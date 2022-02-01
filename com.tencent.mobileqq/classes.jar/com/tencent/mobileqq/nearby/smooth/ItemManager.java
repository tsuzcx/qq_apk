package com.tencent.mobileqq.nearby.smooth;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public final class ItemManager
{
  final int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  final Handler jdField_a_of_type_AndroidOsHandler;
  final ItemLoader<?, ?> jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader;
  ItemManaged jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged;
  final boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  boolean c;
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged == null) {}
    AbsListView localAbsListView;
    ListAdapter localListAdapter;
    do
    {
      return;
      localAbsListView = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged.a();
      localListAdapter = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged.a();
      this.jdField_b_of_type_Boolean = false;
    } while (localListAdapter == null);
    long l1 = SystemClock.uptimeMillis();
    int j = localAbsListView.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = localAbsListView.getChildAt(i);
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localAbsListView, localListAdapter, localView, l1);
      i += 1;
      l1 += 1L;
    }
    long l3 = l1;
    if (this.jdField_a_of_type_Boolean)
    {
      j = localAbsListView.getLastVisiblePosition() + 1;
      long l2 = l1;
      if (j > 0)
      {
        int k = localListAdapter.getCount();
        i = j;
        for (;;)
        {
          l2 = l1;
          if (i >= this.jdField_a_of_type_Int + j) {
            break;
          }
          l2 = l1;
          if (i >= k) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localAbsListView, localListAdapter, i, l1);
          i += 1;
          l1 += 1L;
        }
      }
      j = localAbsListView.getFirstVisiblePosition();
      l3 = l2;
      if (j >= this.jdField_a_of_type_Int)
      {
        i = j - 1;
        for (;;)
        {
          l3 = l2;
          if (i < j - this.jdField_a_of_type_Int) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(localAbsListView, localListAdapter, i, l2);
          i -= 1;
          l2 += 1L;
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = l3;
    localAbsListView.invalidate();
  }
  
  void a(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged.a();
    if ((this.jdField_b_of_type_Int != 2) && (!this.jdField_b_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  void a(ItemManaged paramItemManaged)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged = paramItemManaged;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged != null)
    {
      paramItemManaged = this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged.a();
      paramItemManaged.setOnScrollListener(new ItemManager.ScrollManager(this, null));
      paramItemManaged.setOnTouchListener(new ItemManager.FingerTracker(this, null));
      paramItemManaged.setOnItemSelectedListener(new ItemManager.SelectionTracker(this, null));
    }
  }
  
  void b()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemManaged.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager
 * JD-Core Version:    0.7.0.1
 */