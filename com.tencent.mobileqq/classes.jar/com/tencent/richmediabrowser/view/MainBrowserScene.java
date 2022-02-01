package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.listener.IBrowserItemScrollListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
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
  private boolean isNeedFullScreen = true;
  private volatile boolean isRemoveFullScreen = false;
  public Context mContext;
  public DragView mDragView;
  public Intent mIntent;
  
  public MainBrowserScene(Context paramContext, MainBrowserPresenter paramMainBrowserPresenter)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  private void setFullScreen(boolean paramBoolean)
  {
    Object localObject = this.mContext;
    if ((localObject instanceof Activity))
    {
      localObject = (Activity)localObject;
      if (paramBoolean)
      {
        localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
        localLayoutParams.flags |= 0x400;
        ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
        return;
      }
      WindowManager.LayoutParams localLayoutParams = ((Activity)localObject).getWindow().getAttributes();
      localLayoutParams.flags &= 0xFFFFFBFF;
      ((Activity)localObject).getWindow().setAttributes(localLayoutParams);
    }
  }
  
  public boolean back()
  {
    if (this.mContext != null)
    {
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MainBrowserScene.back[");
      localStringBuilder.append(this.mContext.hashCode());
      localStringBuilder.append("]");
      localIBrowserLog.i("RichMediaBrowserManager", 2, localStringBuilder.toString());
    }
    if ((this.isNeedFullScreen) && (!this.isRemoveFullScreen))
    {
      this.isRemoveFullScreen = true;
      setFullScreen(false);
    }
    return super.back();
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.mIntent = paramIntent;
    super.buildParams(paramIntent);
    if (this.scrollListener != null) {
      this.scrollListener.setBrowserItemScrollListener(this);
    }
    if (paramIntent != null) {
      this.isNeedFullScreen = paramIntent.getBooleanExtra("isNeedFullScreen", true);
    }
  }
  
  public void buildView()
  {
    super.buildView();
    initView();
  }
  
  protected BrowserAdapter createGalleryAdapter(Context paramContext)
  {
    this.mAdapter = new BrowserAdapter(paramContext);
    this.mAdapter.setPresenter(this.mainBrowserPresenter);
    return this.mAdapter;
  }
  
  public Rect getAnimationEndDstRect()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      return ((BrowserBaseView)localIBaseViewBuilder).getAnimationEndDstRect();
    }
    return null;
  }
  
  public BrowserAdapter.BrowserViewHolder getBrowserViewHolder(int paramInt)
  {
    if ((this.mainBrowserPresenter != null) && (this.recyclerView != null))
    {
      RecyclerView.ViewHolder localViewHolder = this.recyclerView.findViewHolderForAdapterPosition(paramInt);
      if ((localViewHolder instanceof BrowserAdapter.BrowserViewHolder)) {
        return (BrowserAdapter.BrowserViewHolder)localViewHolder;
      }
    }
    return null;
  }
  
  public IBaseViewBuilder getCurrentView()
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
  
  public IBaseViewBuilder getView(int paramInt)
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
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.recyclerView.scrollToPosition(this.mainBrowserPresenter.browserModel.getSelectedIndex());
    }
    this.recyclerView.setVisibility(0);
    this.mDragView = ((DragView)this.mRoot.findViewById(2131432158));
    this.mDragView.setGestureChangeListener(this);
    this.mDragView.setRatioModify(true);
    this.mDragView.init();
    if (this.mainBrowserPresenter != null) {
      this.mDragView.setEnableDrag(this.mainBrowserPresenter.getParamsBuilder().f);
    }
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    return ((localIBaseViewBuilder instanceof BrowserBaseView)) && (((BrowserBaseView)localIBaseViewBuilder).isNeedDisallowInterceptEvent(paramMotionEvent));
  }
  
  public boolean needEnterRectAnimation()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      return ((BrowserBaseView)localIBaseViewBuilder).needEnterRectAnimation();
    }
    return false;
  }
  
  public boolean needExitRectAnimation()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      return ((BrowserBaseView)localIBaseViewBuilder).needExitRectAnimation();
    }
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.mAdapter != null) {
      this.mAdapter.notifyDataSetChanged();
    }
  }
  
  public void notifyImageModelDataChanged()
  {
    if ((this.mAdapter != null) && (this.mainBrowserPresenter != null))
    {
      this.mAdapter.reset();
      notifyDataSetChanged();
      scrollToCurrentPosition();
      BrowserLogHelper.getInstance().getGalleryLog().e("MainBrowserScene", 2, "notifyImageModelDataChanged");
    }
  }
  
  public void notifyItemChanged(int paramInt)
  {
    this.mAdapter.notifyItemChanged(paramInt);
  }
  
  public void onClickDragView() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onContentMove(float paramFloat)
  {
    if ((this.isNeedFullScreen) && (!this.isRemoveFullScreen))
    {
      this.isRemoveFullScreen = true;
      setFullScreen(false);
    }
    this.bgView.setAlpha(paramFloat);
    if (paramFloat < 0.8F)
    {
      IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
      if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
        ((BrowserBaseView)localIBaseViewBuilder).updateUI();
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.mContext != null)
    {
      localObject = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MainBrowserScene.onDestroy[");
      localStringBuilder.append(this.mContext.hashCode());
      localStringBuilder.append("]");
      ((IBrowserLog)localObject).i("RichMediaBrowserManager", 2, localStringBuilder.toString());
    }
    super.onDestroy();
    Object localObject = this.mDragView;
    if (localObject != null)
    {
      ((DragView)localObject).setGestureChangeListener(null);
      this.mDragView.onDestroy();
      this.mDragView = null;
    }
    if (this.scrollListener != null)
    {
      this.scrollListener.setBrowserItemScrollListener(null);
      this.scrollListener = null;
    }
  }
  
  public void onDoubleTap()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onDoubleTap(this.mainBrowserPresenter.getCurrentPosition());
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    showContentView(true);
    Object localObject = getCurrentView();
    if ((localObject instanceof BrowserBaseView))
    {
      localObject = (BrowserBaseView)localObject;
      ((BrowserBaseView)localObject).isInEnterAnim = false;
      ((BrowserBaseView)localObject).onEnterAnimationEnd();
    }
  }
  
  public void onEnterAnimationStart()
  {
    super.onEnterAnimationStart();
    Object localObject = getCurrentView();
    if ((localObject instanceof BrowserBaseView))
    {
      localObject = (BrowserBaseView)localObject;
      ((BrowserBaseView)localObject).isInEnterAnim = true;
      ((BrowserBaseView)localObject).onEnterAnimationStart();
    }
  }
  
  public void onExitAnimationEnd()
  {
    super.onExitAnimationEnd();
    Object localObject = getCurrentView();
    if ((localObject instanceof BrowserBaseView))
    {
      localObject = (BrowserBaseView)localObject;
      ((BrowserBaseView)localObject).isInExitAnim = false;
      ((BrowserBaseView)localObject).onExitAnimationEnd();
    }
  }
  
  public void onExitAnimationStart()
  {
    super.onExitAnimationStart();
    Object localObject = getCurrentView();
    if ((localObject instanceof BrowserBaseView))
    {
      localObject = (BrowserBaseView)localObject;
      ((BrowserBaseView)localObject).isInExitAnim = true;
      ((BrowserBaseView)localObject).onExitAnimationStart();
    }
    showContentView(false);
  }
  
  public void onGestureFinish()
  {
    if (this.mContext != null)
    {
      localObject = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGestureFinish[");
      localStringBuilder.append(this.mContext.hashCode());
      localStringBuilder.append("]");
      ((IBrowserLog)localObject).i("RichMediaBrowserManager", 2, localStringBuilder.toString());
    }
    Object localObject = this.mContext;
    if ((localObject instanceof Activity)) {
      ((Activity)localObject).finish();
    }
  }
  
  public void onItemSelected(int paramInt)
  {
    super.onItemSelected(paramInt);
    IBaseViewBuilder localIBaseViewBuilder = getView(paramInt);
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onItemSelected(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt != 4) {
      return false;
    }
    return back();
  }
  
  public void onResetPosition()
  {
    if (this.mContext != null)
    {
      localObject = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onResetPosition[");
      localStringBuilder.append(this.mContext.hashCode());
      localStringBuilder.append("]");
      ((IBrowserLog)localObject).i("RichMediaBrowserManager", 2, localStringBuilder.toString());
    }
    if ((this.isNeedFullScreen) && (this.isRemoveFullScreen))
    {
      this.isRemoveFullScreen = false;
      setFullScreen(true);
    }
    Object localObject = getCurrentView();
    if ((localObject instanceof BrowserBaseView)) {
      ((BrowserBaseView)localObject).updateUI();
    }
  }
  
  public void onScale()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onScale(this.mainBrowserPresenter.getCurrentPosition());
    }
  }
  
  public void onScaleBegin()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onScaleBegin(this.mainBrowserPresenter.getCurrentPosition());
    }
  }
  
  public void onScaleEnd()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onScaleEnd(this.mainBrowserPresenter.getCurrentPosition());
    }
  }
  
  public void onScrollEnd()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onScrollEnd();
    }
  }
  
  public void onScrollHalfScreenWidth()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onScrollHalfScreenWidth();
    }
  }
  
  public void onScrollStart()
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onScrollStart();
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    IBaseViewBuilder localIBaseViewBuilder = getCurrentView();
    if ((localIBaseViewBuilder instanceof BrowserBaseView)) {
      ((BrowserBaseView)localIBaseViewBuilder).onShowAreaChanged(paramInt, paramView, paramRegionDrawableData);
    }
  }
  
  public void requestDisallowInterceptDragEvent(boolean paramBoolean)
  {
    DragView localDragView = this.mDragView;
    if (localDragView != null) {
      localDragView.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (this.recyclerView != null) {
      this.recyclerView.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void scrollToCurrentPosition()
  {
    if ((this.recyclerView != null) && (this.mainBrowserPresenter != null)) {
      this.recyclerView.scrollToPosition(this.mainBrowserPresenter.getCurrentPosition());
    }
  }
  
  public void updateSystemUIVisablity()
  {
    if (this.isNeedFullScreen)
    {
      this.isRemoveFullScreen = false;
      setFullScreen(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.MainBrowserScene
 * JD-Core Version:    0.7.0.1
 */