package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.LocalFileBrowserActivity;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.LocalTbsViewManager;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.PreViewDataHandler;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.helpers.DefaultHandler;

public class QQFileTempUtilsImpl
  implements IQQFileTempUtils
{
  public void doJumpAction(Context paramContext, String paramString)
  {
    paramContext = JumpParser.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramContext, paramString);
    if (paramContext != null) {
      paramContext.a();
    }
  }
  
  public BaseQQAppInterface getApp()
  {
    if ((0 == 0) && (MobileQQ.sProcessId == 1))
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof BaseQQAppInterface))) {
        return (BaseQQAppInterface)localAppRuntime;
      }
    }
    return null;
  }
  
  public int getFileType(String paramString)
  {
    return FileManagerUtil.a(paramString);
  }
  
  public String getHardCodeConfigByFileManagerUtil(String paramString)
  {
    return FileManagerUtil.c(paramString);
  }
  
  public HashMap<String, Object> getMapResultFromPreViewDataHandler(DefaultHandler paramDefaultHandler, String paramString)
  {
    return (HashMap)((FileManagerUtil.PreViewDataHandler)paramDefaultHandler).a().get(paramString);
  }
  
  public void openLocalFileBrowserActivity(Context paramContext, String paramString)
  {
    try
    {
      if (new JSONObject(paramString).getInt("showlocalfile") == 1)
      {
        paramString = new Intent(paramContext, LocalFileBrowserActivity.class);
        if (paramString != null) {}
      }
      else
      {
        return;
      }
      try
      {
        Bundle localBundle = new Bundle();
        localBundle.putInt("category", 23);
        paramString.putExtra("bundle", localBundle);
        paramString.putExtra("localSdCardfile", 0);
        paramContext.startActivity(paramString);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      return;
    }
    catch (JSONException paramContext) {}
  }
  
  public void openQQBrowserWithoutAD(Context paramContext, String paramString)
  {
    VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramString, -1L, null, false, 0);
  }
  
  public void setCheckShowTbsReaderBarByLocalTbsViewManager(boolean paramBoolean)
  {
    LocalTbsViewManager.a().a(paramBoolean);
  }
  
  public void toastSucByFMToastUtil(String paramString)
  {
    FMToastUtil.b(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileTempUtilsImpl
 * JD-Core Version:    0.7.0.1
 */