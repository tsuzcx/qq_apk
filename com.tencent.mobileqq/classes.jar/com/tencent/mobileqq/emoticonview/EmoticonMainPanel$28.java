package com.tencent.mobileqq.emoticonview;

import ankb;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class EmoticonMainPanel$28
  implements Runnable
{
  EmoticonMainPanel$28(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    int i;
    ankb localankb;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localankb = (ankb)localList.get(i);
        if ((localankb == null) || (localankb.a != 11)) {}
      }
    }
    for (;;)
    {
      if ((localankb != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localankb);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localankb = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.28
 * JD-Core Version:    0.7.0.1
 */