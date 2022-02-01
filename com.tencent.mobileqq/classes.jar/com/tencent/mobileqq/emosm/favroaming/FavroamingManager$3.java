package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.List;

class FavroamingManager$3
  implements Runnable
{
  FavroamingManager$3(FavroamingManager paramFavroamingManager, FavEmoRoamingHandler paramFavEmoRoamingHandler) {}
  
  public void run()
  {
    List localList = ((FavroamingDBManager)FavroamingManager.h(this.this$0).getManager(QQManagerFactory.FAVROAMING_DB_MANAGER)).a("needDel");
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