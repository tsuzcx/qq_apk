package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class AbstractTypeCheckerContext$SupertypesPolicy$None
  extends AbstractTypeCheckerContext.SupertypesPolicy
{
  public static final None INSTANCE = new None();
  
  private AbstractTypeCheckerContext$SupertypesPolicy$None()
  {
    super(null);
  }
  
  @NotNull
  public Void transformType(@NotNull AbstractTypeCheckerContext paramAbstractTypeCheckerContext, @NotNull KotlinTypeMarker paramKotlinTypeMarker)
  {
    Intrinsics.checkParameterIsNotNull(paramAbstractTypeCheckerContext, "context");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeMarker, "type");
    throw ((Throwable)new UnsupportedOperationException("Should not be called"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbstractTypeCheckerContext.SupertypesPolicy.None
 * JD-Core Version:    0.7.0.1
 */