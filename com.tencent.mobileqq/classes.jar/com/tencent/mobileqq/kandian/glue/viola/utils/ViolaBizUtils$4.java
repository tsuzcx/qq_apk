package com.tencent.mobileqq.kandian.glue.viola.utils;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.RIJUgcUtils;
import com.tencent.mobileqq.kandian.biz.ugc.api.IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class ViolaBizUtils$4
  implements IRIJUgcVideoPublishService.IGetAllUploadStatusVideosCallback
{
  ViolaBizUtils$4(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localUgcVideo = (UgcVideo)((Iterator)localObject).next();
      if (TextUtils.equals(localUgcVideo.seqId, this.jdField_a_of_type_JavaLangString)) {
        break label51;
      }
    }
    UgcVideo localUgcVideo = null;
    label51:
    if (localUgcVideo != null)
    {
      localObject = RIJUgcUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.publicType).build();
      if (localUgcVideo.status == UgcVideo.STATUS_PAUSE) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC62", (String)localObject);
      } else if (localUgcVideo.status == UgcVideo.STATUS_FAILED) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AC63", (String)localObject);
      }
      if ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (QBaseActivity.sTopActivity != null) && (CUKingCardUtils.a() != 1))
      {
        long l = RIJUgcUtils.a(localUgcVideo);
        if (l > 0L)
        {
          RIJUgcUtils.a(QBaseActivity.sTopActivity, l, new ViolaBizUtils.4.1(this, localUgcVideo, paramList), null);
          return;
        }
        RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
        ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
      RIJUgcVideoPublishManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
      ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
      return;
    }
    ViolaBizUtils.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.4
 * JD-Core Version:    0.7.0.1
 */