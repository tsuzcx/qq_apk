package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentUtils$CommentReportR5Builder
{
  private CommentInfo jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  public ReadInJoyCommentUtils$CommentReportR5Builder(AbsBaseArticleInfo paramAbsBaseArticleInfo, CommentInfo paramCommentInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo = paramCommentInfo;
  }
  
  private CommentReportR5Builder c(int paramInt)
  {
    int j = 1;
    int i = 1;
    if (paramInt == 1) {}
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("puin_type", 1);
      return this;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        continue;
        paramInt = 2;
        continue;
        paramInt = 2;
      }
    }
    if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
    {
      localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAccountLess == 0)
      {
        paramInt = i;
        localJSONObject.put("puin_type", paramInt);
        return this;
      }
    }
    else
    {
      if ((paramInt == 3) && (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null))
      {
        localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAccountLess != 0) {
          break label127;
        }
        paramInt = j;
        localJSONObject.put("puin_type", paramInt);
        return this;
        localJSONObject.printStackTrace();
      }
      return this;
    }
  }
  
  public CommentReportR5Builder a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("entry", paramInt);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return c(paramInt);
  }
  
  public String a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
        this.jdField_a_of_type_OrgJsonJSONObject.put("mp_article_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo != null) {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo.level == 1) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo.commentId);
        } else if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo.level == 2) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("sub_comment_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommentEntityCommentInfo.commentId);
        }
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("source", RIJTransMergeKanDianReport.a());
      this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", RIJAppSetting.a());
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_platform", 3);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this.jdField_a_of_type_OrgJsonJSONObject.toString();
  }
  
  public CommentReportR5Builder b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_icon_choose", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentReportR5Builder
 * JD-Core Version:    0.7.0.1
 */