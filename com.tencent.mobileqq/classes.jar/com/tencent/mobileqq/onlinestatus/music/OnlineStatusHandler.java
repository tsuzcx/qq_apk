package com.tencent.mobileqq.onlinestatus.music;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.OnLineStatusHelper;
import com.tencent.mobileqq.onlinestatus.OnlineMusicStatus;
import com.tencent.mobileqq.onlinestatus.OnlineStatusFriendsPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineMusicStatusManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusDataManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusOlympicManager;
import com.tencent.mobileqq.onlinestatus.manager.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.olympic.model.OlympicMedalEventInfo;
import com.tencent.mobileqq.onlinestatus.utils.MessagePBElemDecoder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.relation.api.IContactUtilsApi;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.msf.service.protocol.push.SvcRespRegister;
import com.tencent.msf.service.protocol.push.SvcRespSetToken;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.AppRuntime.Status;
import tencent.im.cs.cmd0xe59.cmd0xe59.ReqBody;
import tencent.im.cs.cmd0xe59.cmd0xe59.RspBody;
import tencent.im.groupstatus.ImStatus.ImStatusDataPush;
import tencent.im.oidb.cmd0xe62.ReqBody;
import tencent.im.statsvc.business.info.businessinfo.ReqBody;
import tencent.im.statsvc.business.info.businessinfo.RspBody;
import tencent.im.statsvc.song.StatSvcStatSong.ReqBody;
import tencent.im.statsvc.song.StatSvcStatSong.RspBody;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventInfo;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventRequest;
import trpc.qq_onlinestatus.olympic_medal.OlympicMedalEvent.MedalEventResponse;

