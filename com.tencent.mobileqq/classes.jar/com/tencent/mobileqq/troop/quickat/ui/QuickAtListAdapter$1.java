package com.tencent.mobileqq.troop.quickat.ui;

import com.tencent.mobileqq.activity.contacts.alphabet.IndexBar;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.Arrays;

class QuickAtListAdapter$1
  implements AbsListView.OnScrollListener
{
  QuickAtListAdapter$1(QuickAtListAdapter paramQuickAtListAdapter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = Arrays.binarySearch(QuickAtListAdapter.a(this.a), paramInt1);
    if ((paramInt1 >= 0) && (QuickAtListAdapter.a(this.a).a != null)) {
      QuickAtListAdapter.a(this.a).a.setChooseIndex(paramInt1);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.quickat.ui.QuickAtListAdapter.1
 * JD-Core Version:    0.7.0.1
 */