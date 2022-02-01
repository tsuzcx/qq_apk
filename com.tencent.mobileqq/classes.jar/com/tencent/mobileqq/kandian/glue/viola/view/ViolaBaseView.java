package com.tencent.mobileqq.kandian.glue.viola.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import androidx.fragment.app.Fragment;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.util.RIJBlackWhiteModeHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.wormhole.WormholeManager;
import com.tencent.common.wormhole.action.IClientEngine;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInjoyWebRenderSoLoader;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.viola.CommonSuspensionGestureLayout.ContentScrollListener;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.glue.viola.ViolaBizLibHandler;
import com.tencent.mobileqq.kandian.glue.viola.ViolaLibHandler;
import com.tencent.mobileqq.kandian.glue.viola.adapter.BridgeAdapter;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ViolaReportDelegate;
import com.tencent.mobileqq.kandian.glue.viola.adapter.ui.ComponentAdapter;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.wormhole.NativeVueStatusInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.open.base.http.HttpCgiAsyncTask;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.IActivityState;
import com.tencent.viola.core.ViolaEnvironment;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.core.ViolaRenderContainer;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.core.ViolaSDKManager;
import com.tencent.viola.utils.ViolaUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

public class ViolaBaseView
  extends RelativeLayout
  implements IClientEngine, IViolaBaseView, CommonSuspensionGestureLayout.ContentScrollListener, IActivityState
{
  private static int O = 0;
  private static int P = 1;
  public static boolean b = false;
  private long A = 0L;
  private boolean B = false;
  private boolean C = false;
  private ViolaBaseView.OnBaseViewListener D;
  private boolean E;
  private NativeVueStatusInfo F = new NativeVueStatusInfo();
  private Set<String> G;
  private int H = 0;
  private int I;
  private int J;
  private boolean K;
  private Runnable L;
  private Function1<Canvas, Unit> M = new ViolaBaseView.2(this);
  private Function1<Canvas, Unit> N = new ViolaBaseView.3(this);
  public String a;
  private ViolaBaseView.MyHandler c;
  private String d;
  private String e;
  private String f;
  private int g;
  private RIJTransMergeKanDianReport.ReportR5Builder h;
  private ViolaBaseView.ViolaCreactPageObject i;
  private IViolaBaseView.ViolaViewListener j;
  private ViolaInstance k;
  private FPSCalculator.GetFPSListener l;
  private Fragment m;
  private boolean n = false;
  private boolean o = false;
  private boolean p = false;
  private ViolaReportDelegate q;
  private boolean r = false;
  private boolean s = true;
  private int t = 0;
  private boolean u = false;
  private boolean v = false;
  private boolean w = true;
  private long x;
  private long y;
  private double z = 0.0D;
  
  public ViolaBaseView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public ViolaBaseView(Context paramContext, Boolean paramBoolean)
  {
    super(paramContext);
    a(paramContext);
    this.n = paramBoolean.booleanValue();
  }
  
  private void A()
  {
    this.k.renderJSSource(this.d, this.i.e(), ViolaBizUtils.d(this.a));
    if (this.m == null) {
      j();
    }
    w();
    if (!this.n) {
      a(true);
    }
    if (this.p) {
      this.k.onActivityResume();
    }
    Object localObject = this.G;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.k.updateInstance(str);
      }
      this.G.clear();
    }
  }
  
  private void B()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start renderNativeVue, url: ");
      localStringBuilder.append(this.a);
      QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
    }
    NativeVueLoaderManager.a().a(this.i.e(), this.d, this.a, new ViolaBaseView.24(this));
  }
  
  private void a(int paramInt)
  {
    if (paramInt == O)
    {
      this.q.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.x = System.currentTimeMillis();
    }
    NativeVueLoaderManager.a().c();
    ViolaSoLoaderManager localViolaSoLoaderManager = ViolaSoLoaderManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ViolaBaseView_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    localViolaSoLoaderManager.a(localStringBuilder.toString(), new ViolaBaseView.4(this, paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.B) && (paramBoolean))
    {
      if (this.v) {
        return;
      }
      this.B = true;
      if (this.j != null) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
          new Handler(Looper.getMainLooper()).post(new ViolaBaseView.18(this, paramInt));
        } else {
          this.j.a(paramInt);
        }
      }
      if (paramInt == 100)
      {
        this.q.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.a);
      }
      else if (paramInt == 1)
      {
        this.q.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.a);
      }
      else if (paramInt == 5)
      {
        this.q.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.q.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.a);
      }
      else if (paramInt == 7)
      {
        this.q.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.a);
      }
      else if (paramInt == 8)
      {
        this.q.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.a);
      }
      else if (paramInt == 6)
      {
        this.q.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.a);
      }
      else if (paramInt == 9)
      {
        this.q.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.a);
      }
      else if (paramInt == 3)
      {
        this.q.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.a);
      }
      else if (paramInt == 2)
      {
        this.q.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.a);
      }
      else if (paramInt == 10)
      {
        this.q.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.q.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.q.reportData(this.a);
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.a);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openViolaPage error,code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",biz url=");
      localStringBuilder.append(this.a);
      QLog.e("ViolaBaseView", 2, localStringBuilder.toString());
    }
  }
  
  private void a(Context paramContext)
  {
    this.c = new ViolaBaseView.MyHandler(this, Looper.getMainLooper());
    this.g = Math.abs(new Random().nextInt());
    if ("1".equals(Aladdin.getConfig(420).getString("is_show_net_detail", "")))
    {
      b = true;
      return;
    }
    b = false;
  }
  
  private void a(String paramString, ViolaBaseView.LoadAsyBack paramLoadAsyBack)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramString.startsWith("http")) {
        return;
      }
      String str = Uri.parse(paramString).getQueryParameter("v_bid");
      if (TextUtils.isEmpty(str)) {
        return;
      }
      ViolaAccessHelper.a(str, new ViolaBaseView.8(this, str, paramString, paramLoadAsyBack));
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.d = paramString;
      if (paramBoolean)
      {
        this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.q.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.A));
        v();
      }
      if (!paramBoolean) {
        z();
      }
    }
    else
    {
      a(3, paramBoolean);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.j != null) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.17(this, paramInt));
      } else {
        this.j.b(paramInt);
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openViolaPage process,code=");
    localStringBuilder.append(paramInt);
    QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
  }
  
  private void b(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.a))
    {
      a(2, paramBoolean);
      return;
    }
    this.A = System.currentTimeMillis();
    if (paramBoolean) {
      this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
    }
    if ((this.a.contains("v_tid")) && (this.a.contains("v_bundleName")))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadJSSource process from judgeIfNeedCgi v_tid url: ");
        localStringBuilder.append(this.a);
        QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
      }
      d(paramBoolean);
      return;
    }
    this.e = this.a;
    e(paramBoolean);
    f(paramBoolean);
  }
  
  private void c(int paramInt)
  {
    a(paramInt, true);
  }
  
  private void c(String paramString)
  {
    if (!ReadInjoyWebRenderSoLoader.a(paramString))
    {
      c(7);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaBaseView", 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    else
    {
      if ((ViolaLibHandler.w()) && (ViolaBizLibHandler.x()))
      {
        a(P);
        return;
      }
      c(8);
      if (QLog.isColorLevel()) {
        QLog.e("ViolaBaseView", 2, "downLoadSOFromOffline so.zip succ but not Exist");
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean) {
      this.q.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    localStringBuilder.append(ViolaBizUtils.e());
    ViolaAccessHelper.a(localStringBuilder.toString(), new ViolaBaseView.6(this, paramBoolean, l1));
    a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new ViolaBaseView.7(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void d(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (RIJQQAppInterfaceUtil.e() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ViolaBaseView", 2, "checkOfflineUpNotCallback.");
      }
      ThreadManager.post(new ViolaBaseView.11(this, paramString), 8, null, true);
    }
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.q.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.a);
    localStringBuilder2.append("&v_sdk=");
    localStringBuilder2.append("8.8.17");
    localStringBuilder2.append("&v_appid=1&v_uid=");
    localStringBuilder2.append(RIJQQAppInterfaceUtil.d());
    localStringBuilder2.append("&v_platform=1");
    localStringBuilder1.append(URLEncoder.encode(localStringBuilder2.toString()));
    new HttpCgiAsyncTask(localStringBuilder1.toString(), "GET", new ViolaBaseView.19(this, paramBoolean)).a(localBundle);
  }
  
  private void e(String paramString)
  {
    if (this.k == null) {
      return;
    }
    if (this.v) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.k.renderVueDomDirectly(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ViolaBaseView", 2, "render VueDom");
      }
    }
    A();
  }
  
  private void e(boolean paramBoolean)
  {
    ViolaAccessHelper.a(this.e, new ViolaBaseView.20(this, paramBoolean));
  }
  
  private void f(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    a(this.a, new ViolaBaseView.21(this, paramBoolean, l1));
  }
  
  private void g(boolean paramBoolean)
  {
    ViolaBaseView.OnBaseViewListener localOnBaseViewListener = this.D;
    if (localOnBaseViewListener != null) {
      localOnBaseViewListener.c();
    }
    a(9, paramBoolean);
  }
  
  private boolean l()
  {
    ViolaBaseView.ViolaCreactPageObject localViolaCreactPageObject = this.i;
    return (localViolaCreactPageObject != null) && (localViolaCreactPageObject.b());
  }
  
  private void m()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.o = true;
      b(1);
      ViolaBaseView.OnBaseViewListener localOnBaseViewListener = this.D;
      if (localOnBaseViewListener != null) {
        localOnBaseViewListener.a();
      }
      this.o = true;
      v();
      return;
    }
    if (TextUtils.isEmpty(this.f))
    {
      b(0);
      o();
      return;
    }
    ThreadManager.post(new ViolaBaseView.5(this, (QQAppInterface)RIJQQAppInterfaceUtil.e()), 8, null, true);
  }
  
  private void n()
  {
    this.w = true;
    this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.d = ViolaAccessHelper.b(this.a);
    if (ViolaAccessHelper.f()) {
      this.d = ViolaAccessHelper.g(this.a);
    }
    Object localObject;
    if (!TextUtils.isEmpty(this.d))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadJSSource process from v_bid url: ");
        ((StringBuilder)localObject).append(this.a);
        QLog.d("ViolaBaseView", 2, ((StringBuilder)localObject).toString());
      }
      this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
      v();
      return;
    }
    if (!TextUtils.isEmpty(this.a))
    {
      this.w = false;
      if (this.a.contains("v_debug_test=1"))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadJSSource process from cgi debugVersion url: ");
          ((StringBuilder)localObject).append(this.a);
          QLog.d("ViolaBaseView", 2, ((StringBuilder)localObject).toString());
        }
        b(true);
        return;
      }
      StringBuilder localStringBuilder1;
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_");
        ((StringBuilder)localObject).append(ViolaUtils.getPageName(this.a));
        ((StringBuilder)localObject).append("_");
        ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
        localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("read cached jsSource when oom url: ");
        localStringBuilder2.append(this.a);
        localStringBuilder2.append(",error:");
        localStringBuilder2.append(localOutOfMemoryError.getMessage());
        QLog.e("ViolaBaseView", 2, localStringBuilder2.toString());
        localStringBuilder1 = null;
      }
      if ((localStringBuilder1 instanceof String))
      {
        this.d = ((String)localStringBuilder1);
        if (!TextUtils.isEmpty(this.d))
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("loadJSSource process from cgi cache url: ");
            localStringBuilder1.append(this.a);
            QLog.d("ViolaBaseView", 2, localStringBuilder1.toString());
          }
          this.q.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
          v();
          return;
        }
        if (QLog.isColorLevel())
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("loadJSSource process from cgi no cache url: ");
          localStringBuilder1.append(this.a);
          QLog.d("ViolaBaseView", 2, localStringBuilder1.toString());
        }
        b(true);
        return;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("loadJSSource process from cgi no cache1 url: ");
        localStringBuilder1.append(this.a);
        QLog.d("ViolaBaseView", 2, localStringBuilder1.toString());
      }
      b(true);
      return;
    }
    QLog.d("ViolaBaseView", 2, "loadJSSource mOriginalJsUrl is empty!!!");
  }
  
  private void o()
  {
    this.q.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.f = ViolaAccessHelper.b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.f))
    {
      this.q.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.c.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.d());
    localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
    if ((localObject instanceof String))
    {
      this.f = ((String)localObject);
      if (!TextUtils.isEmpty(this.f))
      {
        this.q.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.c.sendEmptyMessageDelayed(3, 0L);
        return;
      }
      c(true);
      return;
    }
    c(true);
  }
  
  private void p()
  {
    ThreadManager.post(new ViolaBaseView.9(this), 8, null, true);
  }
  
  private void q()
  {
    String str1 = ViolaSoLoaderManager.a.a().j();
    String str2 = Uri.parse(str1).getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str2)) {
      return;
    }
    Object localObject = ViolaBizUtils.b(str1);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("downLoadSOFromOffline so.zip exists [url:");
        localStringBuilder.append(str1);
        localStringBuilder.append("]");
        QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
      }
      c((String)localObject);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("downLoadSOFromOffline so.zip not exists [url:");
        ((StringBuilder)localObject).append(str1);
        ((StringBuilder)localObject).append("],try load from cdn");
        QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject).toString());
      }
      p();
    }
    ViolaAccessHelper.a(str2, new ViolaBaseView.10(this));
  }
  
  private void r()
  {
    if (this.H >= 2) {
      return;
    }
    Object localObject1;
    if (this.E)
    {
      localObject1 = this.D;
      if (localObject1 != null)
      {
        ((ViolaBaseView.OnBaseViewListener)localObject1).a(this.d);
        return;
      }
    }
    ViolaRenderContainer localViolaRenderContainer = new ViolaRenderContainer(getContext());
    addView(localViolaRenderContainer);
    u();
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new BridgeAdapter());
        if (this.k == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.m != null)
          {
            localObject1 = new WeakReference(this.m.getActivity());
            if (this.m == null) {
              break label235;
            }
            localObject3 = new WeakReference(this.m);
            this.k = new ViolaInstance(localBaseApplicationImpl, (WeakReference)localObject1, (WeakReference)localObject3, null, -1L, this.a, this.i.c());
          }
        }
        else
        {
          this.k.setRenderContainer(localViolaRenderContainer);
          this.k.setViolaPageListener(new ViolaBaseView.12(this));
          s();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("initViola Exception ");
          ((StringBuilder)localObject3).append(localThrowable.getMessage());
          QLog.e("ViolaBaseView", 1, ((StringBuilder)localObject3).toString());
        }
        return;
      }
      Object localObject2 = null;
      continue;
      label235:
      Object localObject3 = null;
    }
  }
  
  private void s()
  {
    if ((!TextUtils.isEmpty(this.a)) && (this.i != null))
    {
      this.H = 2;
      y();
      if (this.F.a()) {
        B();
      } else {
        A();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ViolaBaseView", 2, "dealRenderJs");
      }
    }
  }
  
  private void t()
  {
    ThreadManager.post(new ViolaBaseView.13(this), 8, null, true);
  }
  
  private void u()
  {
    addOnLayoutChangeListener(new ViolaBaseView.14(this));
  }
  
  private void v()
  {
    if ((!TextUtils.isEmpty(this.d)) && (this.o))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.15(this));
      } else {
        r();
      }
      ViolaAccessHelper.b(this.a, this.d);
      return;
    }
    if (TextUtils.isEmpty(this.d))
    {
      b(2);
      return;
    }
    if (!this.o)
    {
      b(3);
      m();
    }
  }
  
  private void w()
  {
    if (this.j == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.16(this));
    } else {
      this.j.a();
    }
    QLog.d("ViolaBaseView", 2, "openViolaPage success!");
  }
  
  private void x()
  {
    ViolaAccessHelper.a += 1;
    this.B = false;
    this.q.a(this.g, this.a);
  }
  
  private void y()
  {
    this.k.mRenderJsStartTime = System.currentTimeMillis();
    this.k.mPageStartTime = this.y;
  }
  
  private void z()
  {
    ThreadManager.post(new ViolaBaseView.22(this), 8, null, true);
  }
  
  public void a(IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.j = paramViolaViewListener;
    this.y = System.currentTimeMillis();
    x();
    if (!this.s)
    {
      c(11);
      return;
    }
    a(O);
  }
  
  public void a(String paramString)
  {
    if ((this.k != null) && (ViolaSDKEngine.isInitialized()) && (!this.k.isDestroy()))
    {
      this.k.updateInstance(paramString);
      return;
    }
    if ((this.k == null) || (!ViolaSDKEngine.isInitialized()))
    {
      if (this.G == null) {
        this.G = new HashSet();
      }
      this.G.add(paramString);
    }
  }
  
  public void a(@Nullable String paramString, @Nullable Fragment paramFragment, @Nullable IViolaBaseView.ViolaCreactPageObject paramViolaCreactPageObject)
  {
    if (paramViolaCreactPageObject != null)
    {
      a(paramString, paramFragment, new ViolaBaseView.ViolaCreactPageObject(paramViolaCreactPageObject.a(), paramViolaCreactPageObject.b(), paramViolaCreactPageObject.c(), paramViolaCreactPageObject.d(), paramViolaCreactPageObject.e()));
      return;
    }
    a(paramString, paramFragment, null);
  }
  
  public void a(String paramString, Fragment paramFragment, ViolaBaseView.ViolaCreactPageObject paramViolaCreactPageObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("VideoFeeds.js")))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      PublicAccountReportUtils.a(null, null, "0X800AF0D", "0X800AF0D", 0, 0, null, null, null, localStringBuilder.toString(), false);
    }
    this.m = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof ViolaReportDelegate))
    {
      this.q = ((ViolaReportDelegate)ViolaSDKManager.getInstance().getReportDelegate());
    }
    else
    {
      this.q = new ViolaReportDelegate();
      ViolaSDKManager.getInstance().setReportDelegate(this.q);
    }
    this.a = paramString;
    this.i = paramViolaCreactPageObject;
    this.h = new RIJTransMergeKanDianReport.ReportR5Builder().addStringNotThrow("url", this.a);
    this.s = Build.CPU_ABI.contains("arm");
    x();
    if (TextUtils.isEmpty(paramString))
    {
      c(4);
      return;
    }
    if (!this.s)
    {
      c(11);
      return;
    }
    this.F.a(NativeVueLoaderManager.a(paramString));
    a(O);
  }
  
  public void a(String paramString, HippyMap paramHippyMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put(paramString, paramHippyMap.toJSONObject());
      this.k.updateInstance(localJSONObject.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramHippyMap = new StringBuilder();
      paramHippyMap.append("wormhole sendEvent error:");
      paramHippyMap.append(paramString.getMessage());
      QLog.e("ViolaBaseView", 2, paramHippyMap.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.k != null) && (ViolaSDKEngine.isInitialized()) && (!this.k.isDestroy())) {
      if (paramBoolean)
      {
        if (!this.r)
        {
          this.k.updateInstance(ViolaBizUtils.b().toString());
          this.k.setPageVisibility(true);
          this.r = true;
          g();
        }
      }
      else
      {
        if (this.r)
        {
          this.k.updateInstance(ViolaBizUtils.c().toString());
          this.k.setPageVisibility(false);
          this.r = false;
          h();
        }
        if ((ViolaSDKManager.getInstance().getComponentAdapter() instanceof ComponentAdapter)) {
          ((ComponentAdapter)ViolaSDKManager.getInstance().getComponentAdapter()).a();
        }
      }
    }
  }
  
  public boolean a()
  {
    return b();
  }
  
  public <T> T b(String paramString)
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance == null) {
      return null;
    }
    return localViolaInstance.getModule(paramString);
  }
  
  public boolean b()
  {
    return this.H >= 3;
  }
  
  public boolean c()
  {
    return this.H >= 2;
  }
  
  public void d()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityBack();
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (l())
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.N);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!b) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.L == null) {
      this.L = new ViolaBaseView.1(this);
    }
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    int i3 = paramMotionEvent.getAction();
    if (i3 != 0)
    {
      if (i3 != 1) {
        if (i3 != 2)
        {
          if (i3 != 3) {
            break label173;
          }
        }
        else
        {
          if ((this.K) || ((Math.abs(this.I - i1) <= 20) && (Math.abs(this.J - i2) <= 20))) {
            break label173;
          }
          this.K = true;
          removeCallbacks(this.L);
          break label173;
        }
      }
      removeCallbacks(this.L);
    }
    else
    {
      this.I = i1;
      this.J = i2;
      this.K = false;
      postDelayed(this.L, ViewConfiguration.getLongPressTimeout() * 6);
    }
    label173:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (l())
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.M);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean e()
  {
    ViolaInstance localViolaInstance = this.k;
    return (localViolaInstance != null) && (localViolaInstance.consumeBackKeyEvent());
  }
  
  public void f()
  {
    if (!this.C)
    {
      this.C = true;
      this.q.a();
    }
  }
  
  public void g()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.updateCurrentPageInstance();
    }
  }
  
  public int getFromType()
  {
    ViolaBaseView.ViolaCreactPageObject localViolaCreactPageObject = this.i;
    if ((localViolaCreactPageObject != null) && (ViolaBaseView.ViolaCreactPageObject.a(localViolaCreactPageObject) != null) && (ViolaBaseView.ViolaCreactPageObject.a(this.i).has("fromType"))) {
      try
      {
        int i1 = ViolaBaseView.ViolaCreactPageObject.a(this.i).getInt("fromType");
        return i1;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFromType error  url: ");
        localStringBuilder.append(this.a);
        localStringBuilder.append(" , error msg :");
        localStringBuilder.append(localException.getMessage());
        QLog.e("ViolaBaseView", 2, localStringBuilder.toString());
      }
    }
    return 100;
  }
  
  public int getPositionState()
  {
    if ((b()) && (this.u)) {
      return this.t;
    }
    return 1;
  }
  
  public int getRootId()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance == null) {
      return -10076;
    }
    return Integer.valueOf(localViolaInstance.getInstanceId()).intValue() + 10076;
  }
  
  @NonNull
  public View getView()
  {
    return this;
  }
  
  public String getViolaInstanceId()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      return localViolaInstance.getInstanceId();
    }
    return "";
  }
  
  public void h()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.clearCurrentPageInstance();
    }
  }
  
  public void i()
  {
    ThreadManager.post(new ViolaBaseView.23(this), 8, null, true);
  }
  
  public void j()
  {
    this.f = null;
    this.d = null;
  }
  
  public boolean onActivityBack()
  {
    return false;
  }
  
  public void onActivityCreate()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityCreate();
    }
  }
  
  public void onActivityDestroy()
  {
    if (this.v) {
      return;
    }
    this.v = true;
    if ((!this.B) && (this.H == 2))
    {
      localViolaInstance = this.k;
      if ((localViolaInstance != null) && (!localViolaInstance.isReceiveOrder()) && (System.currentTimeMillis() - this.k.mRenderJsStartTime >= 3000L)) {
        this.q.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.a);
      }
    }
    this.q.a();
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityDestroy();
    }
    if (!TextUtils.isEmpty(this.a))
    {
      d(this.a.replace("v_bid", "_bid"));
      i();
    }
    if (!b()) {
      ReadInJoyLogicEngineEventDispatcher.a().b(ViolaUtils.getPageName(this.a), getFromType());
    }
    WormholeManager.a().b(this);
    this.i = null;
  }
  
  public void onActivityPause()
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((ViolaInstance)localObject).onActivityPause();
    }
    localObject = this.L;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18)
    {
      localObject = this.m.getActivity();
      if ((paramInt2 == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((RIJQQAppInterfaceUtil.e() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), this.m.getActivity(), this.m.getActivity(), (Intent)localObject, null);
        }
      }
    }
    Object localObject = this.k;
    if (localObject != null) {
      ((ViolaInstance)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityResume();
    }
    if (this.k == null) {
      this.k = new ViolaInstance(BaseApplicationImpl.getApplication(), new WeakReference(this.m.getActivity()), new WeakReference(this.m), null, -1L, this.a, this.i.c());
    }
    this.p = true;
  }
  
  public void onActivityStart()
  {
    ViolaInstance localViolaInstance = this.k;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    Object localObject = this.k;
    if (localObject != null) {
      ((ViolaInstance)localObject).onActivityStop();
    }
    localObject = this.L;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
  }
  
  public void setBaseViewListener(ViolaBaseView.OnBaseViewListener paramOnBaseViewListener)
  {
    this.D = paramOnBaseViewListener;
    this.E = true;
  }
  
  public void setListener(IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.j = paramViolaViewListener;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.y = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */