package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.biz.qqstory.view.widget.LoadingMoreHelper;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;

public class LoadMoreXListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  public LoadingMoreHelper a;
  private AbsListView.OnScrollListener b = null;
  private int c = -1;
  
  public LoadMoreXListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public LoadMoreXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public LoadMoreXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  protected void a()
  {
    b();
    super.setOnScrollListener(this);
  }
  
  protected void b()
  {
    LoadMoreLayout localLoadMoreLayout = new LoadMoreLayout(getContext());
    this.a = new LoadingMoreHelper(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.b;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.c) {
      return;
    }
    this.c = paramInt1;
    if (paramInt3 - (paramInt1 + paramInt2) <= this.a.a()) {
      this.a.b(true);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AbsListView.OnScrollListener localOnScrollListener = this.b;
    if (localOnScrollListener != null) {
      localOnScrollListener.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.b = paramOnScrollListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LoadMoreXListView
 * JD-Core Version:    0.7.0.1
 */