package com.tencent.mobileqq.kandian.biz.feeds;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.account.api.ICellFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.IReadInJoyPresenter;
import com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadInJoyArticleAdapter
  extends ReadInJoyBaseAdapter
  implements DecodeTaskCompletionListener
{
  private IFaceDecoder a;
  
  public ReadInJoyArticleAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, IFaceDecoder paramIFaceDecoder, SparseArray<IBaseHandler> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public int a(int paramInt)
  {
    return RIJBaseItemViewType.a(a(paramInt), this.d);
  }
  
  public Activity a()
  {
    return this.jdField_a_of_type_AndroidAppActivity;
  }
  
  public IFaceDecoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  }
  
  public AbsBaseArticleInfo a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(this.c, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = Math.min(b().size(), 200);
    int i = 0;
    while (i < j)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = a(i);
      if ((localAbsBaseArticleInfo.mResolvedFeedType == 142) && (localAbsBaseArticleInfo.multiVideoColumnInfo != null) && (localAbsBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_Int == paramInt1))
      {
        MultiVideoColumnInfo localMultiVideoColumnInfo = localAbsBaseArticleInfo.multiVideoColumnInfo;
        boolean bool = true;
        if (paramInt2 != 1) {
          bool = false;
        }
        localMultiVideoColumnInfo.jdField_a_of_type_Boolean = bool;
        localAbsBaseArticleInfo.multiVideoColumnInfo.d = paramInt3;
        if ((localAbsBaseArticleInfo instanceof BaseArticleInfo)) {
          ReadInJoyLogicEngine.a().b(localAbsBaseArticleInfo);
        }
      }
      i += 1;
    }
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(paramAbsBaseArticleInfo.mRecommendSeq))
    {
      ReadinjoyFixPosArticleManager.getInstant().deleteFixPosArticle(this.c, paramAbsBaseArticleInfo.mRecommendSeq);
      return;
    }
    Object localObject = RIJQQAppInterfaceUtil.a();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
      if (localDislikeInfo.c == 5) {
        a(localDislikeInfo.b);
      }
    }
    ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject).longValue(), BaseArticleInfoKt.a(paramAbsBaseArticleInfo, paramArrayList));
    ReadInJoyLogicEngine.a().a(this.c, paramAbsBaseArticleInfo);
    if (paramInt == 0)
    {
      paramAbsBaseArticleInfo = (QQAppInterface)ReadInJoyUtils.a();
      paramArrayList = (KandianMergeManager)paramAbsBaseArticleInfo.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (b().size() > 0)
      {
        if (this.c == 0)
        {
          localObject = a(0);
          if (localObject != null)
          {
            paramArrayList = FeedsStructMsg.a(RIJQQAppInterfaceUtil.b(), (AbsBaseArticleInfo)localObject);
            localObject = FeedsStructMsg.a((AbsBaseArticleInfo)localObject);
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramAbsBaseArticleInfo, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime()), paramArrayList, true);
          }
        }
      }
      else
      {
        ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
        if (this.c == 0)
        {
          paramArrayList = paramAbsBaseArticleInfo.getApp().getResources().getString(2131695229);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramAbsBaseArticleInfo, paramArrayList, String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
        }
      }
    }
  }
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = RIJQQAppInterfaceUtil.a();
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramArrayList.get(0);
    if (localAbsBaseArticleInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject).longValue(), BaseArticleInfoKt.a(localAbsBaseArticleInfo, paramArrayList1));
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList1.next();
      if (((DislikeInfo)localObject).c == 5) {
        a(((DislikeInfo)localObject).b);
      }
    }
    int i = 0;
    while (i < paramArrayList.size())
    {
      paramArrayList1 = (AbsBaseArticleInfo)paramArrayList.get(i);
      if (paramArrayList1 != null)
      {
        long l = paramArrayList1.mRecommendSeq;
        RIJFeedsInsertUtil.a.a(this.c, paramArrayList1);
        if (ReadinjoyFixPosArticleManager.isFixPosArticleSeq(l)) {
          ReadinjoyFixPosArticleManager.getInstant().deleteFixPosArticle(this.c, l);
        } else {
          ReadInJoyLogicEngine.a().a(this.c, paramArrayList1);
        }
      }
      i += 1;
    }
    if (paramInt == 0)
    {
      paramArrayList = (QQAppInterface)ReadInJoyUtils.a();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (b().size() > 0)
      {
        if (this.c == 0)
        {
          localObject = a(0);
          if (localObject != null)
          {
            paramArrayList1 = FeedsStructMsg.a(RIJQQAppInterfaceUtil.b(), (AbsBaseArticleInfo)localObject);
            localObject = FeedsStructMsg.a((AbsBaseArticleInfo)localObject);
            ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramArrayList, (String)localObject, String.valueOf(NetConnInfoCenter.getServerTime()), paramArrayList1, true);
          }
        }
      }
      else
      {
        ReadInJoyLogicEngine.a().a(this.c, 20, 9223372036854775807L, true);
        if (this.c == 0)
        {
          paramArrayList1 = paramArrayList.getApp().getResources().getString(2131695229);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramArrayList, paramArrayList1, String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
        }
      }
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramAbsBaseArticleInfo != null)
    {
      if (paramVideoPlayParam == null) {
        return;
      }
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(paramVideoPlayParam, paramAbsBaseArticleInfo);
      }
      if (this.c != 40677)
      {
        ArrayList localArrayList = new ArrayList();
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
        localReportInfo.mSource = 0;
        localReportInfo.mSourceArticleId = paramAbsBaseArticleInfo.mArticleID;
        localReportInfo.mChannelId = this.c;
        localReportInfo.mAlgorithmId = ((int)paramAbsBaseArticleInfo.mAlgorithmID);
        localReportInfo.mStrategyId = paramAbsBaseArticleInfo.mStrategyId;
        localReportInfo.mOperation = 1;
        localReportInfo.mServerContext = paramAbsBaseArticleInfo.mServerContext;
        localReportInfo.mReadTimeLength = -1;
        localReportInfo.mInnerId = paramAbsBaseArticleInfo.innerUniqueID;
        localReportInfo.videoReportInfo = paramAbsBaseArticleInfo.videoReportInfo;
        if (paramAbsBaseArticleInfo.mVideoColumnInfo != null) {
          localReportInfo.mColumnID = paramAbsBaseArticleInfo.mVideoColumnInfo.jdField_a_of_type_Int;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          FeedsReportData localFeedsReportData = new FeedsReportData();
          localFeedsReportData.jdField_a_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
            localFeedsReportData.jdField_b_of_type_Long = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
          }
          localFeedsReportData.jdField_a_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
          localFeedsReportData.jdField_b_of_type_Int = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
          Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localFeedsReportData.jdField_a_of_type_JavaUtilList = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject).next();
              if (localFeedsInfoUser != null) {
                localFeedsReportData.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
              }
            }
          }
          localReportInfo.mFeedsReportData = localFeedsReportData;
        }
        localArrayList.add(localReportInfo);
        ReadInJoyLogicEngine.a().a(localArrayList);
      }
      ReadInJoyLogicEngine.a().a(paramAbsBaseArticleInfo.mArticleID, System.currentTimeMillis());
      RIJFeedsInsertUtil.a.b(this.c, paramAbsBaseArticleInfo);
      super.a(paramVideoPlayParam, paramAbsBaseArticleInfo, paramBoolean1, paramBoolean2);
    }
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new PublicAccountUnfollowTask((QQAppInterface)ReadInJoyUtils.a(), paramString, this.jdField_a_of_type_AndroidAppActivity).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public AbsBaseArticleInfo b(int paramInt)
  {
    return ReadInJoyLogicEngine.a().a(Integer.valueOf(this.c));
  }
  
  public void b()
  {
    super.b();
  }
  
  public boolean b()
  {
    return RIJAppSetting.a(this.jdField_a_of_type_AndroidAppActivity);
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(Long.valueOf(paramLong));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
    {
      paramInt2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = (IReadInJoyModel)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(paramInt1).getTag(2131380884);
        ReadInJoyView localReadInJoyView = (ReadInJoyView)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(paramInt1).getTag(2131380889);
        IReadInJoyPresenter localIReadInJoyPresenter = (IReadInJoyPresenter)this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(paramInt1).getTag(2131380886);
        if ((localObject != null) && (localReadInJoyView != null) && (localIReadInJoyPresenter != null)) {
          localIReadInJoyPresenter.a(localReadInJoyView, (IReadInJoyModel)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
        }
        if ((localObject != null) && (((ICellFactory)QRoute.api(ICellFactory.class)).cellRebuildCompleted(((IReadInJoyModel)localObject).d())))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(paramInt1);
          if (localObject != null)
          {
            localObject = (FeedItemCell)((View)localObject).getTag();
            if (localObject != null) {
              try
              {
                ((FeedItemCell)localObject).a(Long.valueOf(paramString).longValue(), paramBitmap);
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
            }
          }
        }
        paramInt1 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter
 * JD-Core Version:    0.7.0.1
 */