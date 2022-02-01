package com.tencent.mobileqq.video;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class VipVideoApiPlugin
  extends WebViewPlugin
{
  public final String a = "VideoApiPlugin";
  public String b;
  protected OnRemoteRespObserver c = new VipVideoApiPlugin.1(this);
  
  public VipVideoApiPlugin()
  {
    this.mPluginNameSpace = "video";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      QLog.d("VideoApiPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("video".equals(paramString2)) && (paramString1 != null)) {
      if (paramString3 == null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        boolean bool = paramString1.has("callback");
        if (!bool) {
          break label401;
        }
        paramJsBridgeListener = paramString1.getString("callback");
        if ("isInstalled".equals(paramString3))
        {
          if (((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
          {
            paramString1 = new Bundle();
            paramJsBridgeListener = DataFactory.a("ipc_video_isinstalled", paramJsBridgeListener, this.c.key, paramString1);
            ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
            return true;
          }
        }
        else if ("installPlugin".equals(paramString3))
        {
          if (((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
          {
            paramString1 = new Bundle();
            paramJsBridgeListener = DataFactory.a("ipc_video_install_plugin", paramJsBridgeListener, this.c.key, paramString1);
            ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(paramJsBridgeListener);
            return true;
          }
        }
        else if ("playVideo".equals(paramString3))
        {
          paramString2 = paramString1.optString("vid", "");
          paramString3 = paramString1.optString("format", "");
          int i = paramString1.optInt("playType", 0);
          paramString1 = paramString1.optString("screenOrientation", "landscape");
          if (!TextUtils.isEmpty(paramJsBridgeListener)) {
            this.b = paramJsBridgeListener;
          }
          if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (i > 0))
          {
            paramJsBridgeListener = new Intent(this.mRuntime.d(), VipVideoPlayActivity.class);
            paramJsBridgeListener.putExtra("vid", paramString2);
            paramJsBridgeListener.putExtra("videoFormat", paramString3);
            paramJsBridgeListener.putExtra("vtype", i);
            paramJsBridgeListener.putExtra("screenOrientation", paramString1);
            startActivityForResult(paramJsBridgeListener, (byte)100);
            return true;
          }
          if (!TextUtils.isEmpty(this.b))
          {
            callJs(this.b, new String[] { String.valueOf(4) });
            return true;
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      return true;
      return false;
      label401:
      paramJsBridgeListener = "";
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("vip video api plugin on activity result requestCode=");
      localStringBuilder.append(paramByte);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt);
      QLog.d("VideoApiPlugin", 2, localStringBuilder.toString());
    }
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if ((paramByte == 100) && (!TextUtils.isEmpty(this.b))) {
      callJs(this.b, new String[] { String.valueOf(paramInt) });
    }
  }
  
  protected void onCreate()
  {
    super.onCreate();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.c);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.video.VipVideoApiPlugin
 * JD-Core Version:    0.7.0.1
 */