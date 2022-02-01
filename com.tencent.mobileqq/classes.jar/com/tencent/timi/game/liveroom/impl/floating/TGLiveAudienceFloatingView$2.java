package com.tencent.timi.game.liveroom.impl.floating;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import mqq.app.MobileQQ;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class TGLiveAudienceFloatingView$2
  implements View.OnClickListener
{
  TGLiveAudienceFloatingView$2(TGLiveAudienceFloatingView paramTGLiveAudienceFloatingView) {}
  
  public final void onClick(View paramView)
  {
    Intent localIntent = TGLiveAudienceFloatingView.a(this.a);
    if (localIntent != null) {
      MobileQQ.context.startActivity(localIntent);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.floating.TGLiveAudienceFloatingView.2
 * JD-Core Version:    0.7.0.1
 */