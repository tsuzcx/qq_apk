package com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class InitingState$init$1
  extends Lambda
  implements Function0<Unit>
{
  InitingState$init$1(InitingState paramInitingState)
  {
    super(0);
  }
  
  public final void invoke()
  {
    if (this.this$0.b().get() < 4) {
      this.this$0.a(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.base.video.statemachine.InitingState.init.1
 * JD-Core Version:    0.7.0.1
 */