package com.tencent.timi.game.teamlist.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.teamlist.model.TeamListFilterModel;
import com.tencent.timi.game.teamlist.presenter.TeamListFilterAdapter;
import com.tencent.timi.game.teamlist.report.TeamListReport;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import com.tencent.timi.game.utils.Logger;

public class TeamListFilterView
  extends RelativeLayout
{
  public boolean a = false;
  private TeamListFilterModel b;
  private TeamListFilterAdapter c;
  private TeamListFilterAdapter d;
  private TeamListFilterAdapter e;
  private RecyclerView f;
  private RecyclerView g;
  private RecyclerView h;
  private TextView i;
  private TextView j;
  private View k;
  private RelativeLayout l;
  private View m;
  private ViewGroup.LayoutParams n;
  private CheckBox o;
  private ValueAnimator p;
  private float q = 400.0F;
  private long r = 500L;
  private View.OnClickListener s;
  
  public TeamListFilterView(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public TeamListFilterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  public TeamListFilterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
  }
  
  private void e()
  {
    this.m = LayoutInflater.from(getContext()).inflate(2131629528, this, true);
    this.m.setOnClickListener(new TeamListFilterView.1(this));
    this.m.setVisibility(8);
    this.l = ((RelativeLayout)findViewById(2131431340));
    this.n = this.l.getLayoutParams();
    Object localObject = this.n;
    ((ViewGroup.LayoutParams)localObject).height = 0;
    this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.l.setClickable(true);
    this.k = findViewById(2131429234);
    this.f = ((RecyclerView)findViewById(2131433994));
    localObject = new GridLayoutManager(getContext(), 4);
    ((GridLayoutManager)localObject).setOrientation(1);
    this.f.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.g = ((RecyclerView)findViewById(2131434336));
    localObject = new GridLayoutManager(getContext(), 4);
    ((GridLayoutManager)localObject).setOrientation(1);
    this.g.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.h = ((RecyclerView)findViewById(2131436841));
    localObject = new GridLayoutManager(getContext(), 4);
    ((GridLayoutManager)localObject).setOrientation(1);
    this.h.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.i = ((TextView)findViewById(2131431227));
    this.i.setOnClickListener(new TeamListFilterView.2(this));
    this.j = ((TextView)findViewById(2131444701));
    this.j.setOnClickListener(new TeamListFilterView.3(this));
  }
  
  public void a()
  {
    this.c.a();
    this.d.a();
    this.e.a();
    this.s.onClick(this.i);
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.c.b();
    this.d.b();
    this.e.b();
    if (paramBoolean) {
      this.b.a();
    }
  }
  
  public void b()
  {
    Logger.b("TeamListFilterView", "performShow");
    this.o.setChecked(true);
    if (this.a) {
      return;
    }
    this.a = true;
    this.p = ValueAnimator.ofInt(new int[] { 0, ViewUtils.dip2px(this.q) });
    this.p.setInterpolator(CommonAnimationUtil.SlideUpAnimation.a);
    this.p.setDuration(this.r);
    this.p.addUpdateListener(new TeamListFilterView.5(this));
    this.n.height = 0;
    this.k.setAlpha(0.0F);
    this.l.setLayoutParams(this.n);
    this.m.setVisibility(0);
    this.p.start();
  }
  
  public void c()
  {
    Logger.b("TeamListFilterView", "performHide");
    this.o.setChecked(false);
    if (!this.a) {
      return;
    }
    this.a = false;
    this.p = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(this.q), 0 });
    this.p.setInterpolator(CommonAnimationUtil.SlideUpAnimation.b);
    this.p.setDuration(this.r);
    this.p.addUpdateListener(new TeamListFilterView.6(this));
    ViewGroup.LayoutParams localLayoutParams = this.n;
    localLayoutParams.height = ((int)this.q);
    this.l.setLayoutParams(localLayoutParams);
    this.m.setVisibility(0);
    getHandler().postDelayed(new TeamListFilterView.7(this), this.r - 100L);
    this.p.start();
  }
  
  public void d()
  {
    TeamListReport.g(this.i);
    TeamListReport.h(this.j);
  }
  
  public void setData(TeamListFilterModel paramTeamListFilterModel)
  {
    this.b = paramTeamListFilterModel;
    this.c = new TeamListFilterAdapter(0, paramTeamListFilterModel);
    this.d = new TeamListFilterAdapter(1, paramTeamListFilterModel);
    this.e = new TeamListFilterAdapter(2, paramTeamListFilterModel);
    this.f.setAdapter(this.c);
    this.g.setAdapter(this.d);
    this.h.setAdapter(this.e);
  }
  
  public void setOnFilterConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.s = paramOnClickListener;
  }
  
  public void setTriggerSlideFilterTv(CheckBox paramCheckBox)
  {
    this.o = paramCheckBox;
    paramCheckBox.setOnClickListener(new TeamListFilterView.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListFilterView
 * JD-Core Version:    0.7.0.1
 */