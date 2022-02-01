package com.tencent.qzonehub.api.impl;

import NS_MOBILE_CLIENT_UPDATE.SQ_CLIENT_UPDATE_RSP;
import NS_MOBILE_CLIENT_UPDATE.UPDATE_INFO;
import com.tencent.qzonehub.api.IQzoneModuleManageApi;
import cooperation.qzone.networkedmodule.ModuleDownloadListener;
import cooperation.qzone.networkedmodule.QzoneModuleConfigManager;
import cooperation.qzone.networkedmodule.QzoneModuleManager;
import cooperation.qzone.networkedmodule.QzoneModuleRecord;
import java.io.File;
import java.util.ArrayList;

public class QzoneModuleManageApiImpl
  implements IQzoneModuleManageApi
{
  public void abortDownloadModule(String paramString)
  {
    QzoneModuleManager.getInstance().abortDownloadModule(paramString);
  }
  
  public void cancelDownloadModule(String paramString)
  {
    QzoneModuleManager.getInstance().cancelDownloadModule(paramString);
  }
  
  public boolean checkIfNeedUpdate(String paramString)
  {
    return QzoneModuleManager.getInstance().checkIfNeedUpdate(paramString);
  }
  
  public boolean downloadModule(String paramString, ModuleDownloadListener paramModuleDownloadListener)
  {
    return QzoneModuleManager.getInstance().downloadModule(paramString, paramModuleDownloadListener);
  }
  
  public String getModuleFilePath(String paramString)
  {
    return QzoneModuleManager.getInstance().getModuleFilePath(paramString);
  }
  
  public QzoneModuleRecord getModuleRecord(String paramString)
  {
    return QzoneModuleConfigManager.getInstance().getModuleRecord(paramString);
  }
  
  public ArrayList<UPDATE_INFO> getUpdateInfo()
  {
    return QzoneModuleConfigManager.getInstance().getUpdateInfo();
  }
  
  public void handleModuleRsp(SQ_CLIENT_UPDATE_RSP paramSQ_CLIENT_UPDATE_RSP)
  {
    QzoneModuleConfigManager.getInstance().handleModuleRsp(paramSQ_CLIENT_UPDATE_RSP);
  }
  
  public boolean hasLoadNewMapSDK()
  {
    return QzoneModuleManager.getInstance().hasLoadNewMapSDK;
  }
  
  public boolean hasLoadOldMapSDK()
  {
    return QzoneModuleManager.getInstance().hasLoadOldMapSDK;
  }
  
  public boolean hasStartedUpdateTask()
  {
    return QzoneModuleManager.getInstance().hasStartedUpdateTask();
  }
  
  public boolean isModuleDownloaded(String paramString)
  {
    return QzoneModuleManager.getInstance().isModuleDownloaded(paramString);
  }
  
  public boolean isModuleLoaded(String paramString)
  {
    return QzoneModuleManager.getInstance().isModuleLoaded(paramString);
  }
  
  public boolean loadLibraryById(String paramString)
  {
    return QzoneModuleManager.getInstance().loadLibraryById(paramString);
  }
  
  public boolean loadModule(File paramFile)
  {
    return QzoneModuleManager.getInstance().loadModule(paramFile);
  }
  
  public boolean loadModule(String paramString, ClassLoader paramClassLoader, boolean paramBoolean1, boolean paramBoolean2)
  {
    return QzoneModuleManager.getInstance().loadModule(paramString, paramClassLoader, paramBoolean1, paramBoolean2);
  }
  
  public boolean loadModuleAsQQPatch(String paramString)
  {
    return QzoneModuleManager.getInstance().loadModuleAsQQPatch(paramString);
  }
  
  public boolean loadModuleAsQzonePatch(String paramString, ClassLoader paramClassLoader)
  {
    return QzoneModuleManager.getInstance().loadModuleAsQzonePatch(paramString, paramClassLoader);
  }
  
  public void putModuleRecord(QzoneModuleRecord paramQzoneModuleRecord)
  {
    QzoneModuleConfigManager.getInstance().putModuleRecord(paramQzoneModuleRecord);
  }
  
  public void updateAllModules()
  {
    QzoneModuleManager.getInstance().updateAllModules();
  }
  
  public void updateConfigAfterDownloaded(QzoneModuleRecord paramQzoneModuleRecord)
  {
    QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded(paramQzoneModuleRecord);
  }
  
  public void updateModule(String paramString, ModuleDownloadListener paramModuleDownloadListener)
  {
    QzoneModuleManager.getInstance().updateModule(paramString, paramModuleDownloadListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.impl.QzoneModuleManageApiImpl
 * JD-Core Version:    0.7.0.1
 */