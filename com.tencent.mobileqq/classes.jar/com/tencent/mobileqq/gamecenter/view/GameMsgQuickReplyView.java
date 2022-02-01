package com.tencent.mobileqq.gamecenter.view;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.gamecenter.adapter.GameMsgQuickReplayAdapter;
import com.tencent.mobileqq.gamecenter.data.GameMsgQuickReplyInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class GameMsgQuickReplyView
{
  private GameMsgChatPie jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie;
  private GameMsgQuickReplayAdapter jdField_a_of_type_ComTencentMobileqqGamecenterAdapterGameMsgQuickReplayAdapter;
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  
  public GameMsgQuickReplyView(GameMsgChatPie paramGameMsgChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie = paramGameMsgChatPie;
  }
  
  public void a()
  {
    OverScrollCallbackHorizontalListView localOverScrollCallbackHorizontalListView = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
    if ((localOverScrollCallbackHorizontalListView != null) && (localOverScrollCallbackHorizontalListView.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GameMsgQuickReplyView", 2, "[onDestroy], remove shortcutContainer");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView);
    }
  }
  
  public void a(ArrayList<GameMsgQuickReplyInfo> paramArrayList)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie;
    if ((localObject != null) && (((GameMsgChatPie)localObject).a != null))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a() == null) {
        return;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a().findViewById(2131377004);
      if (localObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameMsgQuickReplyView", 2, "init remove shortcutContainer");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a().removeView((View)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqGamecenterAdapterGameMsgQuickReplayAdapter = new GameMsgQuickReplayAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a, paramArrayList);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131377004);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqGamecenterAdapterGameMsgQuickReplayAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new GameMsgQuickReplyView.1(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(ViewUtils.a(8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(ViewUtils.a(14.0F), ViewUtils.a(10.0F), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() == null)
      {
        paramArrayList = new RelativeLayout.LayoutParams(-1, ViewUtils.a(39.0F));
        paramArrayList.addRule(2, 2131368875);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameMsgChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView, paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.GameMsgQuickReplyView
 * JD-Core Version:    0.7.0.1
 */