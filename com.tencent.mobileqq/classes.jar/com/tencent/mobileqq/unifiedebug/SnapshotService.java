package com.tencent.mobileqq.unifiedebug;

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
import azti;
import aztj;
import aztk;
import aztl;
import bbdc;
import bcdu;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
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
  public static String a;
  private static boolean jdField_a_of_type_Boolean;
  private static String jdField_b_of_type_JavaLangString = "SnapshotService";
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new azti(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private aztl jdField_a_of_type_Aztl;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Queue<aztj> jdField_a_of_type_JavaUtilQueue;
  private aztl jdField_b_of_type_Aztl;
  
  static
  {
    jdField_a_of_type_JavaLangString = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
  }
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Bitmap paramBitmap, aztj paramaztj, aztl paramaztl)
  {
    int j = 1;
    if ((paramaztl == null) || (paramaztl.jdField_a_of_type_Aztk == null) || (paramaztl.jdField_a_of_type_Aztk.mWebview.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = paramaztl.jdField_a_of_type_Aztk.mWebview.getX5WebViewExtension().getClass().getInterfaces();
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
          QLog.i(jdField_b_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap");
        }
        ((Method)localObject1).invoke(paramaztl.jdField_a_of_type_Aztk.mWebview.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new SnapshotService.2(this, paramBitmap, paramaztj, paramaztl) });
        i = j;
      }
      catch (Exception paramBitmap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i(jdField_b_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap failed: " + paramBitmap.getMessage());
        i = 0;
        continue;
      }
      if (i != 0) {
        break;
      }
      if (paramaztl.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", paramaztj.jdField_a_of_type_Long);
        paramaztl.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
      }
      finish();
      return;
      i += 1;
      break label69;
      i = 0;
    }
  }
  
  private void a(aztj paramaztj, aztl paramaztl)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.1(this, paramaztl, paramaztj), paramaztl.jdField_a_of_type_Long);
  }
  
  private void a(aztl paramaztl)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "mQueue size = " + this.jdField_a_of_type_JavaUtilQueue.size());
    }
    aztj localaztj = (aztj)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localaztj != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "current cmd=" + localaztj.jdField_a_of_type_Long);
      }
      a(localaztj, paramaztl);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Intent arg1)
  {
    aztj localaztj = new aztj();
    localaztj.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localaztj.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localaztj.b = ???.getIntExtra("maxSnapshotCount", 5);
    localaztj.jdField_a_of_type_Int = 0;
    localaztj.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localaztj.jdField_a_of_type_Long);
    }
    if (localaztj.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localaztj);
        a(this.jdField_a_of_type_Aztl);
        return true;
      }
      this.jdField_a_of_type_JavaUtilQueue.offer(localaztj);
    }
  }
  
  private boolean a(Intent paramIntent, aztl paramaztl)
  {
    aztl.a(paramaztl, paramIntent.getLongExtra("id", -1L));
    paramaztl.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramaztl.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    paramaztl.jdField_b_of_type_Long = 3000L;
    paramaztl.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramaztl.jdField_a_of_type_JavaLangString))
    {
      paramaztl.jdField_b_of_type_JavaLangString = (aztl.a(paramaztl) + bcdu.d(paramaztl.jdField_a_of_type_JavaLangString));
      return true;
    }
    return false;
  }
  
  private void b(Bitmap paramBitmap, aztj paramaztj, aztl paramaztl)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      paramaztl = new StringBuilder().append("/Snapshot_").append(paramaztl.jdField_b_of_type_JavaLangString).append("_");
      int i = paramaztj.jdField_a_of_type_Int;
      paramaztj.jdField_a_of_type_Int = (i + 1);
      paramaztl = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(paramaztl);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      paramaztj.jdField_a_of_type_JavaUtilArrayList.add(paramaztl.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "saveSnapshotBitmap file path = " + paramaztl.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_b_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  private void b(aztj arg1, aztl paramaztl)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "finish once debug, webview id =" + aztl.a(paramaztl) + ", seq=" + ???.jdField_a_of_type_Long);
    }
    Bundle localBundle;
    int i;
    if (paramaztl.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      localBundle.putLong("seq", ???.jdField_a_of_type_Long);
      localBundle.putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = paramaztl.jdField_a_of_type_AndroidOsResultReceiver;
      if (aztl.a(paramaztl) <= 0L) {
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
          a(paramaztl);
          return;
          label168:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void c(aztj paramaztj, aztl paramaztl)
  {
    if ((paramaztl.jdField_a_of_type_Aztk.mWebview.getWidth() <= 0) || (paramaztl.jdField_a_of_type_Aztk.mWebview.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + paramaztl.jdField_a_of_type_Aztk.mWebview.getWidth() + ", height=" + paramaztl.jdField_a_of_type_Aztk.mWebview.getHeight());
      }
      if ((this.jdField_a_of_type_Long > 0L) && (paramaztl.jdField_a_of_type_AndroidOsResultReceiver != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", paramaztl.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("maxCount", paramaztj.b);
        ((Bundle)localObject).putLong("delay", paramaztl.jdField_a_of_type_Long);
        ((Bundle)localObject).putLong("seq", paramaztj.jdField_a_of_type_Long);
        ((Bundle)localObject).putString("seqKey", paramaztj.jdField_a_of_type_JavaLangString);
        paramaztl.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(paramaztl.jdField_a_of_type_Aztk.mWebview.getWidth(), paramaztl.jdField_a_of_type_Aztk.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
    if (paramaztl.jdField_a_of_type_Aztk.mWebview.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, paramaztj, paramaztl);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    paramaztl.jdField_a_of_type_Aztk.mWebview.draw(localCanvas);
    if (paramaztj.jdField_a_of_type_Int == 0) {
      paramaztj.jdField_a_of_type_Int += 1;
    }
    for (;;)
    {
      d(paramaztj, paramaztl);
      return;
      b((Bitmap)localObject, paramaztj, paramaztl);
    }
  }
  
  private void d(aztj paramaztj, aztl paramaztl)
  {
    int j;
    int i;
    boolean bool;
    if (paramaztl.jdField_a_of_type_Aztk.mWebview.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label217;
      }
      i = paramaztl.jdField_a_of_type_Aztk.mWebview.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + paramaztl.jdField_a_of_type_Aztk.mWebview.getWidth() + ", height=" + paramaztl.jdField_a_of_type_Aztk.mWebview.getHeight());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview scroll height =" + i);
      }
      paramaztl.jdField_a_of_type_Aztk.mWebview.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label233;
      }
      i = paramaztj.b;
      label169:
      if (paramaztj.jdField_a_of_type_Int >= i) {
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.3(this, paramaztj, paramaztl), paramaztl.jdField_b_of_type_Long);
      return;
      j = 0;
      break;
      label217:
      bool = paramaztl.jdField_a_of_type_Aztk.mWebview.pageDown(false);
      break label159;
      label233:
      i = paramaztj.b + 1;
      break label169;
      label243:
      i = 0;
      break label179;
      label248:
      if ((paramaztj.jdField_a_of_type_Int <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label275:
    b(paramaztj, paramaztl);
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "in onDestroy method()");
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      jdField_a_of_type_Boolean = false;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_JavaUtilQueue.clear();
    super.doOnDestroy();
    if (this.jdField_a_of_type_Aztl != null) {
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.c();
    }
    if (this.jdField_b_of_type_Aztl != null) {
      this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.c();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Aztl != null) {
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.b();
    }
    if (this.jdField_b_of_type_Aztl != null) {
      this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.b();
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  public void onCreate(Bundle paramBundle)
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
        QLog.d(jdField_b_of_type_JavaLangString, 2, "app == null");
      }
      super.finish();
    }
    bbdc.b();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", -1L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Aztl = new aztl(this);
      if (!a(getIntent(), this.jdField_a_of_type_Aztl)) {
        finish();
      }
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk = new aztk(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.mWebview, new ViewGroup.LayoutParams(-1, -1));
      super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      super.moveTaskToBack(true);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onCreate");
      }
      if (this.jdField_a_of_type_Long <= 0L) {
        break label417;
      }
      paramBundle = new IntentFilter("android.intent.action.ultimatesnapshot");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.a(this.jdField_a_of_type_Aztl.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    label417:
    do
    {
      return;
      this.jdField_b_of_type_Aztl = new aztl(this);
      if (!a(getIntent(), this.jdField_b_of_type_Aztl)) {
        finish();
      }
      this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk = new aztk(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.mWebview, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.a(this.jdField_b_of_type_Aztl.jdField_a_of_type_JavaLangString);
      paramBundle = new aztj();
      paramBundle.jdField_a_of_type_Long = getIntent().getLongExtra("seq", -1L);
      paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("seqKey");
      paramBundle.b = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.jdField_a_of_type_Int = 0;
      paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + paramBundle.jdField_a_of_type_Long);
      }
    } while (paramBundle.jdField_a_of_type_Long == -1L);
    a(paramBundle, this.jdField_b_of_type_Aztl);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    if (l < 0L)
    {
      if (this.jdField_b_of_type_Aztl == null)
      {
        this.jdField_b_of_type_Aztl = new aztl(this);
        this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk = new aztk(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.jdField_b_of_type_Aztl);
      aztj localaztj = new aztj();
      localaztj.jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      localaztj.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      localaztj.b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      localaztj.jdField_a_of_type_Int = 0;
      localaztj.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localaztj.jdField_a_of_type_Long);
      }
      if (localaztj.jdField_a_of_type_Long != -1L)
      {
        this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.a(this.jdField_b_of_type_Aztl.jdField_a_of_type_JavaLangString);
        a(localaztj, this.jdField_b_of_type_Aztl);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Aztl == null)
        {
          this.jdField_a_of_type_Aztl = new aztl(this);
          this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk = new aztk(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.a(super.getIntent());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.mWebview, new ViewGroup.LayoutParams(-1, -1));
        }
        switch (paramIntent.getIntExtra("action", 2))
        {
        case 1: 
        default: 
          return;
        }
      } while (l != this.jdField_a_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "onNewIntent(), just snapshot for loaded url");
      }
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Long = 1000L;
      this.jdField_a_of_type_Aztl.jdField_b_of_type_Long = 1000L;
      a(paramIntent);
      return;
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "onNewIntent(), load url");
      }
      if (!jdField_a_of_type_Boolean)
      {
        paramIntent = new IntentFilter("android.intent.action.ultimatesnapshot");
        registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramIntent);
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
        }
      }
      jdField_a_of_type_Boolean = true;
    } while ((!a(getIntent(), this.jdField_a_of_type_Aztl)) || (!a(getIntent())));
    this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.a(this.jdField_a_of_type_Aztl.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = l;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Aztl != null) {
      this.jdField_a_of_type_Aztl.jdField_a_of_type_Aztk.a();
    }
    if (this.jdField_b_of_type_Aztl != null) {
      this.jdField_b_of_type_Aztl.jdField_a_of_type_Aztk.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */