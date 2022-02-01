package com.tencent.mobileqq.kandian.repo.fastweb;

import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.fastweb.entity.FastWebShareInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.kandian.repo.pts.entity.PtsData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsExtInfo;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.Client;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqArticle;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.ReqBody;
import tencent.im.oidb.cmd0xad6.oidb_cmd0xad6.RspBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.Client;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqArticle;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.ReqBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspBody;
import tencent.im.oidb.cmd0xad7.oidb_cmd0xad7.RspShare;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.Client;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqArticle;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqBody;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.ReqOption;
import tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspBody;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.FeedParam;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.ReqBody;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.RspBody;
import tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3.ShareInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ParagraphInfo;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.ReqBody;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.RspBody;
import tencent.im.oidb.cmd0xe7e.oidb_cmd0xe7e.WebInfo;

public class FastWebModule
  extends ReadInJoyEngineModule
  implements IFastWebModuleConst
{
  public static final String a = "FastWebModule";
  private AtomicInteger b = new AtomicInteger(0);
  private ConcurrentHashMap<Integer, Object> c = new ConcurrentHashMap();
  private HashMap<String, FastWebModule.OutdateLimitCacheFeild<Parcelable>> d = new HashMap();
  private ConcurrentHashMap<String, FastWebModule.OutdateLimitCacheFeild<FastWebArticleInfo>> e = new ConcurrentHashMap();
  private QQLruCache<String, List<BaseData>> f;
  
  public FastWebModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    a();
  }
  
  private Object a(Integer paramInteger)
  {
    return this.c.remove(paramInteger);
  }
  
  private oidb_cmd0xe7e.ParagraphInfo a(ProteusItemData paramProteusItemData)
  {
    oidb_cmd0xe7e.ParagraphInfo localParagraphInfo = new oidb_cmd0xe7e.ParagraphInfo();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramProteusItemData.be == 2)
      {
        localJSONObject.put("url", paramProteusItemData.n());
        localParagraphInfo.enum_type.set(1);
      }
      else if (paramProteusItemData.be == 3)
      {
        localJSONObject.put("vid", paramProteusItemData.m());
        localParagraphInfo.enum_type.set(2);
      }
      else if (paramProteusItemData.be == 4)
      {
        localJSONObject.put("type", paramProteusItemData.o());
        localParagraphInfo.enum_type.set(3);
      }
      else if (paramProteusItemData.be == 1)
      {
        localParagraphInfo.enum_type.set(0);
      }
      else
      {
        return null;
      }
    }
    catch (JSONException paramProteusItemData)
    {
      QLog.d(a, 1, paramProteusItemData, new Object[0]);
      localParagraphInfo.bytes_detail_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
    }
    return localParagraphInfo;
  }
  
  private oidb_cmd0xe7e.ParagraphInfo a(PtsData paramPtsData)
  {
    oidb_cmd0xe7e.ParagraphInfo localParagraphInfo = new oidb_cmd0xe7e.ParagraphInfo();
    localParagraphInfo.enum_type.set(3);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramPtsData.b);
      localParagraphInfo.bytes_detail_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
      return localParagraphInfo;
    }
    catch (JSONException paramPtsData)
    {
      QLog.e(a, 1, "generateParagraphInfo error : ", paramPtsData);
    }
    return localParagraphInfo;
  }
  
  private void a()
  {
    this.f = new FastWebModule.4(this, 2012, 30, 1);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSubArticleList != null))
    {
      if (paramAbsBaseArticleInfo.mSubArticleList.size() <= 0) {
        return;
      }
      paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.mSubArticleList.iterator();
      while (paramAbsBaseArticleInfo.hasNext()) {
        b((AbsBaseArticleInfo)paramAbsBaseArticleInfo.next());
      }
    }
  }
  
  private void a(Integer paramInteger, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.c.put(paramInteger, paramObject);
  }
  
  private long b(int paramInt)
  {
    int i = NetUtil.a(null);
    Object localObject = FastWebSPUtils.b(RIJQQAppInterfaceUtil.e());
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return 1000L;
    }
    localObject = ((String)localObject).split(",");
    if (localObject.length != 5) {
      return 1000L;
    }
    if (paramInt == 3) {
      return Long.valueOf(localObject[4]).longValue();
    }
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return 1000L;
          }
          return Long.valueOf(localObject[3]).longValue();
        }
        return Long.valueOf(localObject[2]).longValue();
      }
      return Long.valueOf(localObject[1]).longValue();
    }
    return Long.valueOf(localObject[0]).longValue();
  }
  
  private Object b(Integer paramInteger)
  {
    return this.c.get(paramInteger);
  }
  
  private static List<BaseData> b(List<BaseData> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((BaseData)paramList.next());
    }
    return localArrayList;
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (!RIJFeedsType.a(paramAbsBaseArticleInfo))
    {
      if ((paramAbsBaseArticleInfo instanceof AdvertisementInfo)) {
        return;
      }
      if (!RIJFeedsType.a(paramAbsBaseArticleInfo.mArticleContentUrl, paramAbsBaseArticleInfo.mChannelID, paramAbsBaseArticleInfo)) {
        return;
      }
      Object localObject = this.e;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramAbsBaseArticleInfo.mChannelID);
      localStringBuilder.append("_");
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      localObject = (FastWebModule.OutdateLimitCacheFeild)((ConcurrentHashMap)localObject).get(localStringBuilder.toString());
      if ((localObject == null) || (((FastWebModule.OutdateLimitCacheFeild)localObject).a()))
      {
        if (QLog.isColorLevel())
        {
          localObject = a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("[preloadFastWebArticleInfoImp] title = ");
          localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
          QLog.i((String)localObject, 2, localStringBuilder.toString());
        }
        a(paramAbsBaseArticleInfo.mArticleContentUrl, paramAbsBaseArticleInfo.innerUniqueID, paramAbsBaseArticleInfo.mSubscribeID, 3, null);
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int k = ((Integer)paramToServiceMsg.getAttribute("ad6Seq")).intValue();
    String str = (String)paramToServiceMsg.getAttribute("uniflag");
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("ad6ReqTime")).longValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("reqType")).intValue();
    oidb_cmd0xad6.RspBody localRspBody = new oidb_cmd0xad6.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool1;
    if (j == 0)
    {
      paramToServiceMsg = new FastWebArticleInfo();
      bool1 = FastWebArticleInfoUtils.a(paramToServiceMsg, localRspBody, i);
    }
    else
    {
      bool1 = false;
      paramToServiceMsg = null;
    }
    boolean bool2;
    if ((paramToServiceMsg != null) && (!paramToServiceMsg.K)) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    paramFromServiceMsg = (FastWebModule.FastWebContentGetCallback)a(Integer.valueOf(k));
    if (paramFromServiceMsg != null)
    {
      paramObject = new StringBuilder();
      paramObject.append("callback  result : ");
      paramObject.append(bool1);
      paramObject.append(", seq : ");
      paramObject.append(k);
      paramObject.append(", useWebView : ");
      paramObject.append(bool2);
      paramObject.append(", cost : ");
      paramObject.append(l);
      paramObject.append(", retCode : ");
      paramObject.append(j);
      paramObject.append(", native info : ");
      paramObject.append(paramToServiceMsg);
      paramObject.append("  callback : ");
      paramObject.append(paramFromServiceMsg);
      QLog.d("Q.readinjoy.fast_web", 2, paramObject.toString());
      ThreadManager.getUIHandler().post(new FastWebModule.1(this, paramFromServiceMsg, bool1, bool2, paramToServiceMsg));
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("ad6 resp  result : ");
    paramFromServiceMsg.append(bool1);
    paramFromServiceMsg.append(", seq : ");
    paramFromServiceMsg.append(k);
    paramFromServiceMsg.append(", useWebView : ");
    paramFromServiceMsg.append(bool2);
    paramFromServiceMsg.append(", cost : ");
    paramFromServiceMsg.append(l);
    paramFromServiceMsg.append(", retCode : ");
    paramFromServiceMsg.append(j);
    paramFromServiceMsg.append(", native info : ");
    paramFromServiceMsg.append(paramToServiceMsg);
    QLog.d("Q.readinjoy.fast_web", 2, paramFromServiceMsg.toString());
    if (str != null)
    {
      k = i;
      if ((k != 1) && ((k != 3) || (!bool1)))
      {
        if (paramToServiceMsg != null)
        {
          if (!this.e.containsKey(str)) {
            break label516;
          }
          paramFromServiceMsg = (FastWebModule.OutdateLimitCacheFeild)this.e.get(str);
          ((FastWebArticleInfo)paramFromServiceMsg.b()).a(paramToServiceMsg.d, paramToServiceMsg.c);
          paramFromServiceMsg.a(paramFromServiceMsg.b());
        }
      }
      else {
        this.e.put(str, new FastWebModule.OutdateLimitCacheFeild(this, paramToServiceMsg));
      }
    }
    label516:
    paramToServiceMsg = new HashMap();
    paramToServiceMsg.put("which", "2");
    paramToServiceMsg.put("reqType", String.valueOf(i));
    paramToServiceMsg.put("param_uin", RIJQQAppInterfaceUtil.d());
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(j);
    paramFromServiceMsg.append("");
    paramToServiceMsg.put("param_retCode", paramFromServiceMsg.toString());
    paramToServiceMsg.put("param_succ", String.valueOf(bool1));
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append(NetUtil.a(null));
    paramFromServiceMsg.append("");
    paramToServiceMsg.put("param_netType", paramFromServiceMsg.toString());
    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianFastWebCost", bool1, l, 0L, paramToServiceMsg, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad7Seq")).intValue();
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)paramToServiceMsg.getAttribute("ad7ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("ad7Action")).intValue();
    oidb_cmd0xad7.RspBody localRspBody = new oidb_cmd0xad7.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramToServiceMsg = new FastWebShareInfo();
    boolean bool;
    if ((k == 0) && (localRspBody.msg_rsp_share.has()))
    {
      bool = true;
      paramFromServiceMsg = (oidb_cmd0xad7.RspShare)localRspBody.msg_rsp_share.get();
      paramToServiceMsg.b = paramFromServiceMsg.bytes_wechat_pyq.get().toStringUtf8();
      paramToServiceMsg.a = paramFromServiceMsg.bytes_weibo.get().toStringUtf8();
      paramToServiceMsg.d = paramFromServiceMsg.bytes_friend.get().toStringUtf8();
      paramToServiceMsg.c = paramFromServiceMsg.bytes_wechat.get().toStringUtf8();
      paramToServiceMsg.e = paramFromServiceMsg.bytes_qzhone.get().toStringUtf8();
    }
    else
    {
      bool = false;
    }
    paramFromServiceMsg = (FastWebModule.FastWebArticleRichReqCallback)a(Integer.valueOf(i));
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.a(bool, j, paramToServiceMsg);
    }
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("handle ad7rsp , succ ");
    paramFromServiceMsg.append(bool);
    paramFromServiceMsg.append(", retCode : ");
    paramFromServiceMsg.append(k);
    paramFromServiceMsg.append(", seq : ");
    paramFromServiceMsg.append(i);
    paramFromServiceMsg.append(", cost : ");
    paramFromServiceMsg.append(l1 - l2);
    paramFromServiceMsg.append("\n");
    paramFromServiceMsg.append(paramToServiceMsg);
    QLog.d("Q.readinjoy.fast_web", 2, paramFromServiceMsg.toString());
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("bd3Seq")).intValue();
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("bd3ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("bd3ShareType")).intValue();
    oidb_cmd0xbd3.RspBody localRspBody = new oidb_cmd0xbd3.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (FeedbackCallback)a(Integer.valueOf(i));
    paramToServiceMsg = "";
    boolean bool;
    if ((k == 0) && (localRspBody.rpt_share_info.has()) && (localRspBody.rpt_share_info.get() != null) && (localRspBody.rpt_share_info.get().size() > 0))
    {
      paramObject = (oidb_cmd0xbd3.ShareInfo)localRspBody.rpt_share_info.get().get(0);
      if (paramObject.bytes_share_json.has()) {
        paramToServiceMsg = paramObject.bytes_share_json.get().toStringUtf8();
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (paramFromServiceMsg != null) {
      ThreadManager.getUIHandler().post(new FastWebModule.2(this, paramFromServiceMsg, bool, j, paramToServiceMsg));
    }
    QLog.d(a, 1, new Object[] { "handle0xbd3Resp, retCode = ", Integer.valueOf(k), ", success= ", Boolean.valueOf(bool), ", cost = ", Long.valueOf(l), ", shareJson = ", paramToServiceMsg });
    RIJStatisticCollectorReport.a(RIJQQAppInterfaceUtil.e(), bool, l, k);
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt, FastWebModule.FastWebContentGetCallback paramFastWebContentGetCallback)
  {
    for (;;)
    {
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getArticleContent, rowkey : ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(", url : ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(" callback: ");
        ((StringBuilder)localObject1).append(paramFastWebContentGetCallback);
        ((StringBuilder)localObject1).append(", reqType : ");
        ((StringBuilder)localObject1).append(paramInt);
        QLog.d("Q.readinjoy.fast_web", 1, ((StringBuilder)localObject1).toString());
        if ((paramInt != 2) && (paramString2 != null))
        {
          localObject1 = (FastWebModule.OutdateLimitCacheFeild)this.e.get(paramString2);
          if (localObject1 != null) {
            if (((FastWebModule.OutdateLimitCacheFeild)localObject1).a())
            {
              this.e.remove(paramString2);
            }
            else
            {
              paramString3 = (FastWebArticleInfo)((FastWebModule.OutdateLimitCacheFeild)localObject1).b();
              if ((paramString3 == null) || (paramString3.K)) {
                break label802;
              }
              if (!((FastWebModule.OutdateLimitCacheFeild)localObject1).b) {
                break label796;
              }
              break label802;
              if (paramFastWebContentGetCallback != null)
              {
                paramFastWebContentGetCallback.a(true, bool, paramString3);
                PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009C51", "0X8009C51", 0, 0, "", "", "", "", false);
              }
              paramString3 = new StringBuilder();
              paramString3.append("hit cache, rowkey : ");
              paramString3.append(paramString2);
              paramString3.append(", url : ");
              paramString3.append(paramString1);
              paramString3.append(" isUserWeb: ");
              paramString3.append(bool);
              QLog.d("Q.readinjoy.fast_web", 2, paramString3.toString());
              return -1;
            }
          }
        }
        localObject1 = new oidb_cmd0xad6.ReqBody();
        Object localObject2 = new oidb_cmd0xad6.Client();
        ((oidb_cmd0xad6.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
        ((oidb_cmd0xad6.Client)localObject2).uint32_type.set(1);
        ((oidb_cmd0xad6.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
        localObject2 = new oidb_cmd0xad6.ReqArticle();
        if (paramString2 != null) {
          ((oidb_cmd0xad6.ReqArticle)localObject2).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString2));
        }
        if (!TextUtils.isEmpty(paramString1)) {
          ((oidb_cmd0xad6.ReqArticle)localObject2).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
        }
        ((oidb_cmd0xad6.ReqArticle)localObject2).uint32_zip.set(1);
        if (!TextUtils.isEmpty(paramString3)) {
          ((oidb_cmd0xad6.ReqArticle)localObject2).uint64_public_uin.set(Long.valueOf(paramString3).longValue());
        }
        ((oidb_cmd0xad6.ReqArticle)localObject2).uint64_prev_version.set(0L);
        ((oidb_cmd0xad6.ReqBody)localObject1).msg_req_article.set((MessageMicro)localObject2);
        if (paramInt == 1)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
        }
        else if (paramInt == 3)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(0);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(0);
        }
        else if (paramInt == 2)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(0);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
        }
        paramString3 = ReadInJoyOidbHelper.a("OidbSvc.0xad6", 2774, 0, ((oidb_cmd0xad6.ReqBody)localObject1).toByteArray());
        int i = this.b.incrementAndGet();
        long l = b(paramInt);
        paramString3.addAttribute("ad6Seq", Integer.valueOf(i));
        paramString3.addAttribute("ad6ReqTime", Long.valueOf(System.currentTimeMillis()));
        paramString3.addAttribute("uniflag", paramString2);
        paramString3.addAttribute("reqType", Integer.valueOf(paramInt));
        paramString3.setTimeout(l);
        a(Integer.valueOf(i), paramFastWebContentGetCallback);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("send get content req , seq : ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", rowkey : ");
        ((StringBuilder)localObject1).append(paramString2);
        ((StringBuilder)localObject1).append(", oriUrl : ");
        ((StringBuilder)localObject1).append(paramString1);
        ((StringBuilder)localObject1).append(", reqType : ");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(", timeout : ");
        ((StringBuilder)localObject1).append(l);
        QLog.d("Q.readinjoy.fast_web", 2, ((StringBuilder)localObject1).toString());
        sendPbReq(paramString3);
        return i;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString2 = new StringBuilder();
        paramString2.append("send ad6 req error ");
        paramString2.append(paramString1);
        QLog.d("Q.readinjoy.fast_web", 2, paramString2.toString());
        if (paramFastWebContentGetCallback != null) {
          paramFastWebContentGetCallback.a(false, true, null);
        }
        return -1;
      }
      label796:
      boolean bool = false;
      continue;
      label802:
      bool = true;
    }
  }
  
  public Parcelable a(String paramString)
  {
    paramString = (FastWebModule.OutdateLimitCacheFeild)this.d.get(paramString);
    if ((paramString != null) && (!paramString.a())) {
      return (Parcelable)paramString.b();
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    ConcurrentHashMap localConcurrentHashMap = this.c;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void a(@NonNull AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, FeedbackCallback paramFeedbackCallback)
  {
    oidb_cmd0xbd3.ReqBody localReqBody = new oidb_cmd0xbd3.ReqBody();
    oidb_cmd0xbd3.FeedParam localFeedParam = new oidb_cmd0xbd3.FeedParam();
    localFeedParam.feed_type.set(paramAbsBaseArticleInfo.mFeedType);
    localFeedParam.uint64_feed_id.set(paramAbsBaseArticleInfo.mFeedId);
    PBBytesField localPBBytesField = localFeedParam.bytes_subscribe_name;
    String str;
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mSubscribeName)) {
      str = "";
    } else {
      str = paramAbsBaseArticleInfo.mSubscribeName;
    }
    localPBBytesField.set(ByteStringMicro.copyFromUtf8(str));
    localFeedParam.multi_level_info.set(paramAbsBaseArticleInfo.mSocialFeedInfo.n.c());
    localFeedParam.uint64_uin.set(paramAbsBaseArticleInfo.publishUin);
    localFeedParam.uint32_share_type.set(paramInt);
    try
    {
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo.q != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.q.length > 0)) {
        localFeedParam.feed_ext_info.mergeFrom(paramAbsBaseArticleInfo.mSocialFeedInfo.q);
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      QLog.d(a, 2, "req0xbd3ShareJson feed_ext_info exception");
      localInvalidProtocolBufferMicroException.printStackTrace();
    }
    Object localObject = new ArrayList();
    ((List)localObject).add(localFeedParam);
    QLog.d(a, 2, new Object[] { "req0xbd3ShareJson, feed_type = ", Integer.valueOf(localFeedParam.feed_type.get()), "\n", "feed_id = ", Long.valueOf(localFeedParam.uint64_feed_id.get()), "\n", "subscribe_name = ", localFeedParam.bytes_subscribe_name.get().toStringUtf8(), "\n", "uin = ", Long.valueOf(localFeedParam.uint64_uin.get()), "\n", "share_type = ", Integer.valueOf(localFeedParam.uint32_share_type.get()) });
    localReqBody.rpt_feed_param.set((List)localObject);
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0xbd3", 3027, 0, localReqBody.toByteArray());
    int i = this.b.incrementAndGet();
    ((ToServiceMsg)localObject).addAttribute("bd3Seq", Integer.valueOf(i));
    ((ToServiceMsg)localObject).addAttribute("bd3ReqTime", Long.valueOf(System.currentTimeMillis()));
    ((ToServiceMsg)localObject).addAttribute("bd3ShareType", Integer.valueOf(paramInt));
    a(Integer.valueOf(i), paramFeedbackCallback);
    sendPbReq((ToServiceMsg)localObject);
    QLog.d(a, 1, new Object[] { "req0xbd3ShareJson, articleInfo = ", paramAbsBaseArticleInfo, ", seq = ", Integer.valueOf(i), ", shareType = ", Integer.valueOf(paramInt) });
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, boolean paramBoolean)
  {
    a(paramAbsBaseArticleInfo, null, paramFastWebArticleRichReqCallback, paramBoolean);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, FastWebArticleInfo paramFastWebArticleInfo, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback, boolean paramBoolean)
  {
    oidb_cmd0xb54.ReqBody localReqBody = new oidb_cmd0xb54.ReqBody();
    Object localObject1 = new oidb_cmd0xb54.Client();
    ((oidb_cmd0xb54.Client)localObject1).bytes_version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    ((oidb_cmd0xb54.Client)localObject1).uint32_type.set(1);
    localReqBody.msg_client.set((MessageMicro)localObject1);
    localObject1 = new oidb_cmd0xb54.ReqOption();
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_need_fusion_biu_info.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_like_count.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_is_like.set(1);
    if (FastWebSPUtils.a(this.mApp) != 1) {
      ((oidb_cmd0xb54.ReqOption)localObject1).uint32_biu_count.set(1);
    }
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_related_search_size.set(6);
    if (paramBoolean) {
      ((oidb_cmd0xb54.ReqOption)localObject1).uint32_article_business.set(1);
    }
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_need_proteus_json_data.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_need_coin.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject1).uint32_need_share.set(1);
    oidb_cmd0xb54.ReqArticle localReqArticle = new oidb_cmd0xb54.ReqArticle();
    localReqArticle.bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramAbsBaseArticleInfo.innerUniqueID));
    Object localObject2 = (FastWebModule.OutdateLimitCacheFeild)this.e.get(paramAbsBaseArticleInfo.innerUniqueID);
    if (localObject2 != null)
    {
      paramFastWebArticleInfo = (FastWebArticleInfo)((FastWebModule.OutdateLimitCacheFeild)localObject2).b();
      if ((paramFastWebArticleInfo != null) && (!paramFastWebArticleInfo.J.isEmpty()))
      {
        ((oidb_cmd0xb54.ReqOption)localObject1).uint32_style_card.set(1);
        paramFastWebArticleInfo = paramFastWebArticleInfo.J.iterator();
        while (paramFastWebArticleInfo.hasNext())
        {
          localObject2 = (String)paramFastWebArticleInfo.next();
          localReqArticle.rpt_bytes_style_card_id.add(ByteStringMicro.copyFromUtf8((String)localObject2));
        }
      }
    }
    else if (paramFastWebArticleInfo != null)
    {
      this.e.put(paramAbsBaseArticleInfo.innerUniqueID, new FastWebModule.OutdateLimitCacheFeild(this, paramFastWebArticleInfo));
    }
    localReqBody.msg_option.set((MessageMicro)localObject1);
    localReqBody.msg_req_article.set(localReqArticle);
    localReqBody.uint32_topic.set(1);
    paramFastWebArticleInfo = ReadInJoyOidbHelper.a("OidbSvc.0xb54", 2900, 0, localReqBody.toByteArray());
    int i = this.b.incrementAndGet();
    paramFastWebArticleInfo.addAttribute("b54Seq", Integer.valueOf(i));
    paramFastWebArticleInfo.addAttribute("b54ReqTime", Long.valueOf(System.currentTimeMillis()));
    paramFastWebArticleInfo.addAttribute("uniflag", paramAbsBaseArticleInfo.innerUniqueID);
    paramFastWebArticleInfo.addAttribute("rowkey", paramAbsBaseArticleInfo.innerUniqueID);
    paramFastWebArticleInfo.addAttribute("fetchBusiness", Boolean.valueOf(paramBoolean));
    a(Integer.valueOf(i), paramFastWebArticleRichReqCallback);
    sendPbReq(paramFastWebArticleInfo);
    paramFastWebArticleInfo = new StringBuilder();
    paramFastWebArticleInfo.append("req article topic info , rowkey : ");
    paramFastWebArticleInfo.append(paramAbsBaseArticleInfo.innerUniqueID);
    paramFastWebArticleInfo.append(", seq : ");
    paramFastWebArticleInfo.append(i);
    QLog.d("Q.readinjoy.fast_web", 2, paramFastWebArticleInfo.toString());
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, List<BaseData> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramAbsBaseArticleInfo != null))
    {
      if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mArticleContentUrl)) {
        return;
      }
      oidb_cmd0xe7e.ReqBody localReqBody = new oidb_cmd0xe7e.ReqBody();
      RIJPBFieldUtils.b(localReqBody.bytes_qq, RIJQQAppInterfaceUtil.d());
      Object localObject = new oidb_cmd0xe7e.WebInfo();
      RIJPBFieldUtils.b(((oidb_cmd0xe7e.WebInfo)localObject).bytes_url, paramAbsBaseArticleInfo.mArticleContentUrl);
      try
      {
        RIJPBFieldUtils.b(((oidb_cmd0xe7e.WebInfo)localObject).bytes_domain, new URL(paramAbsBaseArticleInfo.mArticleContentUrl).getHost());
      }
      catch (MalformedURLException localMalformedURLException)
      {
        RIJPBFieldUtils.b(((oidb_cmd0xe7e.WebInfo)localObject).bytes_domain, "post.mp.qq.com");
        QLog.e(a, 1, localMalformedURLException, new Object[0]);
      }
      localReqBody.rpt_web_info.set((MessageMicro)localObject);
      RIJPBFieldUtils.b(localReqBody.bytes_rowkey, paramAbsBaseArticleInfo.innerUniqueID);
      localObject = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder(1024);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseData localBaseData = (BaseData)paramList.next();
        paramAbsBaseArticleInfo = null;
        if ((localBaseData instanceof ProteusItemData))
        {
          paramAbsBaseArticleInfo = (ProteusItemData)localBaseData;
          if ((paramAbsBaseArticleInfo.bf != 1) || (paramAbsBaseArticleInfo.bb == null)) {
            continue;
          }
          paramAbsBaseArticleInfo = a(paramAbsBaseArticleInfo);
        }
        else if ((localBaseData instanceof PtsData))
        {
          paramAbsBaseArticleInfo = a((PtsData)localBaseData);
        }
        if (paramAbsBaseArticleInfo != null)
        {
          localStringBuilder.append("item(type:");
          localStringBuilder.append(paramAbsBaseArticleInfo.enum_type.get());
          localStringBuilder.append(") : ");
          localStringBuilder.append(paramAbsBaseArticleInfo.bytes_detail_info.get().toStringUtf8());
          localStringBuilder.append("\n");
          ((ArrayList)localObject).add(paramAbsBaseArticleInfo);
        }
      }
      if (QLog.isColorLevel())
      {
        paramAbsBaseArticleInfo = a;
        paramList = new StringBuilder();
        paramList.append("requestFastWebInsertData : ");
        paramList.append(localStringBuilder.toString());
        QLog.d(paramAbsBaseArticleInfo, 2, paramList.toString());
      }
      localReqBody.rpt_paragraph_info.set((List)localObject);
      sendPbReq(ReadInJoyOidbHelper.a("OidbSvc.0xe7e", 3710, 0, localReqBody.toByteArray()));
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xe7e.RspBody localRspBody = new oidb_cmd0xe7e.RspBody();
    int i = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    if (i != 0)
    {
      paramToServiceMsg = a;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleFastWebInsertDataResp fail , retCode : ");
      paramFromServiceMsg.append(i);
      QLog.d(paramToServiceMsg, 1, paramFromServiceMsg.toString());
      return;
    }
    boolean bool = localRspBody.rpt_insert_module_info.has();
    paramFromServiceMsg = null;
    if (bool) {
      paramToServiceMsg = localRspBody.rpt_insert_module_info.get();
    } else {
      paramToServiceMsg = null;
    }
    if (localRspBody.rpt_text_insert_card_info.has()) {
      paramFromServiceMsg = localRspBody.rpt_text_insert_card_info.get();
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(new FastWebModule.5(this, paramToServiceMsg, paramFromServiceMsg));
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = this.c.entrySet();
    Integer localInteger = null;
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (localEntry.getValue() == paramObject) {
        localInteger = (Integer)localEntry.getKey();
      }
    }
    if (localInteger != null) {
      this.c.remove(localInteger);
    }
  }
  
  public void a(String paramString, Parcelable paramParcelable)
  {
    FastWebModule.OutdateLimitCacheFeild localOutdateLimitCacheFeild = (FastWebModule.OutdateLimitCacheFeild)this.d.get(paramString);
    if (localOutdateLimitCacheFeild == null)
    {
      paramParcelable = new FastWebModule.OutdateLimitCacheFeild(this, paramParcelable);
      this.d.put(paramString, paramParcelable);
      return;
    }
    localOutdateLimitCacheFeild.a(paramParcelable);
  }
  
  public void a(String paramString, FastWebArticleInfo paramFastWebArticleInfo)
  {
    this.e.put(paramString, new FastWebModule.OutdateLimitCacheFeild(this, paramFastWebArticleInfo));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, FastWebModule.FastWebArticleRichReqCallback paramFastWebArticleRichReqCallback)
  {
    oidb_cmd0xad7.ReqBody localReqBody = new oidb_cmd0xad7.ReqBody();
    Object localObject = new oidb_cmd0xad7.Client();
    ((oidb_cmd0xad7.Client)localObject).bytes_version.set(ByteStringMicro.copyFromUtf8("8.8.17"));
    ((oidb_cmd0xad7.Client)localObject).uint32_type.set(1);
    localReqBody.msg_client.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xad7.ReqArticle();
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_article_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramString3));
    try
    {
      ((oidb_cmd0xad7.ReqArticle)localObject).uint64_public_uin.set(Long.valueOf(paramString4).longValue());
    }
    catch (NumberFormatException paramString3)
    {
      paramString3.printStackTrace();
    }
    ((oidb_cmd0xad7.ReqArticle)localObject).uint32_prev_version.set(0);
    localReqBody.msg_req_article.set((MessageMicro)localObject);
    if (paramInt == 72) {
      localReqBody.uint32_friend.set(1);
    } else if (paramInt == 73) {
      localReqBody.uint32_friend.set(1);
    } else if (paramInt == 2) {
      localReqBody.uint32_friend.set(1);
    } else if (paramInt == 3) {
      localReqBody.uint32_qzhone.set(1);
    } else if (paramInt == 12) {
      localReqBody.uint32_weibo.set(1);
    } else if (paramInt == 9) {
      localReqBody.uint32_wechat.set(1);
    } else if (paramInt == 10) {
      localReqBody.uint32_wechat_pyq.set(1);
    }
    paramString3 = ReadInJoyOidbHelper.a("OidbSvc.0xad7", 2775, 0, localReqBody.toByteArray());
    int i = this.b.incrementAndGet();
    paramString3.addAttribute("ad7Seq", Integer.valueOf(i));
    paramString3.addAttribute("ad7ReqTime", Long.valueOf(System.currentTimeMillis()));
    paramString3.addAttribute("ad7Action", Integer.valueOf(paramInt));
    a(Integer.valueOf(i), paramFastWebArticleRichReqCallback);
    sendPbReq(paramString3);
    paramString3 = new StringBuilder();
    paramString3.append("get share Json  articleID : ");
    paramString3.append(paramString2);
    paramString3.append(", oriUrl : ");
    paramString3.append(paramString1);
    paramString3.append(", seq : ");
    paramString3.append(i);
    paramString3.append(", action : ");
    paramString3.append(paramInt);
    QLog.d("Q.readinjoy.fast_web", 2, paramString3.toString());
  }
  
  public void a(String paramString, List<BaseData> paramList)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      this.f.put(paramString, paramList);
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return;
      }
      this.mExecutorService.execute(new FastWebModule.3(this, paramList));
    }
  }
  
  public FastWebArticleInfo b(String paramString)
  {
    paramString = (FastWebModule.OutdateLimitCacheFeild)this.e.get(paramString);
    if (paramString != null) {
      return (FastWebArticleInfo)paramString.b();
    }
    return null;
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("b54Seq")).intValue();
    String str2 = (String)paramToServiceMsg.getAttribute("uniflag");
    System.currentTimeMillis();
    ((Long)paramToServiceMsg.getAttribute("b54ReqTime")).longValue();
    String str1 = (String)paramToServiceMsg.getAttribute("rowkey");
    oidb_cmd0xb54.RspBody localRspBody = new oidb_cmd0xb54.RspBody();
    int j = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (FastWebModule.FastWebArticleRichReqCallback)b(Integer.valueOf(i));
    paramObject = (FastWebModule.OutdateLimitCacheFeild)this.e.get(str2);
    if (paramObject == null) {
      return;
    }
    paramObject = (FastWebArticleInfo)paramObject.b();
    if (j == 0)
    {
      FastWebModuleUtils.a(paramToServiceMsg, localRspBody, paramObject, paramFromServiceMsg, str1);
    }
    else
    {
      paramToServiceMsg = a;
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("oxb54 resp error, code : ");
      paramFromServiceMsg.append(j);
      QLog.d(paramToServiceMsg, 1, paramFromServiceMsg.toString());
    }
    ThreadManager.getUIHandler().post(new FastWebModule.6(this));
  }
  
  public List<BaseData> c(String paramString)
  {
    return b((List)this.f.get(paramString));
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad6"))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad7"))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb54"))
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd3"))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe7e")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.c.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.fastweb.FastWebModule
 * JD-Core Version:    0.7.0.1
 */