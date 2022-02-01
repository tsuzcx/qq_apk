package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class IntegerLiteralTypeConstructor$Companion
{
  private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> paramCollection, IntegerLiteralTypeConstructor.Companion.Mode paramMode)
  {
    if (paramCollection.isEmpty()) {
      return null;
    }
    Iterator localIterator = ((Iterable)paramCollection).iterator();
    if (localIterator.hasNext())
    {
      SimpleType localSimpleType;
      for (paramCollection = localIterator.next(); localIterator.hasNext(); paramCollection = IntegerLiteralTypeConstructor.Companion.fold(paramCollection, localSimpleType, paramMode))
      {
        localSimpleType = (SimpleType)localIterator.next();
        paramCollection = (SimpleType)paramCollection;
      }
      return (SimpleType)paramCollection;
    }
    paramCollection = (Throwable)new UnsupportedOperationException("Empty collection can't be reduced.");
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  private final SimpleType fold(IntegerLiteralTypeConstructor paramIntegerLiteralTypeConstructor1, IntegerLiteralTypeConstructor paramIntegerLiteralTypeConstructor2, IntegerLiteralTypeConstructor.Companion.Mode paramMode)
  {
    int i = IntegerLiteralTypeConstructor.Companion.WhenMappings.$EnumSwitchMapping$0[paramMode.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        paramIntegerLiteralTypeConstructor2 = CollectionsKt.union((Iterable)paramIntegerLiteralTypeConstructor1.getPossibleTypes(), (Iterable)paramIntegerLiteralTypeConstructor2.getPossibleTypes());
      } else {
        throw new NoWhenBranchMatchedException();
      }
    }
    else {
      paramIntegerLiteralTypeConstructor2 = CollectionsKt.intersect((Iterable)paramIntegerLiteralTypeConstructor1.getPossibleTypes(), (Iterable)paramIntegerLiteralTypeConstructor2.getPossibleTypes());
    }
    paramIntegerLiteralTypeConstructor1 = new IntegerLiteralTypeConstructor(IntegerLiteralTypeConstructor.access$getValue$p(paramIntegerLiteralTypeConstructor1), IntegerLiteralTypeConstructor.access$getModule$p(paramIntegerLiteralTypeConstructor1), paramIntegerLiteralTypeConstructor2, null);
    return KotlinTypeFactory.integerLiteralType(Annotations.Companion.getEMPTY(), paramIntegerLiteralTypeConstructor1, false);
  }
  
  private final SimpleType fold(IntegerLiteralTypeConstructor paramIntegerLiteralTypeConstructor, SimpleType paramSimpleType)
  {
    if (paramIntegerLiteralTypeConstructor.getPossibleTypes().contains(paramSimpleType)) {
      return paramSimpleType;
    }
    return null;
  }
  
  private final SimpleType fold(SimpleType paramSimpleType1, SimpleType paramSimpleType2, IntegerLiteralTypeConstructor.Companion.Mode paramMode)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSimpleType1 != null)
    {
      if (paramSimpleType2 == null) {
        return null;
      }
      localObject1 = paramSimpleType1.getConstructor();
      TypeConstructor localTypeConstructor = paramSimpleType2.getConstructor();
      boolean bool = localObject1 instanceof IntegerLiteralTypeConstructor;
      if ((bool) && ((localTypeConstructor instanceof IntegerLiteralTypeConstructor))) {
        return ((Companion)this).fold((IntegerLiteralTypeConstructor)localObject1, (IntegerLiteralTypeConstructor)localTypeConstructor, paramMode);
      }
      if (bool) {
        return ((Companion)this).fold((IntegerLiteralTypeConstructor)localObject1, paramSimpleType2);
      }
      localObject1 = localObject2;
      if ((localTypeConstructor instanceof IntegerLiteralTypeConstructor)) {
        localObject1 = ((Companion)this).fold((IntegerLiteralTypeConstructor)localTypeConstructor, paramSimpleType1);
      }
    }
    return localObject1;
  }
  
  @Nullable
  public final SimpleType findIntersectionType(@NotNull Collection<? extends SimpleType> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "types");
    return ((Companion)this).findCommonSuperTypeOrIntersectionType(paramCollection, IntegerLiteralTypeConstructor.Companion.Mode.INTERSECTION_TYPE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor.Companion
 * JD-Core Version:    0.7.0.1
 */