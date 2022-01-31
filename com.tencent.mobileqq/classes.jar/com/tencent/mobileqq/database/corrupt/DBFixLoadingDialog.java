package com.tencent.mobileqq.database.corrupt;

import acec;
import aced;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class DBFixLoadingDialog
  extends Dialog
  implements Handler.Callback
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = "DBFix";
  public static int b;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 1;
  public static int g = 2;
  public static int h = 3;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBFixLoadingDialog.onDBFixCall jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private File jdField_a_of_type_JavaIoFile;
  private Runnable jdField_a_of_type_JavaLangRunnable = new aced(this);
  private long jdField_b_of_type_Long;
  private File jdField_b_of_type_JavaIoFile;
  private String jdField_b_of_type_JavaLangString;
  private int i = jdField_b_of_type_Int;
  
  static
  {
    jdField_a_of_type_Int = 1;
  }
  
  DBFixLoadingDialog(QQAppInterface paramQQAppInterface, Context paramContext, DBFixLoadingDialog.onDBFixCall paramonDBFixCall)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall = paramonDBFixCall;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == f) {
      if (this.i == c)
      {
        k = (int)((float)(System.currentTimeMillis() - this.jdField_b_of_type_Long) / (10.0F * this.jdField_a_of_type_Float));
        j = k;
        if (k > 90) {
          j = (k - 90) / 10 + 90;
        }
        paramMessage = String.format("正在修复中（%d%%）", new Object[] { Integer.valueOf(Math.min(j, 99)) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(f, 500L);
      }
    }
    while (paramMessage.what != g)
    {
      do
      {
        int k;
        int j;
        return false;
        if (this.i == d)
        {
          ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(204)).b(true);
          if (!this.jdField_b_of_type_JavaIoFile.renameTo(this.jdField_a_of_type_JavaIoFile))
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "db fix succ but copy fail");
            boolean bool = FileUtils.a(this.jdField_b_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile);
            FileUtils.d(this.jdField_b_of_type_JavaIoFile.getPath());
            if (!bool)
            {
              QLog.d(jdField_a_of_type_JavaLangString, 1, "db fix succ but copy fail final");
              paramMessage = new HashMap();
              StatisticCollector.a(BaseApplication.getContext()).a(null, DBFixManager.m, true, -1L, 0L, paramMessage, null, false);
            }
          }
          this.jdField_a_of_type_AndroidWidgetTextView.setText("正在修复中（100%）");
          this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(g, 100L);
          return false;
        }
      } while (this.i != e);
      dismiss();
      this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall.a(this.i);
      return false;
    }
    if (((this.jdField_a_of_type_AndroidContentContext instanceof Activity)) && (!((Activity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall.a(this.i);
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2130969070);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365001));
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaIoFile = this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_b_of_type_JavaLangString + ".db");
    this.jdField_b_of_type_JavaIoFile = this.jdField_a_of_type_AndroidContentContext.getDatabasePath(this.jdField_b_of_type_JavaLangString + "_dump.db");
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
    this.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_Long / 1216348.1F);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.jdField_b_of_type_JavaLangString, 0);
    jdField_a_of_type_Int = localSharedPreferences.getInt(paramBundle + DBFixManager.c, 2);
    if (localSharedPreferences.getInt(paramBundle + DBFixManager.e, 0) > 2) {
      if (jdField_a_of_type_Int != 2) {
        break label395;
      }
    }
    label395:
    for (int j = 1;; j = 2)
    {
      jdField_a_of_type_Int = j;
      localSharedPreferences.edit().putInt(paramBundle + DBFixManager.c, jdField_a_of_type_Int).commit();
      String str = localSharedPreferences.getString(paramBundle + DBFixManager.k, "");
      localSharedPreferences.edit().putString(paramBundle + DBFixManager.k, str + "_" + jdField_a_of_type_Int).commit();
      ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 10, null, true);
      super.setOnKeyListener(new acec(this));
      return;
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog
 * JD-Core Version:    0.7.0.1
 */