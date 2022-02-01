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
    if (paramPicUploadInfo.a != null) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramMessageForPic.msgseq = paramPicUploadInfo.a.a;
      paramMessageForPic.shmsgseq = paramPicUploadInfo.a.b;
      paramMessageForPic.msgUid = paramPicUploadInfo.a.c;
    }
    paramMessageForPic = this.b;
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("retry:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" info.DLSendKey:");
    localStringBuilder.append(paramPicUploadInfo.b);
    Logger.a(paramMessageForPic, str, "packMsg", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ReSendPicOperator
 * JD-Core Version:    0.7.0.1
 */