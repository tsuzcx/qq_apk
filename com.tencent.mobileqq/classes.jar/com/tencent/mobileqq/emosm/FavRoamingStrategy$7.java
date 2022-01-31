package com.tencent.mobileqq.emosm;

import apnd;
import apoo;
import bdin;
import com.tencent.mobileqq.app.QQAppInterface;

public class FavRoamingStrategy$7
  implements Runnable
{
  public FavRoamingStrategy$7(apnd paramapnd) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bdin.d(this.this$0.a.getApp()))) {
      return;
    }
    ((apoo)this.this$0.a.getManager(103)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */