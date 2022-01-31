package com.tencent.richmediabrowser.presenter;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.richmediabrowser.model.BrowserBaseModel;
import com.tencent.richmediabrowser.view.BaseView;

public class BasePresenter
{
  private static final String TAG = "GalleryBasePresenter";
  public BrowserBaseModel baseModel;
  public BaseView baseView;
  
  public static void updateRotation(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      paramInt = 0;
      if (paramURLDrawable.isAnim()) {
        break;
      }
    }
    for (;;)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      if (bool) {
        paramView.setTag(2131296389, Integer.valueOf(paramInt));
      }
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      bool = false;
    }
  }
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public void buildPresenter() {}
  
  public void onCreate(ViewGroup paramViewGroup)
  {
    if (this.baseView != null) {
      this.baseView.onCreate(paramViewGroup);
    }
  }
  
  public void onDestroy()
  {
    if (this.baseView != null) {
      this.baseView.onDestroy();
    }
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public void onPause()
  {
    if (this.baseView != null) {
      this.baseView.onPause();
    }
  }
  
  public void onResume()
  {
    if (this.baseView != null) {
      this.baseView.onResume();
    }
  }
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  public void onStart()
  {
    if (this.baseView != null) {
      this.baseView.onStart();
    }
  }
  
  public void onStop()
  {
    if (this.baseView != null) {
      this.baseView.onStop();
    }
  }
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void setGalleryModel(BrowserBaseModel paramBrowserBaseModel)
  {
    this.baseModel = paramBrowserBaseModel;
  }
  
  public void setGalleryView(BaseView paramBaseView)
  {
    this.baseView = paramBaseView;
  }
  
  public void setRelyPresenter(BasePresenter paramBasePresenter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.presenter.BasePresenter
 * JD-Core Version:    0.7.0.1
 */