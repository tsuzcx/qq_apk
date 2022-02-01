package com.tencent.timi.game.liveroom.impl.inscription;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.timi.game.liveroom.impl.inscription.net.GetAnchorRoomInfoRequest.Result;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.AnchorGameInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/inscription/LivingInscriptionInterEntranceView$anchorRoomInfoCallback$1", "Lcom/tencent/timi/game/utils/IResultListener;", "Lcom/tencent/timi/game/liveroom/impl/inscription/net/GetAnchorRoomInfoRequest$Result;", "onError", "", "errorCode", "", "errorMessage", "", "onSuccess", "result", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionInterEntranceView$anchorRoomInfoCallback$1
  implements IResultListener<GetAnchorRoomInfoRequest.Result>
{
  public void a(int paramInt, @Nullable String paramString)
  {
    String str = LivingInscriptionInterEntranceView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAnchorRoomInfo onError ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    localStringBuilder.append(' ');
    localStringBuilder.append(this.a.getRoomId());
    Logger.c(str, localStringBuilder.toString());
  }
  
  public void a(@Nullable GetAnchorRoomInfoRequest.Result paramResult)
  {
    Object localObject2 = null;
    if (paramResult != null)
    {
      localObject1 = paramResult.a();
      if (localObject1 != null)
      {
        localObject1 = ((GameDataServerOuterClass.AnchorGameInfo)localObject1).url;
        if (localObject1 != null)
        {
          localObject1 = ((PBStringField)localObject1).get();
          break label43;
        }
      }
    }
    Object localObject1 = null;
    label43:
    boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
    Object localObject3 = LivingInscriptionInterEntranceView.d(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestAnchorRoomInfo success roomId =");
    localStringBuilder.append(this.a.getRoomId());
    localStringBuilder.append(" period= ");
    if (paramResult != null) {
      localObject1 = Integer.valueOf(paramResult.c());
    } else {
      localObject1 = null;
    }
    localStringBuilder.append(localObject1);
    localStringBuilder.append(" ,");
    localStringBuilder.append(bool);
    Logger.a((String)localObject3, localStringBuilder.toString());
    if ((!LivingInscriptionInterEntranceView.e(this.a)) && (LivingInscriptionInterEntranceView.a(this.a, paramResult)))
    {
      localObject1 = this.a;
      long l;
      if (paramResult != null) {
        l = paramResult.c();
      } else {
        l = 0L;
      }
      LivingInscriptionInterEntranceView.a((LivingInscriptionInterEntranceView)localObject1, l);
      localObject1 = this.a;
      if (paramResult != null) {
        bool = paramResult.d();
      } else {
        bool = false;
      }
      ((LivingInscriptionInterEntranceView)localObject1).setSettingEntranceShowFlag(bool);
      localObject3 = this.a;
      localObject1 = localObject2;
      if (paramResult != null) {
        localObject1 = paramResult.a();
      }
      LivingInscriptionInterEntranceView.a((LivingInscriptionInterEntranceView)localObject3, (GameDataServerOuterClass.AnchorGameInfo)localObject1, true);
      LivingInscriptionReportHelper.a.a().a(this.a.getRoomId(), LivingInscriptionInterEntranceView.f(this.a));
      LivingInscriptionInterEntranceView.g(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView.anchorRoomInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */