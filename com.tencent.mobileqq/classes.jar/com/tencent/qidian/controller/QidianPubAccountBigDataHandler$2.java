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
    PubAccountNavigationMenu localPubAccountNavigationMenu2 = (PubAccountNavigationMenu)this.this$0.c.get(Long.valueOf(this.a));
    PubAccountNavigationMenu localPubAccountNavigationMenu1 = localPubAccountNavigationMenu2;
    if (localPubAccountNavigationMenu2 == null)
    {
      localPubAccountNavigationMenu1 = new PubAccountNavigationMenu();
      localPubAccountNavigationMenu1.version = 0;
      localPubAccountNavigationMenu1.puin = this.a;
      localPubAccountNavigationMenu1.xml = "";
    }
    QidianPubAccountBigDataHandler.a(this.this$0, this.a, localPubAccountNavigationMenu1, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.QidianPubAccountBigDataHandler.2
 * JD-Core Version:    0.7.0.1
 */