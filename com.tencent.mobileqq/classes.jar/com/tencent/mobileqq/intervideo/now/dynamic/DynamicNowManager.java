package com.tencent.mobileqq.intervideo.now.dynamic;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.TunnelInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.intervideo.nowproxy.InitData;
import com.tencent.intervideo.nowproxy.NowLive;
import com.tencent.intervideo.nowproxy.common.login.LoginData;
import com.tencent.intervideo.nowproxy.common.login.LoginType;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.WebAccelerator;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.bigbrother.JumpCallback;
import com.tencent.mobileqq.bigbrother.TeleScreen;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.Shadow;
import com.tencent.mobileqq.intervideo.now.LogUploadUtil;
import com.tencent.mobileqq.intervideo.now.NowDataReporter;
import com.tencent.mobileqq.intervideo.now.NowQQConnectFragment;
import com.tencent.mobileqq.intervideo.now.dynamic.strategy.IEnterRoomStrategy;
import com.tencent.mobileqq.intervideo.now.dynamic.strategy.StrategyManager;
import com.tencent.mobileqq.intervideo.yiqikan.IWatchTogetherRoomDelegate;
import com.tencent.mobileqq.intervideo.yiqikan.NewTogetherRoomMessageData;
import com.tencent.mobileqq.intervideo.yiqikan.OnOpenCloseRoomCallback;
import com.tencent.mobileqq.intervideo.yiqikan.PushMessageDelegate;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherManager;
import com.tencent.mobileqq.litelivesdk.LiteLiveSDKFactory;
import com.tencent.mobileqq.litelivesdk.api.ILiveSDK;
import com.tencent.mobileqq.litelivesdk.api.business.BusinessConfig;
import com.tencent.mobileqq.litelivesdk.api.login.BizLoginRequest;
import com.tencent.mobileqq.litelivesdk.utils.ProcessUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.lang.ref.WeakReference<Landroid.app.Activity;>;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;

