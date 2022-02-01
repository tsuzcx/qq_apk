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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixDialogUI
  implements DBFixLoadingDialog.onDBFixCall
{
  public static Dialog d;
  public static String e = "0X8007960";
  public static String f = "0X8007961";
  public static String g = "0X8007962";
  public static String h = "0X8007963";
  public static String i = "0X8007964";
  private static String k = "DBFix";
  QQAppInterface a;
  Context b;
  String c;
  DialogInterface.OnCancelListener j = new DBFixDialogUI.1(this);
  private DBFixManager l;
  private int m;
  private String n = "";
  
  public DBFixDialogUI(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.b = paramContext;
    this.c = paramQQAppInterface.getCurrentAccountUin();
    this.l = ((DBFixManager)this.a.getManager(QQManagerFactory.DB_FIX_MANAGER));
  }
  
  private void a(Dialog paramDialog, String paramString)
  {
    String str = k;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DBFixDialogUI showDialog, ");
    localStringBuilder.append(paramString);
    QLog.d(str, 1, localStringBuilder.toString());
    this.n = paramString;
    this.a.runOnUiThread(new DBFixDialogUI.2(this, paramDialog));
  }
  
  private void c()
  {
    this.l.a(true);
    d = new DBFixLoadingDialog(this.a, this.b, this);
    d.setOnCancelListener(this.j);
    a(d, "fixing");
  }
  
  private void d()
  {
    d = DialogUtil.a(this.b, 230).setMessage(HardCodeUtil.a(2131901009)).setPositiveButton(HardCodeUtil.a(2131901014), new DBFixDialogUI.5(this));
    d.setOnKeyListener(new DBFixDialogUI.6(this));
    d.setOnCancelListener(this.j);
    a(d, "fix succ");
    QQAppInterface localQQAppInterface = this.a;
    String str1 = this.c;
    String str2 = h;
    ReportController.b(localQQAppInterface, "CliOper", "", str1, str2, str2, 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    d = DialogUtil.a(this.b, 230).setMessage(HardCodeUtil.a(2131901010)).setPositiveButton("重启QQ", new DBFixDialogUI.7(this));
    d.setOnCancelListener(this.j);
    a(d, "fix fail");
  }
  
  private void f()
  {
    d = DialogUtil.a(this.b, 230).setMessage(HardCodeUtil.a(2131901016)).setPositiveButton(HardCodeUtil.a(2131901015), new DBFixDialogUI.9(this));
    d.setOnCancelListener(this.j);
    a(d, "unable to fix");
  }
  
  private void g()
  {
    d = DialogUtil.a(this.b, 230).setMessage(HardCodeUtil.a(2131901013)).setPositiveButton(HardCodeUtil.a(2131901008), new DBFixDialogUI.11(this)).setNegativeButton(HardCodeUtil.a(2131898212), new DBFixDialogUI.10(this));
    d.setOnCancelListener(this.j);
    a(d, "memory alert");
  }
  
  public void a()
  {
    d = null;
    Object localObject1 = this.b;
    if ((localObject1 instanceof DBFixDialogActivity)) {
      ((DBFixDialogActivity)localObject1).finish();
    }
    this.l.a(false);
    if (this.m != DBFixLoadingDialog.d)
    {
      Object localObject2 = this.a.getApplication().getSharedPreferences(DBFixManager.d, 0);
      localObject1 = this.a.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(DBFixManager.g);
      if (((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0) == DBFixManager.h)
      {
        QLog.d(k, 1, "DBFixDialogUI 2, max count, delete db");
        this.l.b(false);
        this.l.c();
        localObject2 = ((SharedPreferences)localObject2).edit();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(DBFixManager.f);
        ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(DBFixManager.g);
        ((SharedPreferences.Editor)localObject2).remove(localStringBuilder.toString());
        ((SharedPreferences.Editor)localObject2).commit();
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = HardCodeUtil.a(2131901011);
    if (paramInt == DBFixManager.h) {
      localObject = HardCodeUtil.a(2131901012);
    }
    d = DialogUtil.a(this.b, 230).setMessage((CharSequence)localObject).setPositiveButton(HardCodeUtil.a(2131899883), new DBFixDialogUI.4(this)).setNegativeButton("取消", new DBFixDialogUI.3(this));
    d.setOnCancelListener(this.j);
    a(d, "checked corrupt");
    localObject = this.a;
    String str1 = this.c;
    String str2 = e;
    ReportController.b((AppRuntime)localObject, "CliOper", "", str1, str2, str2, 0, 0, "", "", "", "");
    DBFixReportHelper.a();
  }
  
  public void b(int paramInt)
  {
    this.m = paramInt;
    this.a.runOnUiThread(new DBFixDialogUI.8(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixDialogUI
 * JD-Core Version:    0.7.0.1
 */