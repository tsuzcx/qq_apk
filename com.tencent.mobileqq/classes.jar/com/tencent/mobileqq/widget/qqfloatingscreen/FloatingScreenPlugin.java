package com.tencent.mobileqq.widget.qqfloatingscreen;

import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class FloatingScreenPlugin
  extends WebViewPlugin
{
  public FloatingScreenPlugin()
  {
    this.mPluginNameSpace = "floatingWindow";
  }
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, String.format(Locale.getDefault(), "handleJsRequest url: %s pkgName; %s method: %s, args: %s", new Object[] { paramString1, paramString2, paramString3, paramVarArgs }));
    }
    if ("floatingWindow".equals(paramString2))
    {
      if ("show".equals(paramString3))
      {
        ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), true, 16);
        return true;
      }
      if ("hide".equals(paramString3))
      {
        ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowVisibleBroadcast(BaseApplication.getContext(), false, 16);
        return true;
      }
      if ("close".equals(paramString3))
      {
        ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast(BaseApplicationImpl.getContext(), 16);
        return true;
      }
    }
    return false;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, "onActivityResult requestCode=" + paramByte + "  resultCode=" + paramInt);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, "onCreate");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("FloatingScreenPlugin", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPlugin
 * JD-Core Version:    0.7.0.1
 */