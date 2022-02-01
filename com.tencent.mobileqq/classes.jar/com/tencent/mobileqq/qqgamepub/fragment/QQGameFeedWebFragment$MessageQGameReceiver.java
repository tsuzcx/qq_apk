package com.tencent.mobileqq.qqgamepub.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqgamepub.utils.GameVideoManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QQGameFeedWebFragment$MessageQGameReceiver
  extends BroadcastReceiver
{
  private QQGameFeedWebFragment$MessageQGameReceiver(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = new StringBuilder();
    paramContext.append("MessageQGameReceiver onReceive action = ");
    paramContext.append(paramIntent.getAction());
    QLog.d("GameWebPage", 1, paramContext.toString());
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    if ("action_qgame_tool_messgae".equals(paramContext))
    {
      paramContext = paramIntent.getExtras();
      if (paramContext != null)
      {
        paramContext = (ArrayList)paramContext.getSerializable("key_get_msg");
        if ((paramContext != null) && (paramContext.size() > 0)) {
          ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.MessageQGameReceiver.1(this, paramContext));
        }
      }
    }
    else
    {
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
      if ("action_qgame_h5_video_pause".equals(paramContext))
      {
        GameVideoManager.b(1);
        return;
      }
      if (("action_qgame_delete_ad".equals(paramContext)) && (this.a.getQBaseActivity() != null) && (this.a.isAdded()) && (!this.a.getQBaseActivity().isFinishing())) {
        try
        {
          paramContext = paramIntent.getStringExtra("arkViewId");
          boolean bool = paramIntent.getBooleanExtra("isAioDeletMsg", false);
          if (!TextUtils.isEmpty(paramContext))
          {
            QQGameFeedWebFragment.a(this.a, paramContext, bool);
            return;
          }
        }
        catch (Throwable paramContext)
        {
          paramContext.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.fragment.QQGameFeedWebFragment.MessageQGameReceiver
 * JD-Core Version:    0.7.0.1
 */