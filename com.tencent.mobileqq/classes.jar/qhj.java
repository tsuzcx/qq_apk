import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.question.bean.QuestionSquareBean;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.WeiShiVideoArticleInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public abstract class qhj
  implements qfn
{
  public static String b = "ReqType";
  public static String c = "NotifyType";
  public static String d = "BeginSeq";
  public static String e = "EndSeq";
  public static String f = "CountOfRequest_0x68b";
  public static String g = "CountOfRequest_0x886";
  public static String h = "repeatedReqFlag";
  public static String i = "asyncRequestChannelFlag";
  public static String j = "asyncAdRequestFlag";
  public Handler a;
  public AppInterface a;
  public EntityManager a;
  protected ExecutorService a;
  protected qxn a;
  
  public qhj(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qxn paramqxn, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_Qxn = paramqxn;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager = paramEntityManager;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, qfo paramqfo) {}
  
  public void a(Entity paramEntity)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if ((paramEntity instanceof AdvertisementInfo))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(AdvertisementInfo.class.getSimpleName()))
      {
        paramEntity = (AdvertisementInfo)paramEntity;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramEntity.mAdTraceId)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(AdvertisementInfo.class, "mAdTraceId = ?", new String[] { paramEntity.mAdTraceId });
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject1);
      }
      return;
      if ((paramEntity instanceof ArticleInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ArticleInfo.class.getSimpleName()))
        {
          localObject2 = (ArticleInfo)paramEntity;
          paramEntity = localObject3;
          if (((ArticleInfo)localObject2).mChannelID != 70L) {
            paramEntity = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mArticleID), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mRecommendSeq), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          if (paramEntity != null) {}
          for (;;)
          {
            if ((QLog.isColorLevel()) && (paramEntity != null)) {
              QLog.e("ReadInJoyEngineModule", 2, "removeEntityIfExistsInDB, article duplicated, article been channelID=" + ((ArticleInfo)localObject2).mChannelID + "articleID=" + ((ArticleInfo)localObject2).mArticleID + "recommendSeq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
            localObject1 = paramEntity;
            if (((ArticleInfo)localObject2).mChannelID != 70L) {
              break;
            }
            localObject1 = paramEntity;
            if (((ArticleInfo)localObject2).mFeedId == 0L) {
              break;
            }
            localObject2 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ArticleInfo.class, "mFeedId = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mFeedId), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
            localObject1 = paramEntity;
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.remove((Entity)localObject2);
            localObject1 = paramEntity;
            break;
            paramEntity = (Entity)localObject1;
          }
        }
      }
      else if ((paramEntity instanceof ArticleReadInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ArticleInfo.class.getSimpleName()))
        {
          paramEntity = (ArticleReadInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramEntity.mArticleID) });
        }
      }
      else if ((paramEntity instanceof ChannelInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ChannelInfo.class.getSimpleName()))
        {
          paramEntity = (ChannelInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramEntity.mChannelID) });
        }
      }
      else if ((paramEntity instanceof TabChannelCoverInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(TabChannelCoverInfo.class.getSimpleName()))
        {
          paramEntity = (TabChannelCoverInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TabChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramEntity.mChannelCoverId) });
        }
      }
      else if ((paramEntity instanceof ChannelCoverInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ChannelCoverInfo.class.getSimpleName()))
        {
          paramEntity = (ChannelCoverInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramEntity.mChannelCoverId) });
        }
      }
      else if ((paramEntity instanceof ReadInJoyUserInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(ReadInJoyUserInfo.class.getSimpleName()))
        {
          paramEntity = (ReadInJoyUserInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(ReadInJoyUserInfo.class, "uin = ?", new String[] { paramEntity.uin });
        }
      }
      else if ((paramEntity instanceof TopBannerInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(TopBannerInfo.class.getSimpleName()))
        {
          paramEntity = (TopBannerInfo)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(TopBannerInfo.class, "mChannelId = ?", new String[] { "" + paramEntity.mChannelId });
        }
      }
      else if ((paramEntity instanceof QuestionSquareBean))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(QuestionSquareBean.class.getSimpleName()))
        {
          paramEntity = (QuestionSquareBean)paramEntity;
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(QuestionSquareBean.class, "uin = ? and rowKey = ?", new String[] { paramEntity.uin, paramEntity.rowKey });
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((paramEntity instanceof WeiShiVideoArticleInfo))
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.tabbleIsExist(WeiShiVideoArticleInfo.class.getSimpleName()))
          {
            paramEntity = (WeiShiVideoArticleInfo)paramEntity;
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.find(WeiShiVideoArticleInfo.class, "articleID = ? and channelID = ?", new String[] { String.valueOf(paramEntity.articleID), String.valueOf(paramEntity.channelID) });
          }
        }
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
      long l = System.currentTimeMillis();
      paramToServiceMsg.extraData.putLong("time_stamp", l);
      if (this.jdField_a_of_type_Qxn != null) {
        this.jdField_a_of_type_Qxn.a(paramToServiceMsg, this);
      }
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  /* Error */
  public boolean a(Entity paramEntity)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 274	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 276	qhj:a	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   19: aload_0
    //   20: getfield 73	qhj:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: aload_1
    //   24: invokevirtual 279	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   27: aload_1
    //   28: invokevirtual 274	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   31: istore_2
    //   32: iload_2
    //   33: sipush 1001
    //   36: if_icmpne +5 -> 41
    //   39: iconst_1
    //   40: istore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload_1
    //   46: invokevirtual 274	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 274	com/tencent/mobileqq/persistence/Entity:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 73	qhj:jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   69: aload_1
    //   70: invokevirtual 282	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   73: istore_3
    //   74: goto -33 -> 41
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	qhj
    //   0	82	1	paramEntity	Entity
    //   31	6	2	k	int
    //   1	73	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	32	77	finally
    //   45	55	77	finally
    //   55	65	77	finally
    //   65	74	77	finally
  }
  
  public int[] a(int paramInt)
  {
    return new int[0];
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      paramToServiceMsg.addAttribute("req_enable_msf_retry", Boolean.valueOf(true));
      QLog.d("ReadInJoyEngineModule", 2, "sendPbReqWithAutoRetry ");
    }
    a(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qhj
 * JD-Core Version:    0.7.0.1
 */