package cooperation.ilive.lite;

import NS_KING_PUBLIC.stAuth;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.floatwindow.FloatWindowConfigServiceInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.ilive.LiveSDK;
import com.tencent.ilivesdk.avmediaservice_interface.MediaPlayerInterface;
import com.tencent.ilivesdk.roomservice_interface.RoomServiceInterface;
import com.tencent.ilivesdk.roomswitchservice_interface.RoomSwitchInterface;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver;
import com.tencent.mobileqq.litelivesdk.api.IBusinessExpireObserver.IBusinessInitFinish;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.api.login.IBizLoginObserver;
import com.tencent.mobileqq.litelivesdk.api.login.ILiveLoginTicketListener;
import com.tencent.mobileqq.litelivesdk.utils.ProcessUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.rommswitch.LiveLiteSwitchRoomBuilder;
import cooperation.ilive.lite.service.IliveActivityLifeCycleServiceBuilder;
import cooperation.ilive.lite.service.IliveCustomRoomServiceBuilder;
import cooperation.ilive.lite.service.IliveFloatWindowConfigServiceBuilder;
import cooperation.ilive.lite.service.IliveLiteHostProxyBuilder;
import cooperation.ilive.lite.service.IliveMediaPlayerMgrServiceBuilder;
import cooperation.ilive.lite.service.IliveMsfChannelServiceBuilder;
import cooperation.ilive.manager.IliveAuthManager;
import cooperation.ilive.manager.IliveAuthManager.Callback;
import cooperation.ilive.util.ElapseStat;
import cooperation.qqlive.QQLiveAudienceRoomModules;
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class IliveLiteHelper
{
  private static IliveLiteHelper a;
  private static final Object b = new Object();
  private String c;
  private String d;
  private String e;
  private int f;
  private long g = -1L;
  private IBizLoginObserver h;
  private IBusinessExpireObserver.IBusinessInitFinish i;
  private IBusinessExpireObserver j = new IliveLiteHelper.1(this);
  private ILiveLoginTicketListener k = new IliveLiteHelper.2(this);
  private IliveAuthManager.Callback l = new IliveLiteHelper.3(this);
  
  public static IliveLiteHelper a()
  {
    if (a == null) {
      synchronized (b)
      {
        if (a == null) {
          a = new IliveLiteHelper();
        }
      }
    }
    return a;
  }
  
  private void a(boolean paramBoolean, stAuth paramstAuth)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleGetAuthInfo success = ");
    ((StringBuilder)localObject).append(paramBoolean);
    QLog.e("IliveLiteHelper", 1, ((StringBuilder)localObject).toString());
    if (!paramBoolean)
    {
      QLog.e("IliveLiteHelper", 1, "ongetAuth info fail ");
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Ilive login ");
    ((StringBuilder)localObject).append(this.f);
    QLog.e("IliveLiteHelper", 1, ((StringBuilder)localObject).toString());
    int m = this.f;
    if ((m != 2) && (m != 4))
    {
      if (m == 3)
      {
        this.g = System.currentTimeMillis();
        this.f = 1;
        if (this.h != null)
        {
          localObject = new BizLoginRequest();
          ((BizLoginRequest)localObject).b = 0;
          ((BizLoginRequest)localObject).a = "1037";
          ((BizLoginRequest)localObject).d = paramstAuth.sUid;
          ((BizLoginRequest)localObject).e = paramstAuth.sSessionKey;
          ((BizLoginRequest)localObject).c = "1037";
          this.h.a((BizLoginRequest)localObject);
        }
        this.h = null;
      }
    }
    else
    {
      this.g = System.currentTimeMillis();
      localObject = new BizLoginRequest();
      ((BizLoginRequest)localObject).b = 0;
      ((BizLoginRequest)localObject).a = "1037";
      ((BizLoginRequest)localObject).d = paramstAuth.sUid;
      ((BizLoginRequest)localObject).e = paramstAuth.sSessionKey;
      ((BizLoginRequest)localObject).c = "1037";
      LiteLiveSDKFactory.a().a((BizLoginRequest)localObject);
      g();
    }
  }
  
  public static void c()
  {
    BusinessConfig localBusinessConfig = LiteLiveSDKFactory.a().b();
    if ((localBusinessConfig != null) && (localBusinessConfig.m != null) && (localBusinessConfig.a.equals("1037"))) {
      localBusinessConfig.m.remove("closejump");
    }
  }
  
  private void d()
  {
    if (LiteLiveSDKFactory.a().c())
    {
      QLog.e("EnterInitQuestion", 1, "IliveHelper initLiveSdk isInitSDK = true");
      localBusinessConfig = LiteLiveSDKFactory.a().b();
      if ((localBusinessConfig != null) && (localBusinessConfig.a.equals("1037"))) {
        return;
      }
    }
    QLog.e("EnterInitQuestion", 1, "IliveHelper initLiveSdk isInitSDK = false");
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.a = "1037";
    localBusinessConfig.h = 0;
    localBusinessConfig.b = ApkUtils.b(BaseApplicationImpl.getContext());
    localBusinessConfig.c = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.f = 16594;
    localBusinessConfig.d = 1400368383;
    Object localObject = IliveManagerConfProcessor.a();
    if (localObject != null)
    {
      localBusinessConfig.k = (((IliveManagerCfgBean)localObject).a() ^ true);
      localBusinessConfig.l = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initLiveSdk isUseMutilWeb = ");
    ((StringBuilder)localObject).append(localBusinessConfig.k);
    QLog.e("IliveLiteHelper", 1, ((StringBuilder)localObject).toString());
    localBusinessConfig.i = "1";
    localBusinessConfig.j = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    LiteLiveSDKFactory.a().a("1037", this.j);
    LiteLiveSDKFactory.a().a("1037", 7, QQLiveAudienceRoomModules.class);
    LiteLiveSDKFactory.a().a("1037", RoomSwitchInterface.class, LiveLiteSwitchRoomBuilder.class);
    LiteLiveSDKFactory.a().a("1037", RoomServiceInterface.class, IliveCustomRoomServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", ActivityLifeCycleService.class, IliveActivityLifeCycleServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", ChannelInterface.class, IliveMsfChannelServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", HostProxyInterface.class, IliveLiteHostProxyBuilder.class);
    LiteLiveSDKFactory.a().a("1037", FloatWindowConfigServiceInterface.class, IliveFloatWindowConfigServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", MediaPlayerInterface.class, IliveMediaPlayerMgrServiceBuilder.class);
    LiteLiveSDKFactory.a().a(localBusinessConfig);
    LiteLiveSDKFactory.a().a("1037", this.k);
    e();
  }
  
  private void e()
  {
    QLog.e("IliveLiteHelper", 1, "getAuthTicket");
    ElapseStat.a("Ilive auth");
    IliveAuthManager.getInstance().getStAuth(this.l, true);
  }
  
  private String f()
  {
    if (TextUtils.isEmpty(this.d)) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(this.d);
    return Uri.encode(localJSONArray.toString());
  }
  
  private void g()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Ilive login success ");
    localStringBuilder1.append(this.f);
    QLog.e("IliveLiteHelper", 1, localStringBuilder1.toString());
    int m = this.f;
    boolean bool2;
    if (m == 2)
    {
      if (TextUtils.isEmpty(this.c))
      {
        QLog.e("IliveLiteHelper", 1, "enter with empty roomid ");
        return;
      }
      bool2 = false;
    }
    for (;;)
    {
      try
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("IliveLiteHelper handleAfterLogin, liveEngine == null ? ");
        if (LiveSDK.userEngine != null) {
          break label221;
        }
        bool1 = true;
        localStringBuilder1.append(bool1);
        QLog.e("EnterInitQuestion", 1, localStringBuilder1.toString());
        bool1 = LiteLiveSDKFactory.a().a("1037", this.e);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("enter room error ");
        localStringBuilder2.append(localException);
        QLog.e("IliveLiteHelper", 1, localStringBuilder2.toString());
        bool1 = bool2;
      }
      if (bool1)
      {
        this.f = 1;
        return;
        if (m == 4)
        {
          this.f = 1;
          IBusinessExpireObserver.IBusinessInitFinish localIBusinessInitFinish = this.i;
          if (localIBusinessInitFinish != null) {
            localIBusinessInitFinish.a();
          }
        }
      }
      return;
      label221:
      boolean bool1 = false;
    }
  }
  
  public void a(IliveJumpParams paramIliveJumpParams)
  {
    if ((paramIliveJumpParams != null) && (!TextUtils.isEmpty(paramIliveJumpParams.c)))
    {
      QLog.e("IliveLiteHelper", 1, "enterRoom");
      this.f = 2;
      this.c = paramIliveJumpParams.c;
      this.d = paramIliveJumpParams.d;
      if (TextUtils.isEmpty(paramIliveJumpParams.h)) {
        paramIliveJumpParams.h = "";
      }
      if (TextUtils.isEmpty(this.d)) {
        this.d = "";
      }
      if (TextUtils.isEmpty(paramIliveJumpParams.j)) {
        paramIliveJumpParams.j = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      str3 = ((StringBuilder)localObject).toString();
    }
    try
    {
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramIliveJumpParams.j)) {
        localObject = new JSONObject(Uri.decode(paramIliveJumpParams.j));
      }
      ((JSONObject)localObject).put("session_id", str3);
      paramIliveJumpParams.j = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      label196:
      String str4;
      boolean bool;
      String str2;
      String str1;
      break label196;
    }
    QLog.e("IliveLiteHelper", 1, "");
    this.e = "mqqapi://now/openroom?roomtype=0&fromid=1037&roomid={roomId}&coverurl=&videoUrl={videoUrl}&pageType=1&starttime={startTime}&nocleartop={nocleartop}&tool_state={tool_state}&closeJump={closeJump}&fromid={fromid}&trace_info={trace_info}&session_id={session_id}&first_click_time={first_click_time}&room_type={room_type}&game_id={game_id}&game_tag_id={game_tag_id}&video_source={video_source}";
    this.e = this.e.replace("{roomId}", this.c);
    this.e = this.e.replace("{videoUrl}", f());
    this.e = this.e.replace("{fromid}", String.valueOf(paramIliveJumpParams.i));
    this.e = this.e.replace("{startTime}", String.valueOf(System.currentTimeMillis()));
    str4 = this.e;
    bool = paramIliveJumpParams.k;
    str2 = "1";
    str1 = "0";
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    this.e = str4.replace("{nocleartop}", (CharSequence)localObject);
    this.e = this.e.replace("{closeJump}", Uri.encode(paramIliveJumpParams.h));
    this.e = this.e.replace("{trace_info}", Uri.encode(paramIliveJumpParams.j));
    this.e = this.e.replace("{session_id}", str3);
    this.e = this.e.replace("{first_click_time}", String.valueOf(IliveLiteMonitorUtil.j()));
    String str3 = this.e;
    if (ProcessUtil.a()) {
      localObject = str2;
    } else {
      localObject = "0";
    }
    this.e = str3.replace("{tool_state}", (CharSequence)localObject);
    str2 = this.e;
    if (paramIliveJumpParams.m == null) {
      localObject = "0";
    } else {
      localObject = paramIliveJumpParams.m;
    }
    this.e = str2.replace("{room_type}", (CharSequence)localObject);
    str2 = this.e;
    if (paramIliveJumpParams.n == null) {
      localObject = "0";
    } else {
      localObject = paramIliveJumpParams.n;
    }
    this.e = str2.replace("{game_id}", (CharSequence)localObject);
    str2 = this.e;
    if (paramIliveJumpParams.o == null) {
      localObject = "0";
    } else {
      localObject = paramIliveJumpParams.o;
    }
    this.e = str2.replace("{game_tag_id}", (CharSequence)localObject);
    Object localObject = this.e;
    if (paramIliveJumpParams.p == null) {
      paramIliveJumpParams = str1;
    } else {
      paramIliveJumpParams = paramIliveJumpParams.p;
    }
    this.e = ((String)localObject).replace("{video_source}", paramIliveJumpParams);
    e();
    return;
    QLog.e("IliveLiteHelper", 1, "error enter room id null");
  }
  
  public void b()
  {
    this.f = 1;
    try
    {
      d();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("IliveLiteHelper", 1, "init exception", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteHelper
 * JD-Core Version:    0.7.0.1
 */