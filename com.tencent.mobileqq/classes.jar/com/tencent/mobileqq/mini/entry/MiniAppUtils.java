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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.MiniAppConfBean;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.friends.intimate.MiniGamePlayTogetherHandler;
import com.tencent.mobileqq.mini.apkg.AppMode;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.mini.launch.AppBrandLaunchManager;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.launch.CmdCallback;
import com.tencent.mobileqq.mini.report.MiniAppReportManager;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.util.MiniAppSecurityUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.minigame.gpkg.MiniGamePkg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.profilecard.bussiness.miniapp.ProfileMiniAppInfo;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.webso.WebSoCgiService;
import com.tencent.mobileqq.webview.webso.WebSoCgiService.CgiReqInfo;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.vip.tianshu.TianShuManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppUtils
{
  private static final String CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
  private static final String CONTENT_TYPE_JSON = "application/json";
  public static final String GDT_COOKIE = "gdt_cookie";
  public static final String KEY_MINI_APP_CONFIG = "key_record_mini_app_config";
  public static final String KEY_MINI_GAME_PAY_ENV = "keyMiniGamePayEnv";
  public static final String KEY_MINI_GAME_PAY_ENV_APPID_VERTYPE = "keyMiniGamePayEnvAppidVertype";
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
  public static final int TYPE_HONGBAO_MINI_BANNER_ACTION = 104;
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
      paramStringBuilder.append(paramString2);
      paramStringBuilder.append(paramString1);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append("is empty");
      QLog.d("MiniAppUtils", 2, paramString1.toString());
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      insertSemicolon(paramStringBuilder);
      paramStringBuilder.append(paramString2);
      paramStringBuilder.append(paramString3);
    }
  }
  
  public static void checkMiniAppDesktopSendRequest()
  {
    Object localObject = getAppInterface();
    if (localObject == null)
    {
      QLog.e("MiniAppUtils", 1, "checkMiniAppDesktopSendRequest, app is null.");
      return;
    }
    long l1 = ((AppInterface)localObject).getPreferences().getLong("key_mini_app_refresh_interval", 0L);
    long l2 = System.currentTimeMillis();
    localObject = (DesktopDataManager)((AppInterface)localObject).getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    if (l2 - l1 > ((DesktopDataManager)localObject).getRefreshInterval() * 1000L) {
      ((DesktopDataManager)localObject).sendDropDownAppListRequestAsync();
    }
  }
  
  public static boolean checkNavigationAppIdListForMiniGame(String paramString, MiniGamePkg paramMiniGamePkg)
  {
    if (!StringUtil.a(paramString))
    {
      if (paramMiniGamePkg == null) {
        return false;
      }
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
    if (localAppInterface == null)
    {
      QLog.e("MiniAppUtils", 1, "checkSendUserAppListRequest, app is null.");
      return;
    }
    SharedPreferences localSharedPreferences = localAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong("key_update_miniapp_time", 0L);
    long l2 = System.currentTimeMillis();
    MiniAppConfBean localMiniAppConfBean = MiniAppConfProcessor.a();
    int i;
    if (localMiniAppConfBean != null) {
      i = localMiniAppConfBean.a();
    } else {
      i = 60;
    }
    if (l2 - l1 > i * 60 * 1000)
    {
      ((MiniAppUserAppInfoListManager)localAppInterface.getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER)).sendUserAppListRequest(Long.valueOf(localAppInterface.getCurrentAccountUin()).longValue(), 20L);
      localSharedPreferences.edit().putLong("key_update_miniapp_time", l2).apply();
    }
  }
  
  /* Error */
  public static MiniAppInfo createFromBuffer(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 305	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: astore_1
    //   6: aload_2
    //   7: aload_0
    //   8: iconst_0
    //   9: aload_0
    //   10: arraylength
    //   11: invokevirtual 309	android/os/Parcel:unmarshall	([BII)V
    //   14: aload_2
    //   15: astore_1
    //   16: aload_2
    //   17: iconst_0
    //   18: invokevirtual 313	android/os/Parcel:setDataPosition	(I)V
    //   21: aload_2
    //   22: astore_1
    //   23: aload_2
    //   24: ldc_w 315
    //   27: invokevirtual 321	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   30: invokevirtual 325	android/os/Parcel:readParcelable	(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;
    //   33: checkcast 315	com/tencent/mobileqq/mini/apkg/MiniAppInfo
    //   36: astore_0
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: invokevirtual 328	android/os/Parcel:recycle	()V
    //   45: aload_0
    //   46: areturn
    //   47: astore_0
    //   48: goto +91 -> 139
    //   51: astore_1
    //   52: aload_2
    //   53: astore_0
    //   54: aload_1
    //   55: astore_2
    //   56: goto +12 -> 68
    //   59: astore_0
    //   60: aconst_null
    //   61: astore_1
    //   62: goto +77 -> 139
    //   65: astore_2
    //   66: aconst_null
    //   67: astore_0
    //   68: aload_0
    //   69: astore_1
    //   70: new 132	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   77: astore_3
    //   78: aload_0
    //   79: astore_1
    //   80: aload_3
    //   81: ldc_w 330
    //   84: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: astore_1
    //   90: aload_3
    //   91: aload_2
    //   92: invokestatic 336	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   95: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_0
    //   100: astore_1
    //   101: ldc 38
    //   103: iconst_1
    //   104: aload_3
    //   105: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   111: aload_0
    //   112: ifnull +25 -> 137
    //   115: goto +18 -> 133
    //   118: aload_0
    //   119: astore_1
    //   120: ldc 38
    //   122: iconst_1
    //   123: ldc_w 338
    //   126: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: aload_0
    //   130: ifnull +7 -> 137
    //   133: aload_0
    //   134: invokevirtual 328	android/os/Parcel:recycle	()V
    //   137: aconst_null
    //   138: areturn
    //   139: aload_1
    //   140: ifnull +7 -> 147
    //   143: aload_1
    //   144: invokevirtual 328	android/os/Parcel:recycle	()V
    //   147: aload_0
    //   148: athrow
    //   149: astore_0
    //   150: goto +9 -> 159
    //   153: astore_0
    //   154: aload_2
    //   155: astore_0
    //   156: goto -38 -> 118
    //   159: aconst_null
    //   160: astore_0
    //   161: goto -43 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	paramArrayOfByte	byte[]
    //   5	18	1	localObject1	Object
    //   51	4	1	localThrowable1	Throwable
    //   61	83	1	arrayOfByte	byte[]
    //   3	53	2	localObject2	Object
    //   65	90	2	localThrowable2	Throwable
    //   77	28	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	14	47	finally
    //   16	21	47	finally
    //   23	37	47	finally
    //   70	78	47	finally
    //   80	88	47	finally
    //   90	99	47	finally
    //   101	111	47	finally
    //   120	129	47	finally
    //   6	14	51	java/lang/Throwable
    //   16	21	51	java/lang/Throwable
    //   23	37	51	java/lang/Throwable
    //   0	4	59	finally
    //   0	4	65	java/lang/Throwable
    //   0	4	149	java/lang/OutOfMemoryError
    //   6	14	153	java/lang/OutOfMemoryError
    //   16	21	153	java/lang/OutOfMemoryError
    //   23	37	153	java/lang/OutOfMemoryError
  }
  
  private static void fetchWnsCgiCacheData(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((!URLUtil.isHttpsUrl(paramString3)) && (!URLUtil.isHttpUrl(paramString3)))
    {
      paramContext = new StringBuilder();
      paramContext.append(" invalid url ");
      paramContext.append(paramString3);
      QLog.e("MiniAppUtils", 2, new Object[] { "fetchWnsCgiCacheData ", paramContext.toString() });
      return;
    }
    WebSoCgiService.CgiReqInfo localCgiReqInfo = new WebSoCgiService.CgiReqInfo();
    localCgiReqInfo.jdField_a_of_type_JavaLangString = paramString3;
    localCgiReqInfo.b = "GET";
    localCgiReqInfo.jdField_a_of_type_Boolean = false;
    localCgiReqInfo.jdField_a_of_type_Int = 0;
    localCgiReqInfo.jdField_e_of_type_JavaLangString = "application/x-www-form-urlencoded";
    WebSoCgiService.a().a(localCgiReqInfo, new MiniAppUtils.4(ThreadManager.getSubThreadLooper(), paramContext, paramString1, paramString2));
  }
  
  public static void fetchWnsCgiPreCacheData(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = new StringBuilder();
    paramContext.append("--- prefetch cache data appid:");
    paramContext.append(paramString1);
    paramContext.append("  requestUrl");
    paramContext.append(paramString2);
    paramContext.append("  path:");
    paramContext.append(paramString3);
    QLog.d("MiniAppUtils", 1, paramContext.toString());
    paramContext = new WebSoCgiService.CgiReqInfo();
    paramContext.jdField_a_of_type_JavaLangString = paramString2;
    paramContext.b = "GET";
    paramContext.jdField_a_of_type_Boolean = false;
    paramContext.jdField_a_of_type_Int = 0;
    paramContext.jdField_e_of_type_JavaLangString = "application/x-www-form-urlencoded";
    WebSoCgiService.a().a(paramContext, new MiniAppUtils.3(ThreadManager.getSubThreadLooper(), paramString3, paramString2));
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
    String str1 = SwiftBrowserCookieMonster.c(paramString);
    String str2 = SwiftBrowserCookieMonster.a(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    paramString = new StringBuilder();
    paramString.append(".*p_uin=");
    paramString.append(str2);
    paramString.append(";.*");
    Object localObject2 = paramString.toString();
    Object localObject1 = str1;
    paramString = str1;
    for (;;)
    {
      int i;
      try
      {
        if (!TextUtils.isEmpty(str1))
        {
          localObject1 = str1;
          paramString = str1;
          if (str1.contains(";"))
          {
            localObject1 = str1;
            paramString = str1;
            if (str1.contains("uin="))
            {
              localObject1 = str1;
              paramString = str1;
              if (str1.contains("p_uin"))
              {
                localObject1 = str1;
                paramString = str1;
                if (!str1.matches((String)localObject2))
                {
                  paramString = str1;
                  str1 = str1.replaceAll(" ", "");
                  paramString = str1;
                  localObject1 = new StringBuilder();
                  paramString = str1;
                  localObject2 = str1.split(";");
                  paramString = str1;
                  int j = localObject2.length;
                  i = 0;
                  if (i < j)
                  {
                    String str3 = localObject2[i];
                    paramString = str1;
                    String str4;
                    if (str3.startsWith("uin="))
                    {
                      paramString = str1;
                      str4 = str3.substring(4);
                      paramString = str1;
                      if (!TextUtils.isEmpty(str4))
                      {
                        paramString = str1;
                        if (str4.equals(str2)) {
                          break label351;
                        }
                      }
                      paramString = str1;
                      appendCookieStr((StringBuilder)localObject1, str2, "uin=", str3);
                      break label351;
                    }
                    paramString = str1;
                    if (str3.startsWith("p_uin="))
                    {
                      paramString = str1;
                      str4 = str3.substring(6);
                      paramString = str1;
                      if (!TextUtils.isEmpty(str4))
                      {
                        paramString = str1;
                        if (str4.equals(str2)) {
                          break label351;
                        }
                      }
                      paramString = str1;
                      appendCookieStr((StringBuilder)localObject1, str2, "p_uin=", str3);
                      break label351;
                    }
                    paramString = str1;
                    insertSemicolon((StringBuilder)localObject1);
                    paramString = str1;
                    ((StringBuilder)localObject1).append(str3);
                    break label351;
                  }
                  paramString = str1;
                  localObject1 = ((StringBuilder)localObject1).toString();
                }
              }
            }
          }
        }
        return localObject1;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppUtils", 1, "getCookie error.", localThrowable);
        return paramString;
      }
      label351:
      i += 1;
    }
  }
  
  public static Drawable getDrawable(String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    try
    {
      paramURLDrawableOptions = URLDrawable.getDrawable(paramString, paramURLDrawableOptions);
      localObject = paramURLDrawableOptions;
    }
    catch (Exception paramURLDrawableOptions)
    {
      Object localObject;
      label22:
      label25:
      label27:
      label69:
      break label25;
    }
    try
    {
      if (paramURLDrawableOptions.getStatus() != 2) {
        break label69;
      }
      paramURLDrawableOptions.restartDownload();
      return paramURLDrawableOptions;
    }
    catch (Exception localException)
    {
      break label22;
    }
    break label27;
    paramURLDrawableOptions = null;
    localObject = paramURLDrawableOptions;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDrawable: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("MiniAppUtils", 2, ((StringBuilder)localObject).toString());
      localObject = paramURLDrawableOptions;
    }
    return localObject;
  }
  
  public static int getGTK(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 5381;
    if (!bool)
    {
      int i = 0;
      int k = paramString.length();
      while (i < k)
      {
        j += (j << 5) + paramString.charAt(i);
        i += 1;
      }
      return 0x7FFFFFFF & j;
    }
    return 5381;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean)
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
    int i = ViewUtils.b(48.0F);
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
    if (paramBoolean)
    {
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramContext.getResources().getDrawable(2130841201);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramContext.getResources().getDrawable(2130841201);
    }
    paramContext = null;
    Object localObject2;
    try
    {
      localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      paramContext = (Context)localObject1;
      ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.b(9.0F)));
      paramContext = (Context)localObject1;
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.i);
      paramContext = (Context)localObject1;
      localObject2 = localObject1;
      if (((URLDrawable)localObject1).getStatus() == 2)
      {
        paramContext = (Context)localObject1;
        ((URLDrawable)localObject1).restartDownload();
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = paramContext;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIcon url: ");
        localStringBuilder.append(paramString);
        QLog.e("MiniAppUtils", 2, localStringBuilder.toString());
        localObject2 = paramContext;
      }
    }
    return localObject2;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt)
  {
    Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = false;
    int i = ViewUtils.b(48.0F);
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = i;
    ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = i;
    if (paramBoolean)
    {
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = paramContext.getResources().getDrawable(2130841201);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = paramContext.getResources().getDrawable(2130841201);
    }
    paramContext = null;
    Object localObject2;
    try
    {
      localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
      paramContext = (Context)localObject1;
      ((URLDrawable)localObject1).setTag(URLDrawableDecodeHandler.b(i, i, ViewUtils.b(paramInt)));
      paramContext = (Context)localObject1;
      ((URLDrawable)localObject1).setDecodeHandler(URLDrawableDecodeHandler.i);
      paramContext = (Context)localObject1;
      localObject2 = localObject1;
      if (((URLDrawable)localObject1).getStatus() == 2)
      {
        paramContext = (Context)localObject1;
        ((URLDrawable)localObject1).restartDownload();
        return localObject1;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localObject2 = paramContext;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIcon url: ");
        localStringBuilder.append(paramString);
        QLog.e("MiniAppUtils", 2, localStringBuilder.toString());
        localObject2 = paramContext;
      }
    }
    return localObject2;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = false;
    paramInt2 = ViewUtils.b(paramInt2);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
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
      ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.b(paramInt2, paramInt2, ViewUtils.b(9.0F)));
      paramContext = (Context)localObject;
      ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.i);
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getIcon url: ");
        localStringBuilder.append(paramString);
        QLog.e("MiniAppUtils", 2, localStringBuilder.toString());
      }
    }
    return paramContext;
  }
  
  public static Drawable getIcon(Context paramContext, String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mPlayGifImage = false;
    paramInt2 = ViewUtils.b(paramInt2);
    localURLDrawableOptions.mRequestHeight = ViewUtils.b(paramInt3);
    localURLDrawableOptions.mRequestWidth = paramInt2;
    if (paramBoolean)
    {
      localURLDrawableOptions.mFailedDrawable = paramContext.getResources().getDrawable(paramInt1);
      localURLDrawableOptions.mLoadingDrawable = paramContext.getResources().getDrawable(paramInt1);
    }
    try
    {
      paramContext = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getIcon url: ");
        paramContext.append(paramString);
        QLog.e("MiniAppUtils", 2, paramContext.toString());
      }
    }
    return null;
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
      label17:
      break label17;
    }
    QLog.e("MiniAppUtils", 1, "getRecommendIconDrawable, failed.");
    return null;
  }
  
  public static String getSpDesktopGdtCookie()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mini_app_desktop_gdt_cookie_");
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    return StorageUtil.getPreference().getString((String)localObject, "");
  }
  
  public static void handleMiniAppMoreClick(Activity paramActivity)
  {
    int i = 0;
    try
    {
      int j = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_open_store_use_appid", 0);
      i = j;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppUtils", 1, "get config MINI_APP_OPEN_STORE_USE_APPID exception!", localThrowable);
    }
    if (i != 0)
    {
      MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b", 1001, null);
      return;
    }
    Object localObject = getAppInterface();
    if (localObject != null)
    {
      localObject = (MiniAppUserAppInfoListManager)((AppInterface)localObject).getManager(QQManagerFactory.MINI_APP_ITEM_MANAGER);
      if (localObject != null) {
        localObject = ((MiniAppUserAppInfoListManager)localObject).findTopMiniApp("1108291530");
      } else {
        localObject = null;
      }
      if (localObject == null) {}
    }
    try
    {
      QLog.d("MiniAppUtils", 2, "handleMiniAppMoreClick, launch app store by appInfo");
      MiniAppController.launchMiniAppByAppInfo(paramActivity, (MiniAppInfo)localObject, 1001);
      return;
    }
    catch (MiniAppException localMiniAppException)
    {
      label106:
      break label106;
    }
    QLog.e("MiniAppUtils", 1, "handleMiniAppMoreClick, launchMiniAppByAppInfo exception.");
    MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b", 1001, null);
    return;
    MiniAppLauncher.startMiniApp(paramActivity, "mqqapi://miniapp/open?_ext=&_mappid=1108291530&_mvid=&_nq=&_path=&_q=&_sig=0178f7ca2545b9ef6f736f01247642f6e53ef6467005aa21274c4166f0ff5a3b", 1001, null);
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
    if ((paramBundle != null) && (paramBundle.config != null))
    {
      updatePullDownEntryListData(paramBundle);
      if (paramCmdCallback != null) {
        try
        {
          paramCmdCallback.onCmdResult(true, new Bundle());
          return;
        }
        catch (RemoteException paramBundle)
        {
          paramCmdCallback = new StringBuilder();
          paramCmdCallback.append("handlePullDownEntryListData, ");
          paramCmdCallback.append(Log.getStackTraceString(paramBundle));
          QLog.e("MiniAppUtils", 1, paramCmdCallback.toString());
        }
      }
      return;
    }
    QLog.e("MiniAppUtils", 1, "handlePullDownEntryListData, miniAppConfig is null");
  }
  
  private static void insertSemicolon(StringBuilder paramStringBuilder)
  {
    if ((paramStringBuilder != null) && (paramStringBuilder.length() > 0))
    {
      if (paramStringBuilder.toString().endsWith(";"))
      {
        paramStringBuilder.append(" ");
        return;
      }
      if (!paramStringBuilder.toString().endsWith("; ")) {
        paramStringBuilder.append("; ");
      }
    }
  }
  
  public static boolean isDebugMiniApp(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
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
        return false;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("MiniAppUtils", 1, new Object[] { "isDebugMiniApp appidVerTypeStr", paramString, localThrowable });
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
    TianShuReportData localTianShuReportData = new TianShuReportData();
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if (localObject != null) {
      localObject = ((AppRuntime)localObject).getAccount();
    } else {
      localObject = "";
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    localStringBuilder.append(l);
    localTianShuReportData.b = localStringBuilder.toString();
    localTianShuReportData.jdField_a_of_type_Int = 1;
    localTianShuReportData.jdField_e_of_type_JavaLangString = paramString1;
    localTianShuReportData.f = paramString2;
    localTianShuReportData.g = paramString3;
    localTianShuReportData.d = paramInt;
    localTianShuReportData.jdField_e_of_type_Int = 1;
    localTianShuReportData.jdField_a_of_type_Long = l;
    TianShuManager.getInstance().report(localTianShuReportData);
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("tianShuReport, report itemId: ");
      paramString1.append(paramString3);
      QLog.i("MiniAppUtils", 2, paramString1.toString());
    }
  }
  
  private static boolean needUpdateCache(String paramString, long paramLong)
  {
    Object localObject = new File(paramString);
    if (((File)localObject).exists())
    {
      long l = System.currentTimeMillis();
      paramString = new StringBuilder();
      paramString.append("needUpdateCache: precache : lastModified:");
      paramString.append(((File)localObject).lastModified());
      paramString.append("  curTime:");
      paramString.append(l);
      paramString.append("  expire:");
      paramString.append(paramLong);
      QLog.d("MiniAppUtils", 2, paramString.toString());
      if (((File)localObject).lastModified() + paramLong * 1000L > l) {
        return false;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("needUpdateCache precache:  file not exist:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("MiniAppUtils", 2, ((StringBuilder)localObject).toString());
    }
    return true;
  }
  
  public static void notifyUpdateHongBaoRes()
  {
    if (MiniAppConfProcessor.c())
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
    AppBrandProxy.g().sendCmd("cmd_update_pull_down_entry_list", localBundle, new MiniAppUtils.6());
  }
  
  /* Error */
  public static byte[] packMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    // Byte code:
    //   0: invokestatic 305	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   3: astore_2
    //   4: aload_2
    //   5: astore_1
    //   6: aload_2
    //   7: iconst_0
    //   8: invokevirtual 313	android/os/Parcel:setDataPosition	(I)V
    //   11: aload_2
    //   12: astore_1
    //   13: aload_2
    //   14: aload_0
    //   15: iconst_0
    //   16: invokevirtual 880	android/os/Parcel:writeParcelable	(Landroid/os/Parcelable;I)V
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: invokevirtual 884	android/os/Parcel:marshall	()[B
    //   25: astore_0
    //   26: aload_2
    //   27: ifnull +7 -> 34
    //   30: aload_2
    //   31: invokevirtual 328	android/os/Parcel:recycle	()V
    //   34: aload_0
    //   35: areturn
    //   36: astore_0
    //   37: goto +73 -> 110
    //   40: astore_1
    //   41: aload_2
    //   42: astore_0
    //   43: aload_1
    //   44: astore_2
    //   45: goto +12 -> 57
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_1
    //   51: goto +59 -> 110
    //   54: astore_2
    //   55: aconst_null
    //   56: astore_0
    //   57: aload_0
    //   58: astore_1
    //   59: new 132	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   66: astore_3
    //   67: aload_0
    //   68: astore_1
    //   69: aload_3
    //   70: ldc_w 886
    //   73: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_0
    //   78: astore_1
    //   79: aload_3
    //   80: aload_2
    //   81: invokestatic 336	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   84: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_0
    //   89: astore_1
    //   90: ldc 38
    //   92: iconst_1
    //   93: aload_3
    //   94: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 163	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: ifnull +7 -> 108
    //   104: aload_0
    //   105: invokevirtual 328	android/os/Parcel:recycle	()V
    //   108: aconst_null
    //   109: areturn
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 328	android/os/Parcel:recycle	()V
    //   118: aload_0
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	paramMiniAppInfo	MiniAppInfo
    //   5	16	1	localObject1	Object
    //   40	4	1	localThrowable1	Throwable
    //   50	65	1	localMiniAppInfo	MiniAppInfo
    //   3	42	2	localObject2	Object
    //   54	27	2	localThrowable2	Throwable
    //   66	28	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   6	11	36	finally
    //   13	19	36	finally
    //   21	26	36	finally
    //   59	67	36	finally
    //   69	77	36	finally
    //   79	88	36	finally
    //   90	100	36	finally
    //   6	11	40	java/lang/Throwable
    //   13	19	40	java/lang/Throwable
    //   21	26	40	java/lang/Throwable
    //   0	4	48	finally
    //   0	4	54	java/lang/Throwable
  }
  
  /* Error */
  public static boolean performWnsCgiRequest(JSONObject paramJSONObject, com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult paramAsyncResult)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: aload_1
    //   5: iconst_0
    //   6: aconst_null
    //   7: invokeinterface 894 3 0
    //   12: iconst_0
    //   13: ireturn
    //   14: invokestatic 408	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   20: iconst_2
    //   21: invokevirtual 895	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 897	mqq/manager/TicketManager
    //   27: astore 10
    //   29: aload_0
    //   30: ldc_w 899
    //   33: invokevirtual 903	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   36: astore 8
    //   38: new 356	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo
    //   41: dup
    //   42: invokespecial 357	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:<init>	()V
    //   45: astore 9
    //   47: aload 9
    //   49: aload_0
    //   50: ldc_w 905
    //   53: invokevirtual 908	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   56: putfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: aload 8
    //   61: ifnonnull +11 -> 72
    //   64: ldc_w 910
    //   67: astore 8
    //   69: goto +10 -> 79
    //   72: aload 8
    //   74: invokevirtual 911	org/json/JSONObject:toString	()Ljava/lang/String;
    //   77: astore 8
    //   79: aload 9
    //   81: aload 8
    //   83: putfield 913	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:c	Ljava/lang/String;
    //   86: aload 9
    //   88: ldc_w 914
    //   91: putfield 369	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_Int	I
    //   94: aload 9
    //   96: ldc 8
    //   98: putfield 371	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   101: aload 9
    //   103: aload_0
    //   104: ldc_w 916
    //   107: ldc_w 361
    //   110: invokevirtual 918	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   113: putfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   116: aload 9
    //   118: aload_0
    //   119: ldc_w 920
    //   122: invokevirtual 908	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   125: ldc_w 922
    //   128: invokevirtual 241	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: putfield 367	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_Boolean	Z
    //   134: aload 9
    //   136: aconst_null
    //   137: putfield 924	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:d	Ljava/lang/String;
    //   140: aload_0
    //   141: ldc_w 926
    //   144: invokevirtual 908	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   147: ldc_w 928
    //   150: invokevirtual 931	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   153: istore 6
    //   155: aload 9
    //   157: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   160: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   163: ifeq +13 -> 176
    //   166: aload_1
    //   167: iconst_0
    //   168: aconst_null
    //   169: invokeinterface 894 3 0
    //   174: iconst_0
    //   175: ireturn
    //   176: aload_0
    //   177: ldc_w 933
    //   180: invokevirtual 936	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   183: ifeq +39 -> 222
    //   186: aload_0
    //   187: ldc_w 933
    //   190: invokevirtual 939	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   193: astore_0
    //   194: aload_0
    //   195: instanceof 228
    //   198: ifeq +15 -> 213
    //   201: aload 9
    //   203: aload_0
    //   204: checkcast 228	java/lang/String
    //   207: putfield 924	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:d	Ljava/lang/String;
    //   210: goto +12 -> 222
    //   213: aload 9
    //   215: aload_0
    //   216: invokevirtual 940	java/lang/Object:toString	()Ljava/lang/String;
    //   219: putfield 924	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:d	Ljava/lang/String;
    //   222: aload 9
    //   224: getfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   227: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   230: ifeq +13 -> 243
    //   233: aload_1
    //   234: iconst_0
    //   235: aconst_null
    //   236: invokeinterface 894 3 0
    //   241: iconst_0
    //   242: ireturn
    //   243: ldc_w 941
    //   246: aload 9
    //   248: getfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   251: invokevirtual 931	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   254: istore 7
    //   256: iload 7
    //   258: ifne +30 -> 288
    //   261: ldc_w 943
    //   264: aload 9
    //   266: getfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   269: invokevirtual 931	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   272: ifeq +6 -> 278
    //   275: goto +13 -> 288
    //   278: aload_1
    //   279: iconst_0
    //   280: aconst_null
    //   281: invokeinterface 894 3 0
    //   286: iconst_0
    //   287: ireturn
    //   288: aload 9
    //   290: aload 9
    //   292: getfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   295: invokevirtual 946	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   298: putfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   301: ldc_w 943
    //   304: aload 9
    //   306: getfield 364	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:b	Ljava/lang/String;
    //   309: invokevirtual 931	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   312: ifeq +10 -> 322
    //   315: aload 9
    //   317: ldc 11
    //   319: putfield 371	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   322: invokestatic 408	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   325: invokevirtual 412	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   328: invokevirtual 426	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   331: astore_0
    //   332: aload 10
    //   334: aload_0
    //   335: invokestatic 951	com/tencent/biz/AuthorizeConfig:a	()Lcom/tencent/biz/AuthorizeConfig;
    //   338: aload 9
    //   340: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   343: invokestatic 953	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:b	(Ljava/lang/String;)Ljava/lang/String;
    //   346: invokevirtual 954	com/tencent/biz/AuthorizeConfig:c	(Ljava/lang/String;)Ljava/lang/String;
    //   349: invokeinterface 957 3 0
    //   354: astore 8
    //   356: aload 8
    //   358: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   361: ifne +432 -> 793
    //   364: aload 8
    //   366: invokestatic 959	com/tencent/mobileqq/mini/entry/MiniAppUtils:getGTK	(Ljava/lang/String;)I
    //   369: istore_2
    //   370: goto +3 -> 373
    //   373: iload_2
    //   374: iconst_m1
    //   375: if_icmpne +434 -> 809
    //   378: aload 9
    //   380: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   383: invokestatic 421	com/tencent/mobileqq/webview/swift/component/SwiftBrowserCookieMonster:c	(Ljava/lang/String;)Ljava/lang/String;
    //   386: astore 8
    //   388: aload 8
    //   390: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   393: ifne +416 -> 809
    //   396: aload 8
    //   398: ldc_w 961
    //   401: invokevirtual 437	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   404: ifeq +405 -> 809
    //   407: aload 8
    //   409: ldc_w 434
    //   412: invokevirtual 456	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   415: astore 8
    //   417: aload 8
    //   419: arraylength
    //   420: istore 5
    //   422: iconst_0
    //   423: istore 4
    //   425: iload_2
    //   426: istore_3
    //   427: iload 4
    //   429: iload 5
    //   431: if_icmpge +74 -> 505
    //   434: aload 8
    //   436: iload 4
    //   438: aaload
    //   439: astore 11
    //   441: iload_2
    //   442: istore_3
    //   443: aload 11
    //   445: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   448: ifne +350 -> 798
    //   451: iload_2
    //   452: istore_3
    //   453: aload 11
    //   455: ldc_w 961
    //   458: invokevirtual 437	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   461: ifeq +337 -> 798
    //   464: aload 11
    //   466: aload 11
    //   468: ldc_w 963
    //   471: invokevirtual 966	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   474: iconst_1
    //   475: iadd
    //   476: aload 11
    //   478: invokevirtual 232	java/lang/String:length	()I
    //   481: invokevirtual 969	java/lang/String:substring	(II)Ljava/lang/String;
    //   484: astore 11
    //   486: iload_2
    //   487: istore_3
    //   488: aload 11
    //   490: invokestatic 126	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   493: ifne +305 -> 798
    //   496: aload 11
    //   498: invokestatic 959	com/tencent/mobileqq/mini/entry/MiniAppUtils:getGTK	(Ljava/lang/String;)I
    //   501: istore_3
    //   502: goto +296 -> 798
    //   505: iload_3
    //   506: istore_2
    //   507: iload_3
    //   508: iconst_m1
    //   509: if_icmpne +15 -> 524
    //   512: aload 10
    //   514: aload_0
    //   515: invokeinterface 972 2 0
    //   520: invokestatic 959	com/tencent/mobileqq/mini/entry/MiniAppUtils:getGTK	(Ljava/lang/String;)I
    //   523: istore_2
    //   524: iload_2
    //   525: iconst_m1
    //   526: if_icmpeq +158 -> 684
    //   529: aload 9
    //   531: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   534: ldc_w 974
    //   537: invokevirtual 437	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   540: ifeq +47 -> 587
    //   543: new 132	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   550: astore_0
    //   551: aload_0
    //   552: aload 9
    //   554: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   557: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   560: pop
    //   561: aload_0
    //   562: ldc_w 976
    //   565: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: pop
    //   569: aload_0
    //   570: iload_2
    //   571: invokevirtual 979	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload 9
    //   577: aload_0
    //   578: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   581: putfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   584: goto +44 -> 628
    //   587: new 132	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   594: astore_0
    //   595: aload_0
    //   596: aload 9
    //   598: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   601: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_0
    //   606: ldc_w 981
    //   609: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_0
    //   614: iload_2
    //   615: invokevirtual 979	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 9
    //   621: aload_0
    //   622: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   625: putfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   628: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   631: ifeq +53 -> 684
    //   634: new 132	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   641: astore_0
    //   642: aload_0
    //   643: ldc_w 983
    //   646: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_0
    //   651: aload 9
    //   653: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   656: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: pop
    //   660: ldc 38
    //   662: iconst_2
    //   663: aload_0
    //   664: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   670: goto +14 -> 684
    //   673: astore_0
    //   674: ldc 38
    //   676: iconst_1
    //   677: ldc_w 985
    //   680: aload_0
    //   681: invokestatic 471	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   684: new 987	com/tencent/mobileqq/mini/entry/MiniAppUtils$5
    //   687: dup
    //   688: invokestatic 990	com/tencent/mobileqq/app/ThreadManagerV2:getSubThreadLooper	()Landroid/os/Looper;
    //   691: iload 6
    //   693: aload_1
    //   694: invokespecial 993	com/tencent/mobileqq/mini/entry/MiniAppUtils$5:<init>	(Landroid/os/Looper;ZLcom/tencent/qqmini/sdk/launcher/core/proxy/AsyncResult;)V
    //   697: astore_0
    //   698: invokestatic 376	com/tencent/mobileqq/webview/webso/WebSoCgiService:a	()Lcom/tencent/mobileqq/webview/webso/WebSoCgiService;
    //   701: aload 9
    //   703: aload_0
    //   704: aload 9
    //   706: getfield 359	com/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   709: invokestatic 995	com/tencent/mobileqq/mini/entry/MiniAppUtils:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   712: invokevirtual 998	com/tencent/mobileqq/webview/webso/WebSoCgiService:a	(Lcom/tencent/mobileqq/webview/webso/WebSoCgiService$CgiReqInfo;Landroid/os/Handler;Ljava/lang/String;)Z
    //   715: ifeq +14 -> 729
    //   718: ldc 38
    //   720: iconst_2
    //   721: ldc_w 1000
    //   724: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   727: iconst_1
    //   728: ireturn
    //   729: ldc 38
    //   731: iconst_2
    //   732: ldc_w 1002
    //   735: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   738: new 222	org/json/JSONObject
    //   741: dup
    //   742: invokespecial 1003	org/json/JSONObject:<init>	()V
    //   745: astore_0
    //   746: aload_0
    //   747: ldc_w 1005
    //   750: sipush 20001
    //   753: invokevirtual 1009	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   756: pop
    //   757: aload_1
    //   758: iconst_0
    //   759: aload_0
    //   760: invokeinterface 894 3 0
    //   765: iconst_0
    //   766: ireturn
    //   767: astore_0
    //   768: ldc 38
    //   770: iconst_1
    //   771: ldc_w 1011
    //   774: aload_0
    //   775: invokestatic 471	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   778: aload_1
    //   779: iconst_0
    //   780: aconst_null
    //   781: invokeinterface 894 3 0
    //   786: iconst_0
    //   787: ireturn
    //   788: astore 8
    //   790: goto -33 -> 757
    //   793: iconst_m1
    //   794: istore_2
    //   795: goto -422 -> 373
    //   798: iload 4
    //   800: iconst_1
    //   801: iadd
    //   802: istore 4
    //   804: iload_3
    //   805: istore_2
    //   806: goto -381 -> 425
    //   809: iload_2
    //   810: istore_3
    //   811: goto -306 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	814	0	paramJSONObject	JSONObject
    //   0	814	1	paramAsyncResult	com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
    //   369	441	2	i	int
    //   426	385	3	j	int
    //   423	380	4	k	int
    //   420	12	5	m	int
    //   153	539	6	bool1	boolean
    //   254	3	7	bool2	boolean
    //   36	399	8	localObject1	Object
    //   788	1	8	localException	Exception
    //   45	660	9	localCgiReqInfo	WebSoCgiService.CgiReqInfo
    //   27	486	10	localTicketManager	mqq.manager.TicketManager
    //   439	58	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   322	370	673	java/lang/Throwable
    //   378	422	673	java/lang/Throwable
    //   443	451	673	java/lang/Throwable
    //   453	486	673	java/lang/Throwable
    //   488	502	673	java/lang/Throwable
    //   512	524	673	java/lang/Throwable
    //   529	584	673	java/lang/Throwable
    //   587	628	673	java/lang/Throwable
    //   628	670	673	java/lang/Throwable
    //   14	59	767	org/json/JSONException
    //   72	79	767	org/json/JSONException
    //   79	174	767	org/json/JSONException
    //   176	210	767	org/json/JSONException
    //   213	222	767	org/json/JSONException
    //   222	241	767	org/json/JSONException
    //   243	256	767	org/json/JSONException
    //   261	275	767	org/json/JSONException
    //   278	286	767	org/json/JSONException
    //   288	322	767	org/json/JSONException
    //   322	370	767	org/json/JSONException
    //   378	422	767	org/json/JSONException
    //   443	451	767	org/json/JSONException
    //   453	486	767	org/json/JSONException
    //   488	502	767	org/json/JSONException
    //   512	524	767	org/json/JSONException
    //   529	584	767	org/json/JSONException
    //   587	628	767	org/json/JSONException
    //   628	670	767	org/json/JSONException
    //   674	684	767	org/json/JSONException
    //   684	727	767	org/json/JSONException
    //   729	746	767	org/json/JSONException
    //   746	757	767	org/json/JSONException
    //   757	765	767	org/json/JSONException
    //   746	757	788	java/lang/Exception
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mini_app_desktop_gdt_cookie_");
    ((StringBuilder)localObject).append(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    localObject = ((StringBuilder)localObject).toString();
    StorageUtil.getPreference().edit().putString((String)localObject, paramString).apply();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("putSpDesktopGdtCookie, gdt_cookie: ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("MiniAppUtils", 1, ((StringBuilder)localObject).toString());
  }
  
  private static void recordMiniAppInfoToCacheListAndUpdateDB(MiniAppInfo paramMiniAppInfo)
  {
    paramMiniAppInfo.recommend = 0;
    paramMiniAppInfo.extendData = null;
    if (MiniAppConfProcessor.c()) {
      DesktopDataManager.recordMiniAppStart(paramMiniAppInfo);
    } else {
      MiniAppUserAppInfoListManager.recordMiniAppStart(paramMiniAppInfo);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("recordMiniAppInfoToCacheListAndUpdateDB, appInfo = ");
    ((StringBuilder)localObject).append(paramMiniAppInfo);
    QLog.w("MiniAppUtils", 1, ((StringBuilder)localObject).toString());
    localObject = (MiniAppLocalSearchManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.MINI_APP_LOCAL_SEARCH);
    if (localObject != null) {
      ((MiniAppLocalSearchManager)localObject).updateDataToDB(paramMiniAppInfo);
    }
  }
  
  public static void reportMiniAppAd(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportMiniAppAd reportUrl = ");
    localStringBuilder.append(paramString);
    QLog.d("MiniAppUtils", 1, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      if (!URLUtil.isNetworkUrl(paramString)) {
        return;
      }
      ThreadManager.executeOnNetWorkThread(new MiniAppUtils.10(paramString));
    }
  }
  
  public static void reportProfileCardClick(Card paramCard, boolean paramBoolean) {}
  
  public static void reportProfileCardExposed(ProfileMiniAppInfo paramProfileMiniAppInfo, boolean paramBoolean)
  {
    int j = 0;
    int i = 0;
    if (paramBoolean) {}
    try
    {
      if ((!paramProfileMiniAppInfo.isShowMiniPlaying) || (paramProfileMiniAppInfo.miniAppInfoArrayList == null) || (paramProfileMiniAppInfo.miniAppInfoArrayList.size() <= 0)) {
        break label330;
      }
      localObject = new ArrayList();
      while (i < paramProfileMiniAppInfo.miniAppInfoArrayList.size())
      {
        localMiniAppConfig = new MiniAppConfig(MiniAppInfo.from((INTERFACE.StApiAppInfo)paramProfileMiniAppInfo.miniAppInfoArrayList.get(i)));
        localMiniAppConfig.launchParam.scene = 2062;
        ((ArrayList)localObject).add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, i));
        i += 1;
      }
      MiniProgramLpReportDC04239.reportPageView((List)localObject, "expo");
      return;
    }
    catch (Exception paramProfileMiniAppInfo)
    {
      Object localObject;
      MiniAppConfig localMiniAppConfig;
      QLog.e("MiniAppUtils", 1, "reportProfileCardExposed error", paramProfileMiniAppInfo);
    }
    if ((paramProfileMiniAppInfo.isShowMiniPlaying) && (paramProfileMiniAppInfo.appPlayingInfos != null) && (paramProfileMiniAppInfo.appPlayingInfos.size() > 0))
    {
      if (paramProfileMiniAppInfo.appPlayingInfos.size() > 1)
      {
        localObject = new ArrayList();
        i = j;
        while (i < paramProfileMiniAppInfo.appPlayingInfos.size())
        {
          localMiniAppConfig = new MiniAppConfig(MiniAppInfo.from(((MISC.StAppPlayingInfo)paramProfileMiniAppInfo.appPlayingInfos.get(i)).appMetaInfo));
          localMiniAppConfig.launchParam.scene = 2062;
          ((ArrayList)localObject).add(new MiniAppExposureManager.MiniAppExposureData(localMiniAppConfig, i));
          i += 1;
        }
        MiniProgramLpReportDC04239.reportPageView((List)localObject, "expo");
        return;
      }
      paramProfileMiniAppInfo = ((MISC.StAppPlayingInfo)paramProfileMiniAppInfo.appPlayingInfos.get(0)).appMetaInfo;
      localObject = new MiniAppConfig(MiniAppInfo.from(paramProfileMiniAppInfo));
      ((MiniAppConfig)localObject).launchParam.scene = 2062;
      if (!MiniGamePlayTogetherHandler.a(paramProfileMiniAppInfo)) {
        break label331;
      }
      paramProfileMiniAppInfo = "id_card";
    }
    for (;;)
    {
      MiniProgramLpReportDC04239.reportAsync((MiniAppConfig)localObject, paramProfileMiniAppInfo, "expo", null, null);
      return;
      label330:
      return;
      label331:
      paramProfileMiniAppInfo = "page_view";
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
    if (paramStCommonExt != null)
    {
      if (paramStCommonExt.mapInfo == null) {
        return;
      }
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
    if ((!TextUtils.isEmpty(paramString1)) && (paramContext != null))
    {
      if (paramString3 == null) {
        return;
      }
      ThreadManager.getFileThreadHandler().post(new MiniAppUtils.2(paramContext, paramString1, paramString2, paramString3));
    }
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
      label29:
      break label29;
    }
    paramImageView = new StringBuilder();
    paramImageView.append("setImage failed:");
    paramImageView.append(paramString);
    QLog.e("MiniAppUtils", 1, paramImageView.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[MiniAppUserAppInfoListManager]. updateMiniAppList, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("MiniAppUtils", 1, localStringBuilder.toString());
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, paramInt, true, null);
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(QQMessagePageMiniAppEntryManager.class, paramInt, true, null);
    BaseApplicationImpl.getApplication().getRuntime().notifyObservers(ContactsMiniAppEntryManager.class, paramInt, true, null);
  }
  
  private static void updateMiniAppMemoryCache(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig.config != null) && (!TextUtils.isEmpty(paramMiniAppConfig.config.appId)))
    {
      if (paramMiniAppConfig.config.verType != 3)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateMiniAppMemoryCache, verType: ");
        localStringBuilder.append(paramMiniAppConfig.config.verType);
        QLog.d("MiniAppUtils", 1, localStringBuilder.toString());
        paramMiniAppConfig = MiniAppInfo.copy(paramMiniAppConfig.config);
        paramMiniAppConfig.debugInfo = null;
        recordMiniAppInfoToCacheListAndUpdateDB(paramMiniAppConfig);
        return;
      }
      MiniAppCmdUtil.getInstance().getAppInfoById(null, paramMiniAppConfig.config.appId, paramMiniAppConfig.launchParam.entryPath, paramMiniAppConfig.launchParam.envVersion, new MiniAppUtils.9(paramMiniAppConfig));
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateMiniAppMemoryCache, appInfo: ");
    localStringBuilder.append(paramMiniAppConfig.config);
    QLog.e("MiniAppUtils", 1, localStringBuilder.toString());
  }
  
  public static void updatePullDownEntryListData(MiniAppConfig paramMiniAppConfig)
  {
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.isShortcutFakeApp())) {
      return;
    }
    if ((paramMiniAppConfig != null) && (paramMiniAppConfig.config.appMode != null) && (paramMiniAppConfig.config.appMode.keepOffPullList)) {
      return;
    }
    if (!TextUtils.isEmpty(MiniAppSecurityUtil.getLoginMiniAppForbidToken(BaseApplicationImpl.getApplication(), MiniAppSecurityUtil.getLoginMiniAppUin(BaseApplicationImpl.getApplication()))))
    {
      QLog.d("MiniAppUtils", 1, "updatePullDownEntryListData, has forbidToken");
      return;
    }
    ThreadManager.excute(new MiniAppUtils.7(paramMiniAppConfig), 16, null, true);
    ThreadManagerV2.excute(new MiniAppUtils.8(paramMiniAppConfig), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils
 * JD-Core Version:    0.7.0.1
 */