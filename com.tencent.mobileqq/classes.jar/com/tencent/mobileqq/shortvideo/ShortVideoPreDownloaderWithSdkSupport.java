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
    if (paramShortVideoReq != null)
    {
      if (paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downFullVideo, uniseq = ");
        localStringBuilder.append(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.d("ShortVideoPreDownloader", 2, localStringBuilder.toString());
      }
      if (!QQVideoPlaySDKManager.a()) {
        QQVideoPlaySDKManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new ShortVideoPreDownloaderWithSdkSupport.1(this, paramShortVideoReq));
      }
      c(paramShortVideoReq);
    }
  }
  
  private void c(ShortVideoReq paramShortVideoReq)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startFullDownload, uniseq = ");
      ((StringBuilder)localObject1).append(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      QLog.d("ShortVideoPreDownloader", 2, ((StringBuilder)localObject1).toString());
    }
    this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader = SuperPlayerFactory.createDownloader(BaseApplicationImpl.getContext(), 101);
    Object localObject1 = SVUtils.a(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    if ((paramShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString != null) && (paramShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString.length > 0))
    {
      Object localObject2 = new StringBuilder();
      Object localObject3 = paramShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString;
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        ((StringBuilder)localObject2).append(localObject3[i]);
        ((StringBuilder)localObject2).append(";");
        i += 1;
      }
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5());
      ((StringBuilder)localObject3).append(paramShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
      localObject1 = SuperPlayerFactory.createVideoInfoForUrl((String)localObject2, 101, ((StringBuilder)localObject3).toString(), (String)localObject1);
      i = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.startOfflineDownload((SuperPlayerVideoInfo)localObject1, new ShortVideoPreDownloaderWithSdkSupport.2(this, paramShortVideoReq));
      if (i > 0)
      {
        paramShortVideoReq.f = i;
        return;
      }
      if (QLog.isColorLevel())
      {
        paramShortVideoReq = new StringBuilder();
        paramShortVideoReq.append(" downFullVideo error preLoadId = ");
        paramShortVideoReq.append(i);
        QLog.e("ShortVideoPreDownloader", 2, paramShortVideoReq.toString());
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downFullVideo, mVideoUrls is null");
    }
  }
  
  ShortVideoReq a()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      ShortVideoReq localShortVideoReq = a(this.jdField_a_of_type_JavaUtilList);
      if (localShortVideoReq != null)
      {
        a("getShortVideoRequest", "get a short video request from AIORequests");
        return localShortVideoReq;
      }
      synchronized (this.b)
      {
        localShortVideoReq = a(this.b);
        if (localShortVideoReq != null)
        {
          a("getShortVideoRequest", "get a short video request from C2CRequests");
          return localShortVideoReq;
        }
        synchronized (this.c)
        {
          localShortVideoReq = a(this.c);
          if (localShortVideoReq != null)
          {
            a("getShortVideoRequest", "get a short video request from DiscussionRequests");
            return localShortVideoReq;
          }
          synchronized (this.d)
          {
            localShortVideoReq = a(this.d);
            if (localShortVideoReq != null)
            {
              a("getShortVideoRequest", "get a short video request from GroupRequests");
              return localShortVideoReq;
            }
            a("getShortVideoRequest", "cannot get any request");
            return null;
          }
        }
      }
    }
  }
  
  ShortVideoReq a(List<ShortVideoReq> paramList)
  {
    int i = paramList.size();
    Object localObject2 = null;
    if (i <= 0) {
      return null;
    }
    Object localObject1;
    if (QQVideoPlaySDKManager.a())
    {
      i -= 1;
      localObject1 = (ShortVideoReq)paramList.get(i);
      paramList.remove(i);
      a("getRequestBySDKStatus", "sdk installed");
      return localObject1;
    }
    Iterator localIterator = paramList.iterator();
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (ShortVideoReq)localIterator.next();
    } while (((ShortVideoReq)localObject1).jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Int == 0);
    paramList.remove(localObject1);
    a("getRequestBySDKStatus", "get a short video request");
    return localObject1;
  }
  
  public void a(FileSaveReq paramFileSaveReq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "downloadLongVideoForSave.");
    }
    if ((paramFileSaveReq != null) && (paramFileSaveReq.a != null))
    {
      c(paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      Object localObject = paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c;
      long l = paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long;
      localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject, l);
      if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
        ((BaseDownloadProcessor)localObject).cancel();
      }
      a(paramFileSaveReq.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreDownloader", 2, "downloadLongVideoForSave, null param error.");
    }
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
    if ((paramFileSaveReq != null) && (paramFileSaveReq.a != null))
    {
      c(paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      IHttpCommunicatorListener localIHttpCommunicatorListener = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor(paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.c, paramFileSaveReq.a.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoDownloadInfo.jdField_a_of_type_Long);
      if ((localIHttpCommunicatorListener instanceof BaseDownloadProcessor)) {
        ((BaseDownloadProcessor)localIHttpCommunicatorListener).cancel();
      }
      if ((this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader != null) && (paramFileSaveReq.a.f > 0)) {
        this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerDownloader.stopOfflineDownload(paramFileSaveReq.a.f);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ShortVideoPreDownloader", 2, "cancelDownVideoForSave, null param error.");
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ISPlayerPreDownloader localISPlayerPreDownloader = this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader;
    if (localISPlayerPreDownloader != null)
    {
      localISPlayerPreDownloader.stopAllPreDownload();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.destory();
      this.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport
 * JD-Core Version:    0.7.0.1
 */