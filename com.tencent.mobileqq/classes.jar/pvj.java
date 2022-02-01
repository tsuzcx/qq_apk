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
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule;
import com.tencent.biz.pubaccount.readinjoy.model.RIJCommentReportModule.CommentReportInfo;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule;
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
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class pvj
{
  private static long jdField_a_of_type_Long;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static pvj jdField_a_of_type_Pvj;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private RIJCommentReportModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule;
  private RIJUserLevelRequestModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private owz jdField_a_of_type_Owz;
  private oya jdField_a_of_type_Oya;
  private pfi jdField_a_of_type_Pfi;
  private puk jdField_a_of_type_Puk;
  private puo jdField_a_of_type_Puo;
  private pvi jdField_a_of_type_Pvi;
  private pwu jdField_a_of_type_Pwu;
  private qel jdField_a_of_type_Qel;
  private qep jdField_a_of_type_Qep;
  private qeu jdField_a_of_type_Qeu;
  private qew jdField_a_of_type_Qew;
  private qez jdField_a_of_type_Qez;
  private qfb jdField_a_of_type_Qfb;
  private qff jdField_a_of_type_Qff;
  private qfg jdField_a_of_type_Qfg;
  private qfp jdField_a_of_type_Qfp;
  private qfq jdField_a_of_type_Qfq;
  private qft jdField_a_of_type_Qft;
  private qfx jdField_a_of_type_Qfx;
  private qfy jdField_a_of_type_Qfy;
  private qge jdField_a_of_type_Qge;
  private qgo jdField_a_of_type_Qgo;
  private qgs jdField_a_of_type_Qgs;
  private qgv jdField_a_of_type_Qgv;
  private qhd jdField_a_of_type_Qhd;
  private qhi jdField_a_of_type_Qhi;
  private qhp jdField_a_of_type_Qhp;
  private qhs jdField_a_of_type_Qhs;
  private qhx jdField_a_of_type_Qhx;
  private qia jdField_a_of_type_Qia;
  private qif jdField_a_of_type_Qif;
  private qko jdField_a_of_type_Qko;
  private qxn jdField_a_of_type_Qxn;
  private qzs jdField_a_of_type_Qzs;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean;
  private int c;
  
  private void A()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule = null;
    }
  }
  
  private void B()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
    }
    if (this.jdField_a_of_type_Owz != null)
    {
      this.jdField_a_of_type_Owz.a();
      this.jdField_a_of_type_Owz = null;
    }
    if (this.jdField_a_of_type_Qgv != null)
    {
      this.jdField_a_of_type_Qgv.a();
      this.jdField_a_of_type_Qgv = null;
    }
    if (this.jdField_a_of_type_Qgs != null)
    {
      this.jdField_a_of_type_Qgs.a();
      this.jdField_a_of_type_Qgs = null;
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = null;
    }
    if (this.jdField_a_of_type_Qhp != null)
    {
      this.jdField_a_of_type_Qhp.a();
      this.jdField_a_of_type_Qhp = null;
    }
    if (this.jdField_a_of_type_Qew != null)
    {
      this.jdField_a_of_type_Qew.a();
      this.jdField_a_of_type_Qew = null;
    }
    if (this.jdField_a_of_type_Qft != null) {
      this.jdField_a_of_type_Qft.a();
    }
    if (this.jdField_a_of_type_Puk != null)
    {
      this.jdField_a_of_type_Puk.a();
      this.jdField_a_of_type_Puk = null;
    }
    if (this.jdField_a_of_type_Puo != null)
    {
      this.jdField_a_of_type_Puo.a();
      this.jdField_a_of_type_Puo = null;
    }
    if (this.jdField_a_of_type_Qko != null)
    {
      this.jdField_a_of_type_Qko.a();
      this.jdField_a_of_type_Qko = null;
    }
    if (this.jdField_a_of_type_Qff != null)
    {
      this.jdField_a_of_type_Qff.b();
      this.jdField_a_of_type_Qff = null;
    }
    if (this.jdField_a_of_type_Qep != null)
    {
      this.jdField_a_of_type_Qep.b();
      this.jdField_a_of_type_Qep = null;
    }
    if (this.jdField_a_of_type_Qia != null)
    {
      this.jdField_a_of_type_Qia.a();
      this.jdField_a_of_type_Qia = null;
    }
    if (this.jdField_a_of_type_Qeu != null)
    {
      this.jdField_a_of_type_Qeu.b();
      this.jdField_a_of_type_Qeu = null;
    }
    if (this.jdField_a_of_type_Qfx != null)
    {
      this.jdField_a_of_type_Qfx.a();
      this.jdField_a_of_type_Qfx = null;
    }
    if (this.jdField_a_of_type_Qhx != null)
    {
      this.jdField_a_of_type_Qhx.a();
      this.jdField_a_of_type_Qhx = null;
    }
    if (this.jdField_a_of_type_Qfb != null)
    {
      this.jdField_a_of_type_Qfb.a();
      this.jdField_a_of_type_Qfb = null;
    }
    if (this.jdField_a_of_type_Qel != null)
    {
      this.jdField_a_of_type_Qel.a();
      this.jdField_a_of_type_Qel = null;
    }
    if (this.jdField_a_of_type_Qez != null)
    {
      this.jdField_a_of_type_Qez.a();
      this.jdField_a_of_type_Qez = null;
    }
  }
  
  public static pvj a()
  {
    try
    {
      if (jdField_a_of_type_Pvj == null)
      {
        jdField_a_of_type_Pvj = new pvj();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      pvj localpvj = jdField_a_of_type_Pvj;
      return localpvj;
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
    localReportInfo.mUin = pkh.a();
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
        rqf localrqf = new rqf();
        localrqf.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy != null) {
          localrqf.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long;
        }
        localrqf.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localrqf.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localrqf;
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
    QLog.d("ReadInJoyLogicEngine", 1, "requestRefreshChannelIfNeed: " + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      l();
    }
  }
  
  private void v()
  {
    if (this.jdField_a_of_type_Oya != null)
    {
      this.jdField_a_of_type_Oya.a();
      this.jdField_a_of_type_Oya = null;
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_Pwu != null)
    {
      this.jdField_a_of_type_Pwu.a();
      this.jdField_a_of_type_Pwu = null;
    }
  }
  
  private void x()
  {
    if (this.jdField_a_of_type_Qzs != null)
    {
      this.jdField_a_of_type_Qzs.a();
      this.jdField_a_of_type_Qzs = null;
    }
  }
  
  private void y()
  {
    if (this.jdField_a_of_type_Qge != null)
    {
      this.jdField_a_of_type_Qge.a();
      this.jdField_a_of_type_Qge = null;
    }
  }
  
  private void z()
  {
    if (this.jdField_a_of_type_Qgo != null)
    {
      this.jdField_a_of_type_Qgo.a();
      this.jdField_a_of_type_Qgo = null;
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Qhx.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Qep.a().a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = pkh.a() + "_" + paramInt;
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
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qel.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qel.a(paramInt1, paramInt2);
  }
  
  public RIJUserLevelRequestModule a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule;
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
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qel.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (qeh.a(paramLong)) {
      return qeh.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_Qep.a().a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qep.a().a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Qfb != null) {
      return this.jdField_a_of_type_Qfb.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public EntityManagerFactory a()
  {
    Object localObject1 = pkh.a();
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
    if (this.jdField_a_of_type_Qfp != null) {
      return this.jdField_a_of_type_Qfp.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_Qfp != null) {
      return this.jdField_a_of_type_Qfp.a();
    }
    return null;
  }
  
  public List<rov> a()
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qez.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qez.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Qep != null) {
      return this.jdField_a_of_type_Qep.a().c(paramInteger);
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
    return qfz.a(localArrayList);
  }
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_Qff != null) {
      return this.jdField_a_of_type_Qff.b();
    }
    return null;
  }
  
  public owz a()
  {
    return this.jdField_a_of_type_Owz;
  }
  
  public oya a()
  {
    return this.jdField_a_of_type_Oya;
  }
  
  public pfi a()
  {
    return this.jdField_a_of_type_Pfi;
  }
  
  public puk a()
  {
    return this.jdField_a_of_type_Puk;
  }
  
  public puo a()
  {
    return this.jdField_a_of_type_Puo;
  }
  
  public pwu a()
  {
    return this.jdField_a_of_type_Pwu;
  }
  
  public qel a()
  {
    return this.jdField_a_of_type_Qel;
  }
  
  public qep a()
  {
    return this.jdField_a_of_type_Qep;
  }
  
  public qew a()
  {
    return this.jdField_a_of_type_Qew;
  }
  
  public qfg a()
  {
    return this.jdField_a_of_type_Qfg;
  }
  
  public qfq a()
  {
    return this.jdField_a_of_type_Qfq;
  }
  
  public qft a()
  {
    return this.jdField_a_of_type_Qft;
  }
  
  public qgo a()
  {
    return this.jdField_a_of_type_Qgo;
  }
  
  public qgs a()
  {
    return this.jdField_a_of_type_Qgs;
  }
  
  public qgv a()
  {
    return this.jdField_a_of_type_Qgv;
  }
  
  public qhd a()
  {
    return this.jdField_a_of_type_Qhd;
  }
  
  public qhi a()
  {
    return this.jdField_a_of_type_Qhi;
  }
  
  public qia a()
  {
    return this.jdField_a_of_type_Qia;
  }
  
  public qko a()
  {
    return this.jdField_a_of_type_Qko;
  }
  
  public qzs a()
  {
    return this.jdField_a_of_type_Qzs;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(qxs paramqxs, int paramInt1, int paramInt2, int paramInt3, int paramInt4, oha paramoha)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qel.a(paramqxs, paramInt1, paramInt2, paramInt3, paramInt4, paramoha);
  }
  
  public void a()
  {
    this.jdField_c_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qez.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qfb == null)
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
      this.jdField_a_of_type_Qfb.b(true);
      return;
    }
    this.jdField_a_of_type_Qfb.d();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qel.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, oha paramoha)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qel.a(paramInt1, paramInt2, paramInt3, paramInt4, paramoha);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a().b(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_Qep != null) {
      this.jdField_a_of_type_Qep.a().a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Qez == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    rov localrov;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Qez.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localrov = (rov)((Iterator)localObject).next();
        i = rsw.a(localrov.jdField_a_of_type_JavaUtilList, new pvk(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localrov.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localrov.jdField_a_of_type_JavaUtilList.remove(i);
    if (localrov == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localrov = (rov)localList.get(0);
      i = rsw.a(localrov.jdField_a_of_type_JavaUtilList, new pvl(this));
      if (QLog.isColorLevel()) {
        qez.a(localrov.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localrov.jdField_a_of_type_JavaUtilList != null))
      {
        plh.a(pkh.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label405;
        }
        localrov.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        olh.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", pqf.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label405:
        localrov.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (plm.c(paramInt)) {
      return;
    }
    String str = pkh.a() + "_" + paramInt;
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
    this.jdField_a_of_type_Qep.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    Object localObject;
    if (this.jdField_a_of_type_Qep != null)
    {
      if (pqw.j(paramBaseArticleInfo))
      {
        localObject = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)((Iterator)localObject).next();
          this.jdField_a_of_type_Qep.a().a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_Qep.a().a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Qeu != null) && (paramBoolean.booleanValue())) {
        if (pqw.j(paramBaseArticleInfo))
        {
          paramBoolean = paramBaseArticleInfo.mGroupSubArticleList.iterator();
          while (paramBoolean.hasNext())
          {
            localObject = (BaseArticleInfo)paramBoolean.next();
            this.jdField_a_of_type_Qeu.a(((BaseArticleInfo)localObject).mArticleID);
          }
          QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
        }
        else
        {
          this.jdField_a_of_type_Qeu.a(paramBaseArticleInfo.mArticleID);
        }
      }
    }
    for (;;)
    {
      pwx.a.a(paramInt, paramBaseArticleInfo);
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
        rov localrov = (rov)localList.get(i);
        int j = 0;
        while (j < localrov.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localrov.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localrov.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
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
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qez.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<puz> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<puz> paramList1, List<qxr> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      return;
    }
    List localList = this.jdField_a_of_type_Qep.a().c(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_Qep.a().a(Integer.valueOf(paramInt1));
    qxs localqxs = new qxs();
    localqxs.jdField_b_of_type_Int = paramInt1;
    localqxs.jdField_a_of_type_Long = -1L;
    localqxs.jdField_b_of_type_Boolean = true;
    localqxs.jdField_a_of_type_JavaUtilList = localList;
    localqxs.jdField_c_of_type_Boolean = false;
    localqxs.jdField_b_of_type_JavaUtilList = paramList;
    localqxs.jdField_h_of_type_Int = paramInt2;
    localqxs.jdField_d_of_type_Boolean = true;
    localqxs.jdField_e_of_type_Boolean = true;
    localqxs.jdField_f_of_type_Boolean = paramBoolean1;
    localqxs.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Qep.a().a(Integer.valueOf(paramInt1));
    localqxs.jdField_g_of_type_Boolean = paramBoolean2;
    localqxs.jdField_b_of_type_ArrayOfByte = qer.a();
    localqxs.jdField_c_of_type_Int = paramInt3;
    localqxs.jdField_a_of_type_JavaLangString = paramString1;
    localqxs.jdField_c_of_type_Long = paramLong1;
    localqxs.jdField_b_of_type_JavaLangString = paramString2;
    localqxs.jdField_d_of_type_Int = paramInt4;
    localqxs.jdField_d_of_type_Long = paramLong2;
    localqxs.jdField_e_of_type_Long = paramLong3;
    localqxs.jdField_c_of_type_JavaLangString = paramString3;
    localqxs.jdField_i_of_type_Boolean = paramBoolean3;
    localqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localqxs.jdField_i_of_type_Int |= paramInt6;
    localqxs.jdField_d_of_type_JavaUtilList = paramList2;
    localqxs.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (uks.a(paramInt1)) {
      localqxs.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localqxs.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
    for (localqxs.jdField_b_of_type_Long = -1L;; localqxs.jdField_b_of_type_Long = (l + 1L))
    {
      localqxs.jdField_f_of_type_Int |= 0x10;
      localqxs.jdField_f_of_type_Int |= 0x20;
      localqxs.jdField_f_of_type_Int |= 0x100;
      localqxs.jdField_f_of_type_Int |= 0x40;
      localqxs.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localqxs.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localqxs.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localqxs.j = 2;
      }
      if (plm.c(paramInt1)) {
        localqxs.j = 3;
      }
      if (paramList1 != null) {
        localqxs.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localqxs.jdField_i_of_type_Int & 0x100) != 0)
      {
        localqxs.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localqxs.j), ", beginRecommendSeq = ", Long.valueOf(localqxs.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localqxs.jdField_b_of_type_Long) });
      }
      if (!bmhv.l()) {
        localqxs.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localqxs.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localqxs.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localqxs.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localqxs.jdField_a_of_type_Rbl = rbi.a().a();
        rbi.a().a();
      }
      this.jdField_a_of_type_Qep.a(localqxs);
      pwx.a.a(localqxs.jdField_b_of_type_Int, localqxs.jdField_c_of_type_Int, localqxs.jdField_i_of_type_Int);
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
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + pqu.a(paramString2) + " recommendFlag is : " + localqxs.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qel.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Qep != null) {
      this.jdField_a_of_type_Qep.a().a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Qge != null)
    {
      qxw localqxw = new qxw();
      localqxw.jdField_a_of_type_Int = 3;
      localqxw.jdField_a_of_type_JavaLangString = paramString;
      localqxw.jdField_a_of_type_Qxx = new qxx();
      localqxw.jdField_a_of_type_Qxx.jdField_a_of_type_Long = paramLong;
      localqxw.jdField_a_of_type_Qxx.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Qge.a(localqxw);
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
    label95:
    ArticleInfo localArticleInfo;
    int i;
    label145:
    Object localObject2;
    if (((Iterator)localObject1).hasNext())
    {
      localArticleInfo = (ArticleInfo)((Iterator)localObject1).next();
      if (localArticleInfo.mSocialFeedInfo == null) {
        break label465;
      }
      if ((localArticleInfo.mSocialFeedInfo.jdField_h_of_type_Int == 2) || (paramInt != 2)) {
        break label459;
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
            break label95;
          }
          this.jdField_a_of_type_Qep.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_Qep.a().a(localArticleInfo, (int)localArticleInfo.mChannelID);
          if ((k != 0) && (localArticleInfo != null)) {
            localArticleInfo.isNeedShowBtnWhenFollowed = true;
          }
          if (localArticleInfo != null) {
            localArticleInfo.invalidateProteusTemplateBean();
          }
          if ((!paramBoolean) || (localArticleInfo == null)) {
            break label95;
          }
          localArticleInfo.needShowFollwedButton = false;
          break label95;
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
      label459:
      i = 0;
      break label145;
      label465:
      i = 0;
      int j = 0;
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Qeu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qeu.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Qep == null)
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
        localJSONObject.put("biuUin", pkh.a());
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
  
  public void a(long paramLong1, long paramLong2, rqw paramrqw, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, paramrqw, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, rqw paramrqw, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Qep == null) || (paramrqw == null))
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
        this.jdField_a_of_type_Qep.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Qep.a(paramLong1, paramLong2, paramrqw, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, rqw paramrqw, String paramString)
  {
    this.jdField_a_of_type_Qep.a(paramLong1, paramLong2, paramrqw, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
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
    this.jdField_a_of_type_Qep.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<roz> paramList)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramLong, paramList);
  }
  
  public void a(long paramLong, roz paramroz)
  {
    if (paramroz == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramroz);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Qhp == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhp.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qel.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(RIJCommentReportModule.CommentReportInfo paramCommentReportInfo)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule.a(paramCommentReportInfo);
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Qep.a().a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_Qep == null)
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
    this.jdField_a_of_type_Qep.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Qfb != null) {
      this.jdField_a_of_type_Qfb.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Qez.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_Qep != null)
    {
      this.jdField_a_of_type_Qep.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = pkh.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    EntityManager localEntityManager = a().createEntityManager();
    this.jdField_a_of_type_Qxn = qxn.a();
    this.jdField_a_of_type_Qep = new qep(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qia = new qia(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qeu = new qeu(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qfx = new qfx(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qhx = new qhx(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qfb = new qfb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qel = new qel(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qez = new qez(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qhs = new qhs(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qfp = new qfp(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_Qfy = new qfy(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qfg = new qfg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    this.jdField_a_of_type_Qhp = new qhp(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qfq = new qfq(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qew = new qew(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Qep);
    this.jdField_a_of_type_Qif = new qif(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qhi = new qhi(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qft = new qft(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfi = new pfi(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puk = new puk(localEntityManager, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Puo = new puo(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qko = new qko(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qff = new qff(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qhd = new qhd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Owz = new owz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qgv = new qgv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qgs = new qgs(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oya = new oya(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pwu = new pwu(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qzs = new qzs(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qge = new qge(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Qgo = new qgo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJCommentReportModule = new RIJCommentReportModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelRIJUserLevelRequestModule = new RIJUserLevelRequestModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localEntityManager, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_AndroidOsHandler);
    ovq.a.a();
    ovr.a = null;
    plm.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    pdv.f();
    tmh.a();
    tmw.b();
    this.jdField_a_of_type_Pvi = new pvi(paramAppInterface, this.jdField_a_of_type_Qfq);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
    u();
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qel.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true, new pko(Boolean.valueOf(false)));
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_Qfp != null) {
      this.jdField_a_of_type_Qfp.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhx.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((pqx.a != null) && (pqx.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_Qep.a("" + pqx.a.mFeedId, pqx.a.mFeedType, -1, true);
        pqx.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + pqx.a);
      return;
    }
    this.jdField_a_of_type_Qep.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, rqt paramrqt)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramrqt, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhx.a(paramString, paramContext);
    olh.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Qfy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qfy.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Qep != null)
    {
      this.jdField_a_of_type_Qep.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Qia == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qia.a(paramList);
  }
  
  public void a(List<rov> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Qez.a(a().a(), paramList, paramBoolean);
    this.jdField_a_of_type_Qez.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Qia == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Qia.a(paramList, paramString);
  }
  
  public void a(List<rov> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Qez.a(a().a(), paramList, paramBoolean);
  }
  
  public void a(owh paramowh)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (paramowh == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    this.jdField_a_of_type_Qep.a(paramowh);
  }
  
  public void a(rsh paramrsh)
  {
    if (this.jdField_a_of_type_Qfp != null) {
      this.jdField_a_of_type_Qfp.a(paramrsh);
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
      jdField_a_of_type_Pvj = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_Qxn != null)
      {
        this.jdField_a_of_type_Qxn.a();
        this.jdField_a_of_type_Qxn = null;
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      if (this.jdField_a_of_type_Pvi != null)
      {
        this.jdField_a_of_type_Pvi.d();
        this.jdField_a_of_type_Pvi = null;
      }
      v();
      w();
      x();
      y();
      z();
      A();
      B();
      ovq.a.a();
      ovr.a = null;
      qkq.a().b();
      plm.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qfb.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    if (this.jdField_a_of_type_Qep == null)
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
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(-1);
      }
      localHashMap = a();
      l1 = this.jdField_a_of_type_Qep.a().a(Integer.valueOf(70));
      if (l1 == -1L) {
        break label231;
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
        this.jdField_a_of_type_Qep.a(l2, l1, this.jdField_c_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_Qep.a().b(Integer.valueOf(70));
        if (l3 == -1L) {
          break label223;
        }
        localHashMap = null;
        l1 = 0L;
        l2 = l3 - 1L;
        break;
      }
      label223:
      localHashMap = null;
      l1 = 0L;
      continue;
      label231:
      l1 = 0L;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Qel.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qep == null) {
      return false;
    }
    return this.jdField_a_of_type_Qep.a().a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_Qep.a().b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_Qep.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Qeu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Qeu.a(paramLong);
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
    if (this.jdField_a_of_type_Qep == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return this.jdField_a_of_type_Qep.a().a(paramArticleInfo);
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qep != null) {
      return this.jdField_a_of_type_Qep.a().a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Qep.a(paramLong);
  }
  
  public boolean a(rpb paramrpb, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_Qep.a(paramrpb, paramArticleInfo);
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Qfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Qfb.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Qel == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qel.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_Qep.a().b(Integer.valueOf(paramInt));
    if ((localList != null) && (!localList.isEmpty()))
    {
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= localList.size()) {
          break label107;
        }
        ArticleInfo localArticleInfo = (ArticleInfo)localList.get(paramInt);
        localObject = localArticleInfo;
        if (localArticleInfo.mArticleID == paramLong) {
          break;
        }
        paramInt += 1;
      }
    }
    label107:
    return null;
  }
  
  public List<TabChannelCoverInfo> b()
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qez.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Qez.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Qep != null) {
      return this.jdField_a_of_type_Qep.a().b(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qeu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qeu.a();
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
        rov localrov1 = (rov)localList.get(i);
        rov localrov2 = new rov(localrov1.jdField_a_of_type_Long, localrov1.jdField_a_of_type_JavaLangString, localrov1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localrov1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localrov1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localrov2.jdField_a_of_type_JavaUtilList.add(localrov1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localrov2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (qez.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Qfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qfb.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qep != null) {
      this.jdField_a_of_type_Qep.a().a(paramInt1, paramInt2, paramLong, paramBoolean);
    }
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_Qep != null) {
      this.jdField_a_of_type_Qep.a().a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Qhs != null) {
      this.jdField_a_of_type_Qhs.a(paramInt, paramString, null);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Qep != null)
    {
      this.jdField_a_of_type_Qep.a(paramLong);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByTopicId: mArticleInfoModule is null when search " + paramLong);
  }
  
  public void b(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Pvi != null) {
      this.jdField_a_of_type_Pvi.a(paramLong, paramInt);
    }
    if (this.jdField_a_of_type_Qfq != null) {
      this.jdField_a_of_type_Qfq.a(paramLong, paramInt);
    }
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a().b(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhx.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Qfp != null) {
      return this.jdField_a_of_type_Qfp.a();
    }
    return 0;
  }
  
  public List<rpf> c()
  {
    if (this.jdField_a_of_type_Qfq == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Qfq.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a().b();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qez.c(paramInt);
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
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhx.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qez.a(paramBoolean);
  }
  
  public int d()
  {
    String str = pkh.a();
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
    if (this.jdField_a_of_type_Qfx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qfx.b();
    this.jdField_a_of_type_Qfx.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qep.a().a(paramInt1, paramInt2);
  }
  
  public void d(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Qep.a().b(paramArticleInfo);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Qfp != null) {
      this.jdField_a_of_type_Qfp.a(paramBoolean);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhx.f();
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
    if (this.jdField_a_of_type_Qhs == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfInfo mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhs.a(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pvi != null) {
      this.jdField_a_of_type_Pvi.c(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_Qfp != null) {
      this.jdField_a_of_type_Qfp.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Qfp != null) {
      this.jdField_a_of_type_Qfp.a(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Qhx == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qhx.g();
  }
  
  public void g(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Qep != null)
    {
      this.jdField_a_of_type_Qep.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Qep == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Qep.e();
      if (this.jdField_a_of_type_Qhx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Qhx.d();
  }
  
  public void h(int paramInt)
  {
    String str = pkh.a();
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
    if (this.jdField_a_of_type_Qep != null)
    {
      this.jdField_a_of_type_Qep.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Qhx != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Qel != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_Qep.f();
      break;
      label80:
      this.jdField_a_of_type_Qhx.e();
    }
    label90:
    this.jdField_a_of_type_Qel.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_Qep != null) {
      this.jdField_a_of_type_Qep.a().c(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Qff != null) {
      this.jdField_a_of_type_Qff.a(paramString);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Qep == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Qep.c();
      if (this.jdField_a_of_type_Qhx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Qhx.b();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_Qge != null)
    {
      qxw localqxw = new qxw();
      localqxw.jdField_a_of_type_Int = 4;
      localqxw.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Qge.a(localqxw);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Qep == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Qep.d();
      if (this.jdField_a_of_type_Qhx != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Qhx.c();
  }
  
  public void k(String paramString)
  {
    if (this.jdField_a_of_type_Qge != null)
    {
      qxw localqxw = new qxw();
      localqxw.jdField_a_of_type_Int = 5;
      localqxw.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_Qge.a(localqxw);
    }
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      QLog.d("Q.readinjoy.info_module", 1, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      this.jdField_b_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Qez.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Qez == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qez.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Qep == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Qep.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Qfq != null) {
      this.jdField_a_of_type_Qfq.a(300, 2);
    }
  }
  
  public void q()
  {
    if (this.jdField_a_of_type_Qhs != null) {
      this.jdField_a_of_type_Qhs.a();
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
    if (this.jdField_a_of_type_Qff != null)
    {
      this.jdField_a_of_type_Qff.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_Qge != null)
    {
      qxw localqxw = new qxw();
      localqxw.jdField_a_of_type_Int = 1;
      this.jdField_a_of_type_Qge.a(localqxw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pvj
 * JD-Core Version:    0.7.0.1
 */