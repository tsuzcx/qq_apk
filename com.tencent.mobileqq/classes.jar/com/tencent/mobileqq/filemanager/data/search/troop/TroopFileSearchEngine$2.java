package com.tencent.mobileqq.filemanager.data.search.troop;

import atqr;
import atrj;
import bfmp;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSearchEngine$2
  implements Runnable
{
  public TroopFileSearchEngine$2(atrj paramatrj) {}
  
  public void run()
  {
    bfmp localbfmp = bfmp.a();
    atrj.a(this.this$0, localbfmp.a(atrj.a(this.this$0), atrj.a(this.this$0), 0));
    if (atrj.b(this.this$0))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
      atrj.a(this.this$0);
      atrj.a(this.this$0, atrj.a(this.this$0).b());
      atrj.a(this.this$0, atrj.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */