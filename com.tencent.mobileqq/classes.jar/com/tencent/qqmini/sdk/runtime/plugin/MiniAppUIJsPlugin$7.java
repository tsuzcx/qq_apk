package com.tencent.qqmini.sdk.runtime.plugin;

import android.text.TextUtils;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import org.json.JSONException;
import org.json.JSONObject;

class MiniAppUIJsPlugin$7
  implements Runnable
{
  MiniAppUIJsPlugin$7(MiniAppUIJsPlugin paramMiniAppUIJsPlugin, bgok parambgok) {}
  
  public void run()
  {
    JSONObject localJSONObject1 = null;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject2 = new JSONObject(this.val$req.b);
        int i = localJSONObject2.optInt("htmlId");
        if (localJSONObject2.has("src"))
        {
          String str = localJSONObject2.optString("src", "");
          if (localJSONObject2.has("position")) {
            localJSONObject1 = localJSONObject2.optJSONObject("position");
          }
          boolean bool = localJSONObject2.optBoolean("__skipDomainCheck__", false);
          if (!TextUtils.isEmpty(str))
          {
            if (DomainUtil.isDomainValid(MiniAppUIJsPlugin.access$1300(this.this$0), bool, str, 4)) {
              this.this$0.doUpdateHTMLWebView(i, str);
            }
          }
          else
          {
            if (localJSONObject1 != null) {
              this.this$0.doUpdateHTMLWebView(i, localJSONObject1);
            }
            this.val$req.a();
            return;
          }
          QMLog.e("MiniAppUIJsPlugin", "updateHTMLWebView domain valid : " + str);
          this.val$req.a("domain valid");
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("MiniAppUIJsPlugin", "updateHtmlWebview error.", localJSONException);
        return;
      }
      Object localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.plugin.MiniAppUIJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */