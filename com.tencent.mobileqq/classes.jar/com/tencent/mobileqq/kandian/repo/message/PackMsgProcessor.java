package com.tencent.mobileqq.kandian.repo.message;

import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackVideoInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

public class PackMsgProcessor
{
  public static long b = 1L;
  ArticleInfoModule a;
  
  public PackMsgProcessor(ArticleInfoModule paramArticleInfoModule)
  {
    this.a = paramArticleInfoModule;
  }
  
  public static List<AbsBaseArticleInfo> a(List<AbsBaseArticleInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      int k = paramList.size();
      int j;
      for (int i = 0; i < k; i = j + 1)
      {
        Object localObject = (AbsBaseArticleInfo)paramList.get(i);
        ((AbsBaseArticleInfo)localObject).mIsInPolymeric = false;
        if (!RIJFeedsType.E((AbsBaseArticleInfo)localObject))
        {
          localArrayList.add(localObject);
          j = i;
        }
        else
        {
          ((AbsBaseArticleInfo)localObject).mIsInPolymeric = true;
          BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
          localBaseArticleInfo.mRecommendSeq = ((AbsBaseArticleInfo)localObject).mRecommendSeq;
          localBaseArticleInfo.mGroupSubArticleList = new ArrayList();
          localBaseArticleInfo.mGroupSubArticleList.add(localObject);
          localBaseArticleInfo.mPolymericInfo = ((AbsBaseArticleInfo)localObject).mPolymericInfo;
          localBaseArticleInfo.mStrategyId = ((int)((AbsBaseArticleInfo)localObject).mPolymericInfo.k);
          localBaseArticleInfo.mAlgorithmID = ((int)((AbsBaseArticleInfo)localObject).mPolymericInfo.l);
          StringBuilder localStringBuilder = new StringBuilder("polymeric【");
          localStringBuilder.append(localArrayList.size());
          localStringBuilder.append("】");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject).mPolymericInfo.toString());
          localStringBuilder.append("\n title : ");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject).mTitle);
          localStringBuilder.append(", articleID : ");
          localStringBuilder.append(((AbsBaseArticleInfo)localObject).mArticleID);
          localStringBuilder.append(", oriIndex : ");
          localStringBuilder.append(i);
          localStringBuilder.append("\n");
          for (;;)
          {
            j = i + 1;
            if ((j >= k) || (!RIJFeedsType.a((AbsBaseArticleInfo)localObject, (AbsBaseArticleInfo)paramList.get(j)))) {
              break;
            }
            AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.get(j);
            localAbsBaseArticleInfo.mIsInPolymeric = true;
            localBaseArticleInfo.mGroupSubArticleList.add(localAbsBaseArticleInfo);
            localStringBuilder.append("title : ");
            localStringBuilder.append(localAbsBaseArticleInfo.mTitle);
            localStringBuilder.append(", articleID : ");
            localStringBuilder.append(localAbsBaseArticleInfo.mArticleID);
            localStringBuilder.append(", oriIndex : ");
            localStringBuilder.append(j);
            localStringBuilder.append("\n");
            i = j;
          }
          if ((RIJFeedsType.I((AbsBaseArticleInfo)localObject)) && (localBaseArticleInfo.mGroupSubArticleList.size() >= 1))
          {
            localArrayList.add(localBaseArticleInfo);
            j = i;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("PolymericSmallVideo_");
              ((StringBuilder)localObject).append(PackMsgProcessor.class.getSimpleName());
              QLog.d(((StringBuilder)localObject).toString(), 2, localStringBuilder.toString());
              j = i;
            }
          }
          else if (localBaseArticleInfo.mGroupSubArticleList.size() > 1)
          {
            localArrayList.add(localBaseArticleInfo);
            j = i;
          }
          else
          {
            ((AbsBaseArticleInfo)localObject).mIsInPolymeric = false;
            localArrayList.add(localObject);
            j = i;
          }
        }
      }
      if ((localArrayList.size() > 1) && (RIJFeedsType.G((AbsBaseArticleInfo)localArrayList.get(localArrayList.size() - 1)))) {
        localArrayList.remove(localArrayList.size() - 1);
      }
      return localArrayList;
    }
    return null;
  }
  
  public static void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo.mNewPolymericInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.p != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo.p.size() > 0))
    {
      paramAbsBaseArticleInfo.mGroupSubArticleList = new ArrayList();
      String str = paramAbsBaseArticleInfo.getSubscribeUin();
      long l;
      Object localObject;
      try
      {
        l = Long.parseLong(str);
      }
      catch (Exception localException1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleNewPolymericArticleInfo parse exception = ");
        ((StringBuilder)localObject).append(localException1);
        QLog.e("PackMsgProcess", 2, ((StringBuilder)localObject).toString());
        l = 0L;
      }
      Iterator localIterator = paramAbsBaseArticleInfo.mNewPolymericInfo.p.iterator();
      while (localIterator.hasNext())
      {
        localObject = (NewPolymericInfo.PackArticleInfo)localIterator.next();
        BaseArticleInfo localBaseArticleInfo = new BaseArticleInfo();
        localBaseArticleInfo.mChannelID = paramAbsBaseArticleInfo.mChannelID;
        localBaseArticleInfo.mArticleID = ((NewPolymericInfo.PackArticleInfo)localObject).a;
        localBaseArticleInfo.mStrategyId = ((NewPolymericInfo.PackArticleInfo)localObject).h;
        localBaseArticleInfo.mAlgorithmID = ((NewPolymericInfo.PackArticleInfo)localObject).i;
        localBaseArticleInfo.innerUniqueID = ((NewPolymericInfo.PackArticleInfo)localObject).l;
        localBaseArticleInfo.mArticleContentUrl = ((NewPolymericInfo.PackArticleInfo)localObject).e;
        localBaseArticleInfo.mSubscribeID = ((NewPolymericInfo.PackArticleInfo)localObject).f;
        boolean bool;
        if (((NewPolymericInfo.PackArticleInfo)localObject).m == 1) {
          bool = true;
        } else {
          bool = false;
        }
        localBaseArticleInfo.mIsPolymericGallery = bool;
        localBaseArticleInfo.mGalleryPicNumber = ((NewPolymericInfo.PackArticleInfo)localObject).n;
        localBaseArticleInfo.mSinglePicture = RIJConvertString2URL.b(((NewPolymericInfo.PackArticleInfo)localObject).d);
        if (((NewPolymericInfo.PackArticleInfo)localObject).o != null)
        {
          localBaseArticleInfo.mVideoCoverUrl = RIJConvertString2URL.b(((NewPolymericInfo.PackArticleInfo)localObject).d);
          localBaseArticleInfo.mVideoVid = ((NewPolymericInfo.PackArticleInfo)localObject).o.b;
        }
        localBaseArticleInfo.mNewPolymericInfo = new NewPolymericInfo();
        localBaseArticleInfo.mNewPolymericInfo.d = paramAbsBaseArticleInfo.mNewPolymericInfo.d;
        localBaseArticleInfo.mNewPolymericInfo.a = false;
        localBaseArticleInfo.mNewPolymericInfo.p = new ArrayList();
        try
        {
          localBaseArticleInfo.mNewPolymericInfo.p.add((NewPolymericInfo.PackArticleInfo)((NewPolymericInfo.PackArticleInfo)localObject).clone());
        }
        catch (Exception localException2)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleNewPolymericArticleInfo packSubArticle clone failed. exception = ");
          localStringBuilder.append(localException2);
          QLog.e("PackMsgProcess", 2, localStringBuilder.toString());
        }
        if (RIJItemViewTypeUtils.m(paramAbsBaseArticleInfo))
        {
          ((NewPolymericInfo.PackArticleInfo)localObject).s = true;
          localBaseArticleInfo.mSocialFeedInfo = paramAbsBaseArticleInfo.mSocialFeedInfo;
        }
        localBaseArticleInfo.mNewPolymericInfo.c = l;
        paramAbsBaseArticleInfo.mGroupSubArticleList.add(localBaseArticleInfo);
      }
    }
  }
  
  public void a(Integer paramInteger, List<Long> paramList)
  {
    if ((paramList != null) && (paramList.size() != 0))
    {
      long l1 = System.currentTimeMillis();
      int k = paramList.size();
      ArrayList localArrayList = new ArrayList(5);
      int i = 0;
      long l2 = -1L;
      while (i < k)
      {
        Object localObject1 = this.a.i().a(paramInteger, (Long)paramList.get(i));
        if (localObject1 != null)
        {
          int j;
          Object localObject2;
          while (((AbsBaseArticleInfo)localObject1).mGroupId == -1L) {
            if (l2 != -1L)
            {
              localObject1 = localArrayList.iterator();
              j = 0;
              while (((Iterator)localObject1).hasNext())
              {
                localObject2 = (AbsBaseArticleInfo)((Iterator)localObject1).next();
                ((AbsBaseArticleInfo)localObject2).mFeedIndexInGroup = j;
                ((AbsBaseArticleInfo)localObject2).mGroupCount = localArrayList.size();
                j += 1;
              }
              if (QLog.isColorLevel())
              {
                if ((localArrayList.size() > 0) && (((AbsBaseArticleInfo)localArrayList.get(0)).mPackInfoObj != null)) {
                  j = ((articlesummary.PackInfo)((AbsBaseArticleInfo)localArrayList.get(0)).mPackInfoObj.get()).pack_type.get();
                } else {
                  j = -1;
                }
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("groupId:");
                ((StringBuilder)localObject1).append(l2);
                ((StringBuilder)localObject1).append(" count:");
                ((StringBuilder)localObject1).append(localArrayList.size());
                ((StringBuilder)localObject1).append(" type:");
                ((StringBuilder)localObject1).append(j);
                QLog.d("PackMsgProcess", 2, ((StringBuilder)localObject1).toString());
              }
              localArrayList.clear();
              l2 = -1L;
              break label590;
            }
          }
          if (l2 != ((AbsBaseArticleInfo)localObject1).mGroupId)
          {
            if (l2 != -1L)
            {
              localObject2 = localArrayList.iterator();
              j = 0;
              while (((Iterator)localObject2).hasNext())
              {
                AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)((Iterator)localObject2).next();
                localAbsBaseArticleInfo.mFeedIndexInGroup = j;
                localAbsBaseArticleInfo.mGroupCount = localArrayList.size();
                j += 1;
              }
              if (QLog.isColorLevel())
              {
                if ((localArrayList.size() > 0) && (((AbsBaseArticleInfo)localArrayList.get(0)).mPackInfoObj != null)) {
                  j = ((articlesummary.PackInfo)((AbsBaseArticleInfo)localArrayList.get(0)).mPackInfoObj.get()).pack_type.get();
                } else {
                  j = -1;
                }
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("groupId:");
                ((StringBuilder)localObject2).append(l2);
                ((StringBuilder)localObject2).append(" count:");
                ((StringBuilder)localObject2).append(localArrayList.size());
                ((StringBuilder)localObject2).append(" type:");
                ((StringBuilder)localObject2).append(j);
                QLog.d("PackMsgProcess", 2, ((StringBuilder)localObject2).toString());
              }
            }
            localArrayList.clear();
            localArrayList.add(localObject1);
            l2 = ((AbsBaseArticleInfo)localObject1).mGroupId;
          }
          else
          {
            localArrayList.add(localObject1);
          }
        }
        label590:
        i += 1;
      }
      if (localArrayList.size() > 0)
      {
        paramInteger = localArrayList.iterator();
        i = 0;
        while (paramInteger.hasNext())
        {
          paramList = (AbsBaseArticleInfo)paramInteger.next();
          paramList.mFeedIndexInGroup = i;
          paramList.mGroupCount = localArrayList.size();
          i += 1;
        }
        if (QLog.isColorLevel())
        {
          if ((localArrayList.size() > 0) && (((AbsBaseArticleInfo)localArrayList.get(0)).mPackInfoObj != null)) {
            i = ((articlesummary.PackInfo)((AbsBaseArticleInfo)localArrayList.get(0)).mPackInfoObj.get()).pack_type.get();
          } else {
            i = -1;
          }
          paramInteger = new StringBuilder();
          paramInteger.append("groupId:");
          paramInteger.append(l2);
          paramInteger.append(" count:");
          paramInteger.append(localArrayList.size());
          paramInteger.append(" type:");
          paramInteger.append(i);
          QLog.d("PackMsgProcess", 2, paramInteger.toString());
        }
      }
      if (QLog.isColorLevel())
      {
        paramInteger = new StringBuilder();
        paramInteger.append("process article group info,feeds:");
        paramInteger.append(k);
        paramInteger.append(" cost:");
        paramInteger.append(System.currentTimeMillis() - l1);
        QLog.d("PackMsgProcess", 2, paramInteger.toString());
      }
      return;
    }
  }
  
  public void a(Integer paramInteger, List<AbsBaseArticleInfo> paramList, boolean paramBoolean)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (paramBoolean) {
        return;
      }
      AbsBaseArticleInfo localAbsBaseArticleInfo1 = (AbsBaseArticleInfo)paramList.get(paramList.size() - 1);
      if (localAbsBaseArticleInfo1.mGroupId != -1L)
      {
        paramInteger = this.a.i().b(paramInteger.intValue(), 10, localAbsBaseArticleInfo1.mRecommendSeq, true).iterator();
        while (paramInteger.hasNext())
        {
          AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)paramInteger.next();
          if (localAbsBaseArticleInfo2.mGroupId == localAbsBaseArticleInfo1.mGroupId) {
            paramList.add(localAbsBaseArticleInfo2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.message.PackMsgProcessor
 * JD-Core Version:    0.7.0.1
 */