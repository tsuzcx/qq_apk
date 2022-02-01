package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KPropertyImpl;", "R", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "Lkotlin/reflect/KProperty;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "_descriptor", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "kotlin.jvm.PlatformType", "_javaField", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "Ljava/lang/reflect/Field;", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "getter", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "getGetter", "()Lkotlin/reflect/jvm/internal/KPropertyImpl$Getter;", "isBound", "", "()Z", "isConst", "isLateinit", "isSuspend", "javaField", "getJavaField", "()Ljava/lang/reflect/Field;", "getName", "()Ljava/lang/String;", "getSignature", "computeDelegateField", "equals", "other", "getDelegate", "field", "receiver", "hashCode", "", "toString", "Accessor", "Companion", "Getter", "Setter", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public abstract class KPropertyImpl<R>
  extends KCallableImpl<R>
  implements KProperty<R>
{
  public static final KPropertyImpl.Companion Companion = new KPropertyImpl.Companion(null);
  @NotNull
  private static final Object EXTENSION_PROPERTY_DELEGATE = new Object();
  private final ReflectProperties.LazySoftVal<PropertyDescriptor> _descriptor;
  private final ReflectProperties.LazyVal<Field> _javaField;
  @NotNull
  private final KDeclarationContainerImpl container;
  @NotNull
  private final String name;
  private final Object rawBoundReceiver;
  @NotNull
  private final String signature;
  
  public KPropertyImpl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject)
  {
    this(paramKDeclarationContainerImpl, paramString1, paramString2, null, paramObject);
  }
  
  private KPropertyImpl(KDeclarationContainerImpl paramKDeclarationContainerImpl, String paramString1, String paramString2, PropertyDescriptor paramPropertyDescriptor, Object paramObject)
  {
    this.container = paramKDeclarationContainerImpl;
    this.name = paramString1;
    this.signature = paramString2;
    this.rawBoundReceiver = paramObject;
    paramKDeclarationContainerImpl = ReflectProperties.lazy((Function0)new KPropertyImpl._javaField.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazy {…y -> null\n        }\n    }");
    this._javaField = paramKDeclarationContainerImpl;
    paramKDeclarationContainerImpl = ReflectProperties.lazySoft(paramPropertyDescriptor, (Function0)new KPropertyImpl._descriptor.1(this));
    Intrinsics.checkExpressionValueIsNotNull(paramKDeclarationContainerImpl, "ReflectProperties.lazySo…or(name, signature)\n    }");
    this._descriptor = paramKDeclarationContainerImpl;
  }
  
  public KPropertyImpl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    this(paramKDeclarationContainerImpl, str, RuntimeTypeMapper.INSTANCE.mapPropertySignature(paramPropertyDescriptor).asString(), paramPropertyDescriptor, CallableReference.NO_RECEIVER);
  }
  
  @Nullable
  protected final Field computeDelegateField()
  {
    if (getDescriptor().isDelegated()) {
      return getJavaField();
    }
    return null;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    paramObject = UtilKt.asKPropertyImpl(paramObject);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if (Intrinsics.areEqual(getContainer(), paramObject.getContainer()))
      {
        bool1 = bool2;
        if (Intrinsics.areEqual(getName(), paramObject.getName()))
        {
          bool1 = bool2;
          if (Intrinsics.areEqual(this.signature, paramObject.signature))
          {
            bool1 = bool2;
            if (Intrinsics.areEqual(this.rawBoundReceiver, paramObject.rawBoundReceiver)) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  @Nullable
  public final Object getBoundReceiver()
  {
    return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, (CallableMemberDescriptor)getDescriptor());
  }
  
  @NotNull
  public Caller<?> getCaller()
  {
    return getGetter().getCaller();
  }
  
  @NotNull
  public KDeclarationContainerImpl getContainer()
  {
    return this.container;
  }
  
  @Nullable
  public Caller<?> getDefaultCaller()
  {
    return getGetter().getDefaultCaller();
  }
  
  @Nullable
  protected final Object getDelegate(@Nullable Field paramField, @Nullable Object paramObject)
  {
    try
    {
      if ((paramObject == EXTENSION_PROPERTY_DELEGATE) && (getDescriptor().getExtensionReceiverParameter() == null))
      {
        paramField = new StringBuilder();
        paramField.append('\'');
        paramField.append(this);
        paramField.append("' is not an extension property and thus getExtensionDelegate() ");
        paramField.append("is not going to work, use getDelegate() instead");
        throw ((Throwable)new RuntimeException(paramField.toString()));
      }
      if (paramField != null)
      {
        paramField = paramField.get(paramObject);
        return paramField;
      }
      return null;
    }
    catch (IllegalAccessException paramField)
    {
      throw ((Throwable)new IllegalPropertyDelegateAccessException(paramField));
    }
  }
  
  @NotNull
  public PropertyDescriptor getDescriptor()
  {
    Object localObject = this._descriptor.invoke();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "_descriptor()");
    return (PropertyDescriptor)localObject;
  }
  
  @NotNull
  public abstract KPropertyImpl.Getter<R> getGetter();
  
  @Nullable
  public final Field getJavaField()
  {
    return (Field)this._javaField.invoke();
  }
  
  @NotNull
  public String getName()
  {
    return this.name;
  }
  
  @NotNull
  public final String getSignature()
  {
    return this.signature;
  }
  
  public int hashCode()
  {
    return (getContainer().hashCode() * 31 + getName().hashCode()) * 31 + this.signature.hashCode();
  }
  
  public boolean isBound()
  {
    return Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER) ^ true;
  }
  
  public boolean isConst()
  {
    return getDescriptor().isConst();
  }
  
  public boolean isLateinit()
  {
    return getDescriptor().isLateInit();
  }
  
  public boolean isSuspend()
  {
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return ReflectionObjectRenderer.INSTANCE.renderProperty(getDescriptor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImpl
 * JD-Core Version:    0.7.0.1
 */