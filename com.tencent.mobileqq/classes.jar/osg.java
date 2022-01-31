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

public class osg
{
  private static long jdField_a_of_type_Long;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private static osg jdField_a_of_type_Osg;
  private final int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private aukq jdField_a_of_type_Aukq;
  private ReadInJoyUserInfoModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule;
  private SelectPositionModule jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString = "";
  private ConcurrentHashMap<String, Parcelable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private ojr jdField_a_of_type_Ojr;
  private orh jdField_a_of_type_Orh;
  private orl jdField_a_of_type_Orl;
  private osf jdField_a_of_type_Osf;
  private ozk jdField_a_of_type_Ozk;
  private ozo jdField_a_of_type_Ozo;
  private ozt jdField_a_of_type_Ozt;
  private ozv jdField_a_of_type_Ozv;
  private ozy jdField_a_of_type_Ozy;
  private paa jdField_a_of_type_Paa;
  private pae jdField_a_of_type_Pae;
  private paf jdField_a_of_type_Paf;
  private pam jdField_a_of_type_Pam;
  private pan jdField_a_of_type_Pan;
  private par jdField_a_of_type_Par;
  private pav jdField_a_of_type_Pav;
  private paw jdField_a_of_type_Paw;
  private paz jdField_a_of_type_Paz;
  private pbd jdField_a_of_type_Pbd;
  private pbk jdField_a_of_type_Pbk;
  private pbn jdField_a_of_type_Pbn;
  private pbr jdField_a_of_type_Pbr;
  private pbu jdField_a_of_type_Pbu;
  private pby jdField_a_of_type_Pby;
  private pcq jdField_a_of_type_Pcq;
  private por jdField_a_of_type_Por;
  private boolean jdField_a_of_type_Boolean;
  private final int jdField_b_of_type_Int = 1;
  private ConcurrentHashMap<String, Integer> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private final int c;
  private int d;
  private int e;
  private int f;
  
