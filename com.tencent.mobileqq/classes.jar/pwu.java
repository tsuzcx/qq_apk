import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqBody;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.ReqRecommendPara;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspBody;
import tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspRecommendParaArticle;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule;", "Lcom/tencent/biz/pubaccount/readinjoy/model/ReadInJoyEngineModule;", "app", "Lcom/tencent/common/app/AppInterface;", "entityManager", "Lcom/tencent/mobileqq/persistence/EntityManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "msfService", "Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;", "mainThreadHandler", "Landroid/os/Handler;", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/persistence/EntityManager;Ljava/util/concurrent/ExecutorService;Lcom/tencent/biz/pubaccount/readinjoy/protocol/ReadInJoyMSFService;Landroid/os/Handler;)V", "feedsInsertInfoMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "requestTimeMap", "addOrReplaceArticleInfoInList", "", "articleInfo", "articleInfoList", "addRequestAttributes", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "reqParams", "Lcom/tencent/biz/pubaccount/readinjoy/feedsinsert/RIJFeedsInsertModule$ReqParams;", "deleteFeedsInsertInfo", "channelId", "getArticleInfoListLogInfo", "", "getFeedsInsertInfo", "handleReceiveFeedsInsertInfo", "req", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "isAbleToRequest", "", "followPuin", "onReceive", "removeInvalidArticleInfo", "requestFeedsInsertInfo", "unInitialize", "Companion", "ReqParams", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pwu
  extends qhj
{
  public static final pwv a;
  private final ConcurrentHashMap<Long, HashMap<String, ArrayList<BaseArticleInfo>>> a;
  private final ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_Pwv = new pwv(null);
  }
  
  public pwu(@Nullable AppInterface paramAppInterface, @Nullable EntityManager paramEntityManager, @Nullable ExecutorService paramExecutorService, @Nullable qxn paramqxn, @Nullable Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  private final String a(List<? extends BaseArticleInfo> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
      localStringBuilder.append("\n articleInfo[" + i + "] = " + localBaseArticleInfo + ' ');
      i += 1;
    }
    paramList = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "stringBuilder.toString()");
    return paramList;
  }
  
  private final void a(BaseArticleInfo paramBaseArticleInfo, ArrayList<BaseArticleInfo> paramArrayList)
  {
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      if (TextUtils.equals((CharSequence)((BaseArticleInfo)localIterator.next()).innerUniqueID, (CharSequence)paramBaseArticleInfo.innerUniqueID))
      {
        paramArrayList.set(i, paramBaseArticleInfo);
        QLog.i("RIJFeedsInsertModule", 1, "[addOrReplaceArticleInfoInList] replace old articleInfo, articleInfo = " + pwx.a.a(paramBaseArticleInfo) + ", index = " + i);
        return;
      }
      i += 1;
    }
    paramArrayList.add(0, paramBaseArticleInfo);
    QLog.i("RIJFeedsInsertModule", 1, "[addOrReplaceArticleInfoInList] add new articleInfo, articleInfo = " + pwx.a.a(paramBaseArticleInfo));
  }
  
  private final void a(ToServiceMsg paramToServiceMsg, pww parampww)
  {
    Object localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    ((Map)localObject).put("key_channel_id", Long.valueOf(parampww.a()));
    localObject = paramToServiceMsg.getAttributes();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.attributes");
    Map localMap = (Map)localObject;
    localObject = parampww.a();
    if (localObject != null)
    {
      localObject = ((BaseArticleInfo)localObject).innerUniqueID;
      if (localObject == null) {}
    }
    for (;;)
    {
      localMap.put("key_article_rowKey", localObject);
      paramToServiceMsg = paramToServiceMsg.getAttributes();
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.attributes");
      ((Map)paramToServiceMsg).put("key_subscribe_id", parampww.a());
      return;
      localObject = "";
    }
  }
  
  private final void a(ArrayList<BaseArticleInfo> paramArrayList)
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (BaseArticleInfo)((Iterator)localObject2).next();
      if (!((BaseArticleInfo)localObject3).hasBeenInsertIntoList) {
        ((ArrayList)localObject1).add(localObject3);
      }
    }
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (BaseArticleInfo)((Iterator)localObject1).next();
      paramArrayList.remove(localObject2);
      localObject3 = new StringBuilder().append("[removeInvalidArticleInfo], invalidArticleInfo = ");
      pwx localpwx = pwx.a;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "invalidArticleInfo");
      QLog.i("RIJFeedsInsertModule", 1, localpwx.a((BaseArticleInfo)localObject2));
    }
  }
  
  private final boolean a(String paramString)
  {
    Long localLong = (Long)this.b.get(paramString);
    if (localLong != null) {}
    for (;;)
    {
      Intrinsics.checkExpressionValueIsNotNull(localLong, "requestTimeMap[followPuin] ?: 0L");
      long l1 = localLong.longValue();
      long l2 = System.currentTimeMillis();
      QLog.i("RIJFeedsInsertModule", 2, "[isAbleToRequest] followPuin = " + paramString + ", last request timeStamp = " + l1 + ", currentTimeStamp = " + l2);
      if (l2 - l1 <= 2000) {
        break;
      }
      return true;
      localLong = Long.valueOf(0L);
    }
    return false;
  }
  
  private final void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_cmd0xebb.RspBody();
    int i = qxp.a(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    QLog.i("RIJFeedsInsertModule", 1, "[handleReceiveFeedsInsertInfo], result = " + i);
    long l;
    if (i == 0)
    {
      paramFromServiceMsg = ((oidb_cmd0xebb.RspBody)localObject).msg_rsp_channel_article;
      if (paramFromServiceMsg.has()) {
        if (paramFromServiceMsg != null)
        {
          paramObject = paramFromServiceMsg.uint64_channel_id;
          if (paramObject != null)
          {
            l = paramObject.get();
            if (paramFromServiceMsg == null) {
              break label291;
            }
            paramFromServiceMsg = paramFromServiceMsg.rpt_article_list;
            if (paramFromServiceMsg == null) {
              break label291;
            }
            paramFromServiceMsg = paramFromServiceMsg.get();
            label103:
            if (paramToServiceMsg == null) {
              break label302;
            }
            paramToServiceMsg = paramToServiceMsg.getAttribute("key_article_rowKey");
            if (paramToServiceMsg == null) {
              break label302;
            }
            if (!(paramToServiceMsg instanceof String)) {
              break label296;
            }
            paramToServiceMsg = (String)paramToServiceMsg;
            label130:
            paramObject = (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(l));
            if (paramObject != null) {
              break label369;
            }
            paramObject = new HashMap();
            ((Map)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap).put(Long.valueOf(l), paramObject);
          }
        }
      }
    }
    label291:
    label296:
    label302:
    label369:
    for (;;)
    {
      localObject = (ArrayList)paramObject.get(paramToServiceMsg);
      if (localObject == null)
      {
        localObject = new ArrayList();
        ((Map)paramObject).put(paramToServiceMsg, localObject);
      }
      for (paramObject = localObject;; paramObject = localObject)
      {
        a(paramObject);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = CollectionsKt.asReversedMutable(paramFromServiceMsg).iterator();
          for (;;)
          {
            if (paramFromServiceMsg.hasNext())
            {
              localObject = qxm.a((articlesummary.ArticleSummary)paramFromServiceMsg.next(), (int)l, 0, null);
              Intrinsics.checkExpressionValueIsNotNull(localObject, "articleInfo");
              a((BaseArticleInfo)localObject, paramObject);
              continue;
              l = 0L;
              break;
              paramFromServiceMsg = null;
              break label103;
              paramToServiceMsg = "";
              break label130;
              paramToServiceMsg = "";
              break label130;
            }
          }
        }
        QLog.i("RIJFeedsInsertModule", 1, "[handleReceiveFeedsInsertInfo], channelId = " + l + ", insertRowKey = " + paramToServiceMsg + ", articleInfoList = " + a((List)paramObject));
        return;
      }
    }
  }
  
  @Nullable
  public final HashMap<String, ArrayList<BaseArticleInfo>> a(long paramLong)
  {
    return (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public final void a(long paramLong, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "articleInfo");
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null)
    {
      localObject = ((Map)localObject).entrySet().iterator();
      Map.Entry localEntry;
      BaseArticleInfo localBaseArticleInfo;
      do
      {
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
          localIterator = ((ArrayList)localEntry.getValue()).iterator();
        }
        localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
      } while (!TextUtils.equals((CharSequence)paramBaseArticleInfo.innerUniqueID, (CharSequence)localBaseArticleInfo.innerUniqueID));
      ((ArrayList)localEntry.getValue()).remove(localBaseArticleInfo);
      QLog.i("RIJFeedsInsertModule", 1, "[deleteFeedsInsertInfo] articleInfo = " + pwx.a.a(paramBaseArticleInfo));
    }
  }
  
  public void a(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if (paramFromServiceMsg != null) {}
    for (String str = paramFromServiceMsg.getServiceCmd();; str = null)
    {
      if (TextUtils.equals((CharSequence)str, (CharSequence)"OidbSvc.0xebb")) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
  }
  
  public final void a(@NotNull pww parampww)
  {
    Intrinsics.checkParameterIsNotNull(parampww, "reqParams");
    if (!pwx.a.a((int)parampww.a())) {
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo] do not request, channelId = " + parampww.a());
    }
    while (!pwx.a.a()) {
      return;
    }
    if (!a(parampww.a()))
    {
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo] do not request twice in a short period of time...");
      return;
    }
    oidb_cmd0xebb.ReqRecommendPara localReqRecommendPara = new oidb_cmd0xebb.ReqRecommendPara();
    localReqRecommendPara.uint64_channel_id.set(parampww.a());
    PBBytesField localPBBytesField = localReqRecommendPara.bytes_req_rowkey;
    Object localObject = parampww.a();
    if (localObject != null)
    {
      localObject = ((BaseArticleInfo)localObject).innerUniqueID;
      if (localObject == null) {}
    }
    for (;;)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localReqRecommendPara.bytes_subscribe_id.set(ByteStringMicro.copyFromUtf8(parampww.a()));
      localReqRecommendPara.uint32_update_times.set(parampww.a());
      localReqRecommendPara.uint32_req_recommend_flag.set(parampww.b());
      localObject = new oidb_cmd0xebb.ReqBody();
      ((oidb_cmd0xebb.ReqBody)localObject).uint32_network_type.set(qer.a());
      ((oidb_cmd0xebb.ReqBody)localObject).uint32_os_type.set(2);
      ((oidb_cmd0xebb.ReqBody)localObject).msg_req_recommend_para.set((MessageMicro)localReqRecommendPara);
      localObject = qxp.a("OidbSvc.0xebb", 3771, 0, ((oidb_cmd0xebb.ReqBody)localObject).toByteArray());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ReadInJoyOidbHelper.make…T, reqBody.toByteArray())");
      a((ToServiceMsg)localObject, parampww);
      a((ToServiceMsg)localObject);
      long l = System.currentTimeMillis();
      ((Map)this.b).put(parampww.a(), Long.valueOf(l));
      QLog.i("RIJFeedsInsertModule", 1, "[requestFeedsInsertInfo], reqParams = " + parampww + ", timeStamp = " + l);
      return;
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pwu
 * JD-Core Version:    0.7.0.1
 */