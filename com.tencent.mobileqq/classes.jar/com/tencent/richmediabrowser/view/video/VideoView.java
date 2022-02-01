package com.tencent.richmediabrowser.view.video;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.api.event.IVideoViewClickEvent;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.utils.BrowserUtils;
import com.tencent.richmediabrowser.utils.VersionUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.GalleryUrlImageView;
import java.util.concurrent.ConcurrentHashMap;

public class VideoView
  extends BrowserBaseView
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public static final float MAX_PROGRESS = 10000.0F;
  private static final String TAG = "VideoView";
  public RelativeLayout bufferPanel;
  public GalleryUrlImageView coverView;
  public boolean isPlayPanelDecorator = false;
  public ImageView mCenterPlayBtn;
  public LinearLayout mErrLayout;
  public BaseVideoView mVideoView;
  public SeekBar playBar;
  public ImageView playButton;
  public View playPanel;
  public TextView progressTime;
  public TextView rateText;
  public TextView totalTime;
  public RelativeLayout videoControlContainer;
  private VideoPlayerCallback videoPlayerCallback;
  public VideoPresenter videoPresenter;
  private IVideoViewClickEvent videoViewClickEvent;
  
  public VideoView(Context paramContext, VideoPresenter paramVideoPresenter)
  {
    super(paramContext, paramVideoPresenter);
    this.videoPresenter = paramVideoPresenter;
  }
  
  private void handlePlayError(int paramInt1, int paramInt2, VideoPlayParam paramVideoPlayParam)
  {
    if (paramInt2 == 14011001) {
      paramVideoPlayParam = this.mContext.getString(2131720215);
    } else {
      paramVideoPlayParam = null;
    }
    VideoData localVideoData = this.videoPresenter.getCurrentVideoData();
    if (localVideoData != null)
    {
      if (paramVideoPlayParam == null) {
        paramVideoPlayParam = this.mContext.getString(2131720253);
      }
      localVideoData.errorDescription = paramVideoPlayParam;
    }
    if ((this.mContext instanceof Activity)) {
      ((Activity)this.mContext).runOnUiThread(new VideoView.3(this));
    }
  }
  
  private void realPlayVideo(VideoData paramVideoData)
  {
    if ((paramVideoData != null) && (paramVideoData.videoPlayParam != null))
    {
      Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("realPlayVideo id = ");
      localStringBuilder.append(paramVideoData.id);
      ((IBrowserLog)localObject).d("VideoView", 4, localStringBuilder.toString());
      this.videoPresenter.updateItemStatus(paramVideoData.id, 3);
      updateUI();
      setVideoPlayCallback(paramVideoData.videoPlayParam);
      localObject = this.mVideoView;
      if (localObject != null)
      {
        ((BaseVideoView)localObject).setVideoParam(paramVideoData.videoPlayParam);
        this.mVideoView.play();
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "videoPlayParam is null");
  }
  
  private void tryPlayVideo(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("tryPlayVideo, position = ");
    ((StringBuilder)localObject2).append(paramInt);
    ((IBrowserLog)localObject1).d("VideoView", 4, ((StringBuilder)localObject2).toString());
    localObject1 = this.videoPresenter.getItem(paramInt);
    if ((localObject1 != null) && (((RichMediaBrowserInfo)localObject1).baseData != null) && (((RichMediaBrowserInfo)localObject1).baseData.getType() == 2))
    {
      localObject1 = (VideoData)((RichMediaBrowserInfo)localObject1).baseData;
      localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tryPlayVideo, position = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" , id = ");
      localStringBuilder.append(((VideoData)localObject1).id);
      ((IBrowserLog)localObject2).d("VideoView", 4, localStringBuilder.toString());
      ((VideoData)localObject1).isAutoPlay = paramBoolean;
      if ((this.videoPresenter.videoModel != null) && (((VideoData)localObject1).videoPlayParam != null))
      {
        realPlayVideo((VideoData)localObject1);
        return;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "updateItemStatus downloadVideo");
      this.videoPresenter.downloadVideo((VideoData)localObject1);
      this.videoPresenter.updateItemStatus(((VideoData)localObject1).id, 1);
      updateUI();
    }
  }
  
  private void updateStatus(int paramInt)
  {
    Object localObject = this.videoPresenter;
    if (localObject != null)
    {
      localObject = ((VideoPresenter)localObject).getCurrentVideoData();
      if (localObject != null) {
        this.videoPresenter.updateItemStatus(((VideoData)localObject).id, paramInt);
      }
    }
  }
  
  public void abandonAudioFocus()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Context localContext1 = this.mContext;
      Context localContext2 = this.mContext;
      ((AudioManager)localContext1.getSystemService("audio")).abandonAudioFocus(null);
    }
  }
  
  public void bindView(int paramInt)
  {
    this.coverView.setOnClickListener(this);
    this.coverView.setOnLongClickListener(this);
    this.mVideoView.setID(2131380795);
    this.mVideoView.setId(2131380795);
    this.mVideoView.setOnClickListener(this);
    this.mVideoView.setOnLongClickListener(this);
    this.mBrowserItemView.setContentDescription(this.mContext.getString(2131720194));
    Object localObject = this.videoPresenter.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 2))
    {
      localObject = (Drawable)this.videoPresenter.mActiveThumbDrawable.get(Integer.valueOf(paramInt));
      if (localObject != null)
      {
        BaseVideoView localBaseVideoView = this.mVideoView;
        if (localBaseVideoView != null)
        {
          localBaseVideoView.showCover((Drawable)localObject);
          break label157;
        }
      }
      this.videoPresenter.loadVideoCover(this.mScreenWidthPx, this.mScreenHeightPx, this.coverView, paramInt);
      label157:
      localObject = new VideoView.GalleryVideoViewHolder(this);
      ((VideoView.GalleryVideoViewHolder)localObject).videoView = this.mVideoView;
      this.mBrowserItemView.setTag(localObject);
    }
    super.bindView(paramInt);
  }
  
  public void clearTheOuchCache()
  {
    this.videoPresenter.mActiveThumbDrawable.clear();
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    if (((paramView instanceof RelativeLayout)) && ((paramView.getTag() instanceof VideoView.GalleryVideoViewHolder)))
    {
      this.mBrowserItemView = ((RelativeLayout)paramView);
      this.mVideoView = ((VideoView.GalleryVideoViewHolder)paramView.getTag()).videoView;
    }
    else
    {
      this.mBrowserItemView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131563021, paramViewGroup, false));
      this.coverView = ((GalleryUrlImageView)this.mBrowserItemView.findViewById(2131373043));
      this.mVideoView = ((BaseVideoView)this.mBrowserItemView.findViewById(2131380795));
      if (!this.isPlayPanelDecorator)
      {
        ((ViewStub)this.mBrowserItemView.findViewById(2131380699)).inflate();
        initContentView(this.mBrowserItemView);
      }
    }
    super.getView(paramView, paramViewGroup);
    return this.mBrowserItemView;
  }
  
  public void initContentView(View paramView)
  {
    if (this.mBrowserItemView != null)
    {
      this.videoControlContainer = ((RelativeLayout)this.mBrowserItemView.findViewById(2131380556));
      this.playPanel = paramView.findViewById(2131371936);
      this.playBar = ((SeekBar)this.playPanel.findViewById(2131377124));
      this.playButton = ((ImageView)this.playPanel.findViewById(2131372192));
      this.progressTime = ((TextView)this.playPanel.findViewById(2131373130));
      this.totalTime = ((TextView)this.playPanel.findViewById(2131379063));
      this.playButton.setOnClickListener(this);
      this.playBar.setMax(10000);
      this.playBar.setOnSeekBarChangeListener(this);
      this.playPanel.setOnTouchListener(new VideoView.1(this));
      this.bufferPanel = ((RelativeLayout)this.mBrowserItemView.findViewById(2131364130));
      this.rateText = ((TextView)this.mBrowserItemView.findViewById(2131375985));
      this.mCenterPlayBtn = ((ImageView)this.mBrowserItemView.findViewById(2131373042));
      this.mCenterPlayBtn.bringToFront();
      this.mCenterPlayBtn.setOnClickListener(this);
      this.mErrLayout = ((LinearLayout)this.mBrowserItemView.findViewById(2131373044));
    }
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    if (this.playBar.getVisibility() == 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar is visible");
      int[] arrayOfInt = new int[2];
      this.playBar.getLocationInWindow(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      if (new Rect(i, j, this.playBar.getWidth() + i, this.playBar.getHeight() + j).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()))
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "playBar deal event");
        return true;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "recyclerView deal event");
    }
    return super.isNeedDisallowInterceptEvent(paramMotionEvent);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if (i == 2131372192)
    {
      localObject = this.videoViewClickEvent;
      if (localObject != null)
      {
        ((IVideoViewClickEvent)localObject).n();
      }
      else
      {
        localObject = this.mVideoView;
        if ((localObject != null) && (((BaseVideoView)localObject).isPlaying())) {
          pauseVideo();
        } else {
          tryPlayVideo(this.videoPresenter.getCurrentPosition(), false);
        }
      }
    }
    else if ((i != 2131373043) && (i != 2131380795))
    {
      if (i == 2131373042)
      {
        BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 2, "onItemClick, play button click.");
        localObject = this.videoViewClickEvent;
        if (localObject != null) {
          ((IVideoViewClickEvent)localObject).p();
        } else if (this.videoPresenter.getCurrentVideoData() != null) {
          tryPlayVideo(this.videoPresenter.getCurrentPosition(), false);
        }
      }
    }
    else
    {
      localObject = this.videoViewClickEvent;
      if (localObject != null) {
        ((IVideoViewClickEvent)localObject).o();
      } else if (this.itemClickEventListener != null) {
        onClickEvent();
      } else {
        this.videoPresenter.back();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BaseVideoView localBaseVideoView = this.mVideoView;
    if (localBaseVideoView != null) {
      localBaseVideoView.releasePlayer(false);
    }
  }
  
  public void onDestroyView(int paramInt, View paramView)
  {
    this.videoPresenter.mActiveThumbDrawable.remove(Integer.valueOf(paramInt));
    BaseVideoView localBaseVideoView = this.mVideoView;
    if (localBaseVideoView != null) {
      localBaseVideoView.releasePlayer(false);
    }
    super.onDestroyView(paramInt, paramView);
  }
  
  public void onItemSelected(int paramInt)
  {
    bindView(paramInt);
    Object localObject = this.videoPresenter.getItem(paramInt);
    if ((localObject != null) && ((((RichMediaBrowserInfo)localObject).baseData instanceof VideoData)))
    {
      localObject = (VideoData)((RichMediaBrowserInfo)localObject).baseData;
      this.videoPresenter.updateItemStatus(((VideoData)localObject).id, 0);
      if ((this.videoPresenter.isAutoPlay(paramInt)) && (((VideoData)localObject).videoPlayParam != null)) {
        tryPlayVideo(paramInt, true);
      } else {
        updateUI();
      }
    }
    super.onItemSelected(paramInt);
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onPause");
    pauseVideo();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = this.mVideoView;
      if (localObject != null)
      {
        int i = (int)(paramInt / 10000.0F * (float)((BaseVideoView)localObject).getVideoDurationMs());
        this.mVideoView.seekTo(i);
        this.progressTime.setText(BrowserUtils.a(i));
      }
    }
    Object localObject = this.videoViewClickEvent;
    if (localObject != null) {
      ((IVideoViewClickEvent)localObject).a(paramSeekBar, paramInt, paramBoolean);
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onResume");
    Object localObject = this.videoPresenter;
    if ((((VideoPresenter)localObject).isAutoPlay(((VideoPresenter)localObject).getCurrentPosition())) && (this.mVideoView != null))
    {
      localObject = this.videoPresenter.getCurrentVideoData();
      if ((localObject != null) && (((VideoData)localObject).status == 4)) {
        this.mVideoView.resume();
      }
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onScrollHalfScreenWidth");
    BaseVideoView localBaseVideoView = this.mVideoView;
    if ((localBaseVideoView != null) && (localBaseVideoView.mIsPlayVideo)) {
      this.mVideoView.pause();
    }
    super.onScrollHalfScreenWidth();
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onStop");
    clearTheOuchCache();
    BaseVideoView localBaseVideoView = this.mVideoView;
    if (localBaseVideoView != null) {
      localBaseVideoView.releasePlayer(true);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "onStopTrackingTouch");
    IVideoViewClickEvent localIVideoViewClickEvent = this.videoViewClickEvent;
    if (localIVideoViewClickEvent != null) {
      localIVideoViewClickEvent.a(paramSeekBar);
    }
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void pauseVideo()
  {
    BaseVideoView localBaseVideoView = this.mVideoView;
    if (localBaseVideoView != null) {
      localBaseVideoView.pause();
    }
    abandonAudioFocus();
  }
  
  public void requestAudioFocus()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Context localContext1 = this.mContext;
      Context localContext2 = this.mContext;
      ((AudioManager)localContext1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  public void setPlayPanelDecorator(boolean paramBoolean)
  {
    this.isPlayPanelDecorator = paramBoolean;
  }
  
  public void setVideoPlayCallback(VideoPlayParam paramVideoPlayParam)
  {
    paramVideoPlayParam.mCallback = new VideoView.2(this, paramVideoPlayParam);
  }
  
  public void setVideoPlayCallback(VideoPlayerCallback paramVideoPlayerCallback)
  {
    this.videoPlayerCallback = paramVideoPlayerCallback;
  }
  
  public void setVideoViewClickEvent(IVideoViewClickEvent paramIVideoViewClickEvent)
  {
    this.videoViewClickEvent = paramIVideoViewClickEvent;
  }
  
  public void showPlayPanel(boolean paramBoolean)
  {
    View localView = this.playPanel;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
  }
  
  public void updateUI()
  {
    super.updateUI();
    Object localObject1 = this.videoPresenter.getCurrentVideoData();
    if (localObject1 != null)
    {
      Object localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateUI id = ");
      localStringBuilder.append(((VideoData)localObject1).id);
      localStringBuilder.append(", status = ");
      localStringBuilder.append(((VideoData)localObject1).status);
      ((IBrowserLog)localObject2).d("VideoView", 4, localStringBuilder.toString());
      int j = ((VideoData)localObject1).status;
      int i = 8;
      long l;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              if (j != 4)
              {
                if (j != 6)
                {
                  localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append("updateUI status is error, status = ");
                  localStringBuilder.append(((VideoData)localObject1).status);
                  ((IBrowserLog)localObject2).d("VideoView", 4, localStringBuilder.toString());
                  return;
                }
                localObject2 = this.videoPresenter;
                ((VideoPresenter)localObject2).onLoadFinish(((VideoPresenter)localObject2).getSelectedIndex(), true);
                showPlayPanel(false);
                this.bufferPanel.setVisibility(8);
                this.mErrLayout.setVisibility(0);
                this.mCenterPlayBtn.setVisibility(8);
                this.playButton.setImageResource(2130846308);
                localObject2 = (TextView)this.mErrLayout.findViewById(2131366307);
                if (localObject2 != null)
                {
                  if (!TextUtils.isEmpty(((VideoData)localObject1).errorDescription)) {
                    localObject1 = ((VideoData)localObject1).errorDescription;
                  } else {
                    localObject1 = this.mContext.getString(2131720253);
                  }
                  ((TextView)localObject2).setText((CharSequence)localObject1);
                }
              }
              else
              {
                localObject1 = this.videoPresenter;
                ((VideoPresenter)localObject1).onLoadFinish(((VideoPresenter)localObject1).getSelectedIndex(), true);
                showPlayPanel(true);
                this.bufferPanel.setVisibility(8);
                this.mErrLayout.setVisibility(8);
                this.mCenterPlayBtn.setVisibility(0);
                this.playButton.setImageResource(2130846308);
              }
            }
            else
            {
              localObject1 = this.videoPresenter;
              ((VideoPresenter)localObject1).onLoadFinish(((VideoPresenter)localObject1).getSelectedIndex(), true);
              showPlayPanel(true);
              this.bufferPanel.setVisibility(8);
              this.mErrLayout.setVisibility(8);
              this.mCenterPlayBtn.setVisibility(8);
              this.playButton.setImageResource(2130846309);
              localObject1 = this.mVideoView;
              if (localObject1 != null)
              {
                l = ((BaseVideoView)localObject1).getVideoDurationMs();
                localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("videoDuration = ");
                ((StringBuilder)localObject2).append(l);
                ((IBrowserLog)localObject1).d("VideoView", 4, ((StringBuilder)localObject2).toString());
                this.totalTime.setText(BrowserUtils.a(l));
              }
            }
          }
          else
          {
            localObject1 = this.mVideoView;
            if (localObject1 != null) {
              if (((BaseVideoView)localObject1).isPlaying()) {
                this.bufferPanel.setVisibility(0);
              } else {
                this.bufferPanel.setVisibility(8);
              }
            }
            localObject1 = this.videoPresenter;
            ((VideoPresenter)localObject1).onLoadFinish(((VideoPresenter)localObject1).getSelectedIndex(), true);
            showPlayPanel(true);
            this.mCenterPlayBtn.setVisibility(8);
            this.mErrLayout.setVisibility(8);
          }
        }
        else
        {
          localObject2 = this.videoPresenter;
          ((VideoPresenter)localObject2).onLoadStart(((VideoPresenter)localObject2).getSelectedIndex(), ((VideoData)localObject1).progress);
          showPlayPanel(false);
          this.bufferPanel.setVisibility(8);
          this.mErrLayout.setVisibility(8);
          this.mCenterPlayBtn.setVisibility(8);
        }
      }
      else
      {
        localObject2 = this.videoPresenter;
        ((VideoPresenter)localObject2).onLoadFinish(((VideoPresenter)localObject2).getSelectedIndex(), true);
        showPlayPanel(false);
        this.bufferPanel.setVisibility(8);
        this.mErrLayout.setVisibility(8);
        localObject2 = this.mCenterPlayBtn;
        if (!((VideoData)localObject1).isAutoPlay) {
          i = 0;
        }
        ((ImageView)localObject2).setVisibility(i);
        this.playButton.setImageResource(2130846308);
        localObject1 = this.mVideoView;
        if (localObject1 != null)
        {
          l = ((BaseVideoView)localObject1).getVideoDurationMs();
          localObject1 = BrowserLogHelper.getInstance().getGalleryLog();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("videoDuration = ");
          ((StringBuilder)localObject2).append(l);
          ((IBrowserLog)localObject1).d("VideoView", 4, ((StringBuilder)localObject2).toString());
          this.totalTime.setText(BrowserUtils.a(l));
          this.progressTime.setText(BrowserUtils.a(0L));
        }
        this.playBar.setProgress(0);
      }
    }
  }
  
  public void updateView(int paramInt, View paramView)
  {
    Object localObject = this.videoPresenter.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
    {
      if (paramView == null) {
        return;
      }
      if ((paramView.getTag() instanceof VideoView.GalleryVideoViewHolder))
      {
        paramView = ((VideoView.GalleryVideoViewHolder)paramView.getTag()).videoView;
        if (((RichMediaBrowserInfo)localObject).baseData.getType() == 2)
        {
          localObject = (VideoData)((RichMediaBrowserInfo)localObject).baseData;
          BrowserLogHelper.getInstance().getGalleryLog().d("VideoView", 4, "updateView loadShortVideoCover");
          this.videoPresenter.loadVideoCover(this.mScreenWidthPx, this.mScreenHeightPx, paramView.getCoverImage(), paramInt);
          if (this.videoPresenter.isAutoPlay(paramInt)) {
            realPlayVideo((VideoData)localObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.video.VideoView
 * JD-Core Version:    0.7.0.1
 */