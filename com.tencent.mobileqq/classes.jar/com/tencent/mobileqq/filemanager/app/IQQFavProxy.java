package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQFavProxy
  extends IRuntimeService
{
  public static final String DELETE_FAVIDS = "delete_favids";
  
  public abstract void addListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener);
  
  public abstract void cancelGetFileList(long paramLong);
  
  public abstract void deleteListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener);
  
  public abstract void downloadThumb(FavFileInfo paramFavFileInfo, int paramInt);
  
  public abstract void getFileList(long paramLong, boolean paramBoolean, Bundle paramBundle, IQQFavProxy.GetFileListResult paramGetFileListResult);
  
  public abstract long getGettedPartList(long paramLong, List<FavFileInfo> paramList);
  
  public abstract void onFileDownloaded(long paramLong, String paramString);
  
  public abstract void onFileListRefreshed(boolean paramBoolean, Bundle paramBundle);
  
  public abstract void onFileThumbUpdated(long paramLong, String paramString, int paramInt);
  
  public abstract void onGettedFileList(long paramLong, List<FavFileInfo> paramList, Bundle paramBundle);
  
  public abstract boolean refreshList(Bundle paramBundle);
  
  public abstract void sendFavFiles(List<FavFileInfo> paramList, String paramString, int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.IQQFavProxy
 * JD-Core Version:    0.7.0.1
 */