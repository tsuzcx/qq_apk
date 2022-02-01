package com.tencent.mobileqq.hotpic;

import android.support.v7.widget.StaggeredGridLayoutManager.ExceptionListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class HotPicPageView$1
  implements StaggeredGridLayoutManager.ExceptionListener
{
  HotPicPageView$1(HotPicPageView paramHotPicPageView) {}
  
  public void onGetPositionErr(View paramView, boolean paramBoolean, int paramInt, Exception paramException)
  {
    QLog.e("HotPicManagerHotPicPageView", 1, "onGetPositionErr 1  final p:" + paramInt + " rescue:" + paramBoolean + " v:" + paramView + " error: " + paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.1
 * JD-Core Version:    0.7.0.1
 */