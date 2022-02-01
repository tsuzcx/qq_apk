package com.tencent.mobileqq.kandian.repo.report;

import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;

public abstract class BaseReportData
{
  public int a;
  public long a;
  public AbsBaseArticleInfo a;
  public TabChannelCoverInfo a;
  public ReportInfo.DynamicInsertReportData a;
  public Long a;
  public String a;
  public boolean a;
  public byte[] a;
  public int b;
  public long b;
  public AbsBaseArticleInfo b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public boolean e;
  public int f;
  public String f;
  public boolean f;
  public int g;
  public int h = 0;
  public int i = 0;
  public int j = 0;
  public int k = 0;
  public int l;
  public int m;
  
  public BaseReportData()
  {
    this.jdField_f_of_type_Boolean = false;
    this.jdField_b_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BaseReportData{mIsReported=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mReportID=");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    localStringBuilder.append(", mStrategyId=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mAlgorithmID=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mArticleType=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", mFeedsSource='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mVideoVid='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedsChannelEntrance=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", mFeedsFriendsInteraction=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", mStrCircleId='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mPuin='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mInnerUniqueID='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mKandianTabSource=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", mKandianMode=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", mVideoRecommendStrategyID=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", mVideoIsDynamicRecommend=");
    localStringBuilder.append(this.jdField_f_of_type_Boolean);
    localStringBuilder.append(", adsSource=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", adsJump=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", mExposeTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", mPosition=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", entryPath=");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", dailyCookie='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", dynamicInsertReportData=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoReportReportInfo$DynamicInsertReportData);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.report.BaseReportData
 * JD-Core Version:    0.7.0.1
 */