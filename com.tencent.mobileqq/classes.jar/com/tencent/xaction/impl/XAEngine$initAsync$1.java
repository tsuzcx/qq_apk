package com.tencent.xaction.impl;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initAsync$1
  implements Runnable
{
  XAEngine$initAsync$1(XAEngine paramXAEngine, String paramString, Function0 paramFunction0) {}
  
  public final void run()
  {
    XAEngine localXAEngine = this.this$0;
    XAEngine.access$setAnimData$p(localXAEngine, XAEngine.access$parseJson(localXAEngine, this.a));
    XAEngine.access$postMainThread(this.this$0, (Runnable)new XAEngine.initAsync.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initAsync.1
 * JD-Core Version:    0.7.0.1
 */