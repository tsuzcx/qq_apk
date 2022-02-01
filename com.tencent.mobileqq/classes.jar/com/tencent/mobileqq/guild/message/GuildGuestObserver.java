package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;

public class GuildGuestObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  public static final int c;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
    i = a;
    a = i + 1;
    c = i;
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
    a(paramBoolean, paramObject);
  }
  
  private void b(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != c) {
      return;
    }
    boolean bool = paramObject instanceof Object[];
    paramInt = 0;
    if (bool)
    {
      Object[] arrayOfObject = (Object[])paramObject;
      if (arrayOfObject.length >= 3)
      {
        paramObject = (String)arrayOfObject[0];
        paramInt = ((Integer)arrayOfObject[1]).intValue();
        i = ((Integer)arrayOfObject[2]).intValue();
        break label77;
      }
    }
    paramObject = "";
    int i = 0;
    label77:
    a(paramBoolean, paramObject, paramInt, i);
  }
  
  protected void a(boolean paramBoolean, String paramString) {}
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
    b(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildGuestObserver
 * JD-Core Version:    0.7.0.1
 */