package com.tencent.mobileqq.tablequery;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class TableQueryController
{
  private static TableQueryController jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryController;
  public static boolean a = false;
  public static boolean b = true;
  public static boolean c = false;
  private static boolean e = false;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new TableQueryController.2(this);
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private TableQueryManager jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryManager = new TableQueryManager();
  private TableQueryViewer jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  private boolean d = false;
  
  public static TableQueryController a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryController == null) {
        try
        {
          jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryController = new TableQueryController();
        }
        finally {}
      }
      return jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryController;
    }
    finally {}
  }
  
  public int a(QueryData paramQueryData)
  {
    TableQueryViewer localTableQueryViewer = this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer;
    if (localTableQueryViewer == null) {
      return 0;
    }
    return localTableQueryViewer.a(paramQueryData);
  }
  
  public void a()
  {
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a();
    }
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      e = true;
      if (!c) {
        a().a();
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = new TableQueryController.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(paramMotionEvent, 400L);
    }
  }
  
  public void a(QueryData paramQueryData)
  {
    if (jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer.a(paramQueryData);
    }
  }
  
  public void b()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer == null)
    {
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer = new TableQueryViewer(localBaseApplication);
    }
    if (!this.d) {}
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer);
      label56:
      int i;
      if (Build.VERSION.SDK_INT >= 26) {
        i = 2038;
      } else {
        i = 2003;
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, i, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = DisplayUtil.a(localBaseApplication, 72.0F);
      try
      {
        this.jdField_a_of_type_AndroidViewWindowManager.addView(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer, localLayoutParams);
      }
      catch (Exception localException2)
      {
        label130:
        break label130;
      }
      QQToast.a(localBaseApplication, 1, localBaseApplication.getString(2131690647), 0).a();
      this.d = true;
      return;
    }
    catch (Exception localException1)
    {
      break label56;
    }
  }
  
  public void c()
  {
    if (this.d) {
      this.jdField_a_of_type_AndroidViewWindowManager.removeViewImmediate(this.jdField_a_of_type_ComTencentMobileqqTablequeryTableQueryViewer);
    }
    this.d = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryController
 * JD-Core Version:    0.7.0.1
 */