package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.RetryInfo;

public class ReSendPicOperator
  extends UploadPicOperator
{
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    super.a(paramMessageForPic, paramPicUploadInfo);
    boolean bool;
    if (paramPicUploadInfo.ad != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramMessageForPic.msgseq = paramPicUploadInfo.ad.a;
      paramMessageForPic.shmsgseq = paramPicUploadInfo.ad.b;
      paramMessageForPic.msgUid = paramPicUploadInfo.ad.c;
    }
    paramMessageForPic = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retry:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" info.DLSendKey:");
    localStringBuilder.append(paramPicUploadInfo.u);
    Logger.a(paramMessageForPic, str, "packMsg", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ReSendPicOperator
 * JD-Core Version:    0.7.0.1
 */