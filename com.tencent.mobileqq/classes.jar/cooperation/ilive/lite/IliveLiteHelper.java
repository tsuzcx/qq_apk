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
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.module.IliveLiteAudienceRoomModules;
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
import java.util.HashMap;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONObject;

public class IliveLiteHelper
{
  private static IliveLiteHelper jdField_a_of_type_CooperationIliveLiteIliveLiteHelper;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = -1L;
  private IBusinessExpireObserver.IBusinessInitFinish jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver$IBusinessInitFinish;
  private IBusinessExpireObserver jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver = new IliveLiteHelper.1(this);
  private IBizLoginObserver jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver;
  private ILiveLoginTicketListener jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginILiveLoginTicketListener = new IliveLiteHelper.2(this);
  private IliveAuthManager.Callback jdField_a_of_type_CooperationIliveManagerIliveAuthManager$Callback = new IliveLiteHelper.3(this);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  public static IliveLiteHelper a()
  {
    if (jdField_a_of_type_CooperationIliveLiteIliveLiteHelper == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (jdField_a_of_type_CooperationIliveLiteIliveLiteHelper == null) {
          jdField_a_of_type_CooperationIliveLiteIliveLiteHelper = new IliveLiteHelper();
        }
      }
    }
    return jdField_a_of_type_CooperationIliveLiteIliveLiteHelper;
  }
  
  private String a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    localJSONArray.put(this.jdField_b_of_type_JavaLangString);
    return Uri.encode(localJSONArray.toString());
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.e("IliveLiteHelper", 1, ((StringBuilder)localObject).toString());
    int i = this.jdField_a_of_type_Int;
    if ((i != 2) && (i != 4))
    {
      if (i == 3)
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_Int = 1;
        if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver != null)
        {
          localObject = new BizLoginRequest();
          ((BizLoginRequest)localObject).jdField_a_of_type_Int = 0;
          ((BizLoginRequest)localObject).jdField_a_of_type_JavaLangString = "1037";
          ((BizLoginRequest)localObject).c = paramstAuth.sUid;
          ((BizLoginRequest)localObject).jdField_d_of_type_JavaLangString = paramstAuth.sSessionKey;
          ((BizLoginRequest)localObject).jdField_b_of_type_JavaLangString = "1037";
          this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver.a((BizLoginRequest)localObject);
        }
        this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver = null;
      }
    }
    else
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      localObject = new BizLoginRequest();
      ((BizLoginRequest)localObject).jdField_a_of_type_Int = 0;
      ((BizLoginRequest)localObject).jdField_a_of_type_JavaLangString = "1037";
      ((BizLoginRequest)localObject).c = paramstAuth.sUid;
      ((BizLoginRequest)localObject).jdField_d_of_type_JavaLangString = paramstAuth.sSessionKey;
      ((BizLoginRequest)localObject).jdField_b_of_type_JavaLangString = "1037";
      LiteLiveSDKFactory.a().a((BizLoginRequest)localObject);
      e();
    }
  }
  
  public static void b()
  {
    BusinessConfig localBusinessConfig = LiteLiveSDKFactory.a().a();
    if ((localBusinessConfig != null) && (localBusinessConfig.jdField_a_of_type_JavaUtilHashMap != null) && (localBusinessConfig.jdField_a_of_type_JavaLangString.equals("1037"))) {
      localBusinessConfig.jdField_a_of_type_JavaUtilHashMap.remove("closejump");
    }
  }
  
  private void c()
  {
    if (LiteLiveSDKFactory.a().a())
    {
      QLog.e("EnterInitQuestion", 1, "IliveHelper initLiveSdk isInitSDK = true");
      localBusinessConfig = LiteLiveSDKFactory.a().a();
      if ((localBusinessConfig != null) && (localBusinessConfig.jdField_a_of_type_JavaLangString.equals("1037"))) {
        return;
      }
    }
    QLog.e("EnterInitQuestion", 1, "IliveHelper initLiveSdk isInitSDK = false");
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.jdField_a_of_type_JavaLangString = "1037";
    localBusinessConfig.jdField_e_of_type_Int = 0;
    localBusinessConfig.jdField_b_of_type_JavaLangString = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_a_of_type_Int = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_d_of_type_Int = 16594;
    localBusinessConfig.jdField_b_of_type_Int = 1400368383;
    Object localObject = IliveManagerConfProcessor.a();
    if (localObject != null)
    {
      localBusinessConfig.jdField_a_of_type_Boolean = (((IliveManagerCfgBean)localObject).a() ^ true);
      localBusinessConfig.jdField_b_of_type_Boolean = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("initLiveSdk isUseMutilWeb = ");
    ((StringBuilder)localObject).append(localBusinessConfig.jdField_a_of_type_Boolean);
    QLog.e("IliveLiteHelper", 1, ((StringBuilder)localObject).toString());
    localBusinessConfig.jdField_d_of_type_JavaLangString = "1";
    localBusinessConfig.jdField_e_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    LiteLiveSDKFactory.a().a("1037", this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver);
    LiteLiveSDKFactory.a().a("1037", 7, IliveLiteAudienceRoomModules.class);
    LiteLiveSDKFactory.a().a("1037", RoomSwitchInterface.class, LiveLiteSwitchRoomBuilder.class);
    LiteLiveSDKFactory.a().a("1037", RoomServiceInterface.class, IliveCustomRoomServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", ActivityLifeCycleService.class, IliveActivityLifeCycleServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", ChannelInterface.class, IliveMsfChannelServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", HostProxyInterface.class, IliveLiteHostProxyBuilder.class);
    LiteLiveSDKFactory.a().a("1037", FloatWindowConfigServiceInterface.class, IliveFloatWindowConfigServiceBuilder.class);
    LiteLiveSDKFactory.a().a("1037", MediaPlayerInterface.class, IliveMediaPlayerMgrServiceBuilder.class);
    LiteLiveSDKFactory.a().a(localBusinessConfig);
    LiteLiveSDKFactory.a().a("1037", this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginILiveLoginTicketListener);
    d();
  }
  
  private void d()
  {
    QLog.e("IliveLiteHelper", 1, "getAuthTicket");
    ElapseStat.a("Ilive auth");
    IliveAuthManager.getInstance().getStAuth(this.jdField_a_of_type_CooperationIliveManagerIliveAuthManager$Callback, true);
  }
  
  private void e()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("Ilive login success ");
    localStringBuilder1.append(this.jdField_a_of_type_Int);
    QLog.e("IliveLiteHelper", 1, localStringBuilder1.toString());
    int i = this.jdField_a_of_type_Int;
    boolean bool2;
    if (i == 2)
    {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
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
        bool1 = LiteLiveSDKFactory.a().a("1037", this.c);
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
        this.jdField_a_of_type_Int = 1;
        return;
        if (i == 4)
        {
          this.jdField_a_of_type_Int = 1;
          IBusinessExpireObserver.IBusinessInitFinish localIBusinessInitFinish = this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver$IBusinessInitFinish;
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
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    try
    {
      c();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.e("IliveLiteHelper", 1, "init exception", localThrowable);
    }
  }
  
  public void a(IliveJumpParams paramIliveJumpParams)
  {
    Object localObject;
    String str1;
    if ((paramIliveJumpParams != null) && (!TextUtils.isEmpty(paramIliveJumpParams.jdField_b_of_type_JavaLangString)))
    {
      QLog.e("IliveLiteHelper", 1, "enterRoom");
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_JavaLangString = paramIliveJumpParams.jdField_b_of_type_JavaLangString;
      this.jdField_b_of_type_JavaLangString = paramIliveJumpParams.c;
      if (TextUtils.isEmpty(paramIliveJumpParams.jdField_e_of_type_JavaLangString)) {
        paramIliveJumpParams.jdField_e_of_type_JavaLangString = "";
      }
      if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_b_of_type_JavaLangString = "";
      }
      if (TextUtils.isEmpty(paramIliveJumpParams.f)) {
        paramIliveJumpParams.f = "";
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      str1 = ((StringBuilder)localObject).toString();
    }
    try
    {
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramIliveJumpParams.f)) {
        localObject = new JSONObject(Uri.decode(paramIliveJumpParams.f));
      }
      ((JSONObject)localObject).put("session_id", str1);
      paramIliveJumpParams.f = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      label191:
      String str2;
      break label191;
    }
    QLog.e("IliveLiteHelper", 1, "");
    this.c = "mqqapi://now/openroom?roomtype=0&fromid=1037&roomid={roomId}&coverurl=&videoUrl={videoUrl}&pageType=1&starttime={startTime}&nocleartop={nocleartop}&closeJump={closeJump}&fromid={fromid}&trace_info={trace_info}&session_id={session_id}&first_click_time={first_click_time}";
    this.c = this.c.replace("{roomId}", this.jdField_a_of_type_JavaLangString);
    this.c = this.c.replace("{videoUrl}", a());
    this.c = this.c.replace("{fromid}", String.valueOf(paramIliveJumpParams.jdField_a_of_type_Int));
    this.c = this.c.replace("{startTime}", String.valueOf(System.currentTimeMillis()));
    str2 = this.c;
    if (paramIliveJumpParams.jdField_b_of_type_Boolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    this.c = str2.replace("{nocleartop}", (CharSequence)localObject);
    this.c = this.c.replace("{closeJump}", Uri.encode(paramIliveJumpParams.jdField_e_of_type_JavaLangString));
    this.c = this.c.replace("{trace_info}", Uri.encode(paramIliveJumpParams.f));
    this.c = this.c.replace("{session_id}", str1);
    this.c = this.c.replace("{first_click_time}", String.valueOf(IliveLiteMonitorUtil.a()));
    d();
    return;
    QLog.e("IliveLiteHelper", 1, "error enter room id null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteHelper
 * JD-Core Version:    0.7.0.1
 */