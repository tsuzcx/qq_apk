package com.tencent.mobileqq.teamworkforgroup;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.GridOptPopBar;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.IGroupTeamWorkAdapter;
import com.tencent.mobileqq.teamwork.OnItemLongClickListener;
import com.tencent.mobileqq.teamwork.PadInfo;
import com.tencent.mobileqq.teamwork.TeamWorkConstants;
import com.tencent.mobileqq.teamwork.TeamWorkManager;
import com.tencent.mobileqq.teamwork.TeamWorkObserver;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkAdapterCreator;
import com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.api.ITroopSPUtilApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;
import com.tencent.widget.PopupMenuDialog.OnClickActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mqq.os.MqqHandler;

public class GroupTeamWorkListActivity
  extends IphoneTitleBarActivity
  implements Handler.Callback, View.OnClickListener, OnItemLongClickListener, AbsListView.OnScrollListener, OverScrollViewListener
{
  private View A;
  private TextView B;
  private ProgressBar C;
  private View D;
  private View E;
  private View F;
  private TextView G;
  private GridOptPopBar H;
  private boolean I = false;
  private boolean J = false;
  private boolean K = false;
  private boolean L = false;
  private long M;
  private PopupMenuDialog.OnClickActionListener N = new GroupTeamWorkListActivity.7(this);
  private volatile int O = 1;
  private QQCustomDialog P;
  public int a = 0;
  protected final MqqHandler b = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  TeamWorkManager c;
  ITeamWorkHandler d;
  List<GPadInfo> e = new ArrayList();
  RelativeLayout f;
  List<GroupPadTemplateInfo> g = new ArrayList();
  GroupTeamWorkManager h;
  IGroupTeamWorkHandler i;
  public Dialog j = null;
  TextView k;
  EditText l;
  public long m;
  Comparator<PadInfo> n = new GroupTeamWorkListActivity.9(this);
  volatile boolean o = false;
  public int p = 0;
  GroupTeamWorkObserver q = new GroupTeamWorkListActivity.16(this);
  TeamWorkObserver r = new GroupTeamWorkListActivity.17(this);
  private View s;
  private HorizontalListView t;
  private GroupPadTemplateAdapter u;
  private View v;
  private FPSSwipListView w;
  private PullRefreshHeader x;
  private IGroupTeamWorkAdapter y;
  private View z;
  
  private void a()
  {
    this.v = findViewById(2131445137);
    this.D = findViewById(2131446949);
    this.E = findViewById(2131446948);
    this.E.setOnClickListener(this);
    this.F = findViewById(2131446934);
    this.G = ((TextView)findViewById(2131446936));
    this.w = ((FPSSwipListView)findViewById(2131437272));
    this.w.setDragEnable(true);
    this.w.setDivider(null);
    this.w.setOnScrollListener(this);
    this.w.setOverScrollListener(this);
    this.w.setOverscrollHeader(getResources().getDrawable(2130839580));
    View localView = LayoutInflater.from(this).inflate(2131629377, this.w, false);
    Object localObject = new LinearLayout(this);
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).addView(localView);
    this.w.addHeaderView((View)localObject);
    this.s = LayoutInflater.from(this).inflate(2131629507, this.w, false);
    this.t = ((HorizontalListView)this.s.findViewById(2131434438));
    localObject = this.t;
    if (localObject != null)
    {
      ((HorizontalListView)localObject).setVisibility(0);
      this.t.setDividerWidth(getResources().getDimensionPixelSize(2131297568));
    }
    this.w.addHeaderView(this.s);
    this.k = ((TextView)this.s.findViewById(2131448724));
    this.l = ((EditText)this.s.findViewById(2131432634));
    this.l.setCursorVisible(false);
    this.l.setOnFocusChangeListener(new GroupTeamWorkListActivity.4(this));
    this.x = ((PullRefreshHeader)LayoutInflater.from(this).inflate(2131625671, null));
    this.w.setOverScrollHeader(this.x);
    this.z = LayoutInflater.from(this).inflate(2131629380, null);
    this.A = this.z.findViewById(2131446952);
    this.B = ((TextView)this.z.findViewById(2131446951));
    this.C = ((ProgressBar)this.z.findViewById(2131446950));
    this.w.addFooterView(this.z);
    b();
    this.f = ((RelativeLayout)findViewById(2131444897));
    localObject = new ArrayList();
    ((List)localObject).add(GridOptPopBar.c);
    ((List)localObject).add(GridOptPopBar.d);
    ((List)localObject).add(GridOptPopBar.e);
    this.H = new GridOptPopBar(this, (List)localObject, this.N);
    this.w.setVisibility(8);
    this.D.setVisibility(0);
    if (SharedPreUtils.ab(this, this.app.getCurrentUin(), 1))
    {
      new GroupTeamWorkListActivity.5(this);
      localView.setVisibility(0);
      localObject = (TextView)localView.findViewById(2131430845);
      FixSizeImageView localFixSizeImageView = (FixSizeImageView)localView.findViewById(2131430844);
      ((TextView)localObject).setText(getString(2131887817));
      ((TextView)localObject).setMovementMethod(LinkMovementMethod.getInstance());
      localFixSizeImageView.setOnClickListener(new GroupTeamWorkListActivity.6(this, localView));
      return;
    }
    localView.setVisibility(8);
  }
  
  private void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    IGroupTeamWorkHandler localIGroupTeamWorkHandler = this.i;
    if (localIGroupTeamWorkHandler != null)
    {
      localIGroupTeamWorkHandler.getGroupTeamWorkList(paramLong, paramInt1, paramInt2, paramInt3);
      this.i.getGroupPadTemplateList(paramLong);
    }
  }
  
  private void a(List<GPadInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.e.clear();
    this.e.addAll(paramList);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.C.setVisibility(0);
      this.B.setText(2131917125);
      this.A.setVisibility(0);
      return;
    }
    this.C.setVisibility(8);
    this.B.setText(2131917126);
    this.A.setVisibility(0);
  }
  
  private void b()
  {
    this.leftView.setText(getResources().getString(2131890198));
    this.leftView.setBackgroundResource(2130853297);
    this.rightViewImg.setVisibility(0);
    this.rightViewImg.setImageResource(2130841074);
    this.rightViewImg.setOnClickListener(this);
    this.centerView.setMaxEms(13);
    this.centerView.setText(getResources().getString(2131890196));
    this.centerView.setOnClickListener(this);
  }
  
  private void b(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.8(this, paramInt), null, true);
  }
  
  private void b(List<GroupPadTemplateInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    this.g.clear();
    this.g.addAll(paramList);
  }
  
  private void c()
  {
    QQCustomDialog localQQCustomDialog = this.P;
    if (localQQCustomDialog != null)
    {
      if (localQQCustomDialog.isShowing()) {
        try
        {
          this.P.dismiss();
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" dismiss exception: ");
          localStringBuilder.append(localException.toString());
          QLog.e("GroupTeamWorkListActivity", 1, localStringBuilder.toString());
        }
      }
      this.P = null;
    }
  }
  
  private void c(int paramInt)
  {
    ThreadManager.postImmediately(new GroupTeamWorkListActivity.10(this, paramInt), null, true);
  }
  
  private void c(PadInfo paramPadInfo)
  {
    c();
    if (paramPadInfo == null) {
      return;
    }
    String str1 = getString(2131892267);
    if ((this.a != 1) && ((paramPadInfo.creatorUin <= 0L) || (!this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin)))))
    {
      if (TroopUtils.a(this.app, this.m, this.app.getCurrentAccountUin()))
      {
        if (paramPadInfo.type == 1)
        {
          str1 = getString(2131888448);
          str2 = getString(2131888434);
        }
        else
        {
          str1 = getString(2131888450);
          str2 = getString(2131888434);
        }
      }
      else
      {
        str2 = "";
        str3 = str1;
        break label182;
      }
    }
    else if (paramPadInfo.type == 1)
    {
      str1 = getString(2131888449);
      str2 = getString(2131888434);
    }
    else
    {
      str1 = getString(2131888451);
      str2 = getString(2131888434);
    }
    String str3 = str2;
    String str2 = str1;
    label182:
    if ((paramPadInfo.creatorUin > 0L) && (this.app.getCurrentAccountUin().equalsIgnoreCase(String.valueOf(paramPadInfo.creatorUin))))
    {
      this.P = DialogUtil.b(this, 230, null, str2, getString(2131888453), getString(2131887648), str3, new GroupTeamWorkListActivity.11(this), new GroupTeamWorkListActivity.12(this, paramPadInfo), new GroupTeamWorkListActivity.13(this));
    }
    else
    {
      this.P = DialogUtil.a(this, 230).setMessage(str2);
      this.P.setPositiveButton(str3, new GroupTeamWorkListActivity.14(this, paramPadInfo));
      this.P.setNegativeButton(getString(2131887648), new GroupTeamWorkListActivity.15(this));
    }
    this.P.show();
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      this.o = true;
      startTitleProgress();
      return;
    }
    if (paramInt == 2)
    {
      this.o = false;
      stopTitleProgress();
    }
  }
  
  public void a(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url))) {
      c(paramPadInfo);
    }
  }
  
  public void b(PadInfo paramPadInfo)
  {
    if ((paramPadInfo != null) && (!TextUtils.isEmpty(paramPadInfo.pad_url)))
    {
      String str1 = paramPadInfo.pad_url;
      String str2 = paramPadInfo.title;
      String str3 = String.valueOf(paramPadInfo.creatorUin);
      Intent localIntent = new Intent(getApplicationContext(), TeamWorkTransparentShareActivity.class);
      if ((!TextUtils.isEmpty(str3)) && (str3.equals(getCurrentAccountUin()))) {
        localIntent.putExtra("team_is_my_document", true);
      }
      if (!TextUtils.isEmpty(str2)) {
        localIntent.putExtra(TeamWorkConstants.a, str2);
      }
      if (!TextUtils.isEmpty(str1)) {
        localIntent.putExtra("team_work_pad_url", str1);
      }
      localIntent.putExtra("team_policy", paramPadInfo.policy);
      localIntent.putExtra("team_work_pad_list_type", paramPadInfo.type_list);
      localIntent.putExtra("team_work_pad_type", paramPadInfo.type);
      localIntent.putExtra("from_activity", "GroupTeamWorkListActivity");
      localIntent.putExtra("select_type", this.a);
      overridePendingTransition(0, 0);
      startActivity(localIntent);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" onActivityResult,requestCode=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",resultCode=");
      localStringBuilder.append(paramInt2);
      QLog.d("GroupTeamWorkListActivity", 2, localStringBuilder.toString());
    }
    if (paramInt1 == 14001)
    {
      a(this.m, 0, 20, 1);
      this.L = true;
    }
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131624972);
    this.m = getIntent().getLongExtra(TeamWorkConstants.e, 0L);
    this.i = ((IGroupTeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.GROUP_TEAM_WORK_HANDLER));
    this.h = ((GroupTeamWorkManager)this.app.getManager(QQManagerFactory.GROUP_TEAM_WORK_MANAGER));
    this.d = ((ITeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TEAM_WORK_HANDLER));
    this.c = ((TeamWorkManager)this.app.getManager(QQManagerFactory.TEAMWORK_MANAGER));
    this.y = ((IGroupTeamWorkAdapterCreator)QRoute.api(IGroupTeamWorkAdapterCreator.class)).getGroupTeamWorkAdapter(this.app, this, this, null);
    a();
    this.app.addObserver(this.q);
    this.app.addObserver(this.r);
    paramBundle = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
    if (paramBundle != null)
    {
      paramBundle = paramBundle.f(String.valueOf(this.m));
      if (paramBundle != null) {
        this.M = paramBundle.dwGroupClassExt;
      }
    }
    b(1);
    ((TroopInfoManager)this.app.getManager(QQManagerFactory.TROOPINFO_MANAGER)).a(this.app.getApp(), String.valueOf(this.m), "TIM_GROUP_TM_REDDOT", false);
    ((IGroupTeamWorkHandler)this.app.getBusinessHandler(BusinessHandlerFactory.GROUP_TEAM_WORK_HANDLER)).getGroupTeamWorkListLastAddTime(this.m);
    this.L = true;
    this.w.setAdapter(this.y);
    this.y.a(new GroupTeamWorkListActivity.1(this));
    this.y.a(this.e);
    this.u = new GroupPadTemplateAdapter(this, this);
    c(1);
    this.t.setAdapter(this.u);
    this.u.a(this.g);
    this.u.notifyDataSetChanged();
    this.u.a(new GroupTeamWorkListActivity.2(this));
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.H;
    if (localObject != null) {
      ((GridOptPopBar)localObject).a();
    }
    localObject = this.b;
    if (localObject != null)
    {
      ((MqqHandler)localObject).removeMessages(114);
      this.b.removeMessages(111);
      this.b.removeMessages(112);
    }
    ((ITroopSPUtilApi)QRoute.api(ITroopSPUtilApi.class)).setGroupTIMFileNewsInfo(this.app.getCurrentAccountUin(), "group_file_inner_reddot_tim", String.valueOf(this.m), false);
    this.app.removeObserver(this.q);
    this.app.removeObserver(this.r);
    c();
    if (this.u != null) {
      this.u = null;
    }
    super.doOnDestroy();
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    GridOptPopBar localGridOptPopBar = this.H;
    if (localGridOptPopBar != null) {
      localGridOptPopBar.a();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    ThreadManager.getUIHandler().postDelayed(new GroupTeamWorkListActivity.3(this), 100L);
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    default: 
      return true;
    case 115: 
      if (this.u != null) {
        synchronized (this.g)
        {
          this.u.a(this.g);
          if (this.u.getCount() > 0)
          {
            this.t.setVisibility(0);
            return true;
          }
        }
      }
      break;
    case 114: 
      this.b.removeMessages(114);
      if (this.C.getVisibility() == 8)
      {
        this.A.setVisibility(8);
        return true;
      }
      break;
    case 113: 
      if (this.y != null)
      {
        int i1 = ???.arg1;
        i1 = ???.arg2;
        if (i1 == 4) {
          a(false);
        }
        synchronized (this.e)
        {
          this.y.a(this.e);
          if (i1 == 1)
          {
            if (this.y.getCount() > 0)
            {
              if (this.D.getVisibility() == 0) {
                this.D.setVisibility(8);
              }
              if (this.F.getVisibility() == 0) {
                this.F.setVisibility(8);
              }
              this.w.setVisibility(0);
              if (this.L) {
                a(1);
              }
            }
          }
          else if (this.y.getCount() > 0)
          {
            if (this.D.getVisibility() == 0) {
              this.D.setVisibility(8);
            }
            if (this.F.getVisibility() == 0) {
              this.F.setVisibility(8);
            }
            this.w.setVisibility(0);
            if (this.w.getLastVisiblePosition() - this.w.getFirstVisiblePosition() + 1 >= this.y.getCount()) {
              this.A.setVisibility(8);
            }
          }
          else
          {
            if (this.D.getVisibility() == 0) {
              this.D.setVisibility(8);
            }
            if (this.w.getVisibility() == 0) {
              this.w.setVisibility(8);
            }
            this.F.setVisibility(0);
          }
          if ((this.o) || (i1 == 5))
          {
            a(2);
            return true;
          }
        }
      }
      break;
    case 112: 
      ??? = this.w;
      if (??? != null)
      {
        ???.springBackOverScrollHeaderView();
        return true;
      }
      break;
    case 111: 
      if (this.x != null) {
        if (???.arg1 == 1) {
          this.x.a(0);
        } else {
          this.x.a(1);
        }
      }
      ??? = new Message();
      ???.what = 112;
      this.b.sendMessageDelayed(???, 500L);
    }
    return true;
  }
  
  protected boolean onBackEvent()
  {
    GridOptPopBar localGridOptPopBar = this.H;
    if (localGridOptPopBar != null) {
      localGridOptPopBar.a();
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if (i1 != 2131436194)
    {
      if (i1 == 2131446948)
      {
        a(this.m, 0, 20, 1);
        this.E.setVisibility(8);
        this.D.setVisibility(0);
      }
    }
    else
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).report(this.app, "0X800993A");
      GridOptPopBar localGridOptPopBar = this.H;
      if (localGridOptPopBar != null)
      {
        RelativeLayout localRelativeLayout = this.f;
        localGridOptPopBar.a(localRelativeLayout, localRelativeLayout.getWidth() - getResources().getDimensionPixelSize(2131299624), getResources().getDimensionPixelSize(2131299621));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).c(0L);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 != 0) && (paramInt1 + paramInt2 == paramInt3))
    {
      this.I = true;
      if (paramInt3 <= paramInt2)
      {
        this.J = false;
        return;
      }
      this.J = true;
      return;
    }
    this.I = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (this.I)
    {
      paramAbsListView = this.y;
      if ((paramAbsListView != null) && (paramAbsListView.getCount() > 0) && (this.J) && (paramInt != 0))
      {
        if (this.p != 0)
        {
          a(true);
          a(this.m, this.p, 20, 3);
          return;
        }
        a(false);
        this.b.sendEmptyMessageDelayed(114, 1500L);
      }
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).b(0L);
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    ((PullRefreshHeader)paramView).a(0L);
    a(this.m, 0, 20, 2);
    this.K = true;
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.GroupTeamWorkListActivity
 * JD-Core Version:    0.7.0.1
 */