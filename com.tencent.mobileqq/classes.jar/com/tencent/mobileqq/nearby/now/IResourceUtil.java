package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IResourceUtil
  extends QRouteApi
{
  public abstract int getAddDescribeDialogStyleNoFull();
  
  public abstract int getAnimationPoint();
  
  public abstract int[] getBallLoadingView();
  
  public abstract int getBallLoadingViewBallScale();
  
  public abstract int getCloseIcon();
  
  public abstract int[] getCustomFitMode();
  
  public abstract int getCustomFitModeUseFitXFromStart();
  
  public abstract int getDisplayImageView();
  
  public abstract int getDoodleView();
  
  public abstract int getGuideTv();
  
  public abstract int getIvCover();
  
  public abstract int getNearbyNowViewHolderEmptyView();
  
  public abstract int getNearbyNowViewHolderNetworkError();
  
  public abstract int getNearbyNowliveShortvideoLike();
  
  public abstract int getNearbyVideoPlayerErrorLayout();
  
  public abstract int getOutsideErrorView();
  
  public abstract int getQQNearbyImageDisplayView();
  
  public abstract int getQQNearbyNowBgStartLiveGap();
  
  public abstract int getQQNearbyNowBgStartLiveNormalGap();
  
  public abstract int getQQNearbyNowLayoutVideoOperator();
  
  public abstract int getQQNearbyNowVideoPlayerLayout();
  
  public abstract int getQQNearbyTopicLabelBkg();
  
  public abstract int getQQStoryNewGuideDialog();
  
  public abstract int getQQStrQQStoryV88c3cc80();
  
  public abstract int getQQStrStartlivBe188c1d();
  
  public abstract int getRetry();
  
  public abstract int getTips();
  
  public abstract int getVideoSplitProgressBar();
  
  public abstract int getVideoViewPager();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.IResourceUtil
 * JD-Core Version:    0.7.0.1
 */