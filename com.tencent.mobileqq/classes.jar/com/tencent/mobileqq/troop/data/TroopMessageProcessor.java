package com.tencent.mobileqq.troop.data;

import PushNotifyPack.GroupMsgReadedNotify;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc;
import com.tencent.imcore.message.BaseMessageProcessorForTroopAndDisc;
import com.tencent.imcore.message.InitMsgModule;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageCache.RegPrxyCache;
import com.tencent.mobileqq.service.message.PBDecodeContext;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgcomm.msg_comm.AppShareInfo;
import msf.msgcomm.msg_comm.ContentHead;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import msf.msgsvc.msg_svc.PbGetGroupMsgResp;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import msf.onlinepush.msg_onlinepush.PbPushMsg;
import tencent.im.msg.im_msg_body.MsgBody;

public class TroopMessageProcessor
  extends BaseMessageProcessorForTroopAndDisc
{
  public static TroopMessageProcessor.Callback a;
  public Comparator b = new TroopMessageProcessor.1(this);
  
  static {}
  
  public TroopMessageProcessor(AppInterface paramAppInterface, BaseMessageHandler paramBaseMessageHandler)
  {
    super(paramAppInterface, paramBaseMessageHandler);
  }
  
  private int a(msg_comm.Msg paramMsg)
  {
    if (paramMsg.content_head.has()) {
      return ((msg_comm.ContentHead)paramMsg.content_head.get()).pkg_num.get();
    }
    return 0;
  }
  
  private long a(ArrayList<MessageRecord> paramArrayList, String paramString, ArrayList<TroopMemberInfo> paramArrayList1, long paramLong, msg_comm.Msg paramMsg)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    long l3 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    int i = ((msg_comm.MsgHead)localObject1).user_active.get();
    int j = ((msg_comm.MsgHead)localObject1).from_instid.get();
    localObject1 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    int k = ((msg_comm.GroupInfo)localObject1).group_type.get();
    long l6 = ((msg_comm.GroupInfo)localObject1).group_code.get();
    long l7 = ((msg_comm.GroupInfo)localObject1).group_info_seq.get();
    MessageInfo localMessageInfo = new MessageInfo();
    localObject1 = a((msg_comm.GroupInfo)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<---groupMsgRecordHandle_PB : troopUin: ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(", fromUin:");
      ((StringBuilder)localObject2).append(l4);
      ((StringBuilder)localObject2).append(",toUin:");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append(",msgTime:");
      ((StringBuilder)localObject2).append(l5);
      ((StringBuilder)localObject2).append(",msgSeq:");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(",msgUid:");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(",userActive:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",fromInstid:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",groupCode:");
      ((StringBuilder)localObject2).append(l6);
      ((StringBuilder)localObject2).append(",groupType:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",groupSeq:");
      ((StringBuilder)localObject2).append(l7);
      ((StringBuilder)localObject2).append(",cardName:");
      ((StringBuilder)localObject2).append(MessageRecordUtil.a((String)localObject1));
      ((StringBuilder)localObject2).append(",hasAppShare:");
      localObject1 = paramMsg;
      ((StringBuilder)localObject2).append(((msg_comm.Msg)localObject1).appshare_info.has());
      ((StringBuilder)localObject2).append(",hasMsgBody:");
      ((StringBuilder)localObject2).append(((msg_comm.Msg)localObject1).msg_body.has());
      QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = paramMsg;
    Object localObject2 = new ArrayList();
    PBDecodeContext localPBDecodeContext = new PBDecodeContext();
    localPBDecodeContext.jdField_g_of_type_Long = Long.parseLong(paramString);
    localPBDecodeContext.f = 1;
    localPBDecodeContext.jdField_g_of_type_Int = k;
    if (((msg_comm.Msg)localObject1).content_head.has())
    {
      localObject1 = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
      i = ((msg_comm.ContentHead)localObject1).div_seq.get();
      j = ((msg_comm.ContentHead)localObject1).pkg_index.get();
      k = ((msg_comm.ContentHead)localObject1).pkg_num.get();
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("<---groupMsgRecordHandle_PB ContentHead: troopUin: ");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", divSeq:");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(",pkgIndex:");
        ((StringBuilder)localObject1).append(j);
        ((StringBuilder)localObject1).append(",pkgNum:");
        ((StringBuilder)localObject1).append(k);
        QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject1).toString());
      }
    }
    l2 = System.currentTimeMillis();
    localObject1 = null;
    try
    {
      paramMsg = a(paramMsg, (ArrayList)localObject2, localPBDecodeContext, true, localMessageInfo);
    }
    catch (Exception localException)
    {
      paramMsg = (msg_comm.Msg)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", localException);
        paramMsg = (msg_comm.Msg)localObject1;
      }
    }
    if (paramMsg != null) {
      paramArrayList1.add(paramMsg);
    }
    if (QLog.isColorLevel())
    {
      l3 = System.currentTimeMillis();
      paramArrayList1 = new StringBuilder();
      paramArrayList1.append("<---groupMsgRecordHandle_PB decodeSinglePbMsg_GroupDis: troopUin: ");
      paramArrayList1.append(paramString);
      paramArrayList1.append(", costTime = [");
      paramArrayList1.append(l3 - l2);
      paramArrayList1.append("]");
      QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList1.toString());
    }
    if (((ArrayList)localObject2).size() == 0) {
      return paramLong;
    }
    BaseMessageHandlerUtils.a((List)localObject2);
    paramArrayList.addAll((Collection)localObject2);
    return Math.max(l1, paramLong);
  }
  
  private long a(ArrayList<msg_comm.Msg> paramArrayList, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2, String paramString1, String paramString2)
  {
    paramString2 = new ArrayList();
    long l1 = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(paramString1);
    if (paramArrayList == null) {
      return l1;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<---groupMsgRecordHandle_PB : troopUin: ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", msgArrayList size:");
      ((StringBuilder)localObject).append(paramArrayList.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      localObject = (msg_comm.Msg)paramArrayList.next();
      if (localObject != null) {
        l1 = a(paramArrayList2, paramString1, paramString2, l1, (msg_comm.Msg)localObject);
      }
    }
    long l2 = System.currentTimeMillis();
    c(paramString2);
    long l3;
    if (QLog.isColorLevel())
    {
      l3 = System.currentTimeMillis();
      paramArrayList = new StringBuilder();
      paramArrayList.append("<---groupMsgRecordHandle_PB  saveTroopMemberNickAndLevelAndExtraInfo: troopUin: ");
      paramArrayList.append(paramString1);
      paramArrayList.append(", costTime=[");
      paramArrayList.append(l3 - l2);
      paramArrayList.append("]");
      QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
      l2 = l3;
    }
    a(paramArrayList2, paramArrayList1, true);
    if (QLog.isColorLevel())
    {
      l3 = System.currentTimeMillis();
      paramArrayList = new StringBuilder();
      paramArrayList.append("<---groupMsgRecordHandle_PB  msgListFilter: troopUin: ");
      paramArrayList.append(paramString1);
      paramArrayList.append(", costTime=[");
      paramArrayList.append(l3 - l2);
      paramArrayList.append("]");
      QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
    }
    return l1;
  }
  
  private BaseMessageManagerForTroopAndDisc a()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(this);
  }
  
  @Nullable
  private String a(msg_comm.GroupInfo paramGroupInfo)
  {
    if ((paramGroupInfo.group_card.has()) && (paramGroupInfo.group_card.get() != null))
    {
      paramGroupInfo = paramGroupInfo.group_card.get().toByteArray();
      try
      {
        paramGroupInfo = new String(paramGroupInfo, "utf-8");
        return paramGroupInfo;
      }
      catch (UnsupportedEncodingException paramGroupInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.TroopMessageProcessor", 2, "getCardName fail", paramGroupInfo);
        }
      }
    }
    return null;
  }
  
  private void a(int paramInt)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramInt, this);
  }
  
  private void a(long paramLong1, long paramLong2, String paramString, ArrayList<MessageRecord> paramArrayList1, PBDecodeContext paramPBDecodeContext, MessageInfo paramMessageInfo, ArrayList<MessageRecord> paramArrayList2)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramLong1, paramLong2, paramString, paramArrayList1, paramPBDecodeContext, paramMessageInfo, paramArrayList2, this);
  }
  
  private void a(long paramLong, MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramLong, paramMessageRecord, this);
    if ((paramMessageRecord.senderuin != null) && (paramMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
    {
      paramMessageRecord.isread = true;
      paramMessageRecord.issend = 2;
    }
    if (paramLong >= paramMessageRecord.shmsgseq) {
      paramMessageRecord.isread = true;
    }
  }
  
  private void a(long paramLong, ArrayList<MessageRecord> paramArrayList1, String paramString, ArrayList<MessageRecord> paramArrayList2)
  {
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(paramString, paramLong);
    }
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramLong, paramArrayList1, paramString, paramArrayList2, this);
  }
  
  private void a(long paramLong, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramLong, paramArrayList1, paramArrayList2, this);
  }
  
  private void a(MessageInfo paramMessageInfo, String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramMessageInfo, paramString, this);
  }
  
  public static void a(TroopMessageProcessor.Callback paramCallback)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback = paramCallback;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, ArrayList<msg_comm.Msg> paramArrayList, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, String paramString)
  {
    TroopMessageProcessor.ProcessOfflineContext localProcessOfflineContext = new TroopMessageProcessor.ProcessOfflineContext(null);
    Object localObject2 = paramToServiceMsg.extraData.getString("groupuin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = String.valueOf(paramPbGetGroupMsgResp.group_code.get());
    }
    localObject2 = new ArrayList();
    long l1 = a(paramArrayList, (ArrayList)localObject2, new ArrayList(), (String)localObject1, paramString);
    a((String)localObject1);
    long l2;
    if ((paramPbGetGroupMsgResp.result.get() == 104) && (((ArrayList)localObject2).size() == 0))
    {
      l2 = paramToServiceMsg.extraData.getLong("lEndSeq", paramPbGetGroupMsgResp.return_end_seq.get());
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("processOffline reply 104 !! reqEndSeq = ");
        paramToServiceMsg.append(l2);
        QLog.d("Q.msg.TroopMessageProcessor", 2, paramToServiceMsg.toString());
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b((String)localObject1, l2);
      localProcessOfflineContext.b = true;
    }
    paramArrayList = new StringBuilder(128);
    if (((ArrayList)localObject2).size() > 0)
    {
      Collections.sort((List)localObject2, this.b);
      paramToServiceMsg = new ArrayList();
      paramPbGetGroupMsgResp = new ArrayList();
      int i = ((ArrayList)localObject2).size() - 1;
      while (i >= 0)
      {
        a((String)localObject1, paramArrayList, paramToServiceMsg, paramPbGetGroupMsgResp, (MessageRecord)((ArrayList)localObject2).get(i));
        i -= 1;
      }
      a((String)localObject1, paramPbGetGroupMsgResp);
      a(paramString, localProcessOfflineContext, (String)localObject1, paramToServiceMsg);
    }
    else
    {
      localProcessOfflineContext.b = true;
      paramToServiceMsg = (ToServiceMsg)localObject2;
    }
    if ((localProcessOfflineContext.b) && (((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a((String)localObject1) == 1))
    {
      paramArrayList = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b((String)localObject1);
      if (paramArrayList != null)
      {
        l2 = ((Long)paramArrayList[0]).longValue();
        a().b((String)localObject1, 1, l2);
      }
    }
    if (l1 >= 0L)
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("groupMsgRecordHandle info.lGroupCode: ");
        paramArrayList.append((String)localObject1);
        paramArrayList.append(" info.lsMsgSeq: ");
        paramArrayList.append(l1);
        QLog.d("Q.msg.TroopMessageProcessor", 2, paramArrayList.toString());
      }
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a((String)localObject1, l1);
    }
    boolean bool = a(paramToServiceMsg);
    a("initGetPullTroopMsg", true, localProcessOfflineContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(localProcessOfflineContext.jdField_a_of_type_Boolean, bool, paramToServiceMsg), false);
    a(paramToServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList<msg_comm.Msg> paramArrayList, String paramString)
  {
    paramString = new ArrayList();
    MessageInfo localMessageInfo = new MessageInfo();
    if (paramArrayList != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("<---refreshTroopHead_PB: size:");
        ((StringBuilder)localObject).append(paramArrayList.size());
        QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        msg_comm.Msg localMsg = (msg_comm.Msg)paramArrayList.next();
        if (localMsg != null) {
          a(paramPbGetGroupMsgResp, paramString, localMessageInfo, (ArrayList)localObject, localMsg);
        }
      }
      c((ArrayList)localObject);
    }
    b(paramString);
    Collections.sort(paramString, this.b);
    a(localMessageInfo, paramPbGetGroupMsgResp.group_code.toString());
    paramToServiceMsg = paramToServiceMsg.extraData.getBundle("context");
    paramArrayList = new ArrayList();
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.putLong("beginSeq", paramPbGetGroupMsgResp.return_begin_seq.get());
      paramToServiceMsg.putLong("endSeq", paramPbGetGroupMsgResp.return_end_seq.get());
      paramToServiceMsg.putBoolean("success", true);
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).handleRefreshMessageListHeadResult(String.valueOf(paramPbGetGroupMsgResp.group_code.get()), 1, paramString, paramArrayList, paramToServiceMsg);
    }
    a(paramString, paramArrayList);
  }
  
  private void a(String paramString)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramString, this);
  }
  
  private void a(String paramString1, TroopMessageProcessor.ProcessOfflineContext paramProcessOfflineContext, String paramString2, ArrayList<MessageRecord> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      Object localObject = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(paramString2);
      if (localObject != null)
      {
        BaseMessageManagerForTroopAndDisc localBaseMessageManagerForTroopAndDisc = a();
        long l = ((Long)localObject[0]).longValue();
        int j = paramArrayList.size();
        int i = 0;
        while (i < j)
        {
          a(l, (MessageRecord)paramArrayList.get(i));
          i += 1;
        }
        if (!localBaseMessageManagerForTroopAndDisc.a(paramString2, 1, paramArrayList, paramString1))
        {
          paramProcessOfflineContext.jdField_a_of_type_Boolean = BaseMessageHandlerUtils.a(paramArrayList);
          paramProcessOfflineContext.jdField_a_of_type_Int = MsgProxyUtils.a(paramArrayList, (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache());
          localObject = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
          boolean bool;
          if ((paramProcessOfflineContext.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop)) {
            bool = true;
          } else {
            bool = false;
          }
          ((IMessageFacade)localObject).addMessage(paramArrayList, paramString1, bool, false);
          localBaseMessageManagerForTroopAndDisc.b(paramString2, 1, l);
          localBaseMessageManagerForTroopAndDisc.a(paramString2, paramArrayList);
        }
      }
    }
    else
    {
      paramProcessOfflineContext.b = true;
    }
  }
  
  private void a(String paramString, StringBuilder paramStringBuilder, ArrayList<MessageRecord> paramArrayList, ArrayList<String> paramArrayList1, MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel())
    {
      paramStringBuilder.setLength(0);
      paramStringBuilder.append("----------processOffline update send message  mr.senderuin: ");
      paramStringBuilder.append(paramMessageRecord.senderuin);
      paramStringBuilder.append(" mr.msgtype: ");
      paramStringBuilder.append(paramMessageRecord.msgtype);
      paramStringBuilder.append(" mr.frienduin: ");
      paramStringBuilder.append(paramMessageRecord.frienduin);
      paramStringBuilder.append(" mr.shmsgseq: ");
      paramStringBuilder.append(paramMessageRecord.shmsgseq);
      paramStringBuilder.append(" mr.time:");
      paramStringBuilder.append(paramMessageRecord.time);
      paramStringBuilder.append(" mr.msg: ");
      paramStringBuilder.append(paramMessageRecord.getLogColorContent());
      QLog.d("Q.msg.TroopMessageProcessor", 2, paramStringBuilder.toString());
    }
    if (a(paramMessageRecord))
    {
      b(paramMessageRecord);
      if (!a(paramString, paramMessageRecord)) {}
    }
    else if (!paramArrayList1.contains(paramMessageRecord.senderuin))
    {
      paramArrayList1.add(paramMessageRecord.senderuin);
    }
    paramArrayList.add(0, paramMessageRecord);
  }
  
  private void a(String paramString, ArrayList<String> paramArrayList)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (MessageCache.a == null) {
        MessageCache.a = new MessageCache.RegPrxyCache();
      }
      if (MessageCache.a.a == null) {
        MessageCache.a.a = new ConcurrentHashMap();
      }
      MessageCache.a.a.put(paramString, paramArrayList);
    }
  }
  
  private void a(ArrayList<MessageRecord> paramArrayList)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.b(paramArrayList, this);
  }
  
  private void a(List<msg_comm.Msg> paramList1, List<msg_comm.Msg> paramList2)
  {
    Pair localPair = super.a(paramList1, paramList2);
    if ((((Boolean)localPair.first).booleanValue()) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder("<---TroopMessagePackage:msgFilter_OnePkg ");
      localStringBuilder.append((CharSequence)localPair.second);
      localStringBuilder.append(" inListSize:");
      localStringBuilder.append(paramList1.size());
      localStringBuilder.append(" outListSize:");
      localStringBuilder.append(paramList2.size());
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, TroopMessageProcessor.ProcessPushContext paramProcessPushContext, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, int paramInt1, int paramInt2, long paramLong6, int paramInt3, long paramLong7, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("<---handleMsgPush_PB_Group : before analysis :");
      localStringBuilder.append(" fromUin:");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(" toUin:");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" msgTime:");
      localStringBuilder.append(paramLong4);
      localStringBuilder.append(" msgSeq:");
      localStringBuilder.append(paramLong3);
      localStringBuilder.append(" msgUid:");
      localStringBuilder.append(paramLong5);
      localStringBuilder.append(" userActive:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" fromInstid:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" groupCode:");
      localStringBuilder.append(paramLong6);
      localStringBuilder.append(" groupType:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" groupSeq:");
      localStringBuilder.append(paramLong7);
      localStringBuilder.append(" cardName:");
      localStringBuilder.append(MessageRecordUtil.a(paramString));
      localStringBuilder.append(" hasAppShare:");
      localStringBuilder.append(paramMsg.appshare_info.has());
      localStringBuilder.append(" bFinished:");
      localStringBuilder.append(paramProcessPushContext.jdField_a_of_type_Boolean);
      localStringBuilder.append(" divSeq:");
      localStringBuilder.append(c(paramMsg));
      localStringBuilder.append(" pkgIndex:");
      localStringBuilder.append(b(paramMsg));
      localStringBuilder.append(" pkgNum:");
      localStringBuilder.append(a(paramMsg));
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
      if (paramFromServiceMsg.getAttribute("__timestamp_net2msf") != null)
      {
        paramLong1 = ((Long)paramFromServiceMsg.getAttribute("__timestamp_net2msf")).longValue() / 1000L;
        paramMsg = new StringBuilder();
        paramMsg.append("push_cost=");
        paramMsg.append(paramLong1 - paramLong4);
        paramMsg.append(",type=GROUP_PUSH_MSG");
        QLog.d("Q.msg.TroopMessageProcessor", 2, paramMsg.toString());
      }
    }
  }
  
  private void a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, msg_onlinepush.PbPushMsg paramPbPushMsg, boolean paramBoolean)
  {
    TroopMessageProcessor.ProcessPushContext localProcessPushContext = new TroopMessageProcessor.ProcessPushContext(null);
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    if (!((msg_comm.MsgHead)localObject1).group_info.has())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group: no groupInfo.");
      }
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject2 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    long l2 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l3 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    long l6 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    int j = ((msg_comm.MsgHead)localObject1).user_active.get();
    int k = ((msg_comm.MsgHead)localObject1).from_instid.get();
    long l7 = ((msg_comm.GroupInfo)localObject2).group_code.get();
    int i = ((msg_comm.GroupInfo)localObject2).group_type.get();
    long l8 = ((msg_comm.GroupInfo)localObject2).group_info_seq.get();
    if (paramFromServiceMsg.getUin() == null) {
      localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    } else {
      localObject1 = paramFromServiceMsg.getUin();
    }
    long l9 = Long.valueOf((String)localObject1).longValue();
    String str = a((msg_comm.GroupInfo)localObject2);
    Object localObject3 = new ArrayList();
    a(j);
    localObject2 = String.valueOf(l7);
    ArrayList localArrayList = new ArrayList();
    localObject1 = new PBDecodeContext();
    ((PBDecodeContext)localObject1).jdField_g_of_type_Long = l7;
    ((PBDecodeContext)localObject1).f = 1;
    ((PBDecodeContext)localObject1).jdField_g_of_type_Int = i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<---handleMsgPush_PB_Group : needAck ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" pushMsg ");
      if (paramPbPushMsg != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localStringBuilder.append(bool1);
      QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramPbPushMsg != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(l9, paramPbPushMsg.svrip.get(), paramFromServiceMsg.getRequestSsoSeq(), paramPbPushMsg);
    }
    paramPbPushMsg = (msg_onlinepush.PbPushMsg)localObject3;
    localObject3 = "Q.msg.TroopMessageProcessor";
    if (a(paramMsg, paramFromServiceMsg, localProcessPushContext, (String)localObject2)) {
      return;
    }
    a(paramMsg, paramFromServiceMsg, localProcessPushContext, l2, l3, l4, l5, l6, j, k, l7, i, l8, str);
    a((String)localObject2);
    paramFromServiceMsg = new MessageInfo();
    try
    {
      a(paramMsg, paramPbPushMsg, (PBDecodeContext)localObject1, true, paramFromServiceMsg);
    }
    catch (Exception paramMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w((String)localObject3, 2, "decodeSinglePbMsg_GroupDis error,", paramMsg);
    }
    BaseMessageHandlerUtils.a(paramPbPushMsg);
    if (paramPbPushMsg.size() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d((String)localObject3, 2, "<---handleMsgPush_PB_Group : msg list is empty after decode.");
      }
      return;
    }
    paramBoolean = true;
    a(paramPbPushMsg, localArrayList, true);
    paramMsg = new ArrayList();
    a(l2, l9, (String)localObject2, localArrayList, (PBDecodeContext)localObject1, paramFromServiceMsg, paramMsg);
    ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(paramMsg);
    boolean bool1 = BaseMessageHandlerUtils.a(paramMsg);
    boolean bool2 = a(paramMsg);
    j = MsgProxyUtils.a(paramMsg, (MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache());
    paramFromServiceMsg = (IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "");
    if ((!bool1) || (!this.jdField_a_of_type_ComTencentCommonAppAppInterface.isBackgroundStop)) {
      paramBoolean = false;
    }
    paramFromServiceMsg.addMessage(paramMsg, String.valueOf(l9), paramBoolean);
    a(l4, paramPbPushMsg, (String)localObject2, paramMsg);
    if (i == 127) {
      return;
    }
    a("handleMsgPush_PB_Group", true, j, this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(bool1, bool2, paramMsg), false);
    a(l1, localArrayList, paramMsg);
  }
  
  private void a(msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo, ArrayList<TroopMemberInfo> paramArrayList1, msg_comm.Msg paramMsg)
  {
    Object localObject1 = (msg_comm.MsgHead)paramMsg.msg_head.get();
    long l1 = ((msg_comm.MsgHead)localObject1).msg_seq.get();
    long l2 = ((msg_comm.MsgHead)localObject1).msg_uid.get();
    long l3 = ((msg_comm.MsgHead)localObject1).to_uin.get();
    long l4 = ((msg_comm.MsgHead)localObject1).from_uin.get();
    long l5 = ((msg_comm.MsgHead)localObject1).msg_time.get();
    int i = ((msg_comm.MsgHead)localObject1).user_active.get();
    int j = ((msg_comm.MsgHead)localObject1).from_instid.get();
    localObject1 = (msg_comm.GroupInfo)((msg_comm.MsgHead)localObject1).group_info.get();
    int k = ((msg_comm.GroupInfo)localObject1).group_type.get();
    long l6 = ((msg_comm.GroupInfo)localObject1).group_code.get();
    long l7 = ((msg_comm.GroupInfo)localObject1).group_info_seq.get();
    Object localObject3 = a((msg_comm.GroupInfo)localObject1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<---refreshTroopHead_PB : fromUin:");
      ((StringBuilder)localObject2).append(l4);
      ((StringBuilder)localObject2).append(",toUin:");
      ((StringBuilder)localObject2).append(l3);
      ((StringBuilder)localObject2).append(",msgTime:");
      ((StringBuilder)localObject2).append(l5);
      ((StringBuilder)localObject2).append(",msgSeq:");
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append(",msgUid:");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append(",userActive:");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(",fromInstid:");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append(",groupCode:");
      ((StringBuilder)localObject2).append(l6);
      ((StringBuilder)localObject2).append(",groupType:");
      ((StringBuilder)localObject2).append(k);
      ((StringBuilder)localObject2).append(",groupSeq:");
      ((StringBuilder)localObject2).append(l7);
      ((StringBuilder)localObject2).append(",Hascard:");
      ((StringBuilder)localObject2).append(((msg_comm.GroupInfo)localObject1).group_card.has());
      ((StringBuilder)localObject2).append(",cardName:");
      ((StringBuilder)localObject2).append(MessageRecordUtil.a((String)localObject3));
      ((StringBuilder)localObject2).append(",hasAppShare:");
      localObject1 = paramMsg;
      ((StringBuilder)localObject2).append(((msg_comm.Msg)localObject1).appshare_info.has());
      ((StringBuilder)localObject2).append(",hasMsgBody:");
      ((StringBuilder)localObject2).append(((msg_comm.Msg)localObject1).msg_body.has());
      QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = paramMsg;
    Object localObject2 = new ArrayList();
    localObject3 = new PBDecodeContext();
    ((PBDecodeContext)localObject3).jdField_g_of_type_Long = paramPbGetGroupMsgResp.group_code.get();
    ((PBDecodeContext)localObject3).f = 1;
    ((PBDecodeContext)localObject3).jdField_g_of_type_Int = k;
    if (((msg_comm.Msg)localObject1).content_head.has())
    {
      paramPbGetGroupMsgResp = (msg_comm.ContentHead)((msg_comm.Msg)localObject1).content_head.get();
      i = paramPbGetGroupMsgResp.div_seq.get();
      j = paramPbGetGroupMsgResp.pkg_index.get();
      k = paramPbGetGroupMsgResp.pkg_num.get();
      if (QLog.isColorLevel())
      {
        paramPbGetGroupMsgResp = new StringBuilder();
        paramPbGetGroupMsgResp.append("<---refreshTroopHead_PB ContentHead: divSeq:");
        paramPbGetGroupMsgResp.append(i);
        paramPbGetGroupMsgResp.append(",pkgIndex:");
        paramPbGetGroupMsgResp.append(j);
        paramPbGetGroupMsgResp.append(",pkgNum:");
        paramPbGetGroupMsgResp.append(k);
        QLog.d("Q.msg.TroopMessageProcessor", 2, paramPbGetGroupMsgResp.toString());
      }
    }
    localObject1 = null;
    try
    {
      paramPbGetGroupMsgResp = a(paramMsg, (ArrayList)localObject2, (PBDecodeContext)localObject3, true, paramMessageInfo);
    }
    catch (Exception paramMessageInfo)
    {
      paramPbGetGroupMsgResp = (msg_svc.PbGetGroupMsgResp)localObject1;
      if (QLog.isColorLevel())
      {
        QLog.w("Q.msg.TroopMessageProcessor", 2, "decodeSinglePbMsg_GroupDis error,", paramMessageInfo);
        paramPbGetGroupMsgResp = (msg_svc.PbGetGroupMsgResp)localObject1;
      }
    }
    if (paramPbGetGroupMsgResp != null)
    {
      paramPbGetGroupMsgResp.level = -1;
      paramArrayList1.add(paramPbGetGroupMsgResp);
    }
    if (((ArrayList)localObject2).size() == 0) {
      return;
    }
    BaseMessageHandlerUtils.a((List)localObject2);
    if (paramArrayList != null)
    {
      a((List)localObject2, paramArrayList, true);
      return;
    }
  }
  
  private boolean a()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.b(this);
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramMessageRecord, this);
  }
  
  private boolean a(String paramString, MessageRecord paramMessageRecord)
  {
    MessageRecord localMessageRecord = ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).getSendingTroopMsgItem(paramMessageRecord.frienduin, 1, paramMessageRecord);
    if (localMessageRecord == null) {
      return false;
    }
    if ((b(paramMessageRecord)) && (b(localMessageRecord)) && (paramMessageRecord.getRepeatCount() > 0))
    {
      localMessageRecord.setRepeatCount(paramMessageRecord.getRepeatCount());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("<---initGetPullTroopMsg_PB ===> update findMr.repeatCount=");
        localStringBuilder.append(paramMessageRecord.getRepeatCount());
        QLog.d("Q.msg.TroopMessageProcessor", 2, localStringBuilder.toString());
      }
    }
    if (!((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).d()) {
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(localMessageRecord.frienduin, localMessageRecord.istroop, localMessageRecord.uniseq);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageHandler.a(paramMessageRecord.frienduin, 1, localMessageRecord.uniseq, paramMessageRecord.shmsgseq, paramMessageRecord.time);
    ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(paramString, paramMessageRecord.shmsgseq);
    return true;
  }
  
  private boolean a(ArrayList<MessageRecord> paramArrayList)
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramArrayList);
  }
  
  private boolean a(msg_comm.Msg paramMsg, FromServiceMsg paramFromServiceMsg, TroopMessageProcessor.ProcessPushContext paramProcessPushContext, String paramString)
  {
    boolean bool;
    if (((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(paramString) == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramProcessPushContext.jdField_a_of_type_Boolean = bool;
    if (!b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : isNeedPushMsg false");
      }
      return true;
    }
    if (!RegisterProxyHandler.jdField_a_of_type_Boolean)
    {
      if (!paramProcessPushContext.jdField_a_of_type_Boolean)
      {
        ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(paramString, new Object[] { paramMsg, paramFromServiceMsg });
        if (QLog.isColorLevel())
        {
          paramMsg = new StringBuilder();
          paramMsg.append("<---handleMsgPush_PB_Group : unfinished troopuin=");
          paramMsg.append(paramString);
          QLog.d("Q.msg.TroopMessageProcessor", 2, paramMsg.toString());
        }
        return true;
      }
    }
    else if (!a())
    {
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).a(paramString, new Object[] { paramMsg, paramFromServiceMsg });
      if (QLog.isColorLevel()) {
        QLog.d("Q.msg.TroopMessageProcessor", 2, "<---handleMsgPush_PB_Group : isSyncNormalMsgFinish false");
      }
      return true;
    }
    return false;
  }
  
  private int b(msg_comm.Msg paramMsg)
  {
    if (paramMsg.content_head.has()) {
      return ((msg_comm.ContentHead)paramMsg.content_head.get()).pkg_index.get();
    }
    return 0;
  }
  
  private void b(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramMessageRecord, this);
  }
  
  private void b(ArrayList<MessageRecord> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramArrayList.next();
      if ((localMessageRecord.senderuin != null) && (localMessageRecord.senderuin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin()))) {
        localMessageRecord.issend = 2;
      }
      localMessageRecord.isread = true;
    }
  }
  
  private boolean b()
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(this);
  }
  
  private boolean b(MessageRecord paramMessageRecord)
  {
    return jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramMessageRecord);
  }
  
  private int c(msg_comm.Msg paramMsg)
  {
    if (paramMsg.content_head.has()) {
      return ((msg_comm.ContentHead)paramMsg.content_head.get()).div_seq.get();
    }
    return 0;
  }
  
  private void c(ArrayList<TroopMemberInfo> paramArrayList)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramArrayList, this);
  }
  
  public List<MessageRecord> a(msg_comm.Msg paramMsg, PBDecodeContext paramPBDecodeContext)
  {
    return null;
  }
  
  public void a(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    ArrayList localArrayList;
    switch (paramInt)
    {
    default: 
      return;
    case 1003: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[2], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], (msg_svc.PbGetGroupMsgResp)paramVarArgs[1], localArrayList, (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    case 1002: 
      if ((paramVarArgs != null) && (paramVarArgs.length == 4))
      {
        localArrayList = new ArrayList();
        a((ArrayList)paramVarArgs[1], localArrayList);
        a((ToServiceMsg)paramVarArgs[0], localArrayList, (msg_svc.PbGetGroupMsgResp)paramVarArgs[2], (String)paramVarArgs[3]);
        return;
      }
      a(getClass().getName(), paramInt);
      return;
    }
    if ((paramVarArgs != null) && (paramVarArgs.length == 4))
    {
      a((msg_comm.Msg)paramVarArgs[0], (FromServiceMsg)paramVarArgs[1], (msg_onlinepush.PbPushMsg)paramVarArgs[2], ((Boolean)paramVarArgs[3]).booleanValue());
      return;
    }
    a(getClass().getName(), paramInt);
  }
  
  public void a(GroupMsgReadedNotify paramGroupMsgReadedNotify)
  {
    String str = String.valueOf(paramGroupMsgReadedNotify.lGroupCode);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GroupMsgReadedNotify lGroupCode is ");
      ((StringBuilder)localObject).append(paramGroupMsgReadedNotify.lGroupCode);
      ((StringBuilder)localObject).append(", lMemberSeq  is ");
      ((StringBuilder)localObject).append(paramGroupMsgReadedNotify.lMemberSeq);
      QLog.d("Q.msg.TroopMessageProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).b(str);
    if ((localObject != null) && (localObject.length >= 2) && (((Long)localObject[0]).longValue() < paramGroupMsgReadedNotify.lMemberSeq)) {
      ((MessageCache)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getMsgCache()).c(str, new Object[] { Long.valueOf(paramGroupMsgReadedNotify.lMemberSeq), Long.valueOf(paramGroupMsgReadedNotify.lGroupMsgSeq) });
    }
    ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).setReadFrom(str, 1, paramGroupMsgReadedNotify.lMemberSeq);
    if (paramGroupMsgReadedNotify.lMemberSeq >= 0L) {
      ((IMessageFacade)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IMessageFacade.class, "")).removeNotification(str, 1);
    }
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramGroupMsgReadedNotify, this);
  }
  
  public void a(String paramString, int paramInt, long paramLong)
  {
    super.a(paramString, paramInt, paramLong);
    if (!paramString.matches("^\\d+$")) {
      return;
    }
    msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
    msg_svc.PbGroupReadedReportReq localPbGroupReadedReportReq = new msg_svc.PbGroupReadedReportReq();
    localPbGroupReadedReportReq.group_code.set(Long.parseLong(paramString));
    localPbGroupReadedReportReq.last_read_seq.set(paramLong);
    localPbMsgReadedReportReq.grp_read_report.add(localPbGroupReadedReportReq);
    a(localPbMsgReadedReportReq);
  }
  
  public void a(String paramString, msg_svc.PbGetGroupMsgResp paramPbGetGroupMsgResp, int paramInt)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramString, paramPbGetGroupMsgResp, paramInt, this);
  }
  
  void a(ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2)
  {
    jdField_a_of_type_ComTencentMobileqqTroopDataTroopMessageProcessor$Callback.a(paramArrayList1, paramArrayList2, this);
  }
  
  public void b(int paramInt, ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopMessageProcessor
 * JD-Core Version:    0.7.0.1
 */