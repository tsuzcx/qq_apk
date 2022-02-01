package com.tencent.mobileqq.kandian.biz.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.view.widget.pullrefresh.RefreshAnimView;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimDefaultManager
  extends ReadInJoyAnimBaseManager
{
  private RefreshAnimView g;
  
  public ReadInJoyAnimDefaultManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public void endOfRefresh()
  {
    super.endOfRefresh();
    this.g.a(1000L);
  }
  
  public int getPullRefreshAreaHeight()
  {
    return this.a.getResources().getDimensionPixelSize(2131299569);
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.b == null)
    {
      paramViewGroup = LayoutInflater.from(this.a).inflate(2131629138, paramViewGroup, false);
      paramViewGroup.findViewById(2131444559).getLayoutParams().width = -2;
      this.b = ((IPullRefreshHeader)paramViewGroup);
      this.g = ((RefreshAnimView)((PullRefreshHeader)this.b).findViewById(2131444549));
    }
    return (View)this.b;
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.b.a(0L);
    this.g.a();
    this.g.b();
  }
  
  public void onPullRefreshing(int paramInt, boolean paramBoolean)
  {
    super.onPullRefreshing(paramInt, paramBoolean);
    if (this.b == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.b.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.b.f();
      return;
    }
    this.b.c(0L);
    this.g.a();
    RefreshAnimView localRefreshAnimView = this.g;
    double d = paramInt;
    Double.isNaN(d);
    localRefreshAnimView.a(d / 100.0D);
  }
  
  public void showPullRefresh()
  {
    if (this.b == null) {
      return;
    }
    this.b.a(0L);
    this.b.f();
  }
  
  public void showRefreshResult(boolean paramBoolean, String paramString)
  {
    if (this.b == null) {
      return;
    }
    this.g.a(paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimDefaultManager
 * JD-Core Version:    0.7.0.1
 */