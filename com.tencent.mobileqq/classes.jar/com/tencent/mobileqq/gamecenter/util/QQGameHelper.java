package com.tencent.mobileqq.gamecenter.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamecenter.activities.GameCenterActivity;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.update.HippyUpdateManager.HippyConfig;
import com.tencent.hippy.qq.update.UpdateSetting;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyAccessHelper.OpenHippyInfo;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.QGameBusEvent;
import com.tencent.mobileqq.gamecenter.hippy.GamePAHippyFragmentV2;
import com.tencent.mobileqq.gamecenter.hippy.GamePubAccountHippyFragment;
import com.tencent.mobileqq.gamecenter.hippy.GamePubAccountMsgManager;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.view.GameArkView;
import com.tencent.mobileqq.gamecenter.view.IHeaderView;
import com.tencent.mobileqq.gamecenter.view.NavBarQQGamePub;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.startup.step.ProcessInfoUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.URLUtil;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.gamecenter.wadl.biz.entity.WadlResult;>;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QQGameHelper
{
  private static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString = "https://w.gamecenter.qq.com/v1/cgi-bin/common/feeds";
  private static Map<String, String> jdField_a_of_type_JavaUtilMap;
  private static WeakReference<QQGameHelper.OnPreloadFeedsListener> jdField_a_of_type_MqqUtilWeakReference;
  public static volatile boolean a;
  private static long jdField_b_of_type_Long;
  private static String jdField_b_of_type_JavaLangString = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/first";
  private static Map<String, List<Long>> jdField_b_of_type_JavaUtilMap;
  public static volatile boolean b;
  private static long jdField_c_of_type_Long;
  private static String jdField_c_of_type_JavaLangString = "https://hao.gamecenter.qq.com/sgame-official-account/cgi-bin/get-game-priority-json";
  public static volatile boolean c;
  private static String d = "";
  private static String e;
  
  static
  {
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_Boolean = false;
    jdField_c_of_type_Boolean = false;
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new HashMap());
  }
  
  public static float a(int paramInt, float paramFloat1, float paramFloat2)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramFloat1 > 0.0F)
    {
      f1 = f2;
      if (paramFloat2 > 0.0F)
      {
        paramFloat1 = paramFloat2 / paramFloat1;
        f1 = f2;
        if (paramFloat1 != 0.0F) {
          f1 = paramInt / paramFloat1;
        }
      }
    }
    return f1;
  }
  
  public static int a()
  {
    Object localObject = a();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if ((((QQAppInterface)localObject).getMessageFacade() == null) || (((QQAppInterface)localObject).getMessageFacade().a() == null)) {
        return 0;
      }
      return ((QQAppInterface)localObject).getMessageFacade().a().a("2747277822", 1008);
    }
    return 0;
  }
  
  public static int a(HippyMap paramHippyMap)
  {
    int j = 0;
    int i = j;
    if (paramHippyMap != null)
    {
      i = j;
      if (paramHippyMap.containsKey("pos")) {
        i = paramHippyMap.getInt("pos");
      }
    }
    return i;
  }
  
  public static int a(String paramString)
  {
    if ("SGameOfficial".equals(paramString))
    {
      if (QQGameConfigUtil.b() != 0) {
        break label200;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 2, "canOpenHippyByModuleName " + paramString + " not allow");
      }
    }
    do
    {
      do
      {
        return -1;
        if (!"SGameOfficialV2".equals(paramString)) {
          break;
        }
        if (QQGameConfigUtil.c() != 0) {
          break label200;
        }
      } while (!QLog.isColorLevel());
      QLog.d("QQGameHelper", 2, "canOpenHippyByModuleName " + paramString + " not allow");
      return -1;
      if (!"QQGameCenter".equals(paramString)) {
        break label161;
      }
      if (QQGameConfigUtil.g()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQGameHelper", 2, "canOpenHippyByModuleName " + paramString + " not allow");
    return -1;
    return 0;
    label161:
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 2, "canOpenHippyByModuleName " + paramString + " invalid");
    }
    return -4;
    label200:
    if (UpdateSetting.getInstance().getModuleVersion(paramString) <= 0)
    {
      QLog.d("QQGameHelper", 1, "canOpenHippyByModuleName " + paramString + " js bundle not exist");
      HippyUpdateManager.getInstance().updateJsBundle(paramString, QQGameConfigUtil.i(), 4, null);
      return -2;
    }
    if (!HippyQQLibraryManager.getInstance().isLibrayExists())
    {
      QLog.d("QQGameHelper", 1, "canOpenHippyByModuleName so not exist");
      return -3;
    }
    return 0;
  }
  
  public static long a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    return localBaseApplicationImpl.getSharedPreferences("game_center_sp_mutiprocess", 4).getLong(localBaseApplicationImpl.getRuntime().getAccount() + "preload_time", 0L);
  }
  
  public static long a(ArrayList<WadlResult> paramArrayList)
  {
    long l2 = 0L;
    Object localObject2 = "";
    int i = 0;
    Object localObject1 = "";
    long l1 = l2;
    if (paramArrayList != null)
    {
      l1 = l2;
      if (paramArrayList.size() > 0)
      {
        Iterator localIterator = paramArrayList.iterator();
        l1 = 0L;
        paramArrayList = (ArrayList<WadlResult>)localObject2;
        if (localIterator.hasNext())
        {
          localObject2 = (WadlResult)localIterator.next();
          if ((((WadlResult)localObject2).b != 6) || (((WadlResult)localObject2).jdField_c_of_type_Long <= l1)) {
            break label245;
          }
          l1 = ((WadlResult)localObject2).jdField_c_of_type_Long;
          localObject1 = ((WadlResult)localObject2).a.jdField_a_of_type_JavaLangString;
          i = ((WadlResult)localObject2).a.e;
          paramArrayList = ((WadlResult)localObject2).a.f;
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramArrayList;
      paramArrayList = (ArrayList<WadlResult>)localObject2;
      break;
      l1 = l2;
      if (!TextUtils.isEmpty(paramArrayList))
      {
        int j = GameCenterUtils.a((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "appVersionCode = " + j + " lastGameVer=" + i);
        }
        if (j < i) {
          break label230;
        }
        l1 = l2;
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "getLastGameAppID gameAppId=" + l1);
        }
        return l1;
        try
        {
          label230:
          l1 = Long.parseLong(paramArrayList);
        }
        catch (NumberFormatException paramArrayList)
        {
          l1 = l2;
        }
      }
      label245:
      localObject2 = paramArrayList;
      paramArrayList = (ArrayList<WadlResult>)localObject1;
      localObject1 = localObject2;
    }
  }
  
  public static Intent a(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, "createQQGameIntent isWithColdBoot =" + paramBoolean);
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("settingInfo", "");
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
    localIntent.putExtra("moduleId", "cmshowgame_module");
    localIntent.putExtra("startTime", SystemClock.elapsedRealtime());
    localIntent.putExtra("clickTime", System.currentTimeMillis());
    localIntent.putExtra("unreadNum", a());
    if (paramBoolean) {
      if (ProcessInfoUtil.a(BaseApplicationImpl.getContext(), "com.tencent.mobileqq:tool") != -1) {
        break label137;
      }
    }
    label137:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localIntent.putExtra("isColdBoot", paramBoolean);
      return localIntent;
    }
  }
  
  public static WadlReportBuilder a(String paramString)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    localWadlReportBuilder.a("dc00087").g("769").e("1").f("160").a(24, paramString);
    return localWadlReportBuilder;
  }
  
  public static GmpEnterInfoRsp a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_jumpUrl";
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_bubbleId";
    GmpEnterInfoRsp localGmpEnterInfoRsp = new GmpEnterInfoRsp();
    localGmpEnterInfoRsp.url = localSharedPreferences.getString(str, "");
    localGmpEnterInfoRsp.bubble_id = localSharedPreferences.getString((String)localObject, "");
    return localGmpEnterInfoRsp;
  }
  
  public static QQGameMsgInfo a(HippyMap paramHippyMap)
  {
    QQGameMsgInfo localQQGameMsgInfo = new QQGameMsgInfo();
    if (paramHippyMap != null)
    {
      if (paramHippyMap.containsKey("msgID")) {
        localQQGameMsgInfo.paMsgid = paramHippyMap.getString("msgID");
      }
      if (paramHippyMap.containsKey("msgType")) {
        localQQGameMsgInfo.msgType = paramHippyMap.getInt("msgType");
      }
      if (paramHippyMap.containsKey("appID")) {
        localQQGameMsgInfo.gameAppId = paramHippyMap.getString("appID");
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
  
  public static String a()
  {
    if (QQGameConfigUtil.c() == 1) {
      return "SGameOfficialV2";
    }
    if (QQGameConfigUtil.b() == 1) {
      return "SGameOfficial";
    }
    return "";
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    return paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getString("msgPos_web" + paramAppInterface.getCurrentAccountUin(), "");
  }
  
  public static String a(String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return (String)jdField_a_of_type_JavaUtilMap.get(paramString);
    }
    return "";
  }
  
  public static AppRuntime a()
  {
    AppRuntime localAppRuntime = null;
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      localAppRuntime = localBaseApplicationImpl.getRuntime();
    }
    return localAppRuntime;
  }
  
  public static JSONArray a(List<QQGameMsgInfo> paramList)
  {
    localJSONArray = new JSONArray();
    if ((paramList != null) && (paramList.size() > 0)) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          QQGameMsgInfo localQQGameMsgInfo = (QQGameMsgInfo)paramList.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
          if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
            localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
          }
          if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
            localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
          }
          localJSONArray.put(localJSONObject);
        }
        return localJSONArray;
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
    }
  }
  
  public static JSONObject a(QQGameMsgInfo paramQQGameMsgInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("appName", paramQQGameMsgInfo.arkAppName);
      localJSONObject.put("appView", paramQQGameMsgInfo.arkAppView);
      localJSONObject.put("appMinVersion", paramQQGameMsgInfo.arkAppMinVersion);
      localJSONObject.put("appMetaList", paramQQGameMsgInfo.arkMetaList);
      localJSONObject.put("appConfig", paramQQGameMsgInfo.arkAppConfig);
      int i = (int)AIOUtils.a(DisplayUtil.a(BaseApplicationImpl.getContext()).a, BaseApplicationImpl.getApplication().getResources());
      int j = (int)a(i, paramQQGameMsgInfo.arkHeight, paramQQGameMsgInfo.arkWidth);
      QLog.e("QQGameHelper", 1, "msgInfo.arkHeight =" + paramQQGameMsgInfo.arkHeight + "/msgInfo.arkWidth=" + paramQQGameMsgInfo.arkWidth + "/getGameArkData targetWidth=/targetHeight=" + j);
      localJSONObject.put("width", i);
      localJSONObject.put("height", j);
      return localJSONObject;
    }
    catch (JSONException paramQQGameMsgInfo)
    {
      paramQQGameMsgInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static JSONObject a(String paramString)
  {
    try
    {
      if (jdField_b_of_type_JavaUtilMap.containsKey(paramString))
      {
        List localList = (List)jdField_b_of_type_JavaUtilMap.get(paramString);
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("apiSendEnd", localList.get(0));
        localJSONObject.put("sendPack", localList.get(1));
        localJSONObject.put("resPack", localList.get(2));
        localJSONObject.put("apiPackStart", localList.get(3));
        long l = ((Long)localList.get(3)).longValue() - ((Long)localList.get(0)).longValue();
        localJSONObject.put("costTime", l + "");
        a(b()).c("206660").a(15, paramString).a(16, localList.get(0) + "").a(17, localList.get(1) + "").a(18, localList.get(2) + "").a(19, localList.get(3) + "").a(20, l + "").a();
        return localJSONObject;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static void a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_jumpUrl";
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_bubbleId";
    localSharedPreferences.edit().putString(str, "").apply();
    localSharedPreferences.edit().putString((String)localObject, "").apply();
  }
  
  public static void a(int paramInt)
  {
    QGameBusEvent localQGameBusEvent = new QGameBusEvent(paramInt);
    SimpleEventBus.getInstance().dispatchEvent(localQGameBusEvent);
  }
  
  public static void a(int paramInt1, QQGameMsgInfo paramQQGameMsgInfo, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, new Object[] { "publicAccountTianshuReport---> action=" + paramInt1, "   position=" + paramInt2 });
    }
    if (paramQQGameMsgInfo == null) {}
    String str1;
    do
    {
      return;
      if (paramInt1 == 117) {
        PublicAccountEventReport.a(paramQQGameMsgInfo.frienduin, paramQQGameMsgInfo.uniseq);
      }
      str1 = "";
      if (!TextUtils.isEmpty(paramQQGameMsgInfo.advId)) {
        str1 = paramQQGameMsgInfo.advId;
      }
    } while (TextUtils.isEmpty(str1));
    PublicAccountEventReport.a(paramInt1, paramInt2, str1, paramQQGameMsgInfo.triggerInfo);
    if (paramInt1 == 117) {}
    for (String str2 = "207701";; str2 = "207702")
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(Integer.valueOf(2), str1);
      localHashMap.put(Integer.valueOf(6), paramInt1 + "");
      localHashMap.put(Integer.valueOf(24), b());
      GameCenterUtils.a(CmGameUtil.a(), "769", str2, paramQQGameMsgInfo.gameAppId, "76926", "1", "160", localHashMap);
      return;
      if (paramInt1 != 118) {
        break;
      }
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      Object localObject = BaseApplicationImpl.getApplication();
      if (localObject != null)
      {
        SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp_mutiprocess", 4);
        localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "preload_time";
        localSharedPreferences.edit().putLong((String)localObject, paramLong).apply();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGameHelper", 2, QLog.getStackTraceString(localThrowable));
    }
  }
  
  public static void a(Activity paramActivity)
  {
    if (QQGameConfigUtil.d())
    {
      c("1");
      QLog.d("QQGameHelper", 1, "--->enter GamePubAccount to H5");
      PublicFragmentActivityForTool.b(paramActivity, a(true), QQGameFeedWebFragment.class, 10000);
      c();
      return;
    }
    QLog.d("QQGameHelper", 1, "--->enter GamePubAccount to aio");
    b(paramActivity);
  }
  
  public static void a(Context paramContext)
  {
    Object localObject2 = a();
    int i = a(a());
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, "startQQGamePubAccount status=" + i + ",moduleName:" + (String)localObject2);
    }
    new WadlReportBuilder().a("dc00087").g("771").c("206612").a(1, "76918").a(11, "1").a(12, "160").a(13, a()).a(i).a();
    if (i != 0)
    {
      a((Activity)paramContext);
      return;
    }
    Object localObject1 = null;
    if (((String)localObject2).equals("SGameOfficial"))
    {
      c("2");
      localObject1 = GamePubAccountHippyFragment.class;
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isAnimated", true);
      localBundle.putBoolean("isStatusBarDarkFont", true);
      localBundle.putBoolean("isInToolProcess", false);
      localBundle.putString("bundleName", (String)localObject2);
      localBundle.putLong("openPageStart", System.currentTimeMillis());
      localObject2 = a(false);
      ((Intent)localObject2).putExtra("params", localBundle);
      ((Intent)localObject2).putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.Launcher.a(paramContext, (Intent)localObject2, PublicTransFragmentActivity.class, (Class)localObject1);
      ((Activity)paramContext).overridePendingTransition(2130772014, 2130772238);
      return;
      if (((String)localObject2).equals("SGameOfficialV2"))
      {
        c("3");
        localObject1 = GamePAHippyFragmentV2.class;
        f();
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    try
    {
      Intent localIntent = new Intent(paramContext, GameCenterActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_games");
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Throwable paramContext) {}
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    String str = null;
    Object localObject;
    if (paramString1 != null)
    {
      localObject = new StringBuilder().append(paramString1);
      if (!paramString1.contains("?")) {
        break label147;
      }
    }
    label147:
    for (str = "&";; str = "?")
    {
      str = str + "forceHtml=true";
      localObject = HippyUpdateManager.getInstance().getHippyConfig();
      HippyAccessHelper.OpenHippyInfo localOpenHippyInfo = new HippyAccessHelper.OpenHippyInfo();
      localOpenHippyInfo.bundleName = "QQGameCenter";
      localOpenHippyInfo.url = paramString1;
      localOpenHippyInfo.errorUrl = str;
      localOpenHippyInfo.isAnimated = true;
      localOpenHippyInfo.isStatusBarDarkFont = true;
      localOpenHippyInfo.isEnbaleRightFling = false;
      localOpenHippyInfo.from = paramString2;
      localOpenHippyInfo.isInToolProcess = ((HippyUpdateManager.HippyConfig)localObject).isLoadHippyInToolProcess();
      localOpenHippyInfo.isPreloadWhenClosed = ((HippyUpdateManager.HippyConfig)localObject).isPreloadHippy();
      localOpenHippyInfo.isPredrawWhenClosed = ((HippyUpdateManager.HippyConfig)localObject).isPredrawHippy();
      HippyAccessHelper.openHippyPage(paramContext, localOpenHippyInfo);
      return;
    }
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    SharedPreferences localSharedPreferences = paramAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramAppInterface = "msgPos_web" + paramAppInterface.getCurrentAccountUin();
    localSharedPreferences.edit().putString(paramAppInterface, paramString).apply();
  }
  
  public static void a(GmpEnterInfoRsp paramGmpEnterInfoRsp)
  {
    Object localObject = BaseApplicationImpl.getApplication();
    SharedPreferences localSharedPreferences = ((BaseApplicationImpl)localObject).getSharedPreferences("game_center_sp", 0);
    String str = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_jumpUrl";
    localObject = ((BaseApplicationImpl)localObject).getRuntime().getAccount() + "sp_key_game_center_enter_status" + "_bubbleId";
    localSharedPreferences.edit().putString(str, paramGmpEnterInfoRsp.url).apply();
    localSharedPreferences.edit().putString((String)localObject, paramGmpEnterInfoRsp.bubble_id).apply();
  }
  
  public static void a(QQGameHelper.OnPreloadFeedsListener paramOnPreloadFeedsListener)
  {
    jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramOnPreloadFeedsListener);
  }
  
  public static void a(NavBarQQGamePub paramNavBarQQGamePub, GmpEnterInfoRsp paramGmpEnterInfoRsp)
  {
    if ((!TextUtils.isEmpty(paramGmpEnterInfoRsp.url)) && (!TextUtils.isEmpty(paramGmpEnterInfoRsp.bubble_id))) {
      if (paramNavBarQQGamePub != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "show game enter cache icon");
        }
        paramNavBarQQGamePub.setCurType(3);
        paramNavBarQQGamePub.a(paramGmpEnterInfoRsp.url);
        paramNavBarQQGamePub.setmBubbleid(paramGmpEnterInfoRsp.bubble_id);
        paramNavBarQQGamePub.a(true);
      }
    }
    while (paramNavBarQQGamePub == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 1, "show game enter");
    }
    paramNavBarQQGamePub.setCurType(1);
    paramNavBarQQGamePub.a(false);
    paramNavBarQQGamePub.setmBubbleid("");
  }
  
  public static void a(String paramString)
  {
    try
    {
      if (jdField_b_of_type_JavaUtilMap.containsKey(paramString))
      {
        List localList = (List)jdField_b_of_type_JavaUtilMap.get(paramString);
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append("url=").append(paramString).append("|apiSendEnd:").append(localList.get(0)).append("|sendPack:").append(localList.get(1)).append("|resPack:").append(localList.get(2)).append("|apiPackStart:").append(localList.get(3)).append("|costTime=" + (((Long)localList.get(3)).longValue() - ((Long)localList.get(0)).longValue()));
        QLog.d("QQGameHelper", 1, localStringBuffer.toString());
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    try
    {
      if ((paramString.startsWith(jdField_a_of_type_JavaLangString)) || (paramString.startsWith(jdField_b_of_type_JavaLangString)) || (paramString.startsWith(jdField_c_of_type_JavaLangString)))
      {
        if (jdField_b_of_type_JavaUtilMap.containsKey(paramString))
        {
          ((List)jdField_b_of_type_JavaUtilMap.get(paramString)).add(Long.valueOf(paramLong));
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(paramLong));
        jdField_b_of_type_JavaUtilMap.put(paramString, localArrayList);
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
    }
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    ((GamePubAccountMsgManager)localAppRuntime.getManager(QQManagerFactory.GAME_PUB_ACCOUNT_MSG_MANAGER)).a(paramList);
  }
  
  public static boolean a(IHeaderView paramIHeaderView)
  {
    return ((paramIHeaderView instanceof GameArkView)) && (a(paramIHeaderView.a()));
  }
  
  public static boolean a(String paramString)
  {
    return "com.tencent.gamecenter.newvideo".equals(paramString);
  }
  
  public static long b()
  {
    return jdField_c_of_type_Long;
  }
  
  private static long b(String paramString)
  {
    int j = 5381;
    int i = 0;
    while (i < paramString.length())
    {
      j += (j << 5) + Character.codePointAt(paramString, i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static WadlReportBuilder b(String paramString)
  {
    WadlReportBuilder localWadlReportBuilder = new WadlReportBuilder();
    localWadlReportBuilder.a("dc00087").a(24, paramString);
    return localWadlReportBuilder;
  }
  
  public static String b()
  {
    return d;
  }
  
  private static String b(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("code", paramInt);
      localJSONObject.put("message", paramString);
      return localJSONObject.toString();
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("feedsPreload_QQGameHelper", 1, paramString, new Object[0]);
      }
    }
  }
  
  public static JSONArray b(List<QQGameMsgInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    if ((paramList != null) && (paramList.size() > 0)) {}
    for (;;)
    {
      QQGameMsgInfo localQQGameMsgInfo;
      JSONObject localJSONObject;
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          localQQGameMsgInfo = (QQGameMsgInfo)paramList.next();
          localJSONObject = new JSONObject();
          localJSONObject.put("msgID", localQQGameMsgInfo.paMsgid);
          localJSONObject.put("appID", localQQGameMsgInfo.gameAppId);
          localJSONObject.put("msgType", localQQGameMsgInfo.msgType);
          if (localQQGameMsgInfo.msgType == 1)
          {
            localJSONObject.put("arkData", a(localQQGameMsgInfo));
            localJSONObject.put("msgTime", localQQGameMsgInfo.msgTime);
            if (!TextUtils.isEmpty(localQQGameMsgInfo.sortedConfigs)) {
              localJSONObject.put("sorted_configs", localQQGameMsgInfo.sortedConfigs);
            }
            if (!TextUtils.isEmpty(localQQGameMsgInfo.extJson)) {
              localJSONObject.put("extJson", localQQGameMsgInfo.extJson);
            }
            localJSONObject.put("desc", localQQGameMsgInfo.desc);
            localJSONObject.put("icon", localQQGameMsgInfo.icon);
            localJSONObject.put("frienduin", localQQGameMsgInfo.frienduin);
            localJSONObject.put("uniseq", localQQGameMsgInfo.uniseq);
            localJSONObject.put("advId", localQQGameMsgInfo.advId);
            localJSONObject.put("triggerInfo", localQQGameMsgInfo.triggerInfo);
            localJSONArray.put(localJSONObject);
          }
        }
        else
        {
          return localJSONArray;
        }
      }
      catch (Throwable paramList)
      {
        paramList.printStackTrace();
      }
      if (localQQGameMsgInfo.msgType == 2) {
        localJSONObject.put("structData", b(localQQGameMsgInfo));
      } else if (localQQGameMsgInfo.msgType == 3) {
        localJSONObject.put("structData", b(localQQGameMsgInfo));
      }
    }
  }
  
  public static JSONObject b(QQGameMsgInfo paramQQGameMsgInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("coverUrl", paramQQGameMsgInfo.coverUrl);
      localJSONObject.put("url", paramQQGameMsgInfo.url);
      localJSONObject.put("title", paramQQGameMsgInfo.title);
      localJSONObject.put("dateTitle", paramQQGameMsgInfo.dateTitle);
      localJSONObject.put("contentText", paramQQGameMsgInfo.contentText);
      localJSONObject.put("limitText", paramQQGameMsgInfo.limitText);
      localJSONObject.put("actionUrl", paramQQGameMsgInfo.actionUrl);
      return localJSONObject;
    }
    catch (JSONException paramQQGameMsgInfo)
    {
      paramQQGameMsgInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QQGameHelper", 1, "===preloadSw===");
    }
    SwiftBrowserIdleTaskHelper.a().a(new QQGameHelper.1(4096));
  }
  
  public static void b(long paramLong)
  {
    jdField_c_of_type_Long = paramLong;
  }
  
  public static void b(Activity paramActivity)
  {
    if ((paramActivity != null) && (!paramActivity.isFinishing())) {
      QLog.d("QQGameHelper", 1, "--->enter GamePubAccount by AIO");
    }
    try
    {
      Intent localIntent = new Intent();
      localIntent.setClassName(paramActivity, SplashActivity.class.getName());
      localIntent = AIOUtils.a(localIntent, new int[] { 1 });
      localIntent.putExtra("shouldreport", true);
      localIntent.putExtra("has_unread_msg", false);
      localIntent.putExtra("jump_from", 1);
      localIntent.setClass(paramActivity, ChatActivity.class);
      localIntent.putExtra("uin", "2747277822");
      localIntent.putExtra("uintype", 1008);
      localIntent.putExtra("uinname", paramActivity.getString(2131695230));
      localIntent.putExtra("entrance", 1);
      localIntent.putExtra("aio_msg_source", 0);
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
  
  private static void b(Bundle paramBundle1, Bundle paramBundle2, String paramString, JSONArray paramJSONArray)
  {
    ThreadManagerV2.excute(new QQGameHelper.6(paramBundle1, paramString, paramBundle2, paramJSONArray), 128, null, true);
  }
  
  public static void b(String paramString)
  {
    if (a("QQGameCenter") == 0) {
      a(BaseApplication.getContext(), paramString, "publicplat");
    }
    while (!URLUtil.isValidUrl(paramString)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder().append(paramString);
    if (paramString.contains("?")) {}
    for (paramString = "&";; paramString = "?")
    {
      paramString = paramString + "forceHtml=true";
      a(BaseApplication.getContext(), paramString);
      return;
    }
  }
  
  public static void b(String paramString, long paramLong)
  {
    try
    {
      if ((paramString.startsWith(jdField_a_of_type_JavaLangString)) || (paramString.startsWith(jdField_b_of_type_JavaLangString)) || (paramString.startsWith(jdField_c_of_type_JavaLangString)))
      {
        if (jdField_b_of_type_JavaUtilMap.containsKey(paramString)) {
          jdField_b_of_type_JavaUtilMap.remove(paramString);
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Long.valueOf(paramLong));
        jdField_b_of_type_JavaUtilMap.put(paramString, localArrayList);
      }
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static boolean b()
  {
    if (!QQGameConfigUtil.e()) {
      QLog.i("QQGameHelper", 2, "===can't preLoad because config switch is not open===");
    }
    while (QQGameConfigUtil.a() <= 0) {
      return false;
    }
    long l = a();
    if (NetConnInfoCenter.getServerTimeMillis() - l < QQGameConfigUtil.a() * 24 * 60 * 60 * 1000)
    {
      QLog.i("QQGameHelper", 2, "===can't preLoad because time is not in===" + BaseApplicationImpl.processName);
      return false;
    }
    return true;
  }
  
  public static long c()
  {
    return jdField_a_of_type_Long;
  }
  
  public static String c()
  {
    return e;
  }
  
  public static void c()
  {
    ThreadManagerV2.executeOnSubThread(new QQGameHelper.2());
  }
  
  public static void c(String paramString)
  {
    d = paramString;
  }
  
  public static long d()
  {
    return jdField_b_of_type_Long;
  }
  
  public static void d()
  {
    for (;;)
    {
      try
      {
        QLog.i("QQGameHelper", 2, "<<<<<<<<<<<<<<preloadNewQQGamePaHippy<<<<<<<<<<<<<<<<");
        if (QLog.isColorLevel()) {
          QLog.d("QQGameHelper", 1, "isGetHippysManagerConfig=" + jdField_a_of_type_Boolean + " isReadyToPreloadHippy=" + jdField_b_of_type_Boolean + " isPreloadHippy=" + jdField_c_of_type_Boolean);
        }
        if (jdField_a_of_type_Boolean)
        {
          boolean bool = jdField_b_of_type_Boolean;
          if (bool) {}
        }
        else
        {
          return;
        }
        if (QQGameConfigUtil.b() == 0)
        {
          QLog.i("QQGameHelper", 2, "can not preload hippy engine because hippy switch is close");
          continue;
        }
        if (QQGameConfigUtil.e()) {
          break label130;
        }
      }
      finally {}
      QLog.i("QQGameHelper", 2, "can not preload hippy engine because preload switch is close");
      continue;
      label130:
      if (!jdField_c_of_type_Boolean)
      {
        jdField_c_of_type_Boolean = true;
        ThreadManagerV2.excute(new QQGameHelper.3(), 64, null, true);
      }
    }
  }
  
  public static void d(String paramString)
  {
    e = paramString;
  }
  
  private static String e()
  {
    Object localObject = MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (localObject == null) {
      localObject = "0";
    }
    String str;
    do
    {
      return localObject;
      str = ((AppRuntime)localObject).getAccount();
      localObject = str;
    } while (str != null);
    return "0";
  }
  
  public static void e()
  {
    boolean bool = QQGameConfigUtil.g();
    if (QLog.isColorLevel()) {
      QLog.d("QQGameHelper", 2, "preloadQQGameCenterByHippy isHippySwitchOpened:" + bool);
    }
    if (!bool) {
      return;
    }
    HippyUpdateManager.getInstance().updateJsBundle("QQGameCenter", QQGameConfigUtil.i(), 3, new QQGameHelper.4());
  }
  
  public static void e(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(25), paramString);
    localHashMap.put(Integer.valueOf(26), Math.max(d() - c(), 0L) + "");
    localHashMap.put(Integer.valueOf(27), Math.max(b() - c(), 0L) + "");
    localHashMap.put(Integer.valueOf(28), Math.max(System.currentTimeMillis() - c(), 0L) + "");
    try
    {
      paramString = new JSONObject(e);
      localHashMap.put(Integer.valueOf(29), paramString.optString("code"));
      localHashMap.put(Integer.valueOf(30), paramString.optString("message"));
      GameCenterUtils.a(CmGameUtil.a(), "760", "208137", "", "104705", "1", "160", localHashMap);
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.e("QQGameHelper", 1, paramString, new Object[0]);
      }
    }
  }
  
  public static void f()
  {
    jdField_a_of_type_Long = System.currentTimeMillis();
    ThreadManagerV2.excute(new QQGameHelper.5(), 32, null, true);
  }
  
  public static void g()
  {
    e = null;
    jdField_a_of_type_Long = 0L;
    jdField_b_of_type_Long = 0L;
    jdField_c_of_type_Long = 0L;
    jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  private static void i()
  {
    HippyUpdateManager.HippyConfig localHippyConfig = HippyUpdateManager.getInstance().getHippyConfig();
    if ((QQGameConfigUtil.g()) && ((localHippyConfig.isPreloadHippy()) || (localHippyConfig.isPredrawHippy()))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQGameHelper", 2, "onGameCenterUpdateFinished isCanPreload:" + bool);
      }
      if (bool) {
        break;
      }
      return;
    }
    HippyAccessHelper.OpenHippyInfo localOpenHippyInfo = new HippyAccessHelper.OpenHippyInfo();
    localOpenHippyInfo.bundleName = "QQGameCenter";
    localOpenHippyInfo.isPreload = localHippyConfig.isPreloadHippy();
    localOpenHippyInfo.isPredraw = localHippyConfig.isPredrawHippy();
    localOpenHippyInfo.isInToolProcess = localHippyConfig.isLoadHippyInToolProcess();
    HippyAccessHelper.checkAndPreloadHippyPage(localOpenHippyInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameHelper
 * JD-Core Version:    0.7.0.1
 */