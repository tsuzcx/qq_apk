package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

public abstract class ErrorValue
  extends ConstantValue<Unit>
{
  public static final ErrorValue.Companion Companion = new ErrorValue.Companion(null);
  
  public ErrorValue()
  {
    super(Unit.INSTANCE);
  }
  
  @NotNull
  public Unit getValue()
  {
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.constants.ErrorValue
 * JD-Core Version:    0.7.0.1
 */