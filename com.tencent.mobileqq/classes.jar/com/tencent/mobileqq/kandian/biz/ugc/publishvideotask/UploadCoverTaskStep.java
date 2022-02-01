package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.automator.BaseStep;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploader;
import com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcImageUploader;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class UploadCoverTaskStep
  extends BaseStep
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator;
  @NotNull
  private RIJUgcVideoPublishManager jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager;
  private IImageUploader jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader;
  private String jdField_a_of_type_JavaLangString = "";
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public UploadCoverTaskStep(@NotNull QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
  }
  
  private boolean a(UgcVideo paramUgcVideo)
  {
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramUgcVideo.coverPath)) {
      return false;
    }
    this.jdField_a_of_type_JavaLangString = paramUgcVideo.coverPath;
    paramUgcVideo.coverUrl = "";
    paramUgcVideo.coverProgress = 0;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager.d(paramUgcVideo);
    return true;
  }
  
  public void a()
  {
    super.a();
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader.b();
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    if ((a(localUgcVideo)) && (localUgcVideo.status != UgcVideo.STATUS_PAUSE)) {
      return super.a();
    }
    boolean bool = TextUtils.isEmpty(localUgcVideo.coverUrl) ^ true;
    if (bool) {
      localUgcVideo.coverProgress = 100;
    }
    int i;
    if ((!bool) && (localUgcVideo.status != UgcVideo.STATUS_PAUSE)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback.a(3, true, bool, null);
    }
    return (super.a()) && (i != 0);
  }
  
  public boolean b()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    String str;
    if (((UgcVideo)localObject1).coverPath != null) {
      str = ((UgcVideo)localObject1).coverPath;
    } else {
      str = "";
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onStep begin upload cover:");
      ((StringBuilder)localObject2).append(str);
      QLog.i("RIJUGC.UploadCoverTaskStep", 1, ((StringBuilder)localObject2).toString());
      localObject1 = new UploadCoverTaskStep.1(this, (UgcVideo)localObject1);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader;
      if (localObject2 != null) {
        ((IImageUploader)localObject2).b();
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader = new RIJUgcImageUploader(BaseApplicationImpl.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader.a((IImageUploadListener)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIImageUploader.a();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadCoverTaskStep
 * JD-Core Version:    0.7.0.1
 */