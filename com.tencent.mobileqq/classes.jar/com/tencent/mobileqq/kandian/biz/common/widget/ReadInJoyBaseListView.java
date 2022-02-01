package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.api.R.styleable;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView.OnScrollChangeListener;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ReadInJoyBaseListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  protected ProgressBar a;
  protected RelativeLayout a;
  protected TextView a;
  ReadInJoyBaseListView.MultiScrollListener jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$MultiScrollListener = new ReadInJoyBaseListView.MultiScrollListener();
  private ReadInJoyBaseListView.OnDrawCompleteListener jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$OnDrawCompleteListener;
  protected ReadInJoyBaseListView.RefreshCallback a;
  private ReadInJoyBaseListView.ScrollEventCallback jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$ScrollEventCallback = null;
  private ArrayList<ListView.OnScrollChangeListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean a;
  protected int b;
  public boolean b;
  public int c;
  protected boolean c;
  protected int d;
  private boolean d;
  
  public ReadInJoyBaseListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyBaseListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    a(paramContext, paramAttributeSet);
  }
  
  private boolean a()
  {
    ListAdapter localListAdapter = getAdapter();
    boolean bool = false;
    if (localListAdapter == null) {
      return false;
    }
    if (getFooterViewsCount() <= 0) {
      return false;
    }
    if (getLastVisiblePosition() == getAdapter().getCount() - 1) {
      bool = true;
    }
    return bool;
  }
  
  private void b(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setPadding(localRelativeLayout.getPaddingLeft(), 0, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingRight(), paramInt);
    }
  }
  
  private void c()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, RIJStringUtils.a(62.0F, getResources())));
    TextView localTextView = new TextView(getContext());
    localTextView.setText(2131717927);
    localTextView.setTextColor(-4473925);
    localTextView.setTextSize(14.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(14);
    localLayoutParams.addRule(15);
    localLayoutParams.setMargins(0, 12, 0, 12);
    localTextView.setLayoutParams(localLayoutParams);
    localRelativeLayout.addView(localTextView);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout;
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131560393, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373273));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373274));
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
  }
  
  protected void a(int paramInt)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (paramInt != 4)
    {
      if ((a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699872);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        b(0);
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback.b(this, paramInt);
      }
    }
    else
    {
      if (a())
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699872);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        b(0);
      }
      ReadInJoyBaseListView.RefreshCallback localRefreshCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback;
      if (localRefreshCallback != null)
      {
        this.jdField_c_of_type_Int = 1;
        localRefreshCallback.b(this, paramInt);
      }
    }
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.bc);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(R.styleable.jdField_a_of_type_Int, false);
    paramContext.recycle();
    if (this.jdField_d_of_type_Boolean) {
      a();
    }
    if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.jdField_d_of_type_Int)) {
      c();
    }
    super.setOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$MultiScrollListener);
    a(this);
  }
  
  public void a(AbsListView.OnScrollListener paramOnScrollListener)
  {
    ReadInJoyBaseListView.MultiScrollListener localMultiScrollListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$MultiScrollListener;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.a(paramOnScrollListener);
    }
  }
  
  public void a(ListView.OnScrollChangeListener paramOnScrollChangeListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramOnScrollChangeListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadMoreComplete(): hasMoreData=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ReadInJoyBaseListView", 2, localStringBuilder.toString());
    }
    this.jdField_c_of_type_Int = 0;
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131699871);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      b(-this.jdField_a_of_type_Int);
    }
    setFooterView(paramBoolean);
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseListView", 2, new Object[] { "loadingMoreComplete mCurrentStatus = ", Integer.valueOf(this.jdField_c_of_type_Int), ", hasMoreData = ", Boolean.valueOf(paramBoolean) });
    }
  }
  
  public void b()
  {
    ReadInJoyBaseListView.MultiScrollListener localMultiScrollListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$MultiScrollListener;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.a();
    }
  }
  
  public void b(AbsListView.OnScrollListener paramOnScrollListener)
  {
    ReadInJoyBaseListView.MultiScrollListener localMultiScrollListener = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$MultiScrollListener;
    if (localMultiScrollListener != null) {
      localMultiScrollListener.b(paramOnScrollListener);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    paramCanvas = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$OnDrawCompleteListener;
    if (paramCanvas != null)
    {
      paramCanvas.a(this);
      paramCanvas = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$ScrollEventCallback;
      if (paramCanvas != null) {
        paramCanvas.a();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (this.jdField_a_of_type_Int < 0))
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null)
      {
        this.jdField_a_of_type_Int = localRelativeLayout.getHeight();
        b(-this.jdField_a_of_type_Int);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_Int < 0) && (this.jdField_c_of_type_Int != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2) && ((!((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.jdField_d_of_type_Int)) || (!this.jdField_b_of_type_Boolean))) {
      a(2);
    }
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((ListView.OnScrollChangeListener)localIterator.next()).onScrollChanged(this.mFirstPosition, getChildCount(), this.mItemCount);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 1) {
      if (paramInt == 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    this.jdField_a_of_type_Boolean = bool1;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof IReadInJoyBaseAdapter))) {
      ((IReadInJoyBaseAdapter)paramListAdapter).a(new ReadInJoyBaseListView.1(this));
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setCurrentStatus(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.jdField_d_of_type_Int))
      {
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        removeFooterView(this.jdField_a_of_type_AndroidViewView);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        a();
      }
      if (getFooterViewsCount() <= 0) {
        addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
    else
    {
      if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.jdField_d_of_type_Int))
      {
        removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
        if (this.jdField_a_of_type_AndroidViewView == null) {
          c();
        }
        if (getFooterViewsCount() <= 0) {
          addFooterView(this.jdField_a_of_type_AndroidViewView);
        }
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
        a();
      }
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isShowKandianTab())
      {
        int i = this.jdField_d_of_type_Int;
        if ((i == 0) || (i == 56))
        {
          QLog.d("ReadInJoyBaseListView", 1, "independent kd recommend and video channel, keep footer view.");
          return;
        }
      }
      if (getFooterViewsCount() > 0) {
        removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      }
    }
  }
  
  public void setNeedShowFootView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    a();
  }
  
  public void setNoMoreData(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Object localObject;
      if (this.jdField_b_of_type_Boolean)
      {
        if (((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).isKanDianSubscribe(this.jdField_d_of_type_Int))
        {
          if (this.jdField_a_of_type_AndroidViewView == null) {
            c();
          }
          localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
          if (localObject != null) {
            removeFooterView((View)localObject);
          }
          if (getFooterViewsCount() <= 0) {
            addFooterView(this.jdField_a_of_type_AndroidViewView);
          }
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        if (localObject != null) {
          removeFooterView((View)localObject);
        }
      }
    }
  }
  
  public void setOnDrawCompleteListener(ReadInJoyBaseListView.OnDrawCompleteListener paramOnDrawCompleteListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$OnDrawCompleteListener = paramOnDrawCompleteListener;
  }
  
  public final void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    throw new RuntimeException("use addScrollListener  or removeScrollListener，better call addScrollListener in ReadInJoyBaseAdapter.onAddScrollListeners for control the call sequence");
  }
  
  public void setRefreshCallback(ReadInJoyBaseListView.RefreshCallback paramRefreshCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback = paramRefreshCallback;
  }
  
  public void setScrollEventCallback(ReadInJoyBaseListView.ScrollEventCallback paramScrollEventCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$ScrollEventCallback = paramScrollEventCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView
 * JD-Core Version:    0.7.0.1
 */