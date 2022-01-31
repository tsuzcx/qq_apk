package com.tencent.mobileqq.emoticonview;

import apqz;
import apsm;
import java.util.List;

public class EmoticonPanelMallHelper$5
  implements Runnable
{
  public EmoticonPanelMallHelper$5(apqz paramapqz) {}
  
  public void run()
  {
    List localList = this.this$0.a.jdField_b_of_type_JavaUtilList;
    apsm localapsm;
    int i;
    if (localList != null)
    {
      localapsm = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label107;
      }
      localapsm = (apsm)localList.get(i);
      if ((localapsm == null) || (localapsm.a != 9)) {
        break label65;
      }
    }
    for (;;)
    {
      if (i == -1) {}
      label65:
      while ((EmoticonPanelController.jdField_b_of_type_Int != i) || (this.this$0.a.a == null))
      {
        return;
        i += 1;
        break;
      }
      this.this$0.a.a.a(localapsm);
      return;
      label107:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5
 * JD-Core Version:    0.7.0.1
 */