package com.tencent.timi.game.profile.impl.net;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import java.util.List;
import kotlin.Metadata;
import mqq.app.NewIntent;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/profile/impl/net/BatchGetSmobaTeamInfoServlet$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "teamIdList", "", "", "uidId", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class BatchGetSmobaTeamInfoServlet$Companion
{
  @Nullable
  public final NewIntent a(@Nullable List<Long> paramList, long paramLong)
  {
    PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoReq localBatchGetSmobaTeamInfoReq = new PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoReq();
    localBatchGetSmobaTeamInfoReq.team_id_list.set(paramList);
    localBatchGetSmobaTeamInfoReq.uid.set(paramLong);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localBatchGetSmobaTeamInfoReq, BatchGetSmobaTeamInfoServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.net.BatchGetSmobaTeamInfoServlet.Companion
 * JD-Core Version:    0.7.0.1
 */