package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$iQQLiveAnnouncePushListener$1", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveAnnouncePushListener;", "onAnnounceReceive", "", "announcePushMessage", "Lcom/tencent/mobileqq/qqlive/data/announce/AnnouncePushMessage;", "onFail", "errCode", "", "errMsg", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$iQQLiveAnnouncePushListener$1
  implements IQQLiveAnnouncePushListener
{
  public void a(int paramInt, @Nullable String paramString) {}
  
  public void a(@NotNull AnnouncePushMessage paramAnnouncePushMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnouncePushMessage, "announcePushMessage");
    this.a.a(paramAnnouncePushMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.iQQLiveAnnouncePushListener.1
 * JD-Core Version:    0.7.0.1
 */