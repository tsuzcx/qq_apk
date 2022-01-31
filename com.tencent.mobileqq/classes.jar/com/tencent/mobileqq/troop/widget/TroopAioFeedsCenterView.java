package com.tencent.mobileqq.troop.widget;

import ajya;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import asks;
import axqy;
import azpc;
import baec;
import bapj;
import bbfj;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import muc;

public class TroopAioFeedsCenterView
  extends RelativeLayout
  implements Observer
{
  protected Context a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected azpc a;
  protected bapj a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected boolean a;
  
  public TroopAioFeedsCenterView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131560794, this);
  }
  
  public TroopAioFeedsCenterView(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, baec parambaec)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    asks localasks = (asks)paramQQAppInterface.getManager(37);
    try
    {
      this.jdField_a_of_type_Azpc = localasks.a(Long.valueOf(Long.parseLong(paramSessionInfo.a)), true);
      this.jdField_a_of_type_Azpc.addObserver(this);
      this.jdField_a_of_type_Bapj = new bapj(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Azpc, parambaec);
      a(paramQQAppInterface, paramContext);
      return;
    }
    catch (Exception paramSessionInfo)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TroopAioFeedsCenterView", 2, paramSessionInfo.toString());
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    inflate(paramContext, 2131560293, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366181));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131377328));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131377315));
    if (bbfj.d(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715168));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715179));
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Azpc == null) || (this.jdField_a_of_type_Azpc.a.size() <= paramInt)) {
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      localObject = (TroopFeedItem)this.jdField_a_of_type_Azpc.a.get(paramInt);
      localView = this.jdField_a_of_type_Bapj.a((TroopFeedItem)localObject, paramInt, true);
      localObject = localView;
    } while (localView == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(localView, 0);
    paramInt = (int)muc.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    paramViewGroup.setPadding(paramInt, 0, paramInt, 0);
    return localView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azpc == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioFeedsCenterView.troop.notification_center.auto_pull_down", 2, "doAutoPullDownLogic");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715175));
    this.jdField_a_of_type_Azpc.a(1002);
  }
  
  void a(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_Azpc == null) || (paramInt >= this.jdField_a_of_type_Azpc.a.size())) {}
    label468:
    for (;;)
    {
      return;
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)this.jdField_a_of_type_Azpc.a.get(paramInt);
      if (localTroopFeedItem != null)
      {
        int i = localTroopFeedItem.type;
        String str;
        if (paramInt == 0)
        {
          str = "0";
          switch (i)
          {
          }
        }
        for (;;)
        {
          if (!localTroopFeedItem.isStoryType()) {
            break label468;
          }
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          return;
          str = "1";
          break;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          axqy.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, localTroopFeedItem.ex_1, "");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Azpc == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715177));
    }
    this.jdField_a_of_type_Bapj.a();
    this.jdField_a_of_type_Azpc.a(1000);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715181));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Azpc != null) {
      this.jdField_a_of_type_Azpc.deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    int i;
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 105)) {
        break label142;
      }
      if (this.jdField_a_of_type_Azpc != null) {
        break label91;
      }
      i = 0;
      if (i != 0) {
        break label107;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715169));
      label72:
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestFocus();
      }
    }
    label91:
    label107:
    do
    {
      return;
      i = this.jdField_a_of_type_Azpc.a.size();
      break;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
      a(0);
      break label72;
      if (paramObservable.intValue() == 103)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        if (bbfj.d(this.jdField_a_of_type_AndroidContentContext))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715178));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ajya.a(2131715167));
        return;
      }
    } while (paramObservable.intValue() != 1010);
    label142:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView
 * JD-Core Version:    0.7.0.1
 */