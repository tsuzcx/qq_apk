package com.tencent.mobileqq.kandian.biz.ugc;

import android.database.DataSetObserver;
import android.view.View;

class ReadInJoyVideoTagSelectionFragment$2
  extends DataSetObserver
{
  ReadInJoyVideoTagSelectionFragment$2(ReadInJoyVideoTagSelectionFragment paramReadInJoyVideoTagSelectionFragment) {}
  
  public void onChanged()
  {
    if (ReadInJoyVideoTagSelectionFragment.d(this.a).getCount() > 0)
    {
      ReadInJoyVideoTagSelectionFragment.e(this.a).setVisibility(0);
      return;
    }
    ReadInJoyVideoTagSelectionFragment.e(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyVideoTagSelectionFragment.2
 * JD-Core Version:    0.7.0.1
 */