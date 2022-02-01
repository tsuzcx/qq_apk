package com.tencent.mobileqq.kandian.repo.video.entity;

import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

public class SubVideoInfo
{
  public int a;
  public long a;
  public UrlJumpInfo a;
  public String a;
  public int b;
  public String b;
  public String c;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\n");
    localStringBuilder.append("rowKey=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("title=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\n");
    localStringBuilder.append("picUrl=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("\n");
    localStringBuilder.append("jumpUrl=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo);
    localStringBuilder.append("\n");
    localStringBuilder.append("playCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\n");
    localStringBuilder.append("duration=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.entity.SubVideoInfo
 * JD-Core Version:    0.7.0.1
 */