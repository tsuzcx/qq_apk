package com.tencent.mobileqq.kandian.biz.fastweb.util;

import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.detail.web.RecommendAndAdCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class FastWebRequestUtil$RecommendAndAd
{
  private int jdField_a_of_type_Int;
  private RecommendAndAdCallback jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebRecommendAndAdCallback;
  private final String jdField_a_of_type_JavaLangString;
  private List<BaseData> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private List<BaseData> b = new ArrayList();
  
  public FastWebRequestUtil$RecommendAndAd(String paramString, RecommendAndAdCallback paramRecommendAndAdCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebRecommendAndAdCallback = paramRecommendAndAdCallback;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  private void a()
  {
    try
    {
      if ((this.b != null) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebRecommendAndAdCallback != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizDetailWebRecommendAndAdCallback.a(true, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(List<BaseData> paramList)
  {
    this.b = paramList;
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData adDatas callback");
    a();
  }
  
  public void a(List<BaseData> paramList, boolean paramBoolean, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt;
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("REPORT_LINK", "requestAdData recommendDatas callback");
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.RecommendAndAd
 * JD-Core Version:    0.7.0.1
 */