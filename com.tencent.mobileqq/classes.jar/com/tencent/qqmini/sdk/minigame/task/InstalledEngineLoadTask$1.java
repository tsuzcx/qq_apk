package com.tencent.qqmini.sdk.minigame.task;

import android.os.Bundle;
import bgpn;
import bgvg;
import bgvh;
import bgwc;
import java.util.concurrent.atomic.AtomicInteger;

public class InstalledEngineLoadTask$1
  implements Runnable
{
  public InstalledEngineLoadTask$1(bgvg parambgvg) {}
  
  public void run()
  {
    bgwc.a().i(bgvg.a(this.this$0), "[MiniEng]rebindChannelIfNecessary ackCount:" + bgvg.a(this.this$0).get());
    if (bgvg.a(this.this$0).get() < 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("bundle_key_app_type", 1);
      bgpn.a().a("cmd_rebind_engine_channel", localBundle, new bgvh(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.task.InstalledEngineLoadTask.1
 * JD-Core Version:    0.7.0.1
 */