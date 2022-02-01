package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.automator.BaseStep;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IVideoUploader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UploadVideoTaskStep
  extends BaseStep
{
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator;
  @NotNull
  private RIJUgcVideoPublishManager jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager;
  @NotNull
  private IVideoUploader jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploader;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public UploadVideoTaskStep(QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback, @NotNull IVideoUploader paramIVideoUploader)
  {
    super(paramPublishTaskAutomator, true, "UploadVideoTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploader = paramIVideoUploader;
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseUpload, ugcVideo.status=");
    localStringBuilder.append(localUgcVideo.status);
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, localStringBuilder.toString());
    if ((localUgcVideo.status == UgcVideo.STATUS_UPLOADING) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE))
    {
      if (!TextUtils.isEmpty(localUgcVideo.videoUploadKey))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploader.a();
        return;
      }
      QLog.e("RIJUGC.UploadVideoTaskStep", 1, "videoUploadKey is Empty");
    }
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a().lastUploadSizeUpdateTime = 0L;
    b();
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    String str2 = localUgcVideo.compressPath;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    int i = localUgcVideo.url.length();
    boolean bool2 = false;
    if ((i == 0) && (new File(str1).exists()) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback.a(2, true, true, null);
    }
    boolean bool1 = bool2;
    if (super.a())
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean b()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    String str = localUgcVideo.compressPath;
    if ((!this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(str)))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a().status = UgcVideo.STATUS_UPLOADING;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStep begin upload video, filePath=");
      ((StringBuilder)localObject).append(str);
      QLog.i("RIJUGC.UploadVideoTaskStep", 1, ((StringBuilder)localObject).toString());
      localUgcVideo.startUploadingTime = System.currentTimeMillis();
      if (localUgcVideo.startUserWaitingTime > 0L) {
        localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager.d(localUgcVideo);
      localObject = localUgcVideo.videoUploadKey;
      localUgcVideo.lastUploadSizeUpdateTime = System.currentTimeMillis();
      UploadVideoTaskStep.1 local1 = new UploadVideoTaskStep.1(this, localUgcVideo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploader.a(local1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploader.a(str);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploader.b((String)localObject);
      }
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_UPLOADING_VIDEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadVideoTaskStep
 * JD-Core Version:    0.7.0.1
 */