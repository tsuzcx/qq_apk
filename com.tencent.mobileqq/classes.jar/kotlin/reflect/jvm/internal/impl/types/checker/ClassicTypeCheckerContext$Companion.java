package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class ClassicTypeCheckerContext$Companion
{
  @NotNull
  public final AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform classicSubstitutionSupertypePolicy(@NotNull ClassicTypeSystemContext paramClassicTypeSystemContext, @NotNull SimpleTypeMarker paramSimpleTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramClassicTypeSystemContext, "$this$classicSubstitutionSupertypePolicy");
    Intrinsics.checkParameterIsNotNull(paramSimpleTypeMarker, "type");
    if ((paramSimpleTypeMarker instanceof SimpleType)) {
      return (AbstractTypeCheckerContext.SupertypesPolicy.DoCustomTransform)new ClassicTypeCheckerContext.Companion.classicSubstitutionSupertypePolicy.2(paramClassicTypeSystemContext, TypeConstructorSubstitution.Companion.create((KotlinType)paramSimpleTypeMarker).buildSubstitutor());
    }
    throw ((Throwable)new IllegalArgumentException(ClassicTypeCheckerContextKt.access$errorMessage(paramSimpleTypeMarker).toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContext.Companion
 * JD-Core Version:    0.7.0.1
 */