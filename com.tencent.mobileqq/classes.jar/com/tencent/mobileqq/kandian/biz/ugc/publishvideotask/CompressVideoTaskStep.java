package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.biz.pubaccount.util.MD5Utils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.automator.BaseStep;
import com.tencent.mobileqq.kandian.base.video.compress.VideoCompressTask;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import java.io.File;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CompressVideoTaskStep
  extends BaseStep
{
  @NotNull
  private PublishTaskAutomator a;
  @Nullable
  private IPublishTaskCallback b;
  private volatile boolean c = false;
  private volatile boolean d = false;
  @NotNull
  private RIJUgcVideoPublishManager e;
  @Nullable
  private VideoCompressTask f;
  
  public CompressVideoTaskStep(@NotNull QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "UploadCoverTaskStep");
    this.e = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.a = paramPublishTaskAutomator;
    this.b = paramIPublishTaskCallback;
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.a.e();
    String str = localUgcVideo.compressPath;
    boolean bool2 = false;
    int i;
    if ((str != null) && (!localUgcVideo.compressPath.isEmpty()) && (new File(localUgcVideo.compressPath).exists())) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localUgcVideo.compressProgress = 100;
    }
    int j;
    if (localUgcVideo.retryTime >= UgcVideo.RETRY_TIME_LIMIT) {
      j = 1;
    } else {
      j = 0;
    }
    if (j != 0)
    {
      str = localUgcVideo.filePath;
      File localFile = new File(str);
      localUgcVideo.compressPath = str;
      str = MD5Utils.a(localFile);
      if (str == null) {
        str = "";
      }
      localUgcVideo.fileMd5 = str;
      long l;
      if (localFile.exists()) {
        l = localFile.length();
      } else {
        l = 0L;
      }
      localUgcVideo.fileSize = l;
    }
    if ((i == 0) && (localUgcVideo.status != UgcVideo.STATUS_PAUSE) && (j == 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.d = false;
      localUgcVideo.startCompressTime = System.currentTimeMillis();
    }
    else
    {
      this.b.a(1, true, true, null);
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
    if (!this.c)
    {
      this.c = true;
      UgcVideo localUgcVideo = this.a.e();
      this.f = new VideoCompressTask(BaseApplicationImpl.getContext(), new CompressVideoTaskStep.1(this, localUgcVideo));
      this.f.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
  
  public void c()
  {
    super.c();
    this.d = true;
    Object localObject = this.f;
    if (localObject != null) {
      ((VideoCompressTask)localObject).a();
    }
    localObject = this.a.e();
    ((UgcVideo)localObject).status = UgcVideo.STATUS_PAUSE;
    this.e.d((UgcVideo)localObject);
    localObject = this.b;
    if (localObject != null) {
      ((IPublishTaskCallback)localObject).a(1, true, false, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.CompressVideoTaskStep
 * JD-Core Version:    0.7.0.1
 */