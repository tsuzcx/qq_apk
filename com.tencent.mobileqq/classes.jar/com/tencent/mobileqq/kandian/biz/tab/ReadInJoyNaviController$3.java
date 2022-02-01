package com.tencent.mobileqq.kandian.biz.tab;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

class ReadInJoyNaviController$3
  extends ReadInJoyObserver
{
  ReadInJoyNaviController$3(ReadInJoyNaviController paramReadInJoyNaviController) {}
  
  public void b(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if ((paramList != null) && (paramList.size() > 0)) {
        this.a.a(paramList);
      }
      Object localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (ChannelCoverInfo)((Iterator)localObject1).next();
        if ((!TextUtils.isEmpty(((ChannelCoverInfo)localObject2).mChannelJumpUrl)) && (((ChannelCoverInfo)localObject2).mChannelJumpUrl.indexOf("html/topic.html") != -1))
        {
          for (;;)
          {
            for (;;)
            {
              Object localObject3;
              int i;
              try
              {
                localObject2 = new URL(((ChannelCoverInfo)localObject2).mChannelJumpUrl);
                if (TextUtils.isEmpty(((URL)localObject2).getQuery())) {
                  break;
                }
                localObject3 = ((URL)localObject2).getQuery().split("[&]");
                int j = localObject3.length;
                i = 0;
                if (i >= j) {
                  break;
                }
                localObject2 = localObject3[i].split("[=]");
                if (localObject2.length > 1)
                {
                  boolean bool = "topicid".equals(localObject2[0]);
                  if (!bool) {}
                }
              }
              catch (MalformedURLException localMalformedURLException) {}
              try
              {
                Integer.valueOf(localObject2[1]).intValue();
                if (!QLog.isColorLevel()) {
                  break;
                }
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append("onMainChannelListUpdate preload topic and topicId = ");
                ((StringBuilder)localObject3).append(localObject2[1]);
                QLog.d("ReadInJoyNaviController", 2, ((StringBuilder)localObject3).toString());
              }
              catch (Exception localException) {}
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("ReadInJoyNaviController", 2, "onMainChannelListUpdate preload topic and topic is illegal");
            break;
            i += 1;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("onMainChannelListUpdate preload topic MalformedURLException ");
            ((StringBuilder)localObject3).append(localMalformedURLException);
            QLog.d("ReadInJoyNaviController", 2, ((StringBuilder)localObject3).toString());
          }
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onMainChannelListUpdate infos size");
        ((StringBuilder)localObject1).append(paramList.size());
        QLog.d("ReadInJoyNaviController", 2, ((StringBuilder)localObject1).toString());
      }
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("onMainChannelListUpdate");
      paramList.append(paramBoolean);
      QLog.d("ReadInJoyNaviController", 2, paramList.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyNaviController.3
 * JD-Core Version:    0.7.0.1
 */