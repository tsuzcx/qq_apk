package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class BookShelfJsPlugin$6
  implements MiniAppCmdInterface
{
  BookShelfJsPlugin$6(BookShelfJsPlugin paramBookShelfJsPlugin, String paramString, JsRuntime paramJsRuntime, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    try
    {
      JSONObject localJSONObject = ApiUtil.wrapCallbackOk(this.val$eventName, null);
      localJSONObject.putOpt("data", paramJSONObject.optString("key_result_data"));
      this.val$webview.evaluateCallbackJs(this.val$callbackId, localJSONObject.toString());
      return;
    }
    catch (Throwable paramJSONObject)
    {
      QLog.e("BookShelfJsPlugin", 1, "handleInsertBookshelf exception: ", paramJSONObject);
      paramJSONObject = ApiUtil.wrapCallbackFail(this.val$eventName, null);
      this.val$webview.evaluateCallbackJs(this.val$callbackId, paramJSONObject.toString());
    }
    QLog.e("BookShelfJsPlugin", 1, "handleUpdateBookshelf fail");
    paramJSONObject = ApiUtil.wrapCallbackFail(this.val$eventName, null);
    this.val$webview.evaluateCallbackJs(this.val$callbackId, paramJSONObject.toString());
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BookShelfJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */