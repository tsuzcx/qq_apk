package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ReadInJoyDynamicGridView$1
  implements AdapterView.OnItemClickListener
{
  ReadInJoyDynamicGridView$1(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.a.b()) && (this.a.isEnabled()) && (ReadInJoyDynamicGridView.a(this.a) != null)) {
      ReadInJoyDynamicGridView.a(this.a).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyDynamicGridView.1
 * JD-Core Version:    0.7.0.1
 */