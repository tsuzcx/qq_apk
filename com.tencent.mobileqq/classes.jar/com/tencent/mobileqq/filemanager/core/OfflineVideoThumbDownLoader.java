package com.tencent.mobileqq.filemanager.core;

import acwx;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;

public class OfflineVideoThumbDownLoader
  extends BaseThumbDownloader
{
  private FMObserver a;
  
  public OfflineVideoThumbDownLoader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new acwx(this);
    paramQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
  }
  
  private OfflineVideoThumbDownLoader.VideoSession a(long paramLong, boolean paramBoolean)
  {
    BaseThumbDownloader.Session localSession = a(paramLong);
    if (localSession == null) {
      return null;
    }
    if ((localSession instanceof OfflineVideoThumbDownLoader.VideoSession)) {
      return (OfflineVideoThumbDownLoader.VideoSession)localSession;
    }
    QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (paramFileManagerEntity.Uuid == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    int i = a(paramFileManagerEntity.fileName);
    if (-1 == i)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity });
      return null;
    }
    a();
    Object localObject1 = paramFileManagerEntity.Uuid.replace("/", "");
    Object localObject2 = FMSettings.a().d() + a(paramInt, (String)localObject1);
    localObject1 = localObject2;
    if (!FileUtil.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5)) {
        localObject1 = FMSettings.a().d() + a(paramInt, MD5.a(paramFileManagerEntity.strFileMd5));
      }
    }
    if (FileUtils.b((String)localObject1) == true)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + (String)localObject1);
      return localObject1;
    }
    localObject2 = new OfflineVideoThumbDownLoader.VideoSession(paramFileManagerEntity);
    ((OfflineVideoThumbDownLoader.VideoSession)localObject2).jdField_a_of_type_Int = paramInt;
    ((OfflineVideoThumbDownLoader.VideoSession)localObject2).b = i;
    a((BaseThumbDownloader.Session)localObject2, (String)localObject1);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + ((OfflineVideoThumbDownLoader.VideoSession)localObject2).jdField_a_of_type_Long + "]");
    return null;
  }
  
  public void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    paramHttpMsg.c = 0;
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    OfflineVideoThumbDownLoader.VideoSession localVideoSession = a(paramLong, false);
    if (localVideoSession == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
      FileManagerUtil.e(localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localVideoSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localVideoSession.jdField_a_of_type_Int) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramLong);
    return true;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader
 * JD-Core Version:    0.7.0.1
 */