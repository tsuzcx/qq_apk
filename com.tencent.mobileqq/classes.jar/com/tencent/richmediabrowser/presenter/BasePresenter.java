package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.view.BrowserBaseView;

public class BasePresenter
{
  private static final String TAG = "BasePresenter";
  public BrowserBaseModel baseModel;
  public BrowserBaseView baseView;
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public void buildPresenter() {}
  
  public int getRotation(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      return 0;
    case 6: 
      return 90;
    case 3: 
      return 180;
    }
    return 270;
  }
  
  public void onCreate(ViewGroup paramViewGroup) {}
  
  public void onDestroy() {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    this.baseModel = paramBrowserBaseModel;
  }
  
  public void setGalleryView(BrowserBaseView paramBrowserBaseView)
  {
    this.baseView = paramBrowserBaseView;
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.BasePresenter
 * JD-Core Version:    0.7.0.1
 */