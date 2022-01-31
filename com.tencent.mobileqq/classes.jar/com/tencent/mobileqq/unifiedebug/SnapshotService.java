package com.tencent.mobileqq.unifiedebug;

import ajxt;
import ajxu;
import ajxw;
import ajxx;
import ajxy;
import ajxz;
import ajya;
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
  private ajya jdField_a_of_type_Ajya;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new ajxx(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Queue jdField_a_of_type_JavaUtilQueue;
  private ajya b;
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(ajxy paramajxy, ajya paramajya)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajxt(this, paramajya, paramajxy), paramajya.jdField_a_of_type_Long);
  }
  
  private void a(ajya paramajya)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "mQueue size = " + this.jdField_a_of_type_JavaUtilQueue.size());
    }
    ajxy localajxy = (ajxy)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localajxy != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "current cmd=" + localajxy.jdField_a_of_type_Long);
      }
      a(localajxy, paramajya);
    }
  }
  
  private void a(Bitmap paramBitmap, ajxy paramajxy, ajya paramajya)
  {
    int j = 1;
    if ((paramajya == null) || (paramajya.jdField_a_of_type_Ajxz == null) || (paramajya.jdField_a_of_type_Ajxz.a.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = paramajya.jdField_a_of_type_Ajxz.a.getX5WebViewExtension().getClass().getInterfaces();
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
        ((Method)localObject1).invoke(paramajya.jdField_a_of_type_Ajxz.a.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new ajxu(this, paramBitmap, paramajxy, paramajya) });
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
      if (paramajya.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", paramajxy.jdField_a_of_type_Long);
        paramajya.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
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
    ajxy localajxy = new ajxy();
    localajxy.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localajxy.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localajxy.b = ???.getIntExtra("maxSnapshotCount", 5);
    localajxy.jdField_a_of_type_Int = 0;
    localajxy.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command seq=" + localajxy.jdField_a_of_type_Long);
    }
    if (localajxy.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localajxy);
        a(this.jdField_a_of_type_Ajya);
        return true;
      }
      this.jdField_a_of_type_JavaUtilQueue.offer(localajxy);
    }
  }
  
  private boolean a(Intent paramIntent, ajya paramajya)
  {
    ajya.a(paramajya, paramIntent.getLongExtra("id", -1L));
    paramajya.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramajya.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    paramajya.jdField_b_of_type_Long = 3000L;
    paramajya.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramajya.jdField_a_of_type_JavaLangString))
    {
      paramajya.jdField_b_of_type_JavaLangString = (ajya.a(paramajya) + MD5Utils.d(paramajya.jdField_a_of_type_JavaLangString));
      return true;
    }
    return false;
  }
  
  private void b(ajxy arg1, ajya paramajya)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "finish once debug, webview id =" + ajya.a(paramajya) + ", seq=" + ???.jdField_a_of_type_Long);
    }
    Bundle localBundle;
    int i;
    if (paramajya.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      localBundle.putLong("seq", ???.jdField_a_of_type_Long);
      localBundle.putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = paramajya.jdField_a_of_type_AndroidOsResultReceiver;
      if (ajya.a(paramajya) <= 0L) {
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
          a(paramajya);
          return;
          label168:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void b(Bitmap paramBitmap, ajxy paramajxy, ajya paramajya)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramajya = new StringBuilder().append("/Snapshot_").append(paramajya.jdField_b_of_type_JavaLangString).append("_");
      int i = paramajxy.jdField_a_of_type_Int;
      paramajxy.jdField_a_of_type_Int = (i + 1);
      paramajya = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(paramajya);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      paramajxy.jdField_a_of_type_JavaUtilArrayList.add(paramajya.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "saveSnapshotBitmap file path = " + paramajya.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  private void c(ajxy paramajxy, ajya paramajya)
  {
    if ((paramajya.jdField_a_of_type_Ajxz.a.getWidth() <= 0) || (paramajya.jdField_a_of_type_Ajxz.a.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "webview width =" + paramajya.jdField_a_of_type_Ajxz.a.getWidth() + ", height=" + paramajya.jdField_a_of_type_Ajxz.a.getHeight());
      }
      if ((this.jdField_a_of_type_Long > 0L) && (paramajya.jdField_a_of_type_AndroidOsResultReceiver != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", paramajya.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("maxCount", paramajxy.b);
        ((Bundle)localObject).putLong("delay", paramajya.jdField_a_of_type_Long);
        ((Bundle)localObject).putLong("seq", paramajxy.jdField_a_of_type_Long);
        ((Bundle)localObject).putString("seqKey", paramajxy.jdField_a_of_type_JavaLangString);
        paramajya.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(paramajya.jdField_a_of_type_Ajxz.a.getWidth(), paramajya.jdField_a_of_type_Ajxz.a.getHeight(), Bitmap.Config.ARGB_8888);
    if (paramajya.jdField_a_of_type_Ajxz.a.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, paramajxy, paramajya);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramajya.jdField_a_of_type_Ajxz.a.draw(localCanvas);
    if (paramajxy.jdField_a_of_type_Int == 0) {
      paramajxy.jdField_a_of_type_Int += 1;
    }
    for (;;)
    {
      d(paramajxy, paramajya);
      return;
      b((Bitmap)localObject, paramajxy, paramajya);
    }
  }
  
  private void d(ajxy paramajxy, ajya paramajya)
  {
    int j;
    int i;
    boolean bool;
    if (paramajya.jdField_a_of_type_Ajxz.a.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label217;
      }
      i = paramajya.jdField_a_of_type_Ajxz.a.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "webview width =" + paramajya.jdField_a_of_type_Ajxz.a.getWidth() + ", height=" + paramajya.jdField_a_of_type_Ajxz.a.getHeight());
        QLog.i(jdField_a_of_type_JavaLangString, 2, "webview scroll height =" + i);
      }
      paramajya.jdField_a_of_type_Ajxz.a.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label233;
      }
      i = paramajxy.b;
      label169:
      if (paramajxy.jdField_a_of_type_Int >= i) {
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ajxw(this, paramajxy, paramajya), paramajya.jdField_b_of_type_Long);
      return;
      j = 0;
      break;
      label217:
      bool = paramajya.jdField_a_of_type_Ajxz.a.pageDown(false);
      break label159;
      label233:
      i = paramajxy.b + 1;
      break label169;
      label243:
      i = 0;
      break label179;
      label248:
      if ((paramajxy.jdField_a_of_type_Int <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label275:
    b(paramajxy, paramajya);
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
    if (this.jdField_a_of_type_Ajya != null) {
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.c();
    }
    if (this.b != null) {
      this.b.jdField_a_of_type_Ajxz.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Ajya != null) {
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.b();
    }
    if (this.b != null) {
      this.b.jdField_a_of_type_Ajxz.b();
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
      this.jdField_a_of_type_Ajya = new ajya(this);
      if (!a(getIntent(), this.jdField_a_of_type_Ajya)) {
        finish();
      }
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz = new ajxz(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a, new ViewGroup.LayoutParams(-1, -1));
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
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a(this.jdField_a_of_type_Ajya.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    label417:
    do
    {
      return;
      this.b = new ajya(this);
      if (!a(getIntent(), this.b)) {
        finish();
      }
      this.b.jdField_a_of_type_Ajxz = new ajxz(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.b.jdField_a_of_type_Ajxz.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_Ajxz.a, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.b.jdField_a_of_type_Ajxz.a(this.b.jdField_a_of_type_JavaLangString);
      paramBundle = new ajxy();
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
        this.b = new ajya(this);
        this.b.jdField_a_of_type_Ajxz = new ajxz(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.b.jdField_a_of_type_Ajxz.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.b.jdField_a_of_type_Ajxz.a, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.b);
      ajxy localajxy = new ajxy();
      localajxy.jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      localajxy.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      localajxy.b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      localajxy.jdField_a_of_type_Int = 0;
      localajxy.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        QLog.i(jdField_a_of_type_JavaLangString, 2, "new Command seq=" + localajxy.jdField_a_of_type_Long);
      }
      if (localajxy.jdField_a_of_type_Long != -1L)
      {
        this.b.jdField_a_of_type_Ajxz.a(this.b.jdField_a_of_type_JavaLangString);
        a(localajxy, this.b);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Ajya == null)
        {
          this.jdField_a_of_type_Ajya = new ajya(this);
          this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz = new ajxz(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a(super.getIntent());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a, new ViewGroup.LayoutParams(-1, -1));
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
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Long = 1000L;
      this.jdField_a_of_type_Ajya.jdField_b_of_type_Long = 1000L;
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
    } while ((!a(getIntent(), this.jdField_a_of_type_Ajya)) || (!a(getIntent())));
    this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a(this.jdField_a_of_type_Ajya.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = l;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Ajya != null) {
      this.jdField_a_of_type_Ajya.jdField_a_of_type_Ajxz.a();
    }
    if (this.b != null) {
      this.b.jdField_a_of_type_Ajxz.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */