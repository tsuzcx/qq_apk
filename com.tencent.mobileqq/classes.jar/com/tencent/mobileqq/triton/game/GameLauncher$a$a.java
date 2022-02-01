package com.tencent.mobileqq.triton.game;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import org.json.JSONObject;

class GameLauncher$a$a
  implements Runnable
{
  GameLauncher$a$a(GameLauncher.a parama) {}
  
  public void run()
  {
    long l = SystemClock.uptimeMillis();
    if (GameLauncher.e(this.a.b).gameConfigJson != null) {
      GameLauncher.b(this.a.b).getJsRuntime(1).evaluateJs("var __wxConfig = __wxConfig || {}; __wxConfig.gameJson=" + GameLauncher.e(this.a.b).gameConfigJson.toString());
    }
    Object localObject = "var __wxConfig = __wxConfig || {}; __wxConfig.envVersion = '" + GameLauncher.b(this.a.b).l().getGameEnvVersion() + "'";
    GameLauncher.b(this.a.b).getJsRuntime(1).evaluateJs((String)localObject);
    GameLauncher.b(this.a.b).getJsRuntime(2).evaluateJs((String)localObject);
    if ((GameLauncher.e(this.a.b).gameConfigJson != null) && ("true".equals(GameLauncher.e(this.a.b).gameConfigJson.optString("enableWebglPlus", null)))) {
      GameLauncher.b(this.a.b).getJsRuntime(1).evaluateJs("  if (typeof global.enableTTWebglPlus == \"function\" ) {\n    global.enableTTWebglPlus()\n  }");
    }
    GameLauncher.b(this.a.b).getJsRuntime(1).evaluateJs("window = undefined");
    GameLauncher.b(this.a.b).getJsRuntime(2).evaluateJs("window = undefined");
    TTLog.c("GameLauncher", "start launch game [" + GameLauncher.e(this.a.b).gameId + "]");
    localObject = this.a.b;
    GameLauncher.b((GameLauncher)localObject, GameLauncher.e((GameLauncher)localObject));
    localObject = this.a.b;
    GameLauncher.c((GameLauncher)localObject, GameLauncher.e((GameLauncher)localObject));
    l = SystemClock.uptimeMillis() - l;
    TTLog.c("GameLauncher", "launch game [" + GameLauncher.e(this.a.b).gameId + "] cost time:" + l + "ms");
    localObject = this.a.b;
    ((GameLauncher)localObject).a(l, GameLauncher.d((GameLauncher)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.a.a
 * JD-Core Version:    0.7.0.1
 */