package com.tencent.mobileqq.structmsg.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tencent.im.msg.im_msg_body.RichText;

@QAPI(process={"all"})
public abstract interface IMsgStructing
  extends QRouteApi
{
  public abstract void consumeStructMsgPicPre(MessageRecord paramMessageRecord);
  
  public abstract MessageForPic getMessageForPic(MessageRecord paramMessageRecord);
  
  public abstract boolean isMessageForStructing(MessageRecord paramMessageRecord);
  
  public abstract void updateMsgAfterDownload(AppInterface paramAppInterface, MessageRecord paramMessageRecord, MessageForPic paramMessageForPic);
  
  public abstract void updateMsgAfterUpload(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, long paramLong, Long paramLong1, String paramString3, int paramInt);
  
  public abstract void uploadPicConstructRichText(MessageRecord paramMessageRecord, String paramString1, String paramString2, long paramLong, Long paramLong1, im_msg_body.RichText paramRichText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.api.IMsgStructing
 * JD-Core Version:    0.7.0.1
 */