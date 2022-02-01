package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.api.decorator.IDecoratorPresenter;
import com.tencent.richmediabrowser.api.event.IActivityEvent;
import com.tencent.richmediabrowser.core.BrowserBuilder;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import com.tencent.richmediabrowser.view.recyclerview.BrowserAdapter.BrowserViewHolder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class MainBrowserPresenter
  implements IActivityEvent, IBasePresenterBuilder, IDownloadEventListener
{
  private static final String TAG = "MainBrowserPresenter";
  public IActivityEvent activityEventListener;
  public MainBrowserModel browserModel;
  public MainBrowserScene browserScene;
  public ConcurrentHashMap<Integer, IDecoratorPresenter> decoratorPresenterMap = new ConcurrentHashMap();
  private BrowserParamsBuilder paramsBuilder;
  private ConcurrentHashMap<Integer, IBasePresenterBuilder> presenterMap = new ConcurrentHashMap();
  
  public void buildComplete() {}
  
  public IBaseViewBuilder buildItemView(int paramInt)
  {
    BrowserBuilder localBrowserBuilder = new BrowserBuilder(this.browserScene.mContext, paramInt);
    localBrowserBuilder.setRelyPresenter(this);
    new BrowserDirector().construct(localBrowserBuilder, this.browserScene.mIntent);
    if ((localBrowserBuilder.getPresenter() instanceof BrowserBasePresenter))
    {
      ((BrowserBasePresenter)localBrowserBuilder.getPresenter()).setMainBrowserPresenter(this);
      this.presenterMap.put(Integer.valueOf(paramInt), localBrowserBuilder.getPresenter());
      if (localBrowserBuilder.getDecoratorPresenter() != null) {
        this.decoratorPresenterMap.put(Integer.valueOf(paramInt), localBrowserBuilder.getDecoratorPresenter());
      }
    }
    return localBrowserBuilder.getView();
  }
  
  public void buildParams(Intent paramIntent) {}
  
  public void buildPresenter() {}
  
  public boolean enableScrollLeft()
  {
    return getCurrentPosition() != 0;
  }
  
  public boolean enableScrollRight()
  {
    return getCurrentPosition() != getItemCount() - 1;
  }
  
  public Rect getAnimationEndDstRect()
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      return localMainBrowserScene.getAnimationEndDstRect();
    }
    return null;
  }
  
  public IDecoratorPresenter getCurrentDecoratorPresenter()
  {
    Object localObject = this.browserModel;
    if (localObject != null)
    {
      localObject = ((MainBrowserModel)localObject).getItem(getCurrentPosition());
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
        return (IDecoratorPresenter)this.decoratorPresenterMap.get(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()));
      }
    }
    return null;
  }
  
  public int getCurrentPosition()
  {
    MainBrowserModel localMainBrowserModel = this.browserModel;
    if (localMainBrowserModel != null) {
      return localMainBrowserModel.getSelectedIndex();
    }
    return 0;
  }
  
  public IBasePresenterBuilder getCurrentPresenter()
  {
    Object localObject = this.browserModel;
    if (localObject != null)
    {
      localObject = ((MainBrowserModel)localObject).getItem(getCurrentPosition());
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
        return (IBasePresenterBuilder)this.presenterMap.get(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()));
      }
    }
    return null;
  }
  
  public int getCurrentType()
  {
    Object localObject = this.browserModel;
    if (localObject != null)
    {
      localObject = ((MainBrowserModel)localObject).getItem(getCurrentPosition());
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null)) {
        return ((RichMediaBrowserInfo)localObject).baseData.getType();
      }
    }
    return 0;
  }
  
  public IDecoratorPresenter getDecoratorPresenter(int paramInt)
  {
    return (IDecoratorPresenter)this.decoratorPresenterMap.get(Integer.valueOf(paramInt));
  }
  
  public int getItemCount()
  {
    MainBrowserModel localMainBrowserModel = this.browserModel;
    if (localMainBrowserModel != null) {
      return localMainBrowserModel.getCount();
    }
    return 0;
  }
  
  public int getLastVisibleItemPosition()
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      return localMainBrowserScene.getLastVisibleItemPosition();
    }
    return 0;
  }
  
  public BrowserParamsBuilder getParamsBuilder()
  {
    if (this.paramsBuilder == null) {
      this.paramsBuilder = new BrowserParamsBuilder();
    }
    return this.paramsBuilder;
  }
  
  public IBasePresenterBuilder getPresenter(int paramInt)
  {
    return (IBasePresenterBuilder)this.presenterMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean isCurrentView(String paramString)
  {
    Object localObject = this.browserModel;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = this.browserModel.getItem(getCurrentPosition());
        bool1 = bool2;
        if (localObject != null)
        {
          bool1 = bool2;
          if (((RichMediaBrowserInfo)localObject).baseData != null)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(((RichMediaBrowserInfo)localObject).baseData.id))
            {
              bool1 = bool2;
              if (paramString.equals(((RichMediaBrowserInfo)localObject).baseData.id)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public boolean isNeedDisallowInterceptEvent(MotionEvent paramMotionEvent)
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    return (localMainBrowserScene != null) && (localMainBrowserScene.isNeedDisallowInterceptEvent(paramMotionEvent));
  }
  
  public void notifyImageListChanged(List<RichMediaBrowserInfo> paramList, int paramInt)
  {
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    Object localObject = BrowserLogHelper.getInstance().getGalleryLog();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyImageListChanged list size ");
    localStringBuilder.append(i);
    localStringBuilder.append(", selected ");
    localStringBuilder.append(paramInt);
    ((IBrowserLog)localObject).i("MainBrowserPresenter", 2, localStringBuilder.toString());
    localObject = this.browserModel;
    if (localObject != null)
    {
      ((MainBrowserModel)localObject).updateList(paramList);
      this.browserModel.setSelectedIndex(paramInt);
    }
    paramList = this.browserScene;
    if (paramList != null) {
      paramList.notifyImageModelDataChanged();
    }
  }
  
  public void notifyProgress(String paramString, int paramInt)
  {
    Object localObject = this.browserModel;
    if (localObject != null)
    {
      localObject = ((MainBrowserModel)localObject).getItem(paramString);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = (IBasePresenterBuilder)this.presenterMap.get(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()));
        if ((localObject instanceof BrowserBasePresenter)) {
          ((BrowserBasePresenter)localObject).notifyProgress(paramString, paramInt);
        }
      }
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    Object localObject = this.browserModel;
    if (localObject != null)
    {
      localObject = ((MainBrowserModel)localObject).getItem(paramString);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = (IBasePresenterBuilder)this.presenterMap.get(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()));
        if ((localObject instanceof BrowserBasePresenter)) {
          ((BrowserBasePresenter)localObject).notifyResult(paramString, paramInt);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    Object localObject = this.browserScene;
    if (localObject != null) {
      ((MainBrowserScene)localObject).back();
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onBackEvent();
    }
    localObject = this.activityEventListener;
    if (localObject != null) {
      return ((IActivityEvent)localObject).onBackEvent();
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Object localObject = this.browserScene;
    if (localObject != null) {
      ((MainBrowserScene)localObject).onConfigurationChanged(paramConfiguration);
    }
    localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onConfigurationChanged(paramConfiguration);
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onCreate(paramBundle);
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onCreate(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    Object localObject1 = this.presenterMap.values().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (IBasePresenterBuilder)((Iterator)localObject1).next();
      if ((localObject2 instanceof BrowserBasePresenter))
      {
        localObject2 = (BrowserBasePresenter)localObject2;
        ((BrowserBasePresenter)localObject2).onDestroy();
        if (((BrowserBasePresenter)localObject2).browserBaseView != null) {
          ((BrowserBasePresenter)localObject2).browserBaseView.onDestroy();
        }
      }
    }
    localObject1 = this.activityEventListener;
    if (localObject1 != null) {
      ((IActivityEvent)localObject1).onDestroy();
    }
    this.presenterMap.clear();
    this.decoratorPresenterMap.clear();
    localObject1 = this.browserScene;
    if (localObject1 != null) {
      ((MainBrowserScene)localObject1).onDestroy();
    }
  }
  
  public void onDoubleTap()
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.onDoubleTap();
    }
  }
  
  public void onItemSelect(int paramInt)
  {
    Object localObject = this.browserModel;
    if (localObject != null)
    {
      ((MainBrowserModel)localObject).setSelectedIndex(paramInt);
      localObject = this.browserModel.getItem(paramInt);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        BrowserAdapter.BrowserViewHolder localBrowserViewHolder = this.browserScene.getBrowserViewHolder(paramInt);
        if (localBrowserViewHolder != null)
        {
          if (localBrowserViewHolder.decoratorPresenter != null) {
            this.decoratorPresenterMap.put(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()), localBrowserViewHolder.decoratorPresenter);
          }
          if (localBrowserViewHolder.presenterBuilder != null) {
            this.presenterMap.put(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()), localBrowserViewHolder.presenterBuilder);
          }
          if ((localBrowserViewHolder.presenterBuilder instanceof BrowserBasePresenter)) {
            ((BrowserBasePresenter)localBrowserViewHolder.presenterBuilder).onItemSelect(paramInt);
          }
        }
      }
    }
    localObject = this.browserScene;
    if (localObject != null) {
      ((MainBrowserScene)localObject).onItemSelected(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    Object localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onKeyDown(paramInt, paramKeyEvent);
    }
    localObject = this.browserScene;
    if (localObject != null) {
      return ((MainBrowserScene)localObject).onKeyDown(paramInt, paramKeyEvent);
    }
    localObject = this.activityEventListener;
    if (localObject != null) {
      return ((IActivityEvent)localObject).onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void onPause()
  {
    Object localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onPause();
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onPause();
    }
  }
  
  public void onResume()
  {
    Object localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onResume();
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onResume();
    }
  }
  
  public void onScale()
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.onScale();
    }
  }
  
  public void onScaleBegin()
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.onScaleBegin();
    }
  }
  
  public void onScaleEnd()
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.onScaleEnd();
    }
  }
  
  public void onShowAreaChanged(View paramView, RegionDrawableData paramRegionDrawableData)
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.onShowAreaChanged(getCurrentPosition(), paramView, paramRegionDrawableData);
    }
  }
  
  public void onStart()
  {
    Object localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onStart();
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onStart();
    }
  }
  
  public void onStop()
  {
    Object localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onStop();
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onStop();
    }
  }
  
  public void onWindowFocusChanged()
  {
    Object localObject = this.browserScene;
    if (localObject != null) {
      ((MainBrowserScene)localObject).onWindowFocusChanged();
    }
    localObject = this.activityEventListener;
    if (localObject != null) {
      ((IActivityEvent)localObject).onWindowFocusChanged();
    }
    localObject = getPresenter(getCurrentType());
    if ((localObject instanceof BrowserBasePresenter)) {
      ((BrowserBasePresenter)localObject).onWindowFocusChanged();
    }
  }
  
  public void requestDisallowInterceptDragEvent(boolean paramBoolean)
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.requestDisallowInterceptDragEvent(paramBoolean);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    MainBrowserScene localMainBrowserScene = this.browserScene;
    if (localMainBrowserScene != null) {
      localMainBrowserScene.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void resetItemView(int paramInt) {}
  
  public void setActivityEventListener(IActivityEvent paramIActivityEvent)
  {
    this.activityEventListener = paramIActivityEvent;
  }
  
  public void setBrowserModel(IBaseModelBuilder paramIBaseModelBuilder)
  {
    if ((paramIBaseModelBuilder instanceof MainBrowserModel)) {
      this.browserModel = ((MainBrowserModel)paramIBaseModelBuilder);
    }
  }
  
  public void setBrowserScene(MainBrowserScene paramMainBrowserScene)
  {
    this.browserScene = paramMainBrowserScene;
  }
  
  public void setBrowserView(IBaseViewBuilder paramIBaseViewBuilder) {}
  
  public void setParamsBuilder(BrowserParamsBuilder paramBrowserParamsBuilder)
  {
    this.paramsBuilder = paramBrowserParamsBuilder;
  }
  
  public void setRelyPresenter(IBasePresenterBuilder paramIBasePresenterBuilder) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.MainBrowserPresenter
 * JD-Core Version:    0.7.0.1
 */