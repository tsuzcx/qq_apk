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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
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

public class pfa
{
  private static long jdField_a_of_type_Long;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static pfa jdField_a_of_type_Pfa;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private onq jdField_a_of_type_Onq;
  private ooq jdField_a_of_type_Ooq;
  private ovh jdField_a_of_type_Ovh;
  private pea jdField_a_of_type_Pea;
  private pee jdField_a_of_type_Pee;
  private pez jdField_a_of_type_Pez;
  private pgl jdField_a_of_type_Pgl;
  private pog jdField_a_of_type_Pog;
  private pon jdField_a_of_type_Pon;
  private pos jdField_a_of_type_Pos;
  private pou jdField_a_of_type_Pou;
  private pox jdField_a_of_type_Pox;
  private poz jdField_a_of_type_Poz;
  private ppd jdField_a_of_type_Ppd;
  private ppe jdField_a_of_type_Ppe;
  private ppn jdField_a_of_type_Ppn;
  private ppo jdField_a_of_type_Ppo;
  private ppr jdField_a_of_type_Ppr;
  private ppv jdField_a_of_type_Ppv;
  private ppw jdField_a_of_type_Ppw;
  private ppy jdField_a_of_type_Ppy;
  private pqa jdField_a_of_type_Pqa;
  private pqd jdField_a_of_type_Pqd;
  private pqi jdField_a_of_type_Pqi;
  private pqp jdField_a_of_type_Pqp;
  private pqs jdField_a_of_type_Pqs;
  private pqx jdField_a_of_type_Pqx;
  private pra jdField_a_of_type_Pra;
  private prf jdField_a_of_type_Prf;
  private psp jdField_a_of_type_Psp;
  private qfo jdField_a_of_type_Qfo;
  private qhm jdField_a_of_type_Qhm;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int c;
  
