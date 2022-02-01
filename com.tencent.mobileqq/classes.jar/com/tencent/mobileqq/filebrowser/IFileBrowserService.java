package com.tencent.mobileqq.filebrowser;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IFileBrowserService
  extends QRouteApi
{
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_BUDDY = 1;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_BUDDY_LIST = 2;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_DATALINE = 11;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_DISC = 5;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_DISC_LIST = 6;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_TROOP = 3;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_AIO_TROOP_LIST = 4;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_FAV = 10;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_FORWARD = 12;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_LOCAL = 8;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_RECENT = 7;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_UNKNOW = 0;
  public static final int FILE_BROWSER_ENTRANCE_TYPE_WEIYUN = 9;
  public static final String FILE_BROWSER_PARAMS_ENTRANCE = "browser_params_entrance";
  public static final String STRING_BROWSE_ID = "browseId";
  
  public abstract void browserFile(Activity paramActivity, int paramInt, IFileBrowserModel paramIFileBrowserModel, IFileBrowserParam paramIFileBrowserParam);
  
  public abstract void browserFile(Context paramContext, IFileBrowserModel paramIFileBrowserModel, IFileBrowserParam paramIFileBrowserParam);
  
  public abstract IFileBrowserModel getFileModel(int paramInt);
  
  public abstract boolean initTbsReaderEngine(boolean paramBoolean);
  
  public abstract void onDestroy(int paramInt);
  
  public abstract void reportQQBrowserDownloadEvent(String paramString);
  
  public abstract void setCheckShowTbsReaderBar(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.IFileBrowserService
 * JD-Core Version:    0.7.0.1
 */