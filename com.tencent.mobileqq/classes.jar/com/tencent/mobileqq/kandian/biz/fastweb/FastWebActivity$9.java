package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.LiveStatusCallback;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule.UserInfoItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.LiveStatus;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class FastWebActivity$9
  implements RIJLiveStatusModule.LiveStatusCallback
{
  FastWebActivity$9(FastWebActivity paramFastWebActivity) {}
  
  public void a(int paramInt, List<RIJLiveStatusModule.UserInfoItem> paramList)
  {
    QLog.d("FastWebActivity", 1, "live Status Callback");
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RIJLiveStatusModule.UserInfoItem localUserInfoItem = (RIJLiveStatusModule.UserInfoItem)paramList.next();
      if ((localUserInfoItem.a == FastWebActivity.d(this.a).y) && (localUserInfoItem.b.a == 1))
      {
        QLog.d("FastWebActivity", 1, "need to show live status");
        FastWebActivity.j(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.9
 * JD-Core Version:    0.7.0.1
 */