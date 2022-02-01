package com.tencent.timi.game.team.impl.chat;

import android.os.Handler;
import android.os.Message;
import com.tencent.timi.game.tim.api.message.IMsgManager;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/team/impl/chat/TeamChatView$historyHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TeamChatView$historyHandler$1
  extends Handler
{
  public void handleMessage(@Nullable Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = this.a.getIMsgManager();
    if (paramMessage != null) {
      paramMessage.a(TeamChatView.e(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.team.impl.chat.TeamChatView.historyHandler.1
 * JD-Core Version:    0.7.0.1
 */