package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.core.IBaseModelBuilder;
import com.tencent.richmediabrowser.core.IBasePresenterBuilder;
import com.tencent.richmediabrowser.core.IBaseViewBuilder;
import com.tencent.richmediabrowser.listener.IDownloadEventListener;
import com.tencent.richmediabrowser.listener.IGalleryImageListener;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.view.BrowserBaseView;
import com.tencent.richmediabrowser.view.MainBrowserScene;
import java.util.concurrent.ConcurrentHashMap;

public class BrowserBasePresenter
  extends BasePresenter
  implements IBasePresenterBuilder, IDownloadEventListener, IGalleryImageListener
{
  public BrowserBaseView browserBaseView;
  public ConcurrentHashMap<Integer, URLDrawable> mActiveDrawable = new ConcurrentHashMap();
  public MainBrowserPresenter mainBrowserPresenter;
  
  public void back()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.back();
    }
  }
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public void buildPresenter() {}
  
  public RelativeLayout getContentView()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.getContentView();
    }
    return null;
  }
  
  public int getCount()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getCount();
    }
    return 0;
  }
  
  public int getCurrentPosition()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if (localMainBrowserPresenter != null) {
      return localMainBrowserPresenter.getCurrentPosition();
    }
    return -1;
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.getItem(paramInt);
    }
    return null;
  }
  
  public RichMediaBrowserInfo getItem(String paramString)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getItem(paramString);
    }
    return null;
  }
  
  public RecyclerView getRecyclerView()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.getRecyclerView();
    }
    return null;
  }
  
  public RelativeLayout getRootView()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      return this.mainBrowserPresenter.browserScene.mRoot;
    }
    return null;
  }
  
  public int getSelectedIndex()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getSelectedIndex();
    }
    return 0;
  }
  
  public RichMediaBrowserInfo getSelectedItem()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      return this.mainBrowserPresenter.browserModel.getSelectedItem();
    }
    return null;
  }
  
  public void notifyDataSetChanged()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.notifyDataSetChanged();
    }
  }
  
  public void notifyItemChanged(int paramInt)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.notifyItemChanged(paramInt);
    }
  }
  
  public void notifyProgress(String paramString, int paramInt) {}
  
  public void notifyResult(String paramString, int paramInt) {}
  
  public void onDestroy()
  {
    this.mActiveDrawable.clear();
  }
  
  public void onItemSelect(int paramInt) {}
  
  public void onLoadDrawable(int paramInt, URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable != null) {
      this.mActiveDrawable.put(Integer.valueOf(paramInt), paramURLDrawable);
    }
  }
  
  public void onLoadFinish(int paramInt, boolean paramBoolean)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.onLoadFinish(paramInt, paramBoolean);
    }
  }
  
  public void onLoadStart(int paramInt1, int paramInt2)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.onLoadStart(paramInt1, paramInt2);
    }
  }
  
  public void onLoadSuccessed(int paramInt, boolean paramBoolean)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.onLoadSuccessed(paramInt, paramBoolean);
    }
  }
  
  public void setBrowserModel(IBaseModelBuilder paramIBaseModelBuilder) {}
  
  public void setBrowserView(IBaseViewBuilder paramIBaseViewBuilder)
  {
    if ((paramIBaseViewBuilder instanceof BrowserBaseView)) {
      this.browserBaseView = ((BrowserBaseView)paramIBaseViewBuilder);
    }
  }
  
  public void setMainBrowserPresenter(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.mainBrowserPresenter = paramMainBrowserPresenter;
  }
  
  public void setRelyPresenter(IBasePresenterBuilder paramIBasePresenterBuilder)
  {
    if ((paramIBasePresenterBuilder instanceof MainBrowserPresenter)) {
      setMainBrowserPresenter((MainBrowserPresenter)paramIBasePresenterBuilder);
    }
  }
  
  public void showContentView(boolean paramBoolean)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.showContentView(paramBoolean);
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItem(paramRichMediaBrowserInfo);
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo, int paramInt)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItem(paramRichMediaBrowserInfo, paramInt);
    }
  }
  
  public void updateItemStatus(String paramString, int paramInt)
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserModel != null)) {
      this.mainBrowserPresenter.browserModel.updateItemStatus(paramString, paramInt);
    }
  }
  
  public void updateSystemUIVisablity()
  {
    MainBrowserPresenter localMainBrowserPresenter = this.mainBrowserPresenter;
    if ((localMainBrowserPresenter != null) && (localMainBrowserPresenter.browserScene != null)) {
      this.mainBrowserPresenter.browserScene.updateSystemUIVisablity();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.BrowserBasePresenter
 * JD-Core Version:    0.7.0.1
 */