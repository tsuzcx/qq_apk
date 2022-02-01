package com.tencent.mobileqq.kandian.base.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class AchillesFragmentUtils$InstallBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    for (;;)
    {
      try
      {
        String str = paramIntent.getAction();
        paramContext = (WebViewPlugin.PluginRuntime)AchillesFragmentUtils.a().get();
        paramIntent = paramIntent.getData().getEncodedSchemeSpecificPart();
        if ((paramContext != null) && (!TextUtils.isEmpty(paramIntent)))
        {
          if (paramContext == null) {
            break label120;
          }
          paramContext = paramContext.a();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("code", 1);
          localJSONObject.put("packageName", paramIntent);
          if ((paramContext != null) && (!TextUtils.isEmpty(AchillesFragmentUtils.b()))) {
            paramContext.callJs(AchillesFragmentUtils.b(), new String[] { localJSONObject.toString() });
          }
        }
        AchillesFragmentUtils.a("appinstall", str, paramIntent);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.toString();
        return;
      }
      label120:
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.AchillesFragmentUtils.InstallBroadcastReceiver
 * JD-Core Version:    0.7.0.1
 */