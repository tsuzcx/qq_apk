package com.tencent.richmediabrowser.core;

import android.content.Context;
import android.content.Intent;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorModel;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.HashMap;

public class BrowserBuilder
  implements IBrowserBuilder
{
  private static final String TAG = "BrowserBuilder";
  private IDecoratorModel decoratorModel;
  private IDecoratorPresenter decoratorPresenter;
  private IDecoratorView decoratorView;
  private Context mContext;
  private int mType;
  private IBaseModelBuilder model;
  private IBasePresenterBuilder presenter;
  private MainBrowserPresenter relyPresenter;
  private IBaseViewBuilder view;
  
  public BrowserBuilder(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
  }
  
  private void buildPresenter(int paramInt)
  {
    MVPFactory localMVPFactory = new MVPFactory(this.relyPresenter);
    this.presenter = localMVPFactory.createPresenter(paramInt);
    IBasePresenterBuilder localIBasePresenterBuilder = this.presenter;
    if (localIBasePresenterBuilder == null)
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserBuilder", 4, "buildPresenter presenter is null!");
      return;
    }
    localIBasePresenterBuilder.setRelyPresenter(this.relyPresenter);
    this.view = localMVPFactory.createView(this.mContext, paramInt, this.presenter);
    this.presenter.setBrowserView(this.view);
    this.model = localMVPFactory.createModel(paramInt, this.presenter);
    this.presenter.setBrowserModel(this.model);
    this.presenter.buildPresenter();
  }
  
  public void buildComplete()
  {
    Object localObject = this.presenter;
    if (localObject != null) {
      ((IBasePresenterBuilder)localObject).buildComplete();
    }
    localObject = this.view;
    if (localObject != null) {
      ((IBaseViewBuilder)localObject).buildComplete();
    }
    localObject = this.model;
    if (localObject != null) {
      ((IBaseModelBuilder)localObject).buildComplete();
    }
  }
  
  public void buildModel()
  {
    IBaseModelBuilder localIBaseModelBuilder = this.model;
    if (localIBaseModelBuilder != null) {
      localIBaseModelBuilder.buildModel();
    }
  }
  
  public void buildParams(Intent paramIntent)
  {
    Object localObject = this.presenter;
    if (localObject != null) {
      ((IBasePresenterBuilder)localObject).buildParams(paramIntent);
    }
    localObject = this.view;
    if (localObject != null) {
      ((IBaseViewBuilder)localObject).buildParams(paramIntent);
    }
    localObject = this.model;
    if (localObject != null) {
      ((IBaseModelBuilder)localObject).buildParams(paramIntent);
    }
  }
  
  public void buildPresenter()
  {
    if ((this.relyPresenter.getParamsBuilder() != null) && (this.relyPresenter.getParamsBuilder().c != null) && (this.relyPresenter.getParamsBuilder().c.get(Integer.valueOf(this.mType)) != null))
    {
      int i = ((Integer)this.relyPresenter.getParamsBuilder().c.get(Integer.valueOf(this.mType))).intValue();
      if (i > 0)
      {
        localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("buildPresenter businessType = ");
        localStringBuilder.append(this.mType);
        localStringBuilder.append(", decoratorType = ");
        localStringBuilder.append(i);
        localIBrowserLog.d("BrowserBuilder", 4, localStringBuilder.toString());
        buildPresenter(i);
        if (this.relyPresenter.getParamsBuilder().b != null)
        {
          this.decoratorPresenter = this.relyPresenter.getParamsBuilder().b.a(this.mType);
          this.decoratorPresenter.b(this.relyPresenter);
          this.decoratorView = this.relyPresenter.getParamsBuilder().b.a(this.mContext, this.mType, this.decoratorPresenter);
          this.decoratorModel = this.relyPresenter.getParamsBuilder().b.a(this.mType, this.decoratorPresenter);
          this.decoratorModel.a(this.model);
          this.decoratorView.a(this.view);
          this.decoratorPresenter.a(this.presenter);
          this.decoratorPresenter.a(this.decoratorModel);
          this.decoratorPresenter.a(this.decoratorView);
          return;
        }
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserBuilder", 4, "buildPresenter decoratorMvpFactory is null");
        return;
      }
      IBrowserLog localIBrowserLog = BrowserLogHelper.getInstance().getGalleryLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildPresenter mType = ");
      localStringBuilder.append(this.mType);
      localIBrowserLog.d("BrowserBuilder", 4, localStringBuilder.toString());
      buildPresenter(this.mType);
      return;
    }
    buildPresenter(this.mType);
  }
  
  public void buildView()
  {
    IBaseViewBuilder localIBaseViewBuilder = this.view;
    if (localIBaseViewBuilder != null) {
      localIBaseViewBuilder.buildView();
    }
  }
  
  public IDecoratorPresenter getDecoratorPresenter()
  {
    return this.decoratorPresenter;
  }
  
  public IBasePresenterBuilder getPresenter()
  {
    return this.presenter;
  }
  
  public IBaseViewBuilder getView()
  {
    return this.view;
  }
  
  public void setRelyPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.relyPresenter = paramMainBrowserPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.BrowserBuilder
 * JD-Core Version:    0.7.0.1
 */