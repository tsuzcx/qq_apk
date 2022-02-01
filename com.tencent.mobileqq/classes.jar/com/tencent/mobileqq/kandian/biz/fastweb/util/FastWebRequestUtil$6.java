package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.os.Bundle;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.fastweb.FeedbackCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

final class FastWebRequestUtil$6
  implements Runnable
{
  FastWebRequestUtil$6(AbsBaseArticleInfo paramAbsBaseArticleInfo, FeedbackCallback paramFeedbackCallback) {}
  
  public void run()
  {
    String str2 = "1";
    for (;;)
    {
      try
      {
        Object localObject2 = RIJQQAppInterfaceUtil.d();
        String str3 = ((TicketManager)((QQAppInterface)ReadInJoyUtils.b()).getManager(2)).getSkey((String)localObject2);
        Bundle localBundle = new Bundle();
        localBundle.putString("type", "1");
        localBundle.putString("uin", String.valueOf(this.a.publishUin));
        Object localObject1 = str2;
        if (!RIJItemViewTypeUtils.e(this.a))
        {
          if (!RIJItemViewTypeUtils.m(this.a)) {
            break label388;
          }
          localObject1 = str2;
        }
        localBundle.putString("accountType", (String)localObject1);
        str2 = "";
        if (str3 == null) {
          localObject1 = "";
        } else {
          localObject1 = ReadInJoyWebDataManager.a(str3);
        }
        localBundle.putString("g_tk", (String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.d("FastWebRequestUtil", 2, new Object[] { "shieldFeedSource, params type = ", localBundle.getString("type"), ", uin = ", localBundle.getString("uin"), ", accountType = ", localBundle.getString("accountType") });
        }
        localObject1 = new Bundle();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("uin=o");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(";skey=");
        localStringBuilder.append(str3);
        ((Bundle)localObject1).putString("cookie", localStringBuilder.toString());
        localObject2 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), "https://kandian.qq.com/cgi-bin/social/setNotCare", "GET", localBundle, (Bundle)localObject1);
        localObject1 = str2;
        if (localObject2 != null) {
          localObject1 = new String((byte[])localObject2);
        }
        QLog.d("FastWebRequestUtil", 1, new Object[] { "shieldFeeds result = ", localObject1 });
        localObject1 = new JSONObject((String)localObject1).getJSONObject("result");
        int i = ((JSONObject)localObject1).getInt("retCode");
        localObject1 = ((JSONObject)localObject1).getString("retMsg");
        if (this.b != null)
        {
          ThreadManager.getUIHandler().post(new FastWebRequestUtil.6.1(this, i, (String)localObject1));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (this.b != null) {
          ThreadManager.getUIHandler().post(new FastWebRequestUtil.6.2(this, localThrowable));
        }
        QLog.d("FastWebRequestUtil", 2, "shieldFeedSource exception. ", localThrowable);
      }
      return;
      label388:
      String str1 = "2";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebRequestUtil.6
 * JD-Core Version:    0.7.0.1
 */