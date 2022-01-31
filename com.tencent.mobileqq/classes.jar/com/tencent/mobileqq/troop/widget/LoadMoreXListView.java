package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import bfos;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import wdb;

public class LoadMoreXListView
  extends XListView
  implements bfos
{
  private int jdField_a_of_type_Int = -1;
  private bfos jdField_a_of_type_Bfos;
  public wdb a;
  
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
    this.jdField_a_of_type_Wdb = new wdb(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bfos != null) {
      this.jdField_a_of_type_Bfos.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Wdb.a());
    this.jdField_a_of_type_Wdb.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bfos != null) {
      this.jdField_a_of_type_Bfos.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setOnScrollListener(bfos parambfos)
  {
    this.jdField_a_of_type_Bfos = parambfos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LoadMoreXListView
 * JD-Core Version:    0.7.0.1
 */