package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.CallerImpl.AccessorForHiddenBoundConstructor;
import kotlin.reflect.jvm.internal.calls.CallerImpl.AccessorForHiddenConstructor;
import kotlin.reflect.jvm.internal.calls.CallerImpl.BoundConstructor;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Constructor;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundInstance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Instance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.JvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Static;
import kotlin.reflect.jvm.internal.calls.CallerKt;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.InlineClassManglingRulesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", "hashCode", "toString", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class KFunctionImpl
  extends KCallableImpl<Object>
  implements FunctionBase<Object>, KFunction<Object>, FunctionWithAllInvokes
{
  @NotNull
  private final ReflectProperties.LazyVal caller$delegate;
  @NotNull
  private final KDeclarationContainerImpl container;
  @Nullable
  private final ReflectProperties.LazyVal defaultCaller$delegate;
  @NotNull
  private final ReflectProperties.LazySoftVal descriptor$delegate;
  private final Object rawBoundReceiver;
  private final String signature;
  
  public KFunctionImpl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull String paramString1, @NotNull String paramString2, @Nullable Object paramObject)
  {
    this(paramKDeclarationContainerImpl, paramString1, paramString2, null, paramObject);
  }
  
  private KFunctionImpl(KDeclarationContainerImpl paramKDeclarationContainerImpl, String paramString1, String paramString2, FunctionDescriptor paramFunctionDescriptor, Object paramObject)
  {
    this.container = paramKDeclarationContainerImpl;
    this.signature = paramString2;
    this.rawBoundReceiver = paramObject;
    this.descriptor$delegate = ReflectProperties.lazySoft(paramFunctionDescriptor, (Function0)new KFunctionImpl.descriptor.2(this, paramString1));
    this.caller$delegate = ReflectProperties.lazy((Function0)new KFunctionImpl.caller.2(this));
    this.defaultCaller$delegate = ReflectProperties.lazy((Function0)new KFunctionImpl.defaultCaller.2(this));
  }
  
  public KFunctionImpl(@NotNull KDeclarationContainerImpl paramKDeclarationContainerImpl, @NotNull FunctionDescriptor paramFunctionDescriptor)
  {
    this(paramKDeclarationContainerImpl, str, RuntimeTypeMapper.INSTANCE.mapSignature(paramFunctionDescriptor).asString(), paramFunctionDescriptor, null, 16, null);
  }
  
  private final CallerImpl<Constructor<?>> createConstructorCaller(Constructor<?> paramConstructor, FunctionDescriptor paramFunctionDescriptor)
  {
    if (InlineClassManglingRulesKt.shouldHideConstructorDueToInlineClassTypeValueParameters((CallableMemberDescriptor)paramFunctionDescriptor))
    {
      if (isBound()) {
        return (CallerImpl)new CallerImpl.AccessorForHiddenBoundConstructor(paramConstructor, getBoundReceiver());
      }
      return (CallerImpl)new CallerImpl.AccessorForHiddenConstructor(paramConstructor);
    }
    if (isBound()) {
      return (CallerImpl)new CallerImpl.BoundConstructor(paramConstructor, getBoundReceiver());
    }
    return (CallerImpl)new CallerImpl.Constructor(paramConstructor);
  }
  
  private final CallerImpl.Method createInstanceMethodCaller(Method paramMethod)
  {
    if (isBound()) {
      paramMethod = new CallerImpl.Method.BoundInstance(paramMethod, getBoundReceiver());
    } else {
      paramMethod = new CallerImpl.Method.Instance(paramMethod);
    }
    return (CallerImpl.Method)paramMethod;
  }
  
  private final CallerImpl.Method createJvmStaticInObjectCaller(Method paramMethod)
  {
    if (isBound()) {
      paramMethod = new CallerImpl.Method.BoundJvmStaticInObject(paramMethod);
    } else {
      paramMethod = new CallerImpl.Method.JvmStaticInObject(paramMethod);
    }
    return (CallerImpl.Method)paramMethod;
  }
  
  private final CallerImpl.Method createStaticMethodCaller(Method paramMethod)
  {
    if (isBound()) {
      paramMethod = new CallerImpl.Method.BoundStatic(paramMethod, getBoundReceiver());
    } else {
      paramMethod = new CallerImpl.Method.Static(paramMethod);
    }
    return (CallerImpl.Method)paramMethod;
  }
  
  private final Object getBoundReceiver()
  {
    return InlineClassAwareCallerKt.coerceToExpectedReceiverType(this.rawBoundReceiver, (CallableMemberDescriptor)getDescriptor());
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    paramObject = UtilKt.asKFunctionImpl(paramObject);
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
  
  public int getArity()
  {
    return CallerKt.getArity(getCaller());
  }
  
  @NotNull
  public Caller<?> getCaller()
  {
    return (Caller)this.caller$delegate.getValue(this, $$delegatedProperties[1]);
  }
  
  @NotNull
  public KDeclarationContainerImpl getContainer()
  {
    return this.container;
  }
  
  @Nullable
  public Caller<?> getDefaultCaller()
  {
    return (Caller)this.defaultCaller$delegate.getValue(this, $$delegatedProperties[2]);
  }
  
  @NotNull
  public FunctionDescriptor getDescriptor()
  {
    return (FunctionDescriptor)this.descriptor$delegate.getValue(this, $$delegatedProperties[0]);
  }
  
  @NotNull
  public String getName()
  {
    String str = getDescriptor().getName().asString();
    Intrinsics.checkExpressionValueIsNotNull(str, "descriptor.name.asString()");
    return str;
  }
  
  public int hashCode()
  {
    return (getContainer().hashCode() * 31 + getName().hashCode()) * 31 + this.signature.hashCode();
  }
  
  @Nullable
  public Object invoke()
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16, @Nullable Object paramObject17)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16, paramObject17);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16, @Nullable Object paramObject17, @Nullable Object paramObject18)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16, paramObject17, paramObject18);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16, @Nullable Object paramObject17, @Nullable Object paramObject18, @Nullable Object paramObject19)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16, paramObject17, paramObject18, paramObject19);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16, @Nullable Object paramObject17, @Nullable Object paramObject18, @Nullable Object paramObject19, @Nullable Object paramObject20)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16, paramObject17, paramObject18, paramObject19, paramObject20);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16, @Nullable Object paramObject17, @Nullable Object paramObject18, @Nullable Object paramObject19, @Nullable Object paramObject20, @Nullable Object paramObject21)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16, paramObject17, paramObject18, paramObject19, paramObject20, paramObject21);
  }
  
  @Nullable
  public Object invoke(@Nullable Object paramObject1, @Nullable Object paramObject2, @Nullable Object paramObject3, @Nullable Object paramObject4, @Nullable Object paramObject5, @Nullable Object paramObject6, @Nullable Object paramObject7, @Nullable Object paramObject8, @Nullable Object paramObject9, @Nullable Object paramObject10, @Nullable Object paramObject11, @Nullable Object paramObject12, @Nullable Object paramObject13, @Nullable Object paramObject14, @Nullable Object paramObject15, @Nullable Object paramObject16, @Nullable Object paramObject17, @Nullable Object paramObject18, @Nullable Object paramObject19, @Nullable Object paramObject20, @Nullable Object paramObject21, @Nullable Object paramObject22)
  {
    return FunctionWithAllInvokes.DefaultImpls.invoke(this, paramObject1, paramObject2, paramObject3, paramObject4, paramObject5, paramObject6, paramObject7, paramObject8, paramObject9, paramObject10, paramObject11, paramObject12, paramObject13, paramObject14, paramObject15, paramObject16, paramObject17, paramObject18, paramObject19, paramObject20, paramObject21, paramObject22);
  }
  
  public boolean isBound()
  {
    return Intrinsics.areEqual(this.rawBoundReceiver, CallableReference.NO_RECEIVER) ^ true;
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
  
  @NotNull
  public String toString()
  {
    return ReflectionObjectRenderer.INSTANCE.renderFunction(getDescriptor());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KFunctionImpl
 * JD-Core Version:    0.7.0.1
 */