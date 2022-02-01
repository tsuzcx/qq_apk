package com.tencent.mobileqq.kandian.repo.account;

import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class RIJUserInfoUtil$requestUserInfo$runnable$1
  implements Runnable
{
  RIJUserInfoUtil$requestUserInfo$runnable$1(int paramInt, List paramList) {}
  
  public final void run()
  {
    if (!RIJUserInfoUtil.a(RIJUserInfoUtil.a))
    {
      QLog.i("RIJUserInfoUtil", 1, "[requestUserInfo] switch is off.");
      return;
    }
    if (this.a != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[requestUserInfo] channelId is not recommend, channelId = ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.i("RIJUserInfoUtil", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    Object localObject1 = this.b;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      localObject1 = new ArrayList();
      Object localObject2 = new ArrayList((Collection)this.b).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AbsBaseArticleInfo)((Iterator)localObject2).next();
        if (!RIJItemViewTypeUtils.e((AbsBaseArticleInfo)localObject3))
        {
          RIJUserInfoUtil.a(RIJUserInfoUtil.a, (ArrayList)localObject1, ((AbsBaseArticleInfo)localObject3).mSubscribeID);
          Object localObject4 = ((AbsBaseArticleInfo)localObject3).mSubArticleList;
          if ((localObject4 != null) && ((((Collection)localObject4).isEmpty() ^ true) == true))
          {
            localObject3 = ((AbsBaseArticleInfo)localObject3).mSubArticleList.iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (AbsBaseArticleInfo)((Iterator)localObject3).next();
              RIJUserInfoUtil.a(RIJUserInfoUtil.a, (ArrayList)localObject1, ((AbsBaseArticleInfo)localObject4).mSubscribeID);
            }
          }
        }
      }
      if ((((Collection)localObject1).isEmpty() ^ true))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[requestUserInfo] uinList: ");
        localObject3 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          ((StringBuilder)localObject2).append((String)((Iterator)localObject3).next());
          ((StringBuilder)localObject2).append(", ");
        }
        QLog.i("RIJUserInfoUtil", 1, ((StringBuilder)localObject2).toString());
        ReadInJoyUserInfoModule.b((List)localObject1);
      }
      return;
    }
    QLog.i("RIJUserInfoUtil", 1, "[requestUserInfo] articleInfoList is empty.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.account.RIJUserInfoUtil.requestUserInfo.runnable.1
 * JD-Core Version:    0.7.0.1
 */