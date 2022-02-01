package com.tencent.mobileqq.kandian.biz.daily;

import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class DailyDynamicHeaderViewController$5$1
  implements Runnable
{
  DailyDynamicHeaderViewController$5$1(DailyDynamicHeaderViewController.5 param5, int paramInt, SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo;
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.cityCode;
        String str = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.city;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onLocationFinish] adCode=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" cityName=");
        localStringBuilder.append(str);
        QLog.i("DailyHeaderViewController", 1, localStringBuilder.toString());
        RIJSPUtils.a("sp_key_daily_dynamic_header_last_refresh_time", Long.valueOf(System.currentTimeMillis()));
        ReadInJoyLogicEngine.a().t();
        return;
      }
    }
    DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizDailyDailyDynamicHeaderViewController$5.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.DailyDynamicHeaderViewController.5.1
 * JD-Core Version:    0.7.0.1
 */