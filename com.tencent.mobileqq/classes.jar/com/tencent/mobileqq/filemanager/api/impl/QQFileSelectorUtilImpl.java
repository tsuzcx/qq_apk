package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.api.ITabViewEvent;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileCategoryUtil;
import com.tencent.mobileqq.filemanager.util.GetApkPackageInfoCallback;
import java.util.HashMap;
import java.util.List;

public class QQFileSelectorUtilImpl
  implements IQQFileSelectorUtil
{
  public List<PackageInfo> getAllApps(Context paramContext)
  {
    return FileCategoryUtil.e(paramContext);
  }
  
  public Drawable getApkIcon(Context paramContext, String paramString)
  {
    return FileCategoryUtil.a(paramContext, paramString);
  }
  
  public boolean getApkPackageInfo(String paramString, GetApkPackageInfoCallback paramGetApkPackageInfoCallback)
  {
    return FileCategoryUtil.a(paramString, paramGetApkPackageInfoCallback);
  }
  
  public long getPicCount(Context paramContext)
  {
    return FileCategoryUtil.d(paramContext);
  }
  
  public boolean isImportLocaFilesForH5(Context paramContext)
  {
    return (paramContext != null) && ((paramContext instanceof BaseFileAssistantActivity)) && (((BaseFileAssistantActivity)paramContext).z);
  }
  
  public boolean isNeedFinish(Activity paramActivity)
  {
    if ((paramActivity != null) && ((paramActivity instanceof FMActivity)))
    {
      paramActivity = (FMActivity)paramActivity;
      if ((paramActivity.E() == 0) || (7 == paramActivity.E())) {
        return true;
      }
    }
    return false;
  }
  
  public void openFileAssistant(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramContext, FileAssistantActivity.class);
    localIntent.putExtra("from", "FileAssistant");
    if (paramBoolean) {
      localIntent.setFlags(276824064);
    }
    paramContext.startActivity(localIntent);
  }
  
  public List<FileInfo> qureyApks(Context paramContext, ITabViewEvent paramITabViewEvent)
  {
    return FileCategoryUtil.a(paramContext, paramITabViewEvent);
  }
  
  public void scanFileList(boolean paramBoolean, String paramString1, String paramString2, String paramString3, HashMap<String, List<FileInfo>> paramHashMap, ITabViewEvent paramITabViewEvent)
  {
    FileCategoryUtil.a(paramBoolean, paramString1, paramString2, paramString3, paramHashMap, paramITabViewEvent);
  }
  
  public void upDataApkPathForPackageName(FileManagerEntity paramFileManagerEntity)
  {
    FileCategoryUtil.a(paramFileManagerEntity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileSelectorUtilImpl
 * JD-Core Version:    0.7.0.1
 */