package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import blih;
import com.tencent.biz.qqstory.view.widget.LoadMoreLayout;
import com.tencent.widget.AbsListView;
import com.tencent.widget.XListView;
import zti;

public class LoadMoreXListView
  extends XListView
  implements blih
{
  private int jdField_a_of_type_Int = -1;
  private blih jdField_a_of_type_Blih;
  public zti a;
  
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
    this.jdField_a_of_type_Zti = new zti(localLoadMoreLayout, getContext().getApplicationContext());
    super.addFooterView(localLoadMoreLayout);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (paramInt1 == this.jdField_a_of_type_Int) {}
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
    } while (paramInt3 - (paramInt1 + paramInt2) > this.jdField_a_of_type_Zti.a());
    this.jdField_a_of_type_Zti.b(true);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_Blih != null) {
      this.jdField_a_of_type_Blih.onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public void setOnScrollListener(blih paramblih)
  {
    this.jdField_a_of_type_Blih = paramblih;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.LoadMoreXListView
 * JD-Core Version:    0.7.0.1
 */