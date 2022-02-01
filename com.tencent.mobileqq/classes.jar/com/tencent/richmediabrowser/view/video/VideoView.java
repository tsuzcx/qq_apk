package com.tencent.richmediabrowser.view.video;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.view.QQVideoPlayView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.utils.VersionUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.util.concurrent.ConcurrentHashMap;

public class VideoView
  extends BrowserBaseView
  implements View.OnClickListener
{
  public static final float MAX_PROGRESS = 10000.0F;
  private static final String TAG = "VideoView";
  public QQVideoPlayView mVideoView;
  public VideoPresenter videoPresenter;
  
  public VideoView(Activity paramActivity, VideoPresenter paramVideoPresenter)
  {
    super(paramActivity, paramVideoPresenter);
    this.videoPresenter = paramVideoPresenter;
  }
  
  private void abandonAudioFocus()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  private VideoPlayParam buildVideoParam(VideoData paramVideoData)
  {
    VideoPlayParam localVideoPlayParam = new VideoPlayParam();
    if (paramVideoData.isLocal)
    {
      localVideoPlayParam.mVideoPath = paramVideoData.filePath;
      localVideoPlayParam.mIsLocal = true;
    }
    for (;;)
    {
      localVideoPlayParam.mFileID = paramVideoData.id;
      localVideoPlayParam.mIsMute = paramVideoData.isMutePlay;
      if (!localVideoPlayParam.mIsMute) {
        requestAudioFocus();
      }
      localVideoPlayParam.mIsLoop = false;
      localVideoPlayParam.mNeedPlayProgress = true;
      return localVideoPlayParam;
      localVideoPlayParam.mUrls = new String[1];
      localVideoPlayParam.mUrls[0] = paramVideoData.url;
    }
  }
  
  private void pauseVideo()
  {
    if (this.mVideoView != null) {
      this.mVideoView.pause();
    }
    abandonAudioFocus();
    updateStatus(6);
    this.videoPresenter.onLoadFinish(this.videoPresenter.getSelectedIndex(), true);
  }
  
  private void requestAudioFocus()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  private void updateStatus(int paramInt)
  {
    VideoData localVideoData = getCurrentVideoData();
    if (localVideoData != null) {
      this.videoPresenter.updateItemStatus(localVideoData.id, paramInt);
    }
  }
  
  public void bindView(int paramInt)
  {
    Object localObject = this.videoPresenter.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 2))
    {
      localObject = buildVideoParam((VideoData)((RichMediaBrowserInfo)localObject).baseData);
      if (this.mVideoView != null) {
        this.mVideoView.setVideoParam((VideoPlayParam)localObject);
      }
      localObject = new VideoView.GalleryVideoViewHolder(this);
      ((VideoView.GalleryVideoViewHolder)localObject).videoView = this.mVideoView;
      this.mBrowserItemView.setTag(localObject);
    }
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    onCreate(paramViewGroup);
  }
  
  public void clearShortVideo()
  {
    clearTheOuchCache();
  }
  
  public void clearTheOuchCache()
  {
    this.videoPresenter.mActiveThumbDrawable.clear();
  }
  
  public VideoData getCurrentVideoData()
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.videoPresenter.getSelectedItem();
    if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (localRichMediaBrowserInfo.baseData.getType() == 2)) {
      return (VideoData)localRichMediaBrowserInfo.baseData;
    }
    return null;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 2, "getView ");
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof VideoView.GalleryVideoViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.mVideoView = ((VideoView.GalleryVideoViewHolder)paramView.getTag()).videoView;
    }
    for (;;)
    {
      return this.mBrowserItemView;
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131563040, paramViewGroup, false));
      this.mVideoView = ((QQVideoPlayView)this.mBrowserItemView.findViewById(2131380797));
      this.mVideoView.setOnClickListener(this);
    }
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    if ((this.mVideoView != null) && (this.mVideoView.mPlayBar != null) && (this.mVideoView.mPlayBar.getVisibility() == 0))
    {
      SeekBar localSeekBar = this.mVideoView.mPlayBar;
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar is visible");
      int[] arrayOfInt = new int[2];
      localSeekBar.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (new Rect(i, j, localSeekBar.getWidth() + i, localSeekBar.getHeight() + j).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar deal event");
        return true;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar deal event");
    }
    return super.isNeedDisallowInterceptEvent(paramMotionEvent);
  }
  
  public void onClick(View paramView) {}
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
  }
  
  public void onEnterAnimationEnd()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onEnterAnimationEnd");
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onEnterAnimationStart");
    showContentView(false);
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onPause");
    pauseVideo();
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onResume");
    if (this.mVideoView != null) {
      this.mVideoView.resume();
    }
  }
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onStop");
    clearShortVideo();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.video.VideoView
 * JD-Core Version:    0.7.0.1
 */