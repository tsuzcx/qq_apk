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
import bctu;
import bctv;
import bctw;
import bctx;
import befr;
import bfhi;
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
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new bctu(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bctx jdField_a_of_type_Bctx;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Queue<bctv> jdField_a_of_type_JavaUtilQueue;
  private bctx jdField_b_of_type_Bctx;
  
  static
  {
    jdField_a_of_type_JavaLangString = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
  }
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Bitmap paramBitmap, bctv parambctv, bctx parambctx)
  {
    int j = 1;
    if ((parambctx == null) || (parambctx.jdField_a_of_type_Bctw == null) || (parambctx.jdField_a_of_type_Bctw.mWebview.getX5WebViewExtension() == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
      }
      return;
    }
    Object localObject1 = parambctx.jdField_a_of_type_Bctw.mWebview.getX5WebViewExtension().getClass().getInterfaces();
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
        ((Method)localObject1).invoke(parambctx.jdField_a_of_type_Bctw.mWebview.getX5WebViewExtension(), new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new SnapshotService.2(this, paramBitmap, parambctv, parambctx) });
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
      if (parambctx.jdField_a_of_type_AndroidOsResultReceiver != null)
      {
        paramBitmap = new Bundle();
        paramBitmap.putLong("seq", parambctv.jdField_a_of_type_Long);
        parambctx.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
      }
      finish();
      return;
      i += 1;
      break label69;
      i = 0;
    }
  }
  
  private void a(bctv parambctv, bctx parambctx)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.1(this, parambctx, parambctv), parambctx.jdField_a_of_type_Long);
  }
  
  private void a(bctx parambctx)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "mQueue size = " + this.jdField_a_of_type_JavaUtilQueue.size());
    }
    bctv localbctv = (bctv)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localbctv != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "current cmd=" + localbctv.jdField_a_of_type_Long);
      }
      a(localbctv, parambctx);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Intent arg1)
  {
    bctv localbctv = new bctv();
    localbctv.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localbctv.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localbctv.b = ???.getIntExtra("maxSnapshotCount", 5);
    localbctv.jdField_a_of_type_Int = 0;
    localbctv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localbctv.jdField_a_of_type_Long);
    }
    if (localbctv.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localbctv);
        a(this.jdField_a_of_type_Bctx);
        return true;
      }
      this.jdField_a_of_type_JavaUtilQueue.offer(localbctv);
    }
  }
  
  private boolean a(Intent paramIntent, bctx parambctx)
  {
    bctx.a(parambctx, paramIntent.getLongExtra("id", -1L));
    parambctx.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    parambctx.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    parambctx.jdField_b_of_type_Long = 3000L;
    parambctx.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(parambctx.jdField_a_of_type_JavaLangString))
    {
      parambctx.jdField_b_of_type_JavaLangString = (bctx.a(parambctx) + bfhi.d(parambctx.jdField_a_of_type_JavaLangString));
      return true;
    }
    return false;
  }
  
  private void b(Bitmap paramBitmap, bctv parambctv, bctx parambctx)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      parambctx = new StringBuilder().append("/Snapshot_").append(parambctx.jdField_b_of_type_JavaLangString).append("_");
      int i = parambctv.jdField_a_of_type_Int;
      parambctv.jdField_a_of_type_Int = (i + 1);
      parambctx = new File((File)localObject, i + ".png");
      localObject = new FileOutputStream(parambctx);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      parambctv.jdField_a_of_type_JavaUtilArrayList.add(parambctx.getAbsolutePath());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "saveSnapshotBitmap file path = " + parambctx.getAbsolutePath());
      }
      return;
    }
    catch (Exception paramBitmap)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_b_of_type_JavaLangString, 2, paramBitmap.getMessage());
    }
  }
  
  private void b(bctv arg1, bctx parambctx)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "finish once debug, webview id =" + bctx.a(parambctx) + ", seq=" + ???.jdField_a_of_type_Long);
    }
    Bundle localBundle;
    int i;
    if (parambctx.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localBundle = new Bundle();
      localBundle.putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      localBundle.putLong("seq", ???.jdField_a_of_type_Long);
      localBundle.putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = parambctx.jdField_a_of_type_AndroidOsResultReceiver;
      if (bctx.a(parambctx) <= 0L) {
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
          a(parambctx);
          return;
          label168:
          i = 0;
        }
      }
    }
    finish();
  }
  
  private void c(bctv parambctv, bctx parambctx)
  {
    if ((parambctx.jdField_a_of_type_Bctw.mWebview.getWidth() <= 0) || (parambctx.jdField_a_of_type_Bctw.mWebview.getHeight() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + parambctx.jdField_a_of_type_Bctw.mWebview.getWidth() + ", height=" + parambctx.jdField_a_of_type_Bctw.mWebview.getHeight());
      }
      if ((this.jdField_a_of_type_Long > 0L) && (parambctx.jdField_a_of_type_AndroidOsResultReceiver != null))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("debugUrl", parambctx.jdField_a_of_type_JavaLangString);
        ((Bundle)localObject).putInt("maxCount", parambctv.b);
        ((Bundle)localObject).putLong("delay", parambctx.jdField_a_of_type_Long);
        ((Bundle)localObject).putLong("seq", parambctv.jdField_a_of_type_Long);
        ((Bundle)localObject).putString("seqKey", parambctv.jdField_a_of_type_JavaLangString);
        parambctx.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_b_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
        }
      }
      finish();
      return;
    }
    Object localObject = Bitmap.createBitmap(parambctx.jdField_a_of_type_Bctw.mWebview.getWidth(), parambctx.jdField_a_of_type_Bctw.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
    if (parambctx.jdField_a_of_type_Bctw.mWebview.getX5WebViewExtension() != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "start x5 snapshot");
      }
      a((Bitmap)localObject, parambctv, parambctx);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "start webview snapshot");
    }
    Canvas localCanvas = new Canvas((Bitmap)localObject);
    parambctx.jdField_a_of_type_Bctw.mWebview.draw(localCanvas);
    if (parambctv.jdField_a_of_type_Int == 0) {
      parambctv.jdField_a_of_type_Int += 1;
    }
    for (;;)
    {
      d(parambctv, parambctx);
      return;
      b((Bitmap)localObject, parambctv, parambctx);
    }
  }
  
  private void d(bctv parambctv, bctx parambctx)
  {
    int j;
    int i;
    boolean bool;
    if (parambctx.jdField_a_of_type_Bctw.mWebview.getX5WebViewExtension() != null)
    {
      j = 1;
      if (j == 0) {
        break label217;
      }
      i = parambctx.jdField_a_of_type_Bctw.mWebview.getHeight();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview width =" + parambctx.jdField_a_of_type_Bctw.mWebview.getWidth() + ", height=" + parambctx.jdField_a_of_type_Bctw.mWebview.getHeight());
        QLog.i(jdField_b_of_type_JavaLangString, 2, "webview scroll height =" + i);
      }
      parambctx.jdField_a_of_type_Bctw.mWebview.loadUrl("javascript:window.scrollBy(0, " + i + " / window.devicePixelRatio)");
      bool = false;
      label159:
      if (j == 0) {
        break label233;
      }
      i = parambctv.b;
      label169:
      if (parambctv.jdField_a_of_type_Int >= i) {
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
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.3(this, parambctv, parambctx), parambctx.jdField_b_of_type_Long);
      return;
      j = 0;
      break;
      label217:
      bool = parambctx.jdField_a_of_type_Bctw.mWebview.pageDown(false);
      break label159;
      label233:
      i = parambctv.b + 1;
      break label169;
      label243:
      i = 0;
      break label179;
      label248:
      if ((parambctv.jdField_a_of_type_Int <= 1) || ((bool) && (i != 0))) {
        i = 1;
      } else {
        i = 0;
      }
    }
    label275:
    b(parambctv, parambctx);
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
    if (this.jdField_a_of_type_Bctx != null) {
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.c();
    }
    if (this.jdField_b_of_type_Bctx != null) {
      this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.c();
    }
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_Bctx != null) {
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.b();
    }
    if (this.jdField_b_of_type_Bctx != null) {
      this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.b();
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
    befr.b();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", -1L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_Bctx = new bctx(this);
      if (!a(getIntent(), this.jdField_a_of_type_Bctx)) {
        finish();
      }
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw = new bctw(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.mWebview, new ViewGroup.LayoutParams(-1, -1));
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
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.a(this.jdField_a_of_type_Bctx.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    label417:
    do
    {
      return;
      this.jdField_b_of_type_Bctx = new bctx(this);
      if (!a(getIntent(), this.jdField_b_of_type_Bctx)) {
        finish();
      }
      this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw = new bctw(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.mWebview, new ViewGroup.LayoutParams(-1, -1));
      break;
      this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.a(this.jdField_b_of_type_Bctx.jdField_a_of_type_JavaLangString);
      paramBundle = new bctv();
      paramBundle.jdField_a_of_type_Long = getIntent().getLongExtra("seq", -1L);
      paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("seqKey");
      paramBundle.b = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.jdField_a_of_type_Int = 0;
      paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + paramBundle.jdField_a_of_type_Long);
      }
    } while (paramBundle.jdField_a_of_type_Long == -1L);
    a(paramBundle, this.jdField_b_of_type_Bctx);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    if (l < 0L)
    {
      if (this.jdField_b_of_type_Bctx == null)
      {
        this.jdField_b_of_type_Bctx = new bctx(this);
        this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw = new bctw(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.jdField_b_of_type_Bctx);
      bctv localbctv = new bctv();
      localbctv.jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      localbctv.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      localbctv.b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      localbctv.jdField_a_of_type_Int = 0;
      localbctv.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command seq=" + localbctv.jdField_a_of_type_Long);
      }
      if (localbctv.jdField_a_of_type_Long != -1L)
      {
        this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.a(this.jdField_b_of_type_Bctx.jdField_a_of_type_JavaLangString);
        a(localbctv, this.jdField_b_of_type_Bctx);
      }
    }
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Bctx == null)
        {
          this.jdField_a_of_type_Bctx = new bctx(this);
          this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw = new bctw(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.a(super.getIntent());
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.mWebview, new ViewGroup.LayoutParams(-1, -1));
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
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Long = 1000L;
      this.jdField_a_of_type_Bctx.jdField_b_of_type_Long = 1000L;
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
    } while ((!a(getIntent(), this.jdField_a_of_type_Bctx)) || (!a(getIntent())));
    this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.a(this.jdField_a_of_type_Bctx.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Long = l;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Bctx != null) {
      this.jdField_a_of_type_Bctx.jdField_a_of_type_Bctw.a();
    }
    if (this.jdField_b_of_type_Bctx != null) {
      this.jdField_b_of_type_Bctx.jdField_a_of_type_Bctw.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */