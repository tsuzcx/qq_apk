package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2
  extends AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform
{
  ClassicTypeCheckerContext$Companion$classicSubstitutionSupertypePolicy$2(ClassicTypeSystemContext paramClassicTypeSystemContext, TypeSubstitutor paramTypeSubstitutor) {}
  
  @NotNull
  public SimpleTypeMarker transformType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    paramAbstractTypeCheckerContext = this.$this_classicSubstitutionSupertypePolicy;
    TypeSubstitutor localTypeSubstitutor = this.$substitutor;
    paramKotlinTypeMarker = paramAbstractTypeCheckerContext.lowerBoundIfFlexible(paramKotlinTypeMarker);
    if (paramKotlinTypeMarker != null)
    {
      paramKotlinTypeMarker = localTypeSubstitutor.safeSubstitute((KotlinType)paramKotlinTypeMarker, Variance.INVARIANT);
      Intrinsics.checkExpressionValueIsNotNull(paramKotlinTypeMarker, "substitutor.safeSubstitu…ANT\n                    )");
      paramAbstractTypeCheckerContext = paramAbstractTypeCheckerContext.asSimpleType((KotlinTypeMarker)paramKotlinTypeMarker);
      if (paramAbstractTypeCheckerContext == null) {
        Intrinsics.throwNpe();
      }
      return paramAbstractTypeCheckerContext;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.KotlinType");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext.Companion.classicSubstitutionSupertypePolicy.2
 * JD-Core Version:    0.7.0.1
 */