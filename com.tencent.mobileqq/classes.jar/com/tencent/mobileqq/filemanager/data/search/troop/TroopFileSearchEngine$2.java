package com.tencent.mobileqq.filemanager.data.search.troop;

import apfm;
import apge;
import aztb;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSearchEngine$2
  implements Runnable
{
  public TroopFileSearchEngine$2(apge paramapge) {}
  
  public void run()
  {
    aztb localaztb = aztb.a();
    apge.a(this.this$0, localaztb.a(apge.a(this.this$0), apge.a(this.this$0), 0));
    if (apge.b(this.this$0))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
      apge.a(this.this$0);
      apge.a(this.this$0, apge.a(this.this$0).b());
      apge.a(this.this$0, apge.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */