package com.tencent.timi.game.component.qqlive.impl.common;

import android.text.TextUtils;
import com.tencent.mobileqq.qqlive.callback.room.audience.LiveRoomStatusListener;
import com.tencent.timi.game.component.qqlive.impl.anchor.TgLiveAnchorRoomManager;
import com.tencent.timi.game.ui.widget.CustomToastView;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.utils.livedata.LiveDataExtKt;

class TgLiveRoomListenerHandler$1
  implements LiveRoomStatusListener
{
  TgLiveRoomListenerHandler$1(TgLiveRoomListenerHandler paramTgLiveRoomListenerHandler) {}
  
  public void onRoomClose(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRoomClose, closeType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" closeReason:");
    localStringBuilder.append(paramString);
    Logger.c("TgLiveTag_TgLiveRoomListenerHandler", localStringBuilder.toString());
    if (((Boolean)LiveDataExtKt.a(TgLiveRoomUIData.a().b(), Boolean.valueOf(false))).booleanValue())
    {
      if (!TextUtils.isEmpty(paramString)) {
        CustomToastView.a(paramString);
      }
      TgLiveAnchorRoomManager.a().a(null);
    }
  }
  
  public void onRoomOpen()
  {
    Logger.a("TgLiveTag_TgLiveRoomListenerHandler", "onRoomOpen");
  }
  
  public void onRoomPause()
  {
    Logger.a("TgLiveTag_TgLiveRoomListenerHandler", "onRoomPause");
  }
  
  public void onRoomResume()
  {
    Logger.a("TgLiveTag_TgLiveRoomListenerHandler", "onRoomResume");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.component.qqlive.impl.common.TgLiveRoomListenerHandler.1
 * JD-Core Version:    0.7.0.1
 */