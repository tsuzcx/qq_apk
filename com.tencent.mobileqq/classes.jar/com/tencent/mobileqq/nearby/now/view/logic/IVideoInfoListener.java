package com.tencent.mobileqq.nearby.now.view.logic;

import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IVideoInfoListener
  extends QRouteApi
{
  public abstract void handleDeviceNavChange();
  
  public abstract void hideLoading();
  
  public abstract IVideoInfoListener init(Object paramObject, IStoryPlayController paramIStoryPlayController, IShortVideoCommentsView paramIShortVideoCommentsView, boolean paramBoolean);
  
  public abstract void scrollToTop();
  
  public abstract void showLoading();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener
 * JD-Core Version:    0.7.0.1
 */