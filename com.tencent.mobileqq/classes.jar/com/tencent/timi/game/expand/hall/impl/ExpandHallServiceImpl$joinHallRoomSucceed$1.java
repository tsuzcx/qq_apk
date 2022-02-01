package com.tencent.timi.game.expand.hall.impl;

import com.tencent.timi.game.expand.hall.api.ExpandHallLifeCycleListener;
import com.tencent.timi.game.expand.hall.api.IExpandHall;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import mqq.util.WeakReference;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ExpandHallServiceImpl$joinHallRoomSucceed$1
  implements Runnable
{
  ExpandHallServiceImpl$joinHallRoomSucceed$1(ExpandHallServiceImpl paramExpandHallServiceImpl, long paramLong, IExpandHall paramIExpandHall) {}
  
  public final void run()
  {
    Iterator localIterator = ExpandHallServiceImpl.a(this.this$0).iterator();
    while (localIterator.hasNext())
    {
      ExpandHallLifeCycleListener localExpandHallLifeCycleListener = (ExpandHallLifeCycleListener)((WeakReference)localIterator.next()).get();
      if (localExpandHallLifeCycleListener != null) {
        localExpandHallLifeCycleListener.a(this.a, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallServiceImpl.joinHallRoomSucceed.1
 * JD-Core Version:    0.7.0.1
 */