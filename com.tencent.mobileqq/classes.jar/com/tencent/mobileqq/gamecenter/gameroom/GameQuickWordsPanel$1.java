package com.tencent.mobileqq.gamecenter.gameroom;

import android.view.View;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;

class GameQuickWordsPanel$1
  implements AdapterView.OnItemClickListener
{
  GameQuickWordsPanel$1(GameQuickWordsPanel paramGameQuickWordsPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramView = new ChatActivityFacade.SendMsgParams();
    paramView.c = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    paramView.a = System.currentTimeMillis();
    ChatActivityFacade.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, paramAdapterView, null, paramView);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.ad();
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "send_default", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.gameroom.GameQuickWordsPanel.1
 * JD-Core Version:    0.7.0.1
 */