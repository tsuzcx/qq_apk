package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.richmediabrowser.core.BrowserBuilder;
import com.tencent.richmediabrowser.core.BrowserDirector;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.listener.IVideoEnventListener;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
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
  private static final String TAG = "AIOGalleryPresenter";
  public MainBrowserModel browserModel;
  public MainBrowserScene browserScene;
  private ConcurrentHashMap<Integer, BrowserBasePresenter> presenterMap = new ConcurrentHashMap();
  
  public void buildComplete() {}
  
  public void buildMVP(int paramInt)
  {
    if (!this.presenterMap.containsKey(Integer.valueOf(paramInt)))
    {
      BrowserBuilder localBrowserBuilder = new BrowserBuilder(this.browserScene.mContext, paramInt);
      localBrowserBuilder.setRelyPresenter(this);
      new BrowserDirector(localBrowserBuilder).construct(this.browserScene.mIntent);
      if ((localBrowserBuilder.getPresenter() instanceof BrowserBasePresenter))
      {
        ((BrowserBasePresenter)localBrowserBuilder.getPresenter()).setMainBrowserPresenter(this);
        this.presenterMap.put(Integer.valueOf(paramInt), (BrowserBasePresenter)localBrowserBuilder.getPresenter());
      }
    }
  }
  
  public void buildParams(Intent paramIntent) {}
  
  public void buildPresenter() {}
  
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
      BrowserLogHelper.getInstance().getGalleryLog().i("AIOGalleryPresenter", 2, "notifyImageListChanged list size " + i + ", selected " + paramInt);
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
  }
  
  public void onItemSelect(int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.MainBrowserPresenter
 * JD-Core Version:    0.7.0.1
 */