package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONArray;
import org.json.JSONObject;

class BookShelfJsPlugin$4
  implements AsyncResult
{
  BookShelfJsPlugin$4(BookShelfJsPlugin paramBookShelfJsPlugin, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).putOpt("list", new JSONArray(paramJSONObject.optString("key_result_data")));
      this.val$req.ok((JSONObject)localObject);
      return;
    }
    catch (Throwable paramJSONObject)
    {
      Object localObject;
      long l;
      QMLog.e("BookShelfJsPlugin", "handleQueryBookshelf exception: ", paramJSONObject);
      ApiUtil.wrapCallbackFail(this.val$req.event, null);
    }
    l = paramJSONObject.optLong("retCode");
    localObject = paramJSONObject.optString("errMsg");
    QMLog.e("BookShelfJsPlugin", "handleQueryBookshelf fail, retCode: " + l + "; errMsg : " + (String)localObject);
    this.val$req.fail(paramJSONObject, null);
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BookShelfJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */