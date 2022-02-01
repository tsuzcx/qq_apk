package com.tencent.mobileqq.leba.more;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.qphone.base.util.QLog;

public class LebaMoreFragment$MyLoopUp
  extends GridLayoutManager.SpanSizeLookup
{
  LebaMoreAdapter a;
  
  public LebaMoreFragment$MyLoopUp(LebaMoreAdapter paramLebaMoreAdapter)
  {
    this.a = paramLebaMoreAdapter;
  }
  
  public int getSpanSize(int paramInt)
  {
    LebaMoreAdapter localLebaMoreAdapter = this.a;
    if (localLebaMoreAdapter == null)
    {
      QLog.i("LebaMoreFragment", 1, "MyLoopUp getSpanSize mAdapter == null");
      return 1;
    }
    if (localLebaMoreAdapter.getItemViewType(paramInt) == 1) {
      return 4;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.more.LebaMoreFragment.MyLoopUp
 * JD-Core Version:    0.7.0.1
 */