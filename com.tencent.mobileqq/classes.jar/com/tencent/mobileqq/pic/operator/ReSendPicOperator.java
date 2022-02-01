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
    if (paramPicUploadInfo.a != null) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        paramMessageForPic.msgseq = paramPicUploadInfo.a.a;
        paramMessageForPic.shmsgseq = paramPicUploadInfo.a.b;
        paramMessageForPic.msgUid = paramPicUploadInfo.a.c;
      }
      Logger.a(this.b, this.a, "packMsg", "retry:" + bool + " info.DLSendKey:" + paramPicUploadInfo.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.ReSendPicOperator
 * JD-Core Version:    0.7.0.1
 */