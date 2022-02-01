package kotlin.reflect.jvm.internal.impl.types.model;

import org.jetbrains.annotations.NotNull;

public enum TypeVariance
{
  @NotNull
  private final String presentation;
  
  static
  {
    TypeVariance localTypeVariance1 = new TypeVariance("IN", 0, "in");
    IN = localTypeVariance1;
    TypeVariance localTypeVariance2 = new TypeVariance("OUT", 1, "out");
    OUT = localTypeVariance2;
    TypeVariance localTypeVariance3 = new TypeVariance("INV", 2, "");
    INV = localTypeVariance3;
    $VALUES = new TypeVariance[] { localTypeVariance1, localTypeVariance2, localTypeVariance3 };
  }
  
  private TypeVariance(String paramString)
  {
    this.presentation = paramString;
  }
  
  @NotNull
  public String toString()
  {
    return this.presentation;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.model.TypeVariance
 * JD-Core Version:    0.7.0.1
 */