public class DynamicNowManager
  implements IWatchTogetherRoomDelegate, Manager
{
  public static int a;
  static JumpCallback jdField_a_of_type_ComTencentMobileqqBigbrotherJumpCallback = new DynamicNowManager.11();
  static ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private final long jdField_a_of_type_Long = 1800000L;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new DynamicNowManager.6(this);
  private LoginType jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType = LoginType.QQConnect;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ILiveLoginTicketManager jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager;
  protected NowEntry a;
  NowShadowImpl jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowShadowImpl;
  private IEnterRoomStrategy jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy;
  PushMessageDelegate jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanPushMessageDelegate = new DynamicNowManager.12(this);
  private final AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(System.currentTimeMillis() - 1800000L);
  private boolean jdField_a_of_type_Boolean = true;
  private boolean b;
  
  static
  {
    UserAction.registerTunnel(new TunnelInfo("00000MEVUX3CBYO1"));
    jdField_a_of_type_JavaUtilArrayList = null;
    jdField_a_of_type_Int = -1;
  }
  
  public DynamicNowManager(QQAppInterface paramQQAppInterface)
  {
    try
    {
      QLog.i("XProxy|NowProxy", 1, "DynamicNowManager create app = " + paramQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager = new ILiveLoginTicketManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Shadow.a();
      PluginManagerInterfaceImpl.a().a(paramQQAppInterface);
      e();
      f();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowEntry = new NowEntry(paramQQAppInterface);
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
      paramQQAppInterface.addAction("mqq.intent.action.ACCOUNT_KICKED");
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("XProxy|NowProxy", 1, "initNowSdk exception ", paramQQAppInterface);
    }
  }
  
  public static int a(String paramString)
  {
    int i = 2;
    if ((paramString.equals("1")) || (paramString.equals("2"))) {
      i = 1;
    }
    return i;
  }
  
  private Bundle a(Bundle paramBundle, NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    paramBundle.putString("KEY_GROUP_UIN", paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString);
    paramBundle.putString("KEY_GROUP_OWNER_UIN", paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    paramBundle.putInt("KEY_ROOM_TYPE", paramNewTogetherRoomMessageData.jdField_a_of_type_Int);
    paramBundle.putLong("KEY_ROOM_ID", paramNewTogetherRoomMessageData.jdField_a_of_type_Long);
    paramBundle.putInt("KEY_OLD_ROOM_TYPE", paramNewTogetherRoomMessageData.c);
    paramBundle.putLong("KEY_OLD_ROOM_ID", paramNewTogetherRoomMessageData.jdField_b_of_type_Long);
    paramBundle.putString("KEY_ROOM_NAME", paramNewTogetherRoomMessageData.d);
    paramBundle.putString("KEY_JUMP_SCHEME", paramNewTogetherRoomMessageData.e);
    paramBundle.putString("KEY_ROOM_COVER", paramNewTogetherRoomMessageData.f);
    paramBundle.putString("KEY_FROM_ID", paramNewTogetherRoomMessageData.g);
    return paramBundle;
  }
  
  public static QQAppInterface a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    throw new InvalidParameterException("can't get AppInterface");
  }
  
  private static void a(long paramLong, String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      if (paramLong != 0L) {
        break label195;
      }
    }
    label195:
    for (str = "https://now.qq.com/qq/play.html?_bid=2374&_wv=16778245&from=50320";; str = "https://now.qq.com/h5/index.html?_bid=2336&_wv=16778245&from=50320&roomid=" + paramLong)
    {
      long l = System.currentTimeMillis();
      paramString1 = str + "&_t=" + l;
      PluginManagerInterfaceImpl.a().a().a("", String.valueOf(paramLong), paramString2, paramString1);
      paramString2 = new Intent(BaseApplicationImpl.getContext(), QQBrowserActivity.class);
      paramString2.putExtra("hide_operation_bar", true);
      paramString2.putExtra("url", paramString1);
      paramString2.putExtra("op_type", "now_live");
      paramString2.putExtra("key_isReadModeEnabled", true);
      paramString2.setFlags(268435456);
      paramString2.putExtra("insertPluginsArray", new String[] { "nowlive" });
      QLog.i("XProxy|NowProxy", 1, "跳转web页面 URL = " + paramString1 + " time = " + l);
      WebAccelerator.a(BaseApplicationImpl.getContext(), paramString2, paramString1);
      return;
    }
  }
  
  private void a(WeakReference<Activity> paramWeakReference, Bundle paramBundle, long paramLong, String paramString)
  {
    Object localObject1 = new StringBuilder().append("requestHostTicketByDoraemon call login onSuccess, timeconsume = ");
    long l;
    Object localObject2;
    if (paramLong == 0L)
    {
      l = -1L;
      QLog.i("DynamicNowManager", 1, l);
      localObject1 = paramBundle.getString("fromid");
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle);
      if ((paramBundle.getBoolean("isFinishContainerAct")) && (paramWeakReference != null) && (paramWeakReference.get() != null)) {
        ((Activity)paramWeakReference.get()).finish();
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a((String)localObject1)) {
        break label389;
      }
      e(paramBundle);
      LiteLiveSDKFactory.a().a((String)localObject2, paramBundle.getString("mqqScheme") + "&toolProcessState=" + paramString + "&startEnterTime=" + System.currentTimeMillis());
      localObject2 = new HashMap();
      ((Map)localObject2).put("appid", this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle));
      if (!this.b) {
        break label357;
      }
      paramWeakReference = "1";
      label208:
      ((Map)localObject2).put("zt_int4", paramWeakReference);
      ((Map)localObject2).put("zt_int5", paramString);
      ((Map)localObject2).put("act_type", "doraemon_success");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label364;
      }
      paramWeakReference = "";
      label259:
      ((Map)localObject2).put("fromid", paramWeakReference);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        break label370;
      }
      paramWeakReference = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      label286:
      ((Map)localObject2).put("userid", paramWeakReference);
      if (paramLong != 0L) {
        break label377;
      }
    }
    label357:
    label364:
    label370:
    label377:
    for (paramWeakReference = "-1";; paramWeakReference = String.valueOf(System.currentTimeMillis() - paramLong))
    {
      ((Map)localObject2).put("timelong", paramWeakReference);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a("00000MEVUX3CBYO1", "doraemon_success#room_page#room", true, -1L, -1L, (Map)localObject2, true, true);
      return;
      l = System.currentTimeMillis() - paramLong;
      break;
      paramWeakReference = "0";
      break label208;
      paramWeakReference = (WeakReference<Activity>)localObject1;
      break label259;
      paramWeakReference = "";
      break label286;
    }
    label389:
    paramBundle.putString("access_token", this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.b());
    paramBundle.putString("openid", this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a());
    g();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowEntry.b(paramBundle);
  }
  
  public static boolean a()
  {
    return PackageUtil.a(BaseApplicationImpl.getContext(), "com.tencent.now");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1);
  }
  
  private boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("XProxy|NowProxy", 1, "isTroopOwner  troopUin is null");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
      if (paramString != null)
      {
        boolean bool = paramString.isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
        QLog.i("XProxy|NowProxy", 1, "isTroopOwner  selfuin is " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + ";isOwner=" + bool);
        return bool;
      }
    }
    return false;
  }
  
  public static void d()
  {
    jdField_a_of_type_Int = TeleScreen.a().a(jdField_a_of_type_ComTencentMobileqqBigbrotherJumpCallback);
  }
  
  public static void d(Bundle paramBundle)
  {
    if (a())
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tnow://openpage/startlive?from=1"));
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      localIntent.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(localIntent);
      return;
    }
    a(0L, "https://a.app.qq.com/o/simple.jsp?pkgname=com.tencent.now&ckey=CK1339000284644", "beginLive");
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowShadowImpl = new NowShadowImpl();
    InitData localInitData = new InitData();
    localInitData.mAppID = "2";
    localInitData.mSourceVersion = String.valueOf(ApkUtils.a(BaseApplicationImpl.getContext()));
    localInitData.mSourceUid = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localInitData.mIsCpu64bit = false;
    NowLive.setShadowImp(this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowShadowImpl);
    NowLive.start(BaseApplicationImpl.getContext(), localInitData);
  }
  
  private void e(Bundle paramBundle)
  {
    BizLoginRequest localBizLoginRequest = new BizLoginRequest();
    localBizLoginRequest.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle);
    localBizLoginRequest.jdField_a_of_type_Int = 8;
    localBizLoginRequest.g = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a();
    localBizLoginRequest.f = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.b();
    localBizLoginRequest.jdField_b_of_type_JavaLangString = "101490787";
    LiteLiveSDKFactory.a().a(localBizLoginRequest);
  }
  
  private void f()
  {
    NowLive.setCustomizedLog(new DynamicNowManager.CustomizedLogImpl(null));
    NowLive.setCustomChannel(new DynamicNowManager.CustomizedChannelImpl(null));
    NowLive.setCustomizedLoading(new DynamicNowManager.CustomizedLoadingImpl(null));
    NowLive.setCustomizeReport(new DynamicNowManager.CustomizedReportImpl(null));
    NowLive.setCustomizedDownloader(new DynamicNowManager.CustomizedDownloaderImpl(null));
    NowLive.setCustomizedRecord(new DynamicNowManager.CustomizedRecordImpl(null));
    NowLive.setCustomizedShareForQQ(new DynamicNowManager.CustomizedShareForQQImpl(null));
    NowLive.setQQKandianInterface(new DynamicNowManager.QQKandianInterfaceImpl(null));
    NowLive.setCustomizedWebView(new DynamicNowManager.CustomizedWebViewImpl(null));
    NowLive.setCustomizedDns(new DynamicNowManager.CustomizedDnsImpl(null));
  }
  
  private void f(Bundle paramBundle)
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle);
    if (LiteLiveSDKFactory.a().a())
    {
      BusinessConfig localBusinessConfig = LiteLiveSDKFactory.a().a();
      if ((localBusinessConfig != null) && (localBusinessConfig.jdField_a_of_type_JavaLangString.equals(str))) {
        QLog.e("DynamicNowManager", 1, "DynamicNowManager, initLiteSDK--------Already Init, will Return");
      }
    }
    do
    {
      return;
      QLog.i("DynamicNowManager", 1, "-----initLiteSDk-----");
    } while (!this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle));
    LiteLiveSDKFactory.a().a(str, new DynamicNowManager.7(this, paramBundle));
    LiteLiveSDKFactory.a().a(str, new DynamicNowManager.8(this, paramBundle, str));
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle, str);
    LiteLiveSDKFactory.a().a(paramBundle);
  }
  
  private void g()
  {
    long l = System.currentTimeMillis() - this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    QLog.i("XProxy|NowProxy", 1, "login timeDiff: " + l);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (l >= 1800000L))
    {
      LoginData localLoginData = new LoginData();
      TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localTicketManager.getA2(str);
      localLoginData.setLoginType(this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType);
      localLoginData.setLoginAppid(16L);
      a(str, new DynamicNowManager.9(this, localLoginData, localTicketManager, str));
    }
  }
  
  public PushMessageDelegate a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanPushMessageDelegate;
  }
  
  public void a()
  {
    c(null);
  }
  
  public void a(Activity paramActivity, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      QLog.e("XProxy|NowProxy", 1, "activity or bundle is null");
      return;
    }
    long l2 = paramBundle.getLong("enter_ts");
    long l1 = -1L;
    if (l2 != 0L) {
      l1 = System.currentTimeMillis() - l2;
    }
    QLog.i("DynamicNowManager", 1, "realEntry----clickToEnterRoomConume " + l1);
    this.b = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = false;
    String str;
    HashMap localHashMap;
    if (ProcessUtil.a())
    {
      str = "0";
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle.getString("fromid")))
      {
        f(paramBundle);
        localHashMap = new HashMap();
        localHashMap.put("appid", this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle));
        localHashMap.put("zt_int3", String.valueOf(l1));
        if (!this.b) {
          break label348;
        }
        localObject = "1";
        label176:
        localHashMap.put("zt_int4", localObject);
        localHashMap.put("zt_int5", str);
        localHashMap.put("act_type", "qq_start_sdk");
        if (!TextUtils.isEmpty(paramBundle.getString("fromid"))) {
          break label356;
        }
        localObject = "";
        label234:
        localHashMap.put("fromid", localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
          break label368;
        }
      }
    }
    label348:
    label356:
    label368:
    for (Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();; localObject = "")
    {
      localHashMap.put("userid", localObject);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a("00000MEVUX3CBYO1", "qq_start_sdk#room_page#room", true, -1L, -1L, localHashMap, true, true);
      paramBundle.putBoolean("is_cpu_64bit", false);
      localObject = new WeakReference(paramActivity);
      if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a()) {
        break label376;
      }
      a((WeakReference)localObject, paramBundle, 0L, str);
      return;
      str = "1";
      break;
      localObject = "0";
      break label176;
      localObject = paramBundle.getString("fromid");
      break label234;
    }
    label376:
    l1 = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a(paramActivity, new DynamicNowManager.5(this, l1, paramBundle, str, (WeakReference)localObject));
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "enter login_type = " + this.jdField_a_of_type_ComTencentIntervideoNowproxyCommonLoginLoginType.ordinal());
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy = StrategyManager.a().a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramBundle, new DynamicNowManager.3(this, paramBundle));
  }
  
  public void a(Bundle paramBundle, DynamicNowManager.OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy == null) {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy = StrategyManager.a().a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    paramOnOpenCloseRoomCallback = paramBundle.getString("fromid");
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a(paramOnOpenCloseRoomCallback))
    {
      paramOnOpenCloseRoomCallback = null;
      if (SplashActivity.sWeakInstance != null) {
        paramOnOpenCloseRoomCallback = (Activity)SplashActivity.sWeakInstance.get();
      }
      Object localObject = paramOnOpenCloseRoomCallback;
      if (paramOnOpenCloseRoomCallback == null) {
        localObject = QBaseActivity.sTopActivity;
      }
      if (localObject == null)
      {
        paramBundle.putBoolean("isFinishContainerAct", true);
        paramBundle.putInt("jumpCallbackId", jdField_a_of_type_Int);
        paramOnOpenCloseRoomCallback = new Intent();
        paramOnOpenCloseRoomCallback.putExtras(paramBundle);
        paramOnOpenCloseRoomCallback.putExtra("public_fragment_window_feature", 1);
        PublicFragmentActivity.Launcher.a(paramOnOpenCloseRoomCallback, PublicTransFragmentActivity.class, NowQQConnectFragment.class);
        return;
      }
      paramBundle.putBoolean("isFinishContainerAct", false);
      a((Activity)localObject, paramBundle);
      return;
    }
    paramBundle.putBoolean("isFinishContainerAct", true);
    paramBundle.putInt("jumpCallbackId", jdField_a_of_type_Int);
    paramOnOpenCloseRoomCallback = new Intent();
    paramOnOpenCloseRoomCallback.putExtras(paramBundle);
    paramOnOpenCloseRoomCallback.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.Launcher.a(paramOnOpenCloseRoomCallback, PublicTransFragmentActivity.class, NowQQConnectFragment.class);
  }
  
  public void a(ConfigurationService.Config paramConfig) {}
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData)
  {
    a();
  }
  
  public void a(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("mqqScheme", paramNewTogetherRoomMessageData.e);
    localBundle.putBoolean("fromWatchTogether", true);
    localBundle.putString("group_uin", paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString);
    localBundle.putString("group_owner_uin", paramNewTogetherRoomMessageData.jdField_b_of_type_JavaLangString);
    localBundle.putString("group_name", ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString, false));
    localBundle.putBoolean("is_group_owner", a(paramNewTogetherRoomMessageData.jdField_a_of_type_JavaLangString));
    localBundle.putString("roomid", String.valueOf(paramNewTogetherRoomMessageData.jdField_a_of_type_Long));
    localBundle.putString("fromid", String.valueOf(paramNewTogetherRoomMessageData.g));
    a(localBundle, new DynamicNowManager.1(this, paramOnOpenCloseRoomCallback));
  }
  
  public void a(String paramString, @NonNull DynamicNowManager.OnGetSkeyListener paramOnGetSkeyListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      paramOnGetSkeyListener.a(2, null);
    }
    do
    {
      return;
      TicketManager localTicketManager = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
      if (localTicketManager == null)
      {
        paramOnGetSkeyListener.a(2, null);
        return;
      }
      paramString = localTicketManager.getSkey(paramString, 16L, new DynamicNowManager.10(this, paramOnGetSkeyListener));
    } while ((paramString == null) || (paramString._sig == null) || (paramString._sig.length == 0));
    paramOnGetSkeyListener.a(0, new String(paramString._sig));
  }
  
  public void b()
  {
    BaseApplicationImpl.getContext().sendBroadcast(new Intent("room.close.audio"));
  }
  
  public void b(Bundle paramBundle)
  {
    QLog.i("DynamicNowManager", 1, "DynamicNowManager, preloginLiteSDK------");
    if (!paramBundle.containsKey("kandian_003")) {
      paramBundle.putString("fromid", "kandian_003");
    }
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy = StrategyManager.a().a(paramBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicStrategyIEnterRoomStrategy.a("kandian_003"))
    {
      if ((LiteLiveSDKFactory.a().a()) && (LiteLiveSDKFactory.a().a() != null)) {
        QLog.e("DynamicNowManager", 1, "DynamicNowManager, preloginLiteSDK--------Already Init, will Return");
      }
    }
    else {
      return;
    }
    QLog.i("DynamicNowManager", 1, "DynamicNowManager, preloginLiteSDK------will Start");
    f(paramBundle);
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a(null, new DynamicNowManager.4(this, paramBundle));
      return;
    }
    e(paramBundle);
  }
  
  public void b(Bundle paramBundle, DynamicNowManager.OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    paramBundle.putInt("ctrl_cmd", 1);
    NowLive.closeRoom(paramBundle, new DynamicNowManager.13(this, paramOnOpenCloseRoomCallback));
  }
  
  public void b(NewTogetherRoomMessageData paramNewTogetherRoomMessageData, Bundle paramBundle, OnOpenCloseRoomCallback paramOnOpenCloseRoomCallback)
  {
    b(a(paramBundle, paramNewTogetherRoomMessageData), new DynamicNowManager.2(this, paramOnOpenCloseRoomCallback));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      LogUploadUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
  
  public void c(Bundle paramBundle)
  {
    QLog.i("XProxy|NowProxy", 1, "invoke preload");
    g();
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowEntry.a(paramBundle);
  }
  
  public void onDestroy()
  {
    QLog.i("XProxy|NowProxy", 1, "DynamicNowManager onDestroy mApp = " + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    NowLive.killPluginProcess();
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager.a();
      this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicILiveLoginTicketManager = null;
    }
    ((WatchTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.WATCH_LIVE_TOGETHER)).a(1);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoNowDynamicNowEntry.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    NowLive.setCustomizedLog(null);
    NowLive.setCustomChannel(null);
    NowLive.setCustomizedLoading(null);
    NowLive.setCustomizeReport(null);
    NowLive.setCustomizedDownloader(null);
    NowLive.setCustomizedRecord(null);
    NowLive.setCustomizedShareForQQ(null);
    NowLive.setQQKandianInterface(null);
    NowLive.setCustomizedWebView(null);
    NowLive.setCustomizedDns(null);
    PluginManagerInterfaceImpl.a();
    StrategyManager.a().a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.DynamicNowManager
 * JD-Core Version:    0.7.0.1
 */