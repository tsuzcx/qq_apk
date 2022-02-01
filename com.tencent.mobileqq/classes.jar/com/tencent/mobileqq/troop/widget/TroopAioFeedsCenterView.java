package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopAioFeedsCenterView
  extends RelativeLayout
  implements Observer
{
  protected Context a;
  protected LinearLayout a;
  protected RelativeLayout a;
  protected TextView a;
  protected SessionInfo a;
  protected QQAppInterface a;
  protected TroopFeedsDataManager a;
  protected TroopFeedViewFactory a;
  protected boolean a;
  
  public TroopAioFeedsCenterView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    inflate(paramContext, 2131561120, this);
  }
  
  public TroopAioFeedsCenterView(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, boolean paramBoolean, TroopFeedsCenterLogic paramTroopFeedsCenterLogic)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_Boolean = paramBoolean;
    TroopInfoManager localTroopInfoManager = (TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = localTroopInfoManager.a(Long.valueOf(Long.parseLong(paramSessionInfo.a)), true);
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
    }
    catch (Exception paramSessionInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopAioFeedsCenterView", 2, paramSessionInfo.toString());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory = new TroopFeedViewFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager, paramTroopFeedsCenterLogic);
    a(paramQQAppInterface, paramContext);
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    inflate(paramContext, 2131560610, this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366750));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131378756));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378745));
    if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714939));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714950));
  }
  
  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if ((localObject != null) && (((TroopFeedsDataManager)localObject).a.size() > paramInt))
    {
      localObject = (TroopFeedItem)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(paramInt);
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a((TroopFeedItem)localObject, paramInt, true);
      if (localObject != null)
      {
        paramViewGroup.removeAllViews();
        paramViewGroup.addView((View)localObject, 0);
        paramInt = (int)UITools.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
        paramViewGroup.setPadding(paramInt, 0, paramInt, 0);
      }
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAioFeedsCenterView.troop.notification_center.auto_pull_down", 2, "doAutoPullDownLogic");
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714946));
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a(1002);
  }
  
  void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
      if (localObject != null)
      {
        if (paramInt >= ((TroopFeedsDataManager)localObject).a.size()) {
          return;
        }
        TroopFeedItem localTroopFeedItem = (TroopFeedItem)this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a.get(paramInt);
        if (localTroopFeedItem != null)
        {
          int i = localTroopFeedItem.type;
          if (paramInt == 0) {
            localObject = "0";
          } else {
            localObject = "1";
          }
          if (i != 0) {
            if (i != 5)
            {
              if (i != 10)
              {
                if (i != 12)
                {
                  if (i != 99)
                  {
                    if (i != 18)
                    {
                      if (i != 19)
                      {
                        if (i != 131)
                        {
                          if (i != 132) {
                            break label397;
                          }
                          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_music", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
                          break label397;
                        }
                      }
                      else
                      {
                        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_know", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
                        break label397;
                      }
                    }
                    else
                    {
                      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_photo", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
                      break label397;
                    }
                  }
                  else
                  {
                    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_other", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, localTroopFeedItem.ex_1, "");
                    break label397;
                  }
                }
                else
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_vote", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
                  break label397;
                }
              }
              else
              {
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_video", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
                break label397;
              }
            }
            else
            {
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_bulletin", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
              break label397;
            }
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_file", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, (String)localObject, "", "");
          label397:
          if (localTroopFeedItem.isStoryType()) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "notice_center", "exp_story_pgc", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "", "", "");
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager == null) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714948));
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopFeedViewFactory.a();
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a(1000);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714952));
  }
  
  public void c()
  {
    TroopFeedsDataManager localTroopFeedsDataManager = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if (localTroopFeedsDataManager != null) {
      localTroopFeedsDataManager.deleteObserver(this);
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 105))
      {
        if (paramObservable.intValue() == 103)
        {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
          this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
          if (NetworkUtil.isNetSupport(this.jdField_a_of_type_AndroidContentContext))
          {
            this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714949));
            return;
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714938));
          return;
        }
        paramObservable.intValue();
        return;
      }
      paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
      int i;
      if (paramObservable == null) {
        i = 0;
      } else {
        i = paramObservable.a.size();
      }
      if (i == 0)
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131714940));
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        a(this.jdField_a_of_type_AndroidWidgetRelativeLayout, 0);
        a(0);
      }
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.requestFocus();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView
 * JD-Core Version:    0.7.0.1
 */