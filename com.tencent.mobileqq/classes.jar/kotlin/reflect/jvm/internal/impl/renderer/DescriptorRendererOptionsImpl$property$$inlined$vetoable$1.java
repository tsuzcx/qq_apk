package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRendererOptionsImpl$property$$inlined$vetoable$1
  extends ObservableProperty<T>
{
  public DescriptorRendererOptionsImpl$property$$inlined$vetoable$1(Object paramObject1, Object paramObject2, DescriptorRendererOptionsImpl paramDescriptorRendererOptionsImpl)
  {
    super(paramObject2);
  }
  
  protected boolean beforeChange(@NotNull KProperty<?> paramKProperty, T paramT1, T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    if (!this.this$0.isLocked()) {
      return true;
    }
    throw ((Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptionsImpl.property..inlined.vetoable.1
 * JD-Core Version:    0.7.0.1
 */