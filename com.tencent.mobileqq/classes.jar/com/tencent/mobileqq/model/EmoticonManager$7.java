package com.tencent.mobileqq.model;

import aube;
import awbw;
import awby;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$7
  implements Runnable
{
  public EmoticonManager$7(aube paramaube, List paramList) {}
  
  public void run()
  {
    awby localawby = this.this$0.a.a();
    localawby.a();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if ((localEmoticonPackage != null) && (!aube.a(this.this$0, localEmoticonPackage))) {
        QLog.e("EmoticonManager", 1, "saveEmoticonPackages fail epId = " + localEmoticonPackage.epId);
      }
    }
    localawby.c();
    localawby.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.7
 * JD-Core Version:    0.7.0.1
 */