package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty2;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty2Impl;", "D", "E", "R", "Lkotlin/reflect/KProperty2;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty2Impl$Getter;", "get", "receiver1", "receiver2", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "", "invoke", "Getter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public class KProperty2Impl<D, E, R>
  extends KPropertyImpl<R>
  implements KProperty2<D, E, R>
{
  private final ReflectProperties.LazyVal<KProperty2Impl.Getter<D, E, R>> _getter;
  private final Lazy<Field> delegateField;
  
  public KProperty2Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2)
  {
    super(paramKDeclarationContainerImpl, paramString1, paramString2, CallableReference.NO_RECEIVER);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KProperty2Impl._getter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Getter(this) }");
    this._getter = paramKDeclarationContainerImpl;
    this.delegateField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KProperty2Impl.delegateField.1(this));
  }
  
  public KProperty2Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramKDeclarationContainerImpl, paramPropertyDescriptor);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KProperty2Impl._getter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Getter(this) }");
    this._getter = paramKDeclarationContainerImpl;
    this.delegateField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KProperty2Impl.delegateField.1(this));
  }
  
  public R get(D paramD, E paramE)
  {
    return getGetter().call(new Object[] { paramD, paramE });
  }
  
  @Nullable
  public Object getDelegate(D paramD, E paramE)
  {
    return getDelegate((Field)this.delegateField.getValue(), paramD);
  }
  
  @NotNull
  public KProperty2Impl.Getter<D, E, R> getGetter()
  {
    Object localObject = this._getter.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_getter()");
    return (KProperty2Impl.Getter)localObject;
  }
  
  public R invoke(D paramD, E paramE)
  {
    return get(paramD, paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty2Impl
 * JD-Core Version:    0.7.0.1
 */