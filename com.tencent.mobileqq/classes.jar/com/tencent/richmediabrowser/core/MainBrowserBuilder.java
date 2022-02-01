package com.tencent.richmediabrowser.core;

import android.content.Context;
import android.content.Intent;
import android.widget.RelativeLayout;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import com.tencent.richmediabrowser.view.MainBrowserScene;

public class MainBrowserBuilder
  implements IBrowserBuilder
{
  private static final String TAG = "MainBrowserBuilder";
  private Context mContext;
  private MainBrowserModel model;
  private MainBrowserPresenter presenter;
  private MainBrowserScene scene;
  
  public MainBrowserBuilder(Context paramContext)
  {
    this.mContext = paramContext;
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
    this.presenter.buildParams(paramIntent);
    this.scene.buildParams(paramIntent);
    this.model.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.presenter = new MainBrowserPresenter();
    this.scene = new MainBrowserScene(this.mContext, this.presenter);
    this.presenter.setBrowserScene(this.scene);
    this.model = new MainBrowserModel(this.presenter);
    this.presenter.setBrowserModel(this.model);
  }
  
  public void buildView()
  {
    this.scene.buildView();
  }
  
  public RelativeLayout getMainView()
  {
    MainBrowserScene localMainBrowserScene = this.scene;
    if (localMainBrowserScene != null) {
      return localMainBrowserScene.getRootView();
    }
    return null;
  }
  
  public MainBrowserPresenter getPresenter()
  {
    return this.presenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.MainBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */