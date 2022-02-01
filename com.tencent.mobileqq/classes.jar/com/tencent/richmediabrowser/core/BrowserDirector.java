package com.tencent.richmediabrowser.core;

import android.content.Intent;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;

public class BrowserDirector
{
  private static final String TAG = "BrowserDirector";
  public long buildCompleteTime = 0L;
  public long buildModelTime = 0L;
  public long buildParamsTime = 0L;
  public long buildPresenterTime = 0L;
  public long buildViewTime = 0L;
  
  public void construct(IBrowserBuilder paramIBrowserBuilder, Intent paramIntent)
  {
    if (paramIBrowserBuilder != null)
    {
      long l2 = System.currentTimeMillis();
      paramIBrowserBuilder.buildPresenter();
      long l1 = System.currentTimeMillis();
      this.buildParamsTime = (l1 - l2);
      paramIBrowserBuilder.buildParams(paramIntent);
      l2 = System.currentTimeMillis();
      this.buildPresenterTime = (l2 - l1);
      paramIBrowserBuilder.buildView();
      l1 = System.currentTimeMillis();
      this.buildViewTime = (l1 - l2);
      paramIBrowserBuilder.buildModel();
      l2 = System.currentTimeMillis();
      this.buildModelTime = (l2 - l1);
      paramIBrowserBuilder.buildComplete();
      this.buildCompleteTime = (System.currentTimeMillis() - l2);
      if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel())
      {
        paramIBrowserBuilder = new StringBuilder();
        paramIBrowserBuilder.append("buildParamsTime : ");
        paramIBrowserBuilder.append(this.buildParamsTime);
        paramIBrowserBuilder.append(", buildPresenterTime ");
        paramIBrowserBuilder.append(this.buildPresenterTime);
        paramIBrowserBuilder.append(", buildViewTime ");
        paramIBrowserBuilder.append(this.buildViewTime);
        paramIBrowserBuilder.append(", buildModelTime ");
        paramIBrowserBuilder.append(this.buildModelTime);
        paramIBrowserBuilder.append(", buildCompleteTime ");
        paramIBrowserBuilder.append(this.buildCompleteTime);
        paramIBrowserBuilder = paramIBrowserBuilder.toString();
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, paramIBrowserBuilder);
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, "Browser builder is null!");
    }
  }
  
  public void constructItemView(IViewBuilder paramIViewBuilder, Intent paramIntent)
  {
    if (paramIViewBuilder != null)
    {
      long l1 = System.currentTimeMillis();
      paramIViewBuilder.buildInit();
      long l2 = System.currentTimeMillis();
      paramIViewBuilder.buildParams(paramIntent);
      long l3 = System.currentTimeMillis();
      this.buildParamsTime = (l3 - l2);
      paramIViewBuilder.buildView();
      long l4 = System.currentTimeMillis();
      this.buildViewTime = (l4 - l3);
      paramIViewBuilder.buildComplete();
      this.buildCompleteTime = (System.currentTimeMillis() - l4);
      if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel())
      {
        paramIViewBuilder = new StringBuilder();
        paramIViewBuilder.append("buildInitTime : ");
        paramIViewBuilder.append(l2 - l1);
        paramIViewBuilder.append(", buildParamsTime ");
        paramIViewBuilder.append(this.buildParamsTime);
        paramIViewBuilder.append(", buildViewTime ");
        paramIViewBuilder.append(this.buildViewTime);
        paramIViewBuilder.append(", buildCompleteTime ");
        paramIViewBuilder.append(this.buildCompleteTime);
        paramIViewBuilder = paramIViewBuilder.toString();
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, paramIViewBuilder);
      }
    }
    else
    {
      BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, "viewBuilder is null!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.BrowserDirector
 * JD-Core Version:    0.7.0.1
 */