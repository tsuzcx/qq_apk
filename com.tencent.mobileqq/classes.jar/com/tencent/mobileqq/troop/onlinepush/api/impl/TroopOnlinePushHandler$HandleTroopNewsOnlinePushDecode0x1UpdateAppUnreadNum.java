package com.tencent.mobileqq.troop.onlinepush.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopManagerService;
import com.tencent.mobileqq.troop.api.config.TroopOnlinePushHandlerProcessorConfig;
import com.tencent.mobileqq.troop.entereffect.TroopEnterEffectData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.observer.TroopRedDotObserver;
import com.tencent.mobileqq.troop.redpoint.api.IRedPointUtilsApi;
import com.tencent.mobileqq.troop.troopsurvey.api.ITroopSurveyHandler;
import com.tencent.mobileqq.troop.unreadmsg.TroopUnreadMsgInfo;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppID;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyContent;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppNotifyUser;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum;
import tencent.qun.group_effect.group_effect.EffectInfo;
import tencent.qun.group_effect.push_msg.PushMsg;

class TroopOnlinePushHandler$HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum
{
  private int jdField_a_of_type_Int;
  private TroopUnreadMsgInfo jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private List<TroopUnreadMsgInfo> jdField_a_of_type_JavaUtilList;
  private submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public TroopOnlinePushHandler$HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum(boolean paramBoolean, List<TroopUnreadMsgInfo> paramList, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, int paramInt, StringBuilder paramStringBuilder, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum)
  {
    this.b = paramList;
    this.jdField_a_of_type_JavaUtilList = paramTroopUnreadMsgInfo;
    this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo = paramInt;
    this.jdField_a_of_type_Int = paramStringBuilder;
    this.jdField_a_of_type_JavaLangStringBuilder = paramSubCmd0x1UpdateAppUnreadNum;
    Object localObject;
    this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum = localObject;
  }
  
