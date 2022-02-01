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
  private TextView a;
  private RelativeLayout b;
  private ProgressBar c;
  private ReadInJoyPrivacyListView.LoadMoreCallback d;
  private boolean e = false;
  private boolean f = true;
  
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
    setDivider(getResources().getDrawable(2130851424));
    setDividerHeight(AIOUtils.b(0.5F, getResources()));
    setOnScrollListener(this);
    c();
  }
  
  private void c()
  {
    this.b = ((RelativeLayout)LayoutInflater.from(getContext()).inflate(2131626022, this, false));
    this.c = ((ProgressBar)this.b.findViewById(2131440882));
    this.a = ((TextView)this.b.findViewById(2131440883));
    this.a.setTextColor(Color.parseColor("#A6A6A6"));
    this.a.setTextSize(2, 14.0F);
    this.c.setVisibility(8);
    addFooterView(this.b, null, false);
    setFooterDividersEnabled(false);
  }
  
  private void d()
  {
    this.e = true;
    e();
    if (this.f)
    {
      ReadInJoyPrivacyListView.LoadMoreCallback localLoadMoreCallback = this.d;
      if (localLoadMoreCallback != null) {
        localLoadMoreCallback.b();
      }
    }
  }
  
  private void e()
  {
    RelativeLayout localRelativeLayout = this.b;
    if ((localRelativeLayout != null) && (this.c != null))
    {
      if (this.a == null) {
        return;
      }
      localRelativeLayout.setVisibility(0);
      this.c.setVisibility(0);
      this.a.setText(2131915467);
      this.a.setOnClickListener(null);
      this.a.setVisibility(0);
    }
  }
  
  public void a()
  {
    if (this.b != null)
    {
      this.e = false;
      QLog.d("ReadInJoyPrivacyListView", 2, "loadMoreFail");
      this.b.setVisibility(0);
      this.a.setText(2131915466);
      this.a.setVisibility(0);
      this.a.setOnClickListener(new ReadInJoyPrivacyListView.1(this));
      this.c.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      c();
    }
    this.e = false;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loading complete ");
    localStringBuilder.append(paramBoolean);
    QLog.d("ReadInJoyPrivacyListView", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.a.setVisibility(8);
      this.c.setVisibility(8);
    }
    else
    {
      removeFooterView(this.b);
      this.f = false;
    }
    ((BaseAdapter)((HeaderViewListAdapter)getAdapter()).getWrappedAdapter()).notifyDataSetChanged();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.f) && (!this.e)) {
      d();
    }
  }
  
  public void setLoadMoreCallback(ReadInJoyPrivacyListView.LoadMoreCallback paramLoadMoreCallback)
  {
    this.d = paramLoadMoreCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyPrivacyListView
 * JD-Core Version:    0.7.0.1
 */