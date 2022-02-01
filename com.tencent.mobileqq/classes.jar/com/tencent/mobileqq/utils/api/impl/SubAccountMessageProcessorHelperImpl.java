package com.tencent.mobileqq.utils.api.impl;

import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import PushNotifyPack.RequestPushNotify;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.OnLinePushMessageProcessor;
import com.tencent.mobileqq.apollo.utils.api.IApolloMessageUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PAMessage.Item;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a.ReqBody;

public class SubAccountMessageProcessorHelperImpl
  implements ISubAccountMessageProcessorHelper
{
  public String buildBaseMsg(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    int i = paramMessageRecord.msgtype;
    if (i != -5016)
    {
      if ((i != -5004) && (i != -3006))
      {
        if (i != -2058)
        {
          if (i != -2039)
          {
            if (i != -2011)
            {
              if (i != -2007)
              {
                if (i != -2005)
                {
                  if (i != -2002)
                  {
                    if (i != -2000) {
                      return buildBaseMsgForDefault(paramAppInterface, paramMessageRecord, paramString);
                    }
                    return buildBaseMsgForMediaPic(paramAppInterface, paramMessageRecord, paramString);
                  }
                  return paramAppInterface.getApp().getResources().getString(2131691287);
                }
                return buildBaseMsgForMediaFile(paramAppInterface, paramMessageRecord, paramString);
              }
              return buildBaseMsgForMediaMarkFace(paramAppInterface, paramMessageRecord, paramString);
            }
            return buildBaseMsgForStruct(paramAppInterface, paramMessageRecord, paramString);
          }
          return ((IApolloMessageUtil)QRoute.api(IApolloMessageUtil.class)).getApolloMsgTranDec(paramAppInterface, paramMessageRecord);
        }
        return paramAppInterface.getApp().getResources().getString(2131719234);
      }
      return buildBaseMsgForPublicAccount(paramAppInterface, paramMessageRecord, paramString);
    }
    if ((paramMessageRecord instanceof MessageForArkBabyqReply))
    {
      paramAppInterface = (MessageForArkBabyqReply)paramMessageRecord;
      paramAppInterface.parse();
      paramString = paramAppInterface.babyqReplyText;
    }
    return paramString;
  }
  
  String buildBaseMsgForDefault(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject2;
    try
    {
      boolean bool = ActionMsgUtil.a(paramMessageRecord.msgtype);
      Object localObject1 = "";
      if (bool)
      {
        paramMessageRecord = ActionMsgUtil.a(paramMessageRecord.msg);
        localObject2 = paramString;
        if (paramMessageRecord != null)
        {
          if ((paramMessageRecord.actMsgContentValue != null) && (paramMessageRecord.actMsgContentValue.length() > 0)) {
            return paramMessageRecord.actMsgContentValue;
          }
          paramString = ((MessageCache)paramAppInterface.getMsgCache()).a(AppShareIDUtil.a(paramMessageRecord.shareAppID));
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append(paramAppInterface.getApp().getString(2131690096));
          if (paramString != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(paramString.messagetail);
            ((StringBuilder)localObject1).append(paramAppInterface.getApp().getString(2131690097));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          paramMessageRecord.append((String)localObject1);
          return paramMessageRecord.toString();
        }
      }
      else
      {
        if (ActionMsgUtil.b(paramMessageRecord.msgtype)) {
          return paramString;
        }
        localObject2 = paramString;
        if (paramMessageRecord.msg != null)
        {
          localObject2 = paramString;
          if (paramMessageRecord.msg.indexOf("http://maps.google.com/maps?q=") != -1)
          {
            paramString = MessageUtils.a(paramMessageRecord.msg);
            paramMessageRecord = (MessageRecord)localObject1;
            if (paramString != null)
            {
              paramMessageRecord = (MessageRecord)localObject1;
              if (paramString[2] != null) {
                paramMessageRecord = paramString[2];
              }
            }
            paramString = new StringBuilder();
            paramString.append("[");
            paramString.append(paramAppInterface.getApp().getString(2131719740));
            paramString.append("] ");
            paramString.append(paramMessageRecord);
            paramAppInterface = paramString.toString();
            return paramAppInterface;
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramAppInterface = null;
      paramMessageRecord.printStackTrace();
      localObject2 = paramAppInterface;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = ");
        paramString.append(paramMessageRecord.getMessage());
        QLog.d("SUB_ACCOUNT", 2, paramString.toString());
        localObject2 = paramAppInterface;
      }
    }
    return localObject2;
  }
  
  String buildBaseMsgForMediaFile(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = paramMessageRecord.msg;
    paramString = null;
    paramMessageRecord = paramString;
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split("/");
        paramMessageRecord = paramString;
        if (localObject != null)
        {
          paramMessageRecord = paramString;
          if (localObject.length > 0)
          {
            localObject = localObject[(localObject.length - 1)].split("\\|");
            paramMessageRecord = paramString;
            if (localObject != null)
            {
              paramMessageRecord = paramString;
              if (localObject.length > 0) {
                paramMessageRecord = localObject[0];
              }
            }
          }
        }
      }
    }
    catch (Exception paramMessageRecord)
    {
      paramMessageRecord.printStackTrace();
      paramMessageRecord = paramString;
    }
    if (TextUtils.isEmpty(paramMessageRecord)) {
      return paramAppInterface.getApp().getResources().getString(2131691282);
    }
    if (paramMessageRecord.equalsIgnoreCase(paramAppInterface.getApp().getResources().getString(2131691282))) {
      return paramMessageRecord;
    }
    paramString = new StringBuilder();
    paramString.append(paramAppInterface.getApp().getResources().getString(2131691282));
    paramString.append(paramMessageRecord);
    return paramString.toString();
  }
  
  String buildBaseMsgForMediaMarkFace(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForMarketFace))
    {
      paramMessageRecord = ((MessageForMarketFace)paramMessageRecord).mMarkFaceMessage;
      if ((paramMessageRecord != null) && (!TextUtils.isEmpty(paramMessageRecord.faceName)))
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("[");
        paramAppInterface.append(paramMessageRecord.faceName);
        paramAppInterface.append("]");
        return paramAppInterface.toString();
      }
      return paramAppInterface.getApp().getResources().getString(2131691922);
    }
    return paramAppInterface.getApp().getResources().getString(2131691922);
  }
  
  String buildBaseMsgForMediaPic(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if (((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(paramMessageRecord)) {
      return paramAppInterface.getApp().getResources().getString(2131691283);
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return ((MessageForPic)paramMessageRecord).getSummaryMsg();
    }
    return paramAppInterface.getApp().getResources().getString(2131691286);
  }
  
  String buildBaseMsgForPublicAccount(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    if ((paramMessageRecord instanceof MessageForPubAccount)) {
      try
      {
        paramAppInterface = ((MessageForPubAccount)paramMessageRecord).mPAMessage;
        if (paramAppInterface == null) {
          return null;
        }
        paramMessageRecord = ((PAMessage.Item)paramAppInterface.items.get(0)).title;
        if ((((PAMessage.Item)paramAppInterface.items.get(0)).cover == null) && (((PAMessage.Item)paramAppInterface.items.get(0)).digestList != null))
        {
          paramString = new StringBuilder();
          paramString.append(paramMessageRecord);
          paramString.append("：");
          paramString.append((String)((PAMessage.Item)paramAppInterface.items.get(0)).digestList.get(0));
          paramAppInterface = paramString.toString();
          return paramAppInterface;
        }
        return paramMessageRecord;
      }
      catch (Exception paramAppInterface)
      {
        paramAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = ");
          paramMessageRecord.append(paramAppInterface.getMessage());
          QLog.d("SUB_ACCOUNT", 2, paramMessageRecord.toString());
        }
        paramString = null;
      }
    }
    return paramString;
  }
  
  String buildBaseMsgForStruct(AppInterface paramAppInterface, MessageRecord paramMessageRecord, String paramString)
  {
    String str = paramString;
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      paramMessageRecord = (MessageForStructing)paramMessageRecord;
      str = paramString;
      if (paramMessageRecord.structingMsg != null) {
        str = paramMessageRecord.structingMsg.mMsgBrief;
      }
    }
    paramMessageRecord = str;
    if (TextUtils.isEmpty(str)) {
      paramMessageRecord = paramAppInterface.getApp().getResources().getString(2131719333);
    }
    return paramMessageRecord;
  }
  
  public MessageRecord createMsgRecordByMsgType(int paramInt)
  {
    return MessageRecordFactory.a(paramInt);
  }
  
  public boolean isMessageFuDai(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForFuDai;
  }
  
  public boolean isMessagePubAccount(MessageRecord paramMessageRecord)
  {
    return paramMessageRecord instanceof MessageForPubAccount;
  }
  
  public boolean isRedPacketMsg(MessageRecord paramMessageRecord)
  {
    return MessageForQQWalletMsg.isRedPacketMsg(paramMessageRecord);
  }
  
  public void processSubAccountRevokeNotify(AppInterface paramAppInterface, RequestPushNotify paramRequestPushNotify)
  {
    MsgType0x210 localMsgType0x210 = OnLinePushMessageProcessor.a(paramRequestPushNotify.stMsgInfo.vMsg);
    Submsgtype0x8a.ReqBody localReqBody;
    if (localMsgType0x210 != null)
    {
      if (localMsgType0x210.vProtobuf == null) {
        return;
      }
      if ((localMsgType0x210.uSubMsgType == 138L) || (localMsgType0x210.uSubMsgType == 139L)) {
        localReqBody = new Submsgtype0x8a.ReqBody();
      }
    }
    try
    {
      localReqBody.mergeFrom(localMsgType0x210.vProtobuf);
      MsgType0x210Decoder.a((QQAppInterface)paramAppInterface, localReqBody, paramRequestPushNotify.lBindedUin, true);
      return;
    }
    catch (Exception paramAppInterface)
    {
      label79:
      break label79;
    }
    if (QLog.isColorLevel()) {
      QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b sub account msg, prase reqBody error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.utils.api.impl.SubAccountMessageProcessorHelperImpl
 * JD-Core Version:    0.7.0.1
 */