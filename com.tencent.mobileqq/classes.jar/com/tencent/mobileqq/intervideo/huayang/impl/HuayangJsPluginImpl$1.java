package com.tencent.mobileqq.intervideo.huayang.impl;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import org.json.JSONException;
import org.json.JSONObject;

class HuayangJsPluginImpl$1
  extends BroadcastReceiver
{
  HuayangJsPluginImpl$1(HuayangJsPluginImpl paramHuayangJsPluginImpl) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((!paramContext.equals(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(this.a.pluginPackageName))) && (!paramContext.equals(((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(this.a.pluginPackageName))))
    {
      if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.a.pluginPackageName).equals(paramContext))
      {
        paramContext = this.a.mRuntime.a();
        if ((paramContext instanceof BaseActivity))
        {
          ((BaseActivity)paramContext).doOnBackPressed();
          return;
        }
        paramContext.onBackPressed();
        return;
      }
      if (((IHuayangJsPlugin)QRoute.api(IHuayangJsPlugin.class)).getCacheUserNotifyAction(this.a.pluginPackageName).equals(paramContext)) {
        HuayangJsPluginImpl.access$402(this.a, paramIntent.getIntExtra("key_isCache", -1));
      }
    }
    else
    {
      int i = paramIntent.getIntExtra("key_state", -1);
      HuayangJsPluginImpl.access$002(this.a, i);
      JSONObject localJSONObject = HuayangJsPluginImpl.access$100(this.a, i);
      long l;
      switch (i)
      {
      default: 
        break;
      case 10: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_LAUNCHER_FAILED");
        break;
      case 9: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_LAUNCHER_SUCC");
        break;
      case 8: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_LAUNCHERING");
        break;
      case 7: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_LOAD_FALIED");
        break;
      case 6: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_LOAD_COMPLETE");
        break;
      case 5: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_PRELOAD_FALIED");
        break;
      case 3: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_DOWANLODAD_FAILED");
        break;
      case 2: 
        HuayangJsPluginImpl.access$200(this.a, "STATE_DOWANLODAD_COMPLETE");
        paramContext = Message.obtain();
        if (HuayangJsPluginImpl.access$400(this.a) == 1) {
          paramContext.arg1 = 40;
        } else {
          paramContext.arg1 = 0;
        }
        if (!TextUtils.equals(HuayangJsPluginImpl.access$500(this.a), "checkVersion"))
        {
          HuayangJsPluginImpl.access$602(this.a, 0);
          HuayangJsPluginImpl.access$300(this.a).sendMessage(paramContext);
        }
        break;
      case 1: 
      case 4: 
        int j = paramIntent.getIntExtra("key_progress", 0);
        l = paramIntent.getLongExtra("key_totalSize", 0L);
        HuayangJsPluginImpl localHuayangJsPluginImpl = this.a;
        if (i == 1)
        {
          paramContext = new StringBuilder();
          paramIntent = "progress:STATE_DOWANLOADING:";
        }
        else
        {
          paramContext = new StringBuilder();
          paramIntent = "progress:STATE_LOADING:";
        }
        paramContext.append(paramIntent);
        paramContext.append(j);
        HuayangJsPluginImpl.access$200(localHuayangJsPluginImpl, paramContext.toString());
        if (i == 4)
        {
          if (j <= 90) {
            return;
          }
          HuayangJsPluginImpl.access$300(this.a).removeCallbacksAndMessages(null);
        }
        try
        {
          localJSONObject.putOpt("totalSize", Long.valueOf(l));
          localJSONObject.putOpt("pro", Integer.valueOf(j));
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
        }
      case 0: 
        l = paramIntent.getLongExtra("key_totalSize", 0L);
        paramContext = this.a;
        paramIntent = new StringBuilder();
        paramIntent.append("size:");
        paramIntent.append(l);
        HuayangJsPluginImpl.access$200(paramContext, paramIntent.toString());
        try
        {
          localJSONObject.putOpt("totalSize", Long.valueOf(l));
        }
        catch (JSONException paramContext)
        {
          paramContext.printStackTrace();
        }
        localJSONObject.remove("state");
      }
      paramContext = this.a;
      paramContext.callJs(paramContext.mJsNotifyCallback, new String[] { localJSONObject.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.impl.HuayangJsPluginImpl.1
 * JD-Core Version:    0.7.0.1
 */