package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.RIJFeedsInsertArticle;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/feeds/dynamicfeeds/RIJFeedsDynamicInsertRecordAction;", "", "()V", "feedsActionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "getFeedsActionMap", "()Ljava/util/concurrent/ConcurrentHashMap;", "deleteActionsByRowkey", "", "reqSource", "rowKey", "getInsertArticles", "Lkotlin/Triple;", "", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "Lcom/tencent/mobileqq/kandian/repo/feeds/RIJFeedsInsertAction;", "getRecordFeedsActions", "(ILjava/lang/String;)Ljava/lang/Integer;", "recordFeedsAction", "action", "Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJFeedsDynamicInsertRecordAction
{
  public static final RIJFeedsDynamicInsertRecordAction.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJFeedsDynamicInsertRecordAction.Companion.INSTANCE.2.INSTANCE);
  @NotNull
  private final ConcurrentHashMap<Integer, ConcurrentHashMap<String, Integer>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizFeedsDynamicfeedsRIJFeedsDynamicInsertRecordAction$Companion = new RIJFeedsDynamicInsertRecordAction.Companion(null);
  }
  
  @Nullable
  public final Integer a(int paramInt, @Nullable String paramString)
  {
    Object localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject2 = null;
    if (localObject1 != null) {
      localObject1 = (Integer)((ConcurrentHashMap)localObject1).get(paramString);
    } else {
      localObject1 = null;
    }
    if (localObject1 == null) {
      return Integer.valueOf(ActionType.ACTION_NONE.getActionType());
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    localObject1 = localObject2;
    if (localConcurrentHashMap != null) {
      localObject1 = (Integer)localConcurrentHashMap.get(paramString);
    }
    return localObject1;
  }
  
  @NotNull
  public final ConcurrentHashMap<Integer, ConcurrentHashMap<String, Integer>> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  @Nullable
  public final Triple<List<AbsBaseArticleInfo>, RIJFeedsInsertAction, String> a(int paramInt, @Nullable String paramString)
  {
    boolean bool = TextUtils.isEmpty((CharSequence)paramString);
    Object localObject2 = null;
    if (bool)
    {
      QLog.d("RIJFeedsDynamicInsertActionRecord", 1, "rowKey is null, return");
      return null;
    }
    Object localObject3 = a(paramInt, paramString);
    Object localObject1 = RIJFeedsDynamicInsertController.INSTANCE.getFeedsInsertDynamicInsertModule();
    if (localObject1 != null) {
      paramString = ((RIJFeedsDynamicInsertModule)localObject1).a(paramInt, paramString);
    } else {
      paramString = null;
    }
    if (paramString != null) {
      localObject1 = paramString.a();
    } else {
      localObject1 = null;
    }
    if ((localObject1 != null) && (localObject3 != null))
    {
      localObject1 = paramString.a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((SortedMap)localObject1).keySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        RIJFeedsInsertAction localRIJFeedsInsertAction = (RIJFeedsInsertAction)((Iterator)localObject1).next();
        if ((localRIJFeedsInsertAction.a().getActionType() & ((Integer)localObject3).intValue()) > 0)
        {
          localObject3 = paramString.a();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = (ArrayList)((SortedMap)localObject3).get(localRIJFeedsInsertAction);
          }
          return new Triple(localObject1, localRIJFeedsInsertAction, paramString.a());
        }
      }
    }
    return null;
  }
  
  public final void a(int paramInt, @Nullable String paramString)
  {
    if (paramString != null)
    {
      ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      if (localConcurrentHashMap != null) {
        paramString = (Integer)localConcurrentHashMap.remove(paramString);
      }
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public final void a(int paramInt, @Nullable String paramString, @NotNull ActionType paramActionType)
  {
    Intrinsics.checkParameterIsNotNull(paramActionType, "action");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("recordsFeedsAction, reqSource: ");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(", rowKey: ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", action: ");
    ((StringBuilder)localObject1).append(paramActionType);
    QLog.d("RIJFeedsDynamicInsertActionRecord", 1, ((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QLog.i("RIJFeedsDynamicInsertActionRecord", 1, "[recordFeedsAction] record feeds action key is null");
      return;
    }
    localObject1 = a(paramInt, paramString);
    if (localObject1 != null)
    {
      int i = ActionType.ACTION_NONE.getActionType();
      if (((Integer)localObject1).intValue() != i)
      {
        Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject2 == null) {
          return;
        }
        localObject2 = (Map)localObject2;
        paramInt = ((Integer)localObject1).intValue();
        ((Map)localObject2).put(paramString, Integer.valueOf(paramActionType.getActionType() | paramInt));
        return;
      }
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt))) {
      ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Integer.valueOf(paramInt), new ConcurrentHashMap());
    }
    localObject1 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    if (localObject1 != null) {
      ((Map)localObject1).put(paramString, Integer.valueOf(paramActionType.getActionType()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertRecordAction
 * JD-Core Version:    0.7.0.1
 */