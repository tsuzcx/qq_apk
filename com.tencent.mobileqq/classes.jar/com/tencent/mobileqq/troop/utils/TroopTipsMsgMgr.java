package com.tencent.mobileqq.troop.utils;

import android.content.ContentValues;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.tencent.avgame.business.handler.AvGameRoomListHandler;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager;
import com.tencent.mobileqq.apollo.ApolloGameManager;
import com.tencent.mobileqq.apollo.api.IApolloPushManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandlerUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.gameparty.GamePartyManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.UniteEntity.Note;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherPushHelper;
import com.tencent.mobileqq.location.net.QQTroopLocationPushDecoder;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.revokemsg.RevokeMsgInfo;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.message.codec.decoder.MsgType0x2dcDecoder.Parse0x2dcContext;
import com.tencent.mobileqq.service.troop.TroopNotificationConstants;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studyroom.StudyRoomManager;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherParser;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopMessageManager;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceMsgManager;
import com.tencent.mobileqq.troop.handler.TroopInfoExtHandler;
import com.tencent.mobileqq.troop.handler.TroopInfoHandler;
import com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.group.IliveGroupTipsManager;
import java.io.UnsupportedEncodingException;
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
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.LightApp;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.Sender;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.Source;
import tencent.im.oidb.cmd0x857.GroupOpenSysMsg.SysMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857.AIOGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GeneralGrayTipInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GoldMsgTipsElem;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GroupAnnounceTBCInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GroupInfoChange;
import tencent.im.oidb.cmd0x857.TroopTips0x857.GroupNotifyInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MediaChangePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder.MessageMeta;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MessageRecallReminder.WithDrawWordingInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.MiniAppNotify;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody;
import tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyObjmsgUpdate;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsg;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQGroupDigestMsgSummary;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQVaLiveNotifyMsg;
import tencent.im.oidb.cmd0x857.TroopTips0x857.QQVedioGamePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.RedGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.SingChangePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.StudyRoomMemberChangePush;
import tencent.im.oidb.cmd0x857.TroopTips0x857.TroopFormGrayTipsInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.VideoChangePushInfo;
import tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush;
import tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody;

