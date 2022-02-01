package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsDynamicInsertController;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OnSocialHeaderFollowClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private Context b;
  private int c;
  
  public OnSocialHeaderFollowClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramInt;
  }
  
  private void a()
  {
    if (this.a == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = this.a;
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null)) {
      this.a.needShowFollwedButton = true;
    }
    localObject = String.valueOf(b(this.a));
    ReadInJoyUserInfoModule.a(Long.valueOf((String)localObject).longValue(), new OnSocialHeaderFollowClickListener.1(this, localQQAppInterface, (String)localObject));
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (a(this.a)) {
      return;
    }
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().c();
    paramQQAppInterface = paramQQAppInterface.getAccount();
    boolean bool = a(this.a);
    OnSocialHeaderFollowClickListener.2 local2 = new OnSocialHeaderFollowClickListener.2(this, paramBoolean);
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    localUserOperationModule.request0x978(paramQQAppInterface, paramString1, bool ^ true, paramString2, local2, i);
    d();
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramAbsBaseArticleInfo != null)
    {
      bool1 = bool2;
      if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
      {
        bool1 = bool2;
        if (paramAbsBaseArticleInfo.mSocialFeedInfo.o == 2) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static long b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramAbsBaseArticleInfo.mSubscribeID);
      return l;
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      return 0L;
    }
    catch (NumberFormatException paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    return 0L;
  }
  
  private void b()
  {
    long l = this.a.mAlgorithmID;
    int i = RIJFeedsType.g(this.a);
    int j = (int)this.a.mChannelID;
    boolean bool = NetworkUtil.isWifiConnected(this.b);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(b(this.a));
    ((StringBuilder)localObject).append("");
    String str = RIJTransMergeKanDianReport.a(l, i, j, 0, 0, bool, ((StringBuilder)localObject).toString(), null, this.a.innerUniqueID, null, this.a);
    if (ReadinjoyReportUtils.d(this.a.mChannelID)) {
      localObject = "0X800941D";
    } else {
      localObject = "0X80080EC";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b(this.a));
    localStringBuilder.append("");
    PublicAccountReportUtils.a(null, localStringBuilder.toString(), (String)localObject, (String)localObject, 0, 0, String.valueOf(this.a.mFeedId), String.valueOf(this.a.mArticleID), Integer.toString(this.a.mStrategyId), str, false);
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localQQAppInterface != null)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.a;
      if (localAbsBaseArticleInfo != null)
      {
        localAbsBaseArticleInfo.needShowFollwedButton = true;
        String str;
        if (ReadinjoyReportUtils.d(localAbsBaseArticleInfo.mChannelID)) {
          str = "0X800941D";
        } else {
          str = "0X80080EC";
        }
        RIJFrameworkReportManager.a(localAbsBaseArticleInfo, str, str, (int)localAbsBaseArticleInfo.mChannelID);
        ReadInJoyLogicEngine.e(localAbsBaseArticleInfo);
        if (localAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          str = String.valueOf(localAbsBaseArticleInfo.mSocialFeedInfo.c.a);
          ReadInJoyUserInfoModule.a(Long.valueOf(str).longValue(), new OnSocialHeaderFollowClickListener.3(this, localQQAppInterface, str));
        }
      }
    }
    d();
  }
  
  private void d()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      Object localObject3 = ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new FeedsReportData();
      localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((AbsBaseArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((AbsBaseArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((AbsBaseArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((AbsBaseArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((FeedsReportData)localObject1).a = ((SocializeFeedsInfo)localObject3).a;
        if (((SocializeFeedsInfo)localObject3).c != null) {
          ((FeedsReportData)localObject1).b = ((SocializeFeedsInfo)localObject3).c.a;
        }
        ((FeedsReportData)localObject1).d = ((SocializeFeedsInfo)localObject3).h;
        ((FeedsReportData)localObject1).e = ((SocializeFeedsInfo)localObject3).j;
        localObject2 = ((SocializeFeedsInfo)localObject3).d;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((FeedsReportData)localObject1).c = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((FeedsReportData)localObject1).c.add(Long.valueOf(((FeedsInfoUser)localObject3).a));
            }
          }
        }
      }
      localReportInfo.mOperation = 14;
      localReportInfo.mFeedsReportData = ((FeedsReportData)localObject1);
    }
    Object localObject1 = new ArrayList();
    ((List)localObject1).add(localReportInfo);
    ReadInJoyLogicEngine.a().a((List)localObject1);
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (this.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnSocialHeaderFollowClickListener: ");
      localStringBuilder.append(this.a.mTitle);
      QLog.d("OnSocialHeaderFollowClickListener", 2, localStringBuilder.toString());
      ReadinjoyReportUtils.a(this.a, ReadinjoyReportUtils.e, "");
      int i = this.c;
      if ((i != 31) && (i != 32) && (i != 83) && (i != 84) && (i != 85) && (i != 86) && (i != 77) && (i != 78) && (!this.a.isPGCShortContent()) && (!this.a.isAccountShown)) {
        c();
      } else {
        a();
      }
      ((IRIJAdService)QRoute.api(IRIJAdService.class)).clickAdUgcSocialOperationReport(paramViewBase, this.a, true);
      RIJFeedsDynamicInsertController.INSTANCE.requestDynamicInsertInTL(this.a, new RIJFeedsInsertAction(ActionType.ACTION_FOLLOW, 0, 0, 0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnSocialHeaderFollowClickListener
 * JD-Core Version:    0.7.0.1
 */