package com.tencent.mobileqq.emoticonview;

import aoap;
import java.util.List;

class EmoticonMainPanel$8
  implements Runnable
{
  EmoticonMainPanel$8(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    int i;
    aoap localaoap;
    if (localList != null)
    {
      i = 0;
      if (i < localList.size())
      {
        localaoap = (aoap)localList.get(i);
        if ((localaoap == null) || (localaoap.a != 7)) {}
      }
    }
    for (;;)
    {
      if ((localaoap != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localaoap);
      }
      return;
      i += 1;
      break;
      localaoap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.8
 * JD-Core Version:    0.7.0.1
 */