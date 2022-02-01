package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.TypePattern;

public class TypePatternImpl
  implements TypePattern
{
  private String typePattern;
  
  public TypePatternImpl(String paramString)
  {
    this.typePattern = paramString;
  }
  
  public String asString()
  {
    return this.typePattern;
  }
  
  public String toString()
  {
    return asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.TypePatternImpl
 * JD-Core Version:    0.7.0.1
 */