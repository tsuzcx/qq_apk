package com.tencent.mobileqq.service.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.proxy.QProxyManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.Msg;
import msf.msgsvc.msg_svc.PbDeleteMsgReq;
import msf.msgsvc.msg_svc.PbDeleteMsgReq.MsgItem;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import msf.msgsvc.msg_svc.RoutingHead;
import msf.msgsvc.msg_svc.Trans0x211;
import msf.msgsvc.msg_svc.TransMsg;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.ElemFlags2;
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SecretFileMsg;
import tencent.im.msg.im_msg_body.Text;

public class QMessageProtoCodec
{
  private static QMessagePBElemDecoder jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreMessageProtoCodec.yml", version=3)
  public static ArrayList<Class<? extends QMessagePBElemDecoder>> a;
  private static final Comparator<? super IPBMsgElemDecoder> jdField_a_of_type_JavaUtilComparator = new QMessageProtoCodec.1();
  
  static
  {
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(MessagePBElemDecoder.class);
  }
  
  public static int a(int paramInt, AppInterface paramAppInterface)
  {
    return ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "all")).getUinType(paramInt);
  }
  
  public static int a(long paramLong)
  {
    return (int)(paramLong & 0xFFFFFFFF);
  }
  
  public static int a(msg_comm.Msg paramMsg)
  {
    paramMsg = a(paramMsg);
    if ((paramMsg != null) && (paramMsg.uint32_bubble_diy_text_id.has()))
    {
      int i = paramMsg.uint32_bubble_diy_text_id.get();
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("decodeC2CMsgPkg_BubbleDiyTextID->");
        paramMsg.append(i);
        QLog.d("Q.msg.MessageProtoCodec", 2, paramMsg.toString());
      }
      return i;
    }
    return 0;
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder();
    int i = 0;
    int j = 0;
    QMessageProtoCodec.EncodeRichTextFromStringMsgOne localEncodeRichTextFromStringMsgOne;
    for (int k = 0; k < str.length(); k = localEncodeRichTextFromStringMsgOne.c() + 1)
    {
      localEncodeRichTextFromStringMsgOne = new QMessageProtoCodec.EncodeRichTextFromStringMsgOne(paramRichText, str, paramArrayList, i, j, paramString, k).a();
      i = localEncodeRichTextFromStringMsgOne.a();
      j = localEncodeRichTextFromStringMsgOne.b();
    }
    j = i;
    if (paramString.length() > 0)
    {
      a(paramRichText, paramString.toString());
      j = i + 1;
    }
    return j;
  }
  
  public static long a(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    paramAppInterface = a(paramAppInterface, 0).b(paramString1, 0);
    if (paramAppInterface != null)
    {
      int i = paramAppInterface.size() - 1;
      while (i >= 0)
      {
        paramString1 = (MessageRecord)paramAppInterface.get(i);
        if (paramString1.senderuin.equals(paramString2))
        {
          paramAppInterface = paramString1;
          if (!QLog.isColorLevel()) {
            break label80;
          }
          QLog.i("vip", 2, "getLastC2CBubleID find in cache");
          paramAppInterface = paramString1;
          break label80;
        }
        i -= 1;
      }
    }
    paramAppInterface = null;
    label80:
    if (paramAppInterface == null) {
      return 0L;
    }
    return paramAppInterface.vipBubbleID;
  }
  
  public static long a(BaseMessageHandler paramBaseMessageHandler, msg_comm.Msg paramMsg, String paramString1, String paramString2)
  {
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        return 0L;
      }
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      long l1 = -1L;
      if (paramMsg.hasNext())
      {
        Object localObject = (im_msg_body.Elem)paramMsg.next();
        if ((((im_msg_body.Elem)localObject).elem_flags2.has()) && (((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.has())) {}
        for (int i = ((im_msg_body.ElemFlags2)((im_msg_body.Elem)localObject).elem_flags2.get()).uint32_color_text_id.get();; i = ((im_msg_body.ElemFlags2)((im_msg_body.SecretFileMsg)localObject).elem_flags2.get()).uint32_color_text_id.get())
        {
          l1 = i & 0xFFFFFFFF;
          break;
          if (!((im_msg_body.Elem)localObject).secret_file.has()) {
            break;
          }
          localObject = ((im_msg_body.Elem)localObject).secret_file;
          if ((!((im_msg_body.SecretFileMsg)localObject).elem_flags2.has()) || (!((im_msg_body.SecretFileMsg)localObject).elem_flags2.uint32_color_text_id.has())) {
            break;
          }
        }
      }
      long l2;
      if (l1 == 4294967295L) {
        l2 = a(paramBaseMessageHandler.a(), paramString1, paramString2);
      } else {
        l2 = -1L;
      }
      if (l1 != 4294967295L) {
        l2 = l1;
      }
      l1 = l2;
      if (l2 == -1L) {
        l1 = 0L;
      }
      return l1;
    }
    return 0L;
  }
  
  public static BaseMsgProxy a(AppInterface paramAppInterface, int paramInt)
  {
    return ((MsgProxyContainer)((QProxyManager)paramAppInterface.getProxyManagerInner()).getProxy(0)).a(paramInt);
  }
  
  private static List<IPBMsgElemDecoder> a(List<im_msg_body.Elem> paramList, IMessageFacade paramIMessageFacade)
  {
    ArrayList localArrayList = new ArrayList();
    paramIMessageFacade = paramIMessageFacade.getPBMsgElemsDecoders();
    a(paramList, localArrayList, paramIMessageFacade);
    a(localArrayList, paramIMessageFacade);
    b(localArrayList, paramIMessageFacade);
    return localArrayList;
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, int paramInt1, String paramString, TransMsgContext paramTransMsgContext, long paramLong, int paramInt2)
  {
    Object localObject1 = null;
    if (paramTransMsgContext == null) {
      return null;
    }
    int i = (short)(int)paramLong;
    int j = 0xFFFF & i;
    long l1;
    long l2;
    if ((paramInt1 != 9) && (paramInt1 != 13))
    {
      l1 = 72057594037927936L;
      l2 = paramInt2;
    }
    else
    {
      l1 = 144115188075855872L;
      l2 = paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<PbSendMsg><S>--->createPbSendMsgReq: routingType:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(",toUin:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",msgUid:");
      ((StringBuilder)localObject2).append(l1 | l2);
      ((StringBuilder)localObject2).append(",msgSeq:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(",uint32Seq:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",shortSeq:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",randomNum:");
      ((StringBuilder)localObject2).append(paramInt2);
      ((StringBuilder)localObject2).append(",msgContext:");
      ((StringBuilder)localObject2).append(paramTransMsgContext);
      QLog.d("Q.msg.MessageProtoCodec", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (MessageCache)paramAppInterface.getMsgCache();
    paramAppInterface = new msg_svc.RoutingHead();
    if (paramInt1 != 9)
    {
      if (paramInt1 != 13)
      {
        paramInt1 = 0;
        break label369;
      }
      localObject3 = new msg_svc.Trans0x211();
      ((msg_svc.Trans0x211)localObject3).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      paramString = paramString.replace("+", "");
      ((msg_svc.Trans0x211)localObject3).to_uin.set(CharacterUtil.a(paramString));
      paramAppInterface.trans_0x211.set((MessageMicro)localObject3);
    }
    else
    {
      localObject3 = new msg_svc.TransMsg();
      ((msg_svc.TransMsg)localObject3).c2c_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      ((msg_svc.TransMsg)localObject3).to_uin.set(Long.valueOf(paramString).longValue());
      paramAppInterface.trans_msg.set((MessageMicro)localObject3);
    }
    paramInt1 = 1;
    label369:
    if (paramInt1 == 0) {
      return null;
    }
    Object localObject3 = new msg_comm.ContentHead();
    ((msg_comm.ContentHead)localObject3).pkg_num.set(1);
    ((msg_comm.ContentHead)localObject3).div_seq.set(i);
    ((msg_comm.ContentHead)localObject3).pkg_index.set(0);
    im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
    localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
    paramString = new msg_svc.PbSendMsgReq();
    paramString.routing_head.set(paramAppInterface);
    paramString.content_head.set((MessageMicro)localObject3);
    paramString.msg_body.set(localMsgBody);
    paramString.msg_seq.set(j);
    paramString.msg_rand.set(paramInt2);
    paramAppInterface = localObject1;
    if (localObject2 != null) {
      paramAppInterface = ((MessageCache)localObject2).a();
    }
    if (paramAppInterface != null) {
      paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramAppInterface));
    }
    return paramString;
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    int i = b(paramMessageRecord.istroop, paramAppInterface);
    Object localObject = null;
    if (i != 9)
    {
      if (i == 13) {
        return null;
      }
      long l = paramMessageRecord.msgUid;
      int j = (short)(int)paramMessageRecord.msgseq;
      int k = a(l);
      MessageCache localMessageCache = (MessageCache)paramAppInterface.getMsgCache();
      msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
      if (!a(paramAppInterface, paramMessageRecord, localRoutingHead)) {
        return null;
      }
      msg_comm.ContentHead localContentHead = new msg_comm.ContentHead();
      localContentHead.pkg_num.set(paramMessageRecord.longMsgCount);
      localContentHead.div_seq.set(paramMessageRecord.longMsgId);
      localContentHead.pkg_index.set(paramMessageRecord.longMsgIndex);
      paramMessageRecord = new im_msg_body.MsgBody();
      paramMessageRecord.rich_text.set(paramRichText);
      paramRichText = new msg_svc.PbSendMsgReq();
      paramRichText.routing_head.set(localRoutingHead);
      paramRichText.content_head.set(localContentHead);
      paramRichText.msg_body.set(paramMessageRecord);
      paramRichText.msg_seq.set(j & 0xFFFF);
      paramRichText.msg_rand.set(k);
      if ((i != 2) && (i != 4) && (i != 21))
      {
        if (localMessageCache == null) {
          paramMessageRecord = localObject;
        } else {
          paramMessageRecord = localMessageCache.a();
        }
        if (paramMessageRecord != null)
        {
          paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord));
          a(paramAppInterface, paramMessageRecord);
        }
      }
      paramRichText.msg_via.set(paramInt);
      return paramRichText;
    }
    return null;
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransMsgContext paramTransMsgContext, long paramLong, int paramInt3)
  {
    Object localObject1 = null;
    if (paramTransMsgContext == null) {
      return null;
    }
    int i = (short)(int)paramLong;
    int j = 0xFFFF & i;
    long l = paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<PbSendMsg><S>--->createTempSessionSendMsgReq: routingType:13,toUin:");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(",msgUid:");
      ((StringBuilder)localObject2).append(0x0 | l << 16 | 0xA6);
      ((StringBuilder)localObject2).append(",msgSeq:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(",uint32Seq:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",shortSeq:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",randomNum:");
      ((StringBuilder)localObject2).append(paramInt3);
      ((StringBuilder)localObject2).append(",msgContext:");
      ((StringBuilder)localObject2).append(paramTransMsgContext);
      QLog.d("Q.msg.MessageProtoCodec", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (MessageCache)paramAppInterface.getMsgCache();
    paramAppInterface = new msg_svc.RoutingHead();
    Object localObject3 = new msg_svc.Trans0x211();
    ((msg_svc.Trans0x211)localObject3).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
    ((msg_svc.Trans0x211)localObject3).to_uin.set(Long.valueOf(paramString).longValue());
    if (paramArrayOfByte != null) {
      ((msg_svc.Trans0x211)localObject3).sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((msg_svc.Trans0x211)localObject3).c2c_type.set(paramInt1);
    ((msg_svc.Trans0x211)localObject3).service_type.set(paramInt2);
    paramAppInterface.trans_0x211.set((MessageMicro)localObject3);
    paramArrayOfByte = new msg_comm.ContentHead();
    paramArrayOfByte.pkg_num.set(1);
    paramArrayOfByte.div_seq.set(i);
    paramArrayOfByte.pkg_index.set(0);
    localObject3 = new im_msg_body.MsgBody();
    ((im_msg_body.MsgBody)localObject3).msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
    paramString = new msg_svc.PbSendMsgReq();
    paramString.routing_head.set(paramAppInterface);
    paramString.content_head.set(paramArrayOfByte);
    paramString.msg_body.set((MessageMicro)localObject3);
    paramString.msg_seq.set(j);
    paramString.msg_rand.set(paramInt3);
    paramAppInterface = localObject1;
    if (localObject2 != null) {
      paramAppInterface = ((MessageCache)localObject2).a();
    }
    if (paramAppInterface != null) {
      paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramAppInterface));
    }
    return paramString;
  }
  
  public static generalflags.ResvAttr a(im_msg_body.GeneralFlags paramGeneralFlags)
  {
    try
    {
      generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
      localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
      return localResvAttr;
    }
    catch (InvalidProtocolBufferMicroException paramGeneralFlags)
    {
      QLog.e("Q.msg.MessageProtoCodec", 1, "", paramGeneralFlags);
    }
    return null;
  }
  
  public static im_msg_body.Elem a(im_msg_body.RichText paramRichText, String paramString)
  {
    im_msg_body.Text localText = new im_msg_body.Text();
    localText.str.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = new im_msg_body.Elem();
    paramString.text.set(localText);
    paramRichText.elems.add(paramString);
    return paramString;
  }
  
  @Nullable
  public static im_msg_body.GeneralFlags a(msg_comm.Msg paramMsg)
  {
    if (paramMsg.msg_body.has())
    {
      if (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has()) {
        return null;
      }
      paramMsg = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get().iterator();
      while (paramMsg.hasNext())
      {
        im_msg_body.Elem localElem = (im_msg_body.Elem)paramMsg.next();
        if (localElem.general_flags.has()) {
          return (im_msg_body.GeneralFlags)localElem.general_flags.get();
        }
      }
    }
    return null;
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    if (a(localRichText, paramString, paramArrayList) <= 0) {
      return null;
    }
    return localRichText;
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramAppInterface.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    try
    {
      paramLong1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageProtoCodec", 2, localException.getMessage());
      }
      paramLong1 = 0L;
    }
    localMsgItem.to_uin.set(paramLong1);
    localMsgItem.msg_type.set(paramInt2);
    localPbDeleteMsgReq.msgItems.add(localMsgItem);
    localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramAppInterface.sendToService(localToServiceMsg);
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramAppInterface.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    try
    {
      paramLong1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageProtoCodec", 2, localException.getMessage());
      }
      paramLong1 = 0L;
    }
    localMsgItem.to_uin.set(paramLong1);
    localMsgItem.msg_type.set(paramInt2);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
      localMsgItem.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localPbDeleteMsgReq.msgItems.add(localMsgItem);
    localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    paramAppInterface.sendToService(localToServiceMsg);
  }
  
  private static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte)
  {
    if (AppSetting.f()) {
      ((IQMessageProtoCodecService)QRoute.api(IQMessageProtoCodecService.class)).recordCookie(paramAppInterface, paramArrayOfByte);
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, im_msg_body.Elem paramElem)
  {
    Field[] arrayOfField = paramElem.getClass().getDeclaredFields();
    int m = arrayOfField.length;
    int i = 0;
    int k;
    for (int j = 1; i < m; j = k)
    {
      Field localField = arrayOfField[i];
      try
      {
        localField.setAccessible(true);
        Object localObject = localField.get(paramElem);
        k = j;
        if ((localObject instanceof PBPrimitiveField))
        {
          k = j;
          if (((PBPrimitiveField)localObject).has())
          {
            if (j == 0) {
              paramStringBuilder.append(",");
            }
            paramStringBuilder.append(localField.getName());
            k = 0;
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        k = j;
      }
      i += 1;
    }
  }
  
  private static void a(List<im_msg_body.Elem> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(";");
      }
      a(localStringBuilder, localElem);
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("printElem() called with: elements = [");
      paramList.append(localStringBuilder.toString());
      paramList.append("]");
      QLog.d("Q.msg.MessageProtoCodec", 2, paramList.toString());
    }
  }
  
  private static void a(List<IPBMsgElemDecoder> paramList1, List<IPBMsgElemDecoder> paramList2)
  {
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      IPBMsgElemDecoder localIPBMsgElemDecoder = (IPBMsgElemDecoder)paramList2.next();
      if (localIPBMsgElemDecoder != null) {
        localIPBMsgElemDecoder.a(paramList1);
      }
    }
  }
  
  private static void a(List<im_msg_body.Elem> paramList, List<IPBMsgElemDecoder> paramList1, List<IPBMsgElemDecoder> paramList2)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      im_msg_body.Elem localElem = (im_msg_body.Elem)paramList.next();
      Iterator localIterator = paramList2.iterator();
      while (localIterator.hasNext())
      {
        IPBMsgElemDecoder localIPBMsgElemDecoder = (IPBMsgElemDecoder)localIterator.next();
        if ((localIPBMsgElemDecoder != null) && (localIPBMsgElemDecoder.a(localElem))) {
          paramList1.add(localIPBMsgElemDecoder);
        }
      }
    }
  }
  
  private static void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, MessageInfo paramMessageInfo)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder == null) {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder == null) {
            jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder = (QMessagePBElemDecoder)((Class)jdField_a_of_type_JavaUtilArrayList.get(0)).newInstance();
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("Q.msg.MessageProtoCodec", 1, localThrowable, new Object[0]);
      if (jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder != null)
      {
        if (paramList1.isEmpty()) {
          jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder.i(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
        }
        if (paramList1.isEmpty()) {
          jdField_a_of_type_ComTencentMobileqqServiceMessageQMessagePBElemDecoder.h(paramList, paramList1, paramStringBuilder, paramMsg, paramMessageInfo);
        }
      }
    }
  }
  
  private static void a(List<im_msg_body.Elem> paramList, msg_comm.Msg paramMsg, List<MessageRecord> paramList1, StringBuilder paramStringBuilder, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, List<IPBMsgElemDecoder> paramList2, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    Object localObject = paramList2.iterator();
    IPBMsgElemDecoder localIPBMsgElemDecoder;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localIPBMsgElemDecoder = (IPBMsgElemDecoder)((Iterator)localObject).next();
    } while ((localIPBMsgElemDecoder == null) || (!localIPBMsgElemDecoder.a(paramList, paramMsg, paramList1, paramStringBuilder, paramBoolean1, paramBoolean2, paramMessageInfo, paramTempSessionInfo, paramDecodeProtoPkgContext)));
    a(paramList, paramMsg, paramList1, paramStringBuilder, paramMessageInfo);
    b(paramList2);
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localObject = (IPBMsgElemDecoder)paramList2.next();
      if (localObject != null) {
        ((IPBMsgElemDecoder)localObject).a(paramList, paramMsg, paramList1, paramStringBuilder, paramBoolean1, paramBoolean2, paramMessageInfo, paramTempSessionInfo, paramDecodeProtoPkgContext);
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo)
  {
    a(paramAppRuntime, paramList, paramMsg, paramBoolean1, paramBoolean2, paramMessageInfo, null, null);
  }
  
  public static void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    if (localList != null)
    {
      if (localList.size() <= 0) {
        return;
      }
      a(localList);
      StringBuilder localStringBuilder = new StringBuilder("<---decodePBMsgElems:");
      a(localList, paramMsg, paramList, localStringBuilder, paramBoolean2, paramBoolean1, paramMessageInfo, a(localList, (IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "all")), paramTempSessionInfo, paramDecodeProtoPkgContext);
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageProtoCodec", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, msg_svc.RoutingHead paramRoutingHead)
  {
    if (paramRoutingHead == null) {
      return false;
    }
    int i = b(paramMessageRecord.istroop, paramAppInterface);
    return ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "all")).setRoutingHead(paramAppInterface, i, paramRoutingHead, paramMessageRecord);
  }
  
  public static int b(int paramInt, AppInterface paramAppInterface)
  {
    return ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "all")).getRoutingType(paramInt);
  }
  
  public static int b(msg_comm.Msg paramMsg)
  {
    paramMsg = a(paramMsg);
    if ((paramMsg != null) && (paramMsg.uint32_bubble_sub_id.has()))
    {
      int i = paramMsg.uint32_bubble_sub_id.get();
      if (QLog.isColorLevel())
      {
        paramMsg = new StringBuilder();
        paramMsg.append("decodeC2CMsgPkg_SubBubbleID->");
        paramMsg.append(i);
        QLog.d("Q.msg.MessageProtoCodec", 2, paramMsg.toString());
      }
      return i;
    }
    return 0;
  }
  
  private static void b(List<IPBMsgElemDecoder> paramList)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      if (((IPBMsgElemDecoder)paramList.get(i)).a() > -1000) {
        paramList.remove(i);
      }
      i -= 1;
    }
  }
  
  private static void b(List<IPBMsgElemDecoder> paramList1, List<IPBMsgElemDecoder> paramList2)
  {
    Collections.sort(paramList1, jdField_a_of_type_JavaUtilComparator);
  }
  
  public static int c(msg_comm.Msg paramMsg)
  {
    paramMsg = a(paramMsg);
    if (paramMsg != null)
    {
      if (!paramMsg.bytes_pb_reserve.has()) {
        return 0;
      }
      paramMsg = a(paramMsg);
      if (paramMsg != null)
      {
        if (!paramMsg.uint32_pendant_diy_id.has()) {
          return 0;
        }
        int i = paramMsg.uint32_pendant_diy_id.get();
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder();
          paramMsg.append("decodeC2CMsgPkg_PendantDiyID->");
          paramMsg.append(i);
          QLog.d("Q.msg.MessageProtoCodec", 2, paramMsg.toString());
        }
        return i;
      }
    }
    return 0;
  }
  
  public static int d(msg_comm.Msg paramMsg)
  {
    paramMsg = a(paramMsg);
    if (paramMsg != null)
    {
      if (!paramMsg.bytes_pb_reserve.has()) {
        return 0;
      }
      paramMsg = a(paramMsg);
      if (paramMsg != null)
      {
        if (!paramMsg.uint32_req_font_effect_id.has()) {
          return 0;
        }
        int i = paramMsg.uint32_req_font_effect_id.get();
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder();
          paramMsg.append("decodeC2CMsgPkg_FontEffectID->");
          paramMsg.append(i);
          QLog.d("Q.msg.MessageProtoCodec", 2, paramMsg.toString());
        }
        return i;
      }
    }
    return 0;
  }
  
  public static int e(msg_comm.Msg paramMsg)
  {
    paramMsg = a(paramMsg);
    if (paramMsg != null)
    {
      if (!paramMsg.bytes_pb_reserve.has()) {
        return 0;
      }
      paramMsg = a(paramMsg);
      if (paramMsg != null)
      {
        if (!paramMsg.uint32_face_id.has()) {
          return 0;
        }
        int i = paramMsg.uint32_face_id.get();
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder();
          paramMsg.append("decodeC2CMsgPkg_FaceID->");
          paramMsg.append(i);
          QLog.d("Q.msg.MessageProtoCodec", 2, paramMsg.toString());
        }
        return i;
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */