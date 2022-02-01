package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.InnerFavoritesData;
import org.json.JSONException;
import org.json.JSONObject;

class FavoritesJsPlugin$1
  implements AsyncResult
{
  FavoritesJsPlugin$1(FavoritesJsPlugin paramFavoritesJsPlugin, InnerFavoritesData paramInnerFavoritesData, RequestEvent paramRequestEvent) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject("metaData").getJSONObject("detail_1");
      this.val$favoritesData.entryPath = localJSONObject.optString("url");
      localJSONObject = new JSONObject();
      localJSONObject.put("appName", paramJSONObject.optString("appName"));
      localJSONObject.put("appView", paramJSONObject.optString("appView"));
      localJSONObject.put("metaData", paramJSONObject.optJSONObject("metaData"));
      localJSONObject.put("appMinVersion", paramJSONObject.optString("ver"));
      localJSONObject.put("appConfig", paramJSONObject.optJSONObject("config"));
      localJSONObject.put("promptText", paramJSONObject.optString("prompt"));
      this.val$favoritesData.bizDataList = localJSONObject.toString();
      FavoritesJsPlugin.access$000(this.val$favoritesData, this.val$req);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      QMLog.e("FavoritesJsPlugin", "addFavorites AsyncResult", paramJSONObject);
      FavoritesJsPlugin.access$100(this.this$0, "收藏失败，请稍后重试");
      this.val$req.fail(paramJSONObject.getMessage());
      return;
    }
    QMLog.d("FavoritesJsPlugin", "addFavorites AsyncResult isSuc = " + paramBoolean + " ret = " + paramJSONObject);
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getString("errMsg");
      FavoritesJsPlugin.access$100(this.this$0, paramJSONObject);
      this.val$req.fail(paramJSONObject);
      return;
    }
    FavoritesJsPlugin.access$100(this.this$0, "收藏失败，请稍后重试");
    this.val$req.fail("request no response");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */