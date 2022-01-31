package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import bhpo;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import xrt;

public class LoadMoreXListView
  extends XListView
  implements bhpo
{
  private int jdField_a_of_type_Int = -1;
  private bhpo jdField_a_of_type_Bhpo;
  public xrt a;
  
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
    this.jdField_a_of_type_Xrt = new xrt(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Xrt.a());
    this.jdField_a_of_type_Xrt.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Bhpo != null) {
      this.jdField_a_of_type_Bhpo.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setOnScrollListener(bhpo parambhpo)
  {
    this.jdField_a_of_type_Bhpo = parambhpo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LoadMoreXListView
 * JD-Core Version:    0.7.0.1
 */