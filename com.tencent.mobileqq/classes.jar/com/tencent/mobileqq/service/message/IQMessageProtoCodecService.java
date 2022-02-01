package com.tencent.mobileqq.service.message;

import com.tencent.common.app.AppInterface;

public abstract interface IQMessageProtoCodecService
{
  public abstract void a(AppInterface paramAppInterface, byte[] paramArrayOfByte);
  
  public abstract void a(QMessageProtoCodec.EncodeRichTextFromStringMsgOne paramEncodeRichTextFromStringMsgOne);
  
  public abstract boolean a(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.IQMessageProtoCodecService
 * JD-Core Version:    0.7.0.1
 */