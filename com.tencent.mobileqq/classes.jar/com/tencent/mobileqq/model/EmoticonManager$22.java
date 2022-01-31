package com.tencent.mobileqq.model;

import arnz;
import atmp;
import atmr;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$22
  implements Runnable
{
  public EmoticonManager$22(arnz paramarnz, EmoticonKeywords paramEmoticonKeywords) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    localatmr = this.this$0.a.a();
    try
    {
      localatmr.a();
      arnz.a(this.this$0, this.a);
      localatmr.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EmoticonManager", 1, "saveKeywordReqTimeToDB e = " + localException.getMessage());
        localatmr.b();
      }
    }
    finally
    {
      localatmr.b();
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