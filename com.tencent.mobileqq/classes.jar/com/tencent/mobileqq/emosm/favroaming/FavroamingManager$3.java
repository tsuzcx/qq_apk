package com.tencent.mobileqq.emosm.favroaming;

import ajwa;
import ansr;
import anss;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;

public class FavroamingManager$3
  implements Runnable
{
  public FavroamingManager$3(anss paramanss, ajwa paramajwa) {}
  
  public void run()
  {
    List localList = ((ansr)anss.h(this.this$0).getManager(149)).a("needDel");
    if (localList.size() > 0) {
      this.a.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3
 * JD-Core Version:    0.7.0.1
 */