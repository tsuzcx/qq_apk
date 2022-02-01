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

public class pkm
{
  private static long jdField_a_of_type_Long;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static pkm jdField_a_of_type_Pkm;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private opb jdField_a_of_type_Opb;
  private oqc jdField_a_of_type_Oqc;
  private owh jdField_a_of_type_Owh;
  private pjn jdField_a_of_type_Pjn;
  private pjr jdField_a_of_type_Pjr;
  private pkl jdField_a_of_type_Pkl;
  private plx jdField_a_of_type_Plx;
  private pto jdField_a_of_type_Pto;
  private ptv jdField_a_of_type_Ptv;
  private pua jdField_a_of_type_Pua;
  private puc jdField_a_of_type_Puc;
  private puf jdField_a_of_type_Puf;
  private puh jdField_a_of_type_Puh;
  private pul jdField_a_of_type_Pul;
  private pum jdField_a_of_type_Pum;
  private puv jdField_a_of_type_Puv;
  private puw jdField_a_of_type_Puw;
  private puz jdField_a_of_type_Puz;
  private pvd jdField_a_of_type_Pvd;
  private pve jdField_a_of_type_Pve;
  private pvg jdField_a_of_type_Pvg;
  private pvo jdField_a_of_type_Pvo;
  private pvs jdField_a_of_type_Pvs;
  private pvu jdField_a_of_type_Pvu;
  private pvx jdField_a_of_type_Pvx;
  private pwc jdField_a_of_type_Pwc;
  private pwj jdField_a_of_type_Pwj;
  private pwm jdField_a_of_type_Pwm;
  private pwr jdField_a_of_type_Pwr;
  private pwu jdField_a_of_type_Pwu;
  private pwz jdField_a_of_type_Pwz;
  private pyj jdField_a_of_type_Pyj;
  private qli jdField_a_of_type_Qli;
  private qnn jdField_a_of_type_Qnn;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private int c;
  
