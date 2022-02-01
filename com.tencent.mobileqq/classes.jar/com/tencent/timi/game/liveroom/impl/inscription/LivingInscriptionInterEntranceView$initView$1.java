package com.tencent.timi.game.liveroom.impl.inscription;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import com.tencent.timi.game.web.business.api.IWebBusinessService;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class LivingInscriptionInterEntranceView$initView$1
  implements View.OnClickListener
{
  LivingInscriptionInterEntranceView$initView$1(LivingInscriptionInterEntranceView paramLivingInscriptionInterEntranceView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Activity localActivity = CommonExKt.a(this.a);
      if ((localActivity instanceof Activity)) {
        if (TextUtils.isEmpty((CharSequence)LivingInscriptionInterEntranceView.a(this.a))) {
          CustomToastView.a("数据出错，请稍后重试");
        } else {
          ((IWebBusinessService)ServiceCenter.a(IWebBusinessService.class)).a(localActivity, LivingInscriptionInterEntranceView.a(this.a), LivingInscriptionInterEntranceView.b(this.a), this.a.getGameId(), LivingInscriptionInterEntranceView.c(this.a));
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.inscription.LivingInscriptionInterEntranceView.initView.1
 * JD-Core Version:    0.7.0.1
 */