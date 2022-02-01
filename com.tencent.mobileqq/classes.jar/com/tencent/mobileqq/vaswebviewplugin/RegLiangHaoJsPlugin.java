package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.loginregister.ILoginRegisterApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.lianghao.data.LiangHaoUinData;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RegLiangHaoJsPlugin
  extends VasWebviewJsPlugin
{
  public static final String BusinessName = "haomaReg";
  public static final String Method_SubmitBuy = "submitBuy";
  public static final String TAG = "RegLiangHaoJsPlugin";
  public Activity mActivity;
  
  public RegLiangHaoJsPlugin()
  {
    this.mPluginNameSpace = "haomaReg";
  }
  
  public static void webViewPageStartBuyForResult(Activity paramActivity, Intent paramIntent, LiangHaoUinData paramLiangHaoUinData)
  {
    ILoginRegisterApi localILoginRegisterApi = (ILoginRegisterApi)QRoute.api(ILoginRegisterApi.class);
    Intent localIntent = new Intent();
    localIntent.putExtras(paramIntent);
    localIntent.putExtra("lh_request_code", 2);
    localIntent.putExtra("lh_uin", paramLiangHaoUinData.a);
    localIntent.putExtra("lh_light", paramLiangHaoUinData.b);
    QPublicFragmentActivity.Launcher.a(paramActivity, localIntent, QPublicTransFragmentActivity.class, localILoginRegisterApi.getLHBuyFragment(), 2);
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest, url=");
      paramJsBridgeListener.append(paramString1);
      QLog.d("RegLiangHaoJsPlugin", 2, paramJsBridgeListener.toString());
    }
    if (("haomaReg".equals(paramString2)) && (paramString1 != null) && (paramString3 != null))
    {
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        if (paramJsBridgeListener == null) {
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("handleJsRequest JSON = ");
          paramString1.append(paramJsBridgeListener.toString());
          QLog.d("RegLiangHaoJsPlugin", 2, paramString1.toString());
        }
        if ("submitBuy".equals(paramString3))
        {
          int i = this.mActivity.getIntent().getIntExtra("lh_reg_from", -1);
          if (i != 1)
          {
            if (!QLog.isColorLevel()) {
              break label232;
            }
            paramJsBridgeListener = new StringBuilder();
            paramJsBridgeListener.append("illegal from ");
            paramJsBridgeListener.append(i);
            QLog.i("RegLiangHaoJsPlugin", 2, paramJsBridgeListener.toString());
            return true;
          }
          paramString1 = paramJsBridgeListener.optString("uin", "");
          paramJsBridgeListener = paramJsBridgeListener.optString("highlight", "");
          webViewPageStartBuyForResult(this.mActivity, this.mActivity.getIntent(), new LiangHaoUinData(paramString1, paramJsBridgeListener));
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
      }
      return true;
    }
    else
    {
      return false;
    }
    label232:
    return true;
  }
  
  protected void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.RegLiangHaoJsPlugin
 * JD-Core Version:    0.7.0.1
 */