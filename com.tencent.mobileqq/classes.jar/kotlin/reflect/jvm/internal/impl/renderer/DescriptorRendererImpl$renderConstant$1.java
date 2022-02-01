package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererImpl$renderConstant$1
  extends Lambda
  implements Function1<ConstantValue<?>, String>
{
  DescriptorRendererImpl$renderConstant$1(DescriptorRendererImpl paramDescriptorRendererImpl)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull ConstantValue<?> paramConstantValue)
  {
    Intrinsics.checkParameterIsNotNull(paramConstantValue, "it");
    return DescriptorRendererImpl.access$renderConstant(this.this$0, paramConstantValue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderConstant.1
 * JD-Core Version:    0.7.0.1
 */