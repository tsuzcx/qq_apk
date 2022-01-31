package com.tencent.mobileqq.model;

import askf;
import aukp;
import aukr;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonManager$7
  implements Runnable
{
  public EmoticonManager$7(askf paramaskf, List paramList) {}
  
  public void run()
  {
    aukr localaukr = this.this$0.a.a();
    localaukr.a();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
      if ((localEmoticonPackage != null) && (!askf.a(this.this$0, localEmoticonPackage))) {
        QLog.e("EmoticonManager", 1, "saveEmoticonPackages fail epId = " + localEmoticonPackage.epId);
      }
    }
    localaukr.c();
    localaukr.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.7
 * JD-Core Version:    0.7.0.1
 */