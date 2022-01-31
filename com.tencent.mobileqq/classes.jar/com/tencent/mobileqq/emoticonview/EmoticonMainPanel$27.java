package com.tencent.mobileqq.emoticonview;

import aoap;
import java.util.List;

class EmoticonMainPanel$27
  implements Runnable
{
  EmoticonMainPanel$27(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    aoap localaoap;
    int i;
    if (localList != null)
    {
      localaoap = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label98;
      }
      localaoap = (aoap)localList.get(i);
      if ((localaoap == null) || (localaoap.a != 9)) {
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localaoap);
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