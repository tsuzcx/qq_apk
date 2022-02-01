package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "", "newValue", "invoke"}, k=3, mv={1, 1, 16})
final class BKCMShowEngine$businessConfig$2$1
  extends Lambda
  implements Function3<KProperty<?>, Object, Object, Unit>
{
  BKCMShowEngine$businessConfig$2$1(BKCMShowEngine.businessConfig.2 param2)
  {
    super(3);
  }
  
  public final void invoke(@NotNull KProperty<?> paramKProperty, @NotNull Object paramObject1, @NotNull Object paramObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    Intrinsics.checkParameterIsNotNull(paramObject1, "oldValue");
    Intrinsics.checkParameterIsNotNull(paramObject2, "newValue");
    if (QLog.isColorLevel())
    {
      String str = BKCMShowEngine.a(this.this$0.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("BusinessConfig property:");
      localStringBuilder.append(paramKProperty.getName());
      localStringBuilder.append(" change from:");
      localStringBuilder.append(paramObject1);
      localStringBuilder.append(" to:");
      localStringBuilder.append(paramObject2);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (Intrinsics.areEqual(paramKProperty, BKCMShowEngine.businessConfig.2.1.1.INSTANCE)) {
      this.this$0.this$0.b().a(((Integer)paramObject2).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine.businessConfig.2.1
 * JD-Core Version:    0.7.0.1
 */