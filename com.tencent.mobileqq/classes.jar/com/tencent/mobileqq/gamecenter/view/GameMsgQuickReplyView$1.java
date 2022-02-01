package com.tencent.mobileqq.gamecenter.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.data.GameMsgQuickReplyInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgQuickReplyView$1
  implements AdapterView.OnItemClickListener
{
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (GameMsgQuickReplyView.a(this.a) != null) {
      try
      {
        GameMsgQuickReplyInfo localGameMsgQuickReplyInfo = (GameMsgQuickReplyInfo)paramAdapterView.getItemAtPosition(paramInt);
        if (GameMsgQuickReplyView.a(this.a).e(localGameMsgQuickReplyInfo.a)) {
          ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportForGameMsg(GameMsgChatPie.bi, "1", "145", "920", "92005", "207649", localGameMsgQuickReplyInfo.a, "", "20", "");
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("GameMsgQuickReplyView", 1, localThrowable, new Object[0]);
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameMsgQuickReplyView.1
 * JD-Core Version:    0.7.0.1
 */