package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ITeamWorkManager
  extends QRouteApi
{
  public abstract String getPreviewImageForMiniProjUrlOfDoc();
  
  public abstract String getPreviewImageForMiniProjUrlOfSheet();
  
  public abstract String getPreviewImageUrlOfDoc();
  
  public abstract String getPreviewImageUrlOfSheet();
  
  public abstract Boolean isShowTencentDocEntry();
  
  public abstract void onDestroy();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.ITeamWorkManager
 * JD-Core Version:    0.7.0.1
 */