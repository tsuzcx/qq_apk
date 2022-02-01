package cooperation.ilive.lite;

import NS_KING_PUBLIC.stAuth;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.falco.base.libapi.activity.ActivityLifeCycleService;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
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
import cooperation.ilive.entity.IliveJumpParams;
import cooperation.ilive.lite.module.IliveLiteAudienceRoomModules;
import cooperation.ilive.lite.rommswitch.LiveLiteSwitchRoomBuilder;
import cooperation.ilive.lite.service.IliveActivityLifeCycleServiceBuilder;
import cooperation.ilive.lite.service.IliveCustomRoomServiceBuilder;
import cooperation.ilive.lite.service.IliveLiteHostProxyBuilder;
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
  private static IliveLiteHelper jdField_a_of_type_CooperationIliveLiteIliveLiteHelper = null;
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
    if (jdField_a_of_type_CooperationIliveLiteIliveLiteHelper == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_CooperationIliveLiteIliveLiteHelper == null) {
        jdField_a_of_type_CooperationIliveLiteIliveLiteHelper = new IliveLiteHelper();
      }
      return jdField_a_of_type_CooperationIliveLiteIliveLiteHelper;
    }
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
    QLog.e("IliveLiteHelper", 1, "handleGetAuthInfo success = " + paramBoolean);
    if (!paramBoolean) {
      QLog.e("IliveLiteHelper", 1, "ongetAuth info fail ");
    }
    BizLoginRequest localBizLoginRequest;
    do
    {
      return;
      QLog.e("IliveLiteHelper", 1, "Ilive login " + this.jdField_a_of_type_Int);
      if ((this.jdField_a_of_type_Int == 2) || (this.jdField_a_of_type_Int == 4))
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        localBizLoginRequest = new BizLoginRequest();
        localBizLoginRequest.jdField_a_of_type_Int = 0;
        localBizLoginRequest.jdField_a_of_type_JavaLangString = "1037";
        localBizLoginRequest.c = paramstAuth.sUid;
        localBizLoginRequest.jdField_d_of_type_JavaLangString = paramstAuth.sSessionKey;
        localBizLoginRequest.jdField_b_of_type_JavaLangString = "1037";
        LiteLiveSDKFactory.a().a(localBizLoginRequest);
        e();
        return;
      }
    } while (this.jdField_a_of_type_Int != 3);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = 1;
    if (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver != null)
    {
      localBizLoginRequest = new BizLoginRequest();
      localBizLoginRequest.jdField_a_of_type_Int = 0;
      localBizLoginRequest.jdField_a_of_type_JavaLangString = "1037";
      localBizLoginRequest.c = paramstAuth.sUid;
      localBizLoginRequest.jdField_d_of_type_JavaLangString = paramstAuth.sSessionKey;
      localBizLoginRequest.jdField_b_of_type_JavaLangString = "1037";
      this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver.a(localBizLoginRequest);
    }
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginIBizLoginObserver = null;
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
    boolean bool = true;
    QLog.e("IliveLiteHelper", 1, "initLiveSdk isEnableSingleWebView = " + ILiveLiteConfig.a());
    if (LiteLiveSDKFactory.a().a())
    {
      localBusinessConfig = LiteLiveSDKFactory.a().a();
      if ((localBusinessConfig != null) && (localBusinessConfig.jdField_a_of_type_JavaLangString.equals("1037"))) {
        return;
      }
    }
    BusinessConfig localBusinessConfig = new BusinessConfig();
    localBusinessConfig.jdField_a_of_type_JavaLangString = "1037";
    localBusinessConfig.jdField_e_of_type_Int = 0;
    localBusinessConfig.jdField_b_of_type_JavaLangString = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_a_of_type_Int = ApkUtils.a(BaseApplicationImpl.getContext());
    localBusinessConfig.jdField_d_of_type_Int = 16594;
    localBusinessConfig.jdField_b_of_type_Int = 1400368383;
    if (!ILiveLiteConfig.a()) {}
    for (;;)
    {
      localBusinessConfig.jdField_a_of_type_Boolean = bool;
      localBusinessConfig.jdField_d_of_type_JavaLangString = "1";
      localBusinessConfig.jdField_e_of_type_JavaLangString = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      LiteLiveSDKFactory.a().a("1037", this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver);
      LiteLiveSDKFactory.a().a("1037", 7, IliveLiteAudienceRoomModules.class);
      LiteLiveSDKFactory.a().a("1037", RoomSwitchInterface.class, LiveLiteSwitchRoomBuilder.class);
      LiteLiveSDKFactory.a().a("1037", RoomServiceInterface.class, IliveCustomRoomServiceBuilder.class);
      LiteLiveSDKFactory.a().a("1037", ActivityLifeCycleService.class, IliveActivityLifeCycleServiceBuilder.class);
      LiteLiveSDKFactory.a().a("1037", ChannelInterface.class, IliveMsfChannelServiceBuilder.class);
      LiteLiveSDKFactory.a().a("1037", HostProxyInterface.class, IliveLiteHostProxyBuilder.class);
      LiteLiveSDKFactory.a().a(localBusinessConfig);
      LiteLiveSDKFactory.a().a("1037", this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiLoginILiveLoginTicketListener);
      d();
      return;
      bool = false;
    }
  }
  
  private void d()
  {
    QLog.e("IliveLiteHelper", 1, "getAuthTicket");
    ElapseStat.a("Ilive auth");
    IliveAuthManager.getInstance().getStAuth(this.jdField_a_of_type_CooperationIliveManagerIliveAuthManager$Callback, true);
  }
  
  private void e()
  {
    QLog.e("IliveLiteHelper", 1, "Ilive login success " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 2) {
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        QLog.e("IliveLiteHelper", 1, "enter with empty roomid ");
      }
    }
    do
    {
      do
      {
        for (;;)
        {
          return;
          try
          {
            bool = LiteLiveSDKFactory.a().a("1037", this.c);
            if (bool)
            {
              this.jdField_a_of_type_Int = 1;
              return;
            }
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("IliveLiteHelper", 1, "enter room error " + localException);
              boolean bool = false;
            }
          }
        }
      } while (this.jdField_a_of_type_Int != 4);
      this.jdField_a_of_type_Int = 1;
    } while (this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver$IBusinessInitFinish == null);
    this.jdField_a_of_type_ComTencentMobileqqLitelivesdkApiIBusinessExpireObserver$IBusinessInitFinish.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 1;
    c();
  }
  
  public void a(IliveJumpParams paramIliveJumpParams)
  {
    if ((paramIliveJumpParams == null) || (TextUtils.isEmpty(paramIliveJumpParams.jdField_b_of_type_JavaLangString)))
    {
      QLog.e("IliveLiteHelper", 1, "error enter room id null");
      return;
    }
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
    try
    {
      localObject = new JSONObject();
      if (!TextUtils.isEmpty(paramIliveJumpParams.f)) {
        localObject = new JSONObject(Uri.decode(paramIliveJumpParams.f));
      }
      ((JSONObject)localObject).put("session_id", BaseApplicationImpl.getApplication().getRuntime().getAccount() + "_" + System.currentTimeMillis());
      paramIliveJumpParams.f = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str2;
        QLog.e("IliveLiteHelper", 1, "");
        continue;
        String str1 = "0";
      }
    }
    this.c = "mqqapi://now/openroom?roomtype=0&fromid=1037&roomid={roomId}&coverurl=&videoUrl={videoUrl}&pageType=1&starttime={startTime}&nocleartop={nocleartop}&closeJump={closeJump}&fromid={fromid}&trace_info={trace_info}";
    this.c = this.c.replace("{roomId}", this.jdField_a_of_type_JavaLangString);
    this.c = this.c.replace("{videoUrl}", a());
    this.c = this.c.replace("{fromid}", String.valueOf(paramIliveJumpParams.jdField_a_of_type_Int));
    this.c = this.c.replace("{startTime}", String.valueOf(System.currentTimeMillis()));
    str2 = this.c;
    if (paramIliveJumpParams.jdField_b_of_type_Boolean)
    {
      localObject = "1";
      this.c = str2.replace("{nocleartop}", (CharSequence)localObject);
      this.c = this.c.replace("{closeJump}", Uri.encode(paramIliveJumpParams.jdField_e_of_type_JavaLangString));
      this.c = this.c.replace("{trace_info}", Uri.encode(paramIliveJumpParams.f));
      d();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.IliveLiteHelper
 * JD-Core Version:    0.7.0.1
 */