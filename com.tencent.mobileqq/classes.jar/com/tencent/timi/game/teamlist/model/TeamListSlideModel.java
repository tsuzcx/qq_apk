package com.tencent.timi.game.teamlist.model;

import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.ArrayList;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

public class TeamListSlideModel
{
  public int a;
  public List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> b = new ArrayList();
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  private TeamListFilterModel f;
  private boolean g = false;
  
  public TeamListSlideModel(TeamListFilterModel paramTeamListFilterModel)
  {
    this.f = paramTeamListFilterModel;
  }
  
  public void a()
  {
    this.c = 0;
    this.g = true;
    this.d = false;
  }
  
  public void a(String paramString, TeamListSlideModel.INotifyData paramINotifyData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("开始加载侧边栏数据originID:");
    localStringBuilder.append(paramString);
    Logger.a("TeamListSlideModel", localStringBuilder.toString());
    if (!this.d)
    {
      if (this.e) {
        return;
      }
      this.e = true;
      ((NetApi)ServiceCenter.a(NetApi.class)).a(SearchTeamListServlet.a(this.f.h(), this.f.i(), this.f.j(), paramString, this.c, 0), PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp.class, new TeamListSlideModel.1(this, paramINotifyData));
    }
  }
  
  public void a(List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList, TeamListSlideModel.INotifyData paramINotifyData)
  {
    if (paramList != null)
    {
      this.b.clear();
      this.b.addAll(paramList);
      paramINotifyData.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.TeamListSlideModel
 * JD-Core Version:    0.7.0.1
 */