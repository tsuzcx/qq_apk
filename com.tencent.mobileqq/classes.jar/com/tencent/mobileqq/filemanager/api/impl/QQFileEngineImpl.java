package com.tencent.mobileqq.filemanager.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.QQFileHostInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.GetFileListResult;
import com.tencent.mobileqq.filemanager.app.IQQFavProxy.QQFavProxyListener;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileManagerRSCenter;
import com.tencent.mobileqq.filemanager.core.OnlineFileSessionCenter;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qlink.QQProxyForQlink;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class QQFileEngineImpl
  implements IQQFileEngine
{
  public static final String TAG = "QQFileEngineImpl";
  QQAppInterface mApp;
  
  public void clearNewDownload()
  {
    this.mApp.getFileManagerEngine().c();
  }
  
  public void delAllSelectedFiles(boolean paramBoolean)
  {
    this.mApp.getFileManagerEngine().a(paramBoolean);
  }
  
  public boolean delete(long paramLong)
  {
    return this.mApp.getFileManagerEngine().b(paramLong);
  }
  
  public void deleteOfflineFile(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    this.mApp.getFileManagerEngine().a(paramString1, paramString2, paramString3, paramString4, paramBoolean);
  }
  
  public void deleteWeiYunFile(WeiYunFileInfo paramWeiYunFileInfo)
  {
    this.mApp.getFileManagerEngine().a(paramWeiYunFileInfo);
  }
  
  public void downLoadAllSelectFiles(Context paramContext)
  {
    this.mApp.getFileManagerEngine().a(paramContext);
  }
  
  public void downLoadDiscThumb(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    this.mApp.getFileManagerEngine().a(paramFileManagerEntity, paramInt);
  }
  
  public String downloadOfflineVideoThumb(FileManagerEntity paramFileManagerEntity)
  {
    return this.mApp.getFileManagerEngine().a(paramFileManagerEntity);
  }
  
  public void exitQlinkLocalFileBrowser()
  {
    this.mApp.getQQProxyForQlink().f();
  }
  
  public void favProxyAddListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener)
  {
    this.mApp.getFileManagerEngine().a().addListener(paramQQFavProxyListener);
  }
  
  public void favProxyCancelGetFileList(long paramLong)
  {
    this.mApp.getFileManagerEngine().a().cancelGetFileList(paramLong);
  }
  
  public void favProxyDeleteListener(IQQFavProxy.QQFavProxyListener paramQQFavProxyListener)
  {
    this.mApp.getFileManagerEngine().a().deleteListener(paramQQFavProxyListener);
  }
  
  public void favProxyGetFileList(long paramLong, boolean paramBoolean, Bundle paramBundle, IQQFavProxy.GetFileListResult paramGetFileListResult)
  {
    this.mApp.getFileManagerEngine().a().getFileList(paramLong, paramBoolean, paramBundle, paramGetFileListResult);
  }
  
  public long favProxyGetGettedPartList(long paramLong, List<FavFileInfo> paramList)
  {
    return this.mApp.getFileManagerEngine().a().getGettedPartList(paramLong, paramList);
  }
  
  public void favProxyRefreshList(Bundle paramBundle)
  {
    this.mApp.getFileManagerEngine().a().refreshList(paramBundle);
  }
  
  public void favProxydownloadThumb(FavFileInfo paramFavFileInfo, int paramInt)
  {
    this.mApp.getFileManagerEngine().a().downloadThumb(paramFavFileInfo, paramInt);
  }
  
  public int getBigDataHostList(boolean paramBoolean, int paramInt, List<QQFileHostInfo> paramList)
  {
    if (paramList == null) {
      return -1;
    }
    Object localObject1 = (IExcitingTransferAdapter)this.mApp.getRuntimeService(IExcitingTransferAdapter.class, "");
    int i = 1;
    Object localObject2;
    if (paramBoolean)
    {
      QLog.i("QQFileEngineImpl", 1, "[IPv6-File] exciting offlinefile upload. is config enable IPv6.");
      localObject2 = ((IExcitingTransferAdapter)localObject1).getBigDataHostList(false);
      List localList = FileIPv6StrateyController.a().getIPV6listForExcitingUpload(this.mApp, paramInt);
      localObject1 = localObject2;
      paramInt = i;
      if (localList != null)
      {
        localObject1 = localObject2;
        paramInt = i;
        if (localList.size() > 0)
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ArrayList();
          }
          paramInt = localList.size() - 1;
          while (paramInt >= 0)
          {
            ((List)localObject1).add(0, (ExcitingTransferHostInfo)localList.get(paramInt));
            paramInt -= 1;
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("[IPv6-File] exciting offlinefile upload. use IPv6. iplist:");
          ((StringBuilder)localObject2).append(localObject1.toString());
          QLog.i("QQFileEngineImpl", 1, ((StringBuilder)localObject2).toString());
          paramInt = 2;
        }
      }
    }
    else
    {
      localObject1 = ((IExcitingTransferAdapter)localObject1).getBigDataHostList(false);
      paramInt = i;
    }
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ExcitingTransferHostInfo)((Iterator)localObject1).next();
        paramList.add(new QQFileHostInfo(((ExcitingTransferHostInfo)localObject2).mstrIp, ((ExcitingTransferHostInfo)localObject2).mport));
      }
    }
    return paramInt;
  }
  
  public int getIPv6HostsFromDns(String paramString, int paramInt1, int paramInt2, List<String> paramList)
  {
    if (paramList == null) {
      return -1;
    }
    paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt1);
    paramString = FileIPv6StrateyController.a().getIPlistForV6Domain(this.mApp, paramString, paramInt2);
    if ((paramString != null) && (!paramString.a()))
    {
      Iterator localIterator = paramString.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FileIPv6StrateyController.IPInfo localIPInfo = (FileIPv6StrateyController.IPInfo)localIterator.next();
        if (paramInt1 == 0)
        {
          paramList.add(localIPInfo.jdField_a_of_type_JavaLangString);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localIPInfo.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(":");
          localStringBuilder.append(localIPInfo.jdField_a_of_type_Int);
          paramList.add(localStringBuilder.toString());
        }
      }
      return paramString.jdField_a_of_type_Int;
    }
    return -1;
  }
  
  public String getWeiYunPicThumb(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    return this.mApp.getFileManagerEngine().a(paramString1, paramString2, paramInt, paramObject);
  }
  
  public void getWeiYunPreview(String paramString1, String paramString2)
  {
    this.mApp.getFileManagerEngine().c(paramString1, paramString2);
  }
  
  public String getWeiYunVideoThumb(String paramString1, String paramString2, int paramInt, WeiYunFileInfo paramWeiYunFileInfo)
  {
    return this.mApp.getFileManagerEngine().b(paramString1, paramString2, paramInt, paramWeiYunFileInfo);
  }
  
  public boolean hasQueriedVerifyPassword()
  {
    return this.mApp.getFileManagerEngine().a();
  }
  
  public void initAppStoreSDK()
  {
    this.mApp.getFileManagerEngine().a().a();
  }
  
  public boolean isFileInUploaderQueue(String paramString)
  {
    return this.mApp.getFileManagerRSCenter().a(paramString);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.mApp = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public void onDestroy() {}
  
  public void pause(long paramLong)
  {
    this.mApp.getFileManagerEngine().a(paramLong);
  }
  
  public void pauseOnlineTrans(long paramLong)
  {
    this.mApp.getOnlineFileSessionCenter().a(paramLong);
  }
  
  public FileManagerEntity queryFileEntityByFileId(String paramString)
  {
    return this.mApp.getFileManagerRSCenter().a(paramString);
  }
  
  public void queryNeedVerifyPwd()
  {
    this.mApp.getFileManagerEngine().a();
  }
  
  public void queryWeiyunFileList(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    this.mApp.getFileManagerEngine().a(paramInt1, paramString1, paramInt2, paramInt3, paramString2);
  }
  
  public void reciveFile(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.getFileManagerEngine().c(paramFileManagerEntity);
  }
  
  public void recvOnLineFile(long paramLong)
  {
    this.mApp.getOnlineFileSessionCenter().a(paramLong);
  }
  
  public void requestSendQlinkFile(Activity paramActivity, ArrayList<String> paramArrayList, String paramString)
  {
    this.mApp.getQQProxyForQlink().a(paramActivity, paramArrayList, 15, 0, true, paramString);
  }
  
  public void resume(long paramLong)
  {
    this.mApp.getFileManagerEngine().a(paramLong);
  }
  
  public void resumeOnlineTrans(long paramLong)
  {
    this.mApp.getOnlineFileSessionCenter().b(paramLong);
  }
  
  public void reviceFile(FileManagerEntity paramFileManagerEntity)
  {
    this.mApp.getFileManagerEngine().c(paramFileManagerEntity);
  }
  
  public ArrayList<FileManagerEntity> saveAllSelectFileToWeiYun()
  {
    return this.mApp.getFileManagerEngine().a();
  }
  
  public void sendAllSelectedFiles(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    this.mApp.getFileManagerEngine().a(paramBoolean, paramString1, paramString2, paramInt);
  }
  
  public void verifyPwd(String paramString)
  {
    this.mApp.getFileManagerEngine().a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QQFileEngineImpl
 * JD-Core Version:    0.7.0.1
 */