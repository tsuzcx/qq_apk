package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.functions.Function1;

public final class ReturnsCheck$ReturnsUnit
  extends ReturnsCheck
{
  public static final ReturnsUnit INSTANCE = new ReturnsUnit();
  
  private ReturnsCheck$ReturnsUnit()
  {
    super("Unit", (Function1)ReturnsCheck.ReturnsUnit.1.INSTANCE, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.util.ReturnsCheck.ReturnsUnit
 * JD-Core Version:    0.7.0.1
 */