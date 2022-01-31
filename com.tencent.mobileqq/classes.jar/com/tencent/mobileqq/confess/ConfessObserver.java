package com.tencent.mobileqq.confess;

import com.tencent.mobileqq.app.BusinessObserver;

public class ConfessObserver
  implements BusinessObserver
{
  public void a() {}
  
  public void a(int paramInt1, int paramInt2) {}
  
  public void a(ConfessConfig paramConfessConfig) {}
  
  public void a(boolean paramBoolean, Object paramObject) {}
  
  public void a(boolean paramBoolean, String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, ConfessInfo paramConfessInfo) {}
  
  public void b() {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      do
      {
        do
        {
          do
          {
            return;
            a(paramBoolean, paramObject);
            return;
            b(paramBoolean, paramObject);
            return;
          } while ((paramObject == null) || (!(paramObject instanceof Object[])));
          paramObject = (Object[])paramObject;
        } while ((paramObject == null) || (paramObject.length != 6));
        a(paramBoolean, (String)paramObject[0], ((Integer)paramObject[1]).intValue(), ((Integer)paramObject[2]).intValue(), ((Integer)paramObject[3]).intValue(), (String)paramObject[4], (ConfessInfo)paramObject[5]);
        return;
        if ((paramObject != null) && ((paramObject instanceof ConfessConfig))) {
          a((ConfessConfig)paramObject);
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
      a(((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
      return;
    case 6: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessObserver
 * JD-Core Version:    0.7.0.1
 */