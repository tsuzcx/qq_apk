package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty1;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KProperty1Impl;", "T", "R", "Lkotlin/reflect/KProperty1;", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "_getter", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "kotlin.jvm.PlatformType", "delegateField", "Lkotlin/Lazy;", "Ljava/lang/reflect/Field;", "getter", "getGetter", "()Lkotlin/reflect/jvm/internal/KProperty1Impl$Getter;", "get", "receiver", "(Ljava/lang/Object;)Ljava/lang/Object;", "getDelegate", "invoke", "Getter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public class KProperty1Impl<T, R>
  extends KPropertyImpl<R>
  implements KProperty1<T, R>
{
  private final ReflectProperties.LazyVal<KProperty1Impl.Getter<T, R>> _getter;
  private final Lazy<Field> delegateField;
  
  public KProperty1Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject)
  {
    super(paramKDeclarationContainerImpl, paramString1, paramString2, paramObject);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KProperty1Impl._getter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Getter(this) }");
    this._getter = paramKDeclarationContainerImpl;
    this.delegateField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KProperty1Impl.delegateField.1(this));
  }
  
  public KProperty1Impl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    super(paramKDeclarationContainerImpl, paramPropertyDescriptor);
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KProperty1Impl._getter.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy { Getter(this) }");
    this._getter = paramKDeclarationContainerImpl;
    this.delegateField = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new KProperty1Impl.delegateField.1(this));
  }
  
  public R get(T paramT)
  {
    return getGetter().call(new Object[] { paramT });
  }
  
  @Nullable
  public Object getDelegate(T paramT)
  {
    return getDelegate((Field)this.delegateField.getValue(), paramT);
  }
  
  @NotNull
  public KProperty1Impl.Getter<T, R> getGetter()
  {
    Object localObject = this._getter.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_getter()");
    return (KProperty1Impl.Getter)localObject;
  }
  
  public R invoke(T paramT)
  {
    return get(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KProperty1Impl
 * JD-Core Version:    0.7.0.1
 */