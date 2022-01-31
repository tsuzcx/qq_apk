package com.tencent.open.appcommon.js;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RecentTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import bdiv;
import bfbm;
import bfja;
import bfln;
import bflp;
import bflv;
import bfms;
import bfmw;
import bfmy;
import bfpl;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class AppInterface
  extends BaseInterface
{
  protected static final String APP_UPDATE_TAG = "AppUpdate";
  public static final String PLUGIN_NAMESPACE = "qzone_app";
  private static final String TAG = "AppInterface";
  protected Activity activity;
  public Handler mHandler;
  public bfpl tipDialog;
  protected WebView webView;
  
  public AppInterface(Activity paramActivity, WebView paramWebView)
  {
    this.activity = paramActivity;
    this.webView = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String getImei()
  {
    return bfmw.c();
  }
  
  public static String getImsi()
  {
    return bfmw.d();
  }
  
  public String gSetPackageScanSetting(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      return null;
      if (paramString1.equals("2"))
      {
        if (bfms.a(this.activity)) {
          return "1";
        }
        return "0";
      }
      if (paramString1.equals("0"))
      {
        bfmy.a("100", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
        paramString1 = new bfja(this, paramString2);
        this.mHandler.post(new AppInterface.2(this, paramString1));
        return null;
      }
    } while (!paramString1.equals("1"));
    paramString1 = bfbm.a().a().getSharedPreferences("package_scan", 0).edit();
    paramString1.putBoolean("qqsetting_package_scan_flag", true);
    paramString1.commit();
    return "1";
  }
  
  public String getAllDownAppInfo(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
    if (localArrayList != null)
    {
      int i = 0;
      while (i < localArrayList.size())
      {
        PackageInfo localPackageInfo = (PackageInfo)localArrayList.get(i);
        if ((localPackageInfo.applicationInfo.flags & 0x1) == 0) {
          localJSONArray.put(getAppInfo(localPackageInfo, paramString1, paramString2, paramString3));
        }
        i += 1;
      }
      return localJSONArray.toString();
    }
    return "[]";
  }
  
  public String getAppInfo(String paramString)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    return getAppInfo(paramString, "true", "true", "true");
  }
  
  public String getAppInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      if (!hasRight()) {
        return "baby,you don't have permission";
      }
      if (bflv.a(paramString1)) {
        return "[]";
      }
      paramString1 = this.activity.getPackageManager().getPackageInfo(paramString1, 0);
      if (paramString1 == null) {
        return "[]";
      }
      paramString1 = getAppInfo(paramString1, paramString2, paramString3, paramString4).toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "[]";
  }
  
  protected JSONArray getAppInfo(PackageInfo paramPackageInfo, String paramString1, String paramString2, String paramString3)
  {
    int i;
    int j;
    label24:
    int k;
    if ("true".equals(paramString1))
    {
      i = 1;
      if (!"true".equals(paramString2)) {
        break label179;
      }
      j = 1;
      if (!"true".equals(paramString3)) {
        break label196;
      }
      k = 1;
      label37:
      paramString1 = new JSONArray();
      paramString1.put(paramPackageInfo.packageName);
      paramString1.put(paramPackageInfo.versionCode);
      paramString1.put(paramPackageInfo.versionName);
      if (i == 0) {
        break label214;
      }
      paramString1.put(paramPackageInfo.applicationInfo.loadLabel(this.activity.getPackageManager()).toString());
      label101:
      if (j == 0) {
        break label224;
      }
      paramString1.put(bfln.a(paramPackageInfo.applicationInfo.loadIcon(this.activity.getPackageManager())));
      label128:
      if (k == 0) {
        break label252;
      }
      if (Build.VERSION.SDK_INT <= 7) {
        break label243;
      }
      if ((paramPackageInfo.applicationInfo.flags & 0x40000) == 0) {
        break label234;
      }
      paramString1.put(1);
    }
    for (;;)
    {
      return paramString1;
      if ("false".equals(paramString1))
      {
        i = 0;
        break;
      }
      return null;
      label179:
      if ("false".equals(paramString2))
      {
        j = 0;
        break label24;
      }
      return null;
      label196:
      if ("false".equals(paramString3))
      {
        k = 0;
        break label37;
      }
      return null;
      label214:
      paramString1.put("");
      break label101;
      label224:
      paramString1.put("");
      break label128;
      label234:
      paramString1.put(0);
      continue;
      label243:
      paramString1.put(0);
      continue;
      label252:
      paramString1.put(-1);
    }
  }
  
  public String getAppInfoBatch(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    int i = 0;
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    if (bflv.a(paramString1)) {
      return "{}";
    }
    paramString1 = bflv.a(paramString1, paramString2);
    if (paramString1.length == 0) {
      return "{}";
    }
    paramString2 = new JSONArray();
    PackageManager localPackageManager = this.activity.getPackageManager();
    int j = paramString1.length;
    for (;;)
    {
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = paramString1[i];
        if ((TextUtils.isEmpty(localCharSequence)) || (!bdiv.a(this.activity, localCharSequence))) {}
      }
      try
      {
        paramString2.put(getAppInfo(localPackageManager.getPackageInfo(localCharSequence, 0), paramString3, paramString4, paramString5));
        label115:
        i += 1;
        continue;
        return paramString2.toString();
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        break label115;
      }
    }
  }
  
  public String getInterfaceName()
  {
    return "qzone_app";
  }
  
  protected String getRecentApp(int paramInt)
  {
    Object localObject1 = (ActivityManager)this.activity.getSystemService("activity");
    PackageManager localPackageManager = this.activity.getPackageManager();
    int j = paramInt;
    if (paramInt <= 0) {
      j = 5;
    }
    List localList = ((ActivityManager)localObject1).getRecentTasks(64, 1);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    int n;
    int k;
    Object localObject3;
    if (localList != null)
    {
      n = localList.size();
      k = 0;
      paramInt = 0;
      if ((k < n) && (paramInt < j))
      {
        localObject3 = (ActivityManager.RecentTaskInfo)localList.get(k);
        localObject1 = ((ActivityManager.RecentTaskInfo)localObject3).baseIntent;
        localObject3 = ((ActivityManager.RecentTaskInfo)localObject3).origActivity;
        if (localObject3 != null) {
          localObject1 = ((ComponentName)localObject3).getPackageName();
        }
      }
    }
    for (;;)
    {
      label140:
      int i = paramInt;
      if (localObject1 != null)
      {
        if (localArrayList.contains(localObject1)) {}
        for (;;)
        {
          k += 1;
          break;
          if (localObject1 == null) {
            break label413;
          }
          localObject1 = ((Intent)localObject1).getComponent().getPackageName();
          break label140;
          localArrayList.add(localObject1);
          i = -1;
          try
          {
            localObject3 = localPackageManager.getPackageInfo((String)localObject1, 0);
            if (localObject3 != null) {
              break label222;
            }
          }
          catch (PackageManager.NameNotFoundException localNameNotFoundException)
          {
            localNameNotFoundException.printStackTrace();
          }
        }
        label222:
        if (localObject3 != null)
        {
          i = ((PackageInfo)localObject3).versionCode;
          String str = ((PackageInfo)localObject3).versionName;
        }
        if ((((PackageInfo)localObject3).applicationInfo.flags & 0x1) == 0) {
          break label407;
        }
      }
      label407:
      for (int m = 1;; m = 0)
      {
        paramInt += 1;
        localStringBuilder.append("\"");
        localStringBuilder.append(localNameNotFoundException);
        localStringBuilder.append("\"");
        localStringBuilder.append(":");
        localStringBuilder.append("\"");
        localStringBuilder.append(i);
        localStringBuilder.append(",");
        localStringBuilder.append(m);
        localStringBuilder.append("\"");
        i = paramInt;
        if (k < n - 1)
        {
          localStringBuilder.append(",");
          i = paramInt;
        }
        paramInt = i;
        break;
        paramInt = localStringBuilder.length();
        if (localStringBuilder.charAt(paramInt - 1) == ',') {
          localStringBuilder.deleteCharAt(paramInt - 1);
        }
        localStringBuilder.append("}");
        return localStringBuilder.toString();
      }
      label413:
      Object localObject2 = null;
    }
  }
  
  public void getUpdateApp(String paramString)
  {
    bflp.b("AppUpdate", "getUpdateApp , param = " + paramString);
    try
    {
      bfbm.a().a(paramString, this.activity, this.webView);
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public int uninstallApp(String paramString)
  {
    if (!hasRight()) {}
    while (!bfms.b(this.activity, paramString)) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface
 * JD-Core Version:    0.7.0.1
 */