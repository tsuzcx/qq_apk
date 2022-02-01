package com.tencent.mobileqq.unifiedebug;

import Override;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import bflz;
import bfma;
import bfmb;
import bfmc;
import bgyb;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bflz(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bfmc jdField_a_of_type_Bfmc;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Queue<bfma> jdField_a_of_type_JavaUtilQueue;
  private bfmc jdField_b_of_type_Bfmc;
  
  static
  {
    jdField_a_of_type_JavaLangString = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
  }
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Bitmap paramBitmap, bfma parambfma, bfmc parambfmc)
  {
    int j = 1;
    if ((parambfmc == null) || (parambfmc.jdField_a_of_type_Bfmb == null) || (parambfmc.jdField_a_of_type_Bfmb.mWebview.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = parambfmc.jdField_a_of_type_Bfmb.mWebview.getX5WebViewExtension().getClass().getInterfaces();
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
        ((Method)localObject1).invoke(parambfmc.jdField_a_of_type_Bfmb.mWebview.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new SnapshotService.2(this, paramBitmap, parambfma, parambfmc) });
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
      if (parambfmc.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", parambfma.jdField_a_of_type_Long);
        parambfmc.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
      }
      finish();
      return;
      i += 1;
      break label69;
      i = 0;
    }
  }
  
  private void a(bfma parambfma, bfmc parambfmc)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.1(this, parambfmc, parambfma), parambfmc.jdField_a_of_type_Long);
  }
  
  private void a(bfmc parambfmc)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "mQueue size = " + this.jdField_a_of_type_JavaUtilQueue.size());
    }
    bfma localbfma = (bfma)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localbfma != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "current cmd=" + localbfma.jdField_a_of_type_Long);
      }
      a(localbfma, parambfmc);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Intent arg1)
  {
    bfma localbfma = new bfma();
    localbfma.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localbfma.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localbfma.b = ???.getIntExtra("maxSnapshotCount", 5);
    localbfma.jdField_a_of_type_Int = 0;
    localbfma.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localbfma.jdField_a_of_type_Long);
    }
    if (localbfma.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localbfma);
        a(this.jdField_a_of_type_Bfmc);
        return true;
      }
      this.jdField_a_of_type_JavaUtilQueue.offer(localbfma);
    }
  }
  
  private boolean a(Intent paramIntent, bfmc parambfmc)
  {
    bfmc.a(parambfmc, paramIntent.getLongExtra("id", -1L));
    parambfmc.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    parambfmc.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    parambfmc.jdField_b_of_type_Long = 3000L;
    parambfmc.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(parambfmc.jdField_a_of_type_JavaLangString))
    {
      parambfmc.jdField_b_of_type_JavaLangString = (bfmc.a(parambfmc) + MD5Utils.toMD5(parambfmc.jdField_a_of_type_JavaLangString));
      return true;
    }
    return false;
  }
  
  private void b(Bitmap paramBitmap, bfma parambfma, bfmc parambfmc)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      parambfmc = new StringBuilder().append("/Snapshot_").append(parambfmc.jdField_b_of_type_JavaLangString).append("_");
      int i = parambfma.jdField_a_of_type_Int;
      parambfma.jdField_a_of_type_Int = (i + 1);
      parambfmc = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(parambfmc);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      parambfma.jdField_a_of_type_JavaUtilArrayList.add(parambfmc.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "saveSnapshotBitmap file path = " + parambfmc.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_b_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  private void b(bfma arg1, bfmc parambfmc)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "finish once debug, webview id =" + bfmc.a(parambfmc) + ", seq=" + ???.jdField_a_of_type_Long);
    }
    Bundle localBundle;
    int i;
    if (parambfmc.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      localBundle.putLong("seq", ???.jdField_a_of_type_Long);
      localBundle.putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = parambfmc.jdField_a_of_type_AndroidOsResultReceiver;
      if (bfmc.a(parambfmc) <= 0L) {
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
          a(parambfmc);
          return;
          label168:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void c(bfma parambfma, bfmc parambfmc)
  {
    if ((parambfmc.jdField_a_of_type_Bfmb.mWebview.getWidth() <= 0) || (parambfmc.jdField_a_of_type_Bfmb.mWebview.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + parambfmc.jdField_a_of_type_Bfmb.mWebview.getWidth() + ", height=" + parambfmc.jdField_a_of_type_Bfmb.mWebview.getHeight());
      }
      if ((this.jdField_a_of_type_Long > 0L) && (parambfmc.jdField_a_of_type_AndroidOsResultReceiver != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", parambfmc.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("maxCount", parambfma.b);
        ((Bundle)localObject).putLong("delay", parambfmc.jdField_a_of_type_Long);
        ((Bundle)localObject).putLong("seq", parambfma.jdField_a_of_type_Long);
        ((Bundle)localObject).putString("seqKey", parambfma.jdField_a_of_type_JavaLangString);
        parambfmc.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(parambfmc.jdField_a_of_type_Bfmb.mWebview.getWidth(), parambfmc.jdField_a_of_type_Bfmb.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
    if (parambfmc.jdField_a_of_type_Bfmb.mWebview.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, parambfma, parambfmc);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    parambfmc.jdField_a_of_type_Bfmb.mWebview.draw(localCanvas);
    if (parambfma.jdField_a_of_type_Int == 0) {
      parambfma.jdField_a_of_type_Int += 1;
    }
    for (;;)
    {
      d(parambfma, parambfmc);
      return;
      b((Bitmap)localObject, parambfma, parambfmc);
    }
  }
  
  private void d(bfma parambfma, bfmc parambfmc)
  {
    int j;
    int i;
    boolean bool;
    if (parambfmc.jdField_a_of_type_Bfmb.mWebview.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label217;
      }
      i = parambfmc.jdField_a_of_type_Bfmb.mWebview.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + parambfmc.jdField_a_of_type_Bfmb.mWebview.getWidth() + ", height=" + parambfmc.jdField_a_of_type_Bfmb.mWebview.getHeight());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview scroll height =" + i);
      }
      parambfmc.jdField_a_of_type_Bfmb.mWebview.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label233;
      }
      i = parambfma.b;
      label169:
      if (parambfma.jdField_a_of_type_Int >= i) {
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.3(this, parambfma, parambfmc), parambfmc.jdField_b_of_type_Long);
      return;
      j = 0;
      break;
      label217:
      bool = parambfmc.jdField_a_of_type_Bfmb.mWebview.pageDown(false);
      break label159;
      label233:
      i = parambfma.b + 1;
      break label169;
      label243:
      i = 0;
      break label179;
      label248:
      if ((parambfma.jdField_a_of_type_Int <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label275:
    b(parambfma, parambfmc);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
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
    if (this.jdField_a_of_type_Bfmc != null) {
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.c();
    }
    if (this.jdField_b_of_type_Bfmc != null) {
      this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.c();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bfmc != null) {
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.b();
    }
    if (this.jdField_b_of_type_Bfmc != null) {
      this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.b();
    }
  }
  
  public String getModuleId()
  {
    return "modular_web";
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
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
    bgyb.b();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", -1L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Bfmc = new bfmc(this);
      if (!a(getIntent(), this.jdField_a_of_type_Bfmc)) {
        finish();
      }
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb = new bfmb(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.mWebview, new ViewGroup.LayoutParams(-1, -1));
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
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.a(this.jdField_a_of_type_Bfmc.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    label417:
    do
    {
      return;
      this.jdField_b_of_type_Bfmc = new bfmc(this);
      if (!a(getIntent(), this.jdField_b_of_type_Bfmc)) {
        finish();
      }
      this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb = new bfmb(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.mWebview, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.a(this.jdField_b_of_type_Bfmc.jdField_a_of_type_JavaLangString);
      paramBundle = new bfma();
      paramBundle.jdField_a_of_type_Long = getIntent().getLongExtra("seq", -1L);
      paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("seqKey");
      paramBundle.b = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.jdField_a_of_type_Int = 0;
      paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + paramBundle.jdField_a_of_type_Long);
      }
    } while (paramBundle.jdField_a_of_type_Long == -1L);
    a(paramBundle, this.jdField_b_of_type_Bfmc);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    if (l < 0L)
    {
      if (this.jdField_b_of_type_Bfmc == null)
      {
        this.jdField_b_of_type_Bfmc = new bfmc(this);
        this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb = new bfmb(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.jdField_b_of_type_Bfmc);
      bfma localbfma = new bfma();
      localbfma.jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      localbfma.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      localbfma.b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      localbfma.jdField_a_of_type_Int = 0;
      localbfma.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localbfma.jdField_a_of_type_Long);
      }
      if (localbfma.jdField_a_of_type_Long != -1L)
      {
        this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.a(this.jdField_b_of_type_Bfmc.jdField_a_of_type_JavaLangString);
        a(localbfma, this.jdField_b_of_type_Bfmc);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Bfmc == null)
        {
          this.jdField_a_of_type_Bfmc = new bfmc(this);
          this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb = new bfmb(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.a(super.getIntent());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.mWebview, new ViewGroup.LayoutParams(-1, -1));
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
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Long = 1000L;
      this.jdField_a_of_type_Bfmc.jdField_b_of_type_Long = 1000L;
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
    } while ((!a(getIntent(), this.jdField_a_of_type_Bfmc)) || (!a(getIntent())));
    this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.a(this.jdField_a_of_type_Bfmc.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = l;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bfmc != null) {
      this.jdField_a_of_type_Bfmc.jdField_a_of_type_Bfmb.a();
    }
    if (this.jdField_b_of_type_Bfmc != null) {
      this.jdField_b_of_type_Bfmc.jdField_a_of_type_Bfmb.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */