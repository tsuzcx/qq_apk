package com.tencent.mobileqq.gameparty;

import java.util.Observable;
import java.util.Observer;

public class GamePartyObserver
  implements Observer
{
  public void a() {}
  
  public void b() {}
  
  public void c() {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    switch (((Integer)paramObject).intValue())
    {
    default: 
      return;
    case 1: 
      a();
      return;
    case 2: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.gameparty.GamePartyObserver
 * JD-Core Version:    0.7.0.1
 */