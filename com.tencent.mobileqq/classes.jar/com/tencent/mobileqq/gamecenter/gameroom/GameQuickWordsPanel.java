package com.tencent.mobileqq.gamecenter.gameroom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  GameRoomChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public WerewolvesPluginManager a;
  XListView jdField_a_of_type_ComTencentWidgetXListView = null;
  public String a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  
  public GameQuickWordsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a()
  {
    ((GameQuickWordsPanel.WordsAdapter)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, GameRoomChatPie paramGameRoomChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie = paramGameRoomChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = ((WerewolvesHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (paramQQAppInterface != null) {
      paramQQAppInterface = paramQQAppInterface.a();
    } else {
      paramQQAppInterface = null;
    }
    if ((paramQQAppInterface != null) && (paramQQAppInterface.size() != 0))
    {
      this.jdField_a_of_type_JavaUtilArrayList = paramQQAppInterface;
    }
    else
    {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705156));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705157));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705160));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705159));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705158));
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367503));
    this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new GameQuickWordsPanel.1(this));
    paramQQAppInterface = new GameQuickWordsPanel.WordsAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
    paramQQAppInterface.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */