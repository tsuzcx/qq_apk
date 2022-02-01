package com.tencent.tmassistantsdk.internal.c.a;

public class a
  extends com.tencent.tmassistant.common.a.a
{
  protected static a a;
  
  public static a e()
  {
    try
    {
      if (a == null) {
        a = new a();
      }
      a locala = a;
      return locala;
    }
    finally {}
  }
  
  protected String b()
  {
    return "BusinessInfoLogTable";
  }
  
  protected String[] b(int paramInt)
  {
    if (paramInt > 1) {
      return new String[] { c() };
    }
    return null;
  }
  
  protected String c()
  {
    return "CREATE TABLE if not exists BusinessInfoLogTable( _id INTEGER PRIMARY KEY AUTOINCREMENT, logData BLOB );";
  }
  
  protected String d()
  {
    return "INSERT INTO BusinessInfoLogTable logData = ?";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.c.a.a
 * JD-Core Version:    0.7.0.1
 */