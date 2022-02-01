package com.tencent.qidian.controller;

import com.tencent.qidian.data.PubAccountNavigationMenu;
import java.util.Map;

class QidianPubAccountBigDataHandler$2
  implements Runnable
{
  QidianPubAccountBigDataHandler$2(QidianPubAccountBigDataHandler paramQidianPubAccountBigDataHandler, long paramLong1, long paramLong2) {}
  
  public void run()
  {
    this.this$0.a(this.a);
    PubAccountNavigationMenu localPubAccountNavigationMenu = (PubAccountNavigationMenu)this.this$0.a.get(Long.valueOf(this.a));
    if (localPubAccountNavigationMenu == null)
    {
      localPubAccountNavigationMenu = new PubAccountNavigationMenu();
      localPubAccountNavigationMenu.version = 0;
      localPubAccountNavigationMenu.puin = this.a;
      localPubAccountNavigationMenu.xml = "";
    }
    for (;;)
    {
      QidianPubAccountBigDataHandler.a(this.this$0, this.a, localPubAccountNavigationMenu, this.b);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianPubAccountBigDataHandler.2
 * JD-Core Version:    0.7.0.1
 */