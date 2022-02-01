package com.tencent.mobileqq.kandian.repo.biu;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.kandian.repo.common.RIJUserApproveModule;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.LongContentInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class RIJNewBiuCardTransformManager
{
  private BiuInfo a = new BiuInfo();
  
  public static BiuInfo a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData, boolean paramBoolean)
  {
    BiuInfo localBiuInfo = new BiuInfo();
    if (paramRIJBiuAndCommentRespData == null) {
      return localBiuInfo;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("convertRespToBiuInfo | respData : ");
    localStringBuilder.append(paramRIJBiuAndCommentRespData.toString());
    localStringBuilder.append(" ,isFromRecommentFeeds:");
    localStringBuilder.append(paramBoolean);
    QLog.d("RIJNewBiuCardTransformManager", 1, localStringBuilder.toString());
    localBiuInfo.a = paramBoolean;
    localBiuInfo.b = paramRIJBiuAndCommentRespData.e();
    localBiuInfo.e = paramRIJBiuAndCommentRespData.f();
    localBiuInfo.c = paramRIJBiuAndCommentRespData.g();
    localBiuInfo.j = paramRIJBiuAndCommentRespData.l();
    localBiuInfo.i = paramRIJBiuAndCommentRespData.m();
    localBiuInfo.g = paramRIJBiuAndCommentRespData.n();
    localBiuInfo.h = paramRIJBiuAndCommentRespData.d();
    localBiuInfo.f = paramRIJBiuAndCommentRespData.o();
    return localBiuInfo;
  }
  
  public static RIJNewBiuCardTransformManager a()
  {
    return RIJNewBiuCardTransformManager.SingletonInstance.a();
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return false;
    }
    int i = RIJBaseItemViewType.a(paramAbsBaseArticleInfo, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkBiuCardWhiteList | type : ");
    localStringBuilder.append(i);
    QLog.d("RIJNewBiuCardTransformManager", 2, localStringBuilder.toString());
    if ((i != 0) && (i != 3) && (i != 1) && (i != 5) && (i != 6) && (i != 126) && (!b(paramAbsBaseArticleInfo)))
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkBiuCardWhiteList not in white list");
      return false;
    }
    paramAbsBaseArticleInfo = new StringBuilder();
    paramAbsBaseArticleInfo.append("checkBiuCardWhiteList | valid type : ");
    paramAbsBaseArticleInfo.append(i);
    QLog.d("RIJNewBiuCardTransformManager", 2, paramAbsBaseArticleInfo.toString());
    return true;
  }
  
  public static boolean b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType articleInfo is null");
      return false;
    }
    if (!paramAbsBaseArticleInfo.isPGCShortContent())
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | is not pgcShortContent");
      return false;
    }
    if ((paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.L != null))
    {
      int i = paramAbsBaseArticleInfo.mSocialFeedInfo.L.a;
      if ((i != 1) && (i != 3) && (i != 4) && (i != 2) && (i != 5))
      {
        QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | valid shortContent type");
        return true;
      }
      QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | longContent out");
      return false;
    }
    QLog.d("RIJNewBiuCardTransformManager", 2, "checkShortContentType | socialFeedsInfo is null");
    return true;
  }
  
  public void a(BiuInfo paramBiuInfo)
  {
    if (paramBiuInfo != null)
    {
      this.a = paramBiuInfo;
      paramBiuInfo = new StringBuilder();
      paramBiuInfo.append("updateBiuInfo | mBiuInfo  : ");
      paramBiuInfo.append(this.a);
      QLog.d("RIJNewBiuCardTransformManager", 2, paramBiuInfo.toString());
      d();
    }
  }
  
  public boolean b()
  {
    Object localObject = this.a;
    if (localObject == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, biuInfo is null");
      return false;
    }
    if (((BiuInfo)localObject).e == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | false, articleInfo is null");
      return false;
    }
    if (this.a.a)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "shouldAutoRefresh | should refresh when out from related articles");
      return true;
    }
    boolean bool = ReadInJoyLogicEngine.a().b(this.a.e) ^ true;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("shouldAutoRefresh | shouldRefresh: ");
    ((StringBuilder)localObject).append(bool);
    QLog.d("RIJNewBiuCardTransformManager", 2, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void c()
  {
    if (this.a == null)
    {
      QLog.d("RIJNewBiuCardTransformManager", 2, "transformCard | mBiuInfo is null");
      return;
    }
    ReadInJoyLogicEngine.a().a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" transformCard | mBiuInfo ");
    localStringBuilder.append(this.a);
    QLog.d("RIJNewBiuCardTransformManager", 1, localStringBuilder.toString());
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface = RIJQQAppInterfaceUtil.a();
    if (localQQAppInterface != null)
    {
      Object localObject = (ReadInJoyLogicManager)localQQAppInterface.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
      if (localObject != null)
      {
        localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine().n();
        if (localObject != null) {
          ((RIJUserApproveModule)localObject).a(localQQAppInterface.getLongAccountUin(), new RIJNewBiuCardTransformManager.1(this));
        }
      }
    }
  }
  
  public void e()
  {
    BiuInfo localBiuInfo = this.a;
    if (localBiuInfo != null) {
      localBiuInfo.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.biu.RIJNewBiuCardTransformManager
 * JD-Core Version:    0.7.0.1
 */