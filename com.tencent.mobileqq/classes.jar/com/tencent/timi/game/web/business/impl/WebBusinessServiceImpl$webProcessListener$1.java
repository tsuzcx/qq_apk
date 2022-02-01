package com.tencent.timi.game.web.business.impl;

import com.tencent.mobileqq.webview.util.WebProcessStartListener;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/web/business/impl/WebBusinessServiceImpl$webProcessListener$1", "Lcom/tencent/mobileqq/webview/util/WebProcessStartListener;", "onResult", "", "realStartProcess", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class WebBusinessServiceImpl$webProcessListener$1
  implements WebProcessStartListener
{
  public void onResult(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("webProcessListener ");
    localStringBuilder.append(paramBoolean);
    Logger.b("WebBusinessServiceImpl ", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.WebBusinessServiceImpl.webProcessListener.1
 * JD-Core Version:    0.7.0.1
 */