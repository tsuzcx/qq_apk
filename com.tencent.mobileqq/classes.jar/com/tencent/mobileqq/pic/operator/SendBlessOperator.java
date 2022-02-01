package com.tencent.mobileqq.pic.operator;

import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.PicUploadInfo;

public class SendBlessOperator
  extends UploadPicOperator
{
  protected void a(MessageForPic paramMessageForPic, PicUploadInfo paramPicUploadInfo)
  {
    super.a(paramMessageForPic, paramPicUploadInfo);
    paramMessageForPic.isBlessPic = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.SendBlessOperator
 * JD-Core Version:    0.7.0.1
 */