package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import java.util.List;

public class NearbyRelevantObserver
  implements BusinessObserver
{
  public void a(String paramString1, String paramString2, Object paramObject) {}
  
  protected void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, String paramString1, List<InterestTag> paramList, String paramString2, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, List<Object> paramList) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void b(boolean paramBoolean) {}
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 12)
    {
      if (paramInt != 14)
      {
        if (paramInt != 15)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 8: 
            paramObject = (Object[])paramObject;
            a((String)paramObject[0], (String)paramObject[1], paramObject[2]);
            return;
          case 7: 
            b(paramBoolean);
            return;
          case 6: 
            c(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
            return;
          case 5: 
            paramObject = (Object[])paramObject;
            if ((paramBoolean) && (paramObject != null) && (paramObject.length == 1))
            {
              a(paramBoolean, (List)paramObject[0]);
              return;
            }
            a(false, null);
            return;
          }
          paramObject = (Object[])paramObject;
          a(paramBoolean, (String)paramObject[0], (List)paramObject[1], (String)paramObject[2], ((Integer)paramObject[3]).intValue(), ((Integer)paramObject[4]).intValue());
          return;
        }
        a(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
        return;
      }
      b(paramBoolean, ((Boolean)((Object[])(Object[])paramObject)[0]).booleanValue());
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyRelevantObserver
 * JD-Core Version:    0.7.0.1
 */