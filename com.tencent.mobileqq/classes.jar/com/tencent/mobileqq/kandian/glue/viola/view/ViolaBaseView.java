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
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.viola.api.IReadInJoyWebRenderSoLoader;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaCreactPageObject;
import com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView.ViolaViewListener;
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
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.FPSCalculator.GetFPSListener;
import com.tencent.mobileqq.utils.FileUtils;
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
  implements IViolaBaseView, CommonSuspensionGestureLayout.ContentScrollListener, IActivityState
{
  public static boolean a = false;
  private static String jdField_b_of_type_JavaLangString = "ViolaBaseView";
  private static int jdField_f_of_type_Int = 0;
  private static int jdField_g_of_type_Int = 1;
  private double jdField_a_of_type_Double = 0.0D;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Fragment jdField_a_of_type_AndroidxFragmentAppFragment;
  private IViolaBaseView.ViolaViewListener jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener;
  private RIJTransMergeKanDianReport.ReportR5Builder jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJTransMergeKanDianReport$ReportR5Builder;
  private ViolaReportDelegate jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate;
  private ViolaBaseView.MyHandler jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$MyHandler;
  private ViolaBaseView.OnBaseViewListener jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$OnBaseViewListener;
  private ViolaBaseView.ViolaCreactPageObject jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject;
  private NativeVueStatusInfo jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeNativeVueStatusInfo = new NativeVueStatusInfo();
  private FPSCalculator.GetFPSListener jdField_a_of_type_ComTencentMobileqqUtilFPSCalculator$GetFPSListener;
  private ViolaInstance jdField_a_of_type_ComTencentViolaCoreViolaInstance;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  public String a;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private Function1<Canvas, Unit> jdField_a_of_type_KotlinJvmFunctionsFunction1 = new ViolaBaseView.2(this);
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long;
  private Function1<Canvas, Unit> jdField_b_of_type_KotlinJvmFunctionsFunction1 = new ViolaBaseView.3(this);
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private boolean jdField_f_of_type_Boolean = true;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private boolean l;
  private boolean m;
  
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
    this.jdField_b_of_type_Boolean = paramBoolean.booleanValue();
  }
  
  private void a(int paramInt)
  {
    if (paramInt == jdField_f_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_START);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    NativeVueLoaderManager.a().a();
    ViolaSoLoaderManager localViolaSoLoaderManager = ViolaSoLoaderManager.a.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(hashCode());
    localViolaSoLoaderManager.a(localStringBuilder.toString(), new ViolaBaseView.4(this, paramInt));
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if ((!this.j) && (paramBoolean))
    {
      if (this.h) {
        return;
      }
      this.j = true;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener != null) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
          new Handler(Looper.getMainLooper()).post(new ViolaBaseView.18(this, paramInt));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener.a(paramInt);
        }
      }
      if (paramInt == 100)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_NET);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SDK, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 5)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 7)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_UNZIP);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 8)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 6)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_SO, ViolaEnvironment.SO_ERROR_OFFLINE);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_SO, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 9)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_CHANGE_CGI);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_CHANGE_CGI, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_NET);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_BIZ_JS, this.jdField_a_of_type_JavaLangString);
      }
      else if (paramInt == 10)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_NET);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportData(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_MAIN_JS, this.jdField_a_of_type_JavaLangString);
      }
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("openViolaPage error,code=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",biz url=");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.e(str, 2, localStringBuilder.toString());
    }
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$MyHandler = new ViolaBaseView.MyHandler(this, Looper.getMainLooper());
    this.jdField_a_of_type_Int = Math.abs(new Random().nextInt());
    if ("1".equals(Aladdin.getConfig(420).getString("is_show_net_detail", "")))
    {
      jdField_a_of_type_Boolean = true;
      return;
    }
    jdField_a_of_type_Boolean = false;
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
      this.jdField_c_of_type_JavaLangString = paramString;
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_NET);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.TIME_BIZ_JS_NET, Long.toString(System.currentTimeMillis() - this.jdField_c_of_type_Long));
        p();
      }
      if (!paramBoolean) {
        t();
      }
    }
    else
    {
      a(3, paramBoolean);
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener != null) {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.17(this, paramInt));
      } else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener.b(paramInt);
      }
    }
    String str = jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openViolaPage process,code=");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
  }
  
  private void b(String paramString)
  {
    if (!((IReadInJoyWebRenderSoLoader)QRoute.api(IReadInJoyWebRenderSoLoader.class)).unzip(paramString))
    {
      c(7);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists unzip fail");
      }
    }
    else
    {
      if ((ViolaLibHandler.i()) && (ViolaBizLibHandler.i()))
      {
        a(jdField_g_of_type_Int);
        return;
      }
      c(8);
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip succ but not Exist");
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      a(2, paramBoolean);
      return;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_ERROR_OFFLINE);
    }
    if ((this.jdField_a_of_type_JavaLangString.contains("v_tid")) && (this.jdField_a_of_type_JavaLangString.contains("v_bundleName")))
    {
      if (QLog.isColorLevel())
      {
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadJSSource process from judgeIfNeedCgi v_tid url: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      d(paramBoolean);
      return;
    }
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    e(paramBoolean);
    f(paramBoolean);
  }
  
  private void c(int paramInt)
  {
    a(paramInt, true);
  }
  
  private void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (RIJQQAppInterfaceUtil.a() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i(jdField_b_of_type_JavaLangString, 2, "checkOfflineUpNotCallback.");
      }
      ThreadManager.post(new ViolaBaseView.11(this, paramString), 8, null, true);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_ERROR_OFFLINE);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    localStringBuilder.append(ViolaBizUtils.b());
    ViolaAccessHelper.a(localStringBuilder.toString(), new ViolaBaseView.6(this, paramBoolean, l1));
    a("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547", new ViolaBaseView.7(this, paramBoolean, System.currentTimeMillis()));
  }
  
  private void d(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) {
      return;
    }
    if (this.h) {
      return;
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderVueDomDirectly(paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "render VueDom");
      }
    }
    u();
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_CHANGE, ViolaEnvironment.CHANGE_START);
    }
    Bundle localBundle = new Bundle();
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("https://viola.kandian.qq.com/cgi-bin/bundle/exchange?from=android&originUrl=");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder2.append("&v_sdk=");
    localStringBuilder2.append("8.7.0");
    localStringBuilder2.append("&v_appid=1&v_uid=");
    localStringBuilder2.append(RIJQQAppInterfaceUtil.a());
    localStringBuilder2.append("&v_platform=1");
    localStringBuilder1.append(URLEncoder.encode(localStringBuilder2.toString()));
    new HttpCgiAsyncTask(localStringBuilder1.toString(), "GET", new ViolaBaseView.19(this, paramBoolean)).a(localBundle);
  }
  
  private void e(boolean paramBoolean)
  {
    ViolaAccessHelper.a(this.jdField_d_of_type_JavaLangString, new ViolaBaseView.20(this, paramBoolean));
  }
  
  private boolean e()
  {
    ViolaBaseView.ViolaCreactPageObject localViolaCreactPageObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject;
    return (localViolaCreactPageObject != null) && (localViolaCreactPageObject.a());
  }
  
  private void f(boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    a(this.jdField_a_of_type_JavaLangString, new ViolaBaseView.21(this, paramBoolean, l1));
  }
  
  private void g()
  {
    if (ViolaSDKEngine.isInitialized())
    {
      this.jdField_c_of_type_Boolean = true;
      b(1);
      ViolaBaseView.OnBaseViewListener localOnBaseViewListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$OnBaseViewListener;
      if (localOnBaseViewListener != null) {
        localOnBaseViewListener.a();
      }
      this.jdField_c_of_type_Boolean = true;
      p();
      return;
    }
    if (TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      b(0);
      i();
      return;
    }
    ThreadManager.post(new ViolaBaseView.5(this, (QQAppInterface)RIJQQAppInterfaceUtil.a()), 8, null, true);
  }
  
  private void g(boolean paramBoolean)
  {
    ViolaBaseView.OnBaseViewListener localOnBaseViewListener = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$OnBaseViewListener;
    if (localOnBaseViewListener != null) {
      localOnBaseViewListener.c();
    }
    a(9, paramBoolean);
  }
  
  private void h()
  {
    this.i = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_START);
    this.jdField_c_of_type_JavaLangString = ViolaAccessHelper.b(this.jdField_a_of_type_JavaLangString);
    if (ViolaAccessHelper.b()) {
      this.jdField_c_of_type_JavaLangString = ViolaAccessHelper.d(this.jdField_a_of_type_JavaLangString);
    }
    Object localObject1;
    Object localObject2;
    if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadJSSource process from v_bid url: ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_OFFLINE);
      p();
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.i = false;
      if (this.jdField_a_of_type_JavaLangString.contains("v_debug_test=1"))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("loadJSSource process from cgi debugVersion url: ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        b(true);
        return;
      }
      String str;
      try
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("viola_cache_file_viola_qq_page_data_");
        ((StringBuilder)localObject1).append(ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString));
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(RIJQQAppInterfaceUtil.a());
        localObject1 = FileUtils.readObject(((StringBuilder)localObject1).toString());
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject2 = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("read cached jsSource when oom url: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",error:");
        localStringBuilder.append(localOutOfMemoryError.getMessage());
        QLog.e((String)localObject2, 2, localStringBuilder.toString());
        str = null;
      }
      if ((str instanceof String))
      {
        this.jdField_c_of_type_JavaLangString = ((String)str);
        if (!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
        {
          if (QLog.isColorLevel())
          {
            str = jdField_b_of_type_JavaLangString;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("loadJSSource process from cgi cache url: ");
            ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
            QLog.d(str, 2, ((StringBuilder)localObject2).toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_BIZ, ViolaEnvironment.BIZ_END_EXIT_CACHE);
          p();
          return;
        }
        if (QLog.isColorLevel())
        {
          str = jdField_b_of_type_JavaLangString;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("loadJSSource process from cgi no cache url: ");
          ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
          QLog.d(str, 2, ((StringBuilder)localObject2).toString());
        }
        b(true);
        return;
      }
      if (QLog.isColorLevel())
      {
        str = jdField_b_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("loadJSSource process from cgi no cache1 url: ");
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
        QLog.d(str, 2, ((StringBuilder)localObject2).toString());
      }
      b(true);
      return;
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "loadJSSource mOriginalJsUrl is empty!!!");
  }
  
  private void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_START);
    this.jdField_e_of_type_JavaLangString = ViolaAccessHelper.b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
    if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT);
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$MyHandler.sendEmptyMessageDelayed(3, 0L);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("viola_cache_file_viola_qq_page_data_new_main_js_");
    ((StringBuilder)localObject).append(RIJQQAppInterfaceUtil.a());
    localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
    if ((localObject instanceof String))
    {
      this.jdField_e_of_type_JavaLangString = ((String)localObject);
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_EXIT_CACHE);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$MyHandler.sendEmptyMessageDelayed(3, 0L);
        return;
      }
      c(true);
      return;
    }
    c(true);
  }
  
  private void j()
  {
    ThreadManager.post(new ViolaBaseView.9(this), 8, null, true);
  }
  
  private void k()
  {
    String str1 = Uri.parse("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559").getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    String str2 = ViolaBizUtils.b("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559");
    if ((!TextUtils.isEmpty(str2)) && (new File(str2).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559]");
      }
      b(str2);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_b_of_type_JavaLangString, 2, "downLoadSOFromOffline so.zip not exists [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559],try load from cdn");
      }
      j();
    }
    ViolaAccessHelper.a(str1, new ViolaBaseView.10(this));
  }
  
  private void l()
  {
    if (this.jdField_c_of_type_Int >= 2) {
      return;
    }
    Object localObject1;
    if (this.l)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$OnBaseViewListener;
      if (localObject1 != null)
      {
        ((ViolaBaseView.OnBaseViewListener)localObject1).a(this.jdField_c_of_type_JavaLangString);
        return;
      }
    }
    Object localObject4 = new ViolaRenderContainer(getContext());
    addView((View)localObject4);
    o();
    for (;;)
    {
      try
      {
        ViolaSDKManager.getInstance().setBridgeAdapter(new BridgeAdapter());
        if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null)
        {
          BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
          if (this.jdField_a_of_type_AndroidxFragmentAppFragment != null)
          {
            localObject1 = new WeakReference(this.jdField_a_of_type_AndroidxFragmentAppFragment.getActivity());
            if (this.jdField_a_of_type_AndroidxFragmentAppFragment == null) {
              break label231;
            }
            localObject3 = new WeakReference(this.jdField_a_of_type_AndroidxFragmentAppFragment);
            this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(localBaseApplicationImpl, (WeakReference)localObject1, (WeakReference)localObject3, null, -1L, this.jdField_a_of_type_JavaLangString);
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setRenderContainer((ViolaRenderContainer)localObject4);
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setViolaPageListener(new ViolaBaseView.12(this));
          m();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = jdField_b_of_type_JavaLangString;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("initViola Exception ");
          ((StringBuilder)localObject4).append(localThrowable.getMessage());
          QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        }
        return;
      }
      Object localObject2 = null;
      continue;
      label231:
      Object localObject3 = null;
    }
  }
  
  private void m()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject != null))
    {
      this.jdField_c_of_type_Int = 2;
      s();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeNativeVueStatusInfo.a()) {
        v();
      } else {
        u();
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_b_of_type_JavaLangString, 2, "dealRenderJs");
      }
    }
  }
  
  private void n()
  {
    ThreadManager.post(new ViolaBaseView.13(this), 8, null, true);
  }
  
  private void o()
  {
    addOnLayoutChangeListener(new ViolaBaseView.14(this));
  }
  
  private void p()
  {
    if ((!TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString)) && (this.jdField_c_of_type_Boolean))
    {
      if (Looper.getMainLooper() != Looper.myLooper()) {
        new Handler(Looper.getMainLooper()).post(new ViolaBaseView.15(this));
      } else {
        l();
      }
      ViolaAccessHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString);
      return;
    }
    if (TextUtils.isEmpty(this.jdField_c_of_type_JavaLangString))
    {
      b(2);
      return;
    }
    if (!this.jdField_c_of_type_Boolean)
    {
      b(3);
      g();
    }
  }
  
  private void q()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener == null) {
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper()) {
      new Handler(Looper.getMainLooper()).post(new ViolaBaseView.16(this));
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener.a();
    }
    QLog.d(jdField_b_of_type_JavaLangString, 2, "openViolaPage success!");
  }
  
  private void r()
  {
    ViolaAccessHelper.jdField_a_of_type_Int += 1;
    this.j = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mPageStartTime = this.jdField_b_of_type_Long;
  }
  
  private void t()
  {
    ThreadManager.post(new ViolaBaseView.22(this), 8, null, true);
  }
  
  private void u()
  {
    this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.renderJSSource(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject.a(), ViolaBizUtils.c(this.jdField_a_of_type_JavaLangString));
    if (this.jdField_a_of_type_AndroidxFragmentAppFragment == null) {
      f();
    }
    q();
    if (!this.jdField_b_of_type_Boolean) {
      a(true);
    }
    if (this.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.onActivityResume();
    }
    Object localObject = this.jdField_a_of_type_JavaUtilSet;
    if (localObject != null)
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(str);
      }
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  private void v()
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_b_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start renderNativeVue, url: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    NativeVueLoaderManager.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject.a(), this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, new ViolaBaseView.24(this));
  }
  
  public int a()
  {
    if ((b()) && (this.jdField_g_of_type_Boolean)) {
      return this.jdField_b_of_type_Int;
    }
    return 1;
  }
  
  @NonNull
  public View a()
  {
    return this;
  }
  
  public <T> T a(String paramString)
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance == null) {
      return null;
    }
    return localViolaInstance.getModule(paramString);
  }
  
  public String a()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      return localViolaInstance.getInstanceId();
    }
    return "";
  }
  
  public void a()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityBack();
    }
  }
  
  public void a(IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener = paramViolaViewListener;
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    r();
    if (!this.jdField_f_of_type_Boolean)
    {
      c(11);
      return;
    }
    a(jdField_f_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isDestroy()))
    {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(paramString);
      return;
    }
    if ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) || (!ViolaSDKEngine.isInitialized()))
    {
      if (this.jdField_a_of_type_JavaUtilSet == null) {
        this.jdField_a_of_type_JavaUtilSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilSet.add(paramString);
    }
  }
  
  public void a(@Nullable String paramString, @Nullable Fragment paramFragment, @Nullable IViolaBaseView.ViolaCreactPageObject paramViolaCreactPageObject)
  {
    if (paramViolaCreactPageObject != null)
    {
      a(paramString, paramFragment, new ViolaBaseView.ViolaCreactPageObject(paramViolaCreactPageObject.a(), paramViolaCreactPageObject.a(), paramViolaCreactPageObject.b(), paramViolaCreactPageObject.a(), paramViolaCreactPageObject.c()));
      return;
    }
    a(paramString, paramFragment, null);
  }
  
  public void a(String paramString, Fragment paramFragment, ViolaBaseView.ViolaCreactPageObject paramViolaCreactPageObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("VideoFeeds.js")))
    {
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(System.currentTimeMillis());
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, null, "0X800AF0D", "0X800AF0D", 0, 0, null, null, null, localStringBuilder.toString(), false);
    }
    this.jdField_a_of_type_AndroidxFragmentAppFragment = paramFragment;
    if ((ViolaSDKManager.getInstance().getReportDelegate() instanceof ViolaReportDelegate))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate = ((ViolaReportDelegate)ViolaSDKManager.getInstance().getReportDelegate());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate = new ViolaReportDelegate();
      ViolaSDKManager.getInstance().setReportDelegate(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject = paramViolaCreactPageObject;
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueReportRIJTransMergeKanDianReport$ReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder().addStringNotThrow("url", this.jdField_a_of_type_JavaLangString);
    this.jdField_f_of_type_Boolean = Build.CPU_ABI.contains("arm");
    r();
    if (TextUtils.isEmpty(paramString))
    {
      c(4);
      return;
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      c(11);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaWormholeNativeVueStatusInfo.a(NativeVueLoaderManager.a(paramString));
    a(jdField_f_of_type_Int);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentViolaCoreViolaInstance != null) && (ViolaSDKEngine.isInitialized()) && (!this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.isDestroy())) {
      if (paramBoolean)
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(ViolaBizUtils.a().toString());
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(true);
          this.jdField_e_of_type_Boolean = true;
          c();
        }
      }
      else
      {
        if (this.jdField_e_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.updateInstance(ViolaBizUtils.b().toString());
          this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.setPageVisibility(false);
          this.jdField_e_of_type_Boolean = false;
          d();
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
  
  public int b()
  {
    ViolaBaseView.ViolaCreactPageObject localViolaCreactPageObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject;
    if ((localViolaCreactPageObject != null) && (ViolaBaseView.ViolaCreactPageObject.a(localViolaCreactPageObject) != null) && (ViolaBaseView.ViolaCreactPageObject.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject).has("fromType"))) {
      try
      {
        int n = ViolaBaseView.ViolaCreactPageObject.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject).getInt("fromType");
        return n;
      }
      catch (Exception localException)
      {
        String str = jdField_b_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFromType error  url: ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" , error msg :");
        localStringBuilder.append(localException.getMessage());
        QLog.e(str, 2, localStringBuilder.toString());
      }
    }
    return 100;
  }
  
  public void b()
  {
    if (!this.k)
    {
      this.k = true;
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a();
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Int >= 3;
  }
  
  public void c()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.updateCurrentPageInstance();
    }
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Int >= 2;
  }
  
  public void d()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.clearCurrentPageInstance();
    }
  }
  
  public boolean d()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    return (localViolaInstance != null) && (localViolaInstance.consumeBackKeyEvent());
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (e())
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_b_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!jdField_a_of_type_Boolean) {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new ViolaBaseView.1(this);
    }
    int n = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label173;
          }
        }
        else
        {
          if ((this.m) || ((Math.abs(this.jdField_d_of_type_Int - n) <= 20) && (Math.abs(this.jdField_e_of_type_Int - i1) <= 20))) {
            break label173;
          }
          this.m = true;
          removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
          break label173;
        }
      }
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    else
    {
      this.jdField_d_of_type_Int = n;
      this.jdField_e_of_type_Int = i1;
      this.m = false;
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, ViewConfiguration.getLongPressTimeout() * 6);
    }
    label173:
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (e())
    {
      RIJBlackWhiteModeHelper.a.a(paramCanvas, true, this.jdField_a_of_type_KotlinJvmFunctionsFunction1);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    ThreadManager.post(new ViolaBaseView.23(this), 8, null, true);
  }
  
  public void f()
  {
    this.jdField_e_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public boolean onActivityBack()
  {
    return false;
  }
  
  public void onActivityCreate()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityCreate();
    }
  }
  
  public void onActivityDestroy()
  {
    if (this.h) {
      return;
    }
    this.h = true;
    if ((!this.j) && (this.jdField_c_of_type_Int == 2))
    {
      localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
      if ((localViolaInstance != null) && (!localViolaInstance.isReceiveOrder()) && (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentViolaCoreViolaInstance.mRenderJsStartTime >= 3000L)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.reportPageProcess(ViolaEnvironment.KEY_PAGE_PROCESS, ViolaEnvironment.PAGE_ERROR_NOT_RECEIVE_ORDER, this.jdField_a_of_type_JavaLangString);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaAdapterViolaReportDelegate.a();
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityDestroy();
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      c(this.jdField_a_of_type_JavaLangString.replace("v_bid", "_bid"));
      e();
    }
    if (!b()) {
      ReadInJoyLogicEngineEventDispatcher.a().b(ViolaUtils.getPageName(this.jdField_a_of_type_JavaLangString), b());
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$ViolaCreactPageObject = null;
  }
  
  public void onActivityPause()
  {
    Object localObject = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localObject != null) {
      ((ViolaInstance)localObject).onActivityPause();
    }
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 18)
    {
      localObject = this.jdField_a_of_type_AndroidxFragmentAppFragment.getActivity();
      if ((paramInt2 == -1) && (localObject != null) && (!((Activity)localObject).isFinishing()))
      {
        localObject = AIOUtils.a(new Intent((Context)localObject, SplashActivity.class), null);
        if ((paramIntent != null) && ((RIJQQAppInterfaceUtil.a() instanceof QQAppInterface)))
        {
          ((Intent)localObject).putExtras(new Bundle(paramIntent.getExtras()));
          ForwardUtils.a((QQAppInterface)RIJQQAppInterfaceUtil.a(), this.jdField_a_of_type_AndroidxFragmentAppFragment.getActivity(), this.jdField_a_of_type_AndroidxFragmentAppFragment.getActivity(), (Intent)localObject, null);
        }
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localObject != null) {
      ((ViolaInstance)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onActivityResume()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityResume();
    }
    if (this.jdField_a_of_type_ComTencentViolaCoreViolaInstance == null) {
      this.jdField_a_of_type_ComTencentViolaCoreViolaInstance = new ViolaInstance(BaseApplicationImpl.getApplication(), new WeakReference(this.jdField_a_of_type_AndroidxFragmentAppFragment.getActivity()), new WeakReference(this.jdField_a_of_type_AndroidxFragmentAppFragment), null, -1L, this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_d_of_type_Boolean = true;
  }
  
  public void onActivityStart()
  {
    ViolaInstance localViolaInstance = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localViolaInstance != null) {
      localViolaInstance.onActivityStart();
    }
  }
  
  public void onActivityStop()
  {
    Object localObject = this.jdField_a_of_type_ComTencentViolaCoreViolaInstance;
    if (localObject != null) {
      ((ViolaInstance)localObject).onActivityStop();
    }
    localObject = this.jdField_a_of_type_JavaLangRunnable;
    if (localObject != null) {
      removeCallbacks((Runnable)localObject);
    }
  }
  
  public void setBaseViewListener(ViolaBaseView.OnBaseViewListener paramOnBaseViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaViewViolaBaseView$OnBaseViewListener = paramOnBaseViewListener;
    this.l = true;
  }
  
  public void setListener(IViolaBaseView.ViolaViewListener paramViolaViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizViolaApiIViolaBaseView$ViolaViewListener = paramViolaViewListener;
  }
  
  public void setPageStartTime(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView
 * JD-Core Version:    0.7.0.1
 */