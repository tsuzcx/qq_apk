package com.tencent.qqmini.miniapp.core.page;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DomainUtil;
import org.json.JSONException;
import org.json.JSONObject;

class NativeViewContainer$15
  implements Runnable
{
  NativeViewContainer$15(NativeViewContainer paramNativeViewContainer, NativeViewRequestEvent paramNativeViewRequestEvent) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(this.val$req.jsonParams);
        int i = ((JSONObject)localObject2).optInt("htmlId");
        boolean bool1 = ((JSONObject)localObject2).has("src");
        Object localObject3 = null;
        if (bool1)
        {
          String str = ((JSONObject)localObject2).optString("src", "");
          if (!((JSONObject)localObject2).has("position")) {
            break label241;
          }
          localJSONObject = ((JSONObject)localObject2).optJSONObject("position");
          bool1 = ((JSONObject)localObject2).optBoolean("__skipDomainCheck__", false);
          localObject2 = localObject3;
          if (NativeViewContainer.access$500(this.this$0) != null)
          {
            localObject2 = localObject3;
            if (NativeViewContainer.access$500(this.this$0).getMiniAppContext() != null) {
              localObject2 = NativeViewContainer.access$500(this.this$0).getMiniAppContext().getMiniAppInfo();
            }
          }
          if (!TextUtils.isEmpty(str))
          {
            boolean bool2 = AppBrandUtil.isOpenUrlFilter(str);
            if ((localObject2 != null) && (DomainUtil.isDomainValid((MiniAppInfo)localObject2, bool1, str, 4)) && (!bool2))
            {
              this.this$0.doUpdateHTMLWebView(i, str);
            }
            else
            {
              NativeViewContainer.access$600(this.this$0, i, str, (MiniAppInfo)localObject2, this.val$req);
              return;
            }
          }
          if (localJSONObject != null) {
            this.this$0.doUpdateHTMLWebView(i, localJSONObject);
          }
          this.val$req.ok();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("NativeViewContainer", "updateHtmlWebview error.", localJSONException);
        return;
      }
      Object localObject1 = null;
      continue;
      label241:
      JSONObject localJSONObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.NativeViewContainer.15
 * JD-Core Version:    0.7.0.1
 */