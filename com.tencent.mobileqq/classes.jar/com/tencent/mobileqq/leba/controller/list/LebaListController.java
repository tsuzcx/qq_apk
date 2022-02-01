package com.tencent.mobileqq.leba.controller.list;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.fpsreport.FPSXListView;
import com.tencent.mobileqq.leba.controller.ILebaController;
import com.tencent.mobileqq.leba.entity.InitViewParam;
import com.tencent.mobileqq.leba.entity.LebaItemListener;
import com.tencent.mobileqq.leba.redtouch.LebaRedTouchBase;
import com.tencent.mobileqq.leba.utils.LebaPluginViewUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaListController
  implements ILebaController
{
  private LebaListViewAdapter a;
  private LebaItemListener b;
  private LebaRedTouchBase c = new LebaListController.LebaListRedTouch(null);
  private View d;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131437053);
    localView.setBackgroundResource(2130852486);
    RoundRelativeLayout localRoundRelativeLayout = (RoundRelativeLayout)localView.findViewById(2131445177);
    localRoundRelativeLayout.b = ViewUtils.dpToPx(16.0F);
    localRoundRelativeLayout.setVisibility(8);
    localView.findViewById(2131432634).setBackgroundResource(2130852498);
    paramView.findViewById(2131446773).setVisibility(8);
    ((FrameLayout)paramView.findViewById(2131433238)).setVisibility(8);
  }
  
  private void b(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    paramView = (RelativeLayout)paramView.findViewById(2131443583);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839577);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject1 = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).height = localResources.getDimensionPixelSize(2131297112);
    paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = (RoundRelativeLayout)paramView.findViewById(2131445175);
    ((RoundRelativeLayout)localObject1).b = ViewUtils.dpToPx(16.0F);
    ((RoundRelativeLayout)localObject1).setVisibility(8);
    localObject1 = (ImageView)paramView.findViewById(2131437143);
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2130846953;
    } else {
      i = 2130846946;
    }
    ((ImageView)localObject1).setImageResource(i);
    Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(20.0F);
    localObject2 = (RelativeLayout)paramView.findViewById(2131444911);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams()).width = -2;
    localObject2 = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject2).findViewById(2131428776)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = localResources.getDimensionPixelSize(2131299052);
    ((RelativeLayout.LayoutParams)localObject2).height = localResources.getDimensionPixelSize(2131299051);
    localObject2 = (TextView)paramView.findViewById(2131437144);
    ((RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams()).leftMargin = localResources.getDimensionPixelSize(2131299054);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131443800)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
    LebaPluginViewUtil.a((ImageView)localObject1, (TextView)localObject2);
  }
  
  private void c(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    paramView = (RelativeLayout)paramView.findViewById(2131442545);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839577);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject1 = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).height = localResources.getDimensionPixelSize(2131297112);
    localObject1 = (RoundRelativeLayout)paramView.findViewById(2131445175);
    ((RoundRelativeLayout)localObject1).b = ViewUtils.dpToPx(16.0F);
    ((RoundRelativeLayout)localObject1).setVisibility(8);
    localObject1 = (ImageView)paramView.findViewById(2131437143);
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2130846945;
    } else {
      i = 2130846950;
    }
    ((ImageView)localObject1).setImageResource(i);
    Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(20.0F);
    localObject2 = (RelativeLayout)paramView.findViewById(2131444911);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams()).width = -2;
    localObject2 = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject2).findViewById(2131428776)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = localResources.getDimensionPixelSize(2131299052);
    ((RelativeLayout.LayoutParams)localObject2).height = localResources.getDimensionPixelSize(2131299051);
    localObject2 = (TextView)paramView.findViewById(2131442550);
    ((RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams()).leftMargin = localResources.getDimensionPixelSize(2131299054);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131442552)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
    LebaPluginViewUtil.a((ImageView)localObject1, (TextView)localObject2);
  }
  
  private void d(View paramView)
  {
    Resources localResources = paramView.getContext().getResources();
    paramView = (RelativeLayout)paramView.findViewById(2131433352);
    ViewUtils.setViewBackground(paramView, null);
    paramView.setBackgroundResource(2130839577);
    paramView.setPadding(0, 0, 0, 0);
    Object localObject1 = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).leftMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).topMargin = 0;
    ((LinearLayout.LayoutParams)localObject1).height = localResources.getDimensionPixelSize(2131297112);
    localObject1 = (RoundRelativeLayout)paramView.findViewById(2131445175);
    ((RoundRelativeLayout)localObject1).b = ViewUtils.dpToPx(16.0F);
    ((RoundRelativeLayout)localObject1).setVisibility(8);
    localObject1 = (ImageView)paramView.findViewById(2131437143);
    Object localObject2 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject2).height = ViewUtils.dpToPx(24.0F);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ViewUtils.dip2px(20.0F);
    localObject2 = (RelativeLayout)paramView.findViewById(2131444911);
    ((RelativeLayout.LayoutParams)((RelativeLayout)localObject2).getLayoutParams()).width = -2;
    localObject2 = (RelativeLayout.LayoutParams)((ImageView)((RelativeLayout)localObject2).findViewById(2131428776)).getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject2).width = localResources.getDimensionPixelSize(2131299052);
    ((RelativeLayout.LayoutParams)localObject2).height = localResources.getDimensionPixelSize(2131299051);
    localObject2 = (TextView)paramView.findViewById(2131433375);
    ((RelativeLayout.LayoutParams)((TextView)localObject2).getLayoutParams()).leftMargin = localResources.getDimensionPixelSize(2131299054);
    ((RelativeLayout.LayoutParams)((TextView)paramView.findViewById(2131433385)).getLayoutParams()).leftMargin = ViewUtils.dip2px(14.0F);
    LebaPluginViewUtil.a((ImageView)localObject1, (TextView)localObject2);
  }
  
  public void a()
  {
    LebaListViewAdapter localLebaListViewAdapter = this.a;
    if (localLebaListViewAdapter != null) {
      localLebaListViewAdapter.b();
    }
  }
  
  public void a(InitViewParam paramInitViewParam)
  {
    QLog.i("Q.lebatab.LebaListController", 1, "init list ");
    AppRuntime localAppRuntime = paramInitViewParam.a;
    List localList = paramInitViewParam.b;
    Context localContext = paramInitViewParam.c;
    FPSXListView localFPSXListView = paramInitViewParam.d;
    View localView = paramInitViewParam.e;
    LebaItemListener localLebaItemListener = paramInitViewParam.f;
    this.d = paramInitViewParam.e;
    if (localFPSXListView == null)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "initView lebaSV == null ");
      return;
    }
    if (localLebaItemListener != null) {
      this.b = localLebaItemListener;
    }
    try
    {
      if (localFPSXListView.getOverscrollHeader() == null) {
        localFPSXListView.setOverscrollHeader(localContext.getResources().getDrawable(2130852377));
      }
    }
    catch (Exception paramInitViewParam)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramInitViewParam);
    }
    if (localView != null) {
      try
      {
        if (localFPSXListView.getHeaderViewsCount() <= 0) {
          localFPSXListView.addHeaderView(localView);
        }
        a(localView);
        b(localView);
        c(localView);
        d(this.d);
      }
      catch (Exception paramInitViewParam)
      {
        QLog.i("Q.lebatab.LebaListController", 1, "addHeaderView ", paramInitViewParam);
      }
    }
    try
    {
      if (this.a == null)
      {
        this.a = new LebaListViewAdapter(localContext, localList, 2131624719, 2131624721, localAppRuntime, localFPSXListView, new LebaListController.1(this));
        this.a.a();
        localFPSXListView.setAdapter(this.a);
      }
    }
    catch (Exception paramInitViewParam)
    {
      QLog.i("Q.lebatab.LebaListController", 1, "setAdapter ", paramInitViewParam);
    }
    this.a.a(localAppRuntime);
    this.a.a(localList);
    this.a.a(this.c);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt) {}
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((LebaListViewAdapter)localObject).a(paramInt1, paramBoolean, paramInt2);
    }
    localObject = this.c;
    if (localObject != null) {
      ((LebaRedTouchBase)localObject).a(paramAppRuntime);
    }
  }
  
  public void b()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      a((View)localObject);
      b(this.d);
      c(this.d);
      d(this.d);
    }
    localObject = this.a;
    if (localObject != null) {
      ((LebaListViewAdapter)localObject).d();
    }
  }
  
  public void c()
  {
    LebaListViewAdapter localLebaListViewAdapter = this.a;
    if (localLebaListViewAdapter != null) {
      localLebaListViewAdapter.notifyDataSetChanged();
    }
  }
  
  public int d()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.list.LebaListController
 * JD-Core Version:    0.7.0.1
 */