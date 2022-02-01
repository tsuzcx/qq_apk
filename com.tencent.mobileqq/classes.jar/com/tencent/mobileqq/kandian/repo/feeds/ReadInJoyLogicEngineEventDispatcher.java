package com.tencent.mobileqq.kandian.repo.feeds;

import android.content.res.Configuration;
import android.support.annotation.UiThread;
import android.util.SparseArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.kandian.repo.comment.CommentReportInfo;
import com.tencent.mobileqq.kandian.repo.comment.entity.DiandianTopConfig;
import com.tencent.mobileqq.kandian.repo.feeds.api.IInsertArticleCallback;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelBannerInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SubscriptionFeed;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopBannerInfo;
import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.RecommendFollowInfo;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.mobileqq.kandian.repo.handler.TopicInfo;
import com.tencent.mobileqq.kandian.repo.reward.UserCoinInfo;
import com.tencent.mobileqq.kandian.repo.share.KingMomentInfo;
import com.tencent.widget.AbsListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xbd6.oidb_cmd0xbd6.RspBody;

public class ReadInJoyLogicEngineEventDispatcher
{
  private static ReadInJoyLogicEngineEventDispatcher b;
  private final CopyOnWriteArrayList<ReadInJoyObserver> a = new CopyOnWriteArrayList();
  
  public static ReadInJoyLogicEngineEventDispatcher a()
  {
    try
    {
      if (b == null) {
        b = new ReadInJoyLogicEngineEventDispatcher();
      }
      return b;
    }
    finally {}
  }
  
