package com.tencent.mobileqq.newnearby;

import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.mobileqq.widget.TabLayoutCompat;

@QAPI(process={"all"})
public abstract interface INearbyMsgbox
  extends QRouteApi
{
  public abstract void initQQNearbyTabs(QBaseActivity paramQBaseActivity, TabLayoutCompat paramTabLayoutCompat, RedpointObserver paramRedpointObserver, int paramInt1, boolean paramBoolean, int paramInt2);
  
  public abstract void initStatusBar(QBaseActivity paramQBaseActivity);
  
  public abstract void initTitleBar(QBaseActivity paramQBaseActivity);
  
  public abstract boolean isNewNearby();
  
  public abstract void setNearbyVersion(boolean paramBoolean);
  
  public abstract void updateMsgBoxItemView(View paramView, Object paramObject, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.INearbyMsgbox
 * JD-Core Version:    0.7.0.1
 */