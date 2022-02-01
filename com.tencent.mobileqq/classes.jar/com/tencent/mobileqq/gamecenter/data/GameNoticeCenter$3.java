package com.tencent.mobileqq.gamecenter.data;

import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class GameNoticeCenter$3
  implements View.OnClickListener
{
  GameNoticeCenter$3(GameNoticeCenter paramGameNoticeCenter, String paramString) {}
  
  public void onClick(View paramView)
  {
    Message localMessage = GameNoticeCenter.access$200(this.jdField_a_of_type_ComTencentMobileqqGamecenterDataGameNoticeCenter).obtainMessage(2);
    localMessage.obj = this.jdField_a_of_type_JavaLangString;
    localMessage.sendToTarget();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.data.GameNoticeCenter.3
 * JD-Core Version:    0.7.0.1
 */