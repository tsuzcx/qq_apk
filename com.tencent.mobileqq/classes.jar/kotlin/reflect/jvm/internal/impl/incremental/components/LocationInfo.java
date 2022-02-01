package kotlin.reflect.jvm.internal.impl.incremental.components;

import org.jetbrains.annotations.NotNull;

public abstract interface LocationInfo
{
  @NotNull
  public abstract String getFilePath();
  
  @NotNull
  public abstract Position getPosition();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo
 * JD-Core Version:    0.7.0.1
 */