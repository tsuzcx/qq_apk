package com.tencent.timi.game.teamlist.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.timi.game.expand.hall.api.ExpandHallLifeCycleListener;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.teamlist.presenter.TeamListHorizontalAdapter;
import com.tencent.timi.game.teamlist.presenter.TeamListPresenter;
import com.tencent.timi.game.teamlist.report.TeamListReport;
import com.tencent.timi.game.teamlist.util.URLDrawableUtil;
import com.tencent.timi.game.ui.utils.CommonAnimationUtil.SlideUpAnimation;
import com.tencent.timi.game.ui.widget.rc.RCImageView;
import com.tencent.timi.game.utils.Logger;

public class TeamListView
  extends FrameLayout
{
  public TeamListPresenter a;
  public RelativeLayout b;
  public ImageView c;
  public ImageView d;
  public TextView e;
  public RecyclerView f;
  private TeamListHorizontalAdapter g = new TeamListHorizontalAdapter();
  private RelativeLayout h;
  private TextView i;
  private RCImageView j;
  private FrameLayout k;
  private CheckBox l;
  private View m;
  private YoloRoomInterface.YoloRoomLifecycleListener n;
  private ExpandHallLifeCycleListener o;
  private LinearLayoutManager p;
  private int q = 0;
  private boolean r = false;
  private boolean s = false;
  
  public TeamListView(Context paramContext)
  {
    super(paramContext);
    g();
  }
  
  public TeamListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    g();
  }
  
  public TeamListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void g()
  {
    LayoutInflater.from(getContext()).inflate(2131629533, this, true);
    this.k = ((FrameLayout)findViewById(2131446890));
    this.l = ((CheckBox)findViewById(2131446874));
    this.m = findViewById(2131447401);
    this.b = ((RelativeLayout)findViewById(2131446891));
    this.c = ((ImageView)findViewById(2131437102));
    this.d = ((ImageView)findViewById(2131444800));
    this.e = ((TextView)findViewById(2131446888));
    this.h = ((RelativeLayout)findViewById(2131446871));
    this.i = ((TextView)findViewById(2131446870));
    this.f = ((RecyclerView)findViewById(2131446889));
    this.j = ((RCImageView)findViewById(2131446872));
    Drawable localDrawable = getContext().getResources().getDrawable(2130853099);
    this.j.setRadius(ViewUtils.dip2px(15.0F));
    this.j.setImageDrawable(URLDrawableUtil.a("https://cdn.yes.qq.com/smoba/team/empty", localDrawable, 686.0F, 250.0F));
    this.a = new TeamListPresenter();
    this.a.a(this);
    this.p = new LinearLayoutManager(getContext());
    this.p.setOrientation(0);
    this.f.setLayoutManager(this.p);
    this.a.a(this.f);
    this.f.addOnScrollListener(new TeamListView.1(this));
    this.i.setOnClickListener(new TeamListView.2(this));
    h();
    i();
  }
  
  private void h()
  {
    this.m.setOnClickListener(new TeamListView.3(this));
    this.l.setOnCheckedChangeListener(new TeamListView.4(this));
  }
  
  private void i()
  {
    this.o = new TeamListView.5(this);
    ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a(this.o);
  }
  
  public void a()
  {
    this.a.e();
    this.a.g();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.e;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("支车队在招募");
    localTextView.setText(localStringBuilder.toString());
    if (paramInt1 == 0) {
      this.h.setVisibility(0);
    } else {
      this.h.setVisibility(8);
    }
    if (paramInt1 == 0)
    {
      this.d.setVisibility(8);
      this.e.setVisibility(8);
      return;
    }
    this.d.setVisibility(0);
    this.e.setVisibility(0);
  }
  
  public void b()
  {
    Logger.b("TeamListView", "performShow");
    if (this.r)
    {
      Logger.b("TeamListView", "hideByUser");
      return;
    }
    if (!this.s)
    {
      Logger.b("TeamListView", "alreadyShow");
      return;
    }
    this.s = false;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, ViewUtils.dip2px(137.0F) });
    ViewGroup.LayoutParams localLayoutParams = this.k.getLayoutParams();
    localValueAnimator.setInterpolator(CommonAnimationUtil.SlideUpAnimation.a);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new TeamListView.6(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  public void c()
  {
    Logger.b("TeamListView", "performHide");
    if (this.s)
    {
      Logger.b("TeamListView", "alreadyHide");
      return;
    }
    this.s = true;
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { ViewUtils.dip2px(137.0F), 0 });
    ViewGroup.LayoutParams localLayoutParams = this.k.getLayoutParams();
    localValueAnimator.setInterpolator(CommonAnimationUtil.SlideUpAnimation.b);
    localValueAnimator.setDuration(500L);
    localValueAnimator.addUpdateListener(new TeamListView.7(this, localLayoutParams));
    localValueAnimator.start();
  }
  
  protected void d()
  {
    this.n = new TeamListView.8(this);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.n);
  }
  
  public void e()
  {
    this.a.h();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.n);
  }
  
  public void f()
  {
    TeamListReport.a(this.i);
    TeamListReport.b(this.e);
  }
  
  public int getVisibleTeamListPosEnd()
  {
    if (this.q == 0)
    {
      if (this.g.a()) {
        return this.p.findLastVisibleItemPosition() - 1;
      }
      return this.p.findLastVisibleItemPosition();
    }
    return -1;
  }
  
  public int getVisibleTeamListPosStart()
  {
    if (this.q == 0) {
      return this.p.findFirstVisibleItemPosition();
    }
    return -1;
  }
  
  public void setOnMoreClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.a(paramOnClickListener);
    this.e.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListView
 * JD-Core Version:    0.7.0.1
 */