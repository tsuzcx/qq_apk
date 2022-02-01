package com.tencent.mobileqq.c2cshortcutbar;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.List;

public class C2CShortcutBarObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, long paramLong) {}
  
  protected void a(boolean paramBoolean, long paramLong, List<C2CShortcutAppInfo> paramList) {}
  
  public void a(boolean paramBoolean1, String paramString, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, ((Long)paramObject[0]).longValue(), (ArrayList)paramObject[1]);
      return;
    }
    if (paramInt == 2)
    {
      paramObject = (Object[])paramObject;
      a(paramBoolean, (String)paramObject[0], ((Boolean)paramObject[1]).booleanValue());
      return;
    }
    if (paramInt == 3)
    {
      a(paramBoolean, ((Boolean)paramObject).booleanValue());
      return;
    }
    if (paramInt == 6) {
      a(paramBoolean, ((Long)((Object[])(Object[])paramObject)[0]).longValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarObserver
 * JD-Core Version:    0.7.0.1
 */