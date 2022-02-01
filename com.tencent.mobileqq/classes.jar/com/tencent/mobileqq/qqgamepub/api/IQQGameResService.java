package com.tencent.mobileqq.qqgamepub.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQGameResService
  extends QRouteApi
{
  public abstract boolean IsOnlySupportInnerFilePos();
  
  public abstract void checkAndCleanExpireCache(int paramInt);
  
  public abstract void deleteArkResRecordAndFile(String paramString);
  
  public abstract void deleteFile(String paramString);
  
  public abstract String getActivityDSL(String paramString, int paramInt);
  
  public abstract String getArkResRecordName(String paramString1, String paramString2);
  
  public abstract String getArkResRecordPath(String paramString1, String paramString2);
  
  public abstract String getFilePath(String paramString, int paramInt);
  
  public abstract String getResPathByUrl(String paramString, int paramInt);
  
  public abstract String getResPathPrefix(int paramInt);
  
  public abstract String getResRealMd5(String paramString);
  
  public abstract String getResRecordMd5(String paramString1, String paramString2, int paramInt);
  
  public abstract void removeResInfo(String paramString, int paramInt);
  
  public abstract void saveArkResPreloadName(String paramString1, String paramString2, String paramString3);
  
  public abstract void updateResInfo(String paramString1, String paramString2, long paramLong, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.api.IQQGameResService
 * JD-Core Version:    0.7.0.1
 */