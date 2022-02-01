package com.tencent.mobileqq.c2cshortcutbar;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.TroopAppShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarContext;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.IAIOShortcutBarLogic;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.OverScrollCallbackHorizontalListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class C2CAppShortcutBarHelper
  extends TroopAppShortcutBarHelper
{
  private long jdField_a_of_type_Long;
  private C2CShortcutBarAdapter.ItemExposeListener jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener = new C2CAppShortcutBarHelper.1(this);
  private C2CShortcutBarAdapter jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter;
  private C2CShortcutBarJumpController jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController;
  C2CShortcutBarObserver jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver = new C2CAppShortcutBarHelper.2(this);
  private OverScrollCallbackHorizontalListView jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  private List<C2CShortcutAppInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean c;
  
  public C2CAppShortcutBarHelper(IAIOShortcutBarLogic paramIAIOShortcutBarLogic)
  {
    super(paramIAIOShortcutBarLogic);
  }
  
  private void a(C2CShortcutAppInfo paramC2CShortcutAppInfo, int paramInt)
  {
    if (paramC2CShortcutAppInfo == null) {
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList.contains(paramC2CShortcutAppInfo)) {
      return;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B329", "0X800B329", C2CShortcutBarManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(String.valueOf(this.jdField_a_of_type_Long)), 0, paramC2CShortcutAppInfo.a, String.valueOf(paramInt), "", "");
    this.jdField_a_of_type_JavaUtilList.add(paramC2CShortcutAppInfo);
  }
  
  private void k()
  {
    if (!C2CShortcutBarSwitcher.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, String.valueOf(this.jdField_a_of_type_Long), d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for switch limit");
      }
      return;
    }
    if (!C2CShortcutBarManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(Long.valueOf(this.jdField_a_of_type_Long)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList return for ts limit");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "tryRequestAppList ");
    }
    C2CShortcutBarManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a().a(this.jdField_a_of_type_Long, d(), false, 0, "");
  }
  
  protected int a()
  {
    return ViewUtils.a(14.0F);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  }
  
  public ViewGroup.LayoutParams a()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, ViewUtils.a(39.0F));
    localLayoutParams.addRule(2, 2131368875);
    return localLayoutParams;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init mChatPie.app is null");
      }
      return;
    }
    try
    {
      this.jdField_a_of_type_Long = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "init Exception", localNumberFormatException);
      }
    }
    List localList = C2CShortcutBarManager.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).a(Long.valueOf(this.jdField_a_of_type_Long));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init friendUin = ");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(",appListSize = ");
      localStringBuilder.append(localList.size());
      QLog.d("C2CShortcutBarAIOHelper", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter = new C2CShortcutBarAdapter(this.jdField_a_of_type_AndroidContentContext, localList, this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter$ItemExposeListener);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView = new OverScrollCallbackHorizontalListView(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setId(2131377004);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOnItemClickListener(new C2CAppShortcutBarHelper.3(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setOverScrollMode(0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setDividerWidth(ViewUtils.a(8.0F));
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setPadding(ViewUtils.a(14.0F), ViewUtils.a(10.0F), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a(1);
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    k();
  }
  
  protected boolean a()
  {
    return (d()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.b(1));
  }
  
  protected int b()
  {
    return ViewUtils.a(14.0F);
  }
  
  protected View b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
  }
  
  protected boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarIAIOShortcutBarLogic.a(1);
  }
  
  protected int c()
  {
    return ViewUtils.a(10.0F);
  }
  
  protected void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieResume");
    }
    super.c();
    g();
  }
  
  public int d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.a() == 5) {
      return 2;
    }
    return 1;
  }
  
  public boolean d()
  {
    boolean bool2 = C2CShortcutBarSwitcher.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, String.valueOf(this.jdField_a_of_type_Long), d());
    boolean bool1 = false;
    if (!bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for switch off");
      }
      return false;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.e("C2CShortcutBarAIOHelper", 2, "isShortcutBarVisibleOrGoingToBeVisible return false for AIOIceBreakViewShowing");
      }
      return false;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarAdapter.getCount();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isShortcutBarVisibleOrGoingToBeVisible dataSize = ");
      localStringBuilder.append(i);
      QLog.d("C2CShortcutBarAIOHelper", 2, localStringBuilder.toString());
    }
    if (i > 0) {
      bool1 = true;
    }
    return bool1;
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy");
    }
    ((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).removeObserver(this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarObserver);
    this.c = false;
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqC2cshortcutbarC2CShortcutBarJumpController;
    if (localObject != null) {
      ((C2CShortcutBarJumpController)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetOverScrollCallbackHorizontalListView;
    if ((localObject != null) && (((OverScrollCallbackHorizontalListView)localObject).getParent() != null) && (QLog.isColorLevel())) {
      QLog.d("C2CShortcutBarAIOHelper", 2, "onChatPieDestroy remove shortcutContainer");
    }
    super.e();
  }
  
  public void f()
  {
    super.f();
    b().setPadding(a(), c(), b(), 0);
  }
  
  public void g()
  {
    if (!C2CShortcutBarSwitcher.a((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime, String.valueOf(this.jdField_a_of_type_Long), d()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for switch off");
      }
      return;
    }
    if ((d() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildInputShortcutbarAIOShortcutBarContext.c()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("C2CShortcutBarAIOHelper", 2, "resumeAppShorcutBar return for one way friend");
      }
      return;
    }
    super.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.c2cshortcutbar.C2CAppShortcutBarHelper
 * JD-Core Version:    0.7.0.1
 */