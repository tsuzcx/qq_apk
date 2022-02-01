package com.tencent.timi.game.teamlist.model;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.net.api.BaseTimiGameServlet;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import java.util.ArrayList;
import mqq.app.NewIntent;
import trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamReq;

public class SearchTeamListServlet
  extends BaseTimiGameServlet
{
  public static NewIntent a(ArrayList<Integer> paramArrayList1, ArrayList<Integer> paramArrayList2, ArrayList<Integer> paramArrayList3, String paramString, int paramInt1, int paramInt2)
  {
    PremadesTeamServerOuterClass.SearchSmobaPremadesTeamReq localSearchSmobaPremadesTeamReq = new PremadesTeamServerOuterClass.SearchSmobaPremadesTeamReq();
    if (paramArrayList1 != null) {
      localSearchSmobaPremadesTeamReq.game_mode_list.addAll(paramArrayList1);
    }
    if (paramArrayList2 != null) {
      localSearchSmobaPremadesTeamReq.grade_list.addAll(paramArrayList2);
    }
    if (paramArrayList3 != null) {
      localSearchSmobaPremadesTeamReq.lane_type_list.addAll(paramArrayList3);
    }
    localSearchSmobaPremadesTeamReq.origin_id.set(paramString);
    localSearchSmobaPremadesTeamReq.page.set(paramInt1);
    localSearchSmobaPremadesTeamReq.display_type.set(paramInt2);
    return BaseTimiGameServlet.CreateReqIntentUtil.a(localSearchSmobaPremadesTeamReq, SearchTeamListServlet.class);
  }
  
  protected int a()
  {
    return 501;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.SearchTeamListServlet
 * JD-Core Version:    0.7.0.1
 */