package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import bfzl;
import bfzn;
import bfzv;
import bgae;
import bgaf;
import bgag;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import rqn;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements bfzn, bfzv
{
  private int jdField_a_of_type_Int = 0;
  private bfzl jdField_a_of_type_Bfzl;
  private bgag jdField_a_of_type_Bgag;
  protected RecyclerViewWithHeaderFooter a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new bgae(this);
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
    LayoutInflater.from(getContext()).inflate(2131562645, this, true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)findViewById(2131373093));
    this.jdField_a_of_type_Bfzl = new bfzl(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Bfzl.a(true);
    this.jdField_a_of_type_Bfzl.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.addOnScrollListener(new bgaf(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Rqn.a();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_Rqn.a(this);
    if ((this.jdField_a_of_type_Rqn instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839135));
    return localView;
  }
  
  public bfzl a()
  {
    return this.jdField_a_of_type_Bfzl;
  }
  
  public RecyclerViewWithHeaderFooter a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Rqn != null) && (paramView == this.jdField_a_of_type_Rqn.a(this))) {
      this.jdField_a_of_type_Rqn.a(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Rqn != null) && (paramView == this.jdField_a_of_type_Rqn.a(this))) {
      this.jdField_a_of_type_Rqn.a(paramInt, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Rqn != null) {
      this.jdField_a_of_type_Rqn.a(paramBoolean, "");
    }
    if (this.jdField_a_of_type_Bgag != null) {
      this.jdField_a_of_type_Bgag.a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Bfzl.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Bfzl.a(paramBoolean2);
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
    if ((this.jdField_a_of_type_Rqn != null) && (paramView == this.jdField_a_of_type_Rqn.a(this)))
    {
      this.jdField_a_of_type_Rqn.a(bool);
      if (this.jdField_a_of_type_Bgag != null) {
        this.jdField_a_of_type_Bgag.a(this, bool);
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bgag != null) {
      this.jdField_a_of_type_Bgag.a(this, 0);
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
  
  public void setRefreshCallback(bgag parambgag)
  {
    this.jdField_a_of_type_Bgag = parambgag;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */