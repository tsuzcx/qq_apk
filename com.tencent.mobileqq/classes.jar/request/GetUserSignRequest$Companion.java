package request;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.net.api.BaseTimiGameServlet.CreateReqIntentUtil;
import kotlin.Metadata;
import mqq.app.NewIntent;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.TcloudServerOuterClass.GetUserTCloudSignReq;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lrequest/GetUserSignRequest$Companion;", "", "()V", "createReqIntent", "Lmqq/app/NewIntent;", "userId", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class GetUserSignRequest$Companion
{
  @Nullable
  public final NewIntent a(long paramLong)
  {
    TcloudServerOuterClass.GetUserTCloudSignReq localGetUserTCloudSignReq = new TcloudServerOuterClass.GetUserTCloudSignReq();
    localGetUserTCloudSignReq.uid.set(paramLong);
    return BaseTimiGameServlet.CreateReqIntentUtil.a((MessageMicro)localGetUserTCloudSignReq, GetUserSignRequest.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     request.GetUserSignRequest.Companion
 * JD-Core Version:    0.7.0.1
 */