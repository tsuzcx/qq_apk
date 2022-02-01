package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qshadow.utils.QShadowSender;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.EnterCallback;

class DefaultPluginManager$1
  implements Runnable
{
  DefaultPluginManager$1(DefaultPluginManager paramDefaultPluginManager, long paramLong, Bundle paramBundle, Context paramContext, EnterCallback paramEnterCallback) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (this.this$0)
      {
        if (!this.this$0.isPluginInstalled())
        {
          if (DefaultPluginManager.access$000(this.this$0).isInfoEnabled()) {
            DefaultPluginManager.access$000(this.this$0).info("installPlugin " + DefaultPluginManager.access$100(this.this$0));
          }
          this.this$0.installPlugin();
          this.this$0.beforeEnter(this.val$fromId, this.val$bundle);
        }
      }
      try
      {
        DefaultPluginManager.access$300(this.this$0).enter(this.val$context, this.val$fromId, this.val$bundle, this.val$callback);
        DefaultPluginManager.access$402(this.this$0, 0);
        this.this$0.afterEnter(this.val$fromId, this.val$bundle);
        return;
        if (this.this$0.isPluginRunning()) {
          continue;
        }
        if (DefaultPluginManager.access$000(this.this$0).isInfoEnabled()) {
          DefaultPluginManager.access$000(this.this$0).info("initPluginManager" + DefaultPluginManager.access$100(this.this$0));
        }
        DefaultPluginManager.access$200(this.this$0);
        continue;
        localObject = finally;
        throw localObject;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          DefaultPluginManager.access$000(this.this$0).warn("enter error retryCount: " + DefaultPluginManager.access$400(this.this$0), localException);
          this.this$0.release();
          if (DefaultPluginManager.access$400(this.this$0) < 2)
          {
            try
            {
              Thread.sleep(1500L);
              DefaultPluginManager.access$408(this.this$0);
              this.this$0.enter(this.val$context, this.val$fromId, this.val$bundle, this.val$callback);
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
            }
          }
          else
          {
            DefaultPluginManager.access$402(this.this$0, 0);
            PluginRuntime.handleCrash(localInterruptedException, DefaultPluginManager.access$100(this.this$0), DefaultPluginManager.access$500(this.this$0));
            QShadowSender.a(DefaultPluginManager.access$500(this.this$0), DefaultPluginManager.access$100(this.this$0), localInterruptedException, 4001);
            DefaultPluginManager.access$000(this.this$0).error("exceed max retry count, throw exception!", localInterruptedException);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.DefaultPluginManager.1
 * JD-Core Version:    0.7.0.1
 */