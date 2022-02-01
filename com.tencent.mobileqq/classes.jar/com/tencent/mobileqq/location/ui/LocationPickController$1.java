package com.tencent.mobileqq.location.ui;

import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class LocationPickController$1
  implements AbsListView.OnScrollListener
{
  private int b;
  
  LocationPickController$1(LocationPickController paramLocationPickController) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramInt = paramAbsListView.getFirstVisiblePosition();
    if (paramInt > this.b)
    {
      if (!LocationPickController.a(this.a).h()) {
        LocationPickController.a(this.a).a();
      }
      if (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1)
      {
        if (QLog.isDevelopLevel()) {
          QLog.i("LocationShareController", 4, "onScrollStateChanged");
        }
        LocationPickController.b(this.a).a();
      }
    }
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController.1
 * JD-Core Version:    0.7.0.1
 */