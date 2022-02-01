package com.tencent.mobileqq.unifiedebug;

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
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.webview.utils.ProxyConfig;
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
  public static String a = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
  private static boolean jdField_a_of_type_Boolean = false;
  private static String jdField_b_of_type_JavaLangString = "SnapshotService";
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new SnapshotService.4(this);
  public Handler a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SnapshotService.Snapshot jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
  private Queue<SnapshotService.DebugCommand> jdField_a_of_type_JavaUtilQueue;
  private SnapshotService.Snapshot jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
  
  public SnapshotService()
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
  }
  
  private void a(Bitmap paramBitmap, SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    if ((paramSnapshot != null) && (paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView != null) && (paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getX5WebViewExtension() != null))
    {
      Object localObject1 = paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getX5WebViewExtension().getClass().getInterfaces();
      int k = localObject1.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ("com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(((Class)localObject2).getName()))
        {
          try
          {
            localObject1 = ((Class)localObject2).getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
            if (QLog.isColorLevel()) {
              QLog.i(jdField_b_of_type_JavaLangString, 2, "call snapshotVisibleWithBitmap");
            }
            localObject2 = paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getX5WebViewExtension();
            try
            {
              ((Method)localObject1).invoke(localObject2, new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new SnapshotService.2(this, paramBitmap, paramDebugCommand, paramSnapshot) });
              i = 1;
            }
            catch (Exception paramBitmap) {}
            i = j;
          }
          catch (Exception paramBitmap) {}
          if (!QLog.isColorLevel()) {
            break label331;
          }
          localObject1 = jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("call snapshotVisibleWithBitmap failed: ");
          ((StringBuilder)localObject2).append(paramBitmap.getMessage());
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          i = j;
          break label331;
        }
        i += 1;
      }
      i = j;
      label331:
      if (i == 0)
      {
        if (paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver != null)
        {
          paramBitmap = new Bundle();
          paramBitmap.putLong("seq", paramDebugCommand.jdField_a_of_type_Long);
          paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver.send(3, paramBitmap);
        }
        finish();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "snapshotVisibleWithBitmap: null");
    }
  }
  
  private void a(SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.1(this, paramSnapshot, paramDebugCommand), paramSnapshot.jdField_a_of_type_Long);
  }
  
  private void a(SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mQueue size = ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilQueue.size());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (SnapshotService.DebugCommand)this.jdField_a_of_type_JavaUtilQueue.peek();
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("current cmd=");
        localStringBuilder.append(((SnapshotService.DebugCommand)localObject1).jdField_a_of_type_Long);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      a((SnapshotService.DebugCommand)localObject1, paramSnapshot);
    }
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  private boolean a(Intent arg1)
  {
    SnapshotService.DebugCommand localDebugCommand = new SnapshotService.DebugCommand();
    localDebugCommand.jdField_a_of_type_Long = ???.getLongExtra("seq", -1L);
    localDebugCommand.jdField_a_of_type_JavaLangString = ???.getStringExtra("seqKey");
    localDebugCommand.b = ???.getIntExtra("maxSnapshotCount", 5);
    localDebugCommand.jdField_a_of_type_Int = 0;
    localDebugCommand.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    if (QLog.isColorLevel())
    {
      ??? = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new Command seq=");
      localStringBuilder.append(localDebugCommand.jdField_a_of_type_Long);
      QLog.i(???, 2, localStringBuilder.toString());
    }
    if (localDebugCommand.jdField_a_of_type_Long == -1L) {
      return false;
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (this.jdField_a_of_type_JavaUtilQueue.isEmpty())
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localDebugCommand);
        a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilQueue.offer(localDebugCommand);
      }
      return true;
    }
  }
  
  private boolean a(Intent paramIntent, SnapshotService.Snapshot paramSnapshot)
  {
    SnapshotService.Snapshot.a(paramSnapshot, paramIntent.getLongExtra("id", -1L));
    paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramSnapshot.jdField_a_of_type_Long = paramIntent.getLongExtra("delay", 10000L);
    paramSnapshot.jdField_b_of_type_Long = 3000L;
    paramSnapshot.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramSnapshot.jdField_a_of_type_JavaLangString))
    {
      paramIntent = new StringBuilder();
      paramIntent.append(SnapshotService.Snapshot.a(paramSnapshot));
      paramIntent.append(MD5Utils.toMD5(paramSnapshot.jdField_a_of_type_JavaLangString));
      paramSnapshot.jdField_b_of_type_JavaLangString = paramIntent.toString();
      return true;
    }
    return false;
  }
  
  private void b(Bitmap paramBitmap, SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    try
    {
      Object localObject = new File(Environment.getExternalStorageDirectory(), "/tencent/MobileQQ/unifiedebug");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("/Snapshot_");
      localStringBuilder.append(paramSnapshot.jdField_b_of_type_JavaLangString);
      localStringBuilder.append("_");
      int i = paramDebugCommand.jdField_a_of_type_Int;
      paramDebugCommand.jdField_a_of_type_Int = (i + 1);
      localStringBuilder.append(i);
      localStringBuilder.append(".png");
      paramSnapshot = new File((File)localObject, localStringBuilder.toString());
      localObject = new FileOutputStream(paramSnapshot);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      paramDebugCommand.jdField_a_of_type_JavaUtilArrayList.add(paramSnapshot.getAbsolutePath());
      if (QLog.isColorLevel())
      {
        paramBitmap = jdField_b_of_type_JavaLangString;
        paramDebugCommand = new StringBuilder();
        paramDebugCommand.append("saveSnapshotBitmap file path = ");
        paramDebugCommand.append(paramSnapshot.getAbsolutePath());
        QLog.d(paramBitmap, 2, paramDebugCommand.toString());
        return;
      }
    }
    catch (Exception paramBitmap)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, paramBitmap.getMessage());
      }
    }
  }
  
  private void b(SnapshotService.DebugCommand arg1, SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish once debug, webview id =");
      localStringBuilder.append(SnapshotService.Snapshot.a(paramSnapshot));
      localStringBuilder.append(", seq=");
      localStringBuilder.append(???.jdField_a_of_type_Long);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("snapshotPaths", ???.jdField_a_of_type_JavaUtilArrayList);
      ((Bundle)localObject).putLong("seq", ???.jdField_a_of_type_Long);
      ((Bundle)localObject).putString("seqKey", ???.jdField_a_of_type_JavaLangString);
      ??? = paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver;
      int i;
      if (SnapshotService.Snapshot.a(paramSnapshot) > 0L) {
        i = 1;
      } else {
        i = 0;
      }
      ???.send(i, (Bundle)localObject);
    }
    synchronized (this.jdField_a_of_type_JavaUtilQueue)
    {
      if (!this.jdField_a_of_type_JavaUtilQueue.isEmpty()) {
        this.jdField_a_of_type_JavaUtilQueue.remove();
      }
      if (this.jdField_a_of_type_Long > 0L)
      {
        a(paramSnapshot);
        return;
      }
      finish();
      return;
    }
  }
  
  private void c(SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject1;
    Object localObject2;
    if ((paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getWidth() > 0) && (paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getHeight() > 0))
    {
      localObject1 = Bitmap.createBitmap(paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getWidth(), paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
      if (paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getX5WebViewExtension() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "start x5 snapshot");
        }
        a((Bitmap)localObject1, paramDebugCommand, paramSnapshot);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "start webview snapshot");
      }
      localObject2 = new Canvas((Bitmap)localObject1);
      paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.draw((Canvas)localObject2);
      if (paramDebugCommand.jdField_a_of_type_Int == 0) {
        paramDebugCommand.jdField_a_of_type_Int += 1;
      } else {
        b((Bitmap)localObject1, paramDebugCommand, paramSnapshot);
      }
      d(paramDebugCommand, paramSnapshot);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_b_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("webview width =");
      ((StringBuilder)localObject2).append(paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getWidth());
      ((StringBuilder)localObject2).append(", height=");
      ((StringBuilder)localObject2).append(paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getHeight());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.jdField_a_of_type_Long > 0L) && (paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver != null))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("debugUrl", paramSnapshot.jdField_a_of_type_JavaLangString);
      ((Bundle)localObject1).putInt("maxCount", paramDebugCommand.b);
      ((Bundle)localObject1).putLong("delay", paramSnapshot.jdField_a_of_type_Long);
      ((Bundle)localObject1).putLong("seq", paramDebugCommand.jdField_a_of_type_Long);
      ((Bundle)localObject1).putString("seqKey", paramDebugCommand.jdField_a_of_type_JavaLangString);
      paramSnapshot.jdField_a_of_type_AndroidOsResultReceiver.send(2, (Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "WebView is invalid and send to restart alive webview.");
      }
    }
    finish();
  }
  
  private void d(SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject = paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getX5WebViewExtension();
    int k = 1;
    int j;
    if (localObject != null) {
      j = 1;
    } else {
      j = 0;
    }
    int i;
    boolean bool;
    if (j != 0)
    {
      i = paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getHeight();
      if (QLog.isColorLevel())
      {
        localObject = jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("webview width =");
        localStringBuilder.append(paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getWidth());
        localStringBuilder.append(", height=");
        localStringBuilder.append(paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.getHeight());
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        localObject = jdField_b_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("webview scroll height =");
        localStringBuilder.append(i);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      localObject = paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:window.scrollBy(0, ");
      localStringBuilder.append(i);
      localStringBuilder.append(" / window.devicePixelRatio)");
      ((TouchWebView)localObject).loadUrl(localStringBuilder.toString());
      bool = false;
    }
    else
    {
      bool = paramSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview.pageDown(false);
    }
    if (j != 0) {
      i = paramDebugCommand.b;
    } else {
      i = paramDebugCommand.b + 1;
    }
    if (paramDebugCommand.jdField_a_of_type_Int < i) {
      i = 1;
    } else {
      i = 0;
    }
    if (j != 0)
    {
      j = i;
    }
    else
    {
      j = k;
      if (paramDebugCommand.jdField_a_of_type_Int > 1) {
        if ((bool) && (i != 0)) {
          j = k;
        } else {
          j = 0;
        }
      }
    }
    if (j != 0)
    {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new SnapshotService.3(this, paramDebugCommand, paramSnapshot), paramSnapshot.jdField_b_of_type_Long);
      return;
    }
    b(paramDebugCommand, paramSnapshot);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnDestroy()
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
    SnapshotService.Snapshot localSnapshot = this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
    if (localSnapshot != null) {
      localSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.c();
    }
    localSnapshot = this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
    if (localSnapshot != null) {
      localSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SnapshotService.Snapshot localSnapshot = this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
    if (localSnapshot != null) {
      localSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.b();
    }
    localSnapshot = this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
    if (localSnapshot != null) {
      localSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.b();
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
        QLog.d(jdField_b_of_type_JavaLangString, 2, "app == null");
      }
      super.finish();
    }
    ProxyConfig.a();
    this.jdField_a_of_type_JavaUtilQueue = new LinkedList();
    this.jdField_a_of_type_Long = getIntent().getLongExtra("id", -1L);
    if (this.jdField_a_of_type_Long > 0L)
    {
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot = new SnapshotService.Snapshot(this);
      if (!a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot)) {
        finish();
      }
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview, new ViewGroup.LayoutParams(-1, -1));
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot = new SnapshotService.Snapshot(this);
      if (!a(getIntent(), this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot)) {
        finish();
      }
      this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(super.getIntent());
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview, new ViewGroup.LayoutParams(-1, -1));
    }
    super.setContentView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    super.moveTaskToBack(true);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onCreate");
    }
    if (this.jdField_a_of_type_Long > 0L)
    {
      paramBundle = new IntentFilter("android.intent.action.ultimatesnapshot");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "registered receiver: android.intent.action.ultimatesnapshot");
      }
      jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_JavaLangString);
      if (!a(getIntent())) {
        finish();
      }
    }
    else
    {
      this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_JavaLangString);
      paramBundle = new SnapshotService.DebugCommand();
      paramBundle.jdField_a_of_type_Long = getIntent().getLongExtra("seq", -1L);
      paramBundle.jdField_a_of_type_JavaLangString = getIntent().getStringExtra("seqKey");
      paramBundle.b = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.jdField_a_of_type_Int = 0;
      paramBundle.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new Command seq=");
        localStringBuilder.append(paramBundle.jdField_a_of_type_Long);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      if (paramBundle.jdField_a_of_type_Long != -1L) {
        a(paramBundle, this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot);
      }
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    moveTaskToBack(true);
    long l = paramIntent.getLongExtra("id", -1L);
    Object localObject;
    if (l < 0L)
    {
      if (this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot == null)
      {
        this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot = new SnapshotService.Snapshot(this);
        this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot);
      localObject = new SnapshotService.DebugCommand();
      ((SnapshotService.DebugCommand)localObject).jdField_a_of_type_Long = paramIntent.getLongExtra("seq", -1L);
      ((SnapshotService.DebugCommand)localObject).jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("seqKey");
      ((SnapshotService.DebugCommand)localObject).b = paramIntent.getIntExtra("maxSnapshotCount", 5);
      ((SnapshotService.DebugCommand)localObject).jdField_a_of_type_Int = 0;
      ((SnapshotService.DebugCommand)localObject).jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "new Command in onNewIntent()");
        paramIntent = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new Command seq=");
        localStringBuilder.append(((SnapshotService.DebugCommand)localObject).jdField_a_of_type_Long);
        QLog.i(paramIntent, 2, localStringBuilder.toString());
      }
      if (((SnapshotService.DebugCommand)localObject).jdField_a_of_type_Long != -1L)
      {
        this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_JavaLangString);
        a((SnapshotService.DebugCommand)localObject, this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot);
      }
    }
    else
    {
      if (this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot = new SnapshotService.Snapshot(this);
        this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(super.getIntent());
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      int i = paramIntent.getIntExtra("action", 2);
      if (i != 0)
      {
        if (i != 2) {
          return;
        }
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
        if ((a(getIntent(), this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot)) && (a(getIntent())))
        {
          this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a(this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_Long = l;
        }
      }
      else if (l == this.jdField_a_of_type_Long)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_b_of_type_JavaLangString, 2, "onNewIntent(), just snapshot for loaded url");
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
        ((SnapshotService.Snapshot)localObject).jdField_a_of_type_Long = 1000L;
        ((SnapshotService.Snapshot)localObject).jdField_b_of_type_Long = 1000L;
        a(paramIntent);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    SnapshotService.Snapshot localSnapshot = this.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
    if (localSnapshot != null) {
      localSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a();
    }
    localSnapshot = this.jdField_b_of_type_ComTencentMobileqqUnifiedebugSnapshotService$Snapshot;
    if (localSnapshot != null) {
      localSnapshot.jdField_a_of_type_ComTencentMobileqqUnifiedebugSnapshotService$SnapShotWebView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */