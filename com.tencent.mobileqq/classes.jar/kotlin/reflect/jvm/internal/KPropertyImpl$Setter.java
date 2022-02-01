package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty.Setter;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertySetterDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Setter;", "R", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "", "Lkotlin/reflect/KMutableProperty$Setter;", "()V", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "name", "", "getName", "()Ljava/lang/String;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class KPropertyImpl$Setter<R>
  extends KPropertyImpl.Accessor<R, Unit>
  implements KMutableProperty.Setter<R>
{
  @NotNull
  private final ReflectProperties.LazyVal caller$delegate = ReflectProperties.lazy((Function0)new KPropertyImpl.Setter.caller.2(this));
  @NotNull
  private final ReflectProperties.LazySoftVal descriptor$delegate = ReflectProperties.lazySoft((Function0)new KPropertyImpl.Setter.descriptor.2(this));
  
  @NotNull
  public Caller<?> getCaller()
  {
    return (Caller)this.caller$delegate.getValue(this, $$delegatedProperties[1]);
  }
  
  @NotNull
  public PropertySetterDescriptor getDescriptor()
  {
    return (PropertySetterDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public String getName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<set-");
    localStringBuilder.append(getProperty().getName());
    localStringBuilder.append('>');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl.Setter
 * JD-Core Version:    0.7.0.1
 */