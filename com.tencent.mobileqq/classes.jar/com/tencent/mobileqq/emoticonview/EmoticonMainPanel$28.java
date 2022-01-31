package com.tencent.mobileqq.emoticonview;

import aoak;
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
    aoak localaoak;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localaoak = (aoak)localList.get(i);
        if ((localaoak == null) || (localaoak.a != 11)) {}
      }
    }
    for (;;)
    {
      if ((localaoak != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localaoak);
      }
      while (!QLog.isColorLevel())
      {
        return;
        i += 1;
        break;
      }
      QLog.d("EmoticonMainPanel", 2, "updateCameraEmoticonPanel cameraInfo can not find");
      return;
      localaoak = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.28
 * JD-Core Version:    0.7.0.1
 */