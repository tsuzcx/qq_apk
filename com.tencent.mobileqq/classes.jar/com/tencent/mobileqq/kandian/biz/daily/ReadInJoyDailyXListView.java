package com.tencent.mobileqq.kandian.biz.daily;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView.RefreshCallback;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.factory.TemplateFactory;
import com.tencent.mobileqq.kandian.biz.pullrefresh.ReadInJoyAnimBaseManager;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.KandianDailyReportUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

public class ReadInJoyDailyXListView
  extends ReadInJoyXListView
  implements ReadInJoyOverScrollViewListener
{
  private Container A;
  protected List<OverScrollViewListener> w;
  private ColorDrawable x = new ColorDrawable(-1);
  private boolean y = false;
  private boolean z = false;
  
  public ReadInJoyDailyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyDailyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private boolean l()
  {
    ListAdapter localListAdapter = getAdapter();
    boolean bool = false;
    if (localListAdapter == null) {
      return false;
    }
    if (getLastVisiblePosition() >= getAdapter().getCount() - 1) {
      bool = true;
    }
    return bool;
  }
  
  private void m()
  {
    if (this.z) {
      return;
    }
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.g();
    if (ReadInJoyDailyViewController.m() == 1) {}
    while ((!TextUtils.isEmpty(DailyModeConfigHandler.c())) && (ReadInJoyDailyViewController.m() == 3))
    {
      str = "1";
      break;
    }
    String str = "0";
    localReportR5Builder.addStringNotThrow("is_jump", str);
    localReportR5Builder.addStringNotThrow("cmd", ReadInJoyHelper.O());
    if ("1".equals(str)) {
      localReportR5Builder.addStringNotThrow("jump_src", DailyModeConfigHandler.e());
    }
    this.z = true;
    PublicAccountReportUtils.a(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", localReportR5Builder.build(), false);
  }
  
  protected void a(int paramInt)
  {
    if (!this.y) {
      return;
    }
    if (paramInt != 4)
    {
      setFooterView(true);
      if (this.g != null)
      {
        this.c.setVisibility(0);
        this.a.setText(2131915649);
        this.b.setVisibility(0);
        this.f = 1;
        this.g.b(this, paramInt);
      }
    }
    else
    {
      setFooterView(true);
      this.c.setVisibility(0);
      this.a.setText(2131915649);
      this.b.setVisibility(0);
      if (this.g != null)
      {
        this.f = 1;
        this.g.b(this, paramInt);
      }
    }
    QLog.d("ReadInJoyDailyXListView", 1, new Object[] { "loadingMore mCurrentStatus = ", Integer.valueOf(this.f), ", type = ", Integer.valueOf(paramInt) });
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    setNeedShowHeaderView(true);
    a(this);
    if (ReadInJoyDailyViewController.m() != 2)
    {
      a(this);
      return;
    }
    setCanLoadMore(true);
  }
  
  public void a(OverScrollViewListener paramOverScrollViewListener)
  {
    if (this.w == null)
    {
      this.w = new ArrayList();
      super.setOverScrollListener(new ReadInJoyDailyXListView.3(this));
    }
    this.w.add(paramOverScrollViewListener);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    removeFooterView(this.c);
    this.e = 0;
  }
  
  public void b(boolean paramBoolean)
  {
    super.b(paramBoolean);
  }
  
  public void d()
  {
    super.d();
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
  }
  
  public ReadInJoyAnimBaseManager e(int paramInt)
  {
    return (ReadInJoyAnimBaseManager)super.b(paramInt);
  }
  
  public void e()
  {
    super.e();
  }
  
  public void f()
  {
    super.f();
  }
  
  public void g()
  {
    QLog.d("ReadInJoyDailyXListView", 2, "scroll2TopAndRefresh : ");
  }
  
  public int getChennelId()
  {
    return this.i;
  }
  
  public int getTouchMode()
  {
    return this.mTouchMode;
  }
  
  public void k()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = TemplateFactory.a("default_feeds", true);
        if (localObject1 == null) {
          break label101;
        }
        localObject1 = ((TemplateFactory)localObject1).getTemplateBean(DailyModeConfigHandler.d());
        if ((localObject1 != null) && (this.A != null))
        {
          if (RIJThreadHandler.f())
          {
            ProteusSupportUtil.a(this.A, null, (TemplateBean)localObject1);
            return;
          }
          RIJThreadHandler.b().post(new ReadInJoyDailyXListView.2(this, (TemplateBean)localObject1));
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRefreshFooterView, e = ");
        localStringBuilder.append(localJSONException);
        QLog.e("ReadInJoyDailyXListView", 1, localStringBuilder.toString());
      }
      return;
      label101:
      Object localObject2 = null;
    }
  }
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramInt1 == 0) {
      super.onNotCompleteVisable(paramInt1, paramView, paramListView, paramInt2);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!this.y)
    {
      if (l()) {
        m();
      }
    }
    else if ((this.c != null) && (this.e < 0) && (this.f != 1) && (paramInt1 >= paramInt3 - paramInt2 * 2) && (!this.j)) {
      a(2);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      KandianDailyReportUtils.a(8);
    }
  }
  
  public void onScrollView(View paramView, ListView paramListView, int paramInt) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    super.onViewCompleteVisable(paramInt, paramView, paramListView);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if ((this.y) && (paramInt == 1))
    {
      a(2);
      return true;
    }
    if (paramInt == 0) {
      return super.onViewCompleteVisableAndReleased(paramInt, paramView, paramListView);
    }
    return false;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    if ((paramListAdapter != null) && ((paramListAdapter instanceof ReadInJoyBaseAdapter))) {
      ((ReadInJoyBaseAdapter)paramListAdapter).a(new ReadInJoyDailyXListView.1(this));
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(-1);
  }
  
  public void setCanLoadMore(boolean paramBoolean)
  {
    this.y = paramBoolean;
    setOverScrollTouchMode(1);
    if ((paramBoolean) && (this.c == null)) {
      a();
    }
  }
  
  public void setChannelId(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setContentBackground(Drawable paramDrawable, boolean paramBoolean)
  {
    super.setContentBackground(this.x, false);
  }
  
  public void setFooterView(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean) {
      bool = this.y;
    }
    super.setFooterView(bool);
  }
  
  public void setNeedShowFootView(boolean paramBoolean) {}
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    super.setNeedShowHeaderView(paramBoolean);
  }
  
  public void setNoMoreData(boolean paramBoolean) {}
  
  public void setOverScrollListener(OverScrollViewListener paramOverScrollViewListener)
  {
    if (paramOverScrollViewListener != null) {
      this.w.add(paramOverScrollViewListener);
    }
  }
  
  public void setPTSFooterView(Container paramContainer)
  {
    this.A = paramContainer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyXListView
 * JD-Core Version:    0.7.0.1
 */