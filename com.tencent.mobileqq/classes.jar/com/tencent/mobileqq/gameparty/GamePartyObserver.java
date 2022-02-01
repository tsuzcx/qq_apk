package com.tencent.mobileqq.gameparty;

import java.util.Observable;
import java.util.Observer;

public class GamePartyObserver
  implements Observer
{
  protected void a() {}
  
  protected void b() {}
  
  protected void c() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i = ((Integer)paramObject).intValue();
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        c();
        return;
      }
      b();
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyObserver
 * JD-Core Version:    0.7.0.1
 */