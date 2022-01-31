package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.app.BusinessObserver;

public class LebaFeedsObserver
  implements BusinessObserver
{
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramObject = (Object[])paramObject;
      if ((paramObject != null) && (paramObject.length >= 2))
      {
        a(paramBoolean, ((Integer)paramObject[0]).intValue(), ((Integer)paramObject[1]).intValue());
        return;
      }
      a(false, 0, 0);
      return;
    }
    a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsObserver
 * JD-Core Version:    0.7.0.1
 */