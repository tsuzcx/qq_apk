package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.flutter.api.IQFlutterRouterService;
import com.tencent.mobileqq.flutter.router.PageRouter;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameFlutterApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameMsgParser;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePubAccountHippyFragment;
import com.tencent.mobileqq.qqgamepub.ipc.QQGameIPCModule;
import com.tencent.mobileqq.qqgamepub.utils.GameCenterUtils;
import com.tencent.mobileqq.qqgamepub.utils.GamePAPreloadHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.mobileqq.qqgamepub.utils.SharePreferenceUtils;
import com.tencent.mobileqq.qqgamepub.view.GameArkView;
import com.tencent.mobileqq.qqgamepub.view.IHeaderView;
import com.tencent.mobileqq.qqgamepub.view.MoreMsgHeaderView;
import com.tencent.mobileqq.qqgamepub.view.NavBarQQGamePub;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QQGameHelperImpl
  implements IQQGameHelper
{
  public static final String HIPPY_FROM_DINAMIC = "dynamic";
  public static final String PROCESS_NAME_TOOL = "com.tencent.mobileqq:tool";
  private static final String TAG = "QQGamePub_QQGameHelper";
  private long mClickPubAioTime;
  
  public static AppRuntime getAppRuntime()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  private Class<? extends QPublicBaseFragment> getGameHippyFragment(String paramString)
  {
    if (paramString.equals("SGameOfficial"))
    {
      GamePubAccountHelper.b("2");
      return GamePubAccountHippyFragment.class;
    }
    if (paramString.equals("SGameOfficialV2"))
    {
      GamePubAccountHelper.b("3");
      GamePAPreloadHelper.a();
      return GamePAHippyFragmentV2.class;
    }
    return null;
  }
  
  public static int getProcessPid(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext != null)
      {
        paramContext = paramContext.getRunningAppProcesses();
        if (paramContext != null)
        {
          paramContext = paramContext.iterator();
          while (paramContext.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
            if (paramString.compareTo(localRunningAppProcessInfo.processName) == 0) {
              return localRunningAppProcessInfo.pid;
            }
          }
        }
      }
    }
    return -1;
  }
  
  public static int getRedDotUnreadCount()
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if ((localAppRuntime instanceof BaseQQAppInterface)) {
      return ((IConversationFacade)((BaseQQAppInterface)localAppRuntime).getRuntimeService(IConversationFacade.class)).getUnreadCount("2747277822", 1008);
    }
    return 0;
  }
  
  private boolean isFlutterInstall()
  {
    boolean bool1 = ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).isAppInstalled();
    boolean bool2 = ((IQQGameFlutterApi)QRoute.api(IQQGameFlutterApi.class)).isEngineInstalled();
    return (bool1) && (bool2);
  }
  
  private void jumpToHippyFragmemt(Context paramContext, String paramString, Class<? extends QPublicBaseFragment> paramClass)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isAnimated", true);
    localBundle.putBoolean("isStatusBarDarkFont", true);
    localBundle.putString("processName", "main");
    localBundle.putString("bundleName", paramString);
    localBundle.putLong("openPageStart", System.currentTimeMillis());
    paramString = createQQGameIntent(false);
    paramString.putExtra("params", localBundle);
    paramString.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(paramContext, paramString, QPublicTransFragmentActivity.class, paramClass);
    ((Activity)paramContext).overridePendingTransition(2130772023, 2130772024);
  }
  
  private void onUpdateGameCenterFinished()
  {
    Object localObject1 = ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).getHippyConfig();
    boolean bool;
    if ((((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch()) && ((((HippyConfig)localObject1).isGameCenterPreloadHippy()) || (((HippyConfig)localObject1).isGameCenterPredrawHippy()))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGameCenterUpdateFinished isCanPreload:");
      ((StringBuilder)localObject2).append(bool);
      QLog.d("QQGamePub_QQGameHelper", 2, ((StringBuilder)localObject2).toString());
    }
    if (!bool) {
      return;
    }
    Object localObject2 = new OpenHippyInfo();
    ((OpenHippyInfo)localObject2).bundleName = "QQGameCenter";
    ((OpenHippyInfo)localObject2).isPreload = ((HippyConfig)localObject1).isGameCenterPreloadHippy();
    ((OpenHippyInfo)localObject2).isPredraw = ((HippyConfig)localObject1).isGameCenterPredrawHippy();
    if (((HippyConfig)localObject1).isGameCenterLoadHippyInToolProcess()) {
      localObject1 = "tool";
    } else {
      localObject1 = "main";
    }
    ((OpenHippyInfo)localObject2).processName = ((String)localObject1);
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage((OpenHippyInfo)localObject2);
  }
  
  private void preloadFlutter()
  {
    ThreadManagerV2.executeOnSubThread(new QQGameHelperImpl.3(this));
  }
  
  private void report(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("report from：");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" status: ");
      localStringBuilder.append(paramInt2);
      QLog.i("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
    }
    ThreadManagerV2.excute(new QQGameHelperImpl.4(this, paramInt1, paramInt2), 128, null, true);
  }
  
  private void reportFlutterInstallState(PageRouter paramPageRouter)
  {
    if (paramPageRouter == null) {
      return;
    }
    String str2 = paramPageRouter.b;
    String str3 = paramPageRouter.jdField_a_of_type_JavaLangString;
    paramPageRouter = paramPageRouter.jdField_a_of_type_ComTencentMobileqqFlutterRouterSerializableMap;
    if ((paramPageRouter != null) && (paramPageRouter.getMap() != null)) {
      paramPageRouter = (String)paramPageRouter.getMap().get("uniquePagePath");
    } else {
      paramPageRouter = "";
    }
    boolean bool = isFlutterInstall();
    String str1;
    if (isFlutterInstall()) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("flutter install state :");
      localStringBuilder.append(bool);
      localStringBuilder.append(" pageName=");
      localStringBuilder.append(str2);
      localStringBuilder.append(" entryPoint=");
      localStringBuilder.append(str3);
      localStringBuilder.append(" uniquePagepath=");
      localStringBuilder.append(paramPageRouter);
      QLog.d("QQGamePub_QQGameHelper", 1, localStringBuilder.toString());
    }
    GamePubAccountHelper.a(GamePubAccountHelper.a()).c("208646").d("76933").a(11, str2).a(12, str3).a(13, paramPageRouter).a(14, str1).a();
  }
  
  private void startQQGamePaH5(Activity paramActivity)
  {
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isPubFeedByWeb())
    {
      GamePubAccountHelper.b("1");
      QLog.d("QQGamePub_QQGameHelper", 1, "--->enter GamePubAccount to H5");
      Intent localIntent = createQQGameIntent(true);
      localIntent.putExtra("arkResPath", ArkEnvironmentManager.getInstance().getAppResPath(""));
      QPublicFragmentActivityForTool.a(paramActivity, localIntent, QQGameFeedWebFragment.class, 10000);
      loadQGameHtmlOffline();
      return;
    }
    QLog.d("QQGamePub_QQGameHelper", 1, "--->enter GamePubAccount to aio");
    enterAIO(paramActivity);
  }
  
  private void updateGamePubReadTimeByLastMsg()
  {
    Object localObject = ((IMessageFacade)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IMessageFacade.class, "")).getLastMessage("2747277822", 1008);
    if (localObject != null)
    {
      long l = ((Message)localObject).time;
      localObject = MobileQQ.sMobileQQ;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sp_key_pub_account_read_time_");
      localStringBuilder.append(MD5Utils.encodeHexStr(getAccount()));
      SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString(), l);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("updateConversationReadTime:");
        ((StringBuilder)localObject).append(l);
        QLog.i("QQGamePub_QQGameHelper", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public Pair<String, JSONObject> addQQGameArkField(String paramString1, String paramString2, String paramString3, JSONObject paramJSONObject)
  {
    Object localObject3 = paramJSONObject.keys();
    Object localObject2 = "";
    int i = 0;
    for (Object localObject1 = ""; ((Iterator)localObject3).hasNext(); localObject1 = (String)((Iterator)localObject3).next())
    {
      i += 1;
      localObject1 = localObject2;
      if (i != 1) {
        break;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject2 = paramJSONObject.optJSONObject((String)localObject1);
      if (localObject2 == null) {
        return null;
      }
      ((JSONObject)localObject2).put("nativeScene", "gamePubAccount");
      ((JSONObject)localObject2).put("arkViewId", paramString2);
      ((JSONObject)localObject2).put("gamePubType", paramString3);
      ((JSONObject)localObject2).put("__clickTime", getClickAioTime());
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("QQGameMsgParserImpl arkViewId = ");
        ((StringBuilder)localObject3).append(paramString2);
        ((StringBuilder)localObject3).append(",gamePubType=");
        ((StringBuilder)localObject3).append(paramString3);
        ((StringBuilder)localObject3).append(",__clicktime:");
        ((StringBuilder)localObject3).append(getClickAioTime());
        QLog.d("QQGamePub_QQGameHelper", 4, ((StringBuilder)localObject3).toString());
      }
      ((IQQGamePreDownloadService)QRoute.api(IQQGamePreDownloadService.class)).setArkResNameToMeta(paramString1, (JSONObject)localObject2);
      paramJSONObject.put((String)localObject1, localObject2);
      return new Pair(localObject1, localObject2);
    }
    QLog.e("QQGamePub_QQGameHelper", 1, "addQQGameArkField,metaData has more 2 key");
    return null;
  }
  
  public boolean canLoad()
  {
    if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isPreloadSwitch())
    {
      QLog.i("QQGamePub_QQGameHelper", 2, "===can't preLoad because config switch is not open===");
      return false;
    }
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadIntervalDay() <= 0) {
      return false;
    }
    long l = getPreloadTime();
    if (NetConnInfoCenter.getServerTimeMillis() - l < ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getPreloadIntervalDay() * 24 * 60 * 60 * 1000)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("===can't preLoad because time is not in===");
      localStringBuilder.append(MobileQQ.processName);
      QLog.i("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public int canOpenHippyByModuleName(String paramString)
  {
    StringBuilder localStringBuilder;
    if ("SGameOfficial".equals(paramString))
    {
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippySwitch())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("canOpenHippyByModuleName ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" not allow");
          QLog.d("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
        }
        return -1;
      }
    }
    else
    {
      if (!"SGameOfficialV2".equals(paramString)) {
        break label268;
      }
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippyV2Switch())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("canOpenHippyByModuleName ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" not allow");
          QLog.d("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
        }
        return -1;
      }
    }
    if (((IHippySetting)QRoute.api(IHippySetting.class)).getModuleVersion(paramString) <= 0)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("canOpenHippyByModuleName ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" js bundle not exist");
      QLog.d("QQGamePub_QQGameHelper", 1, localStringBuilder.toString());
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).updateJsBundle(paramString, ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 4, null, null);
      return -2;
    }
    if (!((IHippyLibrary)QRoute.api(IHippyLibrary.class)).isLibrayExists())
    {
      QLog.d("QQGamePub_QQGameHelper", 1, "canOpenHippyByModuleName so not exist");
      return -3;
    }
    return 0;
    label268:
    if ("QQGameCenter".equals(paramString))
    {
      if (!((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch())
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("canOpenHippyByModuleName ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" not allow");
          QLog.d("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
        }
        return -1;
      }
      return 0;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("canOpenHippyByModuleName ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" invalid");
      QLog.d("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
    }
    return -4;
  }
  
  public Intent createQQGameIntent(boolean paramBoolean)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createQQGameIntent isWithColdBoot =");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQGamePub_QQGameHelper", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("settingInfo", "");
    ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_zf_games");
    ((Intent)localObject).putExtra("moduleId", "cmshowgame_module");
    ((Intent)localObject).putExtra("startTime", SystemClock.elapsedRealtime());
    ((Intent)localObject).putExtra("clickTime", System.currentTimeMillis());
    ((Intent)localObject).putExtra("unreadNum", getRedDotUnreadCount());
    ((Intent)localObject).putExtra("lastReadTime", getGamePubLastReadTime());
    if (paramBoolean)
    {
      if (getProcessPid(MobileQQ.sMobileQQ, "com.tencent.mobileqq:tool") == -1) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      ((Intent)localObject).putExtra("isColdBoot", paramBoolean);
    }
    return localObject;
  }
  
  public void dispatchVideoEvent(int paramInt)
  {
    GameVideoManager.b(paramInt);
  }
  
  public void enterAIO(Activity paramActivity)
  {
    enterAIO(paramActivity, false);
  }
  
  public void enterAIO(Activity paramActivity, boolean paramBoolean)
  {
    Object localObject;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("--->enter GamePubAccount by AIO,fromGamePub:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("QQGamePub_QQGameHelper", 1, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        initClickAioTime();
        localObject = getAIOURIRequest(paramActivity);
        ((ActivityURIRequest)localObject).extra().putBoolean("key_is_from_game_pub", paramBoolean);
        ((ActivityURIRequest)localObject).extra().putBoolean("game_pub_new_style_key", paramBoolean);
        ((ActivityURIRequest)localObject).extra().putBoolean("game_pub_is_night_mode", ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).isInNightMode());
        Bundle localBundle = ((ActivityURIRequest)localObject).extra();
        if (!paramBoolean) {
          break label151;
        }
        i = 2131695171;
        localBundle.putString("uinname", paramActivity.getString(i));
        QRoute.startUri((URIRequest)localObject, null);
        return;
      }
      catch (Throwable paramActivity)
      {
        paramActivity.printStackTrace();
      }
      return;
      label151:
      int i = 2131695226;
    }
  }
  
  public void enterGameCenter(String paramString)
  {
    if (canOpenHippyByModuleName("QQGameCenter") == 0)
    {
      openQQGameCenterByHippy(BaseApplication.getContext(), paramString, "publicplat");
      return;
    }
    if (URLUtil.a(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      String str = "?";
      if (paramString.contains("?")) {
        str = "&";
      }
      localStringBuilder.append(str);
      localStringBuilder.append("forceHtml=true");
      paramString = localStringBuilder.toString();
      startGameCenterActivity(BaseApplication.getContext(), paramString);
    }
  }
  
  public ActivityURIRequest getAIOURIRequest(Context paramContext)
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(paramContext, "/base/activity/ChatActivity");
    BaseAIOUtils.a(localActivityURIRequest, new int[] { 1 });
    localActivityURIRequest.extra().putBoolean("open_chatfragment", true);
    ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).initPublicAccountChatPieIntent(localActivityURIRequest);
    localActivityURIRequest.extra().putString("uin", "2747277822");
    localActivityURIRequest.extra().putInt("uintype", 1008);
    localActivityURIRequest.extra().putInt("entrance", 1);
    localActivityURIRequest.extra().putInt("aio_msg_source", 0);
    if (!(paramContext instanceof Activity)) {
      localActivityURIRequest.setFlags(268435456);
    }
    return localActivityURIRequest;
  }
  
  public String getAccount()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      return "0";
    }
    String str = ((AppRuntime)localObject).getAccount();
    localObject = str;
    if (str == null) {
      localObject = "0";
    }
    return localObject;
  }
  
  public long getClickAioTime()
  {
    return this.mClickPubAioTime;
  }
  
  public String getDebugGamePubAccountType()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("game_center_sp_mutiprocess", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAccount());
    localStringBuilder.append("ga_debug_type");
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public IHeaderView getGameArkView(Activity paramActivity)
  {
    return new GameArkView(paramActivity, null);
  }
  
  public String getGamePaHippyModuleName()
  {
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippyV2Switch()) {
      return "SGameOfficialV2";
    }
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getNewPAHippySwitch()) {
      return "SGameOfficial";
    }
    return "";
  }
  
  public long getGamePubLastReadTime()
  {
    Object localObject = MobileQQ.sMobileQQ;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_key_pub_account_read_time_");
    localStringBuilder.append(MD5Utils.encodeHexStr(getAccount()));
    long l = SharePreferenceUtils.a((Context)localObject, localStringBuilder.toString());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateGamePubReadTime:");
      ((StringBuilder)localObject).append(l);
      QLog.i("QQGamePub_QQGameHelper", 2, ((StringBuilder)localObject).toString());
    }
    return l;
  }
  
  public IHeaderView getMoreMsgHeaderView(Activity paramActivity)
  {
    return new MoreMsgHeaderView(paramActivity);
  }
  
  public QQGameMsgInfo getMsgInfoByHippyMap(HippyMap paramHippyMap)
  {
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    if (paramHippyMap != null)
    {
      if (paramHippyMap.containsKey("msgid")) {
        localQQGameMsgInfo.paMsgid = paramHippyMap.getString("msgid");
      }
      if (paramHippyMap.containsKey("msgType")) {
        localQQGameMsgInfo.msgType = paramHippyMap.getInt("msgType");
      }
      if (paramHippyMap.containsKey("gameAppId")) {
        localQQGameMsgInfo.gameAppId = paramHippyMap.getString("gameAppId");
      }
      if (paramHippyMap.containsKey("msgTime")) {
        localQQGameMsgInfo.msgTime = paramHippyMap.getLong("msgTime");
      }
      if (paramHippyMap.containsKey(" sorted_configs")) {
        localQQGameMsgInfo.sortedConfigs = paramHippyMap.getString(" sorted_configs");
      }
      if (paramHippyMap.containsKey("extJson")) {
        localQQGameMsgInfo.extJson = paramHippyMap.getString("extJson");
      }
      if (paramHippyMap.containsKey("icon")) {
        localQQGameMsgInfo.icon = paramHippyMap.getString("icon");
      }
      if (paramHippyMap.containsKey("desc")) {
        localQQGameMsgInfo.desc = paramHippyMap.getString("desc");
      }
      if (paramHippyMap.containsKey("frienduin")) {
        localQQGameMsgInfo.frienduin = paramHippyMap.getString("frienduin");
      }
      if (paramHippyMap.containsKey("uniseq")) {
        localQQGameMsgInfo.uniseq = paramHippyMap.getLong("uniseq");
      }
      if (paramHippyMap.containsKey("advId")) {
        localQQGameMsgInfo.advId = paramHippyMap.getString("advId");
      }
      if (paramHippyMap.containsKey("triggerInfo")) {
        localQQGameMsgInfo.triggerInfo = paramHippyMap.getString("triggerInfo");
      }
      if (paramHippyMap.containsKey("appName")) {
        localQQGameMsgInfo.arkAppName = paramHippyMap.getString("appName");
      }
      if (paramHippyMap.containsKey("appView")) {
        localQQGameMsgInfo.arkAppView = paramHippyMap.getString("appView");
      }
      if (paramHippyMap.containsKey("appMinVersion")) {
        localQQGameMsgInfo.arkAppMinVersion = paramHippyMap.getString("appMinVersion");
      }
      if (paramHippyMap.containsKey("appMetaList")) {
        localQQGameMsgInfo.arkMetaList = paramHippyMap.getString("appMetaList");
      }
      if (paramHippyMap.containsKey("appConfig")) {
        localQQGameMsgInfo.arkAppConfig = paramHippyMap.getString("appConfig");
      }
      if (paramHippyMap.containsKey("width")) {
        localQQGameMsgInfo.arkWidth = paramHippyMap.getInt("width");
      }
      if (paramHippyMap.containsKey("height")) {
        localQQGameMsgInfo.arkHeight = paramHippyMap.getInt("height");
      }
      if (paramHippyMap.containsKey("coverUrl")) {
        localQQGameMsgInfo.coverUrl = paramHippyMap.getString("coverUrl");
      }
      if (paramHippyMap.containsKey("url")) {
        localQQGameMsgInfo.url = paramHippyMap.getString("url");
      }
      if (paramHippyMap.containsKey("title")) {
        localQQGameMsgInfo.title = paramHippyMap.getString("title");
      }
      if (paramHippyMap.containsKey("dateTitle")) {
        localQQGameMsgInfo.dateTitle = paramHippyMap.getString("dateTitle");
      }
      if (paramHippyMap.containsKey("contentText")) {
        localQQGameMsgInfo.contentText = paramHippyMap.getString("contentText");
      }
      if (paramHippyMap.containsKey("limitText")) {
        localQQGameMsgInfo.limitText = paramHippyMap.getString("limitText");
      }
    }
    return localQQGameMsgInfo;
  }
  
  public int getMsgPosByHippyMap(HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("pos"))) {
      return paramHippyMap.getInt("pos");
    }
    return 0;
  }
  
  public long getPreloadTime()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("game_center_sp_mutiprocess", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAccount());
    localStringBuilder.append("preload_time");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
  }
  
  public QIPCModule getQQGameIPCModule()
  {
    return QQGameIPCModule.a();
  }
  
  public String getQQGameIPCModuleName()
  {
    return "QQGameIPCModule";
  }
  
  public void initClickAioTime()
  {
    this.mClickPubAioTime = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initClickAioTime:");
      localStringBuilder.append(this.mClickPubAioTime);
      QLog.i("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
    }
  }
  
  public boolean isGamePubAccountDebugOpen()
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("game_center_sp_mutiprocess", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getAccount());
    localStringBuilder.append("ga_debug_mode");
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
  }
  
  public boolean isInValidGameAppId(String paramString)
  {
    boolean bool = false;
    long l;
    try
    {
      int i = Integer.parseInt(paramString);
      l = i;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGamePub_QQGameHelper", 1, paramString, new Object[0]);
      l = 0L;
    }
    if (l == 0L) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isNewPubStyle(Context paramContext, String paramString)
  {
    if ((isQQGamePubAccount(paramString)) && ((paramContext instanceof Activity))) {
      return ((Activity)paramContext).getIntent().getBooleanExtra("game_pub_new_style_key", false);
    }
    return false;
  }
  
  public boolean isQQGamePubAccount(String paramString)
  {
    return "2747277822".equals(paramString);
  }
  
  public void loadQGameHtmlOffline()
  {
    ThreadManagerV2.executeOnSubThread(new QQGameHelperImpl.2(this));
  }
  
  public void notiftyQQGameNewMsg(List<MessageRecord> paramList)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (!(localAppRuntime instanceof BaseQQAppInterface)) {
      return;
    }
    ((IGamePubAccountMsgService)localAppRuntime.getRuntimeService(IGamePubAccountMsgService.class, "")).onGameNewMsg(paramList);
  }
  
  public void openQQGameCenterByHippy(Context paramContext, String paramString1, String paramString2)
  {
    String str;
    if (paramString1 != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      str = "?";
      if (paramString1.contains("?")) {
        str = "&";
      }
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("forceHtml=true");
      str = ((StringBuilder)localObject).toString();
    }
    else
    {
      str = null;
    }
    Object localObject = ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).getHippyConfig();
    OpenHippyInfo localOpenHippyInfo = new OpenHippyInfo();
    localOpenHippyInfo.bundleName = "QQGameCenter";
    localOpenHippyInfo.url = paramString1;
    localOpenHippyInfo.errorUrl = str;
    localOpenHippyInfo.isAnimated = true;
    localOpenHippyInfo.isStatusBarDarkFont = true;
    localOpenHippyInfo.isEnbaleRightFling = false;
    localOpenHippyInfo.from = paramString2;
    if (((HippyConfig)localObject).isGameCenterLoadHippyInToolProcess()) {
      paramString1 = "tool";
    } else {
      paramString1 = "main";
    }
    localOpenHippyInfo.processName = paramString1;
    localOpenHippyInfo.isPreloadWhenClosed = ((HippyConfig)localObject).isGameCenterPreloadHippy();
    localOpenHippyInfo.isPredrawWhenClosed = ((HippyConfig)localObject).isGameCenterPredrawHippy();
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).openHippyPage(paramContext, localOpenHippyInfo);
  }
  
  public void preloadQQGameCenterByHippy()
  {
    boolean bool1 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).getHippySwitch();
    boolean bool2 = ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isGameCenterPreloadByTab();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadQQGameCenterByHippy isHippySwitchOpened:");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" isPreloadByTab:");
      localStringBuilder.append(bool2);
      QLog.d("QQGamePub_QQGameHelper", 2, localStringBuilder.toString());
    }
    if (bool1)
    {
      if (bool2) {
        return;
      }
      ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).updateJsBundle("QQGameCenter", ((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 3, null, new QQGameHelperImpl.5(this));
    }
  }
  
  public void preloadSw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGamePub_QQGameHelper", 1, "===preloadSw===");
    }
    SwiftBrowserIdleTaskHelper.a().a(new QQGameHelperImpl.1(this, 4096));
  }
  
  public void publicAccountTianshuReport(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("publicAccountTianshuReport---> action=");
      ((StringBuilder)localObject1).append(paramInt1);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("   position=");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d("QQGamePub_QQGameHelper", 1, new Object[] { localObject1, ((StringBuilder)localObject2).toString() });
    }
    if (paramQQGameMsgInfo == null) {
      return;
    }
    if (paramInt1 == 117) {
      ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).publicAccountExposureReport(paramQQGameMsgInfo.frienduin, paramQQGameMsgInfo.uniseq);
    }
    if (!TextUtils.isEmpty(paramQQGameMsgInfo.advId)) {
      localObject1 = paramQQGameMsgInfo.advId;
    } else {
      localObject1 = "";
    }
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    ((IQQGameTempRelyApi)QRoute.api(IQQGameTempRelyApi.class)).exePublicAccountTianshuReport(paramInt1, paramInt2, (String)localObject1, paramQQGameMsgInfo.triggerInfo);
    if (paramInt1 == 117) {}
    for (Object localObject2 = "207701";; localObject2 = "207702")
    {
      break;
      if (paramInt1 != 118) {
        return;
      }
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(2), localObject1);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramInt1);
    ((StringBuilder)localObject1).append("");
    localHashMap.put(Integer.valueOf(6), ((StringBuilder)localObject1).toString());
    localHashMap.put(Integer.valueOf(24), GamePubAccountHelper.a());
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "769", (String)localObject2, paramQQGameMsgInfo.gameAppId, "76926", "1", "160", localHashMap);
  }
  
  public void reportArkExposure(Context paramContext, MessageRecord paramMessageRecord)
  {
    Object localObject = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord(paramMessageRecord);
    if ((localObject != null) && ((paramContext instanceof Activity)))
    {
      boolean bool = ((IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(((Activity)paramContext).getIntent());
      paramMessageRecord = new WadlReportBuilder();
      localObject = paramMessageRecord.a("dc00087").h("769").c("208653").b(((QQGameMsgInfo)localObject).gameAppId).d("76901").g("8").e("1").f("160");
      if (bool) {
        paramContext = "3";
      } else {
        paramContext = "2";
      }
      ((WadlReportBuilder)localObject).a(3, paramContext).a(2, "1");
      paramMessageRecord.a();
    }
  }
  
  public void reportStructClick(Context paramContext, MessageRecord paramMessageRecord)
  {
    Object localObject = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord(paramMessageRecord);
    if ((localObject != null) && ((paramContext instanceof Activity)))
    {
      boolean bool = ((IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(((Activity)paramContext).getIntent());
      paramMessageRecord = new WadlReportBuilder();
      localObject = paramMessageRecord.a("dc00087").h("769").c("208654").b(((QQGameMsgInfo)localObject).gameAppId).d("76901").g("20").e("1").f("160");
      if (bool) {
        paramContext = "3";
      } else {
        paramContext = "2";
      }
      ((WadlReportBuilder)localObject).a(3, paramContext).a(2, "2");
      paramMessageRecord.a();
    }
  }
  
  public void reportStructExposure(Context paramContext, MessageRecord paramMessageRecord)
  {
    Object localObject = ((IQQGameMsgParser)QRoute.api(IQQGameMsgParser.class)).parseMessageRecord(paramMessageRecord);
    if ((localObject != null) && ((paramContext instanceof Activity)))
    {
      boolean bool = ((IQQGameSubscribeService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IQQGameSubscribeService.class, "all")).isGameSinglePage(((Activity)paramContext).getIntent());
      paramMessageRecord = new WadlReportBuilder();
      localObject = paramMessageRecord.a("dc00087").h("769").c("208653").b(((QQGameMsgInfo)localObject).gameAppId).d("76901").g("8").e("1").f("160");
      if (bool) {
        paramContext = "3";
      } else {
        paramContext = "2";
      }
      ((WadlReportBuilder)localObject).a(3, paramContext).a(2, "2");
      paramMessageRecord.a();
    }
  }
  
  public void savePreloadTime(long paramLong)
  {
    try
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("game_center_sp_mutiprocess", 4);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getAccount());
      ((StringBuilder)localObject).append("preload_time");
      localObject = ((StringBuilder)localObject).toString();
      localSharedPreferences.edit().putLong((String)localObject, paramLong).apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGamePub_QQGameHelper", 2, QLog.getStackTraceString(localThrowable));
    }
  }
  
  public void setDebugGamePubAccountType(String paramString)
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("game_center_sp_mutiprocess", 4);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getAccount());
    ((StringBuilder)localObject).append("ga_debug_type");
    localObject = ((StringBuilder)localObject).toString();
    localSharedPreferences.edit().putString((String)localObject, paramString).apply();
  }
  
  public void setGamePubAccountMode(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("game_center_sp_mutiprocess", 4);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getAccount());
    ((StringBuilder)localObject).append("ga_debug_mode");
    localObject = ((StringBuilder)localObject).toString();
    localSharedPreferences.edit().putBoolean((String)localObject, paramBoolean).apply();
  }
  
  public void showGameEnterCacheInfo(View paramView, GmpEnterInfoRsp paramGmpEnterInfoRsp)
  {
    if (!(paramView instanceof NavBarQQGamePub)) {
      return;
    }
    paramView = (NavBarQQGamePub)paramView;
    if ((!TextUtils.isEmpty(paramGmpEnterInfoRsp.url)) && (!TextUtils.isEmpty(paramGmpEnterInfoRsp.bubble_id)))
    {
      if (paramView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePub_QQGameHelper", 1, "show game enter cache icon");
        }
        paramView.setCurType(3);
        paramView.a(paramGmpEnterInfoRsp.url);
        paramView.setmBubbleid(paramGmpEnterInfoRsp.bubble_id);
        paramView.a(true);
      }
    }
    else if (paramView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGamePub_QQGameHelper", 1, "show game enter");
      }
      paramView.setCurType(1);
      paramView.a(false);
      paramView.setmBubbleid("");
    }
  }
  
  public void startGameCenterActivity(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      paramContext = new ActivityURIRequest(paramContext, "/base/activity/GameCenterActivity");
      paramContext.extra().putString("url", paramString);
      paramContext.extra().putLong("startOpenPageTime", System.currentTimeMillis());
      paramContext.extra().putString("big_brother_source_key", "biz_src_zf_games");
      paramContext.setFlags(268435456);
      QRoute.startUri(paramContext, null);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public void startQQGameFlutter(Context paramContext, PageRouter paramPageRouter, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePub_QQGameHelper", 4, "startQQGameFlutter");
    }
    try
    {
      reportFlutterInstallState(paramPageRouter);
      ((IQFlutterRouterService)getAppRuntime().getRuntimeService(IQFlutterRouterService.class, "all")).openPageByMainProcess(paramContext, paramPageRouter, paramBundle);
      return;
    }
    catch (Throwable paramContext)
    {
      paramPageRouter = new StringBuilder();
      paramPageRouter.append("startQQGameFlutter error:");
      paramPageRouter.append(paramContext);
      QLog.e("QQGamePub_QQGameHelper", 1, paramPageRouter.toString());
    }
  }
  
  public void startQQGamePubAccount(Context paramContext, int paramInt)
  {
    initClickAioTime();
    String str = getGamePaHippyModuleName();
    int i = canOpenHippyByModuleName(str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startQQGamePubAccount status=");
      localStringBuilder.append(i);
      localStringBuilder.append(",moduleName=");
      localStringBuilder.append(str);
      localStringBuilder.append(",from=");
      localStringBuilder.append(paramInt);
      QLog.d("QQGamePub_QQGameHelper", 1, localStringBuilder.toString());
    }
    report(paramInt, i);
    if (i != 0)
    {
      startQQGamePaH5((Activity)paramContext);
      return;
    }
    jumpToHippyFragmemt(paramContext, str, getGameHippyFragment(str));
    updateGamePubReadTimeByLastMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl
 * JD-Core Version:    0.7.0.1
 */