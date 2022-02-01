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
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.api.IQQGameMsgParser;
import com.tencent.mobileqq.qqgamepub.api.IQQGamePreDownloadService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameSubscribeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameTempRelyApi;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragment;
import com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2;
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
  public static final String HIPPY_PSKEY_DOMAIN = "gamecenter.qq.com";
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
      GamePubAccountHelper.e("2");
      return GamePAHippyFragment.class;
    }
    if (paramString.equals("SGameOfficialV2"))
    {
      GamePubAccountHelper.e("3");
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
  
  private void jumpToHippyFragmemt(Context paramContext, String paramString, Class<? extends QPublicBaseFragment> paramClass)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isAnimated", true);
    localBundle.putBoolean("isStatusBarDarkFont", true);
    localBundle.putString("processName", "main");
    localBundle.putString("bundleName", paramString);
    localBundle.putString("domain", "gamecenter.qq.com");
    localBundle.putLong("openPageStart", System.currentTimeMillis());
    paramString = createQQGameIntent(false);
    paramString.putExtra("params", localBundle);
    paramString.putExtra("public_fragment_window_feature", 1);
    QPublicFragmentActivity.Launcher.a(paramContext, paramString, QPublicTransFragmentActivity.class, paramClass);
    ((Activity)paramContext).overridePendingTransition(2130772028, 2130772029);
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
    ThreadManagerV2.executeOnSubThread(new QQGameHelperImpl.2(this));
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
    ThreadManagerV2.excute(new QQGameHelperImpl.3(this, paramInt1, paramInt2), 128, null, true);
  }
  
  private void startQQGamePaH5(Activity paramActivity)
  {
    if (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isPubFeedByWeb())
    {
      GamePubAccountHelper.e("1");
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
        i = 2131892904;
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
      int i = 2131892960;
    }
  }
  
  public void enterGameCenter(String paramString)
  {
    if (((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).canOpenHippyByModuleName("QQGameCenter") == 0)
    {
      ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).openQQGameCenterByHippy(BaseApplication.getContext(), paramString, "publicplat");
      return;
    }
    if (URLUtil.e(paramString))
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
    ThreadManagerV2.executeOnSubThread(new QQGameHelperImpl.1(this));
  }
  
  public void notiftyQQGameNewMsg(List<MessageRecord> paramList)
  {
    AppRuntime localAppRuntime = getAppRuntime();
    if (!(localAppRuntime instanceof BaseQQAppInterface)) {
      return;
    }
    ((IGamePubAccountMsgService)localAppRuntime.getRuntimeService(IGamePubAccountMsgService.class, "")).onGameNewMsg(paramList);
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
    if ((!TextUtils.isEmpty(paramGmpEnterInfoRsp.url)) && (!TextUtils.isEmpty(paramGmpEnterInfoRsp.bubbleId)))
    {
      if (paramView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGamePub_QQGameHelper", 1, "show game enter cache icon");
        }
        paramView.setCurType(3);
        paramView.a(paramGmpEnterInfoRsp.url);
        paramView.setmBubbleid(paramGmpEnterInfoRsp.bubbleId);
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
    catch (Throwable paramContext)
    {
      QLog.e("QQGamePub_QQGameHelper", 1, paramContext, new Object[0]);
    }
  }
  
  public void startQQGamePubAccount(Context paramContext, int paramInt)
  {
    initClickAioTime();
    String str = ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName();
    int i = ((IQQGameHippyApi)QRoute.api(IQQGameHippyApi.class)).canOpenHippyByModuleName(str);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startQQGamePubAccount status=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",moduleName=");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(",from=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("QQGamePub_QQGameHelper", 1, ((StringBuilder)localObject).toString());
    }
    report(paramInt, i);
    if (i != 0)
    {
      startQQGamePaH5((Activity)paramContext);
      return;
    }
    Object localObject = getGameHippyFragment(str);
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("startQQGamePubAccount hippyFragment is null,moduleName=");
        paramContext.append(str);
        QLog.d("QQGamePub_QQGameHelper", 2, paramContext.toString());
      }
      return;
    }
    jumpToHippyFragmemt(paramContext, str, (Class)localObject);
    updateGamePubReadTimeByLastMsg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.impl.QQGameHelperImpl
 * JD-Core Version:    0.7.0.1
 */