package com.tencent.mobileqq.troop.logic;

import aixu;
import aixv;
import android.app.Activity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troop.utils.HWTroopUtils;
import com.tencent.mobileqq.troop.widget.RedDotAnimateView;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class HomeworkTroopController
{
  public int a;
  protected ImageView a;
  public SessionInfo a;
  public PanelIconLinearLayout a;
  public QQAppInterface a;
  protected RedDotAnimateView a;
  public CalloutPopupWindow a;
  public WeakReference a;
  
  public HomeworkTroopController(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, ImageView paramImageView, RelativeLayout paramRelativeLayout, PanelIconLinearLayout paramPanelIconLinearLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView = new RedDotAnimateView(paramBaseActivity.getActivity());
    paramQQAppInterface = new RelativeLayout.LayoutParams(AIOUtils.a(9.0F, paramBaseActivity.getActivity().getResources()), AIOUtils.a(9.0F, paramBaseActivity.getActivity().getResources()));
    paramQQAppInterface.addRule(7, 2131363977);
    paramQQAppInterface.addRule(6, 2131363977);
    paramQQAppInterface.rightMargin = AIOUtils.a(4.0F, paramBaseActivity.getActivity().getResources());
    paramQQAppInterface.topMargin = AIOUtils.a(11.0F, paramBaseActivity.getActivity().getResources());
    paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView, paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout = paramPanelIconLinearLayout;
  }
  
  private void a(int paramInt, long paramLong)
  {
    ThreadManager.getUIHandler().postDelayed(new aixv(this, paramInt), paramLong);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.isShowing()) && (this.jdField_a_of_type_Int > 0)) {
      a(this.jdField_a_of_type_Int, 0L);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListIcon start. isHomeworkTroop=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aixu(this));
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841325);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      TroopReportor.a("Grp_edu", "homework", "AioSee_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), "", TroopReportor.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a) });
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void b()
  {
    b(false);
    c();
  }
  
  public void b(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, "showHomeworkListRedDot,show = " + paramBoolean + ",context = " + localBaseActivity + ",mRightRedDot = " + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView);
    }
    if (localBaseActivity == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView == null) {
      return;
    }
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.getVisibility() != 0) {
        TroopReportor.a("Grp_edu", "homework", "AioSee_Reddot_Show", 0, 0, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a });
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibleAndZeroRadius();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.b();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetRedDotAnimateView.setVisibility(8);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow != null)
    {
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow.dismiss();
      this.jdField_a_of_type_ComTencentWidgetCalloutpopupwindowCalloutPopupWindow = null;
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint start. show=", Boolean.valueOf(paramBoolean) });
    }
    if (paramBoolean)
    {
      int i = HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkListRedPoint check cache. troopUin=", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, ", result=", Integer.valueOf(i) });
      }
      if (i != 0)
      {
        b(true);
        return;
      }
    }
    b(false);
  }
  
  public void d(boolean paramBoolean)
  {
    boolean bool = TroopInfo.isAdmin(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    if (QLog.isColorLevel()) {
      QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip start. isHomeworkTroop=", Boolean.valueOf(paramBoolean), ", canShow=", Boolean.valueOf(bool) });
    }
    if (!bool) {}
    do
    {
      return;
      if (!paramBoolean) {
        break;
      }
      paramBoolean = HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasHomeworkShown=", Boolean.valueOf(paramBoolean) });
      }
      if (!paramBoolean)
      {
        a(1, 500L);
        HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_homework", true);
        return;
      }
      paramBoolean = HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification");
      if (QLog.isColorLevel()) {
        QLog.d("HomeworkTroopController", 2, new Object[] { "handleHomeworkTroopAIOPanelTip hasNotificationShown=", Boolean.valueOf(paramBoolean) });
      }
    } while (paramBoolean);
    a(2, 500L);
    HWTroopUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "homework_troop_aio_panel_tip_notification", true);
    return;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.HomeworkTroopController
 * JD-Core Version:    0.7.0.1
 */