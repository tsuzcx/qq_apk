package com.tencent.mobileqq.filemanager.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.HashMap;
import org.xml.sax.helpers.DefaultHandler;

@QAPI(process={"all"})
public abstract interface IQQFileTempUtils
  extends QRouteApi
{
  public abstract void doJumpAction(Context paramContext, String paramString);
  
  public abstract BaseQQAppInterface getApp();
  
  public abstract int getFileType(String paramString);
  
  public abstract String getHardCodeConfigByFileManagerUtil(String paramString);
  
  public abstract HashMap<String, Object> getMapResultFromPreViewDataHandler(DefaultHandler paramDefaultHandler, String paramString);
  
  public abstract void openLocalFileBrowserActivity(Context paramContext, String paramString);
  
  public abstract void openQQBrowserWithoutAD(Context paramContext, String paramString);
  
  public abstract void setCheckShowTbsReaderBarByLocalTbsViewManager(boolean paramBoolean);
  
  public abstract void toastSucByFMToastUtil(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQQFileTempUtils
 * JD-Core Version:    0.7.0.1
 */