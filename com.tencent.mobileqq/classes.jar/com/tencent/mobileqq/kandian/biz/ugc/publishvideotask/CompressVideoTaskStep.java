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
  @Nullable
  private VideoCompressTask jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask;
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator;
  @NotNull
  private RIJUgcVideoPublishManager jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  
  public CompressVideoTaskStep(@NotNull QQAppInterface paramQQAppInterface, @NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "UploadCoverTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager = ((RIJUgcVideoPublishManager)paramQQAppInterface.getManager(QQManagerFactory.RIJ_UGC_VIDEO_PUBLISH_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
  }
  
  public void a()
  {
    super.a();
    this.b = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask;
    if (localObject != null) {
      ((VideoCompressTask)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    ((UgcVideo)localObject).status = UgcVideo.STATUS_PAUSE;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskRIJUgcVideoPublishManager.d((UgcVideo)localObject);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback;
    if (localObject != null) {
      ((IPublishTaskCallback)localObject).a(1, true, false, null);
    }
  }
  
  public boolean a()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
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
      this.b = false;
      localUgcVideo.startCompressTime = System.currentTimeMillis();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback.a(1, true, true, null);
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
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask = new VideoCompressTask(BaseApplicationImpl.getContext(), new CompressVideoTaskStep.1(this, localUgcVideo));
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoCompressVideoCompressTask.execute(new String[] { localUgcVideo.filePath });
      localUgcVideo.uploadVideoStatus = UgcVideo.SUBSTATUS_COMPRESS_VIDEO;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.CompressVideoTaskStep
 * JD-Core Version:    0.7.0.1
 */