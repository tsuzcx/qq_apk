package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.listener.IBrowserItemScrollListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter.BrowserViewHolder;
import com.tencent.richmediabrowser.view.recyclerview.BrowserRecyclerView;
import com.tencent.richmediabrowser.view.recyclerview.BrowserScrollListener;
import com.tencent.richmediabrowser.view.recyclerview.DragView;
import com.tencent.richmediabrowser.view.recyclerview.DragView.OnGestureChangeListener;

public class MainBrowserScene
  extends BrowserBaseScene
  implements IBrowserItemScrollListener, DragView.OnGestureChangeListener
{
  private static final String TAG = "MainBrowserScene";
  private RelativeLayout contentView;
  private volatile boolean isRemoveFullScreen = false;
  public Activity mActivity;
  public DragView mDragView;
  public Intent mIntent;
  
  public MainBrowserScene(Activity paramActivity, MainBrowserPresenter paramMainBrowserPresenter)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  private void setFullScreen(boolean paramBoolean)
  {
    if ((this.mActivity != null) && (this.mActivity.getWindow() != null))
    {
      if (paramBoolean)
      {
        localLayoutParams = this.mActivity.getWindow().getAttributes();
        localLayoutParams.flags |= 0x400;
        this.mActivity.getWindow().setAttributes(localLayoutParams);
      }
    }
    else {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = this.mActivity.getWindow().getAttributes();
    localLayoutParams.flags &= 0xFFFFFBFF;
    this.mActivity.getWindow().setAttributes(localLayoutParams);
  }
  
  public boolean back()
  {
    if (!this.isRemoveFullScreen)
    {
      this.isRemoveFullScreen = true;
      setFullScreen(false);
    }
    super.back();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.back();
    }
    return false;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.mIntent = paramIntent;
    this.scrollListener.setBrowserItemScrollListener(this);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    initView();
  }
  
  protected BrowserAdapter createGalleryAdapter(Activity paramActivity)
  {
    this.mAdapter = new BrowserAdapter(paramActivity);
    this.mAdapter.setPresenter(this.mainBrowserPresenter);
    return this.mAdapter;
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559450, null);
  }
  
  public RelativeLayout getContentView()
  {
    return this.contentView;
  }
  
  public BrowserBaseView getCurrentView()
  {
    return getView(this.mainBrowserPresenter.getCurrentPosition());
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    return this.mAdapter.getItem(paramInt);
  }
  
  public int getLastVisibleItemPosition()
  {
    if (this.linearLayoutManager != null) {
      return this.linearLayoutManager.findLastVisibleItemPosition();
    }
    return -1;
  }
  
  public BrowserBaseView getView(int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.recyclerView != null))
    {
      RecyclerView.ViewHolder localViewHolder = this.recyclerView.findViewHolderForAdapterPosition(paramInt);
      if ((localViewHolder instanceof BrowserAdapter.BrowserViewHolder)) {
        return ((BrowserAdapter.BrowserViewHolder)localViewHolder).itemView;
      }
    }
    return null;
  }
  
  public void initView()
  {
    this.contentView = ((RelativeLayout)this.rootView.findViewById(2131365294));
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.recyclerView.scrollToPosition(this.mainBrowserPresenter.browserModel.getSelectedIndex());
    }
    this.recyclerView.setVisibility(0);
    this.mDragView = ((DragView)this.mRoot.findViewById(2131366062));
    this.mDragView.setGestureChangeListener(this);
    this.mDragView.setRatioModify(true);
    this.mDragView.init();
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    return (localBrowserBaseView != null) && (localBrowserBaseView.isNeedDisallowInterceptEvent(paramMotionEvent));
  }
  
  public void notifyDataSetChanged()
  {
    this.mAdapter.notifyDataSetChanged();
  }
  
  public void notifyImageModelDataChanged()
  {
    if ((this.mAdapter != null) && (this.mainBrowserPresenter != null))
    {
      this.mAdapter.reset();
      this.mAdapter.notifyDataSetChanged();
      this.recyclerView.scrollToPosition(this.mainBrowserPresenter.getCurrentPosition());
      BrowserLogHelper.getInstance().getGalleryLog().e("MainBrowserScene", 2, "notifyImageModelDataChanged");
    }
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.notifyImageModelDataChanged();
    }
  }
  
  public void notifyItemChanged(int paramInt)
  {
    this.mAdapter.notifyItemChanged(paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onClickDragView() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentMove(float paramFloat)
  {
    if (!this.isRemoveFullScreen)
    {
      this.isRemoveFullScreen = true;
      setFullScreen(false);
    }
    this.bgView.setAlpha(paramFloat);
    if (paramFloat < 0.8F)
    {
      BrowserBaseView localBrowserBaseView = getCurrentView();
      if (localBrowserBaseView != null) {
        localBrowserBaseView.updateUI();
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onDestroy();
    }
    if (this.contentView != null) {
      this.contentView.removeAllViews();
    }
    if (this.mDragView != null) {
      this.mDragView.onDestroy();
    }
  }
  
  public void onDoubleTap()
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onDoubleTap();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    showContentView(true);
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null)
    {
      localBrowserBaseView.onEnterAnimationEnd();
      localBrowserBaseView.isInEnterAnim = false;
    }
  }
  
  public void onEnterAnimationStart()
  {
    super.onEnterAnimationStart();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null)
    {
      localBrowserBaseView.onEnterAnimationStart();
      localBrowserBaseView.isInEnterAnim = true;
    }
  }
  
  public void onExitAnimationEnd()
  {
    super.onExitAnimationEnd();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null)
    {
      localBrowserBaseView.onExitAnimationEnd();
      localBrowserBaseView.isInExitAnim = false;
    }
  }
  
  public void onExitAnimationStart()
  {
    super.onExitAnimationStart();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null)
    {
      localBrowserBaseView.onExitAnimationStart();
      localBrowserBaseView.isInExitAnim = true;
    }
    showContentView(false);
  }
  
  public void onGestureFinish()
  {
    this.mContext.finish();
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    BrowserBaseView localBrowserBaseView = getView(paramInt);
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onItemSelected(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
    case 82: 
      BrowserBaseView localBrowserBaseView;
      do
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
        localBrowserBaseView = getCurrentView();
      } while (localBrowserBaseView == null);
      return localBrowserBaseView.onKeyDown(paramInt, paramKeyEvent);
    }
    return back();
  }
  
  public void onPause()
  {
    super.onPause();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onPause();
    }
  }
  
  public void onResetPosition()
  {
    if (this.isRemoveFullScreen)
    {
      this.isRemoveFullScreen = false;
      setFullScreen(true);
    }
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.updateUI();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onResume();
    }
  }
  
  public void onScale()
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onScale();
    }
  }
  
  public void onScaleBegin()
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onScaleBegin();
    }
  }
  
  public void onScaleEnd()
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onScaleEnd();
    }
  }
  
  public void onScrollEnd()
  {
    if (this.mainBrowserPresenter != null)
    {
      BrowserBasePresenter localBrowserBasePresenter = this.mainBrowserPresenter.getCurrentPresenter();
      if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null)) {
        localBrowserBasePresenter.browserBaseView.onScrollEnd();
      }
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onScrollHalfScreenWidth();
    }
  }
  
  public void onScrollStart()
  {
    if (this.mainBrowserPresenter != null)
    {
      BrowserBasePresenter localBrowserBasePresenter = this.mainBrowserPresenter.getCurrentPresenter();
      if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null)) {
        localBrowserBasePresenter.browserBaseView.onScrollStart();
      }
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    BrowserBaseView localBrowserBaseView = getCurrentView();
    if (localBrowserBaseView != null) {
      localBrowserBaseView.onStop();
    }
  }
  
  public void requestDisallowInterceptDragEvent(boolean paramBoolean)
  {
    if (this.mDragView != null) {
      this.mDragView.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (this.recyclerView != null) {
      this.recyclerView.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout;
    if (this.contentView != null)
    {
      localRelativeLayout = this.contentView;
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
  
  public void updateSystemUIVisablity()
  {
    this.isRemoveFullScreen = false;
    setFullScreen(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.MainBrowserScene
 * JD-Core Version:    0.7.0.1
 */