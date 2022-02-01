package com.tencent.mobileqq.kandian.biz.skin;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.nv.Node;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import org.json.JSONException;

class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  ReadInJoySkinGuideView$1$1$1(ReadInJoySkinGuideView.1.1 param1, ILayer paramILayer) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.this$0.a.a((Node)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.this$0.a.a();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    try
    {
      localReportR5Builder.addKandianMode();
      localReportR5Builder.addString("guide_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.b);
      localReportR5Builder.addInt("channel_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.jdField_a_of_type_Int);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(RIJAppSetting.a());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(ReadInJoySkinGuideView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizSkinReadInJoySkinGuideView$1$1.a.this$0));
    localIPublicAccountReportUtils.publicAccountReportClickEvent(localQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, str, (String)localObject, localStringBuilder.toString(), localReportR5Builder.build(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.skin.ReadInJoySkinGuideView.1.1.1
 * JD-Core Version:    0.7.0.1
 */