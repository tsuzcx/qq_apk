package com.tencent.mobileqq.nearby.profilecard.api.impl;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.api.INearbyCardManagerUtils;
import com.tencent.mobileqq.nearby.profilecard.IMiniCardManager;
import com.tencent.mobileqq.nearby.profilecard.MiniCardManager;
import com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils;
import com.tencent.mobileqq.nearby.profilecard.api.IMiniCardManagerUtils.onMiniCardRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class MiniCardManagerUtilsImpl
  implements IMiniCardManagerUtils
{
  private void doRequestMiniCardInfo(List<Long> paramList, int paramInt, List<RecentBaseData> paramList1, IMiniCardManager paramIMiniCardManager, IMiniCardManagerUtils.onMiniCardRsp paramonMiniCardRsp)
  {
    if (paramList == null) {
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new MiniCardManagerUtilsImpl.1(this, paramIMiniCardManager, paramList, paramInt, paramonMiniCardRsp, paramList1), 100L);
  }
  
  public boolean containsKey(String paramString)
  {
    return MiniCardManager.a(paramString);
  }
  
  public NowSummaryCard.MiniCard getMiniCard(String paramString)
  {
    return MiniCardManager.b(paramString);
  }
  
  public void handleMiniCardReq(List<RecentBaseData> paramList, IMiniCardManager paramIMiniCardManager, IMiniCardManagerUtils.onMiniCardRsp paramonMiniCardRsp)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      long l = Long.valueOf(((RecentBaseData)paramList.get(i)).getRecentUserUin()).longValue();
      if (l > 10000L) {
        if (((INearbyCardManagerUtils)QRoute.api(INearbyCardManagerUtils.class)).isTinyId(String.valueOf(l))) {
          localArrayList1.add(Long.valueOf(l));
        } else {
          localArrayList2.add(Long.valueOf(l));
        }
      }
      i += 1;
    }
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return;
    }
    IMiniCardManager localIMiniCardManager = paramIMiniCardManager;
    if (paramIMiniCardManager == null) {
      localIMiniCardManager = (IMiniCardManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.MINI_CARD_MANAGER);
    }
    doRequestMiniCardInfo(localArrayList1, 0, paramList, localIMiniCardManager, paramonMiniCardRsp);
    doRequestMiniCardInfo(localArrayList2, 1, paramList, localIMiniCardManager, paramonMiniCardRsp);
  }
  
  public void putMiniCard(String paramString, NowSummaryCard.MiniCard paramMiniCard)
  {
    MiniCardManager.a(paramString, paramMiniCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.api.impl.MiniCardManagerUtilsImpl
 * JD-Core Version:    0.7.0.1
 */