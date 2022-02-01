package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.reflect.KFunction;
import kotlin.reflect.KProperty.Accessor;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyAccessorDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty$Accessor;", "Lkotlin/reflect/KFunction;", "()V", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getDefaultCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyAccessorDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "property", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "getProperty", "()Lkotlin/reflect/jvm/internal/KPropertyImpl;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class KPropertyImpl$Accessor<PropertyType, ReturnType>
  extends KCallableImpl<ReturnType>
  implements KFunction<ReturnType>, KProperty.Accessor<PropertyType>
{
  @NotNull
  public KDeclarationContainerImpl getContainer()
  {
    return getProperty().getContainer();
  }
  
  @Nullable
  public Caller<?> getDefaultCaller()
  {
    return null;
  }
  
  @NotNull
  public abstract PropertyAccessorDescriptor getDescriptor();
  
  @NotNull
  public abstract KPropertyImpl<PropertyType> getProperty();
  
  public boolean isBound()
  {
    return getProperty().isBound();
  }
  
  public boolean isExternal()
  {
    return getDescriptor().isExternal();
  }
  
  public boolean isInfix()
  {
    return getDescriptor().isInfix();
  }
  
  public boolean isInline()
  {
    return getDescriptor().isInline();
  }
  
  public boolean isOperator()
  {
    return getDescriptor().isOperator();
  }
  
  public boolean isSuspend()
  {
    return getDescriptor().isSuspend();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl.Accessor
 * JD-Core Version:    0.7.0.1
 */