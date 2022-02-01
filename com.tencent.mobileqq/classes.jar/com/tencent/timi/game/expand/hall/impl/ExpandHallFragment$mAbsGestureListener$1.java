package com.tencent.timi.game.expand.hall.impl;

import android.view.MotionEvent;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.AbsGestureListener;
import com.tencent.mobileqq.guild.mainframe.attachcontainer.NotifyData;
import com.tencent.timi.game.component.chat.GroupChatView;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/expand/hall/impl/ExpandHallFragment$mAbsGestureListener$1", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/AbsGestureListener;", "onChildConsumeTouchEvent", "", "event", "Landroid/view/MotionEvent;", "onNotify", "", "notifyData", "Lcom/tencent/mobileqq/guild/mainframe/attachcontainer/NotifyData;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandHallFragment$mAbsGestureListener$1
  extends AbsGestureListener
{
  public void a(@Nullable NotifyData paramNotifyData)
  {
    super.a(paramNotifyData);
    int i;
    if (paramNotifyData != null) {
      i = paramNotifyData.b();
    } else {
      i = -2;
    }
    Logger.a("ExpandHallFragment_", String.valueOf(i));
    if ((paramNotifyData != null) && (paramNotifyData.b() == 0))
    {
      ExpandHallFragment.c(this.a, true);
      ExpandHallFragment.n(this.a);
    }
    else
    {
      ExpandHallFragment.c(this.a, false);
      ExpandHallFragment.o(this.a);
    }
    if (paramNotifyData != null)
    {
      ExpandHallFragment.a(this.a, paramNotifyData);
      ExpandHallFragment.b(this.a, paramNotifyData);
    }
    if (paramNotifyData != null)
    {
      Logger.b("ExpandHallFragment_", String.valueOf(paramNotifyData.a()));
      if (paramNotifyData.a() == 2) {
        ((GroupChatView)this.a.c(2131434395)).a();
      }
    }
  }
  
  public boolean a(@Nullable MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent == null) {
      return false;
    }
    return ExpandHallFragment.a(this.a, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.expand.hall.impl.ExpandHallFragment.mAbsGestureListener.1
 * JD-Core Version:    0.7.0.1
 */