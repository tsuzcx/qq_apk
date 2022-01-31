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

public abstract class pgp
  implements pft
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
  public awbw a;
  public AppInterface a;
  protected ExecutorService a;
  protected puz a;
  
  public pgp(AppInterface paramAppInterface, awbw paramawbw, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService = paramExecutorService;
    this.jdField_a_of_type_Puz = parampuz;
    this.jdField_a_of_type_Awbw = paramawbw;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public ArrayList<BaseArticleInfo> a(int paramInt)
  {
    return null;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, pfu parampfu) {}
  
  public void a(awbv paramawbv)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1;
    if ((paramawbv instanceof AdvertisementInfo))
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Awbw.d(AdvertisementInfo.class.getSimpleName()))
      {
        paramawbv = (AdvertisementInfo)paramawbv;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(paramawbv.mAdTraceId)) {
          localObject1 = this.jdField_a_of_type_Awbw.a(AdvertisementInfo.class, "mAdTraceId = ?", new String[] { paramawbv.mAdTraceId });
        }
      }
    }
    for (;;)
    {
      if (localObject1 != null) {
        this.jdField_a_of_type_Awbw.b((awbv)localObject1);
      }
      return;
      if ((paramawbv instanceof ArticleInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(ArticleInfo.class.getSimpleName()))
        {
          localObject2 = (ArticleInfo)paramawbv;
          paramawbv = localObject3;
          if (((ArticleInfo)localObject2).mChannelID != 70L) {
            paramawbv = this.jdField_a_of_type_Awbw.a(ArticleInfo.class, "mArticleID = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mArticleID), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          }
          localObject1 = this.jdField_a_of_type_Awbw.a(ArticleInfo.class, "mRecommendSeq = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mRecommendSeq), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
          if (paramawbv != null) {}
          for (;;)
          {
            if ((QLog.isColorLevel()) && (paramawbv != null)) {
              QLog.e("ReadInJoyEngineModule", 2, "removeEntityIfExistsInDB, article duplicated, article been channelID=" + ((ArticleInfo)localObject2).mChannelID + "articleID=" + ((ArticleInfo)localObject2).mArticleID + "recommendSeq=" + ((ArticleInfo)localObject2).mRecommendSeq);
            }
            localObject1 = paramawbv;
            if (((ArticleInfo)localObject2).mChannelID != 70L) {
              break;
            }
            localObject1 = paramawbv;
            if (((ArticleInfo)localObject2).mFeedId == 0L) {
              break;
            }
            localObject2 = this.jdField_a_of_type_Awbw.a(ArticleInfo.class, "mFeedId = ? and mChannelID = ?", new String[] { String.valueOf(((ArticleInfo)localObject2).mFeedId), String.valueOf(((ArticleInfo)localObject2).mChannelID) });
            localObject1 = paramawbv;
            if (localObject2 == null) {
              break;
            }
            this.jdField_a_of_type_Awbw.b((awbv)localObject2);
            localObject1 = paramawbv;
            break;
            paramawbv = (awbv)localObject1;
          }
        }
      }
      else if ((paramawbv instanceof ArticleReadInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(ArticleInfo.class.getSimpleName()))
        {
          paramawbv = (ArticleReadInfo)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(ArticleReadInfo.class, "mArticleID = ?", new String[] { String.valueOf(paramawbv.mArticleID) });
        }
      }
      else if ((paramawbv instanceof ChannelInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(ChannelInfo.class.getSimpleName()))
        {
          paramawbv = (ChannelInfo)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(ChannelInfo.class, "mChannelID = ?", new String[] { String.valueOf(paramawbv.mChannelID) });
        }
      }
      else if ((paramawbv instanceof TabChannelCoverInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(TabChannelCoverInfo.class.getSimpleName()))
        {
          paramawbv = (TabChannelCoverInfo)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(TabChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramawbv.mChannelCoverId) });
        }
      }
      else if ((paramawbv instanceof ChannelCoverInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(ChannelCoverInfo.class.getSimpleName()))
        {
          paramawbv = (ChannelCoverInfo)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(ChannelCoverInfo.class, "mChannelCoverId = ?", new String[] { String.valueOf(paramawbv.mChannelCoverId) });
        }
      }
      else if ((paramawbv instanceof ReadInJoyUserInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(ReadInJoyUserInfo.class.getSimpleName()))
        {
          paramawbv = (ReadInJoyUserInfo)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(ReadInJoyUserInfo.class, "uin = ?", new String[] { paramawbv.uin });
        }
      }
      else if ((paramawbv instanceof TopBannerInfo))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(TopBannerInfo.class.getSimpleName()))
        {
          paramawbv = (TopBannerInfo)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(TopBannerInfo.class, "mChannelId = ?", new String[] { "" + paramawbv.mChannelId });
        }
      }
      else if ((paramawbv instanceof QuestionSquareBean))
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Awbw.d(QuestionSquareBean.class.getSimpleName()))
        {
          paramawbv = (QuestionSquareBean)paramawbv;
          localObject1 = this.jdField_a_of_type_Awbw.a(QuestionSquareBean.class, "uin = ? and rowKey = ?", new String[] { paramawbv.uin, paramawbv.rowKey });
        }
      }
      else
      {
        localObject1 = localObject2;
        if ((paramawbv instanceof WeiShiVideoArticleInfo))
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Awbw.d(WeiShiVideoArticleInfo.class.getSimpleName()))
          {
            paramawbv = (WeiShiVideoArticleInfo)paramawbv;
            localObject1 = this.jdField_a_of_type_Awbw.a(WeiShiVideoArticleInfo.class, "articleID = ? and channelID = ?", new String[] { String.valueOf(paramawbv.articleID), String.valueOf(paramawbv.channelID) });
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
      if (this.jdField_a_of_type_Puz != null) {
        this.jdField_a_of_type_Puz.a(paramToServiceMsg, this);
      }
    }
  }
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  /* Error */
  public boolean a(awbv paramawbv)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokevirtual 266	awbv:getStatus	()I
    //   8: sipush 1000
    //   11: if_icmpne +34 -> 45
    //   14: aload_0
    //   15: aload_1
    //   16: invokevirtual 268	pgp:a	(Lawbv;)V
    //   19: aload_0
    //   20: getfield 68	pgp:jdField_a_of_type_Awbw	Lawbw;
    //   23: aload_1
    //   24: invokevirtual 270	awbw:b	(Lawbv;)V
    //   27: aload_1
    //   28: invokevirtual 266	awbv:getStatus	()I
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
    //   46: invokevirtual 266	awbv:getStatus	()I
    //   49: sipush 1001
    //   52: if_icmpeq +13 -> 65
    //   55: aload_1
    //   56: invokevirtual 266	awbv:getStatus	()I
    //   59: sipush 1002
    //   62: if_icmpne -21 -> 41
    //   65: aload_0
    //   66: getfield 68	pgp:jdField_a_of_type_Awbw	Lawbw;
    //   69: aload_1
    //   70: invokevirtual 272	awbw:a	(Lawbv;)Z
    //   73: istore_3
    //   74: goto -33 -> 41
    //   77: astore_1
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_1
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	pgp
    //   0	82	1	paramawbv	awbv
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
    if (this.jdField_a_of_type_Awbw.d(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_Awbw.a(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ? OR mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(17), String.valueOf(19), String.valueOf(0), String.valueOf(24), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
  
  public List<ArticleInfo> d(int paramInt)
  {
    List localList = null;
    if (this.jdField_a_of_type_Awbw.d(ArticleInfo.class.getSimpleName())) {
      localList = this.jdField_a_of_type_Awbw.a(ArticleInfo.class, true, "(mFeedType = ? OR mFeedType = ?) AND businessId = ?", new String[] { String.valueOf(0), String.valueOf(4), String.valueOf(paramInt) }, null, null, null, null);
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pgp
 * JD-Core Version:    0.7.0.1
 */