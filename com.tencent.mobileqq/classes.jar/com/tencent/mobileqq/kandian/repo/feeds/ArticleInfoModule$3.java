package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

class ArticleInfoModule$3
  implements Runnable
{
  ArticleInfoModule$3(ArticleInfoModule paramArticleInfoModule, boolean paramBoolean1, List paramList1, List paramList2, int paramInt, boolean paramBoolean2) {}
  
  public void run()
  {
    if (this.a)
    {
      Object localObject1 = this.b;
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        localObject1 = this.c;
        if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
        {
          long l2 = ((Long)this.b.get(0)).longValue();
          StringBuilder localStringBuilder1 = new StringBuilder("\n");
          localObject1 = this.c.iterator();
          int i = 0;
          Object localObject3;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("实时替换 article【");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append("】 id : ");
            ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mArticleID);
            ((StringBuilder)localObject3).append(" seq : ");
            ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mRecommendSeq);
            ((StringBuilder)localObject3).append(" title : ");
            ((StringBuilder)localObject3).append(ReadInJoyStringUtils.b(((AbsBaseArticleInfo)localObject2).mTitle));
            ((StringBuilder)localObject3).append(" , groupID : ");
            ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mGroupId);
            ((StringBuilder)localObject3).append(" algorithmID : ");
            ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mAlgorithmID);
            ((StringBuilder)localObject3).append(" strategyId : ");
            ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mStrategyId);
            ((StringBuilder)localObject3).append(" feedType: ");
            ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mFeedType);
            localStringBuilder1.append(((StringBuilder)localObject3).toString());
            if (QLog.isColorLevel())
            {
              if (((AbsBaseArticleInfo)localObject2).mSocialFeedInfo != null)
              {
                localObject3 = new StringBuilder();
                ((StringBuilder)localObject3).append(" ");
                ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mSocialFeedInfo);
                localStringBuilder1.append(((StringBuilder)localObject3).toString());
                localStringBuilder1.append("\n");
              }
              else
              {
                localStringBuilder1.append("\n");
              }
            }
            else {
              localStringBuilder1.append("\n");
            }
            i += 1;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("###onGetVideoRealtimeReplaceList success=");
          ((StringBuilder)localObject1).append(this.a);
          ((StringBuilder)localObject1).append(" channelId=");
          ((StringBuilder)localObject1).append(this.d);
          ((StringBuilder)localObject1).append(", reqArticleID: ");
          ((StringBuilder)localObject1).append(l2);
          ((StringBuilder)localObject1).append(localStringBuilder1.toString());
          QLog.i("ArticleInfoModule", 1, ((StringBuilder)localObject1).toString());
          localObject1 = ArticleInfoModule.a(this.this$0).b(Integer.valueOf(this.d));
          if (localObject1 == null)
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("###onGetVideoRealtimeReplaceList fail, for currentSeqList is null, channelId=");
              ((StringBuilder)localObject1).append(this.d);
              QLog.i("ArticleInfoModule", 1, ((StringBuilder)localObject1).toString());
            }
            return;
          }
          Object localObject2 = ((List)localObject1).iterator();
          long l1 = -1L;
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Long)((Iterator)localObject2).next();
            AbsBaseArticleInfo localAbsBaseArticleInfo = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.d), (Long)localObject3);
            if (l2 == localAbsBaseArticleInfo.mArticleID)
            {
              l1 = ((Long)localObject3).longValue();
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("###onGetVideoRealtimeReplaceList find the original article seq：");
              localStringBuilder2.append(localObject3);
              localStringBuilder2.append(", reqArticleID: ");
              localStringBuilder2.append(l2);
              localStringBuilder2.append(", title : ");
              localStringBuilder2.append(ReadInJoyStringUtils.b(localAbsBaseArticleInfo.mTitle));
              QLog.i("ArticleInfoModule", 1, localStringBuilder2.toString());
            }
          }
          if (l1 == -1L) {
            return;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder1.setLength(0);
            localStringBuilder1.append("current seq list >>");
            localStringBuilder1.append("\n");
            i = 0;
            while (i < ((List)localObject1).size())
            {
              localObject2 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.d), (Long)((List)localObject1).get(i));
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("article [");
              ((StringBuilder)localObject3).append(i);
              ((StringBuilder)localObject3).append("] seq : ");
              ((StringBuilder)localObject3).append(((List)localObject1).get(i));
              ((StringBuilder)localObject3).append(", id : ");
              ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mArticleID);
              ((StringBuilder)localObject3).append(" title : ");
              ((StringBuilder)localObject3).append(ReadInJoyStringUtils.b(((AbsBaseArticleInfo)localObject2).mTitle));
              localStringBuilder1.append(((StringBuilder)localObject3).toString());
              localStringBuilder1.append("\n");
              i += 1;
            }
            QLog.d("ArticleInfoModule", 2, localStringBuilder1.toString());
          }
          localObject2 = ArticleInfoModule.a(this.this$0).d(this.d);
          if (localObject2 == null) {
            return;
          }
          i = ((List)localObject1).size();
          int k = this.c.size();
          int j = 0;
          while (j < i)
          {
            long l3 = ((Long)((List)localObject1).get(j)).longValue();
            if (((l1 & 0xFFFFFF00) == (l3 & 0xFFFFFF00)) && (l3 >= l1))
            {
              localObject3 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.d), Long.valueOf(l3));
              ((AbsBaseArticleInfo)localObject3).mRecommendSeq = (l3 + k);
              ((ConcurrentMap)localObject2).remove(Long.valueOf(l3));
              ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.d), (AbsBaseArticleInfo)localObject3, true);
            }
            j += 1;
          }
          j = k - 1;
          i = k;
          while (j >= 0)
          {
            localObject1 = (AbsBaseArticleInfo)this.c.get(j);
            ((AbsBaseArticleInfo)localObject1).mRecommendSeq = (l1 + i - 1L - j);
            ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.d), (AbsBaseArticleInfo)localObject1, true);
            j -= 1;
          }
          localObject1 = ArticleInfoModule.a(this.this$0).b(Integer.valueOf(this.d));
          if (QLog.isColorLevel())
          {
            i = 0;
            localStringBuilder1.setLength(0);
            localStringBuilder1.append("new seq list >>");
            localStringBuilder1.append("\n");
            while (i < ((List)localObject1).size())
            {
              localObject2 = ArticleInfoModule.a(this.this$0).a(Integer.valueOf(this.d), (Long)((List)localObject1).get(i));
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("article [");
              ((StringBuilder)localObject3).append(i);
              ((StringBuilder)localObject3).append("] seq : ");
              ((StringBuilder)localObject3).append(((List)localObject1).get(i));
              ((StringBuilder)localObject3).append(", id : ");
              ((StringBuilder)localObject3).append(((AbsBaseArticleInfo)localObject2).mArticleID);
              ((StringBuilder)localObject3).append(" title : ");
              ((StringBuilder)localObject3).append(ReadInJoyStringUtils.b(((AbsBaseArticleInfo)localObject2).mTitle));
              localStringBuilder1.append(((StringBuilder)localObject3).toString());
              localStringBuilder1.append("\n");
              i += 1;
            }
            QLog.d("ArticleInfoModule", 2, localStringBuilder1.toString());
          }
          if (!this.e) {
            return;
          }
          ReadInJoyLogicEngineEventDispatcher.a().a(this.a, this.d, l2, (List)localObject1, this.c);
          return;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ArticleInfoModule", 2, "###onGetVideoRealtimeReplaceList: reqArticleList  szie != 1 or articleInfoList is empty.");
      }
    }
    else
    {
      QLog.e("ArticleInfoModule", 1, "###onGetVideoRealtimeReplaceList failure");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule.3
 * JD-Core Version:    0.7.0.1
 */