package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import begz;
import bejo;
import bejy;
import beka;
import bekg;
import belh;
import bequ;
import beri;
import berl;
import berw;
import besa;
import besl;
import bffu;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import org.json.JSONObject;

public class SystemInfoPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy;
  
  public String handleGetSystemInfo(beka parambeka)
  {
    Object localObject1;
    if (this.mContext == null)
    {
      besl.d("SystemInfoPlugin", "getSystemInfo error,context is NULL");
      localObject1 = parambeka.b();
      return localObject1;
    }
    label62:
    Object localObject3;
    int i;
    label98:
    double d;
    int m;
    int j;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject1);
      localObject3 = this.mMiniAppContext.a();
      if (((!bffu.a((Context)localObject3)) || (!bffu.a((Activity)localObject3))) && (!bffu.a())) {
        break label647;
      }
      i = 1;
      d = ((DisplayMetrics)localObject1).density;
      m = (int)((float)Math.round(((DisplayMetrics)localObject1).widthPixels / d) + 0.5F);
      j = (int)((float)Math.round(((DisplayMetrics)localObject1).heightPixels / d) + 0.5F);
      if (i == 0) {
        break label742;
      }
      j -= (int)(bffu.c((Context)localObject3) / d);
    }
    label326:
    label735:
    label742:
    for (;;)
    {
      int n = (int)(Math.round(bffu.d((Context)localObject3)) / d);
      int i1 = (int)(bffu.a((Context)localObject3, 44.0F) / d + 0.5D);
      int k = (int)(bffu.a((Context)localObject3, 54.0F) / d + 0.5D);
      localObject1 = (String)this.mMiniAppContext.a(bejo.a());
      if (!belh.a((String)localObject1)) {
        label234:
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label735;
        }
      }
      for (localObject3 = this.mApkgInfo.a().a((String)localObject1).a.a.c;; localObject3 = "default")
      {
        if ((this.mApkgInfo != null) && (this.mApkgInfo.a() != null)) {
          if ((this.mApkgInfo.a().jdField_a_of_type_Berw != null) && (this.mApkgInfo.a((String)localObject1)) && (this.mApkgInfo.a().jdField_a_of_type_Berw.a())) {
            i = 1;
          }
        }
        for (;;)
        {
          if ("default".equals(localObject3))
          {
            if (i != 0) {}
            for (;;)
            {
              for (;;)
              {
                i = j - n - i1 - k;
                try
                {
                  localObject1 = new JSONObject();
                  ((JSONObject)localObject1).put("brand", Build.BRAND);
                  ((JSONObject)localObject1).put("model", Build.MODEL);
                  ((JSONObject)localObject1).put("pixelRatio", d);
                  ((JSONObject)localObject1).put("screenWidth", m);
                  ((JSONObject)localObject1).put("screenHeight", j);
                  ((JSONObject)localObject1).put("windowWidth", m);
                  ((JSONObject)localObject1).put("windowHeight", i);
                  ((JSONObject)localObject1).put("statusBarHeight", n);
                  ((JSONObject)localObject1).put("language", "zh_CN");
                  ((JSONObject)localObject1).put("version", this.mMiniAppProxy.getAppVersion());
                  ((JSONObject)localObject1).put("system", "Android " + Build.VERSION.RELEASE);
                  ((JSONObject)localObject1).put("platform", "android");
                  ((JSONObject)localObject1).put("fontSizeSetting", 16);
                  ((JSONObject)localObject1).put("SDKVersion", this.mMiniAppContext.a());
                  ((JSONObject)localObject1).put("AppPlatform", this.mMiniAppProxy.getAppName());
                  localObject3 = bekg.a(parambeka.jdField_a_of_type_JavaLangString, (JSONObject)localObject1).toString();
                  localObject1 = localObject3;
                  if (!"getSystemInfo".equals(parambeka.jdField_a_of_type_JavaLangString)) {
                    break;
                  }
                  parambeka.a((String)localObject3);
                  return localObject3;
                }
                catch (Exception localException)
                {
                  besl.d("SystemInfoPlugin", "getSystemInfo exception: " + new Throwable(localException));
                  return parambeka.b();
                }
              }
              Object localObject2 = this.mContext.getResources().getDisplayMetrics();
              break label62;
              i = 0;
              break label98;
              localObject3 = this.mMiniAppInfo.launchParam.c;
              localObject2 = this.mApkgInfo.a.jdField_a_of_type_JavaLangString;
              if (!this.mApkgInfo.c((String)localObject3)) {
                break label234;
              }
              localObject2 = localObject3;
              break label234;
              i = 0;
              break label326;
              k = 0;
            }
          }
          if (i != 0) {}
          for (;;)
          {
            i = j - k;
            break;
            k = 0;
          }
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */