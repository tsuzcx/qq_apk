package com.tencent.richmediabrowser.view.recyclerview;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ItemDecoration;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

public class BrowserItemDecoration
  extends RecyclerView.ItemDecoration
{
  private int mSpace;
  private MainBrowserPresenter mainBrowserPresenter;
  
  public BrowserItemDecoration(int paramInt, MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mSpace = paramInt;
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public void getItemOffsets(@NonNull Rect paramRect, @NonNull View paramView, @NonNull RecyclerView paramRecyclerView, @NonNull RecyclerView.State paramState)
  {
    paramRect.top = 0;
    paramRect.bottom = 0;
    int i = this.mSpace;
    paramRect.left = i;
    paramRect.right = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.recyclerview.BrowserItemDecoration
 * JD-Core Version:    0.7.0.1
 */