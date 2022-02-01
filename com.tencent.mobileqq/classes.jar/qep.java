import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuCommentInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VisibleSetParam;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectmember.ResultRecord;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troop.data.TroopBarPOI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;

public class qep
  extends qhj
{
  private static volatile int jdField_a_of_type_Int = -1;
  private static boolean jdField_a_of_type_Boolean;
  private static volatile boolean b;
  private qeq jdField_a_of_type_Qeq;
  private qga jdField_a_of_type_Qga;
  private qij jdField_a_of_type_Qij;
  private qik jdField_a_of_type_Qik;
  private qim jdField_a_of_type_Qim;
  private qin jdField_a_of_type_Qin;
  private qio jdField_a_of_type_Qio;
  private qip jdField_a_of_type_Qip;
  private qiq jdField_a_of_type_Qiq;
  private qir jdField_a_of_type_Qir;
  private qis jdField_a_of_type_Qis;
  private qit jdField_a_of_type_Qit;
  private qiu jdField_a_of_type_Qiu;
  private qiv jdField_a_of_type_Qiv;
  private qiw jdField_a_of_type_Qiw;
  private qix jdField_a_of_type_Qix;
  private qiy jdField_a_of_type_Qiy;
  private qiz jdField_a_of_type_Qiz;
  private qja jdField_a_of_type_Qja;
  private qjb jdField_a_of_type_Qjb;
  private qjc jdField_a_of_type_Qjc;
  private qjd jdField_a_of_type_Qjd;
  private qjf jdField_a_of_type_Qjf;
  
  public qep(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqxn, paramHandler);
    h();
  }
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static void a()
  {
    jdField_a_of_type_Int = -1;
  }
  
  private void a(List<ArticleInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (ArticleInfo)paramList.next();
        if ((((ArticleInfo)localObject).mSocialFeedInfo != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrl != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrl.a != null) && (((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrl.a.size() > 0))
        {
          localObject = ((ArticleInfo)localObject).mSocialFeedInfo.jdField_a_of_type_Rrl.a.iterator();
          while (((Iterator)localObject).hasNext())
          {
            rrn localrrn = ((rrm)((Iterator)localObject).next()).a;
            if ((localrrn != null) && (!TextUtils.isEmpty(localrrn.e)))
            {
              sxc localsxc = swx.a(localrrn.e);
              if ((localsxc == null) || (!localsxc.a(System.currentTimeMillis() / 1000L, 3600L))) {
                localArrayList.add(localrrn.e);
              }
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      qck.a().a((String[])localArrayList.toArray(new String[localArrayList.size()]), null);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList, long paramLong1, long paramLong2)
  {
    List localList1 = null;
    if (!paramBoolean1)
    {
      pvm.a().b(false, paramInt, null, false);
      return;
    }
    if (paramList == null)
    {
      pvm.a().b(true, paramInt, null, true);
      return;
    }
    List localList2 = this.jdField_a_of_type_Qga.b(Integer.valueOf(paramInt));
    if (this.jdField_a_of_type_Qeq != null) {
      localList1 = this.jdField_a_of_type_Qeq.a(paramInt, localList2, paramList);
    }
    if ((localList1 != null) && (!localList1.isEmpty())) {
      this.jdField_a_of_type_Qga.a(Integer.valueOf(paramInt), localList1, true);
    }
    this.jdField_a_of_type_Qga.a(Integer.valueOf(paramInt), paramList, true);
    paramBoolean1 = paramList.isEmpty();
    if (paramInt == 70) {
      if ((paramBoolean1) || (paramBoolean2)) {
        paramBoolean1 = true;
      }
    }
    for (;;)
    {
      localList1 = this.jdField_a_of_type_Qga.a(Integer.valueOf(paramInt));
      if ((paramInt == 70) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && (paramBoolean1)) {
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(localList1.size());
      }
      if (paramInt == 0) {
        uvs.a(paramList, localList1, false);
      }
      for (;;)
      {
        pvm.a().b(true, paramInt, localList1, paramBoolean1);
        return;
        paramBoolean1 = false;
        break;
        if (plm.c(paramInt)) {
          pin.a(paramList, localList1, false);
        }
      }
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static void b(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  private void b(owh paramowh)
  {
    if (paramowh == null) {
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | biuInfo is null!");
    }
    ArticleInfo localArticleInfo;
    Object localObject1;
    Object localObject2;
    do
    {
      return;
      if (paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
      {
        QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | originArticleInfo is null!");
        return;
      }
      long l1 = paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedId;
      long l2 = paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mFeedType;
      localArticleInfo = paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
      localArticleInfo.mCardJumpUrl = paramowh.e;
      localArticleInfo.commentBtnJumpUrl = paramowh.c;
      localArticleInfo.commentShareUrl = paramowh.d;
      localArticleInfo.isCardJumpUrlAvailable = paramowh.b;
      localArticleInfo.mProteusTemplateBean = null;
      localArticleInfo.mAbandonRepeatFlag = 1;
      localArticleInfo.mFeedType = 36;
      localObject1 = localArticleInfo.mSocialFeedInfo;
      localArticleInfo.mSocialFeedInfo = new SocializeFeedsInfo();
      if (localObject1 != null)
      {
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Rqy.jdField_a_of_type_Int;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrl = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Rrl;
        localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rrq = ((SocializeFeedsInfo)localObject1).jdField_a_of_type_Rrq;
      }
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.jdField_a_of_type_Long = pkh.a();
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqy.c = 1;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw = new rqw();
      localArticleInfo.mFeedId = paramowh.jdField_a_of_type_Long;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long = paramowh.jdField_a_of_type_Long;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.b = Long.valueOf(l2);
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaLangLong = Long.valueOf(l1);
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject1 = new SocializeFeedsInfo.BiuCommentInfo();
      localObject2 = new String(bhcu.decode(paramowh.jdField_a_of_type_JavaLangString, 0));
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mBiuComment = bcsc.b((String)localObject2);
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mUin = Long.valueOf(pkh.a());
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mFeedId = Long.valueOf(paramowh.jdField_a_of_type_Long);
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mBiuTime = 0;
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mOrigBiuComment = ((String)localObject2);
      ((SocializeFeedsInfo.BiuCommentInfo)localObject1).mFeedsType = 36;
      localArticleInfo.mSocialFeedInfo.jdField_a_of_type_Rqw.jdField_a_of_type_JavaUtilList.add(localObject1);
      localArticleInfo.articleViewModel = ttb.a(localArticleInfo);
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | newArticleInfo:" + localArticleInfo);
      paramowh = a().c(0);
      localObject1 = new ArrayList();
    } while (paramowh == null);
    if (paramowh.containsKey(Long.valueOf(localArticleInfo.mRecommendSeq)))
    {
      paramowh.put(Long.valueOf(localArticleInfo.mRecommendSeq), localArticleInfo);
      this.jdField_a_of_type_Qga.b(0, paramowh);
    }
    for (int i = 1;; i = 0)
    {
      localObject2 = paramowh.values().iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((List)localObject1).add((ArticleInfo)((Iterator)localObject2).next());
      }
      if (i == 0) {
        break;
      }
      this.jdField_a_of_type_Qga.a(Integer.valueOf(0), (List)localObject1, true);
      localObject1 = this.jdField_a_of_type_Qga.a(Integer.valueOf(0));
      pvm.a().b(0, (List)localObject1);
      QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | update DB , cached biuCardArticleInfo: " + paramowh.get(Long.valueOf(localArticleInfo.mRecommendSeq)));
      return;
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static boolean b()
  {
    return b;
  }
  
  private void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.1(this, paramInt));
  }
  
  private void h()
  {
    this.jdField_a_of_type_Qga = new qga(this.jdField_a_of_type_JavaUtilConcurrentExecutorService, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_AndroidOsHandler, this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    i();
  }
  
  private void i()
  {
    this.jdField_a_of_type_Qja = new qja(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qix = new qix(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qjb = new qjb(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qiw = new qiw(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qir = new qir(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qiz = new qiz(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qjd = new qjd(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qiy = new qiy(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qiv = new qiv(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qjc = new qjc(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qjf = new qjf(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qis = new qis(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qiu = new qiu(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qin = new qin(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qij = new qij(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qio = new qio(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qim = new qim(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qik = new qik(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qiq = new qiq(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qip = new qip(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
    this.jdField_a_of_type_Qit = new qit(this, this.jdField_a_of_type_AndroidOsHandler, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager, this.jdField_a_of_type_Qxn, this.jdField_a_of_type_JavaUtilConcurrentExecutorService);
  }
  
  @NonNull
  public qga a()
  {
    return this.jdField_a_of_type_Qga;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Qjc.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Qiu.a(paramLong, paramInt);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Qiw.a(paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, HashMap<Long, Long> paramHashMap, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_Qit.a(paramLong1, paramLong2, paramInt1, paramHashMap, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public void a(long paramLong1, long paramLong2, rqw paramrqw, long paramLong3, String paramString1, long paramLong4, long paramLong5, int paramInt1, String paramString2, int paramInt2, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qin.a(paramLong1, paramLong2, paramrqw, paramLong3, paramString1, paramLong4, paramLong5, paramInt1, paramString2, paramInt2, paramArticleInfo, paramBoolean);
  }
  
  public void a(long paramLong1, long paramLong2, rqw paramrqw, String paramString)
  {
    this.jdField_a_of_type_Qja.a(paramLong1, paramLong2, paramrqw, paramString);
  }
  
  public void a(long paramLong1, long paramLong2, boolean paramBoolean, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Qip.a(paramLong1, paramLong2, paramBoolean, paramArticleInfo);
  }
  
  public void a(long paramLong, String paramString1, int paramInt, String paramString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qij.a(paramLong, paramString1, paramInt, paramString2, paramArrayList, paramBoolean);
  }
  
  public void a(long paramLong, List<roz> paramList)
  {
    this.jdField_a_of_type_Qis.a(paramLong, paramList);
  }
  
  public void a(long paramLong, boolean paramBoolean, FastWebArticleInfo paramFastWebArticleInfo)
  {
    this.jdField_a_of_type_Qiq.a(paramLong, paramBoolean, paramFastWebArticleInfo);
  }
  
  public void a(ArticleInfo paramArticleInfo, String paramString)
  {
    this.jdField_a_of_type_Qik.a(paramArticleInfo, paramString);
  }
  
  public void a(TopicInfo paramTopicInfo)
  {
    this.jdField_a_of_type_Qir.a(paramTopicInfo);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x68b")) {
      this.jdField_a_of_type_Qit.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbf7"))
      {
        QLog.d("ArticleInfoModule", 1, "onReceive 0xbf7");
        this.jdField_a_of_type_Qit.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xcba"))
      {
        QLog.d("ArticleInfoModule", 1, "onReceive 0xcba");
        this.jdField_a_of_type_Qit.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x83e"))
      {
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_Qin.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("biu_deliver", Integer.valueOf(0)).equals(Integer.valueOf(2)))
        {
          this.jdField_a_of_type_Qij.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("ugc_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_Qio.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("up_master_deliver", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_Qim.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("submit_comment", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_Qik.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (paramToServiceMsg.getAttribute("0x83e_upvote_fast_web_article", Integer.valueOf(0)).equals(Integer.valueOf(1)))
        {
          this.jdField_a_of_type_Qiq.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        this.jdField_a_of_type_Qip.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x46f"))
      {
        this.jdField_a_of_type_Qis.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x75e"))
      {
        this.jdField_a_of_type_Qiu.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0x8c8"))
      {
        this.jdField_a_of_type_Qjf.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xb83"))
      {
        this.jdField_a_of_type_Qjc.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbbd"))
      {
        this.jdField_a_of_type_Qiv.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd4_1"))
      {
        this.jdField_a_of_type_Qiy.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbde"))
      {
        this.jdField_a_of_type_Qjd.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xbd6_1"))
      {
        this.jdField_a_of_type_Qiz.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc16"))
      {
        this.jdField_a_of_type_Qir.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc32"))
      {
        this.jdField_a_of_type_Qiw.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xa6e"))
      {
        this.jdField_a_of_type_Qjb.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc6d"))
      {
        this.jdField_a_of_type_Qix.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramFromServiceMsg.getServiceCmd().equals("OidbSvc.0xc5b_2"));
    this.jdField_a_of_type_Qja.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_Qix.a(paramString);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, paramInt2, false);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.jdField_a_of_type_Qjf.a(paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, Bundle paramBundle, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam)
  {
    this.jdField_a_of_type_Qim.a(paramString1, paramString2, paramBundle, paramArrayList, paramBoolean1, paramBoolean2, paramTroopBarPOI, paramVisibleSetParam);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String paramString5, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, rqt paramrqt, TroopBarPOI paramTroopBarPOI, VisibleSetParam paramVisibleSetParam, int paramInt3)
  {
    this.jdField_a_of_type_Qio.a(paramString1, paramString2, paramString3, paramList, paramString4, paramString5, paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramrqt, paramTroopBarPOI, paramVisibleSetParam, paramInt3);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, List<Integer> paramList, String paramString4, String[] paramArrayOfString1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, String[] paramArrayOfString2, ArrayList<SocializeFeedsInfo.BiuCommentInfo> paramArrayList, boolean paramBoolean, int paramInt1, int paramInt2, rqt paramrqt, int paramInt3)
  {
    a(paramString1, paramString2, paramString3, paramList, paramString4, "", paramArrayOfString1, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfString2, paramArrayList, paramBoolean, paramInt1, paramInt2, paramrqt, null, VisibleSetParam.a, paramInt3);
  }
  
  public void a(ArrayList<ResultRecord> paramArrayList, int paramInt, long paramLong, String paramString)
  {
    this.jdField_a_of_type_Qiy.a(paramArrayList, paramInt, paramLong, paramString);
  }
  
  public void a(owh paramowh)
  {
    if (paramowh == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | biuInfo is null!");
      return;
    }
    if (paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null)
    {
      QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | originArticleInfo is null!");
      return;
    }
    boolean bool2 = paramowh.jdField_a_of_type_Boolean;
    boolean bool1 = bool2;
    Object localObject;
    if (!paramowh.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_Qga.c(0);
      bool1 = bool2;
      if (localObject != null) {
        if (!((ConcurrentMap)localObject).containsKey(Long.valueOf(paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRecommendSeq))) {
          break label326;
        }
      }
    }
    label326:
    for (bool1 = true;; bool1 = bool2)
    {
      if (!bool1)
      {
        localObject = ((ConcurrentMap)localObject).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          ArticleInfo localArticleInfo = (ArticleInfo)((Iterator)localObject).next();
          if ((localArticleInfo != null) && ((localArticleInfo.mArticleID == paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID) || ((!TextUtils.isEmpty(localArticleInfo.innerUniqueID)) && (localArticleInfo.innerUniqueID.equalsIgnoreCase(paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID)))))
          {
            paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        if ((paramowh != null) && (paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null))
        {
          paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.invalidateProteusTemplateBean();
          paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.showBreathAnimation = true;
        }
        QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | fromRecommendFeeds:" + bool1);
        if (bool1) {
          if ((paramowh != null) && (owf.a(paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)))
          {
            paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.commentSrc = paramowh.jdField_a_of_type_Int;
            b(paramowh);
          }
        }
        for (;;)
        {
          owf.a().c();
          QLog.d("ArticleInfoModule", 2, "transformNewBiuCard | clearBiuInfo");
          return;
          QLog.d("ArticleInfoModule", 2, "transformNormalToNewBiuCard | invalid card type");
          continue;
          pvj.a().a(paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID, paramowh.jdField_a_of_type_Long, paramowh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.innerUniqueID);
        }
      }
    }
  }
  
  public void a(qeq paramqeq)
  {
    this.jdField_a_of_type_Qeq = paramqeq;
  }
  
  public void a(qxs paramqxs)
  {
    this.jdField_a_of_type_Qit.a(paramqxs);
  }
  
  public void a(rpb paramrpb, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_Qiv.a(paramrpb, paramArticleInfo);
  }
  
  public void a(boolean paramBoolean, int paramInt, List<Long> paramList, List<ArticleInfo> paramList1)
  {
    a(paramBoolean, paramInt, paramList, paramList1, true);
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, List<ArticleInfo> paramList1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.2(this, paramBoolean1, paramList, paramList1, paramInt, paramBoolean2));
  }
  
  public void a(boolean paramBoolean1, int paramInt, boolean paramBoolean2, List<ArticleInfo> paramList1, long paramLong1, long paramLong2, List<ArticleInfo> paramList2, byte[] paramArrayOfByte, ToServiceMsg paramToServiceMsg)
  {
    qyx.a(paramList1);
    pje.a.a(paramList1, paramInt);
    this.jdField_a_of_type_AndroidOsHandler.post(new ArticleInfoModule.3(this, paramLong1, paramInt, paramArrayOfByte, paramBoolean1, paramList1, paramBoolean2, paramLong2, paramList2, paramToServiceMsg));
  }
  
  public boolean a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7)
  {
    return this.jdField_a_of_type_Qit.a(paramInt1, paramInt2, paramLong, paramBoolean, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7);
  }
  
  public boolean a(Long paramLong)
  {
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Qga.a();
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Qjc.a(paramString);
  }
  
  public void c() {}
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Qjd.a(paramString);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
      return;
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {}
    while (((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!QLog.isColorLevel())) {
      return;
    }
    QLog.d("ArticleInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
  }
  
  public void f() {}
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      return;
    }
    c(((KandianMergeManager)((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a(0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qep
 * JD-Core Version:    0.7.0.1
 */