package com.tencent.mobileqq.kandian.biz.feeds;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyFixPosArticleManager;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadinjoyFixPosArticleManager
  implements IReadInJoyFixPosArticleManager
{
  public static final int BUSI_TYPE_AD = 1;
  public static final long MASK_32 = -1L;
  public static final int SCENES_TYPE_ASYNCDATA_READY = 3;
  public static final int SCENES_TYPE_DATA_LOAD = 1;
  public static final int SCENES_TYPE_LOAD_MORE = 2;
  public static final String TAG = "ReadinjoyFixPosArticleManager";
  private static volatile ReadinjoyFixPosArticleManager instant;
  private ReadinjoyFixPosArticleManager.ADArticleController adArticleController = new ReadinjoyFixPosArticleManager.ADArticleController(this, 1);
  private HashMap<Integer, WeakReference<ReadInJoyBaseAdapter>> adapterHashMap = new HashMap();
  
  private int findBestPosition(int paramInt1, List<AbsBaseArticleInfo> paramList, int paramInt2)
  {
    paramInt1 = 0;
    while (paramInt1 < paramList.size())
    {
      if (paramInt2 == 0)
      {
        paramList = (AbsBaseArticleInfo)paramList.get(paramInt1);
        paramInt2 = paramInt1;
        if (paramList != null)
        {
          paramInt2 = paramInt1;
          if (paramList.mGroupId != -1L)
          {
            paramInt2 = paramInt1;
            if (paramList.mGroupCount != 1L)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("position ");
              localStringBuilder.append(paramInt1);
              localStringBuilder.append(" is group article , groupCount : ");
              localStringBuilder.append(paramList.mGroupCount);
              localStringBuilder.append(", nowGroupIndex : ");
              localStringBuilder.append(paramList.mFeedIndexInGroup);
              localStringBuilder.append(", groupID : ");
              localStringBuilder.append(paramList.mGroupId);
              QLog.d("ReadinjoyFixPosArticleManager", 2, localStringBuilder.toString());
              paramInt2 = paramInt1 + (int)(paramList.mGroupCount - paramList.mFeedIndexInGroup);
            }
          }
        }
        return paramInt2;
      }
      paramInt2 -= 1;
      paramInt1 += 1;
    }
    return -1;
  }
  
  private static long getFakeSpecialArticleSeq(int paramInt1, int paramInt2)
  {
    long l = paramInt1;
    return -(paramInt2 | l << 32);
  }
  
  private static int getFixPosArticleBusiType(long paramLong)
  {
    return (int)(-paramLong >> 32 & 0xFFFFFFFF);
  }
  
  private static int getFixPosArticlePosition(long paramLong)
  {
    return (int)(-paramLong & 0xFFFFFFFF);
  }
  
  public static ReadinjoyFixPosArticleManager getInstant()
  {
    if (instant == null) {
      try
      {
        if (instant == null) {
          instant = new ReadinjoyFixPosArticleManager();
        }
      }
      finally {}
    }
    return instant;
  }
  
  public static boolean isFixPosArticleSeq(long paramLong)
  {
    return paramLong <= 0L;
  }
  
  public static boolean isNotSameData(List<AbsBaseArticleInfo> paramList1, List<AbsBaseArticleInfo> paramList2)
  {
    if (paramList1 == null) {
      return false;
    }
    if (paramList2 == null) {
      return true;
    }
    if (paramList1.size() != paramList2.size()) {
      return true;
    }
    int i = 0;
    while (i < paramList1.size())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)paramList1.get(i);
      AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)paramList2.get(i);
      if (localAbsBaseArticleInfo1.mArticleID != localAbsBaseArticleInfo2.mArticleID) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void onAsyncDataReady(int paramInt)
  {
    Object localObject = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on async data refresh , channelID  : ");
    localStringBuilder.append(paramInt);
    ((IRIJAdLogService)localObject).d("AdDataLink", localStringBuilder.toString());
    localObject = (WeakReference)this.adapterHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null) {
      return;
    }
    localObject = (ReadInJoyBaseAdapter)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (((ReadInJoyBaseAdapter)localObject).isEmpty()) {
        return;
      }
      ThreadManager.getUIHandler().post(new ReadinjoyFixPosArticleManager.1(this, (ReadInJoyBaseAdapter)localObject, paramInt));
    }
  }
  
  public void deleteFixPosArticle(int paramInt, long paramLong)
  {
    if (!isFixPosArticleSeq(paramLong)) {
      return;
    }
    int i = getFixPosArticlePosition(paramLong);
    this.adArticleController.b(paramInt, i);
  }
  
  public ReadInJoyBaseAdapter getBaseAdapter(int paramInt)
  {
    WeakReference localWeakReference = (WeakReference)this.adapterHashMap.get(Integer.valueOf(paramInt));
    if (localWeakReference != null) {
      return (ReadInJoyBaseAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public List<Integer> getFixPosArticleInfos(int paramInt)
  {
    Object localObject1 = (WeakReference)this.adapterHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 == null) {
      return new ArrayList();
    }
    Object localObject2 = (ReadInJoyBaseAdapter)((WeakReference)localObject1).get();
    if ((localObject2 != null) && (!((ReadInJoyBaseAdapter)localObject2).isEmpty()))
    {
      localObject1 = new ArrayList();
      localObject2 = ((ReadInJoyBaseAdapter)localObject2).h();
      if (localObject2 == null) {
        return new ArrayList();
      }
      paramInt = 0;
      while (paramInt < ((List)localObject2).size())
      {
        if ((((List)localObject2).get(paramInt) instanceof AdvertisementInfo)) {
          ((ArrayList)localObject1).add(Integer.valueOf(paramInt));
        }
        paramInt += 1;
      }
      return localObject1;
    }
    return new ArrayList();
  }
  
  public AbsBaseArticleInfo getSpecialArticleInfo(int paramInt, long paramLong)
  {
    return this.adArticleController.a(paramInt, getFixPosArticlePosition(paramLong));
  }
  
  public List<AbsBaseArticleInfo> insertFixPosArticles(int paramInt1, List<AbsBaseArticleInfo> paramList1, List<AbsBaseArticleInfo> paramList2, int paramInt2)
  {
    if (paramList1 == null) {
      return null;
    }
    this.adArticleController.a(paramInt1);
    if (!this.adArticleController.e(paramInt1))
    {
      QLog.d("ReadinjoyFixPosArticleManager", 1, "has no fix article , give up insert !");
      return paramList1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("insertFixPosArticles type : ");
    ((StringBuilder)localObject1).append(paramInt2);
    ((StringBuilder)localObject1).append(", channelID : ");
    ((StringBuilder)localObject1).append(paramInt1);
    QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject1).toString());
    int i = 0;
    long l;
    int j;
    ArrayList localArrayList;
    if (paramInt2 == 2)
    {
      paramInt2 = 0;
      while (paramInt2 < paramList2.size())
      {
        l = ((AbsBaseArticleInfo)paramList2.get(paramInt2)).mRecommendSeq;
        if (isFixPosArticleSeq(l))
        {
          j = getFixPosArticlePosition(l);
          int k = paramInt2 - j;
          localObject1 = (ArrayList)this.adArticleController.b.get(Integer.valueOf(paramInt1));
          localArrayList = (ArrayList)this.adArticleController.c.get(Integer.valueOf(paramInt1));
          if ((localObject1 != null) && (localArrayList != null))
          {
            int m = ((ArrayList)localObject1).indexOf(Integer.valueOf(j));
            if (m >= 0)
            {
              localArrayList.set(m, Integer.valueOf(k));
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("fix offset when loadMore, expect : ");
              ((StringBuilder)localObject1).append(j);
              ((StringBuilder)localObject1).append(", now : ");
              ((StringBuilder)localObject1).append(paramInt2);
              ((StringBuilder)localObject1).append(", offset : ");
              ((StringBuilder)localObject1).append(k);
              QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject1).toString());
            }
          }
        }
        paramInt2 += 1;
      }
    }
    paramList2 = (ArrayList)this.adArticleController.b.get(Integer.valueOf(paramInt1));
    localObject1 = (ArrayList)this.adArticleController.c.get(Integer.valueOf(paramInt1));
    Object localObject2 = (ArrayList)this.adArticleController.d.get(Integer.valueOf(paramInt1));
    if ((paramList2 != null) && (localObject1 != null) && (localObject2 != null))
    {
      localArrayList = new ArrayList(paramList1);
      j = Math.min(paramList2.size(), ((ArrayList)localObject2).size());
      paramInt2 = i;
      while (paramInt2 < j)
      {
        i = ((Integer)paramList2.get(paramInt2)).intValue() + ((Integer)((ArrayList)localObject1).get(paramInt2)).intValue();
        if (paramList1.size() + paramList2.size() < i + 1)
        {
          localObject2 = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("expect insert into ");
          localStringBuilder.append(i);
          localStringBuilder.append(", but article size is not enougharticle size:");
          localStringBuilder.append(paramList1.size());
          localStringBuilder.append(" sp size: ");
          localStringBuilder.append(paramList2.size());
          ((IRIJAdLogService)localObject2).d("ReadinjoyFixPosArticleManager", localStringBuilder.toString());
        }
        else
        {
          i = findBestPosition(paramInt1, localArrayList, i);
          if (i == -1)
          {
            QLog.d("ReadinjoyFixPosArticleManager", 1, "find real position is error ! ");
          }
          else
          {
            l = getFakeSpecialArticleSeq(1, ((Integer)paramList2.get(paramInt2)).intValue());
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("insert article , position : ");
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append(", expectIndex : ");
            ((StringBuilder)localObject2).append(paramList2.get(paramInt2));
            ((StringBuilder)localObject2).append(", fakeSeq : ");
            ((StringBuilder)localObject2).append(l);
            QLog.d("ReadinjoyFixPosArticleManager", 1, ((StringBuilder)localObject2).toString());
            localObject2 = ReadInJoyLogicEngine.a().a(paramInt1, l);
            if (localObject2 != null) {
              localArrayList.add(i, localObject2);
            }
          }
        }
        paramInt2 += 1;
      }
      return localArrayList;
    }
    QLog.d("ReadinjoyFixPosArticleManager", 1, "ad article or positions is empty ! return ori data ");
    return paramList1;
  }
  
  public void register(int paramInt, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter)
  {
    if (paramIReadInJoyBaseAdapter == null) {
      return;
    }
    if ((paramIReadInJoyBaseAdapter instanceof ReadInJoyBaseAdapter)) {
      this.adapterHashMap.put(Integer.valueOf(paramInt), new WeakReference((ReadInJoyBaseAdapter)paramIReadInJoyBaseAdapter));
    }
    this.adArticleController.c(paramInt);
  }
  
  public void registerReommendADListener(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" registerReommendADListener ");
      localStringBuilder.append(paramInt);
      QLog.d("ReadinjoyFixPosArticleManager", 2, localStringBuilder.toString());
    }
    this.adArticleController.c(paramInt);
  }
  
  public void unRegister(int paramInt)
  {
    this.adapterHashMap.remove(Integer.valueOf(paramInt));
    this.adArticleController.d(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadinjoyFixPosArticleManager
 * JD-Core Version:    0.7.0.1
 */