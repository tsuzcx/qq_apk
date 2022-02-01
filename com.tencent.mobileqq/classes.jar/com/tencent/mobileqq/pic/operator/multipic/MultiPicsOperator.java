package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.operator.BaseForwardPicOperator;
import com.tencent.mobileqq.pic.operator.IPicInfoBuilder.MixedPicMsgInfoBuilder;
import com.tencent.mobileqq.pic.operator.IPicInfoBuilder.MultiPicsInfoBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiPicsOperator
  extends BaseForwardPicOperator
  implements IPicInfoBuilder.MixedPicMsgInfoBuilder, IPicInfoBuilder.MultiPicsInfoBuilder
{
  protected static int l = 20;
  public ArrayList<PicResult> h;
  protected ArrayList<PicFowardInfo> j;
  protected int k;
  
  public PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    long l1;
    Object localObject2;
    if ((paramMessageForPic != null) && (paramInt >= 0) && (paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return null;
      }
      l1 = System.currentTimeMillis();
      int i;
      if ((!ActionMsgUtil.a(paramMessageForPic.msgtype)) && (paramMessageForPic.msgtype != -3001) && (paramMessageForPic.msgtype != -30002) && (paramMessageForPic.msgtype != -30003)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        i = 65537;
      } else {
        i = 1;
      }
      localObject2 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramMessageForPic, i, null);
      if (localObject2 != null) {
        localObject1 = ((URL)localObject2).toString();
      }
      localObject2 = new PicFowardInfo();
      ((PicFowardInfo)localObject2).d = paramMessageForPic.isSendFromLocal();
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(1009);
      localBuilder.a(paramMessageForPic.path);
      localBuilder.c(paramString3);
      localBuilder.c(10);
      localBuilder.g((int)paramMessageForPic.width);
      localBuilder.h((int)paramMessageForPic.height);
      String str1 = this.b;
      String str2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("picMsg.width = ");
      localStringBuilder.append(paramMessageForPic.width);
      localStringBuilder.append(",picMsg.height = ");
      localStringBuilder.append(paramMessageForPic.height);
      Logger.a(str1, str2, "createForwardPicInfo", localStringBuilder.toString());
      localBuilder.a((int)paramMessageForPic.size);
      localBuilder.i(paramMessageForPic.fileSizeFlag);
      localBuilder.a(paramMessageForPic.thumbWidth);
      localBuilder.b(paramMessageForPic.thumbHeight);
      localBuilder.j(paramMessageForPic.imageType);
      localObject1 = AbsDownloader.getFile((String)localObject1);
      if (localObject1 != null) {
        localBuilder.b(((File)localObject1).getAbsolutePath());
      }
      localBuilder.e(paramInt);
      localBuilder.e(paramString1);
      localBuilder.d(paramString2);
      localBuilder.f(paramMessageForPic.md5);
      ((PicFowardInfo)localObject2).b = localBuilder.k();
      ((PicFowardInfo)localObject2).b.a = paramMessageForPic.localUUID;
      ((PicFowardInfo)localObject2).b.l = "chatimg";
      paramString1 = ((PicFowardInfo)localObject2).b;
      if ((paramString1.t < 0) && (PicBusUtil.a(paramMessageForPic.path))) {
        LogTag.a();
      }
    }
    try
    {
      paramString1.r = PicBusUtil.b(paramMessageForPic.path);
    }
    catch (OutOfMemoryError paramString1)
    {
      label448:
      boolean bool;
      break label448;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
      paramString1.append(paramMessageForPic.path);
      paramString1.append("'s size is ");
      paramString1.append(FileUtils.getFileSizes(paramMessageForPic.path));
      QLog.w("peak_pgjpeg", 2, paramString1.toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append("PeakUtils.getSliceInfos(");
    paramString1.append(paramMessageForPic.path);
    paramString1.append(")");
    LogTag.a("peak_pgjpeg", paramString1.toString());
    if ((paramMessageForPic.isMultiMsg) || (!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)))
    {
      paramString1 = new PicDownloadInfo.Builder();
      paramString1.a(1009);
      paramString1.a(paramString3);
      paramString1.b(paramMessageForPic.frienduin);
      paramString1.b(paramMessageForPic.istroop);
      paramString1.c(paramMessageForPic.uuid);
      paramString1.a(paramMessageForPic.uniseq);
      paramString1.d(paramMessageForPic.md5);
      paramString1.c(paramMessageForPic.issend);
      paramString1.b(paramMessageForPic.time);
      ((PicFowardInfo)localObject2).c = paramString1.h();
      ((PicFowardInfo)localObject2).c.l = "chatimg";
      ((PicFowardInfo)localObject2).c.t = paramMessageForPic.fileSizeFlag;
      ((PicFowardInfo)localObject2).c.o = paramMessageForPic.groupFileID;
    }
    paramMessageForPic = this.b;
    paramString1 = this.a;
    paramString2 = new StringBuilder();
    paramString2.append("cost:");
    paramString2.append(System.currentTimeMillis() - l1);
    Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", paramString2.toString());
    paramMessageForPic = this.b;
    paramString1 = this.a;
    paramString2 = new StringBuilder();
    paramString2.append("retry:");
    if (((PicFowardInfo)localObject2).b.ad != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramString2.append(bool);
    Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", paramString2.toString());
    return localObject2;
    return null;
  }
  
  public ArrayList<PicFowardInfo> a(MessageRecord paramMessageRecord, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageRecord != null) && (paramInt >= 0) && (paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return null;
      }
      Object localObject = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(paramMessageRecord);
      if (localObject == null) {
        return null;
      }
      long l1 = System.currentTimeMillis();
      paramMessageRecord = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord instanceof MessageForPic)) {
          paramMessageRecord.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
        }
      }
      paramString1 = this.b;
      paramString2 = this.a;
      paramString3 = new StringBuilder();
      paramString3.append("cost:");
      paramString3.append(System.currentTimeMillis() - l1);
      Logger.a(paramString1, paramString2, "createForwardPicInfos", paramString3.toString());
      return paramMessageRecord;
    }
    return null;
  }
  
  public void a()
  {
    a(this.c.j);
  }
  
  public void a(ArrayList<PicFowardInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ((PicFowardInfo)paramArrayList.get(0)).a = true;
      this.i = a((PicFowardInfo)paramArrayList.get(0));
      this.h = new ArrayList(paramArrayList.size());
      this.j = paramArrayList;
      this.k = 0;
      System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] start");
      }
      b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
    }
    a(5, -1, null);
  }
  
  public void b()
  {
    if (this.k >= this.j.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiPicsOperator", 2, String.format("createPicsUploadTask total:%d finished and notifyUI", new Object[] { Integer.valueOf(this.j.size()) }));
      }
      a(5, 0, this.h);
      return;
    }
    int i;
    if (this.k + l < this.j.size()) {
      i = this.k + l;
    } else {
      i = this.j.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiPicsOperator", 2, String.format("createPicsUploadTask startIdx:%d, finishIdx:%d", new Object[] { Integer.valueOf(this.k), Integer.valueOf(i) }));
    }
    List localList = this.j.subList(this.k, i);
    this.k = i;
    new MultiPicsOperator.MultiPicsUploadTask(this, this.e, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator
 * JD-Core Version:    0.7.0.1
 */