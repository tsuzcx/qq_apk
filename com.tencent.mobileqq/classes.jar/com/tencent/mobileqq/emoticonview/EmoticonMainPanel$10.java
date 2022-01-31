package com.tencent.mobileqq.emoticonview;

import anza;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class EmoticonMainPanel$10
  implements Runnable
{
  EmoticonMainPanel$10(EmoticonMainPanel paramEmoticonMainPanel, boolean paramBoolean, anza paramanza) {}
  
  public void run()
  {
    EmoticonMainPanel.a(this.this$0, this.jdField_a_of_type_Boolean);
    if (this.jdField_a_of_type_Anza != null) {
      ThreadManager.getUIHandler().post(new EmoticonMainPanel.10.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.10
 * JD-Core Version:    0.7.0.1
 */