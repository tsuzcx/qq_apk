package com.tencent.qqmini.sdk.action;

import android.os.Bundle;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import org.json.JSONException;
import org.json.JSONObject;

@MiniKeep
public class FavoritesAction
  implements Action<Boolean>
{
  public static final int ADD_FAVORITES = 1;
  private Bundle data;
  private int what;
  
  private int getCurrPageId(IMiniAppContext paramIMiniAppContext)
  {
    return PageAction.obtain(paramIMiniAppContext).getPageId();
  }
  
  private String getCurrPageUrl(IMiniAppContext paramIMiniAppContext)
  {
    return PageAction.obtain(paramIMiniAppContext).getPageUrl();
  }
  
  private void handleAddFavorites(BaseRuntime paramBaseRuntime, ShareState paramShareState)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      int i = paramShareState.launchFrom;
      if (i == 1) {
        localJSONObject.put("fromFavoritesButton", 1);
      } else {
        localJSONObject.put("fromFavoritesButton", 0);
      }
      if ((!paramBaseRuntime.isMiniGame()) && (getCurrPageUrl(paramBaseRuntime) != null)) {
        localJSONObject.put("webviewUrl", getCurrPageUrl(paramBaseRuntime));
      }
    }
    catch (JSONException paramShareState)
    {
      QMLog.e("Action", "on add favorite click exception ", paramShareState);
    }
    paramShareState = paramBaseRuntime.getJsService();
    if (paramShareState != null)
    {
      paramShareState.evaluateSubscribeJS("onAddToFavorites", localJSONObject.toString(), getCurrPageId(paramBaseRuntime));
      return;
    }
    QMLog.e("Action", "on add favorite click exception mGameJsPluginEngine == null");
  }
  
  public static FavoritesAction obtain(int paramInt)
  {
    return obtain(paramInt, null);
  }
  
  public static FavoritesAction obtain(int paramInt, Bundle paramBundle)
  {
    FavoritesAction localFavoritesAction = new FavoritesAction();
    localFavoritesAction.what = paramInt;
    localFavoritesAction.data = paramBundle;
    return localFavoritesAction;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    ShareState localShareState = paramBaseRuntime.getShareState();
    Boolean localBoolean = Boolean.valueOf(false);
    if (localShareState == null)
    {
      paramBaseRuntime = new StringBuilder();
      paramBaseRuntime.append("Failed to perform ");
      paramBaseRuntime.append(this);
      paramBaseRuntime.append(". shareState is null");
      QMLog.e("Action", paramBaseRuntime.toString());
      return localBoolean;
    }
    if (paramBaseRuntime.getPage() == null)
    {
      paramBaseRuntime = new StringBuilder();
      paramBaseRuntime.append("Failed to perform ");
      paramBaseRuntime.append(this);
      paramBaseRuntime.append(". page is null");
      QMLog.e("Action", paramBaseRuntime.toString());
      return localBoolean;
    }
    if (this.what == 1) {
      handleAddFavorites(paramBaseRuntime, localShareState);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.action.FavoritesAction
 * JD-Core Version:    0.7.0.1
 */