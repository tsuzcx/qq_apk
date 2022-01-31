package com.tencent.widget.pull2refresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import bera;
import berc;
import berk;
import bert;
import beru;
import berv;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoySkinAnimManager;
import com.tencent.qphone.base.util.QLog;
import rec;

public class XRecyclerView
  extends AbsPullToRefreshView2
  implements berc, berk
{
  private int jdField_a_of_type_Int = 0;
  private bera jdField_a_of_type_Bera;
  private berv jdField_a_of_type_Berv;
  protected RecyclerViewWithHeaderFooter a;
  private XLoadMoreLayout jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout;
  private ThreadLocal<Boolean> jdField_a_of_type_JavaLangThreadLocal = new bert(this);
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
    LayoutInflater.from(getContext()).inflate(2131497049, this, true);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout = new XLoadMoreLayout(getContext());
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter = ((RecyclerViewWithHeaderFooter)findViewById(2131307380));
    this.jdField_a_of_type_Bera = new bera(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout, getContext());
    this.jdField_a_of_type_Bera.a(true);
    this.jdField_a_of_type_Bera.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.c(this.jdField_a_of_type_ComTencentWidgetPull2refreshXLoadMoreLayout);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter.addOnScrollListener(new beru(this));
  }
  
  protected int a()
  {
    return this.jdField_a_of_type_Rec.a();
  }
  
  protected View a()
  {
    View localView = this.jdField_a_of_type_Rec.a(this);
    if ((this.jdField_a_of_type_Rec instanceof ReadInJoySkinAnimManager))
    {
      setPullHeaderBgDrawable(new ColorDrawable(Color.parseColor("#F7F7F7")));
      return localView;
    }
    setPullHeaderBgDrawable(getResources().getDrawable(2130839107));
    return localView;
  }
  
  public bera a()
  {
    return this.jdField_a_of_type_Bera;
  }
  
  public RecyclerViewWithHeaderFooter a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshRecyclerViewWithHeaderFooter;
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Rec != null) && (paramView == this.jdField_a_of_type_Rec.a(this))) {
      this.jdField_a_of_type_Rec.a(100, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_Rec != null) && (paramView == this.jdField_a_of_type_Rec.a(this))) {
      this.jdField_a_of_type_Rec.a(paramInt, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(View paramView, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (this.jdField_a_of_type_Rec != null) {
      this.jdField_a_of_type_Rec.a(paramBoolean, "");
    }
    if (this.jdField_a_of_type_Berv != null) {
      this.jdField_a_of_type_Berv.a();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XRecyclerView", 2, "loadMoreComplete(): hasMoreData=" + paramBoolean2);
    }
    this.jdField_a_of_type_Bera.a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_Bera.a(paramBoolean2);
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
    if ((this.jdField_a_of_type_Rec != null) && (paramView == this.jdField_a_of_type_Rec.a(this)))
    {
      this.jdField_a_of_type_Rec.a(bool);
      if (this.jdField_a_of_type_Berv != null) {
        this.jdField_a_of_type_Berv.a(this, bool);
      }
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Berv != null) {
      this.jdField_a_of_type_Berv.a(this, 0);
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
  
  public void setRefreshCallback(berv paramberv)
  {
    this.jdField_a_of_type_Berv = paramberv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.XRecyclerView
 * JD-Core Version:    0.7.0.1
 */