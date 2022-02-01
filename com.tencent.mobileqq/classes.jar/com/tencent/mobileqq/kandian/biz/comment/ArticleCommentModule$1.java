package com.tencent.mobileqq.kandian.biz.comment;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;

final class ArticleCommentModule$1
  implements IReadInJoyUserInfoModule.RefreshUserInfoCallBack
{
  ArticleCommentModule$1(CommentInfo paramCommentInfo) {}
  
  public void onLoadUserInfoFailed(String paramString1, String paramString2) {}
  
  public void onLoadUserInfoSucceed(String paramString, ReadInJoyUserInfo paramReadInJoyUserInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equalsIgnoreCase(this.a.authorUin)))
    {
      if (paramReadInJoyUserInfo == null) {
        return;
      }
      this.a.authorNickName = paramReadInJoyUserInfo.nick;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.ArticleCommentModule.1
 * JD-Core Version:    0.7.0.1
 */