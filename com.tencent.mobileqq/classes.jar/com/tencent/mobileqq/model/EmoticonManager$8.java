package com.tencent.mobileqq.model;

import aube;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$8
  implements Runnable
{
  public EmoticonManager$8(aube paramaube, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!aube.a(this.this$0, this.a)) {
      QLog.e("EmoticonManager", 1, "saveEmoticonPackage fail epId = " + this.a.epId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.8
 * JD-Core Version:    0.7.0.1
 */