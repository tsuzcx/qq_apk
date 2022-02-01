package com.tencent.mobileqq.triton.internal.script;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class CodeCacheSaver$mTaskRunnable$1
  implements Runnable
{
  CodeCacheSaver$mTaskRunnable$1(CodeCacheSaver paramCodeCacheSaver) {}
  
  public final void run()
  {
    CodeCacheSaver.access$saveCodeCacheIfNeeded(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.CodeCacheSaver.mTaskRunnable.1
 * JD-Core Version:    0.7.0.1
 */