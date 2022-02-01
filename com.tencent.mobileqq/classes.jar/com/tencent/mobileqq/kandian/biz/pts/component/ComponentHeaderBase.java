package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.FeedsReportData;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ComponentHeaderBase
  extends FrameLayout
  implements ComponentInheritView
{
  CmpCtxt a;
  ReadInJoyBaseAdapter b;
  IFaceDecoder c;
  public ComponentNotIntrest d;
  
  public ComponentHeaderBase(Context paramContext)
  {
    super(paramContext);
    c(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(paramContext);
  }
  
  public ComponentHeaderBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(paramContext);
  }
  
  private void c(Context paramContext)
  {
    this.a = new CmpCtxt();
    b(paramContext);
    a();
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626188, this, true);
  }
  
  public void a() {}
  
  public void a(View paramView)
  {
    this.d = ((ComponentNotIntrest)paramView.findViewById(2131439399));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    this.a.a(paramCellListener);
    ComponentNotIntrest localComponentNotIntrest = this.d;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      Object localObject = (IReadInJoyModel)paramObject;
      this.a.a((IReadInJoyModel)localObject);
      b();
      localObject = this.d;
      if (localObject != null)
      {
        ((ComponentNotIntrest)localObject).a(paramObject);
        if (c())
        {
          this.d.setVisibility(8);
          return;
        }
        this.d.setVisibility(0);
      }
    }
  }
  
  public void b() {}
  
  public void b(Context paramContext)
  {
    a(a(paramContext));
  }
  
  public boolean c()
  {
    Object localObject = this.a.a;
    boolean bool2 = false;
    if ((localObject != null) && (this.a.a.k() != null))
    {
      localObject = this.a.a.k();
      if (((RIJFeedsType.p((AbsBaseArticleInfo)localObject)) || (RIJFeedsType.q((AbsBaseArticleInfo)localObject)) || (RIJFeedsType.s((AbsBaseArticleInfo)localObject)) || (RIJFeedsType.t((AbsBaseArticleInfo)localObject))) && (((AbsBaseArticleInfo)localObject).mChannelID != 70L)) {
        return false;
      }
      boolean bool1;
      if ((!this.a.b()) && (((AbsBaseArticleInfo)localObject).mChannelID != 70L))
      {
        bool1 = bool2;
        if (((AbsBaseArticleInfo)localObject).mSocialFeedInfo != null)
        {
          bool1 = bool2;
          if (((AbsBaseArticleInfo)localObject).mSocialFeedInfo.o != 1) {}
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
  
  protected void d()
  {
    ReportInfo localReportInfo = new ReportInfo();
    Object localObject2 = this.a.a.k();
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
  
  public void setLogic(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, IFaceDecoder paramIFaceDecoder)
  {
    this.b = paramReadInJoyBaseAdapter;
    this.c = paramIFaceDecoder;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderBase
 * JD-Core Version:    0.7.0.1
 */