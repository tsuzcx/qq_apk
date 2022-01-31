package com.tencent.mobileqq.database.corrupt;

import abvv;
import abvw;
import abvx;
import abvy;
import abvz;
import abwa;
import abwb;
import abwc;
import abwd;
import abwe;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public Context a;
  DialogInterface.OnCancelListener jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener = new abvv(this);
  public QQAppInterface a;
  private DBFixManager jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager;
  public String a;
  private String h = "";
  
  public DBFixDialogUI(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager = ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(204));
  }
  
  private void a(Dialog paramDialog, String paramString)
  {
    QLog.d(g, 1, "DBFixDialogUI showDialog, " + paramString);
    this.h = paramString;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new abvx(this, paramDialog));
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
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage("修复成功，请重启QQ。").setPositiveButton("强制关闭", new abwa(this));
    jdField_a_of_type_AndroidAppDialog.setOnKeyListener(new abwb(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix succ");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, e, e, 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage("修复失败，重启QQ重试。").setPositiveButton("重启QQ", new abwc(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "fix fail");
  }
  
  private void f()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage("手机空间不足，无法修复聊天记录，请清理手机中的缓存垃圾，释放空间后再修复聊天记录。").setPositiveButton("空间清理", new abvw(this)).setNegativeButton("取消", new abwe(this));
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
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixManager.b();
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new abwd(this, paramInt));
  }
  
  public void b()
  {
    jdField_a_of_type_AndroidAppDialog = DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230).setMessage("检测到你的聊天记录出现异常，请立即修复，否则聊天记录将丢失").setPositiveButton("确定", new abvz(this)).setNegativeButton("取消", new abvy(this));
    jdField_a_of_type_AndroidAppDialog.setOnCancelListener(this.jdField_a_of_type_AndroidContentDialogInterface$OnCancelListener);
    a(jdField_a_of_type_AndroidAppDialog, "checked corrupt");
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.jdField_a_of_type_JavaLangString, b, b, 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI
 * JD-Core Version:    0.7.0.1
 */