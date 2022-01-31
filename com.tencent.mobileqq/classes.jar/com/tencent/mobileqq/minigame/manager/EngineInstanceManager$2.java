package com.tencent.mobileqq.minigame.manager;

import android.os.Bundle;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

class EngineInstanceManager$2
  implements Runnable
{
  EngineInstanceManager$2(EngineInstanceManager paramEngineInstanceManager) {}
  
  public void run()
  {
    QLog.e("EngineInstanceManager", 1, new Object[] { "rebindChannelIfNecessary ackCount:", Integer.valueOf(EngineInstanceManager.access$100(this.this$0).get()) });
    if (EngineInstanceManager.access$100(this.this$0).get() < 1)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("bundle_key_app_type", 1);
      AppBrandProxy.g().sendCmd("cmd_rebind_engine_channel", localBundle, new EngineInstanceManager.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.EngineInstanceManager.2
 * JD-Core Version:    0.7.0.1
 */