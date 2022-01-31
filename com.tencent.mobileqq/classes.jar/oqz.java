import android.os.Handler;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.VideoArticleModule.8;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseVideoArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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

public class oqz
  extends oqg
{
  public static final String a;
  private SparseArray<CopyOnWriteArrayList<WeiShiVideoArticleInfo>> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private SparseBooleanArray jdField_a_of_type_AndroidUtilSparseBooleanArray = new SparseBooleanArray();
  private LinkedHashMap<Integer, ConcurrentHashMap<Long, WeiShiVideoArticleInfo>> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private SparseArray<HashSet<Long>> b = new SparseArray();
  
  static
  {
    jdField_a_of_type_JavaLangString = oqz.class.getSimpleName();
  }
  
  public oqz(AppInterface paramAppInterface, atmp paramatmp, ExecutorService paramExecutorService, pdc parampdc, Handler paramHandler)
  {
    super(paramAppInterface, paramatmp, paramExecutorService, parampdc, paramHandler);
  }
  
  private void a(int paramInt, BaseVideoArticleInfo paramBaseVideoArticleInfo)
  {
    if (paramBaseVideoArticleInfo == null) {}
    oie localoie;
    do
    {
      do
      {
        return;
      } while ((paramInt != 40677) || (paramBaseVideoArticleInfo == null) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)));
      localoie = (oie)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(274);
    } while (localoie == null);
    long l = NetConnInfoCenter.getServerTime();
    localoie.a(rtr.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBaseVideoArticleInfo), l);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "request error, proto:" + paramToServiceMsg.getServiceCmd() + "    code:" + paramInt);
    }
  }
  
  private void a(Integer paramInteger, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo)
  {
    paramInteger = (CopyOnWriteArrayList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInteger.intValue());
    if ((paramInteger != null) && (paramInteger.contains(paramWeiShiVideoArticleInfo))) {
      paramInteger.remove(paramWeiShiVideoArticleInfo);
    }
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<WeiShiVideoArticleInfo> paramList, long paramLong1, long paramLong2)
  {
    paramBoolean2 = false;
    if (!paramBoolean1)
    {
      ohb.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      ohb.a().b(true, paramInt, null, true);
      return;
    }
    a(Integer.valueOf(paramInt), paramList, true);
    paramBoolean1 = paramBoolean2;
    if (paramList.isEmpty()) {
      paramBoolean1 = true;
    }
    paramList = b(Integer.valueOf(paramInt));
    ohb.a().b(true, paramInt, paramList, paramBoolean1);
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<WeiShiVideoArticleInfo> paramList, long paramLong1, long paramLong2, ToServiceMsg paramToServiceMsg)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoArticleModule.3(this, paramLong1, paramBoolean1, paramList, paramInt, paramBoolean2, paramLong2, paramToServiceMsg));
  }
  
  private boolean a(Integer paramInteger, WeiShiVideoArticleInfo paramWeiShiVideoArticleInfo, boolean paramBoolean)
  {
    int j = 0;
    if (paramWeiShiVideoArticleInfo == null) {
      return false;
    }
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if (localConcurrentHashMap == null)
    {
      localConcurrentHashMap = new ConcurrentHashMap();
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramInteger, localConcurrentHashMap);
    }
    for (;;)
    {
      int i;
      if (localConcurrentHashMap.get(Long.valueOf(paramWeiShiVideoArticleInfo.recommendSeq)) != null)
      {
        if (!QLog.isColorLevel()) {
          break label448;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "saveArticleInfo, article seq duplicated, article channelID=" + paramInteger + ", articleID=" + paramWeiShiVideoArticleInfo.articleID + "，seq=" + paramWeiShiVideoArticleInfo.recommendSeq + ", toDb=" + paramBoolean + "，isDupSeq =" + true);
        i = 1;
      }
      for (;;)
      {
        if ((j != 0) || (i != 0)) {
          a(paramInteger, paramWeiShiVideoArticleInfo);
        }
        return true;
        HashSet localHashSet2 = (HashSet)this.b.get(paramInteger.intValue());
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.b.put(paramInteger.intValue(), localHashSet1);
        }
        if (!localHashSet1.contains(Long.valueOf(paramWeiShiVideoArticleInfo.articleID)))
        {
          localHashSet1.add(Long.valueOf(paramWeiShiVideoArticleInfo.articleID));
          i = 0;
          label235:
          if (i == 0) {
            break label405;
          }
          a(paramWeiShiVideoArticleInfo);
        }
        for (;;)
        {
          if (paramBoolean)
          {
            if ((this.jdField_a_of_type_JavaUtilConcurrentExecutorService != null) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isShutdown()) && (!this.jdField_a_of_type_JavaUtilConcurrentExecutorService.isTerminated()))
            {
              this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new VideoArticleModule.4(this, paramWeiShiVideoArticleInfo));
              k = 0;
              j = i;
              i = k;
              break;
              this.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(paramInteger.intValue(), true);
              if (QLog.isColorLevel()) {
                QLog.e(jdField_a_of_type_JavaLangString, 2, "saveArticleInfo, article articleID duplicated, article channelID=" + paramInteger + ", articleID=" + paramWeiShiVideoArticleInfo.articleID + "，seq=" + paramWeiShiVideoArticleInfo.recommendSeq + ", toDb=" + paramBoolean + "，isDupSeq =" + false);
              }
              i = 1;
              break label235;
              label405:
              localConcurrentHashMap.put(Long.valueOf(paramWeiShiVideoArticleInfo.recommendSeq), paramWeiShiVideoArticleInfo);
              continue;
            }
            ThreadManager.executeOnSubThread(new VideoArticleModule.5(this, paramWeiShiVideoArticleInfo));
          }
        }
        int k = 0;
        j = i;
        i = k;
        continue;
        label448:
        i = 1;
      }
    }
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
      if (!localHashSet1.add(Long.valueOf(localWeiShiVideoArticleInfo.articleID))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList articleID duplicated, channelID = " + paramInt1 + ", seq = " + localWeiShiVideoArticleInfo.recommendSeq + "articleID = " + localWeiShiVideoArticleInfo.articleID);
      } else if (!localHashSet2.add(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList articleRecommendSeq duplicated, channelID = " + paramInt1 + ", seq = " + localWeiShiVideoArticleInfo.recommendSeq + "articleID = " + localWeiShiVideoArticleInfo.articleID);
      } else {
        localArrayList.add(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq));
      }
    }
    return localArrayList;
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    oidb_cmd0xbed.RspBody localRspBody = new oidb_cmd0xbed.RspBody();
    int j = pde.a(paramFromServiceMsg, paramObject, localRspBody);
    int i = ((Integer)paramToServiceMsg.getAttribute("channelID")).intValue();
    long l1 = ((Long)paramToServiceMsg.getAttribute(d)).longValue();
    long l2 = ((Long)paramToServiceMsg.getAttribute(e)).longValue();
    int k = ((Integer)paramToServiceMsg.getAttribute("CountOfRequest_0xbed")).intValue();
    paramFromServiceMsg = null;
    label175:
    boolean bool1;
    if (j == 0)
    {
      if ((localRspBody.rspChannelArticle == null) || (!localRspBody.rspChannelArticle.has()) || (localRspBody.rspChannelArticle.get() == null)) {
        break label417;
      }
      if (!localRspBody.rspChannelArticle.uint32_channel_id.has()) {
        break label414;
      }
      i = localRspBody.rspChannelArticle.uint32_channel_id.get();
      if (!localRspBody.rspChannelArticle.uint32_channel_type.has()) {
        break label408;
      }
      j = localRspBody.rspChannelArticle.uint32_channel_type.get();
      bool1 = bool3;
      if (localRspBody.rspChannelArticle.uint32_is_no_more_data.has())
      {
        bool1 = bool3;
        if (localRspBody.rspChannelArticle.uint32_is_no_more_data.get() == 1) {
          bool1 = true;
        }
      }
      if ((!localRspBody.rspChannelArticle.rpt_article_list.has()) || (localRspBody.rspChannelArticle.rpt_article_list.get() == null)) {
        break label402;
      }
      paramFromServiceMsg = qij.a(localRspBody.rspChannelArticle.rpt_article_list.get(), i, j);
      bool2 = true;
    }
    for (;;)
    {
      a(bool2, i, bool1, paramFromServiceMsg, l1, l2, paramToServiceMsg);
      return;
      if ((j == 154) && (k == 1))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handle0xbedGetWeiShiVideoArticleInfoList re-request:" + j + " channelID=" + i + " beginSeq=" + l1 + " endSeq=" + l2);
        }
        paramToServiceMsg.getAttributes().put("CountOfRequest_0xbed", Integer.valueOf(2));
        a(paramToServiceMsg);
        bool1 = false;
      }
      else
      {
        a(paramToServiceMsg, j);
        bool1 = false;
        continue;
        label402:
        bool2 = true;
        continue;
        label408:
        j = 0;
        break label175;
        label414:
        break;
        label417:
        bool1 = false;
        bool2 = true;
      }
    }
  }
  
  private void b(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<WeiShiVideoArticleInfo> paramList, long paramLong1, long paramLong2, ToServiceMsg paramToServiceMsg)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
      if (paramBoolean1)
      {
        if ((paramList != null) && (!paramList.isEmpty())) {
          a(paramInt, (BaseVideoArticleInfo)paramList.get(0));
        }
        if (!paramBoolean2) {
          break label120;
        }
        a(Integer.valueOf(paramInt), paramList, true);
      }
    }
    for (;;)
    {
      paramList = b(Integer.valueOf(paramInt));
      ohb.a().a(paramBoolean1, paramInt, paramList, paramBoolean2);
      return;
      paramToServiceMsg = new CopyOnWriteArrayList(paramList);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramToServiceMsg);
      break;
      label120:
      if ((paramList != null) && (!paramList.isEmpty())) {
        a(Integer.valueOf(paramInt), paramList, true);
      }
    }
  }
  
  List<WeiShiVideoArticleInfo> a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    String str;
    ArrayList localArrayList;
    if (paramBoolean)
    {
      str = "channelID = ? and recommendSeq < ?";
      localArrayList = new ArrayList();
      localObject = this.jdField_a_of_type_Atmp.a(WeiShiVideoArticleInfo.class, true, str, new String[] { String.valueOf(paramInt1), String.valueOf(paramLong) }, null, null, "recommendSeq desc", String.valueOf(paramInt2));
      if (localObject != null) {
        localArrayList.addAll((Collection)localObject);
      }
      if (!localArrayList.isEmpty()) {
        break label160;
      }
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList mEntityManager.query return empty,with selection=" + str + "channelId=" + paramInt1 + " recommendSeq=" + paramLong + " count=" + paramInt2);
      }
    }
    label160:
    while (!QLog.isColorLevel())
    {
      return localArrayList;
      str = "channelID = ? and recommendSeq > ?";
      break;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, "loadChannelArticleSeqList mEntityManager.query size: " + ((List)localObject).size() + "with selection=" + str + "channelId=" + paramInt1 + " recommendSeq=" + paramLong + " count=" + paramInt2);
    Object localObject = new StringBuilder("\n");
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      Iterator localIterator = localArrayList.iterator();
      paramInt2 = 0;
      if (localIterator.hasNext())
      {
        WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder().append("article【").append(paramInt2).append("】 id : ").append(localWeiShiVideoArticleInfo.articleID).append(" seq : ").append(localWeiShiVideoArticleInfo.recommendSeq).append(" title : ").append(obz.c(localWeiShiVideoArticleInfo.title)).append(" rowkey : ").append(localWeiShiVideoArticleInfo.rowkey).append(" isUgc : ").append(localWeiShiVideoArticleInfo.isUgc).append(" vid : ");
        if (localWeiShiVideoArticleInfo.videoData == null) {}
        for (str = "";; str = localWeiShiVideoArticleInfo.videoData.jdField_a_of_type_JavaLangString)
        {
          ((StringBuilder)localObject).append(str + " feedsType : " + localWeiShiVideoArticleInfo.feedsType + " \n");
          paramInt2 += 1;
          break;
        }
      }
    }
    QLog.i(jdField_a_of_type_JavaLangString, 2, "loadFromDb return article list: channelId=" + paramInt1 + ", " + ((StringBuilder)localObject).toString());
    return localArrayList;
  }
  
  public List<WeiShiVideoArticleInfo> a(Integer paramInteger)
  {
    paramInteger = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramInteger);
    if ((paramInteger == null) || (paramInteger.size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramInteger.size());
    Iterator localIterator = paramInteger.keySet().iterator();
    while (localIterator.hasNext()) {
      localArrayList.add((WeiShiVideoArticleInfo)paramInteger.get((Long)localIterator.next()));
    }
    Collections.sort(localArrayList, new ora(this));
    return localArrayList;
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "deleteChannelOutdatedArticle, channelID:" + paramInt1 + "    outdatedTime:" + paramLong + "   feedsReservedCnt:" + paramInt2);
    }
    Object localObject2 = (ConcurrentHashMap)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new ArrayList(((ConcurrentHashMap)localObject2).size());
    Iterator localIterator = ((ConcurrentHashMap)localObject2).values().iterator();
    WeiShiVideoArticleInfo localWeiShiVideoArticleInfo;
    while (localIterator.hasNext())
    {
      localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)localIterator.next();
      if (localWeiShiVideoArticleInfo.recommendTime < paramLong) {
        ((ArrayList)localObject1).add(localWeiShiVideoArticleInfo);
      }
    }
    int j = ((ConcurrentHashMap)localObject2).size() - ((ArrayList)localObject1).size();
    if (j < paramInt2)
    {
      Collections.sort((List)localObject1, new orb(this));
      int i = 0;
      for (;;)
      {
        if (i >= paramInt2 - j) {
          break label215;
        }
        if (((ArrayList)localObject1).size() <= 0) {
          break;
        }
        ((ArrayList)localObject1).remove(0);
        i += 1;
      }
    }
    label215:
    localIterator = ((ArrayList)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)localIterator.next();
      ((ConcurrentHashMap)localObject2).remove(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq));
      a(Integer.valueOf(paramInt1), localWeiShiVideoArticleInfo);
    }
    localObject2 = b(Integer.valueOf(paramInt1));
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoArticleModule.8(this, paramInt1, (List)localObject2));
    localObject2 = jdField_a_of_type_JavaLangString;
    localObject1 = new StringBuilder().append("delete outdated article cache , cnt ").append(((ArrayList)localObject1).size()).append(", reservedCnt : ");
    if (j < paramInt2) {}
    for (;;)
    {
      QLog.e((String)localObject2, 2, paramInt2);
      return;
      paramInt2 = j;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.getServiceCmd().equals("OidbSvc.0xbed")) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
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
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    HashSet localHashSet = new HashSet();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)((Iterator)localObject).next();
      if (!localHashSet.add(Long.valueOf(localWeiShiVideoArticleInfo.articleID))) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getChannelArticleSeqList 有重复文章， channelID = " + paramInteger + ", seq = " + localWeiShiVideoArticleInfo.recommendSeq + "，articleID = " + localWeiShiVideoArticleInfo.articleID);
      } else {
        localArrayList.add(Long.valueOf(localWeiShiVideoArticleInfo.recommendSeq));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqz
 * JD-Core Version:    0.7.0.1
 */