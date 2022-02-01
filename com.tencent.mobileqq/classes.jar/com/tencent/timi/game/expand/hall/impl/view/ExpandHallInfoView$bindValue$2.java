package com.tencent.timi.game.expand.hall.impl.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "onChanged"}, k=3, mv={1, 1, 16})
final class ExpandHallInfoView$bindValue$2<T>
  implements Observer<GameDataServerOuterClass.GetSmobaAuthInfoRsp>
{
  ExpandHallInfoView$bindValue$2(ExpandHallInfoView paramExpandHallInfoView, QBaseActivity paramQBaseActivity) {}
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    ExpandHallInfoView.a(this.a, this.b, (GameDataServerOuterClass.GetSmobaDefaultRoleRsp)((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a().getValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.bindValue.2
 * JD-Core Version:    0.7.0.1
 */