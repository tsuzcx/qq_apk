package com.tencent.mobileqq.trooponline;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.StoryHomeHorizontalListView.OnOverScrollRightListener;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberService;
import com.tencent.mobileqq.troop.onlinemember.data.TroopOnlineMemberItem;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.os.MqqHandler;

public class TroopOnlineMemberBar
  implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, StoryHomeHorizontalListView.OnOverScrollRightListener
{
  public static final int a = UIUtils.a(BaseApplicationImpl.getContext(), 112.0F);
  protected QQAppInterface b;
  protected Context c;
  protected StoryHomeHorizontalListView d;
  protected TroopOnlineMemberListAdapter e;
  protected RelativeLayout f;
  protected RelativeLayout g;
  protected String h;
  protected ValueAnimator i;
  protected ValueAnimator j;
  protected boolean k;
  protected ITroopOnlineMemberService l;
  protected TroopAioTips m;
  public int n = 1;
  public int o = 0;
  Animatable p = null;
  TextView q = null;
  ViewGroup r = null;
  private int s = 1;
  private ValueAnimator.AnimatorUpdateListener t = new TroopOnlineMemberBar.2(this);
  private ValueAnimator.AnimatorUpdateListener u = new TroopOnlineMemberBar.3(this);
  
  public TroopOnlineMemberBar(QQAppInterface paramQQAppInterface, Context paramContext, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, TroopAioTips paramTroopAioTips)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.f = paramRelativeLayout1;
    this.m = paramTroopAioTips;
    this.g = paramRelativeLayout2;
    this.l = ((ITroopOnlineMemberService)paramQQAppInterface.getRuntimeService(ITroopOnlineMemberService.class, ""));
    paramQQAppInterface = this.c;
    if ((paramQQAppInterface instanceof Activity)) {
      this.o = StatusBarUtil.a((Activity)paramQQAppInterface);
    }
  }
  
  private void h()
  {
    Object localObject = this.p;
    if ((localObject != null) && (((Animatable)localObject).isRunning())) {
      this.p.stop();
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      this.q.setVisibility(8);
    }
  }
  
  public void a()
  {
    int i1 = this.f.getChildCount() - 1;
    while (i1 >= 0)
    {
      localObject = this.f.getChildAt(i1);
      ViewGroup localViewGroup = this.r;
      if (localObject == localViewGroup) {
        this.f.removeView(localViewGroup);
      }
      i1 -= 1;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((ValueAnimator)localObject).removeUpdateListener(this.t);
    }
    localObject = this.j;
    if (localObject != null) {
      ((ValueAnimator)localObject).removeUpdateListener(this.u);
    }
  }
  
  public void a(int paramInt)
  {
    this.s = paramInt;
    if (this.r == null) {
      this.r = ((ViewGroup)LayoutInflater.from(this.c).inflate(2131626653, null));
    }
    if (this.d == null)
    {
      this.d = ((StoryHomeHorizontalListView)this.r.findViewById(2131448070));
      this.d.setOnItemClickListener(this);
      this.d.setOnItemLongClickListener(this);
      this.d.setOnOverScrollRightListener(this);
      if (ThemeUtil.isNowThemeIsNight(this.b, false, null)) {
        this.d.setBackgroundColor(-16445151);
      } else {
        this.d.setBackgroundColor(-436207617);
      }
      this.e = new TroopOnlineMemberListAdapter(this.b, this.h);
      this.d.setAdapter(this.e);
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      this.d.setDataCount(2147483647);
      this.f.addView(this.r, (ViewGroup.LayoutParams)localObject);
    }
    h();
    Object localObject = ((ITroopOnlineMemberService)this.b.getRuntimeService(ITroopOnlineMemberService.class, "")).getDetailMemberListFromCache(this.h);
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.e.a((List)localObject);
      this.e.notifyDataSetChanged();
      this.s = 0;
    }
    else
    {
      if (this.q == null) {
        this.q = ((TextView)this.r.findViewById(2131428039));
      }
      this.e.a();
      this.e.notifyDataSetChanged();
      ThreadManager.getUIHandler().postDelayed(new TroopOnlineMemberBar.1(this), 500L);
      if (QLog.isColorLevel()) {
        QLog.i("TroopOnlineMemberBar", 2, "show(), itemList == null || itemList.empty");
      }
    }
    if (this.i == null)
    {
      this.i = ValueAnimator.ofInt(new int[] { -a + this.c.getResources().getDimensionPixelSize(2131299920) + this.o, this.c.getResources().getDimensionPixelSize(2131299920) + this.o });
      this.i.setDuration(500L);
      this.i.addUpdateListener(this.t);
    }
    this.d.setVisibility(0);
    localObject = this.m;
    if (localObject != null) {
      ((TroopAioTips)localObject).a(true);
    }
    this.i.start();
    this.k = true;
    if (this.n == 2)
    {
      TroopReportor.a("Grp_idol", "Grp_renshu", "exp", 0, 0, new String[] { this.h });
      return;
    }
    new ReportTask(this.b).a("dc00899").b("Grp_online").c("online_box").d("exp").a(new String[] { this.h }).a();
  }
  
  public void a(String paramString)
  {
    this.h = paramString;
    int i1 = this.l.getRequestListServiceType(this.h);
    if (i1 == 3)
    {
      this.n = 2;
      return;
    }
    if (i1 == 5)
    {
      this.n = 3;
      return;
    }
    this.n = 1;
  }
  
  public int b()
  {
    if (this.d == null) {
      return this.s;
    }
    if (this.j == null)
    {
      this.j = ValueAnimator.ofInt(new int[] { this.c.getResources().getDimensionPixelSize(2131299920) + this.o, -a + this.c.getResources().getDimensionPixelSize(2131299920) + this.o });
      this.j.setDuration(500L);
      this.j.addUpdateListener(this.u);
    }
    TextView localTextView = this.q;
    if ((localTextView != null) && (localTextView.getVisibility() == 0)) {
      this.q.setVisibility(8);
    }
    this.j.start();
    this.k = false;
    this.e.b.clear();
    return this.s;
  }
  
  public void by_() {}
  
  public void c()
  {
    if (d())
    {
      List localList = ((ITroopOnlineMemberService)this.b.getRuntimeService(ITroopOnlineMemberService.class, "")).getDetailMemberListFromCache(this.h);
      if (localList != null)
      {
        this.s = 0;
        h();
        this.e.a(localList);
        this.e.notifyDataSetChanged();
      }
    }
  }
  
  public boolean d()
  {
    return this.k;
  }
  
  public void e()
  {
    int i2;
    int i1;
    if (this.n == 2)
    {
      i2 = 22;
      i1 = 8;
    }
    else
    {
      i2 = 17;
      i1 = 1;
    }
    if (this.n == 3) {
      i1 = 5;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("troop_uin", this.h);
    localIntent.putExtra("param_from", i2);
    localIntent.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131901576));
    localIntent.putExtra("sort_type", i1);
    RouteUtils.a(this.c, localIntent, "/troop/memberlist/TroopMemberList");
    if (this.n == 2)
    {
      TroopReportor.a("Grp_idol", "Grp_renshu", "right", 0, 0, new String[] { this.h });
      return;
    }
    new ReportTask(this.b).a("dc00899").b("Grp_online").c("online_box").d("enter_mberList").a(new String[] { this.h }).a();
  }
  
  public boolean g()
  {
    ValueAnimator localValueAnimator;
    if (this.k)
    {
      localValueAnimator = this.i;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {}
    }
    else
    {
      if (this.k) {
        break label48;
      }
      localValueAnimator = this.j;
      if ((localValueAnimator == null) || (!localValueAnimator.isRunning())) {
        break label48;
      }
    }
    return true;
    label48:
    return false;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    TroopOnlineMemberItem localTroopOnlineMemberItem = ((TroopOnlineMemberListAdapter.ViewHolder)paramView.getTag()).f;
    if (localTroopOnlineMemberItem != null)
    {
      if (localTroopOnlineMemberItem.a == 2) {
        TroopReportor.a("Grp_idol", "Grp_renshu", "clk", 0, 0, new String[] { this.h });
      } else {
        new ReportTask(this.b).a("dc00899").b("Grp_online").c("online_box").d("clk_mberHead").a(new String[] { this.h, localTroopOnlineMemberItem.c }).a();
      }
      if (!((ITroopRobotService)this.b.getRuntimeService(ITroopRobotService.class, "all")).checkAndProcessJumpRobotPage(this.c, this.h, Long.valueOf(localTroopOnlineMemberItem.b).longValue())) {
        TroopMemberCardUtils.a(this.b, (Activity)this.c, this.h, localTroopOnlineMemberItem.b, 0, -1);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
  
  public boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (TroopOnlineMemberListAdapter.ViewHolder)paramView.getTag();
    paramView = paramAdapterView.f;
    TroopChatPie localTroopChatPie = (TroopChatPie)((BaseActivity)this.c).getChatFragment().k();
    if (localTroopChatPie != null) {
      localTroopChatPie.a(paramView.b, paramAdapterView.e.getText().toString(), false, 1);
    }
    new ReportTask(this.b).a("dc00899").b("Grp_online").c("online_box").d("press_mberHead").a(new String[] { this.h, paramView.c }).a();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar
 * JD-Core Version:    0.7.0.1
 */