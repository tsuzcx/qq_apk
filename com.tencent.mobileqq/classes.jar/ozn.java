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

public class ozn
  extends pbh
{
  private final long jdField_a_of_type_Long = 86400000L;
  private LinkedHashMap<Integer, Long> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, WeakReference<pao>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, Long> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private ConcurrentHashMap<Integer, HashSet<String>> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private LinkedHashMap<Integer, ConcurrentHashMap<Integer, AdvertisementInfo>> c = new LinkedHashMap();
  private LinkedHashMap<Integer, Pair<Integer, Integer>> d;
  private LinkedHashMap<Integer, Boolean> e = new LinkedHashMap();
  
  public ozn(AppInterface paramAppInterface, aukn paramaukn, ExecutorService paramExecutorService, pou parampou, Handler paramHandler)
  {
    super(paramAppInterface, paramaukn, paramExecutorService, parampou, paramHandler);
    this.jdField_d_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "construct!");
    }
  }
  
  private int a()
  {
    switch (bbev.a(BaseApplication.getContext()))
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
    Object localObject2 = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt));
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
        Collections.sort((List)localObject1, new ozp(this));
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
    int i = pow.a(paramFromServiceMsg, paramObject, localRspBody);
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
        break label565;
      }
    }
    label562:
    label565:
    for (long l = localRspBody.uint64_uin.get();; l = -1L)
    {
      if ((localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null) && (String.valueOf(l).equals(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        paramFromServiceMsg = (oidb_cmd0x68b.RspChannelArticle)localRspBody.rspChannelArticle.get();
        i = (int)paramFromServiceMsg.uint64_channel_id.get();
        if ((i != 0) || (k == 0)) {
          break label562;
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
          if ((this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(i))) && (j == 0))
          {
            paramToServiceMsg = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(i));
            if ((paramToServiceMsg != null) && (paramToServiceMsg.get() != null))
            {
              QLog.d("AdvertisementInfoModule", 1, "handle0x68bGetAdvertisementList listener = " + paramToServiceMsg.toString());
              ((pao)paramToServiceMsg.get()).a(i);
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
          nmf.a(new nyg().a(BaseApplication.getContext()).a(nmf.k).b(nmf.S).b(paramToServiceMsg).a());
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
    int i = pow.a(paramFromServiceMsg, paramObject, new oidb_cmd0x886.RspBody());
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
    if ((paramInt2 % 10 == 4) || (paramInt2 == 9))
    {
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
        if (paramInt2 + 10 < ((Integer)localPair.second).intValue()) {
          return null;
        }
        int i = ((Integer)localPair.second).intValue();
        int j = i + 10;
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
    return null;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt1));
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
  
  public oidb_cmd0x68b.ReqAdvertisePara a(poz parampoz, int paramInt1, int paramInt2, int paramInt3, int paramInt4, nlc paramnlc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "makeReqAdvertisePara channelID=" + paramInt1);
    }
    Object localObject1 = new yyt();
    ((yyt)localObject1).a = "ce2d9f";
    Object localObject3 = yys.a(BaseApplication.getContext(), (yyt)localObject1);
    oidb_cmd0x68b.ReqAdvertisePara localReqAdvertisePara;
    Object localObject2;
    long l;
    if (localObject3 != null)
    {
      localObject1 = ((yyu)localObject3).a;
      localReqAdvertisePara = new oidb_cmd0x68b.ReqAdvertisePara();
      localReqAdvertisePara.uint64_channel_id.set(paramInt1, true);
      localObject2 = localReqAdvertisePara.uint64_last_time;
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
        break label1006;
      }
      l = 0L;
      label115:
      ((PBUInt64Field)localObject2).set(l, true);
      localObject2 = new oidb_cmd0x68b.PhoneInfo();
      if ((localObject3 != null) && (((yyu)localObject3).a != null) && (((yyu)localObject3).a.muid != null) && (((yyu)localObject3).a.muid_type != null))
      {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_muid.set(ByteStringMicro.copyFromUtf8(((yyu)localObject3).a.muid.get()));
        ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_muid_type.set(((yyu)localObject3).a.muid_type.get());
      }
      localObject3 = oai.b();
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((oidb_cmd0x68b.PhoneInfo)localObject2).string_imei.set((String)localObject3);
      }
      i = njo.a();
      ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_conn.set(i);
      i = 0;
    }
    try
    {
      int j = bbct.e();
      i = j;
    }
    catch (Exception localException)
    {
      label258:
      break label258;
    }
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_carrier.set(i);
    localObject3 = bbct.e();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    localObject3 = bbct.c();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    int i = AppSetting.a();
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
    localObject3 = fi.a(fi.a());
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject3));
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint32_os_type.set(2);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).uint64_func_flag.set(1L);
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_ads_context.set(ByteStringMicro.copyFromUtf8(nmf.a()));
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
    ((oidb_cmd0x68b.PhoneInfo)localObject2).bytes_wx_ver.set(ByteStringMicro.copyFrom(oai.a(BaseApplication.getContext()).getBytes()));
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
        if ((paramnlc != null) && (paramnlc.a()))
        {
          ((JSONObject)localObject1).put("MaterialId", paramnlc.jdField_a_of_type_Int);
          ((JSONObject)localObject1).put("RepeatedReqFlag", paramnlc.b);
          ((JSONObject)localObject1).put("KdPos", paramnlc.c);
          ((JSONObject)localObject1).put("adPosId", paramnlc.jdField_a_of_type_Long);
        }
        if (!pcz.b(parampoz)) {
          continue;
        }
        ((JSONObject)localObject1).put("adRequestFlag", a(paramInt1));
        if (this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1)) != null) {
          continue;
        }
        l = 0L;
        ((JSONObject)localObject1).put("lastRefreshTime", l);
        if ((oaw.a().a()) && (paramInt2 == 1) && (oaw.a().a().size() > 0))
        {
          ((JSONObject)localObject1).put("superMaskType", 2);
          ((JSONObject)localObject1).put("reqList", new JSONArray(oaw.a().a()));
          oaw.a().b(false);
        }
        QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo," + ((JSONObject)localObject1).toString());
        localReqAdvertisePara.bytes_ad_user_info.set(ByteStringMicro.copyFromUtf8(((JSONObject)localObject1).toString()));
      }
      catch (JSONException parampoz)
      {
        label1006:
        parampoz.printStackTrace();
        continue;
      }
      parampoz = new oidb_cmd0x68b.AdReqInfo();
      parampoz.uint64_ad_channel_id.set(paramInt1);
      localReqAdvertisePara.msg_ad_req_info.set(parampoz);
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
    this.c.clear();
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
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nlc paramnlc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " adPosType = " + paramInt2 + " adStart = " + paramInt3 + " adEnd = " + paramInt4);
    }
    if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " not contained in mChannelID2FixPosArticleAsyncListener");
      ozj.a().a(paramInt1);
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(paramInt1)))
    {
      localObject = (WeakReference)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt1));
      if ((localObject == null) || (((WeakReference)localObject).get() == null))
      {
        QLog.d("AdvertisementInfoModule", 1, "refreshChannelAdvertisementFormServer channelId=" + paramInt1 + " listener is null");
        ozj.a().a(paramInt1);
      }
    }
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l = Long.valueOf(onk.a()).longValue();
    localReqBody.uint64_uin.set(l);
    localReqBody.uint32_network_type.set(a());
    localReqBody.req_advertise_para.set(a(null, paramInt1, paramInt2, paramInt3, paramInt4, paramnlc));
    Object localObject = pow.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    ((ToServiceMsg)localObject).getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
    if ((paramnlc != null) && (paramnlc.b == 1))
    {
      ((ToServiceMsg)localObject).getAttributes().put(h, Integer.valueOf(paramnlc.b));
      ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(0));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("adpostype_0x68b", Integer.valueOf(paramInt2));
      if (!oox.c(paramInt1))
      {
        paramnlc = (nlc)localObject;
        if (!bhvh.a(paramInt1)) {}
      }
      else
      {
        localReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(rqg.a("default_feeds")));
        paramnlc = (nlc)localObject;
        if (bhvh.v())
        {
          paramnlc = pbb.a(paramInt1);
          if (!TextUtils.isEmpty(paramnlc)) {
            localReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramnlc));
          }
          paramnlc = pow.a("OidbSvc.0xcba", 3258, 0, localReqBody.toByteArray());
          paramnlc.getAttributes().put("realTimeServiceKey", "default_feeds");
          paramnlc.getAttributes().put(jdField_d_of_type_JavaLangString, Long.valueOf(paramInt3));
        }
      }
      if ((paramInt2 == 5) || (paramInt2 == 6))
      {
        paramnlc.getAttributes().put(i, Integer.valueOf(paramInt1));
        paramnlc.getAttributes().put(f, Integer.valueOf(0));
      }
      a(paramnlc);
      noo.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
      return;
      ((ToServiceMsg)localObject).getAttributes().put(f, Integer.valueOf(1));
    }
  }
  
  public void a(int paramInt, pao parampao)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "setFixPosArticleAsyncListener channelID=" + paramInt);
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), new WeakReference(parampao));
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
      localObject1 = (ConcurrentHashMap)this.c.get(Integer.valueOf((int)paramAdvertisementInfo.mChannelID));
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
        nmf.a(new nyg().a(paramContext).a(nmf.c).b(nmf.M).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
        return;
      }
      if (onk.a(paramAdvertisementInfo)) {}
      for (i = nmf.Q;; i = nmf.L)
      {
        nmf.a(new nyg().a(paramContext).a(nmf.c).b(i).a(paramAdvertisementInfo).a((int)paramLong).a((String)localObject2).a());
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
          localObject2 = new NewIntent(paramAppInterface.getApplication(), nou.class);
          ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_native");
          ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
          ((NewIntent)localObject2).setObserver(new ozq(this, paramAdvertisementInfo));
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
      long l2 = ((Long)paramToServiceMsg.getAttribute(jdField_d_of_type_JavaLangString)).longValue();
      int k;
      int m;
      Object localObject2;
      if ((paramRspChannelArticle.rpt_advertise_list.has()) && (paramRspChannelArticle.rpt_advertise_list.get() != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp resp.rpt_advertise_list size " + paramRspChannelArticle.rpt_advertise_list.get().size());
        }
        Iterator localIterator = paramRspChannelArticle.rpt_advertise_list.get().iterator();
        paramInt1 = 0;
        k = 0;
        int j = i;
        for (;;)
        {
          m = paramInt1;
          i = j;
          if (localIterator.hasNext())
          {
            Object localObject3 = (articlesummary.ArticleSummary)localIterator.next();
            int i1 = k;
            int n = paramInt1;
            m = j;
            if (((articlesummary.ArticleSummary)localObject3).msg_feeds_info.has())
            {
              i1 = k;
              n = paramInt1;
              m = j;
              if (((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get() != null)
              {
                i1 = k;
                n = paramInt1;
                m = j;
                if (((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get()).msg_pos_ad_info.has())
                {
                  localObject2 = (articlesummary.PosAdInfo)((articlesummary.FeedsInfo)((articlesummary.ArticleSummary)localObject3).msg_feeds_info.get()).msg_pos_ad_info.get();
                  i1 = k;
                  n = paramInt1;
                  m = j;
                  if (localObject2 != null)
                  {
                    i1 = k;
                    n = paramInt1;
                    m = j;
                    if (((articlesummary.PosAdInfo)localObject2).int32_ret.get() == 0)
                    {
                      m = ((articlesummary.PosAdInfo)localObject2).enum_pos_layout.get();
                      long l3 = ((articlesummary.PosAdInfo)localObject2).uint64_pos_id.get();
                      long l4 = ((articlesummary.PosAdInfo)localObject2).is_auto_play.get();
                      localObject2 = (articlesummary.AdInfo)((articlesummary.PosAdInfo)localObject2).msg_ad_info.get();
                      i = j;
                      if (localObject2 != null)
                      {
                        i = j;
                        if (paramInt2 == 0)
                        {
                          j = (int)((articlesummary.AdInfo)localObject2).uint64_channel_id.get();
                          i = j;
                          if (QLog.isColorLevel())
                          {
                            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp channelID from AdInfo:" + j);
                            i = j;
                          }
                        }
                      }
                      localObject2 = new AdvertisementInfo((articlesummary.AdInfo)localObject2);
                      oau.a((AdvertisementInfo)localObject2);
                      pot.a((articlesummary.ArticleSummary)localObject3, i, 0, (ArticleInfo)localObject2);
                      ((AdvertisementInfo)localObject2).mAdFetchTime = l1;
                      ((AdvertisementInfo)localObject2).mAdPosLayout = m;
                      ((AdvertisementInfo)localObject2).mAdPosID = l3;
                      ((AdvertisementInfo)localObject2).mADVideoAutoPlay = l4;
                      j = k;
                      if (l2 == -1L)
                      {
                        j = k;
                        if (k == 0)
                        {
                          j = k;
                          if (((AdvertisementInfo)localObject2).mAdvertisementExtInfo != null)
                          {
                            j = k;
                            if (((AdvertisementInfo)localObject2).mAdvertisementExtInfo.f > 0)
                            {
                              if (QLog.isColorLevel()) {
                                QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp refreshLastPos= +" + ((AdvertisementInfo)localObject2).mAdvertisementExtInfo.f);
                              }
                              a(i, 0, ((AdvertisementInfo)localObject2).mAdvertisementExtInfo.f);
                              j = 1;
                            }
                          }
                        }
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo pos= +" + ((AdvertisementInfo)localObject2).mAdKdPos + "  info=" + ((AdvertisementInfo)localObject2).toString());
                      }
                      if (omx.a()) {
                        omx.a().a((articlesummary.ArticleSummary)localObject3, (ArticleInfo)localObject2);
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("AdvertisementInfoModule", 2, "info.mAdExtInfo= +" + ((AdvertisementInfo)localObject2).mAdExtInfo);
                      }
                    }
                  }
                }
              }
            }
            for (;;)
            {
              try
              {
                boolean bool = TextUtils.isEmpty(((AdvertisementInfo)localObject2).mAdExtInfo);
                k = paramInt1;
                if (!bool) {
                  k = paramInt1;
                }
              }
              catch (Exception localException2)
              {
                k = paramInt1;
                continue;
                continue;
              }
              try
              {
                for (;;)
                {
                  localObject3 = new JSONObject(((AdvertisementInfo)localObject2).mAdExtInfo);
                  m = paramInt1;
                  k = paramInt1;
                  if (((JSONObject)localObject3).has("adPosType"))
                  {
                    m = paramInt1;
                    k = paramInt1;
                    if (((JSONObject)localObject3).getInt("adPosType") == 2)
                    {
                      k = 1;
                      m = 1;
                      QLog.d("AdvertisementInfoModule", 1, " adPosType ==2 , last advertisement, setChannelNeedRequestAdvertisement false");
                    }
                  }
                  k = m;
                  if (QLog.isColorLevel())
                  {
                    k = m;
                    QLog.d("AdvertisementInfoModule", 2, "async handleAdvertisementResp adinfo mAdExtInfo=" + ((JSONObject)localObject3).toString());
                  }
                  k = m;
                  oaw.a().a((AdvertisementInfo)localObject2);
                  k = m;
                  if (!a((AdvertisementInfo)localObject2))
                  {
                    if (oat.a((AdvertisementInfo)localObject2, null)) {
                      localObject3 = new JSONObject();
                    }
                    try
                    {
                      ((JSONObject)localObject3).put("svrresp_result", 0);
                      ((JSONObject)localObject3).put("svrresp_count", 1);
                      nmf.a(new nyg().a(BaseApplication.getContext()).a(nmf.k).b(nmf.S).a((AdvertisementInfo)localObject2).b((JSONObject)localObject3).a());
                      localArrayList.add(localObject2);
                      paramInt1 = j;
                      j = k;
                      k = paramInt1;
                      paramInt1 = j;
                      j = i;
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
                i1 = j;
                n = k;
                m = i;
                if (QLog.isColorLevel())
                {
                  i1 = j;
                  n = k;
                  m = i;
                  if (localObject2 != null)
                  {
                    QLog.d("AdvertisementInfoModule", 2, "filterAdvertisementInfo info = " + ((AdvertisementInfo)localObject2).toSString());
                    m = i;
                    n = k;
                    i1 = j;
                  }
                }
                paramInt1 = i1;
                j = n;
                i = m;
                continue;
                if (!paramRspChannelArticle.msg_ad_pos_map.has()) {
                  continue;
                }
              }
              catch (Exception localException1)
              {
                m = k;
              }
            }
          }
        }
        paramRspChannelArticle = (oidb_cmd0x68b.AdPosMap)paramRspChannelArticle.msg_ad_pos_map.get();
        if (paramRspChannelArticle.bytes_ads_context.has()) {
          nmf.a(paramRspChannelArticle.bytes_ads_context.get().toStringUtf8());
        }
      }
      for (;;)
      {
        if (m != 0) {
          a(i, false);
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), Long.valueOf(l1));
        if ((paramBoolean) && (l1 > 0L)) {
          this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(i), Long.valueOf(l1));
        }
        QLog.d("AdvertisementInfoModule", 1, "async makeReqAdvertisePara adinfo, fromRefresh=" + paramBoolean + ", list.size()=" + localArrayList.size() + ",fetchTime=" + l1);
        paramRspChannelArticle = (ConcurrentHashMap)this.c.get(Integer.valueOf(i));
        if (paramRspChannelArticle == null)
        {
          paramRspChannelArticle = new ConcurrentHashMap();
          this.c.put(Integer.valueOf(i), paramRspChannelArticle);
          if ((paramRspChannelArticle != null) && (QLog.isColorLevel())) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + i);
          }
          Object localObject1 = new ConcurrentHashMap();
          paramBoolean = pcz.a(paramToServiceMsg);
          if (QLog.isColorLevel()) {
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp beginSeq = " + l2 + ",isFeedsPreload=" + paramBoolean);
          }
          if ((paramBoolean) && (localArrayList.size() <= 0)) {}
          for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = paramRspChannelArticle)
          {
            if ((paramToServiceMsg != null) && (QLog.isColorLevel())) {
              QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp dropAdvertisements size = " + paramToServiceMsg.size());
            }
            localObject1 = paramToServiceMsg.values().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (AdvertisementInfo)((Iterator)localObject1).next();
              osj.a().a(i, (BaseArticleInfo)localObject2);
            }
            nmf.a("");
            break;
            nmf.a("");
            break;
            if (l2 != -1L) {
              break label1549;
            }
          }
          label1549:
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
          paramToServiceMsg = new StringBuilder("handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1 + "\n");
          localObject1 = localArrayList.iterator();
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
            QLog.d("AdvertisementInfoModule", 2, "handleAdvertisementResp advertisementInfoMap size " + paramRspChannelArticle.size() + ", channelId=" + i);
          }
          if (localArrayList.size() != 0) {
            break;
          }
          paramToServiceMsg = new JSONObject();
          try
          {
            paramToServiceMsg.put("svrresp_result", 1);
            paramToServiceMsg.put("svrresp_fail_type", 1);
            nmf.a(new nyg().a(BaseApplication.getContext()).a(nmf.k).b(nmf.S).b(paramToServiceMsg).a());
            QLog.d("AdvertisementInfoModule", 1, "handleAdvertisementResp channelID=" + i + ", fetchTime=" + l1 + " parsedAdvertisementList empty!");
            return;
          }
          catch (JSONException paramRspChannelArticle)
          {
            for (;;)
            {
              paramRspChannelArticle.printStackTrace();
            }
          }
        }
        m = 0;
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
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt1));
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
    Object localObject = (ConcurrentHashMap)this.c.get(Integer.valueOf(paramInt));
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = ((ConcurrentHashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add((AdvertisementInfo)((Iterator)localObject).next());
      }
      Collections.sort(localArrayList, new ozo(this));
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
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdvertisementInfoModule", 2, "unInitModel!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ozn
 * JD-Core Version:    0.7.0.1
 */