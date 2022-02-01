package com.tencent.mobileqq.kandian.repo.handler;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentPoi;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.constant.RIJAdConstants.AdvertisementInfoModule;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJNetworkUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJPBFieldUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.ReadInJoyMSFHandlerUtils;
import com.tencent.mobileqq.kandian.glue.pts.RealTimeController;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.mobileqq.kandian.glue.report.ReadInJoySessionManager;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsExposureSwitchAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.common.RIJCUKingCardUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.common.RIJUGJsonUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJUserInfoSp;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyRefreshOptimizeUtil;
import com.tencent.mobileqq.kandian.repo.daily.ReadInJoyDailySettingModel;
import com.tencent.mobileqq.kandian.repo.db.struct.ArticleExposureInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils.CommonChannelDataHandle;
import com.tencent.mobileqq.kandian.repo.feeds.ArticleInfoModuleUtils.FollowChannelDataHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJArticleInfoRepo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.InsertArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LebaKDCellInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.PkgInstallInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyRequestParams.Request0x68bParams;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadUnRead;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadDataModule.PreloadCache;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadHelper;
import com.tencent.mobileqq.kandian.repo.feeds.preload.FeedsPreloadManager;
import com.tencent.mobileqq.kandian.repo.pts.network.WeakNetManager;
import com.tencent.mobileqq.kandian.repo.pts.network.WeakNetReportUtil;
import com.tencent.mobileqq.kandian.repo.ugc.RIJUGRuleSp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.Base64Util;
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

