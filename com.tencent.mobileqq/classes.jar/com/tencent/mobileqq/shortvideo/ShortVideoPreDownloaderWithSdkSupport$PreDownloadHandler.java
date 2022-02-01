package com.tencent.mobileqq.shortvideo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.Callback;
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
  implements Callback
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
    BaseSVReceiveOperator.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader == null) {
      this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 101);
    }
    String str = SVUtils.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.getMd5());
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    localObject = SuperPlayerFactory.createVideoInfoForUrl(this.jdField_a_of_type_ArrayOfJavaLangString, 101, (String)localObject, str);
    long l1 = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileTime;
    int i = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.videoFileSize;
    long l2 = ShortVideoUtils.getPreDownloadTime();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentSuperplayerApiISPlayerPreDownloader.startPreDownload((SuperPlayerVideoInfo)localObject, l1 * 1000L, l2 * 1000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre-download handle short video:");
      ((StringBuilder)localObject).append(str);
      QLog.d("ShortVideoPreDownloader", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.setBitValue(0, (byte)1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.serial();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramFileMsg.uniseq != this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq) {
      return;
    }
    if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
    {
      paramInt1 = paramFileMsg.status;
      if (paramInt1 != 2002)
      {
        if ((paramInt1 != 2004) && (paramInt1 != 2005) && (paramInt1 != 5001) && (paramInt1 != 5002)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq.jdField_a_of_type_ComTencentMobileqqShortvideoVideoDownCallback.a(paramFileMsg.status);
        }
        ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).remove(this);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramFileMsg.urls != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.urls;
        this.jdField_a_of_type_JavaLangString = paramFileMsg.domain;
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
          {
            paramView = new StringBuilder();
            paramFileMsg = this.jdField_a_of_type_ArrayOfJavaLangString;
            paramView.append(paramFileMsg[paramInt1]);
            paramView.append("&txhost=");
            paramView.append(this.jdField_a_of_type_JavaLangString);
            paramFileMsg[paramInt1] = paramView.toString();
          }
          paramInt1 += 1;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq;
        paramView.jdField_a_of_type_ArrayOfJavaLangString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (paramView.jdField_a_of_type_Boolean) {
          ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport, this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoReq);
        } else {
          a();
        }
      }
      ShortVideoPreDownloaderWithSdkSupport.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoPreDownloaderWithSdkSupport).remove(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler
 * JD-Core Version:    0.7.0.1
 */