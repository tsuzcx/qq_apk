package com.tencent.mobileqq.intervideo;

class FormattingTuple
{
  public static FormattingTuple a = new FormattingTuple(null);
  private String b;
  private Throwable c;
  private Object[] d;
  
  public FormattingTuple(String paramString)
  {
    this(paramString, null, null);
  }
  
  public FormattingTuple(String paramString, Object[] paramArrayOfObject, Throwable paramThrowable)
  {
    this.b = paramString;
    this.c = paramThrowable;
    this.d = paramArrayOfObject;
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.FormattingTuple
 * JD-Core Version:    0.7.0.1
 */