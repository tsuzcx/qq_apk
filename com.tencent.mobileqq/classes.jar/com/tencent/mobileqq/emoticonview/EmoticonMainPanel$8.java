package com.tencent.mobileqq.emoticonview;

import aoak;
import java.util.List;

class EmoticonMainPanel$8
  implements Runnable
{
  EmoticonMainPanel$8(EmoticonMainPanel paramEmoticonMainPanel) {}
  
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
        if ((localaoak == null) || (localaoak.a != 7)) {}
      }
    }
    for (;;)
    {
      if ((localaoak != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localaoak);
      }
      return;
      i += 1;
      break;
      localaoak = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.8
 * JD-Core Version:    0.7.0.1
 */