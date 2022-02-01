package com.tencent.mobileqq.leba.mgr.list;

import android.database.DataSetObserver;
import android.widget.TextView;

class LebaListMgrActivity$2
  extends DataSetObserver
{
  LebaListMgrActivity$2(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void onChanged()
  {
    TextView localTextView = LebaListMgrActivity.a(this.a);
    if (LebaListMgrActivity.a(this.a).getCount() > 0) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrActivity.2
 * JD-Core Version:    0.7.0.1
 */