package com.tencent.mobileqq.kandian.biz.publisher.impls;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IVideoPublishCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.tkd.topicsdk.interfaces.IPublishManager.IPublishListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "ugcVideo", "Lcom/tencent/mobileqq/kandian/biz/ugc/entity/UgcVideo;", "kotlin.jvm.PlatformType", "onPublish"}, k=3, mv={1, 1, 16})
final class PublishManagerImpl$addPublishListener$videoPublishCallback$1
  implements IRIJUgcVideoPublishService.IVideoPublishCallback
{
  public final void a(UgcVideo paramUgcVideo)
  {
    PublishManagerImpl localPublishManagerImpl = this.jdField_a_of_type_ComTencentMobileqqKandianBizPublisherImplsPublishManagerImpl;
    Intrinsics.checkExpressionValueIsNotNull(paramUgcVideo, "ugcVideo");
    paramUgcVideo = PublishManagerImpl.a(localPublishManagerImpl, paramUgcVideo);
    if (paramUgcVideo != null) {
      this.jdField_a_of_type_ComTencentTkdTopicsdkInterfacesIPublishManager$IPublishListener.a(paramUgcVideo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.impls.PublishManagerImpl.addPublishListener.videoPublishCallback.1
 * JD-Core Version:    0.7.0.1
 */