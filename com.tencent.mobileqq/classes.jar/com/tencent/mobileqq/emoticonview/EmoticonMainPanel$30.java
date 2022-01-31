package com.tencent.mobileqq.emoticonview;

import com.tencent.qphone.base.util.QLog;

class EmoticonMainPanel$30
  implements Runnable
{
  EmoticonMainPanel$30(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonMainPanel", 2, "func updateLastEmoticonPanel begins.");
    }
    if (this.this$0.a != null) {
      this.this$0.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.30
 * JD-Core Version:    0.7.0.1
 */