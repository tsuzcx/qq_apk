package com.tencent.mobileqq.gamecenter.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.gamecenter.data.GameMsgQuickReplyInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgQuickReplyView$1
  implements AdapterView.OnItemClickListener
{
  GameMsgQuickReplyView$1(GameMsgQuickReplyView paramGameMsgQuickReplyView) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (GameMsgQuickReplyView.a(this.a) != null) {}
    try
    {
      GameMsgQuickReplyInfo localGameMsgQuickReplyInfo = (GameMsgQuickReplyInfo)paramAdapterView.getItemAtPosition(paramInt);
      if (GameMsgQuickReplyView.a(this.a).a(localGameMsgQuickReplyInfo.a)) {
        GameMsgUtil.a(GameMsgChatPie.h, "1", "145", "920", "92005", "207649", localGameMsgQuickReplyInfo.a, "", "20", "");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("GameMsgQuickReplyView", 1, localThrowable, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameMsgQuickReplyView.1
 * JD-Core Version:    0.7.0.1
 */