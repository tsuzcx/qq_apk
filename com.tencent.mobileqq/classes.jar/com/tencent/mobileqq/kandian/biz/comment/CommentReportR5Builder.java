package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.comment.data.CommentViewItem;
import com.tencent.mobileqq.kandian.biz.comment.data.ReadInJoyCommentDataManager;
import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.SubCommentData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class CommentReportR5Builder
{
  private JSONObject a = new JSONObject();
  private AbsBaseArticleInfo b;
  private BaseCommentData c;
  private int d = 0;
  
  public CommentReportR5Builder(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    this.b = paramCommentViewItem.d;
    this.c = paramCommentViewItem.c;
    this.d = paramCommentViewItem.b;
  }
  
  public CommentReportR5Builder(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData)
  {
    this.b = paramAbsBaseArticleInfo;
    this.c = paramBaseCommentData;
  }
  
  private CommentReportR5Builder e(int paramInt)
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
  
  private int n()
  {
    if (this.c == null) {
      return 0;
    }
    if (ReadInJoyHelper.b(this.b)) {
      return 10;
    }
    return this.c.contentSrc;
  }
  
  private CommentReportR5Builder o()
  {
    if (this.d == 0)
    {
      ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.b);
      if (localReadInJoyCommentDataManager != null)
      {
        Object localObject = this.c;
        if ((localObject instanceof CommentData)) {
          localObject = ((BaseCommentData)localObject).commentId;
        } else if ((localObject instanceof SubCommentData)) {
          localObject = ((SubCommentData)localObject).parentCommentId;
        } else {
          localObject = "";
        }
        this.d = localReadInJoyCommentDataManager.h((String)localObject);
      }
    }
    try
    {
      this.a.put("area", this.d);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder a()
  {
    o();
    f();
    g();
    h();
    l();
    return this;
  }
  
  public CommentReportR5Builder a(int paramInt)
  {
    try
    {
      this.a.put("amount", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder a(String paramString)
  {
    try
    {
      this.a.put("comment_id", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder b(int paramInt)
  {
    try
    {
      this.a.put("actionsheet_choose", paramInt);
      JSONObject localJSONObject = this.a;
      if (this.c == null) {
        paramInt = 0;
      } else {
        paramInt = this.c.commentApp;
      }
      localJSONObject.put("comment_app", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder b(String paramString)
  {
    try
    {
      this.a.put("to_uin", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public String b()
  {
    try
    {
      if (this.b != null)
      {
        this.a.put("algorithm_id", this.b.mAlgorithmID);
        if (this.b.mArticleID != -1L) {
          this.a.put("mp_article_id", this.b.mArticleID);
        }
      }
      if (this.c != null) {
        if ((this.c instanceof CommentData)) {
          this.a.put("comment_id", this.c.commentId);
        } else if ((this.c instanceof SubCommentData)) {
          this.a.put("sub_comment_id", this.c.commentId);
        }
      }
      this.a.put("kandian_mode", RIJAppSetting.b());
      this.a.put("comment_platform", 3);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this.a.toString();
  }
  
  public CommentReportR5Builder c(int paramInt)
  {
    try
    {
      this.a.put("comment_number", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public JSONObject c()
  {
    return this.a;
  }
  
  public CommentReportR5Builder d()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      boolean bool = this.c.isAuthorReply();
      if (bool)
      {
        localStringBuilder.append(1);
        localStringBuilder.append(",");
      }
      if (this.c.isAuthorLike)
      {
        localStringBuilder.append(2);
        localStringBuilder.append(",");
      }
      if (this.c.isFollowing)
      {
        localStringBuilder.append(3);
        localStringBuilder.append(",");
      }
      if (this.c.isAuthorSticky) {
        localStringBuilder.append(6);
      }
      if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == ',')) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      if (this.a != null)
      {
        this.a.put("reply_tag_type", localStringBuilder.toString());
        return this;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentReportR5Builder", 2, localJSONException.getMessage());
    }
    return this;
  }
  
  public CommentReportR5Builder d(int paramInt)
  {
    try
    {
      this.a.put("change_into", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder e()
  {
    try
    {
      if ((this.c != null) && ((this.c instanceof SubCommentData)))
      {
        this.a.put("comment_id", ((SubCommentData)this.c).parentCommentId);
        this.a.put("sub_comment_id", this.c.commentId);
        return this;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder f()
  {
    int i = n();
    try
    {
      this.a.put("entry", i);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return e(i);
  }
  
  public CommentReportR5Builder g()
  {
    BaseCommentData localBaseCommentData = this.c;
    int i = 2;
    int j;
    if (localBaseCommentData != null) {
      j = localBaseCommentData.getCommentLevel();
    } else {
      j = 2;
    }
    if (j == 1) {
      i = 0;
    } else if (j == 2) {
      i = 1;
    }
    try
    {
      this.a.put("comment_level", i);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder h()
  {
    for (;;)
    {
      try
      {
        if (this.c != null)
        {
          if (this.c.isAuthorSelection())
          {
            i = 1;
          }
          else
          {
            if (!this.c.isAwesome()) {
              break label61;
            }
            i = 2;
          }
          if (i > 0)
          {
            this.a.put("comment_type", i);
            return this;
          }
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      return this;
      label61:
      int i = 3;
    }
  }
  
  public CommentReportR5Builder i()
  {
    try
    {
      this.a.put("fromuin", RIJQQAppInterfaceUtil.d());
      return this;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentReportR5Builder", 2, localJSONException.getMessage());
    }
    return this;
  }
  
  public CommentReportR5Builder j()
  {
    BaseCommentData localBaseCommentData = this.c;
    if (localBaseCommentData == null) {
      return this;
    }
    int i = 0;
    if (localBaseCommentData.isBanner()) {
      i = 1;
    } else if (this.c.isActivity()) {
      i = 2;
    } else if (this.c.isFamilyTopEntry()) {
      i = 3;
    }
    try
    {
      this.a.put("type", i);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder k()
  {
    Object localObject = this.c;
    if (localObject == null) {
      return this;
    }
    if (((BaseCommentData)localObject).isActivity()) {
      localObject = String.valueOf(this.c.activityCfgID);
    } else if (this.c.isBanner()) {
      localObject = this.c.commentId;
    } else {
      localObject = "";
    }
    try
    {
      this.a.put("h5_id", localObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder l()
  {
    Object localObject = this.c;
    if ((localObject != null) && (!TextUtils.isEmpty(((BaseCommentData)localObject).styleData))) {
      try
      {
        localObject = new JSONObject(this.c.styleData).optJSONObject("reportJson");
        if (localObject != null)
        {
          Iterator localIterator = ((JSONObject)localObject).keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = ((JSONObject)localObject).getString(str1);
            this.a.put(str1, str2);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addFamilyReportData r5 ");
          ((StringBuilder)localObject).append(this.a.toString());
          QLog.d("CommentReportR5Builder", 2, ((StringBuilder)localObject).toString());
          return this;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return this;
  }
  
  public CommentReportR5Builder m()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = this.a;
        if (this.c != null)
        {
          i = this.c.createSrc;
          localJSONObject.put("into_app", i);
          return this;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return this;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentReportR5Builder
 * JD-Core Version:    0.7.0.1
 */