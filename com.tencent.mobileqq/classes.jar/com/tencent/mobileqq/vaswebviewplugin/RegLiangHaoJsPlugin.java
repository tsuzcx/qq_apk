package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import android.content.Intent;
import bijx;
import bioy;
import com.tencent.mobileqq.vip.lianghao.fragment.LiangHaoBuyFragment;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("RegLiangHaoJsPlugin", 2, "handleJsRequest, url=" + paramString1);
    }
    boolean bool1;
    if ((!"haomaReg".equals(paramString2)) || (paramString1 == null) || (paramString3 == null)) {
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      try
      {
        paramJsBridgeListener = WebViewPlugin.getJsonFromJSBridge(paramString1);
        bool1 = bool2;
        if (paramJsBridgeListener != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RegLiangHaoJsPlugin", 2, "handleJsRequest JSON = " + paramJsBridgeListener.toString());
          }
          bool1 = bool2;
          if ("submitBuy".equals(paramString3))
          {
            int i = this.mActivity.getIntent().getIntExtra("lh_reg_from", -1);
            if (i != 1)
            {
              bool1 = bool2;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("RegLiangHaoJsPlugin", 2, "illegal from " + i);
              return true;
            }
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        paramJsBridgeListener.printStackTrace();
        return true;
      }
    }
    paramString1 = paramJsBridgeListener.optString("uin", "");
    paramJsBridgeListener = paramJsBridgeListener.optString("highlight", "");
    LiangHaoBuyFragment.a(this.mActivity, this.mActivity.getIntent(), new bijx(paramString1, paramJsBridgeListener));
    return true;
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mActivity = this.mRuntime.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.RegLiangHaoJsPlugin
 * JD-Core Version:    0.7.0.1
 */