  public static pfa a()
  {
    try
    {
      if (jdField_a_of_type_Pfa == null)
      {
        jdField_a_of_type_Pfa = new pfa();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      pfa localpfa = jdField_a_of_type_Pfa;
      return localpfa;
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
        this.jdField_a_of_type_Int = 1;
        return;
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public static void c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ozs.a();
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
        qxa localqxa = new qxa();
        localqxa.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt != null) {
          localqxa.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qxt.jdField_a_of_type_Long;
        }
        localqxa.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localqxa.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localqxa;
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
  
  private void t()
  {
    if (this.jdField_a_of_type_Ooq != null)
    {
      this.jdField_a_of_type_Ooq.a();
      this.jdField_a_of_type_Ooq = null;
    }
  }
  
  private void u()
  {
    if (this.jdField_a_of_type_Pgl != null)
    {
      this.jdField_a_of_type_Pgl.a();
      this.jdField_a_of_type_Pgl = null;
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Qhm != null)
    {
      this.jdField_a_of_type_Qhm.a();
      this.jdField_a_of_type_Qhm = null;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Pqx.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Pon.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = ozs.a() + "_" + paramInt;
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
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pog.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pog.a(paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pog.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (poc.a(paramLong)) {
      return poc.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_Pon.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pon.a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Poz != null) {
      return this.jdField_a_of_type_Poz.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = ozs.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = ((EntityManagerFactory)localObject1);
      }
      return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
    }
    finally {}
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Ppn != null) {
      return this.jdField_a_of_type_Ppn.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_Ppn != null) {
      return this.jdField_a_of_type_Ppn.a();
    }
    return null;
  }
  
  public List<qvr> a()
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pox.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pox.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pon != null) {
      return this.jdField_a_of_type_Pon.b(paramInteger);
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
    return ppx.a(localArrayList);
  }
  
  public onq a()
  {
    return this.jdField_a_of_type_Onq;
  }
  
  public ooq a()
  {
    return this.jdField_a_of_type_Ooq;
  }
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_Ppd != null) {
      return this.jdField_a_of_type_Ppd.b();
    }
    return null;
  }
  
  public ovh a()
  {
    return this.jdField_a_of_type_Ovh;
  }
  
  public pea a()
  {
    return this.jdField_a_of_type_Pea;
  }
  
  public pee a()
  {
    return this.jdField_a_of_type_Pee;
  }
  
  public pgl a()
  {
    return this.jdField_a_of_type_Pgl;
  }
  
  public pog a()
  {
    return this.jdField_a_of_type_Pog;
  }
  
  public pon a()
  {
    return this.jdField_a_of_type_Pon;
  }
  
  public pou a()
  {
    return this.jdField_a_of_type_Pou;
  }
  
  public ppe a()
  {
    return this.jdField_a_of_type_Ppe;
  }
  
  public ppo a()
  {
    return this.jdField_a_of_type_Ppo;
  }
  
  public ppr a()
  {
    return this.jdField_a_of_type_Ppr;
  }
  
  public ppy a()
  {
    return this.jdField_a_of_type_Ppy;
  }
  
  public pqa a()
  {
    return this.jdField_a_of_type_Pqa;
  }
  
  public pqd a()
  {
    return this.jdField_a_of_type_Pqd;
  }
  
  public pqi a()
  {
    return this.jdField_a_of_type_Pqi;
  }
  
  public pra a()
  {
    return this.jdField_a_of_type_Pra;
  }
  
  public psp a()
  {
    return this.jdField_a_of_type_Psp;
  }
  
  public qhm a()
  {
    return this.jdField_a_of_type_Qhm;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(qft paramqft, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pog.a(paramqft, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pox.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Poz == null)
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
      this.jdField_a_of_type_Poz.b(true);
      return;
    }
    this.jdField_a_of_type_Poz.d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pog.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nyp paramnyp)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pog.a(paramInt1, paramInt2, paramInt3, paramInt4, paramnyp);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestVideoRealTimeReplaceList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Pon.b(Integer.valueOf(paramInt1));
    Object localObject1 = new qft();
    ((qft)localObject1).jdField_b_of_type_Int = paramInt1;
    ((qft)localObject1).jdField_a_of_type_Long = -1L;
    ((qft)localObject1).jdField_b_of_type_Boolean = true;
    ((qft)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    ((qft)localObject1).jdField_c_of_type_Boolean = false;
    localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(paramLong1));
    ((qft)localObject1).jdField_b_of_type_JavaUtilList = ((List)localObject2);
    ((qft)localObject1).jdField_h_of_type_Int = 7;
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("next_video_algorithm_id", paramLong2);
      ((qft)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).toString();
      ((qft)localObject1).jdField_d_of_type_Boolean = true;
      ((qft)localObject1).jdField_e_of_type_Boolean = true;
      ((qft)localObject1).jdField_f_of_type_Boolean = true;
      ((qft)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Pon.a(Integer.valueOf(paramInt1));
      ((qft)localObject1).jdField_g_of_type_Boolean = false;
      ((qft)localObject1).jdField_b_of_type_ArrayOfByte = pon.a();
      ((qft)localObject1).jdField_c_of_type_Int = 0;
      ((qft)localObject1).jdField_a_of_type_JavaLangString = null;
      ((qft)localObject1).jdField_c_of_type_Long = -1L;
      ((qft)localObject1).jdField_b_of_type_JavaLangString = null;
      ((qft)localObject1).jdField_d_of_type_Int = paramInt2;
      ((qft)localObject1).jdField_d_of_type_Long = 0L;
      ((qft)localObject1).jdField_e_of_type_Long = 0L;
      ((qft)localObject1).jdField_i_of_type_Boolean = false;
      ((qft)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = null;
      ((qft)localObject1).jdField_g_of_type_Int = 3;
      ((qft)localObject1).jdField_b_of_type_Long = -1L;
      ((qft)localObject1).jdField_f_of_type_Int |= 0x10;
      ((qft)localObject1).jdField_f_of_type_Int |= 0x2000;
      if ((paramInt1 == 40677) || (paramInt2 == 7)) {
        ((qft)localObject1).j = 2;
      }
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (localObject3 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "requestVideoRealTimeReplaceList positionData = " + localObject3);
          }
          ((qft)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          ((qft)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy((SelectPositionModule.PositionData)localObject3);
        }
      }
      this.jdField_a_of_type_Pon.a((qft)localObject1);
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
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_Pon != null) {
      this.jdField_a_of_type_Pon.a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Pox == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    qvr localqvr;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Pox.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localqvr = (qvr)((Iterator)localObject).next();
        i = qzq.a(localqvr.jdField_a_of_type_JavaUtilList, new pfb(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localqvr.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localqvr.jdField_a_of_type_JavaUtilList.remove(i);
    if (localqvr == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localqvr = (qvr)localList.get(0);
      i = qzq.a(localqvr.jdField_a_of_type_JavaUtilList, new pfc(this));
      if (QLog.isColorLevel()) {
        pox.a(localqvr.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localqvr.jdField_a_of_type_JavaUtilList != null))
      {
        pay.a(ozs.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label404;
        }
        localqvr.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        ocd.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", ozs.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label404:
        localqvr.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (pbd.c(paramInt)) {
      return;
    }
    String str = ozs.a() + "_" + paramInt;
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
    this.jdField_a_of_type_Pon.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Pon != null)
    {
      if (ozs.j(paramBaseArticleInfo))
      {
        localObject = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_Pon.a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_Pon.a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pos != null) && (paramBoolean.booleanValue())) {
        if (ozs.j(paramBaseArticleInfo))
        {
          paramBoolean = paramBaseArticleInfo.mGroupSubArticleList.iterator();
          while (paramBoolean.hasNext())
          {
            localObject = (BaseArticleInfo)paramBoolean.next();
            this.jdField_a_of_type_Pos.a(((BaseArticleInfo)localObject).mArticleID);
          }
          QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
        }
        else
        {
          this.jdField_a_of_type_Pos.a(paramBaseArticleInfo.mArticleID);
        }
      }
    }
    for (;;)
    {
      pgo.a.a(paramInt, paramBaseArticleInfo);
      return;
      QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleReadInfoModule is null !");
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    List localList = a();
    if ((localList != null) && (!localList.isEmpty()))
    {
      int i = 0;
      while (i < localList.size())
      {
        qvr localqvr = (qvr)localList.get(i);
        int j = 0;
        while (j < localqvr.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localqvr.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localqvr.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
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
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pox.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<peq> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<peq> paramList1, List<qfs> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    List localList = this.jdField_a_of_type_Pon.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_Pon.a(Integer.valueOf(paramInt1));
    qft localqft = new qft();
    localqft.jdField_b_of_type_Int = paramInt1;
    localqft.jdField_a_of_type_Long = -1L;
    localqft.jdField_b_of_type_Boolean = true;
    localqft.jdField_a_of_type_JavaUtilList = localList;
    localqft.jdField_c_of_type_Boolean = false;
    localqft.jdField_b_of_type_JavaUtilList = paramList;
    localqft.jdField_h_of_type_Int = paramInt2;
    localqft.jdField_d_of_type_Boolean = true;
    localqft.jdField_e_of_type_Boolean = true;
    localqft.jdField_f_of_type_Boolean = paramBoolean1;
    localqft.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Pon.a(Integer.valueOf(paramInt1));
    localqft.jdField_g_of_type_Boolean = paramBoolean2;
    localqft.jdField_b_of_type_ArrayOfByte = pon.a();
    localqft.jdField_c_of_type_Int = paramInt3;
    localqft.jdField_a_of_type_JavaLangString = paramString1;
    localqft.jdField_c_of_type_Long = paramLong1;
    localqft.jdField_b_of_type_JavaLangString = paramString2;
    localqft.jdField_d_of_type_Int = paramInt4;
    localqft.jdField_d_of_type_Long = paramLong2;
    localqft.jdField_e_of_type_Long = paramLong3;
    localqft.jdField_c_of_type_JavaLangString = paramString3;
    localqft.jdField_i_of_type_Boolean = paramBoolean3;
    localqft.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localqft.jdField_i_of_type_Int |= paramInt6;
    localqft.jdField_d_of_type_JavaUtilList = paramList2;
    localqft.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (tqa.a(paramInt1)) {
      localqft.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localqft.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
    for (localqft.jdField_b_of_type_Long = -1L;; localqft.jdField_b_of_type_Long = (l + 1L))
    {
      localqft.jdField_f_of_type_Int |= 0x10;
      localqft.jdField_f_of_type_Int |= 0x20;
      localqft.jdField_f_of_type_Int |= 0x100;
      localqft.jdField_f_of_type_Int |= 0x40;
      localqft.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localqft.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localqft.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localqft.j = 2;
      }
      if (pbd.c(paramInt1)) {
        localqft.j = 3;
      }
      if (paramList1 != null) {
        localqft.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localqft.jdField_i_of_type_Int & 0x100) != 0)
      {
        localqft.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localqft.j), ", beginRecommendSeq = ", Long.valueOf(localqft.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localqft.jdField_b_of_type_Long) });
      }
      if (!bnrf.h()) {
        localqft.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localqft.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localqft.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localqft.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localqft.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localqft.jdField_a_of_type_Qjd = qja.a().a();
        qja.a().a();
      }
      this.jdField_a_of_type_Pon.a(localqft);
      pgo.a.a(localqft.jdField_b_of_type_Int, localqft.jdField_c_of_type_Int, localqft.jdField_i_of_type_Int);
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
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + ozs.d(paramString2) + " recommendFlag is : " + localqft.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pog.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Pez != null) {
      this.jdField_a_of_type_Pez.a(paramLong, paramInt);
    }
    if (this.jdField_a_of_type_Ppo != null) {
      this.jdField_a_of_type_Ppo.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    a(paramLong, paramInt);
    Object localObject1 = "publishUin = " + paramLong;
    localObject1 = a().createEntityManager().query(ArticleInfo.class, true, (String)localObject1, null, null, null, "mRecommendSeq desc", null);
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
        break label459;
      }
      if ((localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int == 2) || (paramInt != 2)) {
        break label453;
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
          this.jdField_a_of_type_Pon.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_Pon.a(localArticleInfo, (int)localArticleInfo.mChannelID);
          if ((k != 0) && (localArticleInfo != null)) {
            localArticleInfo.isNeedShowBtnWhenFollowed = true;
          }
          if (localArticleInfo != null) {
            localArticleInfo.invalidateProteusTemplateBean();
          }
          if ((!paramBoolean) || (localArticleInfo == null)) {
            break label93;
          }
          localArticleInfo.needShowFollwedButton = false;
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
      label453:
      i = 0;
      break label143;
      label459:
      i = 0;
      int j = 0;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Pos == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pos.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "autoRefreshForNewBiuCard | mArticleInfoModule is null!");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramLong1 != -1L) && (paramLong1 != 0L))
    {
      localArrayList.add(Long.valueOf(paramLong1));
      QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | unique_articleId : " + paramLong1);
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BiuSetTop", "1");
        localJSONObject.put("FeedsId", paramLong2);
        localJSONObject.put("ArticleId", paramLong1);
        localJSONObject.put("biuUin", ozs.a());
        localJSONObject.put("rowKey", paramString);
        paramString = new JSONObject();
        paramString.put("socialFeedsType", 3);
        localJSONObject.put("extension", paramString.toString());
        QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | pushContext: " + localJSONObject.toString());
        a(0, localArrayList, 14, true, false, 0, null, -1L, null, 0, 0L, 0L, localJSONObject.toString(), 6, false, null, 0, null);
        return;
        localArrayList.add(Long.valueOf(paramLong2));
        QLog.d("ReadInJoyLogicEngine", 2, "autoRefreshForNewBiuCard | unique_feedsId : " + paramLong2);
        paramLong1 = paramLong2;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.d("ReadInJoyLogicEngine", 2, paramString.getMessage());
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2, qxr paramqxr, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, paramqxr, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, qxr paramqxr, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Pon == null) || (paramqxr == null))
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
        this.jdField_a_of_type_Pon.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Pon.a(paramLong1, paramLong2, paramqxr, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, qxr paramqxr, String paramString)
  {
    this.jdField_a_of_type_Pon.a(paramLong1, paramLong2, paramqxr, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
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
    this.jdField_a_of_type_Pon.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<qvv> paramList)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramLong, paramList);
  }
  
  public void a(long paramLong, qvv paramqvv)
  {
    if (paramqvv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramqvv);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Pqp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqp.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pog.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pon.a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_Pon == null)
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
    this.jdField_a_of_type_Pon.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Poz != null) {
      this.jdField_a_of_type_Poz.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pox.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_Pon != null)
    {
      this.jdField_a_of_type_Pon.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = ozs.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    EntityManager localEntityManager = a().createEntityManager();
    this.jdField_a_of_type_Qfo = qfo.a();
    this.jdField_a_of_type_Pon = new pon(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pra = new pra(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pos = new pos(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ppv = new ppv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pqx = new pqx(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Poz = new poz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pog = new pog(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pox = new pox(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pqs = new pqs(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ppn = new ppn(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_Ppw = new ppw(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ppe = new ppe(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    this.jdField_a_of_type_Pqp = new pqp(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ppo = new ppo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pou = new pou(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Pon);
    this.jdField_a_of_type_Prf = new prf(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pqi = new pqi(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ppr = new ppr(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ovh = new ovh(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pea = new pea(localEntityManager, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pee = new pee(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Psp = new psp(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Ppd = new ppd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pqd = new pqd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Onq = new onq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pqa = new pqa(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ppy = new ppy(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ooq = new ooq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pgl = new pgl(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qhm = new qhm(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qfo, this.jdField_a_of_type_AndroidOsHandler);
    omi.a.a();
    omj.a = null;
    pbd.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    suz.a();
    svo.b();
    this.jdField_a_of_type_Pez = new pez(paramAppInterface, this.jdField_a_of_type_Ppo);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pog.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true);
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_Ppn != null) {
      this.jdField_a_of_type_Ppn.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqx.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((ozs.a != null) && (ozs.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_Pon.a("" + ozs.a.mFeedId, ozs.a.mFeedType, -1, true);
        ozs.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + ozs.a);
      return;
    }
    this.jdField_a_of_type_Pon.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, qxo paramqxo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramqxo, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqx.a(paramString, paramContext);
    ocd.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Ppw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ppw.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Pon != null)
    {
      this.jdField_a_of_type_Pon.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Pra == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pra.a(paramList);
  }
  
  public void a(List<qvr> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pox.a(a().a(), paramList, paramBoolean);
    this.jdField_a_of_type_Pox.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Pra == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Pra.a(paramList, paramString);
  }
  
  public void a(List<qvr> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pox.a(a().a(), paramList, paramBoolean);
  }
  
  public void a(omy paramomy)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (paramomy == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    this.jdField_a_of_type_Pon.a(paramomy);
  }
  
  public void a(qzb paramqzb)
  {
    if (this.jdField_a_of_type_Ppn != null) {
      this.jdField_a_of_type_Ppn.a(paramqzb);
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
      jdField_a_of_type_Pfa = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_Qfo != null)
      {
        this.jdField_a_of_type_Qfo.a();
        this.jdField_a_of_type_Qfo = null;
      }
      if (this.jdField_a_of_type_Pon != null)
      {
        this.jdField_a_of_type_Pon.a();
        this.jdField_a_of_type_Pon = null;
      }
      if (this.jdField_a_of_type_Pra != null)
      {
        this.jdField_a_of_type_Pra.a();
        this.jdField_a_of_type_Pra = null;
      }
      if (this.jdField_a_of_type_Pos != null)
      {
        this.jdField_a_of_type_Pos.b();
        this.jdField_a_of_type_Pos = null;
      }
      if (this.jdField_a_of_type_Ppv != null)
      {
        this.jdField_a_of_type_Ppv.a();
        this.jdField_a_of_type_Ppv = null;
      }
      if (this.jdField_a_of_type_Pqx != null)
      {
        this.jdField_a_of_type_Pqx.a();
        this.jdField_a_of_type_Pqx = null;
      }
      if (this.jdField_a_of_type_Poz != null)
      {
        this.jdField_a_of_type_Poz.a();
        this.jdField_a_of_type_Poz = null;
      }
      if (this.jdField_a_of_type_Pog != null)
      {
        this.jdField_a_of_type_Pog.a();
        this.jdField_a_of_type_Pog = null;
      }
      if (this.jdField_a_of_type_Pox != null)
      {
        this.jdField_a_of_type_Pox.a();
        this.jdField_a_of_type_Pox = null;
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
      if (this.jdField_a_of_type_Pqp != null)
      {
        this.jdField_a_of_type_Pqp.a();
        this.jdField_a_of_type_Pqp = null;
      }
      if (this.jdField_a_of_type_Pou != null)
      {
        this.jdField_a_of_type_Pou.a();
        this.jdField_a_of_type_Pou = null;
      }
      if (this.jdField_a_of_type_Ppr != null) {
        this.jdField_a_of_type_Ppr.a();
      }
      if (this.jdField_a_of_type_Pea != null)
      {
        this.jdField_a_of_type_Pea.a();
        this.jdField_a_of_type_Pea = null;
      }
      if (this.jdField_a_of_type_Pee != null)
      {
        this.jdField_a_of_type_Pee.a();
        this.jdField_a_of_type_Pee = null;
      }
      if (this.jdField_a_of_type_Psp != null)
      {
        this.jdField_a_of_type_Psp.a();
        this.jdField_a_of_type_Psp = null;
      }
      if (this.jdField_a_of_type_Ppd != null)
      {
        this.jdField_a_of_type_Ppd.b();
        this.jdField_a_of_type_Ppd = null;
      }
      if (this.jdField_a_of_type_Pez != null)
      {
        this.jdField_a_of_type_Pez.d();
        this.jdField_a_of_type_Pez = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
      }
      if (this.jdField_a_of_type_Onq != null)
      {
        this.jdField_a_of_type_Onq.a();
        this.jdField_a_of_type_Onq = null;
      }
      if (this.jdField_a_of_type_Pqa != null)
      {
        this.jdField_a_of_type_Pqa.a();
        this.jdField_a_of_type_Pqa = null;
      }
      if (this.jdField_a_of_type_Ppy != null)
      {
        this.jdField_a_of_type_Ppy.a();
        this.jdField_a_of_type_Ppy = null;
      }
      t();
      u();
      v();
      omi.a.a();
      omj.a = null;
      psr.a().b();
      pbd.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Poz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Poz.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    if (this.jdField_a_of_type_Pon == null)
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
      l1 = this.jdField_a_of_type_Pon.a(Integer.valueOf(70));
      if (l1 == -1L) {
        break label225;
      }
      l1 += 1L;
    }
    for (;;)
    {
      Object localObject = b(Integer.valueOf(70));
      if ((localObject != null) && (!((List)localObject).isEmpty())) {}
      for (localObject = ((ArticleInfo)((List)localObject).get(((List)localObject).size() - 1)).mFeedCookie;; localObject = null)
      {
        this.jdField_c_of_type_Int += 1;
        this.jdField_a_of_type_Pon.a(l2, l1, this.jdField_c_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_Pon.b(Integer.valueOf(70));
        if (l3 == -1L) {
          break label217;
        }
        localHashMap = null;
        l1 = 0L;
        l2 = l3 - 1L;
        break;
      }
      label217:
      localHashMap = null;
      l1 = 0L;
      continue;
      label225:
      l1 = 0L;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Pog.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pon == null) {
      return false;
    }
    return this.jdField_a_of_type_Pon.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_Pon.b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_Pon.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Pos == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Pos.a(paramLong);
  }
  
  public boolean a(Context paramContext)
  {
    if (this.jdField_a_of_type_Int == -1) {
      a(paramContext);
    }
    return this.jdField_a_of_type_Int > 0;
  }
  
  public boolean a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return this.jdField_a_of_type_Pon.a(paramArticleInfo);
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pon != null) {
      return this.jdField_a_of_type_Pon.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Pon.b(paramLong);
  }
  
  public boolean a(qvx paramqvx, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_Pon.a(paramqvx, paramArticleInfo);
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Poz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Poz.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pog == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pog.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_Pon.c(Integer.valueOf(paramInt));
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
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pox.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pox.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pon != null) {
      return this.jdField_a_of_type_Pon.c(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pos == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pos.a();
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
        qvr localqvr1 = (qvr)localList.get(i);
        qvr localqvr2 = new qvr(localqvr1.jdField_a_of_type_Long, localqvr1.jdField_a_of_type_JavaLangString, localqvr1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localqvr1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localqvr1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localqvr2.jdField_a_of_type_JavaUtilList.add(localqvr1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localqvr2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (pox.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Poz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Poz.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pon != null) {
      this.jdField_a_of_type_Pon.b(paramInt1, paramInt2, paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_Pon != null) {
      this.jdField_a_of_type_Pon.a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Pqs != null) {
      this.jdField_a_of_type_Pqs.a(paramInt, paramString, null);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Pon != null)
    {
      this.jdField_a_of_type_Pon.a(paramLong);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByTopicId: mArticleInfoModule is null when search " + paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, false);
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.b(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqx.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Ppn != null) {
      return this.jdField_a_of_type_Ppn.a();
    }
    return 0;
  }
  
  public AdvertisementInfo c(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pog != null)
    {
      Object localObject1 = this.jdField_a_of_type_Pog.b(paramInt1);
      if (localObject1 != null)
      {
        Iterator localIterator = ((ArrayList)localObject1).iterator();
        AdvertisementInfo localAdvertisementInfo;
        for (localObject1 = null;; localObject1 = localAdvertisementInfo)
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localAdvertisementInfo = (AdvertisementInfo)localIterator.next();
          localObject2 = localObject1;
          if (localAdvertisementInfo.mAdKdPos > paramInt2) {
            break;
          }
        }
      }
    }
    Object localObject2 = null;
    return localObject2;
  }
  
  public List<qwb> c()
  {
    if (this.jdField_a_of_type_Ppo == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Ppo.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.f();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pox.c(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqx.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pox.a(paramBoolean);
  }
  
  public int d()
  {
    String str = ozs.a();
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
    if (this.jdField_a_of_type_Ppv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ppv.b();
    this.jdField_a_of_type_Ppv.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Pon.a(paramInt1, paramInt2);
  }
  
  public void d(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Pon.b(paramArticleInfo);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ppn != null) {
      this.jdField_a_of_type_Ppn.a(paramBoolean);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqx.f();
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
    if (this.jdField_a_of_type_Pqs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfInfo mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqs.a(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pez != null) {
      this.jdField_a_of_type_Pez.c(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_Ppn != null) {
      this.jdField_a_of_type_Ppn.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Ppn != null) {
      this.jdField_a_of_type_Ppn.a(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Pqx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pqx.g();
  }
  
  public void g(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Pon != null)
    {
      this.jdField_a_of_type_Pon.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Pon == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Pon.d();
      if (this.jdField_a_of_type_Pqx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pqx.d();
  }
  
  public void h(int paramInt)
  {
    String str = ozs.a();
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
    if (this.jdField_a_of_type_Pon != null)
    {
      this.jdField_a_of_type_Pon.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Pqx != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Pog != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_Pon.e();
      break;
      label80:
      this.jdField_a_of_type_Pqx.e();
    }
    label90:
    this.jdField_a_of_type_Pog.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_Pon != null) {
      this.jdField_a_of_type_Pon.d(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Ppd != null) {
      this.jdField_a_of_type_Ppd.a(paramString);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Pon == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Pon.b();
      if (this.jdField_a_of_type_Pqx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pqx.b();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Pon == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Pon.c();
      if (this.jdField_a_of_type_Pqx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pqx.c();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pox.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Pox == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pox.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Pon == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pon.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Ppo != null) {
      this.jdField_a_of_type_Ppo.a(300, 2);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Pqs != null) {
      this.jdField_a_of_type_Pqs.a();
    }
  }
  
  public void r()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyLogicEngine.8(this));
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Ppd != null)
    {
      this.jdField_a_of_type_Ppd.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pfa
 * JD-Core Version:    0.7.0.1
 */