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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

public abstract class pbh
  implements pan
{
  protected static String b = "ReqType";
  protected static String c = "NotifyType";
  public static String d = "BeginSeq";
  public static String e = "EndSeq";
  public static String f = "CountOfRequest_0x68b";
  public static String g = "CountOfRequest_0x886";
  public static String h = "repeatedReqFlag";
  public static String i = "asyncRequestChannelFlag";
  public Handler a;
  public aukn a;
  public AppInterface a;
  protected ExecutorService a;
  protected pou a;
  
  public pbh(AppInterface paramAppInterface, aukn paramaukn, ExecutorService paramExecutorService, pou parampou, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_Pou = parampou;
    this.jdField_a_of_type_Aukn = paramaukn;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, pao parampao) {}
  
  public void a(aukm paramaukm)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if ((paramaukm instanceof AdvertisementInfo))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Aukn.d(AdvertisementInfo.class.getSimpleName()))
      {
        paramaukm = (AdvertisementInfo)paramaukm;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramaukm.mAdTraceId)) {
          localObject1 = this.jdField_a_of_type_Aukn.a(AdvertisementInfo.class, "mAdTraceId = ?", new String[] { paramaukm.mAdTraceId });
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_Aukn.b((aukm)localObject1);
      }
      return;
      if ((paramaukm instanceof ArticleInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(ArticleInfo.class.getSimpleName()))
        {
          localObject2 = (ArticleInfo)paramaukm;
          paramaukm = localObject3;
          if (((ArticleInfo)localObject2).mChannelID != 70L) {
            paramaukm = this.jdField_a_of_type_Aukn.a(ArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mArticleID), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          }
          localObject1 = this.jdField_a_of_type_Aukn.a(ArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mRecommendSeq), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          if (paramaukm != null) {}
          for (;;)
          {
            if ((QLog.isColorLevel()) && (paramaukm != null)) {
              QLog.e("ReadInJoyEngineModule", 2, "removeEntityIfExistsInDB, article duplicated, article been channelID=" + ((ArticleInfo)localObject2).mChannelID + "articleID=" + ((ArticleInfo)localObject2).mArticleID + "recommendSeq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
            localObject1 = paramaukm;
            if (((ArticleInfo)localObject2).mChannelID != 70L) {
              break;
            }
            localObject1 = paramaukm;
            if (((ArticleInfo)localObject2).mFeedId == 0L) {
              break;
            }
            localObject2 = this.jdField_a_of_type_Aukn.a(ArticleInfo.class, "mFeedId = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mFeedId), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
            localObject1 = paramaukm;
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_Aukn.b((aukm)localObject2);
            localObject1 = paramaukm;
            break;
            paramaukm = (aukm)localObject1;
          }
        }
      }
      else if ((paramaukm instanceof ArticleReadInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(ArticleInfo.class.getSimpleName()))
        {
          paramaukm = (ArticleReadInfo)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramaukm.mArticleID) });
        }
      }
      else if ((paramaukm instanceof ChannelInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(ChannelInfo.class.getSimpleName()))
        {
          paramaukm = (ChannelInfo)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramaukm.mChannelID) });
        }
      }
      else if ((paramaukm instanceof TabChannelCoverInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(TabChannelCoverInfo.class.getSimpleName()))
        {
          paramaukm = (TabChannelCoverInfo)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(TabChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramaukm.mChannelCoverId) });
        }
      }
      else if ((paramaukm instanceof ChannelCoverInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(ChannelCoverInfo.class.getSimpleName()))
        {
          paramaukm = (ChannelCoverInfo)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(ChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramaukm.mChannelCoverId) });
        }
      }
      else if ((paramaukm instanceof ReadInJoyUserInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(ReadInJoyUserInfo.class.getSimpleName()))
        {
          paramaukm = (ReadInJoyUserInfo)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(ReadInJoyUserInfo.class, "uin = ?", new String[] { paramaukm.uin });
        }
      }
      else if ((paramaukm instanceof TopBannerInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(TopBannerInfo.class.getSimpleName()))
        {
          paramaukm = (TopBannerInfo)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(TopBannerInfo.class, "mChannelId = ?", new String[] { "" + paramaukm.mChannelId });
        }
      }
      else if ((paramaukm instanceof QuestionSquareBean))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Aukn.d(QuestionSquareBean.class.getSimpleName()))
        {
          paramaukm = (QuestionSquareBean)paramaukm;
          localObject1 = this.jdField_a_of_type_Aukn.a(QuestionSquareBean.class, "uin = ? and rowKey = ?", new String[] { paramaukm.uin, paramaukm.rowKey });
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((paramaukm instanceof WeiShiVideoArticleInfo))
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Aukn.d(WeiShiVideoArticleInfo.class.getSimpleName()))
          {
            paramaukm = (WeiShiVideoArticleInfo)paramaukm;
            localObject1 = this.jdField_a_of_type_Aukn.a(WeiShiVideoArticleInfo.class, "articleID = ? and channelID = ?", new String[] { String.valueOf(paramaukm.articleID), String.valueOf(paramaukm.channelID) });
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
      if (this.jdField_a_of_type_Pou != null) {
        this.jdField_a_of_type_Pou.a(paramToServiceMsg, this);
      }
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  /* Error */
  public boolean a(aukm paramaukm)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 266	aukm:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 268	pbh:a	(Laukm;)V
    //   19: aload_0
    //   20: getfield 68	pbh:jdField_a_of_type_Aukn	Laukn;
    //   23: aload_1
    //   24: invokevirtual 270	aukn:b	(Laukm;)V
    //   27: aload_1
    //   28: invokevirtual 266	aukm:getStatus	()I
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
    //   46: invokevirtual 266	aukm:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 266	aukm:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 68	pbh:jdField_a_of_type_Aukn	Laukn;
    //   69: aload_1
    //   70: invokevirtual 272	aukn:a	(Laukm;)Z
    //   73: istore_3
    //   74: goto -33 -> 41
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	pbh
    //   0	82	1	paramaukm	aukm
    //   31	6	2	j	int
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
  
  public List<ArticleInfo> c(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_Aukn.d(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_Aukn.a(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ? OR mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(17), String.valueOf(19), String.valueOf(0), String.valueOf(24), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
  
  public List<ArticleInfo> d(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_Aukn.d(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_Aukn.a(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(0), String.valueOf(4), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbh
 * JD-Core Version:    0.7.0.1
 */