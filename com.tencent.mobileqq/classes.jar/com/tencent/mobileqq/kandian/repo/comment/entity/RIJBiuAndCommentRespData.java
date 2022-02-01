package com.tencent.mobileqq.kandian.repo.comment.entity;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.math.BigInteger;

public class RIJBiuAndCommentRespData
{
  private int jdField_a_of_type_Int;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private int jdField_f_of_type_Int;
  private String jdField_f_of_type_JavaLangString;
  private String g;
  private String h;
  private String i;
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      return new BigInteger(this.jdField_b_of_type_JavaLangString).longValue();
    }
    return 0L;
  }
  
  public AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_f_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void c(String paramString)
  {
    this.jdField_f_of_type_JavaLangString = paramString;
  }
  
  public int d()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String d()
  {
    return this.g;
  }
  
  public void d(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
  }
  
  public void d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public int e()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public void e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void e(String paramString)
  {
    this.g = paramString;
  }
  
  public String f()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void f(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void f(String paramString)
  {
    this.h = paramString;
  }
  
  public String g()
  {
    return this.jdField_e_of_type_JavaLangString;
  }
  
  public void g(String paramString)
  {
    this.i = paramString;
  }
  
  public void h(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void i(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RIJBiuAndCommentRespData{mResultCode=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mCommentId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedsId='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mFeedsType=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", mCommentString='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentShareUrl='");
    localStringBuilder.append(this.jdField_f_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCardAvailable=");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", mCardJumpUrl='");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mCommentBtnUrl='");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mArticleInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
    localStringBuilder.append(", mContentSrc=");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(", mCommentType=");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(", mListShowType=");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(", mIsSecondReply=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mReplyCommentId='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mReplyUin='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData
 * JD-Core Version:    0.7.0.1
 */