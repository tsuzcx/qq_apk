package com.tencent.mobileqq.kandian.biz.feeds.fragment;

import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Map;

class ReadInJoyPicWaterFallFragment$6$1
  implements Runnable
{
  ReadInJoyPicWaterFallFragment$6$1(ReadInJoyPicWaterFallFragment.6 param6, boolean paramBoolean1, Map paramMap1, boolean paramBoolean2, Map paramMap2, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isChannelShow(this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$6.a.b())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$6.a(this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsFragmentReadInJoyPicWaterFallFragment$6.a(this.jdField_a_of_type_JavaUtilMap, this.jdField_b_of_type_Boolean, this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyPicWaterFallFragment.6.1
 * JD-Core Version:    0.7.0.1
 */