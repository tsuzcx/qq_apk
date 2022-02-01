package com.tencent.mobileqq.kandian.repo.handler;

import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.RspBody;

class RIJCommentInLikeFeedUpvoteArticleHandler$1
  implements ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob
{
  RIJCommentInLikeFeedUpvoteArticleHandler$1(RIJCommentInLikeFeedUpvoteArticleHandler paramRIJCommentInLikeFeedUpvoteArticleHandler, int paramInt1, int paramInt2, oidb_cmd0x83e.RspBody paramRspBody) {}
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    int i = this.jdField_a_of_type_Int;
    int j = this.b;
    boolean bool;
    if (RIJPBFieldUtils.a(this.jdField_a_of_type_TencentImOidbCmd0x83eOidb_cmd0x83e$RspBody.uint32_operation) == 2) {
      bool = true;
    } else {
      bool = false;
    }
    paramReadInJoyObserver.a(i, j, Boolean.valueOf(bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJCommentInLikeFeedUpvoteArticleHandler.1
 * JD-Core Version:    0.7.0.1
 */