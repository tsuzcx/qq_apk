package com.tencent.richmediabrowser.view;

import android.content.Intent;
import android.view.ViewGroup;

public abstract class BaseView
{
  private IBrowserViewHolder viewHolder;
  
  public void buildComplete() {}
  
  public void buildParams(Intent paramIntent) {}
  
  public void buildView(ViewGroup paramViewGroup) {}
  
  public IBrowserViewHolder getViewHolder()
  {
    return this.viewHolder;
  }
  
  public void onCreate(ViewGroup paramViewGroup) {}
  
  public void onDestroy()
  {
    setViewHolder(null);
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void setViewHolder(IBrowserViewHolder paramIBrowserViewHolder)
  {
    this.viewHolder = paramIBrowserViewHolder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BaseView
 * JD-Core Version:    0.7.0.1
 */