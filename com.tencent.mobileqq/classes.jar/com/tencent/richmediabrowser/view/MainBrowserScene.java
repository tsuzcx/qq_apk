package com.tencent.richmediabrowser.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.page.AdapterView;
import com.tencent.richmediabrowser.view.page.DragGallery;
import com.tencent.richmediabrowser.view.page.DragView;
import com.tencent.richmediabrowser.view.page.DragView.OnGestureChangeListener;
import com.tencent.richmediabrowser.view.page.Gallery;
import com.tencent.richmediabrowser.view.page.ProGallery;
import com.tencent.richmediabrowser.view.page.ProGallery.OnProGalleryListener;
import com.tencent.richmediabrowser.view.progress.AbstractProgressView;

public class MainBrowserScene
  extends BrowserBaseScene
  implements DragView.OnGestureChangeListener
{
  private static final String TAG = "MainBrowserScene";
  private RelativeLayout contentView;
  private volatile boolean isRemoveFullScreen = false;
  public Activity mActivity;
  public BrowserAdapter mAdapter;
  public DragView mDragView;
  public Intent mIntent;
  public MainBrowserPresenter mainBrowserPresenter;
  
  public MainBrowserScene(Activity paramActivity, MainBrowserPresenter paramMainBrowserPresenter)
  {
    super(paramActivity);
    this.mActivity = paramActivity;
    this.mainBrowserPresenter = paramMainBrowserPresenter;
    super.setPresenter(this.mainBrowserPresenter);
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
    boolean bool2 = false;
    if (!this.isRemoveFullScreen)
    {
      this.isRemoveFullScreen = true;
      setFullScreen(false);
    }
    super.back();
    boolean bool1 = bool2;
    if (this.mAdapter != null)
    {
      bool1 = bool2;
      if (this.mAdapter.getCurrentView() != null) {
        bool1 = this.mAdapter.getCurrentView().back();
      }
    }
    return bool1;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
    this.mIntent = paramIntent;
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    super.buildView(paramViewGroup);
    initView();
  }
  
  protected BrowserAdapter createGalleryAdapter(Context paramContext)
  {
    this.mAdapter = new BrowserAdapter(paramContext);
    this.mAdapter.setPresenter(this.mainBrowserPresenter);
    if ((ProGallery.OnProGalleryListener.class.isInstance(this.mAdapter)) && (ProGallery.class.isInstance(this.mGallery))) {
      ((ProGallery)this.mGallery).setOnNoBlankListener(this.mAdapter);
    }
    return this.mAdapter;
  }
  
  protected RelativeLayout createLayout()
  {
    return (RelativeLayout)LayoutInflater.from(this.mContext).inflate(2131559246, null);
  }
  
  public RelativeLayout getContentView()
  {
    return this.contentView;
  }
  
  public BrowserBaseView getCurrentView()
  {
    if (this.mAdapter != null) {
      return this.mAdapter.getCurrentView();
    }
    return null;
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    return this.mAdapter.getItem(paramInt);
  }
  
  public void hideProgress()
  {
    if (this.progressView != null) {
      this.progressView.hide();
    }
  }
  
  public void initView()
  {
    this.contentView = ((RelativeLayout)this.rootView.findViewById(2131364771));
    if ((this.mainBrowserPresenter != null) && (this.mainBrowserPresenter.browserModel != null)) {
      this.mGallery.setSelection(this.mainBrowserPresenter.browserModel.getSelectedIndex());
    }
    this.mGallery.setVisibility(0);
    if ((this.mGallery instanceof DragGallery)) {
      ((DragGallery)this.mGallery).setGalleryScaleListener(this.mAdapter);
    }
    this.mDragView = ((DragView)this.mRoot.findViewById(2131365489));
    this.mDragView.setGestureChangeListener(this);
    this.mDragView.setRatioModify(true);
    this.mDragView.init();
  }
  
  public boolean needShowPageView()
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    this.mAdapter.notifyDataSetChanged();
  }
  
  public void notifyImageModelDataChanged()
  {
    if ((this.mAdapter != null) && (this.mainBrowserPresenter != null))
    {
      this.mAdapter.notifyDataSetChanged();
      this.mGallery.setSelection(this.mainBrowserPresenter.getCurrentPosition());
      BrowserLogHelper.getInstance().getGalleryLog().e("MainBrowserScene", 2, "notifyImageModelDataChanged");
    }
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().notifyImageModelDataChanged();
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onClickDragView() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onConfigurationChanged(paramConfiguration);
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
    if ((paramFloat < 0.8F) && (this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().updateUI();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onDestroy();
    }
    if (this.contentView != null) {
      this.contentView.removeAllViews();
    }
    if (this.mDragView != null) {
      this.mDragView.onDestroy();
    }
  }
  
  public void onEnterAnimationEnd()
  {
    super.onEnterAnimationEnd();
    showContentView(true);
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null))
    {
      this.mAdapter.getCurrentView().onEnterAnimationEnd();
      this.mAdapter.getCurrentView().isInEnterAnim = false;
    }
  }
  
  public void onEnterAnimationStart()
  {
    super.onEnterAnimationStart();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null))
    {
      this.mAdapter.getCurrentView().onEnterAnimationStart();
      this.mAdapter.getCurrentView().isInEnterAnim = true;
    }
  }
  
  public void onExitAnimationEnd()
  {
    super.onExitAnimationEnd();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null))
    {
      this.mAdapter.getCurrentView().onExitAnimationEnd();
      this.mAdapter.getCurrentView().isInExitAnim = false;
    }
  }
  
  public void onExitAnimationStart()
  {
    super.onExitAnimationStart();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null))
    {
      this.mAdapter.getCurrentView().onExitAnimationStart();
      this.mAdapter.getCurrentView().isInExitAnim = true;
    }
    showContentView(false);
  }
  
  public void onGestureFinish()
  {
    this.mContext.finish();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      return this.mAdapter.getCurrentView().onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    return super.onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    super.onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
    if ((this.mAdapter != null) && (this.mainBrowserPresenter != null))
    {
      this.mAdapter.onItemSelected(paramInt);
      this.mainBrowserPresenter.browserModel.setSelectedIndex(paramInt);
      if (this.mAdapter.getCurrentView() != null) {
        this.mAdapter.getCurrentView().onItemSelected(paramAdapterView, paramView, paramInt, paramLong);
      }
    }
    if (this.mainBrowserPresenter != null) {
      this.mainBrowserPresenter.onItemSelect(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
    case 82: 
      do
      {
        return super.onKeyDown(paramInt, paramKeyEvent);
      } while ((this.mAdapter == null) || (this.mAdapter.getCurrentView() == null));
      return this.mAdapter.getCurrentView().onKeyDown(paramInt, paramKeyEvent);
    }
    return back();
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    this.mAdapter.onLoadFinish(paramInt, paramBoolean);
  }
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    this.mAdapter.onLoadStart(paramInt1, paramInt2);
  }
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    this.mAdapter.onLoadFinish(paramInt, paramBoolean);
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onPause();
    }
  }
  
  public void onResetPosition()
  {
    if (this.isRemoveFullScreen)
    {
      this.isRemoveFullScreen = false;
      setFullScreen(true);
    }
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().updateUI();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onResume();
    }
  }
  
  public void onRotateFinished(View paramView, int paramInt1, int paramInt2) {}
  
  public void onScrollEnd(int paramInt)
  {
    super.onScrollEnd(paramInt);
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onScrollEnd(paramInt);
    }
  }
  
  public void onScrollStart(int paramInt)
  {
    super.onScrollStart(paramInt);
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onScrollStart(paramInt);
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if ((this.mAdapter != null) && (this.mAdapter.getCurrentView() != null)) {
      this.mAdapter.getCurrentView().onStop();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.MainBrowserScene
 * JD-Core Version:    0.7.0.1
 */