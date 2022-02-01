package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import org.jetbrains.annotations.NotNull;

public final class StrictEqualityTypeChecker
{
  public static final StrictEqualityTypeChecker INSTANCE = new StrictEqualityTypeChecker();
  
  public final boolean strictEqualTypes(@NotNull UnwrappedType paramUnwrappedType1, @NotNull UnwrappedType paramUnwrappedType2)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType1, "a");
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType2, "b");
    return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes((TypeSystemContext)SimpleClassicTypeSystemContext.INSTANCE, (KotlinTypeMarker)paramUnwrappedType1, (KotlinTypeMarker)paramUnwrappedType2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.StrictEqualityTypeChecker
 * JD-Core Version:    0.7.0.1
 */