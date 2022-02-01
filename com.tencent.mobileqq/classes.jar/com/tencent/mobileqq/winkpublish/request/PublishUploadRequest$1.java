package com.tencent.mobileqq.winkpublish.request;

import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting;
import com.tencent.mobileqq.winkpublish.model.QzoneMediaUploadParams;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudCommon.Entry;
import java.util.Arrays;

class PublishUploadRequest$1
  implements Runnable
{
  PublishUploadRequest$1(PublishUploadRequest paramPublishUploadRequest) {}
  
  public void run()
  {
    if (PublishUploadRequest.a(this.this$0))
    {
      PublishUploadRequest.b(this.this$0);
      PublishUploadRequest.c(this.this$0);
      return;
    }
    IUploadLocalConfig localIUploadLocalConfig = AUploadCommonSetting.a();
    String str3 = QCirclePublishQualityReporter.P_VIDEO_EXPORT_COST;
    Object localObject = PublishUploadRequest.d(this.this$0);
    FeedCloudCommon.Entry localEntry1 = QCircleReportHelper.newEntry("traceid", this.this$0.c.M);
    FeedCloudCommon.Entry localEntry2 = QCircleReportHelper.newEntry("ext6", String.valueOf(PublishUploadRequest.e(this.this$0)));
    StringBuilder localStringBuilder = new StringBuilder();
    boolean bool = PublishUploadRequest.f(this.this$0);
    String str2 = "QQ";
    String str1;
    if (bool) {
      str1 = "QQ";
    } else {
      str1 = "Peak";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(PublishUploadRequest.g(this.this$0));
    localIUploadLocalConfig.mapReport(str3, (String)localObject, Arrays.asList(new FeedCloudCommon.Entry[] { localEntry1, localEntry2, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()), QCircleReportHelper.newEntry("ret_code", "-80000006") }));
    localIUploadLocalConfig = AUploadCommonSetting.a();
    str3 = QCirclePublishQualityReporter.E_VIDEO_EXPORT_RESULT;
    localObject = QCircleReportHelper.newEntry("traceid", this.this$0.c.M);
    localEntry1 = QCircleReportHelper.newEntry("ret_code", "-80000006");
    localEntry2 = QCircleReportHelper.newEntry("ext6", String.valueOf(PublishUploadRequest.e(this.this$0)));
    localStringBuilder = new StringBuilder();
    if (PublishUploadRequest.f(this.this$0)) {
      str1 = str2;
    } else {
      str1 = "Peak";
    }
    localStringBuilder.append(str1);
    localStringBuilder.append(":");
    localStringBuilder.append(PublishUploadRequest.g(this.this$0));
    localIUploadLocalConfig.uploadQualityReport(str3, Arrays.asList(new FeedCloudCommon.Entry[] { localObject, localEntry1, localEntry2, QCircleReportHelper.newEntry("attach_info", localStringBuilder.toString()) }));
    PublishUploadRequest.a(this.this$0, 10001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.request.PublishUploadRequest.1
 * JD-Core Version:    0.7.0.1
 */