package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.base.automator.BaseStep;
import com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PublishTaskStep
  extends BaseStep
{
  @Nullable
  private IPublishTaskCallback jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback;
  @NotNull
  private PublishTaskAutomator jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator;
  
  public PublishTaskStep(@NotNull PublishTaskAutomator paramPublishTaskAutomator, @Nullable IPublishTaskCallback paramIPublishTaskCallback)
  {
    super(paramPublishTaskAutomator, true, "PublishTaskStep");
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator = paramPublishTaskAutomator;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback = paramIPublishTaskCallback;
  }
  
  private void a(UgcVideo paramUgcVideo)
  {
    if ((paramUgcVideo.rowkey != null) && (!paramUgcVideo.rowkey.isEmpty())) {
      paramUgcVideo.status = UgcVideo.STATUS_FINISH;
    } else {
      paramUgcVideo.status = UgcVideo.STATUS_FAILED;
    }
    IPublishTaskCallback localIPublishTaskCallback = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskIPublishTaskCallback;
    if (localIPublishTaskCallback != null)
    {
      boolean bool;
      if (paramUgcVideo.status == UgcVideo.STATUS_FINISH) {
        bool = true;
      } else {
        bool = false;
      }
      localIPublishTaskCallback.a(4, bool, true, "");
    }
    d();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a().status == UgcVideo.STATUS_UPLOADING;
  }
  
  public boolean b()
  {
    UgcVideo localUgcVideo = this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcPublishvideotaskPublishTaskAutomator.a();
    Object localObject1 = localUgcVideo.title;
    Object localObject2 = localUgcVideo.url;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("onStep: title=");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    boolean bool = true;
    QLog.i("RIJUGC.PublishTaskStep", 1, (String)localObject2);
    if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
    {
      localObject1 = new ArrayList();
      ((List)localObject1).add(localUgcVideo);
      if (localUgcVideo.columnId == 0L) {
        bool = false;
      }
      PublishVideoHelper.a(bool, (List)localObject1, new PublishTaskStep.1(this, localUgcVideo), localUgcVideo.needShowPublishToast);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.PublishTaskStep
 * JD-Core Version:    0.7.0.1
 */