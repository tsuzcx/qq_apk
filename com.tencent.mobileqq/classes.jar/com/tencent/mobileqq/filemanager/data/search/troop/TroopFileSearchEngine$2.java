package com.tencent.mobileqq.filemanager.data.search.troop;

import apfq;
import apgi;
import aztd;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSearchEngine$2
  implements Runnable
{
  public TroopFileSearchEngine$2(apgi paramapgi) {}
  
  public void run()
  {
    aztd localaztd = aztd.a();
    apgi.a(this.this$0, localaztd.a(apgi.a(this.this$0), apgi.a(this.this$0), 0));
    if (apgi.b(this.this$0))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
      apgi.a(this.this$0);
      apgi.a(this.this$0, apgi.a(this.this$0).b());
      apgi.a(this.this$0, apgi.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */