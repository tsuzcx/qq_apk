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
    if (this.a.status != UgcVideo.STATUS_PAUSE)
    {
      this.a.status = UgcVideo.STATUS_FAILED;
      if (UploadCoverTaskStep.a(this.b) != null) {
        UploadCoverTaskStep.a(this.b).a(3, false, false, paramString);
      }
      UploadCoverTaskStep.b(this.b).d(this.a);
      this.b.g();
      UploadCoverTaskStep.a(this.b, false);
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.a.status != UgcVideo.STATUS_PAUSE)
    {
      Object localObject = this.a;
      ((UgcVideo)localObject).coverProgress = ((int)((float)paramLong1 * 100.0F / (float)paramLong2));
      ((UgcVideo)localObject).status = UgcVideo.STATUS_UPLOADING;
      if (UploadCoverTaskStep.a(this.b) != null) {
        UploadCoverTaskStep.a(this.b).a(3, true, false, null);
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
    Object localObject = this.a;
    ((UgcVideo)localObject).coverUrl = paramString;
    if (((UgcVideo)localObject).status != UgcVideo.STATUS_PAUSE)
    {
      this.a.coverProgress = 100;
      if (UploadCoverTaskStep.a(this.b) != null) {
        UploadCoverTaskStep.a(this.b).a(3, true, true, null);
      }
    }
    UploadCoverTaskStep.b(this.b).d(this.a);
    this.b.g();
    UploadCoverTaskStep.a(this.b, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadCoverTaskStep.1
 * JD-Core Version:    0.7.0.1
 */