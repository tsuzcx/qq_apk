package com.tencent.mobileqq.kandian.biz.comment.rptdata.topic;

import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import java.util.Map;

class RIJCommentTopicUi$1
  implements IUserLevelCallBack
{
  RIJCommentTopicUi$1(RIJCommentTopicUi paramRIJCommentTopicUi) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo != null) {
      RIJCommentTopicUi.a((String)paramUserLevelInfo.operFobidWording.get(Integer.valueOf(11)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.rptdata.topic.RIJCommentTopicUi.1
 * JD-Core Version:    0.7.0.1
 */