package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.RawType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class RawTypeImpl
  extends FlexibleType
  implements RawType
{
  public RawTypeImpl(@NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    this(paramSimpleType1, paramSimpleType2, false);
  }
  
  private RawTypeImpl(SimpleType paramSimpleType1, SimpleType paramSimpleType2, boolean paramBoolean)
  {
    super(paramSimpleType1, paramSimpleType2);
    if (!paramBoolean)
    {
      paramBoolean = KotlinTypeChecker.DEFAULT.isSubtypeOf((KotlinType)paramSimpleType1, (KotlinType)paramSimpleType2);
      if (_Assertions.ENABLED)
      {
        if (paramBoolean) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Lower bound ");
        localStringBuilder.append(paramSimpleType1);
        localStringBuilder.append(" of a flexible type must be a subtype of the upper bound ");
        localStringBuilder.append(paramSimpleType2);
        throw ((Throwable)new AssertionError(localStringBuilder.toString()));
      }
    }
  }
  
  @NotNull
  public SimpleType getDelegate()
  {
    return getLowerBound();
  }
  
  @NotNull
  public MemberScope getMemberScope()
  {
    ClassifierDescriptor localClassifierDescriptor = getConstructor().getDeclarationDescriptor();
    Object localObject = localClassifierDescriptor;
    if (!(localClassifierDescriptor instanceof ClassDescriptor)) {
      localObject = null;
    }
    localObject = (ClassDescriptor)localObject;
    if (localObject != null)
    {
      localObject = ((ClassDescriptor)localObject).getMemberScope((TypeSubstitution)RawSubstitution.INSTANCE);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "classDescriptor.getMemberScope(RawSubstitution)");
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Incorrect classifier: ");
    ((StringBuilder)localObject).append(getConstructor().getDeclarationDescriptor());
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
  
  @NotNull
  public RawTypeImpl makeNullableAsSpecified(boolean paramBoolean)
  {
    return new RawTypeImpl(getLowerBound().makeNullableAsSpecified(paramBoolean), getUpperBound().makeNullableAsSpecified(paramBoolean));
  }
  
  @NotNull
  public FlexibleType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    Object localObject = paramKotlinTypeRefiner.refineType((KotlinType)getLowerBound());
    if (localObject != null)
    {
      localObject = (SimpleType)localObject;
      paramKotlinTypeRefiner = paramKotlinTypeRefiner.refineType((KotlinType)getUpperBound());
      if (paramKotlinTypeRefiner != null) {
        return (FlexibleType)new RawTypeImpl((SimpleType)localObject, (SimpleType)paramKotlinTypeRefiner, true);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public String render(@NotNull DescriptorRenderer paramDescriptorRenderer, @NotNull DescriptorRendererOptions paramDescriptorRendererOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramDescriptorRenderer, "renderer");
    Intrinsics.checkParameterIsNotNull(paramDescriptorRendererOptions, "options");
    Object localObject1 = RawTypeImpl.render.1.INSTANCE;
    Object localObject2 = new RawTypeImpl.render.2(paramDescriptorRenderer);
    RawTypeImpl.render.3 local3 = RawTypeImpl.render.3.INSTANCE;
    String str = paramDescriptorRenderer.renderType((KotlinType)getLowerBound());
    localObject1 = paramDescriptorRenderer.renderType((KotlinType)getUpperBound());
    if (paramDescriptorRendererOptions.getDebugMode())
    {
      paramDescriptorRenderer = new StringBuilder();
      paramDescriptorRenderer.append("raw (");
      paramDescriptorRenderer.append(str);
      paramDescriptorRenderer.append("..");
      paramDescriptorRenderer.append((String)localObject1);
      paramDescriptorRenderer.append(')');
      return paramDescriptorRenderer.toString();
    }
    if (getUpperBound().getArguments().isEmpty()) {
      return paramDescriptorRenderer.renderFlexibleType(str, (String)localObject1, TypeUtilsKt.getBuiltIns(this));
    }
    Object localObject3 = ((RawTypeImpl.render.2)localObject2).invoke((KotlinType)getLowerBound());
    paramDescriptorRendererOptions = ((RawTypeImpl.render.2)localObject2).invoke((KotlinType)getUpperBound());
    localObject3 = (Iterable)localObject3;
    localObject2 = CollectionsKt.joinToString$default((Iterable)localObject3, (CharSequence)", ", null, null, 0, null, (Function1)RawTypeImpl.render.newArgs.1.INSTANCE, 30, null);
    paramDescriptorRendererOptions = (Iterable)CollectionsKt.zip((Iterable)localObject3, (Iterable)paramDescriptorRendererOptions);
    boolean bool = paramDescriptorRendererOptions instanceof Collection;
    int j = 1;
    int i;
    if ((bool) && (((Collection)paramDescriptorRendererOptions).isEmpty()))
    {
      i = j;
    }
    else
    {
      paramDescriptorRendererOptions = paramDescriptorRendererOptions.iterator();
      do
      {
        i = j;
        if (!paramDescriptorRendererOptions.hasNext()) {
          break;
        }
        localObject3 = (Pair)paramDescriptorRendererOptions.next();
      } while (RawTypeImpl.render.1.INSTANCE.invoke((String)((Pair)localObject3).getFirst(), (String)((Pair)localObject3).getSecond()));
      i = 0;
    }
    paramDescriptorRendererOptions = (DescriptorRendererOptions)localObject1;
    if (i != 0) {
      paramDescriptorRendererOptions = local3.invoke((String)localObject1, (String)localObject2);
    }
    localObject1 = local3.invoke(str, (String)localObject2);
    if (Intrinsics.areEqual(localObject1, paramDescriptorRendererOptions)) {
      return localObject1;
    }
    return paramDescriptorRenderer.renderFlexibleType((String)localObject1, paramDescriptorRendererOptions, TypeUtilsKt.getBuiltIns(this));
  }
  
  @NotNull
  public RawTypeImpl replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new RawTypeImpl(getLowerBound().replaceAnnotations(paramAnnotations), getUpperBound().replaceAnnotations(paramAnnotations));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
 * JD-Core Version:    0.7.0.1
 */