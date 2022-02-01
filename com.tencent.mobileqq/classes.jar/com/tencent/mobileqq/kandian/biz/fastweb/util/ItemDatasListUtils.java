package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.repo.comment.entity.CommentInfo;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ArticleTopicData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.AuthorData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.CommentData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.NoCommentPlaceHolderData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ProteusRecommendItemData;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.ShareBottomData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class ItemDatasListUtils
{
  public static void a(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    int i = 0;
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((BaseData)((Iterator)localObject).next()).aP == 6) {
        i += 1;
      }
    }
    paramList = paramList.iterator();
    int j = 1;
    while (paramList.hasNext())
    {
      localObject = (BaseData)paramList.next();
      int k = ((BaseData)localObject).aP;
      if (k != 6)
      {
        if (k == 9) {}
      }
      else
      {
        localObject = (ProteusRecommendItemData)localObject;
        ((ProteusRecommendItemData)localObject).a = j;
        ((ProteusRecommendItemData)localObject).b = i;
      }
      j += 1;
    }
  }
  
  public static void a(List<BaseData> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.aP == paramInt) {
        localArrayList.add(localBaseData);
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  public static void a(List<BaseData> paramList, int paramInt, AuthorData paramAuthorData)
  {
    if (paramInt == 1)
    {
      paramList.add(0, FastWebRequestUtil.a(paramAuthorData));
      paramList.add(FastWebRequestUtil.a());
    }
  }
  
  public static void a(List<BaseData> paramList, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (FastWebShareUtils.a())
    {
      a(paramList, 19);
      a(paramList, new ShareBottomData());
    }
    else
    {
      a(paramList, 19);
    }
    a(paramList, 21);
  }
  
  public static void a(List<BaseData> paramList, BaseData paramBaseData)
  {
    if (paramList != null)
    {
      if (paramBaseData == null) {
        return;
      }
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break;
        }
        if (paramBaseData.b((BaseData)paramList.get(i)))
        {
          paramList.add(i, paramBaseData);
          j = 1;
          break;
        }
        i += 1;
      }
      if (j == 0)
      {
        QLog.d("ItemDatasListUtils", 2, "insertForWeight, add in the end.");
        paramList.add(paramBaseData);
      }
    }
  }
  
  public static void a(List<BaseData> paramList, List<CommentInfo> paramList1)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramList1 != null))
    {
      if (paramList1.isEmpty()) {
        return;
      }
      HashMap localHashMap = new HashMap();
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        CommentInfo localCommentInfo = (CommentInfo)paramList1.next();
        localHashMap.put(localCommentInfo.commentId, localCommentInfo);
      }
      int i = 0;
      int k;
      for (int j = 0; i < paramList.size(); j = k)
      {
        paramList1 = (BaseData)paramList.get(i);
        k = j;
        if (paramList1.aP == 12)
        {
          paramList1 = (CommentData)paramList1;
          k = j;
          if (localHashMap.containsKey(paramList1.a.commentId))
          {
            paramList1.a = ((CommentInfo)localHashMap.get(paramList1.a.commentId));
            k = j + 1;
          }
        }
        i += 1;
      }
      paramList = ItemDatasListUtils.class.getSimpleName();
      paramList1 = new StringBuilder();
      paramList1.append("update comment data! size : ");
      paramList1.append(j);
      QLog.d(paramList, 2, paramList1.toString());
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, SparseArray<Float> paramSparseArray)
  {
    Object localObject = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if ((localBaseData.aP == 7) || (localBaseData.aP == 6) || (localBaseData.aP == 8)) {
          ((List)localObject).add(localBaseData);
        }
      }
      paramList1.removeAll((Collection)localObject);
    }
    if (paramList2 != null)
    {
      paramList2 = new ArrayList(paramList2).iterator();
      while (paramList2.hasNext())
      {
        localObject = (BaseData)paramList2.next();
        ((BaseData)localObject).aQ = paramAbsBaseArticleInfo;
        ((BaseData)localObject).aR = paramFastWebArticleInfo;
        if ((localObject instanceof ProteusItemData)) {
          FastWebRequestUtil.a(paramAbsBaseArticleInfo, (ProteusItemData)localObject, 5, paramSparseArray);
        }
        a(paramList1, (BaseData)localObject);
      }
    }
  }
  
  public static void a(List<BaseData> paramList1, List<BaseData> paramList2, List<BaseData> paramList3, AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, boolean paramBoolean1, SparseArray<Float> paramSparseArray, ItemShowDispatcher paramItemShowDispatcher, int paramInt, boolean paramBoolean2)
  {
    if ((paramList2 != null) && (!paramList2.isEmpty())) {
      a(paramList1, paramList2, paramAbsBaseArticleInfo, paramFastWebArticleInfo, paramSparseArray);
    }
    if (paramList3 != null)
    {
      if (paramBoolean1) {
        ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).addInnerAd(paramList1, paramList3);
      } else {
        ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).addBottomAd(paramList1, paramList3);
      }
      ((IRIJFastWebAdService)QRoute.api(IRIJFastWebAdService.class)).fixInnerAndBottmAd(paramList1);
    }
    e(paramList1);
  }
  
  public static void a(boolean paramBoolean, List<BaseData> paramList, FastWebArticleInfo paramFastWebArticleInfo, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramFastWebArticleInfo != null))
    {
      if ((paramBoolean) && (paramFastWebArticleInfo.A == null)) {
        return;
      }
      Object localObject2 = null;
      int i = 0;
      Object localObject1;
      int k;
      for (int j = -1;; j = k)
      {
        localObject1 = localObject2;
        if (i >= paramList.size()) {
          break;
        }
        localObject1 = (BaseData)paramList.get(i);
        if (FastWebPTSUtils.a((BaseData)localObject1))
        {
          k = i;
        }
        else
        {
          k = j;
          if (((BaseData)localObject1).aP == 15)
          {
            localObject1 = (ArticleTopicData)localObject1;
            break;
          }
        }
        i += 1;
      }
      if (!paramBoolean)
      {
        if (localObject1 != null) {
          paramList.remove(localObject1);
        }
      }
      else
      {
        if (localObject1 != null)
        {
          ((ArticleTopicData)localObject1).a = paramFastWebArticleInfo.A;
          ((ArticleTopicData)localObject1).aQ = paramAbsBaseArticleInfo;
          ((ArticleTopicData)localObject1).aR = paramFastWebArticleInfo;
          ((ArticleTopicData)localObject1).b = false;
          return;
        }
        if (j != -1)
        {
          localObject1 = new ArticleTopicData();
          ((ArticleTopicData)localObject1).a = paramFastWebArticleInfo.A;
          ((ArticleTopicData)localObject1).aQ = paramAbsBaseArticleInfo;
          ((ArticleTopicData)localObject1).aR = paramFastWebArticleInfo;
          paramList.add(j + 1, localObject1);
        }
      }
    }
  }
  
  public static void b(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    int j = 0;
    Iterator localIterator = paramList.iterator();
    do
    {
      i = j;
      if (!localIterator.hasNext()) {
        break;
      }
    } while (((BaseData)localIterator.next()).aP != 16);
    int i = 1;
    if (i == 0) {
      paramList.add(new NoCommentPlaceHolderData());
    }
  }
  
  public static void b(List<BaseData> paramList, BaseData paramBaseData)
  {
    if (paramList != null)
    {
      if (paramBaseData == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseData localBaseData = (BaseData)localIterator.next();
        if (localBaseData.aP == 23) {
          localArrayList.add(localBaseData);
        }
      }
      paramList.removeAll(localArrayList);
      a(paramList, paramBaseData);
    }
  }
  
  public static void c(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if (localBaseData.aP == 16) {
        paramList.remove(localBaseData);
      }
    }
  }
  
  public static void d(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseData localBaseData = (BaseData)localIterator.next();
      if ((localBaseData.aP == 26) && ((localBaseData instanceof ProteusItemData)))
      {
        ProteusItemData localProteusItemData = (ProteusItemData)localBaseData;
        if ((localProteusItemData.bb != null) && (TextUtils.equals(localProteusItemData.bb.optString("style_ID", ""), "readinjoy_native_tag"))) {
          localArrayList.add(localBaseData);
        }
      }
    }
    paramList.removeAll(localArrayList);
  }
  
  private static void e(List<BaseData> paramList)
  {
    if (paramList == null) {
      return;
    }
    Object localObject2 = null;
    int i = 0;
    Object localObject1;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= paramList.size()) {
        break;
      }
      localObject1 = (BaseData)paramList.get(i);
      if (((BaseData)localObject1).aP == 16)
      {
        localObject1 = (NoCommentPlaceHolderData)localObject1;
        paramList.remove(i);
        break;
      }
      i += 1;
    }
    if (localObject1 != null) {
      paramList.add(localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.ItemDatasListUtils
 * JD-Core Version:    0.7.0.1
 */