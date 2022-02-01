package com.tencent.mobileqq.emoticonview;

import aryo;
import asaf;
import java.util.List;

public class EmoticonPanelMallHelper$5
  implements Runnable
{
  public EmoticonPanelMallHelper$5(aryo paramaryo) {}
  
  public void run()
  {
    List localList = this.this$0.a.jdField_b_of_type_JavaUtilList;
    asaf localasaf;
    int i;
    if (localList != null)
    {
      localasaf = null;
      i = 0;
      int j = localList.size();
      if (i >= j) {
        break label107;
      }
      localasaf = (asaf)localList.get(i);
      if ((localasaf == null) || (localasaf.a != 9)) {
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
      this.this$0.a.a.a(localasaf);
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