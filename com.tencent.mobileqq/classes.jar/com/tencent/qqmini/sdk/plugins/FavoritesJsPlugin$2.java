package com.tencent.qqmini.sdk.plugins;

import android.os.Bundle;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.ipc.MiniCmdCallback.Stub;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

final class FavoritesJsPlugin$2
  extends MiniCmdCallback.Stub
{
  FavoritesJsPlugin$2(RequestEvent paramRequestEvent) {}
  
  public void onCmdResult(boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("sendAddFavoritesToQQ done succ = ");
    paramBundle.append(paramBoolean);
    QMLog.d("FavoritesJsPlugin", paramBundle.toString());
    if (paramBoolean)
    {
      this.val$req.ok();
      QMLog.d("FavoritesJsPlugin", "sendAddFavoritesToQQ ok");
      return;
    }
    this.val$req.fail();
    QMLog.d("FavoritesJsPlugin", "sendAddFavoritesToQQ fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FavoritesJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */