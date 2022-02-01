package com.tencent.timi.game.expand.hall.impl.view;

import androidx.lifecycle.Observer;
import com.tencent.mobileqq.app.QBaseActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaDefaultRoleRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaDefaultRoleRsp;", "onChanged"}, k=3, mv={1, 1, 16})
final class ExpandHallInfoView$bindValue$1<T>
  implements Observer<GameDataServerOuterClass.GetSmobaDefaultRoleRsp>
{
  ExpandHallInfoView$bindValue$1(ExpandHallInfoView paramExpandHallInfoView, QBaseActivity paramQBaseActivity) {}
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaDefaultRoleRsp paramGetSmobaDefaultRoleRsp)
  {
    ExpandHallInfoView.a(this.a, this.b, paramGetSmobaDefaultRoleRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallInfoView.bindValue.1
 * JD-Core Version:    0.7.0.1
 */