package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.upload.IImageUploadListener;
import org.jetbrains.annotations.NotNull;

class UploadCoverTaskStep$1
  implements IImageUploadListener
{
  UploadCoverTaskStep$1(UploadCoverTaskStep paramUploadCoverTaskStep, UgcVideo paramUgcVideo) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload cover fail, errCode=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", errMsg=");
    localStringBuilder.append(paramString);
    QLog.e("RIJUGC.UploadCoverTaskStep", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status = UgcVideo.STATUS_FAILED;
      if (UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep) != null) {
        UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep).a(3, false, false, paramString);
      }
      UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep.d();
      UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep, false);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.status != UgcVideo.STATUS_PAUSE)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
      ((UgcVideo)localObject).coverProgress = ((int)((float)paramLong1 * 100.0F / (float)paramLong2));
      ((UgcVideo)localObject).status = UgcVideo.STATUS_UPLOADING;
      if (UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep) != null) {
        UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep).a(3, true, false, null);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("coverProgress =");
        ((StringBuilder)localObject).append(paramLong1);
        QLog.i("RIJUGC.UploadCoverTaskStep", 0, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("RIJUGC.UploadCoverTaskStep", 1, "upload cover success");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("upload cover url=");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("RIJUGC.UploadCoverTaskStep", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo;
    ((UgcVideo)localObject).coverUrl = paramString;
    if (((UgcVideo)localObject).status != UgcVideo.STATUS_PAUSE)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.coverProgress = 100;
      if (UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep) != null) {
        UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep).a(3, true, true, null);
      }
    }
    UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep).d(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep.d();
    UploadCoverTaskStep.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskUploadCoverTaskStep, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadCoverTaskStep.1
 * JD-Core Version:    0.7.0.1
 */