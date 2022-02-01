package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.ApproximationBounds;
import kotlin.reflect.jvm.internal.impl.types.typesApproximation.CapturedTypeApproximationKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class UtilsKt
{
  private static final KotlinType approximate(@NotNull KotlinType paramKotlinType)
  {
    return (KotlinType)CapturedTypeApproximationKt.approximateCapturedTypes(paramKotlinType).getUpper();
  }
  
  private static final String debugInfo(@NotNull TypeConstructor paramTypeConstructor)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    UtilsKt.debugInfo.1.1 local1 = new UtilsKt.debugInfo.1.1(localStringBuilder1);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("type: ");
    localStringBuilder2.append(paramTypeConstructor);
    local1.invoke(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("hashCode: ");
    localStringBuilder2.append(paramTypeConstructor.hashCode());
    local1.invoke(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("javaClass: ");
    localStringBuilder2.append(paramTypeConstructor.getClass().getCanonicalName());
    local1.invoke(localStringBuilder2.toString());
    for (paramTypeConstructor = (DeclarationDescriptor)paramTypeConstructor.getDeclarationDescriptor(); paramTypeConstructor != null; paramTypeConstructor = paramTypeConstructor.getContainingDeclaration())
    {
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("fqName: ");
      localStringBuilder2.append(DescriptorRenderer.FQ_NAMES_IN_TYPES.render(paramTypeConstructor));
      local1.invoke(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("javaClass: ");
      localStringBuilder2.append(paramTypeConstructor.getClass().getCanonicalName());
      local1.invoke(localStringBuilder2.toString());
    }
    paramTypeConstructor = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramTypeConstructor, "StringBuilder().apply(builderAction).toString()");
    return paramTypeConstructor;
  }
  
  @Nullable
  public static final KotlinType findCorrespondingSupertype(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeCheckingProcedureCallbacks paramTypeCheckingProcedureCallbacks)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType1, "subtype");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "supertype");
    Intrinsics.checkParameterIsNotNull(paramTypeCheckingProcedureCallbacks, "typeCheckingProcedureCallbacks");
    Object localObject1 = new ArrayDeque();
    ((ArrayDeque)localObject1).add(new SubtypePathNode(paramKotlinType1, null));
    TypeConstructor localTypeConstructor = paramKotlinType2.getConstructor();
    while (!((ArrayDeque)localObject1).isEmpty())
    {
      paramKotlinType2 = (SubtypePathNode)((ArrayDeque)localObject1).poll();
      paramKotlinType1 = paramKotlinType2.getType();
      Object localObject2 = paramKotlinType1.getConstructor();
      if (paramTypeCheckingProcedureCallbacks.assertEqualTypeConstructors((TypeConstructor)localObject2, localTypeConstructor))
      {
        boolean bool = paramKotlinType1.isMarkedNullable();
        for (paramKotlinType2 = paramKotlinType2.getPrevious(); paramKotlinType2 != null; paramKotlinType2 = paramKotlinType2.getPrevious())
        {
          localObject1 = paramKotlinType2.getType();
          localObject2 = (Iterable)((KotlinType)localObject1).getArguments();
          if (((localObject2 instanceof Collection)) && (((Collection)localObject2).isEmpty())) {}
          do
          {
            while (!((Iterator)localObject2).hasNext())
            {
              i = 0;
              break;
              localObject2 = ((Iterable)localObject2).iterator();
            }
            if (((TypeProjection)((Iterator)localObject2).next()).getProjectionKind() != Variance.INVARIANT) {
              i = 1;
            } else {
              i = 0;
            }
          } while (i == 0);
          int i = 1;
          if (i != 0)
          {
            paramKotlinType1 = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(TypeConstructorSubstitution.Companion.create((KotlinType)localObject1), false, 1, null).buildSubstitutor().safeSubstitute(paramKotlinType1, Variance.INVARIANT);
            Intrinsics.checkExpressionValueIsNotNull(paramKotlinType1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
            paramKotlinType1 = approximate(paramKotlinType1);
          }
          else
          {
            paramKotlinType1 = TypeConstructorSubstitution.Companion.create((KotlinType)localObject1).buildSubstitutor().safeSubstitute(paramKotlinType1, Variance.INVARIANT);
            Intrinsics.checkExpressionValueIsNotNull(paramKotlinType1, "TypeConstructorSubstitut…uted, Variance.INVARIANT)");
          }
          if ((!bool) && (!((KotlinType)localObject1).isMarkedNullable())) {
            bool = false;
          } else {
            bool = true;
          }
        }
        paramKotlinType2 = paramKotlinType1.getConstructor();
        if (paramTypeCheckingProcedureCallbacks.assertEqualTypeConstructors(paramKotlinType2, localTypeConstructor)) {
          return TypeUtils.makeNullableAsSpecified(paramKotlinType1, bool);
        }
        paramKotlinType1 = new StringBuilder();
        paramKotlinType1.append("Type constructors should be equals!\n");
        paramKotlinType1.append("substitutedSuperType: ");
        paramKotlinType1.append(debugInfo(paramKotlinType2));
        paramKotlinType1.append(", \n\n");
        paramKotlinType1.append("supertype: ");
        paramKotlinType1.append(debugInfo(localTypeConstructor));
        paramKotlinType1.append(" \n");
        paramKotlinType1.append(paramTypeCheckingProcedureCallbacks.assertEqualTypeConstructors(paramKotlinType2, localTypeConstructor));
        throw ((Throwable)new AssertionError(paramKotlinType1.toString()));
      }
      paramKotlinType1 = ((TypeConstructor)localObject2).getSupertypes().iterator();
      while (paramKotlinType1.hasNext())
      {
        localObject2 = (KotlinType)paramKotlinType1.next();
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "immediateSupertype");
        ((ArrayDeque)localObject1).add(new SubtypePathNode((KotlinType)localObject2, paramKotlinType2));
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.UtilsKt
 * JD-Core Version:    0.7.0.1
 */