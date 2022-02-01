package com.tencent.mobileqq.mini.entry;

import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_MISC.MISC.StAppPlayingInfo;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE.StCacheController;
import NS_MINI_INTERFACE.INTERFACE.StGetDropdownAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import apys;
import apyt;
import atup;
import bfol;
import bgyp;
import bgyq;
import blbw;
import blbx;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.NetworkTimeoutInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BaseJsPluginEngine;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.network.http.MiniappHttpUtil;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import nko;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppUtils
{
  private static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
  private static final String CONTENT_TYPE_JSON = "application/json";
  public static final String GDT_COOKIE = "gdt_cookie";
  public static final String KEY_MINI_APP_CONFIG = "key_record_mini_app_config";
  public static final String MINI_APP_DESKTOP_GDT_COOKIE_PRE = "mini_app_desktop_gdt_cookie";
  private static final String MINI_APP_STORE_URL = "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b";
  private static final Set<Integer> PULL_DOWN_REFER = new HashSet();
  public static final int RESULT_WNS_REQUEST_FAIL = 20001;
  private static final String TAG = "MiniAppUtils";
  public static final String TIAN_SHU_APPID = "tianshu.78";
  public static final String TIAN_SHU_PAGE_ID = "tianshu.78";
  public static final int TYPE_ATTACHED_TO_WINDOW = 3;
  public static final int TYPE_DB_INIT_COMPLETE = 8;
  public static final int TYPE_DELETED = 4;
  public static final int TYPE_DESKTOP_SETTINGS_SWITCH_CHANGE = 102;
  public static final int TYPE_ENTER_BACKGROUND = 7;
  public static final int TYPE_ENTER_FOREGROUND = 6;
  public static final int TYPE_HIDE_PULL_DOWN_ENTRY = 100;
  public static final int TYPE_HONGBAO_UPDATE_DESKTOP_RES = 103;
  public static final int TYPE_MINI_APP_CLICK_UPDATE_FAILED = 11;
  public static final int TYPE_MINI_APP_SERVER_REQUEST_FAILED = 10;
  public static final int TYPE_MINI_APP_START_ANIMATION = 12;
  public static final int TYPE_MINI_APP_STOP_ANIMATION = 13;
  public static final int TYPE_MSF_REQUEST_FAILED = 2;
  public static final int TYPE_QUERY_DB_COMPLETE = 9;
  public static final int TYPE_RED_DOT = 101;
  public static final int TYPE_REQUEST_SUCCESS = 1;
  public static final int TYPE_SET_TOP = 5;
  private static final int USE_APPID_LAUNCHER_MINI_APP_DEFAULT = 0;
  
  static
  {
    PULL_DOWN_REFER.add(Integer.valueOf(3001));
    PULL_DOWN_REFER.add(Integer.valueOf(3020));
    PULL_DOWN_REFER.add(Integer.valueOf(3002));
    PULL_DOWN_REFER.add(Integer.valueOf(3003));
    PULL_DOWN_REFER.add(Integer.valueOf(3021));
    PULL_DOWN_REFER.add(Integer.valueOf(3004));
    PULL_DOWN_REFER.add(Integer.valueOf(3005));
    PULL_DOWN_REFER.add(Integer.valueOf(3006));
    PULL_DOWN_REFER.add(Integer.valueOf(3007));
    PULL_DOWN_REFER.add(Integer.valueOf(3008));
    PULL_DOWN_REFER.add(Integer.valueOf(3009));
    PULL_DOWN_REFER.add(Integer.valueOf(3010));
    PULL_DOWN_REFER.add(Integer.valueOf(3011));
    PULL_DOWN_REFER.add(Integer.valueOf(3012));
    PULL_DOWN_REFER.add(Integer.valueOf(3013));
    PULL_DOWN_REFER.add(Integer.valueOf(3016));
    PULL_DOWN_REFER.add(Integer.valueOf(1001));
    PULL_DOWN_REFER.add(Integer.valueOf(1022));
  }
  
  private static void appendCookieStr(StringBuilder paramStringBuilder, String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      insertSemicolon(paramStringBuilder);
      paramStringBuilder.append(paramString2).append(paramString1);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("MiniAppUtils", 2, paramString2 + "is empty");
      }
    } while (TextUtils.isEmpty(paramString3));
    insertSemicolon(paramStringBuilder);
    paramStringBuilder.append(paramString2).append(paramString3);
  }
  
  public static void checkMiniAppDesktopSendRequest()
  {
    Object localObject = getAppInterface();
    if (localObject == null) {
      QLog.e("MiniAppUtils", 1, "checkMiniAppDesktopSendRequest, app is null.");
    }
    long l1;
    long l2;
    do
    {
      return;
      l1 = ((AppInterface)localObject).getPreferences().getLong("key_mini_app_refresh_interval", 0L);
      l2 = System.currentTimeMillis();
      localObject = (DesktopDataManager)((AppInterface)localObject).getManager(336);
    } while (l2 - l1 <= 1000L * ((DesktopDataManager)localObject).getRefreshInterval());
    ((DesktopDataManager)localObject).sendDropDownAppListRequestAsync();
  }
  
  public static boolean checkNavigationAppIdListForMiniGame(String paramString, MiniGamePkg paramMiniGamePkg)
  {
    if ((StringUtil.isEmpty(paramString)) || (paramMiniGamePkg == null)) {}
    for (;;)
    {
      return false;
      try
      {
        paramMiniGamePkg = paramMiniGamePkg.mGameConfigJson.optJSONArray("navigateToMiniProgramAppIdList");
        int i = 0;
        while ((paramMiniGamePkg != null) && (i < paramString.length()))
        {
          boolean bool = paramString.equals(paramMiniGamePkg.getString(i));
          if (bool) {
            return true;
          }
          i += 1;
        }
        return false;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static void checkSendUserAppListRequest()
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface == null) {
      QLog.e("MiniAppUtils", 1, "checkSendUserAppListRequest, app is null.");
    }
    SharedPreferences localSharedPreferences;
    long l1;
    long l2;
    int i;
    do
    {
      return;
      localSharedPreferences = localAppInterface.getPreferences();
      l1 = localSharedPreferences.getLong("key_update_miniapp_time", 0L);
      l2 = System.currentTimeMillis();
      i = 60;
      apys localapys = apyt.a();
      if (localapys != null) {
        i = localapys.a();
      }
    } while (l2 - l1 <= i * 60 * 1000);
    ((MiniAppUserAppInfoListManager)localAppInterface.getManager(309)).sendUserAppListRequest(Long.valueOf(localAppInterface.getCurrentAccountUin()).longValue(), 20L);
    localSharedPreferences.edit().putLong("key_update_miniapp_time", l2).apply();
  }
  
  /* Error */
  public static MiniAppInfo createFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 294	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_1
    //   4: aload_1
    //   5: astore_2
    //   6: aload_1
    //   7: aload_0
    //   8: iconst_0
    //   9: aload_0
    //   10: arraylength
    //   11: invokevirtual 298	android/os/Parcel:unmarshall	([BII)V
    //   14: aload_1
    //   15: astore_2
    //   16: aload_1
    //   17: iconst_0
    //   18: invokevirtual 302	android/os/Parcel:setDataPosition	(I)V
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: ldc_w 304
    //   27: invokevirtual 310	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   30: invokevirtual 314	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   33: checkcast 304	com/tencent/mobileqq/mini/apkg/MiniAppInfo
    //   36: astore_0
    //   37: aload_1
    //   38: ifnull +7 -> 45
    //   41: aload_1
    //   42: invokevirtual 317	android/os/Parcel:recycle	()V
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: aconst_null
    //   49: astore_0
    //   50: ldc 32
    //   52: iconst_1
    //   53: ldc_w 319
    //   56: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: ifnull +7 -> 67
    //   63: aload_0
    //   64: invokevirtual 317	android/os/Parcel:recycle	()V
    //   67: aconst_null
    //   68: areturn
    //   69: astore_0
    //   70: aconst_null
    //   71: astore_1
    //   72: aload_1
    //   73: astore_2
    //   74: ldc 32
    //   76: iconst_1
    //   77: new 129	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 321
    //   87: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: invokestatic 327	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   94: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: aload_1
    //   104: ifnull -37 -> 67
    //   107: aload_1
    //   108: invokevirtual 317	android/os/Parcel:recycle	()V
    //   111: goto -44 -> 67
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_2
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 317	android/os/Parcel:recycle	()V
    //   125: aload_0
    //   126: athrow
    //   127: astore_0
    //   128: goto -11 -> 117
    //   131: astore_1
    //   132: aload_0
    //   133: astore_2
    //   134: aload_1
    //   135: astore_0
    //   136: goto -19 -> 117
    //   139: astore_0
    //   140: goto -68 -> 72
    //   143: astore_0
    //   144: aload_1
    //   145: astore_0
    //   146: goto -96 -> 50
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	paramArrayOfByte	byte[]
    //   3	105	1	localParcel	android.os.Parcel
    //   131	14	1	localObject1	Object
    //   5	129	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	47	java/lang/OutOfMemoryError
    //   0	4	69	java/lang/Throwable
    //   0	4	114	finally
    //   6	14	127	finally
    //   16	21	127	finally
    //   23	37	127	finally
    //   74	103	127	finally
    //   50	59	131	finally
    //   6	14	139	java/lang/Throwable
    //   16	21	139	java/lang/Throwable
    //   23	37	139	java/lang/Throwable
    //   6	14	143	java/lang/OutOfMemoryError
    //   16	21	143	java/lang/OutOfMemoryError
    //   23	37	143	java/lang/OutOfMemoryError
  }
  
  private static void doWnsCgiRequest(String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    if (paramBaseJsPluginEngine == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString1))
    {
      paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, paramInt);
      return;
    }
    int j;
    int i;
    label353:
    label892:
    for (;;)
    {
      Object localObject2;
      TicketManager localTicketManager;
      Object localObject1;
      boolean bool;
      try
      {
        localObject2 = new JSONObject(paramString1);
        localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
        paramString1 = ((JSONObject)localObject2).optJSONObject("header");
        if (paramString1 != null) {
          break label917;
        }
        paramString1 = new JSONObject();
        paramString1.put("Referer", MiniappHttpUtil.getRequestReferer(paramBaseJsPluginEngine));
        j = 60000;
        localObject1 = paramBaseJsPluginEngine.appBrandRuntime.getApkgInfo();
        i = j;
        if (localObject1 != null)
        {
          i = j;
          if (((ApkgInfo)localObject1).mAppConfigInfo != null)
          {
            i = j;
            if (((ApkgInfo)localObject1).mAppConfigInfo.networkTimeoutInfo != null) {
              i = ((ApkgInfo)localObject1).mAppConfigInfo.networkTimeoutInfo.request;
            }
          }
        }
        localObject1 = new bgyq();
        ((bgyq)localObject1).jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).optString("url");
        ((bgyq)localObject1).c = paramString1.toString();
        ((bgyq)localObject1).jdField_a_of_type_Int = i;
        ((bgyq)localObject1).jdField_e_of_type_JavaLangString = "application/x-www-form-urlencoded";
        ((bgyq)localObject1).b = ((JSONObject)localObject2).optString("method", "GET");
        ((bgyq)localObject1).jdField_a_of_type_Boolean = ((JSONObject)localObject2).optString("responseType").equals("base64");
        ((bgyq)localObject1).d = null;
        bool = ((JSONObject)localObject2).optString("dataType").equalsIgnoreCase("json");
        if (TextUtils.isEmpty(((bgyq)localObject1).jdField_a_of_type_JavaLangString))
        {
          paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, "empty url", paramInt);
          return;
        }
      }
      catch (JSONException paramString1)
      {
        QLog.e("MiniAppUtils", 1, "performWnsCgiRequest ", paramString1);
        paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, paramInt);
        return;
      }
      if (((JSONObject)localObject2).has("data"))
      {
        paramString1 = ((JSONObject)localObject2).get("data");
        if (!(paramString1 instanceof String)) {
          break label353;
        }
      }
      for (((bgyq)localObject1).d = ((String)paramString1); TextUtils.isEmpty(((bgyq)localObject1).b); ((bgyq)localObject1).d = paramString1.toString())
      {
        paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, "wrong method", paramInt);
        return;
      }
      if (("get".equalsIgnoreCase(((bgyq)localObject1).b)) || ("post".equalsIgnoreCase(((bgyq)localObject1).b)))
      {
        ((bgyq)localObject1).b = ((bgyq)localObject1).b.toUpperCase();
        if ("post".equalsIgnoreCase(((bgyq)localObject1).b)) {
          ((bgyq)localObject1).jdField_e_of_type_JavaLangString = "application/json";
        }
        i = -1;
      }
      try
      {
        paramString1 = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        localObject2 = localTicketManager.getPskey(paramString1, nko.a().d(SwiftBrowserCookieMonster.b(((bgyq)localObject1).jdField_a_of_type_JavaLangString)));
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          i = getGTK((String)localObject2);
        }
        j = i;
        if (i == -1)
        {
          localObject2 = SwiftBrowserCookieMonster.c(((bgyq)localObject1).jdField_a_of_type_JavaLangString);
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            j = i;
            if (((String)localObject2).contains("p_skey"))
            {
              localObject2 = ((String)localObject2).split(";");
              int m = localObject2.length;
              int k = 0;
              for (;;)
              {
                j = i;
                if (k >= m) {
                  break;
                }
                Object localObject3 = localObject2[k];
                j = i;
                if (!TextUtils.isEmpty((CharSequence)localObject3))
                {
                  j = i;
                  if (((String)localObject3).contains("p_skey"))
                  {
                    localObject3 = ((String)localObject3).substring(((String)localObject3).indexOf("=") + 1, ((String)localObject3).length());
                    j = i;
                    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
                      j = getGTK((String)localObject3);
                    }
                  }
                }
                k += 1;
                i = j;
              }
              paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, "wrong method", paramInt);
              return;
            }
          }
        }
        if (j != -1) {
          break label910;
        }
        i = getGTK(localTicketManager.getSkey(paramString1));
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          QLog.e("MiniAppUtils", 1, "get gtk fail.", paramString1);
          continue;
          QLog.d("MiniAppUtils", 2, "performWnsCgiRequest  fail");
          paramString1 = new JSONObject();
          try
          {
            paramString1.put("wnsCode", 20001);
            paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, paramString1, "perform wnsRequest failed!", paramInt);
            return;
          }
          catch (Exception localException)
          {
            break label892;
          }
          i = j;
        }
      }
      if (i != -1) {
        if (!((bgyq)localObject1).jdField_a_of_type_JavaLangString.contains("?")) {
          break label813;
        }
      }
      for (((bgyq)localObject1).jdField_a_of_type_JavaLangString = (((bgyq)localObject1).jdField_a_of_type_JavaLangString + "&g_tk=" + i);; ((bgyq)localObject1).jdField_a_of_type_JavaLangString = (((bgyq)localObject1).jdField_a_of_type_JavaLangString + "?g_tk=" + i))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MiniAppUtils", 2, "url : " + ((bgyq)localObject1).jdField_a_of_type_JavaLangString);
        }
        paramString1 = new MiniAppUtils.8(ThreadManagerV2.getSubThreadLooper(), bool, paramBaseJsPluginEngine, paramJsRuntime, paramString2, paramInt);
        if (!bgyp.a().a((bgyq)localObject1, paramString1, getCookie(((bgyq)localObject1).jdField_a_of_type_JavaLangString))) {
          break;
        }
        QLog.d("MiniAppUtils", 2, "performWnsCgiRequest  success");
        return;
      }
    }
  }
  
  private static void fetchWnsCgiCacheData(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((!URLUtil.isHttpsUrl(paramString3)) && (!URLUtil.isHttpUrl(paramString3)))
    {
      QLog.e("MiniAppUtils", 2, new Object[] { "fetchWnsCgiCacheData ", " invalid url " + paramString3 });
      return;
    }
    bgyq localbgyq = new bgyq();
    localbgyq.jdField_a_of_type_JavaLangString = paramString3;
    localbgyq.b = "GET";
    localbgyq.jdField_a_of_type_Boolean = false;
    localbgyq.jdField_a_of_type_Int = 0;
    localbgyq.jdField_e_of_type_JavaLangString = "application/x-www-form-urlencoded";
    bgyp.a().a(localbgyq, new MiniAppUtils.5(ThreadManager.getSubThreadLooper(), paramContext, paramString1, paramString2));
  }
  
  public static void fetchWnsCgiPreCacheData(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    QLog.d("MiniAppUtils", 1, "--- prefetch cache data appid:" + paramString1 + "  requestUrl" + paramString2 + "  path:" + paramString3);
    paramContext = new bgyq();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = "GET";
    paramContext.jdField_a_of_type_Boolean = false;
    paramContext.jdField_a_of_type_Int = 0;
    paramContext.jdField_e_of_type_JavaLangString = "application/x-www-form-urlencoded";
    bgyp.a().a(paramContext, new MiniAppUtils.4(ThreadManager.getSubThreadLooper(), paramString3, paramString2));
  }
  
  public static AppInterface getAppInterface()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    if (localObject != null)
    {
      localObject = ((BaseApplicationImpl)localObject).getRuntime();
      if ((localObject instanceof QQAppInterface)) {
        return (QQAppInterface)localObject;
      }
    }
    return null;
  }
  
  public static String getCookie(String paramString)
  {
    paramString = SwiftBrowserCookieMonster.c(paramString);
    String str1 = SwiftBrowserCookieMonster.a(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    Object localObject2 = ".*p_uin=" + str1 + ";.*";
    Object localObject1 = paramString;
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localObject1 = paramString;
        if (!paramString.contains(";")) {
          continue;
        }
        localObject1 = paramString;
        if (!paramString.contains("uin=")) {
          continue;
        }
        localObject1 = paramString;
        if (!paramString.contains("p_uin")) {
          continue;
        }
        localObject1 = paramString;
        if (paramString.matches((String)localObject2)) {
          continue;
        }
        localObject1 = paramString.replaceAll(" ", "");
      }
      catch (Throwable localThrowable1)
      {
        int j;
        int i;
        String str2;
        String str3;
        continue;
        i += 1;
        continue;
      }
      try
      {
        paramString = new StringBuilder();
        localObject2 = ((String)localObject1).split(";");
        j = localObject2.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        str2 = localObject2[i];
        if (str2.startsWith("uin="))
        {
          str3 = str2.substring("uin=".length());
          if ((TextUtils.isEmpty(str3)) || (!str3.equals(str1))) {
            appendCookieStr(paramString, str1, "uin=", str2);
          }
        }
        else if (str2.startsWith("p_uin="))
        {
          str3 = str2.substring("p_uin=".length());
          if ((!TextUtils.isEmpty(str3)) && (str3.equals(str1))) {
            continue;
          }
          appendCookieStr(paramString, str1, "p_uin=", str2);
        }
      }
      catch (Throwable localThrowable2)
      {
        paramString = (String)localObject1;
        localObject1 = localThrowable2;
      }
    }
    QLog.e("MiniAppUtils", 1, "getCookie error.", (Throwable)localObject1);
    localObject1 = paramString;
    return localObject1;
    insertSemicolon(paramString);
    paramString.append(str2);
    break label307;
    paramString = paramString.toString();
    return paramString;
  }
  
  public static Drawable getDrawable(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions1 = null;
    try
    {
      paramURLDrawableOptions = URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
      localURLDrawableOptions2 = paramURLDrawableOptions;
      localURLDrawableOptions1 = paramURLDrawableOptions;
      if (paramURLDrawableOptions.getStatus() == 2)
      {
        localURLDrawableOptions1 = paramURLDrawableOptions;
        paramURLDrawableOptions.restartDownload();
        localURLDrawableOptions2 = paramURLDrawableOptions;
      }
    }
    catch (Exception paramURLDrawableOptions)
    {
      do
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions2 = localURLDrawableOptions1;
      } while (!QLog.isColorLevel());
      QLog.e("MiniAppUtils", 2, "getDrawable: " + paramString);
    }
    return localURLDrawableOptions2;
    return localURLDrawableOptions1;
  }
  
  public static int getGTK(String paramString)
  {
    int i = 5381;
    if (!TextUtils.isEmpty(paramString))
    {
      int k = paramString.length();
      int j = 5381;
      i = 0;
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
      i = 0x7FFFFFFF & j;
    }
    return i;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    int i = ViewUtils.dpToPx(48.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    if (paramBoolean)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130841172);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130841172);
    }
    label118:
    do
    {
      try
      {
        paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          paramContext.setTag(bfol.b(i, i, ViewUtils.dpToPx(9.0F)));
          paramContext.setDecodeHandler(bfol.j);
          localObject = paramContext;
          if (paramContext.getStatus() == 2)
          {
            paramContext.restartDownload();
            localObject = paramContext;
          }
          return localObject;
        }
        catch (Exception localException2)
        {
          Context localContext;
          break label118;
        }
        localException1 = localException1;
        paramContext = null;
      }
      localContext = paramContext;
    } while (!QLog.isColorLevel());
    QLog.e("MiniAppUtils", 2, "getIcon url: " + paramString);
    return paramContext;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    int i = ViewUtils.dpToPx(48.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
    if (paramBoolean)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130841172);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130841172);
    }
    label126:
    do
    {
      try
      {
        paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        float f = paramInt;
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          paramContext.setTag(bfol.b(i, i, ViewUtils.dpToPx(f)));
          paramContext.setDecodeHandler(bfol.j);
          localObject = paramContext;
          if (paramContext.getStatus() == 2)
          {
            paramContext.restartDownload();
            localObject = paramContext;
          }
          return localObject;
        }
        catch (Exception localException2)
        {
          Context localContext;
          break label126;
        }
        localException1 = localException1;
        paramContext = null;
      }
      localContext = paramContext;
    } while (!QLog.isColorLevel());
    QLog.e("MiniAppUtils", 2, "getIcon url: " + paramString);
    return paramContext;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    paramInt2 = ViewUtils.dpToPx(paramInt2);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt2;
    if (paramBoolean)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(paramInt1);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(paramInt1);
    }
    label104:
    do
    {
      try
      {
        paramContext = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        localException1.printStackTrace();
      }
      catch (Exception localException1)
      {
        try
        {
          paramContext.setTag(bfol.b(paramInt2, paramInt2, ViewUtils.dpToPx(9.0F)));
          paramContext.setDecodeHandler(bfol.j);
          localObject = paramContext;
          return localObject;
        }
        catch (Exception localException2)
        {
          Context localContext;
          break label104;
        }
        localException1 = localException1;
        paramContext = null;
      }
      localContext = paramContext;
    } while (!QLog.isColorLevel());
    QLog.e("MiniAppUtils", 2, "getIcon url: " + paramString);
    return paramContext;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    paramInt2 = ViewUtils.dpToPx(paramInt2);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = ViewUtils.dpToPx(paramInt3);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt2;
    if (paramBoolean)
    {
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(paramInt1);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(paramInt1);
    }
    paramContext = null;
    try
    {
      localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      do
      {
        localException.printStackTrace();
      } while (!QLog.isColorLevel());
      QLog.e("MiniAppUtils", 2, "getIcon url: " + paramString);
    }
    return paramContext;
    return null;
  }
  
  public static void getMiniAppStoreAppList(String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    if (paramBaseJsPluginEngine == null) {
      return;
    }
    if (TextUtils.isEmpty(""))
    {
      paramBaseJsPluginEngine.callbackJsEventFail(paramJsRuntime, paramString2, null, "no dataCacheKey at app.json", paramInt);
      return;
    }
    ThreadManager.getFileThreadHandler().post(new MiniAppUtils.2(paramBaseJsPluginEngine, paramJsRuntime, paramString2, paramInt));
  }
  
  public static Drawable getRecommendIconDrawable(Context paramContext, String paramString)
  {
    paramContext = URLDrawable.URLDrawableOptions.obtain();
    paramContext.mPlayGifImage = false;
    try
    {
      paramContext = URLDrawable.getDrawable(paramString, paramContext);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      QLog.e("MiniAppUtils", 1, "getRecommendIconDrawable, failed.");
    }
    return null;
  }
  
  public static String getSpDesktopGdtCookie()
  {
    String str = "mini_app_desktop_gdt_cookie_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    return StorageUtil.getPreference().getString(str, "");
  }
  
  public static void handleMiniAppMoreClick(Activity paramActivity)
  {
    try
    {
      i = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_open_store_use_appid", 0);
      if (i != 0)
      {
        MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b", 1001, null);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      do
      {
        for (;;)
        {
          QLog.e("MiniAppUtils", 1, "get config MINI_APP_OPEN_STORE_USE_APPID exception!", localThrowable);
          int i = 0;
        }
        localObject1 = getAppInterface();
      } while (localObject1 == null);
      localObject1 = (MiniAppUserAppInfoListManager)((AppInterface)localObject1).getManager(309);
      if (localObject1 == null) {}
    }
    Object localObject2;
    for (Object localObject1 = ((MiniAppUserAppInfoListManager)localObject1).findTopMiniApp("1108291530");; localObject2 = null)
    {
      if (localObject1 != null) {
        try
        {
          QLog.d("MiniAppUtils", 2, "handleMiniAppMoreClick, launch app store by appInfo");
          MiniAppController.launchMiniAppByAppInfo(paramActivity, (MiniAppInfo)localObject1, 1001);
          return;
        }
        catch (MiniAppException localMiniAppException)
        {
          QLog.e("MiniAppUtils", 1, "handleMiniAppMoreClick, launchMiniAppByAppInfo exception.");
          MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b", 1001, null);
          return;
        }
      }
      MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b", 1001, null);
      return;
    }
  }
  
  public static void handlePreloadAppData(Context paramContext, INTERFACE.StGetUserAppListRsp paramStGetUserAppListRsp)
  {
    if ((paramStGetUserAppListRsp != null) && (paramContext != null))
    {
      paramStGetUserAppListRsp = paramStGetUserAppListRsp.cacheLst.get().iterator();
      while (paramStGetUserAppListRsp.hasNext())
      {
        Object localObject = (INTERFACE.StCacheController)paramStGetUserAppListRsp.next();
        if ((((INTERFACE.StCacheController)localObject).appInfo != null) && (!TextUtils.isEmpty(((INTERFACE.StCacheController)localObject).appInfo.appId.get())) && (((INTERFACE.StCacheController)localObject).cachePkg.get() == 1)) {
          MiniAppController.preloadPackage(MiniAppInfo.from(((INTERFACE.StCacheController)localObject).appInfo));
        }
        if (((INTERFACE.StCacheController)localObject).appInfo != null)
        {
          localObject = MiniAppInfo.from(((INTERFACE.StCacheController)localObject).appInfo);
          if (localObject != null) {
            preFetchAppCacheData(paramContext, (MiniAppInfo)localObject);
          }
        }
      }
    }
  }
  
  public static void handlePreloadAppDataV2(Context paramContext, INTERFACE.StGetDropdownAppListRsp paramStGetDropdownAppListRsp)
  {
    if ((paramStGetDropdownAppListRsp != null) && (paramContext != null))
    {
      paramStGetDropdownAppListRsp = paramStGetDropdownAppListRsp.cacheLst.get().iterator();
      while (paramStGetDropdownAppListRsp.hasNext())
      {
        Object localObject = (INTERFACE.StCacheController)paramStGetDropdownAppListRsp.next();
        if ((((INTERFACE.StCacheController)localObject).appInfo != null) && (!TextUtils.isEmpty(((INTERFACE.StCacheController)localObject).appInfo.appId.get())) && (((INTERFACE.StCacheController)localObject).cachePkg.get() == 1)) {
          MiniAppController.preloadPackage(MiniAppInfo.from(((INTERFACE.StCacheController)localObject).appInfo));
        }
        if (((INTERFACE.StCacheController)localObject).appInfo != null)
        {
          localObject = MiniAppInfo.from(((INTERFACE.StCacheController)localObject).appInfo);
          if (localObject != null)
          {
            preFetchAppCacheData(paramContext, (MiniAppInfo)localObject);
            if ("1108291530".equals(((MiniAppInfo)localObject).appId))
            {
              localObject = new MiniAppConfig((MiniAppInfo)localObject);
              AppBrandLaunchManager.g().preLaunchMiniApp(paramContext, (MiniAppConfig)localObject);
            }
          }
        }
      }
    }
  }
  
  public static void handlePullDownEntryListData(Bundle paramBundle, CmdCallback paramCmdCallback)
  {
    paramBundle.setClassLoader(MiniAppUtils.class.getClassLoader());
    paramBundle = (MiniAppConfig)paramBundle.getParcelable("key_record_mini_app_config");
    if ((paramBundle == null) || (paramBundle.config == null)) {
      QLog.e("MiniAppUtils", 1, "handlePullDownEntryListData, miniAppConfig is null");
    }
    do
    {
      return;
      updatePullDownEntryListData(paramBundle);
    } while (paramCmdCallback == null);
    try
    {
      paramCmdCallback.onCmdResult(true, new Bundle());
      return;
    }
    catch (RemoteException paramBundle)
    {
      QLog.e("MiniAppUtils", 1, "handlePullDownEntryListData, " + Log.getStackTraceString(paramBundle));
    }
  }
  
  private static void insertSemicolon(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (paramStringBuilder.length() > 0))
    {
      if (!paramStringBuilder.toString().endsWith(";")) {
        break label33;
      }
      paramStringBuilder.append(" ");
    }
    label33:
    while (paramStringBuilder.toString().endsWith("; ")) {
      return;
    }
    paramStringBuilder.append("; ");
  }
  
  public static boolean isDebugMiniApp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("keyMiniGamePayEnv", 4).getString("keyMiniGamePayEnvAppidVertype", "");
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(MD5Utils.encodeHexStr(paramString))))
        {
          localObject = paramString.split("_");
          if (localObject.length > 1)
          {
            int i = Integer.valueOf(localObject[1]).intValue();
            if (i != 3) {
              return true;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppUtils", 1, new Object[] { "isDebugMiniApp appidVerTypeStr", paramString, localThrowable });
      }
    }
    return false;
  }
  
  public static boolean isFromPullDownEntry(MiniAppConfig paramMiniAppConfig)
  {
    return (paramMiniAppConfig != null) && (paramMiniAppConfig.launchParam != null) && (PULL_DOWN_REFER.contains(Integer.valueOf(paramMiniAppConfig.launchParam.scene)));
  }
  
  public static boolean isNightMode()
  {
    return ("1103".equals(ThemeUtil.getCurrentThemeId())) || ("2920".equals(ThemeUtil.getCurrentThemeId()));
  }
  
  public static void miniAppTianShuReport(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    blbx localblbx = new blbx();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    String str = "";
    if (localAppRuntime != null) {
      str = localAppRuntime.getAccount();
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    localblbx.b = (str + "_" + l);
    localblbx.jdField_a_of_type_Int = 1;
    localblbx.jdField_e_of_type_JavaLangString = paramString1;
    localblbx.f = paramString2;
    localblbx.g = paramString3;
    localblbx.d = paramInt;
    localblbx.jdField_e_of_type_Int = 1;
    localblbx.jdField_a_of_type_Long = l;
    blbw.a().a(localblbx);
    if (QLog.isColorLevel()) {
      QLog.i("MiniAppUtils", 2, "tianShuReport, report itemId: " + paramString3);
    }
  }
  
  private static boolean needUpdateCache(String paramString, long paramLong)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      long l = System.currentTimeMillis();
      QLog.d("MiniAppUtils", 2, "needUpdateCache: precache : lastModified:" + localFile.lastModified() + "  curTime:" + l + "  expire:" + paramLong);
      if (localFile.lastModified() + 1000L * paramLong > l) {
        return false;
      }
    }
    else
    {
      QLog.d("MiniAppUtils", 2, "needUpdateCache precache:  file not exist:" + paramString);
    }
    return true;
  }
  
  public static void notifyUpdateHongBaoRes()
  {
    if (apyt.c())
    {
      BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, 103, true, null);
      return;
    }
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(QQMessagePageMiniAppEntryManager.class, 103, true, null);
  }
  
  public static void notityPullDownEntryInMainProcess(MiniAppConfig paramMiniAppConfig)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_record_mini_app_config", paramMiniAppConfig);
    AppBrandProxy.g().sendCmd("cmd_update_pull_down_entry_list", localBundle, new MiniAppUtils.9());
  }
  
  /* Error */
  public static byte[] packMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 294	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   5: astore_1
    //   6: aload_1
    //   7: astore_2
    //   8: aload_1
    //   9: iconst_0
    //   10: invokevirtual 302	android/os/Parcel:setDataPosition	(I)V
    //   13: aload_1
    //   14: astore_2
    //   15: aload_1
    //   16: aload_0
    //   17: iconst_0
    //   18: invokevirtual 1061	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: invokevirtual 1065	android/os/Parcel:marshall	()[B
    //   27: astore_0
    //   28: aload_0
    //   29: astore_2
    //   30: aload_2
    //   31: astore_0
    //   32: aload_1
    //   33: ifnull +9 -> 42
    //   36: aload_1
    //   37: invokevirtual 317	android/os/Parcel:recycle	()V
    //   40: aload_2
    //   41: astore_0
    //   42: aload_0
    //   43: areturn
    //   44: astore_0
    //   45: aconst_null
    //   46: astore_1
    //   47: aload_1
    //   48: astore_2
    //   49: ldc 32
    //   51: iconst_1
    //   52: new 129	java/lang/StringBuilder
    //   55: dup
    //   56: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   59: ldc_w 1067
    //   62: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_0
    //   66: invokestatic 327	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   69: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 160	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   78: aload_3
    //   79: astore_0
    //   80: aload_1
    //   81: ifnull -39 -> 42
    //   84: aload_1
    //   85: invokevirtual 317	android/os/Parcel:recycle	()V
    //   88: aconst_null
    //   89: areturn
    //   90: astore_0
    //   91: aconst_null
    //   92: astore_2
    //   93: aload_2
    //   94: ifnull +7 -> 101
    //   97: aload_2
    //   98: invokevirtual 317	android/os/Parcel:recycle	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore_0
    //   104: goto -11 -> 93
    //   107: astore_0
    //   108: goto -61 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	paramMiniAppInfo	MiniAppInfo
    //   5	80	1	localParcel	android.os.Parcel
    //   7	91	2	localObject1	Object
    //   1	78	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	44	java/lang/Throwable
    //   2	6	90	finally
    //   8	13	103	finally
    //   15	21	103	finally
    //   23	28	103	finally
    //   49	78	103	finally
    //   8	13	107	java/lang/Throwable
    //   15	21	107	java/lang/Throwable
    //   23	28	107	java/lang/Throwable
  }
  
  public static void performWnsCgiRequest(String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    ThreadPools.getNetworkIOThreadPool().execute(new MiniAppUtils.7(paramString1, paramJsRuntime, paramString2, paramInt, paramBaseJsPluginEngine));
  }
  
  public static boolean performWnsCgiRequest(JSONObject paramJSONObject, AsyncResult paramAsyncResult)
  {
    if (paramJSONObject == null)
    {
      paramAsyncResult.onReceiveResult(false, null);
      return false;
    }
    TicketManager localTicketManager;
    Object localObject1;
    bgyq localbgyq;
    boolean bool;
    try
    {
      localTicketManager = (TicketManager)BaseApplicationImpl.getApplication().getRuntime().getManager(2);
      localObject1 = paramJSONObject.optJSONObject("header");
      localbgyq = new bgyq();
      localbgyq.jdField_a_of_type_JavaLangString = paramJSONObject.optString("url");
      if (localObject1 == null) {}
      for (localObject1 = "{}";; localObject1 = ((JSONObject)localObject1).toString())
      {
        localbgyq.c = ((String)localObject1);
        localbgyq.jdField_a_of_type_Int = 60000;
        localbgyq.jdField_e_of_type_JavaLangString = "application/x-www-form-urlencoded";
        localbgyq.b = paramJSONObject.optString("method", "GET");
        localbgyq.jdField_a_of_type_Boolean = paramJSONObject.optString("responseType").equals("base64");
        localbgyq.d = null;
        bool = paramJSONObject.optString("dataType").equalsIgnoreCase("json");
        if (!TextUtils.isEmpty(localbgyq.jdField_a_of_type_JavaLangString)) {
          break;
        }
        paramAsyncResult.onReceiveResult(false, null);
        return false;
      }
      if (paramJSONObject.has("data"))
      {
        paramJSONObject = paramJSONObject.get("data");
        if (!(paramJSONObject instanceof String)) {
          break label231;
        }
        localbgyq.d = ((String)paramJSONObject);
      }
      while (TextUtils.isEmpty(localbgyq.b))
      {
        paramAsyncResult.onReceiveResult(false, null);
        return false;
        label231:
        localbgyq.d = paramJSONObject.toString();
        continue;
        return false;
      }
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("MiniAppUtils", 1, "performWnsCgiRequest ", paramJSONObject);
      paramAsyncResult.onReceiveResult(false, null);
    }
    for (;;)
    {
      int i;
      if (("get".equalsIgnoreCase(localbgyq.b)) || ("post".equalsIgnoreCase(localbgyq.b)))
      {
        localbgyq.b = localbgyq.b.toUpperCase();
        if ("post".equalsIgnoreCase(localbgyq.b)) {
          localbgyq.jdField_e_of_type_JavaLangString = "application/json";
        }
        i = -1;
      }
      try
      {
        paramJSONObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        localObject1 = localTicketManager.getPskey(paramJSONObject, nko.a().d(SwiftBrowserCookieMonster.b(localbgyq.jdField_a_of_type_JavaLangString)));
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          i = getGTK((String)localObject1);
        }
        j = i;
        if (i == -1)
        {
          localObject1 = SwiftBrowserCookieMonster.c(localbgyq.jdField_a_of_type_JavaLangString);
          j = i;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            j = i;
            if (((String)localObject1).contains("p_skey"))
            {
              localObject1 = ((String)localObject1).split(";");
              int m = localObject1.length;
              int k = 0;
              for (;;)
              {
                j = i;
                if (k >= m) {
                  break;
                }
                Object localObject2 = localObject1[k];
                j = i;
                if (!TextUtils.isEmpty((CharSequence)localObject2))
                {
                  j = i;
                  if (((String)localObject2).contains("p_skey"))
                  {
                    localObject2 = ((String)localObject2).substring(((String)localObject2).indexOf("=") + 1, ((String)localObject2).length());
                    j = i;
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      j = getGTK((String)localObject2);
                    }
                  }
                }
                k += 1;
                i = j;
              }
              paramAsyncResult.onReceiveResult(false, null);
              return false;
            }
          }
        }
        if (j == -1)
        {
          i = getGTK(localTicketManager.getSkey(paramJSONObject));
          if (i != -1) {
            if (!localbgyq.jdField_a_of_type_JavaLangString.contains("?")) {
              break label682;
            }
          }
          label682:
          for (localbgyq.jdField_a_of_type_JavaLangString = (localbgyq.jdField_a_of_type_JavaLangString + "&g_tk=" + i);; localbgyq.jdField_a_of_type_JavaLangString = (localbgyq.jdField_a_of_type_JavaLangString + "?g_tk=" + i))
          {
            if (QLog.isColorLevel()) {
              QLog.d("MiniAppUtils", 2, "url : " + localbgyq.jdField_a_of_type_JavaLangString);
            }
            paramJSONObject = new MiniAppUtils.6(ThreadManagerV2.getSubThreadLooper(), bool, paramAsyncResult);
            if (!bgyp.a().a(localbgyq, paramJSONObject, getCookie(localbgyq.jdField_a_of_type_JavaLangString))) {
              break;
            }
            QLog.d("MiniAppUtils", 2, "performWnsCgiRequest  success");
            return true;
          }
        }
      }
      catch (Throwable paramJSONObject)
      {
        for (;;)
        {
          int j;
          for (;;)
          {
            QLog.e("MiniAppUtils", 1, "get gtk fail.", paramJSONObject);
            continue;
            QLog.d("MiniAppUtils", 2, "performWnsCgiRequest  fail");
            paramJSONObject = new JSONObject();
            try
            {
              paramJSONObject.put("wnsCode", 20001);
              label760:
              paramAsyncResult.onReceiveResult(false, paramJSONObject);
            }
            catch (Exception localException)
            {
              break label760;
            }
          }
          i = j;
        }
      }
    }
  }
  
  public static void preFetchAppCacheData(Context paramContext, MiniAppInfo paramMiniAppInfo)
  {
    QLog.d("MiniAppUtils", 1, "preFetchAppCacheData ");
    Iterator localIterator;
    if ((paramMiniAppInfo.preCacheList != null) && (paramMiniAppInfo.preCacheList.size() > 0)) {
      localIterator = paramMiniAppInfo.preCacheList.iterator();
    }
    while (localIterator.hasNext())
    {
      PreCacheInfo localPreCacheInfo = (PreCacheInfo)localIterator.next();
      if (localPreCacheInfo.cacheType == 0)
      {
        String str = MiniAppFileManager.getPreCacheFilePath(paramMiniAppInfo.appId, localPreCacheInfo.preCacheKey);
        if ((!TextUtils.isEmpty(str)) && (needUpdateCache(str, localPreCacheInfo.expireTime)))
        {
          fetchWnsCgiPreCacheData(paramContext, paramMiniAppInfo.appId, localPreCacheInfo.getDataUrl, str);
          continue;
          QLog.d("MiniAppUtils", 1, "preFetchAppCacheData, preeCacheList size = 0");
        }
      }
    }
  }
  
  public static void putSpDesktopGdtCookie(String paramString)
  {
    String str = "mini_app_desktop_gdt_cookie_" + BaseApplicationImpl.getApplication().getRuntime().getAccount();
    StorageUtil.getPreference().edit().putString(str, paramString).apply();
    QLog.d("MiniAppUtils", 1, "putSpDesktopGdtCookie, gdt_cookie: " + paramString);
  }
  
  private static void recordMiniAppInfoToCacheListAndUpdateDB(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.recommend = 0;
    paramMiniAppInfo.extendData = null;
    if (apyt.c()) {
      DesktopDataManager.recordMiniAppStart(paramMiniAppInfo);
    }
    for (;;)
    {
      QLog.w("MiniAppUtils", 1, "recordMiniAppInfoToCacheListAndUpdateDB, appInfo = " + paramMiniAppInfo);
      MiniAppLocalSearchManager localMiniAppLocalSearchManager = (MiniAppLocalSearchManager)BaseApplicationImpl.getApplication().getRuntime().getManager(310);
      if (localMiniAppLocalSearchManager != null) {
        localMiniAppLocalSearchManager.updateDataToDB(paramMiniAppInfo);
      }
      return;
      MiniAppUserAppInfoListManager.recordMiniAppStart(paramMiniAppInfo);
    }
  }
  
  public static void reportMiniAppAd(String paramString)
  {
    QLog.d("MiniAppUtils", 1, "reportMiniAppAd reportUrl = " + paramString);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString))) {
      return;
    }
    ThreadManager.executeOnNetWorkThread(new MiniAppUtils.13(paramString));
  }
  
  public static void reportProfileCardClick(Card paramCard, boolean paramBoolean) {}
  
  public static void reportProfileCardExposed(Card paramCard, boolean paramBoolean)
  {
    if (paramBoolean) {}
    Object localObject;
    try
    {
      if ((!paramCard.isShowMiniPlaying) || (paramCard.miniAppInfoArrayList == null) || (paramCard.miniAppInfoArrayList.size() <= 0)) {
        return;
      }
      localObject = new ArrayList();
      i = 0;
      while (i < paramCard.miniAppInfoArrayList.size())
      {
        localMiniAppConfig = new MiniAppConfig((MiniAppInfo)paramCard.miniAppInfoArrayList.get(i));
        localMiniAppConfig.launchParam.scene = 2062;
        ((ArrayList)localObject).add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, i));
        i += 1;
      }
      MiniProgramLpReportDC04239.reportPageView((List)localObject, "expo");
      return;
    }
    catch (Exception paramCard)
    {
      int i;
      MiniAppConfig localMiniAppConfig;
      QLog.e("MiniAppUtils", 1, "reportProfileCardExposed error", paramCard);
      return;
    }
    if ((paramCard.isShowMiniPlaying) && (paramCard.appPlayingInfos != null) && (paramCard.appPlayingInfos.size() > 0))
    {
      if (paramCard.appPlayingInfos.size() > 1)
      {
        localObject = new ArrayList();
        i = 0;
        while (i < paramCard.appPlayingInfos.size())
        {
          localMiniAppConfig = new MiniAppConfig(MiniAppInfo.from(((MISC.StAppPlayingInfo)paramCard.appPlayingInfos.get(i)).appMetaInfo));
          localMiniAppConfig.launchParam.scene = 2062;
          ((ArrayList)localObject).add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, i));
          i += 1;
        }
        MiniProgramLpReportDC04239.reportPageView((List)localObject, "expo");
        return;
      }
      paramCard = ((MISC.StAppPlayingInfo)paramCard.appPlayingInfos.get(0)).appMetaInfo;
      localObject = new MiniAppConfig(MiniAppInfo.from(paramCard));
      ((MiniAppConfig)localObject).launchParam.scene = 2062;
      if (atup.a(paramCard)) {}
      for (paramCard = "id_card";; paramCard = "page_view")
      {
        MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, paramCard, "expo", null, null);
        return;
      }
    }
  }
  
  public static void reportProfileCardItemClick(MiniAppConfig paramMiniAppConfig)
  {
    if (paramMiniAppConfig == null) {
      return;
    }
    try
    {
      MiniAppReportManager.reportClickDc04239(paramMiniAppConfig, MiniProgramLpReportDC04239.getAppType(paramMiniAppConfig), null, "click", null, true);
      return;
    }
    catch (Exception paramMiniAppConfig)
    {
      QLog.e("MiniAppUtils", 1, "reportProfileCardItemClick error", paramMiniAppConfig);
    }
  }
  
  public static void resetMiniDesktopRequestRefreshTime()
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null)
    {
      localAppInterface.getPreferences().edit().putLong("key_mini_app_refresh_interval", 0L).apply();
      QLog.e("MiniAppUtils", 2, "[DesktopDataManager].resetMiniDesktopRequestRefreshTime, reset refresh time");
    }
  }
  
  public static void resetUserAppListRequestRefreshTime()
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface != null)
    {
      localAppInterface.getPreferences().edit().putLong("key_update_miniapp_time", 0L).apply();
      QLog.e("MiniAppUtils", 2, "[MiniAppUserAppInfoListManager].sendUserAppListRequest, reset refresh time");
    }
  }
  
  public static void saveGdtCookie(COMM.StCommonExt paramStCommonExt)
  {
    if ((paramStCommonExt == null) || (paramStCommonExt.mapInfo == null)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramStCommonExt.mapInfo.size())
      {
        COMM.Entry localEntry = (COMM.Entry)paramStCommonExt.mapInfo.get(i);
        if ("gdt_cookie".equals(localEntry.key.get()))
        {
          putSpDesktopGdtCookie(localEntry.value.get());
          return;
        }
        i += 1;
      }
    }
  }
  
  private static void saveToMiniAppStorage(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (paramContext == null) || (paramString3 == null)) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new MiniAppUtils.3(paramContext, paramString1, paramString2, paramString3));
  }
  
  public static void setImage(@NonNull ImageView paramImageView, @Nullable String paramString)
  {
    if (paramString == null)
    {
      paramImageView.setImageDrawable(null);
      return;
    }
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mPlayGifImage = false;
      paramImageView.setImageDrawable(getDrawable(paramString, localURLDrawableOptions));
      return;
    }
    catch (IllegalArgumentException paramImageView)
    {
      QLog.e("MiniAppUtils", 1, "setImage failed:" + paramString);
    }
  }
  
  public static void setJump(Activity paramActivity, @NonNull View paramView, @Nullable MiniAppInfo paramMiniAppInfo, int paramInt)
  {
    if (paramMiniAppInfo != null)
    {
      paramView.setOnClickListener(new MiniAppUtils.1(paramActivity, paramMiniAppInfo, paramInt));
      return;
    }
    paramView.setOnClickListener(null);
  }
  
  public static void updateDesktopRequestTime()
  {
    AppInterface localAppInterface = getAppInterface();
    if (localAppInterface == null)
    {
      QLog.e("MiniAppUtils", 1, "checkMiniAppDesktopSendRequest, app is null.");
      return;
    }
    long l = System.currentTimeMillis();
    localAppInterface.getPreferences().edit().putLong("key_mini_app_refresh_interval", l).apply();
  }
  
  public static void updateMiniAppList(int paramInt)
  {
    QLog.d("MiniAppUtils", 1, "[MiniAppUserAppInfoListManager]. updateMiniAppList, type = " + paramInt);
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, paramInt, true, null);
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(QQMessagePageMiniAppEntryManager.class, paramInt, true, null);
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(ContactsMiniAppEntryManager.class, paramInt, true, null);
  }
  
  private static void updateMiniAppMemoryCache(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig.config == null) || (TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      QLog.e("MiniAppUtils", 1, "updateMiniAppMemoryCache, appInfo: " + paramMiniAppConfig.config);
      return;
    }
    if (paramMiniAppConfig.config.verType != 3)
    {
      QLog.d("MiniAppUtils", 1, "updateMiniAppMemoryCache, verType: " + paramMiniAppConfig.config.verType);
      paramMiniAppConfig = MiniAppInfo.copy(paramMiniAppConfig.config);
      paramMiniAppConfig.debugInfo = null;
      recordMiniAppInfoToCacheListAndUpdateDB(paramMiniAppConfig);
      return;
    }
    MiniAppCmdUtil.getInstance().getAppInfoById(null, paramMiniAppConfig.config.appId, paramMiniAppConfig.launchParam.entryPath, paramMiniAppConfig.launchParam.envVersion, new MiniAppUtils.12(paramMiniAppConfig));
  }
  
  public static void updatePullDownEntryListData(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.isShortcutFakeApp())) {}
    while ((paramMiniAppConfig != null) && (paramMiniAppConfig.config.appMode != null) && (paramMiniAppConfig.config.appMode.keepOffPullList)) {
      return;
    }
    if (!TextUtils.isEmpty(MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()))))
    {
      QLog.d("MiniAppUtils", 1, "updatePullDownEntryListData, has forbidToken");
      return;
    }
    ThreadManager.excute(new MiniAppUtils.10(paramMiniAppConfig), 16, null, true);
    ThreadManagerV2.excute(new MiniAppUtils.11(paramMiniAppConfig), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils
 * JD-Core Version:    0.7.0.1
 */