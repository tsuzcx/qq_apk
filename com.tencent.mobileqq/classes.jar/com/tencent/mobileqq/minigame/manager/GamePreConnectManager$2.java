package com.tencent.mobileqq.minigame.manager;

import android.text.TextUtils;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.Set;

final class GamePreConnectManager$2
  implements Runnable
{
  GamePreConnectManager$2(int paramInt, String paramString) {}
  
  public void run()
  {
    if (GamePreConnectManager.access$000()) {
      return;
    }
    if (GamePreConnectManager.access$100().size() >= GamePreConnectManager.access$200()) {
      return;
    }
    int i = this.val$returnCode;
    if (i >= 200)
    {
      if (i > 300) {
        return;
      }
      String str = GamePreConnectManager.access$300(this.val$url);
      if ((!TextUtils.isEmpty(str)) && (GamePreConnectManager.access$100().add(str)))
      {
        GameLog localGameLog = GameLog.getInstance();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("insert host: ");
        localStringBuilder.append(str);
        localGameLog.i("GamePreConnectManager", localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GamePreConnectManager.2
 * JD-Core Version:    0.7.0.1
 */