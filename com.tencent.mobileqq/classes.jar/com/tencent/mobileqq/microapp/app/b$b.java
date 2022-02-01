package com.tencent.mobileqq.microapp.app;

import java.util.Observable;
import java.util.Observer;

public class b$b
  implements Observer
{
  public void a(b.a parama) {}
  
  public void a(b.c paramc) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof b.a))
    {
      a((b.a)paramObject);
      return;
    }
    if ((paramObject instanceof b.c)) {
      a((b.c)paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.app.b.b
 * JD-Core Version:    0.7.0.1
 */