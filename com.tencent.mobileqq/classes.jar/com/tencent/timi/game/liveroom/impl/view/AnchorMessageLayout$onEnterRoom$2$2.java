package com.tencent.timi.game.liveroom.impl.view;

import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.mobileqq.qqlive.data.announce.AnnouncePushMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/liveroom/impl/view/AnchorMessageLayout$onEnterRoom$2$2", "Lcom/tencent/mobileqq/qqlive/callback/announce/IQQLiveGetAnnounceCallback;", "onFail", "", "errCode", "", "errMsg", "", "onSuccess", "announce", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AnchorMessageLayout$onEnterRoom$2$2
  implements IQQLiveGetAnnounceCallback
{
  public void a(int paramInt, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getRoomAnnounce errCode = [");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], errMsg = [");
    localStringBuilder.append(paramString);
    localStringBuilder.append(']');
    Logger.c("AnchorMessageLayout", localStringBuilder.toString());
  }
  
  public void a(@Nullable String paramString)
  {
    Logger.a("AnchorMessageLayout", "getRoomAnnounce suc");
    CharSequence localCharSequence = (CharSequence)paramString;
    int j = 0;
    int i;
    if ((localCharSequence != null) && (!StringsKt.isBlank(localCharSequence))) {
      i = 0;
    } else {
      i = 1;
    }
    Object localObject;
    if (i != 0)
    {
      long l = this.a.b;
      localObject = ServiceCenter.a(ITgLiveRoomService.class);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ServiceCenter.getService…eRoomService::class.java)");
      localObject = ((ITgLiveRoomService)localObject).f();
      if ((localObject == null) || (l != ((LiveUserInfo)localObject).uid)) {}
    }
    else
    {
      localObject = this.a.this$0;
      AnnouncePushMessage localAnnouncePushMessage = new AnnouncePushMessage();
      if (localCharSequence != null)
      {
        i = j;
        if (!StringsKt.isBlank(localCharSequence)) {}
      }
      else
      {
        i = 1;
      }
      if (i != 0) {
        paramString = "房间没有公告，赶快去设置一个吧~";
      }
      localAnnouncePushMessage.announce = paramString;
      localAnnouncePushMessage.roomId = this.a.a;
      localAnnouncePushMessage.uid = this.a.b;
      ((AnchorMessageLayout)localObject).a(localAnnouncePushMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.AnchorMessageLayout.onEnterRoom.2.2
 * JD-Core Version:    0.7.0.1
 */