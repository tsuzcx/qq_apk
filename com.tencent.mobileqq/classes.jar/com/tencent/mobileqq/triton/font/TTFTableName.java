package com.tencent.mobileqq.triton.font;

public final class TTFTableName
{
  public static final TTFTableName NAME = new TTFTableName("name");
  public static final TTFTableName TABLE_DIRECTORY = new TTFTableName("tableDirectory");
  private final String name;
  
  private TTFTableName(String paramString)
  {
    this.name = paramString;
  }
  
  public static TTFTableName getValue(String paramString)
  {
    if (paramString != null) {
      return new TTFTableName(paramString);
    }
    throw new IllegalArgumentException("A TrueType font table name must not be null");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof TTFTableName)) {
      return false;
    }
    paramObject = (TTFTableName)paramObject;
    return this.name.equals(paramObject.getName());
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode();
  }
  
  public String toString()
  {
    return this.name;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.TTFTableName
 * JD-Core Version:    0.7.0.1
 */