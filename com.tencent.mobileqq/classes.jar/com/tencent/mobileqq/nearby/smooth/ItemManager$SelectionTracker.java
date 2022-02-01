package com.tencent.mobileqq.nearby.smooth;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;

class ItemManager$SelectionTracker
  implements AdapterView.OnItemSelectedListener
{
  private ItemManager$SelectionTracker(ItemManager paramItemManager) {}
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.a.b != 0)
    {
      localObject = this.a;
      ((ItemManager)localObject).b = 0;
      ((ItemManager)localObject).b();
    }
    Object localObject = this.a.a.a();
    if (localObject != null) {
      ((AdapterView.OnItemSelectedListener)localObject).onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
    AdapterView.OnItemSelectedListener localOnItemSelectedListener = this.a.a.a();
    if (localOnItemSelectedListener != null) {
      localOnItemSelectedListener.onNothingSelected(paramAdapterView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager.SelectionTracker
 * JD-Core Version:    0.7.0.1
 */