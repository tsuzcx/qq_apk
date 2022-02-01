package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorFactory;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "R", "invoke"}, k=3, mv={1, 1, 16})
final class KPropertyImpl$Setter$descriptor$2
  extends Lambda
  implements Function0<PropertySetterDescriptor>
{
  KPropertyImpl$Setter$descriptor$2(KPropertyImpl.Setter paramSetter)
  {
    super(0);
  }
  
  @NotNull
  public final PropertySetterDescriptor invoke()
  {
    PropertySetterDescriptor localPropertySetterDescriptor = this.this$0.getProperty().getDescriptor().getSetter();
    if (localPropertySetterDescriptor != null) {
      return localPropertySetterDescriptor;
    }
    return (PropertySetterDescriptor)DescriptorFactory.createDefaultSetter(this.this$0.getProperty().getDescriptor(), Annotations.Companion.getEMPTY(), Annotations.Companion.getEMPTY());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl.Setter.descriptor.2
 * JD-Core Version:    0.7.0.1
 */