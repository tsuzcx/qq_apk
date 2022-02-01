package com.tencent.mobileqq.mini.model;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;

public class FavoritesData$Builder
{
  private FavoritesData favoritesData = new FavoritesData();
  
  public FavoritesData build()
  {
    return this.favoritesData;
  }
  
  public Builder setAction(int paramInt)
  {
    this.favoritesData.action = paramInt;
    return this;
  }
  
  public Builder setBizDataList(String paramString)
  {
    this.favoritesData.bizDataList = paramString;
    return this;
  }
  
  public Builder setEntryPath(String paramString)
  {
    this.favoritesData.entryPath = paramString;
    return this;
  }
  
  public Builder setMiniAppInfo(MiniAppInfo paramMiniAppInfo)
  {
    this.favoritesData.miniAppInfo = paramMiniAppInfo;
    return this;
  }
  
  public Builder setPicPath(String paramString)
  {
    this.favoritesData.picPath = paramString;
    return this;
  }
  
  public Builder setSummary(String paramString)
  {
    this.favoritesData.summary = paramString;
    return this;
  }
  
  public Builder setTitle(String paramString)
  {
    this.favoritesData.title = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.model.FavoritesData.Builder
 * JD-Core Version:    0.7.0.1
 */