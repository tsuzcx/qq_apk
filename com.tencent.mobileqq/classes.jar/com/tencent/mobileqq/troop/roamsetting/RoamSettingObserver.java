package com.tencent.mobileqq.troop.roamsetting;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.Map;

public class RoamSettingObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, String paramString, Map<String, Integer> paramMap) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    boolean bool2 = false;
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        if (paramObject.length == 2) {
          a(paramBoolean, (String)paramObject[0], (Map)paramObject[1]);
        }
      }
    }
    else
    {
      boolean bool1 = bool2;
      if ((paramObject instanceof Object[]))
      {
        paramObject = (Object[])paramObject;
        bool1 = bool2;
        if (paramObject.length == 1)
        {
          bool1 = bool2;
          if ((paramObject[0] instanceof Boolean)) {
            bool1 = ((Boolean)paramObject[0]).booleanValue();
          }
        }
      }
      a(paramBoolean, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.roamsetting.RoamSettingObserver
 * JD-Core Version:    0.7.0.1
 */