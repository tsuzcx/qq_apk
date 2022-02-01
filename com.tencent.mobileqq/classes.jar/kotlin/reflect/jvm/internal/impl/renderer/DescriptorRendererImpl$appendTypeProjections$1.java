package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererImpl$appendTypeProjections$1
  extends Lambda
  implements Function1<TypeProjection, CharSequence>
{
  DescriptorRendererImpl$appendTypeProjections$1(DescriptorRendererImpl paramDescriptorRendererImpl)
  {
    super(1);
  }
  
  @NotNull
  public final CharSequence invoke(@NotNull TypeProjection paramTypeProjection)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeProjection, "it");
    if (paramTypeProjection.isStarProjection()) {
      return (CharSequence)"*";
    }
    Object localObject1 = this.this$0;
    Object localObject2 = paramTypeProjection.getType();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.type");
    localObject1 = ((DescriptorRendererImpl)localObject1).renderType((KotlinType)localObject2);
    if (paramTypeProjection.getProjectionKind() == Variance.INVARIANT)
    {
      paramTypeProjection = (TypeProjection)localObject1;
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramTypeProjection.getProjectionKind());
      ((StringBuilder)localObject2).append(' ');
      ((StringBuilder)localObject2).append((String)localObject1);
      paramTypeProjection = ((StringBuilder)localObject2).toString();
    }
    return (CharSequence)paramTypeProjection;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.appendTypeProjections.1
 * JD-Core Version:    0.7.0.1
 */