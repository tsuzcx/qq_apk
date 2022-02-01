import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.1;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.2;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.3;
import com.tencent.biz.pubaccount.readinjoy.model.handler.RIJGetArticleListHandler.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ChannelLocationInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ExposeArticleInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ExposeTopic;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.InnerMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PkgInstallInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RefreshHistory;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqChannelPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqGetFollowTabPara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspBody;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabData;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.SubscribeMsg;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UserExposeArticle;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UserReadArticle;

public class qit
  extends qii
{
  private static volatile com.tencent.util.Pair<List<Long>, oidb_cmd0x68b.RspBody> jdField_a_of_type_ComTencentUtilPair;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static volatile List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "com.tencent.weishi", "com.tencent.reading", "com.tencent.mtt", "com.tencent.qqlive", "com.tencent.news" };
  
  public qit(qep paramqep, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, qxn paramqxn, ExecutorService paramExecutorService)
  {
    super(paramqep, paramHandler, paramAppInterface, paramEntityManager, paramqxn, paramExecutorService);
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("recommendFlag");
      if (paramToServiceMsg == null) {
        return 0;
      }
      QLog.d("RIJGetArticleListHandler", 1, " " + paramToServiceMsg);
      int i = ((Integer)paramToServiceMsg).intValue();
      return i;
    }
    catch (Exception paramToServiceMsg) {}
    return 0;
  }
  
  private int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return 1;
    }
    return 0;
  }
  
  private ToServiceMsg a(qxs paramqxs)
  {
    if (paramqxs == null) {}
    while (paramqxs.jdField_b_of_type_Int == -1) {
      return null;
    }
    paramqxs.jdField_a_of_type_Int = 5;
    paramqxs.jdField_a_of_type_Boolean = true;
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l1 = pjz.a();
    long l2 = Long.valueOf(pkh.a()).longValue();
    localReqBody.uint64_uin.set(l2);
    localReqBody.uint32_network_type.set(qer.a());
    oidb_cmd0x68b.ReqChannelPara localReqChannelPara = new oidb_cmd0x68b.ReqChannelPara();
    localReqChannelPara.uint64_channel_id.set(paramqxs.jdField_b_of_type_Int);
    localReqChannelPara.uint32_req_channel_list.set(1);
    a(localReqChannelPara);
    rnz.a(localReqChannelPara, String.valueOf(paramqxs.jdField_b_of_type_Int));
    localReqChannelPara.uint32_residence_time.set((int)rnz.a(paramqxs.jdField_b_of_type_Int));
    if (paramqxs.jdField_a_of_type_Long != -1L) {
      localReqChannelPara.uint64_begin_recommend_seq.set(paramqxs.jdField_a_of_type_Long);
    }
    if (paramqxs.jdField_b_of_type_Long != -1L) {
      localReqChannelPara.uint64_end_recommend_seq.set(paramqxs.jdField_b_of_type_Long);
    }
    localReqChannelPara.uint32_req_article_list.set(a(paramqxs.jdField_a_of_type_Boolean), paramqxs.jdField_a_of_type_Boolean);
    localReqChannelPara.uint32_req_deleted_article_list.set(a(paramqxs.jdField_b_of_type_Boolean), paramqxs.jdField_b_of_type_Boolean);
    if (paramqxs.jdField_a_of_type_JavaUtilList != null) {
      localReqChannelPara.rpt_curr_article_list.set(paramqxs.jdField_a_of_type_JavaUtilList);
    }
    if (bdvn.a())
    {
      paramqxs.jdField_i_of_type_Int |= 0x2000;
      QLog.d("RIJGetArticleListHandler", 1, "is study mode! channelID=" + paramqxs.jdField_b_of_type_Int);
    }
    localReqChannelPara.uint32_req_recommend_flag.set(paramqxs.jdField_i_of_type_Int);
    localReqChannelPara.bytes_req_recommend_json.set(ByteStringMicro.copyFromUtf8(qje.a.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface)));
    localReqChannelPara.bytes_req_ug_interface_data.set(ByteStringMicro.copyFromUtf8(pqp.b()));
    localReqChannelPara.uint32_req_video_list.set(a(paramqxs.jdField_d_of_type_Boolean));
    localReqChannelPara.uint32_req_picture_list.set(a(paramqxs.jdField_e_of_type_Boolean));
    localReqChannelPara.uint32_need_force_set_top.set(a(paramqxs.jdField_f_of_type_Boolean));
    if (paramqxs.jdField_a_of_type_ArrayOfByte != null) {
      localReqChannelPara.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramqxs.jdField_a_of_type_ArrayOfByte));
    }
    if (paramqxs.jdField_b_of_type_ArrayOfByte != null) {
      localReqChannelPara.bytes_device_id.set(ByteStringMicro.copyFrom(paramqxs.jdField_b_of_type_ArrayOfByte));
    }
    localReqChannelPara.uint32_update_times.set(paramqxs.jdField_c_of_type_Int);
    localReqChannelPara.uint32_req_media_specs.set(1);
    if (!bmhv.a(paramqxs.jdField_d_of_type_Int)) {
      localReqChannelPara.uint32_is_support_video_with_small_picture.set(1);
    }
    localReqChannelPara.uint32_is_support_packinfo.set(1);
    localReqChannelPara.uint32_privacy_status.set(uve.b());
    Object localObject;
    if (!TextUtils.isEmpty(Build.BRAND))
    {
      localObject = Build.BRAND;
      localReqChannelPara.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8((String)localObject));
      if (TextUtils.isEmpty(Build.MODEL)) {
        break label956;
      }
    }
    label956:
    for (String str = Build.MODEL;; str = "")
    {
      localReqChannelPara.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(str));
      if (paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData != null)
      {
        oidb_cmd0x68b.ChannelLocationInfo localChannelLocationInfo = new oidb_cmd0x68b.ChannelLocationInfo();
        localChannelLocationInfo.city.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.city));
        localChannelLocationInfo.province.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.province));
        localChannelLocationInfo.nation.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.country));
        localChannelLocationInfo.city_code.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.cityCode));
        localReqChannelPara.msg_channel_location_info.set(localChannelLocationInfo);
        if (QLog.isColorLevel()) {
          QLog.i("RIJGetArticleListHandler", 1, "0x68b request positionInfo = " + paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData);
        }
      }
      QLog.i("RIJGetArticleListHandler", 1, "0x68b request brand = " + (String)localObject + ", model = " + str);
      localObject = a(paramqxs, localReqChannelPara);
      qcr.a(paramqxs, (List)localObject);
      if (paramqxs.jdField_b_of_type_JavaUtilList != null) {
        localReqChannelPara.rpt_subscription_article_list.set(paramqxs.jdField_b_of_type_JavaUtilList);
      }
      a(paramqxs, localReqChannelPara);
      b(localReqChannelPara);
      localReqChannelPara.rpt_inner_msg_list.set((List)localObject);
      localReqChannelPara.uint32_req_is_disp_timestamp.set(1);
      localReqChannelPara.uint32_is_support_gallery.set(1);
      localReqChannelPara.uint32_req_picture_number.set(1);
      b(paramqxs, localReqChannelPara);
      c(paramqxs, localReqChannelPara);
      int i = ((Integer)bmhv.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
      localReqChannelPara.uint32_youngster_status.set(i);
      localReqBody.reqChannelPara.set(localReqChannelPara);
      localReqBody.reqChannelPara.setHasFlag(true);
      localReqBody.uint32_req_dislike_type.set(paramqxs.jdField_e_of_type_Int);
      a(paramqxs, localReqBody);
      if (pjz.b(l1)) {
        pjz.a(paramqxs);
      }
      localReqBody.uint64_client_swithes.set(paramqxs.jdField_f_of_type_Int);
      localReqBody.enum_refresh_type.set(paramqxs.jdField_g_of_type_Int);
      b(paramqxs, localReqBody);
      c(paramqxs, localReqBody);
      localReqBody.uint32_req_sim_type.set(bmhv.d());
      d(paramqxs, localReqBody);
      return a(paramqxs, localReqBody, l1);
      localObject = "";
      break;
    }
  }
  
  @NotNull
  private ToServiceMsg a(qxs paramqxs, oidb_cmd0x68b.ReqBody paramReqBody, long paramLong)
  {
    boolean bool2 = true;
    Object localObject;
    if (paramqxs.jdField_b_of_type_Int == 41403)
    {
      localObject = qxp.a("OidbSvc.0xbf7", 3063, paramqxs.j, paramReqBody.toByteArray());
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "make 0xbf7 OIDB Pkg, beginSeq = ", Long.valueOf(paramqxs.jdField_a_of_type_Long), ", endSeq = ", Long.valueOf(paramqxs.jdField_b_of_type_Long) });
      ((ToServiceMsg)localObject).getAttributes().put(qhj.jdField_c_of_type_JavaLangString, Integer.valueOf(paramqxs.jdField_a_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put(qhj.d, Long.valueOf(paramqxs.jdField_a_of_type_Long));
      ((ToServiceMsg)localObject).getAttributes().put(qhj.e, Long.valueOf(paramqxs.jdField_b_of_type_Long));
      ((ToServiceMsg)localObject).getAttributes().put(qhj.f, Integer.valueOf(1));
      ((ToServiceMsg)localObject).getAttributes().put(qhj.jdField_b_of_type_JavaLangString, Integer.valueOf(paramqxs.jdField_g_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put("recommendFlag", Integer.valueOf(paramqxs.jdField_i_of_type_Int));
      if (paramqxs.jdField_b_of_type_JavaUtilList != null) {
        ((ToServiceMsg)localObject).getAttributes().put("SubscriptionArticles", paramqxs.jdField_b_of_type_JavaUtilList);
      }
      a(paramReqBody, (ToServiceMsg)localObject, paramLong);
      pjz.a((ToServiceMsg)localObject, paramLong);
      ((ToServiceMsg)localObject).getAttributes().put("channelID", new Integer(paramqxs.jdField_b_of_type_Int));
      ((ToServiceMsg)localObject).getAttributes().put("isSingleHighLight", Boolean.valueOf(paramqxs.jdField_g_of_type_Boolean));
      ((ToServiceMsg)localObject).getAttributes().put("clientSwithes", Integer.valueOf(paramqxs.jdField_f_of_type_Int));
      paramReqBody = ((ToServiceMsg)localObject).getAttributes();
      if ((paramqxs.jdField_b_of_type_JavaUtilList == null) || (paramqxs.jdField_b_of_type_JavaUtilList.isEmpty())) {
        break label530;
      }
      bool1 = true;
      label310:
      paramReqBody.put("isRedRefreshReq", Boolean.valueOf(bool1));
      paramReqBody = ((ToServiceMsg)localObject).getAttributes();
      if ((paramqxs.jdField_i_of_type_Int & 0x100) == 0) {
        break label536;
      }
    }
    label530:
    label536:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramReqBody.put("isFeedsPreload", Boolean.valueOf(bool1));
      return localObject;
      if ((plm.c(paramqxs.jdField_b_of_type_Int)) || (bmhv.a(paramqxs.jdField_b_of_type_Int)))
      {
        paramReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(tmt.a("default_feeds")));
        if (bmhv.A())
        {
          localObject = qhc.a(paramqxs.jdField_b_of_type_Int);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
          }
          localObject = qxp.a("OidbSvc.0xcba", 3258, 0, paramReqBody.toByteArray());
          ((ToServiceMsg)localObject).getAttributes().put("realTimeServiceKey", "default_feeds");
          QLog.d("RIJGetArticleListHandler", 1, new Object[] { "make 0xcba OIDB Pkg, beginSeq = ", Long.valueOf(paramqxs.jdField_a_of_type_Long), ", endSeq = ", Long.valueOf(paramqxs.jdField_b_of_type_Long) });
          break;
        }
      }
      localObject = qxp.a("OidbSvc.0x68b", 1675, paramqxs.j, paramReqBody.toByteArray());
      break;
      bool1 = false;
      break label310;
    }
  }
  
  private List<oidb_cmd0x68b.ExposeArticleInfo> a(int paramInt)
  {
    if (!pqt.h()) {}
    do
    {
      return null;
      localObject = this.jdField_a_of_type_Qep.a().b(paramInt);
    } while ((localObject == null) || (((ConcurrentMap)localObject).isEmpty()));
    ArrayList localArrayList = new ArrayList(((ConcurrentMap)localObject).values());
    Collections.sort(localArrayList);
    Object localObject = localArrayList;
    if (localArrayList.size() > 100) {
      localObject = localArrayList.subList(0, 100);
    }
    if (QLog.isColorLevel()) {
      QLog.d("RIJGetArticleListHandler", 2, "add exposure data to 68b, channelID : " + paramInt + ", infos : " + localObject);
    }
    localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localArticleExposureInfo.rowkey))
      {
        oidb_cmd0x68b.ExposeArticleInfo localExposeArticleInfo = new oidb_cmd0x68b.ExposeArticleInfo();
        localExposeArticleInfo.bytes_rowkeys.set(ByteStringMicro.copyFromUtf8(localArticleExposureInfo.rowkey));
        localExposeArticleInfo.uint32_feeds_type.set(localArticleExposureInfo.feedsType);
        localExposeArticleInfo.uint64_algorithm_id.set(localArticleExposureInfo.algorithmID);
        localArrayList.add(localExposeArticleInfo);
      }
    }
    return localArrayList;
  }
  
  private List<Long> a(List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(Long.valueOf(((ArticleInfo)paramList.next()).mRecommendSeq));
    }
    return localArrayList;
  }
  
  @NotNull
  private List<oidb_cmd0x68b.InnerMsg> a(qxs paramqxs, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    ArrayList localArrayList = new ArrayList();
    b(paramqxs, localArrayList);
    if (!TextUtils.isEmpty(paramqxs.jdField_a_of_type_JavaLangString)) {
      a(paramqxs, localArrayList);
    }
    for (;;)
    {
      d(paramqxs, localArrayList);
      c(paramqxs, localArrayList);
      return localArrayList;
      if (paramqxs.jdField_c_of_type_Long != -1L) {
        a(paramqxs, paramReqChannelPara, localArrayList);
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject, int paramInt, Integer paramInteger)
  {
    HashMap localHashMap;
    try
    {
      i = ((byte[])paramObject).length;
      l1 = i;
    }
    catch (Exception paramObject)
    {
      for (;;)
      {
        int j;
        Integer localInteger2;
        Boolean localBoolean2;
        Integer localInteger1;
        Object localObject;
        long l3;
        Long localLong2;
        String str1;
        Long localLong1;
        String str3;
        String str2;
        Boolean localBoolean1;
        QLog.e("RIJGetArticleListHandler", 2, "report0x68bFields: " + paramObject);
        long l1 = 0L;
        continue;
        long l2 = -1L;
        continue;
        int i = 0;
        continue;
        l2 = 0L;
        continue;
        paramObject = "0";
        continue;
        paramObject = "0";
        continue;
        paramObject = "1";
        continue;
        paramObject = "";
        continue;
        paramObject = "0";
        continue;
        paramObject = "0";
        continue;
        paramObject = "";
        continue;
        paramObject = "";
      }
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "0x68b reportFields \n", paramObject.toString() });
      paramObject = pkh.a();
      if (paramInt != 0) {
        break label851;
      }
    }
    j = com.tencent.biz.common.util.NetworkUtil.getNetworkType(BaseApplicationImpl.context);
    boolean bool = com.tencent.mobileqq.utils.NetworkUtil.isNetworkAvailable(BaseApplicationImpl.context);
    paramObject = (Long)paramToServiceMsg.getAttribute(qhj.d);
    if (paramObject != null)
    {
      l2 = paramObject.longValue();
      if (l2 != -1L) {
        break label726;
      }
      i = 1;
      paramObject = (Long)paramToServiceMsg.getAttribute("sendPackageSize");
      localInteger2 = (Integer)paramToServiceMsg.getAttribute("sendNetType");
      localBoolean2 = (Boolean)paramToServiceMsg.getAttribute("sendIsNetConnected");
      localInteger1 = (Integer)paramToServiceMsg.getAttribute("retryIndex");
      localObject = (Long)paramToServiceMsg.getAttribute("firstSendTimestamps");
      l3 = System.currentTimeMillis();
      if (localObject == null) {
        break label732;
      }
      l2 = ((Long)localObject).longValue();
      localLong2 = (Long)paramToServiceMsg.getAttribute("optimizeID");
      str1 = (String)paramToServiceMsg.getAttribute("unCompressSucceed");
      localLong1 = (Long)paramToServiceMsg.getAttribute("unCompressTimeCost");
      str3 = (String)paramToServiceMsg.getAttribute("finalParseSucceed");
      localObject = (String)paramToServiceMsg.getAttribute("compressRatio");
      str2 = pkh.a();
      localBoolean1 = (Boolean)paramToServiceMsg.getAttribute("isFeedsPreload");
      localHashMap = new HashMap();
      localHashMap.put("retCode", String.valueOf(paramInt));
      localHashMap.put("channelID", String.valueOf(paramInteger));
      localHashMap.put("sendPackageSize", String.valueOf(paramObject));
      localHashMap.put("sendNetType", String.valueOf(localInteger2));
      if (!localBoolean2.booleanValue()) {
        break label738;
      }
      paramObject = "1";
      localHashMap.put("sendIsNetConnected", paramObject);
      localHashMap.put("recPackageSize", String.valueOf(l1));
      localHashMap.put("recNetType", String.valueOf(j));
      if (!bool) {
        break label745;
      }
      paramObject = "1";
      localHashMap.put("recIsNetConnected", paramObject);
      if (i == 0) {
        break label752;
      }
      paramObject = "0";
      localHashMap.put("refreshType", paramObject);
      localHashMap.put("retryIndex", String.valueOf(localInteger1));
      localHashMap.put("totalTimeCost", String.valueOf(l3 - l2));
      localHashMap.put("optimizeID", String.valueOf(localLong2));
      if (str3 == null) {
        break label759;
      }
      paramObject = str3;
      localHashMap.put("finalParseSucceed", paramObject);
      if (str2 == null) {
        break label766;
      }
      paramObject = str2;
      localHashMap.put("uin", paramObject);
      if ((localBoolean1 == null) || (!localBoolean1.booleanValue())) {
        break label773;
      }
      paramObject = "1";
      localHashMap.put("isFeedsPreload", paramObject);
      if (pjz.b(localLong2.longValue()))
      {
        if (str1 == null) {
          break label780;
        }
        paramObject = str1;
        localHashMap.put("unCompressSucceed", paramObject);
        localHashMap.put("unCompressTimeCost", String.valueOf(localLong1));
        if (localObject == null) {
          break label787;
        }
        paramObject = localObject;
        localHashMap.put("compressRatio", paramObject);
      }
      localHashMap.put("reqConsumeTime", "" + (System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey")));
      paramToServiceMsg.getAttributes().put("recPackageSize", Long.valueOf(l1));
      paramObject = new StringBuilder();
      paramInteger = localHashMap.entrySet().iterator();
      while (paramInteger.hasNext())
      {
        localObject = (Map.Entry)paramInteger.next();
        if (localObject != null) {
          paramObject.append((String)((Map.Entry)localObject).getKey()).append(" = ").append((String)((Map.Entry)localObject).getValue()).append("\n");
        }
      }
    }
    label726:
    label732:
    label738:
    label745:
    label752:
    label759:
    label766:
    for (bool = true;; bool = false)
    {
      pqe.a(paramObject, bool, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), localHashMap);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, List<ArticleInfo> paramList1, int paramInt1, int paramInt2, List<ArticleInfo> paramList2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    switch (((Integer)paramToServiceMsg.getAttribute(qhj.jdField_c_of_type_JavaLangString)).intValue())
    {
    default: 
      return;
    case 5: 
      long l1 = ((Long)paramToServiceMsg.getAttribute(qhj.d)).longValue();
      long l2 = ((Long)paramToServiceMsg.getAttribute(qhj.e)).longValue();
      int j = ((Integer)paramToServiceMsg.getAttribute(qhj.f)).intValue();
      int k = ((Integer)paramToServiceMsg.getAttribute(qhj.jdField_b_of_type_JavaLangString)).intValue();
      if (QLog.isColorLevel()) {
        if (paramList1 != null) {
          break label409;
        }
      }
      label409:
      for (int i = 0;; i = paramList1.size())
      {
        QLog.d("RIJGetArticleListHandler", 2, "handle0x68bGetSubscribeArticalList result=" + paramInt2 + " channelID=" + paramInt1 + " beginSeq=" + l1 + " endSeq=" + l2 + " articlecount=" + i + " reqType=" + k);
        i = -1;
        if ((paramToServiceMsg.getAttribute("auto_refresh_src") instanceof Integer)) {
          i = ((Integer)paramToServiceMsg.getAttribute("auto_refresh_src")).intValue();
        }
        QLog.d("RIJGetArticleListHandler", 2, "notifyAfterProcessRsp | refreshSrc : " + i);
        if ((i == 14) && (paramList1 != null) && (paramList1.size() > 0) && (paramList1.get(0) != null))
        {
          ((ArticleInfo)paramList1.get(0)).showBreathAnimation = true;
          QLog.d("RIJGetArticleListHandler", 1, "notifyAfterProcessRsp | biu autoRefresh showBreathAnimation ");
        }
        if ((paramInt2 != 154) || (j != 1)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RIJGetArticleListHandler", 2, "handle0x68bGetSubscribeArticalList re-request" + paramInt2 + " channelID=" + paramInt1 + " beginSeq=" + l1 + " endSeq=" + l2);
        }
        paramToServiceMsg.getAttributes().put(qhj.f, Integer.valueOf(2));
        this.jdField_a_of_type_Qep.a(paramToServiceMsg);
        return;
      }
      if (paramInt2 == 2901)
      {
        i = 0;
        if (paramToServiceMsg.getAttribute("retryIndex") != null) {
          i = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
        }
        if (i < 3)
        {
          QLog.d("RIJGetArticleListHandler", 1, new Object[] { "Retry req, handle0x68b, result = ", Integer.valueOf(paramInt2), ", fastResendRetryIndex = ", Integer.valueOf(i) });
          paramToServiceMsg.getAttributes().put("retryIndex", Integer.valueOf(i + 1));
          this.jdField_a_of_type_Qep.a(paramToServiceMsg);
        }
        for (;;)
        {
          udd.a.a(paramToServiceMsg, paramInt2);
          return;
          QLog.d("RIJGetArticleListHandler", 1, new Object[] { "Do not retry, result = ", Integer.valueOf(paramInt2), ", fastResendRetryIndex = ", Integer.valueOf(i) });
          this.jdField_a_of_type_Qep.a(paramBoolean1, paramInt1, paramBoolean2, paramList1, l1, l2, paramList2, paramArrayOfByte, paramToServiceMsg);
        }
      }
      this.jdField_a_of_type_Qep.a(paramBoolean1, paramInt1, paramBoolean2, paramList1, l1, l2, paramList2, paramArrayOfByte, paramToServiceMsg);
      return;
    }
    a(paramBoolean1, paramInt1, paramList2);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspBody paramRspBody, int paramInt)
  {
    Object localObject1 = (Integer)paramToServiceMsg.getAttributes().get("channelID");
    List localList = null;
    Object localObject2 = paramToServiceMsg.getAttribute("request_extra_data_key");
    int i = 0;
    if ((localObject2 instanceof Bundle)) {
      i = ((Bundle)localObject2).getInt("FeedsRefreshType");
    }
    qep.b(false);
    Object localObject3;
    boolean bool1;
    label317:
    Object localObject4;
    label494:
    boolean bool2;
    if (paramInt == 0)
    {
      long l = qxl.a(paramRspBody.uint64_client_swithes, 0L);
      if (qer.a.a(l, paramRspBody))
      {
        localObject3 = (oidb_cmd0x68b.RspGetFollowTabData)paramRspBody.msg_rsp_get_follow_tab_data.get();
        localObject2 = qxl.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).bytes_set_top_cookie);
        QLog.d("RIJGetArticleListHandler", 1, "follow request back cookie is " + qxl.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).bytes_set_top_cookie, ""));
        oidb_cmd0x68b.RspChannelArticle localRspChannelArticle;
        if (qxl.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_is_no_more_data, 0) == 1)
        {
          bool1 = true;
          localList = qet.a.a(this.jdField_a_of_type_Qep, (oidb_cmd0x68b.RspChannelArticle)paramRspBody.rspChannelArticle.get(), ((oidb_cmd0x68b.RspGetFollowTabData)localObject3).rpt_article_list);
          qet.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_has_followed_topic);
          qet.a.b(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_topic_reddot_update_num);
          qet.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_refresh_topic_update_info, ((oidb_cmd0x68b.RspGetFollowTabData)localObject3).topic_update_info);
          qet.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).uint32_hint_index, localList);
          qet.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject3).bytes_refresh_cookie);
          localObject3 = paramToServiceMsg.getAttributes().get("realTimeServiceKey");
          qer.a.a(localObject3, paramRspBody.bytes_new_style_params);
          if (!qer.a.b(l, paramRspBody)) {
            break label748;
          }
          localRspChannelArticle = (oidb_cmd0x68b.RspChannelArticle)paramRspBody.rspChannelArticle.get();
          if (!localRspChannelArticle.uint64_channel_id.has()) {
            break label741;
          }
          localObject3 = Integer.valueOf((int)localRspChannelArticle.uint64_channel_id.get());
          if (qxl.a(localRspChannelArticle.uint32_is_no_more_data, 0) != 1) {
            break label539;
          }
        }
        label532:
        label539:
        for (bool1 = true;; bool1 = false)
        {
          int j = a(paramToServiceMsg);
          localList = qes.a.a(paramToServiceMsg, ((Integer)localObject3).intValue(), i, j, localRspChannelArticle, localRspChannelArticle.rpt_article_list);
          localObject4 = qxm.a(localRspChannelArticle, localRspChannelArticle.rpt_deleted_article_list.get(), ((Integer)localObject3).intValue(), i, j);
          localObject2 = qxl.a(localRspChannelArticle.bytes_set_top_cookie);
          localObject1 = (pvp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
          ukq.a("AdDataLink", "handleAdvertisementResp in article request");
          ((pvp)localObject1).a().a(paramToServiceMsg, localRspChannelArticle);
          qes.a.a(localRspChannelArticle.bytes_nearby_cookie);
          localObject1 = qxl.a(localRspChannelArticle.bytes_pre_load_req_info);
          QLog.d("RIJGetArticleListHandler", 1, new Object[] { "feedsPreload, req info = ", localObject1 });
          qes.a.a(localList, localRspChannelArticle.rpt_back_off_group_info, ((Integer)localObject3).intValue());
          if (!qer.a.a(l)) {
            break label545;
          }
          paramToServiceMsg = (List)paramToServiceMsg.getAttribute("SubscriptionArticles");
          this.jdField_a_of_type_Qep.a(true, ((Integer)localObject3).intValue(), paramToServiceMsg, localList);
          return;
          bool1 = false;
          break;
        }
        label545:
        qer.a.a(paramRspBody.msg_rsp_trace);
        boolean bool3 = true;
        paramRspBody = (oidb_cmd0x68b.RspBody)localObject3;
        localObject3 = localObject2;
        bool2 = bool1;
        bool1 = bool3;
      }
    }
    for (localObject2 = localObject4;; localObject2 = null)
    {
      if (qku.a(paramToServiceMsg))
      {
        QLog.d("RIJGetArticleListHandler", 1, new Object[] { "feedsPreload, channelID = ", paramRspBody, ", result = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(bool1) });
        if (paramInt != 0) {
          break label532;
        }
        localObject4 = new qkp();
        paramToServiceMsg = ((qkp)localObject4).a(paramToServiceMsg).a(paramRspBody.intValue()).b(paramInt).a(localList).b((List)localObject2).a(bool1).b(bool2).a((byte[])localObject3);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
        for (;;)
        {
          paramToServiceMsg.a((String)localObject1);
          qkq.a().a((qkp)localObject4);
          return;
          localObject1 = "";
        }
      }
      a(paramToServiceMsg, localList, paramRspBody.intValue(), paramInt, (List)localObject2, bool1, bool2, (byte[])localObject3);
      return;
      label741:
      localObject3 = localObject1;
      break label317;
      label748:
      localObject4 = null;
      localObject3 = localObject1;
      localObject1 = null;
      break label494;
      localList = null;
      localObject2 = null;
      bool1 = false;
      break;
      paramRspBody = (oidb_cmd0x68b.RspBody)localObject1;
      localObject1 = null;
      bool1 = false;
      localObject3 = null;
      bool2 = false;
    }
  }
  
  private void a(List<Long> paramList, oidb_cmd0x68b.RspBody paramRspBody, long paramLong)
  {
    if (paramList == null)
    {
      QLog.d("RIJGetArticleListHandler", 2, "savePreloadRedPntPushArticle2Cache :  articleIDList is null");
      return;
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (paramList.equals(jdField_a_of_type_JavaUtilList))
        {
          jdField_a_of_type_ComTencentUtilPair = new com.tencent.util.Pair(paramList, paramRspBody);
          QLog.d("RIJGetArticleListHandler", 2, "savePreloadRedPntPushArticle2Cache :  [red_pnt_push preload resp cached] , article list [ " + qer.a(paramList) + " ]");
          i = 1;
          paramList = "";
        }
        try
        {
          paramRspBody = new JSONObject();
          paramRspBody.put("preload_red_pnt_push_articleID", paramLong);
          paramRspBody.put("preload_resp_result_code", 0);
          if (i == 0) {
            break;
          }
          i = 1;
        }
        catch (JSONException paramList)
        {
          String str;
          paramList.printStackTrace();
          continue;
          i = 0;
          continue;
        }
        paramRspBody.put("preload_resp_valid_flag", i);
        paramRspBody.put("preload_resp_invalid_reason", paramList);
        olh.a(null, "", "0X8009483", "0X8009483", 0, 0, paramRspBody.toString(), "", "", "", false);
        return;
      }
      str = "new_red_pnt_push";
      paramRspBody = str;
      if (jdField_a_of_type_JavaUtilList != null)
      {
        paramRspBody = str;
        if (jdField_a_of_type_JavaUtilList.size() == 0) {
          paramRspBody = "user_quick_click";
        }
      }
      QLog.d("RIJGetArticleListHandler", 2, "savePreloadRedPntPushArticle2Cache :  [red_pnt_push preload resp outdated] , article list [" + qer.a(paramList) + " ]");
      i = 0;
      paramList = paramRspBody;
    }
  }
  
  private void a(qxs paramqxs, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
    if (paramqxs.jdField_h_of_type_Int == 5)
    {
      localInnerMsg.uint32_jump_src_type.set(5);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_JavaLangString));
      if (!TextUtils.isEmpty(paramqxs.jdField_b_of_type_JavaLangString)) {
        localInnerMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_b_of_type_JavaLangString));
      }
      if (!TextUtils.isEmpty(paramqxs.jdField_c_of_type_JavaLangString))
      {
        localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_c_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("RIJGetArticleListHandler", 2, "add push contenxt:" + paramqxs.jdField_c_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      paramList.add(localInnerMsg);
      return;
      localInnerMsg.uint32_jump_src_type.set(3);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_JavaLangString));
      if (!TextUtils.isEmpty(paramqxs.jdField_b_of_type_JavaLangString)) {
        localInnerMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_b_of_type_JavaLangString));
      }
    }
  }
  
  private void a(qxs paramqxs, oidb_cmd0x68b.ReqBody paramReqBody) {}
  
  private void a(qxs paramqxs, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if (paramqxs.jdField_a_of_type_Rbl != null)
    {
      oidb_cmd0x68b.UserReadArticle localUserReadArticle = new oidb_cmd0x68b.UserReadArticle();
      localUserReadArticle.uint64_source.set(1L);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramqxs.jdField_a_of_type_Rbl.a.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
      localUserReadArticle.bytes_read_rowkeys.set(localArrayList);
      localArrayList = new ArrayList();
      paramqxs = paramqxs.jdField_a_of_type_Rbl.b.iterator();
      while (paramqxs.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramqxs.next()));
      }
      localUserReadArticle.bytes_unread_rowkeys.set(localArrayList);
      paramReqChannelPara.user_read_article.set(localUserReadArticle);
    }
  }
  
  private void a(qxs paramqxs, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x68b.SubscribeMsg localSubscribeMsg = new oidb_cmd0x68b.SubscribeMsg();
    localSubscribeMsg.uint64_source_article_id.set(paramqxs.jdField_c_of_type_Long);
    if (!TextUtils.isEmpty(paramqxs.jdField_b_of_type_JavaLangString)) {
      localSubscribeMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_b_of_type_JavaLangString));
    }
    localArrayList.add(localSubscribeMsg);
    paramReqChannelPara.rpt_subscribe_msg_list.set(localArrayList);
    paramReqChannelPara = new oidb_cmd0x68b.InnerMsg();
    paramReqChannelPara.uint32_jump_src_type.set(2);
    paramReqChannelPara.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramqxs.jdField_c_of_type_Long)));
    if (!TextUtils.isEmpty(paramqxs.jdField_b_of_type_JavaLangString)) {
      paramReqChannelPara.bytes_title.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_b_of_type_JavaLangString));
    }
    paramList.add(paramReqChannelPara);
  }
  
  private void a(oidb_cmd0x68b.ReqBody paramReqBody, ToServiceMsg paramToServiceMsg, long paramLong)
  {
    long l = 0L;
    try
    {
      i = paramReqBody.toByteArray().length;
      l = i;
    }
    catch (Exception paramReqBody)
    {
      for (;;)
      {
        int i;
        boolean bool;
        QLog.d("RIJGetArticleListHandler", 1, "get packageSize exception.");
      }
    }
    i = com.tencent.biz.common.util.NetworkUtil.getNetworkType(BaseApplicationImpl.context);
    bool = com.tencent.mobileqq.utils.NetworkUtil.isNetworkAvailable(BaseApplicationImpl.context);
    paramToServiceMsg.getAttributes().put("sendPackageSize", Long.valueOf(l));
    paramToServiceMsg.getAttributes().put("sendNetType", Integer.valueOf(i));
    paramToServiceMsg.getAttributes().put("sendIsNetConnected", Boolean.valueOf(bool));
    paramToServiceMsg.getAttributes().put("retryIndex", Integer.valueOf(0));
    paramToServiceMsg.getAttributes().put("firstSendTimestamps", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("optimizeID", Long.valueOf(paramLong));
    paramToServiceMsg.getAttributes().put("compressFlag", Boolean.valueOf(pjz.b(paramLong)));
  }
  
  private void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = null;
    Object localObject3 = Aladdin.getConfig(225);
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject3 = ((AladdinConfig)localObject3).getString("report_app_package_list", "");
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = ((String)localObject3).split("\\|");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.jdField_a_of_type_ArrayOfJavaLangString;
    }
    int k = localObject2.length;
    int i = 0;
    if (i < k)
    {
      localObject1 = localObject2[i];
      localObject3 = new oidb_cmd0x68b.PkgInstallInfo();
      ((oidb_cmd0x68b.PkgInstallInfo)localObject3).bytes_pkg_name.set(ByteStringMicro.copyFromUtf8((String)localObject1));
      PBUInt32Field localPBUInt32Field = ((oidb_cmd0x68b.PkgInstallInfo)localObject3).uint32_is_installed;
      if (bhfn.a(BaseApplicationImpl.getContext(), (String)localObject1)) {}
      for (int j = 1;; j = 0)
      {
        localPBUInt32Field.set(j);
        ((oidb_cmd0x68b.PkgInstallInfo)localObject3).uint32_platform_type.set(1);
        ((oidb_cmd0x68b.PkgInstallInfo)localObject3).bytes_version.set(ByteStringMicro.copyFromUtf8(bhfn.a(BaseApplicationImpl.getContext(), (String)localObject1)));
        localArrayList.add(localObject3);
        i += 1;
        break;
      }
    }
    paramReqChannelPara.rpt_pkg_install_info.set(localArrayList);
  }
  
  private void a(boolean paramBoolean, int paramInt, List<ArticleInfo> paramList)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJGetArticleListHandler.4(this, paramBoolean, paramInt, paramList));
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    boolean bool;
    try
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("recommendFlag");
      if (paramToServiceMsg == null)
      {
        QLog.d("RIJGetArticleListHandler", 2, "isPreloadRedPntPushArticleResp : req RECOMMEND_FLAG is null ");
        return false;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("RIJGetArticleListHandler", 2, "isPreloadRedPntPushArticleResp : req convert Object to Integer exception ", paramToServiceMsg);
      bool = false;
    }
    for (;;)
    {
      return bool;
      int i = ((Integer)paramToServiceMsg).intValue();
      if ((i & 0x40) != 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private boolean a(qxs paramqxs, long paramLong)
  {
    if ((qku.a(paramqxs)) && (!qku.b(paramqxs)))
    {
      paramqxs = qkq.a().a(paramqxs);
      if (paramqxs != null)
      {
        long l1 = System.currentTimeMillis();
        long l2 = ((Long)bmhv.a("sp_key_readinjoy_feeds_preload_loading_time", Long.valueOf(50L))).longValue();
        ThreadManager.getUIHandler().postDelayed(new RIJGetArticleListHandler.3(this, l2, l1, paramqxs, paramLong), l2);
        return true;
      }
    }
    return false;
  }
  
  private void b(qxs paramqxs, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramqxs.jdField_i_of_type_Boolean) && (paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo != null))
    {
      oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
      localInnerMsg.uint32_jump_src_type.set(4);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.articleID)));
      localInnerMsg.template_id.set(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.templateID);
      localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo.extraInfo));
      paramList.add(localInnerMsg);
    }
  }
  
  private void b(qxs paramqxs, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if ((paramqxs.jdField_b_of_type_Int == 0) && (pnn.a()))
    {
      paramqxs = new oidb_cmd0x68b.RefreshHistory();
      paramqxs.bytes_session_id.set(ByteStringMicro.copyFromUtf8(pno.a()));
      paramqxs.rpt_refresh_history.set(pno.a());
      if (QLog.isColorLevel()) {
        QLog.d("RIJGetArticleListHandler", 2, "session_id = " + pno.a() + ", history = " + pno.a().toString());
      }
      paramReqBody.msg_refresh_history.set(paramqxs);
    }
  }
  
  private void b(qxs paramqxs, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if ((paramqxs.jdField_d_of_type_JavaUtilList != null) && (paramqxs.jdField_d_of_type_JavaUtilList.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramqxs = paramqxs.jdField_d_of_type_JavaUtilList.iterator();
      while (paramqxs.hasNext()) {
        localArrayList.add(((qxr)paramqxs.next()).a());
      }
      paramReqChannelPara.rpt_pkg_install_info.set(localArrayList);
    }
  }
  
  private void b(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    String str = LbsManagerService.getCityCode();
    if (!TextUtils.isEmpty(str)) {
      paramReqChannelPara.bytes_lbs_data.set(ByteStringMicro.copyFrom(str.getBytes()));
    }
  }
  
  private void c(qxs paramqxs, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramqxs.jdField_c_of_type_JavaUtilList != null) && (!paramqxs.jdField_c_of_type_JavaUtilList.isEmpty()))
    {
      Iterator localIterator = paramqxs.jdField_c_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        puz localpuz = (puz)localIterator.next();
        QLog.d("RIJGetArticleListHandler", 2, "InsertArticleInfo :" + localpuz);
        oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
        localInnerMsg.uint32_jump_src_type.set(qxs.a(localpuz));
        localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localpuz.jdField_a_of_type_Long)));
        if (!TextUtils.isEmpty(paramqxs.jdField_c_of_type_JavaLangString)) {
          localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_c_of_type_JavaLangString));
        }
        localInnerMsg.uint64_algorithm_id.set(paramqxs.jdField_d_of_type_Long);
        localInnerMsg.uint32_strategy_id.set((int)paramqxs.jdField_e_of_type_Long);
        paramList.add(0, localInnerMsg);
        if (paramqxs.jdField_b_of_type_JavaUtilList == null) {
          paramqxs.jdField_b_of_type_JavaUtilList = new ArrayList();
        }
        paramqxs.jdField_b_of_type_JavaUtilList.add(0, Long.valueOf(localpuz.jdField_a_of_type_Long));
      }
    }
  }
  
  private void c(qxs paramqxs, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    int k = 1;
    pvp localpvp;
    int j;
    int i;
    if (paramqxs.jdField_h_of_type_Boolean)
    {
      localpvp = (pvp)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localpvp != null)
      {
        if (paramqxs.jdField_a_of_type_Long != -1L) {
          break label300;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RIJGetArticleListHandler", 2, "AdvertisementInfoModule reqAdvertisementList params.beginRecommendSeq = " + paramqxs.jdField_a_of_type_Long);
        }
        j = 30;
        pvj.a().a(paramqxs.jdField_b_of_type_Int, true);
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJGetArticleListHandler", 2, "AdvertisementInfoModule reqAdvertisementList  adStartPos = " + i + " adEndPos" + j);
      }
      if (pvj.a().a(paramqxs.jdField_b_of_type_Int))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJGetArticleListHandler", 2, "AdvertisementInfoModule reqAdvertisementList needRequestAdvertisement channelID= " + paramqxs.jdField_b_of_type_Int);
        }
        if ((paramqxs.jdField_g_of_type_Int == 2) || (paramqxs.jdField_g_of_type_Int == 4)) {
          k = 2;
        }
        localObject = new oha();
        uja.a((oha)localObject, paramqxs.jdField_b_of_type_Int);
        localObject = localpvp.a().a(paramqxs, paramqxs.jdField_b_of_type_Int, k, i, j, (oha)localObject);
        localpvp.a().a(paramqxs.jdField_b_of_type_Int, i, j);
        if (localObject != null)
        {
          paramReqBody.req_advertise_para.set((MessageMicro)localObject);
          olh.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
        }
      }
      return;
      label300:
      Object localObject = pvj.a().a(paramqxs.jdField_b_of_type_Int);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJGetArticleListHandler", 2, "AdvertisementInfoModule reqAdvertisementList posRange first = " + ((android.util.Pair)localObject).first + " sencond = " + ((android.util.Pair)localObject).second);
        }
        i = ((Integer)((android.util.Pair)localObject).second).intValue();
        j = i + qel.jdField_b_of_type_Int;
      }
      else
      {
        localObject = this.jdField_a_of_type_Qep.a().c(paramqxs.jdField_b_of_type_Int);
        if (localObject != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("RIJGetArticleListHandler", 2, "AdvertisementInfoModule reqAdvertisementList channelArticleMap = " + ((ConcurrentMap)localObject).size());
          }
          i = ((ConcurrentMap)localObject).size();
          j = i + qel.jdField_b_of_type_Int;
        }
        else
        {
          j = 0;
          i = 0;
        }
      }
    }
  }
  
  private void c(qxs paramqxs, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if (pqt.h())
    {
      paramqxs = a(paramqxs.jdField_b_of_type_Int);
      if ((paramqxs != null) && (paramqxs.size() > 0))
      {
        oidb_cmd0x68b.UserExposeArticle localUserExposeArticle = new oidb_cmd0x68b.UserExposeArticle();
        localUserExposeArticle.rpt_article.set(paramqxs);
        paramReqChannelPara.user_expose_article.set(localUserExposeArticle);
      }
    }
  }
  
  private void d(qxs paramqxs, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    Object localObject;
    if ((paramqxs.jdField_b_of_type_JavaUtilList != null) && (paramqxs.jdField_b_of_type_JavaUtilList.size() > 0))
    {
      localObject = paramqxs.jdField_b_of_type_JavaUtilList.iterator();
      if (((Iterator)localObject).hasNext())
      {
        Long localLong = (Long)((Iterator)localObject).next();
        oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
        if (paramqxs.jdField_h_of_type_Int > 0) {
          localInnerMsg.uint32_jump_src_type.set(paramqxs.jdField_h_of_type_Int);
        }
        for (;;)
        {
          localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localLong)));
          if (!TextUtils.isEmpty(paramqxs.jdField_c_of_type_JavaLangString))
          {
            localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_c_of_type_JavaLangString));
            if (QLog.isColorLevel()) {
              QLog.d("RIJGetArticleListHandler", 2, "add push contenxt:" + paramqxs.jdField_c_of_type_JavaLangString);
            }
          }
          localInnerMsg.uint64_algorithm_id.set(paramqxs.jdField_d_of_type_Long);
          localInnerMsg.uint32_strategy_id.set((int)paramqxs.jdField_e_of_type_Long);
          paramList.add(localInnerMsg);
          break;
          localInnerMsg.uint32_jump_src_type.set(1);
        }
      }
    }
    else if (paramqxs.jdField_b_of_type_Int == 40830)
    {
      localObject = new oidb_cmd0x68b.InnerMsg();
      if (paramqxs.jdField_h_of_type_Int <= 0) {
        break label306;
      }
      ((oidb_cmd0x68b.InnerMsg)localObject).uint32_jump_src_type.set(paramqxs.jdField_h_of_type_Int);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramqxs.jdField_c_of_type_JavaLangString))
      {
        ((oidb_cmd0x68b.InnerMsg)localObject).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramqxs.jdField_c_of_type_JavaLangString));
        if (QLog.isColorLevel()) {
          QLog.d("RIJGetArticleListHandler", 2, "troop subscribe add push contenxt:" + paramqxs.jdField_c_of_type_JavaLangString);
        }
      }
      paramList.add(localObject);
      return;
      label306:
      ((oidb_cmd0x68b.InnerMsg)localObject).uint32_jump_src_type.set(1);
    }
  }
  
  private void d(qxs paramqxs, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if (paramqxs.jdField_b_of_type_Int == 41403)
    {
      Object localObject = LbsManagerService.getCachedLbsInfo("nearby_readinjoy");
      if ((localObject != null) && (((SosoInterface.SosoLbsInfo)localObject).mLocation != null))
      {
        localObject = ((SosoInterface.SosoLbsInfo)localObject).mLocation;
        int i = (int)(((SosoInterface.SosoLocation)localObject).mLat02 * 1000000.0D);
        int j = (int)(((SosoInterface.SosoLocation)localObject).mLon02 * 1000000.0D);
        localObject = new feeds_info.LocationInfo();
        ((feeds_info.LocationInfo)localObject).uint32_latitude.set(i);
        ((feeds_info.LocationInfo)localObject).uint32_longitude.set(j);
        paramReqBody.location_info.set((MessageMicro)localObject);
      }
      if (paramqxs.jdField_a_of_type_Long != -1L)
      {
        paramqxs = (String)bmhv.a("readinjoy_nearby_people_last_refresh_cookie_sp_key", "");
        QLog.d("RIJGetArticleListHandler", 1, new Object[] { "load more article, nearby cookie = ", paramqxs });
        if (!TextUtils.isEmpty(paramqxs)) {
          paramReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramqxs));
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l1 = Long.valueOf(pkh.a()).longValue();
    localReqBody.uint64_uin.set(l1);
    localReqBody.uint32_network_type.set(qer.a());
    long l2 = pjz.a();
    l1 = 768L;
    if (pjz.b(l2))
    {
      l1 = 0x300 | 0x4000;
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "request0x68bFollowList addCompressFlag, optimizeID = ", Long.valueOf(l2) });
    }
    localReqBody.uint64_client_swithes.set(l1);
    oidb_cmd0x68b.ReqGetFollowTabPara localReqGetFollowTabPara = new oidb_cmd0x68b.ReqGetFollowTabPara();
    localReqGetFollowTabPara.uint64_channel_id.set(70L);
    localReqGetFollowTabPara.uint64_begin_recommend_seq.set(paramLong1);
    localReqGetFollowTabPara.uint64_end_recommend_seq.set(paramLong2);
    if (paramHashMap != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("topic update exp time ");
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        oidb_cmd0x68b.ExposeTopic localExposeTopic = new oidb_cmd0x68b.ExposeTopic();
        localExposeTopic.uint32_business_id.set(((Long)localEntry.getKey()).intValue());
        localExposeTopic.uint32_expose_time.set((int)(((Long)localEntry.getValue()).longValue() / 1000L));
        localReqGetFollowTabPara.rpt_expose_topic_list.add(localExposeTopic);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(((Long)localEntry.getKey()).intValue());
          localStringBuilder.append(" ");
          localStringBuilder.append(((Long)localEntry.getValue()).longValue() / 1000L);
          localStringBuilder.append(" ");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
      }
    }
    localReqBody.msg_get_follow_tab_feeds_para.set(localReqGetFollowTabPara);
    paramHashMap = this.jdField_a_of_type_Qep.a().a(Integer.valueOf(70));
    if ((paramHashMap != null) && (paramLong1 != 0L))
    {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramHashMap));
      if (QLog.isColorLevel()) {
        QLog.d("RIJGetArticleListHandler", 1, "request0x68bFollowList: cookie: " + new String(paramHashMap));
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_red_dot_cookie.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_refresh_cookie.set(ByteStringMicro.copyFrom(bhcu.decode(paramString2, 0)));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_last_feed_cookie.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.msg_get_follow_tab_feeds_para.uint32_update_times.set(paramInt1);
    localReqBody.msg_get_follow_tab_feeds_para.uint32_enter_topic_reddot_time.set(paramInt2);
    if (QLog.isColorLevel()) {
      QLog.d("RIJGetArticleListHandler", 1, "request0x68bFollowList: beginRecommendSeq : " + paramLong1 + ", endRecommendSeq : " + paramLong2 + ", upDate_times : " + paramInt1 + ", reddotCookie : " + paramString1 + ", lastRefreshCookie : " + paramString2 + ", lastFeedsCookie : " + paramString3);
    }
    paramHashMap = qxp.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    paramHashMap.getAttributes().put(qhj.jdField_c_of_type_JavaLangString, Integer.valueOf(5));
    l1 = paramLong1;
    if (paramLong1 == 0L) {
      l1 = -1L;
    }
    paramLong1 = paramLong2;
    if (paramLong2 == 0L) {
      paramLong1 = -1L;
    }
    paramHashMap.getAttributes().put(qhj.d, Long.valueOf(l1));
    paramHashMap.getAttributes().put(qhj.e, Long.valueOf(paramLong1));
    paramHashMap.getAttributes().put("isSingleHighLight", Boolean.valueOf(false));
    paramHashMap.getAttributes().put(qhj.f, Integer.valueOf(1));
    paramHashMap.getAttributes().put(qhj.jdField_b_of_type_JavaLangString, Integer.valueOf(0));
    paramHashMap.getAttributes().put("channelID", Integer.valueOf(70));
    a(localReqBody, paramHashMap, l2);
    pjz.a(paramHashMap, l2);
    this.jdField_a_of_type_Qep.a(paramHashMap);
    qep.b(true);
    udc.a().a(paramHashMap);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    Object localObject = (Boolean)paramToServiceMsg.getAttribute("compressFlag");
    if (localObject != null) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "handle0x68bGetArticleList isCompressEnable = ", Boolean.valueOf(bool) });
      int i = pjz.a(paramToServiceMsg, paramFromServiceMsg, paramObject, localRspBody, bool);
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "handle0x68bGetArticleList resp result code ", Integer.valueOf(i) });
      paramFromServiceMsg = (Integer)paramToServiceMsg.getAttributes().get("channelID");
      bool = a(paramToServiceMsg);
      localObject = (List)paramToServiceMsg.getAttributes().get("SubscriptionArticles");
      a(paramToServiceMsg, paramObject, i, paramFromServiceMsg);
      long l1;
      if (bool)
      {
        long l2 = -1L;
        l1 = l2;
        if (localObject != null)
        {
          l1 = l2;
          if (((List)localObject).size() >= 1) {
            l1 = ((Long)((List)localObject).get(0)).longValue();
          }
        }
        if (i == 0)
        {
          a((List)localObject, localRspBody, l1);
          QLog.d("RIJGetArticleListHandler", 2, "handle0x68bGetArticleList  : [red_pnt_push preload resp back] , article list [ " + qer.a((List)localObject) + " ]");
          return;
        }
      }
      try
      {
        paramFromServiceMsg = new JSONObject();
        paramFromServiceMsg.put("preload_red_pnt_push_articleID", l1);
        paramFromServiceMsg.put("preload_resp_result_code", i);
        olh.a(null, "", "0X8009483", "0X8009483", 0, 0, paramFromServiceMsg.toString(), "", "", "", false);
        udc.a().b(paramToServiceMsg);
        a(paramToServiceMsg, localRspBody, i);
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
  
  public void a(qxs paramqxs)
  {
    if (paramqxs == null) {
      QLog.d("RIJGetArticleListHandler", 2, "request0x68bChannelArticleList Request0x68bParams is null!");
    }
    long l1;
    do
    {
      return;
      l1 = System.currentTimeMillis();
    } while (a(paramqxs, l1));
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()))
    {
      QLog.d("RIJGetArticleListHandler", 1, "request0x68bChannelArticleList executorService has error !");
      return;
    }
    long l2 = qku.a(paramqxs);
    qep.b(true);
    qep.b(paramqxs.jdField_g_of_type_Int);
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJGetArticleListHandler.1(this, paramqxs, l1, l2));
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    if (paramBoolean) {}
    for (String str = "mChannelID = ? and mRecommendSeq < ?";; str = "mChannelID = ? and mRecommendSeq > ?")
    {
      QLog.i("RIJGetArticleListHandler", 1, "loadMoreChannelArticleList with selection=" + str + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJGetArticleListHandler.2(this, str, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7, paramBoolean, paramInt5));
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qit
 * JD-Core Version:    0.7.0.1
 */