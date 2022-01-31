package com.tencent.mobileqq.emosm.favroaming;

import alsb;
import apon;
import apoo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class FavroamingManager$3
  implements Runnable
{
  public FavroamingManager$3(apoo paramapoo, alsb paramalsb) {}
  
  public void run()
  {
    List localList = ((apon)apoo.h(this.this$0).getManager(149)).a("needDel");
    if (localList.size() > 0) {
      this.a.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3
 * JD-Core Version:    0.7.0.1
 */