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
      localObject = paramJSONObject.getJSONObject("metaData").getJSONObject("detail_1");
      this.val$favoritesData.entryPath = ((JSONObject)localObject).optString("url");
      localObject = new JSONObject();
      ((JSONObject)localObject).put("appName", paramJSONObject.optString("appName"));
      ((JSONObject)localObject).put("appView", paramJSONObject.optString("appView"));
      ((JSONObject)localObject).put("metaData", paramJSONObject.optJSONObject("metaData"));
      ((JSONObject)localObject).put("appMinVersion", paramJSONObject.optString("ver"));
      ((JSONObject)localObject).put("appConfig", paramJSONObject.optJSONObject("config"));
      ((JSONObject)localObject).put("promptText", paramJSONObject.optString("prompt"));
      this.val$favoritesData.bizDataList = ((JSONObject)localObject).toString();
      FavoritesJsPlugin.access$000(this.val$favoritesData, this.val$req);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      Object localObject;
      QMLog.e("FavoritesJsPlugin", "addFavorites AsyncResult", paramJSONObject);
      FavoritesJsPlugin.access$100(this.this$0, "收藏失败，请稍后重试");
      this.val$req.fail(paramJSONObject.getMessage());
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("addFavorites AsyncResult isSuc = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ret = ");
    ((StringBuilder)localObject).append(paramJSONObject);
    QMLog.d("FavoritesJsPlugin", ((StringBuilder)localObject).toString());
    if (paramJSONObject != null)
    {
      paramJSONObject = paramJSONObject.getString("errMsg");
      FavoritesJsPlugin.access$100(this.this$0, paramJSONObject);
      this.val$req.fail(paramJSONObject);
      return;
    }
    FavoritesJsPlugin.access$100(this.this$0, "收藏失败，请稍后重试");
    this.val$req.fail("request no response");
    return;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */