package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererOptionsImpl$typeNormalizer$2
  extends Lambda
  implements Function1<KotlinType, KotlinType>
{
  public static final 2 INSTANCE = new 2();
  
  DescriptorRendererOptionsImpl$typeNormalizer$2()
  {
    super(1);
  }
  
  @NotNull
  public final KotlinType invoke(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "it");
    return paramKotlinType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.typeNormalizer.2
 * JD-Core Version:    0.7.0.1
 */