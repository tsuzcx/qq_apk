package com.tencent.mobileqq.service.message.codec.decoder;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.imcore.message.C2CMessageProcessor;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.DecodeProtoPkgContext;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.api.ITroopCreateInfoService;
import com.tencent.mobileqq.troop.onlinepush.api.ITroopOnlinePushHandler;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm.ExtGroupKeyInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.jetbrains.annotations.NotNull;
import tencent.im.group.broadcast.BroadcastMsgCtr.ExtGroupInfo;
import tencent.im.group.broadcast.BroadcastMsgCtr.ExtJoinGroupInfo;
import tencent.im.msg.im_msg_body.MsgBody;

public class TroopAddMemberBroadcastDecoder
  implements Decoder<MessageHandler>
{
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, long paramLong1, long paramLong2, String paramString2, Long paramLong, String paramString3, long paramLong3, long paramLong4, long paramLong5, int paramInt2, String paramString4, long paramLong6)
  {
    Object localObject1;
    Object localObject2;
    boolean bool;
    if (paramLong5 > 0L)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString4);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701508));
      localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = MessageHandlerUtils.a(paramQQAppInterface, String.valueOf(paramLong5), paramString3);
      if ((!TextUtils.isEmpty(paramString2)) && (paramString2.equals(String.valueOf(paramLong5)))) {
        bool = true;
      } else {
        bool = false;
      }
      if (paramInt2 == 1)
      {
        paramString2 = new StringBuilder();
        paramString2.append((String)localObject2);
        paramString2.append(HardCodeUtil.a(2131701507));
        localObject2 = paramString2.toString();
        paramString2 = new StringBuilder();
        paramString2.append((String)localObject2);
        paramString2.append((String)localObject1);
        paramString2.append(HardCodeUtil.a(2131701509));
        paramString2 = paramString2.toString();
      }
      else
      {
        paramString2 = new StringBuilder();
        paramString2.append((String)localObject2);
        paramString2.append((String)localObject1);
        paramString2.append(HardCodeUtil.a(2131701510));
        paramString2 = paramString2.toString();
      }
    }
    else
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString4);
      paramString2.append(HardCodeUtil.a(2131701497));
      paramString2 = paramString2.toString();
      localObject1 = "";
      localObject2 = localObject1;
      bool = false;
    }
    Object localObject3 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    TroopInfo localTroopInfo = ((TroopManager)localObject3).c(((TroopManager)localObject3).c(paramString3));
    Object localObject4;
    if ((localTroopInfo != null) && (localTroopInfo.cGroupOption == 2))
    {
      localObject3 = paramQQAppInterface.getApp().getApplicationContext().getString(2131697425);
      if (a(paramString3, paramQQAppInterface))
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(paramString2);
        ((StringBuilder)localObject4).append("，");
        ((StringBuilder)localObject4).append((String)localObject3);
        paramString2 = ((StringBuilder)localObject4).toString();
      }
      localObject4 = "";
    }
    else
    {
      localObject4 = paramQQAppInterface.getApp().getApplicationContext().getString(2131697426);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramString2);
      ((StringBuilder)localObject3).append("，");
      ((StringBuilder)localObject3).append((String)localObject4);
      paramString2 = ((StringBuilder)localObject3).toString();
      localObject3 = "";
    }
    a(paramQQAppInterface, paramInt1, paramString1, paramLong1, paramLong2, paramLong, paramString3, paramString2, a(paramQQAppInterface, paramString1, paramLong1, paramLong2, paramLong, paramString3, paramLong3, paramLong4, paramLong5, paramString4, paramLong6, paramString2, (String)localObject3, (String)localObject4, (String)localObject1, bool, (String)localObject2, localTroopInfo));
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, String paramString3, Long paramLong, String paramString4, long paramLong3, long paramLong4, String paramString5, String paramString6, long paramLong5)
  {
    if (((ITroopCreateInfoService)paramQQAppInterface.getRuntimeService(ITroopCreateInfoService.class, "")).isInInviteList(paramString4, paramString5)) {
      return;
    }
    paramString5 = MessageHandlerUtils.a(paramQQAppInterface, paramString2, paramString4);
    boolean bool;
    if ((!TextUtils.isEmpty(paramString3)) && (paramString3.equals(paramString2)))
    {
      paramString3 = HardCodeUtil.a(2131701496);
      bool = true;
    }
    else
    {
      paramString3 = paramString5;
      bool = false;
    }
    if (bool)
    {
      paramString5 = new StringBuilder();
      paramString5.append(paramString3);
      paramString5.append(HardCodeUtil.a(2131701498));
      paramString5 = paramString5.toString();
    }
    else
    {
      paramString5 = new StringBuilder();
      paramString5.append(paramString3);
      paramString5.append(HardCodeUtil.a(2131701503));
      paramString5 = paramString5.toString();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString5);
    ((StringBuilder)localObject).append(paramString6);
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131701505));
    String str = ((StringBuilder)localObject).toString();
    localObject = paramQQAppInterface.getApp().getApplicationContext().getString(2131697426);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("，");
    localStringBuilder.append((String)localObject);
    str = localStringBuilder.toString();
    a(paramQQAppInterface, paramInt, paramString1, paramLong1, paramLong2, paramLong, paramString4, str, a(paramString1, paramString2, paramLong1, paramLong2, paramLong, paramString4, paramLong3, paramLong4, paramString6, paramLong5, paramString3, bool, paramString5, str, (String)localObject));
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, long paramLong, msg_comm.MsgHead paramMsgHead)
  {
    long l3 = paramMsgHead.msg_seq.get();
    String str1 = paramQQAppInterface.getCurrentAccountUin();
    Long localLong = Long.valueOf(Long.parseLong(str1));
    String str2 = String.valueOf(paramLong);
    msg_comm.ExtGroupKeyInfo localExtGroupKeyInfo = (msg_comm.ExtGroupKeyInfo)paramMsgHead.ext_group_key_info.get();
    long l4 = localExtGroupKeyInfo.cur_max_seq.get();
    long l5 = localExtGroupKeyInfo.cur_time.get();
    Object localObject2 = new BroadcastMsgCtr.ExtGroupInfo();
    boolean bool = localExtGroupKeyInfo.bytes_ext_group_info.has();
    int i = 0;
    long l1;
    if (bool) {
      try
      {
        ((BroadcastMsgCtr.ExtGroupInfo)localObject2).mergeFrom(localExtGroupKeyInfo.bytes_ext_group_info.get().toByteArray());
        if (((BroadcastMsgCtr.ExtGroupInfo)localObject2).ext_join_group_info.has())
        {
          l1 = ((BroadcastMsgCtr.ExtGroupInfo)localObject2).ext_join_group_info.uint64_share_uin.get();
          try
          {
            i = ((BroadcastMsgCtr.ExtGroupInfo)localObject2).ext_join_group_info.enmum_join_group_type.get();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
          {
            break label168;
          }
        }
        else
        {
          l1 = 0L;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
      {
        l1 = 0L;
        label168:
        localInvalidProtocolBufferMicroException2.printStackTrace();
        break label179;
      }
    } else {
      l1 = 0L;
    }
    label179:
    i = 0;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("0x21 troopUin = ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" maxseq = ");
      ((StringBuilder)localObject1).append(l4);
      ((StringBuilder)localObject1).append(", maxTime = ");
      ((StringBuilder)localObject1).append(l5);
      ((StringBuilder)localObject1).append(", member = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", adminUin");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", cOpt");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("GrayTipsForTroop", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(paramMsgHead.auth_uin.get());
    localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = paramMsgHead.auth_nick.get();
    paramMsgHead.auth_sex.get();
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject2).equals(paramString1))) {
      paramMsgHead = (msg_comm.MsgHead)localObject1;
    } else {
      paramMsgHead = "";
    }
    if ((!TextUtils.isEmpty(str1)) && (str1.equals(paramString1)))
    {
      HardCodeUtil.a(2131701499);
      return;
    }
    if (TextUtils.isEmpty(paramMsgHead)) {
      paramMsgHead = MessageHandlerUtils.a(paramQQAppInterface, paramString1, str2);
    }
    long l2;
    try
    {
      l2 = Long.parseLong((String)localObject2);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("senderUin=");
      localStringBuilder.append(0L);
      QLog.e("GrayTipsForTroop", 1, localStringBuilder.toString(), localException);
      l2 = paramLong;
    }
    if ((paramInt != -126) && (paramInt != 2))
    {
      if ((paramInt == -125) || (paramInt == 3)) {
        a(paramQQAppInterface, paramInt, paramString1, paramString2, paramLong, l3, str1, localLong, str2, l4, l5, (String)localObject2, paramMsgHead, l2);
      }
    }
    else {
      a(paramQQAppInterface, paramInt, paramString1, paramLong, l3, str1, localLong, str2, l4, l5, l1, i, paramMsgHead, l2);
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    return MessageHandlerUtils.a(paramQQAppInterface, paramMessageRecord, false);
  }
  
  @NotNull
  public MessageForGrayTips a(QQAppInterface paramQQAppInterface, String paramString1, long paramLong1, long paramLong2, Long paramLong, String paramString2, long paramLong3, long paramLong4, long paramLong5, String paramString3, long paramLong6, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean, String paramString8, TroopInfo paramTroopInfo)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1012);
    localMessageForGrayTips.init(paramLong.longValue(), paramLong1, paramLong6, paramString4, paramLong4, -1012, 1, paramLong2);
    localMessageForGrayTips.shmsgseq = paramLong3;
    localMessageForGrayTips.switch2HightlightMsg();
    paramLong = new Bundle();
    paramLong.putInt("key_action", 5);
    paramLong.putString("troop_mem_uin", paramString1);
    paramLong.putBoolean("need_update_nick", false);
    localMessageForGrayTips.addHightlightItem(0, paramString3.length(), paramLong);
    localMessageForGrayTips.saveExtInfoToExtStr("troop_new_member_uin", paramString1);
    if ((!TextUtils.isEmpty(paramString7)) && (!paramBoolean))
    {
      paramLong = new Bundle();
      paramLong.putInt("key_action", 5);
      paramLong.putString("troop_mem_uin", String.valueOf(paramLong5));
      paramLong.putBoolean("need_update_nick", false);
      localMessageForGrayTips.addHightlightItem(paramString8.length(), paramString8.length() + paramString7.length(), paramLong);
      localMessageForGrayTips.saveExtInfoToExtStr("troop_new_member_uin", String.valueOf(paramLong5));
    }
    if ((paramTroopInfo != null) && (paramTroopInfo.cGroupOption == 2))
    {
      if (a(paramString2, paramQQAppInterface))
      {
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putInt("key_action", 19);
        paramQQAppInterface.putString("troop_mem_uin", paramString1);
        paramQQAppInterface.putString("troopUin", paramString2);
        localMessageForGrayTips.addHightlightItem(paramString4.length() - paramString5.length(), paramString4.length(), paramQQAppInterface);
      }
    }
    else
    {
      paramQQAppInterface = new Bundle();
      paramQQAppInterface.putInt("key_action", 48);
      paramQQAppInterface.putString("troop_mem_uin", paramString1);
      paramQQAppInterface.putString("troopUin", paramString2);
      localMessageForGrayTips.addHightlightItem(paramString4.length() - paramString6.length(), paramString4.length(), paramQQAppInterface);
    }
    localMessageForGrayTips.isread = true;
    return localMessageForGrayTips;
  }
  
  @NotNull
  public MessageForGrayTips a(String paramString1, String paramString2, long paramLong1, long paramLong2, Long paramLong, String paramString3, long paramLong3, long paramLong4, String paramString4, long paramLong5, String paramString5, boolean paramBoolean, String paramString6, String paramString7, String paramString8)
  {
    MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(-1012);
    localMessageForGrayTips.init(paramLong.longValue(), paramLong1, paramLong5, paramString7, paramLong4, -1012, 1, paramLong2);
    localMessageForGrayTips.switch2HightlightMsg();
    localMessageForGrayTips.shmsgseq = paramLong3;
    if (!paramBoolean)
    {
      paramLong = new Bundle();
      paramLong.putInt("key_action", 5);
      paramLong.putString("troop_mem_uin", paramString2);
      paramLong.putBoolean("need_update_nick", false);
      localMessageForGrayTips.addHightlightItem(0, paramString5.length(), paramLong);
    }
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 5);
    paramString2.putString("troop_mem_uin", paramString1);
    paramString2.putBoolean("need_update_nick", false);
    localMessageForGrayTips.addHightlightItem(paramString6.length(), paramString6.length() + paramString4.length(), paramString2);
    localMessageForGrayTips.saveExtInfoToExtStr("troop_new_member_uin", paramString1);
    paramString2 = new Bundle();
    paramString2.putInt("key_action", 48);
    paramString2.putString("troop_mem_uin", paramString1);
    paramString2.putString("troopUin", paramString3);
    localMessageForGrayTips.addHightlightItem(paramString7.length() - paramString8.length(), paramString7.length(), paramString2);
    localMessageForGrayTips.isread = true;
    return localMessageForGrayTips;
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, DecodeProtoPkgContext paramDecodeProtoPkgContext)
  {
    paramList = (msg_comm.MsgHead)paramMsg.msg_head.get();
    Object localObject = ((im_msg_body.MsgBody)paramMsg.msg_body.get()).msg_content.get().toByteArray();
    long l1 = Utils.a((byte[])localObject, 0);
    int i = localObject[4];
    paramMsg = String.valueOf(Utils.a((byte[])localObject, 5));
    i = localObject[9];
    long l2 = Utils.a((byte[])localObject, 10);
    int j = localObject[14];
    try
    {
      new String((byte[])localObject, 15, j, "GBK");
    }
    catch (Exception localException)
    {
      label99:
      break label99;
    }
    new String((byte[])localObject, 15, j);
    if (!paramDecodeProtoPkgContext.d)
    {
      a(paramMessageHandler.a, i, paramMsg, String.valueOf(l2), l1, paramList);
      paramDecodeProtoPkgContext = (ITroopOnlinePushHandler)paramMessageHandler.a.getBusinessHandler(BusinessHandlerFactory.TROOP_ONLINE_PUSH_HANDLER);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("");
      paramDecodeProtoPkgContext.a(((StringBuilder)localObject).toString(), paramMsg, paramList.auth_nick.get());
      paramMsg = new ArrayList();
      paramMsg.add(new Pair(Long.valueOf(paramList.from_uin.get()), Long.valueOf(paramList.msg_time.get())));
      ((C2CMessageProcessor)paramMessageHandler.a("c2c_processor")).a(paramMsg);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, long paramLong1, long paramLong2, Long paramLong, String paramString2, String paramString3, MessageForGrayTips paramMessageForGrayTips)
  {
    TroopTipsMsgMgr localTroopTipsMsgMgr = (TroopTipsMsgMgr)paramQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER);
    if (!a(paramMessageForGrayTips, paramQQAppInterface))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("");
      if (!localTroopTipsMsgMgr.a(localStringBuilder.toString(), paramLong2))
      {
        bool = false;
        break label74;
      }
    }
    boolean bool = true;
    label74:
    if (!bool)
    {
      paramQQAppInterface.getMessageFacade().a(paramMessageForGrayTips, String.valueOf(paramLong));
      paramLong = ((ITroopBatchAddFriendService)paramQQAppInterface.getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
      if ((paramLong.b("newMember")) && (paramLong.a(paramString2))) {
        paramLong.c(paramString2, paramString1);
      }
      paramString1 = new ReportTask(paramQQAppInterface).a("dc00899").b("Grp_AIO").c("newman_join").d("exp_bar");
      paramLong = new StringBuilder();
      paramLong.append("");
      paramLong.append(TroopUtils.b(paramQQAppInterface, paramString2));
      paramString1.a(new String[] { paramString2, "", paramLong.toString() }).a();
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder("seq:");
      paramQQAppInterface.append(paramLong2);
      paramQQAppInterface.append("|cOpt:");
      paramQQAppInterface.append(paramInt);
      paramQQAppInterface.append("|tips:");
      paramQQAppInterface.append(paramString3);
      paramQQAppInterface.append("|msgFilter:");
      paramQQAppInterface.append(bool);
      QLog.d("TroopAddMemberBroadcast", 2, paramQQAppInterface.toString());
    }
  }
  
  protected boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramQQAppInterface == null) {
      return false;
    }
    paramString = paramQQAppInterface.b(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.isAdmin();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.TroopAddMemberBroadcastDecoder
 * JD-Core Version:    0.7.0.1
 */