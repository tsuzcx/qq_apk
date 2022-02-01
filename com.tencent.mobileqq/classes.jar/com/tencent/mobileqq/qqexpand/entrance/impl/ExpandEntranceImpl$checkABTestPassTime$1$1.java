package com.tencent.mobileqq.qqexpand.entrance.impl;

import com.tencent.mobileqq.qqexpand.config.IConfigCallback;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.LongRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "success", "", "onFinish"}, k=3, mv={1, 1, 16})
final class ExpandEntranceImpl$checkABTestPassTime$1$1
  implements IConfigCallback
{
  ExpandEntranceImpl$checkABTestPassTime$1$1(ExpandEntranceImpl.checkABTestPassTime.1 param1, Ref.LongRef paramLongRef) {}
  
  public final void a(boolean paramBoolean)
  {
    ExpandEntranceImpl localExpandEntranceImpl = this.a.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getABTestConfig success ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ExpandEntranceImpl", 1, localStringBuilder.toString());
    ExpandEntranceImpl.access$reportGetAbTestCost(localExpandEntranceImpl, paramBoolean, this.b.element);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.entrance.impl.ExpandEntranceImpl.checkABTestPassTime.1.1
 * JD-Core Version:    0.7.0.1
 */