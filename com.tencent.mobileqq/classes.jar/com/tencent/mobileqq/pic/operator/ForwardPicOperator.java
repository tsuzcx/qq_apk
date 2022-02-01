package com.tencent.mobileqq.pic.operator;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IForwardOrderManager;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import tencent.im.msg.im_msg_body.RichText;

public class ForwardPicOperator
  extends BaseForwardPicOperator
  implements DownCallBack, UpCallBack, IPicInfoBuilder.ForwardInfoBuilder
{
  private void a(PicReq paramPicReq, long paramLong)
  {
    long l;
    if (paramPicReq.l != null) {
      l = paramPicReq.l.uniseq;
    } else {
      l = 0L;
    }
    Integer localInteger2 = Integer.valueOf(-1);
    Integer localInteger1;
    if (paramPicReq.l != null)
    {
      Map localMap = paramPicReq.l.forwardId;
      localInteger1 = localInteger2;
      if (localMap != null)
      {
        localInteger1 = localInteger2;
        if (localMap.size() > 0) {
          localInteger1 = (Integer)localMap.remove(paramPicReq);
        }
      }
    }
    else
    {
      localInteger1 = Integer.valueOf(paramPicReq.m);
    }
    if ((localInteger1 != null) && (localInteger1.intValue() > 0)) {
      ((IForwardOrderManager)QRoute.api(IForwardOrderManager.class)).mapUniSeqId(paramLong, l, localInteger1.intValue());
    }
  }
  
  private boolean b(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      String str1 = this.b;
      String str2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramPicFowardInfo);
      Logger.a(str1, str2, "checkFowardPicInfo", localStringBuilder.toString());
      return paramPicFowardInfo.b();
    }
    Logger.b(this.b, this.a, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void c(PicReq paramPicReq)
  {
    ThreadManager.post(new ForwardPicOperator.1(this, paramPicReq.h, paramPicReq), 8, null, true);
  }
  
  private void d(PicReq paramPicReq)
  {
    ThreadManager.post(new ForwardPicOperator.2(this, paramPicReq), 8, null, true);
  }
  
  private void e(PicReq paramPicReq)
  {
    paramPicReq = a(paramPicReq);
    if ((paramPicReq instanceof DownloadPicOperator))
    {
      paramPicReq = (DownloadPicOperator)paramPicReq;
      paramPicReq.h = this;
      paramPicReq.i = this.i;
      paramPicReq.a();
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.b, this.a, "attachRichText2Msg", "");
    if ((this.i != null) && ((this.i instanceof MessageForRichText))) {
      ((MessageForRichText)this.i).richText = paramRichText;
    }
    return this.i;
  }
  
  public PicFowardInfo a(Intent paramIntent)
  {
    String str1;
    Object localObject1;
    String str2;
    String str3;
    int j;
    String str4;
    long l1;
    int k;
    String str5;
    int m;
    long l2;
    PicFowardInfo localPicFowardInfo;
    if ((paramIntent != null) && ((paramIntent instanceof Intent)))
    {
      str1 = paramIntent.getStringExtra("forward_filepath");
      localObject1 = paramIntent.getStringExtra("FORWARD_URL_KEY");
      int i = paramIntent.getIntExtra("FORWARD_UIN_TYPE", -1);
      String str6 = paramIntent.getStringExtra("SENDER_TROOP_UIN");
      String str7 = paramIntent.getStringExtra("FORWARD_PEER_UIN");
      str2 = paramIntent.getStringExtra("FORWARD_SELF_UIN");
      Object localObject2 = paramIntent.getStringExtra("forward_urldrawable_thumb_url");
      str3 = paramIntent.getStringExtra("forward_download_image_org_uin");
      j = paramIntent.getIntExtra("forward_download_image_org_uin_type", -1);
      str4 = paramIntent.getStringExtra("forward_download_image_server_path");
      l1 = paramIntent.getLongExtra("forward_download_image_item_id", 0L);
      k = paramIntent.getIntExtra("FORWARD_PHOTO_FILE_SIZE_FLAG", 0);
      str5 = paramIntent.getStringExtra("forward_photo_md5");
      m = paramIntent.getIntExtra("forward_photo_isSend", -1);
      l2 = paramIntent.getLongExtra("forward_photo_group_fileid", 0L);
      long l3 = paramIntent.getLongExtra("forward_image_width", 0L);
      long l4 = paramIntent.getLongExtra("forward_image_height", 0L);
      long l5 = paramIntent.getLongExtra("forward_file_size", 0L);
      int n = paramIntent.getIntExtra("forward_image_type", 0);
      int i1 = paramIntent.getIntExtra("forward_photo_imagebiz_type", -1);
      localPicFowardInfo = new PicFowardInfo();
      paramIntent = new PicUploadInfo.Builder();
      paramIntent.d(1009);
      paramIntent.a(str1);
      paramIntent.c(str2);
      paramIntent.c(10);
      paramIntent.g((int)l3);
      paramIntent.h((int)l4);
      String str8 = this.b;
      String str9 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("image_width = ");
      localStringBuilder.append(l3);
      localStringBuilder.append(",image_height = ");
      localStringBuilder.append(l4);
      Logger.a(str8, str9, "createForwardPicInfo(Intent obj)", localStringBuilder.toString());
      paramIntent.a((int)l5);
      paramIntent.i(k);
      paramIntent.j(n);
      localObject2 = AbsDownloader.getFile((String)localObject2);
      if (localObject2 != null) {
        paramIntent.b(((File)localObject2).getAbsolutePath());
      }
      paramIntent.e(i);
      paramIntent.e(str6);
      paramIntent.d(str7);
      paramIntent.f(str5);
      paramIntent.b(l1);
      paramIntent.m(i1);
      localPicFowardInfo.b = paramIntent.k();
      localPicFowardInfo.b.a = ((String)localObject1);
      if (k == 1) {
        localPicFowardInfo.b.l = "chatraw";
      } else {
        localPicFowardInfo.b.l = "chatimg";
      }
      paramIntent = localPicFowardInfo.b;
      if (PicBusUtil.a(str1)) {
        LogTag.a();
      }
    }
    try
    {
      paramIntent.r = PicBusUtil.b(str1);
    }
    catch (OutOfMemoryError paramIntent)
    {
      label458:
      break label458;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
      paramIntent = str1;
      ((StringBuilder)localObject1).append(paramIntent);
      ((StringBuilder)localObject1).append("'s size is ");
      ((StringBuilder)localObject1).append(FileUtils.getFileSizes(paramIntent));
      QLog.w("peak_pgjpeg", 2, ((StringBuilder)localObject1).toString());
    }
    paramIntent = new StringBuilder();
    paramIntent.append("PeakUtils.getSliceInfos(");
    paramIntent.append(str1);
    paramIntent.append(")");
    LogTag.a("peak_pgjpeg", paramIntent.toString());
    if (!FileUtils.fileExistsAndNotEmpty(str1))
    {
      paramIntent = new PicDownloadInfo.Builder();
      paramIntent.a(1009);
      paramIntent.a(str2);
      paramIntent.b(str3);
      paramIntent.b(j);
      paramIntent.c(str4);
      paramIntent.a(l1);
      paramIntent.d(str5);
      paramIntent.c(m);
      localPicFowardInfo.c = paramIntent.h();
      localPicFowardInfo.c.l = "chatimg";
      localPicFowardInfo.c.t = k;
      localPicFowardInfo.c.o = l2;
    }
    Logger.a(this.b, this.a, "createForwardPicInfo", "");
    return localPicFowardInfo;
    Logger.a(this.b, this.a, "createForwardPicInfo", "unknow obj");
    return null;
  }
  
  public void a()
  {
    b(this.c);
  }
  
  public void a(int paramInt, boolean paramBoolean) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if ((this.c != null) && (this.c.a == 3))
    {
      if (paramDownResult.a == 0)
      {
        this.c.h.b.n = paramDownResult.e;
        Logger.a(this.b, this.a, "onDownload", "dowanload pic success,is to forward the pic");
        d(this.c);
        return;
      }
      a(4, this.c.h.H);
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      Object localObject = this.b;
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resut:");
      localStringBuilder.append(paramSendResult);
      Logger.a((String)localObject, str, "updateMsg", localStringBuilder.toString());
      localObject = (MessageForPic)this.i;
      ((MessageForPic)localObject).size = paramSendResult.e;
      ((MessageForPic)localObject).uuid = paramSendResult.f;
      ((MessageForPic)localObject).groupFileID = paramSendResult.h;
      ((MessageForPic)localObject).md5 = paramSendResult.g;
      ((MessageForPic)localObject).serial();
      ((IMessageFacade)this.e.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(this.i.frienduin, this.i.istroop, this.i.uniseq, ((MessageForPic)localObject).msgData);
    }
  }
  
  public void b(PicReq paramPicReq)
  {
    PicFowardInfo localPicFowardInfo = paramPicReq.h;
    if (!b(localPicFowardInfo))
    {
      a(4, localPicFowardInfo.H);
      return;
    }
    if (FileUtils.fileExistsAndNotEmpty(localPicFowardInfo.b.n))
    {
      localPicFowardInfo.a = true;
      this.i = a(localPicFowardInfo);
      d(paramPicReq);
      return;
    }
    if (localPicFowardInfo.b.d())
    {
      File localFile = localPicFowardInfo.b.e();
      if (localFile != null) {
        localPicFowardInfo.b.n = localFile.toString();
      }
      localPicFowardInfo.a = true;
      this.i = a(localPicFowardInfo);
      d(paramPicReq);
      return;
    }
    localPicFowardInfo.a = true;
    this.i = a(localPicFowardInfo);
    if ((localPicFowardInfo.b.m != null) && (localPicFowardInfo.b.E != 0L) && (localPicFowardInfo.b.C != 0) && (localPicFowardInfo.b.D != 0))
    {
      c(paramPicReq);
      return;
    }
    localPicFowardInfo.c.b = 3;
    localPicFowardInfo.c.l = "chatimg";
    int i;
    if (localPicFowardInfo.b.F == 1) {
      i = 7;
    } else {
      i = 6;
    }
    paramPicReq = PicBusiManager.a(i, 3);
    paramPicReq.a((MessageForPic)this.i, localPicFowardInfo.c);
    e(paramPicReq);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null)
    {
      a(3, null);
      return;
    }
    if ((this.c != null) && (this.c.a == 3))
    {
      if (paramSendResult.a == 0)
      {
        a(paramSendResult);
        localObject = ((PicPreDownloadImpl)this.e.getRuntimeService(IPicPreDownload.class, "")).picStatisticsManager;
        if (localObject != null) {
          ((PicStatisticsManager)localObject).a(13058, paramSendResult.e);
        }
        localObject = new PicResult();
        ((PicResult)localObject).a = 0;
        ((PicResult)localObject).d = paramSendResult;
        a(4, (PicResult)localObject);
        return;
      }
      if (paramSendResult.b == 9333)
      {
        this.c.h.c.b = 3;
        this.c.h.c.l = "chatimg";
        int i;
        if (this.c.h.b.F == 1) {
          i = 7;
        } else {
          i = 6;
        }
        Logger.a(this.b, this.a, "onSend", "fastForward md5 missed,is to Download the pic");
        ((IMessageFacade)this.e.getRuntimeService(IMessageFacade.class, "")).removeMsgByMessageRecord(this.i, false);
        paramSendResult = PicBusiManager.a(i, 3);
        this.i = a(this.c.h);
        paramSendResult.a((MessageForPic)this.i, this.c.h.c);
        e(paramSendResult);
        return;
      }
      Object localObject = new PicInfoInterface.ErrInfo();
      ((PicInfoInterface.ErrInfo)localObject).b = paramSendResult.c;
      ((PicInfoInterface.ErrInfo)localObject).a = String.valueOf(paramSendResult.b);
      a(4, (PicInfoInterface.ErrInfo)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ForwardPicOperator
 * JD-Core Version:    0.7.0.1
 */