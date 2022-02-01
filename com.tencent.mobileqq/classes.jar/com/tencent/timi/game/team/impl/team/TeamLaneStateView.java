package com.tencent.timi.game.team.impl.team;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.env.Env;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;
import com.tencent.timi.game.ui.pag.TimiGamePAGView;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomInfo;

public class TeamLaneStateView
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  private TimiGamePAGView c;
  private boolean d;
  private int e;
  private CommonOuterClass.QQUserId f;
  
  public TeamLaneStateView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public TeamLaneStateView(Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public TeamLaneStateView(Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.c = new TimiGamePAGView(getContext());
    this.c.setLayoutParams(new ViewGroup.LayoutParams(paramInt1, paramInt2));
    this.c.setVisibility(8);
    addView(this.c);
  }
  
  private void a(View paramView, int paramInt)
  {
    Object localObject = ((IRoomService)ServiceCenter.a(IRoomService.class)).a(1);
    if (localObject != null)
    {
      localObject = YoloRoomUtil.c((YoloRoomOuterClass.YoloRoomInfo)localObject);
      ((ConcurrentHashMap)localObject).put("yes_user_branch", String.valueOf(paramInt));
      ((IReportService)ServiceCenter.a(IReportService.class)).b(paramView, true, "选择分路弹窗选择按钮", "em_yes_branch_win_choose", (Map)localObject);
    }
  }
  
  private void b()
  {
    c();
    d();
    e();
  }
  
  private void c()
  {
    setBackgroundResource(2130853120);
    setGravity(1);
  }
  
  private void d()
  {
    i();
    h();
  }
  
  private void e()
  {
    setOnClickListener(new TeamLaneStateView.1(this));
  }
  
  private void f()
  {
    this.a.setImageResource(2130853114);
  }
  
  private void g()
  {
    this.a.setImageResource(2130853116);
    TeamLaneSelectView localTeamLaneSelectView = new TeamLaneSelectView(getContext());
    localTeamLaneSelectView.a(this.e, this);
    localTeamLaneSelectView.setOnLaneSelectedListener(new TeamLaneStateView.2(this));
    localTeamLaneSelectView.setOnDismissListener(new TeamLaneStateView.3(this));
  }
  
  private void h()
  {
    this.b = new TextView(getContext());
    this.b.setTextColor(getResources().getColorStateList(2131168312));
    this.b.setTextSize(9.0F);
    this.b.setGravity(17);
    this.b.setText(TeamLaneHelper.a(0, true));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(0, this.a.getId());
    this.b.setLayoutParams(localLayoutParams);
    addView(this.b);
  }
  
  private void i()
  {
    this.a = new ImageView(getContext());
    this.a.setId(2131446910);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams((int)UITools.a(getContext(), 7.0F), (int)UITools.a(getContext(), 4.0F));
    localLayoutParams.addRule(11, -1);
    localLayoutParams.rightMargin = ((int)UITools.a(getContext(), 3.75F));
    localLayoutParams.addRule(15, -1);
    this.a.setLayoutParams(localLayoutParams);
    this.a.setImageResource(2130853114);
    addView(this.a);
  }
  
  private PAGFile j()
  {
    PAGFile localPAGFile = PAGFile.Load(Env.a().getResources().getAssets(), "pag/tg_lane_slide.pag");
    if (localPAGFile == null) {
      return null;
    }
    Matrix localMatrix = localPAGFile.getTotalMatrix();
    float f1 = UITools.a(getContext(), 54.0F) * 1.0F / localPAGFile.width();
    localMatrix.setScale(f1, f1);
    localPAGFile.setMatrix(localMatrix);
    return localPAGFile;
  }
  
  public void a()
  {
    setVisibility(8);
    setTag("");
  }
  
  public void setState(CommonOuterClass.QQUserId paramQQUserId, int paramInt)
  {
    this.e = paramInt;
    this.f = paramQQUserId;
    boolean bool;
    if (paramQQUserId.uid.get() == ((ILoginCoreService)ServiceCenter.a(ILoginCoreService.class)).a()) {
      bool = true;
    } else {
      bool = false;
    }
    this.d = bool;
    if (this.d)
    {
      this.a.setVisibility(0);
      setEnabled(true);
      this.b.setEnabled(true);
      setTag("TeamLaneStateView");
    }
    else
    {
      this.a.setVisibility(8);
      setEnabled(false);
      this.b.setEnabled(false);
      setTag("");
    }
    this.b.setText(TeamLaneHelper.a(paramInt, this.d));
    setVisibility(0);
  }
  
  public void setStateWithAnim(String paramString)
  {
    if (!((IniterService)ServiceCenter.a(IniterService.class)).c()) {
      return;
    }
    int i = (int)UITools.a(getContext(), 54.0F);
    int j = (int)UITools.a(getContext(), 15.0F);
    a(i, j);
    PAGComposition localPAGComposition = PAGComposition.Make(i, j);
    if (localPAGComposition == null) {
      return;
    }
    PAGFile localPAGFile = j();
    if (localPAGFile == null) {
      return;
    }
    localPAGComposition.addLayer(localPAGFile);
    this.c.setComposition(localPAGComposition);
    this.c.setRepeatCount(1);
    this.c.a(new TeamLaneStateView.4(this, paramString));
    this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamLaneStateView
 * JD-Core Version:    0.7.0.1
 */