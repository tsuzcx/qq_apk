package com.tencent.timi.game.live.impl.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.live.api.IGameLiveStatusListener;
import com.tencent.timi.game.live.impl.WifiOr4GStateHolder;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class GameLiveView$bindWifiStatusTip$1
  implements View.OnClickListener
{
  GameLiveView$bindWifiStatusTip$1(GameLiveView paramGameLiveView) {}
  
  public final void onClick(View paramView)
  {
    WifiOr4GStateHolder.a.a();
    IGameLiveStatusListener localIGameLiveStatusListener = this.a.getGameLiveStatusListener();
    if (localIGameLiveStatusListener != null) {
      localIGameLiveStatusListener.a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.video.GameLiveView.bindWifiStatusTip.1
 * JD-Core Version:    0.7.0.1
 */