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
  private int jdField_a_of_type_Int = 0;
  private BaseCommentData jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  public CommentReportR5Builder(CommentViewItem paramCommentViewItem)
  {
    if (paramCommentViewItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData = paramCommentViewItem.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    this.jdField_a_of_type_Int = paramCommentViewItem.b;
  }
  
  public CommentReportR5Builder(AbsBaseArticleInfo paramAbsBaseArticleInfo, BaseCommentData paramBaseCommentData)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData = paramBaseCommentData;
  }
  
  private int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
      return 0;
    }
    if (ReadInJoyHelper.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo)) {
      return 10;
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.contentSrc;
  }
  
  private CommentReportR5Builder e(int paramInt)
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
  
  private CommentReportR5Builder l()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      ReadInJoyCommentDataManager localReadInJoyCommentDataManager = ReadInJoyCommentDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      if (localReadInJoyCommentDataManager != null)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
        if ((localObject instanceof CommentData)) {
          localObject = ((BaseCommentData)localObject).commentId;
        } else if ((localObject instanceof SubCommentData)) {
          localObject = ((SubCommentData)localObject).parentCommentId;
        } else {
          localObject = "";
        }
        this.jdField_a_of_type_Int = localReadInJoyCommentDataManager.a((String)localObject);
      }
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("area", this.jdField_a_of_type_Int);
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
    l();
    d();
    e();
    f();
    j();
    return this;
  }
  
  public CommentReportR5Builder a(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("amount", paramInt);
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
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public String a()
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo != null)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mAlgorithmID);
        if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID != -1L) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("mp_article_id", this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof CommentData)) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId);
        } else if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof SubCommentData)) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("sub_comment_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId);
        }
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", RIJAppSetting.a());
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_platform", 3);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this.jdField_a_of_type_OrgJsonJSONObject.toString();
  }
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public CommentReportR5Builder b()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorReply();
      if (bool)
      {
        localStringBuilder.append(1);
        localStringBuilder.append(",");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorLike)
      {
        localStringBuilder.append(2);
        localStringBuilder.append(",");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isFollowing)
      {
        localStringBuilder.append(3);
        localStringBuilder.append(",");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorSticky) {
        localStringBuilder.append(6);
      }
      if ((localStringBuilder.length() > 0) && (localStringBuilder.charAt(localStringBuilder.length() - 1) == ',')) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      if (this.jdField_a_of_type_OrgJsonJSONObject != null)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("reply_tag_type", localStringBuilder.toString());
        return this;
      }
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentReportR5Builder", 2, localJSONException.getMessage());
    }
    return this;
  }
  
  public CommentReportR5Builder b(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("actionsheet_choose", paramInt);
      JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData == null) {
        paramInt = 0;
      } else {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentApp;
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
      this.jdField_a_of_type_OrgJsonJSONObject.put("to_uin", paramString);
      return this;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder c()
  {
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData instanceof SubCommentData)))
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("comment_id", ((SubCommentData)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData).parentCommentId);
        this.jdField_a_of_type_OrgJsonJSONObject.put("sub_comment_id", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId);
        return this;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder c(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_number", paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder d()
  {
    int i = a();
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("entry", i);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return e(i);
  }
  
  public CommentReportR5Builder d(int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("change_into", paramInt);
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
    BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
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
      this.jdField_a_of_type_OrgJsonJSONObject.put("comment_level", i);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder f()
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAuthorSelection())
          {
            i = 1;
          }
          else
          {
            if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isAwesome()) {
              break label61;
            }
            i = 2;
          }
          if (i > 0)
          {
            this.jdField_a_of_type_OrgJsonJSONObject.put("comment_type", i);
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
  
  public CommentReportR5Builder g()
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("fromuin", RIJQQAppInterfaceUtil.a());
      return this;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("CommentReportR5Builder", 2, localJSONException.getMessage());
    }
    return this;
  }
  
  public CommentReportR5Builder h()
  {
    BaseCommentData localBaseCommentData = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (localBaseCommentData == null) {
      return this;
    }
    int i = 0;
    if (localBaseCommentData.isBanner()) {
      i = 1;
    } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isActivity()) {
      i = 2;
    } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isFamilyTopEntry()) {
      i = 3;
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("type", i);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if (localObject == null) {
      return this;
    }
    if (((BaseCommentData)localObject).isActivity()) {
      localObject = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.activityCfgID);
    } else if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.isBanner()) {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentId;
    } else {
      localObject = "";
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("h5_id", localObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return this;
  }
  
  public CommentReportR5Builder j()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData;
    if ((localObject != null) && (!TextUtils.isEmpty(((BaseCommentData)localObject).styleData))) {
      try
      {
        localObject = new JSONObject(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.styleData).optJSONObject("reportJson");
        if (localObject != null)
        {
          Iterator localIterator = ((JSONObject)localObject).keys();
          while (localIterator.hasNext())
          {
            String str1 = (String)localIterator.next();
            String str2 = ((JSONObject)localObject).getString(str1);
            this.jdField_a_of_type_OrgJsonJSONObject.put(str1, str2);
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addFamilyReportData r5 ");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
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
  
  public CommentReportR5Builder k()
  {
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData != null)
        {
          i = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.createSrc;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.CommentReportR5Builder
 * JD-Core Version:    0.7.0.1
 */