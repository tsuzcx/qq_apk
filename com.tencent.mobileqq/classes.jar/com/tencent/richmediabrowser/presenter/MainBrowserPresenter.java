package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.image.RegionDrawableData;
import com.tencent.richmediabrowser.core.BrowserBuilder;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.core.IBrowserBuilder;
import com.tencent.richmediabrowser.core.IViewBuilder;
import com.tencent.richmediabrowser.core.ViewBuilder;
import com.tencent.richmediabrowser.download.HttpDownloadManager;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.listener.IVideoEnventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.video.VideoPresenter;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MainBrowserPresenter
  extends BasePresenter
  implements IDownloadEventListener, IVideoEnventListener
{
  private static final String TAG = "MainBrowserPresenter";
  public MainBrowserModel browserModel;
  public MainBrowserScene browserScene;
  private ConcurrentHashMap<Integer, BrowserBasePresenter> presenterMap = new ConcurrentHashMap();
  
  public void buildComplete() {}
  
  public BrowserBaseView buildItemView(int paramInt)
  {
    if (this.presenterMap.containsKey(Integer.valueOf(paramInt)))
    {
      localObject = new ViewBuilder(this.browserScene.mContext, paramInt, getPresenter(paramInt));
      new BrowserDirector().constructItemView((IViewBuilder)localObject, this.browserScene.mIntent);
      return ((ViewBuilder)localObject).getView();
    }
    Object localObject = new BrowserBuilder(this.browserScene.mContext, paramInt);
    ((BrowserBuilder)localObject).setRelyPresenter(this);
    new BrowserDirector().construct((IBrowserBuilder)localObject, this.browserScene.mIntent);
    if ((((BrowserBuilder)localObject).getPresenter() instanceof BrowserBasePresenter))
    {
      ((BrowserBasePresenter)((BrowserBuilder)localObject).getPresenter()).setMainBrowserPresenter(this);
      this.presenterMap.put(Integer.valueOf(paramInt), (BrowserBasePresenter)((BrowserBuilder)localObject).getPresenter());
    }
    return ((BrowserBuilder)localObject).getView();
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
    BrowserBasePresenter localBrowserBasePresenter = getCurrentPresenter();
    if ((localBrowserBasePresenter != null) && (localBrowserBasePresenter.browserBaseView != null)) {
      return localBrowserBasePresenter.browserBaseView.getAnimationEndDstRect();
    }
    return null;
  }
  
  public int getCurrentPosition()
  {
    if (this.browserModel != null) {
      return this.browserModel.getSelectedIndex();
    }
    return -1;
  }
  
  public BrowserBasePresenter getCurrentPresenter()
  {
    if (this.browserModel != null)
    {
      RichMediaBrowserInfo localRichMediaBrowserInfo = this.browserModel.getItem(getCurrentPosition());
      if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null)) {
        return (BrowserBasePresenter)this.presenterMap.get(Integer.valueOf(localRichMediaBrowserInfo.baseData.getType()));
      }
    }
    return null;
  }
  
  public int getItemCount()
  {
    if (this.browserModel != null) {
      return this.browserModel.getCount();
    }
    return 0;
  }
  
  public int getLastVisibleItemPosition()
  {
    if (this.browserScene != null) {
      return this.browserScene.getLastVisibleItemPosition();
    }
    return -1;
  }
  
  public BrowserBasePresenter getPresenter(int paramInt)
  {
    return (BrowserBasePresenter)this.presenterMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean isCurrentView(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.browserModel != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = this.browserModel.getItem(getCurrentPosition());
        bool1 = bool2;
        if (localRichMediaBrowserInfo != null)
        {
          bool1 = bool2;
          if (localRichMediaBrowserInfo.baseData != null)
          {
            bool1 = bool2;
            if (!TextUtils.isEmpty(localRichMediaBrowserInfo.baseData.id))
            {
              bool1 = bool2;
              if (paramString.equals(localRichMediaBrowserInfo.baseData.id)) {
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
    return (this.browserScene != null) && (this.browserScene.isNeedDisallowInterceptEvent(paramMotionEvent));
  }
  
  public boolean needEnterRectAnimation()
  {
    if (this.browserScene != null)
    {
      BrowserBaseView localBrowserBaseView = this.browserScene.getCurrentView();
      if (localBrowserBaseView != null) {
        return localBrowserBaseView.needEnterRectAnimation();
      }
    }
    return true;
  }
  
  public boolean needExitRectAnimation()
  {
    if (this.browserScene != null)
    {
      BrowserBaseView localBrowserBaseView = this.browserScene.getCurrentView();
      if (localBrowserBaseView != null) {
        return localBrowserBaseView.needExitRectAnimation();
      }
    }
    return true;
  }
  
  public void notifyImageListChanged(List<RichMediaBrowserInfo> paramList, int paramInt)
  {
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      BrowserLogHelper.getInstance().getGalleryLog().i("MainBrowserPresenter", 2, "notifyImageListChanged list size " + i + ", selected " + paramInt);
      if (this.browserModel != null) {
        this.browserModel.updateList(paramList);
      }
      if (this.browserScene != null) {
        this.browserScene.notifyImageModelDataChanged();
      }
      return;
    }
  }
  
  public void notifyProgress(String paramString, int paramInt)
  {
    if (this.browserModel != null)
    {
      Object localObject = this.browserModel.getItem(paramString);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = (BrowserBasePresenter)this.presenterMap.get(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()));
        if (localObject != null) {
          ((BrowserBasePresenter)localObject).notifyProgress(paramString, paramInt);
        }
      }
    }
  }
  
  public void notifyResult(String paramString, int paramInt)
  {
    if (this.browserModel != null)
    {
      Object localObject = this.browserModel.getItem(paramString);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = (BrowserBasePresenter)this.presenterMap.get(Integer.valueOf(((RichMediaBrowserInfo)localObject).baseData.getType()));
        if (localObject != null) {
          ((BrowserBasePresenter)localObject).notifyResult(paramString, paramInt);
        }
      }
    }
  }
  
  public void notifyVideoUrl(String paramString1, String paramString2)
  {
    if (this.browserModel != null)
    {
      paramString1 = this.browserModel.getItem(paramString1);
      if ((paramString1 != null) && (paramString1.baseData != null))
      {
        paramString1 = (BrowserBasePresenter)this.presenterMap.get(Integer.valueOf(paramString1.baseData.getType()));
        if ((paramString1 instanceof VideoPresenter)) {
          paramString1 = (VideoPresenter)paramString1;
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.browserScene != null) {
      this.browserScene.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.browserScene != null) {
      return this.browserScene.back();
    }
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.browserScene != null) {
      this.browserScene.onConfigurationChanged(paramConfiguration);
    }
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.presenterMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      BrowserBasePresenter localBrowserBasePresenter = (BrowserBasePresenter)((Map.Entry)localIterator.next()).getValue();
      if (localBrowserBasePresenter != null) {
        localBrowserBasePresenter.onDestroy();
      }
    }
    this.presenterMap.clear();
    if (this.browserScene != null) {
      this.browserScene.onDestroy();
    }
    HttpDownloadManager.getInstance().clean();
  }
  
  public void onDoubleTap()
  {
    if (this.browserScene != null) {
      this.browserScene.onDoubleTap();
    }
  }
  
  public void onItemSelect(int paramInt)
  {
    if (this.browserModel != null)
    {
      this.browserModel.setSelectedIndex(paramInt);
      Object localObject = this.browserModel.getItem(paramInt);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if (localObject != null)
        {
          if (this.browserScene.getCurrentView() != null) {
            ((BrowserBasePresenter)localObject).setGalleryView(this.browserScene.getCurrentView());
          }
          BrowserLogHelper.getInstance().getGalleryLog().i("MainBrowserPresenter", 2, "onItemSelect position = " + paramInt + ", id = " + this.browserModel.getItem(paramInt).baseData.id);
          ((BrowserBasePresenter)localObject).onItemSelect(paramInt);
        }
      }
    }
    if (this.browserScene != null) {
      this.browserScene.onItemSelected(paramInt);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.browserScene != null) {
      return this.browserScene.onKeyDown(paramInt, paramKeyEvent);
    }
    return false;
  }
  
  public void onPause()
  {
    if (this.browserScene != null) {
      this.browserScene.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.browserScene != null) {
      this.browserScene.onResume();
    }
  }
  
  public void onScale()
  {
    if (this.browserScene != null) {
      this.browserScene.onScale();
    }
  }
  
  public void onScaleBegin()
  {
    if (this.browserScene != null) {
      this.browserScene.onScaleBegin();
    }
  }
  
  public void onScaleEnd()
  {
    if (this.browserScene != null) {
      this.browserScene.onScaleEnd();
    }
  }
  
  public void onShowAreaChanged(View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (this.browserScene != null) {
      this.browserScene.onShowAreaChanged(getCurrentPosition(), paramView, paramRegionDrawableData);
    }
  }
  
  public void onStart()
  {
    if (this.browserScene != null) {
      this.browserScene.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.browserScene != null) {
      this.browserScene.onStop();
    }
  }
  
  public void onWindowFocusChanged()
  {
    if (this.browserScene != null) {
      this.browserScene.onWindowFocusChanged();
    }
  }
  
  public void preInitItem(int paramInt)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("MainBrowserPresenter", 4, "preInitItem position = " + paramInt);
    if (this.browserModel != null)
    {
      Object localObject = this.browserModel.getItem(paramInt);
      if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
      {
        localObject = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
        if (localObject != null) {
          ((BrowserBasePresenter)localObject).preInitItem(paramInt);
        }
      }
    }
  }
  
  public void requestDisallowInterceptDragEvent(boolean paramBoolean)
  {
    if (this.browserScene != null) {
      this.browserScene.requestDisallowInterceptDragEvent(paramBoolean);
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    if (this.browserScene != null) {
      this.browserScene.requestDisallowInterceptTouchEvent(paramBoolean);
    }
  }
  
  public void resetItemView(int paramInt)
  {
    Object localObject = this.baseModel.getItem(paramInt);
    if ((localObject != null) && (((RichMediaBrowserInfo)localObject).baseData != null))
    {
      localObject = getPresenter(((RichMediaBrowserInfo)localObject).baseData.getType());
      if ((localObject != null) && (((BrowserBasePresenter)localObject).browserBaseView != null)) {
        ((BrowserBasePresenter)localObject).browserBaseView.reset();
      }
    }
  }
  
  public void setGalleryModel(MainBrowserModel paramMainBrowserModel)
  {
    this.browserModel = paramMainBrowserModel;
    super.setGalleryModel(paramMainBrowserModel);
  }
  
  public void setGalleryScene(MainBrowserScene paramMainBrowserScene)
  {
    this.browserScene = paramMainBrowserScene;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.MainBrowserPresenter
 * JD-Core Version:    0.7.0.1
 */