package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererImpl$renderSuperTypes$1
  extends Lambda
  implements Function1<KotlinType, String>
{
  DescriptorRendererImpl$renderSuperTypes$1(DescriptorRendererImpl paramDescriptorRendererImpl)
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(KotlinType paramKotlinType)
  {
    DescriptorRendererImpl localDescriptorRendererImpl = this.this$0;
    Intrinsics.checkExpressionValueIsNotNull(paramKotlinType, "it");
    return localDescriptorRendererImpl.renderType(paramKotlinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.renderSuperTypes.1
 * JD-Core Version:    0.7.0.1
 */