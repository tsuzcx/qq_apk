package com.tencent.mobileqq.database.corrupt;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class DBFixDialogUI
  implements DBFixLoadingDialog.onDBFixCall
{
  public static Dialog a;
  public static String b = "0X8007960";
  public static String c = "0X8007961";
  public static String d = "0X8007962";
  public static String e = "0X8007963";
  public static String f = "0X8007964";
  private static String g = "DBFix";
  private int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new DBFixDialogUI.1(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBFixManager jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager;
  String jdField_a_of_type_JavaLangString;
  private String h = "";
  
  static
  {
    jdField_a_of_type_AndroidAppDialog = null;
  }
  
  public DBFixDialogUI(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager = ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DB_FIX_MANAGER));
  }
  
  private void a(Dialog paramDialog, String paramString)
  {
    QLog.d(g, 1, "DBFixDialogUI showDialog, " + paramString);
    this.h = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new DBFixDialogUI.2(this, paramDialog));
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.a(true);
    jdField_a_of_type_AndroidAppDialog = new DBFixLoadingDialog(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidContentContext, this);
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fixing");
  }
  
  private void d()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131702904)).setPositiveButton(HardCodeUtil.a(2131702910), new DBFixDialogUI.5(this));
    jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new DBFixDialogUI.6(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix succ");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, e, e, 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131702905)).setPositiveButton("重启QQ", new DBFixDialogUI.7(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix fail");
  }
  
  private void f()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131702907)).setPositiveButton(HardCodeUtil.a(2131702903), new DBFixDialogUI.10(this)).setNegativeButton(HardCodeUtil.a(2131702909), new DBFixDialogUI.9(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "memory alert");
  }
  
  public void a()
  {
    jdField_a_of_type_AndroidAppDialog = null;
    if ((this.jdField_a_of_type_AndroidContentContext instanceof DBFixDialogActivity)) {
      ((DBFixDialogActivity)this.jdField_a_of_type_AndroidContentContext).finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.a(false);
    if (this.jdField_a_of_type_Int != DBFixLoadingDialog.d)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
      String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (((SharedPreferences)localObject).getInt(str + DBFixManager.e, 0) == DBFixManager.jdField_a_of_type_Int)
      {
        QLog.d(g, 1, "DBFixDialogUI 2, max count, delete db");
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.b(false);
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.c();
        localObject = ((SharedPreferences)localObject).edit();
        ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.d);
        ((SharedPreferences.Editor)localObject).remove(str + DBFixManager.e);
        ((SharedPreferences.Editor)localObject).commit();
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new DBFixDialogUI.8(this, paramInt));
  }
  
  public void b()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131702906)).setPositiveButton(HardCodeUtil.a(2131702908), new DBFixDialogUI.4(this)).setNegativeButton("取消", new DBFixDialogUI.3(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "checked corrupt");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, b, b, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI
 * JD-Core Version:    0.7.0.1
 */