  private osg()
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = -1;
  }
  
  public static osg a()
  {
    try
    {
      if (jdField_a_of_type_Osg == null)
      {
        jdField_a_of_type_Osg = new osg();
        jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
      }
      osg localosg = jdField_a_of_type_Osg;
      return localosg;
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
    localReportInfo.mUin = onh.a();
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
        qbz localqbz = new qbz();
        localqbz.jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
        if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci != null) {
          localqbz.jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
        }
        localqbz.jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
        localqbz.jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_d_of_type_Int;
        localReportInfo.mFeedsReportData = localqbz;
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
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Pbr.a();
  }
  
  public int a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRefreshedArticleInfoSize mArticleInfoModule is null!");
      }
      return 0;
    }
    return this.jdField_a_of_type_Ozo.a(paramInteger);
  }
  
  public Parcelable a(int paramInt)
  {
    String str = onh.a() + "_" + paramInt;
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
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozk.a(paramInt);
  }
  
  public Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getPreloadAdvertisementAtPostion mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozk.a(paramInt1, paramInt2);
  }
  
  public aukq a()
  {
    Object localObject1 = onh.a();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if ((this.jdField_a_of_type_Aukq == null) || (!TextUtils.equals(((ReadInJoyEntityManagerFactory)this.jdField_a_of_type_Aukq).name, (CharSequence)localObject1)))
      {
        localObject1 = new ReadInJoyEntityManagerFactory((String)localObject1);
        ThreadManager.post(new ReadInJoyLogicEngine.1(this, (ReadInJoyEntityManagerFactory)localObject1), 8, null, false);
        this.jdField_a_of_type_Aukq = ((aukq)localObject1);
      }
      return this.jdField_a_of_type_Aukq;
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
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozk.a(paramInt1, paramInt2);
  }
  
  public ArticleInfo a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    if (ozg.a(paramLong)) {
      return ozg.a().a(paramInt, paramLong);
    }
    return this.jdField_a_of_type_Ozo.a(Integer.valueOf(paramInt), Long.valueOf(paramLong));
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getLastReadArticleInfo mArticleInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozo.a(paramInteger);
  }
  
  public ChannelInfo a(int paramInt)
  {
    if (this.jdField_a_of_type_Paa != null) {
      return this.jdField_a_of_type_Paa.a(Integer.valueOf(paramInt));
    }
    return null;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Pam != null) {
      return this.jdField_a_of_type_Pam.a();
    }
    return "";
  }
  
  public HashMap<Long, Long> a()
  {
    if (this.jdField_a_of_type_Pam != null) {
      return this.jdField_a_of_type_Pam.a();
    }
    return null;
  }
  
  public List<qaq> a()
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverSectionList mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozy.d();
  }
  
  public List<ChannelCoverInfo> a(int paramInt)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozy.b(paramInt);
  }
  
  public List<Long> a(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ozo != null) {
      return this.jdField_a_of_type_Ozo.b(paramInteger);
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
    return pax.a(localArrayList);
  }
  
  public ojr a()
  {
    return this.jdField_a_of_type_Ojr;
  }
  
  public JSONObject a()
  {
    if (this.jdField_a_of_type_Pae != null) {
      return this.jdField_a_of_type_Pae.a();
    }
    return null;
  }
  
  public orh a()
  {
    return this.jdField_a_of_type_Orh;
  }
  
  public orl a()
  {
    return this.jdField_a_of_type_Orl;
  }
  
  public ozk a()
  {
    return this.jdField_a_of_type_Ozk;
  }
  
  public ozo a()
  {
    return this.jdField_a_of_type_Ozo;
  }
  
  public ozv a()
  {
    return this.jdField_a_of_type_Ozv;
  }
  
  public paf a()
  {
    return this.jdField_a_of_type_Paf;
  }
  
  public par a()
  {
    return this.jdField_a_of_type_Par;
  }
  
  public paz a()
  {
    return this.jdField_a_of_type_Paz;
  }
  
  public pbd a()
  {
    return this.jdField_a_of_type_Pbd;
  }
  
  public pbu a()
  {
    return this.jdField_a_of_type_Pbu;
  }
  
  public pcq a()
  {
    return this.jdField_a_of_type_Pcq;
  }
  
  public oidb_cmd0x68b.ReqAdvertisePara a(pow parampow, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "makeReqAdvertisePara mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozk.a(parampow, paramInt1, paramInt2, paramInt3, paramInt4, null);
  }
  
  public void a()
  {
    this.jdField_f_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozy.b(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Paa == null)
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
      this.jdField_a_of_type_Paa.b(true);
      return;
    }
    this.jdField_a_of_type_Paa.e();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setLocalAdvertisementRange mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozk.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, nkz paramnkz)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelAdvertisementFormServer mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozk.a(paramInt1, paramInt2, paramInt3, paramInt4, paramnkz);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestVideoRealTimeReplaceList mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject2 = this.jdField_a_of_type_Ozo.b(Integer.valueOf(paramInt1));
    Object localObject1 = new pow();
    ((pow)localObject1).jdField_b_of_type_Int = paramInt1;
    ((pow)localObject1).jdField_a_of_type_Long = -1L;
    ((pow)localObject1).jdField_b_of_type_Boolean = true;
    ((pow)localObject1).jdField_a_of_type_JavaUtilList = ((List)localObject2);
    ((pow)localObject1).jdField_c_of_type_Boolean = false;
    localObject2 = new ArrayList();
    ((List)localObject2).add(Long.valueOf(paramLong1));
    ((pow)localObject1).jdField_b_of_type_JavaUtilList = ((List)localObject2);
    ((pow)localObject1).jdField_h_of_type_Int = 7;
    Object localObject3 = new JSONObject();
    try
    {
      ((JSONObject)localObject3).put("next_video_algorithm_id", paramLong2);
      ((pow)localObject1).jdField_c_of_type_JavaLangString = ((JSONObject)localObject3).toString();
      ((pow)localObject1).jdField_d_of_type_Boolean = true;
      ((pow)localObject1).jdField_e_of_type_Boolean = true;
      ((pow)localObject1).jdField_f_of_type_Boolean = true;
      ((pow)localObject1).jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Ozo.a(Integer.valueOf(paramInt1));
      ((pow)localObject1).jdField_g_of_type_Boolean = false;
      localObject3 = this.jdField_a_of_type_Ozo;
      ((pow)localObject1).jdField_b_of_type_ArrayOfByte = ozo.a();
      ((pow)localObject1).jdField_c_of_type_Int = 0;
      ((pow)localObject1).jdField_a_of_type_JavaLangString = null;
      ((pow)localObject1).jdField_c_of_type_Long = -1L;
      ((pow)localObject1).jdField_b_of_type_JavaLangString = null;
      ((pow)localObject1).jdField_d_of_type_Int = paramInt2;
      ((pow)localObject1).jdField_d_of_type_Long = 0L;
      ((pow)localObject1).jdField_e_of_type_Long = 0L;
      ((pow)localObject1).jdField_i_of_type_Boolean = false;
      ((pow)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = null;
      ((pow)localObject1).jdField_g_of_type_Int = 3;
      ((pow)localObject1).jdField_b_of_type_Long = -1L;
      ((pow)localObject1).jdField_f_of_type_Int |= 0x10;
      ((pow)localObject1).jdField_f_of_type_Int |= 0x2000;
      if ((paramInt1 == 40677) || (paramInt2 == 7)) {
        ((pow)localObject1).j = 2;
      }
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        localObject3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (localObject3 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "requestVideoRealTimeReplaceList positionData = " + localObject3);
          }
          ((pow)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          ((pow)localObject1).jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy((SelectPositionModule.PositionData)localObject3);
        }
      }
      this.jdField_a_of_type_Ozo.a((pow)localObject1);
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
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelArticleFromDB mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramInt1, paramInt2, paramLong, paramBoolean);
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if (this.jdField_a_of_type_Ozo != null) {
      this.jdField_a_of_type_Ozo.a(paramInt1, paramInt2, paramLong1, paramBoolean, paramLong2);
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "moveChannelToFront() called with: channelCoverId = [" + paramInt1 + "], source = [" + paramInt2 + "], addAtEnd = [" + paramBoolean1 + "]");
    if (this.jdField_a_of_type_Ozy == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "moveChannelToFront mChannelCoverInfoModule is null!");
      }
    }
    List localList;
    Object localObject;
    qaq localqaq;
    int i;
    do
    {
      do
      {
        return;
        localList = this.jdField_a_of_type_Ozy.d();
      } while ((localList == null) || (localList.size() <= 0));
      localObject = localList.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localqaq = (qaq)((Iterator)localObject).next();
        i = qeb.a(localqaq.jdField_a_of_type_JavaUtilList, new osh(this, paramInt1));
      } while (i < 0);
      localObject = (TabChannelCoverInfo)localqaq.jdField_a_of_type_JavaUtilList.get(i);
    } while (((TabChannelCoverInfo)localObject).reason == 4);
    localqaq.jdField_a_of_type_JavaUtilList.remove(i);
    if (localqaq == localList.get(0)) {
      paramInt1 = i;
    }
    for (;;)
    {
      localqaq = (qaq)localList.get(0);
      i = qeb.a(localqaq.jdField_a_of_type_JavaUtilList, new osi(this));
      if (QLog.isColorLevel()) {
        ozy.a(localqaq.jdField_a_of_type_JavaUtilList, " firstUnLockPosition : " + i);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && (localqaq.jdField_a_of_type_JavaUtilList != null))
      {
        oop.a(onh.a(), ((TabChannelCoverInfo)localObject).mChannelCoverId);
        if ((i < 0) || (paramBoolean1)) {
          break label404;
        }
        localqaq.jdField_a_of_type_JavaUtilList.add(i, localObject);
      }
      for (;;)
      {
        nol.a(null, "", "0X8009A59", "0X8009A59", 0, 0, "", "", "", onh.a().b("uin", localQQAppInterface.getCurrentAccountUin()).a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("source", paramInt2).b("fromposition", paramInt1).a(), false);
        a(localList, 2, paramBoolean2);
        return;
        label404:
        localqaq.jdField_a_of_type_JavaUtilList.add(localObject);
      }
      paramInt1 = -1;
      continue;
      paramInt1 = -1;
      localObject = null;
    }
  }
  
  public void a(int paramInt, Parcelable paramParcelable)
  {
    if (oou.c(paramInt)) {
      return;
    }
    String str = onh.a() + "_" + paramInt;
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
    this.jdField_a_of_type_Ozo.a(true, paramInt, Arrays.asList(new Long[] { Long.valueOf(paramArticleInfo1.mArticleID) }), Arrays.asList(new ArticleInfo[] { paramArticleInfo2 }), false);
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramInt, paramBaseArticleInfo, Boolean.valueOf(true));
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ozo != null)
    {
      if (onh.j(paramBaseArticleInfo))
      {
        Iterator localIterator = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (localIterator.hasNext())
        {
          BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)localIterator.next();
          this.jdField_a_of_type_Ozo.a(paramInt, localBaseArticleInfo.mRecommendSeq);
        }
      }
      this.jdField_a_of_type_Ozo.a(paramInt, paramBaseArticleInfo.mRecommendSeq);
    }
    while ((this.jdField_a_of_type_Ozt != null) && (paramBoolean.booleanValue())) {
      if (onh.j(paramBaseArticleInfo))
      {
        paramBaseArticleInfo = paramBaseArticleInfo.mGroupSubArticleList.iterator();
        while (paramBaseArticleInfo.hasNext())
        {
          paramBoolean = (BaseArticleInfo)paramBaseArticleInfo.next();
          this.jdField_a_of_type_Ozt.a(paramBoolean.mArticleID);
        }
        QLog.d("ArticleInfoModule", 2, "ReadinjoyLogicEngine articleInfoModule is null !");
      }
      else
      {
        this.jdField_a_of_type_Ozt.a(paramBaseArticleInfo.mArticleID);
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
        qaq localqaq = (qaq)localList.get(i);
        int j = 0;
        while (j < localqaq.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt == ((TabChannelCoverInfo)localqaq.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            ((TabChannelCoverInfo)localqaq.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverName = paramString;
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
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateMainChannelCoverInfo mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozy.a(paramInt, paramString, paramLong);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<orw> paramList1)
  {
    a(paramInt1, paramList, paramInt2, paramBoolean1, paramBoolean2, paramInt3, paramString1, paramLong1, paramString2, paramInt4, paramLong2, paramLong3, paramString3, paramInt5, paramBoolean3, paramLebaKDCellInfo, paramInt6, paramList1, null, null);
  }
  
  public void a(int paramInt1, List<Long> paramList, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, String paramString1, long paramLong1, String paramString2, int paramInt4, long paramLong2, long paramLong3, String paramString3, int paramInt5, boolean paramBoolean3, LebaKDCellInfo paramLebaKDCellInfo, int paramInt6, List<orw> paramList1, List<pov> paramList2, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshChannelArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_Ozo.b(Integer.valueOf(paramInt1));
    long l = this.jdField_a_of_type_Ozo.a(Integer.valueOf(paramInt1));
    pow localpow = new pow();
    localpow.jdField_b_of_type_Int = paramInt1;
    localpow.jdField_a_of_type_Long = -1L;
    localpow.jdField_b_of_type_Boolean = true;
    localpow.jdField_a_of_type_JavaUtilList = ((List)localObject);
    localpow.jdField_c_of_type_Boolean = false;
    localpow.jdField_b_of_type_JavaUtilList = paramList;
    localpow.jdField_h_of_type_Int = paramInt2;
    localpow.jdField_d_of_type_Boolean = true;
    localpow.jdField_e_of_type_Boolean = true;
    localpow.jdField_f_of_type_Boolean = paramBoolean1;
    localpow.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Ozo.a(Integer.valueOf(paramInt1));
    localpow.jdField_g_of_type_Boolean = paramBoolean2;
    localObject = this.jdField_a_of_type_Ozo;
    localpow.jdField_b_of_type_ArrayOfByte = ozo.a();
    localpow.jdField_c_of_type_Int = paramInt3;
    localpow.jdField_a_of_type_JavaLangString = paramString1;
    localpow.jdField_c_of_type_Long = paramLong1;
    localpow.jdField_b_of_type_JavaLangString = paramString2;
    localpow.jdField_d_of_type_Int = paramInt4;
    localpow.jdField_d_of_type_Long = paramLong2;
    localpow.jdField_e_of_type_Long = paramLong3;
    localpow.jdField_c_of_type_JavaLangString = paramString3;
    localpow.jdField_i_of_type_Boolean = paramBoolean3;
    localpow.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructLebaKDCellInfo = paramLebaKDCellInfo;
    localpow.jdField_i_of_type_Int |= paramInt6;
    localpow.jdField_d_of_type_JavaUtilList = paramList2;
    localpow.jdField_a_of_type_AndroidOsBundle = paramBundle;
    if (oar.a(paramInt1)) {
      localpow.jdField_h_of_type_Boolean = true;
    }
    paramInt2 = paramInt5;
    if (paramInt5 == 1001) {
      paramInt2 = 3;
    }
    localpow.jdField_g_of_type_Int = paramInt2;
    if (l == -1L) {}
    for (localpow.jdField_b_of_type_Long = -1L;; localpow.jdField_b_of_type_Long = (l + 1L))
    {
      localpow.jdField_f_of_type_Int |= 0x10;
      localpow.jdField_f_of_type_Int |= 0x20;
      localpow.jdField_f_of_type_Int |= 0x100;
      localpow.jdField_f_of_type_Int |= 0x40;
      localpow.jdField_f_of_type_Int |= 0x400;
      if (paramInt1 == 56) {
        localpow.jdField_f_of_type_Int |= 0x1080;
      }
      if (paramInt1 == 0) {
        localpow.jdField_f_of_type_Int |= 0x800;
      }
      if ((paramInt1 == 40677) || (paramInt4 == 7)) {
        localpow.j = 2;
      }
      if (oou.c(paramInt1)) {
        localpow.j = 3;
      }
      if (paramList1 != null) {
        localpow.jdField_c_of_type_JavaUtilList.addAll(paramList1);
      }
      if ((localpow.jdField_i_of_type_Int & 0x100) != 0)
      {
        localpow.j = 4;
        QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "feedsPreload, params service type = ", Integer.valueOf(localpow.j), ", beginRecommendSeq = ", Long.valueOf(localpow.jdField_a_of_type_Long), ", endRecommendSeq = ", Long.valueOf(localpow.jdField_b_of_type_Long) });
      }
      if (!bhvy.i()) {
        localpow.jdField_i_of_type_Int |= 0x200;
      }
      QLog.d("ReadInJoyLogicEngine", 1, new Object[] { "68b params recommendFlag = ", Integer.valueOf(localpow.jdField_i_of_type_Int) });
      if ((paramInt1 == 41695) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null))
      {
        paramLebaKDCellInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.a();
        if (paramLebaKDCellInfo != null)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ReadInJoyLogicEngine", 2, "refreshChannelArticlesFormServer positionData = " + paramLebaKDCellInfo);
          }
          localpow.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData = new SelectPositionModule.PositionData();
          localpow.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule$PositionData.copy(paramLebaKDCellInfo);
        }
      }
      if ((localpow.jdField_i_of_type_Int & 0x1000) != 0)
      {
        localpow.jdField_a_of_type_Pqm = pqj.a().a();
        pqj.a().a();
      }
      this.jdField_a_of_type_Ozo.a(localpow);
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
    QLog.i("ArticleInfoModule", 1, "refreshChannelArticlesFormServer kandianArticleID : " + paramLebaKDCellInfo.toString() + " innerUniqId is : " + paramString1 + " subscribeArticleID is : " + paramLong1 + " subscribeArticleTitle : " + onh.c(paramString2) + " recommendFlag is : " + localpow.jdField_i_of_type_Int + " pushContext：" + paramString3 + " channelID : " + paramInt1);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "setChannelNeedRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozk.a(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestIndividualArticlesFormServer mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramLong, 1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_a_of_type_Osf != null) {
      this.jdField_a_of_type_Osf.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, ArticleInfo paramArticleInfo)
  {
    qcg localqcg = new qcg();
    long l = 0L;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg != null)
      {
        localqcg.a = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.a;
        localqcg.b = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qcg.b;
      }
      l = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Qci.jdField_a_of_type_Long;
    }
    a(paramLong, 0L, localqcg, l, "", paramArticleInfo.mArticleID, paramArticleInfo.mRecommendSeq, paramInt2, paramArticleInfo.innerUniqueID, paramInt1, paramArticleInfo, true);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Ozt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleReadInfo mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozt.a(paramLong1, paramLong2);
  }
  
  public void a(long paramLong1, long paramLong2, qcg paramqcg, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo)
  {
    a(paramLong1, paramLong2, paramqcg, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, false);
  }
  
  public void a(long paramLong1, long paramLong2, qcg paramqcg, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Ozo == null) || (paramqcg == null))
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
        this.jdField_a_of_type_Ozo.a(paramLong1, paramString2, paramInt1, paramString1, null, paramBoolean);
        return;
      }
      this.jdField_a_of_type_Ozo.a(paramLong1, paramLong2, paramqcg, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
      return;
    }
  }
  
  public void a(long paramLong1, long paramLong2, qcg paramqcg, String paramString)
  {
    this.jdField_a_of_type_Ozo.a(paramLong1, paramLong2, paramqcg, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteAction mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
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
    this.jdField_a_of_type_Ozo.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<qat> paramList)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramLong, paramList);
  }
  
  public void a(long paramLong, qat paramqat)
  {
    if (paramqat == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "sendShieldArticle mArticleInfoModule is null!");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramqat);
    a(paramLong, localArrayList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpvoteFastWebArticle mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Pbk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "changeRecommendFollow mRecommendFollowForChangeModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbk.a(paramLong, paramArrayOfByte);
  }
  
  public void a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, long paramLong, ArrayList<DislikeInfo> paramArrayList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "doUninterestAdvertisement mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozk.a(paramContext, paramAdvertisementInfo, paramLong, paramArrayList, paramBoolean);
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "updateArticleInfo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    if (this.jdField_a_of_type_Ozo == null)
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
    this.jdField_a_of_type_Ozo.a(paramArticleInfo, paramString);
  }
  
  public void a(ChannelInfo paramChannelInfo)
  {
    if (this.jdField_a_of_type_Paa != null) {
      this.jdField_a_of_type_Paa.a(paramChannelInfo);
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      QLog.d("Q.readinjoy.info_module", 2, "updateChannel mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Ozy.a(paramTabChannelCoverInfo);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    if (this.jdField_a_of_type_Ozo != null)
    {
      this.jdField_a_of_type_Ozo.a(paramTopicInfo);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when create ugc topic: " + paramTopicInfo);
  }
  
  protected void a(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicEngine", 1, "[initialize]: ");
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.addAndGet(1);
    String str = onh.a();
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaLangString.equals(str)) && (paramAppInterface == this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = MonitorTimeExecutor.a();
    aukp localaukp = a().createEntityManager();
    this.jdField_a_of_type_Por = por.a();
    this.jdField_a_of_type_Ozo = new ozo(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pbu = new pbu(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ozt = new ozt(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pav = new pav(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pbr = new pbr(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Paa = new paa(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ozk = new ozk(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ozy = new ozy(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pbn = new pbn(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pam = new pam(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_Paw = new paw(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Paf = new paf(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule = new ReadInJoyUserInfoModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyUserInfoModule.a().a(500);
    this.jdField_a_of_type_Pbk = new pbk(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pan = new pan(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ozv = new ozv(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_Ozo);
    this.jdField_a_of_type_Pby = new pby(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pbd = new pbd(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Par = new par(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Ojr = new ojr(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Orh = new orh(localaukp, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Orl = new orl(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Pcq = new pcq(this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Pae = new pae(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = new SelectPositionModule(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_Paz = new paz(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localaukp, this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_Por, this.jdField_a_of_type_AndroidOsHandler);
    odj.a.a();
    odk.a = null;
    oou.a();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    rpr.a();
    rqg.b();
    this.jdField_a_of_type_Osf = new osf(paramAppInterface, this.jdField_a_of_type_Pan);
    QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine init finish ! account : " + str);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, oidb_cmd0x68b.RspChannelArticle paramRspChannelArticle)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "handleAdvertisementResp mAdvertisementInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozk.a(paramToServiceMsg, paramRspChannelArticle, 0, 0, true);
  }
  
  public void a(Long paramLong)
  {
    if (this.jdField_a_of_type_Pam != null) {
      this.jdField_a_of_type_Pam.a(paramLong);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "stickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbr.a(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestUpdateSocialFeedInfo mArticleInfoModule is null!");
      }
      return;
    }
    if ("-1".equals(paramString))
    {
      if ((onh.a != null) && (onh.a.mFeedId != 0L))
      {
        this.jdField_a_of_type_Ozo.a("" + onh.a.mFeedId, onh.a.mFeedType, -1, true);
        onh.a = null;
        return;
      }
      QLog.w("Q.readinjoy.info_module", 2, " clicked articleInfo  " + onh.a);
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramString, paramInt, -1, true);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, qcd paramqcd)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramString1, null, null, null, paramString2, null, null, null, null, paramArrayList, false, paramInt, 0, paramqcd, 0);
  }
  
  public void a(String paramString, Context paramContext)
  {
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unFollowSubscribeAccount mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbr.a(paramString, paramContext);
    nol.a(null, "CliOper", "", "", "0X8006113", "0X8006113", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Paw == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "get king moment module is null!");
      }
      return;
    }
    this.jdField_a_of_type_Paw.a(paramString1, paramString2);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUpMasterVideo mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, int paramInt2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestDeliverUGC mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, null, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Ozo != null)
    {
      this.jdField_a_of_type_Ozo.a(paramArrayList, 1, paramLong, paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "shareAQinviteFriends, uin = " + paramLong);
  }
  
  public void a(List<ReportInfo> paramList)
  {
    if (this.jdField_a_of_type_Pbu == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "userOperationReport mUserOperationModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbu.a(paramList);
  }
  
  public void a(List<qaq> paramList, int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Ozy.a(paramList, paramBoolean);
    this.jdField_a_of_type_Ozy.a(paramList, paramInt);
  }
  
  public void a(List<ReportInfo> paramList, String paramString)
  {
    if (this.jdField_a_of_type_Pbu == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "mUserOperationModule is null.");
      return;
    }
    this.jdField_a_of_type_Pbu.a(paramList, paramString);
  }
  
  public void a(List<qaq> paramList, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      QLog.d("ReadInJoyLogicEngine", 2, "updateRecommendAndMyChannelListsToServer failed, mChannelCoverInfoModule is null!");
      return;
    }
    this.jdField_a_of_type_Ozy.a(paramList, paramBoolean);
  }
  
  public void a(qdq paramqdq)
  {
    if (this.jdField_a_of_type_Pam != null) {
      this.jdField_a_of_type_Pam.a(paramqdq);
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
      jdField_a_of_type_Osg = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Aukq = null;
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
      if (this.jdField_a_of_type_Por != null)
      {
        this.jdField_a_of_type_Por.a();
        this.jdField_a_of_type_Por = null;
      }
      if (this.jdField_a_of_type_Ozo != null)
      {
        this.jdField_a_of_type_Ozo.a();
        this.jdField_a_of_type_Ozo = null;
      }
      if (this.jdField_a_of_type_Pbu != null)
      {
        this.jdField_a_of_type_Pbu.a();
        this.jdField_a_of_type_Pbu = null;
      }
      if (this.jdField_a_of_type_Ozt != null)
      {
        this.jdField_a_of_type_Ozt.b();
        this.jdField_a_of_type_Ozt = null;
      }
      if (this.jdField_a_of_type_Pav != null)
      {
        this.jdField_a_of_type_Pav.a();
        this.jdField_a_of_type_Pav = null;
      }
      if (this.jdField_a_of_type_Pbr != null)
      {
        this.jdField_a_of_type_Pbr.a();
        this.jdField_a_of_type_Pbr = null;
      }
      if (this.jdField_a_of_type_Paa != null)
      {
        this.jdField_a_of_type_Paa.a();
        this.jdField_a_of_type_Paa = null;
      }
      if (this.jdField_a_of_type_Ozk != null)
      {
        this.jdField_a_of_type_Ozk.a();
        this.jdField_a_of_type_Ozk = null;
      }
      if (this.jdField_a_of_type_Ozy != null)
      {
        this.jdField_a_of_type_Ozy.a();
        this.jdField_a_of_type_Ozy = null;
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
      if (this.jdField_a_of_type_Pbk != null)
      {
        this.jdField_a_of_type_Pbk.a();
        this.jdField_a_of_type_Pbk = null;
      }
      if (this.jdField_a_of_type_Ozv != null)
      {
        this.jdField_a_of_type_Ozv.a();
        this.jdField_a_of_type_Ozv = null;
      }
      if (this.jdField_a_of_type_Par != null) {
        this.jdField_a_of_type_Par.a();
      }
      if (this.jdField_a_of_type_Orh != null)
      {
        this.jdField_a_of_type_Orh.a();
        this.jdField_a_of_type_Orh = null;
      }
      if (this.jdField_a_of_type_Orl != null)
      {
        this.jdField_a_of_type_Orl.a();
        this.jdField_a_of_type_Orl = null;
      }
      if (this.jdField_a_of_type_Pcq != null)
      {
        this.jdField_a_of_type_Pcq.a();
        this.jdField_a_of_type_Pcq = null;
      }
      if (this.jdField_a_of_type_Pae != null)
      {
        this.jdField_a_of_type_Pae.b();
        this.jdField_a_of_type_Pae = null;
      }
      if (this.jdField_a_of_type_Osf != null)
      {
        this.jdField_a_of_type_Osf.c();
        this.jdField_a_of_type_Osf = null;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule.c();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelSelectPositionModule = null;
      }
      odj.a.a();
      odk.a = null;
      pcs.a().b();
      oou.a();
      QLog.d("ReadInJoyLogicEngine", 2, "readinjoy logic engine uninit success!");
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Paa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "followUnfollowChildChannel mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Paa.a(paramBoolean, paramInt1, paramInt2);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    long l2 = 0L;
    r();
    if (this.jdField_a_of_type_Ozo == null)
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
      l1 = this.jdField_a_of_type_Ozo.a(Integer.valueOf(70));
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
        this.jdField_a_of_type_Ozo.a(l2, l1, this.jdField_f_of_type_Int, localHashMap, c(), paramString, a(), (String)localObject);
        return;
        long l3 = this.jdField_a_of_type_Ozo.b(Integer.valueOf(70));
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
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "needRequestAdvertisement mAdvertisementInfoModule is null!");
      }
      return true;
    }
    return this.jdField_a_of_type_Ozk.a(paramInt);
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ozo == null) {
      return false;
    }
    return this.jdField_a_of_type_Ozo.a(paramInt1, paramInt2);
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, mArticleInfoModule = null");
      k(paramInt1);
      return false;
    }
    long l = this.jdField_a_of_type_Ozo.b(Integer.valueOf(paramInt1));
    if (l == -1L)
    {
      QLog.d("ReadInJoyLogicEngine", 1, "loadMoreArticle return false, minRecommendSeq = -1.");
      k(paramInt1);
      return false;
    }
    this.jdField_a_of_type_Ozo.a(paramInt1, 20, l - 1L, true, paramInt2, paramInt3, 0, paramInt4, paramInt5);
    return true;
  }
  
  public boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_Ozt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Ozt.a(paramLong);
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
    if (this.jdField_a_of_type_Ozo != null) {
      return this.jdField_a_of_type_Ozo.a(paramInteger, paramList, paramBoolean);
    }
    return false;
  }
  
  public boolean a(Long paramLong)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "isArticleNeedHighLight mArticleInfoModule is null!");
      }
      return false;
    }
    return this.jdField_a_of_type_Ozo.b(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if ((this.jdField_a_of_type_Osf != null) && (TextUtils.isDigitsOnly(paramString))) {
      return this.jdField_a_of_type_Osf.a(Long.valueOf(paramString));
    }
    return false;
  }
  
  public boolean a(qav paramqav, ArticleInfo paramArticleInfo)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadMoreBius mArticleInfoModule is null!");
      }
      return false;
    }
    this.jdField_a_of_type_Ozo.a(paramqav, paramArticleInfo);
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Paa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelListFromCache mChannelInfoModule is null!");
      }
      return -1;
    }
    return this.jdField_a_of_type_Paa.b();
  }
  
  public AdvertisementInfo b(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Ozk == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getAdvertisementInfo mAdvertisementInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozk.b(paramInt1, paramInt2);
  }
  
  public ArticleInfo b(int paramInt, long paramLong)
  {
    Object localObject;
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getArticleInfo mArticleInfoModule is null!");
      }
      localObject = null;
      return localObject;
    }
    List localList = this.jdField_a_of_type_Ozo.c(Integer.valueOf(paramInt));
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
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozy.a();
  }
  
  public List<TabChannelCoverInfo> b(int paramInt)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getRecommendChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return null;
    }
    return this.jdField_a_of_type_Ozy.a(paramInt);
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    if (this.jdField_a_of_type_Ozo != null) {
      return this.jdField_a_of_type_Ozo.c(paramInteger);
    }
    return null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ozt == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadArticleReadInfoList mArticleReadInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozt.a();
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
        qaq localqaq1 = (qaq)localList.get(i);
        qaq localqaq2 = new qaq(localqaq1.jdField_a_of_type_Long, localqaq1.jdField_a_of_type_JavaLangString, localqaq1.jdField_b_of_type_JavaLangString);
        int j = 0;
        while (j < localqaq1.jdField_a_of_type_JavaUtilList.size())
        {
          if (paramInt != ((TabChannelCoverInfo)localqaq1.jdField_a_of_type_JavaUtilList.get(j)).mChannelCoverId) {
            localqaq2.jdField_a_of_type_JavaUtilList.add(localqaq1.jdField_a_of_type_JavaUtilList.get(j));
          }
          j += 1;
        }
        localArrayList.add(localqaq2);
        i += 1;
      }
    }
    a(localArrayList, true);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (ozy.a(paramInt1)) {
      c(paramInt1, paramInt2);
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_a_of_type_Paa == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getChildChannelFollowStatus mChannelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Paa.a(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if (this.jdField_a_of_type_Ozo != null) {
      this.jdField_a_of_type_Ozo.a(paramInt, paramBaseArticleInfo);
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_Pbn != null) {
      this.jdField_a_of_type_Pbn.a(paramInt, paramString, null);
    }
  }
  
  public void b(long paramLong)
  {
    if (this.jdField_a_of_type_Ozo != null)
    {
      this.jdField_a_of_type_Ozo.a(paramLong);
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
          this.jdField_a_of_type_Ozo.a(localArticleInfo);
          localArticleInfo = this.jdField_a_of_type_Ozo.a(localArticleInfo, (int)localArticleInfo.mChannelID);
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
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unstickySubscriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbr.b(paramString);
  }
  
  public void b(boolean paramBoolean)
  {
    a(paramBoolean, null);
  }
  
  public boolean b(Long paramLong)
  {
    if (this.jdField_a_of_type_Osf != null) {
      return this.jdField_a_of_type_Osf.a(paramLong);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Pam != null) {
      return this.jdField_a_of_type_Pam.a();
    }
    return 0;
  }
  
  public List<qaz> c()
  {
    if (this.jdField_a_of_type_Pan == null) {
      return new ArrayList();
    }
    return this.jdField_a_of_type_Pan.a();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelTopCookieList mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.f();
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadChannelAdvertisementFromDB mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozy.c(paramInt);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, false, true);
  }
  
  public void c(ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Ozo.a(paramArticleInfo);
  }
  
  public void c(String paramString)
  {
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "removeSubsciriptionFeed mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbr.c(paramString);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getMyChannelCoverListFromCache mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozy.a(paramBoolean);
  }
  
  public int d()
  {
    String str = onh.a();
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
    if (this.jdField_a_of_type_Pav == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestGetInterestLabelInfoList mInterestLabelInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pav.b();
    this.jdField_a_of_type_Pav.a(1, 1, 1, false);
  }
  
  public void d(int paramInt)
  {
    ThreadManager.executeOnSubThread(new ReadInJoyLogicEngine.5(this, paramInt));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Ozo.a(paramInt1, paramInt2);
  }
  
  public void d(String paramString)
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "request0xc6dInteractiveAreaCards mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a(paramString);
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Pam != null) {
      this.jdField_a_of_type_Pam.a(paramBoolean);
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionFeedList mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbr.f();
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
    if (this.jdField_a_of_type_Pbn == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "getSelfFollowAndFansCount mSelfInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbn.a(paramString);
  }
  
  public void e(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Osf != null) {
      this.jdField_a_of_type_Osf.c(paramBoolean);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshKanDianUnReadNum mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.g();
  }
  
  public void f(int paramInt)
  {
    if (this.jdField_a_of_type_Pam != null) {
      this.jdField_a_of_type_Pam.a(paramInt);
    }
  }
  
  public void f(String paramString)
  {
    if (this.jdField_a_of_type_Pam != null) {
      this.jdField_a_of_type_Pam.a(paramString);
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Pbr == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshSubscriptionUnReadNum mSubscriptionInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Pbr.g();
  }
  
  public void g(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void g(String paramString)
  {
    if (this.jdField_a_of_type_Ozo != null)
    {
      this.jdField_a_of_type_Ozo.b(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTagsByKeyword: mArticleInfoModule is null when search " + paramString);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Ozo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ozo.d();
      if (this.jdField_a_of_type_Pbr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pbr.d();
  }
  
  public void h(int paramInt)
  {
    String str = onh.a();
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
    if (this.jdField_a_of_type_Ozo != null)
    {
      this.jdField_a_of_type_Ozo.c(paramString);
      return;
    }
    QLog.d("ReadInJoyLogicEngine", 2, "searchUgcTopicByKeyword: mArticleInfoModule is null when search: " + paramString);
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
      if (this.jdField_a_of_type_Pbr != null) {
        break label80;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Ozk != null) {
        break label90;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mAdvertisementInfoModule is null!");
      }
      return;
      this.jdField_a_of_type_Ozo.e();
      break;
      label80:
      this.jdField_a_of_type_Pbr.e();
    }
    label90:
    this.jdField_a_of_type_Ozk.b();
  }
  
  public void i(int paramInt)
  {
    if (this.jdField_a_of_type_Ozo != null) {
      this.jdField_a_of_type_Ozo.d(paramInt);
    }
  }
  
  public void i(String paramString)
  {
    if (this.jdField_a_of_type_Paa != null) {
      this.jdField_a_of_type_Paa.a(paramString);
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_Ozo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ozo.b();
      if (this.jdField_a_of_type_Pbr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "initInfoModuleOnUICreate mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pbr.b();
  }
  
  public void j(int paramInt)
  {
    b(paramInt, "");
  }
  
  public void j(String paramString)
  {
    if (this.jdField_a_of_type_Pae != null) {
      this.jdField_a_of_type_Pae.a(paramString);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_Ozo == null) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mArticleInfoModule is null!");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Ozo.c();
      if (this.jdField_a_of_type_Pbr != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.info_module", 2, "unInitInfoModuleOnUIDestroy mSubscriptionInfoModule is null!");
    return;
    this.jdField_a_of_type_Pbr.c();
  }
  
  public void l()
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "refreshRecommendAnMyCoverListFromServer mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozy.b();
  }
  
  public void m()
  {
    if (this.jdField_a_of_type_Ozy == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "loadAllChannelCoverListFromDb mChannelCoverInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozy.c();
  }
  
  public void o()
  {
    if (this.jdField_a_of_type_Ozo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.info_module", 2, "requestFollowTab0x8c8UpdateUpvoteAndComment mArticleInfoModule is null!");
      }
      return;
    }
    this.jdField_a_of_type_Ozo.a("-1", 0, 70);
  }
  
  public void p()
  {
    if (this.jdField_a_of_type_Pam != null) {
      this.jdField_a_of_type_Pam.a();
    }
  }
  
  public void q()
  {
    if ((this.jdField_a_of_type_Pan != null) && (this.jdField_a_of_type_Pan.a())) {
      this.jdField_a_of_type_Pan.a(300, 2);
    }
  }
  
  public void r()
  {
    if (this.jdField_a_of_type_Paa != null) {
      this.jdField_a_of_type_Paa.d();
    }
  }
  
  public void s()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
    {
      QLog.d("ReadInJoyLogicEngine", 1, "startFeedsPreload, executorService is not available.");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ReadInJoyLogicEngine.8(this));
  }
  
  public void t()
  {
    if (this.jdField_a_of_type_Pae != null)
    {
      this.jdField_a_of_type_Pae.a();
      return;
    }
    QLog.e("ReadInJoyLogicEngine", 1, "[requestDailyDynamicHeaderData] mDailyDynamicHeaderModule == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osg
 * JD-Core Version:    0.7.0.1
 */