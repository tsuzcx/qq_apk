package com.tencent.mobileqq.troop.trooptodo;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.troop.trooptodo.api.ITroopToDoResponseHandler;

public class TroopToDoObserver
  implements BusinessObserver
{
  private ITroopToDoResponseHandler a = null;
  
  public TroopToDoObserver(ITroopToDoResponseHandler paramITroopToDoResponseHandler)
  {
    this.a = paramITroopToDoResponseHandler;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.a.a(paramBoolean, paramObject);
          return;
        }
        this.a.b(paramBoolean, paramObject);
        return;
      }
      this.a.c(paramBoolean, paramObject);
      return;
    }
    this.a.d(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.trooptodo.TroopToDoObserver
 * JD-Core Version:    0.7.0.1
 */