  public static pkm a()
  {
    try
    {
      if (jdField_a_of_type_Pkm == null)
      {
        jdField_a_of_type_Pkm = new pkm();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      pkm localpkm = jdField_a_of_type_Pkm;
      return localpkm;
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
    localReportInfo.mUin = pay.a();
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
        rdy localrdy = new rdy();
        localrdy.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer != null) {
          localrdy.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rer.jdField_a_of_type_Long;
        }
        localrdy.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localrdy.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localrdy;
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
  
  private void u()
  {
    if (this.jdField_a_of_type_Oqc != null)
    {
      this.jdField_a_of_type_Oqc.a();
      this.jdField_a_of_type_Oqc = null;
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Plx != null)
    {
      this.jdField_a_of_type_Plx.a();
      this.jdField_a_of_type_Plx = null;
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Qnn != null)
    {
      this.jdField_a_of_type_Qnn.a();
      this.jdField_a_of_type_Qnn = null;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Pvg != null)
    {
      this.jdField_a_of_type_Pvg.a();
      this.jdField_a_of_type_Pvg = null;
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Pvo != null)
    {
      this.jdField_a_of_type_Pvo.a();
      this.jdField_a_of_type_Pvo = null;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Pwr.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Ptv.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = pay.a() + "_" + paramInt;
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
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pto.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pto.a(paramInt1, paramInt2);
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
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pto.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (ptk.a(paramLong)) {
      return ptk.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_Ptv.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ptv.a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Puh != null) {
      return this.jdField_a_of_type_Puh.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = pay.a();
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
    if (this.jdField_a_of_type_Puv != null) {
      return this.jdField_a_of_type_Puv.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_Puv != null) {
      return this.jdField_a_of_type_Puv.a();
    }
    return null;
  }
  
  public List<rcp> a()
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Puf.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Puf.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      return this.jdField_a_of_type_Ptv.b(paramInteger);
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
    return pvf.a(localArrayList);
  }
  
  public opb a()
  {
    return this.jdField_a_of_type_Opb;
  }
  
  public oqc a()
  {
    return this.jdField_a_of_type_Oqc;
  }
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_Pul != null) {
      return this.jdField_a_of_type_Pul.b();
    }
    return null;
  }
  
  public owh a()
  {
    return this.jdField_a_of_type_Owh;
  }
  
  public pjn a()
  {
    return this.jdField_a_of_type_Pjn;
  }
  
  public pjr a()
  {
    return this.jdField_a_of_type_Pjr;
  }
  
  public plx a()
  {
    return this.jdField_a_of_type_Plx;
  }
  
  public pto a()
  {
    return this.jdField_a_of_type_Pto;
  }
  
  public ptv a()
  {
    return this.jdField_a_of_type_Ptv;
  }
  
  public puc a()
  {
    return this.jdField_a_of_type_Puc;
  }
  
  public pum a()
  {
    return this.jdField_a_of_type_Pum;
  }
  
  public puw a()
  {
    return this.jdField_a_of_type_Puw;
  }
  
  public puz a()
  {
    return this.jdField_a_of_type_Puz;
  }
  
  public pvo a()
  {
    return this.jdField_a_of_type_Pvo;
  }
  
  public pvs a()
  {
    return this.jdField_a_of_type_Pvs;
  }
  
  public pvu a()
  {
    return this.jdField_a_of_type_Pvu;
  }
  
  public pvx a()
  {
    return this.jdField_a_of_type_Pvx;
  }
  
  public pwc a()
  {
    return this.jdField_a_of_type_Pwc;
  }
  
  public pwu a()
  {
    return this.jdField_a_of_type_Pwu;
  }
  
  public pyj a()
  {
    return this.jdField_a_of_type_Pyj;
  }
  
  public qnn a()
  {
    return this.jdField_a_of_type_Qnn;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(qln paramqln, int paramInt1, int paramInt2, int paramInt3, int paramInt4, oaa paramoaa)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pto.a(paramqln, paramInt1, paramInt2, paramInt3, paramInt4, paramoaa);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puf.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Puh == null)
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
      this.jdField_a_of_type_Puh.b(true);
      return;
    }
    this.jdField_a_of_type_Puh.d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pto.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, oaa paramoaa)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pto.a(paramInt1, paramInt2, paramInt3, paramInt4, paramoaa);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      this.jdField_a_of_type_Ptv.a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Puf == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    rcp localrcp;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Puf.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localrcp = (rcp)((Iterator)localObject).next();
        i = rgp.a(localrcp.jdField_a_of_type_JavaUtilList, new pkn(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localrcp.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localrcp.jdField_a_of_type_JavaUtilList.remove(i);
    if (localrcp == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localrcp = (rcp)localList.get(0);
      i = rgp.a(localrcp.jdField_a_of_type_JavaUtilList, new pko(this));
      if (QLog.isColorLevel()) {
        puf.a(localrcp.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localrcp.jdField_a_of_type_JavaUtilList != null))
      {
        pcg.a(pay.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label404;
        }
        localrcp.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        odq.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", pay.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label404:
        localrcp.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (pcl.c(paramInt)) {
      return;
    }
    String str = pay.a() + "_" + paramInt;
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
    this.jdField_a_of_type_Ptv.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Ptv != null)
    {
      if (pay.j(paramBaseArticleInfo))
      {
        localObject = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_Ptv.a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_Ptv.a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Pua != null) && (paramBoolean.booleanValue())) {
        if (pay.j(paramBaseArticleInfo))
        {
          paramBoolean = paramBaseArticleInfo.mGroupSubArticleList.iterator();
          while (paramBoolean.hasNext())
          {
            localObject = (BaseArticleInfo)paramBoolean.next();
            this.jdField_a_of_type_Pua.a(((BaseArticleInfo)localObject).mArticleID);
          }
          QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
        }
        else
        {
          this.jdField_a_of_type_Pua.a(paramBaseArticleInfo.mArticleID);
        }
      }
    }
    for (;;)
    {
      pma.a.a(paramInt, paramBaseArticleInfo);
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
        rcp localrcp = (rcp)localList.get(i);
        int j = 0;
        while (j < localrcp.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localrcp.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localrcp.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
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
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puf.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<pkc> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<pkc> paramList1, List<qlm> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    List localList = this.jdField_a_of_type_Ptv.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_Ptv.a(Integer.valueOf(paramInt1));
    qln localqln = new qln();
    localqln.jdField_b_of_type_Int = paramInt1;
    localqln.jdField_a_of_type_Long = -1L;
    localqln.jdField_b_of_type_Boolean = true;
    localqln.jdField_a_of_type_JavaUtilList = localList;
    localqln.jdField_c_of_type_Boolean = false;
    localqln.jdField_b_of_type_JavaUtilList = paramList;
    localqln.jdField_h_of_type_Int = paramInt2;
    localqln.jdField_d_of_type_Boolean = true;
    localqln.jdField_e_of_type_Boolean = true;
    localqln.jdField_f_of_type_Boolean = paramBoolean1;
    localqln.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Ptv.a(Integer.valueOf(paramInt1));
    localqln.jdField_g_of_type_Boolean = paramBoolean2;
    localqln.jdField_b_of_type_ArrayOfByte = ptv.a();
    localqln.jdField_c_of_type_Int = paramInt3;
    localqln.jdField_a_of_type_JavaLangString = paramString1;
    localqln.jdField_c_of_type_Long = paramLong1;
    localqln.jdField_b_of_type_JavaLangString = paramString2;
    localqln.jdField_d_of_type_Int = paramInt4;
    localqln.jdField_d_of_type_Long = paramLong2;
    localqln.jdField_e_of_type_Long = paramLong3;
    localqln.jdField_c_of_type_JavaLangString = paramString3;
    localqln.jdField_i_of_type_Boolean = paramBoolean3;
    localqln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localqln.jdField_i_of_type_Int |= paramInt6;
    localqln.jdField_d_of_type_JavaUtilList = paramList2;
    localqln.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (twr.a(paramInt1)) {
      localqln.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localqln.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
    for (localqln.jdField_b_of_type_Long = -1L;; localqln.jdField_b_of_type_Long = (l + 1L))
    {
      localqln.jdField_f_of_type_Int |= 0x10;
      localqln.jdField_f_of_type_Int |= 0x20;
      localqln.jdField_f_of_type_Int |= 0x100;
      localqln.jdField_f_of_type_Int |= 0x40;
      localqln.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localqln.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localqln.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localqln.j = 2;
      }
      if (pcl.c(paramInt1)) {
        localqln.j = 3;
      }
      if (paramList1 != null) {
        localqln.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localqln.jdField_i_of_type_Int & 0x100) != 0)
      {
        localqln.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localqln.j), ", beginRecommendSeq = ", Long.valueOf(localqln.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localqln.jdField_b_of_type_Long) });
      }
      if (!bkwm.i()) {
        localqln.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localqln.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localqln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localqln.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localqln.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localqln.jdField_a_of_type_Qpg = qpd.a().a();
        qpd.a().a();
      }
      this.jdField_a_of_type_Ptv.a(localqln);
      pma.a.a(localqln.jdField_b_of_type_Int, localqln.jdField_c_of_type_Int, localqln.jdField_i_of_type_Int);
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
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + pay.d(paramString2) + " recommendFlag is : " + localqln.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pto.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      this.jdField_a_of_type_Ptv.b(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Pvg != null)
    {
      qlr localqlr = new qlr();
      localqlr.jdField_a_of_type_Int = 3;
      localqlr.jdField_a_of_type_JavaLangString = paramString;
      localqlr.jdField_a_of_type_Qls = new qls();
      localqlr.jdField_a_of_type_Qls.jdField_a_of_type_Long = paramLong;
      localqlr.jdField_a_of_type_Qls.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Pvg.a(localqlr);
    }
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    b(paramLong, paramInt);
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
          this.jdField_a_of_type_Ptv.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_Ptv.a(localArticleInfo, (int)localArticleInfo.mChannelID);
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
    if (this.jdField_a_of_type_Pua == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pua.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Ptv == null)
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
        localJSONObject.put("biuUin", pay.a());
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
  
  public void a(long paramLong1, long paramLong2, rep paramrep, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, paramrep, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, rep paramrep, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ptv == null) || (paramrep == null))
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
        this.jdField_a_of_type_Ptv.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Ptv.a(paramLong1, paramLong2, paramrep, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, rep paramrep, String paramString)
  {
    this.jdField_a_of_type_Ptv.a(paramLong1, paramLong2, paramrep, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
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
    this.jdField_a_of_type_Ptv.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<rct> paramList)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramLong, paramList);
  }
  
  public void a(long paramLong, rct paramrct)
  {
    if (paramrct == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramrct);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Pwj == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwj.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pto.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_Ptv == null)
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
    this.jdField_a_of_type_Ptv.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Puh != null) {
      this.jdField_a_of_type_Puh.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Puf.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_Ptv != null)
    {
      this.jdField_a_of_type_Ptv.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = pay.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    EntityManager localEntityManager = a().createEntityManager();
    this.jdField_a_of_type_Qli = qli.a();
    this.jdField_a_of_type_Ptv = new ptv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pwu = new pwu(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pua = new pua(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pvd = new pvd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pwr = new pwr(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puh = new puh(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pto = new pto(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puf = new puf(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pwm = new pwm(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puv = new puv(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_Pve = new pve(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pum = new pum(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    this.jdField_a_of_type_Pwj = new pwj(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puw = new puw(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puc = new puc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Ptv);
    this.jdField_a_of_type_Pwz = new pwz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pwc = new pwc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puz = new puz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Owh = new owh(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pjn = new pjn(localEntityManager, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pjr = new pjr(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pyj = new pyj(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Pul = new pul(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pvx = new pvx(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Opb = new opb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pvu = new pvu(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pvs = new pvs(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oqc = new oqc(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Plx = new plx(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qnn = new qnn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pvg = new pvg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pvo = new pvo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qli, this.jdField_a_of_type_AndroidOsHandler);
    ont.a.a();
    onu.a = null;
    pcl.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    syz.a();
    szo.b();
    this.jdField_a_of_type_Pkl = new pkl(paramAppInterface, this.jdField_a_of_type_Puw);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pto.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true);
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_Puv != null) {
      this.jdField_a_of_type_Puv.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwr.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((pay.a != null) && (pay.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_Ptv.a("" + pay.a.mFeedId, pay.a.mFeedType, -1, true);
        pay.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + pay.a);
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, rem paramrem)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramrem, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwr.a(paramString, paramContext);
    odq.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Pve == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pve.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Ptv != null)
    {
      this.jdField_a_of_type_Ptv.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Pwu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwu.a(paramList);
  }
  
  public void a(List<rcp> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Puf.a(a().a(), paramList, paramBoolean);
    this.jdField_a_of_type_Puf.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Pwu == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Pwu.a(paramList, paramString);
  }
  
  public void a(List<rcp> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Puf.a(a().a(), paramList, paramBoolean);
  }
  
  public void a(ooj paramooj)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (paramooj == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramooj);
  }
  
  public void a(rga paramrga)
  {
    if (this.jdField_a_of_type_Puv != null) {
      this.jdField_a_of_type_Puv.a(paramrga);
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
      jdField_a_of_type_Pkm = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_Qli != null)
      {
        this.jdField_a_of_type_Qli.a();
        this.jdField_a_of_type_Qli = null;
      }
      if (this.jdField_a_of_type_Ptv != null)
      {
        this.jdField_a_of_type_Ptv.a();
        this.jdField_a_of_type_Ptv = null;
      }
      if (this.jdField_a_of_type_Pwu != null)
      {
        this.jdField_a_of_type_Pwu.a();
        this.jdField_a_of_type_Pwu = null;
      }
      if (this.jdField_a_of_type_Pua != null)
      {
        this.jdField_a_of_type_Pua.b();
        this.jdField_a_of_type_Pua = null;
      }
      if (this.jdField_a_of_type_Pvd != null)
      {
        this.jdField_a_of_type_Pvd.a();
        this.jdField_a_of_type_Pvd = null;
      }
      if (this.jdField_a_of_type_Pwr != null)
      {
        this.jdField_a_of_type_Pwr.a();
        this.jdField_a_of_type_Pwr = null;
      }
      if (this.jdField_a_of_type_Puh != null)
      {
        this.jdField_a_of_type_Puh.a();
        this.jdField_a_of_type_Puh = null;
      }
      if (this.jdField_a_of_type_Pto != null)
      {
        this.jdField_a_of_type_Pto.a();
        this.jdField_a_of_type_Pto = null;
      }
      if (this.jdField_a_of_type_Puf != null)
      {
        this.jdField_a_of_type_Puf.a();
        this.jdField_a_of_type_Puf = null;
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
      if (this.jdField_a_of_type_Pwj != null)
      {
        this.jdField_a_of_type_Pwj.a();
        this.jdField_a_of_type_Pwj = null;
      }
      if (this.jdField_a_of_type_Puc != null)
      {
        this.jdField_a_of_type_Puc.a();
        this.jdField_a_of_type_Puc = null;
      }
      if (this.jdField_a_of_type_Puz != null) {
        this.jdField_a_of_type_Puz.a();
      }
      if (this.jdField_a_of_type_Pjn != null)
      {
        this.jdField_a_of_type_Pjn.a();
        this.jdField_a_of_type_Pjn = null;
      }
      if (this.jdField_a_of_type_Pjr != null)
      {
        this.jdField_a_of_type_Pjr.a();
        this.jdField_a_of_type_Pjr = null;
      }
      if (this.jdField_a_of_type_Pyj != null)
      {
        this.jdField_a_of_type_Pyj.a();
        this.jdField_a_of_type_Pyj = null;
      }
      if (this.jdField_a_of_type_Pul != null)
      {
        this.jdField_a_of_type_Pul.b();
        this.jdField_a_of_type_Pul = null;
      }
      if (this.jdField_a_of_type_Pkl != null)
      {
        this.jdField_a_of_type_Pkl.d();
        this.jdField_a_of_type_Pkl = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
      }
      if (this.jdField_a_of_type_Opb != null)
      {
        this.jdField_a_of_type_Opb.a();
        this.jdField_a_of_type_Opb = null;
      }
      if (this.jdField_a_of_type_Pvu != null)
      {
        this.jdField_a_of_type_Pvu.a();
        this.jdField_a_of_type_Pvu = null;
      }
      if (this.jdField_a_of_type_Pvs != null)
      {
        this.jdField_a_of_type_Pvs.a();
        this.jdField_a_of_type_Pvs = null;
      }
      u();
      v();
      w();
      x();
      y();
      ont.a.a();
      onu.a = null;
      pyl.a().b();
      pcl.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Puh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puh.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    if (this.jdField_a_of_type_Ptv == null)
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
      l1 = this.jdField_a_of_type_Ptv.a(Integer.valueOf(70));
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
        this.jdField_a_of_type_Ptv.a(l2, l1, this.jdField_c_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_Ptv.b(Integer.valueOf(70));
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
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Pto.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ptv == null) {
      return false;
    }
    return this.jdField_a_of_type_Ptv.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_Ptv.b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_Ptv.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Pua == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Pua.a(paramLong);
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
    if (this.jdField_a_of_type_Ptv == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return this.jdField_a_of_type_Ptv.a(paramArticleInfo);
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      return this.jdField_a_of_type_Ptv.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Ptv.b(paramLong);
  }
  
  public boolean a(rcv paramrcv, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_Ptv.a(paramrcv, paramArticleInfo);
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Puh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Puh.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pto == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pto.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_Ptv.c(Integer.valueOf(paramInt));
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
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Puf.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Puf.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      return this.jdField_a_of_type_Ptv.c(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pua == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pua.a();
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
        rcp localrcp1 = (rcp)localList.get(i);
        rcp localrcp2 = new rcp(localrcp1.jdField_a_of_type_Long, localrcp1.jdField_a_of_type_JavaLangString, localrcp1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localrcp1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localrcp1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localrcp2.jdField_a_of_type_JavaUtilList.add(localrcp1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localrcp2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (puf.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Puh == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puh.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      this.jdField_a_of_type_Ptv.b(paramInt1, paramInt2, paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      this.jdField_a_of_type_Ptv.a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Pwm != null) {
      this.jdField_a_of_type_Pwm.a(paramInt, paramString, null);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Ptv != null)
    {
      this.jdField_a_of_type_Ptv.a(paramLong);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByTopicId: mArticleInfoModule is null when search " + paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Pkl != null) {
      this.jdField_a_of_type_Pkl.a(paramLong, paramInt);
    }
    if (this.jdField_a_of_type_Puw != null) {
      this.jdField_a_of_type_Puw.a(paramLong, paramInt);
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.b(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwr.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Puv != null) {
      return this.jdField_a_of_type_Puv.a();
    }
    return 0;
  }
  
  public List<rcz> c()
  {
    if (this.jdField_a_of_type_Puw == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Puw.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.f();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puf.c(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(long paramLong, int paramInt)
  {
    a(paramLong, paramInt, false);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwr.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puf.a(paramBoolean);
  }
  
  public int d()
  {
    String str = pay.a();
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
    if (this.jdField_a_of_type_Pvd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pvd.b();
    this.jdField_a_of_type_Pvd.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ptv.a(paramInt1, paramInt2);
  }
  
  public void d(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Ptv.b(paramArticleInfo);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Puv != null) {
      this.jdField_a_of_type_Puv.a(paramBoolean);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwr.f();
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
    if (this.jdField_a_of_type_Pwm == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfInfo mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwm.a(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pkl != null) {
      this.jdField_a_of_type_Pkl.c(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_Puv != null) {
      this.jdField_a_of_type_Puv.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Puv != null) {
      this.jdField_a_of_type_Puv.a(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Pwr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pwr.g();
  }
  
  public void g(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Ptv != null)
    {
      this.jdField_a_of_type_Ptv.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Ptv == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ptv.d();
      if (this.jdField_a_of_type_Pwr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pwr.d();
  }
  
  public void h(int paramInt)
  {
    String str = pay.a();
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
    if (this.jdField_a_of_type_Ptv != null)
    {
      this.jdField_a_of_type_Ptv.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Pwr != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Pto != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_Ptv.e();
      break;
      label80:
      this.jdField_a_of_type_Pwr.e();
    }
    label90:
    this.jdField_a_of_type_Pto.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_Ptv != null) {
      this.jdField_a_of_type_Ptv.d(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Pul != null) {
      this.jdField_a_of_type_Pul.a(paramString);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Ptv == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ptv.b();
      if (this.jdField_a_of_type_Pwr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pwr.b();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_Pvg != null)
    {
      qlr localqlr = new qlr();
      localqlr.jdField_a_of_type_Int = 4;
      localqlr.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Pvg.a(localqlr);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ptv == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ptv.c();
      if (this.jdField_a_of_type_Pwr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pwr.c();
  }
  
  public void k(String paramString)
  {
    if (this.jdField_a_of_type_Pvg != null)
    {
      qlr localqlr = new qlr();
      localqlr.jdField_a_of_type_Int = 5;
      localqlr.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Pvg.a(localqlr);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puf.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Puf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Puf.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Ptv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ptv.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Puw != null) {
      this.jdField_a_of_type_Puw.a(300, 2);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Pwm != null) {
      this.jdField_a_of_type_Pwm.a();
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
    if (this.jdField_a_of_type_Pul != null)
    {
      this.jdField_a_of_type_Pul.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_Pvg != null)
    {
      qlr localqlr = new qlr();
      localqlr.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Pvg.a(localqlr);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pkm
 * JD-Core Version:    0.7.0.1
 */