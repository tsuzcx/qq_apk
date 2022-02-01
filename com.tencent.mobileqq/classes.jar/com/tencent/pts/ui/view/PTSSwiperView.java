package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSAppInstance.PTSLiteAppInstance;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeAttribute;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.utils.PTSDeviceUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PTSSwiperView
  extends RelativeLayout
  implements IView
{
  private static final int MIN_INTERCEPT_DISTANCE = PTSDeviceUtil.dp2pxInt(3.0F);
  private static final String TAG = "PTSSwiperView";
  private PTSSwiperView.PTSSwiperRecyclerViewAdapter mAdapter;
  private boolean mAutoPlay = false;
  private int mAutoPlayDuration = 500;
  private int mAutoPlayInterval = 5000;
  private Runnable mAutoPlayRunnable = new PTSSwiperView.3(this);
  private boolean mCircular = false;
  private List<PTSNodeInfo> mDataList = new ArrayList();
  private LinearLayout mIndicatorContainer;
  private int mIndicatorFocusedColor = -16777216;
  private GradientDrawable mIndicatorFocusedDrawable;
  private int mIndicatorGap = PTSDeviceUtil.dp2pxInt(4.0F);
  private int mIndicatorHeight = PTSDeviceUtil.dp2pxInt(3.0F);
  private int mIndicatorMarginBottom = PTSDeviceUtil.dp2pxInt(12.0F);
  private int mIndicatorNormalColor = 1275068416;
  private GradientDrawable mIndicatorNormalDrawable;
  private float mIndicatorRadius = PTSDeviceUtil.dp2px(2.5F);
  private int mIndicatorWidth = PTSDeviceUtil.dp2pxInt(16.0F);
  private PTSSwiperView.PTSPagerSnapHelper mPagerSnapHelper;
  private PTSSwiperView.PTSSwiperRecyclerView mRecyclerView;
  private PTSNodeSwiper nodeSwiper;
  private PTSNodeInfo ptsNodeInfo;
  
  public PTSSwiperView(PTSNodeSwiper paramPTSNodeSwiper)
  {
    super(paramPTSNodeSwiper.getContext());
    init(paramPTSNodeSwiper);
  }
  
  private void init(PTSNodeSwiper paramPTSNodeSwiper)
  {
    this.nodeSwiper = paramPTSNodeSwiper;
    Context localContext = paramPTSNodeSwiper.getContext();
    this.mAdapter = new PTSSwiperView.PTSSwiperRecyclerViewAdapter(paramPTSNodeSwiper.getAppInstance());
    this.mRecyclerView = new PTSSwiperView.PTSSwiperRecyclerView(this);
    this.mRecyclerView.setAdapter(this.mAdapter);
    paramPTSNodeSwiper = new LinearLayoutManager(localContext);
    paramPTSNodeSwiper.setOrientation(0);
    this.mRecyclerView.setLayoutManager(paramPTSNodeSwiper);
    paramPTSNodeSwiper = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.mRecyclerView, paramPTSNodeSwiper);
    this.mIndicatorContainer = new LinearLayout(localContext);
    paramPTSNodeSwiper = new RelativeLayout.LayoutParams(-2, -2);
    paramPTSNodeSwiper.addRule(14);
    paramPTSNodeSwiper.addRule(12);
    this.mIndicatorContainer.setPadding(0, 0, 0, this.mIndicatorMarginBottom);
    addView(this.mIndicatorContainer, paramPTSNodeSwiper);
    this.mPagerSnapHelper = new PTSSwiperView.PTSPagerSnapHelper(null);
    this.mPagerSnapHelper.attachToRecyclerView(this.mRecyclerView);
    this.mPagerSnapHelper.setEventListener(new PTSSwiperView.1(this));
  }
  
  private void onIndicatorSelected(int paramInt)
  {
    int j = this.mIndicatorContainer.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = this.mIndicatorContainer.getChildAt(i);
      GradientDrawable localGradientDrawable;
      if (i == paramInt) {
        localGradientDrawable = this.mIndicatorFocusedDrawable;
      } else {
        localGradientDrawable = this.mIndicatorNormalDrawable;
      }
      localView.setBackgroundDrawable(localGradientDrawable);
      i += 1;
    }
  }
  
  private void resetIndicator()
  {
    if (this.mIndicatorContainer.getVisibility() != 0) {
      return;
    }
    int m = this.mAdapter.getRealItemCount();
    int k = this.mIndicatorContainer.getChildCount();
    int i = 0;
    if (m <= 1)
    {
      while (i < k)
      {
        this.mIndicatorContainer.getChildAt(i).setVisibility(8);
        i += 1;
      }
      return;
    }
    int j;
    if (m > k)
    {
      Context localContext = this.mIndicatorContainer.getContext();
      int n = this.mIndicatorWidth;
      int i1 = this.mIndicatorHeight;
      i = k;
      while (i < m)
      {
        View localView = new View(localContext);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
        if (i == 0) {
          j = 0;
        } else {
          j = this.mIndicatorGap;
        }
        localLayoutParams.leftMargin = j;
        if (this.mIndicatorFocusedDrawable == null) {
          this.mIndicatorFocusedDrawable = new GradientDrawable();
        }
        if (this.mIndicatorNormalDrawable == null) {
          this.mIndicatorNormalDrawable = new GradientDrawable();
        }
        this.mIndicatorNormalDrawable.setColor(this.mIndicatorNormalColor);
        this.mIndicatorFocusedDrawable.setColor(this.mIndicatorFocusedColor);
        this.mIndicatorFocusedDrawable.setCornerRadius(this.mIndicatorRadius);
        this.mIndicatorNormalDrawable.setCornerRadius(this.mIndicatorRadius);
        GradientDrawable localGradientDrawable;
        if (i == 0) {
          localGradientDrawable = this.mIndicatorFocusedDrawable;
        } else {
          localGradientDrawable = this.mIndicatorNormalDrawable;
        }
        localView.setBackgroundDrawable(localGradientDrawable);
        this.mIndicatorContainer.addView(localView, localLayoutParams);
        i += 1;
      }
    }
    i = 0;
    for (;;)
    {
      j = m;
      if (i >= m) {
        break;
      }
      this.mIndicatorContainer.getChildAt(i).setVisibility(0);
      i += 1;
    }
    while (j < k)
    {
      this.mIndicatorContainer.getChildAt(j).setVisibility(8);
      j += 1;
    }
  }
  
  private void switchAutoPlay(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[switchAutoPlay] autoPlay = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", size = ");
    localStringBuilder.append(this.mDataList.size());
    PTSLog.i("PTSSwiperView", localStringBuilder.toString());
    this.mRecyclerView.removeCallbacks(this.mAutoPlayRunnable);
    if (!paramBoolean) {
      this.mRecyclerView.stopScroll();
    }
    if ((paramBoolean) && (this.mDataList.size() > 1)) {
      this.mRecyclerView.postDelayed(this.mAutoPlayRunnable, this.mAutoPlayInterval);
    }
  }
  
  private void switchCircular(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[switchCircular] circular = ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", size = ");
    ((StringBuilder)localObject).append(this.mDataList.size());
    PTSLog.i("PTSSwiperView", ((StringBuilder)localObject).toString());
    localObject = this.mAdapter;
    boolean bool = true;
    if ((paramBoolean) && (this.mDataList.size() > 1)) {
      paramBoolean = bool;
    } else {
      paramBoolean = false;
    }
    ((PTSSwiperView.PTSSwiperRecyclerViewAdapter)localObject).setInfiniteLoop(paramBoolean);
  }
  
  private void triggerSwiperDrag()
  {
    Object localObject1 = this.mPagerSnapHelper;
    if ((localObject1 != null) && (this.mAdapter != null) && (this.nodeSwiper != null) && (this.mRecyclerView != null))
    {
      int i = ((PTSSwiperView.PTSPagerSnapHelper)localObject1).getCurrentPosition();
      i = this.mAdapter.getRealPosition(i);
      if ((i >= 0) && (i < this.mDataList.size()))
      {
        Object localObject3 = (PTSNodeInfo)this.mDataList.get(i);
        localObject1 = this.nodeSwiper.getAppInstance();
        if ((localObject3 != null) && (localObject1 != null))
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[triggerSwiperDrag], position = ");
          ((StringBuilder)localObject2).append(i);
          PTSLog.i("PTSSwiperView", ((StringBuilder)localObject2).toString());
          if (((PTSAppInstance)localObject1).isLiteAppInstance())
          {
            localObject2 = ((PTSNodeInfo)localObject3).getEventInfo();
            localObject3 = PTSValueConvertUtil.getString(((PTSNodeInfo)localObject3).getAttributes().get("pts:on-swiper-drag"));
            PTSAppInstance.PTSLiteAppInstance localPTSLiteAppInstance = (PTSAppInstance.PTSLiteAppInstance)localObject1;
            IPTSLiteEventListener localIPTSLiteEventListener = localPTSLiteAppInstance.getLiteEventListener();
            PTSLiteItemViewManager localPTSLiteItemViewManager = localPTSLiteAppInstance.getLiteItemViewManager();
            if (localIPTSLiteEventListener != null)
            {
              localPTSLiteAppInstance.triggerLiteEvent(4, (String)localObject3, (HashMap)localObject2, this.mRecyclerView.getChildAt(i), ((PTSAppInstance)localObject1).getPtsComposer());
              return;
            }
            if (localPTSLiteItemViewManager != null) {
              localPTSLiteItemViewManager.triggerLiteEvent(4, (String)localObject3, (HashMap)localObject2, this.mRecyclerView.getChildAt(i));
            }
          }
          else
          {
            PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], is not PTSLiteAppInstance.");
          }
          return;
        }
        PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, nodeInfo is null or ptsAppInstance is null.");
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[triggerSwiperDrag] failed, position = ");
      ((StringBuilder)localObject1).append(i);
      PTSLog.i("PTSSwiperView", ((StringBuilder)localObject1).toString());
      return;
    }
    PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, something is null.");
  }
  
  private void triggerSwiperItemExposure(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mDataList.size()))
    {
      Object localObject3 = (PTSNodeInfo)this.mDataList.get(paramInt);
      if (localObject3 != null)
      {
        localObject1 = this.nodeSwiper;
        if ((localObject1 != null) && (this.mRecyclerView != null))
        {
          localObject1 = ((PTSNodeSwiper)localObject1).getAppInstance();
          if (localObject1 == null)
          {
            PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, ptsAppInstance is null.");
            return;
          }
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[triggerSwiperItemExposure], position = ");
          ((StringBuilder)localObject2).append(paramInt);
          PTSLog.i("PTSSwiperView", ((StringBuilder)localObject2).toString());
          if (((PTSAppInstance)localObject1).isLiteAppInstance())
          {
            localObject2 = ((PTSNodeInfo)localObject3).getEventInfo();
            localObject3 = PTSValueConvertUtil.getString(((PTSNodeInfo)localObject3).getAttributes().get("pts:on-swiper-item-exposure"));
            PTSAppInstance.PTSLiteAppInstance localPTSLiteAppInstance = (PTSAppInstance.PTSLiteAppInstance)localObject1;
            IPTSLiteEventListener localIPTSLiteEventListener = localPTSLiteAppInstance.getLiteEventListener();
            PTSLiteItemViewManager localPTSLiteItemViewManager = localPTSLiteAppInstance.getLiteItemViewManager();
            if (localIPTSLiteEventListener != null)
            {
              localPTSLiteAppInstance.triggerLiteEvent(3, (String)localObject3, (HashMap)localObject2, this.mRecyclerView.getChildAt(paramInt), ((PTSAppInstance)localObject1).getPtsComposer());
              return;
            }
            if (localPTSLiteItemViewManager != null) {
              localPTSLiteItemViewManager.triggerLiteEvent(3, (String)localObject3, (HashMap)localObject2, this.mRecyclerView.getChildAt(paramInt));
            }
          }
          else
          {
            PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], is not PTSLiteAppInstance.");
          }
          return;
        }
      }
      PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, nodeInfo is null or nodeSwiper is null, or recyclerView is null.");
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[triggerSwiperItemExposure] failed, position = ");
    ((StringBuilder)localObject1).append(paramInt);
    PTSLog.i("PTSSwiperView", ((StringBuilder)localObject1).toString());
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    switchAutoPlay(this.mAutoPlay);
  }
  
  public void onBindNodeInfo(PTSNodeInfo paramPTSNodeInfo)
  {
    if (paramPTSNodeInfo == null) {
      return;
    }
    this.mDataList.clear();
    this.mDataList.addAll(paramPTSNodeInfo.getChildren());
    this.mAdapter.setData(this.mDataList);
    resetIndicator();
    switchAutoPlay(this.mAutoPlay);
    switchCircular(this.mCircular);
    post(new PTSSwiperView.2(this, paramPTSNodeInfo));
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    switchAutoPlay(false);
  }
  
  protected void onVisibilityChanged(@NonNull View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    boolean bool;
    if ((paramInt == 0) && (this.mAutoPlay)) {
      bool = true;
    } else {
      bool = false;
    }
    switchAutoPlay(bool);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (PTSDeviceUtil.isVisibleOnScreen(this))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    switchAutoPlay(paramBoolean);
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
    this.mRecyclerView.setAutoPlay(paramBoolean);
    PTSSwiperView.PTSSwiperRecyclerView localPTSSwiperRecyclerView = this.mRecyclerView;
    Runnable localRunnable;
    if (this.mAutoPlay) {
      localRunnable = this.mAutoPlayRunnable;
    } else {
      localRunnable = null;
    }
    localPTSSwiperRecyclerView.setAutoPlayRunnable(localRunnable);
  }
  
  public void setAutoPlayDuration(int paramInt)
  {
    this.mAutoPlayDuration = paramInt;
  }
  
  public void setAutoPlayInterval(int paramInt)
  {
    this.mAutoPlayInterval = paramInt;
    this.mRecyclerView.setAutoPlayInterval(paramInt);
  }
  
  public void setCircular(boolean paramBoolean)
  {
    this.mCircular = paramBoolean;
  }
  
  public void setIndicatorFocusedColor(int paramInt)
  {
    this.mIndicatorFocusedColor = paramInt;
  }
  
  public void setIndicatorGap(float paramFloat)
  {
    this.mIndicatorGap = PTSDeviceUtil.dp2pxInt(paramFloat);
  }
  
  public void setIndicatorHeight(float paramFloat)
  {
    this.mIndicatorHeight = PTSDeviceUtil.dp2pxInt(paramFloat);
  }
  
  public void setIndicatorMarginBottom(float paramFloat)
  {
    this.mIndicatorMarginBottom = PTSDeviceUtil.dp2pxInt(paramFloat);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[setIndicatorMarginBottom], bottom = ");
    localStringBuilder.append(this.mIndicatorMarginBottom);
    localStringBuilder.append(", bottom dp = ");
    localStringBuilder.append(paramFloat);
    PTSLog.i("PTSSwiperView", localStringBuilder.toString());
    this.mIndicatorContainer.setPadding(0, 0, 0, this.mIndicatorMarginBottom);
  }
  
  public void setIndicatorNormalColor(int paramInt)
  {
    this.mIndicatorNormalColor = paramInt;
  }
  
  public void setIndicatorRadius(float paramFloat)
  {
    this.mIndicatorRadius = PTSDeviceUtil.dp2pxInt(paramFloat);
  }
  
  public void setIndicatorVisible(boolean paramBoolean)
  {
    LinearLayout localLinearLayout = this.mIndicatorContainer;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localLinearLayout.setVisibility(i);
  }
  
  public void setIndicatorWidth(float paramFloat)
  {
    this.mIndicatorWidth = PTSDeviceUtil.dp2pxInt(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView
 * JD-Core Version:    0.7.0.1
 */