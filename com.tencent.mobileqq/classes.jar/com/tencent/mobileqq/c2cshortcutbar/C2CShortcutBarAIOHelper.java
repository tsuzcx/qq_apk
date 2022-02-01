package com.tencent.mobileqq.c2cshortcutbar;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ShortcutBarAIOHelper;
import com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class C2CShortcutBarAIOHelper
  extends ShortcutBarAIOHelper
{
  private long jdField_a_of_type_Long;
  private C2CShortcutBarAdapter.ItemExposeListener jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener = new C2CShortcutBarAIOHelper.1(this);
  private C2CShortcutBarAdapter jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter;
  private C2CShortcutBarJumpController jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController;
  C2CShortcutBarObserver jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver = new C2CShortcutBarAIOHelper.2(this);
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private List<C2CShortcutAppInfo> b;
  private boolean c;
  
  public C2CShortcutBarAIOHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
  }
  
  private void a(C2CShortcutAppInfo paramC2CShortcutAppInfo, int paramInt)
  {
    if (paramC2CShortcutAppInfo == null) {}
    while (this.jdField_b_of_type_JavaUtilList.contains(paramC2CShortcutAppInfo)) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B329", "0X800B329", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(String.valueOf(this.jdField_a_of_type_Long)), 0, paramC2CShortcutAppInfo.a, String.valueOf(paramInt), "", "");
    this.jdField_b_of_type_JavaUtilList.add(paramC2CShortcutAppInfo);
  }
  
  private void j()
  {
    if (!C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
      }
    }
    do
    {
      return;
      if (C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf(this.jdField_a_of_type_Long))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
    return;
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
    }
    C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a().a(this.jdField_a_of_type_Long, d(), false, 0, "");
  }
  
  public int a()
  {
    return ViewUtils.a(14.0F);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie is null");
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.app is null");
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.c != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.mAIORootView is null");
    return;
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      Object localObject = C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(Long.valueOf(this.jdField_a_of_type_Long));
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "init friendUin = " + this.jdField_a_of_type_Long + ",appListSize = " + ((List)localObject).size() + ",mChatPie = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie);
      }
      View localView = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().findViewById(2131377560);
      if (localView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("C2CShortcutBarAIOHelper", 2, "init remove shortcutContainer");
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeView(localView);
      }
      this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter = new C2CShortcutBarAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext, (List)localObject, this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131377560);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new C2CShortcutBarAIOHelper.3(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(ViewUtils.a(8.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(ViewUtils.a(14.0F), ViewUtils.a(10.0F), 0, 0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() == null)
      {
        localObject = new RelativeLayout.LayoutParams(-1, ViewUtils.a(39.0F));
        ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131369142);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().addView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView, (ViewGroup.LayoutParams)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
      j();
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("C2CShortcutBarAIOHelper", 2, "init Exception", localNumberFormatException);
        }
      }
    }
  }
  
  public int b()
  {
    return ViewUtils.a(14.0F);
  }
  
  public boolean b()
  {
    if (!C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for switch off");
      }
    }
    int i;
    do
    {
      do
      {
        do
        {
          return false;
          if (!this.jdField_a_of_type_Boolean) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for mIsInputJump");
        return false;
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      return false;
      i = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter.getCount();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible dataSize = " + i);
      }
    } while (i <= 0);
    return true;
  }
  
  public int c()
  {
    return ViewUtils.a(10.0F);
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieResume");
    }
    super.c();
    h();
  }
  
  public int d()
  {
    int i = 1;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie instanceof LimitChatPie)) {
      i = 2;
    }
    return i;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    this.c = false;
    this.jdField_b_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController != null) {
      this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController.a();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a().removeView(this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView);
    }
    super.e();
  }
  
  public void f()
  {
    if (!C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible return for switch off");
      }
    }
    do
    {
      do
      {
        return;
        if ((d() != 1) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.B())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible return for one way friend");
      return;
      super.f();
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "setAppShortcutBarVisible hasReportBarExposure = " + this.c);
      }
    } while (this.c);
    this.c = true;
    ReportController.b(null, "dc00898", "", "", "0X800B334", "0X800B334", C2CShortcutBarManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(String.valueOf(this.jdField_a_of_type_Long)), 0, "", "", "", "");
  }
  
  public void g()
  {
    super.g();
    a().setPadding(a(), c(), b(), 0);
  }
  
  public void h()
  {
    if (!C2CShortcutBarSwitcher.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(this.jdField_a_of_type_Long), d())) {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for switch off");
      }
    }
    do
    {
      return;
      if ((d() != 1) || (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.B())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for one way friend");
    return;
    super.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarAIOHelper
 * JD-Core Version:    0.7.0.1
 */