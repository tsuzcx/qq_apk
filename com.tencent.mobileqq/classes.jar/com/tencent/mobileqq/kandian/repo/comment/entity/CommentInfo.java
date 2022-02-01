package com.tencent.mobileqq.kandian.repo.comment.entity;

import com.tencent.mobileqq.kandian.repo.comment.constants.CommentInfoConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class CommentInfo
  extends CommentInfoConstants
  implements Serializable
{
  public boolean anonymous = false;
  public int area = 0;
  public transient AbsBaseArticleInfo articleInfo = null;
  public String authorAvatar = "";
  public String authorHomepage = "";
  public String authorNickName = "";
  public int authorSelection = 0;
  public String authorUin = "";
  public int awesome;
  public boolean commentByMyself = false;
  public String commentContent = "";
  public int commentCount = 0;
  public String commentId = "";
  public long commentTime = 0L;
  public int commentType = 0;
  public int disLikeCount = 0;
  public boolean disLiked = false;
  public boolean hasNextPage = true;
  public boolean hasTarget = false;
  public int level = 0;
  public int likeCount = 0;
  public boolean liked = false;
  public int page = 0;
  public int rank = -1;
  public String retMsg = "";
  public String toNickName = "";
  public String toUin = "";
  public String uuid = "";
  
  public void toLogString(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("CommentInfo  info: article id=");
      paramString = this.articleInfo;
      if (paramString != null) {
        paramString = Long.valueOf(paramString.mArticleID);
      } else {
        paramString = "null";
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(" uuid=");
      localStringBuilder.append(this.uuid);
      localStringBuilder.append(" commentid=");
      localStringBuilder.append(this.commentId);
      localStringBuilder.append(" commentcontent=");
      localStringBuilder.append(this.commentContent);
      localStringBuilder.append(" commentTime=");
      localStringBuilder.append(this.commentTime);
      localStringBuilder.append(" retMsg=");
      localStringBuilder.append(this.retMsg);
      localStringBuilder.append(" likecount=");
      localStringBuilder.append(this.likeCount);
      localStringBuilder.append(" liked=");
      localStringBuilder.append(this.liked);
      localStringBuilder.append(" anonymous=");
      localStringBuilder.append(this.anonymous);
      localStringBuilder.append(" level=");
      localStringBuilder.append(this.level);
      localStringBuilder.append(" commentByMyself");
      localStringBuilder.append(this.commentByMyself);
      localStringBuilder.append(" authorhome=");
      localStringBuilder.append(this.authorHomepage);
      localStringBuilder.append(" authoruin");
      localStringBuilder.append(this.authorUin);
      localStringBuilder.append(" authornickname");
      localStringBuilder.append(this.authorNickName);
      localStringBuilder.append(" authorAvater=");
      localStringBuilder.append(this.authorAvatar);
      localStringBuilder.append(" author_select=");
      localStringBuilder.append(this.authorSelection);
      localStringBuilder.append("  hastarget=");
      localStringBuilder.append(this.hasTarget);
      localStringBuilder.append("  toNick`name");
      localStringBuilder.append(this.toNickName);
      QLog.d("CommentInfo", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo
 * JD-Core Version:    0.7.0.1
 */