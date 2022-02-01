package com.tencent.timi.game.profile.impl.report;

import android.view.View;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/report/ProfileFleetReport;", "", "reportParamMap", "", "", "(Ljava/util/Map;)V", "getReportParamMap", "()Ljava/util/Map;", "acquireParam", "reportAddQQFriend", "", "view", "Landroid/view/View;", "reportAtClick", "reportFleetClose", "isMaster", "", "reportGift", "reportKickOut", "reportQuitFleet", "reportReport", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileFleetReport
{
  @NotNull
  private final Map<String, String> a;
  
  public ProfileFleetReport(@NotNull Map<String, String> paramMap)
  {
    this.a = paramMap;
  }
  
  private final Map<String, String> a()
  {
    return this.a;
  }
  
  public final void a(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_at", a());
  }
  
  public final void a(boolean paramBoolean, @Nullable View paramView)
  {
    if (paramBoolean)
    {
      ProfileReportUtil.a.a(paramView, "em_yes_myprofile_panel_close", a());
      return;
    }
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_close", a());
  }
  
  public final void b(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_gift", a());
  }
  
  public final void c(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_kickout", a());
  }
  
  public final void d(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_add_friend", a());
  }
  
  public final void e(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_user_report", a());
  }
  
  public final void f(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_myprofile_panel_leave", a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.report.ProfileFleetReport
 * JD-Core Version:    0.7.0.1
 */