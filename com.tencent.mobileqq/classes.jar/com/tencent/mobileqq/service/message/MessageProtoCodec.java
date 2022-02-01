package com.tencent.mobileqq.service.message;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.HiBoomMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForLimitChatConfirm;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageForPokeEmo;
import com.tencent.mobileqq.data.MessageForQQStoryComment;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShakeWindow;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopStory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ShakeWindowMsg;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.hiboom.hiboom_type.Hiboom_Type;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemVideo;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import msf.msgcomm.msg_comm.Msg;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.hummer.resv.source_msg.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype11;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype14;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype16;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype19;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype2;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype23;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatEnter;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype24.LimitChatExit;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body.AnonymousGroupMsg;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.LightAppElem;
import tencent.im.msg.im_msg_body.MarketFace;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichMsg;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.ShakeWindow;
import tencent.im.msg.im_msg_body.SourceMsg;
import tencent.im.msg.im_msg_body.Text;

public class MessageProtoCodec
{
  public static int a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    return QMessageProtoCodec.a(paramInt, paramQQAppInterface);
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return QMessageProtoCodec.a(paramRichText, paramString, paramArrayList);
  }
  
  protected static long a(msg_comm.Msg paramMsg, long paramLong)
  {
    paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
    while (paramMsg.hasNext()) {
      paramLong = a((im_msg_body.Elem)paramMsg.next(), paramLong);
    }
    return paramLong;
  }
  
  private static long a(im_msg_body.Elem paramElem, long paramLong)
  {
    if ((paramElem.elem_flags2.has()) && (paramElem.elem_flags2.uint32_custom_font.has())) {}
    for (int i = ((im_msg_body.ElemFlags2)paramElem.elem_flags2.get()).uint32_custom_font.get();; i = ((im_msg_body.ElemFlags2)paramElem.elem_flags2.get()).uint32_custom_font.get())
    {
      return i & 0xFFFFFFFF;
      if (!paramElem.secret_file.has()) {
        break;
      }
      paramElem = paramElem.secret_file;
      if ((!paramElem.elem_flags2.has()) || (!paramElem.elem_flags2.uint32_custom_font.has())) {
        break;
      }
    }
    return paramLong;
  }
  
  public static MessageRecord a(List<MessageRecord> paramList, byte[] paramArrayOfByte, MessageInfo paramMessageInfo)
  {
    MixedMsg.Msg localMsg = new MixedMsg.Msg();
    JSONObject localJSONObject = new JSONObject();
    paramList = paramList.iterator();
    int j = 0;
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (MessageRecord)paramList.next();
      MixedMsg.Elem localElem = new MixedMsg.Elem();
      int k;
      if (((MessageRecord)localObject).msgtype == -1000)
      {
        if (TextUtils.isEmpty(((MessageRecord)localObject).msg)) {
          continue;
        }
        localElem.textMsg.set(((MessageRecord)localObject).msg);
        k = j;
        try
        {
          if (((MessageRecord)localObject).atInfoList == null) {
            break label426;
          }
          k = j;
          if (((MessageRecord)localObject).atInfoList.size() <= 0) {
            break label426;
          }
          JSONArray localJSONArray = new JSONArray();
          localObject = ((MessageRecord)localObject).atInfoList.iterator();
          k = 0;
          while (((Iterator)localObject).hasNext())
          {
            localJSONArray.put(k, ((AtTroopMemberInfo)((Iterator)localObject).next()).toJsonObject());
            k += 1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(i);
          localJSONObject.put(((StringBuilder)localObject).toString(), localJSONArray);
          k = 1;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("Q.msg.MessageHandler", 1, "disc mixMsg create atInfos error:", localJSONException);
          k = j;
        }
      }
      else if (((MessageRecord)localObject).msgtype == -2000)
      {
        RichMsg.PicRec localPicRec = new RichMsg.PicRec();
        try
        {
          localPicRec = (RichMsg.PicRec)localPicRec.mergeFrom(((MessageRecord)localObject).msgData);
          localElem.picMsg.set(localPicRec);
          k = j;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          QLog.e("Q.msg.MessageHandler", 1, "mergeMixedMsgContent", localInvalidProtocolBufferMicroException);
          k = j;
        }
      }
      else
      {
        k = j;
        if (((MessageRecord)localObject).msgtype == -1049) {
          try
          {
            MessageForReplyText localMessageForReplyText = (MessageForReplyText)localObject;
            localObject = MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo);
            localElem.sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject));
            k = j;
            if (!TextUtils.isEmpty(localMessageForReplyText.msg))
            {
              localElem.textMsg.set(localMessageForReplyText.msg);
              k = j;
            }
          }
          catch (Exception localException)
          {
            k = j;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.msg.MessageHandler", 2, localException.getMessage());
              k = j;
            }
          }
        }
      }
      label426:
      localMsg.elems.get().add(localElem);
      i += 1;
      j = k;
    }
    paramList = (MessageForMixedMsg)MessageRecordFactory.a(-1035);
    paramList.msgtype = -1035;
    paramList.msgData = localMsg.toByteArray();
    if ((paramMessageInfo != null) && (paramMessageInfo.b == 3000)) {
      paramList.frienduin = paramMessageInfo.a;
    } else if ((paramMessageInfo != null) && (paramMessageInfo.b == 10014)) {
      paramList.istroop = 10014;
    }
    if ((j != 0) && (paramMessageInfo != null)) {
      AtTroopMemberSpan.a(paramMessageInfo.b, localJSONObject.toString(), paramList);
    }
    if (paramArrayOfByte != null) {
      paramList.saveExtInfoToExtStr("sens_msg_ctrl_info", HexUtil.bytes2HexStr(paramArrayOfByte));
    }
    paramList.parse();
    return paramList;
  }
  
  private static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    int j;
    for (int i = 0; i < paramString.length(); i = j + 1)
    {
      if (paramString.charAt(i) == '\024')
      {
        int k = i + 1;
        if (k < paramString.length())
        {
          int m = paramString.charAt(k);
          StringBuilder localStringBuilder2;
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("localeCode value:");
            localStringBuilder2.append(m);
            localStringBuilder2.append(",max len:");
            localStringBuilder2.append(MessageUtils.a.length);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder2.toString());
          }
          j = i;
          if (!QQSysFaceUtil.isValidFaceId(m)) {
            continue;
          }
          j = QQSysFaceUtil.convertToServer(m);
          if (QLog.isColorLevel())
          {
            localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("---faceIndex:");
            localStringBuilder2.append(j);
            QLog.d("Q.msg.MessageHandler", 2, localStringBuilder2.toString());
          }
          localStringBuilder1.append(paramString.charAt(i));
          localStringBuilder1.append((char)(j / 128 + 65));
          localStringBuilder1.append((char)(j % 128 + 65));
          j = k;
          continue;
        }
      }
      localStringBuilder1.append(paramString.charAt(i));
      j = i;
    }
    return localStringBuilder1.toString();
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    return QMessageProtoCodec.a(paramAppInterface, paramInt1, paramString, paramTransMsgContext, paramLong, paramInt2);
  }
  
  public static msg_svc.PbSendMsgReq a(BaseMessageHandler paramBaseMessageHandler, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransMsgContext paramTransMsgContext, long paramLong, int paramInt3)
  {
    return QMessageProtoCodec.a(paramBaseMessageHandler.b(), paramString, paramArrayOfByte, paramInt1, paramInt2, paramTransMsgContext, paramLong, paramInt3);
  }
  
  public static generalflags.ResvAttr a(im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return QMessageProtoCodec.a(paramGeneralFlags);
  }
  
  @Nullable
  public static im_msg_body.GeneralFlags a(msg_comm.Msg paramMsg)
  {
    return QMessageProtoCodec.a(paramMsg);
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForRichText))) {
      return ((MessageForRichText)paramChatMessage).richText;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    if (paramChatMessage == null) {
      return null;
    }
    if (!(paramChatMessage instanceof MessageForArkApp)) {
      return null;
    }
    paramChatMessage = (MessageForArkApp)paramChatMessage;
    Object localObject1;
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramChatMessage != null)
    {
      if (paramChatMessage.ark_app_message == null) {
        return null;
      }
      localObject1 = paramChatMessage.ark_app_message.toPbData();
      if (localObject1 != null)
      {
        if (localObject1.length == 0) {
          return null;
        }
        localObject1 = StructMsgUtils.b((byte[])localObject1);
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return null;
          }
          localByteArrayOutputStream = new ByteArrayOutputStream();
        }
      }
    }
    try
    {
      localByteArrayOutputStream.write(1);
      localByteArrayOutputStream.write((byte[])localObject1);
      if ((!TextUtils.isEmpty(paramChatMessage.resIDForLongMsg)) && (!paramBoolean))
      {
        localObject1 = new im_msg_body.RichText();
        localObject2 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject2).general_flags.long_text_flag.set(1);
        ((im_msg_body.Elem)localObject2).general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(paramChatMessage.resIDForLongMsg));
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
        return localObject1;
      }
      if (paramChatMessage.ark_app_message.containStructMsg != null)
      {
        localObject1 = a(paramChatMessage.ark_app_message.containStructMsg);
      }
      else
      {
        localObject2 = new im_msg_body.RichText();
        if (!TextUtils.isEmpty(paramChatMessage.ark_app_message.compatibleText))
        {
          paramChatMessage = paramChatMessage.ark_app_message.compatibleText;
        }
        else
        {
          paramChatMessage = paramChatMessage.getSummery();
          if ((paramChatMessage != null) && (paramChatMessage.length() != 0)) {
            paramChatMessage = String.format(BaseApplication.getContext().getString(2131891206), new Object[] { paramChatMessage });
          } else {
            paramChatMessage = BaseApplication.getContext().getString(2131891205);
          }
        }
        localObject1 = localObject2;
        if (paramChatMessage != null)
        {
          localObject1 = localObject2;
          if (paramChatMessage.length() > 0)
          {
            localObject1 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8(paramChatMessage));
            paramChatMessage = new im_msg_body.Elem();
            paramChatMessage.text.set((MessageMicro)localObject1);
            ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
            localObject1 = localObject2;
          }
        }
      }
      paramChatMessage = new im_msg_body.LightAppElem();
      paramChatMessage.bytes_data.set(ByteStringMicro.copyFrom(localByteArrayOutputStream.toByteArray()));
      Object localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).light_app.set(paramChatMessage);
      if (localObject1 != null) {
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      }
      return localObject1;
    }
    catch (Exception paramChatMessage) {}
    return null;
    return null;
  }
  
  public static im_msg_body.RichText a(MarkFaceMessage paramMarkFaceMessage, String paramString, boolean paramBoolean)
  {
    Object localObject = new im_msg_body.MarketFace();
    if (paramMarkFaceMessage.sbufID != null) {
      ((im_msg_body.MarketFace)localObject).bytes_face_id.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbufID));
    }
    if ((paramBoolean) && (paramString != null)) {
      ((im_msg_body.MarketFace)localObject).bytes_face_name.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    if (paramMarkFaceMessage.sbfKey != null) {
      ((im_msg_body.MarketFace)localObject).bytes_key.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.sbfKey));
    }
    ((im_msg_body.MarketFace)localObject).uint32_face_info.set(paramMarkFaceMessage.cFaceInfo);
    ((im_msg_body.MarketFace)localObject).uint32_item_type.set(paramMarkFaceMessage.dwMSGItemType);
    ((im_msg_body.MarketFace)localObject).uint32_sub_type.set(paramMarkFaceMessage.cSubType);
    ((im_msg_body.MarketFace)localObject).uint32_tab_id.set(paramMarkFaceMessage.dwTabID);
    ((im_msg_body.MarketFace)localObject).uint32_media_type.set(paramMarkFaceMessage.mediaType);
    ((im_msg_body.MarketFace)localObject).uint32_image_width.set(paramMarkFaceMessage.imageWidth);
    ((im_msg_body.MarketFace)localObject).uint32_image_height.set(paramMarkFaceMessage.imageHeight);
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_mobileparam.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.mobileparam));
    }
    if ((paramMarkFaceMessage.resvAttr != null) && (paramMarkFaceMessage.resvAttr.length > 0)) {
      ((im_msg_body.MarketFace)localObject).bytes_pb_reserve.set(ByteStringMicro.copyFrom(paramMarkFaceMessage.resvAttr));
    }
    if (QLog.isColorLevel())
    {
      paramMarkFaceMessage = new StringBuilder();
      paramMarkFaceMessage.append("encodeMarketFace : mf epid = ");
      paramMarkFaceMessage.append(((im_msg_body.MarketFace)localObject).uint32_tab_id.get());
      paramMarkFaceMessage.append(" csubtype = ");
      paramMarkFaceMessage.append(((im_msg_body.MarketFace)localObject).uint32_sub_type.get());
      paramMarkFaceMessage.append(";mediaType = ");
      paramMarkFaceMessage.append(((im_msg_body.MarketFace)localObject).uint32_media_type.get());
      QLog.d("Q.msg.MessageHandler", 2, paramMarkFaceMessage.toString());
    }
    paramMarkFaceMessage = new im_msg_body.Text();
    if (paramString != null) {
      paramMarkFaceMessage.str.set(ByteStringMicro.copyFromUtf8(paramString));
    }
    paramString = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.market_face.set((MessageMicro)localObject);
    paramString.elems.add(localElem);
    localObject = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject).text.set(paramMarkFaceMessage);
    paramString.elems.add((MessageMicro)localObject);
    return paramString;
  }
  
  public static im_msg_body.RichText a(MessageForAniSticker paramMessageForAniSticker)
  {
    Object localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(37);
    ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(paramMessageForAniSticker.stickerType);
    ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(paramMessageForAniSticker.serializeMsgBody()));
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.common_elem.set((MessageMicro)localObject1);
    Object localObject2 = paramMessageForAniSticker.text.substring(1);
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = HardCodeUtil.a(2131916985);
    }
    localObject2 = ByteStringMicro.copyFrom(String.format(HardCodeUtil.a(2131886650), new Object[] { localObject1 }).getBytes());
    localObject1 = new TextMsgExtPb.ResvAttr();
    ((TextMsgExtPb.ResvAttr)localObject1).wording.set((ByteStringMicro)localObject2);
    localObject2 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject2).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject1).toByteArray()));
    ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFrom(paramMessageForAniSticker.text.getBytes()));
    paramMessageForAniSticker = new im_msg_body.Elem();
    paramMessageForAniSticker.text.set((MessageMicro)localObject2);
    localObject1 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject1).elems.add(localElem);
    ((im_msg_body.RichText)localObject1).elems.add(paramMessageForAniSticker);
    return localObject1;
  }
  
  public static im_msg_body.RichText a(MessageForLongTextMsg paramMessageForLongTextMsg, boolean paramBoolean)
  {
    if (paramMessageForLongTextMsg == null) {
      return null;
    }
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      if (paramMessageForLongTextMsg.structingMsg == null) {
        return null;
      }
      localObject2 = paramMessageForLongTextMsg.structingMsg.getXmlBytes();
      if (localObject2 == null) {
        return null;
      }
      localObject1 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject1).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject2));
      ((im_msg_body.RichMsg)localObject1).uint32_service_id.set(paramMessageForLongTextMsg.structingMsg.mMsgServiceID);
      localObject2 = new im_msg_body.RichText();
      Object localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject3);
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramMessageForLongTextMsg.structingMsg.mCompatibleText))
      {
        localObject1 = new im_msg_body.Elem();
        localObject3 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForLongTextMsg.structingMsg.mCompatibleText.getBytes()));
        ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
        ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
        return localObject2;
      }
    }
    else
    {
      localObject1 = a(paramMessageForLongTextMsg.msg, paramMessageForLongTextMsg.atInfoList);
      paramMessageForLongTextMsg = new im_msg_body.GeneralFlags();
      paramMessageForLongTextMsg.long_text_flag.set(2);
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).general_flags.set(paramMessageForLongTextMsg);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    }
    return localObject1;
  }
  
  public static im_msg_body.RichText a(MessageForMarketFace paramMessageForMarketFace)
  {
    if ((paramMessageForMarketFace != null) && (paramMessageForMarketFace.mMarkFaceMessage != null))
    {
      Object localObject;
      if (TextUtils.isEmpty(paramMessageForMarketFace.mMarkFaceMessage.faceName))
      {
        localObject = HardCodeUtil.a(2131904535);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[");
        ((StringBuilder)localObject).append(paramMessageForMarketFace.mMarkFaceMessage.faceName);
        ((StringBuilder)localObject).append("]");
        localObject = ((StringBuilder)localObject).toString();
      }
      boolean bool = true;
      if (paramMessageForMarketFace.istroop == 3000) {
        bool = false;
      }
      return a(paramMessageForMarketFace.mMarkFaceMessage, (String)localObject, bool);
    }
    return null;
  }
  
  public static im_msg_body.RichText a(MessageForMixedMsg paramMessageForMixedMsg)
  {
    if (paramMessageForMixedMsg == null) {
      return null;
    }
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int k = paramMessageForMixedMsg.msgElemList.size();
    int i = 0;
    while (i < k)
    {
      Object localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(i);
      int j;
      if ((localObject instanceof MessageForText))
      {
        localObject = a((MessageForText)localObject);
        if (localObject == null) {
          return null;
        }
        j = 0;
        while (j < ((im_msg_body.RichText)localObject).elems.size())
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
          j += 1;
        }
      }
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject == null) {
          return null;
        }
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        localObject = a((MessageForReplyText)localObject);
        if (localObject != null)
        {
          j = 0;
          while (j < ((im_msg_body.RichText)localObject).elems.size())
          {
            localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(j));
            j += 1;
          }
        }
      }
      i += 1;
    }
    return localRichText;
  }
  
  public static im_msg_body.RichText a(MessageForQQStoryComment paramMessageForQQStoryComment)
  {
    return a(paramMessageForQQStoryComment.msg, null);
  }
  
  public static im_msg_body.RichText a(MessageForReplyText paramMessageForReplyText)
  {
    Object localObject2 = paramMessageForReplyText.getExtInfoFromExtStr("sens_msg_source_msg_info");
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      try
      {
        String str = HexUtil.bytes2HexStr(MessagePkgUtils.a(paramMessageForReplyText.mSourceMsgInfo));
        localObject2 = str;
        localObject1 = str;
        if (!TextUtils.isEmpty(str))
        {
          localObject2 = str;
          paramMessageForReplyText.saveExtInfoToExtStr("sens_msg_source_msg_info", str);
          localObject1 = str;
        }
      }
      catch (Exception localException)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandler", 2, QLog.getStackTraceString(localException));
          localObject1 = localObject2;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSourceMsgInfo data = ");
      ((StringBuilder)localObject2).append(localObject1);
      ((StringBuilder)localObject2).append(", mSourceMsgInfo = ");
      ((StringBuilder)localObject2).append(paramMessageForReplyText.mSourceMsgInfo);
      QLog.d("Q.msg.", 2, ((StringBuilder)localObject2).toString());
    }
    return a(paramMessageForReplyText);
  }
  
  public static im_msg_body.RichText a(MessageForShakeWindow paramMessageForShakeWindow)
  {
    if ((paramMessageForShakeWindow != null) && (paramMessageForShakeWindow.mShakeWindowMsg != null))
    {
      im_msg_body.RichText localRichText = new im_msg_body.RichText();
      im_msg_body.ShakeWindow localShakeWindow = new im_msg_body.ShakeWindow();
      localShakeWindow.uint32_type.set(paramMessageForShakeWindow.mShakeWindowMsg.mType);
      paramMessageForShakeWindow = new im_msg_body.Elem();
      paramMessageForShakeWindow.shake_window.set(localShakeWindow);
      localRichText.elems.add(paramMessageForShakeWindow);
      return localRichText;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing != null)
    {
      if (paramMessageForStructing.structingMsg == null) {
        return null;
      }
      if (paramMessageForStructing.richText != null) {
        return paramMessageForStructing.richText;
      }
      Object localObject2 = paramMessageForStructing.structingMsg.getXmlBytes();
      if (localObject2 == null) {
        return null;
      }
      if ((paramMessageForStructing.structingMsg.mMsgServiceID != 83) && (paramMessageForStructing.structingMsg.mMsgServiceID != 108) && (paramMessageForStructing.structingMsg.mMsgServiceID != 114) && (paramMessageForStructing.structingMsg.mMsgServiceID != 116) && (paramMessageForStructing.structingMsg.mMsgServiceID != 151))
      {
        localObject1 = localObject2;
        if (paramMessageForStructing.structingMsg.mMsgServiceID != 156) {}
      }
      else
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mMsgActionData))
        {
          localObject2 = paramMessageForStructing.structingMsg.mMsgActionData;
          paramMessageForStructing.structingMsg.mMsgActionData = a(paramMessageForStructing.structingMsg.mMsgActionData);
          localObject1 = paramMessageForStructing.structingMsg.getXmlBytes();
          paramMessageForStructing.structingMsg.mMsgActionData = ((String)localObject2);
        }
      }
      localObject2 = new im_msg_body.RichMsg();
      ((im_msg_body.RichMsg)localObject2).bytes_template_1.set(ByteStringMicro.copyFrom((byte[])localObject1));
      ((im_msg_body.RichMsg)localObject2).uint32_service_id.set(paramMessageForStructing.structingMsg.mMsgServiceID);
      if ((paramMessageForStructing.structingMsg instanceof AbsShareMsg))
      {
        localObject1 = ((AbsShareMsg)paramMessageForStructing.structingMsg).getStructMsgItemLists();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label342;
            }
            localObject3 = (AbsStructMsgElement)((Iterator)localObject1).next();
            if ((localObject3 instanceof AbsStructMsgItem))
            {
              localObject3 = ((AbsStructMsgItem)localObject3).ax;
              if (localObject3 != null)
              {
                localObject3 = ((List)localObject3).iterator();
                if (((Iterator)localObject3).hasNext())
                {
                  AbsStructMsgElement localAbsStructMsgElement = (AbsStructMsgElement)((Iterator)localObject3).next();
                  if (!(localAbsStructMsgElement instanceof StructMsgItemVideo)) {
                    break;
                  }
                  if (((StructMsgItemVideo)localAbsStructMsgElement).c()) {
                    ((im_msg_body.RichMsg)localObject2).uint32_flags.set(4);
                  } else {
                    ((im_msg_body.RichMsg)localObject2).uint32_flags.set(2);
                  }
                }
              }
            }
          }
        }
      }
      label342:
      Object localObject1 = new im_msg_body.RichText();
      Object localObject3 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject3).rich_msg.set((MessageMicro)localObject2);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject3);
      if (TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText)) {
        paramMessageForStructing.structingMsg.mCompatibleText = paramMessageForStructing.structingMsg.mMsgUrl;
      }
      if (!TextUtils.isEmpty(paramMessageForStructing.structingMsg.mCompatibleText))
      {
        localObject2 = new im_msg_body.Elem();
        localObject3 = new im_msg_body.Text();
        ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFrom(paramMessageForStructing.structingMsg.mCompatibleText.getBytes()));
        ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject3);
        ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
      }
      return localObject1;
    }
    return null;
  }
  
  public static im_msg_body.RichText a(MessageForText paramMessageForText)
  {
    return a(paramMessageForText.msg, paramMessageForText.atInfoList);
  }
  
  public static im_msg_body.RichText a(MessageForTroopStory paramMessageForTroopStory)
  {
    Object localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(16);
    Object localObject1 = new hummer_commelem.MsgElemInfo_servtype16();
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).uid.set(paramMessageForTroopStory.uid);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).unionID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.unionId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).storyID.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.storyId));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).md5.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.md5));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).thumbUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.thumbUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).doodleUrl.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.doodleUrl));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoWidth.set(paramMessageForTroopStory.videoWidth);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).videoHeight.set(paramMessageForTroopStory.videoHeight);
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceName.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceName));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionType.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionType));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).sourceActionData.set(ByteStringMicro.copyFromUtf8(paramMessageForTroopStory.sourceActionData));
    ((hummer_commelem.MsgElemInfo_servtype16)localObject1).ctr_version.set(paramMessageForTroopStory.ctrVersion);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype16)localObject1).toByteArray()));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject2);
    localObject2 = paramMessageForTroopStory.compatibleText;
    paramMessageForTroopStory = new im_msg_body.Text();
    paramMessageForTroopStory.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramMessageForTroopStory);
    paramMessageForTroopStory = new im_msg_body.RichText();
    paramMessageForTroopStory.elems.add((MessageMicro)localObject1);
    paramMessageForTroopStory.elems.add((MessageMicro)localObject2);
    return paramMessageForTroopStory;
  }
  
  public static im_msg_body.RichText a(MessageRecord paramMessageRecord)
  {
    Object localObject4 = paramMessageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info");
    if (paramMessageRecord.msg == null) {
      localObject1 = "";
    } else {
      localObject1 = paramMessageRecord.msg;
    }
    ArrayList localArrayList2 = paramMessageRecord.atInfoList;
    Object localObject3 = paramMessageRecord.getExtInfoFromExtStr("sens_reply_special_msg");
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("sens_reply_special_at_list");
    Object localObject2 = localObject1;
    ArrayList localArrayList1 = localArrayList2;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject2 = localObject1;
      localArrayList1 = localArrayList2;
      if (!TextUtils.isEmpty(paramMessageRecord))
      {
        localArrayList1 = MessageForText.getTroopMemberInfoFromExtrJson(paramMessageRecord);
        localObject2 = localObject3;
      }
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject4);
    Object localObject1 = null;
    localArrayList2 = null;
    paramMessageRecord = (MessageRecord)localObject1;
    if (!bool) {}
    for (;;)
    {
      try
      {
        localObject3 = (MessageForReplyText.SourceMsgInfo)MessagePkgUtils.a(HexUtil.hexStr2Bytes((String)localObject4));
        paramMessageRecord = (MessageRecord)localObject1;
        if (localObject3 == null) {
          break label567;
        }
        localObject4 = new im_msg_body.SourceMsg();
        ((im_msg_body.SourceMsg)localObject4).uint32_orig_seqs.add(Integer.valueOf((int)((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgSeq));
        paramMessageRecord = a(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgText, null);
        ((im_msg_body.SourceMsg)localObject4).elems.set(paramMessageRecord.elems.get());
        if (((MessageForReplyText.SourceMsgInfo)localObject3).getSourceMsg() != null) {
          ((im_msg_body.SourceMsg)localObject4).bytes_src_msg.set(ByteStringMicro.copyFrom(((MessageForReplyText.SourceMsgInfo)localObject3).getSourceMsg()));
        }
        if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject3).mAnonymousNickName))
        {
          paramMessageRecord = new im_msg_body.AnonymousGroupMsg();
          paramMessageRecord.str_anon_nick.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject3).mAnonymousNickName));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).anon_group_msg.set(paramMessageRecord);
          ((im_msg_body.SourceMsg)localObject4).elems.add((MessageMicro)localObject1);
        }
        if (!TextUtils.isEmpty(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgTroopName)) {
          ((im_msg_body.SourceMsg)localObject4).bytes_troop_name.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgTroopName));
        }
        ((im_msg_body.SourceMsg)localObject4).uint64_sender_uin.set(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgSenderUin);
        ((im_msg_body.SourceMsg)localObject4).uint64_to_uin.set(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgToUin);
        ((im_msg_body.SourceMsg)localObject4).uint32_time.set(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceMsgTime);
        ((im_msg_body.SourceMsg)localObject4).uint32_flag.set(((MessageForReplyText.SourceMsgInfo)localObject3).mSourceSummaryFlag);
        ((im_msg_body.SourceMsg)localObject4).uint32_type.set(((MessageForReplyText.SourceMsgInfo)localObject3).mType);
        if (((MessageForReplyText.SourceMsgInfo)localObject3).mRichMsg != null) {
          ((im_msg_body.SourceMsg)localObject4).bytes_richMsg.set(ByteStringMicro.copyFromUtf8(((MessageForReplyText.SourceMsgInfo)localObject3).mRichMsg));
        }
        if (((MessageForReplyText.SourceMsgInfo)localObject3).oriMsgType == 0) {
          break label582;
        }
        paramMessageRecord = new source_msg.ResvAttr();
        paramMessageRecord.uint32_ori_msgtype.set(((MessageForReplyText.SourceMsgInfo)localObject3).oriMsgType);
        localObject1 = paramMessageRecord;
        if (((MessageForReplyText.SourceMsgInfo)localObject3).origUid != 0L)
        {
          localObject1 = paramMessageRecord;
          if (paramMessageRecord == null) {
            localObject1 = new source_msg.ResvAttr();
          }
          ((source_msg.ResvAttr)localObject1).uint64_orig_uids.add(Long.valueOf(((MessageForReplyText.SourceMsgInfo)localObject3).origUid));
        }
        if (localObject1 != null) {
          ((im_msg_body.SourceMsg)localObject4).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((source_msg.ResvAttr)localObject1).toByteArray()));
        }
        paramMessageRecord = new im_msg_body.RichText();
        try
        {
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).src_msg.set((MessageMicro)localObject4);
          paramMessageRecord.elems.add((MessageMicro)localObject1);
          a(paramMessageRecord, localObject2, localArrayList1);
        }
        catch (Exception localException1)
        {
          localObject1 = paramMessageRecord;
        }
        paramMessageRecord = (MessageRecord)localObject1;
      }
      catch (Exception localException2)
      {
        localObject1 = localArrayList2;
      }
      if (QLog.isColorLevel())
      {
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append("getSourceMsgInfo exception:");
        paramMessageRecord.append(localException2.getMessage());
        QLog.d("Q.msg.", 2, paramMessageRecord.toString());
        paramMessageRecord = (MessageRecord)localObject1;
      }
      label567:
      localObject1 = paramMessageRecord;
      if (paramMessageRecord == null) {
        localObject1 = a(localObject2, localArrayList1);
      }
      return localObject1;
      label582:
      paramMessageRecord = null;
    }
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    return QMessageProtoCodec.a(paramString, paramArrayList);
  }
  
  public static void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, AppInterface paramAppInterface)
  {
    QMessageProtoCodec.a(paramAppInterface, paramLong1, paramInt1, paramLong2, paramInt2);
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    QMessageProtoCodec.a(paramAppInterface, paramLong1, paramInt1, paramLong2, paramInt2, paramArrayOfByte);
  }
  
  public static void a(BaseMessageHandler paramBaseMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo)
  {
    a(paramBaseMessageHandler, paramList, paramMsg, paramBoolean1, paramBoolean2, paramMessageInfo, null, null);
  }
  
  public static void a(BaseMessageHandler paramBaseMessageHandler, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    QMessageProtoCodec.a(paramBaseMessageHandler.b(), paramList, paramMsg, paramBoolean1, paramBoolean2, paramMessageInfo, paramTempSessionInfo, paramDecodeProtoPkgContext);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, msg_svc.RoutingHead paramRoutingHead)
  {
    return QMessageProtoCodec.a(paramQQAppInterface, paramMessageRecord, paramRoutingHead);
  }
  
  public static int b(int paramInt, QQAppInterface paramQQAppInterface)
  {
    return QMessageProtoCodec.b(paramInt, paramQQAppInterface);
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    return QMessageProtoCodec.e(paramMsg);
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForLimitChatConfirm)))
    {
      Object localObject1 = (MessageForLimitChatConfirm)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(24);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype24 localMsgElemInfo_servtype24 = new hummer_commelem.MsgElemInfo_servtype24();
      if (((MessageForLimitChatConfirm)localObject1).bEnterMsg)
      {
        localMsgElemInfo_servtype24.limit_chat_enter.bytes_match_nick.set(ByteStringMicro.copyFromUtf8(((MessageForLimitChatConfirm)localObject1).SenderNickName));
        localMsgElemInfo_servtype24.limit_chat_enter.bytes_tips_wording.set(ByteStringMicro.copyFromUtf8(((MessageForLimitChatConfirm)localObject1).tipsWording));
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_left_chat_time.set(((MessageForLimitChatConfirm)localObject1).leftChatTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_c2c_expired_time.set(((MessageForLimitChatConfirm)localObject1).c2cExpiredTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint32_match_expired_time.set(((MessageForLimitChatConfirm)localObject1).matchExpiredTime);
        localMsgElemInfo_servtype24.limit_chat_enter.uint64_match_ts.set(((MessageForLimitChatConfirm)localObject1).timeStamp);
        localMsgElemInfo_servtype24.limit_chat_enter.uint64_ready_ts.set(((MessageForLimitChatConfirm)localObject1).readyTs);
        localMsgElemInfo_servtype24.limit_chat_enter.setHasFlag(true);
      }
      else
      {
        localMsgElemInfo_servtype24.limit_chat_exit.uint32_exit_method.set(((MessageForLimitChatConfirm)localObject1).leaveChatType);
        localMsgElemInfo_servtype24.limit_chat_exit.uint64_match_ts.set(((MessageForLimitChatConfirm)localObject1).timeStamp);
        localMsgElemInfo_servtype24.limit_chat_exit.setHasFlag(true);
      }
      int i;
      if (((MessageForLimitChatConfirm)localObject1).bEnterMsg) {
        i = 1;
      } else {
        i = 2;
      }
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(i, true);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype24.toByteArray()), true);
      paramChatMessage.common_elem.set((MessageMicro)localObject2, true);
      localObject1 = new im_msg_body.Elem();
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131904538)));
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChat", 2, "getSendLimitChatConfirmMsgBody");
      }
      return localObject2;
    }
    return null;
  }
  
  public static im_msg_body.RichText b(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static int c(msg_comm.Msg paramMsg)
  {
    return QMessageProtoCodec.d(paramMsg);
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return null;
    }
    if (!(paramChatMessage instanceof MessageForArkFlashChat)) {
      return null;
    }
    paramChatMessage = (MessageForArkFlashChat)paramChatMessage;
    Object localObject1;
    Object localObject2;
    if (paramChatMessage != null)
    {
      if (paramChatMessage.ark_app_message == null) {
        return null;
      }
      localObject1 = paramChatMessage.ark_app_message.toPbData();
      if (localObject1 != null)
      {
        if (localObject1.length == 0) {
          return null;
        }
        localObject2 = StructMsgUtils.b((byte[])localObject1);
        if (localObject2 != null)
        {
          if (localObject2.length == 0) {
            return null;
          }
          localObject1 = new ByteArrayOutputStream();
        }
      }
    }
    try
    {
      ((ByteArrayOutputStream)localObject1).write(1);
      ((ByteArrayOutputStream)localObject1).write((byte[])localObject2);
      localObject2 = new hummer_commelem.MsgElemInfo_servtype14();
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).reserve_Info.set(ByteStringMicro.copyFrom(((ByteArrayOutputStream)localObject1).toByteArray()));
      ((hummer_commelem.MsgElemInfo_servtype14)localObject2).uint32_id.set(paramChatMessage.ark_app_message.appResId);
      localObject1 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(0);
      ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(14);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype14)localObject2).toByteArray()));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).common_elem.set((MessageMicro)localObject1);
      paramChatMessage = a(MessageUtils.a(paramChatMessage.getSummery(), true, null), null);
      paramChatMessage.elems.add((MessageMicro)localObject2);
      return paramChatMessage;
    }
    catch (Exception paramChatMessage) {}
    return null;
    return null;
  }
  
  public static im_msg_body.RichText c(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    im_msg_body.RichText localRichText = null;
    if (paramChatMessage == null) {
      return null;
    }
    if (!(paramChatMessage instanceof MessageForArkBabyqReply)) {
      return null;
    }
    Object localObject1 = (MessageForArkBabyqReply)paramChatMessage;
    Object localObject2 = ((MessageForArkBabyqReply)localObject1).toPbData();
    paramChatMessage = localRichText;
    int i;
    if (localObject2 != null)
    {
      if (localObject2.length == 0) {
        return null;
      }
      localObject2 = StructMsgUtils.b((byte[])localObject2);
      paramChatMessage = localRichText;
      if (localObject2 != null)
      {
        if (localObject2.length == 0) {
          return null;
        }
        paramChatMessage = new ByteArrayOutputStream();
        i = 1;
      }
    }
    try
    {
      paramChatMessage.write(1);
      paramChatMessage.write((byte[])localObject2);
      localRichText = new im_msg_body.RichText();
      if ((!TextUtils.isEmpty(((MessageForArkBabyqReply)localObject1).resIDForLongMsg)) && (!paramBoolean))
      {
        paramChatMessage = new im_msg_body.Elem();
        paramChatMessage.general_flags.long_text_flag.set(1);
        paramChatMessage.general_flags.long_text_resid.set(ByteStringMicro.copyFromUtf8(((MessageForArkBabyqReply)localObject1).resIDForLongMsg));
        localRichText.elems.add(paramChatMessage);
        return localRichText;
      }
      localObject2 = new hummer_commelem.MsgElemInfo_servtype19();
      ((hummer_commelem.MsgElemInfo_servtype19)localObject2).bytes_data.set(ByteStringMicro.copyFrom(paramChatMessage.toByteArray()));
      paramChatMessage = new im_msg_body.CommonElem();
      paramChatMessage.uint32_service_type.set(19);
      paramChatMessage.bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype19)localObject2).toByteArray()));
      localObject2 = paramChatMessage.uint32_business_type;
      if (!((MessageForArkBabyqReply)localObject1).showAsBabyq) {
        i = 2;
      }
      ((PBUInt32Field)localObject2).set(i);
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).common_elem.set(paramChatMessage);
      localRichText.elems.add((MessageMicro)localObject2);
      localObject1 = ((MessageForArkBabyqReply)localObject1).babyqReplyText;
      paramChatMessage = localRichText;
      if (localObject1 != null)
      {
        paramChatMessage = localRichText;
        if (((String)localObject1).length() > 0)
        {
          paramChatMessage = new im_msg_body.Text();
          paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set(paramChatMessage);
          localRichText.elems.add((MessageMicro)localObject1);
          paramChatMessage = localRichText;
        }
      }
      return paramChatMessage;
    }
    catch (Exception paramChatMessage) {}
    return null;
  }
  
  @Deprecated
  public static int d(msg_comm.Msg paramMsg)
  {
    return QMessageProtoCodec.f(paramMsg);
  }
  
  public static im_msg_body.RichText d(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForHiBoom)) {
      return null;
    }
    paramChatMessage = (MessageForHiBoom)paramChatMessage;
    if (paramChatMessage.mHiBoomMessage == null) {
      return null;
    }
    Object localObject1 = new hummer_commelem.MsgElemInfo_servtype14();
    ((hummer_commelem.MsgElemInfo_servtype14)localObject1).uint32_id.set(paramChatMessage.mHiBoomMessage.id);
    Object localObject2 = new hiboom_type.Hiboom_Type();
    ((hiboom_type.Hiboom_Type)localObject2).uint32_hiboom_type.set(paramChatMessage.mHiBoomMessage.type);
    ((hummer_commelem.MsgElemInfo_servtype14)localObject1).reserve_Info.set(ByteStringMicro.copyFrom(((hiboom_type.Hiboom_Type)localObject2).toByteArray()));
    localObject2 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(1);
    ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(14);
    ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype14)localObject1).toByteArray()));
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    localElem.common_elem.set((MessageMicro)localObject2);
    localObject1 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject1).elems.add(localElem);
    localObject2 = paramChatMessage.mHiBoomMessage.text;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramChatMessage = new im_msg_body.Text();
      paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).text.set(paramChatMessage);
      ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    }
    return localObject1;
  }
  
  public static long e(msg_comm.Msg paramMsg)
  {
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        return -1L;
      }
      long l = a(paramMsg, -1L);
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("decodeC2CMsgPkg_VipFontID: fontid = ");
        paramMsg.append(l);
        QLog.d("Q.msg.MessageHandler", 2, paramMsg.toString());
      }
      return l;
    }
    return -1L;
  }
  
  public static im_msg_body.RichText e(ChatMessage paramChatMessage)
  {
    Object localObject1 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject1).uint32_service_type.set(2);
    if ((paramChatMessage instanceof MessageForPoke))
    {
      localObject2 = new hummer_commelem.MsgElemInfo_servtype2();
      paramChatMessage = (MessageForPoke)paramChatMessage;
      int i = paramChatMessage.interactType;
      int j = paramChatMessage.doubleHitState;
      int k = paramChatMessage.strength;
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_type.set(i);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_double_hit.set(j);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_vaspoke_id.set(paramChatMessage.subId);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_name.set(ByteStringMicro.copyFromUtf8(paramChatMessage.name));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).bytes_vaspoke_minver.set(ByteStringMicro.copyFromUtf8(paramChatMessage.minVersion));
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_strength.set(k);
      ((hummer_commelem.MsgElemInfo_servtype2)localObject2).uint32_poke_flag.set(paramChatMessage.flag);
      ((im_msg_body.CommonElem)localObject1).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype2)localObject2).toByteArray()));
      ((im_msg_body.CommonElem)localObject1).uint32_business_type.set(i);
      if (QLog.isColorLevel())
      {
        paramChatMessage = new StringBuilder();
        paramChatMessage.append("getSendPokeMsgBody type:");
        paramChatMessage.append(i);
        paramChatMessage.append(" ,doubleHitState:");
        paramChatMessage.append(j);
        QLog.d("Q.msg.MessageHandler", 2, paramChatMessage.toString());
      }
    }
    paramChatMessage = new im_msg_body.Elem();
    paramChatMessage.common_elem.set((MessageMicro)localObject1);
    Object localObject2 = HardCodeUtil.a(2131904537);
    localObject1 = new im_msg_body.Text();
    ((im_msg_body.Text)localObject1).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject1);
    localObject1 = new im_msg_body.RichText();
    ((im_msg_body.RichText)localObject1).elems.add(paramChatMessage);
    ((im_msg_body.RichText)localObject1).elems.add((MessageMicro)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
    }
    return localObject1;
  }
  
  public static im_msg_body.RichText f(ChatMessage paramChatMessage)
  {
    Object localObject3 = new im_msg_body.CommonElem();
    ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(23);
    Object localObject1 = HardCodeUtil.a(2131904542);
    boolean bool = paramChatMessage instanceof MessageForPokeEmo;
    Object localObject2 = "";
    if (bool)
    {
      hummer_commelem.MsgElemInfo_servtype23 localMsgElemInfo_servtype23 = new hummer_commelem.MsgElemInfo_servtype23();
      localObject1 = (MessageForPokeEmo)paramChatMessage;
      int i = ((MessageForPokeEmo)localObject1).pokeemoId;
      int j = ((MessageForPokeEmo)localObject1).pokeemoPressCount;
      paramChatMessage = ((MessageForPokeEmo)localObject1).summary;
      if ((i == 13) && (((MessageForPokeEmo)localObject1).emoIndex >= 0))
      {
        localObject4 = new hummer_commelem.MsgElemInfo_servtype33();
        ((hummer_commelem.MsgElemInfo_servtype33)localObject4).uint32_index.set(((MessageForPokeEmo)localObject1).emoIndex);
        paramChatMessage = QQSysFaceUtil.getPrueFaceDescription(QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.convertToLocal(((MessageForPokeEmo)localObject1).emoIndex)));
        if (paramChatMessage == null) {
          localObject1 = "";
        } else {
          localObject1 = paramChatMessage;
        }
        ((hummer_commelem.MsgElemInfo_servtype33)localObject4).bytes_text.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        if (paramChatMessage == null) {
          localObject1 = "";
        } else {
          localObject1 = paramChatMessage;
        }
        ((hummer_commelem.MsgElemInfo_servtype33)localObject4).bytes_compat.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        localMsgElemInfo_servtype23.msg_yellow_face.set((MessageMicro)localObject4);
        localObject1 = String.format("[%s]x%d", new Object[] { paramChatMessage, Integer.valueOf(j) });
      }
      else
      {
        localObject1 = String.format("[%s]x%d", new Object[] { paramChatMessage, Integer.valueOf(j) });
      }
      localMsgElemInfo_servtype23.uint32_face_type.set(i);
      localMsgElemInfo_servtype23.uint32_face_bubble_count.set(j);
      Object localObject4 = localMsgElemInfo_servtype23.bytes_face_summary;
      if (paramChatMessage != null) {
        localObject2 = paramChatMessage;
      }
      ((PBBytesField)localObject4).set(ByteStringMicro.copyFromUtf8((String)localObject2));
      ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype23.toByteArray()));
      ((im_msg_body.CommonElem)localObject3).uint32_business_type.set(i);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getSendPokeEmoMsgBody pokeemoId:");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" ,pokeemoPressCount:");
        ((StringBuilder)localObject2).append(j);
        QLog.d("Q.msg.MessageHandler", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = localObject1;
    }
    else
    {
      paramChatMessage = (ChatMessage)localObject1;
    }
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject3);
    localObject3 = String.format("[%s]请使用最新版手机QQ体验新功能。", new Object[] { paramChatMessage });
    paramChatMessage = new im_msg_body.Text();
    paramChatMessage.str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
    localObject2 = new TextMsgExtPb.ResvAttr();
    ((TextMsgExtPb.ResvAttr)localObject2).wording.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    paramChatMessage.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject2).toByteArray()));
    localObject2 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject2).text.set(paramChatMessage);
    paramChatMessage = new im_msg_body.RichText();
    paramChatMessage.elems.add((MessageMicro)localObject1);
    paramChatMessage.elems.add((MessageMicro)localObject2);
    if (QLog.isColorLevel()) {
      QLog.d("PokeMsg", 2, "getSendPokeMsgBody");
    }
    return paramChatMessage;
  }
  
  public static im_msg_body.RichText g(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage != null) && ((paramChatMessage instanceof MessageForScribble)))
    {
      Object localObject1 = (MessageForScribble)paramChatMessage;
      Object localObject2 = new im_msg_body.CommonElem();
      ((im_msg_body.CommonElem)localObject2).uint32_service_type.set(11);
      paramChatMessage = new im_msg_body.Elem();
      hummer_commelem.MsgElemInfo_servtype11 localMsgElemInfo_servtype11 = new hummer_commelem.MsgElemInfo_servtype11();
      localMsgElemInfo_servtype11.bytes_Doodle_url.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileUrl));
      localMsgElemInfo_servtype11.bytes_Doodle_md5.set(ByteStringMicro.copyFromUtf8(((MessageForScribble)localObject1).combineFileMd5));
      localMsgElemInfo_servtype11.uint32_doodleData_offset.set(((MessageForScribble)localObject1).offSet);
      localMsgElemInfo_servtype11.uint32_doodle_gif_id.set(((MessageForScribble)localObject1).gifId);
      ((im_msg_body.CommonElem)localObject2).uint32_business_type.set(1);
      ((im_msg_body.CommonElem)localObject2).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype11.toByteArray()));
      paramChatMessage.common_elem.set((MessageMicro)localObject2);
      localObject1 = new im_msg_body.Elem();
      localObject2 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject2).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131904534)));
      ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject2);
      ((im_msg_body.Elem)localObject1).text.setHasFlag(true);
      localObject2 = new im_msg_body.RichText();
      ((im_msg_body.RichText)localObject2).elems.add((MessageMicro)localObject1);
      ((im_msg_body.RichText)localObject2).elems.add(paramChatMessage);
      if (QLog.isColorLevel()) {
        QLog.d("pap", 2, "getSendPapScribeMsgBody");
      }
      return localObject2;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */