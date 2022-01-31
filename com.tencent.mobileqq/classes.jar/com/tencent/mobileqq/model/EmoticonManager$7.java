package com.tencent.mobileqq.model;

import askd;
import aukn;
import aukp;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$7
  implements Runnable
{
  public EmoticonManager$7(askd paramaskd, List paramList) {}
  
  public void run()
  {
    aukp localaukp = this.this$0.a.a();
    localaukp.a();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if ((localEmoticonPackage != null) && (!askd.a(this.this$0, localEmoticonPackage))) {
        QLog.e("EmoticonManager", 1, "saveEmoticonPackages fail epId = " + localEmoticonPackage.epId);
      }
    }
    localaukp.c();
    localaukp.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.7
 * JD-Core Version:    0.7.0.1
 */