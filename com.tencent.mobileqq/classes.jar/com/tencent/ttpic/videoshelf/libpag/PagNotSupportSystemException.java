package com.tencent.ttpic.videoshelf.libpag;

public class PagNotSupportSystemException
  extends Exception
{
  private String mClassName;
  
  public PagNotSupportSystemException(String paramString)
  {
    this.mClassName = paramString;
  }
  
  public String getMessage()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.getMessage());
    localStringBuilder.append(",");
    localStringBuilder.append(this.mClassName);
    localStringBuilder.append("，当前android 系统太低，不支持pag，需要保证系统在android 4.3以及以上。");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException
 * JD-Core Version:    0.7.0.1
 */