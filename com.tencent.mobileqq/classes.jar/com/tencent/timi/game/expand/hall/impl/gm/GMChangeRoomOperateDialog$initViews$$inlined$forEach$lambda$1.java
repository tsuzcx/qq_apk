package com.tencent.timi.game.expand.hall.impl.gm;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import trpc.yes.common.RecommendProxyOuterClass.KuolieRoomInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/timi/game/expand/hall/impl/gm/GMChangeRoomOperateDialog$initViews$1$1"}, k=3, mv={1, 1, 16})
final class GMChangeRoomOperateDialog$initViews$$inlined$forEach$lambda$1
  implements View.OnClickListener
{
  GMChangeRoomOperateDialog$initViews$$inlined$forEach$lambda$1(RecommendProxyOuterClass.KuolieRoomInfo paramKuolieRoomInfo, GMChangeRoomOperateDialog paramGMChangeRoomOperateDialog, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      GMChangeRoomOperateDialog.ItemClickListener localItemClickListener = this.b.a();
      if (localItemClickListener != null)
      {
        RecommendProxyOuterClass.KuolieRoomInfo localKuolieRoomInfo = this.a;
        Context localContext = GMChangeRoomOperateDialog.a(this.b);
        Intrinsics.checkExpressionValueIsNotNull(localContext, "context");
        localItemClickListener.a(localKuolieRoomInfo, localContext);
      }
      this.b.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.gm.GMChangeRoomOperateDialog.initViews..inlined.forEach.lambda.1
 * JD-Core Version:    0.7.0.1
 */