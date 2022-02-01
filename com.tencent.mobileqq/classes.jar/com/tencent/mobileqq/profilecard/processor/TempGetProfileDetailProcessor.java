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
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConditionSearchManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageRoamManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doc.TencentDocPref;
import com.tencent.mobileqq.graytip.CustomizeGrayTipsManager;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandQuestionUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.studymode.StudyModeManager.ModeFlag;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
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
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = true;
    if (paramShort1 != -25217)
    {
      if (paramShort1 != -25200)
      {
        if (paramShort1 != -25040)
        {
          if (paramShort1 != -23776)
          {
            if (paramShort1 != -23754)
            {
              if (paramShort1 != -23723)
              {
                if (paramShort1 != -23549)
                {
                  if (paramShort1 != -23538)
                  {
                    if (paramShort1 != -23502)
                    {
                      if (paramShort1 != -23488) {
                        return;
                      }
                      short s = paramByteBuffer.getShort();
                      paramBundle = (LocalRedTouchManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
                      if (paramBundle != null) {
                        paramBundle.a(s);
                      }
                    }
                    else
                    {
                      paramShort1 = paramByteBuffer.getShort();
                      paramBundle = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
                      paramCard = this.appRuntime.getAccount();
                      if (paramShort1 == 1) {
                        bool1 = true;
                      }
                      paramBundle.setValue(paramCard, "is_nearby_novice", Boolean.valueOf(bool1));
                    }
                  }
                  else
                  {
                    paramShort1 = paramByteBuffer.getShort();
                    paramBundle = (INearbySPUtil)QRoute.api(INearbySPUtil.class);
                    paramCard = this.appRuntime.getAccount();
                    bool1 = bool3;
                    if (paramShort1 == 1) {
                      bool1 = true;
                    }
                    paramBundle.setValue(paramCard, "nearby_need_show_guide", Boolean.valueOf(bool1));
                  }
                }
                else
                {
                  paramShort1 = paramByteBuffer.getShort();
                  paramShort2 = ((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.appRuntime.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
                  if ((paramShort2 != paramShort1) && (paramShort2 != 1)) {
                    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.appRuntime.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(paramShort1));
                  }
                }
              }
              else
              {
                paramShort1 = paramByteBuffer.getShort();
                paramBundle = (MessageRoamManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
                if (paramBundle != null) {
                  paramBundle.e(paramShort1);
                }
              }
            }
            else
            {
              paramShort1 = paramByteBuffer.getShort();
              ((SmartDeviceProxyMgr)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramShort1);
            }
          }
          else if (paramByteBuffer.getShort() == 1) {
            NearbyManagerHelper.a((QQAppInterface)this.appRuntime).e();
          }
        }
        else
        {
          paramShort1 = paramByteBuffer.getShort();
          paramShort2 = this.appRuntime.getPreferences().getInt("nearby_people_profile_ok_new", -1);
          if ((paramShort2 != paramShort1) && (paramShort2 != 1)) {
            this.appRuntime.getPreferences().edit().putInt("nearby_people_profile_ok_new", paramShort1).commit();
          }
        }
      }
      else
      {
        paramShort1 = paramByteBuffer.getShort();
        ((SmartDeviceProxyMgr)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).c(paramShort1);
      }
    }
    else
    {
      if (paramByteBuffer.getShort() == 0) {
        paramShort1 = 1;
      } else {
        paramShort1 = 0;
      }
      paramShort2 = ((QQAppInterface)this.appRuntime).readCallTabStateVal(4);
      int i = ((QQAppInterface)this.appRuntime).readCallTabStateVal(0);
      if (i == 0)
      {
        paramBundle = new Integer[7];
        paramBundle[3] = Integer.valueOf(paramShort1);
        ((QQAppInterface)this.appRuntime).writeCallTabStateVal(paramBundle);
        return;
      }
      if ((i == 1) && (paramShort1 != paramShort2))
      {
        paramBundle = (CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
        bool1 = bool2;
        if (paramShort2 == 0) {
          bool1 = false;
        }
        paramBundle.b(bool1, false);
      }
    }
  }
  
  private void handleGetDetailInfoInner4(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (paramShort1 != -25188)
    {
      if (paramShort1 != -25155)
      {
        if (paramShort1 != -23753)
        {
          if (paramShort1 != -23461)
          {
            if (paramShort1 != -23282)
            {
              if (paramShort1 != 27034)
              {
                if (paramShort1 != 27055) {
                  return;
                }
                paramShort1 = paramByteBuffer.getInt();
                if (String.valueOf(paramLong).equals(this.appRuntime.getCurrentAccountUin())) {
                  ((ISVIPHandler)((QQAppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramShort1, false);
                }
              }
              else
              {
                paramBundle = new byte[paramShort2];
                paramByteBuffer.get(paramBundle);
                paramBundle = new String(paramBundle);
                if ((!TextUtils.isEmpty(paramBundle)) && (String.valueOf(paramLong).equals(this.appRuntime.getCurrentAccountUin()))) {
                  ((FriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.appRuntime.getCurrentAccountUin(), paramBundle, (byte)-1);
                }
              }
            }
            else
            {
              bool2 = paramCard.strangerInviteMeGroupOpen;
              if (paramByteBuffer.getShort() == 0) {
                bool1 = true;
              } else {
                bool1 = false;
              }
              paramCard.strangerInviteMeGroupOpen = bool1;
              bool1 = paramCard.strangerInviteMeGroupOpen;
              if (bool2 != bool1) {
                ((CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(93, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
              }
            }
          }
          else
          {
            bool2 = ((IUtil)QRoute.api(IUtil.class)).checkMedalRedPointConfig((QQAppInterface)this.appRuntime);
            if (paramByteBuffer.getShort() != 0) {
              bool1 = true;
            }
            paramCard.medalSwitchDisable = bool1;
            paramBundle = BaseApplicationImpl.getApplication();
            paramByteBuffer = new StringBuilder();
            paramByteBuffer.append("medal_wall_");
            paramByteBuffer.append(paramLong);
            paramBundle = paramBundle.getSharedPreferences(paramByteBuffer.toString(), 4).edit();
            paramBundle.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
            paramBundle.commit();
            bool1 = ((IUtil)QRoute.api(IUtil.class)).checkMedalRedPointConfig((QQAppInterface)this.appRuntime);
            if (bool2 != bool1) {
              ((IUtil)QRoute.api(IUtil.class)).onMedalConfigChanged((QQAppInterface)this.appRuntime, bool1);
            }
          }
        }
        else
        {
          paramShort1 = paramByteBuffer.getShort();
          paramBundle = (QQAppInterface)this.appRuntime;
          bool1 = bool3;
          if (paramShort1 > 0) {
            bool1 = true;
          }
          HotChatManager.b(paramBundle, bool1);
        }
      }
      else
      {
        bool3 = FriendIntimateRelationshipHelper.a(this.appRuntime.getCurrentUin());
        bool1 = bool2;
        if (paramByteBuffer.getShort() == 1) {
          bool1 = true;
        }
        if (bool3 != bool1) {
          FriendIntimateRelationshipHelper.a(this.appRuntime.getCurrentUin(), bool1);
        }
      }
    }
    else
    {
      bool1 = bool4;
      if (paramByteBuffer.getShort() == 0) {
        bool1 = true;
      }
      ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).setDisplayThirdQQChecked((QQAppInterface)this.appRuntime, bool1);
    }
  }
  
  private void handleGetDetailInfoInner6(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer, TempGetProfileDetailProcessor.ProfileHeaderInfo paramProfileHeaderInfo)
  {
    if (paramShort1 != -24980)
    {
      boolean bool1 = false;
      if (paramShort1 != -23456)
      {
        if (paramShort1 != -23437)
        {
          if (paramShort1 != -23322)
          {
            if (paramShort1 != 20015) {
              return;
            }
            paramProfileHeaderInfo.headSysId = paramByteBuffer.getShort();
            return;
          }
          short s = paramByteBuffer.getShort();
          paramCard.extendFriendQuestion = s;
          paramBundle = (IExpandQuestionUtils)QRoute.api(IExpandQuestionUtils.class);
          paramCard = this.appRuntime.getCurrentAccountUin();
          if (s == 1) {
            bool1 = true;
          }
          paramBundle.setAnswerQuestionFlag(paramCard, bool1);
          return;
        }
        paramProfileHeaderInfo.qq18Switch = paramByteBuffer.getShort();
        return;
      }
      paramShort1 = paramByteBuffer.getShort();
      paramBundle = new WholePeopleLebaEntryChecker((QQAppInterface)this.appRuntime);
      if (paramShort1 == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool2 = paramBundle.c;
      if (bool1 != bool2)
      {
        paramBundle.a((QQAppInterface)this.appRuntime, bool1);
        ((CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(89, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
      }
    }
    else
    {
      paramProfileHeaderInfo.headType = paramByteBuffer.getShort();
      if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.appRuntime.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() != paramProfileHeaderInfo.headType) {
        ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(this.appRuntime.getAccount(), "qq_avatar_type", Integer.valueOf(paramProfileHeaderInfo.headType));
      }
    }
  }
  
  private void handleGetDetailInfoInner7(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool5 = true;
    boolean bool2 = true;
    switch (paramShort1)
    {
    default: 
      return;
    case -20457: 
      if (paramByteBuffer.getShort() != 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      ((TempMsgManager)this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(paramShort1, bool1, false);
      return;
    case -20461: 
    case -20460: 
    case -20459: 
    case -20455: 
      if (paramByteBuffer.getShort() == 1) {
        bool1 = true;
      }
      ((TempMsgManager)this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(paramShort1, bool1);
      new RecentUserCacheHelper().a((AppInterface)this.appRuntime);
      ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).removeMsgBoxIfNecessary((AppInterface)this.appRuntime, true);
      return;
    case -23161: 
      if (paramByteBuffer.getShort() == 2) {
        bool1 = bool5;
      } else {
        bool1 = false;
      }
      ((TempMsgManager)this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(paramShort1, bool1, false);
      return;
    case -23249: 
      if (paramByteBuffer.getShort() == 1) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      ((ISttManagerApi)QRoute.api(ISttManagerApi.class)).initAutoToTextSwitch((QQAppInterface)this.appRuntime);
      paramBundle = QVipAutoPttProcessor.e();
      bool3 = VasUtil.b(this.appRuntime).getVipStatus().isSVip();
      bool1 = bool2;
      if (paramBundle.a > 1)
      {
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (!bool3)
          {
            QLog.e("vip_ptt.TempGetProfileDetailProcessor", 1, "get ptt auto to txt online switch is ture but user is not svip!!");
            bool1 = false;
          }
        }
      }
      bool2 = bool1;
      if (bool1)
      {
        paramCard = (PttAutoChangeBean)QConfigManager.b().b(442);
        bool2 = bool1;
        if (paramCard != null)
        {
          bool2 = bool1;
          if (!paramCard.a())
          {
            QLog.e("vip_ptt.TempGetProfileDetailProcessor", 1, "get ptt auto to txt online switch is ture but config is close!!");
            bool2 = false;
          }
        }
      }
      paramLong = NetConnInfoCenter.getServerTime();
      paramCard = new StringBuilder();
      paramCard.append("businessinfo_ptt_auto_change_text_");
      paramCard.append(this.appRuntime.getCurrentAccountUin());
      paramCard = paramCard.toString();
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("businessinfo_ptt_auto_change_time_");
      paramByteBuffer.append(this.appRuntime.getCurrentAccountUin());
      paramByteBuffer = paramByteBuffer.toString();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("businessinfo_ptt_auto_change_guide_has_show_");
      ((StringBuilder)localObject).append(this.appRuntime.getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      SharedPreferences.Editor localEditor = this.appRuntime.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
      bool1 = PttConstants.f;
      long l = PttConstants.g;
      if (bool2)
      {
        if (!bool1)
        {
          localEditor.putLong(paramByteBuffer, paramLong);
          PttConstants.g = paramLong;
        }
        localEditor.putBoolean((String)localObject, true);
        PttConstants.h = true;
      }
      else
      {
        localEditor.putLong(paramByteBuffer, 9223372036854775807L);
      }
      localEditor.putBoolean(paramCard, bool2);
      localEditor.apply();
      PttConstants.f = bool2;
      paramCard = new StringBuilder();
      paramCard.append("handleGetDetailInfo autoToText onLine:");
      paramCard.append(bool2);
      paramCard.append(", oldSwitch: ");
      paramCard.append(bool1);
      paramCard.append(", time:");
      paramCard.append(paramLong);
      paramCard.append(", oldTime:");
      paramCard.append(l);
      paramCard.append(" conf.stage:");
      paramCard.append(paramBundle.a);
      QLog.e("vip_ptt.TempGetProfileDetailProcessor", 2, paramCard.toString());
      return;
    case -23312: 
    case -23310: 
    case -23309: 
    case -23308: 
    case -23168: 
    case -23166: 
    case -23158: 
      if (paramByteBuffer.getShort() == 1) {
        paramShort2 = 1;
      } else {
        paramShort2 = 0;
      }
      ((TempMsgManager)this.appRuntime.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(paramShort1, paramShort2 ^ 0x1, false);
      return;
    case -23325: 
      paramShort2 = paramByteBuffer.getShort();
      BaseApplicationImpl.getContext().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("contacts_invite_friend_entry", paramShort2).apply();
      return;
    case -23326: 
      paramShort2 = paramByteBuffer.getShort();
      BaseApplicationImpl.getContext().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("invitation_friend_entry", paramShort2).apply();
      return;
    case -23332: 
      bool1 = bool3;
      if (paramByteBuffer.getShort() == 0) {
        bool1 = true;
      }
      paramBundle = this.appRuntime.getCurrentUin();
      SettingCloneUtil.writeValue(this.appRuntime.getApp(), paramBundle, null, "qqsetting_show_push_message", bool1);
      return;
    case -23366: 
      paramShort1 = paramByteBuffer.getShort();
      paramCard.extendFriendEntryContact = paramShort1;
      SharedPreUtils.a(this.appRuntime.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_contact", paramShort1).apply();
      return;
    }
    paramShort2 = paramByteBuffer.getShort();
    paramBundle = this.appRuntime.getApp();
    bool1 = bool4;
    if (paramShort2 != 0) {
      bool1 = true;
    }
    TencentDocPref.c(paramBundle, String.valueOf(paramLong), bool1);
  }
  
  private void handleGetDetailInfoInner8(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer, StudyModeManager.ModeFlag paramModeFlag)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool1 = false;
    if (paramShort1 != -23251)
    {
      if (paramShort1 != -23221)
      {
        if (paramShort1 != -23174)
        {
          if (paramShort1 != -23172)
          {
            if (paramShort1 != -23143)
            {
              if (paramShort1 != -23046)
              {
                if (paramShort1 != 27390)
                {
                  switch (paramShort1)
                  {
                  default: 
                    switch (paramShort1)
                    {
                    default: 
                      return;
                    case -23102: 
                      ((PaiYiPaiManager)this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(paramByteBuffer.getShort());
                      return;
                    case -23103: 
                      ((PaiYiPaiManager)this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a(paramByteBuffer.getShort());
                      return;
                    }
                    paramShort1 = paramByteBuffer.getShort();
                    paramModeFlag.a = true;
                    if (paramShort1 == 1) {
                      bool1 = true;
                    }
                    paramModeFlag.b = bool1;
                    return;
                  case -23106: 
                    bool1 = bool2;
                    if (paramByteBuffer.getShort() == 0) {
                      bool1 = true;
                    }
                    StudyModeManager.a(8, bool1);
                    return;
                  case -23107: 
                    bool1 = bool3;
                    if (paramByteBuffer.getShort() == 0) {
                      bool1 = true;
                    }
                    StudyModeManager.a(32, bool1);
                    return;
                  }
                  bool1 = bool4;
                  if (paramByteBuffer.getShort() == 0) {
                    bool1 = true;
                  }
                  StudyModeManager.a(16, bool1);
                  return;
                }
                ((PaiYiPaiManager)this.appRuntime.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(paramByteBuffer.getShort());
                return;
              }
              StudyModeManager.a(paramByteBuffer.getShort());
              return;
            }
            paramShort1 = paramByteBuffer.getShort();
            ((CustomizeGrayTipsManager)this.appRuntime.getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).a(paramShort1);
            return;
          }
          bool1 = bool5;
          if (paramByteBuffer.getShort() == 1) {
            bool1 = true;
          }
          StudyModeManager.b(bool1);
          ((ModeSwitchManager)this.appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).c(bool1);
          return;
        }
        paramShort1 = paramByteBuffer.getShort();
        paramModeFlag.a = true;
        bool1 = bool6;
        if (paramShort1 == 1) {
          bool1 = true;
        }
        paramModeFlag.c = bool1;
        return;
      }
      bool1 = bool7;
      if (paramByteBuffer.getShort() == 0) {
        bool1 = true;
      }
      ((IStickerRecManager)this.appRuntime.getRuntimeService(IStickerRecManager.class, "")).updateEmotionRecSetting(bool1);
      ((CardHandler)((AppInterface)this.appRuntime).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).notifyUI(102, true, Boolean.valueOf(bool1));
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("handleGetDetailInfo emotionRec onLine:");
        paramBundle.append(bool1);
        QLog.i("TempGetProfileDetailProcessor", 2, paramBundle.toString());
      }
    }
    else
    {
      paramShort1 = paramByteBuffer.getShort();
      paramModeFlag.a = true;
      bool1 = bool8;
      if (paramShort1 == 1) {
        bool1 = true;
      }
      paramModeFlag.d = bool1;
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
    boolean bool = QLog.isColorLevel();
    int i = 0;
    if (bool) {
      QLog.d("TempGetProfileDetailProcessor", 2, String.format("getCommonSwitch switchArray=%s", new Object[] { Arrays.toString(paramArrayOfShort) }));
    }
    if (paramArrayOfShort != null)
    {
      if (paramArrayOfShort.length == 0) {
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
    if (paramShort1 == -25031)
    {
      boolean bool;
      if (paramByteBuffer.getShort() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.isActivateFriendSwitchOpen = bool;
      ((ActivateFriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS)).a(this.isActivateFriendSwitchOpen, false);
    }
  }
  
  public void handleGetBabyQSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25008)
    {
      boolean bool;
      if (paramByteBuffer.getShort() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.babyQSwitch = bool;
    }
  }
  
  public void handleGetCalReactiveSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25007)
    {
      boolean bool;
      if (paramByteBuffer.getShort() != 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramCard.allowCalInteractive = bool;
    }
  }
  
  public void handleGetCareBarEnable(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -23234)
    {
      if (paramByteBuffer.getShort() == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.careBarEnable = bool;
      boolean bool = SettingCloneUtil.isContainValue(BaseApplicationImpl.context, this.appRuntime.getCurrentAccountUin(), null, "qqsetting_special_care_bar");
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("handleGetCareBarEnable: invoked.  careBarPerfExist: ");
        paramBundle.append(bool);
        QLog.i("TempGetProfileDetailProcessor", 2, paramBundle.toString());
      }
      SettingCloneUtil.writeValue(this.appRuntime.getApplication(), String.valueOf(paramLong), null, "qqsetting_special_care_bar", this.careBarEnable);
      NotifyIdManager.a(this.careBarEnable);
    }
  }
  
  public void handleGetCommonSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (this.commonSwitchArray != null)
    {
      paramShort2 = 0;
      int i = 0;
      for (;;)
      {
        paramBundle = this.commonSwitchArray;
        if (paramShort2 >= paramBundle.length) {
          break;
        }
        if (paramShort1 == paramBundle[paramShort2]) {
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
    if (paramShort1 == -25181)
    {
      boolean bool;
      if (paramByteBuffer.getShort() == 0) {
        bool = true;
      } else {
        bool = false;
      }
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
    }
  }
  
  public void handleGetIsQiDianExt(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25126)
    {
      if (paramByteBuffer.getShort() != 0) {
        paramShort1 = 1;
      } else {
        paramShort1 = 0;
      }
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
      if (paramShort2 != 0)
      {
        paramCard = new StringBuilder();
        paramCard.append(MsfSdkUtils.getShortUin(String.valueOf(paramLong)));
        paramCard.append(" handleGetIsQidianMaster is qidianmaster");
        QLog.i("Q.profilecard.", 1, paramCard.toString());
        paramCard = paramBundle.a(String.valueOf(paramLong));
        paramByteBuffer = paramBundle.c(String.valueOf(paramLong));
        if ((paramCard == null) || (paramByteBuffer == null)) {
          paramBundle.b(this.appRuntime.getApp().getBaseContext(), this.qiDianMasterAccountType);
        }
      }
      else if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("handleGetIsQidianMaster sFieldValue: ");
        paramBundle.append(paramShort2);
        QLog.d("Q.profilecard.", 2, paramBundle.toString());
      }
    }
  }
  
  public void handleGetLoginDaysSwitch(Bundle paramBundle, long paramLong, Card paramCard, short paramShort1, short paramShort2, ByteBuffer paramByteBuffer)
  {
    if (paramShort1 == -25044)
    {
      paramShort1 = paramByteBuffer.getShort();
      paramBundle = paramBundle.getString("switchUin");
      boolean bool3 = TextUtils.equals(paramBundle, String.valueOf(paramLong));
      boolean bool2 = false;
      boolean bool1 = false;
      if (bool3)
      {
        if (paramShort1 != 0) {
          bool1 = true;
        }
        paramCard.allowPeopleSee = bool1;
        return;
      }
      paramCard = (IProfileDataService)this.appRuntime.getRuntimeService(IProfileDataService.class, "all");
      paramBundle = paramCard.getProfileCard(paramBundle, true);
      bool1 = bool2;
      if (paramShort1 != 0) {
        bool1 = true;
      }
      paramBundle.allowPeopleSee = bool1;
      paramCard.saveProfileCard(paramBundle);
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
    if (paramShort1 == -25042)
    {
      boolean bool;
      if (paramByteBuffer.getShort() != 0) {
        bool = true;
      } else {
        bool = false;
      }
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
    }
  }
  
  public void onGetProfileDetailRequestForLogin(List<Short> paramList)
  {
    paramList.add(Short.valueOf((short)-23308));
    paramList.add(Short.valueOf((short)-23309));
    paramList.add(Short.valueOf((short)-23310));
    paramList.add(Short.valueOf((short)-23166));
    paramList.add(Short.valueOf((short)-23312));
    paramList.add(Short.valueOf((short)-23168));
    paramList.add(Short.valueOf((short)-23158));
    paramList.add(Short.valueOf((short)-23161));
    paramList.add(Short.valueOf((short)-20461));
    paramList.add(Short.valueOf((short)-20460));
    paramList.add(Short.valueOf((short)-20459));
    paramList.add(Short.valueOf((short)-20457));
    paramList.add(Short.valueOf((short)-20455));
    if (this.appRuntime.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
      paramList.add(Short.valueOf((short)-25040));
    }
    if (((Integer)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.appRuntime.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
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
      localCardHandler.notifyUI(87, false, this.qiDianMasterAccountType);
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
      localCardHandler.notifyUI(86, paramBoolean, Boolean.valueOf(this.isHelloLiveMessageEnable));
    }
    if (paramBundle.getBoolean("isGetActivateFriend")) {
      localCardHandler.notifyUI(58, paramBoolean, Boolean.valueOf(this.isActivateFriendSwitchOpen));
    }
    if (paramBundle.getBoolean("isGetCalReactive"))
    {
      FriendsManager localFriendsManager = (FriendsManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramCard.allowCalInteractive) {
        localFriendsManager.r = 1;
      } else {
        localFriendsManager.r = 0;
      }
      this.appRuntime.getApp().getSharedPreferences(this.appRuntime.getCurrentAccountUin(), 0).edit().putInt("hotDisableInteractive", localFriendsManager.r).commit();
      localCardHandler.notifyUI(70, paramBoolean, Boolean.valueOf(paramCard.allowCalInteractive));
    }
    if (paramBundle.getBoolean("isGetBabyQSwitch")) {
      localCardHandler.notifyUI(73, paramBoolean, Boolean.valueOf(paramCard.babyQSwitch));
    }
    if (paramBundle.getBoolean("isGetCommonSwitchFromDetailInfo")) {
      localCardHandler.notifyUI(83, paramBoolean, new Object[] { this.commonSwitchArray, this.commonSwitchMap });
    }
    if (paramBundle.getBoolean("isCareBarEnable")) {
      localCardHandler.notifyUI(101, paramBoolean, Boolean.valueOf(this.careBarEnable));
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
    if (this.studyModeFlag.a)
    {
      boolean bool;
      if ((!this.studyModeFlag.c) && (!this.studyModeFlag.b)) {
        bool = false;
      } else {
        bool = true;
      }
      QLog.d("TempGetProfileDetailProcessor", 1, new Object[] { "[KidMode]studyModeFlag:", Boolean.valueOf(this.studyModeFlag.c), " kidModeFlag:", Boolean.valueOf(this.studyModeFlag.b), " simpleUi:", Boolean.valueOf(this.studyModeFlag.d) });
      StudyModeManager.a(bool, (QQAppInterface)this.appRuntime);
      ((ModeSwitchManager)this.appRuntime.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).b(bool);
      StudyModeManager.a((QQAppInterface)this.appRuntime, bool, this.studyModeFlag.d);
    }
  }
  
  public void requestParseProfileLocation(Card paramCard)
  {
    ((ConditionSearchManager)((QQAppInterface)this.appRuntime).getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(paramCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor
 * JD-Core Version:    0.7.0.1
 */