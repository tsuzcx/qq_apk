package com.tencent.mobileqq.mini.out.activity;

import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class MapActivity$1
  implements AdapterView.OnItemClickListener
{
  MapActivity$1(MapActivity paramMapActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      paramAdapterView = new StringBuilder();
      paramAdapterView.append("setOnItemClickListener");
      paramAdapterView.append(paramInt);
      QLog.i("MapActivity", 2, paramAdapterView.toString());
    }
    if (this.this$0.poiAdapter.getItem(paramInt) != null) {
      this.this$0.poiAdapter.select(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.1
 * JD-Core Version:    0.7.0.1
 */