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
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")) && (paramMap != null) && (paramLong == 1L) && (paramMap.containsKey("errorCode")))
        {
          int i = ((Integer)paramMap.get("errorCode")).intValue();
          paramString = new StringBuilder();
          paramString.append("paybyh5 handleEvent EVENT_RECEIVER_HTTP_ERROR errorCode:");
          paramString.append(i);
          QMLog.i("BrowserMiniAppPlugin", paramString.toString());
          if ((paramMap == null) || (!paramMap.containsKey("requestUrl"))) {
            break label285;
          }
          paramString = (String)paramMap.get("requestUrl");
          paramMap = new StringBuilder();
          paramMap.append("paybyh5 handleEvent realUrlStr:");
          paramMap.append(paramString);
          QMLog.i("BrowserMiniAppPlugin", paramMap.toString());
          if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://h5.qzone.qq.com/miniapp/act/midasPay")))
          {
            paramMap = new Intent();
            paramMap.putExtra("errCode", -3);
            paramString = new StringBuilder();
            paramString.append("EVENT_RECEIVER_HTTP_ERROR：");
            paramString.append(i);
            paramMap.putExtra("errMsg", paramString.toString());
            paramMap.putExtra("errType", 1L);
            if (this.mActivity == null) {
              break label291;
            }
            paramString = (Activity)this.mActivity.get();
            if (paramString != null)
            {
              paramString.setResult(-1, paramMap);
              paramString.finish();
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QMLog.e("BrowserMiniAppPlugin", "handleEvent error.", paramString);
      }
      return false;
      label285:
      paramString = "";
      continue;
      label291:
      paramString = null;
    }
  }
  
  protected boolean handleJsRequest(String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (QMLog.isColorLevel())
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("handleJsRequest, url=");
      paramVarArgs.append(paramString1);
      paramVarArgs.append(", pkgName=");
      paramVarArgs.append(paramString2);
      paramVarArgs.append(", methodName=");
      paramVarArgs.append(paramString3);
      QMLog.d("BrowserMiniAppPlugin", paramVarArgs.toString());
    }
    if ((paramString2 != null) && (paramString2.equalsIgnoreCase("miniApp")))
    {
      if (paramString3 == null) {
        return false;
      }
      if (this.mActivity != null) {
        paramString2 = (Activity)this.mActivity.get();
      } else {
        paramString2 = null;
      }
      if (this.mActivity == null) {
        return false;
      }
      if (paramString3.equals("payCallback"))
      {
        try
        {
          paramString3 = getJsonFromJSBridge(paramString1);
          paramString1 = new StringBuilder();
          paramString1.append("payCallback");
          paramString1.append(paramString3.toString());
          QMLog.i("BrowserMiniAppPlugin", paramString1.toString());
          paramString1 = new Intent();
          int i = paramString3.optInt("errCode");
          paramString3 = paramString3.optString("errMsg");
          paramString1.putExtra("errCode", i);
          paramString1.putExtra("errMsg", paramString3);
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("payCallback code=");
          paramVarArgs.append(i);
          paramVarArgs.append(", msg=");
          paramVarArgs.append(paramString3);
          QMLog.e("BrowserMiniAppPlugin", paramVarArgs.toString());
          if (paramString2 != null)
          {
            paramString2.setResult(-1, paramString1);
            paramString2.finish();
          }
        }
        catch (Throwable paramString1)
        {
          QMLog.e("BrowserMiniAppPlugin", "payCallback error.", paramString1);
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.browser.BrowserMiniAppPlugin
 * JD-Core Version:    0.7.0.1
 */