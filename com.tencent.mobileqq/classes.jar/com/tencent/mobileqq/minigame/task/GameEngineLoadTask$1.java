package com.tencent.mobileqq.minigame.task;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.minigame.utils.GameLog;
import java.util.concurrent.atomic.AtomicInteger;

class GameEngineLoadTask$1
  implements Runnable
{
  GameEngineLoadTask$1(GameEngineLoadTask paramGameEngineLoadTask) {}
  
  public void run()
  {
    GameLog.getInstance().e("EngineLoadTask", "[MiniEng]rebindChannelIfNecessary ackCount:" + GameEngineLoadTask.access$000(this.this$0).get());
    if (GameEngineLoadTask.access$000(this.this$0).get() < 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("bundle_key_app_type", 1);
      AppBrandProxy.g().sendCmd("cmd_rebind_engine_channel", localBundle, new GameEngineLoadTask.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.task.GameEngineLoadTask.1
 * JD-Core Version:    0.7.0.1
 */