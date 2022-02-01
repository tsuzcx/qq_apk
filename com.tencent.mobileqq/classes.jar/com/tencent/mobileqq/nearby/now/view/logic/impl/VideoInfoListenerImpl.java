package com.tencent.mobileqq.nearby.now.view.logic.impl;

import android.app.Activity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.ProgressControler;
import com.tencent.mobileqq.nearby.now.model.ImageData;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IStoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.IShortVideoCommentsView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView.VideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.OperationView;
import com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter;
import com.tencent.mobileqq.nearby.now.view.VideoPlayerPagerAdapter.VideoViewHolder;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class VideoInfoListenerImpl
  implements IVideoPlayerView.VideoInfoListener, IVideoInfoListener
{
  private static final int RELAYOUT_INTERVAL_TIME = 500;
  private final String TAG = "VideoInfoListener";
  private IShortVideoCommentsView mCommentsView;
  private VideoPlayerPagerAdapter.VideoViewHolder mHolder;
  private HorizontalBallLoadingView mHorizontalBallLoadingView;
  private boolean mNeedRelayoutPlayerView;
  int mOldPercent = -1;
  private IStoryPlayController mPlayController;
  Runnable mShowLoadingRunable = new VideoInfoListenerImpl.3(this);
  private int mVideoCoverHeight;
  private int mVideoCoverWidth;
  
  public void handleDeviceNavChange()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInfoListener", 2, "VideoInfoListenerImpl onLayoutChange");
    }
    if (this.mHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getVisibility() == 0)
    {
      if ((((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.size() > this.mPlayController.getCurrentIndex()) && (((VideoData)((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mPlayController.getCurrentIndex())).a.size() > 0)) {
        ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicLayoutStoryImageContainerView(this.mHolder, ((ImageData)((VideoData)((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mPlayController.getCurrentIndex())).a.get(0)).b, ((ImageData)((VideoData)((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mPlayController.getCurrentIndex())).a.get(0)).jdField_a_of_type_Int, ((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mPlayController.getCurrentIndex()), this.mCommentsView);
      }
    }
    else if ((this.mVideoCoverWidth > 0) && (this.mVideoCoverHeight > 0)) {
      ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(this.mHolder, this.mVideoCoverWidth, this.mVideoCoverHeight);
    }
  }
  
  public void hideLoading()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hideLoading： mHorizontalBallLoadingView is null? : ");
      boolean bool;
      if (this.mHorizontalBallLoadingView == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("VideoInfoListener", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.getUIHandler().removeCallbacks(this.mShowLoadingRunable);
    Object localObject = this.mHorizontalBallLoadingView;
    if (localObject == null) {
      return;
    }
    ((HorizontalBallLoadingView)localObject).setVisibility(8);
    this.mHorizontalBallLoadingView = null;
  }
  
  public VideoInfoListenerImpl init(Object paramObject, IStoryPlayController paramIStoryPlayController, IShortVideoCommentsView paramIShortVideoCommentsView, boolean paramBoolean)
  {
    this.mHolder = ((VideoPlayerPagerAdapter.VideoViewHolder)paramObject);
    this.mPlayController = paramIStoryPlayController;
    this.mCommentsView = paramIShortVideoCommentsView;
    this.mNeedRelayoutPlayerView = paramBoolean;
    return this;
  }
  
  public void onComplete()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onComplete");
    }
    if (((this.mPlayController.getContext() instanceof Activity)) && (((Activity)this.mPlayController.getContext()).isFinishing())) {
      return;
    }
    ThreadManager.getUIHandler().postDelayed(new VideoInfoListenerImpl.1(this), 1000L);
  }
  
  public void onCoverComplete(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCoverComplete() called with: imageWidth = [");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], imageHeight = [");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], isSuc = [");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("]");
      QLog.i("VideoInfoListener", 2, localStringBuilder.toString());
    }
    this.mVideoCoverWidth = paramInt1;
    this.mVideoCoverHeight = paramInt2;
    if ((paramBoolean) && (this.mNeedRelayoutPlayerView)) {
      ((IStoryRelayoutUtil)QRoute.api(IStoryRelayoutUtil.class)).dynamicChangeStoryContainerView(this.mHolder, paramInt1, paramInt2);
    }
  }
  
  public void onDoingStartPlayback()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onDoingStartPlayback");
    }
    showLoading();
    this.mPlayController.updateVideoLabelState();
  }
  
  public void onDoingStopPlayback()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onDoingStopPlayback");
    }
    hideLoading();
    if (!this.mCommentsView.isScrollTop()) {
      this.mCommentsView.scrollToTop();
    }
  }
  
  public void onPlayError()
  {
    this.mHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(false);
    hideLoading();
    QLog.e("VideoInfoListener", 1, "onPlayError");
    this.mHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(0);
    IShortVideoCommentsView localIShortVideoCommentsView = this.mCommentsView;
    if ((localIShortVideoCommentsView != null) && (localIShortVideoCommentsView.getmEmptyCloseBtn() != null)) {
      this.mCommentsView.getmEmptyCloseBtn().setVisibility(0);
    }
    this.mHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.a();
    this.mHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnRetryClickListener(new VideoInfoListenerImpl.2(this));
  }
  
  public void onPlayProgress(int paramInt)
  {
    if (paramInt != 0)
    {
      if (this.mOldPercent == paramInt) {
        return;
      }
      this.mOldPercent = paramInt;
      int i = paramInt;
      if (paramInt > 100) {
        i = 100;
      }
      if (this.mPlayController.isMultiProgressBar())
      {
        ((StuffContainerView)this.mPlayController.getStuffContainerView()).a.a(this.mHolder.jdField_a_of_type_Int, i);
        return;
      }
      ((StuffContainerView)this.mPlayController.getStuffContainerView()).a.a(0, i);
    }
  }
  
  public void onPlayRetry(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onPlayRetry");
    }
    hideLoading();
    if (this.mHolder != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPlayRetry mPlayController.mCurrentIndexis: ");
      ((StringBuilder)localObject).append(this.mPlayController.getCurrentIndex());
      QLog.e("VideoInfoListener", 1, ((StringBuilder)localObject).toString());
      ((IVideoPlayerView)this.mPlayController.getVideoPlayer()).stopPlayback(false);
      localObject = this.mPlayController;
      ((IStoryPlayController)localObject).startPlayVideo(((IStoryPlayController)localObject).getCurrentIndex());
    }
  }
  
  public void onPrepareCompleted() {}
  
  public void onPrepareProgress(int paramInt) {}
  
  public void onStartPlaying()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onStartPlaying");
    }
    Object localObject = this.mHolder;
    if (localObject != null)
    {
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      localObject = this.mCommentsView;
      if ((localObject != null) && (((IShortVideoCommentsView)localObject).getmEmptyCloseBtn() != null) && (((VideoData)((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mHolder.jdField_a_of_type_Int)).b != 4)) {
        this.mCommentsView.getmEmptyCloseBtn().setVisibility(8);
      }
      hideLoading();
      this.mPlayController.hideRootCover();
      this.mHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
      if ((this.mHolder.jdField_a_of_type_Int >= 0) && (this.mHolder.jdField_a_of_type_Int < ((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.size()))
      {
        localObject = (VideoData)((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mHolder.jdField_a_of_type_Int);
        if (1 == ((VideoData)localObject).b) {
          return;
        }
        if (this.mPlayController.getCurrentIndex() == this.mHolder.jdField_a_of_type_Int) {
          ((VideoData)localObject).c = true;
        }
      }
      return;
    }
    QLog.e("VideoInfoListener", 1, "mHolder == null!");
  }
  
  public void onStartPrepareVideo()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoInfoListener", 2, "onStartPrepareVideo");
    }
    Object localObject = this.mHolder;
    if (localObject == null) {
      return;
    }
    ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
    localObject = this.mCommentsView;
    if ((localObject != null) && (((IShortVideoCommentsView)localObject).getmEmptyCloseBtn() != null) && (((VideoData)((VideoPlayerPagerAdapter)this.mPlayController.getAdapter()).a.get(this.mHolder.jdField_a_of_type_Int)).b != 4)) {
      this.mCommentsView.getmEmptyCloseBtn().setVisibility(8);
    }
    localObject = this.mHolder;
    if (localObject != null) {
      ((VideoPlayerPagerAdapter.VideoViewHolder)localObject).jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a(true);
    }
  }
  
  public void scrollToTop()
  {
    this.mCommentsView.scrollToTop();
  }
  
  public void showLoading()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showLoading： mHorizontalBallLoadingView is null? : ");
      boolean bool;
      if (this.mHorizontalBallLoadingView == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.i("VideoInfoListener", 2, localStringBuilder.toString());
    }
    this.mHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.mHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370360));
    ThreadManager.getUIHandler().postDelayed(this.mShowLoadingRunable, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.logic.impl.VideoInfoListenerImpl
 * JD-Core Version:    0.7.0.1
 */