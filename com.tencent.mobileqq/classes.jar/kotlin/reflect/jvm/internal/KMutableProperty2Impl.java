package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty2;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/jvm/internal/KProperty2Impl;", "Lkotlin/reflect/KMutableProperty2;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty2Impl$Setter;", "set", "", "receiver1", "receiver2", "value", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KMutableProperty2Impl<D, E, R>
  extends KProperty2Impl<D, E, R>
  implements KMutableProperty2<D, E, R>
{
  private final ReflectProperties.LazyVal<KMutableProperty2Impl.Setter<D, E, R>> _setter;
  
  public KMutableProperty2Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2)
  {
    super(paramKDeclarationContainerImpl, paramString1, paramString2);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KMutableProperty2Impl._setter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Setter(this) }");
    this._setter = paramKDeclarationContainerImpl;
  }
  
  public KMutableProperty2Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramKDeclarationContainerImpl, paramPropertyDescriptor);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KMutableProperty2Impl._setter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Setter(this) }");
    this._setter = paramKDeclarationContainerImpl;
  }
  
  @NotNull
  public KMutableProperty2Impl.Setter<D, E, R> getSetter()
  {
    Object localObject = this._setter.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_setter()");
    return (KMutableProperty2Impl.Setter)localObject;
  }
  
  public void set(D paramD, E paramE, R paramR)
  {
    getSetter().call(new Object[] { paramD, paramE, paramR });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty2Impl
 * JD-Core Version:    0.7.0.1
 */