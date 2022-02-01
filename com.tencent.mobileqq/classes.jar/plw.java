import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertController.insertArticleInfo.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertController;", "", "()V", "TAG", "", "addToListFilterDuplicate", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "articleInfoList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "index", "", "getInsertArticleInfoList", "insertAfterArticleInfo", "feedsInsertInfoMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getNewArticleInfoListWithInsertFeeds", "", "adapter", "Lcom/tencent/biz/pubaccount/readinjoy/view/ReadInJoyBaseAdapter;", "insertArticleInfo", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class plw
{
  public static final plw a = new plw();
  
  private final ArrayList<BaseArticleInfo> a(BaseArticleInfo paramBaseArticleInfo, HashMap<String, ArrayList<BaseArticleInfo>> paramHashMap)
  {
    Object localObject2 = (ArrayList)paramHashMap.get(paramBaseArticleInfo.innerUniqueID);
    if (localObject2 != null) {}
    Object localObject1;
    do
    {
      return localObject2;
      Object localObject3 = paramBaseArticleInfo.mSubArtilceList;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        localObject1 = localObject2;
        if (((Iterator)localObject3).hasNext())
        {
          localObject2 = (ArrayList)paramHashMap.get(((ArticleInfo)((Iterator)localObject3).next()).innerUniqueID);
          if (localObject2 != null) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            break;
          }
        }
      }
      localObject2 = localObject1;
    } while (localObject1 != null);
    paramBaseArticleInfo = paramBaseArticleInfo.mNewPolymericInfo;
    if (paramBaseArticleInfo != null)
    {
      paramBaseArticleInfo = paramBaseArticleInfo.a;
      if (paramBaseArticleInfo != null)
      {
        localObject2 = paramBaseArticleInfo.iterator();
        paramBaseArticleInfo = (BaseArticleInfo)localObject1;
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (ArrayList)paramHashMap.get(((rdn)((Iterator)localObject2).next()).g);
          if (localObject1 != null) {
            paramBaseArticleInfo = (BaseArticleInfo)localObject1;
          }
          for (;;)
          {
            break;
          }
        }
      }
    }
    for (;;)
    {
      return paramBaseArticleInfo;
      paramBaseArticleInfo = (BaseArticleInfo)localObject1;
    }
  }
  
  private final void a(BaseArticleInfo paramBaseArticleInfo, ArrayList<BaseArticleInfo> paramArrayList, int paramInt)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
      if (TextUtils.equals((CharSequence)paramBaseArticleInfo.innerUniqueID, (CharSequence)localBaseArticleInfo.innerUniqueID))
      {
        QLog.i("RIJFeedsInsertController", 1, "[addToListFilterDuplicate] has duplicate, articleInfo = " + pma.a.a(paramBaseArticleInfo));
        return;
      }
    }
    paramArrayList.add(paramInt, paramBaseArticleInfo);
    if (!paramBaseArticleInfo.hasBeenInsertIntoList)
    {
      pma.a.a();
      paramBaseArticleInfo.hasBeenInsertIntoList = true;
    }
    QLog.i("RIJFeedsInsertController", 1, "[addToListFilterDuplicate], index = " + paramInt + ", articleInfo = " + pma.a.a(paramBaseArticleInfo));
  }
  
  @NotNull
  public final List<BaseArticleInfo> a(@NotNull slt paramslt, @NotNull List<? extends BaseArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramslt, "adapter");
    Intrinsics.checkParameterIsNotNull(paramList, "articleInfoList");
    long l = System.currentTimeMillis();
    int i = paramslt.a();
    if (!pma.a.a(i))
    {
      QLog.i("RIJFeedsInsertController", 1, "[getNewArticleInfoListWithInsertFeeds] channelId = " + i + ", do not insert...");
      return paramList;
    }
    paramslt = pay.a();
    if (paramslt == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
    }
    paramslt = (pks)((QQAppInterface)paramslt).getManager(163);
    ArrayList localArrayList;
    if (paramslt != null)
    {
      paramslt = paramslt.a();
      if (paramslt != null)
      {
        paramslt = paramslt.a();
        if (paramslt != null)
        {
          paramslt = paramslt.a(i);
          localArrayList = new ArrayList((Collection)paramList);
          if (paramslt == null) {
            break label255;
          }
          paramList = ((Iterable)paramList).iterator();
          i = 0;
        }
      }
    }
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label255;
      }
      Object localObject = (BaseArticleInfo)paramList.next();
      localObject = a.a((BaseArticleInfo)localObject, paramslt);
      if (localObject != null)
      {
        localObject = CollectionsKt.asReversedMutable((List)localObject).iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
            a.a(localBaseArticleInfo, localArrayList, i + 1);
            continue;
            paramslt = null;
            break;
          }
        }
      }
      i += 1;
    }
    label255:
    if (QLog.isColorLevel()) {
      QLog.i("RIJFeedsInsertController", 1, "[getNewArticleInfoListWithInsertFeeds], time cost = " + (System.currentTimeMillis() - l) + " ms");
    }
    return (List)localArrayList;
  }
  
  public final void a(@NotNull slt paramslt, @NotNull List<? extends BaseArticleInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramslt, "adapter");
    Intrinsics.checkParameterIsNotNull(paramList, "articleInfoList");
    pay.b().post((Runnable)new RIJFeedsInsertController.insertArticleInfo.1(paramslt, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     plw
 * JD-Core Version:    0.7.0.1
 */