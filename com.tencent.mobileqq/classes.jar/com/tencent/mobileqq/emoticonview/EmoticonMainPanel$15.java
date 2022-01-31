package com.tencent.mobileqq.emoticonview;

import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonMainPanel$15
  implements Runnable
{
  EmoticonMainPanel$15(EmoticonMainPanel paramEmoticonMainPanel, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!this.this$0.b.contains(this.a)) {
      this.this$0.b.add(this.a);
    }
    this.this$0.h = true;
    this.this$0.k = false;
    if (this.this$0.getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonMainPanel", 2, "refresh magic emoji.");
      }
      this.this$0.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.15
 * JD-Core Version:    0.7.0.1
 */