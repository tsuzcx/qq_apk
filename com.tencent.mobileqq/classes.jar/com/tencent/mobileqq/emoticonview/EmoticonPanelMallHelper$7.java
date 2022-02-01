package com.tencent.mobileqq.emoticonview;

import asoc;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class EmoticonPanelMallHelper$7
  implements Runnable
{
  public EmoticonPanelMallHelper$7(asoc paramasoc, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (!this.this$0.a.a.contains(this.a)) {
      this.this$0.a.a.add(this.a);
    }
    this.this$0.a.jdField_b_of_type_Boolean = true;
    this.this$0.a.a().i = false;
    if (this.this$0.a.a().getVisibility() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelMallHelper", 2, "refresh magic emoji.");
      }
      this.this$0.a.d(EmoticonPanelController.jdField_b_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.7
 * JD-Core Version:    0.7.0.1
 */