package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.Set;

final class GamePreConnectManager$3
  implements Runnable
{
  GamePreConnectManager$3(String paramString) {}
  
  public void run()
  {
    if (GamePreConnectManager.access$000())
    {
      GameLog.getInstance().e("GamePreConnectManager", "had saved, no saved needed");
      return;
    }
    if ((!GamePreConnectManager.access$100().isEmpty()) && (!TextUtils.isEmpty(this.val$appId)))
    {
      Object localObject = TextUtils.join(",", GamePreConnectManager.access$100());
      GamePreConnectManager.access$400("MiniGamePreConnect", this.val$appId, (String)localObject);
      localObject = GameLog.getInstance();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("save connect host ");
      localStringBuilder.append(GamePreConnectManager.access$100().size());
      ((GameLog)localObject).i("GamePreConnectManager", localStringBuilder.toString());
      GamePreConnectManager.access$100().clear();
      GamePreConnectManager.access$002(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.3
 * JD-Core Version:    0.7.0.1
 */