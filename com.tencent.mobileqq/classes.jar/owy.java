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

public class owy
{
  private static long jdField_a_of_type_Long;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static owy jdField_a_of_type_Owy;
  private final int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private awgg jdField_a_of_type_Awgg;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private oim jdField_a_of_type_Oim;
  private oof jdField_a_of_type_Oof;
  private ovz jdField_a_of_type_Ovz;
  private owd jdField_a_of_type_Owd;
  private owx jdField_a_of_type_Owx;
  private pes jdField_a_of_type_Pes;
  private pew jdField_a_of_type_Pew;
  private pfb jdField_a_of_type_Pfb;
  private pfd jdField_a_of_type_Pfd;
  private pfg jdField_a_of_type_Pfg;
  private pfi jdField_a_of_type_Pfi;
  private pfn jdField_a_of_type_Pfn;
  private pfo jdField_a_of_type_Pfo;
  private pfv jdField_a_of_type_Pfv;
  private pfw jdField_a_of_type_Pfw;
  private pga jdField_a_of_type_Pga;
  private pge jdField_a_of_type_Pge;
  private pgf jdField_a_of_type_Pgf;
  private pgh jdField_a_of_type_Pgh;
  private pgk jdField_a_of_type_Pgk;
  private pgo jdField_a_of_type_Pgo;
  private pgv jdField_a_of_type_Pgv;
  private pgy jdField_a_of_type_Pgy;
  private phd jdField_a_of_type_Phd;
  private phg jdField_a_of_type_Phg;
  private phk jdField_a_of_type_Phk;
  private pis jdField_a_of_type_Pis;
  private puz jdField_a_of_type_Puz;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int c;
  private int d;
  private int e;
  private int f;
  
