package com.tencent.mobileqq.kandian.biz.pullrefresh;

import android.content.Context;
import android.view.MotionEvent;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView.IPullRefreshAnim;
import com.tencent.mobileqq.kandian.biz.skin.SlideActiveAnimController;
import com.tencent.mobileqq.widget.IPullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager.OnRefreshPullDistanceListener;
import com.tencent.widget.pull2refresh.anim.IAnimManager.PullRefreshComplete;

public abstract class ReadInJoyAnimBaseManager
  implements ReadInJoyXListView.IPullRefreshAnim, IAnimManager
{
  private static final String g = "ReadInJoyAnimBaseManager";
  protected Context a;
  protected IPullRefreshHeader b;
  protected IAnimManager.PullRefreshComplete c;
  protected SlideActiveAnimController d;
  protected int e;
  protected IAnimManager.OnRefreshPullDistanceListener f;
  
  public ReadInJoyAnimBaseManager(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public void a(SlideActiveAnimController paramSlideActiveAnimController)
  {
    this.d = paramSlideActiveAnimController;
  }
  
  public void endOfRefresh() {}
  
  public boolean isSkinAnimManager()
  {
    return false;
  }
  
  public void onDestroy() {}
  
  public void onPullRefreshCancel() {}
  
  public void onPullRefreshComplete(boolean paramBoolean)
  {
    IAnimManager.PullRefreshComplete localPullRefreshComplete = this.c;
    if (localPullRefreshComplete != null) {
      localPullRefreshComplete.pullRefreshComplete(paramBoolean);
    }
  }
  
  public void onPullRefreshing(int paramInt, boolean paramBoolean)
  {
    if (QLog.isDebugVersion())
    {
      String str = g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPullRefreshing percent:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" isTopRefreshing:");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 4, localStringBuilder.toString());
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void onTouchPullDistance(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    IAnimManager.OnRefreshPullDistanceListener localOnRefreshPullDistanceListener = this.f;
    if (localOnRefreshPullDistanceListener != null) {
      localOnRefreshPullDistanceListener.onPullDistance(paramInt1, paramInt2);
    }
  }
  
  public void registerRefreshCompleteListener(IAnimManager.PullRefreshComplete paramPullRefreshComplete)
  {
    this.c = paramPullRefreshComplete;
  }
  
  public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener paramOnRefreshPullDistanceListener)
  {
    this.f = paramOnRefreshPullDistanceListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager
 * JD-Core Version:    0.7.0.1
 */