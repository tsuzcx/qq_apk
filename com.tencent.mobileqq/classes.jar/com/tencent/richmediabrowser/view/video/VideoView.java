package com.tencent.richmediabrowser.view.video;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.constant.Constants;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.model.video.VideoData;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.utils.FileUtils;
import com.tencent.richmediabrowser.utils.VersionUtils;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import java.util.concurrent.ConcurrentHashMap;

public class VideoView
  extends BrowserBaseView
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener
{
  public static final String KEY_NEED_REPORT_FORWARD_SHORT_VIDEO = "NeedReportForwardShortVideo";
  public static final String LONG_VIDEO_TVABLE = "0X8009EF2";
  public static final float MAX_PROGRESS = 10000.0F;
  static final int PROGRESS_SEEK_MAX = 10000;
  public static final String SHORT_VIDEO_TVABLE = "0X8009EF1";
  private static final String TAG = "AIOVideoView";
  public RelativeLayout bufferPanel;
  public ImageView closeBtn;
  public ImageButton closeVideoBtn;
  public RelativeLayout contentView;
  private boolean isPlay = false;
  public SeekBar loadBar;
  public RelativeLayout loadPanel;
  public TextView loadProTxt;
  private ImageView mCenterPlayBtn;
  private LinearLayout mErrLayout;
  public BaseVideoView mVideoView;
  public SeekBar playBar;
  public ImageView playButton;
  public View playPanel;
  public TextView progressTime;
  public TextView rateText;
  public TextView totalTime;
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
  
  private View getGalleryItemView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
    paramView = this.videoPresenter.getItem(paramInt);
    if ((paramView != null) && (paramView.baseData != null) && (paramView.baseData.getType() == 2))
    {
      paramView = (VideoData)paramView.baseData;
      paramView = new VideoView.GalleryVideoViewHolder(this);
      paramView.videoView = null;
      this.mBrowserItemView.setTag(paramView);
      this.mVideoView = null;
      return this.mBrowserItemView;
    }
    return null;
  }
  
  private void pauseVideo()
  {
    if (this.mVideoView != null) {
      this.mVideoView.pause();
    }
    abandonAudioFocus();
    updateStatus(6);
    this.videoPresenter.onLoadFinish(this.videoPresenter.getSelectedIndex(), true);
    showPlayPanel(true);
    showLoadPanel(false);
    this.bufferPanel.setVisibility(8);
    this.mErrLayout.setVisibility(8);
    this.mCenterPlayBtn.setVisibility(0);
    this.playButton.setImageResource(2130846131);
  }
  
  private void realPlayVideo(VideoData paramVideoData) {}
  
  private void requestAudioFocus()
  {
    if ((VersionUtils.isrFroyo()) && (this.mContext != null))
    {
      Activity localActivity1 = this.mContext;
      Activity localActivity2 = this.mContext;
      ((AudioManager)localActivity1.getSystemService("audio")).requestAudioFocus(null, 3, 2);
    }
  }
  
  private void tryPlayVideo(int paramInt)
  {
    this.isPlay = true;
    showPlayPanel(true);
    this.mErrLayout.setVisibility(8);
    this.mCenterPlayBtn.setVisibility(8);
    this.playButton.setImageResource(2130846132);
    Object localObject = this.videoPresenter.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null) && (((RichMediaBrowserInfo)localObject).baseData.getType() == 2))
    {
      localObject = (VideoData)((RichMediaBrowserInfo)localObject).baseData;
      if (!TextUtils.isEmpty(((VideoData)localObject).url)) {
        break label135;
      }
      this.videoPresenter.handleUnDownloadVideo((VideoData)localObject);
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "ShortVideoData url is = " + ((VideoData)localObject).url);
    }
    for (;;)
    {
      updateUI();
      return;
      label135:
      realPlayVideo((VideoData)localObject);
      this.videoPresenter.updateItemStatus(((VideoData)localObject).id, 5);
    }
  }
  
  private void updateStatus(int paramInt)
  {
    VideoData localVideoData = getCurrentVideoData();
    if (localVideoData != null) {
      this.videoPresenter.updateItemStatus(localVideoData.id, paramInt);
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
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 2, "getView, position = " + paramInt);
    initContentView();
    return getGalleryItemView(paramInt, paramView, paramViewGroup);
  }
  
  public boolean handleClickPlayBtn(MotionEvent paramMotionEvent)
  {
    if (this.mCenterPlayBtn == null) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick, mCenterPlayBtn is null.");
    }
    do
    {
      return false;
      if (this.mCenterPlayBtn.getVisibility() != 0) {
        break;
      }
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick, event.getRawX() = " + paramMotionEvent.getRawX() + " , event.getRawY() = " + paramMotionEvent.getRawY() + " , mCenterPlayBtn left = " + this.mCenterPlayBtn.getLeft() + " , top = " + this.mCenterPlayBtn.getTop() + " , right = " + this.mCenterPlayBtn.getRight() + ", bottom = " + this.mCenterPlayBtn.getBottom());
    } while (!new Rect(this.mCenterPlayBtn.getLeft(), this.mCenterPlayBtn.getTop(), this.mCenterPlayBtn.getRight(), this.mCenterPlayBtn.getBottom()).contains((int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY()));
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick, playbtn contains event");
    return true;
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick, mCenterPlayBtn is not visible.");
    return false;
  }
  
  public void initContentView()
  {
    if (this.contentView == null)
    {
      this.contentView = ((RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559188, null));
      RelativeLayout localRelativeLayout = (RelativeLayout)this.contentView.findViewById(2131372145);
      this.playPanel = localRelativeLayout.findViewById(2131371891);
      this.playBar = ((SeekBar)this.playPanel.findViewById(2131377245));
      this.playButton = ((ImageView)this.playPanel.findViewById(2131372146));
      this.progressTime = ((TextView)this.playPanel.findViewById(2131373046));
      this.totalTime = ((TextView)this.playPanel.findViewById(2131379238));
      this.playButton.setOnClickListener(this);
      this.playBar.setMax(10000);
      this.playBar.setOnSeekBarChangeListener(this);
      this.loadPanel = ((RelativeLayout)localRelativeLayout.findViewById(2131380467));
      this.loadBar = ((SeekBar)this.loadPanel.findViewById(2131380469));
      this.loadBar.setMax(10000);
      this.loadProTxt = ((TextView)this.loadPanel.findViewById(2131380468));
      this.closeBtn = ((ImageView)this.loadPanel.findViewById(2131364585));
      this.closeBtn.setOnClickListener(this);
      this.bufferPanel = ((RelativeLayout)this.contentView.findViewById(2131364011));
      this.rateText = ((TextView)this.contentView.findViewById(2131376077));
      this.closeVideoBtn = ((ImageButton)this.contentView.findViewById(2131374360));
      this.closeVideoBtn.setOnClickListener(this);
    }
    if (!this.isInExitAnim) {
      showContentView(true);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131372146) {
      if (this.isPlay)
      {
        pauseVideo();
        this.isPlay = false;
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      tryPlayVideo(this.videoPresenter.getCurrentPosition());
      continue;
      if (i == 2131364585)
      {
        Object localObject = this.videoPresenter.getSelectedItem();
        if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
        {
          localObject = (VideoData)((RichMediaBrowserInfo)localObject).baseData;
          this.videoPresenter.updateItemStatus(((VideoData)localObject).id, 0);
          updateUI();
        }
      }
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    super.onCreate(paramViewGroup);
  }
  
  public View onCreateView(int paramInt, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(false);
    }
    this.isPlay = false;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    this.videoPresenter.mActiveThumbDrawable.remove(Integer.valueOf(paramInt));
  }
  
  public void onEnterAnimationEnd()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onEnterAnimationEnd");
    super.onEnterAnimationEnd();
    showContentView(true);
    updateUI();
  }
  
  public void onEnterAnimationStart()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onEnterAnimationStart");
    showContentView(false);
  }
  
  public void onItemClick(int paramInt, long paramLong)
  {
    RichMediaBrowserInfo localRichMediaBrowserInfo = this.videoPresenter.getItem(paramInt);
    if ((localRichMediaBrowserInfo == null) || (localRichMediaBrowserInfo.baseData == null)) {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemClick data is null，position = " + paramInt);
    }
  }
  
  public void onItemSelected(int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onItemSelected, position = " + paramInt + " ,  , basePresenter.getCurrentPosition() = " + this.basePresenter.getCurrentPosition());
    super.onItemSelected(paramInt);
    if ((this.videoPresenter != null) && (this.videoPresenter.isAutoPlay(paramInt))) {
      tryPlayVideo(paramInt);
    }
    for (;;)
    {
      this.progressTime.setText(FileUtils.stringForTime(0L));
      this.playBar.setProgress(0);
      return;
      showPlayPanel(false);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(0);
      this.playButton.setImageResource(2130846131);
    }
  }
  
  public void onPause()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPause");
    pauseVideo();
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.mVideoView != null))
    {
      paramInt = (int)(paramInt / 10000.0F * (float)this.mVideoView.getVideoDurationMs());
      this.mVideoView.seekTo(paramInt);
      this.progressTime.setText(FileUtils.stringForTime(paramInt));
    }
  }
  
  public void onResume()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onResume");
    if ((this.isPlay) && (this.mVideoView != null))
    {
      this.mVideoView.resume();
      showPlayPanel(true);
      this.mCenterPlayBtn.setVisibility(8);
      this.playButton.setImageResource(2130846132);
      return;
    }
    showPlayPanel(false);
    this.mCenterPlayBtn.setVisibility(0);
    this.playButton.setImageResource(2130846131);
  }
  
  public void onScrollHalfScreenWidth()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onScrollHalfScreenWidth");
    super.onScrollHalfScreenWidth();
    if ((this.mVideoView != null) && (this.mVideoView.mIsPlayVideo)) {
      this.mVideoView.pause();
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStop()
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStop");
    clearShortVideo();
    if (this.mVideoView != null) {
      this.mVideoView.releasePlayer(true);
    }
    this.isPlay = false;
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onStopTrackingTouch");
    EventCollector.getInstance().onStopTrackingTouch(paramSeekBar);
  }
  
  public void onViewDetached(int paramInt, View paramView, RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramView != null) && ((paramView.getTag() instanceof VideoView.GalleryVideoViewHolder)))
    {
      paramView = ((VideoView.GalleryVideoViewHolder)paramView.getTag()).videoView;
      paramRichMediaBrowserInfo = (URLDrawable)this.videoPresenter.mActiveDrawable.get(Integer.valueOf(paramInt));
      if (paramRichMediaBrowserInfo != null)
      {
        paramView.setCoverDrawable(paramRichMediaBrowserInfo);
        BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onViewDetached(): Use thumb cache replace video.");
      }
    }
    else
    {
      return;
    }
    paramView.setCoverDrawable(Constants.TRANSPARENT);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onViewDetached(): No thumb, use TRANSPARENT");
  }
  
  public void showDialogSafe(Dialog paramDialog)
  {
    if ((paramDialog != null) && (this.mContext != null) && (!this.mContext.isFinishing())) {}
    try
    {
      paramDialog.show();
      return;
    }
    catch (Throwable paramDialog)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "showDialogSafe exception: " + paramDialog.getMessage());
    }
  }
  
  public void showLoadPanel(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.loadPanel != null)
    {
      localRelativeLayout = this.loadPanel;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void showPlayPanel(boolean paramBoolean)
  {
    View localView;
    if (this.playPanel != null)
    {
      localView = this.playPanel;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void updateUI()
  {
    int i = 8;
    super.updateUI();
    VideoData localVideoData = getCurrentVideoData();
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI id = " + localVideoData.id + ", status = " + localVideoData.status);
    switch (localVideoData.status)
    {
    default: 
      BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "updateUI status is error, status = " + localVideoData.status);
      return;
    case 4: 
      this.videoPresenter.onLoadStart(this.videoPresenter.getSelectedIndex(), localVideoData.progress);
      showLoadPanel(false);
      this.bufferPanel.setVisibility(8);
      showPlayPanel(false);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(8);
      return;
    }
    this.videoPresenter.onLoadFinish(this.videoPresenter.getSelectedIndex(), true);
    showPlayPanel(false);
    showLoadPanel(false);
    this.bufferPanel.setVisibility(8);
    this.mErrLayout.setVisibility(8);
    ImageView localImageView = this.mCenterPlayBtn;
    if (localVideoData.isAutoPlay) {}
    for (;;)
    {
      localImageView.setVisibility(i);
      this.playButton.setImageResource(2130846131);
      this.progressTime.setText(FileUtils.stringForTime(0L));
      this.playBar.setProgress(0);
      return;
      i = 0;
    }
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean)
  {
    super.updateView(paramInt, paramString1, paramString2, paramView, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.video.VideoView
 * JD-Core Version:    0.7.0.1
 */