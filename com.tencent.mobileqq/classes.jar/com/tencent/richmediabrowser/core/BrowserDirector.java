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
  private IBrowserBuilder mBrowserBuilder;
  
  public BrowserDirector(IBrowserBuilder paramIBrowserBuilder)
  {
    this.mBrowserBuilder = paramIBrowserBuilder;
  }
  
  public void construct(Intent paramIntent)
  {
    if (this.mBrowserBuilder != null)
    {
      long l2 = System.currentTimeMillis();
      this.mBrowserBuilder.buildPresenter();
      long l1 = System.currentTimeMillis();
      this.buildParamsTime = (l1 - l2);
      this.mBrowserBuilder.buildParams(paramIntent);
      l2 = System.currentTimeMillis();
      this.buildPresenterTime = (l2 - l1);
      this.mBrowserBuilder.buildView(null);
      l1 = System.currentTimeMillis();
      this.buildViewTime = (l1 - l2);
      this.mBrowserBuilder.buildModel();
      l2 = System.currentTimeMillis();
      this.buildModelTime = (l2 - l1);
      this.mBrowserBuilder.buildComplete();
      this.buildCompleteTime = (System.currentTimeMillis() - l2);
      if (BrowserLogHelper.getInstance().getGalleryLog().isColorLevel())
      {
        paramIntent = "buildParamsTime : " + this.buildParamsTime + ", buildPresenterTime " + this.buildPresenterTime + ", buildViewTime " + this.buildViewTime + ", buildModelTime " + this.buildModelTime + ", buildCompleteTime " + this.buildCompleteTime;
        BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, paramIntent);
      }
      return;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDirector", 4, "Gallery builder is null!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.richmediabrowser.core.BrowserDirector
 * JD-Core Version:    0.7.0.1
 */