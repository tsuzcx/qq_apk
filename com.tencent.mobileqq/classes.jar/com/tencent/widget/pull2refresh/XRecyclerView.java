package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import biai;
import biak;
import bias;
import bibb;
import bibc;
import bibd;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import sgm;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements biak, bias
{
  private int jdField_a_of_type_Int = 0;
  private biai jdField_a_of_type_Biai;
  private bibd jdField_a_of_type_Bibd;
  protected RecyclerViewWithHeaderFooter a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new bibb(this);
  private int b;
  private int c;
  
  public XRecyclerView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public XRecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    a(this);
    LayoutInflater.from(getContext()).inflate(2131562849, this, true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)findViewById(2131373529));
    this.jdField_a_of_type_Biai = new biai(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Biai.a(true);
    this.jdField_a_of_type_Biai.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.addOnScrollListener(new bibc(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Sgm.a();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_Sgm.a(this);
    if ((this.jdField_a_of_type_Sgm instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839219));
    return localView;
  }
  
  public biai a()
  {
    return this.jdField_a_of_type_Biai;
  }
  
  public RecyclerViewWithHeaderFooter a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this))) {
      this.jdField_a_of_type_Sgm.a(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this))) {
      this.jdField_a_of_type_Sgm.a(paramInt, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Sgm != null) {
      this.jdField_a_of_type_Sgm.a(paramBoolean, "");
    }
    if (this.jdField_a_of_type_Bibd != null) {
      this.jdField_a_of_type_Bibd.a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Biai.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Biai.a(paramBoolean2);
  }
  
  @TargetApi(14)
  protected boolean a()
  {
    return !this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.canScrollVertically(-1);
  }
  
  public boolean a(View paramView)
  {
    boolean bool = ((Boolean)this.jdField_a_of_type_JavaLangThreadLocal.get()).booleanValue();
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(false));
    if ((this.jdField_a_of_type_Sgm != null) && (paramView == this.jdField_a_of_type_Sgm.a(this)))
    {
      this.jdField_a_of_type_Sgm.a(bool);
      if (this.jdField_a_of_type_Bibd != null) {
        this.jdField_a_of_type_Bibd.a(this, bool);
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bibd != null) {
      this.jdField_a_of_type_Bibd.a(this, 0);
    }
    return true;
  }
  
  protected View b()
  {
    return null;
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaLangThreadLocal.set(Boolean.valueOf(true));
    a(1);
  }
  
  protected void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(14)
  protected boolean b()
  {
    return !this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.canScrollVertically(1);
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.stopScroll();
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.scrollToPosition(0);
  }
  
  public void setRefreshCallback(bibd parambibd)
  {
    this.jdField_a_of_type_Bibd = parambibd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */