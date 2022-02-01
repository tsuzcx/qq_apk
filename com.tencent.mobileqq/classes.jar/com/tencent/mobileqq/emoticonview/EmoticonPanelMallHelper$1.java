package com.tencent.mobileqq.emoticonview;

import asno;
import asoc;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class EmoticonPanelMallHelper$1
  implements Runnable
{
  public EmoticonPanelMallHelper$1(asoc paramasoc, boolean paramBoolean, asno paramasno) {}
  
  public void run()
  {
    this.this$0.a.d(this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Asno != null) {
      ThreadManager.getUIHandler().post(new EmoticonPanelMallHelper.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.1
 * JD-Core Version:    0.7.0.1
 */