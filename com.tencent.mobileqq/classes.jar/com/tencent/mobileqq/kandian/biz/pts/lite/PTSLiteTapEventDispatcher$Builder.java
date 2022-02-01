package com.tencent.mobileqq.kandian.biz.pts.lite;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.HashMap;

public class PTSLiteTapEventDispatcher$Builder
{
  private ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  private HashMap<String, Integer> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, AbsBaseArticleInfo> b;
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(HashMap<String, Integer> paramHashMap)
  {
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    return this;
  }
  
  public PTSLiteTapEventDispatcher a()
  {
    PTSLiteTapEventDispatcher localPTSLiteTapEventDispatcher = new PTSLiteTapEventDispatcher(null);
    PTSLiteTapEventDispatcher.a(localPTSLiteTapEventDispatcher, this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter);
    PTSLiteTapEventDispatcher.a(localPTSLiteTapEventDispatcher, this.jdField_a_of_type_JavaUtilHashMap);
    PTSLiteTapEventDispatcher.b(localPTSLiteTapEventDispatcher, this.b);
    return localPTSLiteTapEventDispatcher;
  }
  
  public Builder b(HashMap<String, AbsBaseArticleInfo> paramHashMap)
  {
    this.b = paramHashMap;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteTapEventDispatcher.Builder
 * JD-Core Version:    0.7.0.1
 */