package com.tencent.mobileqq.qwallet.preload;

import android.os.ResultReceiver;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigApi.ConfigInfo;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService.ConfigUpdateListener;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

@Service(process={""})
public abstract interface IPreloadService
  extends INetInfoHandler, IQWalletConfigService.ConfigUpdateListener, IPreloadServiceAbs
{
  public static final String CONIFG_FILE_NAME = "preload.config";
  public static final String KEY_CONFIG_FROM_QQ = "config_from_qq";
  public static final int MSG_FLOW_CONTROL_ADD_RES = 1;
  public static final int MSG_FLOW_CONTROL_CHECK_NEXT_RES = 2;
  public static final String PREF_NAME_QWALLET_PRELOAD_CONFIG = "qwallet_preload_config";
  public static final String TAG = "PreloadService";
  
  public abstract void addResToFlowControlCheck(IPreloadService.FlowControlObj paramFlowControlObj);
  
  public abstract void downloadModule(String paramString);
  
  @Deprecated
  public abstract void downloadModule(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback);
  
  public abstract void downloadModule(String paramString, boolean paramBoolean);
  
  @Deprecated
  public abstract void downloadRes(String paramString1, String paramString2, IPreloadService.DownloadCallback paramDownloadCallback);
  
  public abstract void downloadUrls(List<String> paramList, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getFilePath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getFilePath(String paramString1, String paramString2, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getFilePathByResID(String paramString, ResultReceiver paramResultReceiver);
  
  public abstract IPreloadModule getModuleByMID(String paramString);
  
  public abstract IPreloadModule getModuleByName(String paramString);
  
  public abstract String getResIdByUrl(String paramString);
  
  public abstract ResourceInfo getResInfoByResId(String paramString);
  
  public abstract void getResPath(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getResPath(LinkedList<DownloadParam> paramLinkedList, IPreloadService.OnGetPathsListener paramOnGetPathsListener);
  
  public abstract void getUnzipFolderPath(String paramString, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void getUnzipFolderPath(String paramString1, String paramString2, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract String getUnzipFolderPathByResId(String paramString);
  
  public abstract String getVideoResPathByID(String paramString);
  
  public abstract void mergeConfig(String paramString);
  
  public abstract void notifyResFlowCheckNext();
  
  public abstract void onDestroy();
  
  public abstract void onNetMobile2None();
  
  public abstract void onNetMobile2Wifi(String paramString);
  
  public abstract void onNetNone2Mobile(String paramString);
  
  public abstract void onNetNone2Wifi(String paramString);
  
  public abstract void onNetWifi2Mobile(String paramString);
  
  public abstract void onNetWifi2None();
  
  public abstract void onUpdate(String paramString1, String paramString2, IQWalletConfigApi.ConfigInfo paramConfigInfo);
  
  public abstract void preCheck();
  
  public abstract void realTimeDownload(DownloadParam paramDownloadParam, IPreloadService.OnGetPathListener paramOnGetPathListener);
  
  public abstract void replaceConfig(PreloadConfBean paramPreloadConfBean);
  
  public abstract void replaceConfig(JSONArray paramJSONArray, int paramInt);
  
  public abstract void replaceConfigFromMoggy(IQWalletConfigApi.ConfigInfo paramConfigInfo);
  
  public abstract void savePreloadConfig();
  
  public abstract void setPreloadHelpConfig(int paramInt1, int paramInt2);
  
  public abstract void startCheckConfig(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.IPreloadService
 * JD-Core Version:    0.7.0.1
 */