package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ComponentHeaderBase
  extends FrameLayout
  implements ComponentInheritView
{
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  CmpCtxt jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt;
  public ComponentNotIntrest a;
  
  public ComponentHeaderBase(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt = new CmpCtxt();
    a(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560141, this, true);
  }
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest = ((ComponentNotIntrest)paramView.findViewById(2131371954));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a(paramCellListener);
    ComponentNotIntrest localComponentNotIntrest = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      Object localObject = (IReadInJoyModel)paramObject;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a((IReadInJoyModel)localObject);
      b();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest;
      if (localObject != null)
      {
        ((ComponentNotIntrest)localObject).a(paramObject);
        if (a())
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setVisibility(8);
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentComponentNotIntrest.setVisibility(0);
      }
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a;
    boolean bool2 = false;
    if ((localObject != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
      if (((RIJFeedsType.j((AbsBaseArticleInfo)localObject)) || (RIJFeedsType.k((AbsBaseArticleInfo)localObject)) || (RIJFeedsType.m((AbsBaseArticleInfo)localObject)) || (RIJFeedsType.n((AbsBaseArticleInfo)localObject))) && (((AbsBaseArticleInfo)localObject).mChannelID != 70L)) {
        return false;
      }
      boolean bool1;
      if ((!this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a()) && (((AbsBaseArticleInfo)localObject).mChannelID != 70L))
      {
        bool1 = bool2;
        if (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null)
        {
          bool1 = bool2;
          if (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.h != 1) {}
        }
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    QLog.d("ComponentHeaderBase", 2, "isHideNotInterestView model or articleInfo is null !");
    return false;
  }
  
  public void b() {}
  
  protected void c()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsComponentCmpCtxt.a.a();
    if (localObject2 != null)
    {
      Object localObject3 = ((AbsBaseArticleInfo)localObject2).mSocialFeedInfo;
      localObject1 = new FeedsReportData();
      localReportInfo.mUin = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getLongAccountUin();
      localReportInfo.mSource = 0;
      localReportInfo.mSourceArticleId = ((AbsBaseArticleInfo)localObject2).mArticleID;
      localReportInfo.mChannelId = ((int)((AbsBaseArticleInfo)localObject2).mChannelID);
      localReportInfo.mAlgorithmId = ((int)((AbsBaseArticleInfo)localObject2).mAlgorithmID);
      localReportInfo.mStrategyId = ((AbsBaseArticleInfo)localObject2).mStrategyId;
      localReportInfo.mServerContext = ((AbsBaseArticleInfo)localObject2).mServerContext;
      localReportInfo.mReadTimeLength = -1;
      if (localObject3 != null)
      {
        ((FeedsReportData)localObject1).jdField_a_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_Long;
        if (((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser != null) {
          ((FeedsReportData)localObject1).jdField_b_of_type_Long = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityFeedsInfoUser.jdField_a_of_type_Long;
        }
        ((FeedsReportData)localObject1).jdField_a_of_type_Int = ((SocializeFeedsInfo)localObject3).jdField_b_of_type_Int;
        ((FeedsReportData)localObject1).jdField_b_of_type_Int = ((SocializeFeedsInfo)localObject3).d;
        localObject2 = ((SocializeFeedsInfo)localObject3).jdField_a_of_type_JavaUtilList;
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FeedsInfoUser)((Iterator)localObject2).next();
            if (localObject3 != null) {
              ((FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(((FeedsInfoUser)localObject3).jdField_a_of_type_Long));
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
  
  public void setLogic(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = paramIFaceDecoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderBase
 * JD-Core Version:    0.7.0.1
 */