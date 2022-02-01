package com.tencent.mobileqq.filebrowser.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.filebrowser.FileBrowserActivity;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserParam;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.fileview.LocalTbsViewManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class FileBrowserServiceImpl
  implements IFileBrowserService
{
  private static Integer browseId = Integer.valueOf(0);
  private final Map<Integer, IFileBrowserModel> fileModelMap = new HashMap();
  
  private Bundle getExtraParams(IFileBrowserParam paramIFileBrowserParam)
  {
    Bundle localBundle = new Bundle();
    if (paramIFileBrowserParam == null) {
      return localBundle;
    }
    localBundle.putInt("browser_params_entrance", paramIFileBrowserParam.a());
    if (paramIFileBrowserParam.b() != null) {
      localBundle.putString("file_browser_extra_params_uin", paramIFileBrowserParam.b());
    }
    return localBundle;
  }
  
  private void internalBrowserFile(Context paramContext, int paramInt, IFileBrowserModel paramIFileBrowserModel, IFileBrowserParam paramIFileBrowserParam)
  {
    browseId = Integer.valueOf(browseId.intValue() + 1);
    this.fileModelMap.put(browseId, paramIFileBrowserModel);
    paramIFileBrowserModel = new StringBuilder();
    paramIFileBrowserModel.append("browse file use new fileBrowser, entrance ");
    paramIFileBrowserModel.append(paramIFileBrowserParam.a());
    paramIFileBrowserModel.append(" browse Id");
    paramIFileBrowserModel.append(browseId);
    QLog.d("fileBrowser", 1, paramIFileBrowserModel.toString());
    paramIFileBrowserModel = new Intent(paramContext, FileBrowserActivity.class);
    paramIFileBrowserModel.putExtra("browseId", browseId);
    paramIFileBrowserModel.putExtras(getExtraParams(paramIFileBrowserParam));
    if (paramInt != -1)
    {
      ((Activity)paramContext).startActivityForResult(paramIFileBrowserModel, paramInt);
      return;
    }
    paramContext.startActivity(paramIFileBrowserModel);
  }
  
  public void browserFile(Activity paramActivity, int paramInt, IFileBrowserModel paramIFileBrowserModel, IFileBrowserParam paramIFileBrowserParam)
  {
    internalBrowserFile(paramActivity, paramInt, paramIFileBrowserModel, paramIFileBrowserParam);
  }
  
  public void browserFile(Context paramContext, IFileBrowserModel paramIFileBrowserModel, IFileBrowserParam paramIFileBrowserParam)
  {
    internalBrowserFile(paramContext, -1, paramIFileBrowserModel, paramIFileBrowserParam);
  }
  
  public IFileBrowserModel getFileModel(int paramInt)
  {
    return (IFileBrowserModel)this.fileModelMap.get(Integer.valueOf(paramInt));
  }
  
  public boolean initTbsReaderEngine(boolean paramBoolean)
  {
    return LocalTbsViewManager.a().c(paramBoolean);
  }
  
  public void onDestroy(int paramInt)
  {
    this.fileModelMap.remove(Integer.valueOf(paramInt));
  }
  
  public void reportQQBrowserDownloadEvent(String paramString)
  {
    LocalTbsViewManager.a().a(paramString);
  }
  
  public void setCheckShowTbsReaderBar(boolean paramBoolean)
  {
    LocalTbsViewManager.a().a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.impl.FileBrowserServiceImpl
 * JD-Core Version:    0.7.0.1
 */