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
  
  public DBFixDialogUI(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager = ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DB_FIX_MANAGER));
  }
  
  private void a(Dialog paramDialog, String paramString)
  {
    String str = g;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DBFixDialogUI showDialog, ");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
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
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131703034)).setPositiveButton(HardCodeUtil.a(2131703040), new DBFixDialogUI.5(this));
    jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new DBFixDialogUI.6(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix succ");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = e;
    ReportController.b(localQQAppInterface, "CliOper", "", str1, str2, str2, 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131703035)).setPositiveButton("重启QQ", new DBFixDialogUI.7(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix fail");
  }
  
  private void f()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131703042)).setPositiveButton(HardCodeUtil.a(2131703041), new DBFixDialogUI.9(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "unable to fix");
  }
  
  private void g()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131703037)).setPositiveButton(HardCodeUtil.a(2131703033), new DBFixDialogUI.11(this)).setNegativeButton(HardCodeUtil.a(2131703039), new DBFixDialogUI.10(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "memory alert");
  }
  
  public void a()
  {
    jdField_a_of_type_AndroidAppDialog = null;
    Object localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject1 instanceof DBFixDialogActivity)) {
      ((DBFixDialogActivity)localObject1).finish();
    }
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.a(false);
    if (this.jdField_a_of_type_Int != DBFixLoadingDialog.d)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.b, 0);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(DBFixManager.e);
      if (((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0) == DBFixManager.jdField_a_of_type_Int)
      {
        QLog.d(g, 1, "DBFixDialogUI 2, max count, delete db");
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.b(false);
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.c();
        localObject2 = ((SharedPreferences)localObject2).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(DBFixManager.d);
        ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(DBFixManager.e);
        ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
        ((SharedPreferences.Editor)localObject2).commit();
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
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage(HardCodeUtil.a(2131703036)).setPositiveButton(HardCodeUtil.a(2131703038), new DBFixDialogUI.4(this)).setNegativeButton("取消", new DBFixDialogUI.3(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "checked corrupt");
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str1 = this.jdField_a_of_type_JavaLangString;
    String str2 = b;
    ReportController.b(localQQAppInterface, "CliOper", "", str1, str2, str2, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI
 * JD-Core Version:    0.7.0.1
 */