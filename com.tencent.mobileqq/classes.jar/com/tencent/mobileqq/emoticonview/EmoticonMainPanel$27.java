package com.tencent.mobileqq.emoticonview;

import aoak;
import java.util.List;

class EmoticonMainPanel$27
  implements Runnable
{
  EmoticonMainPanel$27(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    aoak localaoak;
    int i;
    if (localList != null)
    {
      localaoak = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label98;
      }
      localaoak = (aoak)localList.get(i);
      if ((localaoak == null) || (localaoak.a != 9)) {
        break label62;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      label62:
      while ((EmoticonMainPanel.c != i) || (this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter == null))
      {
        return;
        i += 1;
        break;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localaoak);
      return;
      label98:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonMainPanel.27
 * JD-Core Version:    0.7.0.1
 */