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
    int i;
    int j;
    int k;
    label221:
    label239:
    label248:
    label255:
    synchronized (this.this$0.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.this$0.jdField_a_of_type_JavaUtilArrayList != null)
      {
        if (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() != 0) {
          break label239;
        }
        break label221;
        Object localObject2;
        if (i < this.this$0.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localGroupLabel = (GroupLabel)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(i);
          if (i == 0)
          {
            j = 0;
            break label248;
          }
          localObject2 = (GroupLabel)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(j);
          if (TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)((GroupLabel)localObject2).type) > TroopLabelLayout.jdField_a_of_type_AndroidUtilSparseIntArray.get((int)localGroupLabel.type)) {
            break label248;
          }
          j = i;
          break label248;
        }
        GroupLabel localGroupLabel = (GroupLabel)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(j);
        i = k;
        if (i < this.this$0.getChildCount())
        {
          localObject2 = this.this$0.getChildAt(i);
          if (!(localObject2 instanceof TextView)) {
            break label255;
          }
          localObject2 = (TextView)localObject2;
          if (!((TextView)localObject2).getText().toString().equals(localGroupLabel.strWording)) {
            break label255;
          }
          ((TextView)localObject2).setVisibility(8);
          this.this$0.requestLayout();
          break label255;
        }
        return;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopLabelLayout.1
 * JD-Core Version:    0.7.0.1
 */