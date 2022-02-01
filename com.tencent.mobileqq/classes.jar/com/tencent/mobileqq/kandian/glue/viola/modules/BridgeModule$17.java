package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import java.util.List;
import org.jetbrains.annotations.NotNull;

class BridgeModule$17
  implements IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback
{
  BridgeModule$17(BridgeModule paramBridgeModule, UgcVideo paramUgcVideo, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    BridgeModule.access$1600(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcEntityUgcVideo.columnId, paramList, this.jdField_a_of_type_JavaLangString, 0, "", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.17
 * JD-Core Version:    0.7.0.1
 */