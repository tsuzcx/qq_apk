package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.feeds.CityData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;

class ReadInJoySelectPositionFragment$2
  implements AdapterView.OnItemClickListener
{
  ReadInJoySelectPositionFragment$2(ReadInJoySelectPositionFragment paramReadInJoySelectPositionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (paramInt <= 0) {
      return;
    }
    paramAdapterView = (CityData)ReadInJoySelectPositionFragment.a(this.a).get(paramInt - 1);
    if (paramAdapterView.a == 2) {
      this.a.a(new PositionData(paramAdapterView.e, paramAdapterView.d, paramAdapterView.c, paramAdapterView.f));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySelectPositionFragment.2
 * JD-Core Version:    0.7.0.1
 */