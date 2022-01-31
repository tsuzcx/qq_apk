package com.tencent.mobileqq.triton.game;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.ITTEngine.IListener;
import com.tencent.mobileqq.triton.sdk.bridge.ITTJSRuntime;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import org.json.JSONObject;

class GameLauncher$1
  implements Runnable
{
  GameLauncher$1(GameLauncher paramGameLauncher) {}
  
  public void run()
  {
    long l = SystemClock.uptimeMillis();
    if ((GameLauncher.access$000(this.this$0) != null) && (GameLauncher.access$000(this.this$0).gameConfigJson != null)) {
      GameLauncher.access$100(this.this$0).getJsRuntime(1).evaluateJs("var __wxConfig = __wxConfig || {}; __wxConfig.gameJson=" + GameLauncher.access$000(this.this$0).gameConfigJson.toString());
    }
    Object localObject = "var __wxConfig = __wxConfig || {}; __wxConfig.envVersion = '" + GameLauncher.access$100(this.this$0).getQQEnv().getGameEnvVersion() + "'";
    GameLauncher.access$100(this.this$0).getJsRuntime(1).evaluateJs((String)localObject);
    GameLauncher.access$100(this.this$0).getJsRuntime(2).evaluateJs((String)localObject);
    if ((GameLauncher.access$000(this.this$0) != null) && (GameLauncher.access$000(this.this$0).gameConfigJson != null) && ("true".equals(GameLauncher.access$000(this.this$0).gameConfigJson.optString("enableWebglPlus", null)))) {
      GameLauncher.access$100(this.this$0).getJsRuntime(1).evaluateJs("  if (typeof global.enableTTWebglPlus == \"function\" ) {\n    global.enableTTWebglPlus()\n  }");
    }
    GameLauncher.access$100(this.this$0).getJsRuntime(1).evaluateJs("window = undefined");
    GameLauncher.access$100(this.this$0).getJsRuntime(2).evaluateJs("window = undefined");
    TTLog.i("GameLauncher", "start launch game [" + GameLauncher.access$000(this.this$0).gameId + "]");
    GameLauncher.access$200(this.this$0, GameLauncher.access$000(this.this$0));
    int i = GameLauncher.access$300(this.this$0, GameLauncher.access$000(this.this$0));
    l = SystemClock.uptimeMillis() - l;
    TTLog.i("GameLauncher", "launch game [" + GameLauncher.access$000(this.this$0).gameId + "] cost time:" + l + "ms");
    localObject = GameLauncher.access$100(this.this$0).getEngineListener();
    if (localObject != null) {
      ((ITTEngine.IListener)localObject).onGameLaunched(i, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.1
 * JD-Core Version:    0.7.0.1
 */