package com.tencent.mobileqq.model;

import askf;
import aukp;
import aukr;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$22
  implements Runnable
{
  public EmoticonManager$22(askf paramaskf, EmoticonKeywords paramEmoticonKeywords) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    localaukr = this.this$0.a.a();
    try
    {
      localaukr.a();
      askf.a(this.this$0, this.a);
      localaukr.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EmoticonManager", 1, "saveKeywordReqTimeToDB e = " + localException.getMessage());
        localaukr.b();
      }
    }
    finally
    {
      localaukr.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveKeywordReqTimeToDB cost : " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.22
 * JD-Core Version:    0.7.0.1
 */