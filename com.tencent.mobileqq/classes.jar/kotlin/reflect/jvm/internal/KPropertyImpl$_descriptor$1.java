package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KPropertyImpl$_descriptor$1
  extends Lambda
  implements Function0<PropertyDescriptor>
{
  KPropertyImpl$_descriptor$1(KPropertyImpl paramKPropertyImpl)
  {
    super(0);
  }
  
  @NotNull
  public final PropertyDescriptor invoke()
  {
    return this.this$0.getContainer().findPropertyDescriptor(this.this$0.getName(), this.this$0.getSignature());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl._descriptor.1
 * JD-Core Version:    0.7.0.1
 */