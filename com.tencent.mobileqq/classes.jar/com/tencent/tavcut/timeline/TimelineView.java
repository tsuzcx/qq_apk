package com.tencent.tavcut.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.coremedia.CMTimeRange;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.cover.CoverProvider;
import com.tencent.tavcut.player.MoviePlayer;
import com.tencent.tavcut.util.FloatUtils;
import com.tencent.tavcut.util.Logger;
import com.tencent.tavcut.util.Util;
import com.tencent.tavkit.composition.TAVSource;
import com.tencent.weseevideo.model.MediaModel;

public class TimelineView
  extends FrameLayout
  implements IPlayer.PlayerListener
{
  private static final int DEFAULT_MAX_SELECT_DURATION = 60000;
  private static final int DEFAULT_MIN_SELECT_DURATION = 2000;
  private static final int SELECT_AREA_ITEM_COUNT = 8;
  private static final String TAG = "TimelineView";
  private View allMaskView;
  boolean hasEditStartAndEnd = false;
  private RecyclerView.Adapter mAdapter;
  private CoverProvider mCoverProvider;
  private Drawable mDefaultImgBg;
  private long mEndDurationMs;
  private Drawable mGradientMask;
  private int mHeadItemWidth;
  private float mIndicatorProgress = 0.0F;
  private int mItemCount;
  private long mItemDurationMs;
  private int mItemHeight;
  private int mItemWidth;
  private int mLastItemWidth;
  private LinearLayoutManager mLayoutManager;
  private ImageView mLeftGradientMaskIv;
  private int mLeftGradientMaskMargin;
  private int mLeftGradientMaskWidth;
  private ImageView mLeftMaskIv;
  private int mLeftMaskMargin;
  private int mLeftMaskWidth;
  private int mLeftSliderOffset;
  private Drawable mLeftTimelineMask;
  private boolean mLockMode = false;
  private String mMaxDurationTps;
  private long mMaxSelectDurationMs;
  private MediaModel mMediaModel;
  private long mMinSelectDurationMs;
  private long mOriginMaxSelectDurationMs;
  private int mPaddingBottom;
  private int mPaddingLeft;
  private int mPaddingRight;
  private int mPaddingTop;
  private long mPlayDurationMs;
  private MoviePlayer mPlayer;
  private RecyclerView mRecycleView;
  private ImageView mRightMaskIv;
  private int mRightMaskMargin;
  private int mRightMaskWidth;
  private int mRightSliderOffset;
  private Drawable mRightTimelineMask;
  private boolean mScrollEnable;
  private float mSelectAreaLeft;
  private float mSelectAreaRight;
  private long mSelectDurationMs;
  private boolean mShowDuration = true;
  private boolean mShowMask = true;
  private boolean mSliderBarMode = true;
  private float mSliderBarWidth;
  private SliderChangeListener mSliderChangeListener;
  private SliderView mSliderView;
  private float mSpeed = 1.0F;
  private long mSpeedSelectDurationMs;
  private long mSpeedTotalDurationMs;
  private long mStartDurationMs;
  private int mTailItemWidth;
  private TAVSource mTavSource;
  private long mTotalDurationMs;
  private int selectAreaItemCount = 8;
  
  public TimelineView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    initView();
  }
  
  public TimelineView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    super(paramContext, paramAttributeSet, 0);
    this.mDefaultImgBg = paramContext.getResources().getDrawable(paramInt1);
    this.mGradientMask = paramContext.getResources().getDrawable(paramInt2);
    this.mLeftTimelineMask = paramContext.getResources().getDrawable(paramInt3);
    this.mRightTimelineMask = paramContext.getResources().getDrawable(paramInt3);
    initView(paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  private void checkCanAdjust()
  {
    if (this.mSliderView != null)
    {
      if (this.mSelectDurationMs <= this.mMinSelectDurationMs) {
        this.mSliderView.setCanAdjust(false);
      }
    }
    else {
      return;
    }
    this.mSliderView.setCanAdjust(true);
  }
  
  private void correctParams()
  {
    int i = this.mSliderView.getSelectAreaWidth() - this.mItemWidth * this.selectAreaItemCount;
    if (i == 0) {
      return;
    }
    this.mRightSliderOffset = (i + this.mRightSliderOffset);
    initSliderParams();
    initHeadAndTailParams();
  }
  
  private void getCoverInsideScreen()
  {
    int j = this.mLayoutManager.findFirstVisibleItemPosition();
    int i = j;
    if (j > 0) {
      i = j - 1;
    }
    int k = this.mLayoutManager.findLastVisibleItemPosition();
    j = k;
    if (k == this.mAdapter.getItemCount() - 1) {
      j = k - 2;
    }
    if ((i < 0) || (j < 0)) {}
    while (this.mCoverProvider == null) {
      return;
    }
    this.mCoverProvider.getCoverByIndexRange(i, j);
    Logger.d("TimelineView", "getCoverInsideScreen: startIndex is " + i);
    Logger.d("TimelineView", "getCoverInsideScreen: endIndex is " + j);
  }
  
  private void handleSliderBarMove(float paramFloat1, float paramFloat2)
  {
    this.mSelectAreaLeft = paramFloat1;
    this.mSelectAreaRight = paramFloat2;
    updateSelectDuration();
    updateStartDuration();
    updateEndDuration();
    setSliderSelectDuration();
    updateMask();
  }
  
  private void initAdapter()
  {
    if (this.mAdapter != null)
    {
      int i = 1;
      while (i < this.mAdapter.getItemCount() - 1)
      {
        ImageView localImageView = (ImageView)this.mLayoutManager.findViewByPosition(i);
        if (localImageView != null)
        {
          localImageView.setImageBitmap(null);
          localImageView.setImageDrawable(null);
          localImageView.setImageDrawable(this.mDefaultImgBg);
        }
        i += 1;
      }
      this.mAdapter = null;
      this.mRecycleView.setAdapter(null);
      if (this.mCoverProvider != null)
      {
        this.mCoverProvider.release();
        this.mCoverProvider.setCoverListener(null);
        this.mCoverProvider = null;
      }
    }
    this.mAdapter = new TimelineView.4(this);
    this.mRecycleView.setAdapter(this.mAdapter);
    scrollToStart();
  }
  
  private void initConfig()
  {
    this.mLeftSliderOffset = ((int)Util.dp2px(getContext(), 16.0F));
    this.mRightSliderOffset = ((int)Util.dp2px(getContext(), 16.0F));
    this.mPaddingLeft = ((int)Util.dp2px(getContext(), 17.0F));
    this.mPaddingTop = ((int)Util.dp2px(getContext(), 12.5F));
    this.mPaddingRight = ((int)Util.dp2px(getContext(), 17.0F));
    this.mPaddingBottom = ((int)Util.dp2px(getContext(), 12.5F));
    this.mLeftGradientMaskWidth = this.mLeftSliderOffset;
    this.mRightMaskWidth = this.mRightSliderOffset;
    this.mSliderBarWidth = ((int)Util.dp2px(getContext(), 17.0F));
  }
  
  private void initHeadAndTailParams()
  {
    int j = 0;
    if (this.mSliderBarMode) {}
    for (int i = (int)(this.mLeftSliderOffset + this.mSliderBarWidth);; i = 0)
    {
      this.mHeadItemWidth = i;
      i = j;
      if (this.mSliderBarMode) {
        i = (int)(this.mRightSliderOffset + this.mSliderBarWidth);
      }
      this.mTailItemWidth = i;
      return;
    }
  }
  
  private void initItemParams()
  {
    this.mItemWidth = (this.mSliderView.getSelectAreaWidth() / this.selectAreaItemCount);
    this.mItemHeight = (getMeasuredHeight() - this.mPaddingTop - this.mPaddingBottom);
    Logger.d("TimelineView", "setClipData: mSliderView.getSelectAreaWidth() " + this.mSliderView.getSelectAreaWidth());
    Logger.d("TimelineView", "setClipData: mItemWidth is " + this.mItemWidth);
    Logger.d("TimelineView", "setClipData: mItemHeight is " + this.mItemHeight);
    if ((this.mLockMode) || (!this.mSliderBarMode))
    {
      this.mItemDurationMs = (this.mSelectDurationMs / this.selectAreaItemCount);
      Logger.d("TimelineView", "setClipData: mItemDurationMs is  " + this.mItemDurationMs);
      Logger.d("TimelineView", "setClipData: mSelectDurationMs is " + this.mSelectDurationMs);
      if (this.mItemDurationMs != 0L)
      {
        this.mItemCount = ((int)(getCurrentTotalDurationMs() / this.mItemDurationMs));
        long l = getCurrentTotalDurationMs() % this.mItemDurationMs;
        if (l == 0L) {
          break label384;
        }
        this.mLastItemWidth = ((int)((float)l * 1.0F * this.selectAreaItemCount * this.mItemWidth / (float)this.mMaxSelectDurationMs));
        if (this.mLastItemWidth != 0) {
          break label371;
        }
        this.mLastItemWidth = this.mItemWidth;
      }
    }
    for (;;)
    {
      Logger.d("TimelineView", "setClipData: mItemCount is " + this.mItemCount);
      initAdapter();
      initProvider(this.mTavSource);
      post(new TimelineView.3(this));
      return;
      this.mMaxSelectDurationMs = Math.min(60000L, getCurrentTotalDurationMs());
      this.mItemDurationMs = (this.mMaxSelectDurationMs / this.selectAreaItemCount);
      break;
      label371:
      this.mItemCount += 1;
      continue;
      label384:
      this.mLastItemWidth = this.mItemWidth;
    }
  }
  
  private void initMask()
  {
    this.mLeftGradientMaskIv = new ImageView(getContext());
    this.mLeftMaskIv = new ImageView(getContext());
    this.mRightMaskIv = new ImageView(getContext());
    initMaskParams();
    this.mLeftGradientMaskIv.setImageDrawable(this.mGradientMask);
    this.mLeftGradientMaskIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    this.mLeftGradientMaskIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mLeftGradientMaskIv);
    this.mLeftMaskIv.setImageDrawable(this.mLeftTimelineMask);
    this.mLeftMaskIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    this.mLeftMaskIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mLeftMaskIv);
    this.mRightMaskIv.setImageDrawable(this.mRightTimelineMask);
    this.mRightMaskIv.setPadding(0, this.mPaddingTop, 0, this.mPaddingBottom);
    this.mRightMaskIv.setScaleType(ImageView.ScaleType.FIT_XY);
    addView(this.mRightMaskIv);
  }
  
  private void initMaskParams()
  {
    FrameLayout.LayoutParams localLayoutParams2;
    FrameLayout.LayoutParams localLayoutParams1;
    if (this.mLeftGradientMaskIv != null)
    {
      localLayoutParams2 = (FrameLayout.LayoutParams)this.mLeftGradientMaskIv.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(this.mLeftGradientMaskWidth, -1, 8388627);
      }
      localLayoutParams1.width = this.mLeftGradientMaskWidth;
      localLayoutParams1.leftMargin = this.mLeftGradientMaskMargin;
      this.mLeftGradientMaskIv.setLayoutParams(localLayoutParams1);
    }
    if (this.mLeftMaskIv != null)
    {
      localLayoutParams2 = (FrameLayout.LayoutParams)this.mLeftMaskIv.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(this.mLeftMaskWidth, -1, 8388627);
      }
      localLayoutParams1.width = this.mLeftMaskWidth;
      localLayoutParams1.leftMargin = this.mLeftMaskMargin;
      this.mLeftMaskIv.setLayoutParams(localLayoutParams1);
    }
    if (this.mRightMaskIv != null)
    {
      localLayoutParams2 = (FrameLayout.LayoutParams)this.mRightMaskIv.getLayoutParams();
      localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(this.mRightMaskWidth, -1, 8388629);
      }
      localLayoutParams1.width = this.mRightMaskWidth;
      localLayoutParams1.rightMargin = this.mRightMaskMargin;
      this.mRightMaskIv.setLayoutParams(localLayoutParams1);
    }
  }
  
  private void initProvider(TAVSource paramTAVSource)
  {
    this.mCoverProvider = new CoverProvider();
    this.mCoverProvider.setCoverListener(new TimelineView.5(this));
    this.mCoverProvider.init(paramTAVSource, this.mItemDurationMs, this.mItemCount, this.mItemWidth, this.mItemHeight);
    getCoverInsideScreen();
  }
  
  private void initRecycleView()
  {
    this.mLayoutManager = new LinearLayoutManager(getContext(), 0, false);
    this.mRecycleView = new RecyclerView(getContext());
    initRecycleViewParams();
    this.mRecycleView.setOverScrollMode(2);
    this.mRecycleView.setLayoutManager(this.mLayoutManager);
    this.mRecycleView.setItemViewCacheSize(0);
    this.mRecycleView.setItemAnimator(null);
    this.mRecycleView.setHasFixedSize(true);
    this.mRecycleView.addOnScrollListener(new TimelineView.1(this));
    addView(this.mRecycleView);
  }
  
  private void initRecycleViewParams()
  {
    int j = 0;
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mRecycleView.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1, 16);
    }
    this.mRecycleView.setLayoutParams(localLayoutParams1);
    int i;
    if (this.mSliderBarMode)
    {
      i = 0;
      if (!this.mSliderBarMode) {
        break label84;
      }
    }
    for (;;)
    {
      this.mRecycleView.setPadding(i, this.mPaddingTop, j, this.mPaddingBottom);
      return;
      i = this.mPaddingLeft;
      break;
      label84:
      j = this.mPaddingRight;
    }
  }
  
  private void initSlider()
  {
    initSliderParams();
    this.mSliderView.setSliderChangeListener(new TimelineView.2(this));
    addView(this.mSliderView);
  }
  
  private void initSliderParams()
  {
    int k = 0;
    int i;
    if (this.mSliderView != null)
    {
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mSliderView.getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
      }
      if (!this.mSliderBarMode) {
        break label128;
      }
      i = this.mLeftSliderOffset;
      if (!this.mSliderBarMode) {
        break label133;
      }
      j = this.mRightSliderOffset;
      label65:
      localLayoutParams1.leftMargin = i;
      localLayoutParams1.rightMargin = j;
      this.mSliderView.setLayoutParams(localLayoutParams1);
      if (!this.mSliderBarMode) {
        break label138;
      }
      i = 0;
      label95:
      if (!this.mSliderBarMode) {
        break label146;
      }
    }
    label128:
    label133:
    label138:
    label146:
    for (int j = k;; j = this.mPaddingRight)
    {
      this.mSliderView.setPadding(i, this.mSliderView.getPaddingTop(), j, this.mSliderView.getPaddingBottom());
      return;
      i = 0;
      break;
      j = 0;
      break label65;
      i = this.mPaddingLeft;
      break label95;
    }
  }
  
  private void initView()
  {
    initConfig();
    initRecycleView();
    initMask();
    this.mSliderView = new SliderView(getContext());
    initSlider();
  }
  
  private void initView(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    initConfig();
    initRecycleView();
    initMask();
    this.mSliderView = new SliderView(getContext(), paramInt1, paramInt2, paramInt3, paramInt4);
    initSlider();
  }
  
  private void notifyIndicatorMove(float paramFloat)
  {
    this.mIndicatorProgress = paramFloat;
    this.mPlayDurationMs = (((float)this.mSelectDurationMs * paramFloat + (float)this.mStartDurationMs));
    syncPlayerTimeWithIndicatorPosition();
    Logger.d("TimelineView", "notifyIndicatorMove: playDurationMs is " + this.mPlayDurationMs);
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onIndicatorMove(this.mPlayDurationMs);
    }
  }
  
  private void notifyIndicatorPress()
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onIndicatorPress();
    }
  }
  
  private void notifyIndicatorRelease()
  {
    Logger.d("TimelineView", "notifyIndicator Release");
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onIndicatorRelease();
    }
  }
  
  private void notifySelectionChange(boolean paramBoolean)
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onSelectionChange(this.mStartDurationMs, this.mEndDurationMs, paramBoolean);
    }
  }
  
  private void notifySliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onSliderBarMove(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  private void notifySliderBarRelease(boolean paramBoolean)
  {
    if (this.mSliderChangeListener != null) {
      this.mSliderChangeListener.onSliderBarRelease(paramBoolean);
    }
  }
  
  private void scrollToStart()
  {
    if (getCurrentTotalDurationMs() == 0L) {
      return;
    }
    float f = 1.0F * this.mItemCount * (float)this.mStartDurationMs / (float)getCurrentTotalDurationMs();
    Log.d("lingeng", "scrollToStart:  startIndex = " + f);
    int i = (int)(this.mItemWidth * f);
    this.mRecycleView.addOnScrollListener(new TimelineView.7(this));
    boolean bool1 = this.mRecycleView.canScrollHorizontally(1);
    boolean bool2 = this.mRecycleView.canScrollHorizontally(-1);
    Log.d("lingeng_ui", "canScrollRight: " + bool1 + " canScrollLeft:" + bool2);
    this.mLayoutManager.scrollToPositionWithOffset((int)f, 0);
  }
  
  private void setSliderBarPosition()
  {
    if (this.mMaxSelectDurationMs == this.mSelectDurationMs)
    {
      this.mSelectAreaLeft = this.mSliderBarWidth;
      this.mSelectAreaRight = (getWidth() - this.mLeftSliderOffset - this.mRightSliderOffset - this.mSliderBarWidth);
      if (this.mSliderView != null) {
        this.mSliderView.setSliderBarPosition(this.mSelectAreaLeft - this.mSliderBarWidth, this.mSelectAreaRight);
      }
      return;
    }
    Log.d("TimelineView", "setSliderBarPosition: mSliderView.getLeft() = " + this.mSliderView.getLeft());
    Log.d("TimelineView", "setSliderBarPosition: mSliderView.getWidth() = " + this.mSliderView.getWidth());
    int j = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
    View localView = this.mLayoutManager.findViewByPosition(j);
    if (j < 0) {
      this.mSelectAreaLeft = ((float)this.mStartDurationMs * 1.0F * this.mItemWidth / (this.selectAreaItemCount * 1.0F / (float)this.mMaxSelectDurationMs) + this.mSliderBarWidth);
    }
    int i = 0;
    if (localView != null) {
      i = localView.getLeft();
    }
    if (j == 0) {
      this.mSelectAreaLeft = ((float)this.mStartDurationMs * 1.0F * this.mItemWidth * this.selectAreaItemCount / (float)this.mMaxSelectDurationMs + this.mSliderBarWidth);
    }
    for (;;)
    {
      this.mSelectAreaRight = (this.mSelectAreaLeft + (float)this.mSelectDurationMs * 1.0F * this.mItemWidth * this.selectAreaItemCount / (float)this.mMaxSelectDurationMs);
      float f = (float)this.mSelectDurationMs * 1.0F * this.mItemWidth * this.selectAreaItemCount / (float)this.mMaxSelectDurationMs;
      this.mSelectAreaLeft = (this.mSelectAreaRight - f);
      this.mSelectAreaLeft = Math.max(this.mSelectAreaLeft, this.mSliderBarWidth);
      this.mSelectAreaRight = Math.min(this.mSelectAreaRight, getWidth() - this.mLeftSliderOffset - this.mRightSliderOffset - this.mSliderBarWidth);
      if (this.mSliderView == null) {
        break;
      }
      this.mSliderView.setSliderBarPosition(this.mSelectAreaLeft - this.mSliderBarWidth, this.mSelectAreaRight);
      return;
      if (j == 1)
      {
        f = (float)this.mStartDurationMs * 1.0F * this.mItemWidth * this.selectAreaItemCount / (float)this.mMaxSelectDurationMs;
        this.mSelectAreaLeft = (i + f - this.mLeftSliderOffset);
      }
      else if (j > 0)
      {
        this.mSelectAreaLeft = (((float)this.mStartDurationMs - ((j - 1) * this.mItemWidth - i) * 1.0F * (float)this.mItemDurationMs / this.mItemWidth) * 1.0F * this.mItemWidth / (float)this.mItemDurationMs - this.mLeftSliderOffset);
      }
    }
  }
  
  private void setSliderConfig()
  {
    setSliderMinSelectionWidth();
    setSliderMaxSelectionWidth();
    setSliderMaxSelectDuration();
    setSliderTotalDuration();
    setSliderSelectDuration();
  }
  
  private void setSliderMaxSelectDuration()
  {
    if (this.mSliderView != null) {
      this.mSliderView.setMaxSelectDuration(this.mMaxSelectDurationMs);
    }
  }
  
  private void setSliderMaxSelectionWidth()
  {
    if (this.mSliderView == null) {}
    while ((this.mLockMode) || (!this.mSliderBarMode)) {
      return;
    }
    int i = this.mItemWidth;
    int j = this.selectAreaItemCount;
    this.mSliderView.setMaxSelectAreaWidth(i * j);
  }
  
  private void setSliderMinSelectionWidth()
  {
    if (this.mSliderView == null) {}
    while ((this.mLockMode) || (!this.mSliderBarMode)) {
      return;
    }
    int i = (int)(this.mSpeed * (float)this.mMinSelectDurationMs * this.mItemWidth * this.selectAreaItemCount / (float)this.mOriginMaxSelectDurationMs);
    this.mSliderView.setMinSelectAreaWidth(i);
  }
  
  private void setSliderSelectDuration()
  {
    if (this.mSliderView != null) {
      this.mSliderView.setSelectDuration(Long.valueOf(this.mSelectDurationMs));
    }
  }
  
  private void setSliderTotalDuration()
  {
    if (this.mSliderView != null) {
      this.mSliderView.setTotalDurationMs(getCurrentTotalDurationMs());
    }
  }
  
  private boolean shouldSyncIndicatorPositionWithPlayerTime()
  {
    if (this.mSliderView.isDragging()) {}
    while ((this.mSliderView.isIndicatorMoving()) || (this.mPlayer.getCurrentStatus() == IPlayer.PlayerStatus.PAUSED)) {
      return false;
    }
    return true;
  }
  
  private void syncIndicatorPositionWithPlayerTime()
  {
    if (this.mPlayer == null) {
      return;
    }
    setPlayPosition(this.mPlayer.getPosition().getTimeUs() / 1000L);
  }
  
  private void syncPlayerTimeWithIndicatorPosition()
  {
    if (this.mPlayer == null)
    {
      Log.e("TimelineView", "syncPlayerTimeWithIndicatorPosition: mPlayer is null!");
      return;
    }
    long l2 = this.mPlayer.getPlayRange().getDurationUs();
    long l1 = this.mPlayer.getPlayRange().getStartUs();
    float f = this.mSliderView.getIndicatorProgress();
    l2 = ((float)l2 * f);
    this.mPlayer.seekToTime(CMTime.convertTimeScale(CMTime.fromUs(l2 + l1), 1000));
  }
  
  private void updateClipData()
  {
    if (getCurrentTotalDurationMs() != this.mMaxSelectDurationMs) {}
    for (boolean bool = true;; bool = false)
    {
      this.mScrollEnable = bool;
      post(new TimelineView.8(this));
      return;
    }
  }
  
  private void updateEndDuration()
  {
    this.mEndDurationMs = (this.mStartDurationMs + this.mSelectDurationMs);
    this.mEndDurationMs = Math.min(this.mEndDurationMs, getCurrentTotalDurationMs());
    this.mStartDurationMs = (this.mEndDurationMs - this.mSelectDurationMs);
  }
  
  private void updateMask()
  {
    int k = 8;
    int j = 0;
    int m = 0;
    if ((this.mSelectDurationMs == this.mTotalDurationMs) || (!this.mShowMask))
    {
      this.mLeftGradientMaskIv.setVisibility(8);
      this.mLeftMaskIv.setVisibility(8);
      this.mRightMaskIv.setVisibility(8);
    }
    label201:
    label375:
    do
    {
      return;
      if ((this.mSelectAreaLeft == 0.0F) && (this.mSliderView != null) && (this.mSliderView.getLeftBarIv() != null)) {
        this.mSelectAreaLeft = (this.mSliderView.getLeftBarIv().getX() + this.mSliderBarWidth);
      }
      i = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
      if (i <= 0)
      {
        this.mLeftGradientMaskIv.setVisibility(8);
        localObject = this.mLeftMaskIv;
        if (this.mSelectAreaLeft > this.mSliderBarWidth * 2.0F)
        {
          i = 0;
          ((ImageView)localObject).setVisibility(i);
          if ((this.mSliderView == null) || (this.mSliderView.getLeftBarIv() == null)) {
            break label386;
          }
        }
        for (this.mLeftMaskWidth = ((int)(this.mSliderView.getLeftBarIv().getX() - this.mSliderBarWidth));; this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth * 2.0F)))
        {
          this.mLeftMaskMargin = ((int)(this.mLeftSliderOffset + this.mSliderBarWidth));
          i = this.mLayoutManager.findLastCompletelyVisibleItemPosition();
          if ((this.mSelectAreaRight == 0.0F) && (this.mSliderView != null) && (this.mSliderView.getRightBarIv() != null)) {
            this.mSelectAreaRight = this.mSliderView.getRightBarIv().getX();
          }
          if (i != this.mItemCount + 1) {
            break label713;
          }
          localObject = this.mRightMaskIv;
          if (getWidth() - this.mSelectAreaRight - this.mSliderBarWidth * 2.0F - this.mLeftSliderOffset <= this.mRightSliderOffset) {
            break label707;
          }
          i = m;
          ((ImageView)localObject).setVisibility(i);
          this.mRightMaskWidth = ((int)(getWidth() - this.mSelectAreaRight - this.mSliderBarWidth * 2.0F - this.mLeftSliderOffset - this.mRightSliderOffset));
          if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
            this.mRightMaskWidth = this.mRightSliderOffset;
          }
          this.mRightMaskMargin = ((int)(this.mRightSliderOffset + this.mSliderBarWidth));
          initMaskParams();
          return;
          i = 8;
          break;
        }
      }
      if (i != 1) {
        break;
      }
      localObject = this.mLayoutManager.findViewByPosition(i);
    } while (localObject == null);
    label300:
    int n = ((View)localObject).getLeft();
    label386:
    Object localObject = this.mLeftMaskIv;
    if (this.mSelectAreaLeft > this.mSliderBarWidth)
    {
      i = 0;
      label452:
      ((ImageView)localObject).setVisibility(i);
      if (n <= this.mLeftSliderOffset) {
        break label542;
      }
      this.mLeftGradientMaskIv.setVisibility(8);
      this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth - n + this.mLeftSliderOffset));
      this.mLeftMaskMargin = n;
      localObject = this.mLeftMaskIv;
      if (this.mLeftMaskWidth <= 0) {
        break label536;
      }
    }
    label536:
    for (int i = 0;; i = 8)
    {
      ((ImageView)localObject).setVisibility(i);
      break;
      i = 8;
      break label452;
    }
    label542:
    if (n < 0) {}
    for (i = 0;; i = n)
    {
      this.mLeftGradientMaskIv.setVisibility(0);
      this.mLeftGradientMaskWidth = (this.mLeftSliderOffset - i);
      this.mLeftGradientMaskMargin = i;
      this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth));
      this.mLeftMaskMargin = this.mLeftSliderOffset;
      break label201;
      if (i <= 1) {
        break label201;
      }
      this.mLeftGradientMaskIv.setVisibility(0);
      this.mLeftGradientMaskWidth = this.mLeftSliderOffset;
      this.mLeftGradientMaskMargin = 0;
      localObject = this.mLeftMaskIv;
      if (this.mSelectAreaLeft > this.mSliderBarWidth)
      {
        i = 0;
        label643:
        ((ImageView)localObject).setVisibility(i);
        this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth));
        localObject = this.mLeftMaskIv;
        if (this.mLeftMaskWidth <= 0) {
          break label701;
        }
      }
      label701:
      for (i = 0;; i = 8)
      {
        ((ImageView)localObject).setVisibility(i);
        this.mLeftMaskMargin = this.mLeftSliderOffset;
        break;
        i = 8;
        break label643;
      }
      label707:
      i = 8;
      break label300;
      label713:
      if (i == this.mItemCount)
      {
        localObject = this.mLayoutManager.findViewByPosition(i);
        if (localObject == null) {
          break;
        }
        i = getWidth() - ((View)localObject).getRight();
        this.mRightMaskIv.setVisibility(0);
        this.mRightMaskWidth = ((int)(getWidth() - this.mSelectAreaRight - this.mSliderBarWidth - this.mLeftSliderOffset - i));
        if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
          this.mRightMaskWidth = (this.mRightSliderOffset - i);
        }
        this.mRightMaskMargin = i;
        localObject = this.mRightMaskIv;
        if (this.mRightMaskWidth > 0) {}
        for (i = j;; i = 8)
        {
          ((ImageView)localObject).setVisibility(i);
          break;
        }
      }
      if (i >= this.mItemCount) {
        break label375;
      }
      this.mRightMaskIv.setVisibility(0);
      this.mRightMaskWidth = ((int)(getWidth() - this.mSelectAreaRight - this.mSliderBarWidth - this.mLeftSliderOffset));
      if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
        this.mRightMaskWidth = this.mRightSliderOffset;
      }
      localObject = this.mRightMaskIv;
      i = k;
      if (this.mRightMaskWidth > 0) {
        i = 0;
      }
      ((ImageView)localObject).setVisibility(i);
      this.mRightMaskMargin = 0;
      break label375;
    }
  }
  
  private void updateSelectDuration()
  {
    float f = this.mSelectAreaRight - this.mSelectAreaLeft;
    Logger.d("TimelineView", "updateSelectDuration: selectWidth" + f);
    Logger.d("TimelineView", "updateSelectDuration: mSelectAreaRight" + this.mSelectAreaRight);
    Logger.d("TimelineView", "updateSelectDuration: mSelectAreaLeft" + this.mSelectAreaLeft);
    if (FloatUtils.isEquals(f, getWidth() - this.mHeadItemWidth - this.mTailItemWidth)) {}
    for (this.mSelectDurationMs = this.mMaxSelectDurationMs;; this.mSelectDurationMs = (Math.ceil(f * (float)this.mMaxSelectDurationMs / (this.selectAreaItemCount * this.mItemWidth))))
    {
      this.mSelectDurationMs = Math.min(this.mSelectDurationMs, this.mMaxSelectDurationMs);
      if ((!this.mLockMode) && (this.mSliderBarMode))
      {
        this.mSelectDurationMs = Math.max(this.mSelectDurationMs, this.mMinSelectDurationMs);
        this.mSpeedSelectDurationMs = (((float)this.mSelectDurationMs / this.mSpeed));
      }
      return;
    }
  }
  
  private void updateSelection(boolean paramBoolean)
  {
    updateSelectDuration();
    updateStartDuration();
    updateEndDuration();
    setSliderSelectDuration();
    updateMask();
    this.mPlayDurationMs = (((float)this.mStartDurationMs + (float)this.mSelectDurationMs * this.mIndicatorProgress));
    if (this.mPlayDurationMs > this.mTotalDurationMs) {
      this.mPlayDurationMs = this.mTotalDurationMs;
    }
    notifySelectionChange(paramBoolean);
  }
  
  private void updateStartDuration()
  {
    int j = 0;
    int k = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
    if (k < 0) {}
    for (int i = (int)(this.mSelectAreaLeft - this.mSliderBarWidth);; i = 0)
    {
      View localView = this.mLayoutManager.findViewByPosition(k);
      if (localView != null) {
        j = localView.getLeft();
      }
      if (k == 0) {
        i = (int)(this.mSelectAreaLeft - this.mSliderBarWidth);
      }
      for (;;)
      {
        this.mStartDurationMs = ((1.0F * (float)(i * this.mMaxSelectDurationMs) / (this.mItemWidth * this.selectAreaItemCount)));
        Log.d("TimelineView", "updateStartDuration: startOffset = " + i + "\n mMaxSelectDurationMs = " + this.mMaxSelectDurationMs + "\n mItemWidth = " + this.mItemWidth + "\n selectAreaItemCount = " + this.selectAreaItemCount + "\n ************\n mStartDurationMs = " + this.mStartDurationMs);
        if (this.mStartDurationMs < 0L) {
          this.mStartDurationMs = 0L;
        }
        return;
        if (k > 0) {
          i = (int)(this.mHeadItemWidth + (k - 1) * this.mItemWidth - j + this.mSelectAreaLeft - this.mSliderBarWidth);
        }
      }
    }
  }
  
  public void bindPlayer(MoviePlayer paramMoviePlayer)
  {
    this.mPlayer = paramMoviePlayer;
    paramMoviePlayer.addPlayerListener(this);
  }
  
  public long getCurrentTotalDurationMs()
  {
    return ((float)this.mTotalDurationMs / this.mSpeed);
  }
  
  public long getPlayPosition()
  {
    return this.mPlayDurationMs;
  }
  
  public int getRecyclerViewPaddingBottom()
  {
    return this.mPaddingBottom;
  }
  
  public int getRecyclerViewPaddingLeft()
  {
    return this.mPaddingLeft;
  }
  
  public int getRecyclerViewPaddingRight()
  {
    return this.mPaddingRight;
  }
  
  public int getRecyclerViewPaddingTop()
  {
    return this.mPaddingTop;
  }
  
  public int getSelectAreaItemCount()
  {
    return this.selectAreaItemCount;
  }
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    if (shouldSyncIndicatorPositionWithPlayerTime()) {
      syncIndicatorPositionWithPlayerTime();
    }
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus) {}
  
  public void release()
  {
    this.mScrollEnable = false;
    if (this.mCoverProvider != null) {
      this.mCoverProvider.release();
    }
    if (this.mSliderView != null) {
      this.mSliderView.release();
    }
    this.mSliderChangeListener = null;
  }
  
  public void setClipData(TAVSource paramTAVSource, long paramLong1, long paramLong2, long paramLong3)
  {
    this.mTavSource = paramTAVSource;
    this.mTotalDurationMs = paramLong1;
    this.mStartDurationMs = paramLong2;
    this.mEndDurationMs = paramLong3;
    this.mMaxSelectDurationMs = Math.min(this.mTotalDurationMs, this.mMaxSelectDurationMs);
    paramLong1 = Math.min(this.mEndDurationMs - this.mStartDurationMs, this.mMaxSelectDurationMs);
    this.mSelectDurationMs = paramLong1;
    this.mSpeedSelectDurationMs = paramLong1;
    if (this.mTotalDurationMs != this.mSelectDurationMs) {}
    for (boolean bool = true;; bool = false)
    {
      this.mScrollEnable = bool;
      post(new TimelineView.9(this));
      return;
    }
  }
  
  public void setDurationBgRes(int paramInt)
  {
    this.mSliderView.setDurationBgRes(paramInt);
  }
  
  public void setIndicatorRes(int paramInt)
  {
    this.mSliderView.setIndicatorRes(paramInt);
  }
  
  public void setMediaModel(MediaModel paramMediaModel)
  {
    this.mMediaModel = paramMediaModel;
  }
  
  public void setPlayPosition(long paramLong)
  {
    if (this.mSelectDurationMs == 0L) {}
    do
    {
      do
      {
        return;
      } while (this.mPlayDurationMs == paramLong);
      this.mPlayDurationMs = paramLong;
      if (this.mPlayDurationMs > getCurrentTotalDurationMs() + this.mStartDurationMs) {
        this.mPlayDurationMs = (getCurrentTotalDurationMs() + this.mStartDurationMs);
      }
      this.mIndicatorProgress = (1.0F * (float)(this.mPlayDurationMs - this.mStartDurationMs) / (float)this.mSelectDurationMs);
    } while (this.mSliderView == null);
    this.mSliderView.setIndicatorProgress(this.mIndicatorProgress);
  }
  
  public void setRecyclerViewPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPaddingLeft = paramInt1;
    this.mPaddingTop = paramInt2;
    this.mPaddingRight = paramInt3;
    this.mPaddingBottom = paramInt4;
    this.mRecycleView.setPadding(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
  }
  
  public void setSelectAreaItemCount(int paramInt)
  {
    this.selectAreaItemCount = paramInt;
  }
  
  public void setShowIndicator(boolean paramBoolean)
  {
    this.mSliderView.setShowIndicator(paramBoolean);
  }
  
  public void setSliderChangeListener(SliderChangeListener paramSliderChangeListener)
  {
    this.mSliderChangeListener = paramSliderChangeListener;
  }
  
  public void setSliderFrameColor(int paramInt)
  {
    this.mSliderView.setFrameColor(paramInt);
  }
  
  public void setSpeed(float paramFloat)
  {
    if ((FloatUtils.isEquals(paramFloat, this.mSpeed)) || (FloatUtils.isEquals(0.0F, paramFloat))) {
      return;
    }
    this.mSpeed = paramFloat;
    this.mSpeedTotalDurationMs = (((float)this.mTotalDurationMs / this.mSpeed));
    if (getCurrentTotalDurationMs() > this.mOriginMaxSelectDurationMs) {}
    for (this.mMaxSelectDurationMs = (((float)this.mOriginMaxSelectDurationMs * this.mSpeed));; this.mMaxSelectDurationMs = Math.max(this.mTotalDurationMs, this.mMaxSelectDurationMs))
    {
      updateClipData();
      return;
    }
  }
  
  public void setTimelineBuilder(TimelineBuilder paramTimelineBuilder)
  {
    if (paramTimelineBuilder == null) {
      return;
    }
    if (paramTimelineBuilder.getMaxSelectDurationMs() == -1L)
    {
      l = 60000L;
      label20:
      this.mMaxSelectDurationMs = l;
      this.mOriginMaxSelectDurationMs = l;
      if (paramTimelineBuilder.getMinSelectDurationMs() != -1L) {
        break label166;
      }
    }
    label166:
    for (long l = 2000L;; l = paramTimelineBuilder.getMinSelectDurationMs())
    {
      this.mMinSelectDurationMs = l;
      this.mLockMode = paramTimelineBuilder.isLockMode();
      this.mSliderBarMode = paramTimelineBuilder.isSliderBarMode();
      this.mShowMask = paramTimelineBuilder.isShowMask();
      this.mShowDuration = paramTimelineBuilder.isShowDuration();
      this.mMaxDurationTps = paramTimelineBuilder.getMaxDurationTps();
      if (this.mSliderView == null) {
        break;
      }
      this.mSliderView.setLockMode(this.mLockMode);
      this.mSliderView.setSliderBarMode(this.mSliderBarMode);
      this.mSliderView.setShowDuration(this.mShowDuration);
      this.mSliderView.setMaxDurationTips(this.mMaxDurationTps);
      initRecycleViewParams();
      initHeadAndTailParams();
      initSliderParams();
      initMaskParams();
      return;
      l = paramTimelineBuilder.getMaxSelectDurationMs();
      break label20;
    }
  }
  
  public void showAllMask(int paramInt)
  {
    if (this.allMaskView == null) {
      this.allMaskView = new View(getContext());
    }
    removeView(this.allMaskView);
    this.allMaskView.setBackgroundColor(paramInt);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.setMargins(this.mPaddingLeft, this.mPaddingTop, this.mPaddingRight, this.mPaddingBottom);
    addView(this.allMaskView, localLayoutParams);
  }
  
  public void updateSpeed(float paramFloat)
  {
    updateSpeed(paramFloat, null);
  }
  
  public void updateSpeed(float paramFloat, TimelineView.SpeedChangeCallback paramSpeedChangeCallback)
  {
    if ((FloatUtils.isEquals(paramFloat, this.mSpeed)) || (FloatUtils.isEquals(0.0F, paramFloat))) {}
    float f;
    long l1;
    long l2;
    long l3;
    do
    {
      return;
      f = paramFloat / this.mSpeed;
      l1 = getCurrentTotalDurationMs();
      l2 = ((float)this.mSelectDurationMs / f);
      l3 = ((float)l1 / f);
      if ((float)this.mTotalDurationMs / paramFloat >= (float)this.mMinSelectDurationMs) {
        break;
      }
      if ((paramFloat == 2.0F) && (paramSpeedChangeCallback != null))
      {
        paramSpeedChangeCallback.onChangeFailed(1000);
        return;
      }
    } while ((paramFloat != 1.5F) || (paramSpeedChangeCallback == null));
    paramSpeedChangeCallback.onChangeFailed(1001);
    return;
    this.mSpeedTotalDurationMs = l3;
    this.mSpeed = paramFloat;
    if (l3 > 60000L)
    {
      this.mMaxSelectDurationMs = 60000L;
      if (this.hasEditStartAndEnd) {}
      for (this.mSpeedSelectDurationMs = Math.min(l2, this.mMaxSelectDurationMs);; this.mSpeedSelectDurationMs = this.mMaxSelectDurationMs)
      {
        this.mSelectDurationMs = Math.max(this.mSpeedSelectDurationMs, this.mMinSelectDurationMs);
        this.mStartDurationMs = (((float)this.mStartDurationMs / f));
        this.mEndDurationMs = (this.mStartDurationMs + this.mSelectDurationMs);
        Log.d("updateStartDuration", "updateSpeed: start = " + this.mStartDurationMs);
        Log.d("updateStartDuration", "updateSpeed: end = " + this.mEndDurationMs);
        if (paramSpeedChangeCallback != null) {
          paramSpeedChangeCallback.onChangeSucc(paramFloat);
        }
        updateClipData();
        notifySelectionChange(true);
        checkCanAdjust();
        return;
      }
    }
    this.mMaxSelectDurationMs = l3;
    if (this.hasEditStartAndEnd)
    {
      this.mSpeedSelectDurationMs = l2;
      label311:
      this.mSelectDurationMs = Math.max(this.mSpeedSelectDurationMs, this.mMinSelectDurationMs);
      this.mStartDurationMs = (((float)this.mStartDurationMs / f));
      this.mEndDurationMs = (this.mStartDurationMs + this.mSelectDurationMs);
      Log.d("updateStartDuration", "updateSpeed: start = " + this.mStartDurationMs);
      Log.d("updateStartDuration", "updateSpeed: end = " + this.mEndDurationMs);
      if (paramSpeedChangeCallback != null) {
        paramSpeedChangeCallback.onChangeSucc(paramFloat);
      }
      if (l1 >= 60000L) {
        break label470;
      }
      setSliderBarPosition();
      updateMask();
      setSliderSelectDuration();
      setSliderMinSelectionWidth();
      setSliderMaxSelectionWidth();
    }
    for (;;)
    {
      notifySelectionChange(true);
      break;
      this.mSpeedSelectDurationMs = this.mMaxSelectDurationMs;
      break label311;
      label470:
      updateClipData();
    }
  }
  
  public void updateTavSource(TAVSource paramTAVSource)
  {
    this.mTavSource = paramTAVSource;
    post(new TimelineView.6(this));
  }
  
  public void updateTimeRange(long paramLong1, long paramLong2)
  {
    if (paramLong2 == -1L) {
      this.mStartDurationMs = 0L;
    }
    for (this.mEndDurationMs = this.mTotalDurationMs;; this.mEndDurationMs = paramLong2)
    {
      post(new TimelineView.11(this));
      return;
      this.mStartDurationMs = paramLong1;
    }
  }
  
  public void updateTimeRangeAndSource(TAVSource paramTAVSource, long paramLong1, long paramLong2)
  {
    this.mTavSource = paramTAVSource;
    if (paramLong2 == -1L)
    {
      this.mStartDurationMs = 0L;
      this.mEndDurationMs = this.mTotalDurationMs;
      paramLong1 = Math.min(this.mEndDurationMs - this.mStartDurationMs, this.mMaxSelectDurationMs);
      this.mSelectDurationMs = paramLong1;
      this.mSpeedSelectDurationMs = paramLong1;
      if (this.mTotalDurationMs == this.mSelectDurationMs) {
        break label103;
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      this.mScrollEnable = bool;
      post(new TimelineView.10(this));
      return;
      this.mStartDurationMs = paramLong1;
      this.mEndDurationMs = paramLong2;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView
 * JD-Core Version:    0.7.0.1
 */