package com.tencent.mobileqq.filemanager.data.search.troop;

import asml;
import asnd;
import befm;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSearchEngine$2
  implements Runnable
{
  public TroopFileSearchEngine$2(asnd paramasnd) {}
  
  public void run()
  {
    befm localbefm = befm.a();
    asnd.a(this.this$0, localbefm.a(asnd.a(this.this$0), asnd.a(this.this$0), 0));
    if (asnd.b(this.this$0))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
      asnd.a(this.this$0);
      asnd.a(this.this$0, asnd.a(this.this$0).b());
      asnd.a(this.this$0, asnd.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */