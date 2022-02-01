package org.aspectj.runtime.reflect;

import org.aspectj.lang.reflect.SourceLocation;

class SourceLocationImpl
  implements SourceLocation
{
  String fileName;
  int line;
  Class withinType;
  
  SourceLocationImpl(Class paramClass, String paramString, int paramInt)
  {
    this.withinType = paramClass;
    this.fileName = paramString;
    this.line = paramInt;
  }
  
  public int getColumn()
  {
    return -1;
  }
  
  public String getFileName()
  {
    return this.fileName;
  }
  
  public int getLine()
  {
    return this.line;
  }
  
  public Class getWithinType()
  {
    return this.withinType;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getFileName());
    localStringBuilder.append(":");
    localStringBuilder.append(getLine());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.runtime.reflect.SourceLocationImpl
 * JD-Core Version:    0.7.0.1
 */