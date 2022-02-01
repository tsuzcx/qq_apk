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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onGetPositionErr 1  final p:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" rescue:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" v:");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" error: ");
    localStringBuilder.append(paramException);
    QLog.e("HotPicManagerHotPicPageView", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.1
 * JD-Core Version:    0.7.0.1
 */