package com.tencent.xaction.impl;

import com.tencent.xaction.api.data.AnimData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initFromFileAsync$1$1
  implements Runnable
{
  XAEngine$initFromFileAsync$1$1(XAEngine.initFromFileAsync.1 param1) {}
  
  public final void run()
  {
    Object localObject;
    if (!XAEngine.access$compareVersion(this.this$0.this$0))
    {
      localObject = this.this$0.this$0;
      StringBuilder localStringBuilder = new StringBuilder().append("init faild versionMin:");
      AnimData localAnimData = XAEngine.access$getAnimData$p(this.this$0.this$0);
      if (localAnimData == null) {
        Intrinsics.throwNpe();
      }
      ((XAEngine)localObject).logi("XAEngine", 1, localAnimData.getVersionMin() + " VERSION_CODE:" + this.this$0.this$0.getVERSION_CODE());
    }
    do
    {
      return;
      localObject = XAEngine.access$getAnimData$p(this.this$0.this$0);
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((AnimData)localObject).getEles();
    } while (localObject == null);
    this.this$0.this$0.init((ArrayList)localObject);
    this.this$0.a.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initFromFileAsync.1.1
 * JD-Core Version:    0.7.0.1
 */