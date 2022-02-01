package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.utils.ScreenUtils;

public class BrowserBaseView
{
  public BrowserBasePresenter basePresenter;
  public boolean isInEnterAnim;
  public boolean isInExitAnim;
  public RelativeLayout mBrowserItemView;
  public Activity mContext;
  public int mScreenHeightPx;
  public int mScreenWidthPx;
  public int midScreenWidth;
  
  public BrowserBaseView(Activity paramActivity, BrowserBasePresenter paramBrowserBasePresenter)
  {
    this.mContext = paramActivity;
    if (this.mContext != null)
    {
      this.mScreenWidthPx = this.mContext.getResources().getDisplayMetrics().widthPixels;
      this.mScreenHeightPx = this.mContext.getResources().getDisplayMetrics().heightPixels;
    }
    this.basePresenter = paramBrowserBasePresenter;
  }
  
  public boolean back()
  {
    return false;
  }
  
  public void bindView(int paramInt) {}
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent)
  {
    this.midScreenWidth = (ScreenUtils.getScreenWidth(this.mContext) / 2);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    onCreate(paramViewGroup);
  }
  
  public void clearTheOuchCache() {}
  
  public Rect getAnimationEndDstRect()
  {
    return null;
  }
  
  public View getView(View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean needEnterRectAnimation()
  {
    return true;
  }
  
  public boolean needExitRectAnimation()
  {
    return false;
  }
  
  public void notifyImageModelDataChanged()
  {
    int i = this.basePresenter.getSelectedIndex();
    RecyclerView localRecyclerView = this.basePresenter.getRecyclerView();
    if ((localRecyclerView != null) && (i != this.basePresenter.baseModel.getSelectedIndex())) {
      localRecyclerView.scrollToPosition(i);
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    int i = this.mContext.getResources().getDisplayMetrics().widthPixels;
    int j = this.mContext.getResources().getDisplayMetrics().heightPixels;
    if ((i != this.mScreenWidthPx) || (j != this.mScreenHeightPx))
    {
      this.mScreenWidthPx = i;
      this.mScreenHeightPx = j;
      URLDrawable.clearMemoryCache();
    }
  }
  
  public void onCreate(ViewGroup paramViewGroup) {}
  
  public void onDestroy() {}
  
  public void onDestroyView(int paramInt, View paramView) {}
  
  public void onDoubleTap() {}
  
  public void onEnterAnimationEnd() {}
  
  public void onEnterAnimationStart() {}
  
  public void onExitAnimationEnd() {}
  
  public void onExitAnimationStart() {}
  
  public void onItemSelected(int paramInt) {}
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onScale() {}
  
  public void onScaleBegin() {}
  
  public void onScaleEnd() {}
  
  public void onScrollEnd() {}
  
  public void onScrollHalfScreenWidth() {}
  
  public void onScrollStart() {}
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onStop() {}
  
  public void reset() {}
  
  public void showContentView(boolean paramBoolean) {}
  
  public void updateUI() {}
  
  public void updateView(int paramInt, View paramView, boolean paramBoolean)
  {
    updateView(paramInt, null, null, paramView, paramBoolean);
  }
  
  public void updateView(int paramInt, String paramString1, String paramString2, View paramView, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserBaseView
 * JD-Core Version:    0.7.0.1
 */