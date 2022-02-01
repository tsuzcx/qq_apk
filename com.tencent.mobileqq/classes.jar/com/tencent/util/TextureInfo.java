package com.tencent.util;

import com.tencent.ttpic.model.SizeI;

public class TextureInfo
{
  private final SizeI size;
  private final String stackTrace;
  
  public TextureInfo()
  {
    this(null, null);
  }
  
  public TextureInfo(SizeI paramSizeI, String paramString)
  {
    SizeI localSizeI = paramSizeI;
    if (paramSizeI == null) {
      localSizeI = new SizeI(0, 0);
    }
    paramSizeI = paramString;
    if (paramString == null) {
      paramSizeI = "";
    }
    this.size = localSizeI;
    this.stackTrace = paramSizeI;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TextureInfo))
      {
        paramObject = (TextureInfo)paramObject;
        return (this.size.equals(paramObject.size)) && (this.stackTrace.equals(paramObject.stackTrace));
      }
      return false;
    }
    return true;
  }
  
  public SizeI getSize()
  {
    return this.size;
  }
  
  public String getStackTrace()
  {
    return this.stackTrace;
  }
  
  public int hashCode()
  {
    Object localObject = this.size;
    int j = 0;
    int i;
    if (localObject != null) {
      i = ((SizeI)localObject).hashCode();
    } else {
      i = 0;
    }
    localObject = this.stackTrace;
    if (localObject != null) {
      j = ((String)localObject).hashCode();
    }
    return i * 31 + j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TextureInfo(size=");
    localStringBuilder.append(this.size);
    localStringBuilder.append(", stackTrace=");
    localStringBuilder.append(this.stackTrace);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.TextureInfo
 * JD-Core Version:    0.7.0.1
 */