package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;

public abstract class GuildMessageObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
    i = a;
    a = i + 1;
    d = i;
    i = a;
    a = i + 1;
    e = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 1)
      {
        paramObject = (String)paramObject[0];
        break label42;
      }
    }
    paramObject = "";
    label42:
    a(paramObject);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length >= 2)
      {
        paramObject = (String)arrayOfObject[0];
        l = ((Long)arrayOfObject[1]).longValue();
        break label60;
      }
    }
    paramObject = "";
    long l = 0L;
    label60:
    a(paramObject, l);
  }
  
  private void c(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != d) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 5)
      {
        localObject1 = (String)paramObject[0];
        l = ((Long)paramObject[1]).longValue();
        i = ((Integer)paramObject[2]).intValue();
        paramInt = ((Integer)paramObject[3]).intValue();
        paramObject = (String)paramObject[4];
        localObject2 = paramObject;
        break label99;
      }
    }
    long l = 0L;
    paramObject = "";
    Object localObject2 = paramObject;
    int i = 0;
    paramInt = 0;
    Object localObject1 = paramObject;
    label99:
    a((String)localObject1, l, i, paramInt, localObject2);
  }
  
  private void d(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != e) {
      return;
    }
    long l = 0L;
    if ((paramObject instanceof Object[]))
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length >= 2)
      {
        paramObject = (String)arrayOfObject[0];
        l = ((Long)arrayOfObject[1]).longValue();
        break label60;
      }
    }
    paramObject = "";
    label60:
    a(paramBoolean, paramObject, l);
  }
  
  protected void a(String paramString) {}
  
  protected void a(String paramString, long paramLong) {}
  
  protected void a(String paramString1, long paramLong, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void a(boolean paramBoolean, String paramString, long paramLong) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
    c(paramInt, paramBoolean, paramObject);
    d(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildMessageObserver
 * JD-Core Version:    0.7.0.1
 */