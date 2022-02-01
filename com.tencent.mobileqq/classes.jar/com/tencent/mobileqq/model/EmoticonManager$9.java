package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;

class EmoticonManager$9
  implements Runnable
{
  EmoticonManager$9(EmoticonManager paramEmoticonManager, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!EmoticonManager.a(this.this$0, this.a)) {
      QLog.e("EmoticonManager", 1, "saveEmoticonPackage fail epId = " + this.a.epId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.9
 * JD-Core Version:    0.7.0.1
 */