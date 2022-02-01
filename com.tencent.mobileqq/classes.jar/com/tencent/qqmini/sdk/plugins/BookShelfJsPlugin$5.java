package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

class BookShelfJsPlugin$5
  implements AsyncResult
{
  BookShelfJsPlugin$5(BookShelfJsPlugin paramBookShelfJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).putOpt("data", paramJSONObject.optString("key_result_data"));
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      Object localObject;
      long l;
      QMLog.e("BookShelfJsPlugin", "handleUpdateBookshelf exception: ", paramJSONObject);
      ApiUtil.wrapCallbackFail(this.val$req.event, null);
    }
    l = paramJSONObject.optLong("retCode");
    localObject = paramJSONObject.optString("errMsg");
    QMLog.e("BookShelfJsPlugin", "handleQueryBookshelf fail, retCode: " + l + "; errMsg : " + (String)localObject);
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */