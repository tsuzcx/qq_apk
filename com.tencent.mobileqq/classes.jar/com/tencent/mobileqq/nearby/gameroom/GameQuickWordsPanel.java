package com.tencent.mobileqq.nearby.gameroom;

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
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0)) {
        break label132;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramQQAppInterface;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131367744));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new GameQuickWordsPanel.1(this));
      paramQQAppInterface = new GameQuickWordsPanel.WordsAdapter(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label132:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705079));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705080));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705083));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705082));
      this.jdField_a_of_type_JavaUtilArrayList.add(HardCodeUtil.a(2131705081));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */