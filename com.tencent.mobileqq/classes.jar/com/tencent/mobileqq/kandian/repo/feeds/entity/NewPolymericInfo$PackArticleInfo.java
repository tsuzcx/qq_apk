package com.tencent.mobileqq.kandian.repo.feeds.entity;

import com.tencent.qphone.base.util.QLog;

public class NewPolymericInfo$PackArticleInfo
  implements Cloneable
{
  public int a;
  public long a;
  public NewPolymericInfo.PackQuestionAnswerExtraInfo a;
  public NewPolymericInfo.PackTopicExtraInfo a;
  public NewPolymericInfo.PackVideoInfo a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public Object clone()
  {
    PackArticleInfo localPackArticleInfo1;
    try
    {
      localPackArticleInfo1 = (PackArticleInfo)super.clone();
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo != null) {
          localPackArticleInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo = ((NewPolymericInfo.PackVideoInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo.clone());
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo != null) {
          localPackArticleInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo = ((NewPolymericInfo.PackTopicExtraInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackTopicExtraInfo.clone());
        }
        PackArticleInfo localPackArticleInfo2 = localPackArticleInfo1;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo == null) {
          return ???;
        }
        localPackArticleInfo1.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo = ((NewPolymericInfo.PackQuestionAnswerExtraInfo)this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackQuestionAnswerExtraInfo.clone());
        return localPackArticleInfo1;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException1) {}
      localStringBuilder = new StringBuilder();
    }
    catch (CloneNotSupportedException localCloneNotSupportedException2)
    {
      localPackArticleInfo1 = null;
    }
    StringBuilder localStringBuilder;
    localStringBuilder.append("PackArticleInfo item clone failed. exception = ");
    localStringBuilder.append(localCloneNotSupportedException2);
    QLog.e("NewPolymericInfo", 2, localStringBuilder.toString());
    PackArticleInfo localPackArticleInfo3 = localPackArticleInfo1;
    return localPackArticleInfo3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PackArticleInfo = {\ncellStyleID = ");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\narticleID = ");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("\narticleTitle = ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append("\narticleSummary = ");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append("\nfirstPagePicUrl = ");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append("\narticleContentUrl = ");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append("\nsubscribeID = ");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append("\nsubscribeName = ");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append("\nstrategyID = ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("\nalgorithmID = ");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append("\nfeedsID = ");
    localStringBuilder.append(this.jdField_c_of_type_Long);
    localStringBuilder.append("\nfeedsType = ");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append("\ninnerUniqID = ");
    localStringBuilder.append(this.jdField_g_of_type_JavaLangString);
    localStringBuilder.append("\nisGallery = ");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append("\ngalleryPicNum = ");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append("\nvideoInfo = ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityNewPolymericInfo$PackVideoInfo);
    localStringBuilder.append("\nbuttonWording = ");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\nisUgc = ");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append("\nplayCount=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append("commentCount=");
    localStringBuilder.append(this.jdField_g_of_type_Int);
    localStringBuilder.append("isGifCoverUrl = ");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo
 * JD-Core Version:    0.7.0.1
 */