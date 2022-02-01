package com.tencent.timi.game.teamlist.model;

import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import java.util.List;
import mqq.app.NewIntent;
import trpc.yes.common.PremadesTeamServerOuterClass.RefreshAPIReq;

public class BatchUpdateTeamListServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(List<Long> paramList1, List<Long> paramList2)
  {
    PremadesTeamServerOuterClass.RefreshAPIReq localRefreshAPIReq = new PremadesTeamServerOuterClass.RefreshAPIReq();
    localRefreshAPIReq.team_id_list.set(paramList1);
    localRefreshAPIReq.uid_list.set(paramList2);
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localRefreshAPIReq, BatchUpdateTeamListServlet.class);
  }
  
  protected int a()
  {
    return 504;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.BatchUpdateTeamListServlet
 * JD-Core Version:    0.7.0.1
 */