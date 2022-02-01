package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import org.jetbrains.annotations.NotNull;

public final class TypeConstructorSubstitution$Companion
{
  @JvmStatic
  @NotNull
  public final TypeSubstitution create(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "kotlinType");
    return ((Companion)this).create(paramKotlinType.getConstructor(), paramKotlinType.getArguments());
  }
  
  @JvmStatic
  @NotNull
  public final TypeSubstitution create(@NotNull TypeConstructor paramTypeConstructor, @NotNull List<? extends TypeProjection> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "typeConstructor");
    Intrinsics.checkParameterIsNotNull(paramList, "arguments");
    Object localObject1 = paramTypeConstructor.getParameters();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "typeConstructor.parameters");
    Object localObject2 = (TypeParameterDescriptor)CollectionsKt.lastOrNull((List)localObject1);
    boolean bool;
    if (localObject2 != null) {
      bool = ((TypeParameterDescriptor)localObject2).isCapturedFromOuterDeclaration();
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject1 = (Companion)this;
      paramTypeConstructor = paramTypeConstructor.getParameters();
      Intrinsics.checkExpressionValueIsNotNull(paramTypeConstructor, "typeConstructor.parameters");
      localObject2 = (Iterable)paramTypeConstructor;
      paramTypeConstructor = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        TypeParameterDescriptor localTypeParameterDescriptor = (TypeParameterDescriptor)((Iterator)localObject2).next();
        Intrinsics.checkExpressionValueIsNotNull(localTypeParameterDescriptor, "it");
        paramTypeConstructor.add(localTypeParameterDescriptor.getTypeConstructor());
      }
      return (TypeSubstitution)createByConstructorsMap$default((Companion)localObject1, MapsKt.toMap((Iterable)CollectionsKt.zip((Iterable)paramTypeConstructor, (Iterable)paramList)), false, 2, null);
    }
    return (TypeSubstitution)new IndexedParametersSubstitution((List)localObject1, paramList);
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> paramMap, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "map");
    return (TypeConstructorSubstitution)new TypeConstructorSubstitution.Companion.createByConstructorsMap.1(paramMap, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion
 * JD-Core Version:    0.7.0.1
 */