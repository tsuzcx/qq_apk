package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty0Impl;", "R", "Lkotlin/reflect/KProperty0;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "kotlin.jvm.PlatformType", "delegateFieldValue", "Lkotlin/Lazy;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty0Impl$Getter;", "get", "()Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public class KProperty0Impl<R>
  extends KPropertyImpl<R>
  implements KProperty0<R>
{
  private final ReflectProperties.LazyVal<KProperty0Impl.Getter<R>> _getter;
  private final Lazy<Object> delegateFieldValue;
  
  public KProperty0Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject)
  {
    super(paramKDeclarationContainerImpl, paramString1, paramString2, paramObject);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KProperty0Impl._getter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Getter(this) }");
    this._getter = paramKDeclarationContainerImpl;
    this.delegateFieldValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KProperty0Impl.delegateFieldValue.1(this));
  }
  
  public KProperty0Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramKDeclarationContainerImpl, paramPropertyDescriptor);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KProperty0Impl._getter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Getter(this) }");
    this._getter = paramKDeclarationContainerImpl;
    this.delegateFieldValue = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KProperty0Impl.delegateFieldValue.1(this));
  }
  
  public R get()
  {
    return getGetter().call(new Object[0]);
  }
  
  @Nullable
  public Object getDelegate()
  {
    return this.delegateFieldValue.getValue();
  }
  
  @NotNull
  public KProperty0Impl.Getter<R> getGetter()
  {
    Object localObject = this._getter.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_getter()");
    return (KProperty0Impl.Getter)localObject;
  }
  
  public R invoke()
  {
    return get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty0Impl
 * JD-Core Version:    0.7.0.1
 */