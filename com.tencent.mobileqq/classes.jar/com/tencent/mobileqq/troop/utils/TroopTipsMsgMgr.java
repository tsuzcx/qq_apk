package com.tencent.mobileqq.troop.utils;

import ajye;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgDbManager;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.ApolloPushManager;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.C2CMessageProcessor.Parse0x2dcContext;
import com.tencent.mobileqq.app.message.MsgProxy;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef;
import tencent.im.msgrevoke.msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef;
import tencent.im.oidb.cmd0x857.TroopTips0x857.AIOGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GroupNotifyInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x857.TroopTips0x857.RedGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class TroopTipsMsgMgr
  implements Manager
{
  protected static HashMap a;
  protected QQAppInterface a;
  public ArrayList a;
  protected Queue a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public TroopTipsMsgMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(MessageForGrayTips paramMessageForGrayTips, String paramString)
  {
    if ((paramMessageForGrayTips == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    for (;;)
    {
      int i;
      String str;
      Bundle localBundle;
      try
      {
        JSONArray localJSONArray = new JSONArray(paramString);
        i = 0;
        if (i >= localJSONArray.length()) {
          break;
        }
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        int k = localJSONObject.getInt("startIndex");
        int m = localJSONObject.optInt("endIndex");
        if (m <= 0) {
          break label375;
        }
        if (!localJSONObject.has("cmd")) {
          break label370;
        }
        j = localJSONObject.getInt("cmd");
        paramString = "";
        if (localJSONObject.has("data")) {
          paramString = localJSONObject.getString("data");
        }
        str = null;
        if (localJSONObject.has("data_a")) {
          str = localJSONObject.getString("data_a");
        }
        if (localJSONObject.has("url")) {
          paramString = localJSONObject.getString("url");
        }
        localBundle = new Bundle();
        localBundle.putInt("key_action", j);
        switch (j)
        {
        case 4: 
          if (localJSONObject.has("icon"))
          {
            localBundle.putString("image_resource", localJSONObject.optString("icon"));
            localBundle.putString("image_alt", localJSONObject.optString("alt"));
          }
          if (localJSONObject.has("textColor")) {
            localBundle.putString("textColor", localJSONObject.getString("textColor"));
          }
          paramMessageForGrayTips.addHightlightItem(k, m, localBundle);
        }
      }
      catch (JSONException paramMessageForGrayTips) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TroopTipsMsgMgr", 2, "addGrayTips==>JSONException");
      return;
      localBundle.putString("key_action_DATA", paramString);
      localBundle.putString("key_a_action_DATA", str);
      continue;
      localBundle.putString("troop_mem_uin", paramString);
      localBundle.putBoolean("need_update_nick", true);
      continue;
      label370:
      int j = -1;
      continue;
      label375:
      i += 1;
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "setUnreadAIOGrayTips");
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1 + "_" + paramString2, Boolean.valueOf(true));
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Boolean.valueOf(true));
    boolean bool = localEntityManager.a(TroopTipsEntity.class.getSimpleName(), localContentValues, "troopUin=? and msgSeq=?", new String[] { paramString1, paramString2 });
    localEntityManager.a();
    if (bool)
    {
      QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips ok troopUin:" + paramString1 + "msgSeq:" + paramString2);
      jdField_a_of_type_JavaUtilHashMap.remove(paramString1 + "_" + paramString2);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips error");
  }
  
  public MessageForGrayTips a(TroopTipsEntity paramTroopTipsEntity)
  {
    Object localObject;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramTroopTipsEntity == null)) {
      localObject = null;
    }
    MessageForGrayTips localMessageForGrayTips;
    do
    {
      ArrayList localArrayList;
      do
      {
        return localObject;
        localArrayList = new ArrayList();
        localMessageForGrayTips = b(paramTroopTipsEntity);
        localObject = localMessageForGrayTips;
      } while (MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageForGrayTips, false));
      localArrayList.add(localMessageForGrayTips);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = localMessageForGrayTips;
    } while (paramTroopTipsEntity.uinType != 1);
    b(paramTroopTipsEntity.troopUin, paramTroopTipsEntity.msgSeq + "");
    return localMessageForGrayTips;
  }
  
  public MessageForGrayTips a(String paramString1, String paramString2, long paramLong1, long paramLong2, int paramInt1, int paramInt2)
  {
    TroopTipsEntity localTroopTipsEntity = new TroopTipsEntity();
    localTroopTipsEntity.troopUin = paramString1;
    localTroopTipsEntity.time = paramLong1;
    localTroopTipsEntity.expireTime = paramLong2;
    localTroopTipsEntity.msgSeq = paramInt1;
    localTroopTipsEntity.tipsPromptType = 1;
    localTroopTipsEntity.currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localTroopTipsEntity.optContent = paramString2;
    localTroopTipsEntity.optShowLatest = 1;
    localTroopTipsEntity.uinType = paramInt2;
    a(localTroopTipsEntity);
    return a(localTroopTipsEntity);
  }
  
  public MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, C2CMessageProcessor.Parse0x2dcContext paramParse0x2dcContext)
  {
    if (paramArrayOfByte == null)
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    Object localObject1 = new TroopTips0x857.NotifyMsgBody();
    for (;;)
    {
      try
      {
        localObject2 = (TroopTips0x857.NotifyMsgBody)((TroopTips0x857.NotifyMsgBody)localObject1).mergeFrom(paramArrayOfByte);
        if (localObject2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> notifyMsgBody == null");
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> msgSeq:" + paramInt);
          }
          i = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_enum_type.get();
          j = ((TroopTips0x857.NotifyMsgBody)localObject2).uint32_service_type.get();
          l2 = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_group_code.get();
          if (a(l2 + "", paramInt)) {
            return null;
          }
          long l1 = paramLong;
          if (paramLong == 0L) {
            l1 = NetConnInfoCenter.getServerTime();
          }
          paramLong = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_msg_expires.get();
          if ((paramLong != 0L) && (NetConnInfoCenter.getServerTime() >= paramLong))
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> time expried!! promptType:" + i);
            continue;
          }
          localObject1 = new TroopTipsEntity();
          ((TroopTipsEntity)localObject1).troopUin = String.valueOf(l2);
          ((TroopTipsEntity)localObject1).time = l1;
          ((TroopTipsEntity)localObject1).expireTime = paramLong;
          ((TroopTipsEntity)localObject1).msgSeq = paramInt;
          ((TroopTipsEntity)localObject1).isOfflineMsg = paramBoolean1;
          switch (i)
          {
          case 1: 
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_redtips.has())
            {
              paramArrayOfByte = (TroopTips0x857.RedGrayTipsInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_redtips.get();
              if (paramQQAppInterface.a.b())
              {
                a(new ajye(this, ((TroopTipsEntity)localObject1).troopUin, paramArrayOfByte));
                return null;
              }
              ((TroopTipsEntity)localObject1).currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              paramQQAppInterface = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
              paramQQAppInterface.senderUin = (paramArrayOfByte.uint64_sender_uin.get() + "");
              paramQQAppInterface.reciverUin = (paramArrayOfByte.uint64_receiver_uin.get() + "");
              paramQQAppInterface.senderContent = paramArrayOfByte.bytes_sender_rich_content.get().toStringUtf8();
              paramQQAppInterface.reciverContent = paramArrayOfByte.bytes_receiver_rich_content.get().toStringUtf8();
              paramQQAppInterface.authKey = paramArrayOfByte.bytes_authkey.get().toStringUtf8();
              paramQQAppInterface.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((TroopTipsEntity)localObject1).troopUin, "", "[QQWallet Tips]", MessageCache.a(), -2029, 1, MessageCache.a());
              paramQQAppInterface.isread = true;
              paramQQAppInterface.getBytes();
              paramQQAppInterface.onReceiveGrapTips();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramQQAppInterface, ((TroopTipsEntity)localObject1).currentUin);
              return null;
            }
            ((TroopTipsEntity)localObject1).tipsPromptType = 1;
            ((TroopTipsEntity)localObject1).currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            ((TroopTipsEntity)localObject1).optContent = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_bytes_content.get().toStringUtf8();
            ((TroopTipsEntity)localObject1).grayTipsRemindFlag = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_uint32_remind.get();
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_bytes_brief.has()) {
              ((TroopTipsEntity)localObject1).grayTipsSummary = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_bytes_brief.get().toStringUtf8();
            }
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.uint32_robot_group_opt.has())
            {
              if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.uint32_robot_group_opt.get() == 1)
              {
                paramBoolean2 = true;
                ((TroopRobotManager)paramQQAppInterface.getManager(202)).a("" + l2, paramBoolean2);
              }
            }
            else
            {
              if (TextUtils.isEmpty(((TroopTipsEntity)localObject1).optContent)) {
                return null;
              }
              ((TroopTipsEntity)localObject1).optShowLatest = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_uint32_show_lastest.get();
              ((TroopTipsEntity)localObject1).serviceType = j;
              a((TroopTipsEntity)localObject1);
              if (j == 3)
              {
                HWTroopUtils.a(paramQQAppInterface, (TroopTipsEntity)localObject1);
                return null;
              }
              if ((j == 6) && (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.uint64_receiver_uin.has()))
              {
                paramLong = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.uint64_receiver_uin.get();
                if (QLog.isColorLevel()) {
                  QLog.d("TroopRankConfig", 2, "handle0x2dcSubType0x10Msg, grayTipsReceiverUin=" + paramLong);
                }
                if (String.valueOf(paramLong).equals(paramQQAppInterface.getCurrentAccountUin()))
                {
                  TroopRankConfig.a().a(String.valueOf(l2), paramQQAppInterface.getCurrentAccountUin(), true);
                  ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(l2, paramLong);
                }
                paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopTipsEntity)localObject1).troopUin, (TroopTipsEntity)localObject1);
                if ((!paramBoolean1) && (MessageHandlerUtils.a(paramQQAppInterface, paramArrayOfByte, false))) {
                  return null;
                }
              }
              else
              {
                if (j != 11) {
                  continue;
                }
                ((TroopTipsEntity)localObject1).repeatInterval = 10;
                continue;
              }
            }
            break;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject2;
        int i;
        int j;
        long l2;
        paramQQAppInterface.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 Exception " + paramQQAppInterface.getStackTrace());
          continue;
          paramQQAppInterface = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            break;
          }
          paramArrayOfByte.saveExtInfoToExtStr("gray_tips_serviceType", j + "");
          return paramArrayOfByte;
          if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_group_notify.has())
          {
            paramQQAppInterface = (TroopTips0x857.GroupNotifyInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_group_notify.get();
            paramArrayOfByte = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(36)).a(Long.valueOf(l2), true);
            if ((paramArrayOfByte != null) && (1 == paramQQAppInterface.opt_uint32_auto_pull_flag.get()))
            {
              paramArrayOfByte.a(paramQQAppInterface.opt_bytes_feeds_id.get().toStringUtf8(), Integer.valueOf(paramQQAppInterface.opt_uint32_auto_pull_flag.get()));
              ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).a(67, true, new Object[] { String.valueOf(l2), paramQQAppInterface.opt_bytes_feeds_id.get().toStringUtf8(), Integer.valueOf(paramQQAppInterface.opt_uint32_auto_pull_flag.get()) });
              continue;
              if (!paramBoolean2)
              {
                if (paramParse0x2dcContext != null) {
                  paramParse0x2dcContext.a = false;
                }
                if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_recall.has())
                {
                  paramParse0x2dcContext = (TroopTips0x857.MessageRecallReminder)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_recall.get();
                  paramLong = paramParse0x2dcContext.uint64_uin.get();
                  paramInt = paramParse0x2dcContext.uint32_op_type.get();
                  paramQQAppInterface = new HashMap();
                  try
                  {
                    paramArrayOfByte = new msgrevoke_userdef.MsgInfoUserDef();
                    paramArrayOfByte.mergeFrom(paramParse0x2dcContext.bytes_userdef.get().toByteArray());
                    i = paramArrayOfByte.uint32_long_message_flag.get();
                    if (i != 1) {
                      continue;
                    }
                    paramArrayOfByte = ((ArrayList)paramArrayOfByte.long_msg_info.get()).iterator();
                    if (!paramArrayOfByte.hasNext()) {
                      continue;
                    }
                    localObject1 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramArrayOfByte.next();
                    paramQQAppInterface.put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject1).uint32_msg_seq.get()), localObject1);
                    continue;
                    QLog.d("revokeMsg", 2, "recv 0x2dc_0x11 msg, parse msgInfoUserDef error");
                  }
                  catch (Exception paramQQAppInterface)
                  {
                    if (!QLog.isColorLevel()) {
                      break label2041;
                    }
                  }
                  break label2041;
                  paramArrayOfByte = new ArrayList();
                  paramParse0x2dcContext = ((ArrayList)paramParse0x2dcContext.uint32_recalled_msg_list.get()).iterator();
                  if (paramParse0x2dcContext.hasNext())
                  {
                    localObject2 = (TroopTips0x857.MessageRecallReminder.MessageMeta)paramParse0x2dcContext.next();
                    localObject1 = new RevokeMsgInfo();
                    ((RevokeMsgInfo)localObject1).jdField_b_of_type_JavaLangString = String.valueOf(paramLong);
                    ((RevokeMsgInfo)localObject1).jdField_a_of_type_JavaLangString = String.valueOf(l2);
                    ((RevokeMsgInfo)localObject1).jdField_a_of_type_Int = 1;
                    ((RevokeMsgInfo)localObject1).jdField_a_of_type_Long = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject2).uint32_seq.get();
                    ((RevokeMsgInfo)localObject1).jdField_c_of_type_Long = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject2).uint32_time.get();
                    ((RevokeMsgInfo)localObject1).jdField_d_of_type_JavaLangString = String.valueOf(((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject2).uint64_author_uin.get());
                    ((RevokeMsgInfo)localObject1).e = paramInt;
                    if (i == 1)
                    {
                      localObject2 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramQQAppInterface.get(Integer.valueOf(((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject2).uint32_seq.get()));
                      ((RevokeMsgInfo)localObject1).jdField_b_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).long_msg_id.get();
                      ((RevokeMsgInfo)localObject1).jdField_c_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).long_msg_num.get();
                      ((RevokeMsgInfo)localObject1).jdField_d_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).long_msg_index.get();
                    }
                    paramArrayOfByte.add(localObject1);
                    if (!QLog.isColorLevel()) {
                      continue;
                    }
                    QLog.d("revokeMsg", 2, "recv 0x2dc_0x11 msg," + ((RevokeMsgInfo)localObject1).toString());
                    continue;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramArrayOfByte, false);
                  return null;
                  if (QLog.isColorLevel()) {
                    QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate push message");
                  }
                  if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_objmsg_update.has())
                  {
                    paramParse0x2dcContext = (TroopTips0x857.NotifyObjmsgUpdate)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_objmsg_update.get();
                    if (paramParse0x2dcContext.bytes_ext_msg.has())
                    {
                      paramArrayOfByte = new SubMsgType0xaa.MsgBody();
                      try
                      {
                        paramArrayOfByte.mergeFrom(paramParse0x2dcContext.bytes_ext_msg.get().toByteArray());
                        ((GamePartyManager)paramQQAppInterface.getManager(155)).a(paramArrayOfByte, false);
                      }
                      catch (Exception paramParse0x2dcContext)
                      {
                        if (!QLog.isColorLevel()) {
                          continue;
                        }
                        QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate, prase msgBody error");
                        continue;
                      }
                      if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_werewolf_push.has())
                      {
                        if (QLog.isColorLevel()) {
                          QLog.d("Q.werewolf", 2, "recv 0x857_werewolfPush");
                        }
                        ((WerewolvesHandler)paramQQAppInterface.a(107)).a((TroopTips0x857.WereWolfPush)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_werewolf_push.get(), paramArrayOfByte);
                        continue;
                        if (QLog.isColorLevel()) {
                          QLog.d("ApolloGameManager", 2, "recv 0x857_gameStatusNotify push message.[troop]");
                        }
                        if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_stcm_game_state.has())
                        {
                          paramQQAppInterface = (apollo_game_status.STCMGameMessage)((TroopTips0x857.NotifyMsgBody)localObject2).opt_stcm_game_state.get();
                          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                          {
                            ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(210)).a(0, 1, Long.toString(l2), paramQQAppInterface);
                            continue;
                            if (QLog.isColorLevel()) {
                              QLog.d("ApolloPushManager", 2, "recv action push message, [troop]");
                            }
                            if (((TroopTips0x857.NotifyMsgBody)localObject2).apllo_msg_push.has())
                            {
                              paramArrayOfByte = (apollo_push_msgInfo.STPushMsgElem)((TroopTips0x857.NotifyMsgBody)localObject2).apllo_msg_push.get();
                              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
                              {
                                ((ApolloPushManager)paramQQAppInterface.getManager(226)).a(1, paramArrayOfByte);
                                continue;
                                if (QLog.isColorLevel()) {
                                  QLog.d("GoldMsgChatHelper", 2, "recv action push message, [troop]");
                                }
                                if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.has())
                                {
                                  paramQQAppInterface = (TroopTips0x857.GoldMsgTipsElem)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.get();
                                  if ((paramQQAppInterface.type.has()) && (paramQQAppInterface.type.get() == 3))
                                  {
                                    NotifyMsgManager.a(1, (TroopTips0x857.GoldMsgTipsElem)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.get(), null);
                                  }
                                  else
                                  {
                                    GoldMsgDbManager.a(1, Long.toString(l2), (TroopTips0x857.GoldMsgTipsElem)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.get(), null);
                                    continue;
                                    return null;
                                    return null;
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        return null;
      }
      paramBoolean2 = false;
    }
    label2041:
    return null;
  }
  
  public List a(String paramString)
  {
    if (paramString == null) {}
    Object localObject;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    do
    {
      return null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      paramString = ((EntityManager)localObject).a(TroopTipsEntity.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, null, null, "time ASC", null);
      ((EntityManager)localObject).a();
    } while (paramString == null);
    int i = 0;
    if (i < paramString.size())
    {
      localObject = (TroopTipsEntity)paramString.get(i);
      if ((((TroopTipsEntity)localObject).expireTime != 0L) && (NetConnInfoCenter.getServerTime() >= ((TroopTipsEntity)localObject).expireTime)) {}
      for (;;)
      {
        i += 1;
        break;
        if (((TroopTipsEntity)localObject).optShowLatest == 1) {
          localArrayList2.add(localObject);
        } else {
          localArrayList1.add(localObject);
        }
      }
    }
    localArrayList1.addAll(localArrayList2);
    return localArrayList1;
  }
  
  public void a(ajye paramajye)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "addWalletTipsCache");
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramajye);
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "handleWalletTipsCache, size: " + this.jdField_a_of_type_JavaUtilArrayList.size());
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      ajye localajye = (ajye)localIterator.next();
      TroopTips0x857.RedGrayTipsInfo localRedGrayTipsInfo = localajye.jdField_a_of_type_TencentImOidbCmd0x857TroopTips0x857$RedGrayTipsInfo;
      String str = paramQQAppInterface.getCurrentAccountUin();
      MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
      localMessageForQQWalletTips.senderUin = (localRedGrayTipsInfo.uint64_sender_uin.get() + "");
      localMessageForQQWalletTips.reciverUin = (localRedGrayTipsInfo.uint64_receiver_uin.get() + "");
      localMessageForQQWalletTips.senderContent = localRedGrayTipsInfo.bytes_sender_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.reciverContent = localRedGrayTipsInfo.bytes_receiver_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.authKey = localRedGrayTipsInfo.bytes_authkey.get().toStringUtf8();
      localMessageForQQWalletTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localajye.jdField_a_of_type_JavaLangString, "", "[QQWallet Tips]", MessageCache.a(), -2029, 1, MessageCache.a());
      localMessageForQQWalletTips.isread = true;
      localMessageForQQWalletTips.getBytes();
      localMessageForQQWalletTips.onReceiveGrapTips();
      paramQQAppInterface.a().a(localMessageForQQWalletTips, str);
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(QQAppInterface paramQQAppInterface, TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "saveTroopTips");
    }
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    paramTroopTipsEntity.read = false;
    paramTroopTipsEntity.currentUin = paramQQAppInterface.getCurrentAccountUin();
    a(paramTroopTipsEntity.troopUin, paramTroopTipsEntity.msgSeq + "");
    localEntityManager.a(paramTroopTipsEntity);
    localEntityManager.a();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {}
    for (;;)
    {
      return;
      List localList = a(paramString);
      if ((localList != null) && (localList.size() != 0))
      {
        Object localObject = new SparseIntArray();
        int i = localList.size() - 1;
        if (i >= 0)
        {
          TroopTipsEntity localTroopTipsEntity = (TroopTipsEntity)localList.get(i);
          if ((localTroopTipsEntity.repeatInterval > 0) && (((SparseIntArray)localObject).get(localTroopTipsEntity.serviceType, 0) > 0))
          {
            b(localTroopTipsEntity.troopUin, localTroopTipsEntity.msgSeq + "");
            localList.remove(localTroopTipsEntity);
          }
          for (;;)
          {
            i -= 1;
            break;
            ((SparseIntArray)localObject).put(localTroopTipsEntity.serviceType, ((SparseIntArray)localObject).get(localTroopTipsEntity.serviceType, 0) + 1);
          }
        }
        if (localList.size() > 0)
        {
          paramQQAppInterface = paramQQAppInterface.a(1).b(paramString, 1);
          int j;
          label202:
          int k;
          label245:
          int m;
          if (paramQQAppInterface == null)
          {
            i = 0;
            j = localList.size() - 1;
            if ((j < 0) || (i <= 0)) {
              break label426;
            }
            paramString = (TroopTipsEntity)localList.get(j);
            if (paramString.repeatInterval > 0)
            {
              if (paramString.repeatInterval >= i) {
                break label406;
              }
              k = paramString.repeatInterval;
              m = 0;
            }
          }
          for (;;)
          {
            if (m < k)
            {
              localObject = (MessageRecord)paramQQAppInterface.get(i - k + m);
              if ((((MessageRecord)localObject).msgtype != 2024) || (!String.valueOf(paramString.serviceType).equals(((MessageRecord)localObject).getExtInfoFromExtStr("gray_tips_serviceType")))) {
                break label417;
              }
              b(paramString.troopUin, paramString.msgSeq + "");
              localList.remove(j);
              if (QLog.isColorLevel()) {
                QLog.i("TroopTipsMsgMgr", 2, String.format("addGrayTipsIntoMessageListIfNeeded discard seq:%s interval:%d", new Object[] { Long.valueOf(paramString.msgSeq), Integer.valueOf(paramString.repeatInterval) }));
              }
            }
            j -= 1;
            break label202;
            i = paramQQAppInterface.size();
            break;
            label406:
            k = paramQQAppInterface.size();
            break label245;
            label417:
            m += 1;
          }
        }
        label426:
        paramQQAppInterface = localList.iterator();
        while (paramQQAppInterface.hasNext()) {
          a((TroopTipsEntity)paramQQAppInterface.next());
        }
      }
    }
  }
  
  public void a(TroopTipsEntity paramTroopTipsEntity)
  {
    int i = 0;
    if ((paramTroopTipsEntity == null) || (paramTroopTipsEntity.optContent == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("TroopTipsMsgMgr", 2, "decodeContent ===> entity == null || content == null");
      }
    }
    JSONArray localJSONArray;
    label1154:
    do
    {
      return;
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramTroopTipsEntity.optContent);
      paramTroopTipsEntity.highlightNum = 0;
      localJSONArray = new JSONArray();
      Object localObject1 = "";
      int j = 0;
      String str2;
      for (;;)
      {
        if (!localMatcher.find()) {
          break label1154;
        }
        j += 1;
        paramTroopTipsEntity.highlightNum = j;
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsMsgMgr", 2, "match count=====>" + j);
        }
        int m = localMatcher.start();
        int k = localMatcher.end();
        String str1 = paramTroopTipsEntity.optContent.substring(m + 1, k);
        str2 = paramTroopTipsEntity.optContent.substring(i, m);
        localObject1 = (String)localObject1 + str2;
        m = ((String)localObject1).length();
        i = k + 1;
        for (;;)
        {
          try
          {
            localStringBuilder = new StringBuilder();
            localJSONObject = new JSONObject(str1);
            localJSONObject.put("startIndex", m);
            if (localJSONObject.has("uin"))
            {
              str1 = localJSONObject.get("uin").toString();
              str2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a(paramTroopTipsEntity.troopUin, str1);
              if (str2 == null) {
                continue;
              }
              str1 = (String)localObject1 + str2;
              localObject1 = str1;
            }
          }
          catch (JSONException localJSONException2)
          {
            StringBuilder localStringBuilder;
            JSONObject localJSONObject;
            boolean bool;
            String str3;
            Object localObject2;
            continue;
            Object localObject4 = localObject2;
            continue;
            localObject4 = localObject2;
            continue;
            localObject4 = localObject2;
            continue;
          }
          try
          {
            localJSONObject.put("endIndex", str2.length() + m);
            localObject1 = str1;
            localStringBuilder.append("text==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
            localObject1 = str1;
            bool = localJSONObject.has("cmd");
            if (bool) {
              localObject1 = str1;
            }
          }
          catch (JSONException localJSONException1) {}
          try
          {
            k = Integer.parseInt(localJSONObject.get("cmd").toString());
            localObject1 = str1;
            localJSONObject.put("cmd", k);
            localObject1 = str1;
            localStringBuilder.append(",cmd==>");
            localObject1 = str1;
            localStringBuilder.append(k);
          }
          catch (NumberFormatException localNumberFormatException)
          {
            localObject2 = localObject3;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject2 = localObject3;
            QLog.e("TroopTipsMsgMgr", 2, "decodeContent==>NumberFormatException");
            continue;
            localObject2 = str2;
            localJSONArray.put(localJSONObject);
            localObject2 = str2;
            Object localObject3 = str2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            localObject2 = str2;
            QLog.d("TroopTipsMsgMgr", 2, "decodeContent==>" + localStringBuilder.toString());
            localObject3 = str2;
            continue;
          }
          localObject1 = str1;
          if (localJSONObject.has("textColor"))
          {
            localObject1 = str1;
            str2 = localJSONObject.getString("textColor");
            localObject1 = str1;
            localJSONObject.put("textColor", str2);
            localObject1 = str1;
            localStringBuilder.append(",textColor==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("data"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("data").toString();
            localObject1 = str1;
            localJSONObject.put("data", str2);
            localObject1 = str1;
            localStringBuilder.append(",data==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("data_a"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("data_a").toString();
            localObject1 = str1;
            localJSONObject.put("data_a", str2);
            localObject1 = str1;
            localStringBuilder.append(",data_a==>");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("url"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("url").toString();
            localObject1 = str1;
            localJSONObject.put("url", str2);
            localObject1 = str1;
            localStringBuilder.append(",url:");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          if (localJSONObject.has("icon"))
          {
            localObject1 = str1;
            str2 = localJSONObject.get("icon").toString();
            localObject1 = str1;
            localJSONObject.put("icon", str2);
            localObject1 = str1;
            localStringBuilder.append(",icon:");
            localObject1 = str1;
            localStringBuilder.append(str2);
          }
          localObject1 = str1;
          str2 = str1;
          if (!localJSONObject.has("alt")) {
            continue;
          }
          localObject1 = str1;
          str3 = localJSONObject.get("alt").toString();
          str2 = str1;
          if (str3 == null) {
            continue;
          }
          localObject1 = str1;
          str2 = "[" + str3 + "]";
          localObject1 = str1;
          str1 = str1 + str2;
          localObject1 = str1;
          localJSONObject.put("endIndex", m + str2.length());
          localObject1 = str1;
          localStringBuilder.append(",alt:");
          localObject1 = str1;
          localStringBuilder.append(str2);
          localObject1 = str1;
          bool = paramTroopTipsEntity.isSupportImage;
          str2 = str1;
          if (bool) {
            continue;
          }
          localObject1 = str1;
          break;
          if (!localJSONObject.has("text")) {
            continue;
          }
          str2 = localJSONObject.get("text").toString();
          if (str2 == null) {
            continue;
          }
          str1 = (String)localObject1 + str2;
          localObject1 = str1;
          localJSONObject.put("endIndex", str2.length() + m);
          localObject1 = str1;
          localStringBuilder.append("text==>");
          localObject1 = str1;
          localStringBuilder.append(str2);
        }
        localObject3 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("TroopTipsMsgMgr", 2, "decodeContent:JSONException");
          localObject3 = localObject1;
        }
        localObject1 = localObject3;
      }
      paramTroopTipsEntity.optContent = (localObject2 + paramTroopTipsEntity.optContent.substring(i, paramTroopTipsEntity.optContent.length()));
    } while (paramTroopTipsEntity.highlightNum == 0);
    paramTroopTipsEntity.highlightItems = localJSONArray.toString();
  }
  
  public boolean a(String paramString)
  {
    return !jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
  
  public boolean a(String paramString, long paramLong)
  {
    paramString = paramString + "_" + paramLong;
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    while (localIterator.hasNext()) {
      if (((String)localIterator.next()).equals(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsMsgMgr", 2, "tipsMsgFilterBySeq, flag in queue equals uniFlag:" + paramString);
        }
        return true;
      }
    }
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 30) {
      this.jdField_a_of_type_JavaUtilQueue.poll();
    }
    this.jdField_a_of_type_JavaUtilQueue.offer(paramString);
    return false;
  }
  
  public MessageForGrayTips b(TroopTipsEntity paramTroopTipsEntity)
  {
    if (paramTroopTipsEntity == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "decodeTroopTipsEntity2GrayTips,entity:" + paramTroopTipsEntity.toString());
    }
    if (paramTroopTipsEntity.grayTipsRemindFlag != 0) {}
    for (int i = -2042;; i = 2024)
    {
      MessageForGrayTips localMessageForGrayTips = (MessageForGrayTips)MessageRecordFactory.a(2024);
      localMessageForGrayTips.frienduin = paramTroopTipsEntity.troopUin;
      localMessageForGrayTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramTroopTipsEntity.troopUin, paramTroopTipsEntity.troopUin, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, i, paramTroopTipsEntity.uinType, paramTroopTipsEntity.msgSeq);
      if (paramTroopTipsEntity.highlightNum != 0) {
        a(localMessageForGrayTips, paramTroopTipsEntity.highlightItems);
      }
      if (paramTroopTipsEntity.optShowLatest == 1) {
        localMessageForGrayTips.shmsgseq = 0L;
      }
      localMessageForGrayTips.isread = true;
      localMessageForGrayTips.saveExtInfoToExtStr("gray_tips_serviceType", String.valueOf(paramTroopTipsEntity.serviceType));
      return localMessageForGrayTips;
    }
  }
  
  public void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "initTroopTipsFlag");
    }
    jdField_a_of_type_JavaUtilHashMap.clear();
    EntityManager localEntityManager = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
    Cursor localCursor = localEntityManager.a(true, TroopTipsEntity.class.getSimpleName(), new String[] { "troopUin" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int i = localCursor.getColumnIndex("troopUin");
          if (i == -1) {
            break label231;
          }
          paramQQAppInterface = localCursor.getString(i);
          i = localCursor.getColumnIndex("msgSeq");
          if (i == -1) {
            break label225;
          }
          str = localCursor.getString(i);
          if ((paramQQAppInterface != null) && (str != null)) {
            a(paramQQAppInterface, str);
          }
          boolean bool = localCursor.moveToNext();
          if (bool) {
            continue;
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopTipsMsgMgr", 2, "initTroopTipsFlag Exception");
        localCursor.close();
        continue;
      }
      finally
      {
        localCursor.close();
      }
      localEntityManager.a();
      return;
      label225:
      String str = null;
      continue;
      label231:
      paramQQAppInterface = null;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr
 * JD-Core Version:    0.7.0.1
 */