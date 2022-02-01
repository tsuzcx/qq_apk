package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class DescriptorRendererImpl$functionTypeAnnotationsRenderer$2
  extends Lambda
  implements Function0<DescriptorRendererImpl>
{
  DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(DescriptorRendererImpl paramDescriptorRendererImpl)
  {
    super(0);
  }
  
  @NotNull
  public final DescriptorRendererImpl invoke()
  {
    DescriptorRenderer localDescriptorRenderer = this.this$0.withOptions((Function1)DescriptorRendererImpl.functionTypeAnnotationsRenderer.2.1.INSTANCE);
    if (localDescriptorRenderer != null) {
      return (DescriptorRendererImpl)localDescriptorRenderer;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.functionTypeAnnotationsRenderer.2
 * JD-Core Version:    0.7.0.1
 */