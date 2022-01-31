package com.tencent.pts.ui.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeSwiper;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.ArrayList;
import java.util.List;

public class PTSSwiperView
  extends RelativeLayout
  implements IView<PTSNodeSwiper>
{
  private static final String TAG = "PTSSwiperView";
  private PTSSwiperView.PTSSwiperRecyclerViewAdapter mAdapter;
  private boolean mAutoPlay = false;
  private int mAutoPlayDuration = 500;
  private int mAutoPlayInterval = 5000;
  private Runnable mAutoPlayRunnable = new PTSSwiperView.2(this);
  private boolean mCircularAutoPlay = false;
  private List<PTSNodeInfo> mDataList = new ArrayList();
  private LinearLayout mIndicatorContainer;
  private int mIndicatorFocusedColor = -16777216;
  private GradientDrawable mIndicatorFocusedDrawable;
  private float mIndicatorGap = PTSValueConvertUtil.dp2px(4.0F);
  private float mIndicatorHeight = PTSValueConvertUtil.dp2px(3.0F);
  private float mIndicatorMarginBottom = PTSValueConvertUtil.dp2px(12.0F);
  private int mIndicatorNormalColor = 1275068416;
  private GradientDrawable mIndicatorNormalDrawable;
  private float mIndicatorRadius = PTSValueConvertUtil.dp2px(2.5F);
  private float mIndicatorWidth = PTSValueConvertUtil.dp2px(16.0F);
  private PTSNodeSwiper mNode;
  private PTSSwiperView.PTSPagerSnapHelper mPagerSnapHelper;
  private PTSSwiperView.PTSSwiperRecyclerView mRecyclerView;
  
  public PTSSwiperView(PTSNodeSwiper paramPTSNodeSwiper)
  {
    super(paramPTSNodeSwiper.getContext());
    this.mNode = paramPTSNodeSwiper;
    init();
  }
  
  private void init()
  {
    Object localObject1 = this.mNode.getContext();
    this.mAdapter = new PTSSwiperView.PTSSwiperRecyclerViewAdapter(this.mNode.getAppInstance());
    this.mRecyclerView = new PTSSwiperView.PTSSwiperRecyclerView((Context)localObject1);
    this.mRecyclerView.setAdapter(this.mAdapter);
    Object localObject2 = new LinearLayoutManager((Context)localObject1);
    ((LinearLayoutManager)localObject2).setOrientation(0);
    this.mRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject2);
    localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.mRecyclerView, (ViewGroup.LayoutParams)localObject2);
    this.mIndicatorContainer = new LinearLayout((Context)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12);
    this.mIndicatorContainer.setPadding(0, 0, 0, (int)this.mIndicatorMarginBottom);
    addView(this.mIndicatorContainer, (ViewGroup.LayoutParams)localObject1);
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
          int n = (int)this.mIndicatorWidth;
          int i1 = (int)this.mIndicatorHeight;
          i = k;
          if (i < m)
          {
            View localView = new View(localContext);
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(n, i1);
            int j;
            if (i == 0)
            {
              j = 0;
              label128:
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
                break label258;
              }
            }
            label258:
            for (GradientDrawable localGradientDrawable = this.mIndicatorFocusedDrawable;; localGradientDrawable = this.mIndicatorNormalDrawable)
            {
              localView.setBackgroundDrawable(localGradientDrawable);
              this.mIndicatorContainer.addView(localView, localLayoutParams);
              i += 1;
              break;
              j = (int)this.mIndicatorGap;
              break label128;
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
    this.mRecyclerView.removeCallbacks(this.mAutoPlayRunnable);
    if (paramBoolean) {
      this.mRecyclerView.postDelayed(this.mAutoPlayRunnable, this.mAutoPlayInterval);
    }
  }
  
  public PTSNodeSwiper getNode()
  {
    return this.mNode;
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
  
  public void setCircularAutoPlay(boolean paramBoolean)
  {
    this.mCircularAutoPlay = paramBoolean;
  }
  
  public void setIndicatorFocusedColor(int paramInt)
  {
    this.mIndicatorFocusedColor = paramInt;
  }
  
  public void setIndicatorGap(float paramFloat)
  {
    this.mIndicatorGap = PTSValueConvertUtil.dp2px(paramFloat);
  }
  
  public void setIndicatorHeight(float paramFloat)
  {
    this.mIndicatorHeight = PTSValueConvertUtil.dp2px(paramFloat);
  }
  
  public void setIndicatorMarginBottom(float paramFloat)
  {
    this.mIndicatorMarginBottom = PTSValueConvertUtil.dp2px(paramFloat);
    PTSLog.i("PTSSwiperView", "[setIndicatorMarginBottom], bottom = " + this.mIndicatorMarginBottom + ", bottom dp = " + paramFloat);
    this.mIndicatorContainer.setPadding(0, 0, 0, (int)this.mIndicatorMarginBottom);
  }
  
  public void setIndicatorNormalColor(int paramInt)
  {
    this.mIndicatorNormalColor = paramInt;
  }
  
  public void setIndicatorRadius(float paramFloat)
  {
    this.mIndicatorRadius = PTSValueConvertUtil.dp2px(paramFloat);
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
    this.mIndicatorWidth = PTSValueConvertUtil.dp2px(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.ui.view.PTSSwiperView
 * JD-Core Version:    0.7.0.1
 */