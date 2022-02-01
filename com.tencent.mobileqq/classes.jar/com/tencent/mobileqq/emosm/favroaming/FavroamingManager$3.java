package com.tencent.mobileqq.emosm.favroaming;

import anua;
import asfk;
import asfl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.List;

public class FavroamingManager$3
  implements Runnable
{
  public FavroamingManager$3(asfl paramasfl, anua paramanua) {}
  
  public void run()
  {
    List localList = ((asfk)asfl.h(this.this$0).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a("needDel");
    if (localList.size() > 0) {
      this.a.a(localList, true);
    }
    while (localList.size() != 0) {
      return;
    }
    this.this$0.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingManager.3
 * JD-Core Version:    0.7.0.1
 */