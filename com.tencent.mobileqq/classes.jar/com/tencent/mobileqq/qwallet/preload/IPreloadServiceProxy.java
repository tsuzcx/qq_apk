package com.tencent.mobileqq.qwallet.preload;

import android.os.ResultReceiver;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.LinkedList;
import java.util.List;

@Service(process={"all"})
public abstract interface IPreloadServiceProxy
  extends IPreloadServiceAbs
{
  public static final String KEY_DOWNLOAD_CONFIG_STR = "config_str";
  public static final String KEY_DOWNLOAD_ID = "id";
  public static final String KEY_DOWNLOAD_PARAMS = "download_params";
  public static final String KEY_DOWNLOAD_RECEIVER = "receiver";
  public static final String KEY_METHOD_TYPE = "method_type";
  public static final String KEY_MID = "mid";
  public static final String KEY_PATH = "path";
  public static final String KEY_PATH_RESULT = "path_result";
  public static final String KEY_RESID = "res_id";
  public static final String KEY_RESINFO = "res_info";
  public static final String KEY_RESULT_CODE = "result_code";
  public static final String KEY_URL = "url";
  public static final int METHOD_TYPE_DOWNLOAD_URLS = 2;
  public static final int METHOD_TYPE_GET_RES_PATH = 1;
  public static final int METHOD_TYPE_GET_RES_PATHS = 3;
  public static final int METHOD_TYPE_GET_RES_PATH_SYNC = 4;
  
  @Deprecated
  public abstract void downloadModule(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback);
  
  @Deprecated
  public abstract void downloadRes(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback);
  
  public abstract void downloadUrls(List<String> paramList, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getFilePathByResID(String paramString, ResultReceiver paramResultReceiver);
  
  public abstract ResourceInfo getResInfoByResId(String paramString);
  
  public abstract void getResPath(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getResPath(LinkedList<DownloadParam> paramLinkedList, IPreloadService.OnGetPathsListener paramOnGetPathsListener);
  
  public abstract String getVideoResPathByID(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy
 * JD-Core Version:    0.7.0.1
 */