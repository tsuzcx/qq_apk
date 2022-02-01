package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeCheckerContext$SupertypesPolicy$LowerIfFlexible
  extends AbstractTypeCheckerContext.SupertypesPolicy
{
  public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();
  
  private AbstractTypeCheckerContext$SupertypesPolicy$LowerIfFlexible()
  {
    super(null);
  }
  
  @NotNull
  public SimpleTypeMarker transformType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    return paramAbstractTypeCheckerContext.lowerBoundIfFlexible(paramKotlinTypeMarker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.LowerIfFlexible
 * JD-Core Version:    0.7.0.1
 */