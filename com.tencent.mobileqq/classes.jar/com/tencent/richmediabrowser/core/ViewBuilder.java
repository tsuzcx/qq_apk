package com.tencent.richmediabrowser.core;

import android.content.Context;
import android.content.Intent;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.api.decorator.IDecoratorView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.presenter.BrowserBasePresenter;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.HashMap;

public class ViewBuilder
  implements IViewBuilder
{
  private static final String TAG = "ViewBuilder";
  private IBasePresenterBuilder basePresenter;
  private IDecoratorPresenter decoratorPresenter;
  private IDecoratorView decoratorView;
  private Context mContext;
  private int mType;
  private IBaseViewBuilder view;
  
  public ViewBuilder(Context paramContext, int paramInt, IBasePresenterBuilder paramIBasePresenterBuilder, IDecoratorPresenter paramIDecoratorPresenter)
  {
    this.mContext = paramContext;
    this.mType = paramInt;
    this.basePresenter = paramIBasePresenterBuilder;
    this.decoratorPresenter = paramIDecoratorPresenter;
  }
  
  public void buildComplete()
  {
    IBaseViewBuilder localIBaseViewBuilder = this.view;
    if (localIBaseViewBuilder != null) {
      localIBaseViewBuilder.buildComplete();
    }
  }
  
  public void buildInit()
  {
    Object localObject1 = this.basePresenter;
    if ((localObject1 instanceof BrowserBasePresenter))
    {
      Object localObject2 = (BrowserBasePresenter)localObject1;
      if (((BrowserBasePresenter)localObject2).mainBrowserPresenter != null)
      {
        localObject1 = new MVPFactory(((BrowserBasePresenter)localObject2).mainBrowserPresenter);
        int i = ((Integer)((BrowserBasePresenter)localObject2).mainBrowserPresenter.getParamsBuilder().jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(this.mType))).intValue();
        Object localObject3;
        if (i > 0)
        {
          localObject3 = BrowserLogHelper.getInstance().getGalleryLog();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("buildInit businessType = ");
          localStringBuilder.append(this.mType);
          localStringBuilder.append(", decoratorType = ");
          localStringBuilder.append(i);
          ((IBrowserLog)localObject3).d("ViewBuilder", 4, localStringBuilder.toString());
          this.view = ((MVPFactory)localObject1).createView(this.mContext, i, this.basePresenter);
          this.basePresenter.setBrowserView(this.view);
          if (((BrowserBasePresenter)localObject2).mainBrowserPresenter.getParamsBuilder().jdField_a_of_type_ComTencentRichmediabrowserCoreIDecoratorMvpFactory != null)
          {
            this.decoratorView = ((BrowserBasePresenter)localObject2).mainBrowserPresenter.getParamsBuilder().jdField_a_of_type_ComTencentRichmediabrowserCoreIDecoratorMvpFactory.a(this.mContext, this.mType, this.decoratorPresenter);
            this.decoratorView.a(this.view);
            this.decoratorPresenter.a(this.decoratorView);
            this.decoratorPresenter.a(this.basePresenter);
          }
        }
        else
        {
          localObject2 = BrowserLogHelper.getInstance().getGalleryLog();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("buildInit mType = ");
          ((StringBuilder)localObject3).append(this.mType);
          ((IBrowserLog)localObject2).d("ViewBuilder", 4, ((StringBuilder)localObject3).toString());
          this.view = ((MVPFactory)localObject1).createView(this.mContext, this.mType, this.basePresenter);
        }
      }
    }
  }
  
  public void buildParams(Intent paramIntent)
  {
    IBaseViewBuilder localIBaseViewBuilder = this.view;
    if (localIBaseViewBuilder != null) {
      localIBaseViewBuilder.buildParams(paramIntent);
    }
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
    return this.basePresenter;
  }
  
  public IBaseViewBuilder getView()
  {
    return this.view;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.ViewBuilder
 * JD-Core Version:    0.7.0.1
 */