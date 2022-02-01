package com.tencent.mobileqq.troop.widget;

import NearbyGroup.GroupLabel;
import android.util.SparseIntArray;
import android.widget.TextView;
import java.util.ArrayList;

class TroopLabelLayout$1
  implements Runnable
{
  TroopLabelLayout$1(TroopLabelLayout paramTroopLabelLayout) {}
  
  public void run()
  {
    int k = 0;
    for (;;)
    {
      synchronized (this.this$0.jdField_a_of_type_JavaUtilArrayList)
      {
        if ((this.this$0.jdField_a_of_type_JavaUtilArrayList != null) && (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() != 0)) {
          break label235;
        }
        return;
        GroupLabel localGroupLabel;
        Object localObject2;
        if (j < this.this$0.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localGroupLabel = (GroupLabel)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (j == 0)
          {
            i = 0;
            break label242;
          }
          localObject2 = (GroupLabel)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)((GroupLabel)localObject2).type) <= TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)localGroupLabel.type))
          {
            i = j;
            break label242;
          }
        }
        else
        {
          localGroupLabel = (GroupLabel)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(i);
          i = k;
          if (i < this.this$0.getChildCount())
          {
            localObject2 = this.this$0.getChildAt(i);
            if (!(localObject2 instanceof TextView)) {
              break label249;
            }
            localObject2 = (TextView)localObject2;
            if (!((TextView)localObject2).getText().toString().equals(localGroupLabel.strWording)) {
              break label249;
            }
            ((TextView)localObject2).setVisibility(8);
            this.this$0.requestLayout();
            break label249;
          }
          return;
        }
      }
      break label242;
      label235:
      int j = 0;
      int i = 0;
      continue;
      label242:
      j += 1;
      continue;
      label249:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelLayout.1
 * JD-Core Version:    0.7.0.1
 */