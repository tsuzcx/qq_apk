package com.tencent.mobileqq.leba.controller;

import com.tencent.mobileqq.leba.controller.list.LebaListController;
import com.tencent.mobileqq.leba.controller.table.LebaTabletController;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.entity.InitViewParam;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.List;
import mqq.app.AppRuntime;

public class LebaController
{
  private ILebaController jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController;
  private InitViewParam jdField_a_of_type_ComTencentMobileqqLebaEntityInitViewParam;
  private List<LebaViewItem> jdField_a_of_type_JavaUtilList;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null) {
      return this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a();
    }
    return 0;
  }
  
  public ILebaController a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return new LebaTabletController();
    }
    return new LebaListController();
  }
  
  public void a()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onResume");
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null)
    {
      a(true);
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a();
    }
  }
  
  public void a(InitViewParam paramInitViewParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaEntityInitViewParam = paramInitViewParam;
    this.jdField_a_of_type_MqqAppAppRuntime = paramInitViewParam.jdField_a_of_type_MqqAppAppRuntime;
    this.jdField_a_of_type_JavaUtilList = paramInitViewParam.jdField_a_of_type_JavaUtilList;
    QLog.i("Q.lebatab.LebaController", 1, "initLebaView" + LebaViewItem.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController == null)
    {
      boolean bool = a();
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a(paramInitViewParam);
      return;
      a(false);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPause" + paramInt1 + "|" + paramBoolean + paramInt2);
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a(paramAppRuntime, paramInt1, paramBoolean, paramInt2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null)
    {
      boolean bool1 = a();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController instanceof LebaTabletController;
      if (bool1 != bool2)
      {
        QLog.i("Q.lebatab.LebaController", 1, String.format("checkAndSwtichModel old: %b new %b", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.d();
        this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController = a(bool1);
        if (paramBoolean) {
          this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a(this.jdField_a_of_type_ComTencentMobileqqLebaEntityInitViewParam);
        }
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return false;
    }
    return LebaUtil.c(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  public void b()
  {
    QLog.i("Q.lebatab.LebaController", 1, "notifyDataSetChanged" + LebaViewItem.a(this.jdField_a_of_type_JavaUtilList));
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.LebaController
 * JD-Core Version:    0.7.0.1
 */