public class RIJGetArticleListHandler
  extends RIJBaseArticleInfoHandler
{
  public static int g = -2;
  private static volatile List<Long> i = new ArrayList();
  private static final Object j = new Object();
  private String[] h = { "com.tencent.weishi", "com.tencent.reading", "com.tencent.mtt", "com.tencent.qqlive", "com.tencent.news" };
  
  public RIJGetArticleListHandler(ArticleInfoModule paramArticleInfoModule, Handler paramHandler, AppInterface paramAppInterface, EntityManager paramEntityManager, ReadInJoyMSFService paramReadInJoyMSFService, ExecutorService paramExecutorService)
  {
    super(paramArticleInfoModule, paramHandler, paramAppInterface, paramEntityManager, paramReadInJoyMSFService, paramExecutorService);
  }
  
  private int a(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NotNull
  private ToServiceMsg a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqBody paramReqBody, long paramLong)
  {
    int k = paramRequest0x68bParams.b;
    boolean bool2 = false;
    Object localObject;
    if (k == 41403)
    {
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0xbf7", 3063, paramRequest0x68bParams.G, paramReqBody.toByteArray());
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "make 0xbf7 OIDB Pkg, beginSeq = ", Long.valueOf(paramRequest0x68bParams.c), ", endSeq = ", Long.valueOf(paramRequest0x68bParams.d) });
    }
    else
    {
      if ((DailyModeConfigHandler.c(paramRequest0x68bParams.b)) || (RIJShowKanDianTabSp.a(paramRequest0x68bParams.b)))
      {
        paramReqBody.bytes_style_version.set(ByteStringMicro.copyFromUtf8(RealTimeController.a("default_feeds")));
        if (RIJShowKanDianTabSp.d())
        {
          localObject = ReadInJoyDailySettingModel.a(paramRequest0x68bParams.b);
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            paramReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8((String)localObject));
          }
          localObject = ReadInJoyOidbHelper.a("OidbSvc.0xcba", 3258, 0, paramReqBody.toByteArray());
          ((ToServiceMsg)localObject).getAttributes().put("realTimeServiceKey", "default_feeds");
          QLog.d("RIJGetArticleListHandler", 1, new Object[] { "make 0xcba OIDB Pkg, beginSeq = ", Long.valueOf(paramRequest0x68bParams.c), ", endSeq = ", Long.valueOf(paramRequest0x68bParams.d) });
          break label237;
        }
      }
      localObject = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, paramRequest0x68bParams.G, paramReqBody.toByteArray());
    }
    label237:
    ((ToServiceMsg)localObject).getAttributes().put("NotifyType", Integer.valueOf(paramRequest0x68bParams.a));
    ((ToServiceMsg)localObject).getAttributes().put("BeginSeq", Long.valueOf(paramRequest0x68bParams.c));
    ((ToServiceMsg)localObject).getAttributes().put("EndSeq", Long.valueOf(paramRequest0x68bParams.d));
    ((ToServiceMsg)localObject).getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(1));
    ((ToServiceMsg)localObject).getAttributes().put("ReqType", Integer.valueOf(paramRequest0x68bParams.A));
    ((ToServiceMsg)localObject).getAttributes().put("recommendFlag", Integer.valueOf(paramRequest0x68bParams.F));
    if (paramRequest0x68bParams.i != null) {
      ((ToServiceMsg)localObject).getAttributes().put("SubscriptionArticles", paramRequest0x68bParams.i);
    }
    a(paramReqBody, (ToServiceMsg)localObject, paramLong);
    ReadInJoyRefreshOptimizeUtil.a((ToServiceMsg)localObject, paramLong);
    ((ToServiceMsg)localObject).getAttributes().put("channelID", new Integer(paramRequest0x68bParams.b));
    ((ToServiceMsg)localObject).getAttributes().put("isSingleHighLight", Boolean.valueOf(paramRequest0x68bParams.n));
    ((ToServiceMsg)localObject).getAttributes().put("clientSwithes", Integer.valueOf(paramRequest0x68bParams.y));
    paramReqBody = ((ToServiceMsg)localObject).getAttributes();
    if ((paramRequest0x68bParams.i != null) && (!paramRequest0x68bParams.i.isEmpty())) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramReqBody.put("isRedRefreshReq", Boolean.valueOf(bool1));
    paramReqBody = ((ToServiceMsg)localObject).getAttributes();
    boolean bool1 = bool2;
    if ((paramRequest0x68bParams.F & 0x100) != 0) {
      bool1 = true;
    }
    paramReqBody.put("isFeedsPreload", Boolean.valueOf(bool1));
    ((ToServiceMsg)localObject).getAttributes().put("isRetryRequest", Boolean.valueOf(c((ToServiceMsg)localObject)));
    return localObject;
  }
  
  public static String a(List<TencentPoi> paramList)
  {
    String str = "";
    Object localObject = str;
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return "";
      }
      double d = 1.7976931348623157E+308D;
      Iterator localIterator = paramList.iterator();
      paramList = str;
      for (;;)
      {
        localObject = paramList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (TencentPoi)localIterator.next();
        if (((TencentPoi)localObject).getDistance() <= d)
        {
          d = ((TencentPoi)localObject).getDistance();
          paramList = ((TencentPoi)localObject).getUid();
        }
      }
    }
    return localObject;
  }
  
  private List<oidb_cmd0x68b.ExposeArticleInfo> a(int paramInt)
  {
    if (!RIJKanDianFeedsExposureSwitchAladdinConfig.a()) {
      return null;
    }
    Object localObject1 = this.a.i().c(paramInt);
    if (localObject1 != null)
    {
      if (((ConcurrentMap)localObject1).isEmpty()) {
        return null;
      }
      Object localObject2 = new ArrayList(((ConcurrentMap)localObject1).values());
      Collections.sort((List)localObject2);
      localObject1 = localObject2;
      if (((List)localObject2).size() > 100) {
        localObject1 = ((List)localObject2).subList(0, 100);
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("add exposure data to 68b, channelID : ");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", infos : ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject2).toString());
      }
      localObject2 = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ArticleExposureInfo localArticleExposureInfo = (ArticleExposureInfo)((Iterator)localObject1).next();
        if (!TextUtils.isEmpty(localArticleExposureInfo.rowkey))
        {
          oidb_cmd0x68b.ExposeArticleInfo localExposeArticleInfo = new oidb_cmd0x68b.ExposeArticleInfo();
          localExposeArticleInfo.bytes_rowkeys.set(ByteStringMicro.copyFromUtf8(localArticleExposureInfo.rowkey));
          localExposeArticleInfo.uint32_feeds_type.set(localArticleExposureInfo.feedsType);
          localExposeArticleInfo.uint64_algorithm_id.set(localArticleExposureInfo.algorithmID);
          ((List)localObject2).add(localExposeArticleInfo);
        }
      }
      return localObject2;
    }
    return null;
  }
  
  @NotNull
  private List<oidb_cmd0x68b.InnerMsg> a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    ArrayList localArrayList = new ArrayList();
    b(paramRequest0x68bParams, localArrayList);
    if (!TextUtils.isEmpty(paramRequest0x68bParams.s)) {
      a(paramRequest0x68bParams, localArrayList);
    } else if (paramRequest0x68bParams.q != -1L) {
      a(paramRequest0x68bParams, paramReqChannelPara, localArrayList);
    }
    d(paramRequest0x68bParams, localArrayList);
    c(paramRequest0x68bParams, localArrayList);
    return localArrayList;
  }
  
  private void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
    if (paramRequest0x68bParams.D == 5)
    {
      localInnerMsg.uint32_jump_src_type.set(5);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.s));
      if (!TextUtils.isEmpty(paramRequest0x68bParams.t)) {
        localInnerMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.t));
      }
      if (!TextUtils.isEmpty(paramRequest0x68bParams.x))
      {
        localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.x));
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("add push contenxt:");
          localStringBuilder.append(paramRequest0x68bParams.x);
          QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      localInnerMsg.uint32_jump_src_type.set(3);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.s));
      if (!TextUtils.isEmpty(paramRequest0x68bParams.t)) {
        localInnerMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.t));
      }
    }
    paramList.add(localInnerMsg);
  }
  
  private void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqBody paramReqBody) {}
  
  private void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x68b.SubscribeMsg localSubscribeMsg = new oidb_cmd0x68b.SubscribeMsg();
    localSubscribeMsg.uint64_source_article_id.set(paramRequest0x68bParams.q);
    if (!TextUtils.isEmpty(paramRequest0x68bParams.t)) {
      localSubscribeMsg.bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.t));
    }
    localArrayList.add(localSubscribeMsg);
    paramReqChannelPara.rpt_subscribe_msg_list.set(localArrayList);
    paramReqChannelPara = new oidb_cmd0x68b.InnerMsg();
    paramReqChannelPara.uint32_jump_src_type.set(2);
    paramReqChannelPara.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramRequest0x68bParams.q)));
    if (!TextUtils.isEmpty(paramRequest0x68bParams.t)) {
      paramReqChannelPara.bytes_title.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.t));
    }
    paramList.add(paramReqChannelPara);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject, int paramInt, Integer paramInteger)
  {
    int k;
    long l1;
    try
    {
      k = ((byte[])paramObject).length;
      l1 = k;
    }
    catch (Exception paramObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report0x68bFields: ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.e("RIJGetArticleListHandler", 2, ((StringBuilder)localObject).toString());
      l1 = 0L;
    }
    int m = com.tencent.biz.common.util.NetworkUtil.b(BaseApplicationImpl.context);
    boolean bool1 = com.tencent.mobileqq.utils.NetworkUtil.isNetworkAvailable(BaseApplicationImpl.context);
    paramObject = (Long)paramToServiceMsg.getAttribute("BeginSeq");
    long l2;
    if (paramObject != null) {
      l2 = paramObject.longValue();
    } else {
      l2 = -1L;
    }
    if (l2 == -1L) {
      k = 1;
    } else {
      k = 0;
    }
    paramObject = (Long)paramToServiceMsg.getAttribute("sendPackageSize");
    Integer localInteger2 = (Integer)paramToServiceMsg.getAttribute("sendNetType");
    Boolean localBoolean2 = (Boolean)paramToServiceMsg.getAttribute("sendIsNetConnected");
    Integer localInteger1 = (Integer)paramToServiceMsg.getAttribute("retryIndex");
    Object localObject = (Long)paramToServiceMsg.getAttribute("firstSendTimestamps");
    long l3 = System.currentTimeMillis();
    if (localObject != null) {
      l2 = ((Long)localObject).longValue();
    } else {
      l2 = 0L;
    }
    Long localLong2 = (Long)paramToServiceMsg.getAttribute("optimizeID");
    String str1 = (String)paramToServiceMsg.getAttribute("unCompressSucceed");
    Long localLong1 = (Long)paramToServiceMsg.getAttribute("unCompressTimeCost");
    String str3 = (String)paramToServiceMsg.getAttribute("finalParseSucceed");
    localObject = (String)paramToServiceMsg.getAttribute("compressRatio");
    String str2 = RIJQQAppInterfaceUtil.d();
    Boolean localBoolean1 = (Boolean)paramToServiceMsg.getAttribute("isFeedsPreload");
    HashMap localHashMap = new HashMap();
    localHashMap.put("retCode", String.valueOf(paramInt));
    localHashMap.put("channelID", String.valueOf(paramInteger));
    localHashMap.put("sendPackageSize", String.valueOf(paramObject));
    localHashMap.put("sendNetType", String.valueOf(localInteger2));
    boolean bool2 = localBoolean2.booleanValue();
    paramInteger = "1";
    if (bool2) {
      paramObject = "1";
    } else {
      paramObject = "0";
    }
    localHashMap.put("sendIsNetConnected", paramObject);
    localHashMap.put("recPackageSize", String.valueOf(l1));
    localHashMap.put("recNetType", String.valueOf(m));
    if (bool1) {
      paramObject = "1";
    } else {
      paramObject = "0";
    }
    localHashMap.put("recIsNetConnected", paramObject);
    if (k != 0) {
      paramObject = "0";
    } else {
      paramObject = "1";
    }
    localHashMap.put("refreshType", paramObject);
    localHashMap.put("retryIndex", String.valueOf(localInteger1));
    localHashMap.put("totalTimeCost", String.valueOf(l3 - l2));
    localHashMap.put("optimizeID", String.valueOf(localLong2));
    if (str3 != null) {
      paramObject = str3;
    } else {
      paramObject = "";
    }
    localHashMap.put("finalParseSucceed", paramObject);
    if (str2 != null) {
      paramObject = str2;
    } else {
      paramObject = "0";
    }
    localHashMap.put("uin", paramObject);
    if ((localBoolean1 != null) && (localBoolean1.booleanValue())) {
      paramObject = paramInteger;
    } else {
      paramObject = "0";
    }
    localHashMap.put("isFeedsPreload", paramObject);
    if (ReadInJoyRefreshOptimizeUtil.a(localLong2.longValue()))
    {
      if (str1 != null) {
        paramObject = str1;
      } else {
        paramObject = "";
      }
      localHashMap.put("unCompressSucceed", paramObject);
      localHashMap.put("unCompressTimeCost", String.valueOf(localLong1));
      if (localObject != null) {
        paramObject = localObject;
      } else {
        paramObject = "";
      }
      localHashMap.put("compressRatio", paramObject);
    }
    paramObject = new StringBuilder();
    paramObject.append("");
    paramObject.append(System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"));
    localHashMap.put("reqConsumeTime", paramObject.toString());
    paramToServiceMsg.getAttributes().put("recPackageSize", Long.valueOf(l1));
    paramObject = new StringBuilder();
    paramInteger = localHashMap.entrySet().iterator();
    while (paramInteger.hasNext())
    {
      localObject = (Map.Entry)paramInteger.next();
      if (localObject != null) {
        if (((String)((Map.Entry)localObject).getKey()).equals("uin"))
        {
          paramObject.append((String)((Map.Entry)localObject).getKey());
          paramObject.append(" = ");
          paramObject.append(RIJLogUtil.a.a((String)((Map.Entry)localObject).getValue()));
          paramObject.append("\n");
        }
        else
        {
          paramObject.append((String)((Map.Entry)localObject).getKey());
          paramObject.append(" = ");
          paramObject.append((String)((Map.Entry)localObject).getValue());
          paramObject.append("\n");
        }
      }
    }
    paramObject = paramObject.toString();
    bool1 = true;
    QLog.d("RIJGetArticleListHandler", 1, new Object[] { "0x68b reportFields \n", paramObject });
    WeakNetReportUtil.a.a(localHashMap);
    paramObject = RIJQQAppInterfaceUtil.e();
    if (paramInt != 0) {
      bool1 = false;
    }
    RIJStatisticCollectorReport.a(paramObject, bool1, System.currentTimeMillis() - paramToServiceMsg.extraData.getLong("sendtimekey"), localHashMap);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, List<AbsBaseArticleInfo> paramList1, int paramInt1, int paramInt2, List<AbsBaseArticleInfo> paramList2, boolean paramBoolean1, boolean paramBoolean2, byte[] paramArrayOfByte)
  {
    int k = ((Integer)paramToServiceMsg.getAttribute("NotifyType")).intValue();
    if (k != 5)
    {
      if (k != 12) {}
      for (;;)
      {
        return;
        a(paramBoolean1, paramInt1, paramList2);
      }
    }
    long l1 = ((Long)paramToServiceMsg.getAttribute("BeginSeq")).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("EndSeq")).longValue();
    int m = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0x68b")).intValue();
    int n = ((Integer)paramToServiceMsg.getAttribute("ReqType")).intValue();
    if (QLog.isColorLevel())
    {
      if (paramList1 == null) {
        k = 0;
      } else {
        k = paramList1.size();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handle0x68bGetSubscribeArticalList result=");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" channelID=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" beginSeq=");
      localStringBuilder.append(l1);
      localStringBuilder.append(" endSeq=");
      localStringBuilder.append(l2);
      localStringBuilder.append(" articlecount=");
      localStringBuilder.append(k);
      localStringBuilder.append(" reqType=");
      localStringBuilder.append(n);
      QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
    }
    k = -1;
    if ((paramToServiceMsg.getAttribute("auto_refresh_src") instanceof Integer)) {
      k = ((Integer)paramToServiceMsg.getAttribute("auto_refresh_src")).intValue();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notifyAfterProcessRsp | refreshSrc : ");
    localStringBuilder.append(k);
    QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
    if ((k == 14) && (paramList1 != null) && (paramList1.size() > 0) && (paramList1.get(0) != null))
    {
      ((AbsBaseArticleInfo)paramList1.get(0)).showBreathAnimation = true;
      QLog.d("RIJGetArticleListHandler", 1, "notifyAfterProcessRsp | biu autoRefresh showBreathAnimation ");
    }
    if ((paramInt2 == 154) && (m == 1))
    {
      if (QLog.isColorLevel())
      {
        paramList1 = new StringBuilder();
        paramList1.append("handle0x68bGetSubscribeArticalList re-request");
        paramList1.append(paramInt2);
        paramList1.append(" channelID=");
        paramList1.append(paramInt1);
        paramList1.append(" beginSeq=");
        paramList1.append(l1);
        paramList1.append(" endSeq=");
        paramList1.append(l2);
        QLog.d("RIJGetArticleListHandler", 2, paramList1.toString());
      }
      paramToServiceMsg.getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(2));
      this.a.sendPbReq(paramToServiceMsg);
      return;
    }
    if (paramInt2 == 2901)
    {
      if (paramToServiceMsg.getAttribute("retryIndex") != null) {
        k = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
      } else {
        k = 0;
      }
      if (k < 3)
      {
        QLog.d("RIJGetArticleListHandler", 1, new Object[] { "Retry req, handle0x68b, result = ", Integer.valueOf(paramInt2), ", fastResendRetryIndex = ", Integer.valueOf(k) });
        paramToServiceMsg.getAttributes().put("retryIndex", Integer.valueOf(k + 1));
        this.a.sendPbReq(paramToServiceMsg);
      }
      else
      {
        QLog.d("RIJGetArticleListHandler", 1, new Object[] { "Do not retry, result = ", Integer.valueOf(paramInt2), ", fastResendRetryIndex = ", Integer.valueOf(k) });
        this.a.a(paramBoolean1, paramInt1, paramBoolean2, paramList1, l1, l2, paramList2, paramArrayOfByte, paramToServiceMsg);
      }
      WeakNetReportUtil.a.a(paramToServiceMsg, paramInt2);
      return;
    }
    this.a.a(paramBoolean1, paramInt1, paramBoolean2, paramList1, l1, l2, paramList2, paramArrayOfByte, paramToServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspBody paramRspBody, int paramInt)
  {
    Integer localInteger = (Integer)paramToServiceMsg.getAttributes().get("channelID");
    Object localObject1 = paramToServiceMsg.getAttribute("request_extra_data_key");
    int k;
    if ((localObject1 instanceof Bundle)) {
      k = ((Bundle)localObject1).getInt("FeedsRefreshType");
    } else {
      k = 0;
    }
    ArticleInfoModule.b(false);
    Object localObject2;
    byte[] arrayOfByte;
    boolean bool1;
    Object localObject3;
    boolean bool2;
    if (paramInt == 0)
    {
      long l = RIJPBFieldUtils.a(paramRspBody.uint64_client_swithes, 0L);
      if (ArticleInfoModuleUtils.a.a(l, paramRspBody))
      {
        localObject2 = (oidb_cmd0x68b.RspGetFollowTabData)paramRspBody.msg_rsp_get_follow_tab_data.get();
        arrayOfByte = RIJPBFieldUtils.b(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_set_top_cookie);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("follow request back cookie is ");
        ((StringBuilder)localObject1).append(RIJPBFieldUtils.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_set_top_cookie, ""));
        QLog.d("RIJGetArticleListHandler", 1, ((StringBuilder)localObject1).toString());
        if (RIJPBFieldUtils.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_is_no_more_data, 0) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localObject1 = ArticleInfoModuleUtils.FollowChannelDataHandler.a.a(this.a, (oidb_cmd0x68b.RspChannelArticle)paramRspBody.rspChannelArticle.get(), ((oidb_cmd0x68b.RspGetFollowTabData)localObject2).rpt_article_list);
        ArticleInfoModuleUtils.FollowChannelDataHandler.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_has_followed_topic);
        ArticleInfoModuleUtils.FollowChannelDataHandler.a.b(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_topic_reddot_update_num);
        ArticleInfoModuleUtils.FollowChannelDataHandler.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_refresh_topic_update_info, ((oidb_cmd0x68b.RspGetFollowTabData)localObject2).topic_update_info);
        ArticleInfoModuleUtils.FollowChannelDataHandler.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).uint32_hint_index, (List)localObject1);
        ArticleInfoModuleUtils.FollowChannelDataHandler.a.a(((oidb_cmd0x68b.RspGetFollowTabData)localObject2).bytes_refresh_cookie);
      }
      else
      {
        localObject1 = null;
        bool1 = false;
        arrayOfByte = null;
      }
      localObject2 = paramToServiceMsg.getAttributes().get("realTimeServiceKey");
      ArticleInfoModuleUtils.a.a(localObject2, paramRspBody.bytes_new_style_params);
      if (ArticleInfoModuleUtils.a.b(l, paramRspBody))
      {
        oidb_cmd0x68b.RspChannelArticle localRspChannelArticle = (oidb_cmd0x68b.RspChannelArticle)paramRspBody.rspChannelArticle.get();
        if (localRspChannelArticle.uint64_channel_id.has()) {
          localInteger = Integer.valueOf((int)localRspChannelArticle.uint64_channel_id.get());
        }
        if (RIJPBFieldUtils.a(localRspChannelArticle.uint32_is_no_more_data, 0) == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        int m = b(paramToServiceMsg);
        localObject1 = ArticleInfoModuleUtils.CommonChannelDataHandle.a;
        int n = localInteger.intValue();
        localObject2 = localRspChannelArticle.rpt_article_list;
        localObject1 = ((ArticleInfoModuleUtils.CommonChannelDataHandle)localObject1).a(paramToServiceMsg, n, k, m, localRspChannelArticle, (PBRepeatMessageField)localObject2);
        localObject2 = ReadInJoyMSFHandlerUtils.a(localRspChannelArticle, localRspChannelArticle.rpt_deleted_article_list.get(), localInteger.intValue(), k, m);
        arrayOfByte = RIJPBFieldUtils.b(localRspChannelArticle.bytes_set_top_cookie);
        localObject3 = (ReadInJoyLogicManager)this.c.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
        ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("AdDataLink", "handleAdvertisementResp in article request");
        ((ReadInJoyLogicManager)localObject3).getReadInJoyLogicEngine().a(paramToServiceMsg, localRspChannelArticle);
        ArticleInfoModuleUtils.CommonChannelDataHandle.a.a(localRspChannelArticle.bytes_nearby_cookie);
        localObject3 = RIJPBFieldUtils.a(localRspChannelArticle.bytes_pre_load_req_info);
        QLog.d("RIJGetArticleListHandler", 1, new Object[] { "feedsPreload, req info = ", localObject3 });
        ArticleInfoModuleUtils.CommonChannelDataHandle.a.a((List)localObject1, localRspChannelArticle.rpt_back_off_group_info, localInteger.intValue());
      }
      else
      {
        localObject3 = null;
        localObject2 = null;
      }
      if (ArticleInfoModuleUtils.a.a(l))
      {
        paramToServiceMsg = (List)paramToServiceMsg.getAttribute("SubscriptionArticles");
        this.a.a(true, localInteger.intValue(), paramToServiceMsg, (List)localObject1);
        return;
      }
      ArticleInfoModuleUtils.a.a(paramRspBody.msg_rsp_trace);
      paramRspBody = (oidb_cmd0x68b.RspBody)localObject3;
      bool2 = true;
    }
    else
    {
      localObject1 = null;
      localObject2 = null;
      bool2 = false;
      bool1 = false;
      arrayOfByte = null;
      paramRspBody = null;
    }
    if (FeedsPreloadHelper.a(paramToServiceMsg))
    {
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "feedsPreload, channelID = ", localInteger, ", result = ", Integer.valueOf(paramInt), ", success = ", Boolean.valueOf(bool2) });
      if (paramInt == 0)
      {
        localObject3 = new FeedsPreloadDataModule.PreloadCache();
        paramToServiceMsg = ((FeedsPreloadDataModule.PreloadCache)localObject3).a(paramToServiceMsg).a(localInteger.intValue()).b(paramInt).a((List)localObject1).b((List)localObject2).a(bool2).b(bool1).a(arrayOfByte);
        if (TextUtils.isEmpty(paramRspBody)) {
          paramRspBody = "";
        }
        paramToServiceMsg.a(paramRspBody);
        FeedsPreloadManager.a().a((FeedsPreloadDataModule.PreloadCache)localObject3);
      }
      return;
    }
    a(paramToServiceMsg, (List)localObject1, localInteger.intValue(), paramInt, (List)localObject2, bool2, bool1, arrayOfByte);
  }
  
  private void a(List<Long> paramList, oidb_cmd0x68b.RspBody paramRspBody, long paramLong)
  {
    if (paramList == null)
    {
      QLog.d("RIJGetArticleListHandler", 2, "savePreloadRedPntPushArticle2Cache :  articleIDList is null");
      return;
    }
    Object localObject2 = j;
    paramRspBody = "";
    for (;;)
    {
      try
      {
        boolean bool = paramList.equals(i);
        int m = 1;
        Object localObject1;
        if (bool)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("savePreloadRedPntPushArticle2Cache :  [red_pnt_push preload resp cached] , article list [ ");
          ((StringBuilder)localObject1).append(ArticleInfoModuleUtils.a(paramList));
          ((StringBuilder)localObject1).append(" ]");
          QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject1).toString());
          k = 1;
        }
        else
        {
          localObject1 = "new_red_pnt_push";
          paramRspBody = (oidb_cmd0x68b.RspBody)localObject1;
          if (i != null)
          {
            paramRspBody = (oidb_cmd0x68b.RspBody)localObject1;
            if (i.size() == 0) {
              paramRspBody = "user_quick_click";
            }
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("savePreloadRedPntPushArticle2Cache :  [red_pnt_push preload resp outdated] , article list [");
          ((StringBuilder)localObject1).append(ArticleInfoModuleUtils.a(paramList));
          ((StringBuilder)localObject1).append(" ]");
          QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject1).toString());
          k = 0;
        }
        try
        {
          paramList = new JSONObject();
          paramList.put("preload_red_pnt_push_articleID", paramLong);
          paramList.put("preload_resp_result_code", 0);
          if (k == 0) {
            break label281;
          }
          k = m;
          paramList.put("preload_resp_valid_flag", k);
          paramList.put("preload_resp_invalid_reason", paramRspBody);
          PublicAccountReportUtils.a(null, "", "0X8009483", "0X8009483", 0, 0, paramList.toString(), "", "", "", false);
        }
        catch (Throwable paramList)
        {
          paramList.printStackTrace();
        }
        return;
      }
      finally {}
      label281:
      int k = 0;
    }
  }
  
  private void a(oidb_cmd0x68b.ReqBody paramReqBody, ToServiceMsg paramToServiceMsg, long paramLong)
  {
    try
    {
      k = paramReqBody.toByteArray().length;
      l = k;
    }
    catch (Exception paramReqBody)
    {
      int k;
      long l;
      label15:
      boolean bool;
      break label15;
    }
    QLog.d("RIJGetArticleListHandler", 1, "get packageSize exception.");
    l = 0L;
    k = RIJNetworkUtils.f(BaseApplicationImpl.context);
    bool = RIJNetworkUtils.e(BaseApplicationImpl.context);
    paramToServiceMsg.getAttributes().put("sendPackageSize", Long.valueOf(l));
    paramToServiceMsg.getAttributes().put("sendNetType", Integer.valueOf(k));
    paramToServiceMsg.getAttributes().put("sendIsNetConnected", Boolean.valueOf(bool));
    paramToServiceMsg.getAttributes().put("retryIndex", Integer.valueOf(0));
    paramToServiceMsg.getAttributes().put("firstSendTimestamps", Long.valueOf(System.currentTimeMillis()));
    paramToServiceMsg.getAttributes().put("optimizeID", Long.valueOf(paramLong));
    paramToServiceMsg.getAttributes().put("compressFlag", Boolean.valueOf(ReadInJoyRefreshOptimizeUtil.a(paramLong)));
  }
  
  private void a(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(boolean paramBoolean, int paramInt, List<AbsBaseArticleInfo> paramList)
  {
    this.b.post(new RIJGetArticleListHandler.4(this, paramBoolean, paramInt, paramList));
  }
  
  private boolean a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, long paramLong)
  {
    if ((FeedsPreloadHelper.a(paramRequest0x68bParams)) && (!FeedsPreloadHelper.b(paramRequest0x68bParams)))
    {
      paramRequest0x68bParams = FeedsPreloadManager.a().a(paramRequest0x68bParams);
      if (paramRequest0x68bParams != null)
      {
        long l1 = System.currentTimeMillis();
        long l2 = ((Long)RIJSPUtils.b("sp_key_readinjoy_feeds_preload_loading_time", Long.valueOf(50L))).longValue();
        ThreadManager.getUIHandler().postDelayed(new RIJGetArticleListHandler.3(this, l2, l1, paramRequest0x68bParams, paramLong), l2);
        return true;
      }
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg == null) {
      return false;
    }
    try
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("recommendFlag");
      if (paramToServiceMsg == null)
      {
        QLog.d("RIJGetArticleListHandler", 2, "isPreloadRedPntPushArticleResp : req RECOMMEND_FLAG is null ");
        return false;
      }
      int k = ((Integer)paramToServiceMsg).intValue();
      if ((k & 0x40) != 0) {
        return true;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.d("RIJGetArticleListHandler", 2, "isPreloadRedPntPushArticleResp : req convert Object to Integer exception ", paramToServiceMsg);
    }
    return false;
  }
  
  private int b(ToServiceMsg paramToServiceMsg)
  {
    try
    {
      paramToServiceMsg = paramToServiceMsg.getAttribute("recommendFlag");
      if (paramToServiceMsg == null) {
        return 0;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(paramToServiceMsg);
      QLog.d("RIJGetArticleListHandler", 1, localStringBuilder.toString());
      int k = ((Integer)paramToServiceMsg).intValue();
      return k;
    }
    catch (Exception paramToServiceMsg) {}
    return 0;
  }
  
  private ToServiceMsg b(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    if (paramRequest0x68bParams == null) {
      return null;
    }
    if (paramRequest0x68bParams.b == -1) {
      return null;
    }
    paramRequest0x68bParams.a = 5;
    paramRequest0x68bParams.e = true;
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    long l1 = ReadInJoyRefreshOptimizeUtil.a();
    long l2 = Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue();
    localReqBody.uint64_uin.set(l2);
    localReqBody.uint32_network_type.set(ArticleInfoModuleUtils.a());
    oidb_cmd0x68b.ReqChannelPara localReqChannelPara = new oidb_cmd0x68b.ReqChannelPara();
    localReqChannelPara.uint64_channel_id.set(paramRequest0x68bParams.b);
    localReqChannelPara.uint32_req_channel_list.set(1);
    a(localReqChannelPara);
    RIJUGRuleSp.a(localReqChannelPara, String.valueOf(paramRequest0x68bParams.b));
    localReqChannelPara.uint32_residence_time.set((int)RIJUGRuleSp.a(paramRequest0x68bParams.b));
    if (paramRequest0x68bParams.c != -1L) {
      localReqChannelPara.uint64_begin_recommend_seq.set(paramRequest0x68bParams.c);
    }
    if (paramRequest0x68bParams.d != -1L) {
      localReqChannelPara.uint64_end_recommend_seq.set(paramRequest0x68bParams.d);
    }
    localReqChannelPara.uint32_req_article_list.set(a(paramRequest0x68bParams.e), paramRequest0x68bParams.e);
    localReqChannelPara.uint32_req_deleted_article_list.set(a(paramRequest0x68bParams.f), paramRequest0x68bParams.f);
    if (paramRequest0x68bParams.g != null) {
      localReqChannelPara.rpt_curr_article_list.set(paramRequest0x68bParams.g);
    }
    if (StudyModeManager.h())
    {
      paramRequest0x68bParams.F |= 0x2000;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("is study mode! channelID=");
      ((StringBuilder)localObject1).append(paramRequest0x68bParams.b);
      QLog.d("RIJGetArticleListHandler", 1, ((StringBuilder)localObject1).toString());
    }
    localReqChannelPara.uint32_req_recommend_flag.set(paramRequest0x68bParams.F);
    localReqChannelPara.bytes_req_recommend_json.set(ByteStringMicro.copyFromUtf8(RIJTransparentlyContentHandler.a.a(this.c)));
    localReqChannelPara.bytes_req_ug_interface_data.set(ByteStringMicro.copyFromUtf8(RIJUGJsonUtils.b()));
    localReqChannelPara.uint32_req_video_list.set(a(paramRequest0x68bParams.j));
    localReqChannelPara.uint32_req_picture_list.set(a(paramRequest0x68bParams.k));
    localReqChannelPara.uint32_need_force_set_top.set(a(paramRequest0x68bParams.l));
    if (paramRequest0x68bParams.m != null) {
      localReqChannelPara.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramRequest0x68bParams.m));
    }
    if (paramRequest0x68bParams.o != null) {
      localReqChannelPara.bytes_device_id.set(ByteStringMicro.copyFrom(paramRequest0x68bParams.o));
    }
    localReqChannelPara.uint32_update_times.set(paramRequest0x68bParams.p);
    localReqChannelPara.uint32_req_media_specs.set(1);
    if (!RIJShowKanDianTabSp.b(paramRequest0x68bParams.r)) {
      localReqChannelPara.uint32_is_support_video_with_small_picture.set(1);
    }
    localReqChannelPara.uint32_is_support_packinfo.set(1);
    localReqChannelPara.uint32_privacy_status.set(RIJUserInfoSp.a());
    boolean bool = TextUtils.isEmpty(Build.BRAND);
    String str = "";
    if (!bool) {
      localObject1 = Build.BRAND;
    } else {
      localObject1 = "";
    }
    localReqChannelPara.bytes_manufacturer.set(ByteStringMicro.copyFromUtf8((String)localObject1));
    if (!TextUtils.isEmpty(Build.MODEL)) {
      str = Build.MODEL;
    }
    localReqChannelPara.bytes_device_brand_and_model.set(ByteStringMicro.copyFromUtf8(str));
    if (paramRequest0x68bParams.K != null)
    {
      localObject2 = new oidb_cmd0x68b.ChannelLocationInfo();
      ((oidb_cmd0x68b.ChannelLocationInfo)localObject2).city.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.K.city));
      ((oidb_cmd0x68b.ChannelLocationInfo)localObject2).province.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.K.province));
      ((oidb_cmd0x68b.ChannelLocationInfo)localObject2).nation.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.K.country));
      ((oidb_cmd0x68b.ChannelLocationInfo)localObject2).city_code.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.K.cityCode));
      localReqChannelPara.msg_channel_location_info.set((MessageMicro)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("0x68b request positionInfo = ");
        ((StringBuilder)localObject2).append(paramRequest0x68bParams.K);
        QLog.i("RIJGetArticleListHandler", 1, ((StringBuilder)localObject2).toString());
      }
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("0x68b request brand = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(", model = ");
    ((StringBuilder)localObject2).append(str);
    QLog.i("RIJGetArticleListHandler", 1, ((StringBuilder)localObject2).toString());
    Object localObject1 = a(paramRequest0x68bParams, localReqChannelPara);
    ReadInJoyChannelGuidingManager.a(paramRequest0x68bParams, (List)localObject1);
    if (paramRequest0x68bParams.i != null) {
      localReqChannelPara.rpt_subscription_article_list.set(paramRequest0x68bParams.i);
    }
    b(paramRequest0x68bParams, localReqChannelPara);
    b(localReqChannelPara);
    localReqChannelPara.rpt_inner_msg_list.set((List)localObject1);
    localReqChannelPara.uint32_req_is_disp_timestamp.set(1);
    localReqChannelPara.uint32_is_support_gallery.set(1);
    localReqChannelPara.uint32_req_picture_number.set(1);
    c(paramRequest0x68bParams, localReqChannelPara);
    d(paramRequest0x68bParams, localReqChannelPara);
    int k = ((Integer)RIJSPUtils.b("key_sp_is_readinjoy_youngster", Integer.valueOf(0))).intValue();
    localReqChannelPara.uint32_youngster_status.set(k);
    localReqBody.reqChannelPara.set(localReqChannelPara);
    localReqBody.reqChannelPara.setHasFlag(true);
    localReqBody.uint32_req_dislike_type.set(paramRequest0x68bParams.w);
    a(paramRequest0x68bParams, localReqBody);
    if (ReadInJoyRefreshOptimizeUtil.a(l1)) {
      ReadInJoyRefreshOptimizeUtil.a(paramRequest0x68bParams);
    }
    localReqBody.uint64_client_swithes.set(paramRequest0x68bParams.y);
    localReqBody.enum_refresh_type.set(paramRequest0x68bParams.A);
    b(paramRequest0x68bParams, localReqBody);
    c(paramRequest0x68bParams, localReqBody);
    localReqBody.uint32_req_sim_type.set(RIJCUKingCardUtils.a());
    d(paramRequest0x68bParams, localReqBody);
    e(paramRequest0x68bParams, localReqBody);
    return a(paramRequest0x68bParams, localReqBody, l1);
  }
  
  private List<Long> b(List<AbsBaseArticleInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(Long.valueOf(((AbsBaseArticleInfo)paramList.next()).mRecommendSeq));
      }
      return localArrayList;
    }
    return null;
  }
  
  private void b(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramRequest0x68bParams.B) && (paramRequest0x68bParams.C != null))
    {
      oidb_cmd0x68b.InnerMsg localInnerMsg = new oidb_cmd0x68b.InnerMsg();
      localInnerMsg.uint32_jump_src_type.set(4);
      localInnerMsg.bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(paramRequest0x68bParams.C.articleID)));
      localInnerMsg.template_id.set(paramRequest0x68bParams.C.templateID);
      localInnerMsg.bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.C.extraInfo));
      paramList.add(localInnerMsg);
    }
  }
  
  private void b(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if ((paramRequest0x68bParams.b == 0) && (RIJQQAppInterfaceUtil.g()))
    {
      paramRequest0x68bParams = new oidb_cmd0x68b.RefreshHistory();
      paramRequest0x68bParams.bytes_session_id.set(ByteStringMicro.copyFromUtf8(RIJThreadHandler.e()));
      paramRequest0x68bParams.rpt_refresh_history.set(RIJThreadHandler.d());
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("session_id = ");
        localStringBuilder.append(RIJThreadHandler.e());
        localStringBuilder.append(", history = ");
        localStringBuilder.append(RIJThreadHandler.d().toString());
        QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
      }
      paramReqBody.msg_refresh_history.set(paramRequest0x68bParams);
    }
  }
  
  private void b(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if (paramRequest0x68bParams.I != null)
    {
      oidb_cmd0x68b.UserReadArticle localUserReadArticle = new oidb_cmd0x68b.UserReadArticle();
      localUserReadArticle.uint64_source.set(1L);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramRequest0x68bParams.I.c.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)localIterator.next()));
      }
      localUserReadArticle.bytes_read_rowkeys.set(localArrayList);
      localArrayList = new ArrayList();
      paramRequest0x68bParams = paramRequest0x68bParams.I.d.iterator();
      while (paramRequest0x68bParams.hasNext()) {
        localArrayList.add(ByteStringMicro.copyFromUtf8((String)paramRequest0x68bParams.next()));
      }
      localUserReadArticle.bytes_unread_rowkeys.set(localArrayList);
      paramReqChannelPara.user_read_article.set(localUserReadArticle);
    }
  }
  
  private void b(oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    String str = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
    if (!TextUtils.isEmpty(str)) {
      paramReqChannelPara.bytes_lbs_data.set(ByteStringMicro.copyFrom(str.getBytes()));
    }
  }
  
  private void c(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    if ((paramRequest0x68bParams.E != null) && (!paramRequest0x68bParams.E.isEmpty()))
    {
      Iterator localIterator = paramRequest0x68bParams.E.iterator();
      while (localIterator.hasNext())
      {
        InsertArticleInfo localInsertArticleInfo = (InsertArticleInfo)localIterator.next();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("InsertArticleInfo :");
        ((StringBuilder)localObject).append(localInsertArticleInfo);
        QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject).toString());
        localObject = new oidb_cmd0x68b.InnerMsg();
        ((oidb_cmd0x68b.InnerMsg)localObject).uint32_jump_src_type.set(ReadInJoyRequestParams.Request0x68bParams.a(localInsertArticleInfo));
        ((oidb_cmd0x68b.InnerMsg)localObject).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localInsertArticleInfo.a)));
        if (!TextUtils.isEmpty(paramRequest0x68bParams.x)) {
          ((oidb_cmd0x68b.InnerMsg)localObject).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.x));
        }
        ((oidb_cmd0x68b.InnerMsg)localObject).uint64_algorithm_id.set(paramRequest0x68bParams.u);
        ((oidb_cmd0x68b.InnerMsg)localObject).uint32_strategy_id.set((int)paramRequest0x68bParams.v);
        paramList.add(0, localObject);
        if (paramRequest0x68bParams.i == null) {
          paramRequest0x68bParams.i = new ArrayList();
        }
        paramRequest0x68bParams.i.add(0, Long.valueOf(localInsertArticleInfo.a));
      }
    }
  }
  
  private void c(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if (paramRequest0x68bParams.z)
    {
      ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)this.c.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localReadInJoyLogicManager != null)
      {
        Object localObject;
        int k;
        int m;
        int n;
        if (paramRequest0x68bParams.c == -1L)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AdvertisementInfoModule reqAdvertisementList params.beginRecommendSeq = ");
            ((StringBuilder)localObject).append(paramRequest0x68bParams.c);
            QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject).toString());
          }
          ReadInJoyLogicEngine.a().a(paramRequest0x68bParams.b, true);
          k = 0;
          m = 30;
        }
        else
        {
          localObject = ReadInJoyLogicEngine.a().h(paramRequest0x68bParams.b);
          StringBuilder localStringBuilder;
          if (localObject != null)
          {
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("AdvertisementInfoModule reqAdvertisementList posRange first = ");
              localStringBuilder.append(((Pair)localObject).first);
              localStringBuilder.append(" sencond = ");
              localStringBuilder.append(((Pair)localObject).second);
              QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
            }
            k = ((Integer)((Pair)localObject).second).intValue();
          }
          for (m = RIJAdConstants.AdvertisementInfoModule.b;; m = RIJAdConstants.AdvertisementInfoModule.b)
          {
            n = k;
            m += k;
            k = n;
            break label308;
            localObject = this.a.i().d(paramRequest0x68bParams.b);
            if (localObject == null) {
              break;
            }
            if (QLog.isColorLevel())
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("AdvertisementInfoModule reqAdvertisementList channelArticleMap = ");
              localStringBuilder.append(((ConcurrentMap)localObject).size());
              QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
            }
            k = ((ConcurrentMap)localObject).size();
          }
          k = 0;
          m = 0;
        }
        label308:
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("AdvertisementInfoModule reqAdvertisementList  adStartPos = ");
          ((StringBuilder)localObject).append(k);
          ((StringBuilder)localObject).append(" adEndPos");
          ((StringBuilder)localObject).append(m);
          QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (ReadInJoyLogicEngine.a().i(paramRequest0x68bParams.b))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("AdvertisementInfoModule reqAdvertisementList needRequestAdvertisement channelID= ");
            ((StringBuilder)localObject).append(paramRequest0x68bParams.b);
            QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject).toString());
          }
          if ((paramRequest0x68bParams.A != 2) && (paramRequest0x68bParams.A != 4)) {
            n = 1;
          } else {
            n = 2;
          }
          localObject = new AdRequestData();
          ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).fillSuperMaskFlag((AdRequestData)localObject, paramRequest0x68bParams.b);
          localObject = localReadInJoyLogicManager.getReadInJoyLogicEngine().a(paramRequest0x68bParams, paramRequest0x68bParams.b, n, k, m, (AdRequestData)localObject);
          localReadInJoyLogicManager.getReadInJoyLogicEngine().a(paramRequest0x68bParams.b, k, m);
          if (localObject != null)
          {
            paramReqBody.req_advertise_para.set((MessageMicro)localObject);
            PublicAccountReportUtils.a(null, "", "0X8007BA7", "0X8007BA7", 0, 0, "", "", "", "");
          }
        }
      }
    }
  }
  
  private void c(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if ((paramRequest0x68bParams.J != null) && (paramRequest0x68bParams.J.size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      paramRequest0x68bParams = paramRequest0x68bParams.J.iterator();
      while (paramRequest0x68bParams.hasNext()) {
        localArrayList.add(((ReadInJoyRequestParams.PkgInstallInfo)paramRequest0x68bParams.next()).a());
      }
      paramReqChannelPara.rpt_pkg_install_info.set(localArrayList);
    }
  }
  
  private boolean c(ToServiceMsg paramToServiceMsg)
  {
    int k;
    int n;
    if (paramToServiceMsg.getAttribute("CountOfRequest_0x68b") != null)
    {
      k = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0x68b")).intValue();
      if (k == 2) {
        n = 1;
      } else {
        n = 0;
      }
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(n), ", retryTimes = ", Integer.valueOf(k) });
    }
    else
    {
      n = 0;
    }
    int i1 = n;
    if (paramToServiceMsg.getAttribute("retryIndex") != null)
    {
      int m = ((Integer)paramToServiceMsg.getAttribute("retryIndex")).intValue();
      if (m > 0) {
        k = 1;
      } else {
        k = 0;
      }
      i1 = n | k;
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "is68bRetryReq = ", Boolean.valueOf(i1), ", fastResendRetryIndex = ", Integer.valueOf(m) });
    }
    if (i1 != 0) {
      QLog.d("RIJGetArticleListHandler", 1, " isRetryRequest | 68b Retry");
    }
    return i1;
  }
  
  private void d(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, List<oidb_cmd0x68b.InnerMsg> paramList)
  {
    Object localObject1;
    if ((paramRequest0x68bParams.i != null) && (paramRequest0x68bParams.i.size() > 0)) {
      localObject1 = paramRequest0x68bParams.i.iterator();
    }
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject3 = (Long)((Iterator)localObject1).next();
      Object localObject2 = new oidb_cmd0x68b.InnerMsg();
      if (paramRequest0x68bParams.D > 0) {
        ((oidb_cmd0x68b.InnerMsg)localObject2).uint32_jump_src_type.set(paramRequest0x68bParams.D);
      } else {
        ((oidb_cmd0x68b.InnerMsg)localObject2).uint32_jump_src_type.set(1);
      }
      ((oidb_cmd0x68b.InnerMsg)localObject2).bytes_inner_uniq_id.set(ByteStringMicro.copyFromUtf8(String.valueOf(localObject3)));
      if (!TextUtils.isEmpty(paramRequest0x68bParams.x))
      {
        ((oidb_cmd0x68b.InnerMsg)localObject2).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.x));
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("add push contenxt:");
          ((StringBuilder)localObject3).append(paramRequest0x68bParams.x);
          QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject3).toString());
        }
      }
      ((oidb_cmd0x68b.InnerMsg)localObject2).uint64_algorithm_id.set(paramRequest0x68bParams.u);
      ((oidb_cmd0x68b.InnerMsg)localObject2).uint32_strategy_id.set((int)paramRequest0x68bParams.v);
      paramList.add(localObject2);
      continue;
      if (paramRequest0x68bParams.b == 40830)
      {
        localObject1 = new oidb_cmd0x68b.InnerMsg();
        if (paramRequest0x68bParams.D > 0) {
          ((oidb_cmd0x68b.InnerMsg)localObject1).uint32_jump_src_type.set(paramRequest0x68bParams.D);
        } else {
          ((oidb_cmd0x68b.InnerMsg)localObject1).uint32_jump_src_type.set(1);
        }
        if (!TextUtils.isEmpty(paramRequest0x68bParams.x))
        {
          ((oidb_cmd0x68b.InnerMsg)localObject1).bytes_push_context.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams.x));
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("troop subscribe add push contenxt:");
            ((StringBuilder)localObject2).append(paramRequest0x68bParams.x);
            QLog.d("RIJGetArticleListHandler", 2, ((StringBuilder)localObject2).toString());
          }
        }
        paramList.add(localObject1);
      }
    }
  }
  
  private void d(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    if (paramRequest0x68bParams.b == 41403)
    {
      Object localObject = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("nearby_readinjoy");
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
      {
        localObject = ((SosoLbsInfo)localObject).mLocation;
        int k = (int)(((SosoLocation)localObject).mLat02 * 1000000.0D);
        int m = (int)(((SosoLocation)localObject).mLon02 * 1000000.0D);
        localObject = new feeds_info.LocationInfo();
        ((feeds_info.LocationInfo)localObject).uint32_latitude.set(k);
        ((feeds_info.LocationInfo)localObject).uint32_longitude.set(m);
        paramReqBody.location_info.set((MessageMicro)localObject);
      }
      if (paramRequest0x68bParams.c != -1L)
      {
        paramRequest0x68bParams = (String)RIJSPUtils.b("readinjoy_nearby_people_last_refresh_cookie_sp_key", "");
        QLog.d("RIJGetArticleListHandler", 1, new Object[] { "load more article, nearby cookie = ", paramRequest0x68bParams });
        if (!TextUtils.isEmpty(paramRequest0x68bParams)) {
          paramReqBody.bytes_nearby_cookie.set(ByteStringMicro.copyFromUtf8(paramRequest0x68bParams));
        }
      }
    }
  }
  
  private void d(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqChannelPara paramReqChannelPara)
  {
    if (RIJKanDianFeedsExposureSwitchAladdinConfig.a())
    {
      paramRequest0x68bParams = a(paramRequest0x68bParams.b);
      if ((paramRequest0x68bParams != null) && (paramRequest0x68bParams.size() > 0))
      {
        oidb_cmd0x68b.UserExposeArticle localUserExposeArticle = new oidb_cmd0x68b.UserExposeArticle();
        localUserExposeArticle.rpt_article.set(paramRequest0x68bParams);
        paramReqChannelPara.user_expose_article.set(localUserExposeArticle);
      }
    }
  }
  
  private void e(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams, oidb_cmd0x68b.ReqBody paramReqBody)
  {
    paramRequest0x68bParams = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("webview");
    if ((paramRequest0x68bParams != null) && (paramRequest0x68bParams.mLocation != null)) {
      paramRequest0x68bParams = paramRequest0x68bParams.mLocation;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("latitude", paramRequest0x68bParams.mLat02);
      localJSONObject.put("longitude", paramRequest0x68bParams.mLon02);
      localJSONObject.put("area_id", a(paramRequest0x68bParams.poi));
      localJSONObject.put("province", paramRequest0x68bParams.province);
      localJSONObject.put("district", paramRequest0x68bParams.district);
      localJSONObject.put("city", paramRequest0x68bParams.city);
      localJSONObject.put("location_name", paramRequest0x68bParams.name);
      localJSONObject.put("ad_code", paramRequest0x68bParams.cityCode);
      paramReqBody.reqChannelPara.bytes_json_location.set(ByteStringMicro.copyFromUtf8(localJSONObject.toString()));
      return;
    }
    catch (JSONException paramRequest0x68bParams)
    {
      label159:
      break label159;
    }
    QLog.d("RIJGetArticleListHandler", 1, "reqChannelPara bytes_json_location failed!");
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    long l1 = paramLong1;
    oidb_cmd0x68b.ReqBody localReqBody = new oidb_cmd0x68b.ReqBody();
    paramLong1 = Long.valueOf(RIJQQAppInterfaceUtil.d()).longValue();
    localReqBody.uint64_uin.set(paramLong1);
    localReqBody.uint32_network_type.set(ArticleInfoModuleUtils.a());
    paramLong1 = ReadInJoyRefreshOptimizeUtil.a();
    if (ReadInJoyRefreshOptimizeUtil.a(paramLong1))
    {
      l2 = 17152L;
      QLog.d("RIJGetArticleListHandler", 1, new Object[] { "request0x68bFollowList addCompressFlag, optimizeID = ", Long.valueOf(paramLong1) });
    }
    else
    {
      l2 = 768L;
    }
    localReqBody.uint64_client_swithes.set(l2);
    Object localObject = new oidb_cmd0x68b.ReqGetFollowTabPara();
    ((oidb_cmd0x68b.ReqGetFollowTabPara)localObject).uint64_channel_id.set(70L);
    ((oidb_cmd0x68b.ReqGetFollowTabPara)localObject).uint64_begin_recommend_seq.set(l1);
    ((oidb_cmd0x68b.ReqGetFollowTabPara)localObject).uint64_end_recommend_seq.set(paramLong2);
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
        ((oidb_cmd0x68b.ReqGetFollowTabPara)localObject).rpt_expose_topic_list.add(localExposeTopic);
        if (QLog.isColorLevel())
        {
          localStringBuilder.append(((Long)localEntry.getKey()).intValue());
          localStringBuilder.append(" ");
          localStringBuilder.append(((Long)localEntry.getValue()).longValue() / 1000L);
          localStringBuilder.append(" ");
        }
      }
      l2 = paramLong1;
      paramLong1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.d("RIJGetArticleListHandler", 2, localStringBuilder.toString());
        paramLong1 = l2;
      }
    }
    localReqBody.msg_get_follow_tab_feeds_para.set((MessageMicro)localObject);
    paramHashMap = this.a.i().a(Integer.valueOf(70));
    if ((paramHashMap != null) && (l1 != 0L))
    {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_set_top_cookie.set(ByteStringMicro.copyFrom(paramHashMap));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("request0x68bFollowList: cookie: ");
        ((StringBuilder)localObject).append(new String(paramHashMap));
        QLog.d("RIJGetArticleListHandler", 1, ((StringBuilder)localObject).toString());
      }
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_red_dot_cookie.set(ByteStringMicro.copyFromUtf8(paramString1));
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_refresh_cookie.set(ByteStringMicro.copyFrom(Base64Util.decode(paramString2, 0)));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localReqBody.msg_get_follow_tab_feeds_para.bytes_last_feed_cookie.set(ByteStringMicro.copyFromUtf8(paramString3));
    }
    localReqBody.msg_get_follow_tab_feeds_para.uint32_update_times.set(paramInt1);
    localReqBody.msg_get_follow_tab_feeds_para.uint32_enter_topic_reddot_time.set(paramInt2);
    if (QLog.isColorLevel())
    {
      paramHashMap = new StringBuilder();
      paramHashMap.append("request0x68bFollowList: beginRecommendSeq : ");
      paramHashMap.append(l1);
      paramHashMap.append(", endRecommendSeq : ");
      paramHashMap.append(paramLong2);
      paramHashMap.append(", upDate_times : ");
      paramHashMap.append(paramInt1);
      paramHashMap.append(", reddotCookie : ");
      paramHashMap.append(paramString1);
      paramHashMap.append(", lastRefreshCookie : ");
      paramHashMap.append(paramString2);
      paramHashMap.append(", lastFeedsCookie : ");
      paramHashMap.append(paramString3);
      QLog.d("RIJGetArticleListHandler", 1, paramHashMap.toString());
    }
    long l2 = paramLong2;
    paramHashMap = ReadInJoyOidbHelper.a("OidbSvc.0x68b", 1675, 0, localReqBody.toByteArray());
    paramHashMap.getAttributes().put("NotifyType", Integer.valueOf(5));
    long l3 = -1L;
    paramLong2 = l1;
    if (l1 == 0L) {
      paramLong2 = -1L;
    }
    if (l2 == 0L) {
      l2 = l3;
    }
    paramHashMap.getAttributes().put("BeginSeq", Long.valueOf(paramLong2));
    paramHashMap.getAttributes().put("EndSeq", Long.valueOf(l2));
    paramHashMap.getAttributes().put("isSingleHighLight", Boolean.valueOf(false));
    paramHashMap.getAttributes().put("CountOfRequest_0x68b", Integer.valueOf(1));
    paramHashMap.getAttributes().put("ReqType", Integer.valueOf(0));
    paramHashMap.getAttributes().put("channelID", Integer.valueOf(70));
    a(localReqBody, paramHashMap, paramLong1);
    ReadInJoyRefreshOptimizeUtil.a(paramHashMap, paramLong1);
    this.a.sendPbReq(paramHashMap);
    ArticleInfoModule.b(true);
    WeakNetManager.a().a(paramHashMap);
  }
  
  public void a(ReadInJoyRequestParams.Request0x68bParams paramRequest0x68bParams)
  {
    if (paramRequest0x68bParams == null)
    {
      QLog.d("RIJGetArticleListHandler", 2, "request0x68bChannelArticleList Request0x68bParams is null!");
      return;
    }
    long l1 = System.currentTimeMillis();
    if (a(paramRequest0x68bParams, l1)) {
      return;
    }
    if ((this.f != null) && (!this.f.isShutdown()))
    {
      long l2 = FeedsPreloadHelper.c(paramRequest0x68bParams);
      ArticleInfoModule.b(true);
      ArticleInfoModule.a(paramRequest0x68bParams.A);
      this.f.execute(new RIJGetArticleListHandler.1(this, paramRequest0x68bParams, l1, l2));
      return;
    }
    QLog.d("RIJGetArticleListHandler", 1, "request0x68bChannelArticleList executorService has error !");
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0x68b.RspBody localRspBody = new oidb_cmd0x68b.RspBody();
    Object localObject = (Boolean)paramToServiceMsg.getAttribute("compressFlag");
    if (localObject != null) {
      bool = ((Boolean)localObject).booleanValue();
    } else {
      bool = false;
    }
    QLog.d("RIJGetArticleListHandler", 1, new Object[] { "handle0x68bGetArticleList isCompressEnable = ", Boolean.valueOf(bool) });
    int k = ReadInJoyRefreshOptimizeUtil.a(paramToServiceMsg, paramFromServiceMsg, paramObject, localRspBody, bool);
    QLog.d("RIJGetArticleListHandler", 1, new Object[] { "handle0x68bGetArticleList resp result code ", Integer.valueOf(k) });
    localObject = (Integer)paramToServiceMsg.getAttributes().get("channelID");
    boolean bool = a(paramToServiceMsg);
    paramFromServiceMsg = (List)paramToServiceMsg.getAttributes().get("SubscriptionArticles");
    a(paramToServiceMsg, paramObject, k, (Integer)localObject);
    ReadInJoySessionManager.a.a(true);
    if (bool)
    {
      long l2 = -1L;
      long l1 = l2;
      if (paramFromServiceMsg != null)
      {
        l1 = l2;
        if (paramFromServiceMsg.size() >= 1) {
          l1 = ((Long)paramFromServiceMsg.get(0)).longValue();
        }
      }
      if (k == 0)
      {
        a(paramFromServiceMsg, localRspBody, l1);
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handle0x68bGetArticleList  : [red_pnt_push preload resp back] , article list [ ");
        paramToServiceMsg.append(ArticleInfoModuleUtils.a(paramFromServiceMsg));
        paramToServiceMsg.append(" ]");
        QLog.d("RIJGetArticleListHandler", 2, paramToServiceMsg.toString());
        return;
      }
      try
      {
        paramFromServiceMsg = new JSONObject();
        paramFromServiceMsg.put("preload_red_pnt_push_articleID", l1);
        paramFromServiceMsg.put("preload_resp_result_code", k);
        PublicAccountReportUtils.a(null, "", "0X8009483", "0X8009483", 0, 0, paramFromServiceMsg.toString(), "", "", "", false);
      }
      catch (JSONException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
    }
    WeakNetManager.a().b(paramToServiceMsg);
    a(paramToServiceMsg, localRspBody, k);
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    String str;
    if (paramBoolean) {
      str = "mChannelID = ? and mRecommendSeq < ?";
    } else {
      str = "mChannelID = ? and mRecommendSeq > ?";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadMoreChannelArticleList with selection=");
    localStringBuilder.append(str);
    localStringBuilder.append("channelId=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("recommendSeq=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("count=");
    localStringBuilder.append(paramInt2);
    QLog.i("RIJGetArticleListHandler", 1, localStringBuilder.toString());
    this.f.execute(new RIJGetArticleListHandler.2(this, str, paramInt1, paramLong, paramInt2, paramInt3, paramInt4, paramInt6, paramInt7, paramBoolean, paramInt5));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.handler.RIJGetArticleListHandler
 * JD-Core Version:    0.7.0.1
 */