package com.tencent.mobileqq.kandian.glue.viola.adapter;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;
import org.json.JSONException;
import org.json.JSONObject;

class JSAPIAdapter$1
  implements Runnable
{
  JSAPIAdapter$1(JSAPIAdapter paramJSAPIAdapter, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Application localApplication = ViolaEnvironment.getApplication();
    if (localApplication == null) {
      return;
    }
    try
    {
      if (this.a.has("url"))
      {
        localObject = (String)this.a.get("url");
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          return;
        }
        JSAPIAdapter.a(localApplication.getApplicationContext(), (String)localObject, null);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("METHOD_OPEN_URL JSONException");
        ((StringBuilder)localObject).append(localJSONException.getMessage());
        QLog.e("JSAPIAdapter", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.JSAPIAdapter.1
 * JD-Core Version:    0.7.0.1
 */