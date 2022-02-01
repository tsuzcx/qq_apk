package com.tencent.qzonehub.api;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;
import java.io.File;
import java.util.ArrayList;

@QAPI(process={"all"})
public abstract interface IQzoneModuleManageApi
  extends QRouteApi
{
  public abstract void abortDownloadModule(String paramString);
  
  public abstract void cancelDownloadModule(String paramString);
  
  public abstract boolean checkIfNeedUpdate(String paramString);
  
  public abstract boolean downloadModule(String paramString, ModuleDownloadListener paramModuleDownloadListener);
  
  public abstract String getModuleFilePath(String paramString);
  
  public abstract QzoneModuleRecord getModuleRecord(String paramString);
  
  public abstract ArrayList<UPDATE_INFO> getUpdateInfo();
  
  public abstract void handleModuleRsp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP);
  
  public abstract boolean hasLoadNewMapSDK();
  
  public abstract boolean hasLoadOldMapSDK();
  
  public abstract boolean hasStartedUpdateTask();
  
  public abstract boolean isModuleDownloaded(String paramString);
  
  public abstract boolean isModuleLoaded(String paramString);
  
  public abstract boolean loadLibraryById(String paramString);
  
  public abstract boolean loadModule(File paramFile);
  
  public abstract boolean loadModule(String paramString, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean loadModuleAsQQPatch(String paramString);
  
  public abstract boolean loadModuleAsQzonePatch(String paramString, ClassLoader paramClassLoader);
  
  public abstract void putModuleRecord(QzoneModuleRecord paramQzoneModuleRecord);
  
  public abstract void updateAllModules();
  
  public abstract void updateConfigAfterDownloaded(QzoneModuleRecord paramQzoneModuleRecord);
  
  public abstract void updateModule(String paramString, ModuleDownloadListener paramModuleDownloadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.api.IQzoneModuleManageApi
 * JD-Core Version:    0.7.0.1
 */