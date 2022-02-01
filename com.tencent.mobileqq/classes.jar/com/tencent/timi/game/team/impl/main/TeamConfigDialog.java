package com.tencent.timi.game.team.impl.main;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.expand.hall.api.HallReportHelper;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.GuildShequnParams;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.wrapper.IRoomGetDataService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.impl.config.SmobaConfigManager;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.ui.widget.IDialogLoading;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaConfigRsp;
import trpc.yes.common.GameDataServerOuterClass.SmobaBigGradeLevel;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomParams;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomSpeakingPosInfo;
import trpc.yes.common.YoloRoomOuterClass.YoloSmobaRoomParams;

public class TeamConfigDialog
  extends BaseSlideUpDialog
  implements View.OnClickListener, IDialogLoading
{
  private static final String i = "TeamConfigDialog";
  protected Map<String, List<Integer>> a = new HashMap();
  protected int b = 1;
  protected int c = 1;
  protected int d = 11;
  private TextView j;
  private TextView k;
  private EditText l;
  private ImageView m;
  private TeamSelectView n;
  private LevelSegmentSelectView o;
  private TeamSelectView p;
  private View q;
  private TextView r;
  private ImageView s;
  private ImageView t;
  private TimiGamePageLoadingView u;
  private int v;
  private TeamConfigBean w;
  private TeamConfigDialog.OnActionClickListener x;
  private List<String> y;
  private int z;
  
  private TeamConfigDialog(Context paramContext, int paramInt, TeamConfigBean paramTeamConfigBean, TeamConfigDialog.OnActionClickListener paramOnActionClickListener)
  {
    super(paramContext);
    a(paramInt, paramTeamConfigBean, paramOnActionClickListener);
  }
  
  public static TeamConfigDialog a(Context paramContext, TeamConfigBean paramTeamConfigBean, TeamConfigDialog.OnActionClickListener paramOnActionClickListener)
  {
    return new TeamConfigDialog(paramContext, 0, paramTeamConfigBean, paramOnActionClickListener);
  }
  
  private void a(int paramInt, TeamConfigBean paramTeamConfigBean, TeamConfigDialog.OnActionClickListener paramOnActionClickListener)
  {
    this.v = paramInt;
    this.w = paramTeamConfigBean;
    this.x = paramOnActionClickListener;
    paramInt = this.v;
    if (paramInt == 0)
    {
      if (paramTeamConfigBean != null)
      {
        if (paramTeamConfigBean.e != 0) {
          this.b = paramTeamConfigBean.e;
        }
        if (paramTeamConfigBean.c != 0) {
          this.c = paramTeamConfigBean.c;
        }
        if (paramTeamConfigBean.d != 0) {
          this.d = paramTeamConfigBean.d;
        }
      }
    }
    else if ((paramInt == 1) && (paramTeamConfigBean != null))
    {
      if (paramTeamConfigBean.e != 0) {
        this.b = paramTeamConfigBean.e;
      }
      if (paramTeamConfigBean.c != 0) {
        this.c = paramTeamConfigBean.c;
      }
      if (paramTeamConfigBean.d != 0) {
        this.d = paramTeamConfigBean.d;
      }
    }
  }
  
  public static void a(EditText paramEditText)
  {
    paramEditText.setFilters(new InputFilter[] { new TeamConfigDialog.3(), new InputFilter.LengthFilter(15) });
  }
  
  private void a(String paramString, int paramInt)
  {
    List localList = (List)this.a.get(paramString);
    if (localList == null)
    {
      this.a.put(paramString, f(paramInt));
      return;
    }
    localList.add(Integer.valueOf(paramInt));
  }
  
  private void a(List<GameDataServerOuterClass.SmobaBigGradeLevel> paramList)
  {
    this.a.clear();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      GameDataServerOuterClass.SmobaBigGradeLevel localSmobaBigGradeLevel = (GameDataServerOuterClass.SmobaBigGradeLevel)paramList.next();
      int i1 = localSmobaBigGradeLevel.big_grade_level.get();
      if (i1 < 7)
      {
        this.a.put(localSmobaBigGradeLevel.short_level_name.get(), f(localSmobaBigGradeLevel.big_grade_level.get()));
        localArrayList.add(localSmobaBigGradeLevel.short_level_name.get());
      }
      else if ((i1 != 7) && (i1 != 8))
      {
        if (this.a.get("荣耀") == null) {
          localArrayList.add("荣耀");
        }
        a("荣耀", localSmobaBigGradeLevel.big_grade_level.get());
      }
      else
      {
        if (this.a.get("王者") == null) {
          localArrayList.add("王者");
        }
        a("王者", localSmobaBigGradeLevel.big_grade_level.get());
      }
    }
    b(localArrayList);
  }
  
  public static TeamConfigDialog b(Context paramContext, TeamConfigBean paramTeamConfigBean, TeamConfigDialog.OnActionClickListener paramOnActionClickListener)
  {
    return new TeamConfigDialog(paramContext, 1, paramTeamConfigBean, paramOnActionClickListener);
  }
  
  private void b()
  {
    this.u = ((TimiGamePageLoadingView)findViewById(2131446924));
    this.q = findViewById(2131446916);
    this.j = ((TextView)findViewById(2131446930));
    this.k = ((TextView)findViewById(2131446921));
    this.l = ((EditText)findViewById(2131446917));
    this.m = ((ImageView)findViewById(2131446918));
    this.n = ((TeamSelectView)findViewById(2131446925));
    this.o = ((LevelSegmentSelectView)findViewById(2131446923));
    this.p = ((TeamSelectView)findViewById(2131446928));
    this.r = ((TextView)findViewById(2131446915));
    this.s = ((ImageView)findViewById(2131446912));
    this.t = ((ImageView)findViewById(2131446920));
    f();
    h();
    i();
    j();
    e();
    k();
    s();
    c();
  }
  
  private void b(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(15);
    localObject = ((StringBuilder)localObject).toString();
    this.k.setText((CharSequence)localObject);
  }
  
  private void b(List<String> paramList)
  {
    paramList = new ArrayList(paramList);
    this.o.a(paramList);
    this.o.post(new TeamConfigDialog.4(this));
  }
  
  private void c()
  {
    boolean bool;
    if (this.v == 0)
    {
      if (this.w.g == 2) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else {
      bool = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.w.f).o();
    }
    if (bool) {
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this, "pg_sgrp_smoba_cpdd");
    } else {
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this, "pg_kl_smoba_cpdd");
    }
    Object localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if (localObject != null)
    {
      localObject = ((IExpandHall)localObject).e();
      if (this.v == 0)
      {
        ((IReportService)ServiceCenter.a(IReportService.class)).a(this.r, true, "创建车队浮层立即创建按钮", "em_yes_createteam_panel_submit", ((HallReportHelper)localObject).s());
        ((IReportService)ServiceCenter.a(IReportService.class)).a(this.s, true, "创建车队浮层关闭按钮", "em_yes_createteam_panel_close", ((HallReportHelper)localObject).s());
      }
    }
    if ((this.v == 1) && (this.w.f != 0L))
    {
      localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.w.f).b();
      if (localObject == null) {
        return;
      }
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this.r, true, "设置浮层保存修改按钮", "em_yes_config_panel_confirm", YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject));
      ((IReportService)ServiceCenter.a(IReportService.class)).a(this.s, true, "设置浮层关闭按钮", "em_yes_config_panel_close", YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject));
    }
  }
  
  private void c(int paramInt)
  {
    this.r.setText(paramInt);
    this.r.setBackgroundResource(2130853078);
    this.r.setTextColor(-1);
    this.r.setEnabled(true);
  }
  
  private void d()
  {
    this.l.addTextChangedListener(new TeamConfigDialog.1(this));
    a(this.l);
    this.j.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.s.setOnClickListener(this);
    this.r.setOnClickListener(this);
    this.t.setOnClickListener(this);
    this.n.setOnSingleSelectedListener(new TeamConfigDialog.2(this));
  }
  
  private void d(int paramInt)
  {
    this.r.setText(paramInt);
    this.r.setBackgroundResource(2130853079);
    this.r.setTextColor(-8750470);
    this.r.setEnabled(false);
  }
  
  private int e(int paramInt)
  {
    int i1 = 7;
    if (paramInt < 7) {
      return paramInt - 1;
    }
    if ((paramInt == 7) || (paramInt == 8)) {
      i1 = 6;
    }
    return i1;
  }
  
  private void e()
  {
    int i1;
    if (this.l.getText().length() > 0)
    {
      i1 = this.v;
      if (i1 == 0)
      {
        c(2131917180);
        return;
      }
      if (i1 == 1) {
        c(2131917208);
      }
    }
    else
    {
      i1 = this.v;
      if (i1 == 0)
      {
        d(2131917180);
        return;
      }
      if (i1 == 1) {
        d(2131917208);
      }
    }
  }
  
  private List<Integer> f(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramInt));
    return localArrayList;
  }
  
  private void f()
  {
    this.j.setText(2131917211);
  }
  
  private void g()
  {
    a(SmobaConfigManager.a().b().big_grade_level_conf_list.get());
    this.y = SmobaConfigManager.a().b().team_name_list.get();
    Object localObject = this.y;
    if ((localObject == null) || (((List)localObject).isEmpty())) {
      this.t.setVisibility(4);
    }
    double d1 = Math.random();
    double d2 = this.y.size() - 1;
    Double.isNaN(d2);
    this.z = ((int)(d1 * d2));
    localObject = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("team name random index == ");
    localStringBuilder.append(this.z);
    Logger.a((String)localObject, localStringBuilder.toString());
    if (this.v == 0) {
      q();
    }
  }
  
  private void h()
  {
    if (!TextUtils.isEmpty(this.w.a)) {
      this.l.setText(this.w.a);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.l.getText().length());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(15);
    localObject = ((StringBuilder)localObject).toString();
    this.k.setText((CharSequence)localObject);
  }
  
  private void i()
  {
    this.p.setMode(0);
    int i1 = this.v;
    Object localObject;
    if (i1 == 0)
    {
      localObject = new ArrayList();
      ((List)localObject).add(new TeamSelectView.Item(3, "匹配赛").a(true));
      ((List)localObject).add(new TeamSelectView.Item(1, "多人排位"));
      ((List)localObject).add(new TeamSelectView.Item(2, "五人排位"));
    }
    else if (i1 == 1)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new TeamSelectView.Item(3, "匹配赛"));
      localArrayList.add(new TeamSelectView.Item(1, "多人排位"));
      localArrayList.add(new TeamSelectView.Item(2, "五人排位"));
      Iterator localIterator = localArrayList.iterator();
      do
      {
        localObject = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (TeamSelectView.Item)localIterator.next();
      } while (((TeamSelectView.Item)localObject).b != this.w.b);
      ((TeamSelectView.Item)localObject).d = true;
      localObject = localArrayList;
    }
    else
    {
      localObject = null;
    }
    this.n.a((List)localObject);
  }
  
  private void j()
  {
    this.p.setMode(1);
    List localList;
    if (this.v == 0) {
      localList = l();
    } else {
      localList = m();
    }
    this.p.a(localList);
  }
  
  private void k()
  {
    b(this.q);
    this.q.setOnClickListener(this);
  }
  
  private List<TeamSelectView.Item> l()
  {
    double d1 = UITools.a(getContext());
    Double.isNaN(d1);
    int i1 = (int)(d1 * 0.192D);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TeamSelectView.Item(0, TeamLaneHelper.a(0)).a(true).b(true).a(i1));
    localArrayList.add(new TeamSelectView.Item(1, TeamLaneHelper.a(1)).a(i1));
    localArrayList.add(new TeamSelectView.Item(3, TeamLaneHelper.a(3)).a(i1));
    localArrayList.add(new TeamSelectView.Item(2, TeamLaneHelper.a(2)).a(i1));
    localArrayList.add(new TeamSelectView.Item(4, TeamLaneHelper.a(4)).a(i1));
    localArrayList.add(new TeamSelectView.Item(5, TeamLaneHelper.a(5)).a(i1));
    return localArrayList;
  }
  
  private List<TeamSelectView.Item> m()
  {
    double d1 = UITools.a(getContext());
    Double.isNaN(d1);
    int i1 = (int)(d1 * 0.192D);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TeamSelectView.Item(0, TeamLaneHelper.a(0)).b(true).a(i1));
    localArrayList.add(new TeamSelectView.Item(1, TeamLaneHelper.a(1)).a(i1));
    localArrayList.add(new TeamSelectView.Item(3, TeamLaneHelper.a(3)).a(i1));
    localArrayList.add(new TeamSelectView.Item(2, TeamLaneHelper.a(2)).a(i1));
    localArrayList.add(new TeamSelectView.Item(4, TeamLaneHelper.a(4)).a(i1));
    localArrayList.add(new TeamSelectView.Item(5, TeamLaneHelper.a(5)).a(i1));
    Iterator localIterator1 = localArrayList.iterator();
    while (localIterator1.hasNext())
    {
      TeamSelectView.Item localItem = (TeamSelectView.Item)localIterator1.next();
      Iterator localIterator2 = this.w.j.iterator();
      while (localIterator2.hasNext())
      {
        Integer localInteger = (Integer)localIterator2.next();
        if (localItem.b == localInteger.intValue()) {
          localItem.d = true;
        }
      }
    }
    return localArrayList;
  }
  
  private void n()
  {
    int i1 = this.v;
    if (i1 == 0)
    {
      o();
      return;
    }
    if (i1 == 1)
    {
      if (this.n.getSelectedItem().b == this.w.b)
      {
        if (this.n.getSelectedItem().b == 3)
        {
          this.o.setMatchMode(e(this.c), e(this.d));
          return;
        }
        this.o.setRankMode(e(this.b), e(this.c), e(this.d), this.n.getSelectedItem().b);
        return;
      }
      o();
    }
  }
  
  private void o()
  {
    if (this.n.getSelectedItem().b == 3)
    {
      this.o.setMatchMode(e(1), e(11));
      return;
    }
    this.o.setRankMode(e(this.b), this.n.getSelectedItem().b);
  }
  
  private void p()
  {
    RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 179.0F, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(400L);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setAnimationListener(new TeamConfigDialog.5(this));
    this.t.startAnimation(localRotateAnimation);
  }
  
  private void q()
  {
    Object localObject = i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("now teamName index is == ");
    localStringBuilder.append(this.z);
    Logger.a((String)localObject, localStringBuilder.toString());
    if (this.y.isEmpty()) {
      return;
    }
    localObject = this.y;
    localObject = (String)((List)localObject).get(this.z % ((List)localObject).size());
    this.l.setText((CharSequence)localObject);
    if (this.l.isFocused()) {
      this.l.setSelection(((String)localObject).length());
    }
    this.z += 1;
  }
  
  private void u()
  {
    if (!NoDoubleClickUtils.a())
    {
      Object localObject1 = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.w.f);
      if (localObject1 == null) {
        return;
      }
      int i1 = 0;
      localObject1 = ((IRoomGetDataService)localObject1).h().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((YoloRoomOuterClass.YoloRoomSpeakingPosInfo)((Iterator)localObject1).next()).uid.get() != 0L) {
          i1 += 1;
        }
      }
      localObject1 = i;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("player count is ");
      ((StringBuilder)localObject2).append(i1);
      Logger.a((String)localObject1, ((StringBuilder)localObject2).toString());
      if ((this.n.getSelectedItem().b == 1) && (i1 > 3))
      {
        CustomToastView.a("人数超出该模式限制");
        Logger.c(i, "modifyRoomInfo but num limited!!!");
        return;
      }
      if (this.x != null)
      {
        localObject1 = w();
        localObject2 = x();
        this.x.b(this, (YoloRoomOuterClass.YoloRoomParams)localObject1, (YoloRoomOuterClass.YoloSmobaRoomParams)localObject2);
      }
    }
  }
  
  private void v()
  {
    if ((!NoDoubleClickUtils.a()) && (this.x != null))
    {
      YoloRoomOuterClass.YoloRoomParams localYoloRoomParams = w();
      YoloRoomOuterClass.YoloSmobaRoomParams localYoloSmobaRoomParams = x();
      this.x.a(this, localYoloRoomParams, localYoloSmobaRoomParams);
    }
  }
  
  private YoloRoomOuterClass.YoloRoomParams w()
  {
    YoloRoomOuterClass.YoloRoomParams localYoloRoomParams = new YoloRoomOuterClass.YoloRoomParams();
    int i2 = this.v;
    int i1 = 1;
    Object localObject;
    if (i2 == 0)
    {
      localYoloRoomParams.room_type.set(1);
      localYoloRoomParams.is_private.set(0);
      localYoloRoomParams.introduce.set(this.l.getText().toString());
      localObject = localYoloRoomParams.voice_switch;
      if (!((IRoomService)ServiceCenter.a(IRoomService.class)).b(1)) {
        i1 = 2;
      }
      ((PBInt32Field)localObject).set(i1);
      localYoloRoomParams.create_from.set(this.w.g);
      localYoloRoomParams.sub_create_from.set(this.w.h);
      if (this.w.k != null)
      {
        localYoloRoomParams.guild_id.set(this.w.k.a);
        localYoloRoomParams.channel_id.set(this.w.k.b);
        localYoloRoomParams.channel_name.set(this.w.k.c);
        return localYoloRoomParams;
      }
    }
    else if (i2 == 1)
    {
      localObject = this.l.getText().toString();
      if (!TextUtils.equals((CharSequence)localObject, this.w.a))
      {
        Logger.a(i, "修改了队名");
        localYoloRoomParams.introduce.set((String)localObject);
      }
    }
    return localYoloRoomParams;
  }
  
  private YoloRoomOuterClass.YoloSmobaRoomParams x()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.o.a().iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      localObject2 = (List)this.a.get(localObject2);
      if (localObject2 != null) {
        localArrayList.addAll((Collection)localObject2);
      }
    }
    localObject1 = new YoloRoomOuterClass.YoloSmobaRoomParams();
    int i1 = this.v;
    if (i1 == 0)
    {
      ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).is_off_double_check.set(1);
      ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).game_mode.set(this.n.getSelectedItem().b);
      ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).need_lane_type.set(this.p.getSelectedItemIdList());
      ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).grade_list.set(localArrayList);
      ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).base_room_id.set(this.w.i);
      return localObject1;
    }
    if (i1 == 1)
    {
      i1 = this.n.getSelectedItem().b;
      localObject2 = this.p.getSelectedItemIdList();
      if ((i1 != this.w.b) || (!((List)localObject2).equals(this.w.j)) || (((Integer)localArrayList.get(0)).intValue() != this.c) || (((Integer)localArrayList.get(localArrayList.size() - 1)).intValue() != this.d))
      {
        Logger.a(i, "修改了游戏信息");
        ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).game_mode.set(i1);
        ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).need_lane_type.set((List)localObject2);
        ((YoloRoomOuterClass.YoloSmobaRoomParams)localObject1).grade_list.set(localArrayList);
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    a(2131917232);
  }
  
  public void a(int paramInt)
  {
    this.u.setHintText(getContext().getString(2131917232));
    this.u.a();
  }
  
  public void a(@NotNull String paramString) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131446930)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("item == ");
      localStringBuilder.append(this.n.getSelectedItem().c);
      CustomToastView.a(localStringBuilder.toString());
    }
    else if (paramView.getId() == 2131446918)
    {
      this.l.setText("");
    }
    else if (paramView.getId() == 2131446912)
    {
      dismiss();
    }
    else if (paramView.getId() == 2131446915)
    {
      int i1 = this.v;
      if (i1 == 0) {
        v();
      } else if (i1 == 1) {
        u();
      }
    }
    else if (paramView.getId() == 2131446920)
    {
      p();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setSoftInputMode(48);
    setContentView(2131629491);
    b();
    d();
    g();
  }
  
  public void r()
  {
    TimiGamePageLoadingView localTimiGamePageLoadingView = this.u;
    if (localTimiGamePageLoadingView != null) {
      localTimiGamePageLoadingView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.main.TeamConfigDialog
 * JD-Core Version:    0.7.0.1
 */