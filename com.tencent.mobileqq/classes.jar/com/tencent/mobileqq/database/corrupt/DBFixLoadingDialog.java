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
  public static int b = 0;
  public static int c = 1;
  public static int d = 2;
  public static int e = 3;
  public static int f = 4;
  public static int g = 1;
  public static int h = 2;
  public static int i = 3;
  private static String j = "DBFix";
  private QQAppInterface k;
  private Context l;
  private DBFixLoadingDialog.onDBFixCall m;
  private TextView n;
  private String o;
  private File p;
  private File q;
  private File r;
  private long s;
  private float t;
  private long u;
  private MqqWeakReferenceHandler v = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private int w = b;
  private Runnable x = new DBFixLoadingDialog.2(this);
  
  DBFixLoadingDialog(QQAppInterface paramQQAppInterface, Context paramContext, DBFixLoadingDialog.onDBFixCall paramonDBFixCall)
  {
    super(paramContext);
    this.k = paramQQAppInterface;
    this.l = paramContext;
    this.m = paramonDBFixCall;
  }
  
  public void a()
  {
    Object localObject1 = this.k.getApplication().getDatabasePath("chat_ex.trace");
    if ((this.p.exists()) && ((!((File)localObject1).exists()) || (((File)localObject1).length() == 0L)))
    {
      QLog.d(j, 1, "copy fix_result_zero temp db");
      FileUtils.copyFile(this.p, (File)localObject1);
    }
    localObject1 = this.k.getApplication();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.k.getAccount());
    ((StringBuilder)localObject2).append(".db-wal");
    localObject1 = ((MobileQQ)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    localObject2 = this.k.getApplication().getDatabasePath("chat_ex.trace-wal");
    if ((!((File)localObject2).exists()) && (((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      QLog.d(j, 1, "copy fix_result_zero temp db-wal");
      FileUtils.copyFile((File)localObject1, (File)localObject2);
    }
    localObject1 = this.k.getApplication();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.k.getAccount());
    ((StringBuilder)localObject2).append(".db-shm");
    localObject1 = ((MobileQQ)localObject1).getDatabasePath(((StringBuilder)localObject2).toString());
    localObject2 = this.k.getApplication().getDatabasePath("chat_ex.trace-shm");
    if ((!((File)localObject2).exists()) && (((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
    {
      QLog.d(j, 1, "copy fix_result_zero temp db-shm");
      FileUtils.copyFile((File)localObject1, (File)localObject2);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == g)
    {
      int i1 = this.w;
      if (i1 == c)
      {
        int i2 = (int)((float)(System.currentTimeMillis() - this.u) / (this.t * 10.0F));
        i1 = i2;
        if (i2 > 90) {
          i1 = (i2 - 90) / 10 + 90;
        }
        i1 = Math.min(i1, 99);
        paramMessage = String.format(HardCodeUtil.a(2131901017), new Object[] { Integer.valueOf(i1) });
        this.n.setText(paramMessage);
        this.v.sendEmptyMessageDelayed(g, 500L);
        return false;
      }
      if (i1 == d)
      {
        ((DBFixManager)this.k.getManager(QQManagerFactory.DB_FIX_MANAGER)).b(true);
        if (!this.q.renameTo(this.p))
        {
          QLog.d(j, 1, "db fix succ but copy fail");
          boolean bool = FileUtils.copyFile(this.q, this.p);
          FileUtils.deleteFile(this.q.getPath());
          if (!bool)
          {
            QLog.d(j, 1, "db fix succ but copy fail final");
            paramMessage = new HashMap();
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, DBFixManager.x, true, -1L, 0L, paramMessage, null, false);
          }
        }
        DBFixReportHelper.b(a);
        this.n.setText(HardCodeUtil.a(2131901018));
        this.v.sendEmptyMessageDelayed(h, 100L);
        return false;
      }
      if ((i1 == e) || (i1 == f))
      {
        dismiss();
        DBFixReportHelper.b(a);
        this.m.b(this.w);
        return false;
      }
    }
    else if (paramMessage.what == h)
    {
      paramMessage = this.l;
      if (((paramMessage instanceof Activity)) && (!((Activity)paramMessage).isFinishing())) {
        dismiss();
      }
      this.m.b(this.w);
    }
    return false;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.setContentView(2131625295);
    this.n = ((TextView)super.findViewById(2131431641));
    this.o = this.k.getCurrentAccountUin();
    paramBundle = this.l;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.o);
    ((StringBuilder)localObject1).append(".db");
    this.p = paramBundle.getDatabasePath(((StringBuilder)localObject1).toString());
    paramBundle = this.l;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.o);
    ((StringBuilder)localObject1).append("_dump.db");
    this.q = paramBundle.getDatabasePath(((StringBuilder)localObject1).toString());
    paramBundle = this.l;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.o);
    ((StringBuilder)localObject1).append(".db-mbu");
    this.r = paramBundle.getDatabasePath(((StringBuilder)localObject1).toString());
    this.s = this.p.length();
    this.t = ((float)this.s / 1216348.1F);
    this.u = System.currentTimeMillis();
    paramBundle = this.k.getAccount();
    localObject1 = this.k.getApplication().getSharedPreferences(DBFixManager.d, 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(DBFixManager.e);
    localObject2 = ((StringBuilder)localObject2).toString();
    int i1 = 2;
    a = ((SharedPreferences)localObject1).getInt((String)localObject2, 2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(DBFixManager.g);
    if (((SharedPreferences)localObject1).getInt(((StringBuilder)localObject2).toString(), 0) > 2)
    {
      if (a == 2) {
        i1 = 1;
      }
      a = i1;
      localObject2 = ((SharedPreferences)localObject1).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(DBFixManager.e);
      ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), a).commit();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramBundle);
    ((StringBuilder)localObject2).append(DBFixManager.s);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    localObject1 = ((SharedPreferences)localObject1).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramBundle);
    localStringBuilder.append(DBFixManager.s);
    paramBundle = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("_");
    localStringBuilder.append(a);
    ((SharedPreferences.Editor)localObject1).putString(paramBundle, localStringBuilder.toString()).commit();
    ThreadManager.post(this.x, 10, null, true);
    super.setOnKeyListener(new DBFixLoadingDialog.1(this));
  }
  
  protected void onStart()
  {
    super.onStart();
    this.v.sendEmptyMessage(g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixLoadingDialog
 * JD-Core Version:    0.7.0.1
 */