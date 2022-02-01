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
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.RIJFeedsInsertUtil;
import com.tencent.mobileqq.kandian.biz.feeds.presenter.IReadInJoyPresenter;
import com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.pts.component.FeedItemCell;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.mobileqq.kandian.glue.structmsg.FeedsStructMsg;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJFeedsFluencyOptimizeUtil;
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
  private IFaceDecoder z;
  
  public ReadInJoyArticleAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, IFaceDecoder paramIFaceDecoder, SparseArray<IBaseHandler> paramSparseArray)
  {
    super(paramActivity, paramLayoutInflater, paramInt, paramListView, paramSparseArray);
    this.z = paramIFaceDecoder;
    this.z.setDecodeTaskCompletionListener(this);
  }
  
  public Activity a()
  {
    return this.e;
  }
  
  public AbsBaseArticleInfo a(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(this.c, paramLong);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    int j = Math.min(h().size(), 200);
    int i = 0;
    while (i < j)
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = a(i);
      if ((localAbsBaseArticleInfo.mResolvedFeedType == 142) && (localAbsBaseArticleInfo.multiVideoColumnInfo != null) && (localAbsBaseArticleInfo.multiVideoColumnInfo.a == paramInt1))
      {
        MultiVideoColumnInfo localMultiVideoColumnInfo = localAbsBaseArticleInfo.multiVideoColumnInfo;
        boolean bool = true;
        if (paramInt2 != 1) {
          bool = false;
        }
        localMultiVideoColumnInfo.j = bool;
        localAbsBaseArticleInfo.multiVideoColumnInfo.i = paramInt3;
        if ((localAbsBaseArticleInfo instanceof BaseArticleInfo)) {
          ReadInJoyLogicEngine.a().c(localAbsBaseArticleInfo);
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
    Object localObject = RIJQQAppInterfaceUtil.d();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      DislikeInfo localDislikeInfo = (DislikeInfo)localIterator.next();
      if (localDislikeInfo.d == 5) {
        b(localDislikeInfo.f);
      }
    }
    ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject).longValue(), BaseArticleInfoKt.a(paramAbsBaseArticleInfo, paramArrayList));
    ReadInJoyLogicEngine.a().a(this.c, paramAbsBaseArticleInfo);
    if (paramInt == 0)
    {
      paramAbsBaseArticleInfo = (QQAppInterface)ReadInJoyUtils.b();
      paramArrayList = (KandianMergeManager)paramAbsBaseArticleInfo.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (h().size() > 0)
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
          paramArrayList = paramAbsBaseArticleInfo.getApp().getResources().getString(2131892963);
          ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).createFakeStructingMsgWithFields(paramAbsBaseArticleInfo, paramArrayList, String.valueOf(NetConnInfoCenter.getServerTime()), "", true);
        }
      }
    }
  }
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1)
  {
    Object localObject = RIJQQAppInterfaceUtil.d();
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramArrayList.get(0);
    if (localAbsBaseArticleInfo != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf((String)localObject).longValue(), BaseArticleInfoKt.a(localAbsBaseArticleInfo, paramArrayList1));
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localObject = (DislikeInfo)paramArrayList1.next();
      if (((DislikeInfo)localObject).d == 5) {
        b(((DislikeInfo)localObject).f);
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
      paramArrayList = (QQAppInterface)ReadInJoyUtils.b();
      paramArrayList1 = (KandianMergeManager)paramArrayList.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (h().size() > 0)
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
          paramArrayList1 = paramArrayList.getApp().getResources().getString(2131892963);
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
        this.u.c().a(paramVideoPlayParam, paramAbsBaseArticleInfo);
      }
      if (this.c != 40677)
      {
        ArrayList localArrayList = new ArrayList();
        ReportInfo localReportInfo = new ReportInfo();
        localReportInfo.mUin = RIJQQAppInterfaceUtil.c();
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
          localReportInfo.mColumnID = paramAbsBaseArticleInfo.mVideoColumnInfo.b;
        }
        if (paramAbsBaseArticleInfo.mSocialFeedInfo != null)
        {
          FeedsReportData localFeedsReportData = new FeedsReportData();
          localFeedsReportData.a = paramAbsBaseArticleInfo.mSocialFeedInfo.a;
          if (paramAbsBaseArticleInfo.mSocialFeedInfo.c != null) {
            localFeedsReportData.b = paramAbsBaseArticleInfo.mSocialFeedInfo.c.a;
          }
          localFeedsReportData.d = paramAbsBaseArticleInfo.mSocialFeedInfo.h;
          localFeedsReportData.e = paramAbsBaseArticleInfo.mSocialFeedInfo.j;
          Object localObject = paramAbsBaseArticleInfo.mSocialFeedInfo.d;
          if ((localObject != null) && (!((List)localObject).isEmpty()))
          {
            localFeedsReportData.c = new ArrayList();
            localObject = ((List)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              FeedsInfoUser localFeedsInfoUser = (FeedsInfoUser)((Iterator)localObject).next();
              if (localFeedsInfoUser != null) {
                localFeedsReportData.c.add(Long.valueOf(localFeedsInfoUser.a));
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
  
  public AbsBaseArticleInfo b(int paramInt)
  {
    return ReadInJoyLogicEngine.a().a(Integer.valueOf(this.c));
  }
  
  public boolean b(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(paramLong);
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      new PublicAccountUnfollowTask((QQAppInterface)ReadInJoyUtils.b(), paramString, this.e).a();
      return true;
    }
    QLog.d("Q.readinjoy.ui", 2, "unfollow fail , puin is null !");
    return false;
  }
  
  public int c(int paramInt)
  {
    return RIJBaseItemViewType.a(a(paramInt), this.d);
  }
  
  public boolean c(int paramInt, long paramLong)
  {
    return ReadInJoyLogicEngine.a().a(Long.valueOf(paramLong));
  }
  
  public IFaceDecoder l()
  {
    return this.z;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (!this.z.isPausing())
    {
      paramInt2 = this.i.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        Object localObject = (IReadInJoyModel)this.i.getChildAt(paramInt1).getTag(2131449867);
        ReadInJoyView localReadInJoyView = (ReadInJoyView)this.i.getChildAt(paramInt1).getTag(2131449873);
        IReadInJoyPresenter localIReadInJoyPresenter = (IReadInJoyPresenter)this.i.getChildAt(paramInt1).getTag(2131449869);
        if ((localObject != null) && (localReadInJoyView != null) && (localIReadInJoyPresenter != null)) {
          localIReadInJoyPresenter.a(localReadInJoyView, (IReadInJoyModel)localObject, Long.valueOf(paramString).longValue(), paramBitmap);
        }
        if ((localObject != null) && (CellFactory.INSTANCE.cellRebuildCompleted(((IReadInJoyModel)localObject).o())))
        {
          localObject = this.i.getChildAt(paramInt1);
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
  
  public boolean r()
  {
    if (RIJFeedsFluencyOptimizeUtil.a.b()) {
      return ReadinjoySPEventReport.ForeBackGround.a == 1;
    }
    return RIJAppSetting.a(this.e);
  }
  
  public void s()
  {
    super.s();
  }
  
  public void t()
  {
    this.n.g();
  }
  
  public void u()
  {
    this.n.h();
  }
  
  public void v()
  {
    this.n.i();
  }
  
  public void w()
  {
    this.n.j();
  }
  
  public void x()
  {
    this.n.k();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter
 * JD-Core Version:    0.7.0.1
 */