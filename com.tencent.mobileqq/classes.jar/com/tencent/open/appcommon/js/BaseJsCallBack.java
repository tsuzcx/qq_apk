package com.tencent.open.appcommon.js;

import amtj;
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
import bhpc;
import bhwo;
import bhwp;
import bhwr;
import bhxa;
import bhxj;
import bhzd;
import bhzm;
import bhzt;
import biam;
import biaq;
import bias;
import biaz;
import bibw;
import biby;
import bicl;
import bkmn;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.applist.QZoneAppListActivity;
import com.tencent.open.downloadnew.DownloadInfo;
import cooperation.plugin.PluginBaseActivity;
import cooperation.qappcenter.remote.SendMsg;
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
  public static boolean isUpdateAssets;
  protected Activity activity;
  bhxj lastActionRecord = null;
  protected Handler mHandler;
  private bkmn mRemoteServiceProxy;
  public String timePointParams = "";
  protected String urlParams = "";
  
  public BaseJsCallBack(Activity paramActivity)
  {
    if ((paramActivity instanceof PluginBaseActivity)) {}
    for (this.activity = ((PluginBaseActivity)paramActivity).getOutActivity();; this.activity = paramActivity)
    {
      this.mHandler = new Handler(Looper.getMainLooper());
      this.mRemoteServiceProxy = bkmn.a(String.valueOf(bhpc.a().a()));
      return;
    }
  }
  
  public boolean appIsExists(String paramString)
  {
    return biam.a(paramString);
  }
  
  public String appIsExistsBatch(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return "";
    }
    Object localObject = paramString1.split(paramString2);
    if (localObject.length == 0) {
      return "";
    }
    paramString1 = new LinkedHashMap();
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      if ((str != null) && (str.length() > 0))
      {
        if (!biam.a(str)) {
          break label98;
        }
        paramString1.put(str, Integer.valueOf(1));
      }
      for (;;)
      {
        i += 1;
        break;
        label98:
        paramString1.put(str, Integer.valueOf(0));
      }
    }
    localObject = new StringBuilder();
    paramString1 = paramString1.entrySet().iterator();
    while (paramString1.hasNext()) {
      ((StringBuilder)localObject).append(((Map.Entry)paramString1.next()).getValue()).append(paramString2);
    }
    if (((StringBuilder)localObject).length() == 0) {
      return "";
    }
    bhzm.c("BaseJsCallBack", "appIsExistsBatch >>>" + ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1));
    return ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).length() - 1);
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
      biaz.a().a(paramString1, SystemClock.elapsedRealtime() - l, 0L, 0L, i, bhpc.a().a(), "1000002", null);
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
    bhzm.e("BaseJsCallBack", "clearJS");
    if (this.mRemoteServiceProxy != null)
    {
      SendMsg localSendMsg = new SendMsg("clearJS");
      this.mRemoteServiceProxy.b(localSendMsg);
    }
  }
  
  public int getAPNType()
  {
    int k = -1;
    Object localObject = (ConnectivityManager)this.activity.getSystemService("connectivity");
    if (localObject == null) {}
    do
    {
      return -1;
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    } while (localObject == null);
    i = k;
    for (;;)
    {
      try
      {
        j = ((NetworkInfo)localObject).getType();
        if (j != 0) {
          continue;
        }
        j = k;
        i = k;
        if (((NetworkInfo)localObject).getExtraInfo() == null) {
          j = 2;
        }
        i = j;
        boolean bool = ((NetworkInfo)localObject).getExtraInfo().toLowerCase(Locale.ENGLISH).equals("cmnet");
        if (!bool) {
          continue;
        }
        i = 3;
      }
      catch (Exception localException)
      {
        int j;
        bhzm.c("BaseJsCallBack", "getAPNType EX >>> ", localException);
        continue;
        i = -1;
        continue;
      }
      return i;
      i = 2;
      continue;
      if (j != 1) {
        continue;
      }
      i = 1;
    }
  }
  
  public String getAgentVersion()
  {
    return bhpc.a().e();
  }
  
  public String getAppVersionCode(String paramString)
  {
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("packageName");
      localObject = ((JSONObject)localObject).optString("appid");
      int i = 0;
      if (biam.a(paramString)) {
        i = biam.a(paramString);
      }
      paramString = new JSONObject();
      paramString.put("installedVersionCode", i);
      paramString.put("downloadedVersionCode ", biam.b(biby.a().a((String)localObject)));
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
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i < paramString.length())
        {
          Object localObject2 = paramString.optJSONObject(i);
          if (localObject2 == null) {
            break label150;
          }
          Object localObject1 = ((JSONObject)localObject2).getString("packageName");
          localObject2 = ((JSONObject)localObject2).getString("appid");
          if (!biam.a((String)localObject1)) {
            break label145;
          }
          j = biam.a((String)localObject1);
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("installedVersionCode", j);
          ((JSONObject)localObject1).put("downloadedVersionCode", biam.b(biby.a().a((String)localObject2)));
          localJSONObject.put((String)localObject2, localObject1);
        }
      }
      catch (Exception paramString)
      {
        bhzm.c("BaseJsCallBack", "getAppVersionCode ", paramString);
      }
      return localJSONObject.toString();
      label145:
      int j = 0;
      continue;
      label150:
      i += 1;
    }
  }
  
  public String getCurrentVersion()
  {
    return bhpc.a().c();
  }
  
  public String getDisplay()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.activity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    return i + "x" + j;
  }
  
  protected String[] getFileUrl(String paramString)
  {
    return bhwr.a(paramString);
  }
  
  public String getInterfaceName()
  {
    return "qqZoneAppList";
  }
  
  public String getMobileInfo()
  {
    return biaq.i();
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
    return bhpc.a().g();
  }
  
  public String getSid()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return bhpc.a().a();
  }
  
  public String getUin()
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return String.valueOf(bhpc.a().a());
  }
  
  public void goOldDetail(String paramString)
  {
    bhwo.a(this.activity, paramString);
  }
  
  public void goToDetailPage(String paramString1, String paramString2)
  {
    bhzm.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    Object localObject;
    boolean bool1;
    boolean bool2;
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = new Bundle();
      paramString2.putString(bibw.b, paramString1.optString("appid"));
      paramString2.putString(bibw.f, paramString1.optString("packageName"));
      paramString2.putString(bibw.i, paramString1.optString("via"));
      paramString2.putString(bibw.c, paramString1.optString("myAppId"));
      paramString2.putString(bibw.d, paramString1.optString("apkId"));
      paramString2.putInt(bibw.e, paramString1.optInt("versionCode"));
      localObject = paramString1.optString("via");
      String str = paramString1.optString("appid");
      int i = paramString1.optInt("actionCode");
      if (this.lastActionRecord == null) {
        this.lastActionRecord = new bhxj(str, (String)localObject, i);
      }
      while (!this.lastActionRecord.a(str, (String)localObject, i))
      {
        bool1 = DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoDownload"));
        bool2 = DownloadInterface.changeIntToBoolean(paramString1.optInt("isAutoInstall"));
        localObject = biby.a().a(paramString1.optString("appid"));
        paramString1.put("titleType", 0);
        if (localObject != null) {
          break label282;
        }
        if (!bicl.a().c()) {
          break;
        }
        ThreadManager.getSubThreadHandler().post(new BaseJsCallBack.2(this, paramString2, bool1, bool2));
        return;
      }
      return;
      goUrl(paramString1.optString("url"), true);
      return;
    }
    catch (JSONException paramString1)
    {
      bhzm.c("BaseJsCallBack", "goToDetailPage>>>", paramString1);
      return;
    }
    label282:
    if ((((DownloadInfo)localObject).c == 1) && (bicl.a().b()))
    {
      ThreadManager.getSubThreadHandler().post(new BaseJsCallBack.3(this, paramString2, bool1, bool2));
      return;
    }
    goUrl(paramString1.optString("url"), true);
  }
  
  public void goToDownloadTaskList(String paramString)
  {
    bhzm.c("TIME-STATISTIC", "JsCallBack--goToDetailPage");
    Bundle localBundle = new Bundle();
    try
    {
      paramString = new JSONObject(paramString);
      localBundle.putString(bibw.i, paramString.optString("via"));
      ThreadManager.getSubThreadHandler().post(new BaseJsCallBack.4(this, localBundle));
      return;
    }
    catch (JSONException paramString)
    {
      bhzm.c("BaseJsCallBack", "goToDetailPage>>>", paramString);
    }
  }
  
  public void goUrl(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bhzm.c("BaseJsCallBack", paramString);
    Object localObject3;
    JSONArray localJSONArray;
    int j;
    try
    {
      paramString = new JSONObject(paramString);
      localObject3 = paramString.optString("url");
      localJSONArray = paramString.optJSONArray("titleInfo");
      j = paramString.optInt("current");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        bhzm.e("BaseJsCallBack", "gourl strUrl == null");
        return;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
      return;
    }
    int k = paramString.optInt("leftBtnType");
    int m = paramString.optInt("rightBtnType");
    int n = paramString.optInt("titleRefreshType");
    int i1 = paramString.optInt("titleType");
    paramString = getFileUrl((String)localObject3);
    Object localObject1 = paramString[0];
    Object localObject2 = paramString[1];
    paramString = (String)localObject1;
    if (((String)localObject1).equals(localObject3)) {
      if (((String)localObject1).indexOf("?") != -1) {
        break label356;
      }
    }
    label356:
    for (localObject1 = (String)localObject1 + "?";; localObject1 = (String)localObject1 + "&")
    {
      paramString = (String)localObject1;
      if (((String)localObject1).indexOf("{UIN}") > 0) {
        paramString = ((String)localObject1).replaceAll("\\{UIN\\}", bhpc.a().a() + "");
      }
      localObject1 = new Intent(this.activity, QZoneAppListActivity.class);
      localObject3 = new Bundle();
      ((Bundle)localObject3).putString("APP_URL", paramString);
      if ((localObject2 != null) && (((String)localObject2).length() > 0)) {
        ((Bundle)localObject3).putString("APP_PARAMS", (String)localObject2);
      }
      if (localJSONArray == null) {
        break label462;
      }
      int i2 = localJSONArray.length();
      paramString = new ArrayList();
      localObject2 = new ArrayList();
      int i = 0;
      while (i < i2)
      {
        JSONObject localJSONObject = localJSONArray.getJSONObject(i);
        paramString.add(localJSONObject.optString("name"));
        ((ArrayList)localObject2).add(localJSONObject.optString("tipNum"));
        i += 1;
      }
    }
    ((Bundle)localObject3).putStringArrayList("titleName", paramString);
    ((Bundle)localObject3).putStringArrayList("titleTip", (ArrayList)localObject2);
    if (paramString.size() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((Bundle)localObject3).putBoolean("showTitle", bool);
      bhzm.c("BaseJsCallBack", "array = " + paramString.toString() + " | " + paramString.size());
      label462:
      ((Bundle)localObject3).putInt("leftBtnType", k);
      ((Bundle)localObject3).putInt("rightBtnType", m);
      ((Bundle)localObject3).putInt("titleRefreshType", n);
      ((Bundle)localObject3).putInt("titleType", i1);
      ((Bundle)localObject3).putInt("current", j);
      ((Bundle)localObject3).putString("uin", String.valueOf(bhpc.a().a()));
      ((Bundle)localObject3).putString("sid", bhpc.a().a());
      ((Bundle)localObject3).putInt("goto_type", 2);
      ((Intent)localObject1).putExtras((Bundle)localObject3);
      this.activity.startActivityForResult((Intent)localObject1, 200);
      return;
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
      localJSONArray.put(this.activity.getString(2131691339));
      localJSONObject.put("url", paramString);
      localJSONObject.put("titleName", localJSONArray);
      goUrl(localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      bhzm.c("BaseJsCallBack", "gourl(onlyurl) error ", paramString);
    }
  }
  
  /* Error */
  @java.lang.Deprecated
  public void goWebApp(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 385	com/tencent/open/appcommon/js/BaseJsCallBack:hasRight	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: ldc 30
    //   10: astore 22
    //   12: iconst_0
    //   13: istore 21
    //   15: iconst_0
    //   16: istore_2
    //   17: iconst_0
    //   18: istore 20
    //   20: iconst_0
    //   21: istore_3
    //   22: iconst_0
    //   23: istore 19
    //   25: iconst_0
    //   26: istore 4
    //   28: iconst_0
    //   29: istore 18
    //   31: iconst_0
    //   32: istore 5
    //   34: iconst_0
    //   35: istore 17
    //   37: iconst_0
    //   38: istore 6
    //   40: ldc 30
    //   42: astore 30
    //   44: ldc 30
    //   46: astore 23
    //   48: ldc 30
    //   50: astore 31
    //   52: aload 23
    //   54: astore 24
    //   56: aload 30
    //   58: astore 26
    //   60: iload 6
    //   62: istore 7
    //   64: iload 5
    //   66: istore 9
    //   68: iload 4
    //   70: istore 11
    //   72: iload_3
    //   73: istore 13
    //   75: iload_2
    //   76: istore 15
    //   78: aload 22
    //   80: astore 28
    //   82: aload 23
    //   84: astore 25
    //   86: aload 30
    //   88: astore 27
    //   90: iload 17
    //   92: istore 8
    //   94: iload 18
    //   96: istore 10
    //   98: iload 19
    //   100: istore 12
    //   102: iload 20
    //   104: istore 14
    //   106: iload 21
    //   108: istore 16
    //   110: aload 22
    //   112: astore 29
    //   114: new 281	org/json/JSONObject
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 282	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   122: astore 32
    //   124: aload 23
    //   126: astore 24
    //   128: aload 30
    //   130: astore 26
    //   132: iload 6
    //   134: istore 7
    //   136: iload 5
    //   138: istore 9
    //   140: iload 4
    //   142: istore 11
    //   144: iload_3
    //   145: istore 13
    //   147: iload_2
    //   148: istore 15
    //   150: aload 22
    //   152: astore 28
    //   154: aload 23
    //   156: astore 25
    //   158: aload 30
    //   160: astore 27
    //   162: iload 17
    //   164: istore 8
    //   166: iload 18
    //   168: istore 10
    //   170: iload 19
    //   172: istore 12
    //   174: iload 20
    //   176: istore 14
    //   178: iload 21
    //   180: istore 16
    //   182: aload 22
    //   184: astore 29
    //   186: aload 32
    //   188: ldc_w 289
    //   191: invokevirtual 287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   194: astore_1
    //   195: aload 23
    //   197: astore 24
    //   199: aload_1
    //   200: astore 26
    //   202: iload 6
    //   204: istore 7
    //   206: iload 5
    //   208: istore 9
    //   210: iload 4
    //   212: istore 11
    //   214: iload_3
    //   215: istore 13
    //   217: iload_2
    //   218: istore 15
    //   220: aload 22
    //   222: astore 28
    //   224: aload 23
    //   226: astore 25
    //   228: aload_1
    //   229: astore 27
    //   231: iload 17
    //   233: istore 8
    //   235: iload 18
    //   237: istore 10
    //   239: iload 19
    //   241: istore 12
    //   243: iload 20
    //   245: istore 14
    //   247: iload 21
    //   249: istore 16
    //   251: aload 22
    //   253: astore 29
    //   255: aload 32
    //   257: ldc_w 620
    //   260: invokevirtual 287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 22
    //   265: aload 23
    //   267: astore 24
    //   269: aload_1
    //   270: astore 26
    //   272: iload 6
    //   274: istore 7
    //   276: iload 5
    //   278: istore 9
    //   280: iload 4
    //   282: istore 11
    //   284: iload_3
    //   285: istore 13
    //   287: iload_2
    //   288: istore 15
    //   290: aload 22
    //   292: astore 28
    //   294: aload 23
    //   296: astore 25
    //   298: aload_1
    //   299: astore 27
    //   301: iload 17
    //   303: istore 8
    //   305: iload 18
    //   307: istore 10
    //   309: iload 19
    //   311: istore 12
    //   313: iload 20
    //   315: istore 14
    //   317: iload 21
    //   319: istore 16
    //   321: aload 22
    //   323: astore 29
    //   325: aload 32
    //   327: ldc_w 622
    //   330: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   333: istore_2
    //   334: aload 23
    //   336: astore 24
    //   338: aload_1
    //   339: astore 26
    //   341: iload 6
    //   343: istore 7
    //   345: iload 5
    //   347: istore 9
    //   349: iload 4
    //   351: istore 11
    //   353: iload_3
    //   354: istore 13
    //   356: iload_2
    //   357: istore 15
    //   359: aload 22
    //   361: astore 28
    //   363: aload 23
    //   365: astore 25
    //   367: aload_1
    //   368: astore 27
    //   370: iload 17
    //   372: istore 8
    //   374: iload 18
    //   376: istore 10
    //   378: iload 19
    //   380: istore 12
    //   382: iload 20
    //   384: istore 14
    //   386: iload_2
    //   387: istore 16
    //   389: aload 22
    //   391: astore 29
    //   393: aload 32
    //   395: ldc_w 624
    //   398: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   401: istore_3
    //   402: aload 23
    //   404: astore 24
    //   406: aload_1
    //   407: astore 26
    //   409: iload 6
    //   411: istore 7
    //   413: iload 5
    //   415: istore 9
    //   417: iload 4
    //   419: istore 11
    //   421: iload_3
    //   422: istore 13
    //   424: iload_2
    //   425: istore 15
    //   427: aload 22
    //   429: astore 28
    //   431: aload 23
    //   433: astore 25
    //   435: aload_1
    //   436: astore 27
    //   438: iload 17
    //   440: istore 8
    //   442: iload 18
    //   444: istore 10
    //   446: iload 19
    //   448: istore 12
    //   450: iload_3
    //   451: istore 14
    //   453: iload_2
    //   454: istore 16
    //   456: aload 22
    //   458: astore 29
    //   460: aload 32
    //   462: ldc_w 626
    //   465: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   468: istore 4
    //   470: aload 23
    //   472: astore 24
    //   474: aload_1
    //   475: astore 26
    //   477: iload 6
    //   479: istore 7
    //   481: iload 5
    //   483: istore 9
    //   485: iload 4
    //   487: istore 11
    //   489: iload_3
    //   490: istore 13
    //   492: iload_2
    //   493: istore 15
    //   495: aload 22
    //   497: astore 28
    //   499: aload 23
    //   501: astore 25
    //   503: aload_1
    //   504: astore 27
    //   506: iload 17
    //   508: istore 8
    //   510: iload 18
    //   512: istore 10
    //   514: iload 4
    //   516: istore 12
    //   518: iload_3
    //   519: istore 14
    //   521: iload_2
    //   522: istore 16
    //   524: aload 22
    //   526: astore 29
    //   528: aload 32
    //   530: ldc_w 628
    //   533: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   536: istore 5
    //   538: aload 23
    //   540: astore 24
    //   542: aload_1
    //   543: astore 26
    //   545: iload 6
    //   547: istore 7
    //   549: iload 5
    //   551: istore 9
    //   553: iload 4
    //   555: istore 11
    //   557: iload_3
    //   558: istore 13
    //   560: iload_2
    //   561: istore 15
    //   563: aload 22
    //   565: astore 28
    //   567: aload 23
    //   569: astore 25
    //   571: aload_1
    //   572: astore 27
    //   574: iload 17
    //   576: istore 8
    //   578: iload 5
    //   580: istore 10
    //   582: iload 4
    //   584: istore 12
    //   586: iload_3
    //   587: istore 14
    //   589: iload_2
    //   590: istore 16
    //   592: aload 22
    //   594: astore 29
    //   596: aload 32
    //   598: ldc_w 630
    //   601: invokevirtual 436	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   604: istore 6
    //   606: aload 23
    //   608: astore 24
    //   610: aload_1
    //   611: astore 26
    //   613: iload 6
    //   615: istore 7
    //   617: iload 5
    //   619: istore 9
    //   621: iload 4
    //   623: istore 11
    //   625: iload_3
    //   626: istore 13
    //   628: iload_2
    //   629: istore 15
    //   631: aload 22
    //   633: astore 28
    //   635: aload 23
    //   637: astore 25
    //   639: aload_1
    //   640: astore 27
    //   642: iload 6
    //   644: istore 8
    //   646: iload 5
    //   648: istore 10
    //   650: iload 4
    //   652: istore 12
    //   654: iload_3
    //   655: istore 14
    //   657: iload_2
    //   658: istore 16
    //   660: aload 22
    //   662: astore 29
    //   664: aload 32
    //   666: ldc_w 632
    //   669: invokevirtual 287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   672: astore 23
    //   674: aload 23
    //   676: astore 24
    //   678: aload_1
    //   679: astore 26
    //   681: iload 6
    //   683: istore 7
    //   685: iload 5
    //   687: istore 9
    //   689: iload 4
    //   691: istore 11
    //   693: iload_3
    //   694: istore 13
    //   696: iload_2
    //   697: istore 15
    //   699: aload 22
    //   701: astore 28
    //   703: aload 23
    //   705: astore 25
    //   707: aload_1
    //   708: astore 27
    //   710: iload 6
    //   712: istore 8
    //   714: iload 5
    //   716: istore 10
    //   718: iload 4
    //   720: istore 12
    //   722: iload_3
    //   723: istore 14
    //   725: iload_2
    //   726: istore 16
    //   728: aload 22
    //   730: astore 29
    //   732: aload 32
    //   734: ldc_w 634
    //   737: invokevirtual 287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   740: astore 30
    //   742: aload 30
    //   744: astore 24
    //   746: aload 32
    //   748: ldc_w 636
    //   751: invokevirtual 287	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   754: astore 25
    //   756: ldc 8
    //   758: new 114	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 638
    //   768: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: aload 22
    //   773: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: ldc_w 590
    //   779: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: iload_2
    //   783: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   786: ldc_w 590
    //   789: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: iload 4
    //   794: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   797: ldc_w 590
    //   800: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   803: iload_3
    //   804: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   807: ldc_w 590
    //   810: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: iload 5
    //   815: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   818: ldc_w 590
    //   821: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: aload 23
    //   826: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: ldc_w 590
    //   832: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   835: aload 24
    //   837: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: ldc_w 590
    //   843: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: iload 6
    //   848: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   851: ldc_w 590
    //   854: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   857: aload_1
    //   858: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: ldc_w 590
    //   864: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: aload 25
    //   869: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: ldc_w 590
    //   875: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   878: iconst_0
    //   879: invokevirtual 361	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   882: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   885: invokestatic 164	bhzm:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   888: new 545	android/content/Intent
    //   891: dup
    //   892: aload_0
    //   893: getfield 44	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   896: ldc_w 547
    //   899: invokespecial 550	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
    //   902: astore 25
    //   904: new 405	android/os/Bundle
    //   907: dup
    //   908: invokespecial 406	android/os/Bundle:<init>	()V
    //   911: astore 26
    //   913: aload 26
    //   915: ldc_w 488
    //   918: aload 22
    //   920: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   923: aload 26
    //   925: ldc_w 622
    //   928: iload_2
    //   929: invokevirtual 440	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   932: aload 26
    //   934: ldc_w 626
    //   937: iload 4
    //   939: invokevirtual 440	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   942: aload 26
    //   944: ldc_w 624
    //   947: iload_3
    //   948: invokevirtual 440	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   951: aload 26
    //   953: ldc_w 628
    //   956: iload 5
    //   958: invokevirtual 440	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   961: aload 26
    //   963: ldc_w 632
    //   966: aload 23
    //   968: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   971: aload 26
    //   973: ldc_w 634
    //   976: aload 24
    //   978: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   981: aload 26
    //   983: ldc_w 630
    //   986: iload 6
    //   988: invokevirtual 440	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   991: aload 26
    //   993: ldc_w 640
    //   996: aload_1
    //   997: invokevirtual 413	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1000: aload 26
    //   1002: ldc_w 596
    //   1005: iconst_5
    //   1006: invokevirtual 440	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1009: aload 25
    //   1011: aload 26
    //   1013: invokevirtual 600	android/content/Intent:putExtras	(Landroid/os/Bundle;)Landroid/content/Intent;
    //   1016: pop
    //   1017: aload_0
    //   1018: getfield 44	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   1021: aload 25
    //   1023: invokevirtual 644	android/app/Activity:startActivity	(Landroid/content/Intent;)V
    //   1026: return
    //   1027: astore 25
    //   1029: ldc 30
    //   1031: astore 27
    //   1033: aload 28
    //   1035: astore 22
    //   1037: iload 15
    //   1039: istore_2
    //   1040: iload 13
    //   1042: istore_3
    //   1043: iload 11
    //   1045: istore 4
    //   1047: iload 9
    //   1049: istore 5
    //   1051: iload 7
    //   1053: istore 6
    //   1055: aload 26
    //   1057: astore_1
    //   1058: aload 24
    //   1060: astore 23
    //   1062: aload 27
    //   1064: astore 24
    //   1066: aload 25
    //   1068: invokevirtual 520	org/json/JSONException:printStackTrace	()V
    //   1071: ldc 8
    //   1073: ldc_w 646
    //   1076: aload 25
    //   1078: invokestatic 274	bhzm:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1081: aload 31
    //   1083: astore 25
    //   1085: goto -329 -> 756
    //   1088: astore 26
    //   1090: ldc 30
    //   1092: astore 24
    //   1094: aload 29
    //   1096: astore 22
    //   1098: iload 16
    //   1100: istore_2
    //   1101: iload 14
    //   1103: istore_3
    //   1104: iload 12
    //   1106: istore 4
    //   1108: iload 10
    //   1110: istore 5
    //   1112: iload 8
    //   1114: istore 6
    //   1116: aload 27
    //   1118: astore_1
    //   1119: aload 25
    //   1121: astore 23
    //   1123: aload 26
    //   1125: invokevirtual 202	java/lang/Exception:printStackTrace	()V
    //   1128: ldc 8
    //   1130: ldc_w 648
    //   1133: aload 26
    //   1135: invokestatic 274	bhzm:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1138: aload 31
    //   1140: astore 25
    //   1142: goto -386 -> 756
    //   1145: astore 26
    //   1147: goto -24 -> 1123
    //   1150: astore 25
    //   1152: goto -86 -> 1066
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1155	0	this	BaseJsCallBack
    //   0	1155	1	paramString	String
    //   16	1085	2	i	int
    //   21	1083	3	j	int
    //   26	1081	4	k	int
    //   32	1079	5	m	int
    //   38	1077	6	n	int
    //   62	990	7	i1	int
    //   92	1021	8	i2	int
    //   66	982	9	i3	int
    //   96	1013	10	i4	int
    //   70	974	11	i5	int
    //   100	1005	12	i6	int
    //   73	968	13	i7	int
    //   104	998	14	i8	int
    //   76	962	15	i9	int
    //   108	991	16	i10	int
    //   35	540	17	i11	int
    //   29	482	18	i12	int
    //   23	424	19	i13	int
    //   18	365	20	i14	int
    //   13	305	21	i15	int
    //   10	1087	22	localObject1	Object
    //   46	1076	23	localObject2	Object
    //   54	1039	24	localObject3	Object
    //   84	938	25	localObject4	Object
    //   1027	50	25	localJSONException1	JSONException
    //   1083	58	25	str1	String
    //   1150	1	25	localJSONException2	JSONException
    //   58	998	26	localObject5	Object
    //   1088	46	26	localException1	Exception
    //   1145	1	26	localException2	Exception
    //   88	1029	27	str2	String
    //   80	954	28	localObject6	Object
    //   112	983	29	localObject7	Object
    //   42	701	30	str3	String
    //   50	1089	31	str4	String
    //   122	625	32	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   114	124	1027	org/json/JSONException
    //   186	195	1027	org/json/JSONException
    //   255	265	1027	org/json/JSONException
    //   325	334	1027	org/json/JSONException
    //   393	402	1027	org/json/JSONException
    //   460	470	1027	org/json/JSONException
    //   528	538	1027	org/json/JSONException
    //   596	606	1027	org/json/JSONException
    //   664	674	1027	org/json/JSONException
    //   732	742	1027	org/json/JSONException
    //   114	124	1088	java/lang/Exception
    //   186	195	1088	java/lang/Exception
    //   255	265	1088	java/lang/Exception
    //   325	334	1088	java/lang/Exception
    //   393	402	1088	java/lang/Exception
    //   460	470	1088	java/lang/Exception
    //   528	538	1088	java/lang/Exception
    //   596	606	1088	java/lang/Exception
    //   664	674	1088	java/lang/Exception
    //   732	742	1088	java/lang/Exception
    //   746	756	1145	java/lang/Exception
    //   746	756	1150	org/json/JSONException
  }
  
  public void onJsAlert(String paramString)
  {
    new AlertDialog.Builder(this.activity).setTitle("javaScript dialog").setMessage(paramString).setPositiveButton(17039370, new bhxa(this)).setCancelable(false).create().show();
  }
  
  public void report(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    bhzm.b("BaseJsCallBack", "[report] json=" + paramString);
    try
    {
      paramString = new JSONObject(paramString);
      bhzd.a(paramString.optInt("type"), paramString.optString("data"));
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
    bhzm.b("BaseJsCallBack", "[reportBatch] json=" + paramString);
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        JSONObject localJSONObject = paramString.optJSONObject(i);
        if (localJSONObject != null) {
          bhzd.a(localJSONObject.optInt("type"), localJSONObject.optString("data"));
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public void reportForVia(String paramString)
  {
    if (!hasRight()) {
      return;
    }
    try
    {
      Object localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("actionType");
      String str1 = ((JSONObject)localObject).optString("via");
      String str2 = ((JSONObject)localObject).optString("appid");
      String str3 = ((JSONObject)localObject).optString("jsversion");
      localObject = ((JSONObject)localObject).optString("extraData");
      Bundle localBundle = new Bundle();
      localBundle.putString("jsversion", str3);
      bias.a(paramString, str1, str2, (String)localObject, localBundle);
      bhzm.c("BaseJsCallBack", "reportForvia " + paramString + " | " + str1 + " | " + str2);
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
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONArray(paramString);
        i = 0;
        if (i >= paramString.length()) {
          break;
        }
        Object localObject = paramString.optJSONObject(i);
        if (localObject != null)
        {
          String str1 = ((JSONObject)localObject).optString("actionType");
          String str2 = ((JSONObject)localObject).optString("via");
          String str3 = ((JSONObject)localObject).optString("appid");
          String str4 = ((JSONObject)localObject).optString("jsversion");
          localObject = ((JSONObject)localObject).optString("extraData");
          Bundle localBundle = new Bundle();
          localBundle.putString("jsversion", str4);
          bias.a(str1, str2, str3, (String)localObject, localBundle);
          bhzm.c("BaseJsCallBack", "reportForvia " + str1 + " | " + str2 + " | " + str3);
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  public void reportPV(String paramString1, String paramString2)
  {
    if (isUpdateAssets == true)
    {
      isUpdateAssets = false;
      return;
    }
    if (biam.a(paramString1))
    {
      bias.a("100", "ANDROIDQQ.INSTALLED.APPDETAIL", paramString2);
      return;
    }
    if (biby.a().a(paramString2))
    {
      bias.a("100", "ANDROIDQQ.UNINSTALL.APPDETAIL", paramString2);
      return;
    }
    bias.a("100", "ANDROIDQQ.UNDOWNLOAD.APPDETAIL", paramString2);
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
        bhwp.a().a(false);
        return;
      }
      bhwp.a().a(true);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public boolean setCommonReportData(String paramString)
  {
    bhzm.c("BaseJsCallBack", "JsCallBack--setCommonReportData");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        bhpc.a().c(paramString);
        return true;
      }
      catch (Exception paramString)
      {
        bhzm.c("BaseJsCallBack", "JsCallBack--setCommonReportData Exception", paramString);
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
    if (!hasRight()) {}
    while ((this.activity == null) || (this.activity.isFinishing())) {
      return;
    }
    bhzt.a().a(paramString, 1);
  }
  
  public void startApp(String paramString1, String paramString2)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          paramString2 = DownloadInterface.getSourceInfoFromActivity(this.activity);
          biam.a(this.activity, paramString1, paramString2);
          return;
        }
      }
      catch (Exception paramString2)
      {
        bhzm.e("startApp", "apk not exist packName = " + paramString1);
      }
    }
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
        bhzm.c("add", ">>has add platformid=qzone_m");
      }
      try
      {
        this.activity.startActivity(paramString2);
        return;
      }
      catch (Exception paramString2)
      {
        bhzt.a().a(amtj.a(2131700154), 0);
        return;
      }
      return;
    }
    catch (Exception paramString2)
    {
      bhzm.e("startApp", "apk not exist packName = " + paramString1);
    }
  }
  
  public void startAppWithData(String paramString1, String paramString2)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          paramString2 = DownloadInterface.getSourceInfoFromActivity(this.activity);
          biam.a(this.activity, paramString1, paramString2);
          return;
        }
      }
      catch (Exception paramString2)
      {
        bhzm.e("startApp", "apk not exist packName = " + paramString1);
      }
    }
  }
  
  public void startOpenApp(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {}
    for (;;)
    {
      return;
      try
      {
        if (appIsExists(paramString1))
        {
          paramString2 = DownloadInterface.getSourceInfoFromActivity(this.activity);
          biam.a(this.activity, paramString1, paramString2);
          return;
        }
      }
      catch (Exception paramString1) {}
    }
  }
  
  /* Error */
  public void startOpenApp(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    // Byte code:
    //   0: ldc 8
    //   2: new 114	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 817
    //   12: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_1
    //   16: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: ldc_w 819
    //   22: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_3
    //   26: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 819
    //   32: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload 4
    //   37: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 692	bhzm:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokevirtual 768	com/tencent/open/appcommon/js/BaseJsCallBack:appIsExists	(Ljava/lang/String;)Z
    //   51: istore 6
    //   53: iload 6
    //   55: ifeq +22 -> 77
    //   58: aload 5
    //   60: ldc_w 821
    //   63: invokestatic 826	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore_2
    //   67: aload_0
    //   68: getfield 44	com/tencent/open/appcommon/js/BaseJsCallBack:activity	Landroid/app/Activity;
    //   71: aload_3
    //   72: aload_1
    //   73: aload_2
    //   74: invokestatic 829	biam:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   77: return
    //   78: astore_1
    //   79: ldc 8
    //   81: new 114	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   88: ldc_w 831
    //   91: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: aload_1
    //   95: invokevirtual 834	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   98: invokevirtual 147	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 158	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 224	bhzm:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   107: return
    //   108: astore_2
    //   109: aload 5
    //   111: astore_2
    //   112: goto -45 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	this	BaseJsCallBack
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   0	115	3	paramString3	String
    //   0	115	4	paramString4	String
    //   0	115	5	paramString5	String
    //   51	3	6	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   0	53	78	java/lang/Exception
    //   67	77	78	java/lang/Exception
    //   58	67	108	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.appcommon.js.BaseJsCallBack
 * JD-Core Version:    0.7.0.1
 */