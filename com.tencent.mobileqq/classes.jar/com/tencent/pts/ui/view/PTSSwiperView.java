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
    if (i < j)
    {
      View localView = this.mIndicatorContainer.getChildAt(i);
      if (i == paramInt) {}
      for (GradientDrawable localGradientDrawable = this.mIndicatorFocusedDrawable;; localGradientDrawable = this.mIndicatorNormalDrawable)
      {
        localView.setBackgroundDrawable(localGradientDrawable);
        i += 1;
        break;
      }
    }
  }
  
  private void resetIndicator()
  {
    int i = 0;
    if (this.mIndicatorContainer.getVisibility() != 0) {}
    for (;;)
    {
      return;
      int m = this.mAdapter.getRealItemCount();
      int k = this.mIndicatorContainer.getChildCount();
      if (m <= 1)
      {
        while (i < k)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
      else
      {
        if (m > k)
        {
          Context localContext = this.mIndicatorContainer.getContext();
          int n = this.mIndicatorWidth;
          int i1 = this.mIndicatorHeight;
          i = k;
          if (i < m)
          {
            View localView = new View(localContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
            int j;
            if (i == 0)
            {
              j = 0;
              label126:
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
              if (i != 0) {
                break label255;
              }
            }
            label255:
            for (GradientDrawable localGradientDrawable = this.mIndicatorFocusedDrawable;; localGradientDrawable = this.mIndicatorNormalDrawable)
            {
              localView.setBackgroundDrawable(localGradientDrawable);
              this.mIndicatorContainer.addView(localView, localLayoutParams);
              i += 1;
              break;
              j = this.mIndicatorGap;
              break label126;
            }
          }
        }
        i = 0;
        while (i < m)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(0);
          i += 1;
        }
        i = m;
        while (i < k)
        {
          this.mIndicatorContainer.getChildAt(i).setVisibility(8);
          i += 1;
        }
      }
    }
  }
  
  private void switchAutoPlay(boolean paramBoolean)
  {
    PTSLog.i("PTSSwiperView", "[switchAutoPlay] autoPlay = " + paramBoolean + ", size = " + this.mDataList.size());
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
    boolean bool = true;
    PTSLog.i("PTSSwiperView", "[switchCircular] circular = " + paramBoolean + ", size = " + this.mDataList.size());
    PTSSwiperView.PTSSwiperRecyclerViewAdapter localPTSSwiperRecyclerViewAdapter = this.mAdapter;
    if ((paramBoolean) && (this.mDataList.size() > 1)) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localPTSSwiperRecyclerViewAdapter.setInfiniteLoop(paramBoolean);
      return;
    }
  }
  
  private void triggerSwiperDrag()
  {
    if ((this.mPagerSnapHelper == null) || (this.mAdapter == null) || (this.nodeSwiper == null) || (this.mRecyclerView == null)) {
      PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, something is null.");
    }
    int i;
    Object localObject;
    HashMap localHashMap;
    PTSLiteItemViewManager localPTSLiteItemViewManager;
    do
    {
      return;
      i = this.mPagerSnapHelper.getCurrentPosition();
      i = this.mAdapter.getRealPosition(i);
      if ((i < 0) || (i >= this.mDataList.size()))
      {
        PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, position = " + i);
        return;
      }
      localObject = (PTSNodeInfo)this.mDataList.get(i);
      PTSAppInstance localPTSAppInstance = this.nodeSwiper.getAppInstance();
      if ((localObject == null) || (localPTSAppInstance == null))
      {
        PTSLog.i("PTSSwiperView", "[triggerSwiperDrag] failed, nodeInfo is null or ptsAppInstance is null.");
        return;
      }
      PTSLog.i("PTSSwiperView", "[triggerSwiperDrag], position = " + i);
      if (!localPTSAppInstance.isLiteAppInstance()) {
        break;
      }
      localHashMap = ((PTSNodeInfo)localObject).getEventInfo();
      localObject = PTSValueConvertUtil.getString(((PTSNodeInfo)localObject).getAttributes().get("pts:on-swiper-drag"));
      IPTSLiteEventListener localIPTSLiteEventListener = ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).getLiteEventListener();
      localPTSLiteItemViewManager = ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).getLiteItemViewManager();
      if (localIPTSLiteEventListener != null)
      {
        ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).triggerLiteEvent(4, (String)localObject, localHashMap, this.mRecyclerView.getChildAt(i));
        return;
      }
    } while (localPTSLiteItemViewManager == null);
    localPTSLiteItemViewManager.triggerLiteEvent(4, (String)localObject, localHashMap, this.mRecyclerView.getChildAt(i));
    return;
    PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], is not PTSLiteAppInstance.");
  }
  
  private void triggerSwiperItemExposure(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.mDataList.size())) {
      PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, position = " + paramInt);
    }
    Object localObject;
    HashMap localHashMap;
    PTSLiteItemViewManager localPTSLiteItemViewManager;
    do
    {
      return;
      localObject = (PTSNodeInfo)this.mDataList.get(paramInt);
      if ((localObject == null) || (this.nodeSwiper == null) || (this.mRecyclerView == null))
      {
        PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, nodeInfo is null or nodeSwiper is null, or recyclerView is null.");
        return;
      }
      PTSAppInstance localPTSAppInstance = this.nodeSwiper.getAppInstance();
      if (localPTSAppInstance == null)
      {
        PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure] failed, ptsAppInstance is null.");
        return;
      }
      PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], position = " + paramInt);
      if (!localPTSAppInstance.isLiteAppInstance()) {
        break;
      }
      localHashMap = ((PTSNodeInfo)localObject).getEventInfo();
      localObject = PTSValueConvertUtil.getString(((PTSNodeInfo)localObject).getAttributes().get("pts:on-swiper-item-exposure"));
      IPTSLiteEventListener localIPTSLiteEventListener = ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).getLiteEventListener();
      localPTSLiteItemViewManager = ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).getLiteItemViewManager();
      if (localIPTSLiteEventListener != null)
      {
        ((PTSAppInstance.PTSLiteAppInstance)localPTSAppInstance).triggerLiteEvent(3, (String)localObject, localHashMap, this.mRecyclerView.getChildAt(paramInt));
        return;
      }
    } while (localPTSLiteItemViewManager == null);
    localPTSLiteItemViewManager.triggerLiteEvent(3, (String)localObject, localHashMap, this.mRecyclerView.getChildAt(paramInt));
    return;
    PTSLog.i("PTSSwiperView", "[triggerSwiperItemExposure], is not PTSLiteAppInstance.");
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
    if ((paramInt == 0) && (this.mAutoPlay)) {}
    for (boolean bool = true;; bool = false)
    {
      switchAutoPlay(bool);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (PTSDeviceUtil.isVisibleOnScreen(this))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      switchAutoPlay(paramBoolean);
      return;
    }
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    this.mAutoPlay = paramBoolean;
    this.mRecyclerView.setAutoPlay(paramBoolean);
    PTSSwiperView.PTSSwiperRecyclerView localPTSSwiperRecyclerView = this.mRecyclerView;
    if (this.mAutoPlay) {}
    for (Runnable localRunnable = this.mAutoPlayRunnable;; localRunnable = null)
    {
      localPTSSwiperRecyclerView.setAutoPlayRunnable(localRunnable);
      return;
    }
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
    PTSLog.i("PTSSwiperView", "[setIndicatorMarginBottom], bottom = " + this.mIndicatorMarginBottom + ", bottom dp = " + paramFloat);
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
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      return;
    }
  }
  
  public void setIndicatorWidth(float paramFloat)
  {
    this.mIndicatorWidth = PTSDeviceUtil.dp2pxInt(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView
 * JD-Core Version:    0.7.0.1
 */