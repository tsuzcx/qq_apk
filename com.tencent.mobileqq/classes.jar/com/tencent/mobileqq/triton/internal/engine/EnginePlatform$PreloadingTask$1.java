package com.tencent.mobileqq.triton.internal.engine;

import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class EnginePlatform$PreloadingTask$1
  implements Runnable
{
  EnginePlatform$PreloadingTask$1(EnginePlatform.PreloadingTask paramPreloadingTask) {}
  
  public final void run()
  {
    this.this$0.getEngine().setValue(EnginePlatform.access$doCreateEngine(this.this$0.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.engine.EnginePlatform.PreloadingTask.1
 * JD-Core Version:    0.7.0.1
 */