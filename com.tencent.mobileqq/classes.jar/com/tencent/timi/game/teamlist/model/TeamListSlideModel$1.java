package com.tencent.timi.game.teamlist.model;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.Logger;
import java.util.List;
import trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp;

class TeamListSlideModel$1
  implements RequestListener<PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp>
{
  TeamListSlideModel$1(TeamListSlideModel paramTeamListSlideModel, TeamListSlideModel.INotifyData paramINotifyData) {}
  
  public void a(PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp paramSearchSmobaPremadesTeamRsp, FromServiceMsg paramFromServiceMsg)
  {
    TeamListSlideModel.a(this.b, false);
    if (TeamListSlideModel.a(this.b))
    {
      TeamListSlideModel.b(this.b, false);
      this.b.b.clear();
    }
    this.b.b.addAll(paramSearchSmobaPremadesTeamRsp.list.get());
    this.b.a = paramSearchSmobaPremadesTeamRsp.total.get();
    TeamListSlideModel.c(this.b, paramSearchSmobaPremadesTeamRsp.more.get() ^ true);
    paramSearchSmobaPremadesTeamRsp = this.b;
    TeamListSlideModel.a(paramSearchSmobaPremadesTeamRsp, TeamListSlideModel.b(paramSearchSmobaPremadesTeamRsp) + 1);
    paramSearchSmobaPremadesTeamRsp = new StringBuilder();
    paramSearchSmobaPremadesTeamRsp.append("总车队数目：");
    paramSearchSmobaPremadesTeamRsp.append(this.b.a);
    paramSearchSmobaPremadesTeamRsp.append(" 是否加载完成");
    paramSearchSmobaPremadesTeamRsp.append(TeamListSlideModel.c(this.b));
    paramSearchSmobaPremadesTeamRsp.append(" 当前页码:");
    paramSearchSmobaPremadesTeamRsp.append(TeamListSlideModel.b(this.b) - 1);
    Logger.b("TeamListSlideModel", paramSearchSmobaPremadesTeamRsp.toString());
    this.a.a();
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp paramSearchSmobaPremadesTeamRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    TeamListSlideModel.a(this.b, false);
    TeamListSlideModel.b(this.b, false);
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.TeamListSlideModel.1
 * JD-Core Version:    0.7.0.1
 */