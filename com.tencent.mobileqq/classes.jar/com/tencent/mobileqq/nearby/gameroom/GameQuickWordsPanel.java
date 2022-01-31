package com.tencent.mobileqq.nearby.gameroom;

import aeae;
import aeaf;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class GameQuickWordsPanel
  extends RelativeLayout
{
  public SessionInfo a;
  public GameRoomChatPie a;
  public QQAppInterface a;
  public WerewolvesPluginManager a;
  XListView a;
  public String a;
  public ArrayList a;
  
  public GameQuickWordsPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentWidgetXListView = null;
  }
  
  public void a()
  {
    ((aeaf)this.jdField_a_of_type_ComTencentWidgetXListView.getAdapter()).notifyDataSetChanged();
  }
  
  public void a(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, GameRoomChatPie paramGameRoomChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_JavaLangString = paramSessionInfo.jdField_a_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie = paramGameRoomChatPie;
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager = ((WerewolvesHandler)paramQQAppInterface.a(107)).a(this.jdField_a_of_type_JavaLangString);
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a();
      if ((paramQQAppInterface == null) || (paramQQAppInterface.size() == 0)) {
        break label131;
      }
      this.jdField_a_of_type_JavaUtilArrayList = paramQQAppInterface;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131362969));
      this.jdField_a_of_type_ComTencentWidgetXListView.setOnItemClickListener(new aeae(this));
      paramQQAppInterface = new aeaf(this);
      this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(paramQQAppInterface);
      paramQQAppInterface.notifyDataSetChanged();
      return;
      paramQQAppInterface = null;
      break;
      label131:
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      this.jdField_a_of_type_JavaUtilArrayList.add("快点准备，我等到花儿都谢了!");
      this.jdField_a_of_type_JavaUtilArrayList.add("高配玩家在此，狼人这局雪崩");
      this.jdField_a_of_type_JavaUtilArrayList.add("怎么会推我？给你跪下了，大哥");
      this.jdField_a_of_type_JavaUtilArrayList.add("这个发言优秀！感觉可以躺赢");
      this.jdField_a_of_type_JavaUtilArrayList.add("分析的什么鬼，肯定铁狼!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameQuickWordsPanel
 * JD-Core Version:    0.7.0.1
 */