package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin._Assertions;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class MappingUtilKt
{
  @NotNull
  public static final TypeConstructorSubstitution createMappedTypeParametersSubstitution(@NotNull ClassDescriptor paramClassDescriptor1, @NotNull ClassDescriptor paramClassDescriptor2)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor1, "from");
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor2, "to");
    int i;
    if (paramClassDescriptor1.getDeclaredTypeParameters().size() == paramClassDescriptor2.getDeclaredTypeParameters().size()) {
      i = 1;
    } else {
      i = 0;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramClassDescriptor1);
      ((StringBuilder)localObject1).append(" and ");
      ((StringBuilder)localObject1).append(paramClassDescriptor2);
      ((StringBuilder)localObject1).append(" should have same number of type parameters, ");
      ((StringBuilder)localObject1).append("but ");
      ((StringBuilder)localObject1).append(paramClassDescriptor1.getDeclaredTypeParameters().size());
      ((StringBuilder)localObject1).append(" / ");
      ((StringBuilder)localObject1).append(paramClassDescriptor2.getDeclaredTypeParameters().size());
      ((StringBuilder)localObject1).append(" found");
      throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
    }
    Object localObject1 = TypeConstructorSubstitution.Companion;
    paramClassDescriptor1 = paramClassDescriptor1.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor1, "from.declaredTypeParameters");
    Object localObject2 = (Iterable)paramClassDescriptor1;
    paramClassDescriptor1 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      paramClassDescriptor1.add(((TypeParameterDescriptor)((Iterator)localObject2).next()).getTypeConstructor());
    }
    paramClassDescriptor1 = (Iterable)paramClassDescriptor1;
    paramClassDescriptor2 = paramClassDescriptor2.getDeclaredTypeParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor2, "to.declaredTypeParameters");
    localObject2 = (Iterable)paramClassDescriptor2;
    paramClassDescriptor2 = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (TypeParameterDescriptor)((Iterator)localObject2).next();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
      localObject3 = ((TypeParameterDescriptor)localObject3).getDefaultType();
      Intrinsics.checkExpressionValueIsNotNull(localObject3, "it.defaultType");
      paramClassDescriptor2.add(TypeUtilsKt.asTypeProjection((KotlinType)localObject3));
    }
    return TypeConstructorSubstitution.Companion.createByConstructorsMap$default((TypeConstructorSubstitution.Companion)localObject1, MapsKt.toMap((Iterable)CollectionsKt.zip(paramClassDescriptor1, (Iterable)paramClassDescriptor2)), false, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.jvm.MappingUtilKt
 * JD-Core Version:    0.7.0.1
 */