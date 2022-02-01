package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KMutableProperty0Impl;", "R", "Lkotlin/reflect/jvm/internal/KProperty0Impl;", "Lkotlin/reflect/KMutableProperty0;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_setter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "kotlin.jvm.PlatformType", "setter", "getSetter", "()Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", "set", "", "value", "(Ljava/lang/Object;)V", "Setter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KMutableProperty0Impl<R>
  extends KProperty0Impl<R>
  implements KMutableProperty0<R>
{
  private final ReflectProperties.LazyVal<KMutableProperty0Impl.Setter<R>> _setter;
  
  public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject)
  {
    super(paramKDeclarationContainerImpl, paramString1, paramString2, paramObject);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KMutableProperty0Impl._setter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Setter(this) }");
    this._setter = paramKDeclarationContainerImpl;
  }
  
  public KMutableProperty0Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramKDeclarationContainerImpl, paramPropertyDescriptor);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KMutableProperty0Impl._setter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Setter(this) }");
    this._setter = paramKDeclarationContainerImpl;
  }
  
  @NotNull
  public KMutableProperty0Impl.Setter<R> getSetter()
  {
    Object localObject = this._setter.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_setter()");
    return (KMutableProperty0Impl.Setter)localObject;
  }
  
  public void set(R paramR)
  {
    getSetter().call(new Object[] { paramR });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KMutableProperty0Impl
 * JD-Core Version:    0.7.0.1
 */