package com.tencent.mobileqq.model;

import aube;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.qphone.base.util.QLog;

public class EmoticonManager$9
  implements Runnable
{
  public EmoticonManager$9(aube paramaube, Emoticon paramEmoticon) {}
  
  public void run()
  {
    aube.a(this.this$0, this.a);
    if (!aube.a(this.this$0, this.a)) {
      QLog.e("EmoticonManager", 1, "saveEmoticon fail epId = " + this.a.epId + ", eId = " + this.a.eId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.9
 * JD-Core Version:    0.7.0.1
 */