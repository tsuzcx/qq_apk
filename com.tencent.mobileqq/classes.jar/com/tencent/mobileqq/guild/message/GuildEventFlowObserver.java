package com.tencent.mobileqq.guild.message;

import com.tencent.mobileqq.app.BusinessObserver;

public class GuildEventFlowObserver
  implements BusinessObserver
{
  private static int a;
  public static final int b;
  
  static
  {
    int i = a;
    a = i + 1;
    b = i;
  }
  
  private void a(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != b) {
      return;
    }
    boolean bool2 = paramObject instanceof Object[];
    boolean bool1 = false;
    if (bool2)
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length >= 2)
      {
        bool1 = ((Boolean)paramObject[0]).booleanValue();
        paramObject = (String)paramObject[1];
        break label60;
      }
    }
    paramObject = "";
    label60:
    a(paramBoolean, bool1, paramObject);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    a(paramInt, paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.GuildEventFlowObserver
 * JD-Core Version:    0.7.0.1
 */