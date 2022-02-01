package com.tencent.mobileqq.filemanager.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFilePathUtil
  extends QRouteApi
{
  public abstract String copyImageFileToMediaStorage(String paramString);
  
  public abstract boolean fileExistsAndNotEmpty(String paramString);
  
  public abstract String getRealPath(String paramString);
  
  public abstract String renameImageFileToMediaStorage(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IFilePathUtil
 * JD-Core Version:    0.7.0.1
 */