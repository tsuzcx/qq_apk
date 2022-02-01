package org.aspectj.runtime.reflect;

import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.SourceLocation;

class JoinPointImpl$StaticPartImpl
  implements JoinPoint.StaticPart
{
  private int id;
  String kind;
  Signature signature;
  SourceLocation sourceLocation;
  
  public JoinPointImpl$StaticPartImpl(int paramInt, String paramString, Signature paramSignature, SourceLocation paramSourceLocation)
  {
    this.kind = paramString;
    this.signature = paramSignature;
    this.sourceLocation = paramSourceLocation;
    this.id = paramInt;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String getKind()
  {
    return this.kind;
  }
  
  public Signature getSignature()
  {
    return this.signature;
  }
  
  public SourceLocation getSourceLocation()
  {
    return this.sourceLocation;
  }
  
  public final String toLongString()
  {
    return toString(StringMaker.longStringMaker);
  }
  
  public final String toShortString()
  {
    return toString(StringMaker.shortStringMaker);
  }
  
  public final String toString()
  {
    return toString(StringMaker.middleStringMaker);
  }
  
  String toString(StringMaker paramStringMaker)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(paramStringMaker.makeKindName(getKind()));
    localStringBuffer.append("(");
    localStringBuffer.append(((SignatureImpl)getSignature()).toString(paramStringMaker));
    localStringBuffer.append(")");
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.JoinPointImpl.StaticPartImpl
 * JD-Core Version:    0.7.0.1
 */