package com.tencent.mobileqq.shortvideo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.multimsg.save.FileSaveReq;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerDownloader;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShortVideoPreDownloaderWithSdkSupport
  extends ShortVideoPreDownloader
{
  ISPlayerDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader;
  ISPlayerPreDownloader jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
  private ArrayList<ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public ShortVideoPreDownloaderWithSdkSupport(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ShortVideoReq paramShortVideoReq)
  {
    if ((paramShortVideoReq == null) || (paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, uniseq = " + paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new ShortVideoPreDownloaderWithSdkSupport.1(this, paramShortVideoReq));
    }
    c(paramShortVideoReq);
  }
  
  private void c(ShortVideoReq paramShortVideoReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "startFullDownload, uniseq = " + paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject = ShortVideoUtils.getShortVideoSavePath(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    int i;
    if ((paramShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String[] arrayOfString = paramShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      i = 0;
      while (i < j)
      {
        localStringBuilder.append(arrayOfString[i]);
        localStringBuilder.append(";");
        i += 1;
      }
      localObject = SuperPlayerFactory.createVideoInfoForUrl(localStringBuilder.toString(), 101, paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, (String)localObject);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject, new ShortVideoPreDownloaderWithSdkSupport.2(this, paramShortVideoReq));
      if (i <= 0) {
        break label216;
      }
      paramShortVideoReq.f = i;
    }
    label216:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, mVideoUrls is null");
      return;
    }
    QLog.e("ShortVideoPreDownloader", 2, " downFullVideo error preLoadId = " + i);
  }
  
  ShortVideoReq a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ShortVideoReq localShortVideoReq1 = a(this.jdField_a_of_type_JavaUtilList);
      if (localShortVideoReq1 != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localShortVideoReq1;
      }
      synchronized (this.b)
      {
        localShortVideoReq1 = a(this.b);
        if (localShortVideoReq1 != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localShortVideoReq1;
        }
      }
    }
    synchronized (this.c)
    {
      ShortVideoReq localShortVideoReq2 = a(this.c);
      if (localShortVideoReq2 != null)
      {
        a("getShortVideoRequest", "get a short video request from DiscussionRequests");
        return localShortVideoReq2;
      }
    }
    synchronized (this.d)
    {
      ShortVideoReq localShortVideoReq3 = a(this.d);
      if (localShortVideoReq3 != null)
      {
        a("getShortVideoRequest", "get a short video request from GroupRequests");
        return localShortVideoReq3;
      }
    }
    a("getShortVideoRequest", "cannot get any request");
    return null;
  }
  
  ShortVideoReq a(List<ShortVideoReq> paramList)
  {
    int i = paramList.size();
    if (i <= 0) {
      return null;
    }
    ShortVideoReq localShortVideoReq;
    if (QQVideoPlaySDKManager.a())
    {
      localShortVideoReq = (ShortVideoReq)paramList.get(i - 1);
      paramList.remove(i - 1);
      a("getRequestBySDKStatus", "sdk installed");
      paramList = localShortVideoReq;
      return paramList;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      localShortVideoReq = (ShortVideoReq)localIterator.next();
      if (localShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Int != 0) {
        paramList.remove(localShortVideoReq);
      }
    }
    for (paramList = localShortVideoReq;; paramList = null)
    {
      a("getRequestBySDKStatus", "get a short video request");
      break;
    }
  }
  
  public void a(FileSaveReq paramFileSaveReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramFileSaveReq == null) || (paramFileSaveReq.a == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
      }
      return;
    }
    c(paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
    Object localObject = paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c;
    long l = paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long;
    localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
      ((BaseDownloadProcessor)localObject).cancel();
    }
    a(paramFileSaveReq.a);
  }
  
  protected void a(ShortVideoReq paramShortVideoReq)
  {
    super.a(paramShortVideoReq);
    if (paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Int == 0)
    {
      FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (localFileTransferManager != null)
      {
        paramShortVideoReq = new ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler(this, paramShortVideoReq);
        this.jdField_a_of_type_JavaUtilArrayList.add(paramShortVideoReq);
        localFileTransferManager.a(paramShortVideoReq.a, paramShortVideoReq);
      }
    }
  }
  
  public void b(FileSaveReq paramFileSaveReq)
  {
    if ((paramFileSaveReq == null) || (paramFileSaveReq.a == null)) {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
      }
    }
    do
    {
      return;
      c(paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c, paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long);
      if ((localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      }
    } while ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader == null) || (paramFileSaveReq.a.f <= 0));
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramFileSaveReq.a.f);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.stopAllPreDownload();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport
 * JD-Core Version:    0.7.0.1
 */