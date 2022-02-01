package com.tencent.mobileqq.leba;

import android.content.Intent;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.leba.controller.LebaController;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.entity.LebaClickReportInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.proxy.ILebaProxy;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class Leba$RealLebaProxy
  implements ILebaProxy
{
  Leba a;
  
  public int a()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController != null) {
      return this.a.jdField_a_of_type_ComTencentMobileqqLebaControllerLebaController.a();
    }
    return 0;
  }
  
  public QBaseActivity a()
  {
    return this.a.a();
  }
  
  public HashMap<String, LebaViewItem> a()
  {
    return LebaShowListManager.a().jdField_a_of_type_JavaUtilHashMap;
  }
  
  public List<LebaViewItem> a()
  {
    return this.a.jdField_a_of_type_JavaUtilList;
  }
  
  public AppRuntime a()
  {
    return this.a.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  public void a()
  {
    this.a.b(new Leba.RealLebaProxy.1(this));
  }
  
  public void a(Intent paramIntent)
  {
    this.a.a(paramIntent);
  }
  
  public void a(LebaClickReportInfo paramLebaClickReportInfo)
  {
    this.a.a(paramLebaClickReportInfo);
  }
  
  public void a(Runnable paramRunnable)
  {
    this.a.b(paramRunnable);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.a.a(paramBoolean1, paramBoolean2, paramInt);
  }
  
  public boolean a()
  {
    return LebaUtil.c(a());
  }
  
  public void b()
  {
    this.a.b(new Leba.RealLebaProxy.2(this));
  }
  
  public void c()
  {
    LebaShowListManager.jdField_a_of_type_Int |= 0x1;
  }
  
  public void d()
  {
    LebaShowListManager.jdField_a_of_type_Int |= 0x2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.RealLebaProxy
 * JD-Core Version:    0.7.0.1
 */