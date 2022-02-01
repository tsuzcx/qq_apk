package com.tencent.mobileqq.emotionintegrate;

import android.content.Intent;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicDownloadPro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class MsgEmotionDataSource
  extends EmotionDataSource
  implements EmotionDownGIFCallback.UiCallback
{
  public EmotionDataManager a;
  public MessageRecord b;
  public SessionInfo c;
  private long d;
  private boolean e;
  private HashMap<MessageForPic, EmotionDownGIFCallback> f = new HashMap();
  private EmotionDownGIFCallback.UiCallback g;
  private EmotionGallery h;
  
  public MsgEmotionDataSource(Intent paramIntent, MsgEmoticonPreviewData paramMsgEmoticonPreviewData, SessionInfo paramSessionInfo)
  {
    this.a = new EmotionDataManager(paramSessionInfo.b, paramSessionInfo.a);
    this.b = paramMsgEmoticonPreviewData.a;
    this.c = paramSessionInfo;
    this.d = paramIntent.getLongExtra("key_multi_forward_seq", 0L);
    this.e = paramIntent.getBooleanExtra("key_is_multi_forward_msg", false);
  }
  
  private IPicTransFile.IPicDownloadPro a(MessageForPic paramMessageForPic)
  {
    QQAppInterface localQQAppInterface = d();
    if (localQQAppInterface != null)
    {
      PicDownloadInfo localPicDownloadInfo = new PicDownloadInfo();
      localPicDownloadInfo.t = paramMessageForPic.fileSizeFlag;
      int i = localPicDownloadInfo.t;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      i = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType("chatimg", bool);
      paramMessageForPic = ((ITransFileController)localQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, i));
      if ((paramMessageForPic != null) && ((paramMessageForPic instanceof IPicTransFile.IPicDownloadPro))) {
        return (IPicTransFile.IPicDownloadPro)paramMessageForPic;
      }
    }
    return null;
  }
  
  public List<EmoticonPreviewData> a(boolean paramBoolean)
  {
    Object localObject2 = new ArrayList();
    boolean bool;
    label175:
    do
    {
      localObject1 = this.b;
      long l;
      if ((localObject1 != null) && (((MessageRecord)localObject1).isMultiMsg)) {
        l = this.b.msgseq;
      } else {
        l = -1L;
      }
      List localList = this.a.a(this.c.b, this.c.a, paramBoolean, l);
      Object localObject3;
      if (localList != null)
      {
        localObject1 = localList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (MessageRecord)((Iterator)localObject1).next();
          if ((localObject3 != null) && (this.b != null) && (((MessageRecord)localObject3).time == this.b.time) && (((((MessageRecord)localObject3).msgtype != 1) && (((MessageRecord)localObject3).msgtype != 3000)) || (((MessageRecord)localObject3).shmsgseq == this.b.shmsgseq)))
          {
            bool = true;
            break label175;
          }
        }
      }
      bool = false;
      if (localList != null) {
        ((List)localObject2).addAll(0, localList);
      }
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getEmotionDataIncremental tempList size:");
        if (localList == null) {
          localObject1 = "null";
        } else {
          localObject1 = Integer.valueOf(localList.size());
        }
        ((StringBuilder)localObject3).append(localObject1);
        ((StringBuilder)localObject3).append(" contains:");
        ((StringBuilder)localObject3).append(bool);
        QLog.d("MsgEmotionFragmentDataSource", 2, ((StringBuilder)localObject3).toString());
      }
      if ((this.b == null) || (localList == null) || (localList.isEmpty())) {
        break;
      }
    } while (!bool);
    break label312;
    QLog.d("MsgEmotionFragmentDataSource", 1, "mCurMsgRecord or tempList is null or empty");
    label312:
    Object localObject1 = new ArrayList();
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add(new MsgEmoticonPreviewData((MessageRecord)((Iterator)localObject2).next()));
    }
    return localObject1;
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    EmoticonPreviewData localEmoticonPreviewData = (EmoticonPreviewData)this.h.getSelectedItem();
    if (!(localEmoticonPreviewData instanceof MsgEmoticonPreviewData)) {
      return;
    }
    if (((MsgEmoticonPreviewData)localEmoticonPreviewData).a != paramMessageForPic) {
      return;
    }
    this.g.a(paramInt, paramMessageForPic);
  }
  
  public void a(EmotionGallery paramEmotionGallery, Handler paramHandler, EmoticonPreviewData paramEmoticonPreviewData, EmotionDownGIFCallback.UiCallback paramUiCallback)
  {
    if (!(paramEmoticonPreviewData instanceof MsgEmoticonPreviewData)) {
      return;
    }
    paramEmoticonPreviewData = (MsgEmoticonPreviewData)paramEmoticonPreviewData;
    if (!(paramEmoticonPreviewData.a instanceof MessageForPic)) {
      return;
    }
    this.g = paramUiCallback;
    this.h = paramEmotionGallery;
    paramEmotionGallery = (MessageForPic)paramEmoticonPreviewData.a;
    if (QLog.isColorLevel())
    {
      paramEmoticonPreviewData = new StringBuilder();
      paramEmoticonPreviewData.append("triggerDownloadPic, mr uniseq: ");
      paramEmoticonPreviewData.append(paramEmotionGallery.uniseq);
      QLog.d("MsgEmotionFragmentDataSource", 2, paramEmoticonPreviewData.toString());
    }
    paramHandler = new EmotionDownGIFCallback(paramEmotionGallery, paramHandler, this);
    if (!this.f.containsKey(paramEmotionGallery)) {
      this.f.put(paramEmotionGallery, paramHandler);
    }
    paramEmoticonPreviewData = a(paramEmotionGallery);
    if (paramEmoticonPreviewData != null)
    {
      paramEmoticonPreviewData.addDownCallback(paramHandler);
    }
    else
    {
      paramEmoticonPreviewData = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(6, 1536, 1);
      paramEmoticonPreviewData.a(paramEmotionGallery, paramEmotionGallery.getPicDownloadInfo());
      paramEmoticonPreviewData.a(paramHandler);
      if (d() != null) {
        ((IPicBus)QRoute.api(IPicBus.class)).launch(paramEmoticonPreviewData);
      }
    }
    AIOImageProviderService.a(d(), paramEmotionGallery);
  }
  
  public void a(EmotionGallery paramEmotionGallery, EmotionAdapter paramEmotionAdapter, long paramLong, EmotionDataSource.DataLoadListener paramDataLoadListener)
  {
    if ((this.e) && (paramLong == this.d))
    {
      paramDataLoadListener.e();
      return;
    }
    int j = 0;
    paramEmotionAdapter = paramEmotionAdapter.a();
    int i = j;
    Object localObject;
    if (paramEmotionAdapter != null)
    {
      paramEmotionAdapter = paramEmotionAdapter.iterator();
      do
      {
        i = j;
        if (!paramEmotionAdapter.hasNext()) {
          break;
        }
        localObject = (EmoticonPreviewData)paramEmotionAdapter.next();
      } while ((!(localObject instanceof MsgEmoticonPreviewData)) || (((MsgEmoticonPreviewData)localObject).a.uniseq != paramLong));
      i = 1;
    }
    if (i == 0)
    {
      if (QLog.isColorLevel())
      {
        paramEmotionGallery = new StringBuilder();
        paramEmotionGallery.append("onRevokeMsg notContain seq:");
        paramEmotionGallery.append(paramLong);
        QLog.d("MsgEmotionFragmentDataSource", 2, paramEmotionGallery.toString());
      }
      return;
    }
    paramEmotionGallery = (EmoticonPreviewData)paramEmotionGallery.getSelectedItem();
    if (paramEmotionGallery == null) {
      return;
    }
    paramEmotionAdapter = ((MsgEmoticonPreviewData)paramEmotionGallery).a;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRevokeMsg seq:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", selectItem seq:");
      long l;
      if (paramEmotionAdapter != null) {
        l = paramEmotionAdapter.uniseq;
      } else {
        l = 0L;
      }
      ((StringBuilder)localObject).append(l);
      QLog.d("MsgEmotionFragmentDataSource", 2, ((StringBuilder)localObject).toString());
    }
    if (paramEmotionAdapter == null) {
      return;
    }
    if (paramLong == paramEmotionAdapter.uniseq)
    {
      paramDataLoadListener.e();
      return;
    }
    a(paramDataLoadListener, paramEmotionGallery, true);
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    Object localObject1 = (EmotionDownGIFCallback)this.f.remove(paramMessageForPic);
    Object localObject2 = a(paramMessageForPic);
    if (localObject2 != null) {
      ((IPicTransFile.IPicDownloadPro)localObject2).removeDownCallBack((DownCallBack)localObject1);
    }
    localObject1 = (EmoticonPreviewData)this.h.getSelectedItem();
    if (!(localObject1 instanceof MsgEmoticonPreviewData)) {
      return;
    }
    localObject1 = ((MsgEmoticonPreviewData)localObject1).a;
    if ((localObject1 != null) && (paramMessageForPic != null) && (localObject1 != paramMessageForPic))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onUIResult, mr not equal, picMr:");
        ((StringBuilder)localObject2).append(paramMessageForPic.uniseq);
        ((StringBuilder)localObject2).append(" mr:");
        ((StringBuilder)localObject2).append(((MessageRecord)localObject1).uniseq);
        QLog.d("MsgEmotionFragmentDataSource", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    this.g.a(paramBoolean, paramMessageForPic);
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(EmoticonPreviewData paramEmoticonPreviewData)
  {
    if (!(paramEmoticonPreviewData instanceof MsgEmoticonPreviewData)) {
      return true;
    }
    paramEmoticonPreviewData = ((MsgEmoticonPreviewData)paramEmoticonPreviewData).a;
    if ((paramEmoticonPreviewData instanceof MessageForPic))
    {
      paramEmoticonPreviewData = (MessageForPic)paramEmoticonPreviewData;
      File localFile = AbsDownloader.getFile(URLDrawableHelper.getURL(paramEmoticonPreviewData, 1).toString());
      if (localFile == null) {
        return false;
      }
      if ((paramEmoticonPreviewData.fileSizeFlag != 1) && (paramEmoticonPreviewData.mShowLength > 0))
      {
        long l1 = paramEmoticonPreviewData.size;
        if (!paramEmoticonPreviewData.isMixed)
        {
          long l2 = localFile.length();
          if (l2 < l1)
          {
            if (QLog.isColorLevel())
            {
              paramEmoticonPreviewData = new StringBuilder();
              paramEmoticonPreviewData.append("checkMsgPicReady, fileLen:");
              paramEmoticonPreviewData.append(l2);
              paramEmoticonPreviewData.append(" fileLenBySender:");
              paramEmoticonPreviewData.append(l1);
              QLog.i("MsgEmotionFragmentDataSource", 2, paramEmoticonPreviewData.toString());
            }
            return false;
          }
        }
      }
    }
    return true;
  }
  
  public int b()
  {
    return 1;
  }
  
  public void c()
  {
    if (!this.f.isEmpty())
    {
      Iterator localIterator = this.f.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        IPicTransFile.IPicDownloadPro localIPicDownloadPro = a((MessageForPic)localEntry.getKey());
        if (localIPicDownloadPro != null) {
          localIPicDownloadPro.removeDownCallBack((DownCallBack)localEntry.getValue());
        }
      }
    }
    this.f.clear();
  }
  
  protected QQAppInterface d()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.MsgEmotionDataSource
 * JD-Core Version:    0.7.0.1
 */