  private owy()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
  }
  
  public static owy a()
  {
    try
    {
      if (jdField_a_of_type_Owy == null)
      {
        jdField_a_of_type_Owy = new owy();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      owy localowy = jdField_a_of_type_Owy;
      return localowy;
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
  
  public static void c(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    ReportInfo localReportInfo = new ReportInfo();
    localReportInfo.mUin = ors.a();
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
        qlv localqlv = new qlv();
        localqlv.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme != null) {
          localqlv.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qme.jdField_a_of_type_Long;
        }
        localqlv.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localqlv.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localqlv;
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
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Phd.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Pew.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = ors.a() + "_" + paramInt;
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
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pes.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pes.a(paramInt1, paramInt2);
  }
  
  public awgg a()
  {
    Object localObject1 = ors.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_Awgg == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_Awgg).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_a_of_type_Awgg = ((awgg)localObject1);
      }
      return this.jdField_a_of_type_Awgg;
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
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pes.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (peo.a(paramLong)) {
      return peo.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_Pew.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pew.a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Pfi != null) {
      return this.jdField_a_of_type_Pfi.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Pfv != null) {
      return this.jdField_a_of_type_Pfv.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_Pfv != null) {
      return this.jdField_a_of_type_Pfv.a();
    }
    return null;
  }
  
  public List<qkm> a()
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pfg.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pfg.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pew != null) {
      return this.jdField_a_of_type_Pew.b(paramInteger);
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
    return pgg.a(localArrayList);
  }
  
  public oim a()
  {
    return this.jdField_a_of_type_Oim;
  }
  
  public oof a()
  {
    return this.jdField_a_of_type_Oof;
  }
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_Pfn != null) {
      return this.jdField_a_of_type_Pfn.a();
    }
    return null;
  }
  
  public ovz a()
  {
    return this.jdField_a_of_type_Ovz;
  }
  
  public owd a()
  {
    return this.jdField_a_of_type_Owd;
  }
  
  public pes a()
  {
    return this.jdField_a_of_type_Pes;
  }
  
  public pew a()
  {
    return this.jdField_a_of_type_Pew;
  }
  
  public pfd a()
  {
    return this.jdField_a_of_type_Pfd;
  }
  
  public pfo a()
  {
    return this.jdField_a_of_type_Pfo;
  }
  
  public pga a()
  {
    return this.jdField_a_of_type_Pga;
  }
  
  public pgh a()
  {
    return this.jdField_a_of_type_Pgh;
  }
  
  public pgk a()
  {
    return this.jdField_a_of_type_Pgk;
  }
  
  public pgo a()
  {
    return this.jdField_a_of_type_Pgo;
  }
  
  public phg a()
  {
    return this.jdField_a_of_type_Phg;
  }
  
  public pis a()
  {
    return this.jdField_a_of_type_Pis;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(pve parampve, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pes.a(parampve, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfg.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pfi == null)
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
      this.jdField_a_of_type_Pfi.b(true);
      return;
    }
    this.jdField_a_of_type_Pfi.e();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pes.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nnv paramnnv)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pes.a(paramInt1, paramInt2, paramInt3, paramInt4, paramnnv);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestVideoRealTimeReplaceList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Pew.b(Integer.valueOf(paramInt1));
    Object localObject1 = new pve();
    ((pve)localObject1).jdField_b_of_type_Int = paramInt1;
    ((pve)localObject1).jdField_a_of_type_Long = -1L;
    ((pve)localObject1).jdField_b_of_type_Boolean = true;
    ((pve)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    ((pve)localObject1).jdField_c_of_type_Boolean = false;
    localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(paramLong1));
    ((pve)localObject1).jdField_b_of_type_JavaUtilList = ((List)localObject2);
    ((pve)localObject1).jdField_h_of_type_Int = 7;
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("next_video_algorithm_id", paramLong2);
      ((pve)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).toString();
      ((pve)localObject1).jdField_d_of_type_Boolean = true;
      ((pve)localObject1).jdField_e_of_type_Boolean = true;
      ((pve)localObject1).jdField_f_of_type_Boolean = true;
      ((pve)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Pew.a(Integer.valueOf(paramInt1));
      ((pve)localObject1).jdField_g_of_type_Boolean = false;
      localObject3 = this.jdField_a_of_type_Pew;
      ((pve)localObject1).jdField_b_of_type_ArrayOfByte = pew.a();
      ((pve)localObject1).jdField_c_of_type_Int = 0;
      ((pve)localObject1).jdField_a_of_type_JavaLangString = null;
      ((pve)localObject1).jdField_c_of_type_Long = -1L;
      ((pve)localObject1).jdField_b_of_type_JavaLangString = null;
      ((pve)localObject1).jdField_d_of_type_Int = paramInt2;
      ((pve)localObject1).jdField_d_of_type_Long = 0L;
      ((pve)localObject1).jdField_e_of_type_Long = 0L;
      ((pve)localObject1).jdField_i_of_type_Boolean = false;
      ((pve)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = null;
      ((pve)localObject1).jdField_g_of_type_Int = 3;
      ((pve)localObject1).jdField_b_of_type_Long = -1L;
      ((pve)localObject1).jdField_f_of_type_Int |= 0x10;
      ((pve)localObject1).jdField_f_of_type_Int |= 0x2000;
      if ((paramInt1 == 40677) || (paramInt2 == 7)) {
        ((pve)localObject1).j = 2;
      }
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (localObject3 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "requestVideoRealTimeReplaceList positionData = " + localObject3);
          }
          ((pve)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          ((pve)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy((SelectPositionModule.PositionData)localObject3);
        }
      }
      this.jdField_a_of_type_Pew.a((pve)localObject1);
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
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_Pew != null) {
      this.jdField_a_of_type_Pew.a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Pfg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    qkm localqkm;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Pfg.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localqkm = (qkm)((Iterator)localObject).next();
        i = qoa.a(localqkm.jdField_a_of_type_JavaUtilList, new owz(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localqkm.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localqkm.jdField_a_of_type_JavaUtilList.remove(i);
    if (localqkm == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localqkm = (qkm)localList.get(0);
      i = qoa.a(localqkm.jdField_a_of_type_JavaUtilList, new oxa(this));
      if (QLog.isColorLevel()) {
        pfg.a(localqkm.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localqkm.jdField_a_of_type_JavaUtilList != null))
      {
        ota.a(ors.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label404;
        }
        localqkm.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        nrt.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", ors.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label404:
        localqkm.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (otf.c(paramInt)) {
      return;
    }
    String str = ors.a() + "_" + paramInt;
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
    this.jdField_a_of_type_Pew.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pew != null)
    {
      if (ors.j(paramBaseArticleInfo))
      {
        Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          this.jdField_a_of_type_Pew.a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_Pew.a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    while ((this.jdField_a_of_type_Pfb != null) && (paramBoolean.booleanValue())) {
      if (ors.j(paramBaseArticleInfo))
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          paramBoolean = (BaseArticleInfo)paramBaseArticleInfo.next();
          this.jdField_a_of_type_Pfb.a(paramBoolean.mArticleID);
        }
        QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
      }
      else
      {
        this.jdField_a_of_type_Pfb.a(paramBaseArticleInfo.mArticleID);
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
        qkm localqkm = (qkm)localList.get(i);
        int j = 0;
        while (j < localqkm.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localqkm.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localqkm.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
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
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfg.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<owo> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<owo> paramList1, List<pvd> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_Pew.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_Pew.a(Integer.valueOf(paramInt1));
    pve localpve = new pve();
    localpve.jdField_b_of_type_Int = paramInt1;
    localpve.jdField_a_of_type_Long = -1L;
    localpve.jdField_b_of_type_Boolean = true;
    localpve.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localpve.jdField_c_of_type_Boolean = false;
    localpve.jdField_b_of_type_JavaUtilList = paramList;
    localpve.jdField_h_of_type_Int = paramInt2;
    localpve.jdField_d_of_type_Boolean = true;
    localpve.jdField_e_of_type_Boolean = true;
    localpve.jdField_f_of_type_Boolean = paramBoolean1;
    localpve.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Pew.a(Integer.valueOf(paramInt1));
    localpve.jdField_g_of_type_Boolean = paramBoolean2;
    localObject = this.jdField_a_of_type_Pew;
    localpve.jdField_b_of_type_ArrayOfByte = pew.a();
    localpve.jdField_c_of_type_Int = paramInt3;
    localpve.jdField_a_of_type_JavaLangString = paramString1;
    localpve.jdField_c_of_type_Long = paramLong1;
    localpve.jdField_b_of_type_JavaLangString = paramString2;
    localpve.jdField_d_of_type_Int = paramInt4;
    localpve.jdField_d_of_type_Long = paramLong2;
    localpve.jdField_e_of_type_Long = paramLong3;
    localpve.jdField_c_of_type_JavaLangString = paramString3;
    localpve.jdField_i_of_type_Boolean = paramBoolean3;
    localpve.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localpve.jdField_i_of_type_Int |= paramInt6;
    localpve.jdField_d_of_type_JavaUtilList = paramList2;
    localpve.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (oee.a(paramInt1)) {
      localpve.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localpve.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
    for (localpve.jdField_b_of_type_Long = -1L;; localpve.jdField_b_of_type_Long = (l + 1L))
    {
      localpve.jdField_f_of_type_Int |= 0x10;
      localpve.jdField_f_of_type_Int |= 0x20;
      localpve.jdField_f_of_type_Int |= 0x100;
      localpve.jdField_f_of_type_Int |= 0x40;
      localpve.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localpve.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localpve.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localpve.j = 2;
      }
      if (otf.c(paramInt1)) {
        localpve.j = 3;
      }
      if (paramList1 != null) {
        localpve.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localpve.jdField_i_of_type_Int & 0x100) != 0)
      {
        localpve.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localpve.j), ", beginRecommendSeq = ", Long.valueOf(localpve.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localpve.jdField_b_of_type_Long) });
      }
      if (!bkbq.i()) {
        localpve.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localpve.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localpve.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localpve.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localpve.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localpve.jdField_a_of_type_Pxh = pxe.a().a();
        pxe.a().a();
      }
      this.jdField_a_of_type_Pew.a(localpve);
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
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + ors.c(paramString2) + " recommendFlag is : " + localpve.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pes.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Owx != null) {
      this.jdField_a_of_type_Owx.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Pfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfb.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, String paramString)
  {
    if (this.jdField_a_of_type_Pew == null)
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
        localJSONObject.put("biuUin", ors.a());
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
  
  public void a(long paramLong1, long paramLong2, qmc paramqmc, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, paramqmc, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, qmc paramqmc, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Pew == null) || (paramqmc == null))
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
        this.jdField_a_of_type_Pew.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Pew.a(paramLong1, paramLong2, paramqmc, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, qmc paramqmc, String paramString)
  {
    this.jdField_a_of_type_Pew.a(paramLong1, paramLong2, paramqmc, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
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
    this.jdField_a_of_type_Pew.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<qkq> paramList)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramLong, paramList);
  }
  
  public void a(long paramLong, qkq paramqkq)
  {
    if (paramqkq == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramqkq);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Pgv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pgv.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pes.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "resetBiuBreathAnimationFlag | mArticleInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pew.a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_Pew == null)
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
    this.jdField_a_of_type_Pew.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Pfi != null) {
      this.jdField_a_of_type_Pfi.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pfg.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_Pew != null)
    {
      this.jdField_a_of_type_Pew.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = ors.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    awgf localawgf = a().createEntityManager();
    this.jdField_a_of_type_Puz = puz.a();
    this.jdField_a_of_type_Pew = new pew(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Phg = new phg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfb = new pfb(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pge = new pge(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Phd = new phd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfi = new pfi(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pes = new pes(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfg = new pfg(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pgy = new pgy(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfv = new pfv(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_Pgf = new pgf(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfo = new pfo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    this.jdField_a_of_type_Pgv = new pgv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfw = new pfw(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pfd = new pfd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Pew);
    this.jdField_a_of_type_Phk = new phk(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pgo = new pgo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pga = new pga(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oof = new oof(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ovz = new ovz(localawgf, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Owd = new owd(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pis = new pis(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Pfn = new pfn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pgk = new pgk(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Oim = new oim(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pgh = new pgh(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localawgf, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Puz, this.jdField_a_of_type_AndroidOsHandler);
    ohe.a.a();
    ohf.a = null;
    otf.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    sfq.a();
    sgf.b();
    this.jdField_a_of_type_Owx = new owx(paramAppInterface, this.jdField_a_of_type_Pfw);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pes.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true);
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_Pfv != null) {
      this.jdField_a_of_type_Pfv.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phd.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((ors.a != null) && (ors.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_Pew.a("" + ors.a.mFeedId, ors.a.mFeedType, -1, true);
        ors.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + ors.a);
      return;
    }
    this.jdField_a_of_type_Pew.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, qlz paramqlz)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramqlz, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phd.a(paramString, paramContext);
    nrt.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Pgf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pgf.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Pew != null)
    {
      this.jdField_a_of_type_Pew.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Phg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phg.a(paramList);
  }
  
  public void a(List<qkm> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pfg.a(paramList, paramBoolean);
    this.jdField_a_of_type_Pfg.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Phg == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Phg.a(paramList, paramString);
  }
  
  public void a(List<qkm> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Pfg.a(paramList, paramBoolean);
  }
  
  public void a(ohu paramohu)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds | mArticleInfoModule is null!");
      return;
    }
    if (paramohu == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "transformNewBiuCardInRecommendFeeds |  biuInfo is null!");
      return;
    }
    this.jdField_a_of_type_Pew.a(paramohu);
  }
  
  public void a(qnm paramqnm)
  {
    if (this.jdField_a_of_type_Pfv != null) {
      this.jdField_a_of_type_Pfv.a(paramqnm);
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
      jdField_a_of_type_Owy = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Awgg = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_Puz != null)
      {
        this.jdField_a_of_type_Puz.a();
        this.jdField_a_of_type_Puz = null;
      }
      if (this.jdField_a_of_type_Pew != null)
      {
        this.jdField_a_of_type_Pew.a();
        this.jdField_a_of_type_Pew = null;
      }
      if (this.jdField_a_of_type_Phg != null)
      {
        this.jdField_a_of_type_Phg.a();
        this.jdField_a_of_type_Phg = null;
      }
      if (this.jdField_a_of_type_Pfb != null)
      {
        this.jdField_a_of_type_Pfb.b();
        this.jdField_a_of_type_Pfb = null;
      }
      if (this.jdField_a_of_type_Pge != null)
      {
        this.jdField_a_of_type_Pge.a();
        this.jdField_a_of_type_Pge = null;
      }
      if (this.jdField_a_of_type_Phd != null)
      {
        this.jdField_a_of_type_Phd.a();
        this.jdField_a_of_type_Phd = null;
      }
      if (this.jdField_a_of_type_Pfi != null)
      {
        this.jdField_a_of_type_Pfi.a();
        this.jdField_a_of_type_Pfi = null;
      }
      if (this.jdField_a_of_type_Pes != null)
      {
        this.jdField_a_of_type_Pes.a();
        this.jdField_a_of_type_Pes = null;
      }
      if (this.jdField_a_of_type_Pfg != null)
      {
        this.jdField_a_of_type_Pfg.a();
        this.jdField_a_of_type_Pfg = null;
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
      if (this.jdField_a_of_type_Pgv != null)
      {
        this.jdField_a_of_type_Pgv.a();
        this.jdField_a_of_type_Pgv = null;
      }
      if (this.jdField_a_of_type_Pfd != null)
      {
        this.jdField_a_of_type_Pfd.a();
        this.jdField_a_of_type_Pfd = null;
      }
      if (this.jdField_a_of_type_Pga != null) {
        this.jdField_a_of_type_Pga.a();
      }
      if (this.jdField_a_of_type_Ovz != null)
      {
        this.jdField_a_of_type_Ovz.a();
        this.jdField_a_of_type_Ovz = null;
      }
      if (this.jdField_a_of_type_Owd != null)
      {
        this.jdField_a_of_type_Owd.a();
        this.jdField_a_of_type_Owd = null;
      }
      if (this.jdField_a_of_type_Pis != null)
      {
        this.jdField_a_of_type_Pis.a();
        this.jdField_a_of_type_Pis = null;
      }
      if (this.jdField_a_of_type_Pfn != null)
      {
        this.jdField_a_of_type_Pfn.b();
        this.jdField_a_of_type_Pfn = null;
      }
      if (this.jdField_a_of_type_Owx != null)
      {
        this.jdField_a_of_type_Owx.c();
        this.jdField_a_of_type_Owx = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
      }
      if (this.jdField_a_of_type_Oim != null)
      {
        this.jdField_a_of_type_Oim.a();
        this.jdField_a_of_type_Oim = null;
      }
      if (this.jdField_a_of_type_Pgh != null)
      {
        this.jdField_a_of_type_Pgh.a();
        this.jdField_a_of_type_Pgh = null;
      }
      ohe.a.a();
      ohf.a = null;
      piu.a().b();
      otf.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pfi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfi.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    s();
    if (this.jdField_a_of_type_Pew == null)
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
      l1 = this.jdField_a_of_type_Pew.a(Integer.valueOf(70));
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
        this.jdField_a_of_type_Pew.a(l2, l1, this.jdField_f_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_Pew.b(Integer.valueOf(70));
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
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Pes.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pew == null) {
      return false;
    }
    return this.jdField_a_of_type_Pew.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_Pew.b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_Pew.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Pfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Pfb.a(paramLong);
  }
  
  public boolean a(Context paramContext)
  {
    if (this.jdField_d_of_type_Int == -1) {
      a(paramContext);
    }
    return this.jdField_d_of_type_Int > 0;
  }
  
  public boolean a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "isArticleFromRecommendFeeds | mArticleInfoModule is null!");
      return false;
    }
    return this.jdField_a_of_type_Pew.a(paramArticleInfo);
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pew != null) {
      return this.jdField_a_of_type_Pew.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Pew.b(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Owx != null) && (TextUtils.isDigitsOnly(paramString))) {
      return this.jdField_a_of_type_Owx.a(Long.valueOf(paramString));
    }
    return false;
  }
  
  public boolean a(qks paramqks, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_Pew.a(paramqks, paramArticleInfo);
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Pfi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Pfi.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Pes == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pes.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_Pew.c(Integer.valueOf(paramInt));
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
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pfg.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Pfg.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Pew != null) {
      return this.jdField_a_of_type_Pew.c(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pfb == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfb.a();
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
        qkm localqkm1 = (qkm)localList.get(i);
        qkm localqkm2 = new qkm(localqkm1.jdField_a_of_type_Long, localqkm1.jdField_a_of_type_JavaLangString, localqkm1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localqkm1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localqkm1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localqkm2.jdField_a_of_type_JavaUtilList.add(localqkm1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localqkm2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (pfg.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Pfi == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfi.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_Pew != null) {
      this.jdField_a_of_type_Pew.a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Pgy != null) {
      this.jdField_a_of_type_Pgy.a(paramInt, paramString, null);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Pew != null)
    {
      this.jdField_a_of_type_Pew.a(paramLong);
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
          this.jdField_a_of_type_Pew.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_Pew.a(localArticleInfo, (int)localArticleInfo.mChannelID);
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
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.b(paramArticleInfo);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phd.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public boolean b(Long paramLong)
  {
    if (this.jdField_a_of_type_Owx != null) {
      return this.jdField_a_of_type_Owx.a(paramLong);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Pfv != null) {
      return this.jdField_a_of_type_Pfv.a();
    }
    return 0;
  }
  
  public List<qkw> c()
  {
    if (this.jdField_a_of_type_Pfw == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Pfw.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.f();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfg.c(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phd.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfg.a(paramBoolean);
  }
  
  public int d()
  {
    String str = ors.a();
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
    if (this.jdField_a_of_type_Pge == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pge.b();
    this.jdField_a_of_type_Pge.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Pew.a(paramInt1, paramInt2);
  }
  
  public void d(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Pew.b(paramArticleInfo);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pfv != null) {
      this.jdField_a_of_type_Pfv.a(paramBoolean);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phd.f();
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
    if (this.jdField_a_of_type_Pgy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfInfo mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pgy.a(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Owx != null) {
      this.jdField_a_of_type_Owx.c(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_Pfv != null) {
      this.jdField_a_of_type_Pfv.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Pfv != null) {
      this.jdField_a_of_type_Pfv.a(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Phd == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Phd.g();
  }
  
  public void g(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Pew != null)
    {
      this.jdField_a_of_type_Pew.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Pew == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Pew.d();
      if (this.jdField_a_of_type_Phd != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Phd.d();
  }
  
  public void h(int paramInt)
  {
    String str = ors.a();
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
    if (this.jdField_a_of_type_Pew != null)
    {
      this.jdField_a_of_type_Pew.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Phd != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Pes != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_Pew.e();
      break;
      label80:
      this.jdField_a_of_type_Phd.e();
    }
    label90:
    this.jdField_a_of_type_Pes.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_Pew != null) {
      this.jdField_a_of_type_Pew.d(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Pfi != null) {
      this.jdField_a_of_type_Pfi.a(paramString);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Pew == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Pew.b();
      if (this.jdField_a_of_type_Phd != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Phd.b();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_Pfn != null) {
      this.jdField_a_of_type_Pfn.a(paramString);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Pew == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Pew.c();
      if (this.jdField_a_of_type_Phd != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Phd.c();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfg.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Pfg == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pfg.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Pew == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pew.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Pfv != null) {
      this.jdField_a_of_type_Pfv.a();
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_Pfw != null) && (this.jdField_a_of_type_Pfw.a())) {
      this.jdField_a_of_type_Pfw.a(300, 2);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_Pgy != null) {
      this.jdField_a_of_type_Pgy.a();
    }
  }
  
  public void s()
  {
    if (this.jdField_a_of_type_Pfi != null) {
      this.jdField_a_of_type_Pfi.d();
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
    if (this.jdField_a_of_type_Pfn != null)
    {
      this.jdField_a_of_type_Pfn.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     owy
 * JD-Core Version:    0.7.0.1
 */