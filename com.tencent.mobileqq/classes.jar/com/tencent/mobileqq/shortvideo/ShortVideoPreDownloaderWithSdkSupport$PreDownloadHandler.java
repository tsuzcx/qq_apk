package com.tencent.mobileqq.shortvideo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.FileTransferManager.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

public class ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler
  implements FileTransferManager.Callback
{
  public View a;
  private ShortVideoReq jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler(ShortVideoPreDownloaderWithSdkSupport paramShortVideoPreDownloaderWithSdkSupport, ShortVideoReq paramShortVideoReq)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq = paramShortVideoReq;
    this.jdField_a_of_type_AndroidViewView = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), new ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler.1(this));
    }
    b();
    BaseShortVideoOprerator.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 101);
    }
    String str = ShortVideoUtils.getShortVideoSavePath(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5() + this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localObject = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ArrayOfJavaLangString, 101, (String)localObject, str);
    long l1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime;
    long l2 = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
    l2 = ShortVideoUtils.getPreDownloadTime();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)localObject, l1 * 1000L, l2 * 1000L);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoPreDownloader", 2, "pre-download handle short video:" + str);
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
  }
  
  public void a(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramFileMsg.uniseq != this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {}
    while ((paramFileMsg.fileType != 6) && (paramFileMsg.fileType != 17) && (paramFileMsg.fileType != 9) && (paramFileMsg.fileType != 20)) {
      return;
    }
    switch (paramFileMsg.status)
    {
    default: 
      return;
    case 2002: 
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramFileMsg.urls != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.urls;
        this.jdField_a_of_type_JavaLangString = paramFileMsg.domain;
        paramInt1 = 0;
      }
      break;
    case 2004: 
    case 2005: 
    case 5001: 
    case 5002: 
      while (paramInt1 < 1)
      {
        if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
        {
          paramView = new StringBuilder();
          paramFileMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
          paramFileMsg[paramInt1] = (paramFileMsg[paramInt1] + "&txhost=" + this.jdField_a_of_type_JavaLangString);
        }
        paramInt1 += 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport$VideoDownCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport$VideoDownCallback.a(paramFileMsg.status);
        }
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).remove(this);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
      if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_Boolean) {
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
      }
      break;
    }
    for (;;)
    {
      ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).remove(this);
      return;
      a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler
 * JD-Core Version:    0.7.0.1
 */