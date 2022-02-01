package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anzj;
import axfw;
import bdll;
import bfrm;
import bghm;
import bgwy;
import bhnv;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mvd;

public class TroopAioFeedsCenterView
  extends RelativeLayout
  implements Observer
{
  protected Context a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected bfrm a;
  protected bgwy a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected boolean a;
  
  public TroopAioFeedsCenterView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131561242, this);
  }
  
  public TroopAioFeedsCenterView(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, bghm parambghm)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    axfw localaxfw = (axfw)paramQQAppInterface.getManager(37);
    try
    {
      this.jdField_a_of_type_Bfrm = localaxfw.a(Long.valueOf(Long.parseLong(paramSessionInfo.a)), true);
      this.jdField_a_of_type_Bfrm.addObserver(this);
      this.jdField_a_of_type_Bgwy = new bgwy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Bfrm, parambghm);
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
    inflate(paramContext, 2131560570, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366574));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378909));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378898));
    if (bhnv.d(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713942));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713953));
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bfrm == null) || (this.jdField_a_of_type_Bfrm.a.size() <= paramInt)) {
      localObject = null;
    }
    View localView;
    do
    {
      return localObject;
      localObject = (TroopFeedItem)this.jdField_a_of_type_Bfrm.a.get(paramInt);
      localView = this.jdField_a_of_type_Bgwy.a((TroopFeedItem)localObject, paramInt, true);
      localObject = localView;
    } while (localView == null);
    paramViewGroup.removeAllViews();
    paramViewGroup.addView(localView, 0);
    paramInt = (int)mvd.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
    paramViewGroup.setPadding(paramInt, 0, paramInt, 0);
    return localView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfrm == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioFeedsCenterView.troop.notification_center.auto_pull_down", 2, "doAutoPullDownLogic");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713949));
    this.jdField_a_of_type_Bfrm.a(1002);
  }
  
  void a(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_Bfrm == null) || (paramInt >= this.jdField_a_of_type_Bfrm.a.size())) {}
    label468:
    for (;;)
    {
      return;
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)this.jdField_a_of_type_Bfrm.a.get(paramInt);
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
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          return;
          str = "1";
          break;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, "", "");
          continue;
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, str, localTroopFeedItem.ex_1, "");
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfrm == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713951));
    }
    this.jdField_a_of_type_Bgwy.a();
    this.jdField_a_of_type_Bfrm.a(1000);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713955));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfrm != null) {
      this.jdField_a_of_type_Bfrm.deleteObserver(this);
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
      if (this.jdField_a_of_type_Bfrm != null) {
        break label91;
      }
      i = 0;
      if (i != 0) {
        break label107;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713943));
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
      i = this.jdField_a_of_type_Bfrm.a.size();
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
        if (bhnv.d(this.jdField_a_of_type_AndroidContentContext))
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713952));
          return;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(anzj.a(2131713941));
        return;
      }
    } while (paramObservable.intValue() != 1010);
    label142:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView
 * JD-Core Version:    0.7.0.1
 */