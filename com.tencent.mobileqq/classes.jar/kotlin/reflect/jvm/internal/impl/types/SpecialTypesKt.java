package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SpecialTypesKt
{
  @Nullable
  public static final AbbreviatedType getAbbreviatedType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getAbbreviatedType");
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    paramKotlinType = localUnwrappedType;
    if (!(localUnwrappedType instanceof AbbreviatedType)) {
      paramKotlinType = null;
    }
    return (AbbreviatedType)paramKotlinType;
  }
  
  @Nullable
  public static final SimpleType getAbbreviation(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getAbbreviation");
    paramKotlinType = getAbbreviatedType(paramKotlinType);
    if (paramKotlinType != null) {
      return paramKotlinType.getAbbreviation();
    }
    return null;
  }
  
  public static final boolean isDefinitelyNotNullType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isDefinitelyNotNullType");
    return paramKotlinType.unwrap() instanceof DefinitelyNotNullType;
  }
  
  private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(@NotNull IntersectionTypeConstructor paramIntersectionTypeConstructor)
  {
    paramIntersectionTypeConstructor = (Iterable)paramIntersectionTypeConstructor.getSupertypes();
    Collection localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramIntersectionTypeConstructor, 10));
    Iterator localIterator = paramIntersectionTypeConstructor.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      KotlinType localKotlinType = (KotlinType)localIterator.next();
      paramIntersectionTypeConstructor = localKotlinType;
      if (TypeUtils.isNullableType(localKotlinType))
      {
        i = 1;
        paramIntersectionTypeConstructor = (KotlinType)makeDefinitelyNotNullOrNotNull(localKotlinType.unwrap());
      }
      localCollection.add(paramIntersectionTypeConstructor);
    }
    paramIntersectionTypeConstructor = (List)localCollection;
    if (i == 0) {
      return null;
    }
    return new IntersectionTypeConstructor((Collection)paramIntersectionTypeConstructor);
  }
  
  @NotNull
  public static final UnwrappedType makeDefinitelyNotNullOrNotNull(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "$this$makeDefinitelyNotNullOrNotNull");
    Object localObject = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors(paramUnwrappedType);
    if (localObject != null) {
      localObject = (UnwrappedType)localObject;
    } else {
      localObject = (UnwrappedType)makeIntersectionTypeDefinitelyNotNullOrNotNull((KotlinType)paramUnwrappedType);
    }
    if (localObject != null) {
      return localObject;
    }
    return paramUnwrappedType.makeNullableAsSpecified(false);
  }
  
  private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(@NotNull KotlinType paramKotlinType)
  {
    TypeConstructor localTypeConstructor = paramKotlinType.getConstructor();
    paramKotlinType = localTypeConstructor;
    if (!(localTypeConstructor instanceof IntersectionTypeConstructor)) {
      paramKotlinType = null;
    }
    paramKotlinType = (IntersectionTypeConstructor)paramKotlinType;
    if (paramKotlinType != null)
    {
      paramKotlinType = makeDefinitelyNotNullOrNotNull(paramKotlinType);
      if (paramKotlinType != null) {
        return paramKotlinType.createType();
      }
    }
    return null;
  }
  
  @NotNull
  public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "$this$makeSimpleTypeDefinitelyNotNullOrNotNull");
    Object localObject = DefinitelyNotNullType.Companion.makeDefinitelyNotNull$descriptors((UnwrappedType)paramSimpleType);
    if (localObject != null) {
      localObject = (SimpleType)localObject;
    } else {
      localObject = makeIntersectionTypeDefinitelyNotNullOrNotNull((KotlinType)paramSimpleType);
    }
    if (localObject != null) {
      return localObject;
    }
    return paramSimpleType.makeNullableAsSpecified(false);
  }
  
  @NotNull
  public static final SimpleType withAbbreviation(@NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType1, "$this$withAbbreviation");
    Intrinsics.checkParameterIsNotNull(paramSimpleType2, "abbreviatedType");
    if (KotlinTypeKt.isError((KotlinType)paramSimpleType1)) {
      return paramSimpleType1;
    }
    return (SimpleType)new AbbreviatedType(paramSimpleType1, paramSimpleType2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt
 * JD-Core Version:    0.7.0.1
 */