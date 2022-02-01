package com.tencent.mobileqq.filemanager.data.search.troop;

import auab;
import auat;
import bfwb;
import com.tencent.qphone.base.util.QLog;

public class TroopFileSearchEngine$2
  implements Runnable
{
  public TroopFileSearchEngine$2(auat paramauat) {}
  
  public void run()
  {
    bfwb localbfwb = bfwb.a();
    auat.a(this.this$0, localbfwb.a(auat.a(this.this$0), auat.a(this.this$0), 0));
    if (auat.b(this.this$0))
    {
      QLog.i("TroopFileSearchEngine<QFile>", 4, "collectContactInfos. need do search. execSearch.");
      auat.a(this.this$0);
      auat.a(this.this$0, auat.a(this.this$0).b());
      auat.a(this.this$0, auat.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.troop.TroopFileSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */