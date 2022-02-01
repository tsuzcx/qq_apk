package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

class FastWebActivity$41
  implements Runnable
{
  FastWebActivity$41(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    if (this.this$0.g != null)
    {
      QLog.d("FastWebActivity", 1, "requestControllInfo requestInsertArticlesAndRecordAction in native page");
      RIJFeedsDynamicInsertController.INSTANCE.requestInsertArticlesAndRecordAction(this.this$0.g.innerUniqueID, new RIJFeedsInsertAction(ActionType.ACTION_NONE, 0, 0, 0), 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.41
 * JD-Core Version:    0.7.0.1
 */