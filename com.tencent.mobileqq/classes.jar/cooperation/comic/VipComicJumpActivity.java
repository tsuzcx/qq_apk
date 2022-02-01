package cooperation.comic;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.colornote.launcher.BoodoLauncher;
import com.tencent.mobileqq.config.business.QQComicConfBean;
import com.tencent.mobileqq.config.business.QQComicConfBean.BoodoHippyConfig;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqHandler;
import com.tencent.mobileqq.hitrate.PreloadProcHitPluginSession;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfo;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.StringBuilderUtils;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.comic.emoticon.VipComicEmoticonUploadRemoteCmd;
import cooperation.comic.utils.BoodoHippyBirdge;
import cooperation.comic.utils.QQComicPluginBridge;
import cooperation.comic.utils.QQComicRedTouchManager;
import cooperation.comic.utils.VipComicUrlHelper;
import cooperation.plugin.IPluginManager;
import eipc.EIPCClient;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class VipComicJumpActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback
{
  public static final String a;
  long jdField_a_of_type_Long = 0L;
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = null;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public WeakReferenceHandler a;
  VipComicJumpActivity.ComicParam jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam = null;
  public IPluginManager a;
  boolean jdField_a_of_type_Boolean = false;
  long jdField_b_of_type_Long = 0L;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  volatile boolean jdField_b_of_type_Boolean = false;
  long jdField_c_of_type_Long = 0L;
  boolean jdField_c_of_type_Boolean = false;
  private boolean d;
  
  static
  {
    jdField_a_of_type_JavaLangString = VipComicJumpActivity.class.getName();
  }
  
  private static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString)
    {
      QLog.e("VipComicJumpActivity", 1, paramString, new Object[0]);
    }
    return 0;
  }
  
  public static int a(String paramString, List<WebViewTabBarData> paramList)
  {
    int i = 0;
    while (i < paramList.size())
    {
      if (((WebViewTabBarData)paramList.get(i)).tag.equals(paramString)) {
        return i;
      }
      i += 1;
    }
    return 0;
  }
  
  private static QQComicConfBean.BoodoHippyConfig a()
  {
    if (BaseApplicationImpl.sProcessId == 1) {
      return QQComicConfBean.a();
    }
    return VipComicConfigHelper.a;
  }
  
  @Nullable
  private PreloadProcHitPluginSession a(VipComicJumpActivity.ComicParam paramComicParam, Intent paramIntent)
  {
    paramIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      paramIntent.putExtra("reportProcessExistFlag", i);
      paramIntent.putExtra("reportLebaClick", paramComicParam.jdField_a_of_type_Long);
      paramIntent.putExtra("reportJumpActivityOnCreate", paramComicParam.jdField_b_of_type_Long);
      if ((paramComicParam.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_a_of_type_Long > paramComicParam.jdField_b_of_type_Long)) {
        paramIntent.putExtra("reportDownloadTime", this.jdField_a_of_type_Long - paramComicParam.jdField_b_of_type_Long);
      }
      if ((this.jdField_b_of_type_Long != 0L) && (this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Long > this.jdField_a_of_type_Long)) {
        paramIntent.putExtra("reportInstallTime", this.jdField_b_of_type_Long - this.jdField_a_of_type_Long);
      }
      paramIntent.putExtra("reportStartPluginTime", System.currentTimeMillis());
      paramIntent.putExtra("isFromJumpActivity", true);
      paramIntent = PluginPreloadReportUtils.a(2);
      paramComicParam = null;
      if (paramIntent != null)
      {
        paramIntent.a();
        paramComicParam = paramIntent.a;
      }
      return paramComicParam;
    }
  }
  
  public static VipComicJumpActivity.ComicParam a(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    VipComicJumpActivity.ComicParam localComicParam = new VipComicJumpActivity.ComicParam();
    JSONObject localJSONObject = a(paramIntent, localComicParam);
    Bundle localBundle = VipComicRemoteCommand.a(null);
    int i;
    if ((localBundle != null) && ((localComicParam.jdField_a_of_type_Int == 1006002) || (localComicParam.jdField_a_of_type_Int == 19) || (localComicParam.jdField_a_of_type_Int == 20)))
    {
      i = 1;
      if (i == 0) {
        break label99;
      }
      a(localComicParam, localBundle);
    }
    for (;;)
    {
      if (TextUtils.isEmpty(localComicParam.jdField_d_of_type_JavaLangString)) {
        localComicParam.jdField_d_of_type_JavaLangString = VipComicHelper.a();
      }
      a(paramIntent, localComicParam);
      return localComicParam;
      i = 0;
      break;
      label99:
      if (localJSONObject != null) {
        a(localComicParam, localJSONObject);
      }
    }
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).optString("_show_mission");
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("VipComicJumpActivity", 1, "getShowMissionId error", paramString);
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    String str2 = (String)IndividuationUrlHelper.a().get(paramString1);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = VipComicUrlHelper.a(paramString1);
    }
    return b(str1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
  
  private static String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      if (i != 0) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append((String)paramList.get(i));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  @Nullable
  private static JSONObject a(Intent paramIntent, VipComicJumpActivity.ComicParam paramComicParam)
  {
    paramComicParam.jdField_a_of_type_AndroidOsBundle = paramIntent.getBundleExtra("hippy_bundle");
    paramComicParam.jdField_a_of_type_Long = paramIntent.getLongExtra("click_start_time", 0L);
    paramComicParam.jdField_b_of_type_Long = System.currentTimeMillis();
    if (paramComicParam.jdField_a_of_type_Long <= 0L) {
      paramComicParam.jdField_a_of_type_Long = paramComicParam.jdField_b_of_type_Long;
    }
    paramComicParam.jdField_h_of_type_Boolean = paramIntent.getBooleanExtra("has_red_dot", false);
    String str1 = paramIntent.getStringExtra("from_leba");
    String str2 = paramIntent.getStringExtra("from_leba_mgr");
    String str3 = paramIntent.getStringExtra("cfrom");
    Object localObject = null;
    if ((str1 != null) && (str1.equalsIgnoreCase("fromleba")))
    {
      paramComicParam.jdField_a_of_type_Int = 1006002;
      paramIntent = localObject;
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "getFromInfoFromIntent sourceFrom = " + paramComicParam.jdField_a_of_type_Int + ", extUrlParam = " + paramComicParam.jdField_a_of_type_JavaLangString);
      }
      if (paramComicParam.jdField_a_of_type_Int != 1006002) {
        break label235;
      }
      paramComicParam.jdField_f_of_type_JavaLangString = FrameControllerUtil.jdField_d_of_type_JavaLangString;
    }
    label235:
    while (paramComicParam.jdField_a_of_type_Int != 1006003)
    {
      return paramIntent;
      if ((str2 != null) && (str2.equalsIgnoreCase("fromlebamgr")))
      {
        paramComicParam.jdField_a_of_type_Int = 1006003;
        paramIntent = localObject;
        break;
      }
      if (!TextUtils.isEmpty(str3))
      {
        paramComicParam.jdField_a_of_type_Int = Integer.valueOf(str3).intValue();
        paramIntent = localObject;
        break;
      }
      paramIntent = b(paramIntent, paramComicParam);
      break;
    }
    paramComicParam.jdField_f_of_type_JavaLangString = HardCodeUtil.a(2131716537);
    return paramIntent;
  }
  
  public static void a(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isAnimated", true);
    localBundle.putBoolean("isStatusBarDarkFont", true);
    localBundle.putBoolean("isInToolProcess", true);
    localBundle.putBoolean("isTrasparent", true);
    localBundle.putString("bundleName", "QQBoodoComic");
    Object localObject = a();
    if ((localObject != null) && (((QQComicConfBean.BoodoHippyConfig)localObject).mPreloadModules.contains("QQBoodoComic"))) {
      localBundle.putBoolean("isPreloadWhenClosed", true);
    }
    SerializableMap localSerializableMap = new SerializableMap();
    HashMap localHashMap = new HashMap();
    if (paramComicParam.jdField_h_of_type_Boolean) {}
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("hasRedDot", localObject);
      localHashMap.put("extUrlParam", paramComicParam.jdField_a_of_type_JavaLangString);
      localHashMap.put("from", String.valueOf(paramComicParam.jdField_a_of_type_Int));
      localHashMap.put("redId", paramComicParam.jdField_h_of_type_JavaLangString);
      if (paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$PageOpenTraceInfo != null)
      {
        localHashMap.put("lastPageKey", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$PageOpenTraceInfo.jdField_a_of_type_JavaLangString);
        localHashMap.put("linkModule", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$PageOpenTraceInfo.jdField_c_of_type_JavaLangString);
        localHashMap.put("linkContent", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$PageOpenTraceInfo.jdField_d_of_type_JavaLangString);
      }
      localSerializableMap.wrapMap(localHashMap);
      localBundle.putSerializable("js_param_map", localSerializableMap);
      localObject = new HippyAccessHelper.OpenHippyInfo(localBundle);
      paramComicParam = paramActivity;
      if (paramActivity == null) {
        paramComicParam = BaseApplicationImpl.getContext();
      }
      HippyAccessHelper.openHippyPage(paramComicParam, (HippyAccessHelper.OpenHippyInfo)localObject);
      return;
    }
  }
  
  private static void a(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam, ArrayList<WebViewTabBarData> paramArrayList)
  {
    if (paramComicParam.jdField_d_of_type_JavaLangString != null) {}
    for (int i = a(paramComicParam.jdField_d_of_type_JavaLangString, paramArrayList);; i = 0)
    {
      WebViewTabBarData localWebViewTabBarData = (WebViewTabBarData)paramArrayList.get(i);
      localWebViewTabBarData.url = HtmlOffline.a(localWebViewTabBarData.url, "isDefaultTab=1");
      if (paramComicParam.jdField_e_of_type_JavaLangString != null) {
        i = a(paramComicParam.jdField_e_of_type_JavaLangString);
      }
      if ((!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_JavaLangString)) && (i >= 0) && (i < paramArrayList.size()))
      {
        localWebViewTabBarData = (WebViewTabBarData)paramArrayList.get(i);
        localWebViewTabBarData.url = HtmlOffline.a(localWebViewTabBarData.url, "extUrlParam=" + URLEncoder.encode(paramComicParam.jdField_a_of_type_JavaLangString));
      }
      a(paramActivity, paramComicParam, paramArrayList, i, 0);
      return;
    }
  }
  
  private static void a(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam, ArrayList<WebViewTabBarData> paramArrayList, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("tabConfigData", paramArrayList);
    localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
    localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
    localIntent.putExtra("key_maintab", paramInt1);
    localIntent.putExtra("tabDefaultIndex", paramInt1);
    localIntent.putExtra("key_subtab", paramInt2);
    if (TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString))
    {
      paramArrayList = paramActivity.getString(2131690778);
      localIntent.putExtra("selfSet_leftViewText", paramArrayList);
      if ((paramComicParam.jdField_a_of_type_Int == 1006002) || (paramComicParam.jdField_a_of_type_Int == 1006003)) {
        if (paramComicParam.jdField_a_of_type_Int != 1006002) {
          break label187;
        }
      }
    }
    label187:
    for (paramInt1 = 40400;; paramInt1 = 40401)
    {
      localIntent.putExtra("individuation_url_type", paramInt1);
      if (paramComicParam.jdField_e_of_type_Boolean) {
        localIntent.setFlags(localIntent.getFlags() | 0x4000000 | 0x10000000);
      }
      VipComicHelper.a(paramActivity, localIntent, -1);
      return;
      paramArrayList = paramComicParam.jdField_f_of_type_JavaLangString;
      break;
    }
  }
  
  private static void a(Activity paramActivity, VipComicJumpActivity.LoadingCondition paramLoadingCondition)
  {
    if (paramLoadingCondition == null) {}
    while (!paramLoadingCondition.jdField_a_of_type_Boolean) {
      return;
    }
    paramActivity = new VipComicJumpActivity.4(paramActivity, paramLoadingCondition);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      paramActivity.run();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(paramActivity);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent.getBooleanExtra("from_launch_hippy", false)) {
      finish();
    }
    do
    {
      return;
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "do handle launch activity in receiver.");
        }
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1000);
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = false;
        c(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQComicDebug", 2, "skip handle launch activity in receiver.");
  }
  
  private static void a(Intent paramIntent, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramIntent.hasExtra("banner_fromBanner")) && (paramIntent.getBooleanExtra("banner_fromBanner", false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "come from AIO Banner!");
      }
      if ((paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo != null) && (!TextUtils.isEmpty(paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString))) {
        VipComicReportUtils.a(null, "100007", "2", "40040", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString, new String[0]);
      }
    }
  }
  
  public static void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin before enter start");
    }
    if ((paramAppInterface instanceof QQAppInterface))
    {
      MqqHandler localMqqHandler = paramAppInterface.getHandler(Conversation.class);
      if (localMqqHandler != null)
      {
        BannerManager.a().a(32, 3001, 1000L);
        localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(1134040), 1000L);
      }
      VipComicRemoteCommand.a((QQAppInterface)paramAppInterface);
      VipComicEmoticonUploadRemoteCmd.a((QQAppInterface)paramAppInterface);
      if (paramBoolean) {
        ThreadManager.postImmediately(new VipComicJumpActivity.5((QQAppInterface)paramAppInterface), null, true);
      }
      paramAppInterface = (VipComicMqqHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.MQQ_COMIC_HANDLER);
      if (paramAppInterface != null) {
        paramAppInterface.b();
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "init plugin before enter end");
      }
      return;
      paramAppInterface = new Bundle();
      paramAppInterface.putBoolean("doLoadModule", paramBoolean);
      QIPCClientHelper.getInstance().getClient().callServer("QQComicIPCModule", "initPluginBeforeEnter", paramAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (ILebaHelperService)paramQQAppInterface.getRuntimeService(ILebaHelperService.class, "");
    if (localObject == null)
    {
      QLog.d("VipComicJumpActivity", 1, "preloadQQBoodoComic lebaHelperService == null");
      return;
    }
    if (!((ILebaHelperService)localObject).isPluginOpen(1113L))
    {
      QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic not open");
      return;
    }
    localObject = a();
    if ((localObject == null) || (!((QQComicConfBean.BoodoHippyConfig)localObject).mPreloadModules.contains("QQBoodoComic")))
    {
      QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic config not pass");
      return;
    }
    paramQQAppInterface = (IPluginManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_PLUGIN);
    if (paramQQAppInterface == null)
    {
      QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic pluginManager == null");
      return;
    }
    if (!paramQQAppInterface.isPlugininstalled("comic_plugin.apk"))
    {
      QLog.e("VipComicJumpActivity", 1, "preloadQQBoodoComic plugin not ready");
      return;
    }
    QLog.i("VipComicJumpActivity", 1, "preloadBoodoComic");
    paramQQAppInterface = new HippyAccessHelper.OpenHippyInfo();
    paramQQAppInterface.bundleName = "QQBoodoComic";
    paramQQAppInterface.isPreload = true;
    paramQQAppInterface.isInToolProcess = true;
    HippyAccessHelper.checkAndPreloadHippyPage(paramQQAppInterface);
  }
  
  private static void a(VipComicJumpActivity.ComicParam paramComicParam, Bundle paramBundle)
  {
    boolean bool = true;
    int i = paramBundle.getInt("type", -1);
    if ((i >= 100) && (i <= 300))
    {
      paramComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo = new VipComicJumpActivity.ComicInfo();
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString = paramBundle.getString("comicId");
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString = paramBundle.getString("sectionId");
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString = paramBundle.getString("pictureId");
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int = paramBundle.getInt("offset", -1);
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int = paramBundle.getInt("type", -1);
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_Int = paramBundle.getInt("player", 2);
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_e_of_type_JavaLangString = paramBundle.getString("cloudUrl", "");
      if (!"com.qqcomic.activity.media.VipComicMediaPlayActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString)) {
        break label292;
      }
      paramComicParam.jdField_a_of_type_Boolean = false;
      paramComicParam.jdField_d_of_type_Boolean = paramBundle.getBoolean("isPlayerLocked", false);
      if (paramBundle.getBoolean("supportMiniPlayer", false)) {
        break label280;
      }
      label186:
      paramComicParam.jdField_f_of_type_Boolean = bool;
      if (!paramComicParam.jdField_f_of_type_Boolean) {
        break label285;
      }
    }
    label280:
    label285:
    for (paramBundle = "";; paramBundle = "init_player=1&")
    {
      paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString = a("comicDetailVideo", null, null, "1", "354", null, paramBundle + "ADTAG=comic.plugin.fav&id=" + paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
      return;
      if (BoodoLauncher.a())
      {
        paramComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.reader.VipComicReadingActivityV2";
        break;
      }
      paramComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.reader.VipComicPortraitReadingActivity";
      break;
      bool = false;
      break label186;
    }
    label292:
    paramComicParam.jdField_b_of_type_Boolean = paramBundle.getBoolean("key_return_to_home");
    paramComicParam.jdField_a_of_type_Boolean = true;
  }
  
  private static void a(VipComicJumpActivity.ComicParam paramComicParam, JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    paramComicParam.jdField_b_of_type_JavaLangString = paramJSONObject.optString("jumpto", "com.qqcomic.activity.VipComicMainTabActivity");
    paramComicParam.jdField_a_of_type_Int = paramJSONObject.optInt("from", 0);
    boolean bool1;
    if (!paramJSONObject.optBoolean("newInstance")) {
      bool1 = true;
    }
    for (;;)
    {
      paramComicParam.jdField_e_of_type_Boolean = bool1;
      if (paramJSONObject.has("url")) {
        paramComicParam.jdField_c_of_type_JavaLangString = paramJSONObject.optString("url");
      }
      try
      {
        paramComicParam.jdField_c_of_type_JavaLangString = URLDecoder.decode(paramComicParam.jdField_c_of_type_JavaLangString);
        label77:
        if (VipComicHelper.a(paramComicParam.jdField_c_of_type_JavaLangString, paramComicParam.jdField_a_of_type_AndroidContentIntent)) {
          paramComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.activity.media.VipComicMediaPlayActivity";
        }
        if (paramJSONObject.has("comic")) {}
        for (;;)
        {
          try
          {
            JSONObject localJSONObject = new JSONObject(paramJSONObject.optString("comic"));
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo = new VipComicJumpActivity.ComicInfo();
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString = localJSONObject.optString("comicID");
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString = localJSONObject.optString("comicSectionID");
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString = localJSONObject.optString("comicPageID");
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int = localJSONObject.optInt("comicPageOffset");
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int = localJSONObject.optInt("type");
            paramComicParam.jdField_a_of_type_Boolean = localJSONObject.optBoolean("returnToDetail");
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_Int = localJSONObject.optInt("player", 2);
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_e_of_type_JavaLangString = localJSONObject.optString("cloudUrl", "");
            paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString = localJSONObject.optString("url", "");
            if (localJSONObject.optInt("returnToHome") != 1) {
              continue;
            }
            bool1 = bool2;
            paramComicParam.jdField_b_of_type_Boolean = bool1;
          }
          catch (JSONException localJSONException)
          {
            continue;
          }
          if (paramJSONObject.has("maintab")) {
            paramComicParam.jdField_d_of_type_JavaLangString = paramJSONObject.optString("maintab");
          }
          if (paramJSONObject.has("subtab")) {
            paramComicParam.jdField_e_of_type_JavaLangString = paramJSONObject.optString("subtab");
          }
          if (paramJSONObject.has("leftViewText")) {
            paramComicParam.jdField_f_of_type_JavaLangString = paramJSONObject.optString("leftViewText");
          }
          return;
          bool1 = false;
          break;
          bool1 = false;
        }
      }
      catch (Exception localException)
      {
        break label77;
      }
    }
  }
  
  private void a(VipComicJumpActivity.ComicParam paramComicParam, boolean paramBoolean)
  {
    if (paramComicParam.jdField_g_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1000);
    }
    this.jdField_a_of_type_Boolean = QIPCServerHelper.getInstance().isModuleRunning("comic_plugin.apk");
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "plugin is not running...");
      }
      if (!paramBoolean) {
        SystemClock.sleep(500L);
      }
      QQComicPluginBridge.a(this, null);
      VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long), "1" });
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QQComicDebug", 2, "plugin is running...");
  }
  
  private static void a(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      QQToast.a(BaseApplicationImpl.getContext(), paramString, 0).a();
      return;
    }
    ThreadManager.getUIHandler().post(new VipComicJumpActivity.2(paramString));
  }
  
  static void a(AppRuntime paramAppRuntime, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramAppRuntime == null) || (paramComicParam == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo start");
    }
    boolean bool2 = paramAppRuntime instanceof QQAppInterface;
    Object localObject1;
    label64:
    Object localObject2;
    if (bool2)
    {
      localObject1 = (ILebaHelperService)paramAppRuntime.getRuntimeService(ILebaHelperService.class, "multi");
      if (localObject1 != null)
      {
        localObject1 = ((ILebaHelperService)localObject1).getLebaMgrList();
        if (localObject1 == null) {
          break label1081;
        }
        localObject1 = ((List)localObject1).iterator();
        do
        {
          if (!((Iterator)localObject1).hasNext()) {
            break;
          }
          localObject2 = (LebaViewItem)((Iterator)localObject1).next();
        } while ((localObject2 == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo == null) || (((LebaViewItem)localObject2).jdField_a_of_type_ComTencentMobileqqLebaEntityLebaPluginInfo.uiResId != 1113L));
      }
    }
    label140:
    label143:
    label275:
    label410:
    label436:
    label948:
    label1081:
    for (int i = ((LebaViewItem)localObject2).jdField_a_of_type_Byte;; i = -1)
    {
      String str;
      if (i == 0)
      {
        bool1 = true;
        localObject1 = null;
        if (!bool1) {
          break label598;
        }
        localObject6 = "1113." + 100800;
        localObject5 = "1113." + 100802;
        localObject4 = "1113." + 100803;
        localObject3 = "1113." + 100804;
        localObject2 = "1113." + 100801;
        str = String.valueOf(1113);
        if (!bool2) {
          break label751;
        }
        paramAppRuntime = (RedTouchManager)paramAppRuntime.getManager(QQManagerFactory.MGR_RED_TOUCH);
        if (paramAppRuntime == null) {
          break;
        }
        localObject1 = paramAppRuntime.a(str);
        localObject6 = paramAppRuntime.a((String)localObject6);
        localObject5 = paramAppRuntime.a((String)localObject5);
        localObject4 = paramAppRuntime.a((String)localObject4);
        localObject3 = paramAppRuntime.a((String)localObject3);
        paramAppRuntime = paramAppRuntime.a((String)localObject2);
        if ((localObject6 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject6).iNewFlag.get() == 0)) {
          break label726;
        }
        bool1 = true;
        label360:
        paramComicParam.a("index", bool1);
        if ((paramAppRuntime == null) || (paramAppRuntime.iNewFlag.get() == 0)) {
          break label731;
        }
        bool1 = true;
        paramComicParam.a("fav", bool1);
        if ((localObject3 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject3).iNewFlag.get() == 0)) {
          break label736;
        }
        bool1 = true;
        paramComicParam.a("category", bool1);
        if ((localObject5 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject5).iNewFlag.get() == 0)) {
          break label741;
        }
        bool1 = true;
        paramComicParam.a("more", bool1);
        if ((localObject4 == null) || (((BusinessInfoCheckUpdate.AppInfo)localObject4).iNewFlag.get() == 0)) {
          break label746;
        }
      }
      label598:
      label731:
      label736:
      label741:
      label746:
      for (boolean bool1 = true;; bool1 = false)
      {
        paramComicParam.a("group", bool1);
        if ((localObject1 != null) && (paramComicParam.jdField_h_of_type_Boolean))
        {
          a(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get(), ((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get(), paramComicParam);
          paramComicParam.jdField_g_of_type_JavaLangString = a(((BusinessInfoCheckUpdate.AppInfo)localObject1).missions.get());
          paramComicParam.jdField_h_of_type_JavaLangString = a(((BusinessInfoCheckUpdate.AppInfo)localObject1).buffer.get());
        }
        if (!QLog.isColorLevel()) {
          break label1054;
        }
        QLog.d("VipComicJumpActivity", 2, "updateRedAppInfo end");
        return;
        QLog.d("VipComicJumpActivity", 1, "updateRedAppInfo lebaHelperService == null");
        localObject1 = null;
        break label64;
        bool1 = false;
        break label140;
        localObject1 = (QQComicRedTouchManager)paramAppRuntime.getManager(QQManagerFactory.COMIC_RED_TOUCH_MANAGER);
        if (localObject1 == null) {
          break;
        }
        bool1 = ((QQComicRedTouchManager)localObject1).a(1113);
        break label143;
        localObject6 = "100600.100001113." + 100100800;
        localObject5 = "100600.100001113." + 100100802;
        localObject4 = "100600.100001113." + 100100803;
        localObject3 = "100600.100001113." + 100100804;
        localObject2 = "100600.100001113." + 100100801;
        str = "100600.100001113";
        break label275;
        bool1 = false;
        break label360;
        bool1 = false;
        break label384;
        bool1 = false;
        break label410;
        bool1 = false;
        break label436;
      }
      label726:
      label751:
      paramAppRuntime = new ArrayList();
      paramAppRuntime.add(str);
      paramAppRuntime.add(localObject6);
      paramAppRuntime.add(localObject2);
      paramAppRuntime.add(localObject3);
      paramAppRuntime.add(localObject5);
      paramAppRuntime.add(localObject4);
      paramAppRuntime = ((QQComicRedTouchManager)localObject1).a(paramAppRuntime);
      if (paramAppRuntime == null) {
        break;
      }
      localObject1 = (RedAppInfo)paramAppRuntime.get(str);
      Object localObject6 = (RedAppInfo)paramAppRuntime.get(localObject6);
      Object localObject5 = (RedAppInfo)paramAppRuntime.get(localObject5);
      Object localObject4 = (RedAppInfo)paramAppRuntime.get(localObject4);
      Object localObject3 = (RedAppInfo)paramAppRuntime.get(localObject3);
      paramAppRuntime = (RedAppInfo)paramAppRuntime.get(localObject2);
      if ((localObject6 != null) && (((RedAppInfo)localObject6).b() != 0))
      {
        bool1 = true;
        paramComicParam.a("index", bool1);
        if ((paramAppRuntime == null) || (paramAppRuntime.b() == 0)) {
          break label1061;
        }
        bool1 = true;
        paramComicParam.a("fav", bool1);
        if ((localObject3 == null) || (((RedAppInfo)localObject3).b() == 0)) {
          break label1066;
        }
        bool1 = true;
        paramComicParam.a("category", bool1);
        if ((localObject5 == null) || (((RedAppInfo)localObject5).b() == 0)) {
          break label1071;
        }
        bool1 = true;
        label971:
        paramComicParam.a("more", bool1);
        if ((localObject4 == null) || (((RedAppInfo)localObject4).b() == 0)) {
          break label1076;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramComicParam.a("group", bool1);
        if ((localObject1 == null) || (!paramComicParam.jdField_h_of_type_Boolean)) {
          break label533;
        }
        a(((RedAppInfo)localObject1).a(), ((RedAppInfo)localObject1).a(), paramComicParam);
        paramComicParam.jdField_g_of_type_JavaLangString = a(((RedAppInfo)localObject1).a());
        paramComicParam.jdField_h_of_type_JavaLangString = a(((RedAppInfo)localObject1).a());
        break label533;
        break;
        bool1 = false;
        break label904;
        bool1 = false;
        break label925;
        bool1 = false;
        break label948;
        bool1 = false;
        break label971;
      }
    }
  }
  
  private static boolean a()
  {
    Iterator localIterator = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses().iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (!((ActivityManager.RunningAppProcessInfo)localIterator.next()).processName.equals("com.tencent.mobileqq:tool"));
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "isToolProcessExist: " + bool);
      }
      return bool;
    }
  }
  
  private static boolean a(Activity paramActivity)
  {
    Object localObject = paramActivity.getSharedPreferences("vip_comic_file", 4);
    String str1;
    String str2;
    if (((SharedPreferences)localObject).getBoolean("restore_flag", false))
    {
      str1 = ((SharedPreferences)localObject).getString("base_package", "");
      str2 = ((SharedPreferences)localObject).getString("base_activity", "");
      i = ((SharedPreferences)localObject).getInt("activity_task_id", -1);
      localObject = ((ActivityManager)paramActivity.getApplication().getApplicationContext().getSystemService("activity")).getRunningTasks(100);
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        ActivityManager.RunningTaskInfo localRunningTaskInfo;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((Iterator)localObject).next();
        } while ((!localRunningTaskInfo.baseActivity.getClassName().equals(str2)) || (i != localRunningTaskInfo.id));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        localObject = new Intent();
        ((Intent)localObject).setComponent(new ComponentName(str1, str2));
        ((Intent)localObject).addFlags(269500416);
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zz_bodong");
        try
        {
          paramActivity.startActivity((Intent)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("QQComicDebug", 2, "handle param restore stack end");
          }
          return true;
        }
        catch (Exception paramActivity)
        {
          paramActivity.printStackTrace();
        }
      }
      return false;
    }
  }
  
  public static boolean a(AppInterface paramAppInterface, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    boolean bool2 = true;
    if ((paramAppInterface == null) || (paramActivity == null) || (paramComicParam == null)) {
      bool2 = false;
    }
    for (;;)
    {
      return bool2;
      QLog.d("QQComicDebug", 2, "handle param start");
      if (("com.qqcomic.activity.VipComicMainTabActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString)) && (paramComicParam.jdField_d_of_type_JavaLangString == null)) {}
      for (boolean bool1 = true; !a(paramAppInterface, paramActivity, paramComicParam, bool1); bool1 = false)
      {
        if (!"com.qqcomic.activity.VipComicMainTabActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString)) {
          break label88;
        }
        return c(paramAppInterface, paramActivity, paramComicParam);
      }
    }
    label88:
    if ("com.qqcomic.activity.VipComicTabBrowserActivity".equals(paramComicParam.jdField_b_of_type_JavaLangString))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramComicParam.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
      localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
      if (TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString)) {}
      for (paramAppInterface = paramActivity.getString(2131690778);; paramAppInterface = paramComicParam.jdField_f_of_type_JavaLangString)
      {
        localIntent.putExtra("selfSet_leftViewText", paramAppInterface);
        VipComicHelper.a(paramActivity, localIntent, -1);
        VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
        QLog.d("QQComicDebug", 2, "handle param open web end");
        return true;
      }
    }
    paramComicParam.jdField_g_of_type_Boolean = true;
    QLog.d("QQComicDebug", 2, "handle param end");
    return false;
  }
  
  private static boolean a(AppInterface paramAppInterface, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam, boolean paramBoolean)
  {
    if ((paramComicParam.jdField_a_of_type_Int == 12) && (paramBoolean))
    {
      if (b(paramAppInterface, paramActivity, paramComicParam)) {}
      while (a(paramActivity)) {
        return true;
      }
    }
    return false;
  }
  
  static boolean a(String paramString, List<String> paramList, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = null;
      try
      {
        paramString = new JSONObject(paramString).optJSONObject("msg");
        if (paramString != null)
        {
          paramList = paramList.iterator();
          for (;;)
          {
            if (!paramList.hasNext()) {
              break label185;
            }
            localObject = (String)paramList.next();
            try
            {
              localObject = paramString.optJSONObject((String)localObject);
              if (localObject != null)
              {
                localObject = ((JSONObject)localObject).optString("content");
                if (!TextUtils.isEmpty((CharSequence)localObject))
                {
                  localObject = new JSONObject((String)localObject);
                  paramComicParam.jdField_i_of_type_Boolean = "redirect".equals(((JSONObject)localObject).optString("type"));
                  if (paramComicParam.jdField_i_of_type_Boolean)
                  {
                    localObject = ((JSONObject)localObject).optString("link");
                    if (!TextUtils.isEmpty((CharSequence)localObject)) {
                      break;
                    }
                    paramComicParam.jdField_i_of_type_Boolean = false;
                  }
                }
              }
            }
            catch (Exception localException)
            {
              QLog.e("VipComicJumpActivity", 1, "parse red mission failed", localException);
            }
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          QLog.e("VipComicJumpActivity", 1, "parse red failed", paramString);
          paramString = localException;
        }
        paramComicParam.jdField_i_of_type_JavaLangString = localException;
        return true;
      }
    }
    label185:
    return false;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    StringBuilder localStringBuilder = StringBuilderUtils.a();
    if (!TextUtils.isEmpty(paramString7)) {
      localStringBuilder.append(paramString7);
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!paramString1.contains("_wv=")))
    {
      localStringBuilder.append("&_wv=");
      localStringBuilder.append(paramString2);
    }
    if ((!TextUtils.isEmpty(paramString3)) && (!paramString1.contains("_wwv=")))
    {
      localStringBuilder.append("&_wwv=");
      localStringBuilder.append(paramString3);
    }
    if ((!TextUtils.isEmpty(paramString4)) && (!paramString1.contains("_cwv=")))
    {
      localStringBuilder.append("&_cwv=");
      localStringBuilder.append(paramString4);
    }
    if ((!TextUtils.isEmpty(paramString5)) && (!paramString1.contains("_sonic_id=")) && (!paramString1.contains("_bid=")))
    {
      localStringBuilder.append("&_bid=");
      localStringBuilder.append(paramString5);
    }
    if ((!TextUtils.isEmpty(paramString6)) && (!paramString1.contains("channel=")))
    {
      localStringBuilder.append("&channel=");
      localStringBuilder.append(paramString6);
    }
    if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(0) == '&')) {
      localStringBuilder.deleteCharAt(0);
    }
    return HtmlOffline.a(paramString1, localStringBuilder.toString());
  }
  
  private static JSONObject b(Intent paramIntent, VipComicJumpActivity.ComicParam paramComicParam)
  {
    try
    {
      paramIntent = paramIntent.getStringExtra("options");
      if (!TextUtils.isEmpty(paramIntent)) {
        paramIntent = new JSONObject(paramIntent);
      }
      JSONObject localJSONObject;
      label129:
      return null;
    }
    catch (Exception paramComicParam)
    {
      try
      {
        paramComicParam.jdField_a_of_type_Int = paramIntent.optInt("from");
        paramComicParam.jdField_a_of_type_JavaLangString = paramIntent.optString("extUrlParam");
        if (TextUtils.isEmpty(paramComicParam.jdField_a_of_type_JavaLangString))
        {
          localJSONObject = paramIntent.optJSONObject("comic");
          if (localJSONObject != null) {
            paramComicParam.jdField_a_of_type_JavaLangString = localJSONObject.optString("extUrlParam");
          }
        }
        paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$PageOpenTraceInfo = new VipComicJumpActivity.PageOpenTraceInfo(paramIntent.optString("lastPageKey"), paramIntent.optString("pageId"), paramIntent.optString("moduleId", "0"), paramIntent.optString("contentId", "0"));
        return paramIntent;
      }
      catch (Exception paramComicParam)
      {
        break label129;
      }
      paramComicParam = paramComicParam;
      paramIntent = null;
      paramComicParam.printStackTrace();
      return paramIntent;
    }
  }
  
  private static void b(int paramInt, VipComicJumpActivity.LoadingCondition paramLoadingCondition, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramInt != 0)
    {
      a("启动波洞动漫失败");
      if (paramLoadingCondition.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog != null) {
        paramLoadingCondition.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog.dismiss();
      }
    }
    for (;;)
    {
      paramLoadingCondition.jdField_a_of_type_Boolean = false;
      try
      {
        paramLoadingCondition.notifyAll();
        return;
      }
      finally {}
      if ((paramLoadingCondition.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog == null) || ((paramLoadingCondition.jdField_a_of_type_CooperationComicBoodoPluginLoadingDialog != null) && (!paramLoadingCondition.jdField_b_of_type_Boolean)))
      {
        a(paramActivity, paramComicParam);
        QLog.i("VipComicJumpActivity", 1, "checkBoodoPlugin launchHippyPage ");
      }
    }
  }
  
  private static void b(AppInterface paramAppInterface, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    VipComicJumpActivity.LoadingCondition localLoadingCondition = new VipComicJumpActivity.LoadingCondition();
    BoodoHippyBirdge.a(paramActivity, new VipComicJumpActivity.3(localLoadingCondition, paramActivity, paramComicParam));
    if (!a())
    {
      a(paramActivity, localLoadingCondition);
      paramAppInterface = (IWebProcessManagerService)paramAppInterface.getRuntimeService(IWebProcessManagerService.class, "multi");
      if (paramAppInterface != null) {
        paramAppInterface.startWebProcess(-1, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 1, new Object[] { "checkBoodoPlugin showLoadingDialog loadingCondition.mNeedLaunch:", Boolean.valueOf(localLoadingCondition.jdField_a_of_type_Boolean) });
      }
      return;
      for (;;)
      {
        try {}catch (InterruptedException paramAppInterface)
        {
          QLog.e("VipComicJumpActivity", 1, paramAppInterface, new Object[0]);
          continue;
        }
        try
        {
          localLoadingCondition.wait(300L);
          a(paramActivity, localLoadingCondition);
          break;
        }
        finally {}
      }
    }
  }
  
  private static boolean b(AppInterface paramAppInterface, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    boolean bool2 = false;
    QLog.i("VipComicJumpActivity", 1, "QQComicConfBean.getHippyConfig().mHippyStatus:" + QQComicConfBean.a().mHippyStatus);
    QQComicConfBean.BoodoHippyConfig localBoodoHippyConfig = a();
    boolean bool1 = bool2;
    if (localBoodoHippyConfig != null)
    {
      bool1 = bool2;
      if (localBoodoHippyConfig.mHippyStatus == 1)
      {
        ThreadManagerV2.excute(new VipComicJumpActivity.1(paramAppInterface, paramActivity, paramComicParam), 16, null, false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private static void c(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramActivity.getResources().getDimensionPixelSize(2131299166);
    int i = j;
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      i = j + ImmersiveUtils.getStatusBarHeight(paramActivity);
    }
    i = (int)((i - 0.5F) / paramActivity.getResources().getDisplayMetrics().density);
    Object localObject1 = VipComicNavConfigHelper.a();
    Object localObject2 = "&redId=" + paramComicParam.jdField_h_of_type_JavaLangString;
    Object localObject3;
    Object localObject4;
    WebViewTabBarData localWebViewTabBarData1;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject3 = ((List)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (VipComicNavConfigHelper.TabItemData)((Iterator)localObject3).next();
        localWebViewTabBarData1 = new WebViewTabBarData();
        localWebViewTabBarData1.tag = ((VipComicNavConfigHelper.TabItemData)localObject4).jdField_a_of_type_JavaLangString;
        localWebViewTabBarData1.tabName = ((VipComicNavConfigHelper.TabItemData)localObject4).jdField_b_of_type_JavaLangString;
        if (TextUtils.equals(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_a_of_type_JavaLangString, "index")) {}
        for (localObject1 = "&redDotIds=" + paramComicParam.jdField_g_of_type_JavaLangString;; localObject1 = "")
        {
          localWebViewTabBarData1.url = HtmlOffline.a(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_c_of_type_JavaLangString, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.a(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_a_of_type_JavaLangString) + "&_titleBarHeight=" + i + (String)localObject1 + (String)localObject2);
          localWebViewTabBarData1.tabIcon = VipComicNavConfigHelper.a(((VipComicNavConfigHelper.TabItemData)localObject4).jdField_d_of_type_JavaLangString);
          localArrayList.add(localWebViewTabBarData1);
          break;
        }
      }
    }
    else
    {
      localObject1 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject1).tag = "index";
      ((WebViewTabBarData)localObject1).tabName = HardCodeUtil.a(2131716317);
      ((WebViewTabBarData)localObject1).url = a("comicIndex", null, "64", "5", "", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.a("index") + "&_titleBarHeight=" + i + "&redDotIds=" + paramComicParam.jdField_g_of_type_JavaLangString + (String)localObject2);
      localObject3 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject3).tag = "fav";
      ((WebViewTabBarData)localObject3).tabName = HardCodeUtil.a(2131716311);
      ((WebViewTabBarData)localObject3).url = a("comicFav", null, "", "1", "354", "%7B%22tabNum%22%3A2%2C%22subTextArray%22%3A%5B%22%E6%94%B6%E8%97%8F%22%2C%22%E4%B8%8B%E8%BD%BD%22%5D%7D", "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.a("fav") + "&_titleBarHeight=" + i + (String)localObject2);
      localObject4 = new WebViewTabBarData();
      ((WebViewTabBarData)localObject4).tag = "category";
      ((WebViewTabBarData)localObject4).tabName = HardCodeUtil.a(2131716314);
      ((WebViewTabBarData)localObject4).url = a("comicCategory", null, null, "1", "354", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.a("category") + "&_titleBarHeight=" + i + (String)localObject2);
      localWebViewTabBarData1 = new WebViewTabBarData();
      localWebViewTabBarData1.tag = "more";
      localWebViewTabBarData1.tabName = HardCodeUtil.a(2131716395);
      localWebViewTabBarData1.url = a("comicMore", null, null, "1", "354", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.a("more") + "&_titleBarHeight=" + i + (String)localObject2);
      WebViewTabBarData localWebViewTabBarData2 = new WebViewTabBarData();
      localWebViewTabBarData2.tag = "group";
      localWebViewTabBarData2.tabName = HardCodeUtil.a(2131716323);
      localWebViewTabBarData2.url = a("comicGroup", null, null, "1", "354", null, "_cfrom=" + paramComicParam.jdField_a_of_type_Int + "&hasRedDot=" + paramComicParam.a("group") + "&_titleBarHeight=" + i + (String)localObject2);
      localArrayList.add(localObject1);
      localArrayList.add(localObject3);
      localArrayList.add(localObject4);
      localArrayList.add(localWebViewTabBarData1);
      localArrayList.add(localWebViewTabBarData2);
    }
    if (QLog.isColorLevel())
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WebViewTabBarData)((Iterator)localObject1).next();
        QLog.d("VipComicJumpActivity", 2, "tabBar:tabKey=" + ((WebViewTabBarData)localObject2).tag + ", tabName=" + ((WebViewTabBarData)localObject2).tabName + ", tabUrl=" + ((WebViewTabBarData)localObject2).url);
      }
    }
    a(paramActivity, paramComicParam, localArrayList);
  }
  
  private static boolean c(AppInterface paramAppInterface, Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    a(paramAppInterface, paramComicParam);
    if (b(paramAppInterface, paramActivity, paramComicParam)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param parse red touch end");
    }
    if (paramComicParam.jdField_i_of_type_Boolean)
    {
      paramAppInterface = HtmlOffline.a(paramComicParam.jdField_i_of_type_JavaLangString, "returnIndex=true");
      Intent localIntent = new Intent();
      localIntent.putExtra("url", paramAppInterface);
      localIntent.putExtra("reportSourceFrom", paramComicParam.jdField_a_of_type_Int);
      localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
      VipComicHelper.a(paramActivity, localIntent, -1);
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "jump to comic activity page directly, url=" + paramAppInterface);
      }
      return true;
    }
    c(paramActivity, paramComicParam);
    VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "handle param open main tab end");
    }
    return true;
  }
  
  public void a(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin start");
    }
    a(this.app, false);
    ThreadManager.postImmediately(new VipComicJumpActivity.6(this, this.app, paramComicParam), null, true);
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "init plugin end");
    }
  }
  
  void a(VipComicJumpActivity.ComicParam paramComicParam, int paramInt)
  {
    if (paramComicParam == null) {
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        if (this.app == null) {
          continue;
        }
        localObject1 = (SVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
        if (localObject1 == null) {
          continue;
        }
        i = ((SVIPHandler)localObject1).g();
        if (i != 1) {
          continue;
        }
        localObject1 = "2";
      }
      catch (Exception localException)
      {
        Object localObject1;
        int i;
        localException.printStackTrace();
        Object localObject2 = "1";
        continue;
        if ((paramComicParam.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L) || (this.jdField_a_of_type_Long <= paramComicParam.jdField_b_of_type_Long)) {
          continue;
        }
        String str1 = this.jdField_a_of_type_Long - paramComicParam.jdField_b_of_type_Long + "";
        continue;
        String str4 = "0";
        continue;
        String str3 = "0";
        continue;
        String str2 = "0";
        continue;
        str1 = "0";
        continue;
        str1 = "1";
        continue;
      }
      localObject2 = localObject1;
      if (!this.jdField_a_of_type_Boolean) {
        continue;
      }
      localObject1 = "-1";
      if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long <= this.jdField_a_of_type_Long)) {
        continue;
      }
      str2 = this.jdField_b_of_type_Long - this.jdField_a_of_type_Long + "";
      if ((this.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long <= this.jdField_b_of_type_Long)) {
        continue;
      }
      str3 = this.jdField_c_of_type_Long - this.jdField_b_of_type_Long + "";
      if ((paramComicParam.jdField_b_of_type_Long == 0L) || (this.jdField_c_of_type_Long == 0L) || (this.jdField_c_of_type_Long <= paramComicParam.jdField_b_of_type_Long)) {
        continue;
      }
      str4 = this.jdField_c_of_type_Long - paramComicParam.jdField_b_of_type_Long + "";
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "downloadCost:" + (String)localObject1 + ", installCost:" + str2 + ", launchCost:" + str3 + ", allCost:" + str4 + ",[startTime-launchTime]=[" + paramComicParam.jdField_b_of_type_Long + "-" + this.jdField_c_of_type_Long + "]");
      }
      VipUtils.a(null, "VIPCOMIC", "0X80052CA", "0X80052CA", paramComicParam.jdField_a_of_type_Int, paramInt, new String[] { localObject2 });
      VipUtils.a(null, "VIPCOMIC", "0X8005359", "0X8005359", paramComicParam.jdField_a_of_type_Int, paramInt, new String[] { localObject1, str2, str3, str4 });
      return;
      if (i != 3) {
        continue;
      }
      localObject1 = "3";
    }
  }
  
  void b(Activity paramActivity, VipComicJumpActivity.ComicParam paramComicParam)
  {
    if ((paramActivity == null) || (paramComicParam == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "call start plugin activity start.");
    }
    if ("com.tencent.hippy.qq.fragment.CommonHippyFragment".equals(paramComicParam.jdField_b_of_type_JavaLangString))
    {
      QLog.i("VipComicJumpActivity", 1, "directStartPlugin openHippyPage param:" + paramComicParam);
      return;
    }
    Intent localIntent = paramComicParam.jdField_a_of_type_AndroidContentIntent;
    localIntent.putExtra("begin_to_load_comic_plugin", System.currentTimeMillis());
    localIntent.putExtra("startOpenPageTime", paramComicParam.jdField_a_of_type_Long);
    localIntent.putExtra("pluginFinished", this.jdField_a_of_type_Long);
    if (!TextUtils.isEmpty(paramComicParam.jdField_c_of_type_JavaLangString)) {
      localIntent.putExtra("url", paramComicParam.jdField_c_of_type_JavaLangString);
    }
    boolean bool = BoodoLauncher.a();
    QLog.i("VipComicJumpActivity", 2, "[directStartPlugin] param.jumpConponentName = " + paramComicParam.jdField_b_of_type_JavaLangString + ", use comic version is " + bool);
    if (paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo != null)
    {
      if ((paramComicParam.jdField_b_of_type_JavaLangString.equals("com.qqcomic.reader.VipComicReadingActivityV2")) || (bool))
      {
        paramComicParam.jdField_b_of_type_JavaLangString = "com.qqcomic.reader.VipComicReadingActivityV2";
        localIntent.putExtra("req_comicId", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
        localIntent.putExtra("req_sectionId", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString);
        localIntent.putExtra("req_picId", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString);
      }
    }
    else
    {
      localIntent.putExtra("key_extUrlParam", paramComicParam.jdField_a_of_type_JavaLangString);
      QLog.d("VipComicJumpActivity", 1, new Object[] { "directStartPlugin key_extUrlParam mExtUrlParam:", paramComicParam.jdField_a_of_type_JavaLangString });
      localIntent.putExtra("key_source_from", paramComicParam.jdField_a_of_type_Int);
      if (!TextUtils.isEmpty(paramComicParam.jdField_f_of_type_JavaLangString)) {
        break label607;
      }
      localIntent.putExtra("selfSet_leftViewText", getString(2131690778));
    }
    for (;;)
    {
      if (paramComicParam.jdField_e_of_type_Boolean) {
        localIntent.addFlags(67108864);
      }
      PreloadProcHitPluginSession localPreloadProcHitPluginSession = a(paramComicParam, localIntent);
      QQComicPluginBridge.a(paramActivity, localIntent, paramComicParam.jdField_b_of_type_JavaLangString, localPreloadProcHitPluginSession);
      QLog.d("QQComicDebug", 2, "call start plugin activity end.");
      return;
      localIntent.putExtra("key_comic_id", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("key_section_id", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_pic_id", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("key_pic_offset_ratio", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_a_of_type_Int);
      localIntent.putExtra("key_type", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_b_of_type_Int);
      localIntent.putExtra("key_jump_from_out_plugin", true);
      localIntent.putExtra("key_return_to_detail", paramComicParam.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_return_to_home", paramComicParam.jdField_b_of_type_Boolean);
      localIntent.putExtra("key_is_player_locked", paramComicParam.jdField_d_of_type_Boolean);
      localIntent.putExtra("key_return_to_home_from_detail", paramComicParam.jdField_c_of_type_Boolean);
      localIntent.putExtra("key_is_fullscreen", paramComicParam.jdField_f_of_type_Boolean);
      localIntent.putExtra("key_video_player_type", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_c_of_type_Int);
      localIntent.putExtra("key_cloud_url", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_e_of_type_JavaLangString);
      localIntent.putExtra("key_from_out_entry", true);
      if (TextUtils.isEmpty(paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localIntent.putExtra("url", paramComicParam.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicInfo.jdField_d_of_type_JavaLangString);
      break;
      label607:
      localIntent.putExtra("selfSet_leftViewText", paramComicParam.jdField_f_of_type_JavaLangString);
    }
  }
  
  void b(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramComicParam == null) {
      return;
    }
    Object localObject = ((ActivityManager)getApplication().getSystemService("activity")).getRunningAppProcesses();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!"com.tencent.mobileqq:tool".equals(((ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next()).processName));
    }
    for (boolean bool = true;; bool = false)
    {
      if ("com.tencent.hippy.qq.fragment.CommonHippyFragment".equals(paramComicParam.jdField_b_of_type_JavaLangString))
      {
        QQComicPluginBridge.a(this, paramComicParam.jdField_a_of_type_AndroidOsBundle);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1002);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(1002, 10000L);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long), "1" });
        return;
      }
      a(paramComicParam, bool);
      return;
    }
  }
  
  public void c(VipComicJumpActivity.ComicParam paramComicParam)
  {
    if (paramComicParam == null) {
      return;
    }
    if (!paramComicParam.jdField_g_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQComicDebug", 2, "skip launch activity.");
      }
      finish();
      return;
    }
    b(this, paramComicParam);
    VipUtils.a(null, "VIPCOMIC", "0X8005FC8", "0X8005FC8", paramComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - paramComicParam.jdField_b_of_type_Long) });
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    VipComicJumpActivity.ComicParam localComicParam = a(getIntent());
    this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam = localComicParam;
    if (a(this.app, this, localComicParam))
    {
      finish();
      return true;
    }
    paramBundle = new IntentFilter();
    paramBundle.addAction("com.tencent.mobileqq.ACTION_PLUGIN_STARTUP_FAILED");
    paramBundle.addAction("com.tencent.mobileqq.PreLoadComicProcess");
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new VipComicJumpActivity.LaunchCompletedObserver(this);
    getApplicationContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate registerReceiver");
    }
    setContentView(2131563207);
    setTitle(2131720587);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370748));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370752));
    this.jdField_a_of_type_CooperationPluginIPluginManager = ((IPluginManager)this.app.getManager(QQManagerFactory.MGR_PLUGIN));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("VipComicJumpActivity onCreate mPluginManager = ");
      if (this.jdField_a_of_type_CooperationPluginIPluginManager != null) {
        break label287;
      }
    }
    label287:
    for (paramBundle = "null";; paramBundle = Boolean.valueOf(this.jdField_a_of_type_CooperationPluginIPluginManager.isReady()))
    {
      QLog.d("VipComicJumpActivity", 2, paramBundle);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(this);
      VipUtils.a(null, "VIPCOMIC", "0X8005FC7", "0X8005FC7", localComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - localComicParam.jdField_b_of_type_Long) });
      paramBundle = (QQComicPreloadManager)this.app.getManager(QQManagerFactory.QQCOMIC_PRELOAD_MANAGER);
      if (paramBundle != null)
      {
        paramBundle.a(System.currentTimeMillis());
        paramBundle.b();
      }
      a(localComicParam);
      return true;
    }
  }
  
  public void finish()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VipComicJumpActivity", 2, "finish.");
    }
    super.finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool = false;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      bool = true;
      do
      {
        return bool;
        finish();
        break;
      } while (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam == null);
      if (!this.jdField_b_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQComicDebug", 2, "do handle launch activity.");
        }
        this.jdField_b_of_type_Boolean = true;
        this.jdField_c_of_type_Boolean = true;
        c(this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam);
        VipUtils.a(null, "VIPCOMIC", "0X8005FCE", "0X8005FCE", this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_a_of_type_Int, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_b_of_type_Long), "2" });
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("QQComicDebug", 2, "skip handle launch activity.");
        continue;
        String str = paramMessage.arg1 + "%";
        paramMessage = String.valueOf(paramMessage.obj);
        this.jdField_b_of_type_AndroidWidgetTextView.setText(str);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
      }
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.jdField_a_of_type_CooperationPluginIPluginManager.a("comic_plugin.apk");
    boolean bool = getIntent().getBooleanExtra("has_red_dot", false);
    int i;
    if (this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam != null)
    {
      if (localObject != null) {
        break label168;
      }
      j = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_a_of_type_Int;
      l1 = System.currentTimeMillis();
      l2 = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_b_of_type_Long;
      if (!this.jdField_a_of_type_Boolean) {
        break label131;
      }
      i = 0;
      if (!bool) {
        break label160;
      }
    }
    label131:
    label160:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), "-9999", String.valueOf(i), localObject });
      return super.onBackEvent();
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break;
        }
        i = 3;
        break;
      }
      i = 4;
      break;
    }
    label168:
    int j = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_a_of_type_Int;
    long l1 = System.currentTimeMillis();
    long l2 = this.jdField_a_of_type_CooperationComicVipComicJumpActivity$ComicParam.jdField_b_of_type_Long;
    int k = ((PluginBaseInfo)localObject).mState;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 0;
      label205:
      if (!bool) {
        break label296;
      }
    }
    label296:
    for (localObject = "1";; localObject = "0")
    {
      VipUtils.a(null, "VIPCOMIC", "0X8005FCD", "0X8005FCD", j, 0, new String[] { String.valueOf(l1 - l2), String.valueOf(k), String.valueOf(i), localObject });
      break;
      if (this.jdField_b_of_type_Boolean)
      {
        if (this.jdField_c_of_type_Boolean)
        {
          i = 2;
          break label205;
        }
        i = 3;
        break label205;
      }
      i = 4;
      break label205;
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler != null)
    {
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1000);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(1001);
    }
    this.jdField_d_of_type_Boolean = true;
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      getApplicationContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      if (QLog.isColorLevel()) {
        QLog.i("VipComicJumpActivity", 2, "VipComicJumpActivity.doOnCreate unregisterReceiver");
      }
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      if (QLog.isColorLevel()) {
        QLog.d("VipComicJumpActivity", 2, "VipComicJumpActivity onDestroy");
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        localIllegalArgumentException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.comic.VipComicJumpActivity
 * JD-Core Version:    0.7.0.1
 */