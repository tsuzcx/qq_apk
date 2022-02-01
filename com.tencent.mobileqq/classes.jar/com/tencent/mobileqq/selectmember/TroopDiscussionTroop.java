package com.tencent.mobileqq.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import mqq.app.AppRuntime;

public class TroopDiscussionTroop
  extends TroopDiscussionBaseV
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  TextView a = null;
  int b = getResources().getDimensionPixelSize(2131299976);
  private SwipPinnedHeaderExpandableListView c;
  private TroopDiscussionMemSelectAdapter i;
  private TroopDiscussionTroop.MyRoamSettingObserver j;
  private TroopDiscussionTroop.MyAvatarObserver k;
  private TroopDiscussionTroop.MyTroopModifyObserver l;
  private TroopDiscussionTroop.MyTroopMngObserver m;
  private TroopDiscussionTroop.MyTroopObserver n;
  private TroopDiscussionTroop.MyMessageObserver o;
  private AutomatorObserver p = new TroopDiscussionTroop.2(this);
  
  public TroopDiscussionTroop(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  private void d()
  {
    if (this.j == null) {
      this.j = new TroopDiscussionTroop.MyRoamSettingObserver(this);
    }
    if (this.k == null) {
      this.k = new TroopDiscussionTroop.MyAvatarObserver(this);
    }
    if (this.l == null) {
      this.l = new TroopDiscussionTroop.MyTroopModifyObserver(this);
    }
    if (this.m == null) {
      this.m = new TroopDiscussionTroop.MyTroopMngObserver(this);
    }
    if (this.n == null) {
      this.n = new TroopDiscussionTroop.MyTroopObserver(this);
    }
    if (this.o == null) {
      this.o = new TroopDiscussionTroop.MyMessageObserver(this);
    }
    this.f.addObserver(this.j);
    this.f.addObserver(this.k);
    this.f.addObserver(this.l);
    this.f.addObserver(this.m);
    this.f.addObserver(this.n);
    this.f.addObserver(this.o);
    this.f.addObserver(this.p);
  }
  
  private void g()
  {
    this.f.removeObserver(this.j);
    this.f.removeObserver(this.k);
    this.f.removeObserver(this.l);
    this.f.removeObserver(this.m);
    this.f.removeObserver(this.n);
    this.f.removeObserver(this.o);
    this.f.removeObserver(this.p);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    setContentView(2131626505);
    this.c = ((SwipPinnedHeaderExpandableListView)findViewById(2131450345));
    this.a = ((TextView)findViewById(2131448101));
    this.c.setSelector(2131168376);
    this.c.setNeedCheckSpringback(true);
    this.c.setGroupIndicator(null);
    this.c.setDivider(null);
    this.c.setPadding(0, 0, 0, CommonUtils.a(54.0F, getResources()));
    this.c.setChildDivider(null);
    this.c.setClipToPadding(false);
    this.c.setScrollBarStyle(33554432);
    this.i = new TroopDiscussionMemSelectAdapter(this.d, this.f, this.c, this);
    this.c.setAdapter(this.i);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
    }
    TroopDiscussionMemSelectAdapter localTroopDiscussionMemSelectAdapter = this.i;
    if (localTroopDiscussionMemSelectAdapter != null) {
      localTroopDiscussionMemSelectAdapter.b();
    }
    g();
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    d();
    this.c.postDelayed(new TroopDiscussionTroop.1(this), 200L);
  }
  
  void c()
  {
    TroopDiscussionMemSelectAdapter localTroopDiscussionMemSelectAdapter = this.i;
    if (localTroopDiscussionMemSelectAdapter != null) {
      localTroopDiscussionMemSelectAdapter.notifyDataSetChanged();
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (TroopDiscussionMemSelectAdapter.TroopViewHolder)paramView.getTag();
    Object localObject1;
    if ((localObject2 != null) && (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).c != null))
    {
      localObject1 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).c;
      boolean bool = this.d instanceof SelectMemberActivity;
      int i2 = 0;
      if ((bool) && (!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.f.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.f.getCurrentAccountUin())))
      {
        if (TextUtils.isEmpty(this.d.mGroupCode)) {
          QQToast.makeText(this.d, 0, this.d.getString(2131895397), 0).show(getResources().getDimensionPixelSize(2131299920));
        } else {
          QQToast.makeText(this.d, 0, this.d.getString(2131895399), 0).show(getResources().getDimensionPixelSize(2131299920));
        }
      }
      else
      {
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("group_uin", ((TroopInfo)localObject1).troopuin);
        ((Bundle)localObject3).putString("group_name", ((TroopInfo)localObject1).getTroopDisplayName());
        this.g.a(6, (Bundle)localObject3);
        int i3 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).e;
        int i1 = i2;
        if (i3 != 1) {
          if (i3 != 3)
          {
            if (i3 != 5)
            {
              if (i3 != 7) {
                i1 = i2;
              } else {
                i1 = 2;
              }
            }
            else {
              i1 = 1;
            }
          }
          else {
            i1 = 3;
          }
        }
        localObject2 = this.f;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TroopInfo)localObject1).troopuin);
        ((StringBuilder)localObject3).append("");
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((StringBuilder)localObject3).toString(), String.valueOf(i1), "", "");
      }
    }
    else if ((localObject2 != null) && (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).d != null))
    {
      localObject1 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).d;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
      ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
      this.g.a(7, (Bundle)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop
 * JD-Core Version:    0.7.0.1
 */