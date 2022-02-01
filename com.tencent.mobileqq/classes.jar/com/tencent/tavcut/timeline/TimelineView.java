package com.tencent.tavcut.timeline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
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
    SliderView localSliderView = this.mSliderView;
    if (localSliderView != null)
    {
      if (this.mSelectDurationMs <= this.mMinSelectDurationMs)
      {
        localSliderView.setCanAdjust(false);
        return;
      }
      localSliderView.setCanAdjust(true);
    }
  }
  
  private void correctParams()
  {
    int i = this.mSliderView.getSelectAreaWidth() - this.mItemWidth * this.selectAreaItemCount;
    if (i == 0) {
      return;
    }
    this.mRightSliderOffset += i;
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
    if (i >= 0)
    {
      if (j < 0) {
        return;
      }
      Object localObject = this.mCoverProvider;
      if (localObject != null)
      {
        ((CoverProvider)localObject).getCoverByIndexRange(i, j);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCoverInsideScreen: startIndex is ");
        ((StringBuilder)localObject).append(i);
        Logger.d("TimelineView", ((StringBuilder)localObject).toString());
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCoverInsideScreen: endIndex is ");
        ((StringBuilder)localObject).append(j);
        Logger.d("TimelineView", ((StringBuilder)localObject).toString());
      }
    }
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
        localObject = (ImageView)this.mLayoutManager.findViewByPosition(i);
        if (localObject != null)
        {
          ((ImageView)localObject).setImageBitmap(null);
          ((ImageView)localObject).setImageDrawable(null);
          ((ImageView)localObject).setImageDrawable(this.mDefaultImgBg);
        }
        i += 1;
      }
      this.mAdapter = null;
      this.mRecycleView.setAdapter(null);
      Object localObject = this.mCoverProvider;
      if (localObject != null)
      {
        ((CoverProvider)localObject).release();
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
    boolean bool = this.mSliderBarMode;
    int j = 0;
    if (bool) {
      i = (int)(this.mLeftSliderOffset + this.mSliderBarWidth);
    } else {
      i = 0;
    }
    this.mHeadItemWidth = i;
    int i = j;
    if (this.mSliderBarMode) {
      i = (int)(this.mRightSliderOffset + this.mSliderBarWidth);
    }
    this.mTailItemWidth = i;
  }
  
  private void initItemParams()
  {
    this.mItemWidth = (this.mSliderView.getSelectAreaWidth() / this.selectAreaItemCount);
    this.mItemHeight = (getMeasuredHeight() - this.mPaddingTop - this.mPaddingBottom);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipData: mSliderView.getSelectAreaWidth() ");
    localStringBuilder.append(this.mSliderView.getSelectAreaWidth());
    Logger.d("TimelineView", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipData: mItemWidth is ");
    localStringBuilder.append(this.mItemWidth);
    Logger.d("TimelineView", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipData: mItemHeight is ");
    localStringBuilder.append(this.mItemHeight);
    Logger.d("TimelineView", localStringBuilder.toString());
    if ((!this.mLockMode) && (this.mSliderBarMode))
    {
      this.mMaxSelectDurationMs = Math.min(60000L, getCurrentTotalDurationMs());
      this.mItemDurationMs = (this.mMaxSelectDurationMs / this.selectAreaItemCount);
    }
    else
    {
      this.mItemDurationMs = (this.mSelectDurationMs / this.selectAreaItemCount);
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipData: mItemDurationMs is  ");
    localStringBuilder.append(this.mItemDurationMs);
    Logger.d("TimelineView", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setClipData: mSelectDurationMs is ");
    localStringBuilder.append(this.mSelectDurationMs);
    Logger.d("TimelineView", localStringBuilder.toString());
    if (this.mItemDurationMs != 0L)
    {
      this.mItemCount = ((int)(getCurrentTotalDurationMs() / this.mItemDurationMs));
      long l = getCurrentTotalDurationMs() % this.mItemDurationMs;
      if (l != 0L)
      {
        float f1 = (float)l;
        float f2 = this.selectAreaItemCount;
        int i = this.mItemWidth;
        this.mLastItemWidth = ((int)(f1 * 1.0F * f2 * i / (float)this.mMaxSelectDurationMs));
        if (this.mLastItemWidth == 0) {
          this.mLastItemWidth = i;
        } else {
          this.mItemCount += 1;
        }
      }
      else
      {
        this.mLastItemWidth = this.mItemWidth;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("setClipData: mItemCount is ");
      localStringBuilder.append(this.mItemCount);
      Logger.d("TimelineView", localStringBuilder.toString());
      initAdapter();
      initProvider(this.mTavSource);
      post(new TimelineView.3(this));
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
    Object localObject = this.mLeftGradientMaskIv;
    FrameLayout.LayoutParams localLayoutParams;
    if (localObject != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new FrameLayout.LayoutParams(this.mLeftGradientMaskWidth, -1, 8388627);
      }
      ((FrameLayout.LayoutParams)localObject).width = this.mLeftGradientMaskWidth;
      ((FrameLayout.LayoutParams)localObject).leftMargin = this.mLeftGradientMaskMargin;
      this.mLeftGradientMaskIv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.mLeftMaskIv;
    if (localObject != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new FrameLayout.LayoutParams(this.mLeftMaskWidth, -1, 8388627);
      }
      ((FrameLayout.LayoutParams)localObject).width = this.mLeftMaskWidth;
      ((FrameLayout.LayoutParams)localObject).leftMargin = this.mLeftMaskMargin;
      this.mLeftMaskIv.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.mRightMaskIv;
    if (localObject != null)
    {
      localLayoutParams = (FrameLayout.LayoutParams)((ImageView)localObject).getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new FrameLayout.LayoutParams(this.mRightMaskWidth, -1, 8388629);
      }
      ((FrameLayout.LayoutParams)localObject).width = this.mRightMaskWidth;
      ((FrameLayout.LayoutParams)localObject).rightMargin = this.mRightMaskMargin;
      this.mRightMaskIv.setLayoutParams((ViewGroup.LayoutParams)localObject);
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
    FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)this.mRecycleView.getLayoutParams();
    FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null) {
      localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1, 16);
    }
    this.mRecycleView.setLayoutParams(localLayoutParams1);
    boolean bool = this.mSliderBarMode;
    int j = 0;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = this.mPaddingLeft;
    }
    if (!this.mSliderBarMode) {
      j = this.mPaddingRight;
    }
    this.mRecycleView.setPadding(i, this.mPaddingTop, j, this.mPaddingBottom);
  }
  
  private void initSlider()
  {
    initSliderParams();
    this.mSliderView.setSliderChangeListener(new TimelineView.2(this));
    addView(this.mSliderView);
  }
  
  private void initSliderParams()
  {
    Object localObject = this.mSliderView;
    if (localObject != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((SliderView)localObject).getLayoutParams();
      localObject = localLayoutParams;
      if (localLayoutParams == null) {
        localObject = new FrameLayout.LayoutParams(-1, -1);
      }
      boolean bool = this.mSliderBarMode;
      int k = 0;
      int i;
      if (bool) {
        i = this.mLeftSliderOffset;
      } else {
        i = 0;
      }
      int j;
      if (this.mSliderBarMode) {
        j = this.mRightSliderOffset;
      } else {
        j = 0;
      }
      ((FrameLayout.LayoutParams)localObject).leftMargin = i;
      ((FrameLayout.LayoutParams)localObject).rightMargin = j;
      this.mSliderView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (this.mSliderBarMode) {
        i = 0;
      } else {
        i = this.mPaddingLeft;
      }
      if (this.mSliderBarMode) {
        j = k;
      } else {
        j = this.mPaddingRight;
      }
      localObject = this.mSliderView;
      ((SliderView)localObject).setPadding(i, ((SliderView)localObject).getPaddingTop(), j, this.mSliderView.getPaddingBottom());
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyIndicatorMove: playDurationMs is ");
    ((StringBuilder)localObject).append(this.mPlayDurationMs);
    Logger.d("TimelineView", ((StringBuilder)localObject).toString());
    localObject = this.mSliderChangeListener;
    if (localObject != null) {
      ((SliderChangeListener)localObject).onIndicatorMove(this.mPlayDurationMs);
    }
  }
  
  private void notifyIndicatorPress()
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onIndicatorPress();
    }
  }
  
  private void notifyIndicatorRelease()
  {
    Logger.d("TimelineView", "notifyIndicator Release");
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onIndicatorRelease();
    }
  }
  
  private void notifySelectionChange(boolean paramBoolean)
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onSelectionChange(this.mStartDurationMs, this.mEndDurationMs, paramBoolean);
    }
  }
  
  private void notifySliderBarMove(boolean paramBoolean, float paramFloat1, float paramFloat2)
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onSliderBarMove(paramBoolean, paramFloat1, paramFloat2);
    }
  }
  
  private void notifySliderBarRelease(boolean paramBoolean)
  {
    SliderChangeListener localSliderChangeListener = this.mSliderChangeListener;
    if (localSliderChangeListener != null) {
      localSliderChangeListener.onSliderBarRelease(paramBoolean);
    }
  }
  
  private void scrollToStart()
  {
    if (getCurrentTotalDurationMs() == 0L) {
      return;
    }
    float f = this.mItemCount * 1.0F * (float)this.mStartDurationMs / (float)getCurrentTotalDurationMs();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scrollToStart:  startIndex = ");
    localStringBuilder.append(f);
    Log.d("lingeng", localStringBuilder.toString());
    int i = this.mItemWidth;
    this.mRecycleView.addOnScrollListener(new TimelineView.7(this));
    boolean bool1 = this.mRecycleView.canScrollHorizontally(1);
    boolean bool2 = this.mRecycleView.canScrollHorizontally(-1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("canScrollRight: ");
    localStringBuilder.append(bool1);
    localStringBuilder.append(" canScrollLeft:");
    localStringBuilder.append(bool2);
    Log.d("lingeng_ui", localStringBuilder.toString());
    this.mLayoutManager.scrollToPositionWithOffset((int)f, 0);
  }
  
  private void setSliderBarPosition()
  {
    if (this.mMaxSelectDurationMs == this.mSelectDurationMs)
    {
      this.mSelectAreaLeft = this.mSliderBarWidth;
      f1 = getWidth() - this.mLeftSliderOffset - this.mRightSliderOffset;
      f2 = this.mSliderBarWidth;
      this.mSelectAreaRight = (f1 - f2);
      localObject = this.mSliderView;
      if (localObject != null) {
        ((SliderView)localObject).setSliderBarPosition(this.mSelectAreaLeft - f2, this.mSelectAreaRight);
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSliderBarPosition: mSliderView.getLeft() = ");
    ((StringBuilder)localObject).append(this.mSliderView.getLeft());
    Log.d("TimelineView", ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSliderBarPosition: mSliderView.getWidth() = ");
    ((StringBuilder)localObject).append(this.mSliderView.getWidth());
    Log.d("TimelineView", ((StringBuilder)localObject).toString());
    int j = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
    localObject = this.mLayoutManager.findViewByPosition(j);
    if (j < 0) {
      this.mSelectAreaLeft = ((float)this.mStartDurationMs * 1.0F * this.mItemWidth / (this.selectAreaItemCount * 1.0F / (float)this.mMaxSelectDurationMs) + this.mSliderBarWidth);
    }
    int i = 0;
    if (localObject != null) {
      i = ((View)localObject).getLeft();
    }
    if (j == 0)
    {
      this.mSelectAreaLeft = ((float)this.mStartDurationMs * 1.0F * this.mItemWidth * this.selectAreaItemCount / (float)this.mMaxSelectDurationMs + this.mSliderBarWidth);
    }
    else if (j == 1)
    {
      this.mSelectAreaLeft = ((float)this.mStartDurationMs * 1.0F * this.mItemWidth * this.selectAreaItemCount / (float)this.mMaxSelectDurationMs + i - this.mLeftSliderOffset);
    }
    else if (j > 0)
    {
      f1 = (float)this.mStartDurationMs;
      int k = this.mItemWidth;
      f2 = (j - 1) * k - i;
      l1 = this.mItemDurationMs;
      this.mSelectAreaLeft = ((f1 - f2 * 1.0F * (float)l1 / k) * 1.0F * k / (float)l1 - this.mLeftSliderOffset);
    }
    float f1 = this.mSelectAreaLeft;
    long l1 = this.mSelectDurationMs;
    float f2 = (float)l1;
    i = this.mItemWidth;
    float f3 = i;
    j = this.selectAreaItemCount;
    float f4 = j;
    long l2 = this.mMaxSelectDurationMs;
    this.mSelectAreaRight = (f1 + f2 * 1.0F * f3 * f4 / (float)l2);
    f1 = (float)l1 * 1.0F * i * j / (float)l2;
    this.mSelectAreaLeft = (this.mSelectAreaRight - f1);
    this.mSelectAreaLeft = Math.max(this.mSelectAreaLeft, this.mSliderBarWidth);
    this.mSelectAreaRight = Math.min(this.mSelectAreaRight, getWidth() - this.mLeftSliderOffset - this.mRightSliderOffset - this.mSliderBarWidth);
    localObject = this.mSliderView;
    if (localObject != null) {
      ((SliderView)localObject).setSliderBarPosition(this.mSelectAreaLeft - this.mSliderBarWidth, this.mSelectAreaRight);
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
    SliderView localSliderView = this.mSliderView;
    if (localSliderView != null) {
      localSliderView.setMaxSelectDuration(this.mMaxSelectDurationMs);
    }
  }
  
  private void setSliderMaxSelectionWidth()
  {
    SliderView localSliderView = this.mSliderView;
    if (localSliderView == null) {
      return;
    }
    if ((!this.mLockMode) && (this.mSliderBarMode)) {
      localSliderView.setMaxSelectAreaWidth(this.mItemWidth * this.selectAreaItemCount);
    }
  }
  
  private void setSliderMinSelectionWidth()
  {
    SliderView localSliderView = this.mSliderView;
    if (localSliderView == null) {
      return;
    }
    if ((!this.mLockMode) && (this.mSliderBarMode)) {
      localSliderView.setMinSelectAreaWidth((int)(this.mSpeed * (float)this.mMinSelectDurationMs * this.mItemWidth * this.selectAreaItemCount / (float)this.mOriginMaxSelectDurationMs));
    }
  }
  
  private void setSliderSelectDuration()
  {
    SliderView localSliderView = this.mSliderView;
    if (localSliderView != null) {
      localSliderView.setSelectDuration(Long.valueOf(this.mSelectDurationMs));
    }
  }
  
  private void setSliderTotalDuration()
  {
    SliderView localSliderView = this.mSliderView;
    if (localSliderView != null) {
      localSliderView.setTotalDurationMs(getCurrentTotalDurationMs());
    }
  }
  
  private boolean shouldSyncIndicatorPositionWithPlayerTime()
  {
    if (this.mSliderView.isDragging()) {
      return false;
    }
    if (this.mSliderView.isIndicatorMoving()) {
      return false;
    }
    return this.mPlayer.getCurrentStatus() != IPlayer.PlayerStatus.PAUSED;
  }
  
  private void syncIndicatorPositionWithPlayerTime()
  {
    MoviePlayer localMoviePlayer = this.mPlayer;
    if (localMoviePlayer == null) {
      return;
    }
    setPlayPosition(localMoviePlayer.getPosition().getTimeUs() / 1000L);
  }
  
  private void syncPlayerTimeWithIndicatorPosition()
  {
    MoviePlayer localMoviePlayer = this.mPlayer;
    if (localMoviePlayer == null)
    {
      Log.e("TimelineView", "syncPlayerTimeWithIndicatorPosition: mPlayer is null!");
      return;
    }
    long l2 = localMoviePlayer.getPlayRange().getDurationUs();
    long l1 = this.mPlayer.getPlayRange().getStartUs();
    float f = this.mSliderView.getIndicatorProgress();
    l2 = ((float)l2 * f);
    this.mPlayer.seekToTime(CMTime.convertTimeScale(CMTime.fromUs(l1 + l2), 1000));
  }
  
  private void updateClipData()
  {
    boolean bool;
    if (getCurrentTotalDurationMs() != this.mMaxSelectDurationMs) {
      bool = true;
    } else {
      bool = false;
    }
    this.mScrollEnable = bool;
    post(new TimelineView.8(this));
  }
  
  private void updateEndDuration()
  {
    this.mEndDurationMs = (this.mStartDurationMs + this.mSelectDurationMs);
    this.mEndDurationMs = Math.min(this.mEndDurationMs, getCurrentTotalDurationMs());
    this.mStartDurationMs = (this.mEndDurationMs - this.mSelectDurationMs);
  }
  
  private void updateMask()
  {
    long l1 = this.mSelectDurationMs;
    long l2 = this.mTotalDurationMs;
    int k = 8;
    if ((l1 != l2) && (this.mShowMask))
    {
      Object localObject;
      if (this.mSelectAreaLeft == 0.0F)
      {
        localObject = this.mSliderView;
        if ((localObject != null) && (((SliderView)localObject).getLeftBarIv() != null)) {
          this.mSelectAreaLeft = (this.mSliderView.getLeftBarIv().getX() + this.mSliderBarWidth);
        }
      }
      int i = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
      int j = 0;
      int m = 0;
      if (i <= 0)
      {
        this.mLeftGradientMaskIv.setVisibility(8);
        localObject = this.mLeftMaskIv;
        if (this.mSelectAreaLeft > this.mSliderBarWidth * 2.0F) {
          i = 0;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        localObject = this.mSliderView;
        if ((localObject != null) && (((SliderView)localObject).getLeftBarIv() != null)) {
          this.mLeftMaskWidth = ((int)(this.mSliderView.getLeftBarIv().getX() - this.mSliderBarWidth));
        } else {
          this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth * 2.0F));
        }
        this.mLeftMaskMargin = ((int)(this.mLeftSliderOffset + this.mSliderBarWidth));
      }
      else if (i == 1)
      {
        localObject = this.mLayoutManager.findViewByPosition(i);
        if (localObject == null) {
          return;
        }
        n = ((View)localObject).getLeft();
        localObject = this.mLeftMaskIv;
        if (this.mSelectAreaLeft > this.mSliderBarWidth) {
          i = 0;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        if (n > this.mLeftSliderOffset)
        {
          this.mLeftGradientMaskIv.setVisibility(8);
          this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth - n + this.mLeftSliderOffset));
          this.mLeftMaskMargin = n;
          localObject = this.mLeftMaskIv;
          if (this.mLeftMaskWidth > 0) {
            i = 0;
          } else {
            i = 8;
          }
          ((ImageView)localObject).setVisibility(i);
        }
        else
        {
          i = n;
          if (n < 0) {
            i = 0;
          }
          this.mLeftGradientMaskIv.setVisibility(0);
          n = this.mLeftSliderOffset;
          this.mLeftGradientMaskWidth = (n - i);
          this.mLeftGradientMaskMargin = i;
          this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth));
          this.mLeftMaskMargin = n;
        }
      }
      else if (i > 1)
      {
        this.mLeftGradientMaskIv.setVisibility(0);
        this.mLeftGradientMaskWidth = this.mLeftSliderOffset;
        this.mLeftGradientMaskMargin = 0;
        localObject = this.mLeftMaskIv;
        if (this.mSelectAreaLeft > this.mSliderBarWidth) {
          i = 0;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        this.mLeftMaskWidth = ((int)(this.mSelectAreaLeft - this.mSliderBarWidth));
        localObject = this.mLeftMaskIv;
        if (this.mLeftMaskWidth > 0) {
          i = 0;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        this.mLeftMaskMargin = this.mLeftSliderOffset;
      }
      i = this.mLayoutManager.findLastCompletelyVisibleItemPosition();
      if (this.mSelectAreaRight == 0.0F)
      {
        localObject = this.mSliderView;
        if ((localObject != null) && (((SliderView)localObject).getRightBarIv() != null)) {
          this.mSelectAreaRight = this.mSliderView.getRightBarIv().getX();
        }
      }
      int n = this.mItemCount;
      if (i == n + 1)
      {
        localObject = this.mRightMaskIv;
        if (getWidth() - this.mSelectAreaRight - this.mSliderBarWidth * 2.0F - this.mLeftSliderOffset > this.mRightSliderOffset) {
          i = m;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
        float f1 = getWidth();
        float f2 = this.mSelectAreaRight;
        float f3 = this.mSliderBarWidth;
        float f4 = this.mLeftSliderOffset;
        i = this.mRightSliderOffset;
        this.mRightMaskWidth = ((int)(f1 - f2 - f3 * 2.0F - f4 - i));
        if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
          this.mRightMaskWidth = i;
        }
        this.mRightMaskMargin = ((int)(this.mRightSliderOffset + this.mSliderBarWidth));
      }
      else if (i == n)
      {
        localObject = this.mLayoutManager.findViewByPosition(i);
        if (localObject == null) {
          return;
        }
        i = getWidth() - ((View)localObject).getRight();
        this.mRightMaskIv.setVisibility(0);
        this.mRightMaskWidth = ((int)(getWidth() - this.mSelectAreaRight - this.mSliderBarWidth - this.mLeftSliderOffset - i));
        if (this.mSelectDurationMs == this.mMaxSelectDurationMs) {
          this.mRightMaskWidth = (this.mRightSliderOffset - i);
        }
        this.mRightMaskMargin = i;
        localObject = this.mRightMaskIv;
        if (this.mRightMaskWidth > 0) {
          i = j;
        } else {
          i = 8;
        }
        ((ImageView)localObject).setVisibility(i);
      }
      else if (i < n)
      {
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
      }
      initMaskParams();
      return;
    }
    this.mLeftGradientMaskIv.setVisibility(8);
    this.mLeftMaskIv.setVisibility(8);
    this.mRightMaskIv.setVisibility(8);
  }
  
  private void updateSelectDuration()
  {
    float f = this.mSelectAreaRight - this.mSelectAreaLeft;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSelectDuration: selectWidth");
    localStringBuilder.append(f);
    Logger.d("TimelineView", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSelectDuration: mSelectAreaRight");
    localStringBuilder.append(this.mSelectAreaRight);
    Logger.d("TimelineView", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateSelectDuration: mSelectAreaLeft");
    localStringBuilder.append(this.mSelectAreaLeft);
    Logger.d("TimelineView", localStringBuilder.toString());
    if (FloatUtils.isEquals(f, getWidth() - this.mHeadItemWidth - this.mTailItemWidth)) {
      this.mSelectDurationMs = this.mMaxSelectDurationMs;
    } else {
      this.mSelectDurationMs = (Math.ceil((float)this.mMaxSelectDurationMs * f / (this.selectAreaItemCount * this.mItemWidth)));
    }
    this.mSelectDurationMs = Math.min(this.mSelectDurationMs, this.mMaxSelectDurationMs);
    if ((!this.mLockMode) && (this.mSliderBarMode))
    {
      this.mSelectDurationMs = Math.max(this.mSelectDurationMs, this.mMinSelectDurationMs);
      this.mSpeedSelectDurationMs = (((float)this.mSelectDurationMs / this.mSpeed));
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
    long l1 = this.mPlayDurationMs;
    long l2 = this.mTotalDurationMs;
    if (l1 > l2) {
      this.mPlayDurationMs = l2;
    }
    notifySelectionChange(paramBoolean);
  }
  
  private void updateStartDuration()
  {
    int k = this.mLayoutManager.findFirstCompletelyVisibleItemPosition();
    int j = 0;
    int i;
    if (k < 0) {
      i = (int)(this.mSelectAreaLeft - this.mSliderBarWidth);
    } else {
      i = 0;
    }
    Object localObject = this.mLayoutManager.findViewByPosition(k);
    if (localObject != null) {
      j = ((View)localObject).getLeft();
    }
    float f1;
    if (k == 0) {
      f1 = this.mSelectAreaLeft;
    }
    for (float f2 = this.mSliderBarWidth;; f2 = this.mSliderBarWidth)
    {
      i = (int)(f1 - f2);
      break;
      if (k <= 0) {
        break;
      }
      f1 = this.mHeadItemWidth + (k - 1) * this.mItemWidth - j + this.mSelectAreaLeft;
    }
    this.mStartDurationMs = (((float)(i * this.mMaxSelectDurationMs) * 1.0F / (this.mItemWidth * this.selectAreaItemCount)));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateStartDuration: startOffset = ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("\n mMaxSelectDurationMs = ");
    ((StringBuilder)localObject).append(this.mMaxSelectDurationMs);
    ((StringBuilder)localObject).append("\n mItemWidth = ");
    ((StringBuilder)localObject).append(this.mItemWidth);
    ((StringBuilder)localObject).append("\n selectAreaItemCount = ");
    ((StringBuilder)localObject).append(this.selectAreaItemCount);
    ((StringBuilder)localObject).append("\n ************\n mStartDurationMs = ");
    ((StringBuilder)localObject).append(this.mStartDurationMs);
    Log.d("TimelineView", ((StringBuilder)localObject).toString());
    if (this.mStartDurationMs < 0L) {
      this.mStartDurationMs = 0L;
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
    Object localObject = this.mCoverProvider;
    if (localObject != null) {
      ((CoverProvider)localObject).release();
    }
    localObject = this.mSliderView;
    if (localObject != null) {
      ((SliderView)localObject).release();
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
    boolean bool;
    if (this.mTotalDurationMs != this.mSelectDurationMs) {
      bool = true;
    } else {
      bool = false;
    }
    this.mScrollEnable = bool;
    post(new TimelineView.9(this));
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
    if (this.mSelectDurationMs == 0L) {
      return;
    }
    if (this.mPlayDurationMs == paramLong) {
      return;
    }
    this.mPlayDurationMs = paramLong;
    if (this.mPlayDurationMs > getCurrentTotalDurationMs() + this.mStartDurationMs) {
      this.mPlayDurationMs = (getCurrentTotalDurationMs() + this.mStartDurationMs);
    }
    this.mIndicatorProgress = ((float)(this.mPlayDurationMs - this.mStartDurationMs) * 1.0F / (float)this.mSelectDurationMs);
    SliderView localSliderView = this.mSliderView;
    if (localSliderView != null) {
      localSliderView.setIndicatorProgress(this.mIndicatorProgress);
    }
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
    if (!FloatUtils.isEquals(paramFloat, this.mSpeed))
    {
      if (FloatUtils.isEquals(0.0F, paramFloat)) {
        return;
      }
      this.mSpeed = paramFloat;
      this.mSpeedTotalDurationMs = (((float)this.mTotalDurationMs / this.mSpeed));
      long l1 = getCurrentTotalDurationMs();
      long l2 = this.mOriginMaxSelectDurationMs;
      if (l1 > l2) {
        this.mMaxSelectDurationMs = (((float)l2 * this.mSpeed));
      } else {
        this.mMaxSelectDurationMs = Math.max(this.mTotalDurationMs, this.mMaxSelectDurationMs);
      }
      updateClipData();
    }
  }
  
  public void setTimelineBuilder(TimelineBuilder paramTimelineBuilder)
  {
    if (paramTimelineBuilder == null) {
      return;
    }
    long l;
    if (paramTimelineBuilder.getMaxSelectDurationMs() == -1L) {
      l = 60000L;
    } else {
      l = paramTimelineBuilder.getMaxSelectDurationMs();
    }
    this.mMaxSelectDurationMs = l;
    this.mOriginMaxSelectDurationMs = l;
    if (paramTimelineBuilder.getMinSelectDurationMs() == -1L) {
      l = 2000L;
    } else {
      l = paramTimelineBuilder.getMinSelectDurationMs();
    }
    this.mMinSelectDurationMs = l;
    this.mLockMode = paramTimelineBuilder.isLockMode();
    this.mSliderBarMode = paramTimelineBuilder.isSliderBarMode();
    this.mShowMask = paramTimelineBuilder.isShowMask();
    this.mShowDuration = paramTimelineBuilder.isShowDuration();
    this.mMaxDurationTps = paramTimelineBuilder.getMaxDurationTps();
    paramTimelineBuilder = this.mSliderView;
    if (paramTimelineBuilder != null)
    {
      paramTimelineBuilder.setLockMode(this.mLockMode);
      this.mSliderView.setSliderBarMode(this.mSliderBarMode);
      this.mSliderView.setShowDuration(this.mShowDuration);
      this.mSliderView.setMaxDurationTips(this.mMaxDurationTps);
      initRecycleViewParams();
      initHeadAndTailParams();
      initSliderParams();
      initMaskParams();
    }
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    this.mSliderView.setTypeface(paramTypeface);
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
    if (!FloatUtils.isEquals(paramFloat, this.mSpeed))
    {
      if (FloatUtils.isEquals(0.0F, paramFloat)) {
        return;
      }
      float f = paramFloat / this.mSpeed;
      long l1 = getCurrentTotalDurationMs();
      long l2 = ((float)this.mSelectDurationMs / f);
      long l3 = ((float)l1 / f);
      if ((float)this.mTotalDurationMs / paramFloat < (float)this.mMinSelectDurationMs)
      {
        if ((paramFloat == 2.0F) && (paramSpeedChangeCallback != null))
        {
          paramSpeedChangeCallback.onChangeFailed(1000);
          return;
        }
        if ((paramFloat == 1.5F) && (paramSpeedChangeCallback != null)) {
          paramSpeedChangeCallback.onChangeFailed(1001);
        }
        return;
      }
      this.mSpeedTotalDurationMs = l3;
      this.mSpeed = paramFloat;
      StringBuilder localStringBuilder;
      if (l3 > 60000L)
      {
        this.mMaxSelectDurationMs = 60000L;
        if (this.hasEditStartAndEnd) {
          this.mSpeedSelectDurationMs = Math.min(l2, this.mMaxSelectDurationMs);
        } else {
          this.mSpeedSelectDurationMs = this.mMaxSelectDurationMs;
        }
        this.mSelectDurationMs = Math.max(this.mSpeedSelectDurationMs, this.mMinSelectDurationMs);
        this.mStartDurationMs = (((float)this.mStartDurationMs / f));
        this.mEndDurationMs = (this.mStartDurationMs + this.mSelectDurationMs);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSpeed: start = ");
        localStringBuilder.append(this.mStartDurationMs);
        Log.d("updateStartDuration", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSpeed: end = ");
        localStringBuilder.append(this.mEndDurationMs);
        Log.d("updateStartDuration", localStringBuilder.toString());
        if (paramSpeedChangeCallback != null) {
          paramSpeedChangeCallback.onChangeSucc(paramFloat);
        }
        updateClipData();
        notifySelectionChange(true);
      }
      else
      {
        this.mMaxSelectDurationMs = l3;
        if (this.hasEditStartAndEnd) {
          this.mSpeedSelectDurationMs = l2;
        } else {
          this.mSpeedSelectDurationMs = this.mMaxSelectDurationMs;
        }
        this.mSelectDurationMs = Math.max(this.mSpeedSelectDurationMs, this.mMinSelectDurationMs);
        this.mStartDurationMs = (((float)this.mStartDurationMs / f));
        this.mEndDurationMs = (this.mStartDurationMs + this.mSelectDurationMs);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSpeed: start = ");
        localStringBuilder.append(this.mStartDurationMs);
        Log.d("updateStartDuration", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateSpeed: end = ");
        localStringBuilder.append(this.mEndDurationMs);
        Log.d("updateStartDuration", localStringBuilder.toString());
        if (paramSpeedChangeCallback != null) {
          paramSpeedChangeCallback.onChangeSucc(paramFloat);
        }
        if (l1 < 60000L)
        {
          setSliderBarPosition();
          updateMask();
          setSliderSelectDuration();
          setSliderMinSelectionWidth();
          setSliderMaxSelectionWidth();
        }
        else
        {
          updateClipData();
        }
        notifySelectionChange(true);
      }
      checkCanAdjust();
    }
  }
  
  public void updateTavSource(TAVSource paramTAVSource)
  {
    this.mTavSource = paramTAVSource;
    post(new TimelineView.6(this));
  }
  
  public void updateTimeRange(long paramLong1, long paramLong2)
  {
    if (paramLong2 == -1L)
    {
      this.mStartDurationMs = 0L;
      this.mEndDurationMs = this.mTotalDurationMs;
    }
    else
    {
      this.mStartDurationMs = paramLong1;
      this.mEndDurationMs = paramLong2;
    }
    post(new TimelineView.11(this));
  }
  
  public void updateTimeRangeAndSource(TAVSource paramTAVSource, long paramLong1, long paramLong2)
  {
    this.mTavSource = paramTAVSource;
    if (paramLong2 == -1L)
    {
      this.mStartDurationMs = 0L;
      this.mEndDurationMs = this.mTotalDurationMs;
    }
    else
    {
      this.mStartDurationMs = paramLong1;
      this.mEndDurationMs = paramLong2;
    }
    paramLong1 = Math.min(this.mEndDurationMs - this.mStartDurationMs, this.mMaxSelectDurationMs);
    this.mSelectDurationMs = paramLong1;
    this.mSpeedSelectDurationMs = paramLong1;
    boolean bool;
    if (this.mTotalDurationMs != this.mSelectDurationMs) {
      bool = true;
    } else {
      bool = false;
    }
    this.mScrollEnable = bool;
    post(new TimelineView.10(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavcut.timeline.TimelineView
 * JD-Core Version:    0.7.0.1
 */