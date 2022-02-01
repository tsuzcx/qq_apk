package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeCheckerContext$SupertypesPolicy$UpperIfFlexible
  extends AbstractTypeCheckerContext.SupertypesPolicy
{
  public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();
  
  private AbstractTypeCheckerContext$SupertypesPolicy$UpperIfFlexible()
  {
    super(null);
  }
  
  @NotNull
  public SimpleTypeMarker transformType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    return paramAbstractTypeCheckerContext.upperBoundIfFlexible(paramKotlinTypeMarker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.UpperIfFlexible
 * JD-Core Version:    0.7.0.1
 */