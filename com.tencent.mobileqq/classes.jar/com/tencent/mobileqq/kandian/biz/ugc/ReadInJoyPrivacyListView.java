package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.XListView;

public class ReadInJoyPrivacyListView
  extends XListView
  implements AbsListView.OnScrollListener
{
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyPrivacyListView.LoadMoreCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView$LoadMoreCallback;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  
  public ReadInJoyPrivacyListView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ReadInJoyPrivacyListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ReadInJoyPrivacyListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setDivider(getResources().getDrawable(2130849715));
    setDividerHeight(AIOUtils.b(0.5F, getResources()));
    setOnScrollListener(this);
    c();
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131559979, this, false));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373273));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131373274));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#A6A6A6"));
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(2, 14.0F);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    addFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Boolean = true;
    e();
    if (this.b)
    {
      ReadInJoyPrivacyListView.LoadMoreCallback localLoadMoreCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView$LoadMoreCallback;
      if (localLoadMoreCallback != null) {
        localLoadMoreCallback.b();
      }
    }
  }
  
  private void e()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null))
    {
      if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
        return;
      }
      localRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717987);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(null);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      this.jdField_a_of_type_Boolean = false;
      QLog.d("ReadInJoyPrivacyListView", 2, "loadMoreFail");
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131717986);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new ReadInJoyPrivacyListView.1(this));
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      c();
    }
    this.jdField_a_of_type_Boolean = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loading complete ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ReadInJoyPrivacyListView", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    }
    else
    {
      removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.b = false;
    }
    ((BaseAdapter)((HeaderViewListAdapter)getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.b) && (!this.jdField_a_of_type_Boolean)) {
      d();
    }
  }
  
  public void setLoadMoreCallback(ReadInJoyPrivacyListView.LoadMoreCallback paramLoadMoreCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcReadInJoyPrivacyListView$LoadMoreCallback = paramLoadMoreCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListView
 * JD-Core Version:    0.7.0.1
 */