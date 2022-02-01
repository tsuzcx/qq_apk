package com.tencent.mobileqq.onlinestatus.view;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.onlinestatus.OnLineStatusBlurBg;
import com.tencent.mobileqq.onlinestatus.OnlineStatusItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPanelParams;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionChecker.OnlineStatusPermissionItem;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionManager;
import com.tencent.mobileqq.onlinestatus.OnlineStatusUtil;
import com.tencent.mobileqq.onlinestatus.OnlineStatusViewCtrl;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class AutoStatusAccountView
  extends AutoStatusSelectView
{
  private ArrayList<OnlineStatusItem> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean = true;
  private OnlineStatusPermissionChecker.OnlineStatusPermissionItem b;
  
  public AutoStatusAccountView(@NonNull BaseActivity paramBaseActivity, OnLineStatusBlurBg paramOnLineStatusBlurBg, BaseStatusCardView.OnDismissCallback paramOnDismissCallback)
  {
    super(paramBaseActivity, paramOnLineStatusBlurBg, paramOnDismissCallback);
    this.jdField_a_of_type_Int = 2;
    this.jdField_b_of_type_Int = 40000;
  }
  
  private void a(ArrayList<OnlineStatusItem> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList(0);
    localArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList = localArrayList;
  }
  
  private boolean c()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null) {}
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null);
      if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission() != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.isAllHasPermission()) {
        return true;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size() != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size())
      {
        if (QLog.isColorLevel()) {
          QLog.d("AutoStatusAccountView", 2, new Object[] { " hasPermissionChange entity.size=", Integer.valueOf(this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size()), " item.size=", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().size()) });
        }
        return true;
      }
    } while (this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins().containsAll(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem.getPermissionUins()));
    return true;
  }
  
  private boolean d()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() != this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a().size()) {
      return true;
    }
    Iterator localIterator1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a().iterator();
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        OnlineStatusItem localOnlineStatusItem1 = (OnlineStatusItem)localIterator1.next();
        Iterator localIterator2 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        OnlineStatusItem localOnlineStatusItem2;
        do
        {
          if (!localIterator2.hasNext()) {
            break;
          }
          localOnlineStatusItem2 = (OnlineStatusItem)localIterator2.next();
        } while (localOnlineStatusItem1.a != localOnlineStatusItem2.a);
      }
      for (int i = 1; i == 0; i = 0)
      {
        return true;
        return false;
      }
    }
  }
  
  public ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
      return localArrayList;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(Integer.valueOf((int)((OnlineStatusItem)((Iterator)localObject).next()).a));
    }
    return localArrayList;
  }
  
  protected void a() {}
  
  public void a(OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (paramOnlineStatusPermissionItem != null) {}
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = paramOnlineStatusPermissionItem;
      super.a(this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem);
      return;
      paramOnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, OnlineStatusPermissionChecker.OnlineStatusPermissionItem paramOnlineStatusPermissionItem)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.requestPermissions(new AutoStatusAccountView.1(this, paramBoolean, paramOnlineStatusPermissionItem), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    }
    for (;;)
    {
      ReportHelperKt.a("0X800AF9A");
      ReportHelperKt.a("0X800AF3E", 2);
      return;
      a(paramBoolean);
      a(paramOnlineStatusPermissionItem);
      show();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoStatusAccountView", 2, new Object[] { "hasChange =", Boolean.valueOf(paramBoolean1), " isSmartListEmpty=", Boolean.valueOf(paramBoolean2) });
    }
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131694615);
    if (paramBoolean2)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
  }
  
  protected boolean a(boolean paramBoolean)
  {
    OnlineStatusPermissionManager localOnlineStatusPermissionManager = (OnlineStatusPermissionManager)((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null)).getManager(QQManagerFactory.ONLINE_STATUS_PERMISSION_MANAGER);
    if ((this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem == null) && (localOnlineStatusPermissionManager.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem, this))) {
      return true;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem != null) && (c())) {
      return true;
    }
    if (paramBoolean) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return localOnlineStatusPermissionManager.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a());
    }
    return d();
  }
  
  public void aA_()
  {
    a(false, null);
  }
  
  protected void b()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131691416);
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl == null)
    {
      OnlineStatusPanelParams localOnlineStatusPanelParams = new OnlineStatusPanelParams();
      localOnlineStatusPanelParams.jdField_a_of_type_Int = 3;
      localOnlineStatusPanelParams.c = true;
      localOnlineStatusPanelParams.b = false;
      localOnlineStatusPanelParams.jdField_a_of_type_Boolean = true;
      localOnlineStatusPanelParams.f = 5;
      localOnlineStatusPanelParams.h = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().widthPixels - AIOUtils.a(26.0F, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources()));
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl = new OnlineStatusViewCtrl(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_AndroidViewViewGroup, this, localOnlineStatusPanelParams, this);
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  protected void b(View paramView)
  {
    c();
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewBaseStatusCardView$OnDismissCallback.a(40001L);
    dismiss();
    OnlineStatusUtil.a(this, paramView);
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (boolean bool1 = b();; bool1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a().isEmpty())
    {
      boolean bool2 = a();
      boolean bool3 = a(paramBoolean);
      if (QLog.isColorLevel()) {
        QLog.d("AutoStatusAccountView", 2, new Object[] { "isSmartListEmpty =", Boolean.valueOf(bool1), " hasPartVisible=", Boolean.valueOf(bool2), " hasDataChange=", Boolean.valueOf(bool3), " fromShow=", Boolean.valueOf(paramBoolean) });
      }
      a(bool3, bool1);
      b(bool2, bool1);
      return;
    }
  }
  
  public ArrayList<OnlineStatusItem> c()
  {
    ArrayList localArrayList = super.c();
    a(localArrayList);
    return localArrayList;
  }
  
  public void c()
  {
    this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
    a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusViewCtrl.a());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131377364)
    {
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem = this.jdField_b_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionChecker$OnlineStatusPermissionItem;
      dismiss();
      ReportHelperKt.a("0X800AF94");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131364141) {
        b(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.AutoStatusAccountView
 * JD-Core Version:    0.7.0.1
 */