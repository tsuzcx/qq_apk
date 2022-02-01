package com.tencent.richmediabrowser.core;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;

public class MainBrowserBuilder
  implements IBrowserBuilder
{
  private static final String TAG = "MainBrowserBuilder";
  private Activity mActivity;
  private MainBrowserModel model;
  private MainBrowserPresenter presenter;
  private MainBrowserScene scene;
  
  public MainBrowserBuilder(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void buildComplete()
  {
    this.presenter.buildComplete();
    this.scene.buildComplete();
    this.model.buildComplete();
  }
  
  public void buildModel()
  {
    this.model.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    RichMediaBrowserManager.getInstance().setApplicationContext(this.mActivity.getApplicationContext());
    this.presenter.buildParams(paramIntent);
    this.scene.buildParams(paramIntent);
    this.model.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.presenter = new MainBrowserPresenter();
    this.scene = new MainBrowserScene(this.mActivity, this.presenter);
    this.presenter.setGalleryScene(this.scene);
    this.model = new MainBrowserModel(this.presenter);
    this.presenter.setGalleryModel(this.model);
  }
  
  public void buildView(ViewGroup paramViewGroup)
  {
    this.scene.buildView(paramViewGroup);
  }
  
  public MainBrowserPresenter getPresenter()
  {
    return this.presenter;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.presenter != null) {
      this.presenter.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.presenter != null) {
      return this.presenter.onBackEvent();
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.presenter != null) {
      this.presenter.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    if (this.presenter != null) {
      this.presenter.onDestroy();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.presenter != null) {
      return this.presenter.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void onPause()
  {
    if (this.presenter != null) {
      this.presenter.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.presenter != null) {
      this.presenter.onResume();
    }
  }
  
  public void onStart()
  {
    if (this.presenter != null) {
      this.presenter.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.presenter != null) {
      this.presenter.onStop();
    }
  }
  
  public void onWindowFocusChanged()
  {
    if (this.presenter != null) {
      this.presenter.onWindowFocusChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.MainBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */