package com.tencent.qqmini.sdk.minigame.task;

import android.os.Bundle;
import bepk;
import bewp;
import bewq;
import bexk;
import java.util.concurrent.atomic.AtomicInteger;

public class GameEngineLoadTask$1
  implements Runnable
{
  public GameEngineLoadTask$1(bewp parambewp) {}
  
  public void run()
  {
    bexk.a().i("EngineLoadTask", "[MiniEng]rebindChannelIfNecessary ackCount:" + bewp.a(this.this$0).get());
    if (bewp.a(this.this$0).get() < 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("bundle_key_app_type", 1);
      bepk.a().a("cmd_rebind_engine_channel", localBundle, new bewq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.task.GameEngineLoadTask.1
 * JD-Core Version:    0.7.0.1
 */