package com.tencent.timi.game.liveroom.impl.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.liveroom.impl.fans.LivingFansGroupListDialog;
import com.tencent.timi.game.liveroom.impl.util.LivingWebUtil;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.CommonExKt;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.NoDoubleClickUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class AnchorTopAreaView$2
  implements View.OnClickListener
{
  AnchorTopAreaView$2(AnchorTopAreaView paramAnchorTopAreaView) {}
  
  public final void onClick(View paramView)
  {
    if (!NoDoubleClickUtils.a())
    {
      Activity localActivity = CommonExKt.a(this.a);
      List localList = (List)AnchorTopAreaView.e(this.a).get(Long.valueOf(AnchorTopAreaView.f(this.a)));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("funGroupEntranceView setOnClickListener ");
      localStringBuilder.append(localActivity);
      localStringBuilder.append(' ');
      boolean bool;
      if (localList != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      localStringBuilder.append(' ');
      Object localObject;
      if (localList != null) {
        localObject = Integer.valueOf(localList.size());
      } else {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      Logger.a("AnchorTopAreaView_", localStringBuilder.toString());
      if ((localActivity instanceof Activity)) {
        if (!AnchorTopAreaView.c(this.a))
        {
          if (localList != null) {
            new LivingFansGroupListDialog((Context)localActivity, AnchorTopAreaView.f(this.a), localList, AnchorTopAreaView.g(this.a)).show();
          }
        }
        else
        {
          localObject = ServiceCenter.a(ILoginCoreService.class);
          Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…nCoreService::class.java)");
          long l = ((ILoginCoreService)localObject).a();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("https://h5.qzone.qq.com/subscription/fansqun/");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("?_proxy=1&_wv=3");
          localObject = ((StringBuilder)localObject).toString();
          LivingWebUtil.a.a((Context)localActivity, (String)localObject);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorTopAreaView.2
 * JD-Core Version:    0.7.0.1
 */