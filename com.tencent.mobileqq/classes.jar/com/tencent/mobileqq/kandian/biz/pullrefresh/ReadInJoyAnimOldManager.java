package com.tencent.mobileqq.kandian.biz.pullrefresh;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class ReadInJoyAnimOldManager
  extends ReadInJoyAnimBaseManager
{
  public ReadInJoyAnimOldManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public int getPullRefreshAreaHeight()
  {
    return this.a.getResources().getDimensionPixelSize(2131299643);
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.b == null) {
      this.b = ((PullRefreshHeader)LayoutInflater.from(this.a).inflate(2131625671, paramViewGroup, false));
    }
    return (View)this.b;
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.b.a(0L);
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
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.b.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.b.a(0);
      return;
    }
    this.b.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimOldManager
 * JD-Core Version:    0.7.0.1
 */