package com.tencent.mobileqq.kandian.base.view.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

class ReadInJoyNinePicDeliverDynamicGridView$1
  implements AdapterView.OnItemClickListener
{
  ReadInJoyNinePicDeliverDynamicGridView$1(ReadInJoyNinePicDeliverDynamicGridView paramReadInJoyNinePicDeliverDynamicGridView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((!this.a.a()) && (this.a.isEnabled()) && (ReadInJoyNinePicDeliverDynamicGridView.a(this.a) != null)) {
      ReadInJoyNinePicDeliverDynamicGridView.a(this.a).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyNinePicDeliverDynamicGridView.1
 * JD-Core Version:    0.7.0.1
 */