  private void a()
  {
    Object localObject = (ITroopSurveyHandler)TroopOnlinePushHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopSurveyHandlerName());
    TroopOnlinePushHandlerProcessorConfig.a().a(TroopOnlinePushHandler.b(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 101618516L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopOnlinePushHandler", 2, "onLinePush receive 0x210_0x26_cmd0x1 troop mini app entrance.");
      }
      boolean bool;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setAIOTroopMiniAppEntranceRedPoint(TroopOnlinePushHandler.c(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, bool);
      TroopOnlinePushHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler, TroopRedDotObserver.c, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, Boolean.valueOf(bool) });
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1104445552L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopOnlinePushHandler", 2, "onLinePush receive 0x210_0x26_cmd0x1 homework.");
      }
      ((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).setAIOHomeworkBtnRedPoint(TroopOnlinePushHandler.d(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      TroopOnlinePushHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler, TroopRedDotObserver.jdField_a_of_type_Int, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, String.valueOf(1104445552), Boolean.valueOf(false) });
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106588005L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupPadTemplateNewsInfoTips(TroopOnlinePushHandler.e(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "group_pad_template_tips", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, true);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106664488L)
    {
      c();
      return;
    }
    if (((ITroopSurveyHandler)localObject).a(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo, this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum, 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, "handleTroopNewsOnlinePush() msginfo handled by Oidb0xb36");
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 101818344L)
    {
      if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has())
      {
        localObject = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
        if (((submsgtype0x26.AppTipNotify)localObject).bytes_text.has())
        {
          ((ITroopHonorService)TroopOnlinePushHandler.f(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getRuntimeService(ITroopHonorService.class, "")).updatePushTroopHonor(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, ((submsgtype0x26.AppTipNotify)localObject).bytes_text.get().toByteArray(), 0);
          ((ITroopManagerService)TroopOnlinePushHandler.g(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getRuntimeService(ITroopManagerService.class, "")).handleTroopMemberNewLevelChange(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, ((submsgtype0x26.AppTipNotify)localObject).bytes_text.get().toByteArray(), 0);
        }
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 101872323L)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b > 0)
        {
          ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(TroopOnlinePushHandler.h(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, true);
          TroopOnlinePushHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler, TroopRedDotObserver.d, true, new Object[] { this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString });
          return;
        }
        ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(TroopOnlinePushHandler.i(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, false);
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 101913298L) {
        ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(TroopOnlinePushHandler.j(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, "troop", 5, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      }
    }
  }
  
  private void b()
  {
    long l = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_id.uint64_app_id.get();
    this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo = new TroopUnreadMsgInfo();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo;
    ((TroopUnreadMsgInfo)localObject).jdField_a_of_type_Long = l;
    ((TroopUnreadMsgInfo)localObject).jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.uint64_group_code.get());
    this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.sint32_unread_num.get();
    this.jdField_a_of_type_Int += this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b;
    this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Int = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.sint32_album_cnt.get();
    boolean bool = this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has();
    int i = 0;
    if (bool)
    {
      localObject = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
      if (((submsgtype0x26.AppTipNotify)localObject).opt_msg_app_notify_content.has())
      {
        submsgtype0x26.AppNotifyContent localAppNotifyContent = (submsgtype0x26.AppNotifyContent)((submsgtype0x26.AppTipNotify)localObject).opt_msg_app_notify_content.get();
        List localList = localAppNotifyContent.opt_msg_app_notify_user.get();
        localObject = new long[localList.size()];
        while (i < localList.size())
        {
          localObject[i] = ((submsgtype0x26.AppNotifyUser)localList.get(i)).opt_uint64_uin.get();
          i += 1;
        }
        i = localAppNotifyContent.room_mode.get();
        j = localAppNotifyContent.game_id.get();
        k = localAppNotifyContent.live_extra_mode.get();
        break label264;
      }
    }
    localObject = null;
    i = 0;
    int j = 0;
    int k = -1;
    label264:
    TroopOnlinePushHandlerProcessorConfig.a().a(TroopOnlinePushHandler.k(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo, this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum, (long[])localObject, i, j, k);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 2L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.l(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "troop_photo_new", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(TroopOnlinePushHandler.m(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, "troop", 2, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.n(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "troop_photo_message", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Int);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.o(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "troop_file_new", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101236949L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.p(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "troop_notification_new", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101484419L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.q(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "group_activity_new_message", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1102858908L)
    {
      f();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1105933138L)
    {
      e();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long == 1106180084L) {
      d();
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b == -1) {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(TroopOnlinePushHandler.r(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, true);
    } else {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(TroopOnlinePushHandler.s(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler).getCurrentAccountUin(), "group_file_reddot_tim", this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, false);
    }
    TroopOnlinePushHandler localTroopOnlinePushHandler = this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler;
    int i = TroopRedDotObserver.g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
    TroopOnlinePushHandler.a(localTroopOnlinePushHandler, i, true, new Object[] { localStringBuilder.toString(), Boolean.valueOf(true) });
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "onLinePush receive 0x210_0x26_cmd0x1, [Enter Troop]");
    }
    if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.has())
    {
      Object localObject2 = (submsgtype0x26.AppTipNotify)this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum.msg_app_tip_notify.get();
      Object localObject1 = new push_msg.PushMsg();
      try
      {
        ((push_msg.PushMsg)localObject1).mergeFrom(((submsgtype0x26.AppTipNotify)localObject2).bytes_text.get().toByteArray());
        if (((push_msg.PushMsg)localObject1).rc.get() == 0)
        {
          int i = ((group_effect.EffectInfo)((push_msg.PushMsg)localObject1).effect_info.get()).effect_id.get();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((push_msg.PushMsg)localObject1).uin.get());
          localObject2 = ((StringBuilder)localObject2).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(((push_msg.PushMsg)localObject1).group_code.get());
          localObject1 = new TroopEnterEffectData(i, (String)localObject2, localStringBuilder.toString(), ((push_msg.PushMsg)localObject1).svip_level.get(), ((push_msg.PushMsg)localObject1).svip_type.get(), ((push_msg.PushMsg)localObject1).group_level.get(), ((push_msg.PushMsg)localObject1).set_mode.get());
          TroopOnlinePushHandler.a(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler, (TroopEnterEffectData)localObject1);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onLinePush receive 0x210_0x8ca error: ");
          ((StringBuilder)localObject2).append(QLog.getStackTraceString(localInvalidProtocolBufferMicroException));
          QLog.e("TroopEnterEffect", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b == -1) {
      TroopOnlinePushHandlerProcessorConfig.a().a(TroopOnlinePushHandler.t(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinepushApiImplTroopOnlinePushHandler), this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopNewsOnlinePush, msgInfo.nNewNum:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      QLog.d("TroopOnlinePushHandlerQ.hotchat.aio_post_red_point", 2, localStringBuilder.toString());
    }
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b == -1) || (this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b > 0)) {
      this.b = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopNewsOnlinePush, troopUin=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", nNewNum=");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
      QLog.i(".troop.notify_feeds.data", 2, localStringBuilder.toString());
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum a()
  {
    if (this.jdField_a_of_type_TencentImS2cMsgtype0x210Submsgtype0x26Submsgtype0x26$MsgBody$SubCmd0x1UpdateAppUnreadNum == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.troopgetnews..troop.notification_center", 4, "unreadNum is null");
      }
      this.jdField_a_of_type_Boolean = true;
      return this;
    }
    b();
    a();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = this.jdField_a_of_type_JavaLangStringBuilder;
      localStringBuilder.append("add photoinfo, groupCode = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", appid = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Long);
      localStringBuilder.append(", messageNum = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.jdField_a_of_type_Int);
      localStringBuilder.append(", newPhotoes = ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo.b);
    }
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo);
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public TroopUnreadMsgInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUnreadmsgTroopUnreadMsgInfo;
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinepush.api.impl.TroopOnlinePushHandler.HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum
 * JD-Core Version:    0.7.0.1
 */