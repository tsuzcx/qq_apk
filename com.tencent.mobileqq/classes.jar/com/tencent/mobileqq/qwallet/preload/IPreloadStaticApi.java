package com.tencent.mobileqq.qwallet.preload;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPreloadStaticApi
  extends QRouteApi
{
  public abstract void deleteRes(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract String getConfigFromQQ(String paramString);
  
  public abstract String getFolderPathByMD5AndUrl(String paramString1, String paramString2, int paramInt);
  
  public abstract IPreloadServiceAbs getInstance();
  
  public abstract String getRealMd5(String paramString1, String paramString2, int paramInt);
  
  public abstract ResourceInfo getResInfoByUrl(String paramString, boolean paramBoolean, int paramInt);
  
  public abstract IPreloadService.PathResult getResPathSync(DownloadParam paramDownloadParam);
  
  public abstract String getResourcePathByUrl(String paramString, int paramInt);
  
  public abstract String getUnzipFolderPath(String paramString);
  
  public abstract boolean isDiskEnoughToUnzip(String paramString);
  
  public abstract boolean isFileValid(ResourceInfo paramResourceInfo, DownloadParam paramDownloadParam);
  
  public abstract boolean isFolderPathValid(String paramString);
  
  public abstract boolean unzipAtomically(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadStaticApi
 * JD-Core Version:    0.7.0.1
 */