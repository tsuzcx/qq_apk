package com.tencent.mobileqq.emosm;

import anrh;
import anss;
import bbev;
import com.tencent.mobileqq.app.QQAppInterface;

public class FavRoamingStrategy$7
  implements Runnable
{
  public FavRoamingStrategy$7(anrh paramanrh) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bbev.d(this.this$0.a.getApp()))) {
      return;
    }
    ((anss)this.this$0.a.getManager(103)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */