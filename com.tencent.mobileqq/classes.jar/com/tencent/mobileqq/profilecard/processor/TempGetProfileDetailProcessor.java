package com.tencent.mobileqq.profilecard.processor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.avatardoubletap.PaiYiPaiManager;
import com.tencent.mobileqq.activity.aio.item.PttSlideStateHelper;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doc.TencentDocPref;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.StudyModeManager.ModeFlag;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.utils.PttUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.notification.NotifyIdManager;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class TempGetProfileDetailProcessor
  extends AbsProfileBusinessProcessor
{
  private static final String TAG = "TempGetProfileDetailProcessor";
  private boolean careBarEnable;
  private short[] commonSwitchArray;
  private Map<Short, Short> commonSwitchMap;
  private boolean isActivateFriendSwitchOpen;
  private boolean isHelloLiveMessageEnable;
  private boolean pcActiveState;
  private TempGetProfileDetailProcessor.ProfileHeaderInfo profileHeaderInfo;
  private BmqqAccountType qiDianExtAccountType;
  private BmqqAccountType qiDianMasterAccountType;
  private StudyModeManager.ModeFlag studyModeFlag;
  
  public TempGetProfileDetailProcessor(AppRuntime paramAppRuntime)
  {
    super(paramAppRuntime);
  }
  
  private void getDetailCardInfo(List<Short> paramList, Bundle paramBundle, String paramString)
  {
    getDetailCardInfo(paramList, paramBundle, paramString, 9);
  }
  
  private void getDetailCardInfo(List<Short> paramList, Bundle paramBundle, String paramString, int paramInt)
  {
    ProfileServiceUtils.getIProfileProtocolService(this.appRuntime).getProfileDetail(paramString, paramList, paramInt, paramBundle);
  }
  
  private void handleGetDetailInfoInner3(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramShort1)
    {
    }
    short s;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramShort1 = paramByteBuffer.getShort();
                paramShort2 = this.appRuntime.getPreferences().getInt("nearby_people_profile_ok_new", -1);
              } while ((paramShort2 == paramShort1) || (paramShort2 == 1));
              this.appRuntime.getPreferences().edit().putInt("nearby_people_profile_ok_new", paramShort1).commit();
              return;
              paramShort1 = paramByteBuffer.getShort();
              paramShort2 = ((Integer)NearbySPUtil.a(this.appRuntime.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
            } while ((paramShort2 == paramShort1) || (paramShort2 == 1));
            NearbySPUtil.a(this.appRuntime.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(paramShort1));
            return;
            paramShort1 = paramByteBuffer.getShort();
            paramBundle = this.appRuntime.getAccount();
            if (paramShort1 == 1) {}
            for (bool1 = true;; bool1 = false)
            {
              NearbySPUtil.a(paramBundle, "nearby_need_show_guide", Boolean.valueOf(bool1));
              return;
            }
            paramShort1 = paramByteBuffer.getShort();
            paramBundle = this.appRuntime.getAccount();
            if (paramShort1 == 1) {}
            for (;;)
            {
              NearbySPUtil.a(paramBundle, "is_nearby_novice", Boolean.valueOf(bool1));
              return;
              bool1 = false;
            }
          } while (paramByteBuffer.getShort() != 1);
          ((QQAppInterface)this.appRuntime).getNearbyProxy().b();
          return;
          if (paramByteBuffer.getShort() == 0) {}
          for (paramShort1 = 1;; paramShort1 = 0)
          {
            paramShort2 = ((QQAppInterface)this.appRuntime).readCallTabStateVal(4);
            i = ((QQAppInterface)this.appRuntime).readCallTabStateVal(0);
            if (i != 0) {
              break;
            }
            paramBundle = new Integer[7];
            paramBundle[3] = Integer.valueOf(paramShort1);
            ((QQAppInterface)this.appRuntime).writeCallTabStateVal(paramBundle);
            return;
          }
        } while ((i != 1) || (paramShort1 == paramShort2));
        paramBundle = (CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        bool1 = bool2;
        if (paramShort2 == 0) {
          bool1 = false;
        }
        paramBundle.b(bool1, false);
        return;
        paramShort1 = paramByteBuffer.getShort();
        ((SmartDeviceProxyMgr)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramShort1);
        return;
        paramShort1 = paramByteBuffer.getShort();
        ((SmartDeviceProxyMgr)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b(paramShort1);
        return;
        paramShort1 = paramByteBuffer.getShort();
        paramBundle = (MessageRoamManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      } while (paramBundle == null);
      paramBundle.d(paramShort1);
      return;
      s = paramByteBuffer.getShort();
      paramBundle = (LocalRedTouchManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    } while (paramBundle == null);
    paramBundle.a(s);
  }
  
  private void handleGetDetailInfoInner4(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool4 = true;
    boolean bool3 = true;
    switch (paramShort1)
    {
    default: 
    case 27055: 
    case 27034: 
      do
      {
        do
        {
          return;
          paramShort1 = paramByteBuffer.getInt();
        } while (!String.valueOf(paramLong).equals(this.appRuntime.getCurrentAccountUin()));
        ((SVIPHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramShort1, false);
        return;
        paramBundle = new byte[paramShort2];
        paramByteBuffer.get(paramBundle);
        paramBundle = new String(paramBundle);
      } while ((TextUtils.isEmpty(paramBundle)) || (!String.valueOf(paramLong).equals(this.appRuntime.getCurrentAccountUin())));
      ((FriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.appRuntime.getCurrentAccountUin(), paramBundle, (byte)-1);
      return;
    case -23753: 
      paramShort1 = paramByteBuffer.getShort();
      paramBundle = (QQAppInterface)this.appRuntime;
      if (paramShort1 > 0) {}
      for (bool1 = bool3;; bool1 = false)
      {
        HotChatManager.a(paramBundle, bool1);
        return;
      }
    case -23461: 
      bool2 = Util.a((QQAppInterface)this.appRuntime);
      if (paramByteBuffer.getShort() != 0) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        paramBundle = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramLong, 4).edit();
        paramBundle.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        paramBundle.commit();
        bool1 = Util.a((QQAppInterface)this.appRuntime);
        if (bool2 == bool1) {
          break;
        }
        Util.a((QQAppInterface)this.appRuntime, bool1);
        return;
        bool1 = false;
      }
    case -23282: 
      bool2 = paramCard.strangerInviteMeGroupOpen;
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramCard.strangerInviteMeGroupOpen = bool1;
        bool1 = paramCard.strangerInviteMeGroupOpen;
        if (bool2 == bool1) {
          break;
        }
        ((CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(95, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return;
      }
    case -25155: 
      bool3 = FriendIntimateRelationshipHelper.a(this.appRuntime.getCurrentUin());
      if (paramByteBuffer.getShort() == 1) {}
      for (bool1 = bool2; bool3 != bool1; bool1 = false)
      {
        FriendIntimateRelationshipHelper.a(this.appRuntime.getCurrentUin(), bool1);
        return;
      }
    }
    if (paramByteBuffer.getShort() == 0) {}
    for (bool1 = bool4;; bool1 = false)
    {
      SubAccountControll.a((QQAppInterface)this.appRuntime, bool1);
      return;
    }
  }
  
  private void handleGetDetailInfoInner6(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer, TempGetProfileDetailProcessor.ProfileHeaderInfo paramProfileHeaderInfo)
  {
    boolean bool1 = true;
    switch (paramShort1)
    {
    default: 
    case -23456: 
    case 27245: 
    case -23322: 
    case -24980: 
      do
      {
        do
        {
          return;
          paramShort1 = paramByteBuffer.getShort();
          paramBundle = new WholePeopleLebaEntryChecker((QQAppInterface)this.appRuntime);
          if (paramShort1 == 1) {}
          for (bool1 = true;; bool1 = false)
          {
            boolean bool2 = paramBundle.a;
            if (bool1 == bool2) {
              break;
            }
            paramBundle.a((QQAppInterface)this.appRuntime, bool1);
            ((CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(91, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
            return;
          }
          paramShort1 = paramByteBuffer.getShort();
        } while (paramShort1 <= 0);
        DanceGameVideoManager.a().a(paramShort1, String.valueOf(paramLong));
        return;
        short s = paramByteBuffer.getShort();
        paramCard.extendFriendQuestion = s;
        paramBundle = this.appRuntime.getCurrentAccountUin();
        if (s == 1) {}
        for (;;)
        {
          ExtendFriendManager.a(paramBundle, bool1);
          return;
          bool1 = false;
        }
        paramProfileHeaderInfo.headType = paramByteBuffer.getShort();
      } while (((Integer)NearbySPUtil.a(this.appRuntime.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() == paramProfileHeaderInfo.headType);
      NearbySPUtil.a(this.appRuntime.getAccount(), "qq_avatar_type", Integer.valueOf(paramProfileHeaderInfo.headType));
      return;
    case -23437: 
      paramProfileHeaderInfo.qq18Switch = paramByteBuffer.getShort();
      return;
    }
    paramProfileHeaderInfo.headSysId = paramByteBuffer.getShort();
  }
  
  private void handleGetDetailInfoInner7(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    switch (paramShort1)
    {
    default: 
      return;
    case -23326: 
      paramShort2 = paramByteBuffer.getShort();
      BaseApplicationImpl.getContext().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("invitation_friend_entry", paramShort2).apply();
      return;
    case -23325: 
      paramShort2 = paramByteBuffer.getShort();
      BaseApplicationImpl.getContext().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("contacts_invite_friend_entry", paramShort2).apply();
      return;
    case -23366: 
      paramShort1 = paramByteBuffer.getShort();
      paramCard.extendFriendEntryContact = paramShort1;
      SharedPreUtils.a(this.appRuntime.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_contact", paramShort1).apply();
      return;
    case -23332: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramBundle = this.appRuntime.getCurrentUin();
        SettingCloneUtil.writeValue(this.appRuntime.getApp(), paramBundle, null, "qqsetting_show_push_message", bool1);
        return;
      }
    case -23370: 
      paramShort2 = paramByteBuffer.getShort();
      paramBundle = this.appRuntime.getApp();
      if (paramShort2 != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        TencentDocPref.b(paramBundle, String.valueOf(paramLong), bool1);
        return;
      }
    case -23312: 
    case -23310: 
    case -23309: 
    case -23308: 
    case -23168: 
    case -23166: 
    case -23158: 
      if (paramByteBuffer.getShort() == 1)
      {
        paramShort2 = 1;
        paramBundle = (TempMsgManager)this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        if (paramShort2 != 0) {
          break label390;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramBundle.a(paramShort1, bool1, false);
        return;
        paramShort2 = 0;
        break;
      }
    case -23161: 
      label390:
      if (paramByteBuffer.getShort() == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        ((TempMsgManager)this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(paramShort1, bool1, false);
        return;
      }
    }
    boolean bool2;
    if (paramByteBuffer.getShort() == 1)
    {
      bool1 = true;
      PttUtils.a((QQAppInterface)this.appRuntime);
      paramBundle = QVipAutoPttProcessor.c();
      boolean bool3 = VipUtils.b((QQAppInterface)this.appRuntime);
      bool2 = bool1;
      if (paramBundle.a > 1)
      {
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if (!bool3)
          {
            QLog.e("vip_ptt.TempGetProfileDetailProcessor", 1, "get ptt auto to txt online switch is ture but user is not svip!!");
            bool2 = false;
          }
        }
      }
      if (!bool2) {
        break label841;
      }
      paramCard = (PttAutoChangeBean)QConfigManager.a().a(442);
      if ((paramCard == null) || (paramCard.a())) {
        break label841;
      }
      QLog.e("vip_ptt.TempGetProfileDetailProcessor", 1, "get ptt auto to txt online switch is ture but config is close!!");
    }
    label841:
    for (boolean bool1 = false;; bool1 = bool2)
    {
      paramLong = NetConnInfoCenter.getServerTime();
      paramCard = "businessinfo_ptt_auto_change_text_" + this.appRuntime.getCurrentAccountUin();
      paramByteBuffer = "businessinfo_ptt_auto_change_time_" + this.appRuntime.getCurrentAccountUin();
      String str = "businessinfo_ptt_auto_change_guide_has_show_" + this.appRuntime.getCurrentAccountUin();
      SharedPreferences.Editor localEditor = this.appRuntime.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
      bool2 = PttSlideStateHelper.c;
      long l = PttSlideStateHelper.a;
      if (bool1)
      {
        if (!bool2)
        {
          localEditor.putLong(paramByteBuffer, paramLong);
          PttSlideStateHelper.a = paramLong;
        }
        localEditor.putBoolean(str, true);
        PttSlideStateHelper.d = true;
      }
      for (;;)
      {
        localEditor.putBoolean(paramCard, bool1);
        localEditor.apply();
        PttSlideStateHelper.c = bool1;
        QLog.e("vip_ptt.TempGetProfileDetailProcessor", 2, "handleGetDetailInfo autoToText onLine:" + bool1 + ", oldSwitch: " + bool2 + ", time:" + paramLong + ", oldTime:" + l + " conf.stage:" + paramBundle.a);
        return;
        bool1 = false;
        break;
        localEditor.putLong(paramByteBuffer, 9223372036854775807L);
      }
    }
  }
  
  private void handleGetDetailInfoInner8(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer, StudyModeManager.ModeFlag paramModeFlag)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool1 = true;
    switch (paramShort1)
    {
    default: 
      return;
    case -23221: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        StickerRecManager.a((QQAppInterface)this.appRuntime).a(bool1);
        ((CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(104, true, Boolean.valueOf(bool1));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("TempGetProfileDetailProcessor", 2, "handleGetDetailInfo emotionRec onLine:" + bool1);
        return;
      }
    case -23172: 
      if (paramByteBuffer.getShort() == 1) {}
      for (;;)
      {
        StudyModeManager.b(bool1);
        ((ModeSwitchManager)this.appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).c(bool1);
        return;
        bool1 = false;
      }
    case -23251: 
      paramShort1 = paramByteBuffer.getShort();
      paramModeFlag.a = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        paramModeFlag.d = bool1;
        return;
      }
    case -23174: 
      paramShort1 = paramByteBuffer.getShort();
      paramModeFlag.a = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool3;; bool1 = false)
      {
        paramModeFlag.c = bool1;
        return;
      }
    case -23104: 
      paramShort1 = paramByteBuffer.getShort();
      paramModeFlag.a = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool4;; bool1 = false)
      {
        paramModeFlag.b = bool1;
        return;
      }
    case -23046: 
      StudyModeManager.a(paramByteBuffer.getShort());
      return;
    case -23143: 
      paramShort1 = paramByteBuffer.getShort();
      ((CustomizeGrayTipsManager)this.appRuntime.getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).a(paramShort1);
      return;
    case -23103: 
      ((PaiYiPaiManager)this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a(paramByteBuffer.getShort());
      return;
    case -23102: 
      ((PaiYiPaiManager)this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(paramByteBuffer.getShort());
      return;
    case 27390: 
      ((PaiYiPaiManager)this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(paramByteBuffer.getShort());
      return;
    case -23108: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool5;; bool1 = false)
      {
        StudyModeManager.a(16, bool1);
        return;
      }
    case -23107: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool6;; bool1 = false)
      {
        StudyModeManager.a(32, bool1);
        return;
      }
    }
    if (paramByteBuffer.getShort() == 0) {}
    for (bool1 = bool7;; bool1 = false)
    {
      StudyModeManager.a(8, bool1);
      return;
    }
  }
  
  public void getActivateFriendSwitch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, "getActivateFriendSwitch");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25031));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isGetActivateFriend", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getBabyQSwitch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, "getBabyQSwitch");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25008));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isGetBabyQSwitch", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getCalReactiveSwitch()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, "getCalReactiveSwitch");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25007));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isGetCalReactive", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getCareBarEnable()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, "getCareBarEnable");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23234));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isCareBarEnable", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getClassicHeadActivityParams()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-24980));
    localArrayList.add(Short.valueOf((short)-23437));
    localArrayList.add(Short.valueOf((short)20015));
    getDetailCardInfo(localArrayList, null);
  }
  
  public void getCommonSwitch(short[] paramArrayOfShort)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, String.format("getCommonSwitch switchArray=%s", new Object[] { Arrays.toString(paramArrayOfShort) }));
    }
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfShort.length;
    while (i < j)
    {
      localArrayList.add(Short.valueOf(paramArrayOfShort[i]));
      i += 1;
    }
    Bundle localBundle = new Bundle();
    localBundle.putShortArray("switch_id_array", paramArrayOfShort);
    localBundle.putBoolean("isGetCommonSwitchFromDetailInfo", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getDetailCardInfo(List<Short> paramList, Bundle paramBundle)
  {
    getDetailCardInfo(paramList, paramBundle, this.appRuntime.getCurrentAccountUin());
  }
  
  public void getEmotionRecSwitch()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23221));
    getDetailCardInfo(localArrayList, null);
  }
  
  public void getHelloLiveMessageState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getHelloLiveMessageState");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25181));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("helloLiveMessage", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getLoginDaysSwitch()
  {
    getLoginDaysSwitch(this.appRuntime.getCurrentUin());
  }
  
  public void getLoginDaysSwitch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, String.format("getLoginDaysSwitch uin=%s", new Object[] { paramString }));
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25044));
    Bundle localBundle = new Bundle();
    localBundle.putString("switchUin", paramString);
    localBundle.putBoolean("isGetLoginDays", true);
    getDetailCardInfo(localArrayList, localBundle, paramString);
  }
  
  public void getOfficeUserFlag()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, "getOfficeUserFlag");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23449));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isOfficeUserFlag", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getPCActiveState()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getPCActiveState");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25042));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("pcActiveState", true);
    getDetailCardInfo(localArrayList, localBundle);
  }
  
  public void getQidianExt(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TempGetProfileDetailProcessor", 2, String.format("getQidianExt uin=%s isQidianSimple", new Object[] { paramString, Boolean.valueOf(paramBoolean) }));
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25126));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isQidianExt", true);
    localBundle.putBoolean("isQidianSimple", paramBoolean);
    getDetailCardInfo(localArrayList, localBundle, paramString);
  }
  
  public void getQidianMaster(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "isQidianMaster");
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25176));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isQidianMaster", true);
    getDetailCardInfo(localArrayList, localBundle, paramString, 160);
  }
  
  public void getTencentDocSwitch()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23370));
    getDetailCardInfo(localArrayList, null);
  }
  
  public void handleGetActivateFriendSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25031) {
      if (paramByteBuffer.getShort() != 0) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      this.isActivateFriendSwitchOpen = bool;
      ((ActivateFriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(this.isActivateFriendSwitchOpen, false);
      return;
    }
  }
  
  public void handleGetBabyQSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25008) {
      if (paramByteBuffer.getShort() != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      paramCard.babyQSwitch = bool;
      return;
    }
  }
  
  public void handleGetCalReactiveSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25007) {
      if (paramByteBuffer.getShort() == 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      paramCard.allowCalInteractive = bool;
      return;
    }
  }
  
  public void handleGetCareBarEnable(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -23234) {
      if (paramByteBuffer.getShort() != 0) {
        break label107;
      }
    }
    label107:
    for (boolean bool = true;; bool = false)
    {
      this.careBarEnable = bool;
      bool = SettingCloneUtil.isContainValue(BaseApplicationImpl.context, this.appRuntime.getCurrentAccountUin(), null, "qqsetting_special_care_bar");
      if (QLog.isColorLevel()) {
        QLog.i("TempGetProfileDetailProcessor", 2, "handleGetCareBarEnable: invoked.  careBarPerfExist: " + bool);
      }
      SettingCloneUtil.writeValue(this.appRuntime.getApplication(), String.valueOf(paramLong), null, "qqsetting_special_care_bar", this.careBarEnable);
      NotifyIdManager.a(this.careBarEnable);
      return;
    }
  }
  
  public void handleGetCommonSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    paramShort2 = 0;
    if (this.commonSwitchArray != null)
    {
      int i = 0;
      while (paramShort2 < this.commonSwitchArray.length)
      {
        if (paramShort1 == this.commonSwitchArray[paramShort2]) {
          i = 1;
        }
        paramShort2 += 1;
      }
      if (i != 0)
      {
        short s = paramByteBuffer.getShort();
        if (this.commonSwitchMap == null) {
          this.commonSwitchMap = new HashMap();
        }
        this.commonSwitchMap.put(Short.valueOf(paramShort1), Short.valueOf(s));
      }
    }
  }
  
  public void handleGetHelloLiveMessageState(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25181) {
      if (paramByteBuffer.getShort() != 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      this.isHelloLiveMessageEnable = bool;
      paramBundle = String.valueOf(paramLong);
      if (SettingCloneUtil.readValue(this.appRuntime.getApplication(), paramBundle, null, "qqsetting_hello_live_message", false) != this.isHelloLiveMessageEnable)
      {
        SettingCloneUtil.writeValue(this.appRuntime.getApplication(), paramBundle, null, "qqsetting_hello_live_message", this.isHelloLiveMessageEnable);
        paramCard = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
        paramCard.putExtra("isHelloLiveMessageEnable", this.isHelloLiveMessageEnable);
        paramCard.putExtra("uin", paramBundle);
        this.appRuntime.getApp().sendBroadcast(paramCard);
      }
      return;
    }
  }
  
  public void handleGetIsQiDianExt(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25126) {
      if (paramByteBuffer.getShort() == 0) {
        break label126;
      }
    }
    label126:
    for (paramShort1 = 1;; paramShort1 = 0)
    {
      this.qiDianExtAccountType = new BmqqAccountType(String.valueOf(paramLong), paramShort1);
      paramCard = (QidianManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.QIDIAN_MANAGER);
      paramCard.a(this.qiDianExtAccountType);
      boolean bool = paramBundle.getBoolean("isQidianSimple", false);
      if ((paramShort1 == 1) && (bool))
      {
        paramCard.a(this.appRuntime.getApp().getBaseContext(), this.qiDianExtAccountType);
        return;
      }
      paramCard.b(this.appRuntime.getApp().getBaseContext(), this.qiDianExtAccountType);
      return;
    }
  }
  
  public void handleGetIsQiDianMaster(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25176)
    {
      paramShort2 = paramByteBuffer.getShort();
      paramShort1 = 4;
      if (paramShort2 != 0) {
        paramShort1 = 6;
      }
      this.qiDianMasterAccountType = new BmqqAccountType(String.valueOf(paramLong), paramShort1);
      paramBundle = (QidianManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.QIDIAN_MANAGER);
      paramBundle.a(this.qiDianMasterAccountType);
      if (paramShort2 == 0) {
        break label157;
      }
      QLog.i("Q.profilecard.", 1, MsfSdkUtils.getShortUin(String.valueOf(paramLong)) + " handleGetIsQidianMaster is qidianmaster");
      paramCard = paramBundle.a(String.valueOf(paramLong));
      paramByteBuffer = paramBundle.a(String.valueOf(paramLong));
      if ((paramCard == null) || (paramByteBuffer == null)) {
        paramBundle.b(this.appRuntime.getApp().getBaseContext(), this.qiDianMasterAccountType);
      }
    }
    label157:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster sFieldValue: " + paramShort2);
  }
  
  public void handleGetLoginDaysSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    boolean bool = true;
    if (paramShort1 == -25044)
    {
      paramShort1 = paramByteBuffer.getShort();
      paramBundle = paramBundle.getString("switchUin");
      if (!TextUtils.equals(paramBundle, String.valueOf(paramLong))) {
        break label59;
      }
      if (paramShort1 == 0) {
        break label53;
      }
    }
    label53:
    for (bool = true;; bool = false)
    {
      paramCard.allowPeopleSee = bool;
      return;
    }
    label59:
    paramCard = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
    paramBundle = paramCard.getProfileCard(paramBundle, true);
    if (paramShort1 != 0) {}
    for (;;)
    {
      paramBundle.allowPeopleSee = bool;
      paramCard.saveProfileCard(paramBundle);
      return;
      bool = false;
    }
  }
  
  public void handleGetOfficeUserFlag(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -23449)
    {
      paramShort1 = paramByteBuffer.getShort();
      ((AppGuideTipsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.APP_GUIDE_TIPS_MANAGER)).a(paramShort1);
    }
  }
  
  public void handleGetPCActiveState(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25042) {
      if (paramByteBuffer.getShort() == 0) {
        break label120;
      }
    }
    label120:
    for (boolean bool = true;; bool = false)
    {
      this.pcActiveState = bool;
      paramBundle = String.valueOf(paramLong);
      if (SettingCloneUtil.readValue(this.appRuntime.getApplication(), paramBundle, null, "qqsetting_pcactive_key", false) != this.pcActiveState)
      {
        SettingCloneUtil.writeValue(this.appRuntime.getApplication(), paramBundle, null, "qqsetting_pcactive_key", this.pcActiveState);
        paramCard = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
        paramCard.putExtra("pcActive", this.pcActiveState);
        paramCard.putExtra("uin", paramBundle);
        this.appRuntime.getApp().sendBroadcast(paramCard);
      }
      return;
    }
  }
  
  public void onGetProfileDetailRequestForLogin(List<Short> paramList)
  {
    if (this.appRuntime.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
      paramList.add(Short.valueOf((short)-25040));
    }
    if (((Integer)NearbySPUtil.a(this.appRuntime.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
      paramList.add(Short.valueOf((short)-23549));
    }
    ClassicHeadActivityManager localClassicHeadActivityManager = (ClassicHeadActivityManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localClassicHeadActivityManager != null) && (localClassicHeadActivityManager.a()))
    {
      paramList.add(Short.valueOf((short)-23437));
      paramList.add(Short.valueOf((short)20015));
    }
  }
  
  public void onGetProfileDetailResponseBegin(Bundle paramBundle)
  {
    this.profileHeaderInfo = null;
    this.studyModeFlag = null;
    this.qiDianMasterAccountType = null;
    this.qiDianExtAccountType = null;
    this.pcActiveState = false;
    this.isHelloLiveMessageEnable = false;
    this.isActivateFriendSwitchOpen = false;
    this.commonSwitchArray = null;
    this.commonSwitchMap = null;
    this.careBarEnable = false;
  }
  
  public void onGetProfileDetailResponseEnd(Bundle paramBundle, boolean paramBoolean, Card paramCard)
  {
    CardHandler localCardHandler = (CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (paramBundle.getBoolean("isQidianMaster")) {
      localCardHandler.notifyUI(89, false, this.qiDianMasterAccountType);
    }
    if (paramBundle.getBoolean("isQidianExt")) {
      localCardHandler.notifyUI(68, paramBoolean, this.qiDianExtAccountType);
    }
    if (paramBundle.getBoolean("isGetLoginDays")) {
      localCardHandler.notifyUI(44, paramBoolean, new Object[] { Boolean.valueOf(paramCard.allowPeopleSee), paramCard.uin });
    }
    if (paramBundle.getBoolean("pcActiveState")) {
      localCardHandler.notifyUI(54, paramBoolean, Boolean.valueOf(this.pcActiveState));
    }
    if (paramBundle.getBoolean("helloLiveMessage")) {
      localCardHandler.notifyUI(88, paramBoolean, Boolean.valueOf(this.isHelloLiveMessageEnable));
    }
    if (paramBundle.getBoolean("isGetActivateFriend")) {
      localCardHandler.notifyUI(58, paramBoolean, Boolean.valueOf(this.isActivateFriendSwitchOpen));
    }
    FriendsManager localFriendsManager;
    if (paramBundle.getBoolean("isGetCalReactive"))
    {
      localFriendsManager = (FriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (!paramCard.allowCalInteractive) {
        break label361;
      }
    }
    label361:
    for (localFriendsManager.q = 1;; localFriendsManager.q = 0)
    {
      this.appRuntime.getApp().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("hotDisableInteractive", localFriendsManager.q).commit();
      localCardHandler.notifyUI(72, paramBoolean, Boolean.valueOf(paramCard.allowCalInteractive));
      if (paramBundle.getBoolean("isGetBabyQSwitch")) {
        localCardHandler.notifyUI(75, paramBoolean, Boolean.valueOf(paramCard.babyQSwitch));
      }
      if (paramBundle.getBoolean("isGetCommonSwitchFromDetailInfo")) {
        localCardHandler.notifyUI(85, paramBoolean, new Object[] { this.commonSwitchArray, this.commonSwitchMap });
      }
      if (paramBundle.getBoolean("isCareBarEnable")) {
        localCardHandler.notifyUI(103, paramBoolean, Boolean.valueOf(this.careBarEnable));
      }
      return;
    }
  }
  
  public void onGetProfileDetailTLV(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    handleGetDetailInfoInner3(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetDetailInfoInner4(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetDetailInfoInner6(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer, this.profileHeaderInfo);
    handleGetDetailInfoInner7(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetDetailInfoInner8(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer, this.studyModeFlag);
    handleGetIsQiDianMaster(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetIsQiDianExt(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetLoginDaysSwitch(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetPCActiveState(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetHelloLiveMessageState(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetActivateFriendSwitch(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetCalReactiveSwitch(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetBabyQSwitch(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetCommonSwitch(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetOfficeUserFlag(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
    handleGetCareBarEnable(paramBundle, paramLong, paramCard, paramShort1, paramShort2, paramByteBuffer);
  }
  
  public void onGetProfileDetailTLVBegin(Bundle paramBundle, long paramLong, Card paramCard)
  {
    this.profileHeaderInfo = new TempGetProfileDetailProcessor.ProfileHeaderInfo(null);
    this.studyModeFlag = new StudyModeManager.ModeFlag();
    this.isActivateFriendSwitchOpen = ((ActivateFriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(false);
    this.commonSwitchArray = paramBundle.getShortArray("switch_id_array");
  }
  
  public void onGetProfileDetailTLVEnd(Bundle paramBundle, long paramLong, Card paramCard)
  {
    paramBundle = (ClassicHeadActivityManager)this.appRuntime.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((paramBundle != null) && (paramBundle.a())) {
      paramBundle.a(this.profileHeaderInfo.headSysId, this.profileHeaderInfo.headType, this.profileHeaderInfo.qq18Switch);
    }
    if (this.studyModeFlag.a) {
      if ((!this.studyModeFlag.c) && (!this.studyModeFlag.b)) {
        break label205;
      }
    }
    label205:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("TempGetProfileDetailProcessor", 1, new Object[] { "[KidMode]studyModeFlag:", Boolean.valueOf(this.studyModeFlag.c), " kidModeFlag:", Boolean.valueOf(this.studyModeFlag.b), " simpleUi:", Boolean.valueOf(this.studyModeFlag.d) });
      StudyModeManager.a(bool, (QQAppInterface)this.appRuntime);
      ((ModeSwitchManager)this.appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).b(bool);
      StudyModeManager.a((QQAppInterface)this.appRuntime, bool, this.studyModeFlag.d);
      return;
    }
  }
  
  public void requestParseProfileLocation(Card paramCard)
  {
    ((ConditionSearchManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(paramCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor
 * JD-Core Version:    0.7.0.1
 */