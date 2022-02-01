package com.tencent.mobileqq.filemanager.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.GetFileListResult;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.QQFavProxyListener;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IQQFileEngine
  extends IRuntimeService
{
  public abstract void clearNewDownload();
  
  public abstract void delAllSelectedFiles(boolean paramBoolean);
  
  public abstract boolean delete(long paramLong);
  
  public abstract void deleteOfflineFile(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean);
  
  public abstract void deleteWeiYunFile(WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract void downLoadAllSelectFiles(Context paramContext);
  
  public abstract void downLoadDiscThumb(FileManagerEntity paramFileManagerEntity, int paramInt);
  
  public abstract String downloadOfflineVideoThumb(FileManagerEntity paramFileManagerEntity);
  
  public abstract void exitQlinkLocalFileBrowser();
  
  public abstract void favProxyAddListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener);
  
  public abstract void favProxyCancelGetFileList(long paramLong);
  
  public abstract void favProxyDeleteListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener);
  
  public abstract void favProxyGetFileList(long paramLong, boolean paramBoolean, Bundle paramBundle, IQQFavProxy.GetFileListResult paramGetFileListResult);
  
  public abstract long favProxyGetGettedPartList(long paramLong, List<FavFileInfo> paramList);
  
  public abstract void favProxyRefreshList(Bundle paramBundle);
  
  public abstract void favProxydownloadThumb(FavFileInfo paramFavFileInfo, int paramInt);
  
  public abstract int getBigDataHostList(boolean paramBoolean, int paramInt, List<QQFileHostInfo> paramList);
  
  public abstract int getIPv6HostsFromDns(String paramString, int paramInt1, int paramInt2, List<String> paramList);
  
  public abstract String getWeiYunPicThumb(String paramString1, String paramString2, int paramInt, Object paramObject);
  
  public abstract void getWeiYunPreview(String paramString1, String paramString2);
  
  public abstract String getWeiYunVideoThumb(String paramString1, String paramString2, int paramInt, WeiYunFileInfo paramWeiYunFileInfo);
  
  public abstract boolean hasQueriedVerifyPassword();
  
  public abstract void initAppStoreSDK();
  
  public abstract boolean isFileInUploaderQueue(String paramString);
  
  public abstract void pause(long paramLong);
  
  public abstract void pauseOnlineTrans(long paramLong);
  
  public abstract FileManagerEntity queryFileEntityByFileId(String paramString);
  
  public abstract void queryNeedVerifyPwd();
  
  public abstract void queryWeiyunFileList(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2);
  
  public abstract void reciveFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract void recvOnLineFile(long paramLong);
  
  public abstract void requestSendQlinkFile(Activity paramActivity, ArrayList<String> paramArrayList, String paramString);
  
  public abstract void resume(long paramLong);
  
  public abstract void resumeOnlineTrans(long paramLong);
  
  public abstract void reviceFile(FileManagerEntity paramFileManagerEntity);
  
  public abstract ArrayList<FileManagerEntity> saveAllSelectFileToWeiYun();
  
  public abstract void sendAllSelectedFiles(boolean paramBoolean, String paramString1, String paramString2, int paramInt);
  
  public abstract void verifyPwd(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.IQQFileEngine
 * JD-Core Version:    0.7.0.1
 */