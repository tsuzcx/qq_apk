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
  public static String b = "try{document.querySelectorAll('video,audio').forEach(function(item){item.autoplay=false;item.pause();});[HTMLAudioElement, HTMLVideoElement].forEach(function(i){i.prototype.play=function(){}})}catch(err){console.log(err.message)}";
  private static String c = "SnapshotService";
  private static boolean d = false;
  public Handler a = new Handler();
  private AppInterface e;
  private RelativeLayout f;
  private SnapshotService.Snapshot g;
  private SnapshotService.Snapshot h;
  private Queue<SnapshotService.DebugCommand> i;
  private long j;
  private BroadcastReceiver k = new SnapshotService.4(this);
  
  private void a(Bitmap paramBitmap, SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    if ((paramSnapshot != null) && (paramSnapshot.a != null) && (paramSnapshot.a.mWebview.getX5WebViewExtension() != null))
    {
      Object localObject1 = paramSnapshot.a.mWebview.getX5WebViewExtension().getClass().getInterfaces();
      int i1 = localObject1.length;
      int n = 0;
      int m = 0;
      while (m < i1)
      {
        Object localObject2 = localObject1[m];
        if ("com.tencent.smtt.export.internal.interfaces.IX5WebView".equals(((Class)localObject2).getName()))
        {
          try
          {
            localObject1 = ((Class)localObject2).getDeclaredMethod("snapshotVisibleWithBitmap", new Class[] { Bitmap.class, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Boolean.TYPE, Float.TYPE, Float.TYPE, Runnable.class });
            if (QLog.isColorLevel()) {
              QLog.i(c, 2, "call snapshotVisibleWithBitmap");
            }
            localObject2 = paramSnapshot.a.mWebview.getX5WebViewExtension();
            try
            {
              ((Method)localObject1).invoke(localObject2, new Object[] { paramBitmap, Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), Integer.valueOf(1), Integer.valueOf(1), new SnapshotService.2(this, paramBitmap, paramDebugCommand, paramSnapshot) });
              m = 1;
            }
            catch (Exception paramBitmap) {}
            m = n;
          }
          catch (Exception paramBitmap) {}
          if (!QLog.isColorLevel()) {
            break label331;
          }
          localObject1 = c;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("call snapshotVisibleWithBitmap failed: ");
          ((StringBuilder)localObject2).append(paramBitmap.getMessage());
          QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          m = n;
          break label331;
        }
        m += 1;
      }
      m = n;
      label331:
      if (m == 0)
      {
        if (paramSnapshot.b != null)
        {
          paramBitmap = new Bundle();
          paramBitmap.putLong("seq", paramDebugCommand.a);
          paramSnapshot.b.send(3, paramBitmap);
        }
        finish();
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "snapshotVisibleWithBitmap: null");
    }
  }
  
  private void a(SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    this.a.postDelayed(new SnapshotService.1(this, paramSnapshot, paramDebugCommand), paramSnapshot.d);
  }
  
  private void a(SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mQueue size = ");
      ((StringBuilder)localObject2).append(this.i.size());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = (SnapshotService.DebugCommand)this.i.peek();
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("current cmd=");
        localStringBuilder.append(((SnapshotService.DebugCommand)localObject1).a);
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      a((SnapshotService.DebugCommand)localObject1, paramSnapshot);
    }
  }
  
  public static boolean a()
  {
    return d;
  }
  
  private boolean a(Intent arg1)
  {
    SnapshotService.DebugCommand localDebugCommand = new SnapshotService.DebugCommand();
    localDebugCommand.a = ???.getLongExtra("seq", -1L);
    localDebugCommand.b = ???.getStringExtra("seqKey");
    localDebugCommand.d = ???.getIntExtra("maxSnapshotCount", 5);
    localDebugCommand.c = 0;
    localDebugCommand.e = new ArrayList();
    if (QLog.isColorLevel())
    {
      ??? = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new Command seq=");
      localStringBuilder.append(localDebugCommand.a);
      QLog.i(???, 2, localStringBuilder.toString());
    }
    if (localDebugCommand.a == -1L) {
      return false;
    }
    synchronized (this.i)
    {
      if (this.i.isEmpty())
      {
        this.i.offer(localDebugCommand);
        a(this.g);
      }
      else
      {
        this.i.offer(localDebugCommand);
      }
      return true;
    }
  }
  
  private boolean a(Intent paramIntent, SnapshotService.Snapshot paramSnapshot)
  {
    SnapshotService.Snapshot.a(paramSnapshot, paramIntent.getLongExtra("id", -1L));
    paramSnapshot.b = ((ResultReceiver)paramIntent.getParcelableExtra("callback"));
    paramSnapshot.d = paramIntent.getLongExtra("delay", 10000L);
    paramSnapshot.e = 3000L;
    paramSnapshot.c = paramIntent.getStringExtra("debugUrl");
    if (!TextUtils.isEmpty(paramSnapshot.c))
    {
      paramIntent = new StringBuilder();
      paramIntent.append(SnapshotService.Snapshot.a(paramSnapshot));
      paramIntent.append(MD5Utils.toMD5(paramSnapshot.c));
      paramSnapshot.f = paramIntent.toString();
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
      localStringBuilder.append(paramSnapshot.f);
      localStringBuilder.append("_");
      int m = paramDebugCommand.c;
      paramDebugCommand.c = (m + 1);
      localStringBuilder.append(m);
      localStringBuilder.append(".png");
      paramSnapshot = new File((File)localObject, localStringBuilder.toString());
      localObject = new FileOutputStream(paramSnapshot);
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject);
      ((OutputStream)localObject).flush();
      ((OutputStream)localObject).close();
      paramBitmap.recycle();
      paramDebugCommand.e.add(paramSnapshot.getAbsolutePath());
      if (QLog.isColorLevel())
      {
        paramBitmap = c;
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
        QLog.e(c, 2, paramBitmap.getMessage());
      }
    }
  }
  
  private void b(SnapshotService.DebugCommand arg1, SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("finish once debug, webview id =");
      localStringBuilder.append(SnapshotService.Snapshot.a(paramSnapshot));
      localStringBuilder.append(", seq=");
      localStringBuilder.append(???.a);
      QLog.i((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramSnapshot.b != null)
    {
      localObject = new Bundle();
      ((Bundle)localObject).putStringArrayList("snapshotPaths", ???.e);
      ((Bundle)localObject).putLong("seq", ???.a);
      ((Bundle)localObject).putString("seqKey", ???.b);
      ??? = paramSnapshot.b;
      int m;
      if (SnapshotService.Snapshot.a(paramSnapshot) > 0L) {
        m = 1;
      } else {
        m = 0;
      }
      ???.send(m, (Bundle)localObject);
    }
    synchronized (this.i)
    {
      if (!this.i.isEmpty()) {
        this.i.remove();
      }
      if (this.j > 0L)
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
    if ((paramSnapshot.a.mWebview.getWidth() > 0) && (paramSnapshot.a.mWebview.getHeight() > 0))
    {
      localObject1 = Bitmap.createBitmap(paramSnapshot.a.mWebview.getWidth(), paramSnapshot.a.mWebview.getHeight(), Bitmap.Config.ARGB_8888);
      if (paramSnapshot.a.mWebview.getX5WebViewExtension() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(c, 2, "start x5 snapshot");
        }
        a((Bitmap)localObject1, paramDebugCommand, paramSnapshot);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "start webview snapshot");
      }
      localObject2 = new Canvas((Bitmap)localObject1);
      paramSnapshot.a.mWebview.draw((Canvas)localObject2);
      if (paramDebugCommand.c == 0) {
        paramDebugCommand.c += 1;
      } else {
        b((Bitmap)localObject1, paramDebugCommand, paramSnapshot);
      }
      d(paramDebugCommand, paramSnapshot);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = c;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("webview width =");
      ((StringBuilder)localObject2).append(paramSnapshot.a.mWebview.getWidth());
      ((StringBuilder)localObject2).append(", height=");
      ((StringBuilder)localObject2).append(paramSnapshot.a.mWebview.getHeight());
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.j > 0L) && (paramSnapshot.b != null))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("debugUrl", paramSnapshot.c);
      ((Bundle)localObject1).putInt("maxCount", paramDebugCommand.d);
      ((Bundle)localObject1).putLong("delay", paramSnapshot.d);
      ((Bundle)localObject1).putLong("seq", paramDebugCommand.a);
      ((Bundle)localObject1).putString("seqKey", paramDebugCommand.b);
      paramSnapshot.b.send(2, (Bundle)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "WebView is invalid and send to restart alive webview.");
      }
    }
    finish();
  }
  
  private void d(SnapshotService.DebugCommand paramDebugCommand, SnapshotService.Snapshot paramSnapshot)
  {
    Object localObject = paramSnapshot.a.mWebview.getX5WebViewExtension();
    int i1 = 1;
    int n;
    if (localObject != null) {
      n = 1;
    } else {
      n = 0;
    }
    int m;
    boolean bool;
    if (n != 0)
    {
      m = paramSnapshot.a.mWebview.getHeight();
      if (QLog.isColorLevel())
      {
        localObject = c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("webview width =");
        localStringBuilder.append(paramSnapshot.a.mWebview.getWidth());
        localStringBuilder.append(", height=");
        localStringBuilder.append(paramSnapshot.a.mWebview.getHeight());
        QLog.i((String)localObject, 2, localStringBuilder.toString());
        localObject = c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("webview scroll height =");
        localStringBuilder.append(m);
        QLog.i((String)localObject, 2, localStringBuilder.toString());
      }
      localObject = paramSnapshot.a.mWebview;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("javascript:window.scrollBy(0, ");
      localStringBuilder.append(m);
      localStringBuilder.append(" / window.devicePixelRatio)");
      ((TouchWebView)localObject).loadUrl(localStringBuilder.toString());
      bool = false;
    }
    else
    {
      bool = paramSnapshot.a.mWebview.pageDown(false);
    }
    if (n != 0) {
      m = paramDebugCommand.d;
    } else {
      m = paramDebugCommand.d + 1;
    }
    if (paramDebugCommand.c < m) {
      m = 1;
    } else {
      m = 0;
    }
    if (n != 0)
    {
      n = m;
    }
    else
    {
      n = i1;
      if (paramDebugCommand.c > 1) {
        if ((bool) && (m != 0)) {
          n = i1;
        } else {
          n = 0;
        }
      }
    }
    if (n != 0)
    {
      this.a.postDelayed(new SnapshotService.3(this, paramDebugCommand, paramSnapshot), paramSnapshot.e);
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
      QLog.i(c, 2, "in onDestroy method()");
    }
    if (this.j > 0L)
    {
      unregisterReceiver(this.k);
      d = false;
    }
    this.a.removeCallbacksAndMessages(null);
    this.i.clear();
    super.doOnDestroy();
    SnapshotService.Snapshot localSnapshot = this.g;
    if (localSnapshot != null) {
      localSnapshot.a.c();
    }
    localSnapshot = this.h;
    if (localSnapshot != null) {
      localSnapshot.a.c();
    }
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    SnapshotService.Snapshot localSnapshot = this.g;
    if (localSnapshot != null) {
      localSnapshot.a.b();
    }
    localSnapshot = this.h;
    if (localSnapshot != null) {
      localSnapshot.a.b();
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
    this.f = new RelativeLayout(this);
    paramBundle = MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    if ((paramBundle instanceof AppInterface)) {
      this.e = ((AppInterface)paramBundle);
    }
    if (this.e == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(c, 2, "app == null");
      }
      super.finish();
    }
    ProxyConfig.a();
    this.i = new LinkedList();
    this.j = getIntent().getLongExtra("id", -1L);
    if (this.j > 0L)
    {
      this.g = new SnapshotService.Snapshot(this);
      if (!a(getIntent(), this.g)) {
        finish();
      }
      this.g.a = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.e);
      this.g.a.a(super.getIntent());
      this.f.addView(this.g.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
    }
    else
    {
      this.h = new SnapshotService.Snapshot(this);
      if (!a(getIntent(), this.h)) {
        finish();
      }
      this.h.a = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.e);
      this.h.a.a(super.getIntent());
      this.f.addView(this.h.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
    }
    super.setContentView(this.f);
    super.moveTaskToBack(true);
    if (QLog.isColorLevel()) {
      QLog.i(c, 2, "new Command in onCreate");
    }
    if (this.j > 0L)
    {
      paramBundle = new IntentFilter("android.intent.action.ultimatesnapshot");
      registerReceiver(this.k, paramBundle);
      if (QLog.isColorLevel()) {
        QLog.i(c, 2, "registered receiver: android.intent.action.ultimatesnapshot");
      }
      d = true;
      this.g.a.a(this.g.c);
      if (!a(getIntent())) {
        finish();
      }
    }
    else
    {
      this.h.a.a(this.h.c);
      paramBundle = new SnapshotService.DebugCommand();
      paramBundle.a = getIntent().getLongExtra("seq", -1L);
      paramBundle.b = getIntent().getStringExtra("seqKey");
      paramBundle.d = getIntent().getIntExtra("maxSnapshotCount", 5);
      paramBundle.c = 0;
      paramBundle.e = new ArrayList();
      if (QLog.isColorLevel())
      {
        String str = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new Command seq=");
        localStringBuilder.append(paramBundle.a);
        QLog.i(str, 2, localStringBuilder.toString());
      }
      if (paramBundle.a != -1L) {
        a(paramBundle, this.h);
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
      if (this.h == null)
      {
        this.h = new SnapshotService.Snapshot(this);
        this.h.a = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.e);
        this.h.a.a(super.getIntent());
        this.f.addView(this.h.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      a(paramIntent, this.h);
      localObject = new SnapshotService.DebugCommand();
      ((SnapshotService.DebugCommand)localObject).a = paramIntent.getLongExtra("seq", -1L);
      ((SnapshotService.DebugCommand)localObject).b = paramIntent.getStringExtra("seqKey");
      ((SnapshotService.DebugCommand)localObject).d = paramIntent.getIntExtra("maxSnapshotCount", 5);
      ((SnapshotService.DebugCommand)localObject).c = 0;
      ((SnapshotService.DebugCommand)localObject).e = new ArrayList();
      if (QLog.isColorLevel())
      {
        QLog.i(c, 2, "new Command in onNewIntent()");
        paramIntent = c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new Command seq=");
        localStringBuilder.append(((SnapshotService.DebugCommand)localObject).a);
        QLog.i(paramIntent, 2, localStringBuilder.toString());
      }
      if (((SnapshotService.DebugCommand)localObject).a != -1L)
      {
        this.h.a.a(this.h.c);
        a((SnapshotService.DebugCommand)localObject, this.h);
      }
    }
    else
    {
      if (this.g == null)
      {
        this.g = new SnapshotService.Snapshot(this);
        this.g.a = new SnapshotService.SnapShotWebView(getBaseContext(), this, this.e);
        this.g.a.a(super.getIntent());
        this.f.addView(this.g.a.mWebview, new ViewGroup.LayoutParams(-1, -1));
      }
      int m = paramIntent.getIntExtra("action", 2);
      if (m != 0)
      {
        if (m != 2) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i(c, 2, "onNewIntent(), load url");
        }
        if (!d)
        {
          paramIntent = new IntentFilter("android.intent.action.ultimatesnapshot");
          registerReceiver(this.k, paramIntent);
          if (QLog.isColorLevel()) {
            QLog.i(c, 2, "registered receiver: android.intent.action.ultimatesnapshot");
          }
        }
        d = true;
        if ((a(getIntent(), this.g)) && (a(getIntent())))
        {
          this.g.a.a(this.g.c);
          this.j = l;
        }
      }
      else if (l == this.j)
      {
        if (QLog.isColorLevel()) {
          QLog.i(c, 2, "onNewIntent(), just snapshot for loaded url");
        }
        localObject = this.g;
        ((SnapshotService.Snapshot)localObject).d = 1000L;
        ((SnapshotService.Snapshot)localObject).e = 1000L;
        a(paramIntent);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    SnapshotService.Snapshot localSnapshot = this.g;
    if (localSnapshot != null) {
      localSnapshot.a.a();
    }
    localSnapshot = this.h;
    if (localSnapshot != null) {
      localSnapshot.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.unifiedebug.SnapshotService
 * JD-Core Version:    0.7.0.1
 */