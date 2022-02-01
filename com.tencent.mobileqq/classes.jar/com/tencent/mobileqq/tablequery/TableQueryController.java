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
  public static boolean a = false;
  public static boolean b = true;
  public static boolean c = false;
  private static TableQueryController d;
  private static boolean j = false;
  private WindowManager e;
  private WeakReference<QQAppInterface> f;
  private TableQueryViewer g;
  private TableQueryManager h = new TableQueryManager();
  private boolean i = false;
  private BroadcastReceiver k = new TableQueryController.2(this);
  
  public static TableQueryController a()
  {
    try
    {
      if (d == null) {
        try
        {
          d = new TableQueryController();
        }
        finally {}
      }
      return d;
    }
    finally {}
  }
  
  public int a(QueryData paramQueryData)
  {
    TableQueryViewer localTableQueryViewer = this.g;
    if (localTableQueryViewer == null) {
      return 0;
    }
    return localTableQueryViewer.b(paramQueryData);
  }
  
  public void a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      j = true;
      if (!c) {
        a().b();
      }
    }
    else if (paramMotionEvent.getAction() == 1)
    {
      paramMotionEvent = new TableQueryController.1(this);
      ThreadManager.getSubThreadHandler().postDelayed(paramMotionEvent, 400L);
    }
  }
  
  public void b()
  {
    if (a) {
      this.g.a();
    }
  }
  
  public void b(QueryData paramQueryData)
  {
    if (a) {
      this.g.a(paramQueryData);
    }
  }
  
  public void c()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (this.g == null)
    {
      this.e = ((WindowManager)localBaseApplication.getSystemService("window"));
      this.g = new TableQueryViewer(localBaseApplication);
    }
    if (!this.i) {}
    try
    {
      this.e.removeViewImmediate(this.g);
      label56:
      int m;
      if (Build.VERSION.SDK_INT >= 26) {
        m = 2038;
      } else {
        m = 2003;
      }
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams(-1, -2, m, 776, -2);
      localLayoutParams.gravity = 51;
      localLayoutParams.x = 0;
      localLayoutParams.y = DisplayUtil.a(localBaseApplication, 72.0F);
      try
      {
        this.e.addView(this.g, localLayoutParams);
      }
      catch (Exception localException2)
      {
        label130:
        break label130;
      }
      QQToast.makeText(localBaseApplication, 1, localBaseApplication.getString(2131887558), 0).show();
      this.i = true;
      return;
    }
    catch (Exception localException1)
    {
      break label56;
    }
  }
  
  public void d()
  {
    if (this.i) {
      this.e.removeViewImmediate(this.g);
    }
    this.i = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryController
 * JD-Core Version:    0.7.0.1
 */