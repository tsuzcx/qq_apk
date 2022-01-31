import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyEntityManagerFactory;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.1;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.2;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.5;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.6;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.7;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine.8;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.LebaKDCellInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.MagicEvent;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ReqAdvertisePara;
import tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspChannelArticle;

public class ogy
{
  private static long jdField_a_of_type_Long;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static ogy jdField_a_of_type_Ogy;
  private final int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private atmq jdField_a_of_type_Atmq;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private nyj jdField_a_of_type_Nyj;
  private ofz jdField_a_of_type_Ofz;
  private ogd jdField_a_of_type_Ogd;
  private ogx jdField_a_of_type_Ogx;
  private oom jdField_a_of_type_Oom;
  private ooq jdField_a_of_type_Ooq;
  private oov jdField_a_of_type_Oov;
  private oox jdField_a_of_type_Oox;
  private opa jdField_a_of_type_Opa;
  private opc jdField_a_of_type_Opc;
  private opg jdField_a_of_type_Opg;
  private oph jdField_a_of_type_Oph;
  private opo jdField_a_of_type_Opo;
  private opp jdField_a_of_type_Opp;
  private opt jdField_a_of_type_Opt;
  private opx jdField_a_of_type_Opx;
  private opy jdField_a_of_type_Opy;
  private oqb jdField_a_of_type_Oqb;
  private oqf jdField_a_of_type_Oqf;
  private oqm jdField_a_of_type_Oqm;
  private oqp jdField_a_of_type_Oqp;
  private oqs jdField_a_of_type_Oqs;
  private oqv jdField_a_of_type_Oqv;
  private oqz jdField_a_of_type_Oqz;
  private orr jdField_a_of_type_Orr;
  private pdc jdField_a_of_type_Pdc;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int c;
  private int d;
  private int e;
  private int f;
  
