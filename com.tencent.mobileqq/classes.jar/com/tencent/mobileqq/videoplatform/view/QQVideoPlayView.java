package com.tencent.mobileqq.videoplatform.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.mobileqq.videoplatform.util.UIUtil;

public class QQVideoPlayView
  extends RelativeLayout
  implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, IBaseVideoView, VideoPlayerCallback
{
  public static final float MAX_PROGRESS = 10000.0F;
  BaseVideoView mBaseVideoView;
  public RelativeLayout mBufferPanel;
  private ImageView mCenterPlayBtn;
  private LinearLayout mErrLayout;
  private boolean mIsPlay = false;
  public SeekBar mPlayBar;
  public ImageView mPlayButton;
  public LinearLayout mPlayPanel;
  public TextView mProgressTime;
  public TextView mRateText;
  public TextView mTotalTime;
  
  public QQVideoPlayView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView)
  {
    super(paramContext);
    if (paramVideoPlayParam != null) {
      paramVideoPlayParam.mNeedPlayProgress = true;
    }
    this.mBaseVideoView = new BaseVideoView(paramContext, paramLong, paramVideoPlayParam, paramImageView, this);
    initView();
  }
  
  private void addBaseVideoView()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.mBaseVideoView.setLayoutParams(localLayoutParams);
    addView(this.mBaseVideoView);
  }
  
  private void addBuffView()
  {
    this.mBufferPanel = ((RelativeLayout)inflate(getContext(), 2131562817, null));
    new RelativeLayout.LayoutParams(-2, -2).addRule(13);
    this.mBufferPanel.setVisibility(8);
    addView(this.mBufferPanel);
    this.mRateText = ((TextView)this.mBufferPanel.findViewById(2131375207));
    this.mRateText.setVisibility(8);
  }
  
  private void addCenterPlayBtn()
  {
    this.mCenterPlayBtn = new ImageView(getContext());
    this.mCenterPlayBtn.setImageDrawable(getResources().getDrawable(2130850166));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    this.mCenterPlayBtn.setLayoutParams(localLayoutParams);
    addView(this.mCenterPlayBtn);
    this.mCenterPlayBtn.bringToFront();
    this.mCenterPlayBtn.setOnClickListener(new QQVideoPlayView.1(this));
  }
  
  private void addErrView()
  {
    this.mErrLayout = ((LinearLayout)inflate(getContext(), 2131562818, null));
    new RelativeLayout.LayoutParams(-1, -1);
    addView(this.mErrLayout);
  }
  
  private void addPlayCtlView()
  {
    this.mPlayPanel = ((LinearLayout)inflate(getContext(), 2131562819, null));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.addRule(12);
    this.mPlayPanel.setLayoutParams(localLayoutParams);
    addView(this.mPlayPanel);
    this.mPlayPanel.bringToFront();
    this.mPlayBar = ((SeekBar)this.mPlayPanel.findViewById(2131376325));
    this.mPlayButton = ((ImageView)this.mPlayPanel.findViewById(2131371461));
    this.mPlayButton.setImageResource(2130850162);
    this.mProgressTime = ((TextView)this.mPlayPanel.findViewById(2131372339));
    this.mTotalTime = ((TextView)this.mPlayPanel.findViewById(2131378220));
    this.mPlayButton.setOnClickListener(this);
    this.mPlayBar.setMax(10000);
    this.mPlayBar.setOnSeekBarChangeListener(this);
  }
  
  private String getLogTag()
  {
    return "[VideoPlatForm]QQVideoPlayView[" + this.mBaseVideoView.getLogId() + "]";
  }
  
  private void initView()
  {
    addBaseVideoView();
    addPlayCtlView();
    addBuffView();
    addErrView();
    addCenterPlayBtn();
  }
  
  public void captureCurFrame(long paramLong, int paramInt1, int paramInt2)
  {
    this.mBaseVideoView.captureCurFrame(paramLong, paramInt1, paramInt2);
  }
  
  public Drawable getCoverDrawable()
  {
    return this.mBaseVideoView.getCoverDrawable();
  }
  
  public ImageView getCoverImage()
  {
    return this.mBaseVideoView.getCoverImage();
  }
  
  public long getCurPlayingPos()
  {
    return this.mBaseVideoView.getCurPlayingPos();
  }
  
  public long getVideoDurationMs()
  {
    return this.mBaseVideoView.getVideoDurationMs();
  }
  
  public boolean isLocalPlay()
  {
    return this.mBaseVideoView.isLocalPlay();
  }
  
  public boolean isPlaying()
  {
    return this.mBaseVideoView.isPlaying();
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.mBaseVideoView.onCapFrame(paramLong, paramBoolean, paramInt1, paramInt2, paramBitmap);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131371461)
    {
      if (this.mIsPlay) {
        pause();
      }
    }
    else {
      return;
    }
    play();
  }
  
  public void onDownloadComplete(long paramLong)
  {
    this.mBaseVideoView.onDownloadComplete(paramLong);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2)
  {
    this.mBaseVideoView.onDownloadProgress(paramLong1, paramLong2);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    this.mBaseVideoView.onLoopBack(paramLong1, paramLong2);
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    String str = getContext().getString(2131721386);
    if (paramInt1 == 1) {
      str = getContext().getString(2131721385);
    }
    if (paramInt3 == 14011001) {
      str = getContext().getString(2131721387);
    }
    ThreadUtil.postOnUIThread(new QQVideoPlayView.2(this, str));
    this.mBaseVideoView.onPlayError(paramLong, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "onPlayProgress , id = " + paramLong1 + ", positionMs=" + paramLong2);
    }
    if (this.mBaseVideoView.getVideoDurationMs() > 0L)
    {
      int i = (int)(paramLong2 / this.mBaseVideoView.getVideoDurationMs() * 10000.0D);
      this.mProgressTime.setText(UIUtil.stringForTime(paramLong2));
      this.mPlayBar.setProgress(i);
    }
    this.mBaseVideoView.onPlayProgress(paramLong1, paramLong2);
  }
  
  public void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramInt = (int)(paramInt / 10000.0F * (float)this.mBaseVideoView.getVideoDurationMs());
      this.mBaseVideoView.seekTo(paramInt);
    }
  }
  
  public void onStartTrackingTouch(SeekBar paramSeekBar) {}
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "onStateChange , state = " + PlayerState.getStateStr(paramInt) + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.mBaseVideoView.onStateChange(paramLong, paramInt);
      return;
      this.mBufferPanel.setVisibility(8);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(8);
      continue;
      if (this.mBaseVideoView != null)
      {
        if (!this.mBaseVideoView.isPlaying()) {
          break label165;
        }
        this.mBufferPanel.setVisibility(0);
      }
      for (;;)
      {
        this.mErrLayout.setVisibility(8);
        break;
        label165:
        this.mBufferPanel.setVisibility(8);
      }
      this.mBufferPanel.setVisibility(8);
      this.mErrLayout.setVisibility(8);
      this.mCenterPlayBtn.setVisibility(0);
      this.mPlayButton.setImageResource(2130850162);
    }
  }
  
  public void onStopTrackingTouch(SeekBar paramSeekBar) {}
  
  public void pause()
  {
    this.mIsPlay = false;
    this.mBufferPanel.setVisibility(8);
    this.mErrLayout.setVisibility(8);
    this.mCenterPlayBtn.setVisibility(0);
    this.mPlayButton.setImageResource(2130850162);
    this.mBaseVideoView.pause();
  }
  
  public void pauseDownload()
  {
    this.mBaseVideoView.pauseDownload();
  }
  
  public void play()
  {
    this.mIsPlay = true;
    this.mErrLayout.setVisibility(8);
    this.mCenterPlayBtn.setVisibility(8);
    this.mPlayButton.setImageResource(2130850163);
    this.mBaseVideoView.play();
  }
  
  public void releasePlayer(boolean paramBoolean)
  {
    this.mBaseVideoView.releasePlayer(paramBoolean);
  }
  
  public void resume()
  {
    if (this.mIsPlay)
    {
      this.mBaseVideoView.resume();
      this.mCenterPlayBtn.setVisibility(8);
      this.mPlayButton.setImageResource(2130850163);
      return;
    }
    this.mCenterPlayBtn.setVisibility(0);
    this.mPlayButton.setImageResource(2130850162);
  }
  
  public void resumeDownload()
  {
    this.mBaseVideoView.resumeDownload();
  }
  
  public void seekTo(int paramInt)
  {
    this.mBaseVideoView.seekTo(paramInt);
  }
  
  public void setCoverDrawable(Drawable paramDrawable)
  {
    this.mBaseVideoView.setCoverDrawable(paramDrawable);
  }
  
  public void setID(long paramLong)
  {
    this.mBaseVideoView.setID(paramLong);
  }
  
  public void setVideoParam(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      paramVideoPlayParam.mNeedPlayProgress = true;
    }
    this.mBaseVideoView.setVideoParam(paramVideoPlayParam);
  }
  
  public void showCover(Drawable paramDrawable)
  {
    this.mBaseVideoView.showCover(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.view.QQVideoPlayView
 * JD-Core Version:    0.7.0.1
 */