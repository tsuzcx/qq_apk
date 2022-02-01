package com.tencent.mobileqq.kandian.biz.comment;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ArticleCommentModule
  extends CommentInfo
{
  public boolean canComment = false;
  public int facecount = 0;
  private List<CommentInfo> mCommentItemLists = new ArrayList();
  
  public ArticleCommentModule(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    this.articleInfo = paramAbsBaseArticleInfo;
    this.commentId = paramString1;
    this.commentType = paramInt;
    this.uuid = paramString2;
  }
  
  public static CommentInfo buildFeedsOutsideComment(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    Object localObject = "";
    try
    {
      paramString = new JSONObject(paramString).getString("comment");
      localObject = paramString;
      paramString = new String(Base64Util.decode(paramString, 0));
    }
    catch (JSONException paramString)
    {
      label66:
      break label66;
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("buildFeedsOutsideComment commentVal ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ArticleCommentModule", 2, ((StringBuilder)localObject).toString());
    }
    catch (JSONException localJSONException)
    {
      break label68;
    }
    paramString = (String)localObject;
    label68:
    localObject = new CommentInfo();
    ((CommentInfo)localObject).articleInfo = paramAbsBaseArticleInfo;
    ((CommentInfo)localObject).commentTime = (System.currentTimeMillis() / 1000L);
    ((CommentInfo)localObject).liked = false;
    ((CommentInfo)localObject).disLiked = false;
    ((CommentInfo)localObject).commentContent = paramString;
    ((CommentInfo)localObject).commentByMyself = true;
    ((CommentInfo)localObject).rank = 1;
    paramAbsBaseArticleInfo = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramAbsBaseArticleInfo instanceof QQAppInterface))
    {
      ((CommentInfo)localObject).authorUin = ((QQAppInterface)paramAbsBaseArticleInfo).getCurrentAccountUin();
      ((CommentInfo)localObject).commentByMyself = true;
    }
    paramAbsBaseArticleInfo = ReadInJoyUserInfoModule.a(Long.parseLong(((CommentInfo)localObject).authorUin), new ArticleCommentModule.1((CommentInfo)localObject));
    if (paramAbsBaseArticleInfo != null) {
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.nick;
    } else {
      paramAbsBaseArticleInfo = ReadInJoyUserInfoModule.d();
    }
    ((CommentInfo)localObject).authorNickName = paramAbsBaseArticleInfo;
    return localObject;
  }
  
  public List<CommentInfo> getCommentList()
  {
    return this.mCommentItemLists;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ArticleCommentModule
 * JD-Core Version:    0.7.0.1
 */