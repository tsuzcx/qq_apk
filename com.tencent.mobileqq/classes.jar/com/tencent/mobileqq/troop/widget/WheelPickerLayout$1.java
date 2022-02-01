package com.tencent.mobileqq.troop.widget;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class WheelPickerLayout$1
  implements AdapterView.OnItemSelectedListener
{
  WheelPickerLayout$1(WheelPickerLayout paramWheelPickerLayout) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    WheelPickerLayout.a(this.a, paramView, 1);
    WheelPickerLayout.a(this.a, paramView, true);
    if ((paramView != null) && (paramView.getTag() != null))
    {
      int i = Integer.parseInt(paramView.getTag().toString());
      int j = paramAdapterView.getChildCount();
      paramInt = 0;
      while (paramInt < j)
      {
        if (i != paramInt)
        {
          WheelPickerLayout.a(this.a, paramAdapterView.getChildAt(paramInt), 0);
          WheelPickerLayout.a(this.a, paramAdapterView.getChildAt(paramInt), false);
        }
        paramInt += 1;
      }
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout.1
 * JD-Core Version:    0.7.0.1
 */