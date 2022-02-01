package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.qroute.QRoute;

public class OperationView
  extends FrameLayout
{
  IPlayOperationViewModel a;
  VideoData b;
  public AppInterface c;
  
  public OperationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public OperationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OperationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowLayoutVideoOperator(), this, true);
    this.a = ((IPlayOperationViewModel)QRoute.api(IPlayOperationViewModel.class)).init(localView, this.c);
  }
  
  public void a(VideoData paramVideoData)
  {
    this.b = paramVideoData;
    this.a.updateShowInfo(paramVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == null) {
      return;
    }
    this.a.showIfCan(paramBoolean);
  }
  
  public void b()
  {
    if (this.b.b != 4) {
      this.a.initCommentsWidget();
    }
  }
  
  public void c()
  {
    this.a.destroy();
  }
  
  public IPlayOperationViewModel getPlayOperationViewModel()
  {
    return this.a;
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    IPlayOperationViewModel localIPlayOperationViewModel = this.a;
    if (localIPlayOperationViewModel != null) {
      localIPlayOperationViewModel.setCurrentAnchorUin(paramLong);
    }
  }
  
  public void setOnCloseListener(Object paramObject)
  {
    IPlayOperationViewModel localIPlayOperationViewModel = this.a;
    if (localIPlayOperationViewModel != null) {
      localIPlayOperationViewModel.setOnCloseListener(paramObject);
    }
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    IPlayOperationViewModel localIPlayOperationViewModel = this.a;
    if (localIPlayOperationViewModel != null) {
      localIPlayOperationViewModel.setOnCommentClickListener(paramOnClickListener);
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.a.setVideoPageSource(paramInt);
  }
  
  public void setWatchCount(int paramInt)
  {
    VideoData localVideoData = this.b;
    if (localVideoData == null) {
      return;
    }
    if (localVideoData.b == 1) {
      return;
    }
    this.a.setWatchCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.OperationView
 * JD-Core Version:    0.7.0.1
 */