package com.tencent.mobileqq.confess;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.confess.data.TroopConfessMsg;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class TroopConfessItemBuilder$1
  implements View.OnClickListener
{
  TroopConfessItemBuilder$1(TroopConfessItemBuilder paramTroopConfessItemBuilder, MessageForTroopConfess paramMessageForTroopConfess) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mTroopConfessMsg != null) && (this.a.mTroopConfessMsg.items != null) && (!this.a.mTroopConfessMsg.items.isEmpty())) {
      TroopConfessUtil.a(this.b.d, this.b.e, 1, this.b.f.b, this.a.getConfessTopicId(), String.valueOf(this.a.mTroopConfessMsg.confessorUin), String.valueOf(this.a.getConfessToUin()));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.TroopConfessItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */