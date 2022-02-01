package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class GameCloseManager$ChangeAllOnClickListener$1
  implements MiniAppCmdInterface
{
  GameCloseManager$ChangeAllOnClickListener$1(GameCloseManager.ChangeAllOnClickListener paramChangeAllOnClickListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null) && (GameCloseManager.ChangeAllOnClickListener.access$000(this.this$0) != null)) {
      try
      {
        ArrayList localArrayList = GameCloseManager.access$400(paramJSONObject);
        if ((localArrayList != null) && (localArrayList.size() >= 3))
        {
          this.this$0.ext = GameCloseManager.access$500(paramJSONObject);
          GameCloseManager.ChangeAllOnClickListener.access$000(this.this$0).runOnUiThread(new GameCloseManager.ChangeAllOnClickListener.1.1(this, localArrayList));
          return;
        }
        QLog.w("GameCloseManager", 1, "useUserApp, recommendApps == null || recommendApps.size() < RETAIN_RECOMMEND_APP_NUM");
        return;
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("GameCloseManager", 1, "useUserApp, useUserApp request JSONException ", paramJSONObject);
        return;
      }
    }
    QLog.w("GameCloseManager", 1, "useUserApp, !isSuc || ret == null || gameActivity == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.ChangeAllOnClickListener.1
 * JD-Core Version:    0.7.0.1
 */