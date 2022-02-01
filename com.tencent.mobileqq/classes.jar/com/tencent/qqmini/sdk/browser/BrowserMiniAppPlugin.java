package com.tencent.qqmini.sdk.browser;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public class BrowserMiniAppPlugin
  extends BrowserPlugin
{
  public static final String NAME_SPACE = "miniApp";
  public static final String TAG = "BrowserMiniAppPlugin";
  
  protected boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) && (paramMap != null) && (paramLong == 1L) && (paramMap.containsKey("errorCode")))
      {
        int i = ((Integer)paramMap.get("errorCode")).intValue();
        QMLog.i("BrowserMiniAppPlugin", "paybyh5 handleEvent EVENT_RECEIVER_HTTP_ERROR errorCode:" + i);
        if ((paramMap != null) && (paramMap.containsKey("requestUrl")))
        {
          paramString = (String)paramMap.get("requestUrl");
          QMLog.i("BrowserMiniAppPlugin", "paybyh5 handleEvent realUrlStr:" + paramString);
          if ((TextUtils.isEmpty(paramString)) || (!paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay"))) {
            break label266;
          }
          paramMap = new Intent();
          paramMap.putExtra("errCode", -3);
          paramMap.putExtra("errMsg", "EVENT_RECEIVER_HTTP_ERROR：" + i);
          paramMap.putExtra("errType", 1L);
          if (this.mActivity == null) {
            break label252;
          }
        }
        label252:
        for (paramString = (Activity)this.mActivity.get();; paramString = null)
        {
          if (paramString == null) {
            break label266;
          }
          paramString.setResult(-1, paramMap);
          paramString.finish();
          break label266;
          paramString = "";
          break;
        }
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QMLog.e("BrowserMiniAppPlugin", "handleEvent error.", paramString);
    }
  }
  
  protected boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QMLog.isColorLevel()) {
      QMLog.d("BrowserMiniAppPlugin", "handleJsRequest, url=" + paramString1 + ", pkgName=" + paramString2 + ", methodName=" + paramString3);
    }
    if ((paramString2 == null) || (!paramString2.equalsIgnoreCase("miniApp")) || (paramString3 == null)) {
      return false;
    }
    if (this.mActivity != null) {}
    for (paramString2 = (Activity)this.mActivity.get(); this.mActivity == null; paramString2 = null) {
      return false;
    }
    if (paramString3.equals("payCallback"))
    {
      try
      {
        paramString3 = getJsonFromJSBridge(paramString1);
        QMLog.i("BrowserMiniAppPlugin", "payCallback" + paramString3.toString());
        paramString1 = new Intent();
        int i = paramString3.optInt("errCode");
        paramString3 = paramString3.optString("errMsg");
        paramString1.putExtra("errCode", i);
        paramString1.putExtra("errMsg", paramString3);
        QMLog.e("BrowserMiniAppPlugin", "payCallback code=" + i + ", msg=" + paramString3);
        if (paramString2 != null)
        {
          paramString2.setResult(-1, paramString1);
          paramString2.finish();
        }
      }
      catch (Throwable paramString1)
      {
        for (;;)
        {
          QMLog.e("BrowserMiniAppPlugin", "payCallback error.", paramString1);
        }
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserMiniAppPlugin
 * JD-Core Version:    0.7.0.1
 */