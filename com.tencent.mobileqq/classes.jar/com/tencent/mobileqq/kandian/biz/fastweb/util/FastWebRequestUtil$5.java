package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

final class FastWebRequestUtil$5
  implements Runnable
{
  FastWebRequestUtil$5(AbsBaseArticleInfo paramAbsBaseArticleInfo, FeedbackCallback paramFeedbackCallback) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = new Bundle();
      Object localObject1 = (QQAppInterface)ReadInJoyUtils.a();
      String str2 = RIJQQAppInterfaceUtil.a();
      String str3 = ((TicketManager)((QQAppInterface)localObject1).getManager(2)).getSkey(str2);
      ((Bundle)localObject2).putString("feeds_id", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId));
      ((Bundle)localObject2).putString("uin", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.publishUin));
      ((Bundle)localObject2).putString("feedsType", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType));
      String str1 = "";
      if (str3 == null) {
        localObject1 = "";
      } else {
        localObject1 = ReadInJoyWebDataManager.a(str3);
      }
      ((Bundle)localObject2).putString("g_tk", (String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("FastWebRequestUtil", 2, new Object[] { "params feeds_id = ", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedId), ", uin = ", Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.publishUin), ", feedsType = ", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mFeedType) });
      }
      localObject1 = new Bundle();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("uin=o");
      localStringBuilder.append(str2);
      localStringBuilder.append(";skey=");
      localStringBuilder.append(str3);
      ((Bundle)localObject1).putString("cookie", localStringBuilder.toString());
      localObject2 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://kandian.qq.com/qz_kandian_social/kandian_ext/deleteFeeds", "GET", (Bundle)localObject2, (Bundle)localObject1);
      localObject1 = str1;
      if (localObject2 != null) {
        localObject1 = new String((byte[])localObject2);
      }
      QLog.d("FastWebRequestUtil", 1, new Object[] { "deleteFeeds result = ", localObject1 });
      localObject1 = new JSONObject((String)localObject1).getJSONObject("result");
      int i = ((JSONObject)localObject1).getInt("retCode");
      localObject1 = ((JSONObject)localObject1).getString("retMsg");
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback != null)
      {
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.5.1(this, i, (String)localObject1));
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqKandianRepoFastwebFeedbackCallback != null) {
        ThreadManager.getUIHandler().post(new FastWebRequestUtil.5.2(this, localThrowable));
      }
      QLog.d("FastWebRequestUtil", 2, "deleteFeeds exception. ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.5
 * JD-Core Version:    0.7.0.1
 */