package com.tencent.mobileqq.model;

import aube;
import awbw;
import awby;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$22
  implements Runnable
{
  public EmoticonManager$22(aube paramaube, EmoticonKeywords paramEmoticonKeywords) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    localawby = this.this$0.a.a();
    try
    {
      localawby.a();
      aube.a(this.this$0, this.a);
      localawby.c();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("EmoticonManager", 1, "saveKeywordReqTimeToDB e = " + localException.getMessage());
        localawby.b();
      }
    }
    finally
    {
      localawby.b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveKeywordReqTimeToDB cost : " + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.22
 * JD-Core Version:    0.7.0.1
 */