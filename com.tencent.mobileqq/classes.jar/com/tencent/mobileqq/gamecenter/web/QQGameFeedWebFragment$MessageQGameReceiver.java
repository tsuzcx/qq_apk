package com.tencent.mobileqq.gamecenter.web;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.media.GameVideoManager;
import java.util.ArrayList;

class QQGameFeedWebFragment$MessageQGameReceiver
  extends BroadcastReceiver
{
  private QQGameFeedWebFragment$MessageQGameReceiver(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (!"action_qgame_tool_messgae".equals(paramContext)) {
            break;
          }
          paramContext = paramIntent.getExtras();
        } while (paramContext == null);
        paramContext = (ArrayList)paramContext.getSerializable("key_get_msg");
      } while ((paramContext == null) || (paramContext.size() <= 0));
      ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.MessageQGameReceiver.1(this, paramContext));
      return;
      if ("action_qgame_jaspi_webloaded".equals(paramContext))
      {
        ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.MessageQGameReceiver.2(this));
        return;
      }
      if ("action_qgame_h5_video_play".equals(paramContext))
      {
        GameVideoManager.b(2);
        return;
      }
    } while (!"action_qgame_h5_video_pause".equals(paramContext));
    GameVideoManager.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.MessageQGameReceiver
 * JD-Core Version:    0.7.0.1
 */