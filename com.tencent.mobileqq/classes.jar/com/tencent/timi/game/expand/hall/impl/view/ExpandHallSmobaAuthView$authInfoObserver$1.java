package com.tencent.timi.game.expand.hall.impl.view;

import androidx.lifecycle.Observer;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameDataServerOuterClass.GetSmobaAuthInfoRsp;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ltrpc/yes/common/GameDataServerOuterClass$GetSmobaAuthInfoRsp;", "onChanged"}, k=3, mv={1, 1, 16})
final class ExpandHallSmobaAuthView$authInfoObserver$1<T>
  implements Observer<GameDataServerOuterClass.GetSmobaAuthInfoRsp>
{
  ExpandHallSmobaAuthView$authInfoObserver$1(ExpandHallSmobaAuthView paramExpandHallSmobaAuthView) {}
  
  public final void a(@Nullable GameDataServerOuterClass.GetSmobaAuthInfoRsp paramGetSmobaAuthInfoRsp)
  {
    ExpandHallSmobaAuthView.a(this.a, paramGetSmobaAuthInfoRsp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.view.ExpandHallSmobaAuthView.authInfoObserver.1
 * JD-Core Version:    0.7.0.1
 */