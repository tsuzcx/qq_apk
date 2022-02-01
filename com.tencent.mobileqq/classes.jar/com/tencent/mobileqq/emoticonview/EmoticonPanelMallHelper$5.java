package com.tencent.mobileqq.emoticonview;

import asoc;
import aspt;
import java.util.List;

public class EmoticonPanelMallHelper$5
  implements Runnable
{
  public EmoticonPanelMallHelper$5(asoc paramasoc) {}
  
  public void run()
  {
    List localList = this.this$0.a.jdField_b_of_type_JavaUtilList;
    aspt localaspt;
    int i;
    if (localList != null)
    {
      localaspt = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label107;
      }
      localaspt = (aspt)localList.get(i);
      if ((localaspt == null) || (localaspt.a != 9)) {
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
      this.this$0.a.a.a(localaspt);
      return;
      label107:
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelMallHelper.5
 * JD-Core Version:    0.7.0.1
 */