import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.im.oidb.articlesummary.articlesummary.AdInfo;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;
import tencent.im.oidb.articlesummary.articlesummary.FeedsInfo;
import tencent.im.oidb.articlesummary.articlesummary.PosAdInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdPosMap;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.AdReqInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PhoneInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x886.oidb_cmd0x886.RspBody;

public class pes
  extends pgp
{
  public static int a;
  public static int b;
  public static int c;
  private final long jdField_a_of_type_Long = 86400000L;
  private LinkedHashMap<Integer, Long> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ArrayBlockingQueue<AdvertisementInfo> jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
  private ConcurrentHashMap<Integer, WeakReference<pfu>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, Long> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ArrayBlockingQueue<AdvertisementInfo> jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue = new ArrayBlockingQueue(10);
  private ConcurrentHashMap<Integer, HashSet<String>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> c;
  private LinkedHashMap<Integer, Pair<Integer, Integer>> d;
  private LinkedHashMap<Integer, Boolean> e = new LinkedHashMap();
  
  static
  {
    jdField_a_of_type_Int = 15;
    jdField_b_of_type_Int = 10;
    jdField_c_of_type_Int = 10;
  }
  
  public pes(AppInterface paramAppInterface, awbw paramawbw, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawbw, paramExecutorService, parampuz, paramHandler);
    this.jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_d_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
  {
    switch (bdee.a(BaseApplication.getContext()))
    {
    case 0: 
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 3;
    }
    return 4;
  }
  
  private int a(int paramInt)
  {
    int i = 1;
    Object localObject1 = new ArrayList();
    Object localObject2 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    paramInt = i;
    if (localObject2 != null)
    {
      paramInt = i;
      if (((ConcurrentHashMap)localObject2).size() > 0)
      {
        localObject2 = ((ConcurrentHashMap)localObject2).values().iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((ArrayList)localObject1).add((AdvertisementInfo)((Iterator)localObject2).next());
        }
        Collections.sort((List)localObject1, new peu(this));
        localObject1 = (AdvertisementInfo)((ArrayList)localObject1).get(0);
        paramInt = i;
        if (localObject1 != null)
        {
          paramInt = i;
          if (((AdvertisementInfo)localObject1).mAdKdPos <= 100) {
            if (!((AdvertisementInfo)localObject1).hasAddExposure) {
              break label132;
            }
          }
        }
      }
    }
    label132:
    for (paramInt = 1;; paramInt = 2) {
      return paramInt;
    }
  }
  
  private boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {}
    while ((TextUtils.isEmpty(paramAdvertisementInfo.mTitle)) || ((!TextUtils.isEmpty(paramAdvertisementInfo.mJsonVideoList)) && ((TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage)) || (TextUtils.isEmpty(paramAdvertisementInfo.mSubscribeName)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdVideoUrl))))) {
      return true;
    }
    return false;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int j = 0;
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    int i = pvb.a(paramFromServiceMsg, paramObject, localRspBody);
    int m = ((Integer)paramToServiceMsg.getAttribute(h, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + m);
    }
    int k = ((Integer)paramToServiceMsg.getAttribute(i, Integer.valueOf(0))).intValue();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! result=" + i + ",repeatedreqFlag=" + m);
    }
    if (i == 0) {
      if (!localRspBody.uint64_uin.has()) {
        break label572;
      }
    }
    label569:
    label572:
    for (long l = localRspBody.uint64_uin.get();; l = -1L)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        i = (int)paramFromServiceMsg.uint64_channel_id.get();
        if ((i != 0) || (k == 0)) {
          break label569;
        }
        i = k;
      }
      for (;;)
      {
        if ((paramFromServiceMsg.rpt_advertise_list.has()) && (paramFromServiceMsg.rpt_advertise_list.get() != null)) {
          a(paramToServiceMsg, paramFromServiceMsg, m, k, false);
        }
        for (;;)
        {
          oek.a().c(true);
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) && (j == 0))
          {
            paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
            {
              QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList listener = " + paramToServiceMsg.toString());
              ((pfu)paramToServiceMsg.get()).a(i);
            }
          }
          return;
          if (m == 1)
          {
            if (QLog.isColorLevel()) {
              QLog.d("AdvertisementInfoModule", 2, "handle0x68bGetAdvertisementList! 重复曝光加载数据返回空");
            }
            j = 1;
          }
        }
        j = ((Integer)paramToServiceMsg.getAttribute(f)).intValue();
        QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList Error result = " + i + " requestCount = " + j);
        if ((i == 154) && (j == 1))
        {
          paramToServiceMsg.getAttributes().put(f, Integer.valueOf(2));
          a(paramToServiceMsg);
          return;
        }
        paramToServiceMsg = new JSONObject();
        try
        {
          paramToServiceMsg.put("svrresp_result", 1);
          paramToServiceMsg.put("svrresp_fail_type", 2);
          paramToServiceMsg.put("svrresp_fail_code", i);
          noy.a(new obk().a(BaseApplication.getContext()).a(noy.k).b(noy.S).b(paramToServiceMsg).a());
          return;
        }
        catch (JSONException paramFromServiceMsg)
        {
          for (;;)
          {
            paramFromServiceMsg.printStackTrace();
          }
        }
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "handle0x886AdvertisementReportResp!");
    }
    int i = pvb.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
    if (i != 0)
    {
      int j = ((Integer)paramToServiceMsg.getAttribute(g)).intValue();
      if ((i == 154) && (j == 1))
      {
        paramToServiceMsg.getAttributes().put(g, Integer.valueOf(2));
        a(paramToServiceMsg);
      }
    }
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    return (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getPreloadAdvertisementAtPostion postion = " + paramInt2);
    }
    if (!a(paramInt1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "   !needRequestAdvertisement ");
      }
      return null;
    }
    Pair localPair = (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localPair != null)
    {
      if (paramInt2 + jdField_c_of_type_Int <= ((Integer)localPair.second).intValue()) {
        return null;
      }
      int i = ((Integer)localPair.second).intValue();
      int j = jdField_b_of_type_Int + i;
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "first = " + localPair.first + " second = " + localPair.second);
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "async getPreloadAdvertisementAtPostion channelid=" + paramInt1 + "  position=" + paramInt2 + "  startpos=" + i + "  endpos=" + j);
      }
      return new Pair(Integer.valueOf(i), Integer.valueOf(j));
    }
    return null;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localConcurrentHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      }
      return null;
    }
    return (AdvertisementInfo)localConcurrentHashMap.get(Integer.valueOf(paramInt2));
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPosArticleListSync channelId=" + paramInt);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(b(paramInt));
    return localArrayList;
  }
  
  public ArrayBlockingQueue<AdvertisementInfo> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(pve parampve, int paramInt1, int paramInt2, int paramInt3, int paramInt4, nnv paramnnv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt1);
    }
    Object localObject1 = new aaop();
    ((aaop)localObject1).a = "ce2d9f";
    Object localObject3 = aaoo.a(BaseApplication.getContext(), (aaop)localObject1);
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara;
    Object localObject2;
    long l;
    if (localObject3 != null)
    {
      localObject1 = ((aaoq)localObject3).a;
      localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(paramInt1, true);
      localObject2 = localReqAdvertisePara.uint64_last_time;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
        break label1088;
      }
      l = 0L;
      label115:
      ((PBUInt64Field)localObject2).set(l, true);
      localObject2 = new oidb_cmd0x68b.PhoneInfo();
      if ((localObject3 != null) && (((aaoq)localObject3).a != null) && (((aaoq)localObject3).a.muid != null) && (((aaoq)localObject3).a.muid_type != null))
      {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_muid.set(ByteStringMicro.copyFromUtf8(((aaoq)localObject3).a.muid.get()));
        ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_muid_type.set(((aaoq)localObject3).a.muid_type.get());
      }
      localObject3 = ods.b();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_imei.set((String)localObject3);
      }
      i = nmh.a();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_conn.set(i);
      i = 0;
    }
    try
    {
      int j = bdcb.e();
      i = j;
    }
    catch (Exception localException)
    {
      label258:
      break label258;
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
    localObject3 = bdcb.e();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    localObject3 = bdcb.c();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    int i = AppSetting.a();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    localObject3 = dr.a(dr.a());
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_os_type.set(2);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint64_func_flag.set(1L);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(noy.a()));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_manufacturer.set(ByteStringMicro.copyFromUtf8(Build.BRAND));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(Build.MODEL));
    if (localObject1 != null)
    {
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_qadid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).qadid.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_androidid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_android_id.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_mac.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).md5_mac.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_oaid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).aid_ticket.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_taid.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).taid_ticket.get());
      }
      if (((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.has()) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_client_ipv4.set(((qq_ad_get.QQAdGet.DeviceInfo)localObject1).client_ipv4.get());
      }
      if (QLog.isColorLevel()) {
        QLog.i("AdvertisementInfoModule", 2, "makeReqAdvertisePara: deviceInfo: ma=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_androidid.get() + ", mm=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_mac.get() + ", oa=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_oaid.get() + ", ta=" + ((oidb_cmd0x68b.PhoneInfo)localObject2).string_taid.get());
      }
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(ods.a(BaseApplication.getContext()).getBytes()));
    localReqAdvertisePara.msg_phone_info.set((MessageMicro)localObject2, true);
    if (paramInt3 != paramInt4) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("adPosType", paramInt2);
        ((JSONObject)localObject1).put("adStartPos", paramInt3);
        ((JSONObject)localObject1).put("adEndPos", paramInt4);
        if ((paramnnv != null) && (paramnnv.a()))
        {
          ((JSONObject)localObject1).put("MaterialId", paramnnv.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("RepeatedReqFlag", paramnnv.jdField_b_of_type_Int);
          ((JSONObject)localObject1).put("KdPos", paramnnv.jdField_c_of_type_Int);
          ((JSONObject)localObject1).put("adPosId", paramnnv.jdField_a_of_type_Long);
        }
        if (!piy.b(parampve)) {
          continue;
        }
        ((JSONObject)localObject1).put("adRequestFlag", a(paramInt1));
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
          continue;
        }
        l = 0L;
        ((JSONObject)localObject1).put("lastRefreshTime", l);
        if ((oek.a().a()) && (paramInt2 == 1) && (oek.a().a().size() > 0))
        {
          ((JSONObject)localObject1).put("superMaskType", 2);
          ((JSONObject)localObject1).put("reqList", new JSONArray(oek.a().a()));
          oek.a().b(false);
          oek.a().c(false);
        }
        if ((paramInt2 == 7) && (paramnnv != null))
        {
          ((JSONObject)localObject1).put("videoPatchAdFlag", paramnnv.d);
          ((JSONObject)localObject1).put("prePatchAdCount", paramnnv.e);
          ((JSONObject)localObject1).put("postPatchAdCount", paramnnv.f);
        }
        if (azwu.a()) {
          ((JSONObject)localObject1).put("reqLearningPatternFlag", 1);
        }
        localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "async makeReqAdvertisePara adinfo," + ((JSONObject)localObject1).toString());
        }
      }
      catch (JSONException parampve)
      {
        label1088:
        parampve.printStackTrace();
        continue;
      }
      parampve = new oidb_cmd0x68b.AdReqInfo();
      parampve.uint64_ad_channel_id.set(paramInt1);
      localReqAdvertisePara.msg_ad_req_info.set(parampve);
      return localReqAdvertisePara;
      localObject1 = null;
      break;
      l = ((Long)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
      break label115;
      l = ((Long)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1))).longValue();
      continue;
      ((JSONObject)localObject1).put("adRequestFlag", 0);
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitialize!");
    }
    this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "removeFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Integer.valueOf(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    Pair localPair = (Pair)this.jdField_d_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localPair == null) {
      localPair = new Pair(Integer.valueOf(0), Integer.valueOf(0));
    }
    for (;;)
    {
      int i = paramInt3;
      if (paramInt2 != 0)
      {
        i = paramInt3;
        if (paramInt3 < ((Integer)localPair.second).intValue()) {
          i = ((Integer)localPair.second).intValue();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "async setLocalAdvertisementRange channelid=" + paramInt1 + "  adStart=" + paramInt2 + "  adEnd=" + i);
      }
      localPair = new Pair(Integer.valueOf(paramInt2), Integer.valueOf(i));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.remove(Integer.valueOf(paramInt1));
      this.jdField_d_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt1), localPair);
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nnv paramnnv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " adPosType = " + paramInt2 + " adStart = " + paramInt3 + " adEnd = " + paramInt4);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " not contained in mChannelID2FixPosArticleAsyncListener");
      peo.a().a(paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((WeakReference)localObject).get() == null))
      {
        QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " listener is null");
        peo.a().a(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(ors.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.req_advertise_para.set(a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramnnv));
    Object localObject = pvb.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
    if ((paramnnv != null) && (paramnnv.jdField_b_of_type_Int == 1))
    {
      ((ToServiceMsg)localObject).getAttributes().put(h, Integer.valueOf(paramnnv.jdField_b_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(0));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
      if (!otf.c(paramInt1))
      {
        paramnnv = (nnv)localObject;
        if (!bjxj.a(paramInt1)) {}
      }
      else
      {
        localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(sgc.a("default_feeds")));
        paramnnv = (nnv)localObject;
        if (bjxj.w())
        {
          paramnnv = pgj.a(paramInt1);
          if (!TextUtils.isEmpty(paramnnv)) {
            localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramnnv));
          }
          paramnnv = pvb.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
          paramnnv.getAttributes().put("realTimeServiceKey", "default_feeds");
          paramnnv.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
        }
      }
      if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        paramnnv.getAttributes().put(i, Integer.valueOf(paramInt1));
        paramnnv.getAttributes().put(f, Integer.valueOf(0));
      }
      a(paramnnv);
      nrt.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
      return;
      ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(1));
    }
  }
  
  public void a(int paramInt, pfu parampfu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(parampfu));
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "async setChannelNeedRequestAdvertisement channelid=" + paramInt + "  bNeed= " + paramBoolean);
    }
    this.e.put(Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean));
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (paramAdvertisementInfo == null) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "doUninterestAdvertisement tagId=" + paramLong + ", channelId=" + paramAdvertisementInfo.mChannelID + ", pos=" + paramAdvertisementInfo.mAdKdPos + ", traceID=" + paramAdvertisementInfo.mAdTraceId);
      }
      localObject1 = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
      if ((localObject1 != null) && (((ConcurrentHashMap)localObject1).containsKey(Integer.valueOf(paramAdvertisementInfo.mAdKdPos)))) {
        ((ConcurrentHashMap)localObject1).remove(Integer.valueOf(paramAdvertisementInfo.mAdKdPos));
      }
    } while (paramBoolean);
    Object localObject1 = "";
    Object localObject2 = localObject1;
    int i;
    if (paramArrayList != null)
    {
      i = 0;
      localObject2 = localObject1;
      if (i < paramArrayList.size())
      {
        localObject2 = (DislikeInfo)paramArrayList.get(i);
        if (localObject2 == null) {
          break label375;
        }
        localObject2 = (String)localObject1 + ((DislikeInfo)localObject2).jdField_a_of_type_Long;
        localObject1 = localObject2;
        if (i != paramArrayList.size() - 1) {
          localObject1 = (String)localObject2 + ",";
        }
      }
    }
    label375:
    for (;;)
    {
      i += 1;
      break;
      if (paramAdvertisementInfo.mChannelID == 56L)
      {
        noy.a(new obk().a(paramContext).a(noy.jdField_c_of_type_Int).b(noy.M).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
      if (ors.a(paramAdvertisementInfo)) {}
      for (i = noy.Q;; i = noy.L)
      {
        noy.a(new obk().a(paramContext).a(noy.jdField_c_of_type_Int).b(i).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
    }
  }
  
  public void a(AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo)
  {
    try
    {
      Object localObject2 = new JSONObject(paramAdvertisementInfo.mAdExt);
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("traceid", paramAdvertisementInfo.mAdTraceId);
      ((JSONObject)localObject1).put("rl", paramAdvertisementInfo.mAdRl);
      ((JSONObject)localObject1).put("productid", paramAdvertisementInfo.mAdProductId);
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "native object is null");
        }
      }
      else
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("videoUrl", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("coverUrl", paramAdvertisementInfo.mVideoCoverUrl);
        localJSONObject.put("duration", paramAdvertisementInfo.mVideoDuration);
        ((JSONObject)localObject1).put("video", localJSONObject);
        ((JSONObject)localObject1).put("native", ((JSONObject)localObject2).getJSONObject("native"));
        localObject2 = new JSONArray();
        ((JSONArray)localObject2).put(localObject1);
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("uin", paramAppInterface.getAccount());
        ((JSONObject)localObject1).put("type", 3);
        ((JSONObject)localObject1).put("ads", localObject2);
        localObject2 = ((JSONObject)localObject1).toString();
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "get ad app json: " + (String)localObject2);
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = new WebSsoBody.WebSsoRequestBody();
          ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject2);
          localObject2 = new NewIntent(paramAppInterface.getApplication(), nrz.class);
          ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new pev(this, paramAdvertisementInfo));
          paramAppInterface.startServlet((NewIntent)localObject2);
          return;
        }
      }
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "onReceive response cmd=" + paramFromServiceMsg.getServiceCmd());
    }
    if ((paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) || (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x886")) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramRspChannelArticle == null) {
      return;
    }
    int i = (int)paramRspChannelArticle.uint64_channel_id.get();
    if ((i == 0) && (paramInt2 != 0)) {
      i = paramInt2;
    }
    for (;;)
    {
      long l1 = paramRspChannelArticle.uint64_pos_ad_time.get();
      ArrayList localArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1 + ",repeatedreqFlag=" + paramInt1);
      }
      int k = 0;
      long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
      int j = i;
      paramInt1 = k;
      int n;
      Object localObject2;
      Object localObject3;
      int m;
      if (paramRspChannelArticle.rpt_advertise_list.has())
      {
        j = i;
        paramInt1 = k;
        if (paramRspChannelArticle.rpt_advertise_list.get() != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp resp.rpt_advertise_list size " + paramRspChannelArticle.rpt_advertise_list.get().size());
          }
          Iterator localIterator = paramRspChannelArticle.rpt_advertise_list.get().iterator();
          n = 0;
          paramInt1 = 0;
          k = 0;
          j = i;
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject2 = (articlesummary.ArticleSummary)localIterator.next();
              if ((((articlesummary.ArticleSummary)localObject2).msg_feeds_info.has()) && (((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get() != null) && (((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get()).msg_pos_ad_info.has()))
              {
                localObject3 = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject2).msg_feeds_info.get()).msg_pos_ad_info.get();
                if ((localObject3 != null) && (((articlesummary.PosAdInfo)localObject3).int32_ret.get() == 0))
                {
                  m = ((articlesummary.PosAdInfo)localObject3).enum_pos_layout.get();
                  long l3 = ((articlesummary.PosAdInfo)localObject3).uint64_pos_id.get();
                  long l4 = ((articlesummary.PosAdInfo)localObject3).is_auto_play.get();
                  localObject3 = (articlesummary.AdInfo)((articlesummary.PosAdInfo)localObject3).msg_ad_info.get();
                  i = j;
                  if (localObject3 != null)
                  {
                    i = j;
                    if (paramInt2 == 0)
                    {
                      j = (int)((articlesummary.AdInfo)localObject3).uint64_channel_id.get();
                      i = j;
                      if (QLog.isColorLevel())
                      {
                        QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID from AdInfo:" + j);
                        i = j;
                      }
                    }
                  }
                  localObject3 = new AdvertisementInfo((articlesummary.AdInfo)localObject3);
                  oee.a((AdvertisementInfo)localObject3);
                  puy.a((articlesummary.ArticleSummary)localObject2, i, 0, (ArticleInfo)localObject3);
                  ((AdvertisementInfo)localObject3).mAdFetchTime = l1;
                  ((AdvertisementInfo)localObject3).mAdPosLayout = m;
                  ((AdvertisementInfo)localObject3).mAdPosID = l3;
                  ((AdvertisementInfo)localObject3).mADVideoAutoPlay = l4;
                  if ((l2 == -1L) && (k == 0) && (((AdvertisementInfo)localObject3).mAdvertisementExtInfo != null) && (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.f > 0))
                  {
                    jdField_a_of_type_Int = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.f;
                    if (QLog.isColorLevel()) {
                      QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPosX= +" + jdField_a_of_type_Int);
                    }
                    a(i, 0, jdField_a_of_type_Int);
                    if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.h > 0)
                    {
                      jdField_b_of_type_Int = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.h;
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPosZ= +" + jdField_b_of_type_Int);
                      }
                    }
                    if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.g > 0)
                    {
                      jdField_c_of_type_Int = ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.g;
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPosY= +" + jdField_c_of_type_Int);
                      }
                    }
                    j = 1;
                    label694:
                    if (QLog.isColorLevel()) {
                      QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo pos= +" + ((AdvertisementInfo)localObject3).mAdKdPos + "  info=" + ((AdvertisementInfo)localObject3).toString());
                    }
                    if (orf.a()) {
                      orf.a().a((articlesummary.ArticleSummary)localObject2, (ArticleInfo)localObject3);
                    }
                    if (QLog.isColorLevel()) {
                      QLog.d("AdvertisementInfoModule", 2, "info.mAdExtInfo= +" + ((AdvertisementInfo)localObject3).mAdExtInfo);
                    }
                    for (;;)
                    {
                      try
                      {
                        bool = TextUtils.isEmpty(((AdvertisementInfo)localObject3).mAdExtInfo);
                        if (bool) {}
                      }
                      catch (Exception localException3)
                      {
                        boolean bool;
                        JSONObject localJSONObject;
                        label989:
                        continue;
                      }
                      try
                      {
                        localJSONObject = new JSONObject(((AdvertisementInfo)localObject3).mAdExtInfo);
                        if (!localJSONObject.has("adPosType")) {
                          break label2550;
                        }
                        k = localJSONObject.getInt("adPosType");
                        if (k != 2) {
                          break label2550;
                        }
                        k = 1;
                        paramInt1 = 1;
                      }
                      catch (Exception localException2)
                      {
                        continue;
                        continue;
                        continue;
                      }
                      try
                      {
                        QLog.d("AdvertisementInfoModule", 1, " adPosType ==2 , last advertisement, setChannelNeedRequestAdvertisement false");
                        k = paramInt1;
                        if (QLog.isColorLevel())
                        {
                          k = paramInt1;
                          QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo mAdExtInfo=" + localJSONObject.toString());
                        }
                        k = paramInt1;
                        oek.a().a((AdvertisementInfo)localObject3);
                        k = paramInt1;
                        m = paramInt1;
                        if (localJSONObject.has("patchAdType"))
                        {
                          k = paramInt1;
                          if (localJSONObject.optInt("patchAdType") == 1)
                          {
                            k = paramInt1;
                            oeh.jdField_a_of_type_Boolean = true;
                            k = paramInt1;
                            this.jdField_a_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(localObject3);
                            k = paramInt1;
                            if (localJSONObject.optInt("postPatchAdNoFirst") != 1) {
                              continue;
                            }
                            bool = true;
                            k = paramInt1;
                            oeh.c = bool;
                            k = paramInt1;
                            oeh.jdField_a_of_type_Int = localJSONObject.optInt("patchAdLimitMinutes");
                            k = paramInt1;
                            oeh.jdField_b_of_type_Int = localJSONObject.optInt("patchAdDisplaySeconds");
                            n = 1;
                            k = j;
                            j = i;
                            break;
                          }
                          k = paramInt1;
                          if (localJSONObject.optInt("patchAdType") != 2) {
                            continue;
                          }
                          k = paramInt1;
                          oeh.jdField_b_of_type_Boolean = true;
                          k = paramInt1;
                          this.jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue.offer(localObject3);
                          continue;
                          paramInt2 = i;
                        }
                      }
                      catch (Exception localException1)
                      {
                        paramInt1 = k;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        if (n != 0)
        {
          if (localArrayList.size() != 0) {
            break;
          }
          paramToServiceMsg = new JSONObject();
        }
        for (;;)
        {
          try
          {
            for (;;)
            {
              paramToServiceMsg.put("svrresp_result", 1);
              paramToServiceMsg.put("svrresp_fail_type", 1);
              noy.a(new obk().a(BaseApplication.getContext()).a(noy.k).b(noy.S).b(paramToServiceMsg).a());
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + paramInt2 + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
              return;
              bool = false;
              break label989;
              m = paramInt1;
              paramInt1 = m;
              k = j;
              if (l2 == -1L)
              {
                k = j;
                if (j == 0)
                {
                  k = j;
                  if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo != null)
                  {
                    k = j;
                    if (((AdvertisementInfo)localObject3).mAdvertisementExtInfo.f > 0)
                    {
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPos= +" + ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.f);
                      }
                      a(i, 0, ((AdvertisementInfo)localObject3).mAdvertisementExtInfo.f);
                      k = 1;
                    }
                  }
                }
              }
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo pos= +" + ((AdvertisementInfo)localObject3).mAdKdPos + "  info=" + ((AdvertisementInfo)localObject3).toString());
              }
              if (orf.a()) {
                orf.a().a((articlesummary.ArticleSummary)localObject2, (ArticleInfo)localObject3);
              }
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "info.mAdExtInfo= +" + ((AdvertisementInfo)localObject3).mAdExtInfo);
              }
              if (!a((AdvertisementInfo)localObject3))
              {
                if (oed.a((AdvertisementInfo)localObject3, null)) {
                  localObject2 = new JSONObject();
                }
                try
                {
                  ((JSONObject)localObject2).put("svrresp_result", 0);
                  ((JSONObject)localObject2).put("svrresp_count", 1);
                  noy.a(new obk().a(BaseApplication.getContext()).a(noy.k).b(noy.S).a((AdvertisementInfo)localObject3).b((JSONObject)localObject2).a());
                  localArrayList.add(localObject3);
                  j = i;
                  i = paramInt1;
                  paramInt1 = k;
                  k = paramInt1;
                  paramInt1 = i;
                }
                catch (JSONException localJSONException)
                {
                  for (;;)
                  {
                    localJSONException.printStackTrace();
                  }
                }
              }
            }
            if ((QLog.isColorLevel()) && (localObject3 != null)) {
              QLog.d("AdvertisementInfoModule", 2, "filterAdvertisementInfo info = " + ((AdvertisementInfo)localObject3).toSString());
            }
            j = i;
            i = paramInt1;
            paramInt1 = k;
            continue;
          }
          catch (JSONException paramRspChannelArticle)
          {
            paramRspChannelArticle.printStackTrace();
            continue;
          }
          if (paramRspChannelArticle.msg_ad_pos_map.has())
          {
            paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
            if (paramRspChannelArticle.bytes_ads_context.has())
            {
              noy.a(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
              if (paramInt1 != 0) {
                a(paramInt2, false);
              }
              this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt2), Long.valueOf(l1));
              if ((paramBoolean) && (l1 > 0L)) {
                this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt2), Long.valueOf(l1));
              }
              QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo, fromRefresh=" + paramBoolean + ", list.size()=" + localArrayList.size() + ",fetchTime=" + l1);
              paramRspChannelArticle = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt2));
              if (paramRspChannelArticle != null) {
                break label2547;
              }
              paramRspChannelArticle = new ConcurrentHashMap();
              this.jdField_c_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt2), paramRspChannelArticle);
              if ((paramRspChannelArticle != null) && (QLog.isColorLevel())) {
                QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + paramInt2);
              }
              localObject1 = new ConcurrentHashMap();
              paramBoolean = piy.a(paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp beginSeq = " + l2 + ",isFeedsPreload=" + paramBoolean);
              }
              if ((!paramBoolean) || (localArrayList.size() > 0)) {
                break label2051;
              }
            }
          }
          for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = paramRspChannelArticle)
          {
            if ((paramToServiceMsg != null) && (QLog.isColorLevel())) {
              QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements size = " + paramToServiceMsg.size());
            }
            localObject1 = paramToServiceMsg.values().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
              owy.a().a(paramInt2, (BaseArticleInfo)localObject2);
            }
            noy.a("");
            break;
            noy.a("");
            j = paramInt2;
            paramInt2 = j;
            break;
            label2051:
            if (l2 != -1L) {
              break label2065;
            }
          }
          label2065:
          localObject2 = localArrayList.iterator();
          for (;;)
          {
            paramToServiceMsg = (ToServiceMsg)localObject1;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            paramToServiceMsg = (AdvertisementInfo)((Iterator)localObject2).next();
            if (paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)) != null)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements info = " + paramToServiceMsg.toSString());
              }
              ((ConcurrentHashMap)localObject1).put(Integer.valueOf(paramToServiceMsg.mAdKdPos), paramRspChannelArticle.get(Integer.valueOf(paramToServiceMsg.mAdKdPos)));
              paramRspChannelArticle.remove(Integer.valueOf(paramToServiceMsg.mAdKdPos));
            }
          }
          paramToServiceMsg.clear();
          paramToServiceMsg = new StringBuilder("handleAdvertisementResp channelID=" + paramInt2 + ", fetchTime=" + l1 + "\n");
          Object localObject1 = localArrayList.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
            paramRspChannelArticle.put(Integer.valueOf(((AdvertisementInfo)localObject2).mAdKdPos), localObject2);
            if (paramToServiceMsg != null) {
              paramToServiceMsg.append("[pos=").append(((AdvertisementInfo)localObject2).mAdKdPos).append(", traceID=").append(((AdvertisementInfo)localObject2).mAdTraceId).append("]\n");
            }
            if ((((AdvertisementInfo)localObject2).mAdJumpMode == 4) && (TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdAppJson))) {
              a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, (AdvertisementInfo)localObject2);
            }
          }
          if (paramToServiceMsg != null) {
            QLog.d("AdvertisementInfoModule", 1, paramToServiceMsg.toString());
          }
          if ((paramRspChannelArticle != null) && (QLog.isColorLevel())) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + paramInt2);
          }
          if (localArrayList.size() != 0) {
            break;
          }
          paramToServiceMsg = new JSONObject();
          try
          {
            paramToServiceMsg.put("svrresp_result", 1);
            paramToServiceMsg.put("svrresp_fail_type", 1);
            noy.a(new obk().a(BaseApplication.getContext()).a(noy.k).b(noy.S).b(paramToServiceMsg).a());
            QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + paramInt2 + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
            return;
          }
          catch (JSONException paramRspChannelArticle)
          {
            for (;;)
            {
              paramRspChannelArticle.printStackTrace();
            }
          }
          label2547:
          label2550:
          j = k;
          break label694;
          i = paramInt1;
          paramInt1 = k;
        }
        paramInt2 = j;
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.e.containsKey(Integer.valueOf(paramInt))) {
      return ((Boolean)this.e.get(Integer.valueOf(paramInt))).booleanValue();
    }
    return true;
  }
  
  public int[] a(int paramInt)
  {
    ArrayList localArrayList = b(paramInt);
    if (localArrayList.size() <= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getFixPositionSync channelID=" + paramInt + " return empty!");
      }
      return new int[0];
    }
    int[] arrayOfInt = new int[localArrayList.size()];
    StringBuilder localStringBuilder = new StringBuilder("[");
    int i = 0;
    while (i < localArrayList.size())
    {
      arrayOfInt[i] = ((AdvertisementInfo)localArrayList.get(i)).mAdKdPos;
      localStringBuilder.append(arrayOfInt[i]);
      if (i != localArrayList.size() - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    localStringBuilder.append("]");
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "getFixPositionSync channelID=" + paramInt + " return " + localStringBuilder.toString());
    }
    return arrayOfInt;
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localConcurrentHashMap == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AdvertisementInfoModule", 2, "getAdvertisementInfo channelId=" + paramInt1 + " map is null!");
      }
      return null;
    }
    return (AdvertisementInfo)localConcurrentHashMap.remove(Integer.valueOf(paramInt2));
  }
  
  public ArrayList<AdvertisementInfo> b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ConcurrentHashMap)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject).next());
      }
      Collections.sort(localArrayList, new pet(this));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("\n");
      int i = 0;
      while (i < localArrayList.size())
      {
        AdvertisementInfo localAdvertisementInfo = (AdvertisementInfo)localArrayList.get(i);
        ((StringBuilder)localObject).append("[pos=").append(localAdvertisementInfo.mAdKdPos).append(", traceID=").append(localAdvertisementInfo.mAdTraceId).append("]");
        if (i != localArrayList.size() - 1) {
          ((StringBuilder)localObject).append("\n");
        }
        i += 1;
      }
      QLog.d("AdvertisementInfoModule", 2, "loadChannelAdvertisement channelId=" + paramInt + ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public ArrayBlockingQueue<AdvertisementInfo> b()
  {
    return this.jdField_b_of_type_JavaUtilConcurrentArrayBlockingQueue;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pes
 * JD-Core Version:    0.7.0.1
 */