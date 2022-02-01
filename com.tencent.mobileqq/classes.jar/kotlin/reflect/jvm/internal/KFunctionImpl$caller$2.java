package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode;
import kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin;
import kotlin.reflect.jvm.internal.calls.Caller;
import kotlin.reflect.jvm.internal.calls.CallerImpl;
import kotlin.reflect.jvm.internal.calls.InlineClassAwareCallerKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"}, k=3, mv={1, 1, 16})
final class KFunctionImpl$caller$2
  extends Lambda
  implements Function0<Caller<? extends Member>>
{
  KFunctionImpl$caller$2(KFunctionImpl paramKFunctionImpl)
  {
    super(0);
  }
  
  @NotNull
  public final Caller<Member> invoke()
  {
    Object localObject2 = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
    Object localObject3;
    Object localObject4;
    if ((localObject2 instanceof JvmFunctionSignature.KotlinConstructor))
    {
      if (this.this$0.isAnnotationConstructor())
      {
        localObject1 = this.this$0.getContainer().getJClass();
        localObject3 = (Iterable)this.this$0.getParameters();
        localObject2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((KParameter)((Iterator)localObject3).next()).getName();
          if (localObject4 == null) {
            Intrinsics.throwNpe();
          }
          ((Collection)localObject2).add(localObject4);
        }
        return (Caller)new AnnotationConstructorCaller((Class)localObject1, (List)localObject2, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
      }
      localObject1 = (Member)this.this$0.getContainer().findConstructorBySignature(((JvmFunctionSignature.KotlinConstructor)localObject2).getConstructorDesc());
    }
    else if ((localObject2 instanceof JvmFunctionSignature.KotlinFunction))
    {
      localObject1 = this.this$0.getContainer();
      localObject2 = (JvmFunctionSignature.KotlinFunction)localObject2;
      localObject1 = (Member)((KDeclarationContainerImpl)localObject1).findMethodBySignature(((JvmFunctionSignature.KotlinFunction)localObject2).getMethodName(), ((JvmFunctionSignature.KotlinFunction)localObject2).getMethodDesc());
    }
    else if ((localObject2 instanceof JvmFunctionSignature.JavaMethod))
    {
      localObject1 = (Member)((JvmFunctionSignature.JavaMethod)localObject2).getMethod();
    }
    else
    {
      if (!(localObject2 instanceof JvmFunctionSignature.JavaConstructor)) {
        break label444;
      }
      localObject1 = (Member)((JvmFunctionSignature.JavaConstructor)localObject2).getConstructor();
    }
    if ((localObject1 instanceof Constructor))
    {
      localObject2 = this.this$0;
      localObject1 = KFunctionImpl.access$createConstructorCaller((KFunctionImpl)localObject2, (Constructor)localObject1, ((KFunctionImpl)localObject2).getDescriptor());
    }
    else
    {
      if (!(localObject1 instanceof Method)) {
        break label382;
      }
      localObject1 = (Method)localObject1;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {
        localObject1 = KFunctionImpl.access$createInstanceMethodCaller(this.this$0, (Method)localObject1);
      } else if (this.this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null) {
        localObject1 = KFunctionImpl.access$createJvmStaticInObjectCaller(this.this$0, (Method)localObject1);
      } else {
        localObject1 = KFunctionImpl.access$createStaticMethodCaller(this.this$0, (Method)localObject1);
      }
      localObject1 = (CallerImpl)localObject1;
    }
    return InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded$default((Caller)localObject1, (CallableMemberDescriptor)this.this$0.getDescriptor(), false, 2, null);
    label382:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Could not compute caller for function: ");
    ((StringBuilder)localObject2).append(this.this$0.getDescriptor());
    ((StringBuilder)localObject2).append(" (member = ");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(')');
    throw ((Throwable)new KotlinReflectionInternalError(((StringBuilder)localObject2).toString()));
    label444:
    if ((localObject2 instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor))
    {
      localObject1 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor)localObject2).getMethods();
      localObject2 = this.this$0.getContainer().getJClass();
      localObject4 = (Iterable)localObject1;
      localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        Method localMethod = (Method)((Iterator)localObject4).next();
        Intrinsics.checkExpressionValueIsNotNull(localMethod, "it");
        ((Collection)localObject3).add(localMethod.getName());
      }
      return (Caller)new AnnotationConstructorCaller((Class)localObject2, (List)localObject3, AnnotationConstructorCaller.CallMode.POSITIONAL_CALL, AnnotationConstructorCaller.Origin.JAVA, (List)localObject1);
    }
    Object localObject1 = new NoWhenBranchMatchedException();
    for (;;)
    {
      throw ((Throwable)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KFunctionImpl.caller.2
 * JD-Core Version:    0.7.0.1
 */