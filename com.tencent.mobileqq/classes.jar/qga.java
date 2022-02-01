import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.1;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.11;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.13;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.14;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.15;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.16;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.17;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.18;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.19;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.2;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.20;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.21;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.22;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.23;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.24;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.25;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.3;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.4;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.5;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.6;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.7;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.8;
import com.tencent.biz.pubaccount.readinjoy.model.RIJArticleInfoRepo.9;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleExposureInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import mqq.os.MqqHandler;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;

public class qga
{
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final EntityManager jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager;
  private final LinkedHashMap<Integer, ConcurrentMap<Long, Boolean>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private final Map<Integer, ChannelTopCookie> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  private final ExecutorService jdField_a_of_type_JavaUtilConcurrentExecutorService;
  private final qep jdField_a_of_type_Qep;
  private final qfz jdField_a_of_type_Qfz;
  private qgd jdField_a_of_type_Qgd;
  private boolean jdField_a_of_type_Boolean;
  private final LinkedHashMap<Integer, ConcurrentMap<String, ArticleExposureInfo>> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private final Map<Integer, CopyOnWriteArrayList<ArticleInfo>> jdField_b_of_type_JavaUtilMap = new HashMap();
  private final LinkedHashMap<Integer, ConcurrentMap<Long, ArticleInfo>> c = new LinkedHashMap();
  private final LinkedHashMap<Integer, ConcurrentHashMap<String, ArticleInfo>> d = new LinkedHashMap();
  
  public qga(ExecutorService paramExecutorService, EntityManager paramEntityManager, Handler paramHandler, qep paramqep, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_Qep = paramqep;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Qfz = new qfz(paramqep);
  }
  
  private ArticleInfo a(ArticleInfo paramArticleInfo)
  {
    ArticleInfo localArticleInfo = paramArticleInfo;
    if (pid.a(paramArticleInfo))
    {
      QLog.d("RIJArticleInfoRepo", 1, "过滤卡片: " + paramArticleInfo + "  social : " + paramArticleInfo.mSocialFeedInfo);
      localArticleInfo = null;
    }
    return localArticleInfo;
  }
  
  private List<ArticleInfo> a(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ? OR mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(17), String.valueOf(19), String.valueOf(0), String.valueOf(24), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
  
  private void a(int paramInt, List<Long> paramList, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    do
    {
      return;
      long l = NetConnInfoCenter.getServerTime();
      paramList = a(Integer.valueOf(paramInt), (Long)paramList.get(0));
      Object localObject;
      if ((paramInt == 0) && (paramList != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        localObject = uuc.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList);
        String str = uuc.a(paramList);
        uuc.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, str, String.valueOf(l), (String)localObject, paramBoolean);
      }
      if ((paramInt == 40677) && (paramList != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        localObject = (pws)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.WEISHI_MANAGER);
        if (localObject != null) {
          ((pws)localObject).a(uuc.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramList), l);
        }
      }
      if ((paramInt == 70) && (paramList != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)))
      {
        localObject = (KandianSubscribeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
        if (localObject != null) {
          ((KandianSubscribeManager)localObject).a(paramList, l);
        }
      }
    } while ((!plm.c(paramInt)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (paramList == null));
    ((KandianDailyManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_DAILY_MANAGER)).a(paramList);
  }
  
