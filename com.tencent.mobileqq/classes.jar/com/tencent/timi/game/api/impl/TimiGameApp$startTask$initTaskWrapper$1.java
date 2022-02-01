package com.tencent.timi.game.api.impl;

import android.content.DialogInterface;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import com.tencent.timi.game.utils.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TimiGameApp$startTask$initTaskWrapper$1
  implements Runnable
{
  TimiGameApp$startTask$initTaskWrapper$1(ExpandHallLaunchParam paramExpandHallLaunchParam, long paramLong, TimiGameApp.IStartTask paramIStartTask, Ref.ObjectRef paramObjectRef) {}
  
  public final void run()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Object localObject = new Ref.ObjectRef();
    ((Ref.ObjectRef)localObject).element = new AtomicBoolean(false);
    Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
    localObjectRef.element = new AtomicBoolean(false);
    ThreadManagerV2.excute((Runnable)new TimiGameApp.startTask.initTaskWrapper.1.initTask.1(this, localCountDownLatch, (Ref.ObjectRef)localObject, localObjectRef), 16, null, false);
    try
    {
      localCountDownLatch.await(1000L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException localInterruptedException2)
    {
      Logger.a("TimiGameApp_", "SHOW_LOADING_DURATION Time Out", (Throwable)localInterruptedException2);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sub thread activityAlreadyStart:");
    localStringBuilder.append(((AtomicBoolean)localObjectRef.element).get());
    Logger.a("TimiGameApp_", localStringBuilder.toString());
    if (!((AtomicBoolean)localObjectRef.element).get()) {
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new TimiGameApp.startTask.initTaskWrapper.1.1(this, localObjectRef));
    }
    try
    {
      localCountDownLatch.await(3000L, TimeUnit.MILLISECONDS);
    }
    catch (InterruptedException localInterruptedException1)
    {
      Logger.a("TimiGameApp_", "MAX_WAIT_DURATION Time Out", (Throwable)localInterruptedException1);
    }
    ((AtomicBoolean)((Ref.ObjectRef)localObject).element).set(true);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init task finished ");
    ((StringBuilder)localObject).append(System.currentTimeMillis() - this.b);
    ((StringBuilder)localObject).append("ms");
    Logger.a("TimiGameApp_", ((StringBuilder)localObject).toString());
    localObject = (EmptyDialog)this.d.element;
    if (localObject != null) {
      TimiGameApp.a(TimiGameApp.a, (DialogInterface)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.startTask.initTaskWrapper.1
 * JD-Core Version:    0.7.0.1
 */