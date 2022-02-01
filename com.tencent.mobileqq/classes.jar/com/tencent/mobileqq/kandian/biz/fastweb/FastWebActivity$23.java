package com.tencent.mobileqq.kandian.biz.fastweb;

import android.text.TextUtils;
import android.view.View;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentListAdapter;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentReportManager;
import com.tencent.mobileqq.kandian.biz.fastweb.adapter.WebFastAdapter;
import com.tencent.mobileqq.kandian.biz.fastweb.event.FastWebAdapterShowHelper;
import com.tencent.mobileqq.kandian.biz.fastweb.event.ItemShowDispatcher;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ReportUtil;
import com.tencent.mobileqq.kandian.biz.hippy.tuwen.view.ReadInJoyCommentListView;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskArticleTimer;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class FastWebActivity$23
  implements AbsListView.OnScrollListener
{
  FastWebActivity$23(FastWebActivity paramFastWebActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (FastWebActivity.a(this.a) != null)
    {
      FastWebActivity.a(this.a).a(paramAbsListView, paramInt1, paramInt2, paramInt3);
      FastWebActivity.a(this.a).a(this.a.app, paramAbsListView, paramInt1, paramInt2);
    }
    FastWebActivity.a(this.a).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).a(FastWebActivity.a(this.a), FastWebActivity.a(this.a).getFirstVisiblePosition(), paramInt2);
    }
    FastWebActivity localFastWebActivity = this.a;
    paramInt2 += paramInt1;
    FastWebActivity.a(localFastWebActivity, paramAbsListView, paramInt2 - 1, false);
    FastWebActivity.b(this.a, 0);
    paramAbsListView = paramAbsListView.getChildAt(0);
    if ((paramAbsListView != null) && (FastWebActivity.c(this.a) != paramAbsListView.getTop()))
    {
      FastWebActivity.c(this.a, paramAbsListView.getTop());
      FastWebActivity.a(this.a).resetStationaryTime();
    }
    if ((paramAbsListView != null) && (paramAbsListView.getTop() == 0) && (paramInt1 == 0))
    {
      QLog.d("FastWebActivity", 2, "on scroller top");
      FastWebActivity.b(this.a, 1);
    }
    if (paramInt2 == paramInt3)
    {
      QLog.d("FastWebActivity", 2, "on scroller bottom");
      FastWebActivity.b(this.a, 2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    Object localObject1 = this.a;
    boolean bool1 = FastWebActivity.a((FastWebActivity)localObject1, FastWebActivity.a((FastWebActivity)localObject1).getLastVisiblePosition());
    if (bool1) {
      localObject1 = "list_comment_kandian";
    } else {
      localObject1 = "list_kandian_native_web";
    }
    Object localObject2 = localObject1;
    if (PTSLiteSwitchManager.a().b())
    {
      localObject2 = localObject1;
      if (TextUtils.equals((CharSequence)localObject1, "list_kandian_native_web")) {
        localObject2 = "list_kandian_native_web_lite";
      }
    }
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      int i = FastWebActivity.a(this.a).getFirstVisiblePosition();
      FastWebActivity.g(this.a);
      localObject1 = this.a;
      FastWebActivity.a((FastWebActivity)localObject1, i, FastWebActivity.a((FastWebActivity)localObject1));
      DropFrameMonitor.a().a((String)localObject2, false);
    }
    else
    {
      AbstractGifImage.pauseAll();
      DropFrameMonitor.a().a((String)localObject2);
    }
    localObject1 = this.a;
    boolean bool2 = FastWebActivity.b((FastWebActivity)localObject1, FastWebActivity.a((FastWebActivity)localObject1).getFirstVisiblePosition());
    ReportUtil.a(paramAbsListView, paramInt, this.a.a.innerUniqueID, FastWebActivity.a(this.a, paramAbsListView, paramInt), bool2);
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
    }
    FastWebActivity.a(this.a).onScrollStateChanged(paramAbsListView, paramInt);
    FastWebActivity.h(this.a);
    if (FastWebActivity.a(this.a) != null) {
      FastWebActivity.a(this.a).a(paramAbsListView, paramInt);
    }
    if (paramInt == 1) {
      FastWebActivity.g(this.a);
    }
    if (bool1)
    {
      FastWebActivity.a(this.a).a();
      if ((FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a) != null) && (FastWebActivity.a(this.a).a() != null)) {
        FastWebActivity.a(this.a).a().a(FastWebActivity.a(this.a).getFirstVisiblePosition() - FastWebActivity.a(this.a).getCount(), FastWebActivity.a(this.a).getLastVisiblePosition() - FastWebActivity.a(this.a).getCount());
      }
    }
    else
    {
      FastWebActivity.a(this.a).b();
    }
    this.a.a(paramAbsListView, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.23
 * JD-Core Version:    0.7.0.1
 */