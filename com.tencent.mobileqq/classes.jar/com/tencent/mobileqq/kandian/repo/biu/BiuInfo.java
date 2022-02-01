package com.tencent.mobileqq.kandian.repo.biu;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class BiuInfo
{
  public int a;
  public long a;
  public AbsBaseArticleInfo a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c = "";
  public String d = "";
  public String e;
  
  public BiuInfo()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = -1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = null;
    this.jdField_a_of_type_Int = -1;
    this.e = "";
    this.d = "";
    this.jdField_b_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BiuInfo{isFromRecommendFeeds=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", feedsID=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", biuComment='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", biuMediaUrl='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", articleInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    localStringBuilder.append(", contentSrc=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", commentBtnJumpUrl='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", commentShareUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardJumpUrl='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", isCardAvailable=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.BiuInfo
 * JD-Core Version:    0.7.0.1
 */