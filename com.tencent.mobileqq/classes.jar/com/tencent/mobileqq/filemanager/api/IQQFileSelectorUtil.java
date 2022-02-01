package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.GetApkPackageInfoCallback;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import java.util.List;

@QAPI(process={""})
public abstract interface IQQFileSelectorUtil
  extends QRouteApi
{
  public abstract List<PackageInfo> getAllApps(Context paramContext);
  
  public abstract Drawable getApkIcon(Context paramContext, String paramString);
  
  public abstract boolean getApkPackageInfo(String paramString, GetApkPackageInfoCallback paramGetApkPackageInfoCallback);
  
  public abstract long getPicCount(Context paramContext);
  
  public abstract boolean isImportLocaFilesForH5(Context paramContext);
  
  public abstract boolean isNeedFinish(Activity paramActivity);
  
  public abstract void openFileAssistant(Context paramContext, boolean paramBoolean);
  
  public abstract List<FileInfo> qureyApks(Context paramContext, ITabViewEvent paramITabViewEvent);
  
  public abstract void scanFileList(boolean paramBoolean, String paramString1, String paramString2, String paramString3, HashMap<String, List<FileInfo>> paramHashMap, ITabViewEvent paramITabViewEvent);
  
  public abstract void upDataApkPathForPackageName(FileManagerEntity paramFileManagerEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil
 * JD-Core Version:    0.7.0.1
 */