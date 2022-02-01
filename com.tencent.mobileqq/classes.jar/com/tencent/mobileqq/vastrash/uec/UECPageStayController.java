package com.tencent.mobileqq.vastrash.uec;

import NS_USER_ACTION_REPORT.QQStayTimeInfo;
import android.view.WindowManager;
import java.util.ArrayList;

public class UECPageStayController
{
  public static boolean a = false;
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private UECPageStayViewer jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer;
  private boolean b = false;
  
  public static UECPageStayController a()
  {
    return UECPageStayController.SingletonInstance.a();
  }
  
  public void a()
  {
    if (this.b) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer);
    }
    this.b = false;
  }
  
  public void a(ArrayList<QQStayTimeInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    if (jdField_a_of_type_Boolean)
    {
      UECPageStayViewer localUECPageStayViewer = this.jdField_a_of_type_ComTencentMobileqqVastrashUecUECPageStayViewer;
      if (localUECPageStayViewer != null) {
        localUECPageStayViewer.a(paramArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vastrash.uec.UECPageStayController
 * JD-Core Version:    0.7.0.1
 */