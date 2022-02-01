package com.tencent.mobileqq.service.message.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.QMessageProtoCodec.EncodeRichTextFromStringMsgOne;

@QAPI(process={"all"})
public abstract interface IQMessageProtoCodecService
  extends QRouteApi
{
  public abstract boolean needProcessEmotion(String paramString, int paramInt);
  
  public abstract void processEmotion(QMessageProtoCodec.EncodeRichTextFromStringMsgOne paramEncodeRichTextFromStringMsgOne);
  
  public abstract void recordCookie(AppInterface paramAppInterface, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService
 * JD-Core Version:    0.7.0.1
 */