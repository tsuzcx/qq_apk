package com.tencent.mobileqq.service.message;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.core.codec.IPBMsgElemDecoder;
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
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
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
import tencent.im.msg.im_msg_body.GeneralFlags;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;

public class QMessageProtoCodec
{
  private static IQMessageProtoCodecService jdField_a_of_type_ComTencentMobileqqServiceMessageIQMessageProtoCodecService;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreMessageProtoCodec.yml", version=2)
  public static ArrayList<Class<? extends IDecodePBMsgElement>> a;
  private static final Comparator<? super IPBMsgElemDecoder> jdField_a_of_type_JavaUtilComparator;
  private static List<IDecodePBMsgElement> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final Object b;
  @ConfigInject(configPath="IMCore/src/main/resources/Inject_IMCoreMessageProtoCodec.yml", version=2)
  public static ArrayList<Class<? extends IQMessageProtoCodecService>> b;
  
  static
  {
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_a_of_type_JavaUtilComparator = new QMessageProtoCodec.1();
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(DecodePBMsgElementImpl.class);
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList.add(MessageProtoCodecServiceImpl.class);
  }
  
  public static int a(int paramInt, AppInterface paramAppInterface)
  {
    return ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, "all")).getUinType(paramInt);
  }
  
  public static int a(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  public static int a(im_msg_body.RichText paramRichText, String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    int k = 0;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = 0;
      int i = 0;
      while (k < paramString.length())
      {
        QMessageProtoCodec.EncodeRichTextFromStringMsgOne localEncodeRichTextFromStringMsgOne = new QMessageProtoCodec.EncodeRichTextFromStringMsgOne(paramRichText, paramString, paramArrayList, i, j, localStringBuilder, k).a();
        i = localEncodeRichTextFromStringMsgOne.a();
        j = localEncodeRichTextFromStringMsgOne.b();
        k = localEncodeRichTextFromStringMsgOne.c() + 1;
      }
      j = i;
      if (localStringBuilder.length() > 0)
      {
        a(paramRichText, localStringBuilder.toString());
        j = i + 1;
      }
      return j;
    }
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
    if (paramTransMsgContext == null) {
      return null;
    }
    int j = (short)(int)paramLong;
    int k = 0xFFFF & j;
    long l;
    msg_svc.RoutingHead localRoutingHead;
    if ((paramInt1 == 9) || (paramInt1 == 13))
    {
      l = 0x0 | paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length << 16 | 0xA6;
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.MessageProtoCodec", 2, "<PbSendMsg><S>--->createPbSendMsgReq: routingType:" + paramInt1 + ",toUin:" + paramString + ",msgUid:" + l + ",msgSeq:" + paramLong + ",uint32Seq:" + k + ",shortSeq:" + j + ",randomNum:" + paramInt2 + ",msgContext:" + paramTransMsgContext);
      }
      paramAppInterface = (MessageCache)paramAppInterface.getMsgCache();
      localRoutingHead = new msg_svc.RoutingHead();
      int i = 0;
      switch (paramInt1)
      {
      default: 
        paramInt1 = i;
      }
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        break label325;
      }
      return null;
      l = 0x0 | paramInt2;
      break;
      localObject = new msg_svc.TransMsg();
      ((msg_svc.TransMsg)localObject).c2c_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      ((msg_svc.TransMsg)localObject).to_uin.set(Long.valueOf(paramString).longValue());
      localRoutingHead.trans_msg.set((MessageMicro)localObject);
      paramInt1 = 1;
      continue;
      localObject = new msg_svc.Trans0x211();
      ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
      paramString = paramString.replace("+", "");
      ((msg_svc.Trans0x211)localObject).to_uin.set(CharacterUtil.a(paramString));
      localRoutingHead.trans_0x211.set((MessageMicro)localObject);
      paramInt1 = 1;
    }
    label325:
    Object localObject = new msg_comm.ContentHead();
    ((msg_comm.ContentHead)localObject).pkg_num.set(1);
    ((msg_comm.ContentHead)localObject).div_seq.set(j);
    ((msg_comm.ContentHead)localObject).pkg_index.set(0);
    im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
    localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
    paramString = new msg_svc.PbSendMsgReq();
    paramString.routing_head.set(localRoutingHead);
    paramString.content_head.set((MessageMicro)localObject);
    paramString.msg_body.set(localMsgBody);
    paramString.msg_seq.set(k);
    paramString.msg_rand.set(paramInt2);
    if (paramAppInterface != null) {}
    for (paramAppInterface = paramAppInterface.a();; paramAppInterface = null)
    {
      if (paramAppInterface != null) {
        paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramAppInterface));
      }
      return paramString;
    }
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, MessageRecord paramMessageRecord, im_msg_body.RichText paramRichText, int paramInt)
  {
    Object localObject = null;
    int i = b(paramMessageRecord.istroop, paramAppInterface);
    if ((i == 9) || (i == 13)) {
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
    paramRichText.msg_seq.set(0xFFFF & j);
    paramRichText.msg_rand.set(k);
    if ((i != 2) && (i != 4) && (i != 21)) {
      if (localMessageCache != null) {
        break label253;
      }
    }
    label253:
    for (paramMessageRecord = localObject;; paramMessageRecord = localMessageCache.a())
    {
      if (paramMessageRecord != null)
      {
        paramRichText.sync_cookie.set(ByteStringMicro.copyFrom(paramMessageRecord));
        a(paramAppInterface, paramMessageRecord);
      }
      paramRichText.msg_via.set(paramInt);
      return paramRichText;
    }
  }
  
  public static msg_svc.PbSendMsgReq a(AppInterface paramAppInterface, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, TransMsgContext paramTransMsgContext, long paramLong, int paramInt3)
  {
    if (paramTransMsgContext == null) {
      return null;
    }
    int i = (short)(int)paramLong;
    int j = 0xFFFF & i;
    long l = paramTransMsgContext.jdField_a_of_type_ArrayOfByte.length;
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageProtoCodec", 2, "<PbSendMsg><S>--->createTempSessionSendMsgReq: routingType:13,toUin:" + paramString + ",msgUid:" + (0x0 | l << 16 | 0xA6) + ",msgSeq:" + paramLong + ",uint32Seq:" + j + ",shortSeq:" + i + ",randomNum:" + paramInt3 + ",msgContext:" + paramTransMsgContext);
    }
    paramAppInterface = (MessageCache)paramAppInterface.getMsgCache();
    msg_svc.RoutingHead localRoutingHead = new msg_svc.RoutingHead();
    Object localObject = new msg_svc.Trans0x211();
    ((msg_svc.Trans0x211)localObject).cc_cmd.set(paramTransMsgContext.jdField_a_of_type_Int);
    ((msg_svc.Trans0x211)localObject).to_uin.set(Long.valueOf(paramString).longValue());
    if (paramArrayOfByte != null) {
      ((msg_svc.Trans0x211)localObject).sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((msg_svc.Trans0x211)localObject).c2c_type.set(paramInt1);
    ((msg_svc.Trans0x211)localObject).service_type.set(paramInt2);
    localRoutingHead.trans_0x211.set((MessageMicro)localObject);
    paramArrayOfByte = new msg_comm.ContentHead();
    paramArrayOfByte.pkg_num.set(1);
    paramArrayOfByte.div_seq.set(i);
    paramArrayOfByte.pkg_index.set(0);
    localObject = new im_msg_body.MsgBody();
    ((im_msg_body.MsgBody)localObject).msg_content.set(ByteStringMicro.copyFrom(paramTransMsgContext.jdField_a_of_type_ArrayOfByte));
    paramString = new msg_svc.PbSendMsgReq();
    paramString.routing_head.set(localRoutingHead);
    paramString.content_head.set(paramArrayOfByte);
    paramString.msg_body.set((MessageMicro)localObject);
    paramString.msg_seq.set(j);
    paramString.msg_rand.set(paramInt3);
    if (paramAppInterface != null) {}
    for (paramAppInterface = paramAppInterface.a();; paramAppInterface = null)
    {
      if (paramAppInterface != null) {
        paramString.sync_cookie.set(ByteStringMicro.copyFrom(paramAppInterface));
      }
      return paramString;
    }
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
    if ((!paramMsg.msg_body.has()) || (!((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.has())) {
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
    return null;
  }
  
  public static im_msg_body.RichText a(String paramString, ArrayList<AtTroopMemberInfo> paramArrayList)
  {
    im_msg_body.RichText localRichText2 = new im_msg_body.RichText();
    im_msg_body.RichText localRichText1 = localRichText2;
    if (a(localRichText2, paramString, paramArrayList) <= 0) {
      localRichText1 = null;
    }
    return localRichText1;
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong1, int paramInt1, long paramLong2, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramAppInterface.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramAppInterface.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageProtoCodec", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramAppInterface.getCurrentAccountUin(), "MessageSvc.PbDeleteMsg");
    msg_svc.PbDeleteMsgReq localPbDeleteMsgReq = new msg_svc.PbDeleteMsgReq();
    msg_svc.PbDeleteMsgReq.MsgItem localMsgItem = new msg_svc.PbDeleteMsgReq.MsgItem();
    localMsgItem.from_uin.set(paramLong1);
    localMsgItem.msg_seq.set(paramInt1);
    localMsgItem.msg_uid.set(paramLong2);
    paramLong2 = 0L;
    try
    {
      paramLong1 = Long.parseLong(paramAppInterface.getCurrentAccountUin());
      localMsgItem.to_uin.set(paramLong1);
      localMsgItem.msg_type.set(paramInt2);
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0)) {
        localMsgItem.sig.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      localPbDeleteMsgReq.msgItems.add(localMsgItem);
      localToServiceMsg.putWupBuffer(localPbDeleteMsgReq.toByteArray());
      localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      paramAppInterface.sendToService(localToServiceMsg);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramLong1 = paramLong2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageProtoCodec", 2, localException.getMessage());
          paramLong1 = paramLong2;
        }
      }
    }
  }
  
  private static void a(AppInterface paramAppInterface, byte[] paramArrayOfByte)
  {
    if (AppSetting.f()) {
      b().a(paramAppInterface, paramArrayOfByte);
    }
  }
  
  private static void a(StringBuilder paramStringBuilder, im_msg_body.Elem paramElem)
  {
    int i = 1;
    Field[] arrayOfField = paramElem.getClass().getDeclaredFields();
    int k = arrayOfField.length;
    int j = 0;
    for (;;)
    {
      if (j >= k) {
        return;
      }
      Field localField = arrayOfField[j];
      try
      {
        localField.setAccessible(true);
        Object localObject = localField.get(paramElem);
        if ((!(localObject instanceof PBPrimitiveField)) || (!((PBPrimitiveField)localObject).has())) {
          break;
        }
        if (i == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append(localField.getName());
        i = 0;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          localIllegalAccessException.printStackTrace();
        }
      }
      j += 1;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.msg.MessageProtoCodec", 2, "printElem() called with: elements = [" + localStringBuilder.toString() + "]");
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
      if (jdField_a_of_type_JavaUtilList.isEmpty()) {
        synchronized (jdField_a_of_type_JavaLangObject)
        {
          if (jdField_a_of_type_JavaUtilList.isEmpty())
          {
            Iterator localIterator2 = jdField_a_of_type_JavaUtilArrayList.iterator();
            if (localIterator2.hasNext())
            {
              Class localClass = (Class)localIterator2.next();
              jdField_a_of_type_JavaUtilList.add(localClass.newInstance());
            }
          }
        }
      }
      Iterator localIterator1;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("Q.msg.MessageProtoCodec", 1, localThrowable, new Object[0]);
      while (!jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localIterator1 = jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator1.hasNext()) {
          ((IDecodePBMsgElement)localIterator1.next()).a(paramList, paramMsg, paramList1, paramStringBuilder, paramMessageInfo);
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
  
  public static void a(AppRuntime paramAppRuntime, List<MessageRecord> paramList, msg_comm.Msg paramMsg, boolean paramBoolean1, boolean paramBoolean2, MessageInfo paramMessageInfo, TempSessionInfo paramTempSessionInfo, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    List localList = ((im_msg_body.RichText)((im_msg_body.MsgBody)paramMsg.msg_body.get()).rich_text.get()).elems.get();
    if ((localList == null) || (localList.size() <= 0)) {}
    StringBuilder localStringBuilder;
    do
    {
      return;
      a(localList);
      localStringBuilder = new StringBuilder("<---decodePBMsgElems:");
      a(localList, paramMsg, paramList, localStringBuilder, paramBoolean2, paramBoolean1, paramMessageInfo, a(localList, (IMessageFacade)paramAppRuntime.getRuntimeService(IMessageFacade.class, "all")), paramTempSessionInfo, paramDecodeProtoPkgContext);
    } while (!QLog.isColorLevel());
    QLog.d("Q.msg.MessageProtoCodec", 2, localStringBuilder.toString());
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
  
  /* Error */
  private static IQMessageProtoCodecService b()
  {
    // Byte code:
    //   0: getstatic 637	com/tencent/mobileqq/service/message/QMessageProtoCodec:jdField_a_of_type_ComTencentMobileqqServiceMessageIQMessageProtoCodecService	Lcom/tencent/mobileqq/service/message/IQMessageProtoCodecService;
    //   3: ifnonnull +36 -> 39
    //   6: getstatic 29	com/tencent/mobileqq/service/message/QMessageProtoCodec:jdField_b_of_type_JavaLangObject	Ljava/lang/Object;
    //   9: astore_0
    //   10: aload_0
    //   11: monitorenter
    //   12: getstatic 637	com/tencent/mobileqq/service/message/QMessageProtoCodec:jdField_a_of_type_ComTencentMobileqqServiceMessageIQMessageProtoCodecService	Lcom/tencent/mobileqq/service/message/IQMessageProtoCodecService;
    //   15: ifnonnull +22 -> 37
    //   18: getstatic 47	com/tencent/mobileqq/service/message/QMessageProtoCodec:jdField_b_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   21: iconst_0
    //   22: invokevirtual 640	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 540	java/lang/Class
    //   28: invokevirtual 594	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   31: checkcast 530	com/tencent/mobileqq/service/message/IQMessageProtoCodecService
    //   34: putstatic 637	com/tencent/mobileqq/service/message/QMessageProtoCodec:jdField_a_of_type_ComTencentMobileqqServiceMessageIQMessageProtoCodecService	Lcom/tencent/mobileqq/service/message/IQMessageProtoCodecService;
    //   37: aload_0
    //   38: monitorexit
    //   39: getstatic 637	com/tencent/mobileqq/service/message/QMessageProtoCodec:jdField_a_of_type_ComTencentMobileqqServiceMessageIQMessageProtoCodecService	Lcom/tencent/mobileqq/service/message/IQMessageProtoCodecService;
    //   42: areturn
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_0
    //   49: ldc 143
    //   51: iconst_1
    //   52: aload_0
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 597	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   60: goto -21 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   48	5	0	localThrowable	Throwable
    //   43	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	37	43	finally
    //   37	39	43	finally
    //   44	46	43	finally
    //   6	12	48	java/lang/Throwable
    //   46	48	48	java/lang/Throwable
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.QMessageProtoCodec
 * JD-Core Version:    0.7.0.1
 */