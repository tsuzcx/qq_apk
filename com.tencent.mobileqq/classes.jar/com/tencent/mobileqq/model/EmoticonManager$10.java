package com.tencent.mobileqq.model;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

class EmoticonManager$10
  implements Runnable
{
  EmoticonManager$10(EmoticonManager paramEmoticonManager, Emoticon paramEmoticon) {}
  
  public void run()
  {
    EmoticonManager.a(this.this$0, this.a);
    if (!EmoticonManager.a(this.this$0, this.a)) {
      QLog.e("EmoticonManager", 1, "saveEmoticon fail epId = " + this.a.epId + ", eId = " + this.a.eId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.10
 * JD-Core Version:    0.7.0.1
 */