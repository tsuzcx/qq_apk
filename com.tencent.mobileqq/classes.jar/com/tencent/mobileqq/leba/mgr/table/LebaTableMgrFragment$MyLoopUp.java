package com.tencent.mobileqq.leba.mgr.table;

import android.support.v7.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.qphone.base.util.QLog;

public class LebaTableMgrFragment$MyLoopUp
  extends GridLayoutManager.SpanSizeLookup
{
  LebaTableMgrAdpter a;
  
  public LebaTableMgrFragment$MyLoopUp(LebaTableMgrAdpter paramLebaTableMgrAdpter)
  {
    this.a = paramLebaTableMgrAdpter;
  }
  
  public int getSpanSize(int paramInt)
  {
    if (this.a == null) {
      QLog.i("LebaTableMgrFragment", 1, "MyLoopUp getSpanSize mAdapter == null");
    }
    while ((this.a.getItemViewType(paramInt) != 1) && (this.a.getItemViewType(paramInt) != 3)) {
      return 1;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.mgr.table.LebaTableMgrFragment.MyLoopUp
 * JD-Core Version:    0.7.0.1
 */