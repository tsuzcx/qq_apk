package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyCommentUtils$CommentReportR5Builder
{
  private JSONObject a = new JSONObject();
  private AbsBaseArticleInfo b;
  private CommentInfo c;
  
  public ReadInJoyCommentUtils$CommentReportR5Builder(AbsBaseArticleInfo paramAbsBaseArticleInfo, CommentInfo paramCommentInfo)
  {
    this.b = paramAbsBaseArticleInfo;
    this.c = paramCommentInfo;
  }
  
  private CommentReportR5Builder c(int paramInt)
  {
    int j = 1;
    int i = 1;
    if (paramInt == 1) {}
    try
    {
      this.a.put("puin_type", 1);
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
    if ((paramInt == 2) && (this.b != null))
    {
      localJSONObject = this.a;
      if (this.b.mAccountLess == 0)
      {
        paramInt = i;
        localJSONObject.put("puin_type", paramInt);
        return this;
      }
    }
    else
    {
      if ((paramInt == 3) && (this.b != null))
      {
        localJSONObject = this.a;
        if (this.b.mAccountLess != 0) {
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
      this.a.put("entry", paramInt);
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
      if (this.b != null)
      {
        this.a.put("algorithm_id", this.b.mAlgorithmID);
        this.a.put("mp_article_id", this.b.mArticleID);
      }
      if (this.c != null) {
        if (this.c.level == 1) {
          this.a.put("comment_id", this.c.commentId);
        } else if (this.c.level == 2) {
          this.a.put("sub_comment_id", this.c.commentId);
        }
      }
      this.a.put("source", RIJTransMergeKanDianReport.b());
      this.a.put("kandian_mode", RIJAppSetting.b());
      this.a.put("comment_platform", 3);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this.a.toString();
  }
  
  public CommentReportR5Builder b(int paramInt)
  {
    try
    {
      this.a.put("comment_icon_choose", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils.CommentReportR5Builder
 * JD-Core Version:    0.7.0.1
 */