package com.tencent.mobileqq.qqgift.mvvm.business.view;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.OnScrollListener;

class QQGiftPanelViewImpl$1
  extends RecyclerView.OnScrollListener
{
  QQGiftPanelViewImpl$1(QQGiftPanelViewImpl paramQQGiftPanelViewImpl) {}
  
  public void onScrollStateChanged(@NonNull RecyclerView paramRecyclerView, int paramInt)
  {
    super.onScrollStateChanged(paramRecyclerView, paramInt);
    QQGiftPanelViewImpl.a(this.a, paramInt);
  }
  
  public void onScrolled(@NonNull RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
  {
    super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.view.QQGiftPanelViewImpl.1
 * JD-Core Version:    0.7.0.1
 */