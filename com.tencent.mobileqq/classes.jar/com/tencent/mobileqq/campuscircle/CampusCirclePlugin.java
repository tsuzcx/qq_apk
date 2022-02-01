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
import com.tencent.mobileqq.webview.swift.IPreCreatePluginChecker;
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
  implements IPreCreatePluginChecker
{
  public CampusCirclePlugin()
  {
    this.mPluginNameSpace = "campus_circle";
  }
  
  public boolean a(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    paramString3 = (SwiftBrowserUIStyleHandler)super.getBrowserComponent(2);
    boolean bool = false;
    int n = 0;
    if (paramString3 != null)
    {
      Resources localResources = paramString3.d.getContext().getResources();
      int i1 = (int)(localResources.getDisplayMetrics().density * 30.0F);
      int i = 10;
      paramString2 = "";
      int j;
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        int m;
        try
        {
          paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
          j = paramJsBridgeListener.optInt("iconIndex");
          try
          {
            k = paramJsBridgeListener.optInt("iconPad");
            i = k;
            paramJsBridgeListener = paramJsBridgeListener.optString("iconRes");
            i = k;
          }
          catch (Exception paramString1)
          {
            k = i;
            m = j;
          }
          i = k;
        }
        catch (Exception paramString1)
        {
          m = 0;
          k = i;
        }
        paramJsBridgeListener = paramString2;
        j = m;
        if (QLog.isColorLevel())
        {
          QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", paramString1);
          i = k;
          paramJsBridgeListener = paramString2;
          j = m;
        }
      }
      else
      {
        j = 0;
        paramJsBridgeListener = paramString2;
      }
      bool = "arrow_up".equals(paramJsBridgeListener);
      paramString1 = null;
      if (bool)
      {
        paramJsBridgeListener = localResources.getDrawable(2130844948);
      }
      else if ("arrow_down".equals(paramJsBridgeListener))
      {
        paramJsBridgeListener = localResources.getDrawable(2130844947);
      }
      else
      {
        "none".equals(paramJsBridgeListener);
        paramJsBridgeListener = paramString1;
      }
      int k = 3;
      if (j > 3) {
        j = k;
      } else if (j < 0) {
        j = 0;
      }
      if (i < 0) {
        i = n;
      } else if (i > i1) {
        i = i1;
      }
      paramString3.a.a(j, paramJsBridgeListener, i);
      bool = true;
    }
    return bool;
  }
  
  public boolean b(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]).optString("callback");
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", paramJsBridgeListener);
        }
      }
    } else {
      paramJsBridgeListener = "";
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("getRedPoint callback=");
      paramString1.append(paramJsBridgeListener);
      QLog.d("CampusCirclePlugin", 2, paramString1.toString());
    }
    if (TextUtils.isEmpty(paramJsBridgeListener)) {
      return true;
    }
    paramString1 = new JSONObject();
    paramString2 = CampusCircleIpcClient.a().a();
    boolean bool;
    int j;
    int i;
    long l;
    int k;
    if (paramString2 != null)
    {
      bool = paramString2.getBoolean("hasRedTouch", false);
      j = paramString2.getInt("type", 1);
      i = paramString2.getInt("count", 0);
      l = paramString2.getLong("seq", 0L);
      k = paramString2.getInt("code");
    }
    else
    {
      k = -1;
      l = 0L;
      i = 0;
      bool = false;
      j = 1;
    }
    for (;;)
    {
      try
      {
        paramString1.put("code", k);
        if (!bool) {
          break label319;
        }
        k = 1;
        paramString1.put("hasRedTouch", k);
        paramString1.put("type", j);
        paramString1.put("count", i);
        paramString1.put("seq", l);
      }
      catch (JSONException paramString2)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CampusCirclePlugin", 2, paramString2, new Object[] { "getRedPoint, exception" });
        }
      }
      paramString1 = paramString1.toString();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("getRedPoint, json=");
        paramString2.append(paramString1);
        QLog.d("CampusCirclePlugin", 2, paramString2.toString());
      }
      callJs(paramJsBridgeListener, new String[] { paramString1 });
      return true;
      label319:
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
      if (paramVarArgs.length > 0) {
        try
        {
          l1 = new JSONObject(paramVarArgs[0]).optLong("seq", -1L);
        }
        catch (Exception paramJsBridgeListener)
        {
          l1 = l2;
          if (QLog.isColorLevel())
          {
            QLog.d("CampusCirclePlugin", 2, "getRedPoint exception", paramJsBridgeListener);
            l1 = l2;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("getRedPoint seq=");
      paramJsBridgeListener.append(l1);
      QLog.d("CampusCirclePlugin", 2, paramJsBridgeListener.toString());
    }
    if (l1 < 0L) {
      return true;
    }
    CampusCircleIpcClient.a().a(l1);
    return true;
  }
  
  public boolean d(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0)) {
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
        if (QLog.isColorLevel())
        {
          QLog.i("CampusCirclePlugin", 2, String.format(Locale.getDefault(), "onSearchSchoolResult schoolId: %d schoolName: %s activity: %s", new Object[] { Long.valueOf(l), paramJsBridgeListener, paramString1 }));
          return false;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CampusCirclePlugin", 2, "onSearchSchoolResult exception", paramJsBridgeListener);
        }
      }
    }
    return false;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 8589934598L;
  }
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    boolean bool2 = super.handleEvent(paramString, paramLong, paramMap);
    bool1 = bool2;
    if (paramLong == 8589934598L) {
      if (this.mRuntime.a().getIntent().getIntExtra("uintype", -1) == 1030) {
        bool3 = false;
      }
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
    bool1 = true;
    return bool1;
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
  
  public boolean isNeedPreCreatePlugin(Intent paramIntent, String paramString1, String paramString2)
  {
    return paramIntent.getIntExtra("uintype", -1) == 1030;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.campuscircle.CampusCirclePlugin
 * JD-Core Version:    0.7.0.1
 */