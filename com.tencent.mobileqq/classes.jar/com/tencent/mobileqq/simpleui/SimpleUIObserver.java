package com.tencent.mobileqq.simpleui;

import com.tencent.mobileqq.app.BusinessObserver;

public class SimpleUIObserver
  implements BusinessObserver
{
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3, String paramString, long paramLong) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, String paramString) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5) {
              return;
            }
            throw new NullPointerException();
          }
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 3)) {
            a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), (String)paramObject[2]);
          }
        }
        else
        {
          paramObject = (Object[])paramObject;
          if ((paramObject != null) && (paramObject.length == 3)) {
            a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue());
          }
        }
      }
      else
      {
        paramObject = (Object[])paramObject;
        if ((paramObject != null) && (paramObject.length == 5)) {
          a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Integer)paramObject[1]).intValue(), ((Boolean)paramObject[2]).booleanValue(), (String)paramObject[3], ((Long)paramObject[4]).longValue());
        }
      }
    }
    else
    {
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length == 4)) {
        a(paramBoolean, ((Boolean)paramObject[0]).booleanValue(), ((Boolean)paramObject[1]).booleanValue(), ((Integer)paramObject[2]).intValue(), (String)paramObject[3]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.simpleui.SimpleUIObserver
 * JD-Core Version:    0.7.0.1
 */