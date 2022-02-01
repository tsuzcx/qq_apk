package com.tencent.mobileqq.kandian.repo.video;

import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.RIJWeiShiLegacyUtils;
import com.tencent.mobileqq.kandian.repo.common.IFindRemovedEntity;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.video.entity.BaseVideoArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoData;
import com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
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
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.RspBody;
import tencent.im.oidb.cmd0xbed.oidb_cmd0xbed.RspChannelArticle;

public class VideoArticleModule
  extends ReadInJoyEngineModule
{
  public static final String a = "VideoArticleModule";
  private SparseArray<CopyOnWriteArrayList<WeiShiVideoArticleInfo>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private IFindRemovedEntity<WeiShiVideoArticleInfo> jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity = new VideoArticleModule.1(this);
  private LinkedHashMap<Integer, ConcurrentHashMap<Long, WeiShiVideoArticleInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private SparseArray<HashSet<Long>> b = new SparseArray();
  
  public VideoArticleModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
    registerEntityFinder(WeiShiVideoArticleInfo.class, this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonIFindRemovedEntity);
  }
  
  private void a(int paramInt, BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (paramBaseVideoArticleInfo == null) {
      return;
    }
    if ((paramInt == 40677) && (this.mApp != null) && ((this.mApp instanceof QQAppInterface)))
    {
      long l = NetConnInfoCenter.getServerTime();
      RIJWeiShiLegacyUtils.a.a(RIJWeiShiLegacyUtils.a(paramBaseVideoArticleInfo), l);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request error, proto:");
      localStringBuilder.append(paramToServiceMsg.getServiceCmd());
      localStringBuilder.append("    code:");
      localStringBuilder.append(paramInt);
      QLog.e(str, 2, localStringBuilder.toString());
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xbed.RspBody localRspBody = new oidb_cmd0xbed.RspBody();
    int k = ReadInJoyOidbHelper.a(paramFromServiceMsg, paramObject, localRspBody);
    int i = ((Integer)paramToServiceMsg.getAttribute("channelID")).intValue();
    int j = i;
    long l1 = ((Long)paramToServiceMsg.getAttribute("BeginSeq")).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute("EndSeq")).longValue();
    int m = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0xbed")).intValue();
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool2 = false;
    if (k == 0) {
      if ((localRspBody.rspChannelArticle != null) && (localRspBody.rspChannelArticle.has()) && (localRspBody.rspChannelArticle.get() != null))
      {
        i = j;
        if (localRspBody.rspChannelArticle.uint32_channel_id.has()) {
          i = localRspBody.rspChannelArticle.uint32_channel_id.get();
        }
        if (localRspBody.rspChannelArticle.uint32_channel_type.has()) {
          j = localRspBody.rspChannelArticle.uint32_channel_type.get();
        } else {
          j = 0;
        }
        bool1 = bool2;
        if (localRspBody.rspChannelArticle.uint32_is_no_more_data.has())
        {
          bool1 = bool2;
          if (localRspBody.rspChannelArticle.uint32_is_no_more_data.get() == 1) {
            bool1 = true;
          }
        }
        if ((localRspBody.rspChannelArticle.rpt_article_list.has()) && (localRspBody.rspChannelArticle.rpt_article_list.get() != null)) {
          paramFromServiceMsg = VideoProtoHelper.a(localRspBody.rspChannelArticle.rpt_article_list.get(), i, j);
        } else {
          paramFromServiceMsg = null;
        }
        bool2 = bool1;
        bool1 = bool3;
        break label429;
      }
    }
    for (;;)
    {
      paramFromServiceMsg = null;
      bool2 = false;
      break;
      if ((k == 154) && (m == 1))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = jdField_a_of_type_JavaLangString;
          paramObject = new StringBuilder();
          paramObject.append("handle0xbedGetWeiShiVideoArticleInfoList re-request:");
          paramObject.append(k);
          paramObject.append(" channelID=");
          paramObject.append(j);
          paramObject.append(" beginSeq=");
          paramObject.append(l1);
          paramObject.append(" endSeq=");
          paramObject.append(l2);
          QLog.d(paramFromServiceMsg, 2, paramObject.toString());
        }
        paramToServiceMsg.getAttributes().put("CountOfRequest_0xbed", Integer.valueOf(2));
        sendPbReq(paramToServiceMsg);
      }
      else
      {
        a(paramToServiceMsg, k);
      }
      bool1 = false;
    }
    label429:
    a(bool1, i, bool2, paramFromServiceMsg, l1, l2, paramToServiceMsg);
  }
  
  private void a(Integer paramInteger, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInteger.intValue());
    if (paramInteger != null) {
      paramInteger.remove(paramWeiShiVideoArticleInfo);
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<WeiShiVideoArticleInfo> paramList, long paramLong1, long paramLong2)
  {
    if (!paramBoolean1)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, null, true);
      return;
    }
    a(Integer.valueOf(paramInt), paramList, true);
    paramBoolean1 = paramList.isEmpty();
    paramList = b(Integer.valueOf(paramInt));
    ReadInJoyLogicEngineEventDispatcher.a().b(true, paramInt, paramList, paramBoolean1);
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<WeiShiVideoArticleInfo> paramList, long paramLong1, long paramLong2, ToServiceMsg paramToServiceMsg)
  {
    this.mMainThreadHandler.post(new VideoArticleModule.4(this, paramLong1, paramBoolean1, paramList, paramInt, paramBoolean2, paramLong2, paramToServiceMsg));
  }
  
  private boolean a(Integer paramInteger, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo, boolean paramBoolean)
  {
    int i = 0;
    if (paramWeiShiVideoArticleInfo == null) {
      return false;
    }
    Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramInteger, localObject1);
    }
    int j;
    if (((ConcurrentHashMap)localObject1).get(Long.valueOf(paramWeiShiVideoArticleInfo.recommendSeq)) != null)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("saveArticleInfo, article seq duplicated, article channelID=");
        ((StringBuilder)localObject2).append(paramInteger);
        ((StringBuilder)localObject2).append(", articleID=");
        ((StringBuilder)localObject2).append(paramWeiShiVideoArticleInfo.articleID);
        ((StringBuilder)localObject2).append("，seq=");
        ((StringBuilder)localObject2).append(paramWeiShiVideoArticleInfo.recommendSeq);
        ((StringBuilder)localObject2).append(", toDb=");
        ((StringBuilder)localObject2).append(paramBoolean);
        ((StringBuilder)localObject2).append("，isDupSeq =");
        ((StringBuilder)localObject2).append(true);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      j = 1;
    }
    else
    {
      Object localObject3 = (HashSet)this.b.get(paramInteger.intValue());
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new HashSet();
        this.b.put(paramInteger.intValue(), localObject2);
      }
      if (!((HashSet)localObject2).contains(Long.valueOf(paramWeiShiVideoArticleInfo.articleID)))
      {
        ((HashSet)localObject2).add(Long.valueOf(paramWeiShiVideoArticleInfo.articleID));
        i = 0;
      }
      else
      {
        this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInteger.intValue(), true);
        if (QLog.isColorLevel())
        {
          localObject2 = jdField_a_of_type_JavaLangString;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("saveArticleInfo, article articleID duplicated, article channelID=");
          ((StringBuilder)localObject3).append(paramInteger);
          ((StringBuilder)localObject3).append(", articleID=");
          ((StringBuilder)localObject3).append(paramWeiShiVideoArticleInfo.articleID);
          ((StringBuilder)localObject3).append("，seq=");
          ((StringBuilder)localObject3).append(paramWeiShiVideoArticleInfo.recommendSeq);
          ((StringBuilder)localObject3).append(", toDb=");
          ((StringBuilder)localObject3).append(paramBoolean);
          ((StringBuilder)localObject3).append("，isDupSeq =");
          ((StringBuilder)localObject3).append(false);
          QLog.e((String)localObject2, 2, ((StringBuilder)localObject3).toString());
        }
        i = 1;
      }
      if (i != 0) {
        removeEntityIfExistsInDB(paramWeiShiVideoArticleInfo);
      } else {
        ((ConcurrentHashMap)localObject1).put(Long.valueOf(paramWeiShiVideoArticleInfo.recommendSeq), paramWeiShiVideoArticleInfo);
      }
      if (paramBoolean) {
        if ((this.mExecutorService != null) && (!this.mExecutorService.isShutdown()) && (!this.mExecutorService.isTerminated())) {
          this.mExecutorService.execute(new VideoArticleModule.5(this, paramWeiShiVideoArticleInfo));
        } else {
          ThreadManager.executeOnSubThread(new VideoArticleModule.6(this, paramWeiShiVideoArticleInfo));
        }
      }
      j = 0;
    }
    if ((i != 0) || (j != 0)) {
      a(paramInteger, paramWeiShiVideoArticleInfo);
    }
    return true;
  }
  
  private List<Long> b(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    Object localObject = a(paramInt1, paramInt2, paramLong, paramBoolean);
    if (((List)localObject).isEmpty()) {
      return null;
    }
    a(Integer.valueOf(paramInt1), (List)localObject, false);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)((Iterator)localObject).next();
      String str;
      StringBuilder localStringBuilder;
      if (!localHashSet1.add(Long.valueOf(localWeiShiVideoArticleInfo.articleID)))
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadChannelArticleSeqList articleID duplicated, channelID = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", seq = ");
        localStringBuilder.append(localWeiShiVideoArticleInfo.recommendSeq);
        localStringBuilder.append("articleID = ");
        localStringBuilder.append(localWeiShiVideoArticleInfo.articleID);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      else if (!localHashSet2.add(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq)))
      {
        str = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = ");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", seq = ");
        localStringBuilder.append(localWeiShiVideoArticleInfo.recommendSeq);
        localStringBuilder.append("articleID = ");
        localStringBuilder.append(localWeiShiVideoArticleInfo.articleID);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      else
      {
        localArrayList.add(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq));
      }
    }
    return localArrayList;
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<WeiShiVideoArticleInfo> paramList, long paramLong1, long paramLong2, ToServiceMsg paramToServiceMsg)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramToServiceMsg = new CopyOnWriteArrayList(paramList);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramToServiceMsg);
    }
    else
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    if (paramBoolean1)
    {
      if ((paramList != null) && (!paramList.isEmpty())) {
        a(paramInt, (BaseVideoArticleInfo)paramList.get(0));
      }
      if (paramBoolean2) {
        a(Integer.valueOf(paramInt), paramList, true);
      } else if ((paramList != null) && (!paramList.isEmpty())) {
        a(Integer.valueOf(paramInt), paramList, true);
      }
    }
    paramList = b(Integer.valueOf(paramInt));
    ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean1, paramInt, paramList, paramBoolean2);
  }
  
  List<WeiShiVideoArticleInfo> a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "channelID = ? and recommendSeq < ?";
    } else {
      str = "channelID = ? and recommendSeq > ?";
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.mEntityManager.query(WeiShiVideoArticleInfo.class, true, str, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "recommendSeq desc", String.valueOf(paramInt2));
    if (localObject1 != null) {
      localArrayList.addAll((Collection)localObject1);
    }
    Object localObject2;
    if (localArrayList.isEmpty())
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadChannelArticleSeqList mEntityManager.query return empty,with selection=");
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append("channelId=");
        ((StringBuilder)localObject2).append(paramInt1);
        ((StringBuilder)localObject2).append(" recommendSeq=");
        ((StringBuilder)localObject2).append(paramLong);
        ((StringBuilder)localObject2).append(" count=");
        ((StringBuilder)localObject2).append(paramInt2);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        return localArrayList;
      }
    }
    else if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("loadChannelArticleSeqList mEntityManager.query size: ");
      ((StringBuilder)localObject3).append(((List)localObject1).size());
      ((StringBuilder)localObject3).append("with selection=");
      ((StringBuilder)localObject3).append(str);
      ((StringBuilder)localObject3).append("channelId=");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append(" recommendSeq=");
      ((StringBuilder)localObject3).append(paramLong);
      ((StringBuilder)localObject3).append(" count=");
      ((StringBuilder)localObject3).append(paramInt2);
      QLog.d((String)localObject2, 2, ((StringBuilder)localObject3).toString());
      localObject1 = new StringBuilder("\n");
      if (localArrayList.size() > 0)
      {
        localObject2 = localArrayList.iterator();
        paramInt2 = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (WeiShiVideoArticleInfo)((Iterator)localObject2).next();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("article【");
          localStringBuilder.append(paramInt2);
          localStringBuilder.append("】 id : ");
          localStringBuilder.append(((WeiShiVideoArticleInfo)localObject3).articleID);
          localStringBuilder.append(" seq : ");
          localStringBuilder.append(((WeiShiVideoArticleInfo)localObject3).recommendSeq);
          localStringBuilder.append(" title : ");
          localStringBuilder.append(ReadInJoyStringUtils.b(((WeiShiVideoArticleInfo)localObject3).title));
          localStringBuilder.append(" rowkey : ");
          localStringBuilder.append(((WeiShiVideoArticleInfo)localObject3).rowkey);
          localStringBuilder.append(" isUgc : ");
          localStringBuilder.append(((WeiShiVideoArticleInfo)localObject3).isUgc);
          localStringBuilder.append(" vid : ");
          if (((WeiShiVideoArticleInfo)localObject3).videoData == null) {
            str = "";
          } else {
            str = ((WeiShiVideoArticleInfo)localObject3).videoData.jdField_a_of_type_JavaLangString;
          }
          localStringBuilder.append(str);
          localStringBuilder.append(" feedsType : ");
          localStringBuilder.append(((WeiShiVideoArticleInfo)localObject3).feedsType);
          localStringBuilder.append(" \n");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
          paramInt2 += 1;
        }
      }
      str = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("loadFromDb return article list: channelId=");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.i(str, 2, ((StringBuilder)localObject2).toString());
    }
    return localArrayList;
  }
  
  public List<WeiShiVideoArticleInfo> a(Integer paramInteger)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if ((paramInteger != null) && (paramInteger.size() != 0))
    {
      ArrayList localArrayList = new ArrayList(paramInteger.size());
      Iterator localIterator = paramInteger.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((WeiShiVideoArticleInfo)paramInteger.get((Long)localIterator.next()));
      }
      Collections.sort(localArrayList, new VideoArticleModule.7(this));
      return localArrayList;
    }
    return null;
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("deleteChannelOutdatedArticle, channelID:");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append("    outdatedTime:");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append("   feedsReservedCnt:");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new ArrayList(((ConcurrentHashMap)localObject2).size());
    Object localObject3 = ((ConcurrentHashMap)localObject2).values().iterator();
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    while (((Iterator)localObject3).hasNext())
    {
      localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)((Iterator)localObject3).next();
      if (localWeiShiVideoArticleInfo.recommendTime < paramLong) {
        ((ArrayList)localObject1).add(localWeiShiVideoArticleInfo);
      }
    }
    int j = ((ConcurrentHashMap)localObject2).size() - ((ArrayList)localObject1).size();
    if (j < paramInt2)
    {
      Collections.sort((List)localObject1, new VideoArticleModule.8(this));
      int i = 0;
      while (i < paramInt2 - j)
      {
        if (((ArrayList)localObject1).size() <= 0) {
          return;
        }
        ((ArrayList)localObject1).remove(0);
        i += 1;
      }
    }
    localObject3 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)((Iterator)localObject3).next();
      ((ConcurrentHashMap)localObject2).remove(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq));
      a(Integer.valueOf(paramInt1), localWeiShiVideoArticleInfo);
    }
    localObject2 = b(Integer.valueOf(paramInt1));
    this.mMainThreadHandler.post(new VideoArticleModule.9(this, paramInt1, (List)localObject2));
    localObject2 = jdField_a_of_type_JavaLangString;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("delete outdated article cache , cnt ");
    ((StringBuilder)localObject3).append(((ArrayList)localObject1).size());
    ((StringBuilder)localObject3).append(", reservedCnt : ");
    paramInt1 = j;
    if (j < paramInt2) {
      paramInt1 = paramInt2;
    }
    ((StringBuilder)localObject3).append(paramInt1);
    QLog.e((String)localObject2, 2, ((StringBuilder)localObject3).toString());
  }
  
  public boolean a(Integer paramInteger, List<WeiShiVideoArticleInfo> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(paramInteger, (WeiShiVideoArticleInfo)paramList.next(), paramBoolean);
    }
    return true;
  }
  
  public List<Long> b(Integer paramInteger)
  {
    Object localObject = a(paramInteger);
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      ArrayList localArrayList = new ArrayList(((List)localObject).size());
      HashSet localHashSet = new HashSet();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)((Iterator)localObject).next();
        if (!localHashSet.add(Long.valueOf(localWeiShiVideoArticleInfo.articleID)))
        {
          String str = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getChannelArticleSeqList 有重复文章， channelID = ");
          localStringBuilder.append(paramInteger);
          localStringBuilder.append(", seq = ");
          localStringBuilder.append(localWeiShiVideoArticleInfo.recommendSeq);
          localStringBuilder.append("，articleID = ");
          localStringBuilder.append(localWeiShiVideoArticleInfo.articleID);
          QLog.d(str, 2, localStringBuilder.toString());
        }
        else
        {
          localArrayList.add(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq));
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.0xbed")) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  public void unInitialize()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.b.clear();
    this.jdField_a_of_type_AndroidUtilSparseBooleanArray.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoArticleModule
 * JD-Core Version:    0.7.0.1
 */