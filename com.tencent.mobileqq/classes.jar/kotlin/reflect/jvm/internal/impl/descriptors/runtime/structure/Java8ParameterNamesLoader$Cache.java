package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.Method;
import org.jetbrains.annotations.Nullable;

public final class Java8ParameterNamesLoader$Cache
{
  @Nullable
  private final Method getName;
  @Nullable
  private final Method getParameters;
  
  public Java8ParameterNamesLoader$Cache(@Nullable Method paramMethod1, @Nullable Method paramMethod2)
  {
    this.getParameters = paramMethod1;
    this.getName = paramMethod2;
  }
  
  @Nullable
  public final Method getGetName()
  {
    return this.getName;
  }
  
  @Nullable
  public final Method getGetParameters()
  {
    return this.getParameters;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.Java8ParameterNamesLoader.Cache
 * JD-Core Version:    0.7.0.1
 */