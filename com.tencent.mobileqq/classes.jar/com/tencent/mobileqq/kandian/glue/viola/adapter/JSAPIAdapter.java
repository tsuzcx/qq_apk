package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.IJSApiAdapter;
import com.tencent.viola.adapter.IJSApiAdapter.OnInovkeCallback;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaSDKManager;
import org.json.JSONException;
import org.json.JSONObject;

public class JSAPIAdapter
  implements IJSApiAdapter
{
  private JSONObject a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("fail", "exception");
      localJSONObject.put("msg", paramString);
      return localJSONObject;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exceptionCall JSONException");
        localStringBuilder.append(paramString.getMessage());
        QLog.e("JSAPIAdapter", 2, localStringBuilder.toString());
      }
    }
    return localJSONObject;
  }
  
  private static void b(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (paramContext != null)
    {
      if (paramString == null) {
        return;
      }
      int i;
      if ((!paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) && (!paramString.startsWith("http://clientui.3g.qq.com/mqq/")) && (!paramString.startsWith("http://qm.qq.com/cgi-bin/")) && (!paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) && (paramString.startsWith("https://")))
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("url", paramString);
        localBundle.putBoolean("hide_operation_bar", true);
        paramString = new Intent(paramContext, QQBrowserActivity.class);
        paramString.setFlags(268435456);
        paramString.putExtras(localBundle);
        if (paramBundle != null) {
          paramString.putExtras(paramBundle);
        }
        paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        paramContext.startActivity(paramString);
        return;
      }
      paramBundle = new Intent(paramContext, JumpActivity.class);
      paramBundle.setFlags(268435456);
      paramString = Uri.parse(paramString);
      paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramBundle.setData(paramString);
      paramContext.startActivity(paramBundle);
    }
  }
  
  public void invoke(String paramString, JSONObject paramJSONObject, IJSApiAdapter.OnInovkeCallback paramOnInovkeCallback, ViolaInstance paramViolaInstance)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if ("openUrl".equals(paramString))
    {
      paramString = new JSAPIAdapter.1(this, paramJSONObject);
      ViolaSDKManager.getInstance().postOnUiThread(paramString, 0L);
      return;
    }
    if ("getCache".equals(paramString))
    {
      try
      {
        if ((paramJSONObject.has("url")) && (paramJSONObject.has("key")) && (paramJSONObject.has("host")))
        {
          if (!paramJSONObject.has("path")) {
            return;
          }
          paramJSONObject.put("callid", 0);
          ReadInJoyWebDataManager.a().a(paramJSONObject.getString("url"), paramJSONObject.toString(), new JSAPIAdapter.H5Callback(paramOnInovkeCallback));
          return;
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramOnInovkeCallback.callback(a(paramString.getMessage()));
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("METHOD_GET_CACHE JSONException");
      paramJSONObject.append(paramString.getMessage());
      QLog.e("JSAPIAdapter", 2, paramJSONObject.toString());
    }
    else if ("writeCache".equals(paramString))
    {
      try
      {
        if ((paramJSONObject.has("url")) && (paramJSONObject.has("key")) && (paramJSONObject.has("host")) && (paramJSONObject.has("path")))
        {
          if (!paramJSONObject.has("data")) {
            return;
          }
          paramJSONObject.put("callid", 0);
          ReadInJoyWebDataManager.a().a(paramJSONObject.getString("url"), paramJSONObject.toString(), null, paramJSONObject);
          return;
        }
        return;
      }
      catch (JSONException paramString)
      {
        paramOnInovkeCallback.callback(a(paramString.getMessage()));
        if (QLog.isColorLevel())
        {
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("METHOD_WRITE_CACHE fail");
          paramJSONObject.append(paramString.getMessage());
          QLog.e("JSAPIAdapter", 2, paramJSONObject.toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.JSAPIAdapter
 * JD-Core Version:    0.7.0.1
 */