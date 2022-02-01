package com.tencent.mobileqq.kandian.ad.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"all"})
public abstract interface INativeAdPreloadService
  extends IRuntimeService
{
  public abstract void addImageToPreload(String paramString);
  
  public abstract void addImagesToPreload(ArrayList<String> paramArrayList);
  
  public abstract void clearPreloadList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.INativeAdPreloadService
 * JD-Core Version:    0.7.0.1
 */