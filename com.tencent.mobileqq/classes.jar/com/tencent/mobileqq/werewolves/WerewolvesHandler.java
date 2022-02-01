package com.tencent.mobileqq.werewolves;

import KQQ.ProfSmpInfoRes;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DateNickNameInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x857.TroopTips0x857.WereWolfPush;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.ReqBody;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.ReqBody;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;
import tencent.im.s2c.msgtype0x210.submsgtype0xdd.submsgtype0xdd.MsgBody;

public class WerewolvesHandler
  extends BusinessHandler
{
  protected static HashMap<String, WeakReference<TextView>> a;
  protected BroadcastReceiver a;
  protected LruCache<String, String> a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected WerewolvesHandler.UIHandler a;
  WerewolvesPluginManager jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = null;
  public String a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public WerewolvesHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_AndroidSupportV4UtilLruCache = new LruCache(100);
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$UIHandler = new WerewolvesHandler.UIHandler();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new WerewolvesHandler.6(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApp().getSharedPreferences("werewolves_sp", 0).getString("judgeUin", "");
    IntentFilter localIntentFilter = new IntentFilter("tencent.video.v2q.memberSpeaking");
    paramQQAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  protected ProtoUtils.TroopProtocolObserver a(WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    return new WerewolvesHandler.4(this, paramCallback);
  }
  
  public WerewolvesPluginManager a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager == null) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = new WerewolvesPluginManager(paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.jdField_a_of_type_JavaLangString = paramString;
    }
    return this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = null;
  }
  
  public void a(int paramInt1, int paramInt2, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_max_member_num.set(paramInt1, true);
    localReqBody.uint32_zone_id.set(paramInt2);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_1", 2276, 1, new Bundle(), 5000L);
  }
  
  public void a(TextView paramTextView, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString1)) {}
    try
    {
      paramTextView.setText(String.format(paramString2, new Object[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname() }));
      return;
    }
    catch (Exception paramString1)
    {
      label37:
      Object localObject;
      break label37;
    }
    paramTextView.setText(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname());
    return;
    localObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (((FriendsManager)localObject).b(paramString1)) {
      paramString1 = ContactUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1);
    }
    try
    {
      paramTextView.setText(String.format(paramString2, new Object[] { paramString1 }));
      return;
    }
    catch (Exception paramString2)
    {
      label99:
      break label99;
    }
    paramTextView.setText(paramString1);
    return;
    localObject = ((FriendsManager)localObject).a(paramString1);
    if ((localObject != null) && (((DateNickNameInfo)localObject).nickName != null) && (!((DateNickNameInfo)localObject).nickName.equals(paramString1))) {}
    try
    {
      paramTextView.setText(String.format(paramString2, new Object[] { ((DateNickNameInfo)localObject).nickName }));
      return;
    }
    catch (Exception paramString1)
    {
      label159:
      break label159;
    }
    paramTextView.setText(((DateNickNameInfo)localObject).nickName);
    return;
    paramTextView.setText(paramString1);
    paramTextView.setTag(new String[] { paramString1, paramString2 });
    if (jdField_a_of_type_JavaUtilHashMap.containsKey(paramString1))
    {
      jdField_a_of_type_JavaUtilHashMap.remove(paramString1);
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, new WeakReference(paramTextView));
      return;
    }
    jdField_a_of_type_JavaUtilHashMap.put(paramString1, new WeakReference(paramTextView));
    paramTextView = createToServiceMsg("ProfileService.GetSimpleInfo");
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    paramTextView.extraData.putStringArrayList("uinList", paramString2);
    paramTextView.extraData.putBoolean("reqDateNick", true);
    send(paramTextView);
    if (QLog.isColorLevel())
    {
      paramTextView = new StringBuilder();
      paramTextView.append("WerewolvesHandler: setNickname->sendToServiceMsg, uin = ");
      paramTextView.append(paramString1);
      QLog.d("WerewolvesHandler", 2, paramTextView.toString());
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo)
  {
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).exitRoom(l);
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.a()));
      if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramHotChatInfo.troopUin, 1);
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
      if (localObject != null) {
        ((WerewolvesPluginManager)localObject).b();
      }
      localObject = (HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      List localList = ((HotChatManager)localObject).a();
      if (localList != null) {
        localList.remove(paramHotChatInfo);
      }
      ((HotChatManager)localObject).a(paramHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      paramHotChatInfo.printStackTrace();
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, int paramInt1, int paramInt2, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    WerewolvesHandler.2 local2 = new WerewolvesHandler.2(this, paramCallback);
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(new WerewolvesHandler.3(this, local2, paramHotChatInfo, l, paramInt2, paramInt1, paramCallback)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      label126:
      break label126;
    }
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
    }
  }
  
  public void a(HotChatInfo paramHotChatInfo, WerewolvesHandler.Callback<oidb_0x8ed.RspBody> paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "exitRoom");
    }
    oidb_0x8ed.ReqBody localReqBody = new oidb_0x8ed.ReqBody();
    try
    {
      long l = Long.parseLong(paramHotChatInfo.troopUin);
      localReqBody.uint64_room_id.set(l, true);
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, b(new WerewolvesHandler.1(this, paramCallback, paramHotChatInfo)), localReqBody.toByteArray(), "OidbSvc.0x8ed_2", 2285, 2, new Bundle(), 5000L);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).exitRoom(l);
      ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.a()));
      try
      {
        if ((paramHotChatInfo.troopUin != null) && (!paramHotChatInfo.troopUin.equals("0"))) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramHotChatInfo.troopUin, 1);
        }
      }
      catch (Exception paramHotChatInfo)
      {
        paramHotChatInfo.printStackTrace();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.b();
      }
      return;
    }
    catch (Exception paramHotChatInfo)
    {
      label209:
      break label209;
    }
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "hotChatInfo.troopUin is wrong");
    }
  }
  
  public void a(WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "reqInviteId");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_6", 2276, 6, new Bundle(), 5000L);
  }
  
  public void a(String paramString, long paramLong, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "kickInviteUser");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint64_kick_uin.set(paramLong, true);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_5", 2276, 5, new Bundle(), 5000L);
  }
  
  public void a(String paramString, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_3", 2276, 3, new Bundle(), 5000L);
  }
  
  public void a(String paramString, boolean paramBoolean, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = new StringBuilder();
      paramString.append("acceptInvite failed, invitedId null; isAccept = ");
      paramString.append(paramBoolean);
      QLog.e("WerewolvesHandler", 2, paramString.toString());
      return;
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    paramString = localReqBody.uint32_accept_invite;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    paramString.set(i, true);
    localReqBody.uint32_ready_state.set(2);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_2", 2276, 2, new Bundle(), 5000L);
  }
  
  public void a(TroopTips0x857.WereWolfPush paramWereWolfPush, byte[] paramArrayOfByte)
  {
    if (paramWereWolfPush == null) {
      return;
    }
    if ((paramWereWolfPush.uint64_game_room.has()) && (paramWereWolfPush.bytes_judge_words.has()) && (paramWereWolfPush.uint64_judge_uin.has()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramWereWolfPush.uint64_game_room.get());
      ((StringBuilder)localObject1).append("");
      String str2 = ((StringBuilder)localObject1).toString();
      long l = MessageCache.a();
      String str1 = paramWereWolfPush.bytes_judge_words.get().toStringUtf8();
      if (TextUtils.isEmpty(str1))
      {
        if (QLog.isColorLevel())
        {
          paramWereWolfPush = new StringBuilder();
          paramWereWolfPush.append("uint64_game_room:");
          paramWereWolfPush.append(str2);
          paramWereWolfPush.append(", msg is empty");
          QLog.d("Q.werewolf.WereWolfPush", 2, paramWereWolfPush.toString());
        }
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(false);
      if (localObject1 == null) {
        return;
      }
      localObject1 = ((HotChatManager)localObject1).a(str2);
      if ((localObject1 != null) && (((HotChatInfo)localObject1).isGameRoom))
      {
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().getLastMessage(str2, 1);
        localObject1 = MessageRecordFactory.a(-1000);
        ((MessageRecord)localObject1).init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str1, l, -1000, 1, l);
        if (localObject2 != null) {
          ((MessageRecord)localObject1).shmsgseq = ((com.tencent.imcore.message.Message)localObject2).shmsgseq;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramWereWolfPush.uint64_judge_uin.get());
        ((StringBuilder)localObject2).append("");
        ((MessageRecord)localObject1).senderuin = ((StringBuilder)localObject2).toString();
        this.jdField_a_of_type_JavaLangString = ((MessageRecord)localObject1).senderuin;
        if (paramWereWolfPush.bytes_judge_nickname.has())
        {
          localObject2 = paramWereWolfPush.bytes_judge_nickname.get().toStringUtf8();
          TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramWereWolfPush.uint64_judge_uin.get());
          localStringBuilder.append("");
          localTroopManager.a(str2, localStringBuilder.toString(), (String)localObject2, 0, null, null, 0, 0, 0, 0L, (byte)0, 0L, 0.0D);
          paramWereWolfPush = (TroopTips0x857.WereWolfPush)localObject2;
        }
        else
        {
          paramWereWolfPush = "";
        }
        ((MessageRecord)localObject1).isread = true;
        ((MessageRecord)localObject1).issend = 0;
        ((MessageRecord)localObject1).saveExtInfoToExtStr("isJudgeMsg", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a((MessageRecord)localObject1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
        ((RecentUserProxy)localObject1).a(((RecentUserProxy)localObject1).a(str2, 1));
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("uint64_game_room:");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append("|judge_nickname:");
          ((StringBuilder)localObject1).append(paramWereWolfPush);
          ((StringBuilder)localObject1).append("|msg:");
          if (TextUtils.isEmpty(str1))
          {
            paramWereWolfPush = "";
          }
          else
          {
            paramWereWolfPush = new StringBuilder();
            paramWereWolfPush.append(str1.substring(0, 1));
            paramWereWolfPush.append("***");
            paramWereWolfPush.append(str1.substring(str1.length() - 1));
            paramWereWolfPush.append("|msg len:");
            paramWereWolfPush.append(str1.length());
            paramWereWolfPush = paramWereWolfPush.toString();
          }
          ((StringBuilder)localObject1).append(paramWereWolfPush);
          QLog.d("Q.werewolf.WereWolfPush", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        ((IHotChatHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName())).getMyHotChatList(2);
        return;
      }
    }
    paramWereWolfPush = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
    if (paramWereWolfPush != null) {
      paramWereWolfPush.a("WereWolfPush", paramArrayOfByte);
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    submsgtype0xdd.MsgBody localMsgBody = new submsgtype0xdd.MsgBody();
    try
    {
      localMsgBody.mergeFrom(paramArrayOfByte);
      notifyUI(1, true, localMsgBody);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.e("WerewolvesHandler", 2, QLog.getStackTraceString(paramArrayOfByte));
      }
    }
  }
  
  protected ProtoUtils.TroopProtocolObserver b(WerewolvesHandler.Callback<oidb_0x8ed.RspBody> paramCallback)
  {
    return new WerewolvesHandler.5(this, paramCallback);
  }
  
  public void b(int paramInt1, int paramInt2, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "quickStartGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.uint32_play_way.set(1, true);
    localReqBody.uint32_max_member_num.set(paramInt1);
    localReqBody.uint32_zone_id.set(paramInt2);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.e("WerewolvesHandler", 2, "startGame");
    }
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString), true);
    localReqBody.uint32_play_way.set(2, true);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_4", 2276, 4, new Bundle(), 5000L);
  }
  
  public void b(String paramString, boolean paramBoolean, WerewolvesHandler.Callback<oidb_0x8e4.RspBody> paramCallback)
  {
    oidb_0x8e4.ReqBody localReqBody = new oidb_0x8e4.ReqBody();
    localReqBody.string_invite_id.set(ByteStringMicro.copyFromUtf8(paramString));
    paramString = localReqBody.uint32_ready_state;
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    paramString.set(i);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, a(paramCallback), localReqBody.toByteArray(), "OidbSvc.0x8e4_7", 2276, 7, new Bundle(), 5000L);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return WerewolvesObserver.class;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).unbindService();
    WerewolvesPluginManager localWerewolvesPluginManager = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager;
    if (localWerewolvesPluginManager != null) {
      localWerewolvesPluginManager.b();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("werewolves_sp", 0).edit().putString("judgeUin", this.jdField_a_of_type_JavaLangString).commit();
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$UIHandler.removeCallbacksAndMessages(null);
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WereWolevsHandler onReceive. cmd=");
      localStringBuilder.append((String)localObject);
      QLog.d("Q.qqstory.protocol", 2, localStringBuilder.toString());
    }
    if ("ProfileService.GetSimpleInfo".equals(localObject))
    {
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("uinList");
      if (paramFromServiceMsg.isSuccess())
      {
        localObject = (ArrayList)paramObject;
        if ((localObject != null) && (paramToServiceMsg != null) && (((ArrayList)localObject).size() > 0) && (paramToServiceMsg.size() > 0))
        {
          paramObject = (String)paramToServiceMsg.get(0);
          paramFromServiceMsg = ((ProfSmpInfoRes)((ArrayList)localObject).get(0)).sDateNick;
          paramToServiceMsg = paramFromServiceMsg;
          if (TextUtils.isEmpty(paramFromServiceMsg)) {
            paramToServiceMsg = ((ProfSmpInfoRes)((ArrayList)localObject).get(0)).strNick;
          }
          paramFromServiceMsg = new android.os.Message();
          paramFromServiceMsg.obj = new String[] { paramObject, paramToServiceMsg };
          this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$UIHandler.sendMessage(paramFromServiceMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler
 * JD-Core Version:    0.7.0.1
 */