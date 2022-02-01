package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundInstance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundJvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Instance;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.JvmStaticInObject;
import kotlin.reflect.jvm.internal.calls.CallerImpl.Method.Static;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass.Bound;
import kotlin.reflect.jvm.internal.calls.InternalUnderlyingValOfInlineClass.Unbound;
import kotlin.reflect.jvm.internal.calls.ThrowingCaller;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class KPropertyImplKt
{
  private static final Caller<?> computeCallerForAccessor(@NotNull KPropertyImpl.Accessor<?, ?> paramAccessor, boolean paramBoolean)
  {
    if (KDeclarationContainerImpl.Companion.getLOCAL_PROPERTY_SIGNATURE$kotlin_reflection().matches((CharSequence)paramAccessor.getProperty().getSignature())) {
      return (Caller)ThrowingCaller.INSTANCE;
    }
    KPropertyImplKt.computeCallerForAccessor.1 local1 = new KPropertyImplKt.computeCallerForAccessor.1(paramAccessor);
    Object localObject2 = new KPropertyImplKt.computeCallerForAccessor.3(paramAccessor, paramBoolean, new KPropertyImplKt.computeCallerForAccessor.2(paramAccessor), local1);
    Object localObject1 = RuntimeTypeMapper.INSTANCE.mapPropertySignature(paramAccessor.getProperty().getDescriptor());
    if ((localObject1 instanceof JvmPropertySignature.KotlinProperty))
    {
      JvmPropertySignature.KotlinProperty localKotlinProperty = (JvmPropertySignature.KotlinProperty)localObject1;
      localObject1 = localKotlinProperty.getSignature();
      if (paramBoolean)
      {
        if (((JvmProtoBuf.JvmPropertySignature)localObject1).hasGetter())
        {
          localObject1 = ((JvmProtoBuf.JvmPropertySignature)localObject1).getGetter();
          break label128;
        }
      }
      else if (((JvmProtoBuf.JvmPropertySignature)localObject1).hasSetter())
      {
        localObject1 = ((JvmProtoBuf.JvmPropertySignature)localObject1).getSetter();
        break label128;
      }
      localObject1 = null;
      label128:
      if (localObject1 != null) {
        localObject1 = paramAccessor.getProperty().getContainer().findMethodBySignature(localKotlinProperty.getNameResolver().getString(((JvmProtoBuf.JvmMethodSignature)localObject1).getName()), localKotlinProperty.getNameResolver().getString(((JvmProtoBuf.JvmMethodSignature)localObject1).getDesc()));
      } else {
        localObject1 = null;
      }
      if (localObject1 == null)
      {
        if ((InlineClassesUtilsKt.isUnderlyingPropertyOfInlineClass((VariableDescriptor)paramAccessor.getProperty().getDescriptor())) && (Intrinsics.areEqual(paramAccessor.getProperty().getDescriptor().getVisibility(), Visibilities.INTERNAL)))
        {
          localObject1 = InlineClassAwareCallerKt.toInlineClass(paramAccessor.getProperty().getDescriptor().getContainingDeclaration());
          if (localObject1 != null)
          {
            localObject1 = InlineClassAwareCallerKt.getUnboxMethod((Class)localObject1, (CallableMemberDescriptor)paramAccessor.getProperty().getDescriptor());
            if (localObject1 != null)
            {
              if (paramAccessor.isBound()) {
                localObject1 = (InternalUnderlyingValOfInlineClass)new InternalUnderlyingValOfInlineClass.Bound((Method)localObject1, getBoundReceiver(paramAccessor));
              } else {
                localObject1 = (InternalUnderlyingValOfInlineClass)new InternalUnderlyingValOfInlineClass.Unbound((Method)localObject1);
              }
              localObject1 = (Caller)localObject1;
              break label667;
            }
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Underlying property of inline class ");
          ((StringBuilder)localObject1).append(paramAccessor.getProperty());
          ((StringBuilder)localObject1).append(" should have a field");
          throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
        }
        else
        {
          localObject1 = paramAccessor.getProperty().getJavaField();
          if (localObject1 != null)
          {
            localObject1 = (Caller)((KPropertyImplKt.computeCallerForAccessor.3)localObject2).invoke((Field)localObject1);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("No accessors or field is found for property ");
            ((StringBuilder)localObject1).append(paramAccessor.getProperty());
            throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
          }
        }
      }
      else if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (paramAccessor.isBound()) {
          localObject1 = (CallerImpl.Method)new CallerImpl.Method.BoundInstance((Method)localObject1, getBoundReceiver(paramAccessor));
        } else {
          localObject1 = (CallerImpl.Method)new CallerImpl.Method.Instance((Method)localObject1);
        }
        localObject1 = (Caller)localObject1;
      }
      else if (local1.invoke())
      {
        if (paramAccessor.isBound()) {
          localObject1 = (CallerImpl.Method)new CallerImpl.Method.BoundJvmStaticInObject((Method)localObject1);
        } else {
          localObject1 = (CallerImpl.Method)new CallerImpl.Method.JvmStaticInObject((Method)localObject1);
        }
        localObject1 = (Caller)localObject1;
      }
      else
      {
        if (paramAccessor.isBound()) {
          localObject1 = (CallerImpl.Method)new CallerImpl.Method.BoundStatic((Method)localObject1, getBoundReceiver(paramAccessor));
        } else {
          localObject1 = (CallerImpl.Method)new CallerImpl.Method.Static((Method)localObject1);
        }
        localObject1 = (Caller)localObject1;
      }
    }
    else if ((localObject1 instanceof JvmPropertySignature.JavaField))
    {
      localObject1 = (Caller)((KPropertyImplKt.computeCallerForAccessor.3)localObject2).invoke(((JvmPropertySignature.JavaField)localObject1).getField());
    }
    else
    {
      if (!(localObject1 instanceof JvmPropertySignature.JavaMethodProperty)) {
        break label722;
      }
      if (paramBoolean)
      {
        localObject1 = ((JvmPropertySignature.JavaMethodProperty)localObject1).getGetterMethod();
      }
      else
      {
        localObject2 = (JvmPropertySignature.JavaMethodProperty)localObject1;
        localObject1 = ((JvmPropertySignature.JavaMethodProperty)localObject2).getSetterMethod();
        if (localObject1 == null) {
          break label682;
        }
      }
      if (paramAccessor.isBound()) {
        localObject1 = (CallerImpl.Method)new CallerImpl.Method.BoundInstance((Method)localObject1, getBoundReceiver(paramAccessor));
      } else {
        localObject1 = (CallerImpl.Method)new CallerImpl.Method.Instance((Method)localObject1);
      }
      localObject1 = (Caller)localObject1;
    }
    label667:
    return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default((Caller)localObject1, (CallableMemberDescriptor)paramAccessor.getDescriptor(), false, 2, null);
    label682:
    paramAccessor = new StringBuilder();
    paramAccessor.append("No source found for setter of Java method property: ");
    paramAccessor.append(((JvmPropertySignature.JavaMethodProperty)localObject2).getGetterMethod());
    throw ((Throwable)new KotlinReflectionInternalError(paramAccessor.toString()));
    label722:
    if ((localObject1 instanceof JvmPropertySignature.MappedKotlinProperty))
    {
      if (paramBoolean)
      {
        localObject1 = ((JvmPropertySignature.MappedKotlinProperty)localObject1).getGetterSignature();
      }
      else
      {
        localObject1 = ((JvmPropertySignature.MappedKotlinProperty)localObject1).getSetterSignature();
        if (localObject1 == null) {
          break label917;
        }
      }
      localObject1 = paramAccessor.getProperty().getContainer().findMethodBySignature(((JvmFunctionSignature.KotlinFunction)localObject1).getMethodName(), ((JvmFunctionSignature.KotlinFunction)localObject1).getMethodDesc());
      if (localObject1 != null)
      {
        paramBoolean = Modifier.isStatic(((Method)localObject1).getModifiers());
        if ((_Assertions.ENABLED) && (!(paramBoolean ^ true)))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Mapped property cannot have a static accessor: ");
          ((StringBuilder)localObject1).append(paramAccessor.getProperty());
          throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
        }
        if (paramAccessor.isBound()) {
          return (Caller)new CallerImpl.Method.BoundInstance((Method)localObject1, getBoundReceiver(paramAccessor));
        }
        return (Caller)new CallerImpl.Method.Instance((Method)localObject1);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No accessor found for property ");
      ((StringBuilder)localObject1).append(paramAccessor.getProperty());
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("No setter found for property ");
      ((StringBuilder)localObject1).append(paramAccessor.getProperty());
      throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject1).toString()));
    }
    label917:
    throw new NoWhenBranchMatchedException();
  }
  
  @Nullable
  public static final Object getBoundReceiver(@NotNull KPropertyImpl.Accessor<?, ?> paramAccessor)
  {
    Intrinsics.checkParameterIsNotNull(paramAccessor, "$this$boundReceiver");
    return paramAccessor.getProperty().getBoundReceiver();
  }
  
  private static final boolean isJvmFieldPropertyInCompanionObject(@NotNull PropertyDescriptor paramPropertyDescriptor)
  {
    DeclarationDescriptor localDeclarationDescriptor = paramPropertyDescriptor.getContainingDeclaration();
    Intrinsics.checkExpressionValueIsNotNull(localDeclarationDescriptor, "containingDeclaration");
    if (!DescriptorUtils.isCompanionObject(localDeclarationDescriptor)) {
      return false;
    }
    localDeclarationDescriptor = localDeclarationDescriptor.getContainingDeclaration();
    boolean bool2 = DescriptorUtils.isInterface(localDeclarationDescriptor);
    boolean bool1 = true;
    if ((bool2) || (DescriptorUtils.isAnnotationClass(localDeclarationDescriptor)))
    {
      if (((paramPropertyDescriptor instanceof DeserializedPropertyDescriptor)) && (JvmProtoBufUtil.isMovedFromInterfaceCompanion(((DeserializedPropertyDescriptor)paramPropertyDescriptor).getProto()))) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KPropertyImplKt
 * JD-Core Version:    0.7.0.1
 */