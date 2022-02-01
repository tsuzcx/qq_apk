package org.aspectj.internal.lang.reflect;

import org.aspectj.lang.reflect.SignaturePattern;

public class SignaturePatternImpl
  implements SignaturePattern
{
  private String sigPattern;
  
  public SignaturePatternImpl(String paramString)
  {
    this.sigPattern = paramString;
  }
  
  public String asString()
  {
    return this.sigPattern;
  }
  
  public String toString()
  {
    return asString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.internal.lang.reflect.SignaturePatternImpl
 * JD-Core Version:    0.7.0.1
 */