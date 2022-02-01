package com.tencent.mobileqq.imaxad;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewJsPlugin;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class ImaxAdSharePlugin
  extends VasWebviewJsPlugin
{
  public ImaxAdSharePlugin()
  {
    this.mPluginNameSpace = "qq_imax_ad";
  }
  
  private void a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      String str = paramString.optString("callback");
      paramString = AdvertisementItem.a(paramString);
      JSONObject localJSONObject = new JSONObject();
      if (paramString != null)
      {
        if ((QLog.isColorLevel()) && (paramString.a != null))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ad id  = ");
          localStringBuilder.append(paramString.a.c);
          QLog.d("ImaxAdvertisement", 2, localStringBuilder.toString());
        }
        PublicAccountAdvertisementActivity.a(BaseApplicationImpl.getContext(), paramString);
        paramString = localJSONObject.put("retCode", "0");
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("ImaxAdvertisement", 2, "item == null");
        }
        paramString = localJSONObject.put("retCode", "-1");
      }
      if (!TextUtils.isEmpty(str))
      {
        callJs(str, new String[] { paramString.toString() });
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImaxAdvertisement", 2, "openImaxAd", paramString);
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QLog.isColorLevel())
    {
      paramJsBridgeListener = new StringBuilder();
      paramJsBridgeListener.append("handleJsRequest pkgName=");
      paramJsBridgeListener.append(paramString2);
      paramJsBridgeListener.append(" method=");
      paramJsBridgeListener.append(paramString3);
      QLog.d("ImaxAdvertisement", 2, paramJsBridgeListener.toString());
    }
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (TextUtils.isEmpty(paramString3)) {
          return false;
        }
        bool1 = bool2;
        if (paramVarArgs != null)
        {
          if (paramVarArgs.length == 0) {
            return false;
          }
          if (!"qq_imax_ad".equals(paramString2)) {
            return false;
          }
          bool1 = bool2;
          if ("showSharedAD".equals(paramString3))
          {
            a(paramVarArgs[0]);
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdSharePlugin
 * JD-Core Version:    0.7.0.1
 */