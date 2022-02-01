package com.tencent.mobileqq.kandian.biz.atlas;

import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

public class ReadInjoyAtlasReportUtils
{
  public static void a(int paramInt)
  {
    if ((paramInt == 41516) || (paramInt == 41522))
    {
      String str = new AtlasCommonR5Builder().a().a(paramInt).a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009EF4", "0X8009EF4", 0, 0, "", "", "", str, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.atlas.ReadInjoyAtlasReportUtils
 * JD-Core Version:    0.7.0.1
 */