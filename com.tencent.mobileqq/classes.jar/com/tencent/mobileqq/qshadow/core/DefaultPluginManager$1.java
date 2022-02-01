package com.tencent.mobileqq.qshadow.core;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.pluginsdk.PluginRuntime;
import com.tencent.mobileqq.qshadow.interfaces.IPluginOpenListener;
import com.tencent.mobileqq.qshadow.utils.QShadowSender;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import com.tencent.shadow.dynamic.host.QShadowLoadInfo;

class DefaultPluginManager$1
  implements Runnable
{
  DefaultPluginManager$1(DefaultPluginManager paramDefaultPluginManager, long paramLong, Bundle paramBundle, Context paramContext, IPluginOpenListener paramIPluginOpenListener) {}
  
  public void run()
  {
    Object localObject3;
    synchronized (this.this$0)
    {
      Object localObject6;
      if (!this.this$0.isPluginInstalled())
      {
        if (DefaultPluginManager.access$000(this.this$0).isWarnEnabled())
        {
          localObject4 = DefaultPluginManager.access$000(this.this$0);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("installPlugin ");
          ((StringBuilder)localObject6).append(DefaultPluginManager.access$100(this.this$0));
          ((Logger)localObject4).warn(((StringBuilder)localObject6).toString());
        }
        this.this$0.installPlugin();
      }
      else if (!this.this$0.isPluginRunning())
      {
        if (DefaultPluginManager.access$000(this.this$0).isWarnEnabled())
        {
          localObject4 = DefaultPluginManager.access$000(this.this$0);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("initPluginManager");
          ((StringBuilder)localObject6).append(DefaultPluginManager.access$100(this.this$0));
          ((Logger)localObject4).warn(((StringBuilder)localObject6).toString());
        }
        DefaultPluginManager.access$200(this.this$0);
      }
      this.this$0.beforeEnter(this.val$fromId, this.val$bundle);
      Object localObject4 = null;
      try
      {
        DefaultPluginManager.access$300(this.this$0).enter(this.val$context, this.val$fromId, this.val$bundle, null);
        DefaultPluginManager.access$402(this.this$0, 0);
        Object localObject2;
        try
        {
          ??? = (QShadowLoadInfo)this.val$bundle.getParcelable("QShadowLoadInfo");
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          localObject2 = null;
        }
        localObject6 = DefaultPluginManager.access$000(this.this$0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("load plugin ");
        localStringBuilder.append(DefaultPluginManager.access$100(this.this$0));
        localStringBuilder.append(" success info: ");
        localStringBuilder.append(localObject2);
        ((Logger)localObject6).warn(localStringBuilder.toString());
        if (this.val$listener != null) {
          this.val$listener.a(true, localObject2);
        }
      }
      catch (Exception localException2)
      {
        localObject6 = DefaultPluginManager.access$000(this.this$0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enter error retryCount: ");
        localStringBuilder.append(DefaultPluginManager.access$400(this.this$0));
        ((Logger)localObject6).warn(localStringBuilder.toString(), localException2);
        this.this$0.release();
        if (DefaultPluginManager.access$400(this.this$0) < 2)
        {
          try
          {
            Thread.sleep(1500L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          DefaultPluginManager.access$408(this.this$0);
          this.this$0.enter(this.val$context, this.val$fromId, this.val$bundle, this.val$listener);
        }
        else
        {
          DefaultPluginManager.access$402(this.this$0, 0);
          PluginRuntime.handleCrash(localInterruptedException, DefaultPluginManager.access$100(this.this$0), DefaultPluginManager.access$500(this.this$0));
          QShadowSender.a(DefaultPluginManager.access$500(this.this$0), DefaultPluginManager.access$100(this.this$0), localInterruptedException, 4001);
          DefaultPluginManager.access$000(this.this$0).error("exceed max retry count, throw exception!", localInterruptedException);
          try
          {
            QShadowLoadInfo localQShadowLoadInfo = (QShadowLoadInfo)this.val$bundle.getParcelable("QShadowLoadInfo");
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            localObject3 = localObject4;
          }
          localObject4 = DefaultPluginManager.access$000(this.this$0);
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("load plugin ");
          ((StringBuilder)localObject6).append(DefaultPluginManager.access$100(this.this$0));
          ((StringBuilder)localObject6).append(" failed info: ");
          ((StringBuilder)localObject6).append(localObject3);
          ((Logger)localObject4).warn(((StringBuilder)localObject6).toString());
          localObject4 = this.val$listener;
          if (localObject4 != null) {
            ((IPluginOpenListener)localObject4).a(false, localObject3);
          }
        }
      }
      this.this$0.afterEnter(this.val$fromId, this.val$bundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qshadow.core.DefaultPluginManager.1
 * JD-Core Version:    0.7.0.1
 */