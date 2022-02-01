package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty1Impl;", "T", "R", "Lkotlin/reflect/jvm/internal/KProperty1Impl;", "Lkotlin/reflect/KMutableProperty1;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty1Impl$Setter;", "set", "", "receiver", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KMutableProperty1Impl<T, R>
  extends KProperty1Impl<T, R>
  implements KMutableProperty1<T, R>
{
  private final ReflectProperties.LazyVal<KMutableProperty1Impl.Setter<T, R>> _setter;
  
  public KMutableProperty1Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject)
  {
    super(paramKDeclarationContainerImpl, paramString1, paramString2, paramObject);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KMutableProperty1Impl._setter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Setter(this) }");
    this._setter = paramKDeclarationContainerImpl;
  }
  
  public KMutableProperty1Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramKDeclarationContainerImpl, paramPropertyDescriptor);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KMutableProperty1Impl._setter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Setter(this) }");
    this._setter = paramKDeclarationContainerImpl;
  }
  
  @NotNull
  public KMutableProperty1Impl.Setter<T, R> getSetter()
  {
    Object localObject = this._setter.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_setter()");
    return (KMutableProperty1Impl.Setter)localObject;
  }
  
  public void set(T paramT, R paramR)
  {
    getSetter().call(new Object[] { paramT, paramR });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty1Impl
 * JD-Core Version:    0.7.0.1
 */