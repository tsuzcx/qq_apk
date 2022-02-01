package com.tencent.timi.game.initer.impl;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.timi.game.app.event.AppBecomeForegroundEvent;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class TGGroundInterfaceWrapper$onApplicationForeground$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    SimpleEventBus.getInstance().dispatchEvent((SimpleBaseEvent)new AppBecomeForegroundEvent());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.initer.impl.TGGroundInterfaceWrapper.onApplicationForeground.1
 * JD-Core Version:    0.7.0.1
 */