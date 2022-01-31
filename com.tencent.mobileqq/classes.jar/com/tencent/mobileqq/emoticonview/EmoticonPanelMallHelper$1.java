package com.tencent.mobileqq.emoticonview;

import apuy;
import apvi;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class EmoticonPanelMallHelper$1
  implements Runnable
{
  public EmoticonPanelMallHelper$1(apvi paramapvi, boolean paramBoolean, apuy paramapuy) {}
  
  public void run()
  {
    this.this$0.a.d(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Apuy != null) {
      ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1
 * JD-Core Version:    0.7.0.1
 */