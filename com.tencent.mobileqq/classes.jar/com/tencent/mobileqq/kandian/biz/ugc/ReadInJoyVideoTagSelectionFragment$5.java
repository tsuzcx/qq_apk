package com.tencent.mobileqq.kandian.biz.ugc;

import android.view.View;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class ReadInJoyVideoTagSelectionFragment$5
  implements AdapterView.OnItemClickListener
{
  ReadInJoyVideoTagSelectionFragment$5(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getItemAtPosition(paramInt);
    if ((paramAdapterView != null) && ((paramAdapterView instanceof TagInfo))) {
      if (!ReadInJoyVideoTagSelectionFragment.a(this.a).a())
      {
        if ((!ReadInJoyVideoTagSelectionFragment.a(this.a).a((TagInfo)paramAdapterView)) && (!ReadInJoyVideoTagSelectionFragment.f(this.a).isShowing())) {
          ReadInJoyVideoTagSelectionFragment.f(this.a).show();
        }
      }
      else if (!ReadInJoyVideoTagSelectionFragment.g(this.a).isShowing()) {
        ReadInJoyVideoTagSelectionFragment.g(this.a).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment.5
 * JD-Core Version:    0.7.0.1
 */