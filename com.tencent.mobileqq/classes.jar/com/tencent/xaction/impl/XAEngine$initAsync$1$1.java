package com.tencent.xaction.impl;

import com.tencent.xaction.api.data.AnimData;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class XAEngine$initAsync$1$1
  implements Runnable
{
  XAEngine$initAsync$1$1(XAEngine.initAsync.1 param1) {}
  
  public final void run()
  {
    if (!XAEngine.access$compareVersion(this.this$0.this$0))
    {
      localObject = this.this$0.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init faild versionMin:");
      AnimData localAnimData = XAEngine.access$getAnimData$p(this.this$0.this$0);
      if (localAnimData == null) {
        Intrinsics.throwNpe();
      }
      localStringBuilder.append(localAnimData.getVersionMin());
      localStringBuilder.append(" VERSION_CODE:");
      localStringBuilder.append(this.this$0.this$0.getVERSION_CODE());
      ((XAEngine)localObject).logi("XAEngine", 1, localStringBuilder.toString());
      return;
    }
    Object localObject = XAEngine.access$getAnimData$p(this.this$0.this$0);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((AnimData)localObject).getEles();
    if (localObject != null) {
      this.this$0.this$0.init((ArrayList)localObject);
    }
    this.this$0.a.invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.impl.XAEngine.initAsync.1.1
 * JD-Core Version:    0.7.0.1
 */