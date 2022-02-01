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
  @NotNull
  private PublishTaskAutomator a;
  @Nullable
  private IPublishTaskCallback b;
  private volatile boolean c = false;
  @NotNull
  private RIJUgcVideoPublishManager d;
  @NotNull
  private IVideoUploader e;
  
  public UploadVideoTaskStep(QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback, @NotNull IVideoUploader paramIVideoUploader)
  {
    super(paramPublishTaskAutomator, true, "UploadVideoTaskStep");
    this.d = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.a = paramPublishTaskAutomator;
    this.b = paramIPublishTaskCallback;
    this.e = paramIVideoUploader;
  }
  
  private void d()
  {
    this.c = false;
    UgcVideo localUgcVideo = this.a.e();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pauseUpload, ugcVideo.status=");
    localStringBuilder.append(localUgcVideo.status);
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, localStringBuilder.toString());
    if ((localUgcVideo.status == UgcVideo.STATUS_UPLOADING) || (localUgcVideo.status == UgcVideo.STATUS_PAUSE))
    {
      if (!TextUtils.isEmpty(localUgcVideo.videoUploadKey))
      {
        this.e.a();
        return;
      }
      QLog.e("RIJUGC.UploadVideoTaskStep", 1, "videoUploadKey is Empty");
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.a.e();
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
      this.b.a(2, true, true, null);
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
    UgcVideo localUgcVideo = this.a.e();
    String str = localUgcVideo.compressPath;
    if ((!this.c) && (!TextUtils.isEmpty(str)))
    {
      this.c = true;
      this.a.e().status = UgcVideo.STATUS_UPLOADING;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onStep begin upload video, filePath=");
      ((StringBuilder)localObject).append(str);
      QLog.i("RIJUGC.UploadVideoTaskStep", 1, ((StringBuilder)localObject).toString());
      localUgcVideo.startUploadingTime = System.currentTimeMillis();
      if (localUgcVideo.startUserWaitingTime > 0L) {
        localUgcVideo.startUserWaitingTime = System.currentTimeMillis();
      }
      this.d.d(localUgcVideo);
      localObject = localUgcVideo.videoUploadKey;
      localUgcVideo.lastUploadSizeUpdateTime = System.currentTimeMillis();
      UploadVideoTaskStep.1 local1 = new UploadVideoTaskStep.1(this, localUgcVideo);
      this.e.a(local1);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        this.e.a(str);
      } else {
        this.e.b((String)localObject);
      }
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_UPLOADING_VIDEO;
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    this.a.e().lastUploadSizeUpdateTime = 0L;
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadVideoTaskStep
 * JD-Core Version:    0.7.0.1
 */