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
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.ImageUtil;
import com.tencent.open.base.StringAddition;
import com.tencent.open.business.base.AppUtil;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.open.business.base.StaticAnalyz;
import com.tencent.open.downloadnew.MyAppDialog;
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
  protected Handler mHandler;
  protected MyAppDialog tipDialog;
  protected WebView webView;
  
  public AppInterface(Activity paramActivity, WebView paramWebView)
  {
    this.activity = paramActivity;
    this.webView = paramWebView;
    this.mHandler = new Handler(Looper.getMainLooper());
  }
  
  public static String getImei()
  {
    return MobileInfoUtil.getImei();
  }
  
  public static String getImsi()
  {
    return MobileInfoUtil.getImsi();
  }
  
  public String gSetPackageScanSetting(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    if (paramString1.equals("2"))
    {
      if (AppUtil.c(this.activity)) {
        return "1";
      }
      return "0";
    }
    if (paramString1.equals("0"))
    {
      StaticAnalyz.a("100", "ANDROIDQQ.STORE.UPDATECHECKBOX", "");
      paramString1 = new AppInterface.1(this, paramString2);
      this.mHandler.post(new AppInterface.2(this, paramString1));
      return null;
    }
    if (paramString1.equals("1"))
    {
      paramString1 = CommonDataAdapter.a().b().getSharedPreferences("package_scan", 0).edit();
      paramString1.putBoolean("qqsetting_package_scan_flag", true);
      paramString1.commit();
      return "1";
    }
    return null;
  }
  
  public String getAllDownAppInfo(String paramString1, String paramString2, String paramString3)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    JSONArray localJSONArray = new JSONArray();
    ArrayList localArrayList = new ArrayList();
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
      if (StringAddition.d(paramString1)) {
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
    if ("true".equals(paramString1))
    {
      i = 1;
    }
    else
    {
      if (!"false".equals(paramString1)) {
        break label252;
      }
      i = 0;
    }
    int j;
    if ("true".equals(paramString2))
    {
      j = 1;
    }
    else
    {
      if (!"false".equals(paramString2)) {
        break label252;
      }
      j = 0;
    }
    int k;
    if ("true".equals(paramString3))
    {
      k = 1;
    }
    else
    {
      if (!"false".equals(paramString3)) {
        break label252;
      }
      k = 0;
    }
    paramString1 = new JSONArray();
    paramString1.put(paramPackageInfo.packageName);
    paramString1.put(paramPackageInfo.versionCode);
    paramString1.put(paramPackageInfo.versionName);
    if (i != 0) {
      paramString1.put(paramPackageInfo.applicationInfo.loadLabel(this.activity.getPackageManager()).toString());
    } else {
      paramString1.put("");
    }
    if (j != 0) {
      paramString1.put(ImageUtil.a(paramPackageInfo.applicationInfo.loadIcon(this.activity.getPackageManager())));
    } else {
      paramString1.put("");
    }
    if (k != 0)
    {
      if (Build.VERSION.SDK_INT > 7)
      {
        if ((paramPackageInfo.applicationInfo.flags & 0x40000) != 0)
        {
          paramString1.put(1);
          return paramString1;
        }
        paramString1.put(0);
        return paramString1;
      }
      paramString1.put(0);
      return paramString1;
    }
    paramString1.put(-1);
    return paramString1;
    label252:
    return null;
  }
  
  public String getAppInfoBatch(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!hasRight()) {
      return "baby,you don't have permission";
    }
    if (StringAddition.d(paramString1)) {
      return "{}";
    }
    paramString1 = StringAddition.a(paramString1, paramString2);
    if (paramString1.length == 0) {
      return "{}";
    }
    paramString2 = new JSONArray();
    PackageManager localPackageManager = this.activity.getPackageManager();
    int j = paramString1.length;
    int i = 0;
    for (;;)
    {
      CharSequence localCharSequence;
      if (i < j)
      {
        localCharSequence = paramString1[i];
        if ((TextUtils.isEmpty(localCharSequence)) || (!PackageUtil.a(this.activity, localCharSequence))) {}
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
    int i = paramInt;
    if (paramInt <= 0) {
      i = 5;
    }
    List localList = ((ActivityManager)localObject1).getRecentTasks(64, 1);
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    if (localList != null)
    {
      int n = localList.size();
      paramInt = 0;
      int k;
      for (int j = 0; (paramInt < n) && (j < i); j = k)
      {
        localObject1 = (ActivityManager.RecentTaskInfo)localList.get(paramInt);
        Object localObject2 = ((ActivityManager.RecentTaskInfo)localObject1).baseIntent;
        Object localObject3 = ((ActivityManager.RecentTaskInfo)localObject1).origActivity;
        localObject1 = null;
        if (localObject3 != null) {
          localObject1 = ((ComponentName)localObject3).getPackageName();
        } else if (localObject2 != null) {
          localObject1 = ((Intent)localObject2).getComponent().getPackageName();
        }
        k = j;
        if (localObject1 != null) {
          if (localArrayList.contains(localObject1))
          {
            k = j;
          }
          else
          {
            localArrayList.add(localObject1);
            k = -1;
            try
            {
              localObject2 = localPackageManager.getPackageInfo((String)localObject1, 0);
              if (localObject2 == null)
              {
                k = j;
              }
              else
              {
                if (localObject2 != null)
                {
                  k = ((PackageInfo)localObject2).versionCode;
                  localObject3 = ((PackageInfo)localObject2).versionName;
                }
                int m;
                if ((((PackageInfo)localObject2).applicationInfo.flags & 0x1) != 0) {
                  m = 1;
                } else {
                  m = 0;
                }
                j += 1;
                localStringBuilder.append("\"");
                localStringBuilder.append((String)localObject1);
                localStringBuilder.append("\"");
                localStringBuilder.append(":");
                localStringBuilder.append("\"");
                localStringBuilder.append(k);
                localStringBuilder.append(",");
                localStringBuilder.append(m);
                localStringBuilder.append("\"");
                k = j;
                if (paramInt < n - 1)
                {
                  localStringBuilder.append(",");
                  k = j;
                }
              }
            }
            catch (PackageManager.NameNotFoundException localNameNotFoundException)
            {
              localNameNotFoundException.printStackTrace();
              k = j;
            }
          }
        }
        paramInt += 1;
      }
    }
    paramInt = localStringBuilder.length() - 1;
    if (localStringBuilder.charAt(paramInt) == ',') {
      localStringBuilder.deleteCharAt(paramInt);
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public int uninstallApp(String paramString)
  {
    if (!hasRight()) {
      return -1;
    }
    if (AppUtil.d(this.activity, paramString)) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appcommon.js.AppInterface
 * JD-Core Version:    0.7.0.1
 */