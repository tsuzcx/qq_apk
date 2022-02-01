package com.tencent.qcircle.tavcut.timeline;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.qcircle.tavcut.R.drawable;
import com.tencent.qcircle.tavcut.player.MoviePlayer;
import com.tencent.qcircle.tavcut.session.TAVCutVideoSession;
import com.tencent.tav.coremedia.CGSize;

public class CoverSelectView
  extends FrameLayout
{
  public static final float TIMELINE_LR_PADDING = 17.0F;
  CoverPreviewBar coverPreviewBar;
  private float currCoverProgress = 0.0F;
  private long maxDurationMs = 60000L;
  private MoviePlayer player;
  private TAVCutVideoSession tavCutVideoSession;
  TimelineView timelineView;
  private CoverSelectView.UIConfigWrapper wrapper;
  
  public CoverSelectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt, CoverSelectView.UIConfigWrapper paramUIConfigWrapper)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.wrapper = paramUIConfigWrapper;
    initialize();
  }
  
  public CoverSelectView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, CoverSelectView.UIConfigWrapper paramUIConfigWrapper)
  {
    super(paramContext, paramAttributeSet);
    this.wrapper = paramUIConfigWrapper;
    initialize();
  }
  
  public CoverSelectView(@NonNull Context paramContext, CoverSelectView.UIConfigWrapper paramUIConfigWrapper)
  {
    super(paramContext);
    this.wrapper = paramUIConfigWrapper;
    initialize();
  }
  
  private void initCoverPreviewBar()
  {
    this.coverPreviewBar = new CoverPreviewBar(getContext());
    this.currCoverProgress = CoverSelectView.UIConfigWrapper.access$000(this.wrapper);
    int i = CoverSelectView.UIConfigWrapper.access$100(this.wrapper);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(CoverSelectView.UIConfigWrapper.access$200(this.wrapper), i);
    localLayoutParams.gravity = 16;
    this.coverPreviewBar.setScaleType(ImageView.ScaleType.CENTER_CROP);
    addView(this.coverPreviewBar, localLayoutParams);
    post(new CoverSelectView.1(this));
    this.coverPreviewBar.setOnSliderSlideListener(new CoverSelectView.2(this));
  }
  
  private void initTimeLineView()
  {
    if (this.wrapper == null) {
      this.wrapper = new CoverSelectView.UIConfigWrapper(getContext(), R.drawable.pic_music_default_w, R.drawable.bg_timeline_mask_gradient, R.drawable.bg_timeline_mask, R.drawable.icon_blockbuster_timeline_range_lock_left, R.drawable.icon_blockbuster_timeline_range_lock_right, R.drawable.icon_blockbuster_timeline_range_left, R.drawable.icon_blockbuster_timeline_range_right, R.drawable.duration_bg, 8);
    }
    this.timelineView = new TimelineView(getContext(), null, CoverSelectView.UIConfigWrapper.access$600(this.wrapper), CoverSelectView.UIConfigWrapper.access$700(this.wrapper), CoverSelectView.UIConfigWrapper.access$800(this.wrapper), CoverSelectView.UIConfigWrapper.access$900(this.wrapper), CoverSelectView.UIConfigWrapper.access$1000(this.wrapper), CoverSelectView.UIConfigWrapper.access$1100(this.wrapper), CoverSelectView.UIConfigWrapper.access$1200(this.wrapper));
    TimelineBuilder localTimelineBuilder = new TimelineBuilder().setMaxSelectDurationMs(this.maxDurationMs).setLockMode(true).setSliderBarMode(false).setShowMask(false).setShowDuration(false).setMaxDurationTps("已达到模板最大时长");
    this.timelineView.setTimelineBuilder(localTimelineBuilder);
    this.timelineView.setSliderFrameColor(0);
    this.timelineView.setShowIndicator(false);
    this.timelineView.setSelectAreaItemCount(CoverSelectView.UIConfigWrapper.access$1300(this.wrapper));
    this.timelineView.setDurationBgRes(CoverSelectView.UIConfigWrapper.access$1400(this.wrapper));
    this.timelineView.setRecyclerViewPadding(16, 5, 16, 5);
    this.timelineView.showAllMask(Color.parseColor("#99ffffff"));
    addView(this.timelineView);
  }
  
  private void initialize()
  {
    initTimeLineView();
    initCoverPreviewBar();
  }
  
  public void bindPlayer(MoviePlayer paramMoviePlayer)
  {
    this.player = paramMoviePlayer;
    Object localObject = this.timelineView;
    if (localObject != null) {
      ((TimelineView)localObject).bindPlayer(paramMoviePlayer);
    }
    localObject = this.coverPreviewBar;
    if (localObject != null) {
      ((CoverPreviewBar)localObject).bindPlayer(paramMoviePlayer);
    }
  }
  
  public Bitmap getCurrCoverBitmap()
  {
    Bitmap localBitmap = this.coverPreviewBar.getCurrCover();
    CGSize localCGSize = this.tavCutVideoSession.getRenderSize();
    return Bitmap.createScaledBitmap(localBitmap, (int)localCGSize.width, (int)localCGSize.height, true);
  }
  
  public float getCurrCoverProgress()
  {
    return this.currCoverProgress;
  }
  
  public void release()
  {
    TimelineView localTimelineView = this.timelineView;
    if (localTimelineView != null) {
      localTimelineView.release();
    }
  }
  
  public void setClipAndSpeed(float paramFloat, long paramLong1, long paramLong2, long paramLong3)
  {
    TimelineView localTimelineView = this.timelineView;
    if (localTimelineView != null)
    {
      localTimelineView.setSpeed(paramFloat);
      this.timelineView.setClipData(this.tavCutVideoSession.getTAVSourceForCover(), paramLong1, ((float)paramLong2 / paramFloat), ((float)paramLong3 / paramFloat));
    }
  }
  
  public void setCoverPreviewBarBg(Drawable paramDrawable)
  {
    this.coverPreviewBar.setBackgroundDrawable(paramDrawable);
  }
  
  public void setMaxDurationMs(long paramLong)
  {
    this.maxDurationMs = paramLong;
  }
  
  public void setPreviewBar(ImageView paramImageView)
  {
    CoverPreviewBar localCoverPreviewBar = this.coverPreviewBar;
    if (localCoverPreviewBar != null) {
      localCoverPreviewBar.setPreviewBarView(paramImageView);
    }
  }
  
  public void setPreviewBarElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      CoverPreviewBar localCoverPreviewBar = this.coverPreviewBar;
      if (localCoverPreviewBar != null) {
        localCoverPreviewBar.setElevation(paramFloat);
      }
    }
  }
  
  public void setTimelineBuilder(TimelineBuilder paramTimelineBuilder)
  {
    TimelineView localTimelineView = this.timelineView;
    if (localTimelineView != null) {
      localTimelineView.setTimelineBuilder(paramTimelineBuilder);
    }
  }
  
  public void setTimelineViewPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TimelineView localTimelineView = this.timelineView;
    if (localTimelineView != null)
    {
      localTimelineView.setRecyclerViewPadding(paramInt1, paramInt2, paramInt3, paramInt4);
      this.timelineView.showAllMask(Color.parseColor("#99ffffff"));
      this.coverPreviewBar.initCoverSlider(paramInt1, paramInt3, this.timelineView.getWidth() - paramInt1 - paramInt3, this.currCoverProgress);
    }
  }
  
  public void updateTavVideoSession(TAVCutVideoSession paramTAVCutVideoSession)
  {
    if (paramTAVCutVideoSession != null) {
      this.tavCutVideoSession = paramTAVCutVideoSession;
    }
  }
  
  public void updateTimeRange(long paramLong1, long paramLong2)
  {
    TimelineView localTimelineView = this.timelineView;
    if (localTimelineView != null) {
      localTimelineView.updateTimeRange(paramLong1, paramLong2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.timeline.CoverSelectView
 * JD-Core Version:    0.7.0.1
 */