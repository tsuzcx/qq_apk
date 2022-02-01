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
    int i;
    if (LebaListMgrActivity.a(this.a).getCount() > 0) {
      i = 0;
    } else {
      i = 8;
    }
    localTextView.setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.list.LebaListMgrActivity.2
 * JD-Core Version:    0.7.0.1
 */