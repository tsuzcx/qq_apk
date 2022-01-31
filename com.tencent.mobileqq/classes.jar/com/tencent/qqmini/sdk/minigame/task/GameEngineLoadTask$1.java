package com.tencent.qqmini.sdk.minigame.task;

import android.os.Bundle;
import beot;
import bevy;
import bevz;
import bewt;
import java.util.concurrent.atomic.AtomicInteger;

public class GameEngineLoadTask$1
  implements Runnable
{
  public GameEngineLoadTask$1(bevy parambevy) {}
  
  public void run()
  {
    bewt.a().i("EngineLoadTask", "[MiniEng]rebindChannelIfNecessary ackCount:" + bevy.a(this.this$0).get());
    if (bevy.a(this.this$0).get() < 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("bundle_key_app_type", 1);
      beot.a().a("cmd_rebind_engine_channel", localBundle, new bevz(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.task.GameEngineLoadTask.1
 * JD-Core Version:    0.7.0.1
 */