  private ogy()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
  }
  
  public static ogy a()
  {
    try
    {
      if (jdField_a_of_type_Ogy == null)
      {
        jdField_a_of_type_Ogy = new ogy();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      ogy localogy = jdField_a_of_type_Ogy;
      return localogy;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramContext = (LocationManager)paramContext.getSystemService("location");
    } while (paramContext == null);
    try
    {
      bool = paramContext.isProviderEnabled("gps");
      if (QLog.isColorLevel()) {
        QLog.i("LBS", 2, "GPS Open " + bool);
      }
      if (bool)
      {
        this.jdField_d_of_type_Int = 1;
        return;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
      this.jdField_d_of_type_Int = 0;
    }
  }
  
  public static void b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = obz.a();
    localReportInfo.mSource = 0;
    localReportInfo.mSourceArticleId = paramArticleInfo.mArticleID;
    localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
    localReportInfo.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
    localReportInfo.mStrategyId = paramArticleInfo.mStrategyId;
    localReportInfo.mOperation = 30;
    if (paramArticleInfo.mChannelID == 70L) {
      localReportInfo.mOpSource = 13;
    }
    for (;;)
    {
      localReportInfo.mChannelId = ((int)paramArticleInfo.mChannelID);
      if (paramArticleInfo.mSocialFeedInfo != null)
      {
        pqg localpqg = new pqg();
        localpqg.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo != null) {
          localpqg.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
        }
        localpqg.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localpqg.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localpqg;
      }
      localArrayList.add(localReportInfo);
      a().a(localArrayList);
      return;
      if (paramArticleInfo.mChannelID == 56L) {
        localReportInfo.mOpSource = 11;
      } else {
        localReportInfo.mOpSource = 0;
      }
    }
  }
  
  private void k(int paramInt)
  {
    QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "onLoadMoreArticleFalse, channelID = ", Integer.valueOf(paramInt) });
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyLogicEngine.2(this, paramInt));
    }
  }
  
  public static void n()
  {
    jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Oqs.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Ooq.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = obz.a() + "_" + paramInt;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveChannelPosInfo mLeavePosCache is null.");
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getPosInfo, key: ", str, ", state: ", this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) });
    }
    return (Parcelable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
  }
  
  public Pair<Integer, Integer> a(int paramInt)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Oom.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Oom.a(paramInt1, paramInt2);
  }
  
  public atmq a()
  {
    Object localObject1 = obz.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_Atmq == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_Atmq).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_a_of_type_Atmq = ((atmq)localObject1);
      }
      return this.jdField_a_of_type_Atmq;
    }
    finally {}
  }
  
  public ReadInJoyUserInfoModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  }
  
  public SelectPositionModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  }
  
  public AdvertisementInfo a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Oom.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (onu.a(paramLong)) {
      return onu.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_Ooq.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ooq.a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Opc != null) {
      return this.jdField_a_of_type_Opc.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Opo != null) {
      return this.jdField_a_of_type_Opo.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_Opo != null) {
      return this.jdField_a_of_type_Opo.a();
    }
    return null;
  }
  
  public List<pox> a()
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Opa.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Opa.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ooq != null) {
      return this.jdField_a_of_type_Ooq.b(paramInteger);
    }
    return null;
  }
  
  public List<BaseArticleInfo> a(Integer paramInteger, List<Long> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList == null) || (paramList.isEmpty())) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (Long)paramList.next();
      localObject = a(paramInteger.intValue(), ((Long)localObject).longValue());
      if (localObject != null) {
        localArrayList.add(localObject);
      }
    }
    return opz.a(localArrayList);
  }
  
  public nyj a()
  {
    return this.jdField_a_of_type_Nyj;
  }
  
  public ofz a()
  {
    return this.jdField_a_of_type_Ofz;
  }
  
  public ogd a()
  {
    return this.jdField_a_of_type_Ogd;
  }
  
  public oom a()
  {
    return this.jdField_a_of_type_Oom;
  }
  
  public ooq a()
  {
    return this.jdField_a_of_type_Ooq;
  }
  
  public oox a()
  {
    return this.jdField_a_of_type_Oox;
  }
  
  public oph a()
  {
    return this.jdField_a_of_type_Oph;
  }
  
  public opt a()
  {
    return this.jdField_a_of_type_Opt;
  }
  
  public oqb a()
  {
    return this.jdField_a_of_type_Oqb;
  }
  
  public oqf a()
  {
    return this.jdField_a_of_type_Oqf;
  }
  
  public oqv a()
  {
    return this.jdField_a_of_type_Oqv;
  }
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_Opg != null) {
      return this.jdField_a_of_type_Opg.a();
    }
    return null;
  }
  
  public orr a()
  {
    return this.jdField_a_of_type_Orr;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(pdh parampdh, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Oom.a(parampdh, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opa.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Opc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelListFromServer mChannelInfoModule is null!");
      }
      return;
    }
    switch (paramInt1)
    {
    case 0: 
    default: 
      return;
    case -1: 
      this.jdField_a_of_type_Opc.b(true);
      return;
    }
    this.jdField_a_of_type_Opc.e();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oom.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nab paramnab)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oom.a(paramInt1, paramInt2, paramInt3, paramInt4, paramnab);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestVideoRealTimeReplaceList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Ooq.b(Integer.valueOf(paramInt1));
    Object localObject1 = new pdh();
    ((pdh)localObject1).jdField_b_of_type_Int = paramInt1;
    ((pdh)localObject1).jdField_a_of_type_Long = -1L;
    ((pdh)localObject1).jdField_b_of_type_Boolean = true;
    ((pdh)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    ((pdh)localObject1).jdField_c_of_type_Boolean = false;
    localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(paramLong1));
    ((pdh)localObject1).jdField_b_of_type_JavaUtilList = ((List)localObject2);
    ((pdh)localObject1).jdField_h_of_type_Int = 7;
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("next_video_algorithm_id", paramLong2);
      ((pdh)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).toString();
      ((pdh)localObject1).jdField_d_of_type_Boolean = true;
      ((pdh)localObject1).jdField_e_of_type_Boolean = true;
      ((pdh)localObject1).jdField_f_of_type_Boolean = true;
      ((pdh)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Ooq.a(Integer.valueOf(paramInt1));
      ((pdh)localObject1).jdField_g_of_type_Boolean = false;
      localObject3 = this.jdField_a_of_type_Ooq;
      ((pdh)localObject1).jdField_b_of_type_ArrayOfByte = ooq.a();
      ((pdh)localObject1).jdField_c_of_type_Int = 0;
      ((pdh)localObject1).jdField_a_of_type_JavaLangString = null;
      ((pdh)localObject1).jdField_c_of_type_Long = -1L;
      ((pdh)localObject1).jdField_b_of_type_JavaLangString = null;
      ((pdh)localObject1).jdField_d_of_type_Int = paramInt2;
      ((pdh)localObject1).jdField_d_of_type_Long = 0L;
      ((pdh)localObject1).jdField_e_of_type_Long = 0L;
      ((pdh)localObject1).jdField_i_of_type_Boolean = false;
      ((pdh)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = null;
      ((pdh)localObject1).jdField_g_of_type_Int = 3;
      ((pdh)localObject1).jdField_b_of_type_Long = -1L;
      ((pdh)localObject1).jdField_f_of_type_Int |= 0x10;
      ((pdh)localObject1).jdField_f_of_type_Int |= 0x2000;
      if ((paramInt1 == 40677) || (paramInt2 == 7)) {
        ((pdh)localObject1).j = 2;
      }
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (localObject3 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "requestVideoRealTimeReplaceList positionData = " + localObject3);
          }
          ((pdh)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          ((pdh)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy((SelectPositionModule.PositionData)localObject3);
        }
      }
      this.jdField_a_of_type_Ooq.a((pdh)localObject1);
      localObject1 = new StringBuilder("SelectedKandianArticleIds : ");
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Long)((Iterator)localObject2).next();
          ((StringBuilder)localObject1).append(localObject3 + " , ");
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
      QLog.i("ArticleInfoModule", 1, "###requestVideoRealTimeReplaceList kandianArticleID : " + ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Opa == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    pox localpox;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Opa.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localpox = (pox)((Iterator)localObject).next();
        i = psg.a(localpox.jdField_a_of_type_JavaUtilList, new ogz(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localpox.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localpox.jdField_a_of_type_JavaUtilList.remove(i);
    if (localpox == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localpox = (pox)localList.get(0);
      i = psg.a(localpox.jdField_a_of_type_JavaUtilList, new oha(this));
      if (QLog.isColorLevel()) {
        opa.a(localpox.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localpox.jdField_a_of_type_JavaUtilList != null))
      {
        odh.a(obz.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label404;
        }
        localpox.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        ndn.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", obz.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label404:
        localpox.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_Ooq != null) {
      this.jdField_a_of_type_Ooq.a(paramInt, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (odm.c(paramInt)) {
      return;
    }
    String str = obz.a() + "_" + paramInt;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveChannelPosInfo mLeavePosCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updatePosInfo, key: ", str, ", state: ", paramParcelable });
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, paramParcelable);
  }
  
  public void a(int paramInt, ArticleInfo paramArticleInfo1, ArticleInfo paramArticleInfo2)
  {
    if ((paramArticleInfo1 == null) || (paramArticleInfo2 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyLogicEngine", 2, "###insertAfterTarget error for null, targetArticleInfo:" + paramArticleInfo1 + "     valueArticleInfo:" + paramArticleInfo2);
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      if (obz.j(paramBaseArticleInfo))
      {
        Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          this.jdField_a_of_type_Ooq.a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_Ooq.a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    while ((this.jdField_a_of_type_Oov != null) && (paramBoolean.booleanValue())) {
      if (obz.j(paramBaseArticleInfo))
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          paramBoolean = (BaseArticleInfo)paramBaseArticleInfo.next();
          this.jdField_a_of_type_Oov.a(paramBoolean.mArticleID);
        }
        QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
      }
      else
      {
        this.jdField_a_of_type_Oov.a(paramBaseArticleInfo.mArticleID);
        return;
      }
    }
    QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
  }
  
  public void a(int paramInt, String paramString)
  {
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        pox localpox = (pox)localList.get(i);
        int j = 0;
        while (j < localpox.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localpox.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localpox.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
          }
          j += 1;
        }
        i += 1;
      }
    }
    a(localList, true);
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opa.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<ogo> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<ogo> paramList1, List<pdg> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_Ooq.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_Ooq.a(Integer.valueOf(paramInt1));
    pdh localpdh = new pdh();
    localpdh.jdField_b_of_type_Int = paramInt1;
    localpdh.jdField_a_of_type_Long = -1L;
    localpdh.jdField_b_of_type_Boolean = true;
    localpdh.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localpdh.jdField_c_of_type_Boolean = false;
    localpdh.jdField_b_of_type_JavaUtilList = paramList;
    localpdh.jdField_h_of_type_Int = paramInt2;
    localpdh.jdField_d_of_type_Boolean = true;
    localpdh.jdField_e_of_type_Boolean = true;
    localpdh.jdField_f_of_type_Boolean = paramBoolean1;
    localpdh.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Ooq.a(Integer.valueOf(paramInt1));
    localpdh.jdField_g_of_type_Boolean = paramBoolean2;
    localObject = this.jdField_a_of_type_Ooq;
    localpdh.jdField_b_of_type_ArrayOfByte = ooq.a();
    localpdh.jdField_c_of_type_Int = paramInt3;
    localpdh.jdField_a_of_type_JavaLangString = paramString1;
    localpdh.jdField_c_of_type_Long = paramLong1;
    localpdh.jdField_b_of_type_JavaLangString = paramString2;
    localpdh.jdField_d_of_type_Int = paramInt4;
    localpdh.jdField_d_of_type_Long = paramLong2;
    localpdh.jdField_e_of_type_Long = paramLong3;
    localpdh.jdField_c_of_type_JavaLangString = paramString3;
    localpdh.jdField_i_of_type_Boolean = paramBoolean3;
    localpdh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localpdh.jdField_i_of_type_Int |= paramInt6;
    localpdh.jdField_d_of_type_JavaUtilList = paramList2;
    localpdh.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (npj.a(paramInt1)) {
      localpdh.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localpdh.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
    for (localpdh.jdField_b_of_type_Long = -1L;; localpdh.jdField_b_of_type_Long = (l + 1L))
    {
      localpdh.jdField_f_of_type_Int |= 0x10;
      localpdh.jdField_f_of_type_Int |= 0x20;
      localpdh.jdField_f_of_type_Int |= 0x100;
      localpdh.jdField_f_of_type_Int |= 0x40;
      localpdh.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localpdh.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localpdh.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localpdh.j = 2;
      }
      if (odm.c(paramInt1)) {
        localpdh.j = 3;
      }
      if (paramList1 != null) {
        localpdh.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localpdh.jdField_i_of_type_Int & 0x100) != 0)
      {
        localpdh.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localpdh.j), ", beginRecommendSeq = ", Long.valueOf(localpdh.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localpdh.jdField_b_of_type_Long) });
      }
      if (!bgmq.i()) {
        localpdh.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localpdh.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localpdh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localpdh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localpdh.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localpdh.jdField_a_of_type_Pev = pes.a().a();
        pes.a().a();
      }
      this.jdField_a_of_type_Ooq.a(localpdh);
      paramLebaKDCellInfo = new StringBuilder("SelectedKandianArticleIds : ");
      if (paramList == null) {
        break;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramList1 = (Long)paramList.next();
        paramLebaKDCellInfo.append(paramList1 + " , ");
      }
    }
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + obz.c(paramString2) + " recommendFlag is : " + localpdh.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oom.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Ogx != null) {
      this.jdField_a_of_type_Ogx.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    pqm localpqm = new pqm();
    long l = 0L;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm != null)
      {
        localpqm.a = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.a;
        localpqm.b = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqm.b;
      }
      l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Pqo.jdField_a_of_type_Long;
    }
    a(paramLong, 0L, localpqm, l, "", paramArticleInfo.mArticleID, paramArticleInfo.mRecommendSeq, paramInt2, paramArticleInfo.innerUniqueID, paramInt1, paramArticleInfo, true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Oov == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oov.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, pqm parampqm, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, parampqm, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, pqm parampqm, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ooq == null) || (parampqm == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestMultiBiu mArticleInfoModule is null!");
      }
      return;
    }
    if (paramLong4 == -1L) {
      paramLong4 = 0L;
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramString2)) && (paramInt1 == 17))
      {
        this.jdField_a_of_type_Ooq.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Ooq.a(paramLong1, paramLong2, parampqm, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, pqm parampqm, String paramString)
  {
    this.jdField_a_of_type_Ooq.a(paramLong1, paramLong2, parampqm, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.atlas.", 2, "requestAtlasBiu rowKey is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<ppa> paramList)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramLong, paramList);
  }
  
  public void a(long paramLong, ppa paramppa)
  {
    if (paramppa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramppa);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Oqm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqm.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oom.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment mArticleInfoModule is null!");
      }
      return;
    }
    if ((paramArticleInfo == null) || (TextUtils.isEmpty(paramString)))
    {
      QLog.d("Q.readinjoy.info_module", 2, "requestSubmitComment articleinfo or commentinfo is null!");
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Opc != null) {
      this.jdField_a_of_type_Opc.a(paramChannelInfo);
    }
  }
  
  public void a(MagicEvent paramMagicEvent)
  {
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.a(paramMagicEvent);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Opa.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      this.jdField_a_of_type_Ooq.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = obz.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    atmp localatmp = a().createEntityManager();
    this.jdField_a_of_type_Pdc = pdc.a();
    this.jdField_a_of_type_Ooq = new ooq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oqv = new oqv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oov = new oov(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opx = new opx(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oqs = new oqs(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opc = new opc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oom = new oom(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opa = new opa(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oqp = new oqp(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opo = new opo(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_Opy = new opy(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oph = new oph(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    this.jdField_a_of_type_Oqm = new oqm(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opp = new opp(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oox = new oox(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Ooq);
    this.jdField_a_of_type_Oqz = new oqz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oqf = new oqf(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opt = new opt(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Nyj = new nyj(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ofz = new ofz(localatmp, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ogd = new ogd(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Orr = new orr(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Opg = new opg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oqb = new oqb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localatmp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Pdc, this.jdField_a_of_type_AndroidOsHandler);
    nsc.a.a();
    nsd.a = null;
    odm.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    rdg.a();
    rdw.b();
    this.jdField_a_of_type_Ogx = new ogx(paramAppInterface, this.jdField_a_of_type_Opp);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oom.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true);
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_Opo != null) {
      this.jdField_a_of_type_Opo.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqs.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((obz.a != null) && (obz.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_Ooq.a("" + obz.a.mFeedId, obz.a.mFeedType, -1, true);
        obz.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + obz.a);
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, pqk parampqk)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, parampqk, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqs.a(paramString, paramContext);
    ndn.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Opy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opy.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      this.jdField_a_of_type_Ooq.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Oqv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqv.a(paramList);
  }
  
  public void a(List<pox> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Opa.a(paramList, paramBoolean);
    this.jdField_a_of_type_Opa.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Oqv == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Oqv.a(paramList, paramString);
  }
  
  public void a(List<pox> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Opa.a(paramList, paramBoolean);
  }
  
  public void a(prv paramprv)
  {
    if (this.jdField_a_of_type_Opo != null) {
      this.jdField_a_of_type_Opo.a(paramprv);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    try
    {
      if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(-1) > 0)
      {
        QLog.d("ReadInJoyLogicEngine", 2, "unInit fail, referenceCount is : " + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
        return;
      }
      jdField_a_of_type_Ogy = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Atmq = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_Pdc != null)
      {
        this.jdField_a_of_type_Pdc.a();
        this.jdField_a_of_type_Pdc = null;
      }
      if (this.jdField_a_of_type_Ooq != null)
      {
        this.jdField_a_of_type_Ooq.a();
        this.jdField_a_of_type_Ooq = null;
      }
      if (this.jdField_a_of_type_Oqv != null)
      {
        this.jdField_a_of_type_Oqv.a();
        this.jdField_a_of_type_Oqv = null;
      }
      if (this.jdField_a_of_type_Oov != null)
      {
        this.jdField_a_of_type_Oov.b();
        this.jdField_a_of_type_Oov = null;
      }
      if (this.jdField_a_of_type_Opx != null)
      {
        this.jdField_a_of_type_Opx.a();
        this.jdField_a_of_type_Opx = null;
      }
      if (this.jdField_a_of_type_Oqs != null)
      {
        this.jdField_a_of_type_Oqs.a();
        this.jdField_a_of_type_Oqs = null;
      }
      if (this.jdField_a_of_type_Opc != null)
      {
        this.jdField_a_of_type_Opc.a();
        this.jdField_a_of_type_Opc = null;
      }
      if (this.jdField_a_of_type_Oom != null)
      {
        this.jdField_a_of_type_Oom.a();
        this.jdField_a_of_type_Oom = null;
      }
      if (this.jdField_a_of_type_Opa != null)
      {
        this.jdField_a_of_type_Opa.a();
        this.jdField_a_of_type_Opa = null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = null;
      }
      if (this.jdField_a_of_type_Oqm != null)
      {
        this.jdField_a_of_type_Oqm.a();
        this.jdField_a_of_type_Oqm = null;
      }
      if (this.jdField_a_of_type_Oox != null)
      {
        this.jdField_a_of_type_Oox.a();
        this.jdField_a_of_type_Oox = null;
      }
      if (this.jdField_a_of_type_Opt != null) {
        this.jdField_a_of_type_Opt.a();
      }
      if (this.jdField_a_of_type_Ofz != null)
      {
        this.jdField_a_of_type_Ofz.a();
        this.jdField_a_of_type_Ofz = null;
      }
      if (this.jdField_a_of_type_Ogd != null)
      {
        this.jdField_a_of_type_Ogd.a();
        this.jdField_a_of_type_Ogd = null;
      }
      if (this.jdField_a_of_type_Orr != null)
      {
        this.jdField_a_of_type_Orr.a();
        this.jdField_a_of_type_Orr = null;
      }
      if (this.jdField_a_of_type_Opg != null)
      {
        this.jdField_a_of_type_Opg.b();
        this.jdField_a_of_type_Opg = null;
      }
      if (this.jdField_a_of_type_Ogx != null)
      {
        this.jdField_a_of_type_Ogx.c();
        this.jdField_a_of_type_Ogx = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
      }
      nsc.a.a();
      nsd.a = null;
      ort.a().b();
      odm.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Opc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opc.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    s();
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "equestFollowList mArticleInfoModule is null!");
      }
      return;
    }
    HashMap localHashMap;
    long l1;
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(162)).a(-1);
      }
      localHashMap = a();
      l1 = this.jdField_a_of_type_Ooq.a(Integer.valueOf(70));
      if (l1 == -1L) {
        break label229;
      }
      l1 += 1L;
    }
    for (;;)
    {
      Object localObject = b(Integer.valueOf(70));
      if ((localObject != null) && (!((List)localObject).isEmpty())) {}
      for (localObject = ((ArticleInfo)((List)localObject).get(((List)localObject).size() - 1)).mFeedCookie;; localObject = null)
      {
        this.jdField_f_of_type_Int += 1;
        this.jdField_a_of_type_Ooq.a(l2, l1, this.jdField_f_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_Ooq.b(Integer.valueOf(70));
        if (l3 == -1L) {
          break label221;
        }
        localHashMap = null;
        l1 = 0L;
        l2 = l3 - 1L;
        break;
      }
      label221:
      localHashMap = null;
      l1 = 0L;
      continue;
      label229:
      l1 = 0L;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Oom.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ooq == null) {
      return false;
    }
    return this.jdField_a_of_type_Ooq.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_Ooq.b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_Ooq.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Oov == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Oov.a(paramLong);
  }
  
  public boolean a(Context paramContext)
  {
    if (this.jdField_d_of_type_Int == -1) {
      a(paramContext);
    }
    return this.jdField_d_of_type_Int > 0;
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ooq != null) {
      return this.jdField_a_of_type_Ooq.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Ooq.b(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Ogx != null) && (TextUtils.isDigitsOnly(paramString))) {
      return this.jdField_a_of_type_Ogx.a(Long.valueOf(paramString));
    }
    return false;
  }
  
  public boolean a(ppc paramppc, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_Ooq.a(paramppc, paramArticleInfo);
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Opc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Opc.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Oom == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Oom.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_Ooq.c(Integer.valueOf(paramInt));
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= localList.size()) {
          break label104;
        }
        ArticleInfo localArticleInfo = (ArticleInfo)localList.get(paramInt);
        localObject = localArticleInfo;
        if (localArticleInfo.mArticleID == paramLong) {
          break;
        }
        paramInt += 1;
      }
    }
    label104:
    return null;
  }
  
  public List<TabChannelCoverInfo> b()
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Opa.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Opa.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ooq != null) {
      return this.jdField_a_of_type_Ooq.c(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Oov == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oov.a();
  }
  
  public void b(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        pox localpox1 = (pox)localList.get(i);
        pox localpox2 = new pox(localpox1.jdField_a_of_type_Long, localpox1.jdField_a_of_type_JavaLangString, localpox1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localpox1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localpox1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localpox2.jdField_a_of_type_JavaUtilList.add(localpox1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localpox2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (opa.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Opc == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opc.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_Ooq != null) {
      this.jdField_a_of_type_Ooq.a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      this.jdField_a_of_type_Ooq.a(paramLong);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByTopicId: mArticleInfoModule is null when search " + paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    a(paramLong, paramInt);
    Object localObject1 = "publishUin = " + paramLong;
    localObject1 = a().createEntityManager().a(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "no soical feeds to update article.publishUin:" + paramLong);
      return;
    }
    localObject1 = ((List)localObject1).iterator();
    label93:
    ArticleInfo localArticleInfo;
    int i;
    label143:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
      if (localArticleInfo.mSocialFeedInfo == null) {
        break label443;
      }
      if ((localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int == 2) || (paramInt != 2)) {
        break label437;
      }
      i = 1;
      localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int = paramInt;
      localObject2 = new articlesummary.SocializeFeedsInfo();
    }
    for (;;)
    {
      try
      {
        ((articlesummary.SocializeFeedsInfo)localObject2).mergeFrom(localArticleInfo.mSocialFeedInfoByte);
        ((articlesummary.SocializeFeedsInfo)localObject2).uint32_follow_status.set(paramInt, true);
        localArticleInfo.mSocialFeedInfoByte = ((articlesummary.SocializeFeedsInfo)localObject2).toByteArray();
        j = 1;
        k = i;
        m = j;
        if (localArticleInfo.mPolymericInfo != null)
        {
          j = i;
          if (localArticleInfo.mPolymericInfo.e != 2)
          {
            j = i;
            if (paramInt == 2) {
              j = 1;
            }
          }
          localArticleInfo.mPolymericInfo.e = paramInt;
          localObject2 = new articlesummary.PackInfo();
        }
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
      {
        try
        {
          ((articlesummary.PackInfo)localObject2).mergeFrom(localArticleInfo.mPackInfoBytes);
          ((articlesummary.PackInfo)localObject2).uint32_follow_status.set(paramInt, true);
          localArticleInfo.mPackInfoBytes = ((articlesummary.PackInfo)localObject2).toByteArray();
          int m = 1;
          int k = j;
          if (m == 0) {
            break label93;
          }
          this.jdField_a_of_type_Ooq.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_Ooq.a(localArticleInfo, (int)localArticleInfo.mChannelID);
          if ((k != 0) && (localArticleInfo != null)) {
            localArticleInfo.isNeedShowBtnWhenFollowed = true;
          }
          if (localArticleInfo == null) {
            break label93;
          }
          localArticleInfo.invalidateProteusTemplateBean();
          break label93;
          localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
          localInvalidProtocolBufferMicroException1.printStackTrace();
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
        {
          QLog.e("ReadInJoyLogicEngine", 1, "updateArticleFollowStatusByAccount article.mPackInfoBytes convert error article.publishUin:" + paramLong + " e = " + localInvalidProtocolBufferMicroException2);
          localInvalidProtocolBufferMicroException2.printStackTrace();
          continue;
        }
      }
      if (this.jdField_a_of_type_AndroidOsHandler == null) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new ReadInJoyLogicEngine.7(this));
      return;
      label437:
      i = 0;
      break label143;
      label443:
      i = 0;
      int j = 0;
    }
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqs.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public boolean b(Long paramLong)
  {
    if (this.jdField_a_of_type_Ogx != null) {
      return this.jdField_a_of_type_Ogx.a(paramLong);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Opo != null) {
      return this.jdField_a_of_type_Opo.a();
    }
    return 0;
  }
  
  public List<ppg> c()
  {
    if (this.jdField_a_of_type_Opp == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Opp.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.f();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opa.c(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Ooq.a(paramArticleInfo);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqs.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opa.a(paramBoolean);
  }
  
  public int d()
  {
    String str = obz.a();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "getLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "getLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str) });
    }
    return ((Integer)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(str)).intValue();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Opx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opx.b();
    this.jdField_a_of_type_Opx.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ooq.a(paramInt1, paramInt2);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Opo != null) {
      this.jdField_a_of_type_Opo.a(paramBoolean);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqs.f();
  }
  
  public void e(int paramInt)
  {
    if (paramInt != 40677) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.6(this, paramInt));
  }
  
  public void e(String paramString)
  {
    if (this.jdField_a_of_type_Oqp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfFollowAndFansCount mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqp.a(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ogx != null) {
      this.jdField_a_of_type_Ogx.c(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_Opo != null) {
      this.jdField_a_of_type_Opo.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Opo != null) {
      this.jdField_a_of_type_Opo.a(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Oqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Oqs.g();
  }
  
  public void g(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      this.jdField_a_of_type_Ooq.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Ooq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ooq.d();
      if (this.jdField_a_of_type_Oqs != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Oqs.d();
  }
  
  public void h(int paramInt)
  {
    String str = obz.a();
    if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "updateLeaveKanDianTabInfo mLeaveKanDianTabCache is null.");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyLogicEngine", 2, new Object[] { "updateLeaveKanDianTabInfo, key: ", str, ", tabIndex: ", Integer.valueOf(paramInt) });
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(paramInt));
  }
  
  public void h(String paramString)
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      this.jdField_a_of_type_Ooq.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Oqs != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Oom != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_Ooq.e();
      break;
      label80:
      this.jdField_a_of_type_Oqs.e();
    }
    label90:
    this.jdField_a_of_type_Oom.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_Ooq != null) {
      this.jdField_a_of_type_Ooq.d(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Opc != null) {
      this.jdField_a_of_type_Opc.a(paramString);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Ooq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ooq.b();
      if (this.jdField_a_of_type_Oqs != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Oqs.b();
  }
  
  public void j(int paramInt)
  {
    if (this.jdField_a_of_type_Oqp != null) {
      this.jdField_a_of_type_Oqp.b(paramInt);
    }
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_Opg != null) {
      this.jdField_a_of_type_Opg.a(paramString);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ooq == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ooq.c();
      if (this.jdField_a_of_type_Oqs != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Oqs.c();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opa.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Opa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Opa.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Ooq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ooq.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Opo != null) {
      this.jdField_a_of_type_Opo.a();
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Oqv != null) {
      this.jdField_a_of_type_Oqv.b();
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_Opp != null) && (this.jdField_a_of_type_Opp.a())) {
      this.jdField_a_of_type_Opp.a(300, 2);
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Opc != null) {
      this.jdField_a_of_type_Opc.d();
    }
  }
  
  public void t()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyLogicEngine.8(this));
  }
  
  public void u()
  {
    if (this.jdField_a_of_type_Opg != null)
    {
      this.jdField_a_of_type_Opg.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogy
 * JD-Core Version:    0.7.0.1
 */