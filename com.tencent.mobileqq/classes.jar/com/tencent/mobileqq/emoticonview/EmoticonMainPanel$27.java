package com.tencent.mobileqq.emoticonview;

import ankb;
import java.util.List;

class EmoticonMainPanel$27
  implements Runnable
{
  EmoticonMainPanel$27(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void run()
  {
    List localList = this.this$0.jdField_a_of_type_JavaUtilList;
    ankb localankb;
    int i;
    if (localList != null)
    {
      localankb = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label98;
      }
      localankb = (ankb)localList.get(i);
      if ((localankb == null) || (localankb.a != 9)) {
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
      this.this$0.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmotionPanelViewPagerAdapter.a(localankb);
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