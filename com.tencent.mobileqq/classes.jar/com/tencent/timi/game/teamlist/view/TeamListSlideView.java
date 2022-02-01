package com.tencent.timi.game.teamlist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.expand.hall.api.ExpandHallLifeCycleListener;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.api.YoloRoomInterface.YoloRoomLifecycleListener;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.teamlist.model.TeamListFilterModel;
import com.tencent.timi.game.teamlist.presenter.TeamListSlidePresenter;
import com.tencent.timi.game.teamlist.report.TeamListReport;
import com.tencent.timi.game.utils.Logger;
import org.jetbrains.annotations.NotNull;

public class TeamListSlideView
  extends RelativeLayout
  implements ExpandHallLifeCycleListener
{
  private TeamListSlidePresenter a;
  private View.OnClickListener b;
  private ImageView c;
  private RelativeLayout d;
  private TextView e;
  private TextView f;
  private CheckBox g;
  private TeamListFilterView h;
  private RecyclerView i;
  private RelativeLayout j;
  private QQBlurView k;
  private SwipeRefreshLayout l;
  private RelativeLayout m;
  private YoloRoomInterface.YoloRoomLifecycleListener n;
  
  public TeamListSlideView(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  public TeamListSlideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    f();
  }
  
  public TeamListSlideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
  }
  
  private void f()
  {
    LayoutInflater.from(getContext()).inflate(2131629532, this, true);
    this.c = ((ImageView)findViewById(2131446073));
    this.d = ((RelativeLayout)findViewById(2131446084));
    this.e = ((TextView)findViewById(2131446085));
    this.f = ((TextView)findViewById(2131446077));
    this.g = ((CheckBox)findViewById(2131446079));
    this.h = ((TeamListFilterView)findViewById(2131446078));
    this.i = ((RecyclerView)findViewById(2131446868));
    this.l = ((SwipeRefreshLayout)findViewById(2131446663));
    this.j = ((RelativeLayout)findViewById(2131446869));
    this.k = ((QQBlurView)findViewById(2131429622));
    this.m = ((RelativeLayout)findViewById(2131432519));
    this.a = new TeamListSlidePresenter(new TeamListFilterModel());
    this.a.a(this);
    this.l.setOnRefreshListener(new TeamListSlideView.1(this));
    this.c.setOnClickListener(new TeamListSlideView.2(this));
    this.h.setTriggerSlideFilterTv(this.g);
    this.a.a(this.h);
    this.h.setOnFilterConfirmClickListener(new TeamListSlideView.3(this));
    Object localObject = new LinearLayoutManager(getContext());
    ((LinearLayoutManager)localObject).setOrientation(1);
    this.i.setLayoutManager((RecyclerView.LayoutManager)localObject);
    this.a.a(this.i);
    this.j.setOnClickListener(new TeamListSlideView.4(this));
    localObject = ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a();
    if ((localObject != null) && (((IExpandHall)localObject).h() != 0L))
    {
      this.a.a(String.valueOf(((IExpandHall)localObject).h()));
      this.a.a(((IExpandHall)localObject).b().a);
      e();
      return;
    }
    ((IExpandHallService)ServiceCenter.a(IExpandHallService.class)).a(this);
  }
  
  private void g()
  {
    boolean bool;
    if (Build.VERSION.SDK_INT >= 24) {
      bool = true;
    } else {
      bool = false;
    }
    this.k.setVisibility(0);
    this.k.a(this.i);
    Object localObject = this.k;
    ((QQBlurView)localObject).b((View)localObject);
    this.k.c(-1);
    this.k.setEnableBlur(bool);
    this.k.b(0);
    this.k.a(4.0F);
    this.k.a(6);
    localObject = getResources().getDrawable(2130852970);
    ((Drawable)localObject).setAlpha(180);
    this.k.a((Drawable)localObject);
    this.k.setDisableBlurDrawableRes(2130853592);
    this.k.d();
    this.k.a();
  }
  
  public void a()
  {
    View.OnClickListener localOnClickListener = this.b;
    if (localOnClickListener != null) {
      localOnClickListener.onClick(this);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("totalNum");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" displayTeamNum");
    ((StringBuilder)localObject).append(paramInt2);
    Logger.b("TeamListSlideView", ((StringBuilder)localObject).toString());
    if (paramInt2 == 0) {
      this.m.setVisibility(0);
    } else {
      this.m.setVisibility(8);
    }
    localObject = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("支车队在招募");
    ((TextView)localObject).setText(localStringBuilder.toString());
  }
  
  public void a(int paramInt, @NotNull String paramString, @NotNull IExpandHall paramIExpandHall) {}
  
  public void a(long paramLong, @NotNull IExpandHall paramIExpandHall)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("joinHallSucceed roomId:");
    localStringBuilder.append(paramLong);
    Logger.a("TeamListSlideView", localStringBuilder.toString());
    this.a.a(String.valueOf(paramLong));
    this.a.a(paramIExpandHall.b().a);
    ThreadManagerV2.excute(new TeamListSlideView.6(this), 128, null, true);
  }
  
  public void a(@NotNull IExpandHall paramIExpandHall) {}
  
  public void b()
  {
    if (this.l.isRefreshing()) {
      this.l.setRefreshing(false);
    }
  }
  
  public void b(@NotNull IExpandHall paramIExpandHall) {}
  
  public void c()
  {
    Logger.b("TeamListSlideView", "onOpen");
    this.a.b();
  }
  
  public void d()
  {
    Logger.b("TeamListSlideView", "onClose");
    this.h.c();
  }
  
  public void e()
  {
    TeamListReport.d(this.c);
    TeamListReport.f(this.g);
    TeamListReport.e(this.j);
    this.h.d();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    g();
    this.n = new TeamListSlideView.5(this);
    ((IRoomService)ServiceCenter.a(IRoomService.class)).a(this.n);
  }
  
  protected void onDetachedFromWindow()
  {
    this.k.c();
    ((IRoomService)ServiceCenter.a(IRoomService.class)).b(this.n);
    super.onDetachedFromWindow();
  }
  
  public void setOnCloseClickListener(View.OnClickListener paramOnClickListener)
  {
    this.b = paramOnClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.view.TeamListSlideView
 * JD-Core Version:    0.7.0.1
 */