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
    ILebaController localILebaController = this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController;
    if (localILebaController != null) {
      return localILebaController.a();
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initLebaView");
    localStringBuilder.append(LebaViewItem.a(this.jdField_a_of_type_JavaUtilList));
    QLog.i("Q.lebatab.LebaController", 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController == null)
    {
      boolean bool = a();
      this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController = a(bool);
      QLog.i("Q.lebatab.LebaController", 1, String.format("init puginLogin modle = %b", new Object[] { Boolean.valueOf(bool) }));
    }
    else
    {
      a(false);
    }
    this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController.a(paramInitViewParam);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    ILebaController localILebaController = this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController;
    if (localILebaController != null) {
      localILebaController.a(paramAbsListView, paramInt);
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onPause");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("|");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(paramInt2);
    QLog.i("Q.lebatab.LebaController", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController;
    if (localObject != null) {
      ((ILebaController)localObject).a(paramAppRuntime, paramInt1, paramBoolean, paramInt2);
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
    AppRuntime localAppRuntime = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localAppRuntime == null) {
      return false;
    }
    return LebaUtil.c(localAppRuntime);
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("notifyDataSetChanged");
    ((StringBuilder)localObject).append(LebaViewItem.a(this.jdField_a_of_type_JavaUtilList));
    QLog.i("Q.lebatab.LebaController", 1, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController;
    if (localObject != null) {
      ((ILebaController)localObject).c();
    }
  }
  
  public void c()
  {
    QLog.i("Q.lebatab.LebaController", 1, "onPostThemeChanged");
    ILebaController localILebaController = this.jdField_a_of_type_ComTencentMobileqqLebaControllerILebaController;
    if (localILebaController != null) {
      localILebaController.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.controller.LebaController
 * JD-Core Version:    0.7.0.1
 */