  private void a(ChannelTopCookie paramChannelTopCookie)
  {
    if (paramChannelTopCookie.mChannelID == 70)
    {
      if ((paramChannelTopCookie.mSetTopCookie == null) || (paramChannelTopCookie.mSetTopCookie.length <= 0)) {
        break label84;
      }
      if (QLog.isColorLevel()) {
        QLog.d("RIJArticleInfoRepo", 2, "save follow cookie is " + new String(paramChannelTopCookie.mSetTopCookie));
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramChannelTopCookie.mChannelID), paramChannelTopCookie);
      return;
      label84:
      if (QLog.isColorLevel()) {
        QLog.d("RIJArticleInfoRepo", 2, "save follow cookie is null");
      }
    }
  }
  
  private void a(Integer paramInteger)
  {
    paramInteger = (ConcurrentMap)this.c.get(paramInteger);
    ArrayList localArrayList = new ArrayList(paramInteger.keySet());
    Collections.sort(localArrayList);
    int j = localArrayList.size();
    int i = 0;
    while (i < j - 30)
    {
      paramInteger.remove(localArrayList.get(i));
      i += 1;
    }
  }
  
  private void a(List<ChannelTopCookie> paramList)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJArticleInfoRepo.3(this, paramList));
  }
  
  private List<ArticleInfo> b(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(0), String.valueOf(4), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
  
  private void b(Integer paramInteger, ArticleInfo paramArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramInteger.iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        if (localArticleInfo.mArticleID == paramArticleInfo.mArticleID) {
          paramInteger.set(paramInteger.indexOf(localArticleInfo), paramArticleInfo);
        }
      }
    }
  }
  
  private void b(List<ArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.listIterator();
    label12:
    ArticleInfo localArticleInfo1;
    ArticleInfo localArticleInfo2;
    for (;;)
    {
      if (paramList.hasNext())
      {
        localArticleInfo1 = (ArticleInfo)paramList.next();
        localArticleInfo2 = a(localArticleInfo1);
        if (localArticleInfo2 == null)
        {
          paramList.remove();
        }
        else
        {
          if (localArticleInfo2 != localArticleInfo1) {
            paramList.set(localArticleInfo2);
          }
          qfz.a(localArticleInfo2);
          if (piv.a(ppe.a(localArticleInfo2)))
          {
            if (Looper.getMainLooper() != Looper.myLooper()) {
              break label112;
            }
            ThreadManager.getSubThreadHandler().post(new RIJArticleInfoRepo.13(this, localArticleInfo2));
          }
        }
      }
    }
    for (;;)
    {
      localArticleInfo1.articleViewModel = ttb.a(localArticleInfo1);
      break label12;
      break;
      label112:
      piv.a(localArticleInfo2);
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList1, long paramLong1, long paramLong2, List<ArticleInfo> paramList2, ToServiceMsg paramToServiceMsg)
  {
    if (paramBoolean1)
    {
      c(paramList1);
      if ((paramList1 != null) && (paramList1.size() > 0))
      {
        paramToServiceMsg = new CopyOnWriteArrayList(paramList1);
        this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramToServiceMsg);
      }
      if (paramList1 != null)
      {
        paramLong1 = System.currentTimeMillis();
        paramToServiceMsg = paramList1.iterator();
        while (paramToServiceMsg.hasNext()) {
          ((ArticleInfo)paramToServiceMsg.next()).mRefreshTime = (paramLong1 + "");
        }
      }
      this.jdField_a_of_type_Boolean = true;
      if ((paramInt == 70) || (paramInt == 41403) || (plm.a(paramInt)) || (bmhv.a(paramInt))) {
        break label247;
      }
      if ((!paramBoolean2) || (pqt.a(paramInt))) {
        break label182;
      }
      a(Integer.valueOf(paramInt), paramList1, true);
      b(paramInt, paramList2);
    }
    label182:
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("RIJArticleInfoRepo", 2, "handleRefreshChannel clearChannelArticleInfo channelId=" + paramInt);
      }
    } while ((paramList1 == null) || (paramList1.size() <= 0));
    b(paramInt);
    a(Integer.valueOf(paramInt), paramList1, true);
    return;
    label247:
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      b(paramInt);
      a(Integer.valueOf(paramInt), paramList1, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("RIJArticleInfoRepo", 2, "articleInfoList is wrong");
    }
    a(Integer.valueOf(paramInt), paramList1, true);
    b(paramInt, paramList2);
  }
  
  private void c(List<ArticleInfo> paramList)
  {
    if (paramList == null) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        if ((localArticleInfo != null) && (!pms.a(localArticleInfo))) {
          localArrayList.add(localArticleInfo);
        }
      }
    } while (localArrayList.isEmpty());
    paramList.removeAll(localArrayList);
  }
  
  private void d(int paramInt)
  {
    if (this.jdField_a_of_type_Qgd != null) {
      this.jdField_a_of_type_Qgd.a(paramInt);
    }
  }
  
  public int a(Integer paramInteger)
  {
    paramInteger = (List)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return 0;
    }
    return paramInteger.size();
  }
  
  public long a(Integer paramInteger)
  {
    long l1 = -1L;
    paramInteger = (ConcurrentMap)this.c.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = l1;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() > l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public ArticleInfo a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject3;
    if (paramInt == 0)
    {
      localObject3 = (ConcurrentMap)this.c.get(Integer.valueOf(0));
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject2 = ((ConcurrentMap)localObject3).values().iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (ArticleInfo)((Iterator)localObject2).next();
        } while ((((ArticleInfo)localObject1).mRecommendSeq != paramArticleInfo.mRecommendSeq) || (((ArticleInfo)localObject1).mArticleID != paramArticleInfo.mArticleID));
      }
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((ArticleInfo)localObject1).mSocialFeedInfoByte = paramArticleInfo.mSocialFeedInfoByte;
        if (QLog.isColorLevel()) {
          QLog.d("RIJArticleInfoRepo", 2, "mArticleID = " + ((ArticleInfo)localObject1).mArticleID + ", old data = " + ((ArticleInfo)localObject1).mSocialFeedInfo + ", new data = " + paramArticleInfo.mSocialFeedInfo);
        }
        ((ArticleInfo)localObject1).mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo;
        localObject2 = (ConcurrentMap)this.c.get(Integer.valueOf(paramInt));
        localObject3 = localObject1;
        if (localObject2 != null)
        {
          localObject3 = ((ConcurrentMap)localObject2).values().iterator();
          do
          {
            localObject2 = localObject1;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2 = (ArticleInfo)((Iterator)localObject3).next();
          } while ((((ArticleInfo)localObject2).mFeedId == 0L) || (((ArticleInfo)localObject2).mFeedId != paramArticleInfo.mSocialFeedInfo.a) || (((ArticleInfo)localObject2).mFeedType != paramArticleInfo.mFeedType));
          if ((localObject2 == null) || (((ArticleInfo)localObject2).mFeedId != paramArticleInfo.mSocialFeedInfo.a) || (((ArticleInfo)localObject2).mFeedType != paramArticleInfo.mFeedType)) {
            break label447;
          }
          ((ArticleInfo)localObject2).mSocialFeedInfoByte = paramArticleInfo.mSocialFeedInfoByte;
          if (QLog.isColorLevel()) {
            QLog.d("RIJArticleInfoRepo", 2, "mArticleID = " + ((ArticleInfo)localObject2).mArticleID + ", old data = " + ((ArticleInfo)localObject2).mSocialFeedInfo + ", new data = " + paramArticleInfo.mSocialFeedInfo);
          }
          ((ArticleInfo)localObject2).mSocialFeedInfo = paramArticleInfo.mSocialFeedInfo;
          localObject3 = localObject2;
        }
      }
      label447:
      do
      {
        return localObject3;
        if (QLog.isColorLevel()) {
          QLog.d("RIJArticleInfoRepo", 2, "cannot update no-cached article id:" + paramArticleInfo.mArticleID + " title:" + paramArticleInfo.mTitle);
        }
        break;
        localObject3 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.d("RIJArticleInfoRepo", 2, "cannot update no-cached article id:" + paramArticleInfo.mArticleID + " title:" + paramArticleInfo.mTitle);
      return localObject2;
      localObject1 = null;
    }
  }
  
  public ArticleInfo a(Integer paramInteger)
  {
    if (pqt.a(paramInteger.intValue()))
    {
      paramInteger = null;
      return paramInteger;
    }
    List localList = (List)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if ((localList != null) && (!localList.isEmpty()))
    {
      if (paramInteger.intValue() == 70)
      {
        int i = 0;
        for (;;)
        {
          if (i >= localList.size()) {
            break label114;
          }
          ArticleInfo localArticleInfo = (ArticleInfo)localList.get(i);
          paramInteger = localArticleInfo;
          if (localArticleInfo.hintFlag) {
            break;
          }
          i += 1;
        }
      }
      return (ArticleInfo)localList.get(localList.size() - 1);
    }
    label114:
    return null;
  }
  
  public ArticleInfo a(Integer paramInteger, Long paramLong)
  {
    paramInteger = (ConcurrentMap)this.c.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return (ArticleInfo)paramInteger.get(paramLong);
  }
  
  public List<Long> a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramInt1, paramInt2, paramLong, paramBoolean);
    if (((List)localObject).isEmpty()) {
      return null;
    }
    rbg.a().a((List)localObject);
    a(Integer.valueOf(paramInt1), (List)localObject, false);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID))) {
        QLog.d("RIJArticleInfoRepo", 2, "loadChannelArticleSeqList articleID duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else if (!localHashSet2.add(Long.valueOf(localArticleInfo.mRecommendSeq))) {
        QLog.d("RIJArticleInfoRepo", 2, "loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = " + paramInt1 + ", seq = " + localArticleInfo.mRecommendSeq + "articleID = " + localArticleInfo.mArticleID);
      } else {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    this.jdField_a_of_type_Qfz.a(Integer.valueOf(paramInt1), localArrayList);
    return localArrayList;
  }
  
  public List<Long> a(Integer paramInteger)
  {
    Object localObject = b(paramInteger);
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
      if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 41403) && (!localHashSet1.add(Long.valueOf(localArticleInfo.mArticleID))))
      {
        QLog.d("RIJArticleInfoRepo", 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localArticleInfo.mRecommendSeq + "，articleID = " + localArticleInfo.mArticleID);
        a(paramInteger, localArticleInfo);
      }
      else if ((paramInteger.intValue() == 41403) && (!localHashSet2.add(Long.valueOf(localArticleInfo.mFeedId))))
      {
        QLog.d("RIJArticleInfoRepo", 1, new Object[] { "getChannelArticleSeqList 有重复feeds, channelID = ", paramInteger, ", seq = ", Long.valueOf(localArticleInfo.mRecommendSeq), ", feedsId = ", Long.valueOf(localArticleInfo.mFeedId) });
        a(paramInteger, localArticleInfo);
      }
      else
      {
        localArrayList.add(Long.valueOf(localArticleInfo.mRecommendSeq));
      }
    }
    this.jdField_a_of_type_Qfz.a(paramInteger, localArrayList);
    return localArrayList;
  }
  
  public ConcurrentMap<Long, Boolean> a(int paramInt)
  {
    return (ConcurrentMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.c.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.d.clear();
  }
  
  public void a(int paramInt)
  {
    if (!pqt.h()) {}
    while ((paramInt != 0) && (!plm.c(paramInt))) {
      return;
    }
    if ((ConcurrentMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt)) != null)
    {
      QLog.d("RIJArticleInfoRepo", 1, "loadArticleExposureInfoFromDB has loaded!");
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.5(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = (ArrayList)b(paramInt1);
    if ((localObject1 == null) || (((ArrayList)localObject1).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RIJArticleInfoRepo", 2, "no recommend topic feeds");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    qxm.a((List)localObject1);
    localArrayList.addAll((Collection)localObject1);
    int i = 0;
    int j;
    if (i < localArrayList.size())
    {
      j = (int)((ArticleInfo)localArrayList.get(i)).mChannelID;
      localObject1 = (ConcurrentMap)this.c.get(Integer.valueOf(j));
      if (localObject1 != null) {
        break label676;
      }
      localObject1 = new ConcurrentHashMap();
      this.c.put(Integer.valueOf(j), localObject1);
    }
    label676:
    for (;;)
    {
      for (;;)
      {
        if ((((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo.a.size() > 0)) {
          ((rsj)((ArticleInfo)localArrayList.get(i)).mTopicRecommendFeedsInfo.a.get(0)).c = paramInt2;
        }
        int k;
        Object localObject2;
        if (((ArticleInfo)localArrayList.get(i)).mPolymericInfo != null)
        {
          k = paramInt2 + 1;
          ((ArticleInfo)localArrayList.get(i)).mPolymericInfo.e = k;
          localObject2 = new articlesummary.PackInfo();
        }
        try
        {
          ((articlesummary.PackInfo)localObject2).mergeFrom(((ArticleInfo)localArrayList.get(i)).mPackInfoBytes);
          ((articlesummary.PackInfo)localObject2).uint32_follow_status.set(k, true);
          ((ArticleInfo)localArrayList.get(i)).mPackInfoBytes = ((articlesummary.PackInfo)localObject2).toByteArray();
          localObject2 = ((ArticleInfo)localArrayList.get(i)).clone();
          if (((ConcurrentMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq)) != null)
          {
            a(Integer.valueOf(j), (ArticleInfo)localObject2);
            if (QLog.isColorLevel()) {
              QLog.e("RIJArticleInfoRepo", 2, "recordArticleInfo, article duplicated, article been channelID=" + j + ", articleID=" + ((ArticleInfo)localObject2).mArticleID + "，seq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
          }
          localObject1 = (ArticleInfo)((ConcurrentMap)localObject1).get(Long.valueOf(((ArticleInfo)localObject2).mRecommendSeq));
          if (localObject1 != null)
          {
            if ((((ArticleInfo)localObject1).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a != null) && (((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.size() > 0)) {
              ((rsj)((ArticleInfo)localObject1).mTopicRecommendFeedsInfo.a.get(0)).c = paramInt2;
            }
            if (((ArticleInfo)localObject1).mPolymericInfo != null)
            {
              j = paramInt2 + 1;
              ((ArticleInfo)localObject1).mPolymericInfo.e = j;
              localPackInfo = new articlesummary.PackInfo();
            }
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException1)
        {
          try
          {
            articlesummary.PackInfo localPackInfo;
            localPackInfo.mergeFrom(((ArticleInfo)localObject1).mPackInfoBytes);
            localPackInfo.uint32_follow_status.set(j, true);
            ((ArticleInfo)localObject1).mPackInfoBytes = localPackInfo.toByteArray();
            ((ArticleInfo)localObject1).invalidateProteusTemplateBean();
            this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.18(this, (ArticleInfo)localObject2));
            i += 1;
            break;
            localInvalidProtocolBufferMicroException1 = localInvalidProtocolBufferMicroException1;
            QLog.e("RIJArticleInfoRepo", 1, "first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:" + paramInt1 + " e = " + localInvalidProtocolBufferMicroException1);
            localInvalidProtocolBufferMicroException1.printStackTrace();
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException2)
          {
            for (;;)
            {
              QLog.e("RIJArticleInfoRepo", 1, "first setSmallVideoTopicFollowTypeIntoDB article.mPackInfoBytes convert error article.topicID:" + paramInt1 + " e = " + localInvalidProtocolBufferMicroException2);
              localInvalidProtocolBufferMicroException2.printStackTrace();
            }
          }
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJArticleInfoRepo.19(this, paramInt1, paramInt2));
      return;
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      QLog.i("RIJArticleInfoRepo", 1, "[loadFeedsFromDB], mExecutorService is null or shutDown.");
    }
    List localList;
    do
    {
      return;
      localList = a(Integer.valueOf(paramInt1));
    } while ((localList == null) || (localList.isEmpty()));
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.20(this, paramInt1, paramInt2, paramLong, paramBoolean));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.e("RIJArticleInfoRepo", 1, "[preloadFeedsFromDB], e = " + localRejectedExecutionException);
    }
  }
  
  public void a(int paramInt1, int paramInt2, long paramLong1, boolean paramBoolean, long paramLong2)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()))
    {
      QLog.i("RIJArticleInfoRepo", 1, "[loadFeedsFromDB], mExecutorService is null or shutDown.");
      return;
    }
    List localList = a(Integer.valueOf(paramInt1));
    if ((localList != null) && (localList.size() > 0))
    {
      rbg.a().a(paramInt1, localList);
      if ((Looper.myLooper() == Looper.getMainLooper()) && (pkh.c()))
      {
        qxy.a().a(paramInt1, localList, paramLong2);
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new RIJArticleInfoRepo.21(this, paramInt1, localList, paramLong2));
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.22(this, paramInt1, localList, paramInt2, paramLong1, paramBoolean, paramLong2));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.e("RIJArticleInfoRepo", 1, "[loadFeedsFromDB], e = " + localRejectedExecutionException);
    }
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.e("RIJArticleInfoRepo", 2, "deleteChannelArticle channelId=" + paramInt + "recommendSeq=" + paramLong);
    }
    if ((paramLong == -2L) || (paramLong == -3L)) {
      if (QLog.isColorLevel()) {
        QLog.e("RIJArticleInfoRepo", 2, "deleteChannelArticle recommendSeq is TOPIC/SUBSCRIBE recommendSeq");
      }
    }
    ConcurrentMap localConcurrentMap;
    ArticleInfo localArticleInfo;
    do
    {
      do
      {
        return;
        localConcurrentMap = (ConcurrentMap)this.c.get(Integer.valueOf(paramInt));
      } while (localConcurrentMap == null);
      localArticleInfo = (ArticleInfo)localConcurrentMap.get(Long.valueOf(paramLong));
      if (localArticleInfo != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("RIJArticleInfoRepo", 2, "deleteChannelArticle connot find channelId=" + paramInt + "ArticleInfo with recommendSeq=" + paramLong);
    return;
    a(Integer.valueOf(paramInt), localArticleInfo);
    localConcurrentMap.remove(Long.valueOf(paramLong));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.8(this, localArticleInfo));
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    Object localObject2 = (ConcurrentMap)this.c.get(Integer.valueOf(paramInt1));
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new ArrayList(((ConcurrentMap)localObject2).size());
    Iterator localIterator = ((ConcurrentMap)localObject2).values().iterator();
    ArticleInfo localArticleInfo;
    while (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      if (localArticleInfo.mRecommendTime < paramLong) {
        ((ArrayList)localObject1).add(localArticleInfo);
      }
    }
    int j = ((ConcurrentMap)localObject2).size() - ((ArrayList)localObject1).size();
    if (j < paramInt2)
    {
      Collections.sort((List)localObject1, new qgb(this));
      int i = 0;
      for (;;)
      {
        if (i >= paramInt2 - j) {
          break label167;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break;
        }
        ((ArrayList)localObject1).remove(0);
        i += 1;
      }
    }
    label167:
    localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator.next();
      ((ConcurrentMap)localObject2).remove(Long.valueOf(localArticleInfo.mRecommendSeq));
      a(Integer.valueOf(paramInt1), localArticleInfo);
    }
    localObject2 = a(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_AndroidOsHandler.post(new RIJArticleInfoRepo.11(this, paramInt1, (List)localObject2));
    localObject1 = new StringBuilder().append("delete outdated article cache , cnt ").append(((ArrayList)localObject1).size()).append(", reservedCnt : ");
    if (j < paramInt2) {}
    for (;;)
    {
      QLog.d("RIJArticleInfoRepo", 2, paramInt2);
      return;
      paramInt2 = j;
    }
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = (ConcurrentMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
    if (localObject == null)
    {
      localObject = new ConcurrentHashMap();
      this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt), localObject);
    }
    for (;;)
    {
      ArticleExposureInfo localArticleExposureInfo2;
      if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramBaseArticleInfo.innerUniqueID)))
      {
        if (!((ConcurrentMap)localObject).containsKey(paramBaseArticleInfo.innerUniqueID)) {
          break label139;
        }
        localArticleExposureInfo2 = (ArticleExposureInfo)((ConcurrentMap)localObject).get(paramBaseArticleInfo.innerUniqueID);
        localArticleExposureInfo1 = localArticleExposureInfo2;
        if (localArticleExposureInfo2 != null) {
          localArticleExposureInfo2.exposureTime = NetConnInfoCenter.getServerTimeMillis();
        }
      }
      label139:
      for (ArticleExposureInfo localArticleExposureInfo1 = localArticleExposureInfo2;; localArticleExposureInfo1 = ArticleExposureInfo.createExposureInfoFromArticle(paramBaseArticleInfo))
      {
        if (localArticleExposureInfo1 != null)
        {
          ((ConcurrentMap)localObject).put(paramBaseArticleInfo.innerUniqueID, localArticleExposureInfo1);
          ThreadManager.excute(new RIJArticleInfoRepo.4(this, localArticleExposureInfo1), 32, null, true);
        }
        return;
      }
    }
  }
  
  public void a(int paramInt, List<ArticleInfo> paramList)
  {
    if (!pqt.h()) {}
    ArrayList localArrayList;
    do
    {
      Map localMap;
      do
      {
        do
        {
          return;
        } while ((paramList == null) || (paramList.isEmpty()) || ((paramInt != 0) && (!plm.c(paramInt))));
        localMap = (Map)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      } while (localMap == null);
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ArticleInfo localArticleInfo = (ArticleInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) && (localMap.containsKey(localArticleInfo.innerUniqueID))) {
          if ((!localArticleInfo.isNeeaRealExposureFilter) || (localArticleInfo.mAbandonRepeatFlag == 1))
          {
            QLog.d("RIJArticleInfoRepo", 1, "[filterRealExposureArticle] isReplaceFlag is true or isNeedRealExposureFilter flag is false, articleID : " + localArticleInfo.mArticleID);
          }
          else
          {
            localArrayList.add(localArticleInfo);
            QLog.d("RIJArticleInfoRepo", 1, "[filterRealExposureArticle] 文章已真实曝光，需去重: " + localArticleInfo + ", exposureInfo : " + localMap.get(localArticleInfo.innerUniqueID));
          }
        }
      }
    } while (localArrayList.isEmpty());
    paramList.removeAll(localArrayList);
  }
  
  public void a(int paramInt, ConcurrentMap<Long, Boolean> paramConcurrentMap)
  {
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramInt), paramConcurrentMap);
  }
  
  public void a(long paramLong, int paramInt)
  {
    List localList = b(Integer.valueOf(paramInt));
    if (localList == null) {
      return;
    }
    paramInt = 0;
    for (;;)
    {
      if ((paramInt >= localList.size()) || ((localList.get(paramInt) != null) && (((ArticleInfo)localList.get(paramInt)).mArticleID == paramLong)))
      {
        paramInt += 15;
        while (paramInt < localList.size())
        {
          if (localList.get(paramInt) != null) {
            ((ArticleInfo)localList.get(paramInt)).invalidateProteusTemplateBean();
          }
          paramInt += 1;
        }
        break;
      }
      paramInt += 1;
    }
  }
  
  public void a(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (!paramArticleInfo.showBreathAnimation)) {
      return;
    }
    label11:
    label199:
    for (;;)
    {
      Object localObject = (ConcurrentMap)this.c.get(Integer.valueOf(0));
      if (localObject != null)
      {
        if (((ConcurrentMap)localObject).containsKey(Long.valueOf(paramArticleInfo.mRecommendSeq)))
        {
          ((ArticleInfo)((ConcurrentMap)localObject).get(Long.valueOf(paramArticleInfo.mRecommendSeq))).showBreathAnimation = false;
          a(Integer.valueOf(0), paramArticleInfo, true);
          QLog.d("RIJArticleInfoRepo", 2, "resetBiuBreathAnimationFlag | reset breathAnim for fastweb type");
        }
        for (int i = 1;; i = 0)
        {
          if (i != 0) {
            break label199;
          }
          localObject = ((ConcurrentMap)localObject).values().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break label11;
          }
          ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
          if ((localArticleInfo == null) || ((localArticleInfo.mArticleID != paramArticleInfo.mArticleID) && ((TextUtils.isEmpty(localArticleInfo.innerUniqueID)) || (!localArticleInfo.innerUniqueID.equalsIgnoreCase(paramArticleInfo.innerUniqueID))))) {
            break;
          }
          localArticleInfo.showBreathAnimation = false;
          a(Integer.valueOf(0), paramArticleInfo, true);
          QLog.d("RIJArticleInfoRepo", 2, "resetBiuBreathAnimationFlag |  reset breathAnim for video or shortContent type");
          return;
        }
      }
    }
  }
  
  public void a(Integer paramInteger, ArticleInfo paramArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      paramInteger.remove(paramArticleInfo);
    }
  }
  
  public void a(Integer paramInteger, byte[] paramArrayOfByte)
  {
    ChannelTopCookie localChannelTopCookie2 = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    ChannelTopCookie localChannelTopCookie1;
    if (localChannelTopCookie2 == null)
    {
      localChannelTopCookie2 = new ChannelTopCookie();
      localChannelTopCookie2.mChannelID = paramInteger.intValue();
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
    for (;;)
    {
      a(localChannelTopCookie1);
      try
      {
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.1(this, localChannelTopCookie1));
        return;
      }
      catch (Exception paramInteger)
      {
        paramInteger.printStackTrace();
      }
      localChannelTopCookie1 = localChannelTopCookie2;
      if (paramInteger.intValue() == 70)
      {
        localChannelTopCookie1 = localChannelTopCookie2;
        if (paramArrayOfByte != null)
        {
          localChannelTopCookie2.mSetTopCookie = paramArrayOfByte;
          localChannelTopCookie1 = localChannelTopCookie2;
        }
      }
    }
  }
  
  /* Error */
  public void a(List<ArticleInfo> paramList, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 842	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: invokevirtual 847	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   10: aload_1
    //   11: invokeinterface 394 1 0
    //   16: astore_1
    //   17: aload_1
    //   18: invokeinterface 307 1 0
    //   23: ifeq +160 -> 183
    //   26: aload_1
    //   27: invokeinterface 311 1 0
    //   32: checkcast 90	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo
    //   35: astore_3
    //   36: aload_3
    //   37: getfield 851	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mExtraBiuBriefInfo	Lrpb;
    //   40: ifnull -23 -> 17
    //   43: aload_3
    //   44: getfield 851	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mExtraBiuBriefInfo	Lrpb;
    //   47: getfield 854	rpb:a	Ljava/util/ArrayList;
    //   50: ifnull -33 -> 17
    //   53: aload_3
    //   54: getfield 851	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mExtraBiuBriefInfo	Lrpb;
    //   57: getfield 854	rpb:a	Ljava/util/ArrayList;
    //   60: invokevirtual 750	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   63: astore_3
    //   64: aload_3
    //   65: invokeinterface 307 1 0
    //   70: ifeq -53 -> 17
    //   73: aload_3
    //   74: invokeinterface 311 1 0
    //   79: checkcast 856	rpc
    //   82: astore 4
    //   84: aload_0
    //   85: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   88: ldc 90
    //   90: ldc_w 858
    //   93: iconst_2
    //   94: anewarray 121	java/lang/String
    //   97: dup
    //   98: iconst_0
    //   99: iload_2
    //   100: invokestatic 125	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   103: aastore
    //   104: dup
    //   105: iconst_1
    //   106: aload 4
    //   108: getfield 859	rpc:a	J
    //   111: invokestatic 172	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   114: aastore
    //   115: invokevirtual 863	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   118: astore 4
    //   120: aload 4
    //   122: ifnull -58 -> 64
    //   125: aload_0
    //   126: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   129: aload 4
    //   131: invokevirtual 866	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   134: pop
    //   135: goto -71 -> 64
    //   138: astore_1
    //   139: aload_1
    //   140: invokevirtual 837	java/lang/Exception:printStackTrace	()V
    //   143: ldc 74
    //   145: iconst_2
    //   146: new 76	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 868
    //   156: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: aload_1
    //   160: invokevirtual 871	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: invokevirtual 98	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 874	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   176: invokevirtual 842	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   179: invokevirtual 877	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   182: return
    //   183: aload_0
    //   184: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   187: invokevirtual 842	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   190: invokevirtual 880	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   193: aload_0
    //   194: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   197: invokevirtual 842	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   200: invokevirtual 877	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: return
    //   204: astore_1
    //   205: aload_0
    //   206: getfield 51	qga:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   209: invokevirtual 842	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   212: invokevirtual 877	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   215: aload_1
    //   216: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	217	0	this	qga
    //   0	217	1	paramList	List<ArticleInfo>
    //   0	217	2	paramInt	int
    //   35	39	3	localObject1	Object
    //   82	48	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	17	138	java/lang/Exception
    //   17	64	138	java/lang/Exception
    //   64	120	138	java/lang/Exception
    //   125	135	138	java/lang/Exception
    //   183	193	138	java/lang/Exception
    //   0	17	204	finally
    //   17	64	204	finally
    //   64	120	204	finally
    //   125	135	204	finally
    //   139	172	204	finally
    //   183	193	204	finally
  }
  
  public void a(qgd paramqgd)
  {
    this.jdField_a_of_type_Qgd = paramqgd;
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList1, long paramLong1, long paramLong2, List<ArticleInfo> paramList2, ToServiceMsg paramToServiceMsg)
  {
    b(paramBoolean1, paramInt, paramBoolean2, paramList1, paramLong1, paramLong2, paramList2, paramToServiceMsg);
    paramList2 = a(Integer.valueOf(paramInt));
    if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((paramBoolean2) || ((paramList1 == null) && (paramBoolean1))) && (paramList2 != null)) {
      ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(paramList2.size());
    }
    Object localObject = paramToServiceMsg.getAttribute("isRedRefreshReq");
    if ((localObject != null) && ((localObject instanceof Boolean))) {}
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      if (paramInt == 0)
      {
        uvs.a(paramList1, paramList2, bool);
        uvs.a(paramList1);
        localObject = (List)paramToServiceMsg.getAttributes().get("SubscriptionArticles");
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          pvm.a().a(paramBoolean1, (List)localObject, paramList1);
        }
        pvm.a().a(paramBoolean1, paramInt, paramList2, paramBoolean2);
        qxy.a().a(paramInt, paramList2, paramBoolean1, paramBoolean2, paramToServiceMsg);
        if (paramBoolean1) {
          if (paramList1 == null) {
            break label251;
          }
        }
      }
      label251:
      for (int i = paramList1.size();; i = 0)
      {
        qks.a(paramToServiceMsg, i);
        a(paramInt, paramList2, paramBoolean1);
        return;
        if (!plm.c(paramInt)) {
          break;
        }
        pin.a(paramList1, paramList2, bool);
        break;
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RIJArticleInfoRepo", 2, "setRecommendTopicFollowTypeIntoDB topicID = " + paramInt1 + "，followType=" + paramInt2);
    }
    Object localObject = (ArrayList)a(paramInt1);
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJArticleInfoRepo", 2, "no recommend topic feeds in db");
      }
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    qxm.a((List)localObject);
    localArrayList.addAll((Collection)localObject);
    paramInt1 = 0;
    int i;
    if (paramInt1 < localArrayList.size())
    {
      i = (int)((ArticleInfo)localArrayList.get(paramInt1)).mChannelID;
      localObject = (ConcurrentMap)this.c.get(Integer.valueOf(i));
      if (localObject != null) {
        break label463;
      }
      localObject = new ConcurrentHashMap();
      this.c.put(Integer.valueOf(i), localObject);
    }
    label463:
    for (;;)
    {
      if ((((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.a.size() > 0)) {
        ((rsj)((ArticleInfo)localArrayList.get(paramInt1)).mTopicRecommendFeedsInfo.a.get(0)).c = paramInt2;
      }
      ArticleInfo localArticleInfo = ((ArticleInfo)localArrayList.get(paramInt1)).clone();
      if (((ConcurrentMap)localObject).get(Long.valueOf(localArticleInfo.mRecommendSeq)) != null) {
        a(Integer.valueOf(i), localArticleInfo);
      }
      localObject = (ArticleInfo)((ConcurrentMap)localObject).get(Long.valueOf(localArticleInfo.mRecommendSeq));
      if (localObject != null)
      {
        if ((((ArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((ArticleInfo)localObject).mTopicRecommendFeedsInfo.a != null) && (((ArticleInfo)localObject).mTopicRecommendFeedsInfo.a.size() > 0)) {
          ((rsj)((ArticleInfo)localObject).mTopicRecommendFeedsInfo.a.get(0)).c = paramInt2;
        }
        ((ArticleInfo)localObject).invalidateProteusTemplateBean();
        if (QLog.isColorLevel()) {
          QLog.d("RIJArticleInfoRepo", 2, "update memory articleInfo articleID = " + ((ArticleInfo)localObject).mArticleID + ", mRecommendSeq =" + ((ArticleInfo)localObject).mRecommendSeq + "，followType=" + paramInt2);
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.16(this, localArticleInfo));
      paramInt1 += 1;
      break;
      this.jdField_a_of_type_AndroidOsHandler.post(new RIJArticleInfoRepo.17(this));
      return true;
    }
  }
  
  public boolean a(ArticleInfo paramArticleInfo)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramArticleInfo != null)
    {
      bool1 = bool3;
      if (this.c != null)
      {
        Object localObject = (ConcurrentMap)this.c.get(Integer.valueOf(0));
        bool1 = bool3;
        if (localObject != null)
        {
          if (((ConcurrentMap)localObject).containsKey(Long.valueOf(paramArticleInfo.mRecommendSeq))) {
            bool2 = true;
          }
          bool1 = bool2;
          if (!bool2)
          {
            localObject = ((ConcurrentMap)localObject).values().iterator();
            ArticleInfo localArticleInfo;
            do
            {
              bool1 = bool2;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
            } while ((localArticleInfo == null) || ((localArticleInfo.mArticleID != paramArticleInfo.mArticleID) && ((TextUtils.isEmpty(localArticleInfo.innerUniqueID)) || (!localArticleInfo.innerUniqueID.equalsIgnoreCase(paramArticleInfo.innerUniqueID)))));
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      QLog.d("RIJArticleInfoRepo", 2, "isArticleFromRecommendFeeds : " + bool1);
      return bool1;
    }
  }
  
  public boolean a(Integer paramInteger, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    if (paramArticleInfo == null) {}
    while (!pms.a(paramArticleInfo)) {
      return false;
    }
    Object localObject = (ConcurrentMap)this.c.get(paramInteger);
    if (localObject == null)
    {
      localObject = new ConcurrentHashMap();
      this.c.put(paramInteger, localObject);
    }
    for (;;)
    {
      boolean bool;
      if (((ConcurrentMap)localObject).get(Long.valueOf(paramArticleInfo.mRecommendSeq)) != null) {
        if (paramArticleInfo.mAbandonRepeatFlag == 0)
        {
          bool = true;
          label78:
          QLog.e("RIJArticleInfoRepo", 1, "saveArticleInfo, article duplicated, article been channelID=" + paramInteger + ", articleID=" + paramArticleInfo.mArticleID + "，seq=" + paramArticleInfo.mRecommendSeq + ", toDb=" + paramBoolean + "，isDupArticle =" + bool + "，title = " + paramArticleInfo.mTitle);
        }
      }
      for (;;)
      {
        ConcurrentHashMap localConcurrentHashMap;
        if ((paramInteger.intValue() != 70) && (paramInteger.intValue() != 0) && (paramInteger.intValue() != 9999) && (!TextUtils.isEmpty(paramArticleInfo.mVideoVid)))
        {
          localConcurrentHashMap = (ConcurrentHashMap)this.d.get(paramInteger);
          if (localConcurrentHashMap != null) {
            break label545;
          }
          localConcurrentHashMap = new ConcurrentHashMap();
          this.d.put(paramInteger, localConcurrentHashMap);
        }
        label530:
        label545:
        for (;;)
        {
          if (localConcurrentHashMap.get(paramArticleInfo.mVideoVid) != null)
          {
            ArticleInfo localArticleInfo = (ArticleInfo)localConcurrentHashMap.get(paramArticleInfo.mVideoVid);
            if (localArticleInfo.mArticleID != paramArticleInfo.mArticleID)
            {
              a(paramInteger.intValue(), localArticleInfo.mRecommendSeq);
              if (QLog.isColorLevel()) {
                QLog.e("RIJArticleInfoRepo", 2, "saveArticleInfo, find article vid duplicated! old article: channelID=" + paramInteger + ", id=" + localArticleInfo.mArticleID + "，seq: " + localArticleInfo.mRecommendSeq + ", title: " + pqu.a(localArticleInfo.mTitle) + "，vid =" + localArticleInfo.mVideoVid + "\n new article  id : " + paramArticleInfo.mArticleID + " seq : " + paramArticleInfo.mRecommendSeq + " title : " + pqu.a(paramArticleInfo.mTitle) + "，vid =" + paramArticleInfo.mVideoVid);
              }
            }
          }
          localConcurrentHashMap.put(paramArticleInfo.mVideoVid, paramArticleInfo);
          if (!bool)
          {
            ((ConcurrentMap)localObject).put(Long.valueOf(paramArticleInfo.mRecommendSeq), paramArticleInfo);
            if (paramArticleInfo.isWormhole()) {
              break;
            }
            if (paramBoolean)
            {
              if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated())) {
                break label530;
              }
              this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.6(this, paramArticleInfo));
            }
          }
          for (;;)
          {
            return true;
            ThreadManager.executeOnSubThread(new RIJArticleInfoRepo.7(this, paramArticleInfo));
          }
        }
        bool = false;
        break label78;
        bool = false;
      }
    }
  }
  
  public boolean a(Integer paramInteger, List<ArticleInfo> paramList, boolean paramBoolean)
  {
    b(paramList);
    if ((paramInteger.intValue() == -1) || (paramList == null) || (paramList.size() == 0))
    {
      this.jdField_b_of_type_JavaUtilMap.remove(paramInteger);
      return false;
    }
    this.jdField_a_of_type_Qfz.a(paramInteger, paramList, paramBoolean);
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInteger, (ArticleInfo)paramList.next(), paramBoolean);
    }
    if ((paramInteger.intValue() == 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = false;
      if (((ConcurrentMap)this.c.get(paramInteger)).size() > 30) {
        a(paramInteger);
      }
    }
    return true;
  }
  
  public byte[] a(Integer paramInteger)
  {
    paramInteger = (ChannelTopCookie)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger == null) {
      return null;
    }
    return paramInteger.mSetTopCookie;
  }
  
  public long b(Integer paramInteger)
  {
    long l1 = 9223372036854775807L;
    paramInteger = (ConcurrentMap)this.c.get(paramInteger);
    long l2;
    if (paramInteger == null) {
      l2 = -1L;
    }
    do
    {
      return l2;
      paramInteger = paramInteger.keySet().iterator();
      l2 = l1;
    } while (!paramInteger.hasNext());
    Long localLong = (Long)paramInteger.next();
    if (localLong.longValue() < l1) {
      l1 = localLong.longValue();
    }
    for (;;)
    {
      break;
    }
  }
  
  public List<ArticleInfo> b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Object localObject = "mChannelID = ? and mRecommendSeq < ?";; localObject = "mChannelID = ? and mRecommendSeq > ?")
    {
      if (QLog.isColorLevel()) {
        QLog.e("RIJArticleInfoRepo", 2, "loadChannelArticleSeqList with selection=" + (String)localObject + "channelId=" + paramInt1 + "recommendSeq=" + paramLong + "count=" + paramInt2);
      }
      ArrayList localArrayList = new ArrayList();
      localObject = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ArticleInfo.class, true, (String)localObject, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "mRecommendSeq desc", String.valueOf(paramInt2));
      if (localObject != null)
      {
        qxm.a((List)localObject);
        localArrayList.addAll((Collection)localObject);
      }
      if ((localArrayList.isEmpty()) && (QLog.isColorLevel())) {
        QLog.e("RIJArticleInfoRepo", 2, "loadChannelArticleSeqList mEntityManager.query return empty");
      }
      a(paramInt1);
      return localArrayList;
    }
  }
  
  public List<ArticleInfo> b(Integer paramInteger)
  {
    paramInteger = (ConcurrentMap)this.c.get(paramInteger);
    if ((paramInteger == null) || (paramInteger.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInteger.size());
    Iterator localIterator = paramInteger.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((ArticleInfo)paramInteger.get((Long)localIterator.next()));
    }
    Collections.sort(localArrayList, new qgc(this));
    return localArrayList;
  }
  
  public ConcurrentMap<String, ArticleExposureInfo> b(int paramInt)
  {
    return (ConcurrentMap)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.2(this));
  }
  
  public void b(int paramInt)
  {
    this.c.remove(Integer.valueOf(paramInt));
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.9(this, paramInt));
  }
  
  public void b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService == null) || (this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown())) {
      return;
    }
    List localList1 = a(Integer.valueOf(paramInt1));
    List localList2 = pvj.a().a(Integer.valueOf(paramInt1), localList1);
    if ((localList1 != null) && (localList1.size() > 0))
    {
      rbg.a().a(paramInt1, localList1);
      qyx.a(localList2);
      if ((Looper.myLooper() == Looper.getMainLooper()) && (pkh.c()))
      {
        pvm.a().a(paramInt1, localList1);
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.post(new RIJArticleInfoRepo.23(this, paramInt1, localList1));
        return;
      }
    }
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.24(this, paramInt1, localList1, paramInt2, paramLong, paramBoolean));
      return;
    }
    catch (RejectedExecutionException localRejectedExecutionException)
    {
      QLog.d("RIJArticleInfoRepo", 1, "loadChannelArticle Exception.");
      localRejectedExecutionException.printStackTrace();
    }
  }
  
  public void b(int paramInt, List<ArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    Object localObject1;
    do
    {
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("RIJArticleInfoRepo", 2, "deleteChannelArticleList channelID = " + paramInt + " articleList");
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ArticleInfo)((Iterator)localObject1).next();
          QLog.d("RIJArticleInfoRepo", 2, "articleInfo.mArticleID = " + ((ArticleInfo)localObject2).mArticleID);
        }
      }
      localObject1 = (ConcurrentMap)this.c.get(Integer.valueOf(paramInt));
    } while (localObject1 == null);
    Object localObject2 = new StringBuilder();
    Iterator localIterator1 = paramList.iterator();
    label148:
    ArticleInfo localArticleInfo;
    if (localIterator1.hasNext())
    {
      localArticleInfo = (ArticleInfo)localIterator1.next();
      Iterator localIterator2 = ((ConcurrentMap)localObject1).entrySet().iterator();
      paramList = null;
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator2.next();
          if (((ArticleInfo)localEntry.getValue()).mNewPolymericInfo != null)
          {
            Iterator localIterator3 = ((ArticleInfo)localEntry.getValue()).mNewPolymericInfo.a.iterator();
            rpt localrpt;
            do
            {
              if (!localIterator3.hasNext()) {
                break;
              }
              localrpt = (rpt)localIterator3.next();
            } while (localrpt.a != localArticleInfo.mArticleID);
            paramList = (ArticleInfo)localEntry.getValue();
            paramList.mNewPolymericInfo.a.remove(localrpt);
          }
          else
          {
            label308:
            if (((ArticleInfo)localEntry.getValue()).mArticleID == localArticleInfo.mArticleID) {
              paramList = (ArticleInfo)localEntry.getValue();
            }
          }
        }
      }
    }
    for (;;)
    {
      if (paramList == null)
      {
        if (!QLog.isColorLevel()) {
          break label148;
        }
        ((StringBuilder)localObject2).append("deleteChannelArticleList connot find channelId=" + paramInt + " ArticleInfo with recommendSeq=" + localArticleInfo.mRecommendSeq + " with articleID=" + localArticleInfo.mArticleID + '\n');
        break label148;
      }
      if ((paramList.mNewPolymericInfo != null) && (((pqw.m(paramList)) && (paramList.mNewPolymericInfo.a.size() >= 3)) || ((!pqw.m(paramList)) && (paramList.mNewPolymericInfo.a.size() >= 2))))
      {
        paramList.mNewPackInfoBytes = paramList.mNewPolymericInfo.a();
        b(Integer.valueOf(paramInt), paramList);
        ((ConcurrentMap)localObject1).put(Long.valueOf(paramList.mRecommendSeq), paramList);
        this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.14(this, paramList));
        break label148;
      }
      a(Integer.valueOf(paramInt), paramList);
      ((ConcurrentMap)localObject1).remove(Long.valueOf(paramList.mRecommendSeq));
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.15(this, paramList));
      break label148;
      if (((StringBuilder)localObject2).length() <= 0) {
        break;
      }
      QLog.e("RIJArticleInfoRepo", 2, ((StringBuilder)localObject2).toString());
      return;
      break label308;
    }
  }
  
  public void b(int paramInt, ConcurrentMap<Long, ArticleInfo> paramConcurrentMap)
  {
    this.c.put(Integer.valueOf(paramInt), paramConcurrentMap);
  }
  
  public void b(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo != null) {
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new RIJArticleInfoRepo.25(this, paramArticleInfo));
    }
  }
  
  public List<Long> c(Integer paramInteger)
  {
    Object localObject1 = b(paramInteger);
    if ((localObject1 == null) || (((List)localObject1).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (ArticleInfo)((Iterator)localObject1).next();
      if ((localArrayList.contains(Long.valueOf(((ArticleInfo)localObject2).mArticleID))) || (((ArticleInfo)localObject2).mRecommendSeq == -2L) || (((ArticleInfo)localObject2).mRecommendSeq == -3L))
      {
        QLog.d("RIJArticleInfoRepo", 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + ((ArticleInfo)localObject2).mRecommendSeq + "articleID = " + ((ArticleInfo)localObject2).mArticleID + ", title =" + ((ArticleInfo)localObject2).mTitle);
        a(paramInteger, (ArticleInfo)localObject2);
      }
      else if (((ArticleInfo)localObject2).mNewPolymericInfo != null)
      {
        localObject2 = ((ArticleInfo)localObject2).mNewPolymericInfo.a;
        if (localObject2 != null)
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            localArrayList.add(Long.valueOf(((rpt)((Iterator)localObject2).next()).a));
          }
        }
      }
      else
      {
        localArrayList.add(Long.valueOf(((ArticleInfo)localObject2).mArticleID));
      }
    }
    return localArrayList;
  }
  
  public ConcurrentMap<Long, ArticleInfo> c(int paramInt)
  {
    return (ConcurrentMap)this.c.get(Integer.valueOf(paramInt));
  }
  
  public void c(int paramInt)
  {
    if (paramInt != 0)
    {
      this.c.remove(Integer.valueOf(paramInt));
      this.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qga
 * JD-Core Version:    0.7.0.1
 */