package cooperation.ilive.lite.service;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ilivesdk.roomservice_interface.EnterExitRoomCallback;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceAdapter;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.room.DefaultCustomRoomService;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.countdown.IQQGiftCountDownModule;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.room.IAudienceRoom;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.data.QQLiveAudienceDtReportData;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveVideoStatus;
import com.tencent.mobileqq.qqlive.report.IQQLiveReportCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.QQLiveJumpUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class IliveCustomRoomService
  extends DefaultCustomRoomService
{
  private Context e;
  private RoomServiceAdapter f;
  private IAudienceRoom g;
  private ReceiveGiftMessageListener h;
  private IQQLiveSDK i;
  private QQLiveAudienceDtReportData j;
  private IQQLiveReportCallback k = new IliveCustomRoomService.1(this);
  
  private int a(LiveVideoStatus paramLiveVideoStatus)
  {
    if (paramLiveVideoStatus == null) {
      return 0;
    }
    if (paramLiveVideoStatus == LiveVideoStatus.Start) {
      return 1;
    }
    return 0;
  }
  
  private com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo a(com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo paramLiveAnchorInfo)
  {
    if (paramLiveAnchorInfo == null) {
      return null;
    }
    com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo localLiveAnchorInfo = new com.tencent.ilivesdk.roomservice_interface.model.LiveAnchorInfo();
    localLiveAnchorInfo.uid = paramLiveAnchorInfo.uid;
    localLiveAnchorInfo.businessUid = paramLiveAnchorInfo.businessUid;
    localLiveAnchorInfo.explicitId = paramLiveAnchorInfo.explicitId;
    localLiveAnchorInfo.headUrl = paramLiveAnchorInfo.headUrl;
    localLiveAnchorInfo.nickName = paramLiveAnchorInfo.nickName;
    localLiveAnchorInfo.imsdkTinyId = paramLiveAnchorInfo.imsdkTinyId;
    localLiveAnchorInfo.initialClientType = paramLiveAnchorInfo.initialClientType;
    return localLiveAnchorInfo;
  }
  
  private boolean b(long paramLong)
  {
    Object localObject = this.i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      localObject = ((IQQLiveSDK)localObject).getLoginModule();
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (paramLong == ((IQQLiveModuleLogin)localObject).getLoginInfo().uid) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void s()
  {
    int m = n();
    if (m == 0) {}
    while (m != 1)
    {
      m = 1;
      break;
    }
    m = 0;
    this.j = new QQLiveAudienceDtReportData(m, l(), m(), o(), r());
  }
  
  private void t()
  {
    if (this.h == null) {
      this.h = new IliveCustomRoomService.4(this);
    }
  }
  
  private IQQGiftSDK u()
  {
    return ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
  }
  
  public void exitRoom(EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    u().i().d();
    Object localObject = this.g;
    if (localObject != null)
    {
      ((IAudienceRoom)localObject).stopRoomTimer();
      k();
      this.g.exitRoom(new IliveCustomRoomService.3(this));
      localObject = this.k;
      if (localObject != null) {
        this.g.unRegisterReportCallback((IQQLiveReportCallback)localObject);
      }
      this.g.destroy();
      this.g = null;
    }
    if (paramEnterExitRoomCallback != null) {
      paramEnterExitRoomCallback.onSuccess();
    }
  }
  
  public RoomServiceAdapter i()
  {
    return this.f;
  }
  
  public void init(RoomServiceAdapter paramRoomServiceAdapter)
  {
    super.init(paramRoomServiceAdapter);
    this.f = paramRoomServiceAdapter;
  }
  
  public void j()
  {
    if (this.h == null) {
      t();
    }
    IAudienceRoom localIAudienceRoom = this.g;
    if (localIAudienceRoom != null) {
      localIAudienceRoom.registerReceiveGiftMessageListener(this.h);
    }
  }
  
  public void k()
  {
    IAudienceRoom localIAudienceRoom = this.g;
    if (localIAudienceRoom != null)
    {
      ReceiveGiftMessageListener localReceiveGiftMessageListener = this.h;
      if (localReceiveGiftMessageListener != null)
      {
        localIAudienceRoom.unRegisterReceiveGiftMessageListener(localReceiveGiftMessageListener);
        this.h = null;
      }
    }
    QLog.e("IliveReportModule", 1, "unRegisterRoomGiftListeners");
  }
  
  protected long l()
  {
    if ((this.c != null) && (this.c.extData != null)) {
      return this.c.extData.getLong("ext_enter_room_video_source_app_id", 0L);
    }
    QLog.e("IliveReportModule", 1, "[getVideoSource] get enter room info null!");
    return 0L;
  }
  
  protected int m()
  {
    if ((this.c != null) && (this.c.extData != null)) {
      return this.c.extData.getInt("ext_enter_room_game_id", 0);
    }
    QLog.e("IliveReportModule", 1, "[getGameTagId] get enter room info null!");
    return 0;
  }
  
  protected int n()
  {
    if ((this.c != null) && (this.c.extData != null)) {
      return this.c.extData.getInt("ext_enter_room_room_type", 0);
    }
    QLog.e("IliveReportModule", 1, "[getRoomType] get enter room info null!");
    return 0;
  }
  
  protected String o()
  {
    EnterRoomInfo localEnterRoomInfo = this.c;
    String str = "";
    if (localEnterRoomInfo == null)
    {
      QLog.e("IliveReportModule", 1, "[getSource] get enter room info null!");
      return "";
    }
    if (!TextUtils.isEmpty(this.c.source)) {
      return this.c.source;
    }
    if (this.c.extData != null) {
      str = this.c.extData.getString("source", "");
    }
    return str;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    this.e = paramContext;
    this.d = false;
    t();
    this.i = ((IQQLiveSDKManager)QRoute.api(IQQLiveSDKManager.class)).getSDKImpl("1037");
    if (!this.i.isInited())
    {
      QQLiveJumpUtil.a();
      QLog.e("IliveReportModule", 1, "liveSDK not init!");
    }
    paramContext = this.i.getLoginModule();
    if ((paramContext != null) && (!paramContext.isLogined()))
    {
      QQLiveJumpUtil.b();
      QLog.e("IliveReportModule", 1, "liveSDK not login!");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k();
    IAudienceRoom localIAudienceRoom = this.g;
    if (localIAudienceRoom != null) {
      localIAudienceRoom.destroy();
    }
    QLog.e("IliveReportModule", 1, "onDestroy");
  }
  
  protected String p()
  {
    EnterRoomInfo localEnterRoomInfo = this.c;
    String str = "";
    if (localEnterRoomInfo == null)
    {
      QLog.e("IliveReportModule", 1, "[getTraceInfo] get enter room info null!");
      return "";
    }
    if (this.c.extData != null) {
      str = this.c.extData.getString("trace_info", "");
    }
    return str;
  }
  
  protected String q()
  {
    EnterRoomInfo localEnterRoomInfo = this.c;
    String str = "";
    if (localEnterRoomInfo == null)
    {
      QLog.e("IliveReportModule", 1, "[getTraceInfo] get enter room info null!");
      return "";
    }
    if (this.c.extData != null) {
      str = this.c.extData.getString("session_id", "");
    }
    return str;
  }
  
  public String r()
  {
    Object localObject2 = "";
    String str = p();
    if ((str != null) && (str.contains("session_id"))) {
      return str;
    }
    try
    {
      localObject1 = new JSONObject();
      if (!TextUtils.isEmpty(str)) {
        localObject1 = new JSONObject(Uri.decode(str));
      }
      ((JSONObject)localObject1).put("session_id", q());
      localObject1 = ((JSONObject)localObject1).toString();
    }
    catch (Exception localException)
    {
      Object localObject1;
      label72:
      break label72;
    }
    QLog.e("IliveReportModule", 1, "");
    localObject1 = str;
    if (localObject1 == null) {
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getCurrentRecomInfo = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("IliveReportModule", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public void watchEnterRoom(EnterRoomInfo paramEnterRoomInfo, EnterExitRoomCallback paramEnterExitRoomCallback)
  {
    this.c = paramEnterRoomInfo;
    if (QLog.isColorLevel()) {
      QLog.d("IliveReportModule", 2, "watchEnterRoom");
    }
    if (paramEnterRoomInfo == null)
    {
      QLog.e("IliveReportModule", 1, "watchEnterRoom enterRoomInfo data is null!");
      return;
    }
    if (paramEnterRoomInfo.extData.getInt("ext_enter_room_room_type", 0) == 0)
    {
      this.g = this.i.createAudienceRoom(false);
      s();
      this.g.startRoomTimer(5000L);
      long l = System.currentTimeMillis();
      this.g.setEnterRoomTime(l);
      this.g.registerReportCallback(this.k);
      Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
      if (localObject != null)
      {
        localObject = ((AppRuntime)localObject).getCurrentUin();
      }
      else
      {
        QLog.e("IliveReportModule", 1, "getCurrentUin appRuntime is null!");
        localObject = "";
      }
      this.g.setSeq((String)localObject, String.valueOf(paramEnterRoomInfo.roomId), l);
      u().i().c();
      j();
    }
    ThreadManager.getSubThreadHandler().post(new IliveCustomRoomService.2(this, paramEnterRoomInfo, paramEnterExitRoomCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.service.IliveCustomRoomService
 * JD-Core Version:    0.7.0.1
 */