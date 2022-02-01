package com.tencent.timi.game.profile.impl.view;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/profile/impl/view/ProfileItemInTeamView$acquireSmobaTeamInfo$listener$1", "Lcom/tencent/timi/game/net/api/RequestListener;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$BatchGetSmobaTeamInfoRsp;", "onError", "", "isMsfSuccess", "", "msfResultCode", "", "timiErrCode", "timiSubErrCode", "timiErrMsg", "", "timiDisplayErrMsg", "response", "originalMsfRsp", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "onSuccess", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ProfileItemInTeamView$acquireSmobaTeamInfo$listener$1
  implements RequestListener<PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp>
{
  ProfileItemInTeamView$acquireSmobaTeamInfo$listener$1(long paramLong) {}
  
  public void a(@Nullable PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp paramBatchGetSmobaTeamInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    if (!ProfileItemInTeamView.e(this.a))
    {
      boolean bool = false;
      if (paramBatchGetSmobaTeamInfoRsp != null)
      {
        paramFromServiceMsg = paramBatchGetSmobaTeamInfoRsp.team_list;
        if (paramFromServiceMsg != null)
        {
          i = paramFromServiceMsg.size();
          break label36;
        }
      }
      int i = 0;
      label36:
      if ((i > 0) && (ProfileItemInTeamView.a(this.a, paramBatchGetSmobaTeamInfoRsp)))
      {
        ProfileItemInTeamView localProfileItemInTeamView = this.a;
        if (paramBatchGetSmobaTeamInfoRsp != null)
        {
          paramFromServiceMsg = paramBatchGetSmobaTeamInfoRsp.team_list;
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = (PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)paramFromServiceMsg.get(0);
            break label84;
          }
        }
        paramFromServiceMsg = null;
        label84:
        ProfileItemInTeamView.a(localProfileItemInTeamView, paramFromServiceMsg);
        paramFromServiceMsg = this.a;
        if (ProfileItemInTeamView.b(paramFromServiceMsg, ProfileItemInTeamView.b(paramFromServiceMsg)))
        {
          ProfileItemInTeamView.a(this.a, false);
          return;
        }
        paramFromServiceMsg = ProfileItemInTeamView.b(this.a);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = paramFromServiceMsg.id;
          if (paramFromServiceMsg != null)
          {
            l = paramFromServiceMsg.get();
            break label148;
          }
        }
        long l = 0L;
        paramFromServiceMsg = this.a;
        if (l != 0L) {
          bool = true;
        }
        ProfileItemInTeamView.a(paramFromServiceMsg, bool);
        paramFromServiceMsg = this.a;
        ProfileItemInTeamView.c(paramFromServiceMsg, ProfileItemInTeamView.b(paramFromServiceMsg));
        paramFromServiceMsg = this.a;
        ProfileItemInTeamView.d(paramFromServiceMsg, ProfileItemInTeamView.b(paramFromServiceMsg));
        paramFromServiceMsg = this.a;
        ProfileItemInTeamView.a(paramFromServiceMsg, paramBatchGetSmobaTeamInfoRsp, ProfileItemInTeamView.b(paramFromServiceMsg));
        return;
      }
      label148:
      ProfileItemInTeamView.a(this.a, false);
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString1, @Nullable String paramString2, @Nullable PremadesTeamServerOuterClass.BatchGetSmobaTeamInfoRsp paramBatchGetSmobaTeamInfoRsp, @Nullable FromServiceMsg paramFromServiceMsg)
  {
    paramBatchGetSmobaTeamInfoRsp = ProfileItemInTeamView.d(this.a);
    paramFromServiceMsg = new StringBuilder();
    paramFromServiceMsg.append("acquireSmobaTeamInfo - onError -");
    paramFromServiceMsg.append(paramString1);
    paramFromServiceMsg.append('-');
    paramFromServiceMsg.append(paramString2);
    paramFromServiceMsg.append(' ');
    paramFromServiceMsg.append(this.b);
    Logger.c(paramBatchGetSmobaTeamInfoRsp, paramFromServiceMsg.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.profile.impl.view.ProfileItemInTeamView.acquireSmobaTeamInfo.listener.1
 * JD-Core Version:    0.7.0.1
 */