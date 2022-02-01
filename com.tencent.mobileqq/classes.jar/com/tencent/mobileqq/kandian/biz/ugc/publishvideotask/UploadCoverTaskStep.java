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
  @NotNull
  private PublishTaskAutomator a;
  @Nullable
  private IPublishTaskCallback b;
  private volatile boolean c = false;
  private String d = "";
  @NotNull
  private RIJUgcVideoPublishManager e;
  private IImageUploader f;
  private QQAppInterface g;
  
  public UploadCoverTaskStep(@NotNull QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "UploadCoverTaskStep");
    this.g = paramQQAppInterface;
    this.e = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.a = paramPublishTaskAutomator;
    this.b = paramIPublishTaskCallback;
  }
  
  private boolean a(UgcVideo paramUgcVideo)
  {
    if (TextUtils.equals(this.d, paramUgcVideo.coverPath)) {
      return false;
    }
    this.d = paramUgcVideo.coverPath;
    paramUgcVideo.coverUrl = "";
    paramUgcVideo.coverProgress = 0;
    this.e.d(paramUgcVideo);
    return true;
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.a.e();
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
      this.b.a(3, true, bool, null);
    }
    return (super.a()) && (i != 0);
  }
  
  public boolean b()
  {
    Object localObject1 = this.a.e();
    String str;
    if (((UgcVideo)localObject1).coverPath != null) {
      str = ((UgcVideo)localObject1).coverPath;
    } else {
      str = "";
    }
    if (!this.c)
    {
      this.c = true;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onStep begin upload cover:");
      ((StringBuilder)localObject2).append(str);
      QLog.i("RIJUGC.UploadCoverTaskStep", 1, ((StringBuilder)localObject2).toString());
      localObject1 = new UploadCoverTaskStep.1(this, (UgcVideo)localObject1);
      localObject2 = this.f;
      if (localObject2 != null) {
        ((IImageUploader)localObject2).b();
      }
      this.f = new RIJUgcImageUploader(BaseApplicationImpl.getContext(), this.g, str);
      this.f.a((IImageUploadListener)localObject1);
      this.f.a();
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    UgcVideo localUgcVideo = this.a.e();
    if ((this.f != null) && (localUgcVideo.status == UgcVideo.STATUS_UPLOADING)) {
      this.f.b();
    }
    this.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.UploadCoverTaskStep
 * JD-Core Version:    0.7.0.1
 */