package com.tencent.timi.game.profile.impl.report;

import android.view.View;
import com.tencent.timi.game.profile.api.ProfileReportUtil;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/report/ProfileCommunityReport;", "", "reportParamMap", "", "", "(Ljava/util/Map;)V", "getReportParamMap", "()Ljava/util/Map;", "acquireParam", "reportAt", "", "view", "Landroid/view/View;", "reportCloseClick", "isMaster", "", "reportExitMic", "reportGift", "reportKaihei", "reportReport", "reportRoleChange", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileCommunityReport
{
  @NotNull
  private final Map<String, String> a;
  
  public ProfileCommunityReport(@NotNull Map<String, String> paramMap)
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
  
  public final void a(@Nullable View paramView, boolean paramBoolean)
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
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_team_invite", a());
  }
  
  public final void d(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_userprofile_panel_user_report", a());
  }
  
  public final void e(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_myprofile_panel_rolebind", a());
  }
  
  public final void f(@Nullable View paramView)
  {
    ProfileReportUtil.a.a(paramView, "em_yes_myprofile_panel_leavemic", a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.report.ProfileCommunityReport
 * JD-Core Version:    0.7.0.1
 */