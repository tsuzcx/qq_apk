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
import kotlin.TypeCastException;
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
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/calls/Caller;", "Ljava/lang/reflect/Member;", "invoke"}, k=3, mv={1, 1, 16})
final class KFunctionImpl$defaultCaller$2
  extends Lambda
  implements Function0<Caller<? extends Member>>
{
  KFunctionImpl$defaultCaller$2(KFunctionImpl paramKFunctionImpl)
  {
    super(0);
  }
  
  @Nullable
  public final Caller<Member> invoke()
  {
    Object localObject3 = RuntimeTypeMapper.INSTANCE.mapSignature(this.this$0.getDescriptor());
    boolean bool = localObject3 instanceof JvmFunctionSignature.KotlinFunction;
    Object localObject2 = null;
    Object localObject1;
    Object localObject4;
    Object localObject5;
    if (bool)
    {
      localObject1 = this.this$0.getContainer();
      localObject4 = (JvmFunctionSignature.KotlinFunction)localObject3;
      localObject3 = ((JvmFunctionSignature.KotlinFunction)localObject4).getMethodName();
      localObject4 = ((JvmFunctionSignature.KotlinFunction)localObject4).getMethodDesc();
      localObject5 = this.this$0.getCaller().getMember();
      if (localObject5 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = (Member)((KDeclarationContainerImpl)localObject1).findDefaultMethod((String)localObject3, (String)localObject4, Modifier.isStatic(((Member)localObject5).getModifiers()) ^ true);
    }
    else if ((localObject3 instanceof JvmFunctionSignature.KotlinConstructor))
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
        return (Caller)new AnnotationConstructorCaller((Class)localObject1, (List)localObject2, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.KOTLIN, null, 16, null);
      }
      localObject1 = (Member)this.this$0.getContainer().findDefaultConstructor(((JvmFunctionSignature.KotlinConstructor)localObject3).getConstructorDesc());
    }
    else
    {
      if ((localObject3 instanceof JvmFunctionSignature.FakeJavaAnnotationConstructor))
      {
        localObject1 = ((JvmFunctionSignature.FakeJavaAnnotationConstructor)localObject3).getMethods();
        localObject2 = this.this$0.getContainer().getJClass();
        localObject4 = (Iterable)localObject1;
        localObject3 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject4, 10));
        localObject4 = ((Iterable)localObject4).iterator();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (Method)((Iterator)localObject4).next();
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "it");
          ((Collection)localObject3).add(((Method)localObject5).getName());
        }
        return (Caller)new AnnotationConstructorCaller((Class)localObject2, (List)localObject3, AnnotationConstructorCaller.CallMode.CALL_BY_NAME, AnnotationConstructorCaller.Origin.JAVA, (List)localObject1);
      }
      localObject1 = null;
    }
    if ((localObject1 instanceof Constructor))
    {
      localObject3 = this.this$0;
      localObject1 = KFunctionImpl.access$createConstructorCaller((KFunctionImpl)localObject3, (Constructor)localObject1, ((KFunctionImpl)localObject3).getDescriptor());
    }
    else if ((localObject1 instanceof Method))
    {
      if (this.this$0.getDescriptor().getAnnotations().findAnnotation(UtilKt.getJVM_STATIC()) != null)
      {
        localObject3 = this.this$0.getDescriptor().getContainingDeclaration();
        if (localObject3 != null)
        {
          if (!((ClassDescriptor)localObject3).isCompanionObject())
          {
            localObject1 = KFunctionImpl.access$createJvmStaticInObjectCaller(this.this$0, (Method)localObject1);
            break label534;
          }
        }
        else {
          throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        }
      }
      localObject1 = KFunctionImpl.access$createStaticMethodCaller(this.this$0, (Method)localObject1);
      label534:
      localObject1 = (CallerImpl)localObject1;
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null) {
      localObject2 = InlineClassAwareCallerKt.createInlineClassAwareCallerIfNeeded((Caller)localObject1, (CallableMemberDescriptor)this.this$0.getDescriptor(), true);
    }
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.KFunctionImpl.defaultCaller.2
 * JD-Core Version:    0.7.0.1
 */