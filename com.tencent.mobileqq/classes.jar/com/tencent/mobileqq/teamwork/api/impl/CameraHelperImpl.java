package com.tencent.mobileqq.teamwork.api.impl;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.teamwork.api.ICameraHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;

public final class CameraHelperImpl
  implements ICameraHelper
{
  private static final String TAG = "CameraHelperImpl";
  private String mCallback;
  private Handler mHandler;
  private final WebViewPlugin mHostPlugin;
  
  public CameraHelperImpl(WebViewPlugin paramWebViewPlugin)
  {
    this.mHostPlugin = paramWebViewPlugin;
  }
  
  private boolean checkSelfPermission()
  {
    AppActivity localAppActivity = getActivity();
    return (Build.VERSION.SDK_INT < 23) || (localAppActivity == null) || (localAppActivity.checkSelfPermission("android.permission.CAMERA") == 0);
  }
  
  private AppActivity getActivity()
  {
    Object localObject = this.mHostPlugin;
    AppActivity localAppActivity = null;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WebViewPlugin)localObject).mRuntime;
    }
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).a();
    }
    if ((localObject instanceof AppActivity)) {
      localAppActivity = (AppActivity)localObject;
    }
    return localAppActivity;
  }
  
  private void onPermissionResult(boolean paramBoolean, int paramInt)
  {
    String str2 = this.mCallback;
    if (!TextUtils.isEmpty(str2))
    {
      String str1;
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("granted", paramBoolean);
        ((JSONObject)localObject).put("errorCode", paramInt);
        ((JSONObject)localObject).put("cmd", "onPermissionResult");
        localObject = ((JSONObject)localObject).toString();
      }
      catch (JSONException localJSONException)
      {
        QLog.e("CameraHelperImpl", 1, "onPermissionResult error", localJSONException);
        str1 = "";
      }
      if ((this.mHostPlugin != null) && (!TextUtils.isEmpty(str1))) {
        this.mHostPlugin.callJs(str2, new String[] { str1 });
      }
    }
  }
  
  private void removePermissionUncertainMonitor()
  {
    Handler localHandler = this.mHandler;
    if (localHandler != null) {
      localHandler.removeMessages(1);
    }
  }
  
  private void requestPermission()
  {
    AppActivity localAppActivity = getActivity();
    if (localAppActivity == null) {
      return;
    }
    localAppActivity.requestPermissions(new CameraHelperImpl.1(this), 1819, new String[] { "android.permission.CAMERA" });
    if (this.mHandler == null) {
      this.mHandler = new CameraHelperImpl.2(this, Looper.getMainLooper());
    }
    this.mHandler.sendEmptyMessageDelayed(1, 10000L);
  }
  
  public boolean checkPermission(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("CameraHelperImpl", 1, "checkPermission failed, callback is invalid.");
      return false;
    }
    if (this.mHostPlugin == null) {
      return false;
    }
    this.mCallback = paramString;
    if (checkSelfPermission())
    {
      onPermissionResult(true, 0);
      return true;
    }
    requestPermission();
    return false;
  }
  
  public void destroy()
  {
    this.mCallback = null;
    removePermissionUncertainMonitor();
    this.mHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.impl.CameraHelperImpl
 * JD-Core Version:    0.7.0.1
 */