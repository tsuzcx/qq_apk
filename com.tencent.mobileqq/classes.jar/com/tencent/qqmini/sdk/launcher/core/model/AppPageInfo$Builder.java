package com.tencent.qqmini.sdk.launcher.core.model;

public class AppPageInfo$Builder
{
  private AppPageInfo appPageInfo = new AppPageInfo();
  
  public AppPageInfo build()
  {
    return this.appPageInfo;
  }
  
  public Builder setPageId(int paramInt)
  {
    this.appPageInfo.pageId = paramInt;
    return this;
  }
  
  public Builder setPageUrl(String paramString)
  {
    this.appPageInfo.pageUrl = paramString;
    return this;
  }
  
  public Builder setSurfaceViewHeight(int paramInt)
  {
    this.appPageInfo.surfaceViewHeight = paramInt;
    return this;
  }
  
  public Builder setSurfaceViewWidth(int paramInt)
  {
    this.appPageInfo.surfaceViewWidth = paramInt;
    return this;
  }
  
  public Builder setWindowHeight(int paramInt)
  {
    this.appPageInfo.windowHeight = paramInt;
    return this;
  }
  
  public Builder setWindowWidth(int paramInt)
  {
    this.appPageInfo.windowWidth = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.model.AppPageInfo.Builder
 * JD-Core Version:    0.7.0.1
 */