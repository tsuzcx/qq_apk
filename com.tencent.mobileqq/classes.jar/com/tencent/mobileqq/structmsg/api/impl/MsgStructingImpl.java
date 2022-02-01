package com.tencent.mobileqq.structmsg.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIOGallerySceneWithBusiness;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pic.StructMsgPicPreDelegate;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;

public class MsgStructingImpl
  implements IMsgStructing
{
  public void consumeStructMsgPicPre(MessageRecord paramMessageRecord)
  {
    StructMsgPicPreDelegate.a((MessageForStructing)paramMessageRecord, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public MessageForPic getMessageForPic(MessageRecord paramMessageRecord)
  {
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if ((paramMessageRecord.structingMsg != null) && ((paramMessageRecord.structingMsg instanceof StructMsgForImageShare)))
    {
      paramMessageRecord = ((StructMsgForImageShare)paramMessageRecord.structingMsg).getFirstImageElement();
      if (paramMessageRecord != null)
      {
        paramMessageRecord = paramMessageRecord.aF;
        if (paramMessageRecord != null) {
          return paramMessageRecord;
        }
      }
    }
    return null;
  }
  
  public boolean isMessageForStructing(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForStructing;
  }
  
  public void updateMsgAfterDownload(AppInterface paramAppInterface, MessageRecord paramMessageRecord, MessageForPic paramMessageForPic)
  {
    paramMessageRecord = (MessageForStructing)paramMessageRecord;
    if ((paramMessageRecord.structingMsg instanceof StructMsgForImageShare))
    {
      StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)paramMessageRecord.structingMsg).getFirstImageElement();
      if (localStructMsgItemImage != null)
      {
        localStructMsgItemImage.aF = paramMessageForPic;
        ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramMessageForPic.frienduin, paramMessageForPic.istroop, paramMessageForPic.uniseq, paramMessageRecord.structingMsg.getBytes());
      }
    }
  }
  
  public void updateMsgAfterUpload(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString1, String paramString2, long paramLong, Long paramLong1, String paramString3, int paramInt)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
    {
      StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)localMessageForStructing.structingMsg).getFirstImageElement();
      if (localStructMsgItemImage != null)
      {
        localStructMsgItemImage.aw = paramString1;
        localStructMsgItemImage.av = paramString2;
        localStructMsgItemImage.aC = paramLong;
        if (paramLong1 != null) {
          localStructMsgItemImage.aB = paramLong1.longValue();
        }
        localStructMsgItemImage.aD = paramMessageRecord.time;
        localMessageForStructing.msgData = localMessageForStructing.structingMsg.getBytes();
        ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(paramString3, paramInt, paramMessageRecord.uniseq, localMessageForStructing.msgData);
      }
    }
  }
  
  public void uploadPicConstructRichText(MessageRecord paramMessageRecord, String paramString1, String paramString2, long paramLong, Long paramLong1, im_msg_body.RichText paramRichText)
  {
    MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
    if ((localMessageForStructing.structingMsg != null) && ((localMessageForStructing.structingMsg instanceof StructMsgForImageShare)))
    {
      StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
      StructMsgItemImage localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
      if (localStructMsgItemImage != null)
      {
        localStructMsgItemImage.aw = paramString1;
        localStructMsgItemImage.av = paramString2;
        if (paramLong1 != null) {
          localStructMsgItemImage.aB = paramLong1.longValue();
        }
        localStructMsgItemImage.aD = paramMessageRecord.time;
        localStructMsgItemImage.aC = paramLong;
        if (AIOGallerySceneWithBusiness.b(localStructMsgForImageShare.mMsgActionData))
        {
          paramString1 = localStructMsgItemImage.au;
          localStructMsgItemImage.au = "";
          paramMessageRecord = localMessageForStructing.structingMsg.getXmlBytes();
          localStructMsgItemImage.au = paramString1;
        }
        else
        {
          paramMessageRecord = localMessageForStructing.structingMsg.getXmlBytes();
        }
        if ((!TextUtils.isEmpty(localMessageForStructing.frienduin)) && (paramMessageRecord != null))
        {
          paramString1 = new im_msg_body.RichMsg();
          paramString1.bytes_template_1.set(ByteStringMicro.copyFrom(paramMessageRecord));
          paramMessageRecord = new im_msg_body.Elem();
          paramMessageRecord.rich_msg.set(paramString1);
          paramRichText.elems.add(paramMessageRecord);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.api.impl.MsgStructingImpl
 * JD-Core Version:    0.7.0.1
 */