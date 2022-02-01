package com.tencent.mobileqq.database.corrupt;

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
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.MqqWeakReferenceHandler;
import java.io.File;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class DBFixLoadingDialog
  extends ReportDialog
  implements Handler.Callback
{
  public static int a = 1;
  private static String jdField_a_of_type_JavaLangString = "DBFix";
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private DBFixLoadingDialog.onDBFixCall jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall;
  private MqqWeakReferenceHandler jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private File jdField_a_of_type_JavaIoFile;
  private Runnable jdField_a_of_type_JavaLangRunnable = new DBFixLoadingDialog.2(this);
  private long jdField_b_of_type_Long;
  private File jdField_b_of_type_JavaIoFile;
  private String jdField_b_of_type_JavaLangString;
  private int j = jdField_b_of_type_Int;
  
  DBFixLoadingDialog(QQAppInterface paramQQAppInterface, Context paramContext, DBFixLoadingDialog.onDBFixCall paramonDBFixCall)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall = paramonDBFixCall;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == g)
    {
      int k = this.j;
      if (k == c)
      {
        int m = (int)((float)(System.currentTimeMillis() - this.jdField_b_of_type_Long) / (this.jdField_a_of_type_Float * 10.0F));
        k = m;
        if (m > 90) {
          k = (m - 90) / 10 + 90;
        }
        k = Math.min(k, 99);
        paramMessage = String.format(HardCodeUtil.a(2131703043), new Object[] { Integer.valueOf(k) });
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramMessage);
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(g, 500L);
        return false;
      }
      if (k == d)
      {
        ((DBFixManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DB_FIX_MANAGER)).b(true);
        if (!this.jdField_b_of_type_JavaIoFile.renameTo(this.jdField_a_of_type_JavaIoFile))
        {
          QLog.d(jdField_a_of_type_JavaLangString, 1, "db fix succ but copy fail");
          boolean bool = FileUtils.copyFile(this.jdField_b_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile);
          FileUtils.deleteFile(this.jdField_b_of_type_JavaIoFile.getPath());
          if (!bool)
          {
            QLog.d(jdField_a_of_type_JavaLangString, 1, "db fix succ but copy fail final");
            paramMessage = new HashMap();
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.n, true, -1L, 0L, paramMessage, null, false);
          }
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131703044));
        this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessageDelayed(h, 100L);
        return false;
      }
      if ((k == e) || (k == f))
      {
        dismiss();
        this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall.a(this.j);
        return false;
      }
    }
    else if (paramMessage.what == h)
    {
      paramMessage = this.jdField_a_of_type_AndroidContentContext;
      if (((paramMessage instanceof Activity)) && (!((Activity)paramMessage).isFinishing())) {
        dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqDatabaseCorruptDBFixLoadingDialog$onDBFixCall.a(this.j);
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131559329);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365437));
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    paramBundle = this.jdField_a_of_type_AndroidContentContext;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append(".db");
    this.jdField_a_of_type_JavaIoFile = paramBundle.getDatabasePath(((StringBuilder)localObject1).toString());
    paramBundle = this.jdField_a_of_type_AndroidContentContext;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("_dump.db");
    this.jdField_b_of_type_JavaIoFile = paramBundle.getDatabasePath(((StringBuilder)localObject1).toString());
    this.jdField_a_of_type_Long = this.jdField_a_of_type_JavaIoFile.length();
    this.jdField_a_of_type_Float = ((float)this.jdField_a_of_type_Long / 1216348.1F);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences(DBFixManager.jdField_b_of_type_JavaLangString, 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(DBFixManager.c);
    localObject2 = ((StringBuilder)localObject2).toString();
    int k = 2;
    jdField_a_of_type_Int = ((SharedPreferences)localObject1).getInt((String)localObject2, 2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(DBFixManager.e);
    if (((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0) > 2)
    {
      if (jdField_a_of_type_Int == 2) {
        k = 1;
      }
      jdField_a_of_type_Int = k;
      localObject2 = ((SharedPreferences)localObject1).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(DBFixManager.c);
      ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), jdField_a_of_type_Int).commit();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(DBFixManager.l);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    localObject1 = ((SharedPreferences)localObject1).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(DBFixManager.l);
    paramBundle = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("_");
    localStringBuilder.append(jdField_a_of_type_Int);
    ((SharedPreferences.Editor)localObject1).putString(paramBundle, localStringBuilder.toString()).commit();
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 10, null, true);
    super.setOnKeyListener(new DBFixLoadingDialog.1(this));
  }
  
  protected void onStart()
  {
    super.onStart();
    this.jdField_a_of_type_ComTencentUtilMqqWeakReferenceHandler.sendEmptyMessage(g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog
 * JD-Core Version:    0.7.0.1
 */