  public void a(float paramFloat, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramFloat, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).m_(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b_(paramInt1, paramInt2);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramInt2, paramInt3);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(int paramInt, long paramLong, String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramLong, paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(int paramInt1, long paramLong, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramLong, paramString1, paramInt2, paramString2, paramString3);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(int paramInt1, long paramLong, List<Long> paramList, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt1, paramLong, paramList, paramInt2, paramInt3, paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString1, String paramString2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramAbsBaseArticleInfo, paramString1, paramString2);
      }
      return;
    }
    for (;;)
    {
      throw paramAbsBaseArticleInfo;
    }
  }
  
  public void a(int paramInt, PositionData paramPositionData)
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramPositionData);
      }
      return;
    }
    for (;;)
    {
      throw paramPositionData;
    }
  }
  
  public void a(int paramInt, KingMomentInfo paramKingMomentInfo)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramKingMomentInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramKingMomentInfo;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramObject);
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void a(int paramInt, @NonNull String paramString1, @NonNull String paramString2, JSONObject paramJSONObject)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramString1, paramString2, paramJSONObject);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(int paramInt, String paramString, List<AbsBaseArticleInfo> paramList, IInsertArticleCallback paramIInsertArticleCallback)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramString, paramList, paramIInsertArticleCallback);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(int paramInt, List<Long> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt, paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong, paramInt, paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramLong, paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramConfiguration);
      }
      return;
    }
    for (;;)
    {
      throw paramConfiguration;
    }
  }
  
  public void a(View paramView)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramView);
      }
      return;
    }
    for (;;)
    {
      throw paramView;
    }
  }
  
  public void a(ReadInJoyLogicEngineEventDispatcher.ForEachObserverJob paramForEachObserverJob)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        paramForEachObserverJob.a((ReadInJoyObserver)localIterator.next());
      }
      return;
    }
    for (;;)
    {
      throw paramForEachObserverJob;
    }
  }
  
  public void a(ReadInJoyObserver paramReadInJoyObserver)
  {
    if (paramReadInJoyObserver == null) {
      return;
    }
    if (!this.a.contains(paramReadInJoyObserver)) {
      synchronized (this.a)
      {
        this.a.add(paramReadInJoyObserver);
        return;
      }
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a_(paramAbsBaseArticleInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramAbsBaseArticleInfo;
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramAbsBaseArticleInfo, paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw paramAbsBaseArticleInfo;
    }
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramTabChannelCoverInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramTabChannelCoverInfo;
    }
  }
  
  public void a(TopBannerInfo paramTopBannerInfo)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramTopBannerInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramTopBannerInfo;
    }
  }
  
  public void a(AbsListView paramAbsListView)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramAbsListView);
      }
      return;
    }
    for (;;)
    {
      throw paramAbsListView;
    }
  }
  
  public void a(Long paramLong)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong);
      }
      return;
    }
    for (;;)
    {
      throw paramLong;
    }
  }
  
  public void a(Object paramObject, int paramInt, boolean paramBoolean, String... paramVarArgs)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramObject, paramInt, paramBoolean, paramVarArgs);
      }
      return;
    }
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public void a(String paramString)
  {
    a(new ReadInJoyLogicEngineEventDispatcher.1(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramString, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString, paramInt1, paramInt2);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(String paramString1, int paramInt1, long paramLong, String paramString2, int paramInt2, String paramString3, String paramString4)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString1, paramInt1, paramLong, paramString2, paramInt2, paramString3, paramString4);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(String paramString1, int paramInt, oidb_cmd0xbd6.RspBody paramRspBody, String paramString2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString1, paramInt, paramRspBody, paramString2);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString1, paramString2, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramArrayList);
      }
      return;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public void a(List<SubscriptionFeed> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a_(paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(List<String> paramList, List<TopicInfo> paramList1)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramList, paramList1);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, long paramLong, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramLong, paramList, paramList1);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, SparseArray<ChannelInfo> paramSparseArray)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramSparseArray);
      }
      return;
    }
    for (;;)
    {
      throw paramSparseArray;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, CommentReportInfo paramCommentReportInfo)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramString, paramCommentReportInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt, String paramString, UserCoinInfo paramUserCoinInfo)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt, paramString, paramUserCoinInfo);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramInt1, paramString1, paramString2, paramInt2);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, String paramString1, String paramString2, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramInt, paramString1, paramString2, paramBoolean2);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramLong, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    try
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          ((ReadInJoyObserver)localIterator.next()).a_(paramBoolean, paramString);
        }
        return;
      }
      throw paramString;
    }
    finally {}
    for (;;) {}
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramInt2);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2, paramString5);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramString1, paramString2, paramString3, paramString4, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a(boolean paramBoolean, List<DiandianTopConfig> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  @Deprecated
  public void a(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void a(boolean paramBoolean, List<Long> paramList, List<AbsBaseArticleInfo> paramList1)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramList, paramList1);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b()
  {
    ??? = this.a.iterator();
    while (((Iterator)???).hasNext())
    {
      localReadInJoyObserver = (ReadInJoyObserver)((Iterator)???).next();
      if (localReadInJoyObserver != null) {
        break label36;
      }
    }
    ReadInJoyObserver localReadInJoyObserver = null;
    label36:
    synchronized (this.a)
    {
      this.a.clear();
      if (localReadInJoyObserver != null) {
        this.a.add(localReadInJoyObserver);
      }
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void b(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).n_(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(int paramInt, List<Long> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramInt, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramLong, paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(ReadInJoyObserver paramReadInJoyObserver)
  {
    synchronized (this.a)
    {
      this.a.remove(paramReadInJoyObserver);
      return;
    }
  }
  
  public void b(String paramString)
  {
    a(new ReadInJoyLogicEngineEventDispatcher.2(this, paramString));
  }
  
  public void b(String paramString, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramString, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void b(List<TagInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void b(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean1, paramInt, paramList, paramBoolean2);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void b(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void c()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cE_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c(int paramInt, List<Long> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramInt, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void c(String paramString)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).k_(paramString);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void c(String paramString, int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramString, paramInt);
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void c(List<TopicInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  @UiThread
  public void c(boolean paramBoolean)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void c(boolean paramBoolean, List<ChannelInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).a(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void c(boolean paramBoolean1, List<FollowingMember> paramList, long paramLong, boolean paramBoolean2)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean1, paramList, paramLong, paramBoolean2);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void d()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cF_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).e(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void d(int paramInt, List<ChannelBannerInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).d(paramInt, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void d(boolean paramBoolean, List<Integer> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).g(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void e()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cG_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void e(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).f(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void e(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).e(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void f()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cK_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void f(int paramInt)
  {
    synchronized (this.a)
    {
      Iterator localIterator = new ArrayList(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).o_(paramInt);
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void f(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).b(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void g()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).s();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void g(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).c(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void h()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).t();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void h(boolean paramBoolean, List<ChannelCoverInfo> paramList)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).h(paramBoolean, paramList);
      }
      return;
    }
    for (;;)
    {
      throw paramList;
    }
  }
  
  public void i()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cH_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void j()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cI_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void k()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cJ_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void l()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((ReadInJoyObserver)localIterator.next()).f();
    }
  }
  
  public void m()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cL_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void n()
  {
    try
    {
      synchronized (this.a)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          ((ReadInJoyObserver)localIterator.next()).cM_();
        }
        return;
      }
      throw localObject1;
    }
    finally {}
    for (;;) {}
  }
  
  public void o()
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext()) {
        ((ReadInJoyObserver)localIterator.next()).cN_();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher
 * JD-Core Version:    0.7.0.1
 */