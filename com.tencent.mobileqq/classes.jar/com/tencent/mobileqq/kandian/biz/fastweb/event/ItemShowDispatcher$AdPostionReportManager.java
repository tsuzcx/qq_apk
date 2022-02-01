package com.tencent.mobileqq.kandian.biz.fastweb.event;

import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;

public class ItemShowDispatcher$AdPostionReportManager
{
  public float a;
  public int a;
  public long a;
  public BaseData a;
  public Long a;
  public long b;
  
  public ItemShowDispatcher$AdPostionReportManager(int paramInt, Long paramLong, BaseData paramBaseData)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangLong = paramLong;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = paramBaseData;
    this.b = 0L;
  }
  
  public void a(AdPostionReportManager paramAdPostionReportManager)
  {
    if (paramAdPostionReportManager != null)
    {
      this.jdField_a_of_type_JavaLangLong = paramAdPostionReportManager.jdField_a_of_type_JavaLangLong;
      this.jdField_a_of_type_Long = paramAdPostionReportManager.jdField_a_of_type_Long;
      this.jdField_a_of_type_Float = paramAdPostionReportManager.jdField_a_of_type_Float;
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData = paramAdPostionReportManager.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityBaseData;
      this.b = paramAdPostionReportManager.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher.AdPostionReportManager
 * JD-Core Version:    0.7.0.1
 */