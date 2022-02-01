package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.appcommon.AppClient;
import com.tencent.open.appcommon.CallBackEvent;
import com.tencent.open.appcommon.Common;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.ToastUtil;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.open.downloadnew.MyAppApi;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseJsCallBack
  extends BaseInterface
{
  public static final String LOG_TAG = "BaseJsCallBack";
  public static final String PLUGIN_NAMESPACE = "qqZoneAppList";
  public static boolean isUpdateAssets = false;
  protected Activity activity;
  LastDownloadAction lastActionRecord = null;
  protected Handler mHandler;
  private RemoteServiceProxy mRemoteServiceProxy;
  public String timePointParams = "";
  protected String urlParams = "";
  
  public BaseJsCallBack(Activity paramActivity)
  {
    if ((paramActivity instanceof PluginBaseActivity)) {
      this.activity = ((PluginBaseActivity)paramActivity).getOutActivity();
    } else {
      this.activity = paramActivity;
    }
    this.mHandler = new Handler(Looper.getMainLooper());
    this.mRemoteServiceProxy = RemoteServiceProxy.a(String.valueOf(CommonDataAdapter.a().c()));
  }
  
  public boolean appIsExists(String paramString)
  {
    return AppUtil.a(paramString);
  }
  
  public String appIsExistsBatch(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return "";
      }
      Object localObject = paramString1.split(paramString2);
      if (localObject.length == 0) {
        return "";
      }
      paramString1 = new LinkedHashMap();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        String str = localObject[i];
        if ((str != null) && (str.length() > 0)) {
          if (AppUtil.a(str)) {
            paramString1.put(str, Integer.valueOf(1));
          } else {
            paramString1.put(str, Integer.valueOf(0));
          }
        }
        i += 1;
      }
      localObject = new StringBuilder();
      paramString1 = paramString1.entrySet().iterator();
      while (paramString1.hasNext())
      {
        ((StringBuilder)localObject).append(((Map.Entry)paramString1.next()).getValue());
        ((StringBuilder)localObject).append(paramString2);
      }
      if (((StringBuilder)localObject).length() == 0) {
        return "";
      }
      paramString1 = new StringBuilder();
      paramString1.append("appIsExistsBatch >>>");
      paramString1.append(((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1));
      LogUtility.c("BaseJsCallBack", paramString1.toString());
      return ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
    }
    return "";
  }
  
  public void back()
  {
    this.activity.finish();
  }
  
  public void cgiReport(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      long l = Long.parseLong(paramString2);
      int i = Integer.parseInt(paramString3);
      ReportManager.a().a(paramString1, SystemClock.elapsedRealtime() - l, 0L, 0L, i, CommonDataAdapter.a().c(), "1000002", null);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void changeLoadingTip(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.mHandler.post(new BaseJsCallBack.6(this, paramString));
  }
  
  public void clearJS()
  {
    LogUtility.e("BaseJsCallBack", "clearJS");
    if (this.mRemoteServiceProxy != null)
    {
      SendMsg localSendMsg = new SendMsg("clearJS");
      this.mRemoteServiceProxy.b(localSendMsg);
    }
  }
  
  public int getAPNType()
  {
    Object localObject = (ConnectivityManager)this.activity.getSystemService("connectivity");
    int i = -1;
    if (localObject == null) {
      return -1;
    }
    localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    if (localObject == null) {
      return -1;
    }
    int j = i;
    try
    {
      int k = ((NetworkInfo)localObject).getType();
      if (k == 0)
      {
        k = i;
        j = i;
        if (((NetworkInfo)localObject).getExtraInfo() == null) {
          k = 2;
        }
        j = k;
        boolean bool = ((NetworkInfo)localObject).getExtraInfo().toLowerCase(Locale.ENGLISH).equals("cmnet");
        if (bool) {
          return 3;
        }
        return 2;
      }
      if (k == 1) {
        return 1;
      }
    }
    catch (Exception localException)
    {
      LogUtility.c("BaseJsCallBack", "getAPNType EX >>> ", localException);
      i = j;
    }
    return i;
  }
  
  public String getAgentVersion()
  {
    return CommonDataAdapter.a().k();
  }
  
  public String getAppVersionCode(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("packageName");
      localObject = ((JSONObject)localObject).optString("appid");
      int i = 0;
      if (AppUtil.a(paramString)) {
        i = AppUtil.d(paramString);
      }
      paramString = new JSONObject();
      paramString.put("installedVersionCode", i);
      paramString.put("downloadedVersionCode ", AppUtil.e(DownloadManager.b().b((String)localObject)));
      paramString = paramString.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public String getAppVersionCodeBatch(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        if (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          if (localObject2 != null)
          {
            Object localObject1 = ((JSONObject)localObject2).getString("packageName");
            localObject2 = ((JSONObject)localObject2).getString("appid");
            if (AppUtil.a((String)localObject1))
            {
              j = AppUtil.d((String)localObject1);
              localObject1 = new JSONObject();
              ((JSONObject)localObject1).put("installedVersionCode", j);
              ((JSONObject)localObject1).put("downloadedVersionCode", AppUtil.e(DownloadManager.b().b((String)localObject2)));
              localJSONObject.put((String)localObject2, localObject1);
            }
          }
          else
          {
            i += 1;
          }
        }
        else
        {
          return localJSONObject.toString();
        }
      }
      catch (Exception paramString)
      {
        LogUtility.c("BaseJsCallBack", "getAppVersionCode ", paramString);
      }
      int j = 0;
    }
  }
  
  public String getCurrentVersion()
  {
    return CommonDataAdapter.a().g();
  }
  
  public String getDisplay()
  {
    Object localObject = new DisplayMetrics();
    this.activity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    int i = ((DisplayMetrics)localObject).widthPixels;
    int j = ((DisplayMetrics)localObject).heightPixels;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("x");
    ((StringBuilder)localObject).append(j);
    return ((StringBuilder)localObject).toString();
  }
  
  protected String[] getFileUrl(String paramString)
  {
    return Common.a(paramString);
  }
  
  public String getInterfaceName()
  {
    return "qqZoneAppList";
  }
  
  public String getMobileInfo()
  {
    return MobileInfoUtil.getMobileInfo();
  }
  
  public String getPageTimePoint()
  {
    return this.timePointParams;
  }
  
  public String getParams()
  {
    return this.urlParams;
  }
  
  public String getPlatform()
  {
    return CommonDataAdapter.a().m();
  }
  
  public String getSid()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return CommonDataAdapter.a().e();
  }
  
  public String getUin()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return String.valueOf(CommonDataAdapter.a().c());
  }
  
  public void goOldDetail(String paramString)
  {
    AppClient.a(this.activity, paramString);
  }
  
  public void goToDetailPage(String paramString1, String paramString2)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = new Bundle();
      paramString2.putString(DownloadConstants.b, paramString1.optString("appid"));
      paramString2.putString(DownloadConstants.f, paramString1.optString("packageName"));
      paramString2.putString(DownloadConstants.i, paramString1.optString("via"));
      paramString2.putString(DownloadConstants.c, paramString1.optString("myAppId"));
      paramString2.putString(DownloadConstants.d, paramString1.optString("apkId"));
      paramString2.putInt(DownloadConstants.e, paramString1.optInt("versionCode"));
      Object localObject = paramString1.optString("via");
      String str = paramString1.optString("appid");
      int i = paramString1.optInt("actionCode");
      if (this.lastActionRecord == null) {
        this.lastActionRecord = new LastDownloadAction(str, (String)localObject, i);
      } else if (this.lastActionRecord.a(str, (String)localObject, i)) {
        return;
      }
      boolean bool1 = DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoDownload"));
      boolean bool2 = DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoInstall"));
      localObject = DownloadManager.b().d(paramString1.optString("appid"));
      paramString1.put("titleType", 0);
      if (localObject == null)
      {
        if (MyAppApi.l().p())
        {
          ThreadManager.getSubThreadHandler().post(new BaseJsCallBack.2(this, paramString2, bool1, bool2));
          return;
        }
        goUrl(paramString1.optString("url"), true);
        return;
      }
      if (((DownloadInfo)localObject).o == 1)
      {
        MyAppApi.l();
        if (MyAppApi.m())
        {
          ThreadManager.getSubThreadHandler().post(new BaseJsCallBack.3(this, paramString2, bool1, bool2));
          return;
        }
      }
      goUrl(paramString1.optString("url"), true);
      return;
    }
    catch (JSONException paramString1)
    {
      LogUtility.c("BaseJsCallBack", "goToDetailPage>>>", paramString1);
    }
  }
  
  public void goToDownloadTaskList(String paramString)
  {
    LogUtility.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new JSONObject(paramString);
      localBundle.putString(DownloadConstants.i, paramString.optString("via"));
      ThreadManager.getSubThreadHandler().post(new BaseJsCallBack.4(this, localBundle));
      return;
    }
    catch (JSONException paramString)
    {
      LogUtility.c("BaseJsCallBack", "goToDetailPage>>>", paramString);
    }
  }
  
  public void goUrl(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    LogUtility.c("BaseJsCallBack", paramString);
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        Object localObject3 = paramString.optString("url");
        Object localObject1 = paramString.optJSONArray("titleInfo");
        int k = paramString.optInt("current");
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          LogUtility.e("BaseJsCallBack", "gourl strUrl == null");
          return;
        }
        int m = paramString.optInt("leftBtnType");
        int n = paramString.optInt("rightBtnType");
        int i1 = paramString.optInt("titleRefreshType");
        int i2 = paramString.optInt("titleType");
        Object localObject2 = getFileUrl((String)localObject3);
        paramString = localObject2[0];
        localObject2 = localObject2[1];
        if (!paramString.equals(localObject3)) {
          break label615;
        }
        if (paramString.indexOf("?") == -1)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append("?");
          paramString = ((StringBuilder)localObject3).toString();
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramString);
          ((StringBuilder)localObject3).append("&");
          paramString = ((StringBuilder)localObject3).toString();
        }
        if (paramString.indexOf("{UIN}") > 0)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(CommonDataAdapter.a().c());
          ((StringBuilder)localObject3).append("");
          paramString = paramString.replaceAll("\\{UIN\\}", ((StringBuilder)localObject3).toString());
          localObject3 = new Intent(this.activity, QZoneAppListActivity.class);
          Bundle localBundle = new Bundle();
          localBundle.putString("APP_URL", paramString);
          if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
            localBundle.putString("APP_PARAMS", (String)localObject2);
          }
          if (localObject1 != null)
          {
            int i = ((JSONArray)localObject1).length();
            paramString = new ArrayList();
            localObject2 = new ArrayList();
            int j = 0;
            if (j < i)
            {
              JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(j);
              paramString.add(localJSONObject.optString("name"));
              ((ArrayList)localObject2).add(localJSONObject.optString("tipNum"));
              j += 1;
              continue;
            }
            localBundle.putStringArrayList("titleName", paramString);
            localBundle.putStringArrayList("titleTip", (ArrayList)localObject2);
            if (paramString.size() <= 0) {
              break label618;
            }
            bool = true;
            localBundle.putBoolean("showTitle", bool);
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("array = ");
            ((StringBuilder)localObject1).append(paramString.toString());
            ((StringBuilder)localObject1).append(" | ");
            ((StringBuilder)localObject1).append(paramString.size());
            LogUtility.c("BaseJsCallBack", ((StringBuilder)localObject1).toString());
          }
          localBundle.putInt("leftBtnType", m);
          localBundle.putInt("rightBtnType", n);
          localBundle.putInt("titleRefreshType", i1);
          localBundle.putInt("titleType", i2);
          localBundle.putInt("current", k);
          localBundle.putString("uin", String.valueOf(CommonDataAdapter.a().c()));
          localBundle.putString("sid", CommonDataAdapter.a().e());
          localBundle.putInt("goto_type", 2);
          ((Intent)localObject3).putExtras(localBundle);
          this.activity.startActivityForResult((Intent)localObject3, 200);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      continue;
      label615:
      continue;
      label618:
      boolean bool = false;
    }
  }
  
  protected void goUrl(String paramString, boolean paramBoolean)
  {
    if (!hasRight()) {
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONArray.put(this.activity.getString(2131888413));
      localJSONObject.put("url", paramString);
      localJSONObject.put("titleName", localJSONArray);
      goUrl(localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("BaseJsCallBack", "gourl(onlyurl) error ", paramString);
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public void goWebApp(String paramString)
  {
    // Byte code:
    //   0: ldc 33
    //   2: astore 13
    //   4: aload_0
    //   5: invokevirtual 389	com/tencent/open/appcommon/js/BaseJsCallBack:hasRight	()Z
    //   8: ifne +4 -> 12
    //   11: return
    //   12: new 284	org/json/JSONObject
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 285	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   20: astore 8
    //   22: aload 8
    //   24: ldc_w 292
    //   27: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   30: astore_1
    //   31: aload 8
    //   33: ldc_w 627
    //   36: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   39: astore 7
    //   41: aload 8
    //   43: ldc_w 629
    //   46: invokevirtual 440	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   49: istore_2
    //   50: aload 8
    //   52: ldc_w 631
    //   55: invokevirtual 440	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   58: istore_3
    //   59: aload 8
    //   61: ldc_w 633
    //   64: invokevirtual 440	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   67: istore 4
    //   69: aload 8
    //   71: ldc_w 635
    //   74: invokevirtual 440	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   77: istore 5
    //   79: aload 8
    //   81: ldc_w 637
    //   84: invokevirtual 440	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   87: istore 6
    //   89: aload 8
    //   91: ldc_w 639
    //   94: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 9
    //   99: aload 8
    //   101: ldc_w 641
    //   104: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: astore 10
    //   109: aload 8
    //   111: ldc_w 643
    //   114: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   117: astore 8
    //   119: aload 8
    //   121: astore 13
    //   123: aload_1
    //   124: astore 8
    //   126: aload 7
    //   128: astore 12
    //   130: aload 9
    //   132: astore 7
    //   134: aload 10
    //   136: astore_1
    //   137: goto +456 -> 593
    //   140: astore 8
    //   142: aload_1
    //   143: astore 12
    //   145: aload 7
    //   147: astore 11
    //   149: aload 9
    //   151: astore 7
    //   153: aload 10
    //   155: astore_1
    //   156: goto +339 -> 495
    //   159: astore 8
    //   161: aload_1
    //   162: astore 11
    //   164: aload 7
    //   166: astore 12
    //   168: aload 9
    //   170: astore 7
    //   172: aload 10
    //   174: astore_1
    //   175: goto +399 -> 574
    //   178: astore 8
    //   180: ldc 33
    //   182: astore 10
    //   184: aload_1
    //   185: astore 12
    //   187: aload 7
    //   189: astore 11
    //   191: aload 9
    //   193: astore 7
    //   195: aload 10
    //   197: astore_1
    //   198: goto +297 -> 495
    //   201: astore 8
    //   203: ldc 33
    //   205: astore 10
    //   207: aload_1
    //   208: astore 11
    //   210: aload 7
    //   212: astore 12
    //   214: aload 9
    //   216: astore 7
    //   218: aload 10
    //   220: astore_1
    //   221: goto +353 -> 574
    //   224: astore 8
    //   226: ldc 33
    //   228: astore 10
    //   230: aload 10
    //   232: astore 9
    //   234: aload_1
    //   235: astore 12
    //   237: aload 7
    //   239: astore 11
    //   241: aload 10
    //   243: astore 7
    //   245: aload 9
    //   247: astore_1
    //   248: goto +247 -> 495
    //   251: astore 8
    //   253: ldc 33
    //   255: astore 10
    //   257: aload 10
    //   259: astore 9
    //   261: aload_1
    //   262: astore 11
    //   264: aload 7
    //   266: astore 12
    //   268: aload 10
    //   270: astore 7
    //   272: aload 9
    //   274: astore_1
    //   275: goto +299 -> 574
    //   278: astore 8
    //   280: ldc 33
    //   282: astore 10
    //   284: aload 10
    //   286: astore 9
    //   288: aload_1
    //   289: astore 12
    //   291: aload 7
    //   293: astore 11
    //   295: goto +190 -> 485
    //   298: astore 8
    //   300: ldc 33
    //   302: astore 10
    //   304: aload 10
    //   306: astore 9
    //   308: aload_1
    //   309: astore 11
    //   311: aload 7
    //   313: astore 12
    //   315: goto +249 -> 564
    //   318: astore 8
    //   320: ldc 33
    //   322: astore 10
    //   324: aload 10
    //   326: astore 11
    //   328: goto +143 -> 471
    //   331: astore 8
    //   333: ldc 33
    //   335: astore 10
    //   337: aload 10
    //   339: astore 11
    //   341: goto +209 -> 550
    //   344: astore 8
    //   346: ldc 33
    //   348: astore 10
    //   350: aload 10
    //   352: astore 11
    //   354: goto +114 -> 468
    //   357: astore 8
    //   359: ldc 33
    //   361: astore 10
    //   363: aload 10
    //   365: astore 11
    //   367: goto +180 -> 547
    //   370: astore 8
    //   372: ldc 33
    //   374: astore 10
    //   376: aload 10
    //   378: astore 11
    //   380: goto +86 -> 466
    //   383: astore 8
    //   385: ldc 33
    //   387: astore 10
    //   389: aload 10
    //   391: astore 11
    //   393: goto +152 -> 545
    //   396: astore 8
    //   398: ldc 33
    //   400: astore 10
    //   402: aload_1
    //   403: astore 9
    //   405: aload 10
    //   407: astore_1
    //   408: goto +47 -> 455
    //   411: astore 8
    //   413: ldc 33
    //   415: astore 10
    //   417: aload_1
    //   418: astore 9
    //   420: aload 10
    //   422: astore_1
    //   423: goto +111 -> 534
    //   426: astore 8
    //   428: aload_1
    //   429: astore 9
    //   431: goto +17 -> 448
    //   434: astore 8
    //   436: aload_1
    //   437: astore 9
    //   439: goto +88 -> 527
    //   442: astore 8
    //   444: ldc 33
    //   446: astore 9
    //   448: ldc 33
    //   450: astore 7
    //   452: ldc 33
    //   454: astore_1
    //   455: aload_1
    //   456: astore 11
    //   458: iconst_0
    //   459: istore_2
    //   460: aload_1
    //   461: astore 10
    //   463: aload 9
    //   465: astore_1
    //   466: iconst_0
    //   467: istore_3
    //   468: iconst_0
    //   469: istore 4
    //   471: iconst_0
    //   472: istore 5
    //   474: aload 11
    //   476: astore 9
    //   478: aload 7
    //   480: astore 11
    //   482: aload_1
    //   483: astore 12
    //   485: iconst_0
    //   486: istore 6
    //   488: aload 9
    //   490: astore_1
    //   491: aload 10
    //   493: astore 7
    //   495: aload 8
    //   497: invokevirtual 204	java/lang/Exception:printStackTrace	()V
    //   500: ldc 8
    //   502: ldc_w 645
    //   505: aload 8
    //   507: invokestatic 276	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   510: aload 12
    //   512: astore 8
    //   514: aload 11
    //   516: astore 12
    //   518: goto +75 -> 593
    //   521: astore 8
    //   523: ldc 33
    //   525: astore 9
    //   527: ldc 33
    //   529: astore 7
    //   531: ldc 33
    //   533: astore_1
    //   534: aload_1
    //   535: astore 11
    //   537: iconst_0
    //   538: istore_2
    //   539: aload_1
    //   540: astore 10
    //   542: aload 9
    //   544: astore_1
    //   545: iconst_0
    //   546: istore_3
    //   547: iconst_0
    //   548: istore 4
    //   550: iconst_0
    //   551: istore 5
    //   553: aload 11
    //   555: astore 9
    //   557: aload 7
    //   559: astore 12
    //   561: aload_1
    //   562: astore 11
    //   564: iconst_0
    //   565: istore 6
    //   567: aload 9
    //   569: astore_1
    //   570: aload 10
    //   572: astore 7
    //   574: aload 8
    //   576: invokevirtual 611	org/json/JSONException:printStackTrace	()V
    //   579: ldc 8
    //   581: ldc_w 647
    //   584: aload 8
    //   586: invokestatic 276	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   589: aload 11
    //   591: astore 8
    //   593: new 117	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   600: astore 9
    //   602: aload 9
    //   604: ldc_w 649
    //   607: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: pop
    //   611: aload 9
    //   613: aload 12
    //   615: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 9
    //   621: ldc_w 596
    //   624: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: pop
    //   628: aload 9
    //   630: iload_2
    //   631: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: aload 9
    //   637: ldc_w 596
    //   640: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 9
    //   646: iload 4
    //   648: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   651: pop
    //   652: aload 9
    //   654: ldc_w 596
    //   657: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: pop
    //   661: aload 9
    //   663: iload_3
    //   664: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 9
    //   670: ldc_w 596
    //   673: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 9
    //   679: iload 5
    //   681: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: pop
    //   685: aload 9
    //   687: ldc_w 596
    //   690: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: pop
    //   694: aload 9
    //   696: aload 7
    //   698: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: pop
    //   702: aload 9
    //   704: ldc_w 596
    //   707: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: pop
    //   711: aload 9
    //   713: aload_1
    //   714: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: pop
    //   718: aload 9
    //   720: ldc_w 596
    //   723: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: aload 9
    //   729: iload 6
    //   731: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 9
    //   737: ldc_w 596
    //   740: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 9
    //   746: aload 8
    //   748: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload 9
    //   754: ldc_w 596
    //   757: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload 9
    //   763: aload 13
    //   765: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload 9
    //   771: ldc_w 596
    //   774: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: pop
    //   778: aload 9
    //   780: iconst_0
    //   781: invokevirtual 366	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   784: pop
    //   785: ldc 8
    //   787: aload 9
    //   789: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 166	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   795: new 553	android/content/Intent
    //   798: dup
    //   799: aload_0
    //   800: getfield 47	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   803: ldc_w 555
    //   806: invokespecial 558	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   809: astore 9
    //   811: new 409	android/os/Bundle
    //   814: dup
    //   815: invokespecial 410	android/os/Bundle:<init>	()V
    //   818: astore 10
    //   820: aload 10
    //   822: ldc_w 494
    //   825: aload 12
    //   827: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload 10
    //   832: ldc_w 629
    //   835: iload_2
    //   836: invokevirtual 444	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   839: aload 10
    //   841: ldc_w 633
    //   844: iload 4
    //   846: invokevirtual 444	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   849: aload 10
    //   851: ldc_w 631
    //   854: iload_3
    //   855: invokevirtual 444	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   858: aload 10
    //   860: ldc_w 635
    //   863: iload 5
    //   865: invokevirtual 444	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   868: aload 10
    //   870: ldc_w 639
    //   873: aload 7
    //   875: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   878: aload 10
    //   880: ldc_w 641
    //   883: aload_1
    //   884: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   887: aload 10
    //   889: ldc_w 637
    //   892: iload 6
    //   894: invokevirtual 444	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   897: aload 10
    //   899: ldc_w 651
    //   902: aload 8
    //   904: invokevirtual 417	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   907: aload 10
    //   909: ldc_w 602
    //   912: iconst_5
    //   913: invokevirtual 444	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   916: aload 9
    //   918: aload 10
    //   920: invokevirtual 606	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   923: pop
    //   924: aload_0
    //   925: getfield 47	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   928: aload 9
    //   930: invokevirtual 655	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   933: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	934	0	this	BaseJsCallBack
    //   0	934	1	paramString	String
    //   49	787	2	i	int
    //   58	797	3	j	int
    //   67	778	4	k	int
    //   77	787	5	m	int
    //   87	806	6	n	int
    //   39	835	7	localObject1	Object
    //   20	105	8	localObject2	Object
    //   140	1	8	localException1	Exception
    //   159	1	8	localJSONException1	JSONException
    //   178	1	8	localException2	Exception
    //   201	1	8	localJSONException2	JSONException
    //   224	1	8	localException3	Exception
    //   251	1	8	localJSONException3	JSONException
    //   278	1	8	localException4	Exception
    //   298	1	8	localJSONException4	JSONException
    //   318	1	8	localException5	Exception
    //   331	1	8	localJSONException5	JSONException
    //   344	1	8	localException6	Exception
    //   357	1	8	localJSONException6	JSONException
    //   370	1	8	localException7	Exception
    //   383	1	8	localJSONException7	JSONException
    //   396	1	8	localException8	Exception
    //   411	1	8	localJSONException8	JSONException
    //   426	1	8	localException9	Exception
    //   434	1	8	localJSONException9	JSONException
    //   442	64	8	localException10	Exception
    //   512	1	8	localObject3	Object
    //   521	64	8	localJSONException10	JSONException
    //   591	312	8	localObject4	Object
    //   97	832	9	localObject5	Object
    //   107	812	10	localObject6	Object
    //   147	443	11	localObject7	Object
    //   128	698	12	localObject8	Object
    //   2	762	13	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   109	119	140	java/lang/Exception
    //   109	119	159	org/json/JSONException
    //   99	109	178	java/lang/Exception
    //   99	109	201	org/json/JSONException
    //   89	99	224	java/lang/Exception
    //   89	99	251	org/json/JSONException
    //   79	89	278	java/lang/Exception
    //   79	89	298	org/json/JSONException
    //   69	79	318	java/lang/Exception
    //   69	79	331	org/json/JSONException
    //   59	69	344	java/lang/Exception
    //   59	69	357	org/json/JSONException
    //   50	59	370	java/lang/Exception
    //   50	59	383	org/json/JSONException
    //   41	50	396	java/lang/Exception
    //   41	50	411	org/json/JSONException
    //   31	41	426	java/lang/Exception
    //   31	41	434	org/json/JSONException
    //   12	31	442	java/lang/Exception
    //   12	31	521	org/json/JSONException
  }
  
  public void onJsAlert(String paramString)
  {
    new AlertDialog.Builder(this.activity).setTitle("javaScript dialog").setMessage(paramString).setPositiveButton(17039370, new BaseJsCallBack.1(this)).setCancelable(false).create().show();
  }
  
  public void report(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[report] json=");
    localStringBuilder.append(paramString);
    LogUtility.b("BaseJsCallBack", localStringBuilder.toString());
    try
    {
      paramString = new JSONObject(paramString);
      AppCenterReporter.a(paramString.optInt("type"), paramString.optString("data"));
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportBatch(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[reportBatch] json=");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.b("BaseJsCallBack", ((StringBuilder)localObject).toString());
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        localObject = paramString.optJSONObject(i);
        if (localObject != null) {
          AppCenterReporter.a(((JSONObject)localObject).optInt("type"), ((JSONObject)localObject).optString("data"));
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportForVia(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject2 = new JSONObject(paramString);
      paramString = ((JSONObject)localObject2).optString("actionType");
      String str1 = ((JSONObject)localObject2).optString("via");
      String str2 = ((JSONObject)localObject2).optString("appid");
      Object localObject1 = ((JSONObject)localObject2).optString("jsversion");
      localObject2 = ((JSONObject)localObject2).optString("extraData");
      Bundle localBundle = new Bundle();
      localBundle.putString("jsversion", (String)localObject1);
      StaticAnalyz.a(paramString, str1, str2, (String)localObject2, localBundle);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("reportForvia ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(" | ");
      ((StringBuilder)localObject1).append(str2);
      LogUtility.c("BaseJsCallBack", ((StringBuilder)localObject1).toString());
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportForViaBatch(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        Object localObject2 = paramString.optJSONObject(i);
        if (localObject2 != null)
        {
          String str1 = ((JSONObject)localObject2).optString("actionType");
          String str2 = ((JSONObject)localObject2).optString("via");
          String str3 = ((JSONObject)localObject2).optString("appid");
          Object localObject1 = ((JSONObject)localObject2).optString("jsversion");
          localObject2 = ((JSONObject)localObject2).optString("extraData");
          Bundle localBundle = new Bundle();
          localBundle.putString("jsversion", (String)localObject1);
          StaticAnalyz.a(str1, str2, str3, (String)localObject2, localBundle);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reportForvia ");
          ((StringBuilder)localObject1).append(str1);
          ((StringBuilder)localObject1).append(" | ");
          ((StringBuilder)localObject1).append(str2);
          ((StringBuilder)localObject1).append(" | ");
          ((StringBuilder)localObject1).append(str3);
          LogUtility.c("BaseJsCallBack", ((StringBuilder)localObject1).toString());
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void reportPV(String paramString1, String paramString2)
  {
    if (isUpdateAssets == true)
    {
      isUpdateAssets = false;
      return;
    }
    if (AppUtil.a(paramString1))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.INSTALLED.APPDETAIL", paramString2);
      return;
    }
    if (DownloadManager.b().k(paramString2))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.UNINSTALL.APPDETAIL", paramString2);
      return;
    }
    StaticAnalyz.a("100", "ANDROIDQQ.UNDOWNLOAD.APPDETAIL", paramString2);
  }
  
  public void setActionButton(String paramString)
  {
    this.mHandler.post(new BaseJsCallBack.5(this, paramString));
  }
  
  public void setAllowCallBackEvent(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (!hasRight()) {
        return;
      }
      if (i == 0)
      {
        CallBackEvent.a().a(false);
        return;
      }
      CallBackEvent.a().a(true);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean setCommonReportData(String paramString)
  {
    LogUtility.c("BaseJsCallBack", "JsCallBack--setCommonReportData");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        CommonDataAdapter.a().c(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        LogUtility.c("BaseJsCallBack", "JsCallBack--setCommonReportData Exception", paramString);
      }
    }
    return false;
  }
  
  public void setParams(String paramString)
  {
    this.urlParams = paramString;
  }
  
  public void showToast(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    Activity localActivity = this.activity;
    if ((localActivity != null) && (!localActivity.isFinishing())) {
      ToastUtil.a().a(paramString, 1);
    }
  }
  
  public void startApp(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      if (!appIsExists(paramString1)) {
        break label66;
      }
      paramString2 = DownloadInterface.getSourceInfoFromActivity(this.activity);
      AppUtil.b(this.activity, paramString1, paramString2);
      return;
    }
    catch (Exception paramString2)
    {
      label34:
      break label34;
    }
    paramString2 = new StringBuilder();
    paramString2.append("apk not exist packName = ");
    paramString2.append(paramString1);
    LogUtility.e("startApp", paramString2.toString());
    label66:
  }
  
  public void startApp(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (appIsExists(paramString1))
      {
        paramString3 = this.activity.getPackageManager().getLaunchIntentForPackage(paramString1);
        paramString2 = paramString3;
        if (paramString3 == null)
        {
          paramString2 = new Intent(paramString1);
          paramString2.addCategory("android.intent.category.DEFAULT");
        }
        paramString2.putExtra("platformId", "qzone_m");
        paramString2.putExtra("big_brother_source_key", DownloadInterface.getSourceInfoFromActivity(this.activity));
        LogUtility.c("add", ">>has add platformid=qzone_m");
      }
    }
    catch (Exception paramString2)
    {
      label87:
      label101:
      break label101;
    }
    try
    {
      this.activity.startActivity(paramString2);
      return;
    }
    catch (Exception paramString2)
    {
      break label87;
    }
    ToastUtil.a().a(HardCodeUtil.a(2131899235), 0);
    return;
    paramString2 = new StringBuilder();
    paramString2.append("apk not exist packName = ");
    paramString2.append(paramString1);
    LogUtility.e("startApp", paramString2.toString());
  }
  
  public void startAppWithData(String paramString1, String paramString2)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      if (!appIsExists(paramString1)) {
        break label66;
      }
      paramString2 = DownloadInterface.getSourceInfoFromActivity(this.activity);
      AppUtil.b(this.activity, paramString1, paramString2);
      return;
    }
    catch (Exception paramString2)
    {
      label34:
      break label34;
    }
    paramString2 = new StringBuilder();
    paramString2.append("apk not exist packName = ");
    paramString2.append(paramString1);
    LogUtility.e("startApp", paramString2.toString());
    label66:
  }
  
  public void startOpenApp(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      if (appIsExists(paramString1))
      {
        paramString2 = DownloadInterface.getSourceInfoFromActivity(this.activity);
        AppUtil.b(this.activity, paramString1, paramString2);
      }
      return;
    }
    catch (Exception paramString1) {}
  }
  
  public void startOpenApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      paramString2 = new StringBuilder();
      paramString2.append("start App：");
      paramString2.append(paramString1);
      paramString2.append(",");
      paramString2.append(paramString3);
      paramString2.append(",");
      paramString2.append(paramString4);
      LogUtility.b("BaseJsCallBack", paramString2.toString());
      boolean bool = appIsExists(paramString1);
      if (!bool) {}
    }
    catch (Exception paramString1)
    {
      label84:
      paramString2 = new StringBuilder();
      paramString2.append("try start app:");
      paramString2.append(paramString1.getMessage());
      LogUtility.e("BaseJsCallBack", paramString2.toString());
    }
    try
    {
      paramString2 = URLDecoder.decode(paramString5, "UTF-8");
      paramString5 = paramString2;
    }
    catch (Exception paramString2)
    {
      break label84;
    }
    AppUtil.b(this.activity, paramString3, paramString1, paramString5);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack
 * JD-Core Version:    0.7.0.1
 */