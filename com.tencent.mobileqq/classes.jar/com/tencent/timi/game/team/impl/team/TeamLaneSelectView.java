package com.tencent.timi.game.team.impl.team;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.team.impl.setting.TeamLaneHelper;
import com.tencent.util.Pair;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class TeamLaneSelectView
  extends LinearLayout
{
  private PopupWindow a;
  private TeamLaneSelectView.OnLaneSelectedListener b;
  
  public TeamLaneSelectView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  @NotNull
  private TextView a(Pair<Integer, String> paramPair)
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(17);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams((int)UITools.a(getContext(), 120.0F), (int)UITools.a(getContext(), 40.0F));
    localTextView.setTextColor(getResources().getColorStateList(2131168311));
    if (getChildCount() == 0) {
      localTextView.setBackgroundResource(2130853118);
    } else if (getChildCount() == TeamLaneHelper.a().size() - 1) {
      localTextView.setBackgroundResource(2130853119);
    } else {
      localTextView.setBackgroundResource(2130853117);
    }
    localTextView.setTag(paramPair.first);
    localTextView.setText((CharSequence)paramPair.second);
    localTextView.setTextSize(14.0F);
    localTextView.setSelected(false);
    localTextView.setOnClickListener(new TeamLaneSelectView.1(this, localTextView));
    localTextView.setLayoutParams(localLayoutParams);
    return localTextView;
  }
  
  private void a()
  {
    c();
    b();
  }
  
  private void a(View paramView)
  {
    int i = (int)UITools.a(getContext(), 120.0F);
    int j = (int)UITools.a(getContext(), 2.0F);
    if (UITools.a(getContext()) - paramView.getX() > i)
    {
      this.a.showAsDropDown(paramView, 0, j);
      return;
    }
    int k = paramView.getWidth();
    this.a.showAsDropDown(paramView, -(i - k), j);
  }
  
  private void b()
  {
    setBackgroundResource(2130853115);
    setOrientation(1);
    setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
  }
  
  private void c()
  {
    Iterator localIterator = TeamLaneHelper.a().iterator();
    while (localIterator.hasNext()) {
      addView(a((Pair)localIterator.next()));
    }
  }
  
  private void d()
  {
    ((IReportService)ServiceCenter.a(IReportService.class)).a(this.a.getContentView(), "pg_yes_smoba_team");
  }
  
  private void e()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setSelected(false);
      i += 1;
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    this.a = new PopupWindow(this, -2, -2);
    this.a.setOutsideTouchable(true);
    this.a.setFocusable(true);
    d();
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.a.setElevation(UITools.a(getContext(), 5.0F));
      if (Build.VERSION.SDK_INT >= 28) {
        this.a.getContentView().setOutlineSpotShadowColor(-1052689);
      }
    }
    a(paramView);
    paramView = (TextView)findViewWithTag(Integer.valueOf(paramInt));
    if (paramView != null) {
      paramView.setSelected(true);
    }
  }
  
  public void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.a.setOnDismissListener(paramOnDismissListener);
  }
  
  public void setOnLaneSelectedListener(TeamLaneSelectView.OnLaneSelectedListener paramOnLaneSelectedListener)
  {
    this.b = paramOnLaneSelectedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.team.TeamLaneSelectView
 * JD-Core Version:    0.7.0.1
 */