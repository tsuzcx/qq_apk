package com.tencent.mobileqq.emosm;

import asfn;
import ashd;
import bhnv;
import com.tencent.mobileqq.app.QQAppInterface;

public class FavRoamingStrategy$7
  implements Runnable
{
  public FavRoamingStrategy$7(asfn paramasfn) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!bhnv.d(this.this$0.a.getApp()))) {
      return;
    }
    ((ashd)this.this$0.a.getManager(103)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */