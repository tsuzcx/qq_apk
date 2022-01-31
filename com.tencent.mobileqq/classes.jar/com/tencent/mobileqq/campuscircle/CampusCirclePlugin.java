package com.tencent.mobileqq.campuscircle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CampusCirclePlugin
  extends WebViewPlugin
{
  public CampusCirclePlugin()
  {
    this.mPluginNameSpace = "campus_circle";
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString2 = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    int i1;
    int k;
    int i;
    int j;
    int m;
    if (paramString2 != null)
    {
      paramString3 = paramString2.b.getContext().getResources();
      i1 = (int)(30.0F * paramString3.getDisplayMetrics().density);
      int i2 = 0;
      k = 0;
      paramString1 = "";
      int n = 10;
      i = n;
      paramJsBridgeListener = paramString1;
      j = k;
      if (paramVarArgs != null)
      {
        i = n;
        paramJsBridgeListener = paramString1;
        j = k;
        if (paramVarArgs.length > 0)
        {
          k = n;
          m = i2;
        }
      }
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        k = n;
        m = i2;
        j = paramJsBridgeListener.optInt("iconIndex");
        k = n;
        m = j;
        i = paramJsBridgeListener.optInt("iconPad");
        k = i;
        m = j;
        paramJsBridgeListener = paramJsBridgeListener.optString("iconRes");
      }
      catch (Exception paramVarArgs)
      {
        for (;;)
        {
          i = k;
          paramJsBridgeListener = paramString1;
          j = m;
          if (QLog.isColorLevel())
          {
            QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", paramVarArgs);
            i = k;
            paramJsBridgeListener = paramString1;
            j = m;
            continue;
            if ("arrow_down".equals(paramJsBridgeListener))
            {
              paramJsBridgeListener = paramString3.getDrawable(2130842339);
            }
            else if ("none".equals(paramJsBridgeListener))
            {
              paramJsBridgeListener = null;
            }
            else
            {
              paramJsBridgeListener = null;
              continue;
              k = j;
              if (j < 0)
              {
                k = 0;
                continue;
                j = i;
                if (i > i1) {
                  j = i1;
                }
              }
            }
          }
        }
      }
      if ("arrow_up".equals(paramJsBridgeListener))
      {
        paramJsBridgeListener = paramString3.getDrawable(2130842340);
        if (j <= 3) {
          break label278;
        }
        k = 3;
        if (i >= 0) {
          break label293;
        }
        j = 0;
        paramString2.a.a(k, paramJsBridgeListener, j);
        return true;
      }
    }
    label278:
    label293:
    return false;
  }
  
  public boolean b(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString1 = "";
    paramJsBridgeListener = paramString1;
    if (paramVarArgs != null)
    {
      paramJsBridgeListener = paramString1;
      if (paramVarArgs.length <= 0) {}
    }
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
      if (QLog.isColorLevel()) {
        QLog.d("CampusCirclePlugin", 2, "getRedPoint callback=" + paramJsBridgeListener);
      }
      if (TextUtils.isEmpty(paramJsBridgeListener)) {
        return true;
      }
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        paramJsBridgeListener = paramString1;
        if (QLog.isColorLevel())
        {
          QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", paramString2);
          paramJsBridgeListener = paramString1;
        }
      }
      paramString1 = new JSONObject();
      paramString2 = CampusCircleIpcClient.a().a();
      bool = false;
      j = 1;
      i = 0;
      l = 0L;
      if (paramString2 == null) {
        break label277;
      }
    }
    boolean bool = paramString2.getBoolean("hasRedTouch", false);
    int j = paramString2.getInt("type", 1);
    int i = paramString2.getInt("count", 0);
    long l = paramString2.getLong("seq", 0L);
    int k = paramString2.getInt("code");
    for (;;)
    {
      try
      {
        paramString1.put("code", k);
        if (!bool) {
          continue;
        }
        k = 1;
        paramString1.put("hasRedTouch", k);
        paramString1.put("type", j);
        paramString1.put("count", i);
        paramString1.put("seq", l);
      }
      catch (JSONException paramString2)
      {
        label277:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("CampusCirclePlugin", 2, paramString2, new Object[] { "getRedPoint, exception" });
        continue;
      }
      paramString1 = paramString1.toString();
      if (QLog.isColorLevel()) {
        QLog.d("CampusCirclePlugin", 2, "getRedPoint, json=" + paramString1);
      }
      callJs(paramJsBridgeListener, new String[] { paramString1 });
      return true;
      k = -1;
      continue;
      k = 0;
    }
  }
  
  public boolean c(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    long l2 = -1L;
    long l1 = l2;
    if (paramVarArgs != null)
    {
      l1 = l2;
      if (paramVarArgs.length <= 0) {}
    }
    try
    {
      l1 = new JSONObject(paramVarArgs[0]).optLong("seq", -1L);
      if (QLog.isColorLevel()) {
        QLog.d("CampusCirclePlugin", 2, "getRedPoint seq=" + l1);
      }
      if (l1 < 0L) {
        return true;
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", paramJsBridgeListener);
          l1 = l2;
        }
      }
      CampusCircleIpcClient.a().a(l1);
    }
    return true;
  }
  
  public boolean d(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {}
    try
    {
      paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
      long l = paramJsBridgeListener.getLong("schoolId");
      paramJsBridgeListener = paramJsBridgeListener.getString("schoolName");
      paramString1 = this.mRuntime.a();
      if (paramString1 != null)
      {
        paramString2 = new Intent();
        paramString2.putExtra("campus_school_id", l);
        paramString2.putExtra("campus_school", paramJsBridgeListener);
        paramString1.setResult(-1, paramString2);
        paramString1.finish();
      }
      if (QLog.isColorLevel()) {
        QLog.i("CampusCirclePlugin", 2, String.format(Locale.getDefault(), "onSearchSchoolResult schoolId: %d schoolName: %s activity: %s", new Object[] { Long.valueOf(l), paramJsBridgeListener, paramString1 }));
      }
    }
    catch (Exception paramJsBridgeListener)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CampusCirclePlugin", 2, "onSearchSchoolResult exception", paramJsBridgeListener);
    }
    return false;
    return false;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map paramMap)
  {
    boolean bool2 = super.handleEvent(paramString, paramLong, paramMap);
    boolean bool3;
    if (paramLong == 8589934598L)
    {
      if (this.mRuntime.a().getIntent().getIntExtra("uintype", -1) == 1030) {
        bool3 = false;
      }
      try
      {
        paramString = Uri.parse(this.mRuntime.a().getIntent().getStringExtra("url"));
        bool1 = bool3;
        if (paramString != null)
        {
          bool1 = bool3;
          if (paramString.isHierarchical()) {
            bool1 = "1".equals(paramString.getQueryParameter("__iscomic"));
          }
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          bool1 = bool3;
        }
      }
      if (bool1) {
        return bool2;
      }
      paramString = new Intent(this.mRuntime.a(), SplashActivity.class);
      paramString.putExtra("fragment_id", 1);
      paramString.putExtra("main_tab_id", 4);
      paramString.setFlags(603979776);
      paramString.putExtra("from", "campus_notice");
      this.mRuntime.a().startActivity(paramString);
      if (QLog.isDevelopLevel()) {
        QLog.i("CampusNoticeManager", 4, "EVENT_BEFORE_ACTIVITY_FINISH");
      }
    }
    for (boolean bool1 = true;; bool1 = bool2) {
      return bool1;
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CampusCirclePlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("campus_circle".equals(paramString2))
    {
      if ("getRedPoint".equals(paramString3)) {
        return b(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      if ("reportRedPoint".equals(paramString3)) {
        return c(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      if ("setTitleIcon".equals(paramString3)) {
        return a(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      if ("onSearchSchoolResult".equals(paramString3)) {
        return d(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
      }
      return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCirclePlugin
 * JD-Core Version:    0.7.0.1
 */