package com.tencent.timi.game.api.impl;

import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.initer.api.InitCallback;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import com.tencent.timi.game.utils.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onInitFinish"}, k=3, mv={1, 1, 16})
final class TimiGameApp$startTask$initTaskWrapper$1$initTask$1$1
  implements InitCallback
{
  TimiGameApp$startTask$initTaskWrapper$1$initTask$1$1(TimiGameApp.startTask.initTaskWrapper.1.initTask.1 param1) {}
  
  public final void a(boolean paramBoolean)
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this.a.this$0.a.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ensureInitWithCallback ");
    localStringBuilder.append(System.currentTimeMillis() - this.a.this$0.b);
    localStringBuilder.append("ms");
    Logger.a("TimiGameApp_", localStringBuilder.toString());
    ((IniterService)ServiceCenter.a(IniterService.class)).a(1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("doWhenLaunchYesScenes ");
    localStringBuilder.append(System.currentTimeMillis() - this.a.this$0.b);
    localStringBuilder.append("ms");
    Logger.a("TimiGameApp_", localStringBuilder.toString());
    ((ITimiGameTimApi)ServiceCenter.a(ITimiGameTimApi.class)).a(null);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("login ");
    localStringBuilder.append(System.currentTimeMillis() - this.a.this$0.b);
    localStringBuilder.append("ms");
    Logger.a("TimiGameApp_", localStringBuilder.toString());
    this.a.this$0.c.a(this.a.a, (EmptyDialog)this.a.this$0.d.element, (AtomicBoolean)this.a.b.element, (AtomicBoolean)this.a.c.element);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.api.impl.TimiGameApp.startTask.initTaskWrapper.1.initTask.1.1
 * JD-Core Version:    0.7.0.1
 */