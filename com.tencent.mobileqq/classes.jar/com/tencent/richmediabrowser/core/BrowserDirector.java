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
      paramIBrowserBuilder.buildView(null);
      l1 = System.currentTimeMillis();
      this.buildViewTime = (l1 - l2);
      paramIBrowserBuilder.buildModel();
      l2 = System.currentTimeMillis();
      this.buildModelTime = (l2 - l1);
      paramIBrowserBuilder.buildComplete();
      this.buildCompleteTime = (System.currentTimeMillis() - l2);
      if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel())
      {
        paramIBrowserBuilder = "buildParamsTime : " + this.buildParamsTime + ", buildPresenterTime " + this.buildPresenterTime + ", buildViewTime " + this.buildViewTime + ", buildModelTime " + this.buildModelTime + ", buildCompleteTime " + this.buildCompleteTime;
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, paramIBrowserBuilder);
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, "Browser builder is null!");
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
      paramIViewBuilder.buildView(null);
      long l4 = System.currentTimeMillis();
      this.buildViewTime = (l4 - l3);
      paramIViewBuilder.buildComplete();
      this.buildCompleteTime = (System.currentTimeMillis() - l4);
      if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel())
      {
        paramIViewBuilder = "buildInitTime : " + (l2 - l1) + ", buildParamsTime " + this.buildParamsTime + ", buildViewTime " + this.buildViewTime + ", buildCompleteTime " + this.buildCompleteTime;
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, paramIViewBuilder);
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, "viewBuilder is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.BrowserDirector
 * JD-Core Version:    0.7.0.1
 */