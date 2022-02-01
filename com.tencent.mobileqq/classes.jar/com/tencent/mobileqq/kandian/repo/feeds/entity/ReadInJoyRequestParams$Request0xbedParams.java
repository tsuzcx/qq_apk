package com.tencent.mobileqq.kandian.repo.feeds.entity;

import java.util.List;

public class ReadInJoyRequestParams$Request0xbedParams
{
  public int a;
  public long a;
  public ReadInJoyRequestParams.Request0xbedParams.InnerMsg a;
  public String a;
  public List<Long> a;
  public byte[] a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public int d;
  public long d;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("channelID:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" channelType:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(" upDateTimes：");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(" beginRecommendSeq：");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" endRecommendSeq：");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(" beginCollectionID:");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append(" endCollectionID:");
    localStringBuilder.append(this.d);
    localStringBuilder.append("   subscriptionArticleList:");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(" innerMsg:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityReadInJoyRequestParams$Request0xbedParams$InnerMsg);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0xbedParams
 * JD-Core Version:    0.7.0.1
 */