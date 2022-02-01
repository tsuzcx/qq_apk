import android.os.Handler;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule.6;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.PtsData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
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

public class ppe
  extends pqj
{
  public static final String a;
  private QQLruCache<String, List<BaseData>> jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache;
  private HashMap<String, ppj<Parcelable>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ConcurrentHashMap<Integer, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private ConcurrentHashMap<String, ppj<FastWebArticleInfo>> b = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaLangString = ppe.class.getSimpleName();
  }
  
  public ppe(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qfo paramqfo, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqfo, paramHandler);
    b();
  }
  
  private long a(int paramInt)
  {
    int i = bjjh.a(null);
    Object localObject = bnrf.f(ozs.a());
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      return 1000L;
      localObject = ((String)localObject).split(",");
    } while (localObject.length != 5);
    if (paramInt == 3) {
      return Long.valueOf(localObject[4]).longValue();
    }
    switch (i)
    {
    default: 
      return 1000L;
    case 1: 
      return Long.valueOf(localObject[0]).longValue();
    case 2: 
      return Long.valueOf(localObject[1]).longValue();
    case 3: 
      return Long.valueOf(localObject[2]).longValue();
    }
    return Long.valueOf(localObject[3]).longValue();
  }
  
  private Object a(Integer paramInteger)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramInteger);
  }
  
  private oidb_cmd0xe7e.ParagraphInfo a(ProteusItemData paramProteusItemData)
  {
    oidb_cmd0xe7e.ParagraphInfo localParagraphInfo = new oidb_cmd0xe7e.ParagraphInfo();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (paramProteusItemData.u == 2)
      {
        localJSONObject.put("url", paramProteusItemData.b());
        localParagraphInfo.enum_type.set(1);
      }
      for (;;)
      {
        localParagraphInfo.bytes_detail_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
        return localParagraphInfo;
        if (paramProteusItemData.u != 3) {
          break;
        }
        localJSONObject.put("vid", paramProteusItemData.a());
        localParagraphInfo.enum_type.set(2);
      }
    }
    catch (JSONException paramProteusItemData)
    {
      for (;;)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, paramProteusItemData, new Object[0]);
        continue;
        if (paramProteusItemData.u == 4)
        {
          localJSONObject.put("type", paramProteusItemData.c());
          localParagraphInfo.enum_type.set(3);
        }
        else
        {
          if (paramProteusItemData.u != 1) {
            break;
          }
          localParagraphInfo.enum_type.set(0);
        }
      }
    }
    return null;
  }
  
  private oidb_cmd0xe7e.ParagraphInfo a(PtsData paramPtsData)
  {
    oidb_cmd0xe7e.ParagraphInfo localParagraphInfo = new oidb_cmd0xe7e.ParagraphInfo();
    localParagraphInfo.enum_type.set(3);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", paramPtsData.jdField_a_of_type_JavaLangString);
      localParagraphInfo.bytes_detail_info.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
      return localParagraphInfo;
    }
    catch (JSONException paramPtsData)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "generateParagraphInfo error : ", paramPtsData);
    }
    return localParagraphInfo;
  }
  
  private void a(Integer paramInteger, Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramInteger, paramObject);
  }
  
  private Object b(Integer paramInteger)
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramInteger);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache = new ppf(this, 2012, 30, 1);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad6Seq")).intValue();
    String str = (String)paramToServiceMsg.getAttribute("uniflag");
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("ad6ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("reqType")).intValue();
    oidb_cmd0xad6.RspBody localRspBody = new oidb_cmd0xad6.RspBody();
    int k = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool1 = false;
    boolean bool2 = false;
    paramToServiceMsg = null;
    if (k == 0)
    {
      bool1 = bool2;
      if (localRspBody.bool_use_webview.has())
      {
        bool1 = bool2;
        if (localRspBody.bool_use_webview.get()) {
          bool1 = true;
        }
      }
      paramToServiceMsg = new FastWebArticleInfo();
      boolean bool3 = paramToServiceMsg.a(localRspBody, j);
      bool2 = bool1;
      bool1 = bool3;
    }
    for (;;)
    {
      paramFromServiceMsg = (ppi)a(Integer.valueOf(i));
      if (paramFromServiceMsg != null)
      {
        QLog.d("Q.readinjoy.fast_web", 2, "callback  result : " + bool1 + ", seq : " + i + ", useWebView : " + bool2 + ", cost : " + l + ", retCode : " + k + ", native info : " + paramToServiceMsg + "  callback : " + paramFromServiceMsg);
        ThreadManager.getUIHandler().post(new FastWebModule.1(this, paramFromServiceMsg, bool1, bool2, paramToServiceMsg));
      }
      QLog.d("Q.readinjoy.fast_web", 2, "ad6 resp  result : " + bool1 + ", seq : " + i + ", useWebView : " + bool2 + ", cost : " + l + ", retCode : " + k + ", native info : " + paramToServiceMsg);
      if (str != null)
      {
        if ((j != 1) && ((j != 3) || (!bool1))) {
          break label534;
        }
        this.b.put(str, new ppj(this, paramToServiceMsg));
      }
      for (;;)
      {
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("which", "2");
        paramToServiceMsg.put("reqType", String.valueOf(j));
        paramToServiceMsg.put("param_uin", ozs.a());
        paramToServiceMsg.put("param_retCode", k + "");
        paramToServiceMsg.put("param_succ", String.valueOf(bool1));
        paramToServiceMsg.put("param_netType", bjjh.a(null) + "");
        bdmc.a(BaseApplicationImpl.getApplication()).a(null, "actKandianFastWebCost", bool1, l, 0L, paramToServiceMsg, null);
        return;
        label534:
        if ((paramToServiceMsg != null) && (this.b.containsKey(str)))
        {
          paramFromServiceMsg = (ppj)this.b.get(str);
          ((FastWebArticleInfo)paramFromServiceMsg.a()).a(paramToServiceMsg.b, paramToServiceMsg.a);
          paramFromServiceMsg.a(paramFromServiceMsg.a());
        }
      }
      bool2 = false;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("ad7Seq")).intValue();
    long l1 = System.currentTimeMillis();
    long l2 = ((Long)paramToServiceMsg.getAttribute("ad7ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("ad7Action")).intValue();
    paramToServiceMsg = new oidb_cmd0xad7.RspBody();
    int k = qfq.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ssh();
    boolean bool;
    if ((k == 0) && (paramToServiceMsg.msg_rsp_share.has()))
    {
      bool = true;
      paramToServiceMsg = (oidb_cmd0xad7.RspShare)paramToServiceMsg.msg_rsp_share.get();
      paramFromServiceMsg.b = paramToServiceMsg.bytes_wechat_pyq.get().toStringUtf8();
      paramFromServiceMsg.jdField_a_of_type_JavaLangString = paramToServiceMsg.bytes_weibo.get().toStringUtf8();
      paramFromServiceMsg.d = paramToServiceMsg.bytes_friend.get().toStringUtf8();
      paramFromServiceMsg.c = paramToServiceMsg.bytes_wechat.get().toStringUtf8();
      paramFromServiceMsg.e = paramToServiceMsg.bytes_qzhone.get().toStringUtf8();
    }
    for (;;)
    {
      paramToServiceMsg = (pph)a(Integer.valueOf(i));
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(bool, j, paramFromServiceMsg);
      }
      QLog.d("Q.readinjoy.fast_web", 2, "handle ad7rsp , succ " + bool + ", retCode : " + k + ", seq : " + i + ", cost : " + (l1 - l2) + "\n" + paramFromServiceMsg);
      return;
      bool = false;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("bd3Seq")).intValue();
    long l = System.currentTimeMillis() - ((Long)paramToServiceMsg.getAttribute("bd3ReqTime")).longValue();
    int j = ((Integer)paramToServiceMsg.getAttribute("bd3ShareType")).intValue();
    oidb_cmd0xbd3.RspBody localRspBody = new oidb_cmd0xbd3.RspBody();
    int k = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (syn)a(Integer.valueOf(i));
    paramToServiceMsg = "";
    if ((k == 0) && (localRspBody.rpt_share_info.has()) && (localRspBody.rpt_share_info.get() != null) && (localRspBody.rpt_share_info.get().size() > 0))
    {
      paramToServiceMsg = (oidb_cmd0xbd3.ShareInfo)localRspBody.rpt_share_info.get().get(0);
      if (paramToServiceMsg.bytes_share_json.has()) {
        paramToServiceMsg = paramToServiceMsg.bytes_share_json.get().toStringUtf8();
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (paramFromServiceMsg != null) {
        ThreadManager.getUIHandler().post(new FastWebModule.2(this, paramFromServiceMsg, bool, j, paramToServiceMsg));
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "handle0xbd3Resp, retCode = ", Integer.valueOf(k), ", success= ", Boolean.valueOf(bool), ", cost = ", Long.valueOf(l), ", shareJson = ", paramToServiceMsg });
      ozs.a(ozs.a(), bool, l, k);
      return;
      paramToServiceMsg = "";
      break;
    }
  }
  
  public int a(String paramString1, String paramString2, String paramString3, int paramInt, ppi paramppi)
  {
    for (;;)
    {
      Object localObject1;
      try
      {
        QLog.d("Q.readinjoy.fast_web", 1, "getArticleContent, rowkey : " + paramString2 + ", url : " + paramString1 + " callback: " + paramppi + ", reqType : " + paramInt);
        if ((paramInt != 2) && (paramString2 != null))
        {
          localObject1 = (ppj)this.b.get(paramString2);
          if (localObject1 != null)
          {
            if (!((ppj)localObject1).a()) {
              continue;
            }
            this.b.remove(paramString2);
          }
        }
        localObject1 = new oidb_cmd0xad6.ReqBody();
        Object localObject2 = new oidb_cmd0xad6.Client();
        ((oidb_cmd0xad6.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("8.4.5"));
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
          paramString3 = qfq.a("OidbSvc.0xad6", 2774, 0, ((oidb_cmd0xad6.ReqBody)localObject1).toByteArray());
          int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
          long l = a(paramInt);
          paramString3.addAttribute("ad6Seq", Integer.valueOf(i));
          paramString3.addAttribute("ad6ReqTime", Long.valueOf(System.currentTimeMillis()));
          paramString3.addAttribute("uniflag", paramString2);
          paramString3.addAttribute("reqType", Integer.valueOf(paramInt));
          paramString3.setTimeout(l);
          a(Integer.valueOf(i), paramppi);
          QLog.d("Q.readinjoy.fast_web", 2, "send get content req , seq : " + i + ", rowkey : " + paramString2 + ", oriUrl : " + paramString1 + ", reqType : " + paramInt + ", timeout : " + l);
          a(paramString3);
          return i;
          if (paramppi != null)
          {
            paramppi.a(true, ((ppj)localObject1).a, (FastWebArticleInfo)((ppj)localObject1).a());
            ocd.a(null, "CliOper", "", "", "0X8009C51", "0X8009C51", 0, 0, "", "", "", "", false);
          }
          QLog.d("Q.readinjoy.fast_web", 2, "hit cache, rowkey : " + paramString2 + ", url : " + paramString1 + " isUserWeb " + ((ppj)localObject1).a);
          return -1;
        }
        if (paramInt == 3)
        {
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(1);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(0);
          ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(0);
          continue;
        }
        if (paramInt != 2) {
          continue;
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        QLog.d("Q.readinjoy.fast_web", 2, "send ad6 req error " + paramString1);
        if (paramppi != null) {
          paramppi.a(false, true, null);
        }
        return -1;
      }
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_article.set(0);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_comment.set(1);
      ((oidb_cmd0xad6.ReqBody)localObject1).uint32_read_count.set(1);
    }
  }
  
  public Parcelable a(String paramString)
  {
    paramString = (ppj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((paramString == null) || (paramString.a())) {
      return null;
    }
    return (Parcelable)paramString.a();
  }
  
  public FastWebArticleInfo a(String paramString)
  {
    paramString = (ppj)this.b.get(paramString);
    if (paramString != null) {
      return (FastWebArticleInfo)paramString.a();
    }
    return null;
  }
  
  public List<BaseData> a(String paramString)
  {
    return sst.a((List)this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.get(paramString));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(@NonNull ArticleInfo paramArticleInfo, int paramInt, syn paramsyn)
  {
    oidb_cmd0xbd3.ReqBody localReqBody = new oidb_cmd0xbd3.ReqBody();
    oidb_cmd0xbd3.FeedParam localFeedParam = new oidb_cmd0xbd3.FeedParam();
    localFeedParam.feed_type.set(paramArticleInfo.mFeedType);
    localFeedParam.uint64_feed_id.set(paramArticleInfo.mFeedId);
    PBBytesField localPBBytesField = localFeedParam.bytes_subscribe_name;
    Object localObject;
    if (TextUtils.isEmpty(paramArticleInfo.mSubscribeName)) {
      localObject = "";
    }
    for (;;)
    {
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localFeedParam.multi_level_info.set(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxr.a());
      localFeedParam.uint64_uin.set(paramArticleInfo.publishUin);
      localFeedParam.uint32_share_type.set(paramInt);
      try
      {
        if ((paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ArrayOfByte != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ArrayOfByte.length > 0)) {
          localFeedParam.feed_ext_info.mergeFrom(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ArrayOfByte);
        }
        localObject = new ArrayList();
        ((List)localObject).add(localFeedParam);
        QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "req0xbd3ShareJson, feed_type = ", Integer.valueOf(localFeedParam.feed_type.get()), "\n", "feed_id = ", Long.valueOf(localFeedParam.uint64_feed_id.get()), "\n", "subscribe_name = ", localFeedParam.bytes_subscribe_name.get().toStringUtf8(), "\n", "uin = ", Long.valueOf(localFeedParam.uint64_uin.get()), "\n", "share_type = ", Integer.valueOf(localFeedParam.uint32_share_type.get()) });
        localReqBody.rpt_feed_param.set((List)localObject);
        localObject = qfq.a("OidbSvc.0xbd3", 3027, 0, localReqBody.toByteArray());
        int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        ((ToServiceMsg)localObject).addAttribute("bd3Seq", Integer.valueOf(i));
        ((ToServiceMsg)localObject).addAttribute("bd3ReqTime", Long.valueOf(System.currentTimeMillis()));
        ((ToServiceMsg)localObject).addAttribute("bd3ShareType", Integer.valueOf(paramInt));
        a(Integer.valueOf(i), paramsyn);
        a((ToServiceMsg)localObject);
        QLog.d(jdField_a_of_type_JavaLangString, 1, new Object[] { "req0xbd3ShareJson, articleInfo = ", paramArticleInfo, ", seq = ", Integer.valueOf(i), ", shareType = ", Integer.valueOf(paramInt) });
        return;
        localObject = paramArticleInfo.mSubscribeName;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "req0xbd3ShareJson feed_ext_info exception");
          localInvalidProtocolBufferMicroException.printStackTrace();
        }
      }
    }
  }
  
  public void a(ArticleInfo paramArticleInfo, pph parampph, boolean paramBoolean)
  {
    Object localObject1 = new oidb_cmd0xb54.ReqBody();
    Object localObject2 = new oidb_cmd0xb54.Client();
    ((oidb_cmd0xb54.Client)localObject2).bytes_version.set(ByteStringMicro.copyFromUtf8("8.4.5"));
    ((oidb_cmd0xb54.Client)localObject2).uint32_type.set(1);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_client.set((MessageMicro)localObject2);
    localObject2 = new oidb_cmd0xb54.ReqOption();
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_need_fusion_biu_info.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_like_count.set(1);
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_is_like.set(1);
    if (bnrf.m(this.jdField_a_of_type_ComTencentCommonAppAppInterface) != 1) {
      ((oidb_cmd0xb54.ReqOption)localObject2).uint32_biu_count.set(1);
    }
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_related_search_size.set(6);
    if (paramBoolean) {
      ((oidb_cmd0xb54.ReqOption)localObject2).uint32_article_business.set(1);
    }
    ((oidb_cmd0xb54.ReqOption)localObject2).uint32_need_proteus_json_data.set(1);
    oidb_cmd0xb54.ReqArticle localReqArticle = new oidb_cmd0xb54.ReqArticle();
    localReqArticle.bytes_row_key.set(ByteStringMicro.copyFromUtf8(paramArticleInfo.innerUniqueID));
    Object localObject3 = (ppj)this.b.get(paramArticleInfo.innerUniqueID);
    if (localObject3 != null)
    {
      localObject3 = (FastWebArticleInfo)((ppj)localObject3).a();
      if ((localObject3 != null) && (!((FastWebArticleInfo)localObject3).a().isEmpty()))
      {
        ((oidb_cmd0xb54.ReqOption)localObject2).uint32_style_card.set(1);
        localObject3 = ((FastWebArticleInfo)localObject3).a().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          localReqArticle.rpt_bytes_style_card_id.add(ByteStringMicro.copyFromUtf8(str));
        }
      }
    }
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_option.set((MessageMicro)localObject2);
    ((oidb_cmd0xb54.ReqBody)localObject1).msg_req_article.set(localReqArticle);
    ((oidb_cmd0xb54.ReqBody)localObject1).uint32_topic.set(1);
    localObject1 = qfq.a("OidbSvc.0xb54", 2900, 0, ((oidb_cmd0xb54.ReqBody)localObject1).toByteArray());
    int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    ((ToServiceMsg)localObject1).addAttribute("b54Seq", Integer.valueOf(i));
    ((ToServiceMsg)localObject1).addAttribute("b54ReqTime", Long.valueOf(System.currentTimeMillis()));
    ((ToServiceMsg)localObject1).addAttribute("uniflag", paramArticleInfo.innerUniqueID);
    ((ToServiceMsg)localObject1).addAttribute("rowkey", paramArticleInfo.innerUniqueID);
    ((ToServiceMsg)localObject1).addAttribute("fetchBusiness", Boolean.valueOf(paramBoolean));
    a(Integer.valueOf(i), parampph);
    a((ToServiceMsg)localObject1);
    QLog.d("Q.readinjoy.fast_web", 2, "req article topic info , rowkey : " + paramArticleInfo.innerUniqueID + ", seq : " + i);
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo, List<BaseData> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()) || (paramBaseArticleInfo == null) || (TextUtils.isEmpty(paramBaseArticleInfo.mArticleContentUrl))) {
      return;
    }
    oidb_cmd0xe7e.ReqBody localReqBody = new oidb_cmd0xe7e.ReqBody();
    qfm.a(localReqBody.bytes_qq, ozs.a());
    Object localObject = new oidb_cmd0xe7e.WebInfo();
    qfm.a(((oidb_cmd0xe7e.WebInfo)localObject).bytes_url, paramBaseArticleInfo.mArticleContentUrl);
    try
    {
      qfm.a(((oidb_cmd0xe7e.WebInfo)localObject).bytes_domain, new URL(paramBaseArticleInfo.mArticleContentUrl).getHost());
      localReqBody.rpt_web_info.set((MessageMicro)localObject);
      qfm.a(localReqBody.bytes_rowkey, paramBaseArticleInfo.innerUniqueID);
      localObject = new ArrayList();
      StringBuilder localStringBuilder = new StringBuilder(1024);
      paramList = paramList.iterator();
      for (;;)
      {
        if (!paramList.hasNext()) {
          break label295;
        }
        paramBaseArticleInfo = (BaseData)paramList.next();
        if (!(paramBaseArticleInfo instanceof ProteusItemData)) {
          break;
        }
        paramBaseArticleInfo = (ProteusItemData)paramBaseArticleInfo;
        if ((paramBaseArticleInfo.v == 1) && (paramBaseArticleInfo.c != null))
        {
          paramBaseArticleInfo = a(paramBaseArticleInfo);
          if (paramBaseArticleInfo != null)
          {
            localStringBuilder.append("item(type:").append(paramBaseArticleInfo.enum_type.get()).append(") : ").append(paramBaseArticleInfo.bytes_detail_info.get().toStringUtf8()).append("\n");
            ((ArrayList)localObject).add(paramBaseArticleInfo);
          }
        }
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        qfm.a(((oidb_cmd0xe7e.WebInfo)localObject).bytes_domain, "post.mp.qq.com");
        QLog.e(jdField_a_of_type_JavaLangString, 1, localMalformedURLException, new Object[0]);
        continue;
        if ((paramBaseArticleInfo instanceof PtsData))
        {
          paramBaseArticleInfo = a((PtsData)paramBaseArticleInfo);
          continue;
          label295:
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "requestFastWebInsertData : " + localMalformedURLException.toString());
          }
          localReqBody.rpt_paragraph_info.set((List)localObject);
          a(qfq.a("OidbSvc.0xe7e", 3710, 0, localReqBody.toByteArray()));
        }
        else
        {
          paramBaseArticleInfo = null;
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad6")) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xad7"))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb54"))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd3"))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xe7e"));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(Object paramObject)
  {
    if (paramObject == null) {}
    label81:
    label82:
    for (;;)
    {
      return;
      Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet();
      Integer localInteger = null;
      localObject = ((Set)localObject).iterator();
      if (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        if (localEntry.getValue() != paramObject) {
          break label81;
        }
        localInteger = (Integer)localEntry.getKey();
      }
      for (;;)
      {
        break;
        if (localInteger == null) {
          break label82;
        }
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localInteger);
        return;
      }
    }
  }
  
  public void a(String paramString, Parcelable paramParcelable)
  {
    ppj localppj = (ppj)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localppj == null)
    {
      paramParcelable = new ppj(this, paramParcelable);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramParcelable);
      return;
    }
    localppj.a(paramParcelable);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, pph parampph)
  {
    oidb_cmd0xad7.ReqBody localReqBody = new oidb_cmd0xad7.ReqBody();
    Object localObject = new oidb_cmd0xad7.Client();
    ((oidb_cmd0xad7.Client)localObject).bytes_version.set(ByteStringMicro.copyFromUtf8("8.4.5"));
    ((oidb_cmd0xad7.Client)localObject).uint32_type.set(1);
    localReqBody.msg_client.set((MessageMicro)localObject);
    localObject = new oidb_cmd0xad7.ReqArticle();
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_article_id.set(ByteStringMicro.copyFromUtf8(paramString2));
    ((oidb_cmd0xad7.ReqArticle)localObject).bytes_url.set(ByteStringMicro.copyFromUtf8(paramString1));
    try
    {
      ((oidb_cmd0xad7.ReqArticle)localObject).uint64_public_uin.set(Long.valueOf(paramString3).longValue());
      ((oidb_cmd0xad7.ReqArticle)localObject).uint32_prev_version.set(0);
      localReqBody.msg_req_article.set((MessageMicro)localObject);
      if (paramInt == 72)
      {
        localReqBody.uint32_friend.set(1);
        paramString3 = qfq.a("OidbSvc.0xad7", 2775, 0, localReqBody.toByteArray());
        int i = this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
        paramString3.addAttribute("ad7Seq", Integer.valueOf(i));
        paramString3.addAttribute("ad7ReqTime", Long.valueOf(System.currentTimeMillis()));
        paramString3.addAttribute("ad7Action", Integer.valueOf(paramInt));
        a(Integer.valueOf(i), parampph);
        a(paramString3);
        QLog.d("Q.readinjoy.fast_web", 2, "get share Json  articleID : " + paramString2 + ", oriUrl : " + paramString1 + ", seq : " + i + ", action : " + paramInt);
        return;
      }
    }
    catch (NumberFormatException paramString3)
    {
      for (;;)
      {
        paramString3.printStackTrace();
        continue;
        if (paramInt == 73) {
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
      }
    }
  }
  
  public void a(String paramString, List<BaseData> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentCommonsdkCacheQQLruCache.put(paramString, paramList);
  }
  
  public void a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new FastWebModule.3(this, paramList));
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = null;
    oidb_cmd0xe7e.RspBody localRspBody = new oidb_cmd0xe7e.RspBody();
    int i = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    if (i != 0)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "handleFastWebInsertDataResp fail , retCode : " + i);
      return;
    }
    if (localRspBody.rpt_insert_module_info.has()) {}
    for (paramToServiceMsg = localRspBody.rpt_insert_module_info.get();; paramToServiceMsg = null)
    {
      paramFromServiceMsg = localObject;
      if (localRspBody.rpt_text_insert_card_info.has()) {
        paramFromServiceMsg = localRspBody.rpt_text_insert_card_info.get();
      }
      pfd.a().a(new ppg(this, paramToServiceMsg, paramFromServiceMsg));
      return;
    }
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = ((Integer)paramToServiceMsg.getAttribute("b54Seq")).intValue();
    String str2 = (String)paramToServiceMsg.getAttribute("uniflag");
    System.currentTimeMillis();
    ((Long)paramToServiceMsg.getAttribute("b54ReqTime")).longValue();
    String str1 = (String)paramToServiceMsg.getAttribute("rowkey");
    oidb_cmd0xb54.RspBody localRspBody = new oidb_cmd0xb54.RspBody();
    int j = qfq.a(paramFromServiceMsg, paramObject, localRspBody);
    paramFromServiceMsg = (pph)b(Integer.valueOf(i));
    paramObject = (ppj)this.b.get(str2);
    if (paramObject == null) {
      return;
    }
    paramObject = (FastWebArticleInfo)paramObject.a();
    if (j == 0)
    {
      ppk.a(localRspBody, paramObject, paramFromServiceMsg, str1);
      ppk.b(localRspBody, paramObject, paramFromServiceMsg, str1);
      ppk.a(localRspBody, paramObject, paramFromServiceMsg);
      ppk.c(localRspBody, paramObject, paramFromServiceMsg, str1);
      ppk.a(localRspBody, paramObject);
      if (((Boolean)paramToServiceMsg.getAttribute("fetchBusiness", Boolean.valueOf(false))).booleanValue()) {
        ppk.b(localRspBody, paramObject, paramFromServiceMsg);
      }
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new FastWebModule.6(this));
      return;
      QLog.d("Q.readinjoy.fast_web", 2, "oxb54 resp error, code : " + j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ppe
 * JD-Core Version:    0.7.0.1
 */