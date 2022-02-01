package com.tencent.mobileqq.qwallet.preload;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.LinkedList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPreloadServiceAbs
  extends IRuntimeService
{
  public static final String PRELOAD_DIR_NAME_HIDE = ".preloaduni";
  
  @Deprecated
  public abstract void downloadModule(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback);
  
  @Deprecated
  public abstract void downloadRes(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback);
  
  public abstract void downloadUrls(List<String> paramList, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getFilePathByResID(String paramString, ResultReceiver paramResultReceiver);
  
  public abstract void getResPath(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getResPath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getResPath(LinkedList<DownloadParam> paramLinkedList, IPreloadService.OnGetPathsListener paramOnGetPathsListener);
  
  public abstract IPreloadResource getResourceByResID(String paramString);
  
  public abstract String getVideoResPathByID(String paramString);
  
  public abstract boolean isNetValidToDownload(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadServiceAbs
 * JD-Core Version:    0.7.0.1
 */