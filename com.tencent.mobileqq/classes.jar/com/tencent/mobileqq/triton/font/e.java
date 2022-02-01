package com.tencent.mobileqq.triton.font;

public final class e
{
  public static final e b = new e("tableDirectory");
  public static final e c = new e("name");
  private final String a;
  
  private e(String paramString)
  {
    this.a = paramString;
  }
  
  public static e a(String paramString)
  {
    if (paramString != null) {
      return new e(paramString);
    }
    throw new IllegalArgumentException("A TrueType font table name must not be null");
  }
  
  public String a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
    return this.a.equals(paramObject.a());
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
  
  public String toString()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.e
 * JD-Core Version:    0.7.0.1
 */