@KeepClassConstructor
public class OnlineStatusHandler
  extends BusinessHandler
{
  private Friends a;
  private AppInterface b;
  private long c = -1L;
  private long d = -1L;
  private Handler e;
  private Handler f = new OnlineStatusHandler.4(this, ThreadManagerV2.getSubThreadLooper());
  
  public OnlineStatusHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.b = paramAppInterface;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        boolean bool2 = QLog.isColorLevel();
        bool1 = true;
        if (bool2) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetExtBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
        }
        if (i != 0) {
          break label333;
        }
        paramFromServiceMsg = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramToServiceMsg.getAttribute("online_status_permission_item");
        if (paramFromServiceMsg != null) {
          ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(new OnlineStatusFriendsPermissionItem(paramFromServiceMsg.isAllHasPermission(), paramFromServiceMsg.getPermissionUins()));
        }
        int k = paramToServiceMsg.extraData.getInt("StatusId");
        if (((Boolean)paramToServiceMsg.getAttribute("from_need_update_delay_time", Boolean.valueOf(false))).booleanValue())
        {
          paramFromServiceMsg = (OnlineStatusDataManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class);
          paramFromServiceMsg.a(k, j);
          paramFromServiceMsg.a(k, NetConnInfoCenter.getServerTime());
        }
        bool2 = ((Boolean)paramToServiceMsg.getAttribute("from_register", Boolean.valueOf(false))).booleanValue();
        boolean bool3 = ((Boolean)paramToServiceMsg.getAttribute("from_modify", Boolean.valueOf(false))).booleanValue();
        if ((bool2) || (bool3)) {
          break label333;
        }
        ((IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "")).updateOnlineStatus(AppRuntime.Status.online, k);
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      notifyUI(7, bool1, paramToServiceMsg.extraData);
      return;
      label333:
      if (i != 0) {
        bool1 = false;
      }
    }
  }
  
  private void c(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      paramFromServiceMsg = new businessinfo.RspBody();
      paramFromServiceMsg.mergeFrom((byte[])paramObject);
      int i = paramFromServiceMsg.uint32_error_code.get();
      paramObject = paramFromServiceMsg.string_error_msg.get();
      int j = paramFromServiceMsg.uint32_interval.get();
      if (QLog.isColorLevel())
      {
        QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetBatteryBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      paramFromServiceMsg.printStackTrace();
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        long l = ((Integer)paramToServiceMsg.getAttribute("StatusId", Integer.valueOf(0))).intValue();
        boolean bool2 = QLog.isColorLevel();
        bool1 = true;
        if (bool2) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j), " id=", Long.valueOf(l) });
        }
        if (i != 0) {
          break label227;
        }
        paramToServiceMsg = (OnlineStatusDataManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class);
        if (l > 40000L)
        {
          paramToServiceMsg.b(40000, j);
        }
        else
        {
          paramToServiceMsg.a(l, j);
          paramToServiceMsg.a((int)l, NetConnInfoCenter.getServerTime());
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      notifyUI(3, bool1, null);
      return;
      label227:
      if (i != 0) {
        bool1 = false;
      }
    }
  }
  
  private void d(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = ((SvcRespSetToken)paramObject).cReplyCode;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetPushToken res:", Boolean.valueOf(paramFromServiceMsg.isSuccess()), "replycode = ", Integer.valueOf(i) });
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      try
      {
        paramFromServiceMsg = new businessinfo.RspBody();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        i = paramFromServiceMsg.uint32_error_code.get();
        paramObject = paramFromServiceMsg.string_error_msg.get();
        int j = paramFromServiceMsg.uint32_interval.get();
        boolean bool2 = QLog.isColorLevel();
        bool1 = true;
        if (bool2) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetLocationBusinessInfo,errorCode  = ", Integer.valueOf(i), " errorMsg=", paramObject, " interval=", Integer.valueOf(j) });
        }
        if (i == 0)
        {
          paramFromServiceMsg = (OnlineStatusPermissionChecker.OnlineStatusPermissionItem)paramToServiceMsg.getAttribute("online_status_permission_item");
          if (paramFromServiceMsg != null) {
            ((OnlineStatusPermissionManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusPermissionManager.class)).a(new OnlineStatusFriendsPermissionItem(paramFromServiceMsg.isAllHasPermission(), paramFromServiceMsg.getPermissionUins()));
          }
          paramFromServiceMsg = (IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "");
          paramObject = (IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "");
          ((OnlineStatusDataManager)paramFromServiceMsg.getManager(IOnlineStatusDataManager.class)).b(-1, j);
          if (!((Boolean)paramToServiceMsg.getAttribute("from_register", Boolean.valueOf(false))).booleanValue()) {
            paramObject.updateOnlineStatus(AppRuntime.Status.online, -1L);
          }
        }
        else
        {
          this.b.runOnUiThread(new OnlineStatusHandler.2(this));
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return;
      }
      notifyUI(2, bool1, null);
      return;
      if (i != 0) {
        bool1 = false;
      }
    }
  }
  
  private void e(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SvcRespRegister)paramObject;
      long l1 = paramObject.timeStamp;
      byte b1 = paramObject.cReplyCode;
      long l2 = paramObject.iStatus;
      long l3 = paramObject.uExtOnlineStatus;
      long l4 = paramObject.uClientAutoStatusInterval;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusHandler", 2, new Object[] { "[status][autoMgr] handleRecvSetOnlineStatus timeStamp:", Long.valueOf(l1), " cCode:", Byte.valueOf(b1), " iStatus:", Long.valueOf(l2), " extOnlineStatus:", Long.valueOf(l3), " autoStatusInterval: ", Long.valueOf(l4) });
      }
      if (b1 == 0)
      {
        localBundle.putLong("onlineStatus", l2);
        localBundle.putLong("extStatus", l3);
        localBundle.putLong("autoStatusInterval", l4);
        paramFromServiceMsg = (IOnlineStatusService)this.b.getRuntimeService(IOnlineStatusService.class, "");
        paramFromServiceMsg.setOnlineStatus(AppRuntime.Status.build((int)l2));
        paramFromServiceMsg.setExtOnlineStatus(l3);
        ((OnlineStatusDataManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusDataManager.class)).a();
        notifyUI(1, true, localBundle);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "handleRecvSetOnlineStatus res:", Boolean.valueOf(paramFromServiceMsg.isSuccess()) });
    }
    notifyUI(1, false, localBundle);
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    paramToServiceMsg = new OlympicMedalEvent.MedalEventResponse();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, "handleOnlineInfoOlympicMedalEvent. ");
    }
    if (i != 0)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramObject = new StringBuilder();
        paramObject.append("handleOnlineInfoOlympicMedalEvent.  InvalidProtocolBufferMicroException result：");
        paramObject.append(paramFromServiceMsg.toString());
        QLog.e("OnlineStatusHandler", 1, paramObject.toString());
        i = j;
      }
    }
    else if (paramFromServiceMsg != null)
    {
      paramObject = new StringBuilder();
      paramObject.append("ERRCODE:");
      paramObject.append(paramFromServiceMsg.getResultCode());
      QLog.e("OnlineStatusHandler", 1, paramObject.toString());
    }
    if (i != 0)
    {
      paramFromServiceMsg = new OlympicMedalEventInfo();
      if (paramToServiceMsg.event_valid.has()) {
        paramFromServiceMsg.a(paramToServiceMsg.event_valid.get());
      } else {
        paramFromServiceMsg.a(true);
      }
      if (paramToServiceMsg.pull_interval_seconds.has()) {
        paramFromServiceMsg.a(paramToServiceMsg.pull_interval_seconds.get());
      }
      if (paramToServiceMsg.event.has()) {
        paramFromServiceMsg.a((OlympicMedalEvent.MedalEventInfo)paramToServiceMsg.event.get());
      }
      ((OnlineStatusOlympicManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineStatusOlympicManager.class)).a(paramFromServiceMsg);
    }
  }
  
  public Lyric a(String paramString)
  {
    Lyric localLyric2 = LyricParseHelper.a(paramString, true);
    Lyric localLyric1 = localLyric2;
    if (localLyric2 == null) {
      localLyric1 = LyricParseHelper.a(paramString, false);
    }
    return localLyric1;
  }
  
  public OnLineStatusHelper a()
  {
    return OnLineStatusHelper.a();
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "StatSvc.SyncBusinessInfo");
    businessinfo.ReqBody localReqBody = new businessinfo.ReqBody();
    int i = paramBundle.getInt("StatusId", 0);
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          paramBundle = new StringBuilder();
          paramBundle.append("error type:");
          paramBundle.append(paramInt);
          QLog.w("OnlineStatusHandler", 1, paramBundle.toString());
          return;
        }
        paramBundle = paramBundle.getByteArray("ExtInfo");
        localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
        localReqBody.uint32_ext_status.set(i);
        localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom(paramBundle));
        paramBundle = new cmd0xe62.ReqBody();
        localReqBody.private_info.set(paramBundle);
      }
      else
      {
        paramBundle = paramBundle.getByteArray("LocationInfo");
        localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
        localReqBody.uint32_ext_status.set(-1);
        localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom(paramBundle));
        paramBundle = new cmd0xe62.ReqBody();
        localReqBody.private_info.set(paramBundle);
        i = -1;
      }
    }
    else
    {
      i = paramBundle.getInt("BatteryInfo", 0);
      localReqBody.int32_battery_status.set(i);
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(1000);
      i = 1000;
    }
    localToServiceMsg.addAttribute("StatusId", Integer.valueOf(i));
    localToServiceMsg.addAttribute("business_type", Integer.valueOf(paramInt));
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSynBusinessInfo type:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(int paramInt, Bundle paramBundle, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "StatSvc.SetBusinessInfo");
    businessinfo.ReqBody localReqBody = new businessinfo.ReqBody();
    int i;
    if (paramInt != 1)
    {
      Object localObject;
      PBUInt32Field localPBUInt32Field;
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          localObject = paramBundle.getByteArray("ExtInfo");
          int j = paramBundle.getInt("StatusId");
          localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
          localReqBody.uint32_ext_status.set(j);
          localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom((byte[])localObject));
          if (paramOnlineStatusPermissionItem != null)
          {
            localObject = new cmd0xe62.ReqBody();
            localPBUInt32Field = ((cmd0xe62.ReqBody)localObject).set_type;
            if (paramOnlineStatusPermissionItem.isAllHasPermission()) {
              i = 1;
            } else {
              i = 2;
            }
            localPBUInt32Field.set(i);
            if (paramOnlineStatusPermissionItem.getPermissionUins() != null) {
              ((cmd0xe62.ReqBody)localObject).rpt_uint64_uin.set(paramOnlineStatusPermissionItem.getPermissionUins());
            }
            localReqBody.private_info.set((MessageMicro)localObject);
            localToServiceMsg.addAttribute("online_status_permission_item", paramOnlineStatusPermissionItem);
          }
          localToServiceMsg.extraData.putAll(paramBundle);
          if (QLog.isColorLevel()) {
            QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetBusinessInfo: invoked. ", " statusId: ", Integer.valueOf(j), " onlinePermission: ", paramOnlineStatusPermissionItem });
          }
        }
      }
      else
      {
        localObject = paramBundle.getByteArray("LocationInfo");
        localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
        localReqBody.uint32_ext_status.set(-1);
        localReqBody.bytes_business_info.set(ByteStringMicro.copyFrom((byte[])localObject));
        if (paramOnlineStatusPermissionItem != null)
        {
          localObject = new cmd0xe62.ReqBody();
          localPBUInt32Field = ((cmd0xe62.ReqBody)localObject).set_type;
          if (paramOnlineStatusPermissionItem.isAllHasPermission()) {
            i = 1;
          } else {
            i = 2;
          }
          localPBUInt32Field.set(i);
          if (paramOnlineStatusPermissionItem.getPermissionUins() != null) {
            ((cmd0xe62.ReqBody)localObject).rpt_uint64_uin.set(paramOnlineStatusPermissionItem.getPermissionUins());
          }
          localReqBody.private_info.set((MessageMicro)localObject);
          localToServiceMsg.addAttribute("online_status_permission_item", paramOnlineStatusPermissionItem);
        }
      }
    }
    else
    {
      i = paramBundle.getInt("BatteryInfo", 0);
      localReqBody.uint32_status.set(AppRuntime.Status.online.getValue());
      localReqBody.uint32_ext_status.set(1000);
      localReqBody.int32_battery_status.set(i);
    }
    localToServiceMsg.addAttribute("from_modify", Boolean.valueOf(paramBundle.getBoolean("from_modify", false)));
    localToServiceMsg.addAttribute("from_register", Boolean.valueOf(paramBundle.getBoolean("from_register", false)));
    localToServiceMsg.addAttribute("from_need_update_delay_time", Boolean.valueOf(paramBundle.getBoolean("from_need_update_delay_time", false)));
    localToServiceMsg.addAttribute("business_type", Integer.valueOf(paramInt));
    localToServiceMsg.putWupBuffer(localReqBody.toByteArray());
    sendPbReq(localToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetBusinessInfo type:", Integer.valueOf(paramInt) });
    }
  }
  
  public void a(Friends paramFriends)
  {
    String str = paramFriends.songId;
    if (QLog.isColorLevel()) {
      QLog.e("OnlineStatusHandler", 2, new Object[] { "getMusicLyric, id:", str });
    }
    Object localObject = (OnlineMusicStatusManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
    if (((OnlineMusicStatusManager)localObject).b.containsKey(str))
    {
      QLog.e("OnlineStatusHandler", 1, "getMusicLyric return, getting status");
      return;
    }
    this.a = paramFriends;
    ((OnlineMusicStatusManager)localObject).b.put(str, new Lyric(0, 0, null));
    localObject = new cmd0xe59.ReqBody();
    ((cmd0xe59.ReqBody)localObject).song_id.set(ByteStringMicro.copyFromUtf8(str));
    ((cmd0xe59.ReqBody)localObject).zip_compress_flag.set(true);
    if (!TextUtils.isEmpty(paramFriends.songName)) {
      ((cmd0xe59.ReqBody)localObject).song_name.set(ByteStringMicro.copyFromUtf8(paramFriends.songName));
    }
    if (!TextUtils.isEmpty(paramFriends.singerName)) {
      ((cmd0xe59.ReqBody)localObject).singer_name.set(ByteStringMicro.copyFromUtf8(paramFriends.singerName));
    }
    paramFriends = makeOIDBPkg("OidbSvc.0xe59", 3673, 0, ((cmd0xe59.ReqBody)localObject).toByteArray());
    paramFriends.getAttributes().put("songId", str);
    sendPbReq(paramFriends);
  }
  
  public void a(OnlineMusicStatus paramOnlineMusicStatus)
  {
    long l = a().a(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "pushMusicStatus curExtStatus:", Long.valueOf(l), ", ", paramOnlineMusicStatus });
    }
    Object localObject = paramOnlineMusicStatus;
    if (paramOnlineMusicStatus == null) {
      localObject = new OnlineMusicStatus();
    }
    if (l == 1028L)
    {
      paramOnlineMusicStatus = new StatSvcStatSong.ReqBody();
      paramOnlineMusicStatus.bool_need_convert.set(((OnlineMusicStatus)localObject).a);
      paramOnlineMusicStatus.uint32_song_type.set(((OnlineMusicStatus)localObject).d);
      paramOnlineMusicStatus.uint32_remaining_time.set(((OnlineMusicStatus)localObject).f);
      paramOnlineMusicStatus.uint32_source_type.set(((OnlineMusicStatus)localObject).g);
      paramOnlineMusicStatus.bytes_song_id.set(ByteStringMicro.copyFromUtf8(((OnlineMusicStatus)localObject).b));
      paramOnlineMusicStatus.bytes_song_name.set(ByteStringMicro.copyFromUtf8(((OnlineMusicStatus)localObject).c));
      paramOnlineMusicStatus.bytes_singer_name.set(ByteStringMicro.copyFromUtf8(((OnlineMusicStatus)localObject).e));
      paramOnlineMusicStatus.bool_pause_flag.set(((OnlineMusicStatus)localObject).h);
      paramOnlineMusicStatus.uint32_song_play_time.set(((OnlineMusicStatus)localObject).i);
      localObject = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "StatSvc.SetSong");
      ((ToServiceMsg)localObject).extraData.putBoolean("req_pb_protocol_flag", true);
      ((ToServiceMsg)localObject).putWupBuffer(paramOnlineMusicStatus.toByteArray());
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        StatSvcStatSong.RspBody localRspBody = new StatSvcStatSong.RspBody();
        localRspBody.mergeFrom((byte[])paramObject);
        int i = localRspBody.error_code.get();
        paramObject = localRspBody.error_msg.get();
        paramFromServiceMsg = "";
        if (localRspBody.bytes_song_id.get() != null) {
          paramFromServiceMsg = localRspBody.bytes_song_id.get().toStringUtf8();
        }
        QLog.d("OnlineStatusHandler", 1, new Object[] { "handlePushMusicStatusRsp, errorCode:", Integer.valueOf(i), " errorMsg:", paramObject, " convertSongId:", paramFromServiceMsg });
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", paramFromServiceMsg);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("songId", "");
    OnlineMusicStatusManager localOnlineMusicStatusManager = (OnlineMusicStatusManager)((IOnlineStatusManagerService)this.b.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
    if (paramFromServiceMsg != null) {}
    try
    {
      if ((paramFromServiceMsg.isSuccess()) && (!TextUtils.isEmpty(str)))
      {
        Object localObject = new cmd0xe59.RspBody();
        parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
        boolean bool1 = ((cmd0xe59.RspBody)localObject).safe_hit_flag.get();
        int i = ((cmd0xe59.RspBody)localObject).ret.get();
        int j = ((cmd0xe59.RspBody)localObject).sub_ret.get();
        paramObject = ((cmd0xe59.RspBody)localObject).msg.get().toStringUtf8();
        boolean bool2 = ((cmd0xe59.RspBody)localObject).zip_compress_flag.get();
        if ((i == 0) && (!bool1))
        {
          paramFromServiceMsg = new Lyric(0, 0, new ArrayList());
          paramToServiceMsg = paramFromServiceMsg;
          if (((cmd0xe59.RspBody)localObject).song_lyric.has())
          {
            localObject = ((cmd0xe59.RspBody)localObject).song_lyric.get().toByteArray();
            paramToServiceMsg = paramFromServiceMsg;
            if (localObject.length > 0)
            {
              if (bool2) {
                paramToServiceMsg = new String(MessagePBElemDecoder.a((byte[])localObject));
              } else {
                paramToServiceMsg = new String((byte[])localObject);
              }
              paramToServiceMsg = a(paramToServiceMsg);
            }
          }
          if (paramToServiceMsg != null) {
            localOnlineMusicStatusManager.b.put(str, paramToServiceMsg);
          }
        }
        else
        {
          localOnlineMusicStatusManager.b.remove(str);
          if ((bool1) && (this.a != null) && (str.equals(this.a.songId)))
          {
            this.a.songName = "";
            this.a.singerName = "";
            localOnlineMusicStatusManager.c.add(this.a.songId);
            ((IFriendHandlerTempService)this.b.getRuntimeService(IFriendHandlerTempService.class, "")).getOnlineInfo(this.a.uin, false);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusHandler", 2, new Object[] { "handleGetMusicLyric, ret:", Integer.valueOf(i), " subRet:", Integer.valueOf(j), " errorMsg:", paramObject, " zipFlag:", Boolean.valueOf(bool2), " safeHitFlag:", Boolean.valueOf(bool1) });
        }
      }
      else
      {
        localOnlineMusicStatusManager.b.remove(str);
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("OnlineStatusHandler", 1, "handleGetMusicLyric", paramToServiceMsg);
      localOnlineMusicStatusManager.b.remove(str);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusHandler", 2, new Object[] { "HPush_requestSetPushToken token:", paramString1 });
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.b.getCurrentAccountUin(), "PushService.SetToken");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("push_token", paramString1);
    localBundle.putString("push_profileid", paramString2);
    send(localToServiceMsg);
  }
  
  public void a(AppRuntime paramAppRuntime, AppRuntime.Status paramStatus, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" isAutoSet: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("OnlineStatusHandler", 2, new Object[] { "requestSetOnlineStatus onlineStatus:", paramStatus, " extStatus:", Long.valueOf(paramLong1), " largeSeq:", Long.valueOf(paramLong2), ((StringBuilder)localObject).toString() });
    }
    Object localObject = new ToServiceMsg("mobileqq.service", paramAppRuntime.getCurrentAccountUin(), "StatSvc.SetStatusFromClient");
    Bundle localBundle = ((ToServiceMsg)localObject).extraData;
    localBundle.putLong("K_SEQ", paramLong2);
    localBundle.putSerializable("onlineStatus", paramStatus);
    localBundle.putLong("extOnlineStatus", paramLong1);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong1 == 1000L))
    {
      paramAppRuntime = (IOnlineStatusService)paramAppRuntime.getRuntimeService(IOnlineStatusService.class, "");
      try
      {
        if (paramAppRuntime.getExtOnlineStatus() != 1000L) {
          paramAppRuntime.setPowerConnect(OnLineStatusHelper.i());
        }
      }
      catch (Throwable paramStatus)
      {
        QLog.e("OnlineStatusHandler", 1, "setOnlineStatus t:", paramStatus);
      }
      localBundle.putInt("batteryCapacity", paramAppRuntime.getBatteryCapacity());
      localBundle.putInt("powerConnect", paramAppRuntime.getPowerConnect());
    }
    localBundle.putBoolean("isAutoSet", paramBoolean);
    int i = OnlineStatusUtil.b();
    localBundle.putInt("vendor_push_type", i);
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("OnlineStatusHandler-requestSetOnlineStatus.vendor_push_type:");
      paramAppRuntime.append(i);
      QLog.d("OnlineStatusHandler", 2, paramAppRuntime.toString());
    }
    send((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getOlympicMedalEventReq ");
    ((StringBuilder)localObject).append(paramBoolean1);
    QLog.d("OnlineStatusHandler", 1, ((StringBuilder)localObject).toString(), new Throwable("打印堆栈"));
    if ((!paramBoolean2) && (!c(paramBoolean1)))
    {
      long l1;
      long l2;
      if (paramBoolean1)
      {
        l1 = this.c + 5000L;
        l2 = System.currentTimeMillis();
      }
      else
      {
        l1 = this.d + 300000L;
        l2 = System.currentTimeMillis();
      }
      l1 -= l2;
      localObject = this.f.obtainMessage();
      ((Message)localObject).obj = Boolean.valueOf(paramBoolean1);
      ((Message)localObject).what = 0;
      this.f.removeMessages(0);
      this.f.sendMessageDelayed((Message)localObject, l1);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendOlympicMedalEventReq after ");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append("ms");
      QLog.d("OnlineStatusHandler", 1, ((StringBuilder)localObject).toString());
      return;
    }
    b(paramBoolean1);
    QLog.d("OnlineStatusHandler", 1, "sendOlympicMedalEventReq.");
  }
  
  public Handler b()
  {
    if (this.e == null) {
      this.e = new Handler(ThreadManagerV2.getSubThreadLooper());
    }
    return this.e;
  }
  
  public void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          return;
        }
        paramFromServiceMsg = new ImStatus.ImStatusDataPush();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramObject = String.valueOf(paramFromServiceMsg.uint64_uin.get());
        j = paramFromServiceMsg.uint32_music_info_refresh.get();
        if (j != 1) {
          break label232;
        }
        paramFromServiceMsg = ((IMessageFacade)this.b.getRuntimeService(IMessageFacade.class, "")).getCurrChatUin();
        if (paramObject == null) {
          break label238;
        }
        if (paramObject.equals(paramFromServiceMsg)) {
          break label233;
        }
        if (!paramObject.equals(this.b.getCurrentAccountUin())) {
          break label238;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        int j;
        boolean bool;
        QLog.e("OnlineStatusHandler", 1, "handlePushMusicStatusRsp, ", paramFromServiceMsg);
      }
      bool = ((IContactUtilsApi)QRoute.api(IContactUtilsApi.class)).isContactShown();
      if ((i != 0) || (bool)) {
        b().postDelayed(new OnlineStatusHandler.3(this, paramObject), 500L);
      }
      QLog.d("OnlineStatusHandler", 1, new Object[] { "handleRecvMusicStatusPush, uin:", StringUtil.getSimpleUinForPrint(paramObject), " currentChatUin:", StringUtil.getSimpleUinForPrint(paramFromServiceMsg), " needRefresh:", Integer.valueOf(j), " isContactShown:", Boolean.valueOf(bool) });
      return;
      label232:
      return;
      label233:
      int i = 1;
      continue;
      label238:
      i = 0;
    }
  }
  
  void b(boolean paramBoolean)
  {
    OlympicMedalEvent.MedalEventRequest localMedalEventRequest = new OlympicMedalEvent.MedalEventRequest();
    localMedalEventRequest.from_aio.set(paramBoolean);
    ToServiceMsg localToServiceMsg = createToServiceMsg("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get");
    localToServiceMsg.putWupBuffer(localMedalEventRequest.toByteArray());
    sendPbReq(localToServiceMsg);
    if (paramBoolean)
    {
      this.c = System.currentTimeMillis();
      return;
    }
    this.d = System.currentTimeMillis();
  }
  
  public boolean c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.c + 5000L < System.currentTimeMillis()) {
        return true;
      }
    }
    else if (this.d + 300000L < System.currentTimeMillis()) {
      return true;
    }
    return false;
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("StatSvc.SetStatusFromClient");
      this.allowCmdSet.add("StatSvc.SetBusinessInfo");
      this.allowCmdSet.add("StatSvc.SyncBusinessInfo");
      this.allowCmdSet.add("StatSvc.SetSong");
      this.allowCmdSet.add("ImStatus.ReqPushStatus");
      this.allowCmdSet.add("OidbSvc.0xe59");
      this.allowCmdSet.add("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get");
      this.allowCmdSet.add("PushService.SetToken");
    }
    return this.allowCmdSet;
  }
  
  public Set<String> getPushPBCommandList()
  {
    return new OnlineStatusHandler.1(this);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return OnlineStatusObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if ((msgCmdFilter(str)) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onReceive, msgCmdFilter is true,cmd  = ");
        localStringBuilder.append(str);
        QLog.d("OnlineStatusHandler", 2, localStringBuilder.toString());
      }
      if ("StatSvc.SetSong".equals(str))
      {
        a(paramFromServiceMsg, paramObject);
        return;
      }
      if ("PushService.SetToken".equals(str))
      {
        d(paramFromServiceMsg, paramObject);
        return;
      }
      if ("StatSvc.SetStatusFromClient".equals(str))
      {
        e(paramFromServiceMsg, paramObject);
        return;
      }
      if ("StatSvc.SyncBusinessInfo".equals(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("StatSvc.SetBusinessInfo".equals(str))
      {
        int i = ((Integer)paramToServiceMsg.getAttribute("business_type", Integer.valueOf(-1))).intValue();
        if (i == 2)
        {
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (i == 1)
        {
          c(paramFromServiceMsg, paramObject);
          return;
        }
        if (i == 3) {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else
      {
        if ("ImStatus.ReqPushStatus".equals(str))
        {
          b(paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0xe59".equals(str))
        {
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("trpc.qq_status_rank.olympic_notice_sync.MedalEvent.Get".equals(str)) {
          e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler
 * JD-Core Version:    0.7.0.1
 */