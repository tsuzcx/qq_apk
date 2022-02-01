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
    return super.getMessage() + "," + this.mClassName + "，当前android 系统太低，不支持pag，需要保证系统在android 4.3以及以上。";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException
 * JD-Core Version:    0.7.0.1
 */