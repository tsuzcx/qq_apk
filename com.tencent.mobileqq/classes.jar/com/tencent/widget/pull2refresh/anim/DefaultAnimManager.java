package com.tencent.widget.pull2refresh.anim;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.mobileqq.widget.PullRefreshHeader;

public class DefaultAnimManager
  extends BaseAnimManager
{
  public DefaultAnimManager(Context paramContext)
  {
    super(paramContext);
  }
  
  public int getPullRefreshAreaHeight()
  {
    return this.mContext.getResources().getDimensionPixelSize(2131298921);
  }
  
  public View getRefreshView(ViewGroup paramViewGroup)
  {
    if (this.mTopRefresh == null) {
      this.mTopRefresh = ((PullRefreshHeader)LayoutInflater.from(this.mContext).inflate(2131559642, paramViewGroup, false));
    }
    return (View)this.mTopRefresh;
  }
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    if (this.mTopRefresh == null) {
      return;
    }
    this.mTopRefresh.a(0L);
  }
  
  public void onPullRefreshing(int paramInt, boolean paramBoolean)
  {
    if (this.mTopRefresh == null) {
      return;
    }
    if (paramInt == 100)
    {
      this.mTopRefresh.b(0L);
      return;
    }
    if (paramBoolean)
    {
      this.mTopRefresh.f();
      return;
    }
    this.mTopRefresh.c(0L);
  }
  
  public void onTouchPullDistance(int paramInt1, int paramInt2) {}
  
  public void registerRefreshCompleteListener(IAnimManager.PullRefreshComplete paramPullRefreshComplete) {}
  
  public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener paramOnRefreshPullDistanceListener) {}
  
  public void showPullRefresh()
  {
    if (this.mTopRefresh == null) {
      return;
    }
    this.mTopRefresh.a(0L);
    this.mTopRefresh.f();
  }
  
  public void showRefreshResult(boolean paramBoolean, String paramString)
  {
    if (this.mTopRefresh == null) {
      return;
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      this.mTopRefresh.a(0, paramString);
      return;
    }
    if (paramBoolean)
    {
      this.mTopRefresh.a(0);
      return;
    }
    this.mTopRefresh.a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.pull2refresh.anim.DefaultAnimManager
 * JD-Core Version:    0.7.0.1
 */