package com.tencent.timi.game.teamlist.model;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.teamlist.util.TimiNetErrorDisplayUtil;
import com.tencent.timi.game.utils.Logger;
import java.util.Vector;
import trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp;

class TeamListModel$1
  implements RequestListener<PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp>
{
  TeamListModel$1(TeamListModel paramTeamListModel, TeamListModel.INotifyData paramINotifyData) {}
  
  public void a(PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp paramSearchSmobaPremadesTeamRsp, FromServiceMsg paramFromServiceMsg)
  {
    this.b.c.clear();
    this.b.c.addAll(paramSearchSmobaPremadesTeamRsp.list.get());
    this.b.a = paramSearchSmobaPremadesTeamRsp.total.get();
    this.b.b = paramSearchSmobaPremadesTeamRsp.refresh_interval.get();
    this.b.d = paramSearchSmobaPremadesTeamRsp.more.get();
    this.a.d();
    TeamListModel.a(this.b, false);
    Logger.b("TeamListModel", "首页数据加载完成");
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2, @Nullable PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp paramSearchSmobaPremadesTeamRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    TeamListModel.a(this.b, false);
    Logger.b("TeamListModel", "首页数据加载失败");
    TimiNetErrorDisplayUtil.a("TeamListModel", paramInt2, paramInt3, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.TeamListModel.1
 * JD-Core Version:    0.7.0.1
 */