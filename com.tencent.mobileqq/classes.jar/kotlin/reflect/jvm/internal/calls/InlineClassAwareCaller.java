package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.IntRange.Companion;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.InlineClassesUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller;", "M", "Ljava/lang/reflect/Member;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "caller", "isDefault", "", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;Lkotlin/reflect/jvm/internal/calls/Caller;Z)V", "data", "Lkotlin/reflect/jvm/internal/calls/InlineClassAwareCaller$BoxUnboxData;", "member", "getMember", "()Ljava/lang/reflect/Member;", "parameterTypes", "", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "BoxUnboxData", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class InlineClassAwareCaller<M extends Member>
  implements Caller<M>
{
  private final Caller<M> caller;
  private final InlineClassAwareCaller.BoxUnboxData data;
  private final boolean isDefault;
  
  public InlineClassAwareCaller(@NotNull CallableMemberDescriptor paramCallableMemberDescriptor, @NotNull Caller<? extends M> paramCaller, boolean paramBoolean)
  {
    this.caller = paramCaller;
    this.isDefault = paramBoolean;
    Object localObject2 = (InlineClassAwareCaller)this;
    paramCaller = paramCallableMemberDescriptor.getReturnType();
    if (paramCaller == null) {
      Intrinsics.throwNpe();
    }
    Intrinsics.checkExpressionValueIsNotNull(paramCaller, "descriptor.returnType!!");
    paramCaller = InlineClassAwareCallerKt.toInlineClass(paramCaller);
    if (paramCaller != null) {
      paramCaller = InlineClassAwareCallerKt.getBoxMethod(paramCaller, paramCallableMemberDescriptor);
    } else {
      paramCaller = null;
    }
    paramBoolean = InlineClassesUtilsKt.isGetterOfUnderlyingPropertyOfInlineClass((CallableDescriptor)paramCallableMemberDescriptor);
    int k = 0;
    Object localObject1;
    label205:
    int m;
    if (paramBoolean)
    {
      paramCallableMemberDescriptor = new InlineClassAwareCaller.BoxUnboxData(IntRange.Companion.getEMPTY(), new Method[0], paramCaller);
    }
    else
    {
      localObject1 = ((InlineClassAwareCaller)localObject2).caller;
      paramBoolean = localObject1 instanceof CallerImpl.Method.BoundStatic;
      int i = -1;
      if (!paramBoolean)
      {
        if ((paramCallableMemberDescriptor instanceof ConstructorDescriptor))
        {
          if ((localObject1 instanceof BoundCaller)) {
            break label205;
          }
        }
        else if ((paramCallableMemberDescriptor.getDispatchReceiverParameter() != null) && (!(((InlineClassAwareCaller)localObject2).caller instanceof BoundCaller)))
        {
          localObject1 = paramCallableMemberDescriptor.getContainingDeclaration();
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.containingDeclaration");
          if (!InlineClassesUtilsKt.isInlineClass((DeclarationDescriptor)localObject1))
          {
            i = 1;
            break label205;
          }
        }
        i = 0;
      }
      if (((InlineClassAwareCaller)localObject2).isDefault) {
        j = 2;
      } else {
        j = 0;
      }
      Object localObject3 = new ArrayList();
      localObject1 = paramCallableMemberDescriptor.getExtensionReceiverParameter();
      if (localObject1 != null) {
        localObject1 = ((ReceiverParameterDescriptor)localObject1).getType();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        ((ArrayList)localObject3).add(localObject1);
      }
      else if ((paramCallableMemberDescriptor instanceof ConstructorDescriptor))
      {
        localObject1 = ((ConstructorDescriptor)paramCallableMemberDescriptor).getConstructedClass();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.constructedClass");
        if (((ClassDescriptor)localObject1).isInner())
        {
          localObject1 = ((ClassDescriptor)localObject1).getContainingDeclaration();
          if (localObject1 != null) {
            ((ArrayList)localObject3).add(((ClassDescriptor)localObject1).getDefaultType());
          } else {
            throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
          }
        }
      }
      else
      {
        localObject1 = paramCallableMemberDescriptor.getContainingDeclaration();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.containingDeclaration");
        if ((localObject1 instanceof ClassDescriptor))
        {
          localObject1 = (ClassDescriptor)localObject1;
          if (((ClassDescriptor)localObject1).isInline()) {
            ((ArrayList)localObject3).add(((ClassDescriptor)localObject1).getDefaultType());
          }
        }
      }
      localObject1 = paramCallableMemberDescriptor.getValueParameters();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "descriptor.valueParameters");
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = ((Iterator)localObject1).next();
        ((Collection)localObject3).add(((ValueParameterDescriptor)localObject4).getType());
      }
      localObject1 = (Collection)localObject3;
      localObject3 = (List)localObject3;
      m = ((List)localObject3).size() + i + j;
      localObject1 = (Caller)localObject2;
      if (CallerKt.getArity((Caller)localObject1) != m) {
        break label645;
      }
      localObject2 = RangesKt.until(Math.max(i, 0), ((List)localObject3).size() + i);
      Object localObject4 = new Method[m];
      int j = k;
      while (j < m)
      {
        if (((IntRange)localObject2).contains(j))
        {
          localObject1 = InlineClassAwareCallerKt.toInlineClass((KotlinType)((List)localObject3).get(j - i));
          if (localObject1 != null)
          {
            localObject1 = InlineClassAwareCallerKt.getUnboxMethod((Class)localObject1, paramCallableMemberDescriptor);
            break label610;
          }
        }
        localObject1 = null;
        label610:
        localObject4[j] = localObject1;
        j += 1;
      }
      paramCallableMemberDescriptor = new InlineClassAwareCaller.BoxUnboxData((IntRange)localObject2, (Method[])localObject4, paramCaller);
    }
    this.data = paramCallableMemberDescriptor;
    return;
    label645:
    paramCaller = new StringBuilder();
    paramCaller.append("Inconsistent number of parameters in the descriptor and Java reflection object: ");
    paramCaller.append(CallerKt.getArity((Caller)localObject1));
    paramCaller.append(" != ");
    paramCaller.append(m);
    paramCaller.append('\n');
    paramCaller.append("Calling: ");
    paramCaller.append(paramCallableMemberDescriptor);
    paramCaller.append('\n');
    paramCaller.append("Parameter types: ");
    paramCaller.append(((InlineClassAwareCaller)localObject2).getParameterTypes());
    paramCaller.append(")\n");
    paramCaller.append("Default: ");
    paramCaller.append(((InlineClassAwareCaller)localObject2).isDefault);
    paramCallableMemberDescriptor = (Throwable)new KotlinReflectionInternalError(paramCaller.toString());
    for (;;)
    {
      throw paramCallableMemberDescriptor;
    }
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    Object localObject2 = this.data;
    Object localObject1 = ((InlineClassAwareCaller.BoxUnboxData)localObject2).component1();
    Method[] arrayOfMethod = ((InlineClassAwareCaller.BoxUnboxData)localObject2).component2();
    Method localMethod1 = ((InlineClassAwareCaller.BoxUnboxData)localObject2).component3();
    Object[] arrayOfObject = Arrays.copyOf(paramArrayOfObject, paramArrayOfObject.length);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfObject, "java.util.Arrays.copyOf(this, size)");
    if (arrayOfObject != null)
    {
      int i = ((IntRange)localObject1).getFirst();
      int j = ((IntRange)localObject1).getLast();
      if (i <= j) {
        for (;;)
        {
          Method localMethod2 = arrayOfMethod[i];
          localObject2 = paramArrayOfObject[i];
          localObject1 = localObject2;
          if (localMethod2 != null)
          {
            localObject1 = localObject2;
            if (localObject2 != null) {
              localObject1 = localMethod2.invoke(localObject2, new Object[0]);
            }
          }
          arrayOfObject[i] = localObject1;
          if (i == j) {
            break;
          }
          i += 1;
        }
      }
      localObject1 = this.caller.call(arrayOfObject);
      paramArrayOfObject = (Object[])localObject1;
      if (localMethod1 != null)
      {
        localObject2 = localMethod1.invoke(null, new Object[] { localObject1 });
        paramArrayOfObject = (Object[])localObject1;
        if (localObject2 != null) {
          paramArrayOfObject = (Object[])localObject2;
        }
      }
      return paramArrayOfObject;
    }
    paramArrayOfObject = new TypeCastException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
    for (;;)
    {
      throw paramArrayOfObject;
    }
  }
  
  public M getMember()
  {
    return this.caller.getMember();
  }
  
  @NotNull
  public List<Type> getParameterTypes()
  {
    return this.caller.getParameterTypes();
  }
  
  @NotNull
  public Type getReturnType()
  {
    return this.caller.getReturnType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.InlineClassAwareCaller
 * JD-Core Version:    0.7.0.1
 */