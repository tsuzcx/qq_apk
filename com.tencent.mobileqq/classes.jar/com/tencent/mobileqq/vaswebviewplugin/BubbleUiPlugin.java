package com.tencent.mobileqq.vaswebviewplugin;

import android.content.Intent;
import android.os.Handler;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class BubbleUiPlugin
  extends VasWebviewUiPlugin
{
  private static final String TAG = "BubbleUiPlugin";
  OnRemoteRespObserver mOnRemoteResp = new BubbleUiPlugin.2(this);
  
  void OnActivityDestroy()
  {
    super.OnActivityDestroy();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).unRegisterObserver(this.mOnRemoteResp);
  }
  
  void OnActivityResume()
  {
    super.OnActivityResume();
    ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).registerObserver(this.mOnRemoteResp);
    if (((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded())
    {
      reportBubbleSetting();
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "OnActivityResume -> loading url");
      }
    }
    else
    {
      this.isHomePageWatingBind = true;
      if (QLog.isColorLevel()) {
        QLog.i("BubbleUiPlugin", 2, "OnActivityResume -> loadurl waiting binding");
      }
    }
  }
  
  protected long getPluginBusiness()
  {
    return 64L;
  }
  
  public long getWebViewEventByNameSpace(String paramString)
  {
    return 3L;
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("BaseWebActivity onActivityResult requestCode=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(",resultCode=");
      ((StringBuilder)localObject1).append(paramInt2);
      QLog.i("BubbleUiPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt2 == -1) {
      switch (paramInt1)
      {
      default: 
        break;
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
        try
        {
          localObject1 = paramIntent.getStringExtra("callbackSn");
          Object localObject2 = paramIntent.getStringExtra("result");
          paramIntent = new JSONObject();
          paramIntent.put("responseId", localObject1);
          paramIntent.put("responseData", new JSONObject((String)localObject2));
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("BaseWebActivity loadUrl setMessage =");
            ((StringBuilder)localObject1).append(paramIntent.toString());
            QLog.i("BubbleUiPlugin", 2, ((StringBuilder)localObject1).toString());
          }
          localObject1 = this.mRuntime.a();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("javascript:window.qqJSBridge&&qqJSBridge.setMessage('");
          ((StringBuilder)localObject2).append(paramIntent.toString());
          ((StringBuilder)localObject2).append("');");
          ((CustomWebView)localObject1).loadUrl(((StringBuilder)localObject2).toString());
        }
        catch (Exception paramIntent)
        {
          paramIntent.printStackTrace();
        }
        return true;
      }
    }
    return false;
  }
  
  public void reportBubbleSetting()
  {
    new Handler().postDelayed(new BubbleUiPlugin.1(this), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin
 * JD-Core Version:    0.7.0.1
 */