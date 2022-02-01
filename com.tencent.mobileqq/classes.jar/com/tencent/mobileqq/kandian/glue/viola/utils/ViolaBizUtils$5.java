package com.tencent.mobileqq.kandian.glue.viola.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$5
  implements IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$5(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localUgcVideo = (UgcVideo)((Iterator)localObject).next();
      if (TextUtils.equals(localUgcVideo.seqId, this.jdField_a_of_type_JavaLangString)) {
        break label45;
      }
    }
    UgcVideo localUgcVideo = null;
    label45:
    if (localUgcVideo != null)
    {
      localObject = RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.publicType).build();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC61", (String)localObject);
      RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localUgcVideo);
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
      return;
    }
    ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.5
 * JD-Core Version:    0.7.0.1
 */