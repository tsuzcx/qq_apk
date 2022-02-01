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
  private boolean b;
  private boolean c;
  private List<TroopUnreadMsgInfo> d;
  private TroopUnreadMsgInfo e;
  private int f;
  private StringBuilder g;
  private submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum h;
  
  public TroopOnlinePushHandler$HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum(boolean paramBoolean, List<TroopUnreadMsgInfo> paramList, TroopUnreadMsgInfo paramTroopUnreadMsgInfo, int paramInt, StringBuilder paramStringBuilder, submsgtype0x26.MsgBody.SubCmd0x1UpdateAppUnreadNum paramSubCmd0x1UpdateAppUnreadNum)
  {
    this.c = paramList;
    this.d = paramTroopUnreadMsgInfo;
    this.e = paramInt;
    this.f = paramStringBuilder;
    this.g = paramSubCmd0x1UpdateAppUnreadNum;
    Object localObject;
    this.h = localObject;
  }
  
  private void f()
  {
    Object localObject = (ITroopSurveyHandler)TroopOnlinePushHandler.a(this.a).getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopSurveyHandlerName());
    TroopOnlinePushHandlerProcessorConfig.a().a(TroopOnlinePushHandler.b(this.a), this.e);
    if (this.e.a == 101618516L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopOnlinePushHandler", 2, "onLinePush receive 0x210_0x26_cmd0x1 troop mini app entrance.");
      }
      boolean bool;
      if (this.e.d != 0) {
        bool = true;
      } else {
        bool = false;
      }
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setAIOTroopMiniAppEntranceRedPoint(TroopOnlinePushHandler.c(this.a), this.e.b, bool);
      TroopOnlinePushHandler.a(this.a, TroopRedDotObserver.d, true, new Object[] { this.e.b, Boolean.valueOf(bool) });
      return;
    }
    if (this.e.a == 1104445552L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopOnlinePushHandler", 2, "onLinePush receive 0x210_0x26_cmd0x1 homework.");
      }
      ((IHWTroopUtilsApi)QRoute.api(IHWTroopUtilsApi.class)).setAIOHomeworkBtnRedPoint(TroopOnlinePushHandler.d(this.a), this.e.b, this.e.d);
      TroopOnlinePushHandler.a(this.a, TroopRedDotObserver.b, true, new Object[] { this.e.b, String.valueOf(1104445552), Boolean.valueOf(false) });
      return;
    }
    if (this.e.a == 1106588005L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupPadTemplateNewsInfoTips(TroopOnlinePushHandler.e(this.a).getCurrentAccountUin(), "group_pad_template_tips", this.e.b, true);
      return;
    }
    if (this.e.a == 1106664488L)
    {
      h();
      return;
    }
    if (((ITroopSurveyHandler)localObject).a(this.e, this.h, 2))
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.survey", 2, "handleTroopNewsOnlinePush() msginfo handled by Oidb0xb36");
      }
    }
    else if (this.e.a == 101818344L)
    {
      if (this.h.msg_app_tip_notify.has())
      {
        localObject = (submsgtype0x26.AppTipNotify)this.h.msg_app_tip_notify.get();
        if (((submsgtype0x26.AppTipNotify)localObject).bytes_text.has())
        {
          ((ITroopHonorService)TroopOnlinePushHandler.f(this.a).getRuntimeService(ITroopHonorService.class, "")).updatePushTroopHonor(this.e.b, ((submsgtype0x26.AppTipNotify)localObject).bytes_text.get().toByteArray(), 0);
          ((ITroopManagerService)TroopOnlinePushHandler.g(this.a).getRuntimeService(ITroopManagerService.class, "")).handleTroopMemberNewLevelChange(this.e.b, ((submsgtype0x26.AppTipNotify)localObject).bytes_text.get().toByteArray(), 0);
        }
      }
    }
    else
    {
      if (this.e.a == 101872323L)
      {
        if (this.e.d > 0)
        {
          ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(TroopOnlinePushHandler.h(this.a), this.e.b, true);
          TroopOnlinePushHandler.a(this.a, TroopRedDotObserver.e, true, new Object[] { this.e.b });
          return;
        }
        ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setTroopHasNewApp(TroopOnlinePushHandler.i(this.a), this.e.b, false);
        return;
      }
      if (this.e.a == 101913298L) {
        ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(TroopOnlinePushHandler.j(this.a), this.e.b, "troop", 5, this.e.d);
      }
    }
  }
  
  private void g()
  {
    long l = this.h.msg_app_id.uint64_app_id.get();
    this.e = new TroopUnreadMsgInfo();
    Object localObject = this.e;
    ((TroopUnreadMsgInfo)localObject).a = l;
    ((TroopUnreadMsgInfo)localObject).b = String.valueOf(this.h.uint64_group_code.get());
    this.e.d = this.h.sint32_unread_num.get();
    this.f += this.e.d;
    this.e.c = this.h.sint32_album_cnt.get();
    boolean bool = this.h.msg_app_tip_notify.has();
    int i = 0;
    if (bool)
    {
      localObject = (submsgtype0x26.AppTipNotify)this.h.msg_app_tip_notify.get();
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
    TroopOnlinePushHandlerProcessorConfig.a().a(TroopOnlinePushHandler.k(this.a), this.e, this.h, (long[])localObject, i, j, k);
    if (this.e.a == 2L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.l(this.a).getCurrentAccountUin(), "troop_photo_new", this.e.b, this.e.d);
      ((IRedPointUtilsApi)QRoute.api(IRedPointUtilsApi.class)).updateRedPointInfo(TroopOnlinePushHandler.m(this.a), this.e.b, "troop", 2, this.e.d);
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.n(this.a).getCurrentAccountUin(), "troop_photo_message", this.e.b, this.e.c);
      return;
    }
    if (this.e.a == 1L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.o(this.a).getCurrentAccountUin(), "troop_file_new", this.e.b, this.e.d);
      return;
    }
    if (this.e.a == 1101236949L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.p(this.a).getCurrentAccountUin(), "troop_notification_new", this.e.b, this.e.d);
      return;
    }
    if (this.e.a == 1101484419L)
    {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupGroupNewsInfo(TroopOnlinePushHandler.q(this.a).getCurrentAccountUin(), "group_activity_new_message", this.e.b, this.e.d);
      return;
    }
    if (this.e.a == 1102858908L)
    {
      k();
      return;
    }
    if (this.e.a == 1105933138L)
    {
      j();
      return;
    }
    if (this.e.a == 1106180084L) {
      i();
    }
  }
  
  private void h()
  {
    if (this.e.d == -1) {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(TroopOnlinePushHandler.r(this.a).getCurrentAccountUin(), "group_file_reddot_tim", this.e.b, true);
    } else {
      ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(TroopOnlinePushHandler.s(this.a).getCurrentAccountUin(), "group_file_reddot_tim", this.e.b, false);
    }
    TroopOnlinePushHandler localTroopOnlinePushHandler = this.a;
    int i = TroopRedDotObserver.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.e.b);
    TroopOnlinePushHandler.a(localTroopOnlinePushHandler, i, true, new Object[] { localStringBuilder.toString(), Boolean.valueOf(true) });
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect", 2, "onLinePush receive 0x210_0x26_cmd0x1, [Enter Troop]");
    }
    if (this.h.msg_app_tip_notify.has())
    {
      Object localObject2 = (submsgtype0x26.AppTipNotify)this.h.msg_app_tip_notify.get();
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
          TroopOnlinePushHandler.a(this.a, (TroopEnterEffectData)localObject1);
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
  
  private void j()
  {
    if (this.e.d == -1) {
      TroopOnlinePushHandlerProcessorConfig.a().a(TroopOnlinePushHandler.t(this.a), this.e.b);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopNewsOnlinePush, msgInfo.nNewNum:");
      localStringBuilder.append(this.e.d);
      QLog.d("TroopOnlinePushHandlerQ.hotchat.aio_post_red_point", 2, localStringBuilder.toString());
    }
  }
  
  private void k()
  {
    if ((this.e.d == -1) || (this.e.d > 0)) {
      this.c = true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopNewsOnlinePush, troopUin=");
      localStringBuilder.append(this.e.b);
      localStringBuilder.append(", nNewNum=");
      localStringBuilder.append(this.e.d);
      QLog.i(".troop.notify_feeds.data", 2, localStringBuilder.toString());
    }
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public TroopUnreadMsgInfo c()
  {
    return this.e;
  }
  
  public int d()
  {
    return this.f;
  }
  
  public HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum e()
  {
    if (this.h == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.troopgetnews..troop.notification_center", 4, "unreadNum is null");
      }
      this.b = true;
      return this;
    }
    g();
    f();
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = this.g;
      localStringBuilder.append("add photoinfo, groupCode = ");
      localStringBuilder.append(this.e.b);
      localStringBuilder.append(", appid = ");
      localStringBuilder.append(this.e.a);
      localStringBuilder.append(", messageNum = ");
      localStringBuilder.append(this.e.c);
      localStringBuilder.append(", newPhotoes = ");
      localStringBuilder.append(this.e.d);
    }
    this.d.add(this.e);
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.onlinepush.api.impl.TroopOnlinePushHandler.HandleTroopNewsOnlinePushDecode0x1UpdateAppUnreadNum
 * JD-Core Version:    0.7.0.1
 */