public class TroopTipsMsgMgr
  implements Manager
{
  protected static final String a;
  protected static HashMap<String, Boolean> a;
  protected QQAppInterface a;
  public ArrayList<TroopTipsMsgMgr.RedGrayTips> a;
  protected Queue<String> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "<{text:'A',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>" + HardCodeUtil.a(2131715650) + "<{text:'B',action:'',url:'',url_p:'schemel://xxx',actionData:'action:xxxx',actionData_i:'',actionData_a:''}>" + HardCodeUtil.a(2131715651) + "<{icon:'/rose',url:'url.qq.com?rose.png',alt:'玫瑰'}>";
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public TroopTipsMsgMgr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    if (!a(paramLong2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "reportGameGrayTip, troopUin: " + paramLong1 + " busiId: " + paramLong2);
    }
    int i;
    if (paramLong2 == 10035L)
    {
      i = 1;
      if (i == 0) {
        break label98;
      }
    }
    label98:
    for (String str = "game_on_exp";; str = "game_off_exp")
    {
      TroopReportor.a("Grp_AIO", "AIO_exp", str, 0, 0, new String[] { String.valueOf(paramLong1) });
      return;
      i = 0;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    if (((paramLong2 != 1068L) && (paramLong2 != 1067L)) || ((paramLong3 != 10036L) && (paramLong3 != 10038L))) {}
    do
    {
      return;
      if (!paramString.isEmpty()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TroopTipsMsgMgr", 2, "tryRefreshClockInEntry， contentXml is empty");
    return;
    if (QLog.isColorLevel()) {
      QLog.e("TroopTipsMsgMgr", 2, "tryRefreshClockInEntry， troopUin: " + paramLong1 + " busiId: " + paramLong2 + " templId: " + paramLong3);
    }
    for (;;)
    {
      try
      {
        paramString = UniteGrayTipUtil.a(paramString);
        if (paramString == null) {
          break;
        }
        paramString = paramString.a();
        if (paramString == null) {
          break;
        }
        paramString = paramString.a();
        if (paramString == null) {
          break;
        }
        paramString = paramString.iterator();
        if (paramString.hasNext())
        {
          UniteEntity.Note localNote = (UniteEntity.Note)paramString.next();
          if (localNote.a() != 4) {
            continue;
          }
          paramString = (String)localNote.a().get(Integer.valueOf(6));
          if ((TextUtils.isEmpty(paramString)) || (!paramString.equals(paramQQAppInterface.getCurrentAccountUin()))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.e("TroopTipsMsgMgr", 2, "tryRefreshClockInEntry， getClockInStatus");
          }
          ((TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(String.valueOf(paramLong1), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopTipsMsgMgr", 2, "tryRefreshClockInEntry， e: " + paramQQAppInterface);
        }
        paramQQAppInterface.printStackTrace();
        return;
      }
      paramString = null;
    }
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
          break label392;
        }
        if (!localJSONObject.has("cmd")) {
          break label387;
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
      label387:
      int j = -1;
      continue;
      label392:
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
  
  private void a(GroupOpenSysMsg.SysMsgBody paramSysMsgBody, TroopTipsEntity paramTroopTipsEntity)
  {
    if ((paramSysMsgBody.msg_type.get() == 2) && (paramSysMsgBody.light_app.has()))
    {
      MessageForArkApp localMessageForArkApp = (MessageForArkApp)MessageRecordFactory.a(-5008);
      Object localObject = new ArkAppMessage();
      ((ArkAppMessage)localObject).promptText = paramSysMsgBody.light_app.prompt.get();
      ((ArkAppMessage)localObject).appName = paramSysMsgBody.light_app.app.get();
      ((ArkAppMessage)localObject).appView = paramSysMsgBody.light_app.view.get();
      ((ArkAppMessage)localObject).appDesc = paramSysMsgBody.light_app.desc.get();
      ((ArkAppMessage)localObject).appMinVersion = paramSysMsgBody.light_app.ver.get();
      ((ArkAppMessage)localObject).metaList = paramSysMsgBody.light_app.meta.get();
      ((ArkAppMessage)localObject).config = paramSysMsgBody.light_app.config.get();
      if (paramSysMsgBody.light_app.source.has())
      {
        ((ArkAppMessage)localObject).mSourceName = paramSysMsgBody.light_app.source.name.get();
        ((ArkAppMessage)localObject).mSourceUrl = paramSysMsgBody.light_app.source.url.get();
      }
      localMessageForArkApp.ark_app_message = ((ArkAppMessage)localObject);
      localObject = "";
      if (paramSysMsgBody.sender.has())
      {
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_has", "1");
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_flag", "1");
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_head_url", paramSysMsgBody.sender.avatar.get());
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_head_click_url", paramSysMsgBody.sender.url.get());
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_nickname", paramSysMsgBody.sender.nick.get());
        localMessageForArkApp.saveExtInfoToExtStr("troop_msg_nick_color", String.valueOf(BaseApplication.getContext().getResources().getColor(2131167058)));
        localObject = String.valueOf(paramSysMsgBody.sender.uin.get());
      }
      localMessageForArkApp.saveExtInfoToExtStr("troop_mini_app_sys", "1");
      localMessageForArkApp.frienduin = paramTroopTipsEntity.troopUin;
      localMessageForArkApp.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramTroopTipsEntity.troopUin, (String)localObject, paramTroopTipsEntity.optContent, paramTroopTipsEntity.time, -5008, paramTroopTipsEntity.uinType, paramTroopTipsEntity.msgSeq);
      localMessageForArkApp.isread = true;
      localMessageForArkApp.getBytes();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageForArkApp, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
  }
  
  private boolean a(long paramLong)
  {
    return (paramLong == 10035L) || (paramLong == 10036L);
  }
  
  public static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQAppInterface paramQQAppInterface)
  {
    if (paramMessageForUniteGrayTip.shmsgseq <= 0L) {
      return false;
    }
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (a(paramMessageForUniteGrayTip, paramQQAppInterface.b(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop))) {
      return true;
    }
    String str = String.format("shmsgseq=%d", new Object[] { Long.valueOf(paramMessageForUniteGrayTip.shmsgseq) });
    return a(paramMessageForUniteGrayTip, paramQQAppInterface.a(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop, paramMessageForUniteGrayTip.shmsgseq, 1000, str));
  }
  
  private static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, MessageRecord paramMessageRecord)
  {
    if (!TextUtils.equals(paramMessageForUniteGrayTip.senderuin, paramMessageRecord.senderuin)) {}
    while ((!TextUtils.equals(paramMessageForUniteGrayTip.frienduin, paramMessageRecord.frienduin)) || (!TextUtils.equals(paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_tips_seq_id"), paramMessageRecord.getExtInfoFromExtStr("uint64_tips_seq_id"))) || (!TextUtils.equals(paramMessageForUniteGrayTip.getExtInfoFromExtStr("uint64_busi_id"), paramMessageRecord.getExtInfoFromExtStr("uint64_busi_id")))) {
      return false;
    }
    return true;
  }
  
  private static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < paramList.size())
      {
        if (a(paramMessageForUniteGrayTip, (MessageRecord)paramList.get(i))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "removeReadedAIOGrayTips");
    }
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("read", Boolean.valueOf(true));
    boolean bool = localEntityManager.update(TroopTipsEntity.class.getSimpleName(), localContentValues, "troopUin=? and msgSeq=?", new String[] { paramString1, paramString2 });
    localEntityManager.close();
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
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localArrayList, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
  
  public MessageRecord a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, MsgType0x2dcDecoder.Parse0x2dcContext paramParse0x2dcContext)
  {
    if (paramArrayOfByte == null) {
      paramQQAppInterface = null;
    }
    Object localObject1;
    Object localObject2;
    int i;
    int j;
    long l5;
    long l1;
    Object localObject3;
    label1211:
    label1270:
    do
    {
      return paramQQAppInterface;
      localObject1 = new TroopTips0x857.NotifyMsgBody();
      do
      {
        try
        {
          localObject2 = (TroopTips0x857.NotifyMsgBody)((TroopTips0x857.NotifyMsgBody)localObject1).mergeFrom(paramArrayOfByte);
          if (localObject2 == null)
          {
            if (!QLog.isColorLevel()) {
              break label4809;
            }
            QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> notifyMsgBody == null");
            break label4809;
          }
          i = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_enum_type.get();
          j = ((TroopTips0x857.NotifyMsgBody)localObject2).uint32_service_type.get();
          l5 = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_group_code.get();
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> msgSeq:" + paramInt + ", promptType: " + i + ", serviceType: " + j + ", troopUin: " + l5);
          }
          if (a(l5 + "", paramInt)) {
            return null;
          }
          if (paramLong != 0L) {
            break label4806;
          }
          paramLong = NetConnInfoCenter.getServerTime();
          l1 = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_msg_expires.get();
          if ((l1 != 0L) && (NetConnInfoCenter.getServerTime() >= l1))
          {
            if (!QLog.isColorLevel()) {
              break label4811;
            }
            QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 ==> time expried!! promptType:" + i);
            break label4811;
          }
          localObject3 = new TroopTipsEntity();
          ((TroopTipsEntity)localObject3).troopUin = String.valueOf(l5);
          ((TroopTipsEntity)localObject3).time = paramLong;
          ((TroopTipsEntity)localObject3).expireTime = l1;
          ((TroopTipsEntity)localObject3).msgSeq = paramInt;
          ((TroopTipsEntity)localObject3).isOfflineMsg = paramBoolean1;
          switch (i)
          {
          case 1: 
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_redtips.has())
            {
              paramArrayOfByte = (TroopTips0x857.RedGrayTipsInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_redtips.get();
              if (paramQQAppInterface.mAutomator.b())
              {
                a(new TroopTipsMsgMgr.RedGrayTips(this, ((TroopTipsEntity)localObject3).troopUin, paramArrayOfByte));
                return null;
              }
              ((TroopTipsEntity)localObject3).currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
              paramQQAppInterface = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
              paramQQAppInterface.senderUin = (paramArrayOfByte.uint64_sender_uin.get() + "");
              paramQQAppInterface.reciverUin = (paramArrayOfByte.uint64_receiver_uin.get() + "");
              paramQQAppInterface.senderContent = paramArrayOfByte.bytes_sender_rich_content.get().toStringUtf8();
              paramQQAppInterface.reciverContent = paramArrayOfByte.bytes_receiver_rich_content.get().toStringUtf8();
              paramQQAppInterface.authKey = paramArrayOfByte.bytes_authkey.get().toStringUtf8();
              paramQQAppInterface.idiomSeq = paramArrayOfByte.uint32_idiom_seq.get();
              paramQQAppInterface.idiom = paramArrayOfByte.bytes_idiom.get().toStringUtf8();
              paramQQAppInterface.msgType = paramArrayOfByte.sint32_msgtype.get();
              paramQQAppInterface.richContent = paramArrayOfByte.bytes_broadcast_rich_content.get().toStringUtf8();
              paramQQAppInterface.lastPinyin = paramArrayOfByte.bytes_idiom_alpha.get().toStringUtf8();
              paramQQAppInterface.bytes_jumpurl = paramArrayOfByte.bytes_jumpurl.get().toStringUtf8();
              paramQQAppInterface.subChannel = paramArrayOfByte.uint32_subchannel.get();
              paramQQAppInterface.poemRule = paramArrayOfByte.bytes_poem_rule.get().toStringUtf8();
              paramQQAppInterface.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), ((TroopTipsEntity)localObject3).troopUin, "", "[QQWallet Tips]", MessageCache.a(), -2029, 1, MessageCache.a());
              paramQQAppInterface.isread = true;
              paramQQAppInterface.getBytes();
              paramQQAppInterface.onReceiveGrapTips();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramQQAppInterface, ((TroopTipsEntity)localObject3).currentUin);
              return null;
            }
            ((TroopTipsEntity)localObject3).tipsPromptType = 1;
            ((TroopTipsEntity)localObject3).currentUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            ((TroopTipsEntity)localObject3).optContent = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_bytes_content.get().toStringUtf8();
            ((TroopTipsEntity)localObject3).grayTipsRemindFlag = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_uint32_remind.get();
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_bytes_brief.has()) {
              ((TroopTipsEntity)localObject3).grayTipsSummary = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_bytes_brief.get().toStringUtf8();
            }
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.uint32_robot_group_opt.has())
            {
              if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.uint32_robot_group_opt.get() == 1) {}
              paramArrayOfByte = (TroopRobotManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER);
            }
            if (TextUtils.isEmpty(((TroopTipsEntity)localObject3).optContent)) {
              return null;
            }
            ((TroopTipsEntity)localObject3).optShowLatest = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_graytips.opt_uint32_show_lastest.get();
            ((TroopTipsEntity)localObject3).serviceType = j;
            a((TroopTipsEntity)localObject3);
            if (j == 3)
            {
              HWTroopUtils.a(paramQQAppInterface, (TroopTipsEntity)localObject3);
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
                TroopRankConfig.a().a(String.valueOf(l5), paramQQAppInterface.getCurrentAccountUin(), true);
                ((TroopMemberInfoHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_INFO_HANDLER)).a(l5, paramLong);
              }
            }
            for (;;)
            {
              paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((TroopTipsEntity)localObject3).troopUin, (TroopTipsEntity)localObject3);
              if ((paramBoolean1) || (!MessageHandlerUtils.a(paramQQAppInterface, paramArrayOfByte, false))) {
                break label1270;
              }
              return null;
              if (j != 11) {
                break;
              }
              ((TroopTipsEntity)localObject3).repeatInterval = 10;
            }
            QLog.e("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10 Exception " + paramQQAppInterface.getStackTrace());
          }
        }
        catch (Exception paramQQAppInterface)
        {
          paramQQAppInterface.printStackTrace();
          if (!QLog.isColorLevel()) {
            break label4813;
          }
        }
        break label4813;
      } while (j != 12);
      if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_sender_uin.has()) {
        break;
      }
      paramLong = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_sender_uin.get();
      paramQQAppInterface = ((TroopTipsEntity)localObject3).optContent;
      if (QLog.isColorLevel()) {
        QLog.d("TroopTipsMsgMgr", 2, "ServiceType_GroupNameModified modify name:" + paramQQAppInterface + "， uin" + paramLong);
      }
      TroopUtils.a(l5, paramQQAppInterface, paramLong);
      return null;
      paramQQAppInterface = paramArrayOfByte;
    } while (paramArrayOfByte == null);
    paramArrayOfByte.saveExtInfoToExtStr("gray_tips_serviceType", j + "");
    return paramArrayOfByte;
    label1559:
    label1688:
    long l2;
    label2796:
    long l3;
    label2817:
    label2837:
    label2900:
    label2924:
    long l4;
    if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_group_notify.has())
    {
      paramQQAppInterface = (TroopTips0x857.GroupNotifyInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_group_notify.get();
      paramArrayOfByte = ((TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(Long.valueOf(l5), true);
      if ((paramArrayOfByte != null) && (1 == paramQQAppInterface.opt_uint32_auto_pull_flag.get()))
      {
        paramArrayOfByte.a(paramQQAppInterface.opt_bytes_feeds_id.get().toStringUtf8(), Integer.valueOf(paramQQAppInterface.opt_uint32_auto_pull_flag.get()));
        ((TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(TroopNotificationConstants.ap, true, new Object[] { String.valueOf(l5), paramQQAppInterface.opt_bytes_feeds_id.get().toStringUtf8(), Integer.valueOf(paramQQAppInterface.opt_uint32_auto_pull_flag.get()) });
        break label4813;
        if (!paramBoolean2)
        {
          if (paramParse0x2dcContext != null) {
            paramParse0x2dcContext.a = false;
          }
          if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_recall.has())
          {
            paramParse0x2dcContext = (TroopTips0x857.MessageRecallReminder)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_recall.get();
            paramLong = paramParse0x2dcContext.uint64_uin.get();
            l1 = paramParse0x2dcContext.uint64_admin_uin.get();
            i = paramParse0x2dcContext.uint32_op_type.get();
            if (paramParse0x2dcContext.msg_wording_info.has())
            {
              paramInt = paramParse0x2dcContext.msg_wording_info.int32_item_id.get();
              paramQQAppInterface = paramParse0x2dcContext.msg_wording_info.string_item_name.get();
              paramArrayOfByte = new HashMap();
              try
              {
                localObject1 = new msgrevoke_userdef.MsgInfoUserDef();
                ((msgrevoke_userdef.MsgInfoUserDef)localObject1).mergeFrom(paramParse0x2dcContext.bytes_userdef.get().toByteArray());
                j = ((msgrevoke_userdef.MsgInfoUserDef)localObject1).uint32_long_message_flag.get();
                if (j != 1) {
                  break label1688;
                }
                localObject1 = ((ArrayList)((msgrevoke_userdef.MsgInfoUserDef)localObject1).long_msg_info.get()).iterator();
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)((Iterator)localObject1).next();
                  paramArrayOfByte.put(Integer.valueOf(((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject2).uint32_msg_seq.get()), localObject2);
                }
                QLog.d("revokeMsg", 2, "recv 0x2dc_0x11 msg, parse msgInfoUserDef error");
              }
              catch (Exception paramQQAppInterface)
              {
                if (!QLog.isColorLevel()) {
                  break label4815;
                }
              }
              break label4815;
              localObject1 = new ArrayList();
              paramParse0x2dcContext = ((ArrayList)paramParse0x2dcContext.uint32_recalled_msg_list.get()).iterator();
              while (paramParse0x2dcContext.hasNext())
              {
                localObject3 = (TroopTips0x857.MessageRecallReminder.MessageMeta)paramParse0x2dcContext.next();
                localObject2 = new RevokeMsgInfo();
                ((RevokeMsgInfo)localObject2).jdField_b_of_type_JavaLangString = String.valueOf(paramLong);
                ((RevokeMsgInfo)localObject2).jdField_c_of_type_JavaLangString = String.valueOf(l1);
                ((RevokeMsgInfo)localObject2).jdField_a_of_type_JavaLangString = String.valueOf(l5);
                ((RevokeMsgInfo)localObject2).jdField_a_of_type_Int = 1;
                ((RevokeMsgInfo)localObject2).jdField_a_of_type_Long = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get();
                ((RevokeMsgInfo)localObject2).jdField_c_of_type_Long = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_time.get();
                ((RevokeMsgInfo)localObject2).jdField_e_of_type_JavaLangString = String.valueOf(((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint64_author_uin.get());
                ((RevokeMsgInfo)localObject2).jdField_e_of_type_Int = i;
                ((RevokeMsgInfo)localObject2).jdField_f_of_type_Int = ((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_is_anony_msg.get();
                ((RevokeMsgInfo)localObject2).g = paramInt;
                ((RevokeMsgInfo)localObject2).jdField_f_of_type_JavaLangString = paramQQAppInterface;
                if (j == 1)
                {
                  localObject3 = (msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)paramArrayOfByte.get(Integer.valueOf(((TroopTips0x857.MessageRecallReminder.MessageMeta)localObject3).uint32_seq.get()));
                  ((RevokeMsgInfo)localObject2).jdField_b_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_id.get();
                  ((RevokeMsgInfo)localObject2).jdField_c_of_type_Int = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_num.get();
                  ((RevokeMsgInfo)localObject2).d = ((msgrevoke_userdef.MsgInfoUserDef.MsgInfoDef)localObject3).long_msg_index.get();
                }
                ((ArrayList)localObject1).add(localObject2);
                if (QLog.isColorLevel()) {
                  QLog.d("revokeMsg", 2, "recv 0x2dc_0x11 msg," + ((RevokeMsgInfo)localObject2).toString());
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((ArrayList)localObject1, false);
              return null;
              if (QLog.isColorLevel()) {
                QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate push message");
              }
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_objmsg_update.has()) {
                break label4813;
              }
              paramParse0x2dcContext = (TroopTips0x857.NotifyObjmsgUpdate)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_objmsg_update.get();
              if (!paramParse0x2dcContext.bytes_ext_msg.has()) {
                break label4813;
              }
              paramArrayOfByte = new SubMsgType0xaa.MsgBody();
              try
              {
                paramArrayOfByte.mergeFrom(paramParse0x2dcContext.bytes_ext_msg.get().toByteArray());
                ((GamePartyManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_PARTY_MANAGER)).a(paramArrayOfByte, false);
              }
              catch (Exception paramParse0x2dcContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("GameParty", 2, "recv 0x857_notifyobjmsgupdate, prase msgBody error");
                  }
                }
              }
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_werewolf_push.has()) {
                break label4813;
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.werewolf", 2, "recv 0x857_werewolfPush");
              }
              ((WerewolvesHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a((TroopTips0x857.WereWolfPush)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_werewolf_push.get(), paramArrayOfByte);
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("ApolloGameManager", 2, "recv 0x857_gameStatusNotify push message.[troop]");
              }
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_stcm_game_state.has()) {
                break label4813;
              }
              paramQQAppInterface = (apollo_game_status.STCMGameMessage)((TroopTips0x857.NotifyMsgBody)localObject2).opt_stcm_game_state.get();
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
                break label4813;
              }
              ((ApolloGameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.APOLLO_GAME_MANAGER)).a(0, 1, Long.toString(l5), paramQQAppInterface);
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("ApolloPushManager", 2, "recv action push message, [troop]");
              }
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).apllo_msg_push.has()) {
                break label4813;
              }
              paramArrayOfByte = (apollo_push_msgInfo.STPushMsgElem)((TroopTips0x857.NotifyMsgBody)localObject2).apllo_msg_push.get();
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
                break label4813;
              }
              ((IApolloPushManager)paramQQAppInterface.getRuntimeService(IApolloPushManager.class, "all")).onRecvActionPush(1, paramArrayOfByte);
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("TroopTipsMsgMgr", 2, "recv action push message, [troop]");
              }
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.has()) {
                break label4813;
              }
              paramQQAppInterface = (TroopTips0x857.GoldMsgTipsElem)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.get();
              if ((!paramQQAppInterface.type.has()) || (paramQQAppInterface.type.get() != 3)) {
                break label4813;
              }
              NotifyMsgManager.a(1, (TroopTips0x857.GoldMsgTipsElem)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_goldtips.get(), null);
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("TroopTipsMsgMgr", 2, "recv miniAppNotify");
              }
              paramBoolean1 = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_miniapp_notify.has();
              if (!paramBoolean1) {
                break label4813;
              }
              try
              {
                paramQQAppInterface = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_miniapp_notify.bytes_msg.get().toByteArray();
                paramArrayOfByte = new GroupOpenSysMsg.SysMsgBody();
                paramArrayOfByte.mergeFrom(paramQQAppInterface);
                a(paramArrayOfByte, (TroopTipsEntity)localObject3);
              }
              catch (InvalidProtocolBufferMicroException paramQQAppInterface)
              {
                if (!QLog.isColorLevel()) {
                  break label4813;
                }
              }
              QLog.d("TroopTipsMsgMgr", 2, "parse miniAppNotify error");
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("TroopTipsMsgMgr", 2, "recv RecvMsgSetChanged");
              }
              if (paramQQAppInterface == null) {
                break label4813;
              }
              ((TroopInfoHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_HANDLER)).a(String.valueOf(l5), false, "", false, true, false, true);
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("TroopTipsMsgMgr", 2, "recv Prompt_TroopFormGrayTips");
              }
              QLog.d("TroopTipsMsgMgr", 1, "troopFormLog receive Prompt_TroopFormGray");
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_troopformtips_push.has()) {
                break label4813;
              }
              TeamWorkUtils.a(paramQQAppInterface, (TroopTips0x857.TroopFormGrayTipsInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_troopformtips_push.get(), ((TroopTipsEntity)localObject3).troopUin);
              break label4813;
              if (QLog.isColorLevel()) {
                QLog.d("TroopTipsMsgMgr", 2, "recv IliveGroup Prompt_QQLiveNotify");
              }
              if (!((TroopTips0x857.NotifyMsgBody)localObject2).opt_qq_live_notify.has()) {
                break label4813;
              }
              paramArrayOfByte = (TroopTips0x857.QQVaLiveNotifyMsg)((TroopTips0x857.NotifyMsgBody)localObject2).opt_qq_live_notify.get();
              ((IliveGroupTipsManager)paramQQAppInterface.getManager(QQManagerFactory.ILIVE_GROUP_TIPS_MANAGER)).a(paramArrayOfByte, l5);
              break label4813;
              if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_media_push.has())
              {
                ListenTogetherPushHelper.a(paramQQAppInterface, paramInt, paramLong, (TroopTips0x857.MediaChangePushInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_media_push.get());
                break label4813;
              }
              QLog.d("ListenTogether", 1, "notifyMsgBody.opt_msg_media_push miss");
              break label4813;
              if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_qq_vedio_game_push_info.has())
              {
                paramQQAppInterface = (AvGameRoomListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
                if (paramQQAppInterface == null) {
                  break label4813;
                }
                paramQQAppInterface.a((TroopTips0x857.QQVedioGamePushInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_qq_vedio_game_push_info.get());
                break label4813;
              }
              QLog.d("AvGameRoomListHandler", 1, "notifyMsgBody.opt_qq_vedio_game_push_info miss");
              break label4813;
              paramBoolean1 = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_general_gray_tip.has();
              if (paramBoolean1)
              {
                try
                {
                  localObject1 = (TroopTips0x857.GeneralGrayTipInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_general_gray_tip.get();
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_busi_type.has()) {
                    break label4817;
                  }
                  l1 = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_busi_type.get();
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_busi_id.has()) {
                    break label4823;
                  }
                  l2 = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_busi_id.get();
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_templ_id.has()) {
                    break label4829;
                  }
                  l3 = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_templ_id.get();
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint32_ctrl_flag.has()) {
                    break label4835;
                  }
                  paramInt = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint32_ctrl_flag.get();
                  if (((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint32_c2c_type.has()) {
                    ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint32_c2c_type.get();
                  }
                  if (((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint32_service_type.has()) {
                    ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint32_service_type.get();
                  }
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).bytes_pb_reserv.has()) {
                    break label4840;
                  }
                  paramArrayOfByte = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).bytes_pb_reserv.get().toByteArray();
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).bytes_content.has()) {
                    break label4845;
                  }
                  paramParse0x2dcContext = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).bytes_content.get().toByteArray();
                  if (!((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_tips_seq_id.has()) {
                    break label4851;
                  }
                  l4 = ((TroopTips0x857.GeneralGrayTipInfo)localObject1).uint64_tips_seq_id.get();
                  label2945:
                  localObject1 = "";
                  if ((paramParse0x2dcContext != null) && (paramParse0x2dcContext.length > 0)) {
                    paramParse0x2dcContext = new String(paramParse0x2dcContext, "utf-8");
                  }
                  for (;;)
                  {
                    paramInt = UniteGrayTipUtil.a(paramInt);
                    a(paramQQAppInterface, l5, l2, l3, paramParse0x2dcContext);
                    if (!a(l2)) {
                      break label3063;
                    }
                    if (!StudyModeManager.a()) {
                      break;
                    }
                    return null;
                    paramParse0x2dcContext = (MsgType0x2dcDecoder.Parse0x2dcContext)localObject1;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("TroopTipsMsgMgr", 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
                      paramParse0x2dcContext = (MsgType0x2dcDecoder.Parse0x2dcContext)localObject1;
                    }
                  }
                  label3063:
                  QLog.e("TroopTipsMsgMgr", 2, "handleC2COnlinePushMsgGrayTipResp fail3 ", paramQQAppInterface);
                }
                catch (NullPointerException paramQQAppInterface)
                {
                  if (!QLog.isColorLevel()) {
                    break label4813;
                  }
                  QLog.e("TroopTipsMsgMgr", 2, "handleC2COnlinePushMsgGrayTipResp fail2 ", paramQQAppInterface);
                  break label4813;
                  a(l5, l2);
                  paramArrayOfByte = UniteGrayTipUtil.a(paramQQAppInterface, ((TroopTipsEntity)localObject3).troopUin, 1, paramInt, paramLong, paramParse0x2dcContext, l1, l2, paramArrayOfByte);
                  if (paramArrayOfByte == null) {
                    break label4813;
                  }
                  paramArrayOfByte.saveExtInfoToExtStr("uint64_busi_type", String.valueOf(l1));
                  paramArrayOfByte.saveExtInfoToExtStr("uint64_busi_id", String.valueOf(l2));
                  paramArrayOfByte.saveExtInfoToExtStr("uint64_templ_id", String.valueOf(l3));
                  paramArrayOfByte.saveExtInfoToExtStr("bytes_content", paramParse0x2dcContext);
                  paramArrayOfByte.saveExtInfoToExtStr("uint64_tips_seq_id", String.valueOf(l4));
                  if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_group_cur_msg_seq.has()) {
                    paramArrayOfByte.shmsgseq = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_group_cur_msg_seq.get();
                  }
                  paramArrayOfByte.tipParam.d = String.valueOf(l4);
                  ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800A560", "0X800A560", 3, 0, "" + l2, "" + l1, "", "");
                  if (a(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
                    break label3283;
                  }
                  UniteGrayTipUtil.a(paramQQAppInterface, paramArrayOfByte);
                }
                catch (UnsupportedEncodingException paramQQAppInterface)
                {
                  if (!QLog.isColorLevel()) {
                    break label4813;
                  }
                }
                break label4813;
                label3283:
                if (!QLog.isColorLevel()) {
                  break label4813;
                }
                QLog.d("TroopTipsMsgMgr", 2, "handle0x2dcSubType0x10Msg: duplicate gray tip " + paramArrayOfByte);
                break label4813;
              }
              QLog.d("ListenTogether", 1, "notifyMsgBody.opt_msg_media_push miss");
              break label4813;
              if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_video_push.has())
              {
                paramArrayOfByte = ((TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(2);
                if (paramArrayOfByte == null) {
                  break label4813;
                }
                paramArrayOfByte.a(paramQQAppInterface, paramInt, paramLong, ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_video_push.get());
                break label4813;
              }
              QLog.d("WatchTogetherParser", 2, "notifyMsgBody.opt_msg_video_push miss");
              break label4813;
              if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_sing_push.has())
              {
                paramArrayOfByte = ((TogetherControlManager)paramQQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).a(4);
                if (paramArrayOfByte == null) {
                  break label4813;
                }
                paramArrayOfByte.a(paramQQAppInterface, paramInt, paramLong, ((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_sing_push.get());
                break label4813;
              }
              QLog.d("WatchTogetherParser", 2, "notifyMsgBody.opt_msg_sing_push miss");
              break label4813;
              paramLong = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_group_code.get();
              paramArrayOfByte = (TroopTips0x857.GroupInfoChange)((TroopTips0x857.NotifyMsgBody)localObject2).opt_msg_group_info_change.get();
              if (paramArrayOfByte == null) {
                break label4813;
              }
              if (paramArrayOfByte.uint32_group_honor_switch.has())
              {
                paramInt = paramArrayOfByte.uint32_group_honor_switch.get();
                if (QLog.isColorLevel()) {
                  QLog.d("TroopHonor.push", 2, String.format("aio switch push, groupCode: %s, switch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
                }
                paramParse0x2dcContext = (ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "");
                if (paramInt != 0) {
                  break label4857;
                }
                paramBoolean1 = true;
                label3564:
                paramParse0x2dcContext.updateTroopHonorAIOSwitch(String.valueOf(paramLong), paramBoolean1);
              }
              if (paramArrayOfByte.uint32_group_member_level_switch.has())
              {
                paramInt = paramArrayOfByte.uint32_group_member_level_switch.get();
                if (QLog.isColorLevel()) {
                  QLog.d("TroopHonor.push", 2, String.format("aio level switch push, groupCode: %s, switch: %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
                }
                paramParse0x2dcContext = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                localObject1 = paramParse0x2dcContext.c(String.valueOf(paramLong));
                if (localObject1 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopTipsMsgMgr", 1, "level switch push troopInfo groupUin = " + paramLong);
                  }
                  ((TroopInfo)localObject1).cNewGroupRankUserFlag = ((byte)paramInt);
                  paramParse0x2dcContext.b((TroopInfo)localObject1);
                  paramParse0x2dcContext = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
                  if (paramParse0x2dcContext != null)
                  {
                    i = TroopNotificationConstants.bW;
                    if (paramInt != 0) {
                      break label4863;
                    }
                    paramBoolean1 = true;
                    label3742:
                    paramParse0x2dcContext.notifyUI(i, true, new Object[] { String.valueOf(paramLong), Boolean.valueOf(paramBoolean1) });
                  }
                }
              }
              if (paramArrayOfByte.uint32_group_flagext4.has())
              {
                paramInt = paramArrayOfByte.uint32_group_flagext4.get();
                ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).m(String.valueOf(paramLong), paramInt);
              }
              if (paramArrayOfByte.uint32_group_class_ext.has())
              {
                paramInt = paramArrayOfByte.uint32_group_class_ext.get();
                paramParse0x2dcContext = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                localObject1 = paramParse0x2dcContext.c(String.valueOf(paramLong));
                if (localObject1 != null)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopTipsMsgMgr", 1, "HWGroup classInfo changed");
                  }
                  l1 = ((TroopInfo)localObject1).dwGroupClassExt;
                  ((TroopInfo)localObject1).dwGroupClassExt = paramInt;
                  paramParse0x2dcContext.b((TroopInfo)localObject1);
                  paramParse0x2dcContext = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
                  if (paramParse0x2dcContext != null) {
                    paramParse0x2dcContext.notifyUI(TroopNotificationConstants.ca, true, new Object[] { String.valueOf(paramLong), Long.valueOf(l1) });
                  }
                }
              }
              if (paramArrayOfByte.uint32_group_flagext3.has())
              {
                localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                paramParse0x2dcContext = ((TroopManager)localObject1).c(String.valueOf(paramLong));
                if (paramParse0x2dcContext != null)
                {
                  paramParse0x2dcContext.dwGroupFlagExt3 = paramArrayOfByte.uint32_group_flagext3.get();
                  ((TroopManager)localObject1).b(paramParse0x2dcContext);
                  localObject1 = (TroopHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
                  if (localObject1 != null) {
                    ((TroopHandler)localObject1).notifyUI(TroopNotificationConstants.cb, true, new Object[] { String.valueOf(paramLong), Long.valueOf(paramParse0x2dcContext.dwGroupFlagExt3) });
                  }
                }
              }
              if (paramArrayOfByte.uint32_group_flag.has())
              {
                paramInt = paramArrayOfByte.uint32_group_flag.get();
                if (QLog.isColorLevel()) {
                  QLog.d("TroopTipsMsgMgr.push", 2, "groupInfoChange push, groupCode = " + paramLong + ", uint32_group_flag = " + paramInt);
                }
                paramParse0x2dcContext = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
                if (paramParse0x2dcContext != null)
                {
                  localObject1 = paramParse0x2dcContext.c(String.valueOf(paramLong));
                  if (localObject1 == null) {
                    break label4346;
                  }
                  if ((paramInt & 0x80) != 128) {
                    break label4869;
                  }
                  paramBoolean1 = true;
                  label4166:
                  ((TroopInfo)localObject1).isTroopBlocked = paramBoolean1;
                  if (QLog.isColorLevel()) {
                    QLog.d("TroopTipsMsgMgr.push", 2, "groupInfoChange push, isTroopBlocked = " + paramBoolean1);
                  }
                  if (paramArrayOfByte.uint32_appeal_deadline.has())
                  {
                    ((TroopInfo)localObject1).appealDeadline = paramArrayOfByte.uint32_appeal_deadline.get();
                    if (QLog.isColorLevel()) {
                      QLog.d("TroopTipsMsgMgr.push", 2, "groupInfoChange push, uint32_appeal_deadline = " + ((TroopInfo)localObject1).appealDeadline);
                    }
                  }
                  paramParse0x2dcContext.b((TroopInfo)localObject1);
                  paramParse0x2dcContext = (TroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
                  if (paramParse0x2dcContext != null) {
                    paramParse0x2dcContext.notifyUI(TroopNotificationConstants.cc, true, new Object[] { String.valueOf(l5) });
                  }
                }
              }
              while (paramArrayOfByte.uint32_group_info_ext_seq.has())
              {
                ((TroopInfoExtHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_INFO_EXT_HANDLER)).a(String.valueOf(paramLong));
                break;
                label4346:
                if (QLog.isColorLevel())
                {
                  QLog.d("TroopTipsMsgMgr.push", 2, "groupInfoChange push, troopInfo = null!!");
                  continue;
                  QQTroopLocationPushDecoder.a(paramQQAppInterface, (TroopTips0x857.NotifyMsgBody)localObject2);
                  break;
                  if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_group_announce_tbc_info.has())
                  {
                    paramParse0x2dcContext = (TroopTips0x857.GroupAnnounceTBCInfo)((TroopTips0x857.NotifyMsgBody)localObject2).opt_group_announce_tbc_info.get();
                    if (paramParse0x2dcContext != null) {
                      if (!paramParse0x2dcContext.feeds_id.has()) {
                        break label4878;
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
    label4869:
    label4878:
    for (paramArrayOfByte = paramParse0x2dcContext.feeds_id.get().toStringUtf8();; paramArrayOfByte = null)
    {
      paramLong = paramParse0x2dcContext.group_id.get();
      paramInt = paramParse0x2dcContext.action.get();
      switch (paramInt)
      {
      case 0: 
        TroopNotificationHelper.b(paramQQAppInterface, paramArrayOfByte, String.valueOf(paramLong), 1);
        break;
      case 1: 
      case 2: 
        paramQQAppInterface = new JSONObject();
        try
        {
          paramQQAppInterface.put("fid", paramArrayOfByte);
          paramQQAppInterface.put("gc", String.valueOf(paramLong));
          paramQQAppInterface.put("action", String.valueOf(paramInt));
          try
          {
            ArkAppCenter.a("com.tencent.mannounce", "UpdateAnnounce", paramQQAppInterface.toString(), "json");
          }
          catch (UnsatisfiedLinkError paramQQAppInterface)
          {
            QLog.e("TroopTipsMsgMgr", 1, "Error: troop arkNotify com.tencent.mannounce error. UpdateAnnounce.", paramQQAppInterface);
          }
        }
        catch (JSONException paramArrayOfByte)
        {
          for (;;)
          {
            QLog.e("TroopTipsMsgMgr", 1, "jsonObj.put", paramArrayOfByte);
          }
        }
        if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_study_room_member_msg.has())
        {
          paramLong = ((TroopTips0x857.NotifyMsgBody)localObject2).opt_uint64_group_code.get();
          if (QLog.isColorLevel()) {
            QLog.i("TroopTipsMsgMgr", 2, "StudyRoomMemberChangePush received groupUin:" + paramLong);
          }
          ((StudyRoomManager)paramQQAppInterface.getManager(QQManagerFactory.STUDY_ROOM_MANAGER)).a(((TroopTips0x857.StudyRoomMemberChangePush)((TroopTips0x857.NotifyMsgBody)localObject2).opt_study_room_member_msg.get()).toByteArray(), paramLong + "");
          break label4813;
          if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_qq_group_digest_msg.has())
          {
            if (QLog.isColorLevel()) {
              QLog.i("TroopTipsMsgMgr", 2, "recv Prompt_QQGroupDigestMsg");
            }
            ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a((TroopTips0x857.QQGroupDigestMsg)((TroopTips0x857.NotifyMsgBody)localObject2).opt_qq_group_digest_msg.get(), paramBoolean1);
            break label4813;
            if (((TroopTips0x857.NotifyMsgBody)localObject2).opt_group_digest_msg_summary.has())
            {
              if (QLog.isColorLevel()) {
                QLog.i("TroopTipsMsgMgr", 2, "recv Prompt_GroupDigestMsgSummary");
              }
              ((TroopEssenceMsgManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ESSENCE_MSG_MANAGER)).a(l5, (TroopTips0x857.QQGroupDigestMsgSummary)((TroopTips0x857.NotifyMsgBody)localObject2).opt_group_digest_msg_summary.get(), paramBoolean1);
              break label4813;
              paramInt = 0;
              paramQQAppInterface = "";
              break label1559;
              paramLong = 0L;
              break label1211;
              break;
              return null;
              return null;
            }
          }
        }
      default: 
        for (;;)
        {
          label4806:
          label4809:
          label4811:
          label4813:
          return null;
          label4815:
          return null;
          label4817:
          l1 = 0L;
          break;
          label4823:
          l2 = 0L;
          break label2796;
          label4829:
          l3 = 0L;
          break label2817;
          label4835:
          paramInt = 0;
          break label2837;
          label4840:
          paramArrayOfByte = null;
          break label2900;
          label4845:
          paramParse0x2dcContext = null;
          break label2924;
          label4851:
          l4 = 0L;
          break label2945;
          label4857:
          paramBoolean1 = false;
          break label3564;
          label4863:
          paramBoolean1 = false;
          break label3742;
          paramBoolean1 = false;
          break label4166;
        }
      }
    }
  }
  
  public List<TroopTipsEntity> a(String paramString)
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
      paramString = ((EntityManager)localObject).query(TroopTipsEntity.class, true, "troopUin=? and read=? and currentUin=?", new String[] { paramString, "0", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }, null, null, "time ASC", null);
      ((EntityManager)localObject).close();
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
      TroopTipsMsgMgr.RedGrayTips localRedGrayTips = (TroopTipsMsgMgr.RedGrayTips)localIterator.next();
      TroopTips0x857.RedGrayTipsInfo localRedGrayTipsInfo = localRedGrayTips.jdField_a_of_type_TencentImOidbCmd0x857TroopTips0x857$RedGrayTipsInfo;
      String str = paramQQAppInterface.getCurrentAccountUin();
      MessageForQQWalletTips localMessageForQQWalletTips = (MessageForQQWalletTips)MessageRecordFactory.a(-2029);
      localMessageForQQWalletTips.senderUin = (localRedGrayTipsInfo.uint64_sender_uin.get() + "");
      localMessageForQQWalletTips.reciverUin = (localRedGrayTipsInfo.uint64_receiver_uin.get() + "");
      localMessageForQQWalletTips.senderContent = localRedGrayTipsInfo.bytes_sender_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.reciverContent = localRedGrayTipsInfo.bytes_receiver_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.authKey = localRedGrayTipsInfo.bytes_authkey.get().toStringUtf8();
      localMessageForQQWalletTips.idiomSeq = localRedGrayTipsInfo.uint32_idiom_seq.get();
      localMessageForQQWalletTips.idiom = localRedGrayTipsInfo.bytes_idiom.get().toStringUtf8();
      localMessageForQQWalletTips.msgType = localRedGrayTipsInfo.sint32_msgtype.get();
      localMessageForQQWalletTips.richContent = localRedGrayTipsInfo.bytes_broadcast_rich_content.get().toStringUtf8();
      localMessageForQQWalletTips.lastPinyin = localRedGrayTipsInfo.bytes_idiom_alpha.get().toStringUtf8();
      localMessageForQQWalletTips.bytes_jumpurl = localRedGrayTipsInfo.bytes_jumpurl.get().toStringUtf8();
      localMessageForQQWalletTips.subChannel = localRedGrayTipsInfo.uint32_subchannel.get();
      localMessageForQQWalletTips.poemRule = localRedGrayTipsInfo.bytes_poem_rule.get().toStringUtf8();
      localMessageForQQWalletTips.init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localRedGrayTips.jdField_a_of_type_JavaLangString, "", "[QQWallet Tips]", MessageCache.a(), -2029, 1, MessageCache.a());
      localMessageForQQWalletTips.isread = true;
      localMessageForQQWalletTips.getBytes();
      localMessageForQQWalletTips.onReceiveGrapTips();
      paramQQAppInterface.getMessageFacade().a(localMessageForQQWalletTips, str);
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
    localEntityManager.persist(paramTroopTipsEntity);
    localEntityManager.close();
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
          paramQQAppInterface = paramQQAppInterface.getMessageProxy(1).b(paramString, 1);
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
    label1169:
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
          break label1169;
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
              str2 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramTroopTipsEntity.troopUin, str1);
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
  
  public void a(TroopTipsMsgMgr.RedGrayTips paramRedGrayTips)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsMsgMgr", 2, "addWalletTipsCache");
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramRedGrayTips);
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
    Cursor localCursor = localEntityManager.query(true, TroopTipsEntity.class.getSimpleName(), new String[] { "troopUin" }, "read=?", new String[] { String.valueOf(0) }, "troopUin", null, null, null);
    if (localCursor != null) {}
    for (;;)
    {
      try
      {
        if (localCursor.moveToFirst())
        {
          int i = localCursor.getColumnIndex("troopUin");
          if (i == -1) {
            break label232;
          }
          paramQQAppInterface = localCursor.getString(i);
          i = localCursor.getColumnIndex("msgSeq");
          if (i == -1) {
            break label226;
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
      localEntityManager.close();
      return;
      label226:
      String str = null;
      continue;
      label232:
      paramQQAppInterface = null;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr
 * JD-Core Version:    0.7.0.1
 */