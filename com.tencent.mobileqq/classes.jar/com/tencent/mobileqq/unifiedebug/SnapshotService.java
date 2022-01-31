package com.tencent.mobileqq.unifiedebug;

import ajjp;
import ajjq;
import ajjs;
import ajjt;
import ajju;
import ajjv;
import ajjw;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebViewUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SnapshotService
  extends IphoneTitleBarActivity
{
  private static String jdField_a_of_type_JavaLangString = "SnapshotService";
  private static boolean jdField_a_of_type_Boolean;
  private long jdField_a_of_type_Long;
  private ajjw jdField_a_of_type_Ajjw;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajjt(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private ajjw b;
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(ajju paramajju, ajjw paramajjw)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajjp(this, paramajjw, paramajju), paramajjw.jdField_a_of_type_Long);
  }
  
  private void a(ajjw paramajjw)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "mQueue size = " + this.jdField_a_of_type_JavaUtilQueue.size());
    }
    ajju localajju = (ajju)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localajju != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "current cmd=" + localajju.jdField_a_of_type_Long);
      }
      a(localajju, paramajjw);
    }
  }
  
  private void a(Bitmap paramBitmap, ajju paramajju, ajjw paramajjw)
  {
    int j = 1;
    if ((paramajjw == null) || (paramajjw.jdField_a_of_type_Ajjv == null) || (paramajjw.jdField_a_of_type_Ajjv.a.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = paramajjw.jdField_a_of_type_Ajjv.a.getX5WebViewExtension().getClass().getInterfaces();
    int k = localObject1.length;
    int i = 0;
    label69:
    Object localObject2;
    if (i < k)
    {
      localObject2 = localObject1[i];
      if (!"com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(localObject2.getName())) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = localObject2.getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap");
        }
        ((Method)localObject1).invoke(paramajjw.jdField_a_of_type_Ajjv.a.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new ajjq(this, paramBitmap, paramajju, paramajjw) });
        i = j;
      }
      catch (Exception paramBitmap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_a_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap failed: " + paramBitmap.getMessage());
        i = 0;
        continue;
      }
      if (i != 0) {
        break;
      }
      if (paramajjw.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", paramajju.jdField_a_of_type_Long);
        paramajjw.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
      }
      finish();
      return;
      i += 1;
      break label69;
      i = 0;
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Intent arg1)
  {
    ajju localajju = new ajju();
    localajju.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localajju.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localajju.b = ???.getIntExtra("maxSnapshotCount", 5);
    localajju.jdField_a_of_type_Int = 0;
    localajju.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command seq=" + localajju.jdField_a_of_type_Long);
    }
    if (localajju.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localajju);
        a(this.jdField_a_of_type_Ajjw);
        return true;
      }
      this.jdField_a_of_type_JavaUtilQueue.offer(localajju);
    }
  }
  
  private boolean a(Intent paramIntent, ajjw paramajjw)
  {
    ajjw.a(paramajjw, paramIntent.getLongExtra("id", -1L));
    paramajjw.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramajjw.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    paramajjw.jdField_b_of_type_Long = 3000L;
    paramajjw.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramajjw.jdField_a_of_type_JavaLangString))
    {
      paramajjw.jdField_b_of_type_JavaLangString = (ajjw.a(paramajjw) + MD5Utils.d(paramajjw.jdField_a_of_type_JavaLangString));
      return true;
    }
    return false;
  }
  
  private void b(ajju arg1, ajjw paramajjw)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "finish once debug, webview id =" + ajjw.a(paramajjw) + ", seq=" + ???.jdField_a_of_type_Long);
    }
    Bundle localBundle;
    int i;
    if (paramajjw.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      localBundle.putLong("seq", ???.jdField_a_of_type_Long);
      localBundle.putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = paramajjw.jdField_a_of_type_AndroidOsResultReceiver;
      if (ajjw.a(paramajjw) <= 0L) {
        break label168;
      }
      i = 1;
    }
    for (;;)
    {
      ???.send(i, localBundle);
      synchronized (this.jdField_a_of_type_JavaUtilQueue)
      {
        if (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) {
          this.jdField_a_of_type_JavaUtilQueue.remove();
        }
        if (this.jdField_a_of_type_Long > 0L)
        {
          a(paramajjw);
          return;
          label168:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void b(Bitmap paramBitmap, ajju paramajju, ajjw paramajjw)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramajjw = new StringBuilder().append("/Snapshot_").append(paramajjw.jdField_b_of_type_JavaLangString).append("_");
      int i = paramajju.jdField_a_of_type_Int;
      paramajju.jdField_a_of_type_Int = (i + 1);
      paramajjw = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(paramajjw);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      paramajju.jdField_a_of_type_JavaUtilArrayList.add(paramajjw.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "saveSnapshotBitmap file path = " + paramajjw.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  private void c(ajju paramajju, ajjw paramajjw)
  {
    if ((paramajjw.jdField_a_of_type_Ajjv.a.getWidth() <= 0) || (paramajjw.jdField_a_of_type_Ajjv.a.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "webview width =" + paramajjw.jdField_a_of_type_Ajjv.a.getWidth() + ", height=" + paramajjw.jdField_a_of_type_Ajjv.a.getHeight());
      }
      if ((this.jdField_a_of_type_Long > 0L) && (paramajjw.jdField_a_of_type_AndroidOsResultReceiver != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", paramajjw.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("maxCount", paramajju.b);
        ((Bundle)localObject).putLong("delay", paramajjw.jdField_a_of_type_Long);
        ((Bundle)localObject).putLong("seq", paramajju.jdField_a_of_type_Long);
        ((Bundle)localObject).putString("seqKey", paramajju.jdField_a_of_type_JavaLangString);
        paramajjw.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(paramajjw.jdField_a_of_type_Ajjv.a.getWidth(), paramajjw.jdField_a_of_type_Ajjv.a.getHeight(), Bitmap.Config.ARGB_8888);
    if (paramajjw.jdField_a_of_type_Ajjv.a.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, paramajju, paramajjw);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramajjw.jdField_a_of_type_Ajjv.a.draw(localCanvas);
    if (paramajju.jdField_a_of_type_Int == 0) {
      paramajju.jdField_a_of_type_Int += 1;
    }
    for (;;)
    {
      d(paramajju, paramajjw);
      return;
      b((Bitmap)localObject, paramajju, paramajjw);
    }
  }
  
  private void d(ajju paramajju, ajjw paramajjw)
  {
    int j;
    int i;
    boolean bool;
    if (paramajjw.jdField_a_of_type_Ajjv.a.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label217;
      }
      i = paramajjw.jdField_a_of_type_Ajjv.a.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "webview width =" + paramajjw.jdField_a_of_type_Ajjv.a.getWidth() + ", height=" + paramajjw.jdField_a_of_type_Ajjv.a.getHeight());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "webview scroll height =" + i);
      }
      paramajjw.jdField_a_of_type_Ajjv.a.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label233;
      }
      i = paramajju.b;
      label169:
      if (paramajju.jdField_a_of_type_Int >= i) {
        break label243;
      }
      i = 1;
      label179:
      if (j == 0) {
        break label248;
      }
    }
    for (;;)
    {
      if (i == 0) {
        break label275;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajjs(this, paramajju, paramajjw), paramajjw.jdField_b_of_type_Long);
      return;
      j = 0;
      break;
      label217:
      bool = paramajjw.jdField_a_of_type_Ajjv.a.pageDown(false);
      break label159;
      label233:
      i = paramajju.b + 1;
      break label169;
      label243:
      i = 0;
      break label179;
      label248:
      if ((paramajju.jdField_a_of_type_Int <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label275:
    b(paramajju, paramajjw);
  }
  
  protected void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "in onDestroy method()");
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Ajjw != null) {
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.c();
    }
    if (this.b != null) {
      this.b.jdField_a_of_type_Ajjv.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Ajjw != null) {
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.b();
    }
    if (this.b != null) {
      this.b.jdField_a_of_type_Ajjv.b();
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this);
    paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((paramBundle instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramBundle);
    }
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "app == null");
      }
      super.finish();
    }
    SwiftWebViewUtils.b();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", -1L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Ajjw = new ajjw(this);
      if (!a(getIntent(), this.jdField_a_of_type_Ajjw)) {
        finish();
      }
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv = new ajjv(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a, new ViewGroup.LayoutParams(-1, -1));
      super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      super.moveTaskToBack(true);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command in onCreate");
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        break label417;
      }
      paramBundle = new IntentFilter("android.intent.action.ultimatesnapshot");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a(this.jdField_a_of_type_Ajjw.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    label417:
    do
    {
      return;
      this.b = new ajjw(this);
      if (!a(getIntent(), this.b)) {
        finish();
      }
      this.b.jdField_a_of_type_Ajjv = new ajjv(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.b.jdField_a_of_type_Ajjv.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_Ajjv.a, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.b.jdField_a_of_type_Ajjv.a(this.b.jdField_a_of_type_JavaLangString);
      paramBundle = new ajju();
      paramBundle.jdField_a_of_type_Long = getIntent().getLongExtra("seq", -1L);
      paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("seqKey");
      paramBundle.b = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.jdField_a_of_type_Int = 0;
      paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command seq=" + paramBundle.jdField_a_of_type_Long);
      }
    } while (paramBundle.jdField_a_of_type_Long == -1L);
    a(paramBundle, this.b);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    if (l < 0L)
    {
      if (this.b == null)
      {
        this.b = new ajjw(this);
        this.b.jdField_a_of_type_Ajjv = new ajjv(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.b.jdField_a_of_type_Ajjv.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_Ajjv.a, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.b);
      ajju localajju = new ajju();
      localajju.jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      localajju.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      localajju.b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      localajju.jdField_a_of_type_Int = 0;
      localajju.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command seq=" + localajju.jdField_a_of_type_Long);
      }
      if (localajju.jdField_a_of_type_Long != -1L)
      {
        this.b.jdField_a_of_type_Ajjv.a(this.b.jdField_a_of_type_JavaLangString);
        a(localajju, this.b);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Ajjw == null)
        {
          this.jdField_a_of_type_Ajjw = new ajjw(this);
          this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv = new ajjv(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a(super.getIntent());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a, new ViewGroup.LayoutParams(-1, -1));
        }
        switch (paramIntent.getIntExtra("action", 2))
        {
        case 1: 
        default: 
          return;
        }
      } while (l != this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onNewIntent(), just snapshot for loaded url");
      }
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Long = 1000L;
      this.jdField_a_of_type_Ajjw.jdField_b_of_type_Long = 1000L;
      a(paramIntent);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "onNewIntent(), load url");
      }
      if (!jdField_a_of_type_Boolean)
      {
        paramIntent = new IntentFilter("android.intent.action.ultimatesnapshot");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
        }
      }
      jdField_a_of_type_Boolean = true;
    } while ((!a(getIntent(), this.jdField_a_of_type_Ajjw)) || (!a(getIntent())));
    this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a(this.jdField_a_of_type_Ajjw.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = l;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ajjw != null) {
      this.jdField_a_of_type_Ajjw.jdField_a_of_type_Ajjv.a();
    }
    if (this.b != null) {
      this.b.jdField_a_of_type_Ajjv.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */