package com.tencent.mobileqq.emosm;

import aqzl;
import arbb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;

public class FavRoamingStrategy$7
  implements Runnable
{
  public FavRoamingStrategy$7(aqzl paramaqzl) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (!NetworkUtil.isNetSupport(this.this$0.a.getApp()))) {
      return;
    }
    ((arbb)this.this$0.a.getManager(103)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.FavRoamingStrategy.7
 * JD-Core Version:    0.7.0.1
 */