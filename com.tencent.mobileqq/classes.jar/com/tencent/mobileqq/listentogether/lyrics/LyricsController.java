package com.tencent.mobileqq.listentogether.lyrics;

import android.animation.ValueAnimator;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Paint.Align;
import android.os.Handler;
import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.animation.LinearInterpolator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySpEventReportUtil;
import com.tencent.mobileqq.listentogether.ListenTogetherHandler;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherObserver;
import com.tencent.mobileqq.listentogether.ListenTogetherUtils;
import com.tencent.mobileqq.listentogether.OnExistListenTogetherCallback;
import com.tencent.mobileqq.listentogether.fragment.ListenTogetherOverlayFragment;
import com.tencent.mobileqq.listentogether.player.Const;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin;
import com.tencent.mobileqq.theme.ListenTogetherTheme.SkinDrawable.IVasSkinChangeCallback;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class LyricsController
  implements FloatLayoutCallback, ILyricView.LyricState, SkinDrawable.IVasSkinChangeCallback
{
  int jdField_a_of_type_Int = -1;
  ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new LyricsController.6(this);
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new LyricsController.7(this);
  protected QQAppInterface a;
  protected ListenTogetherObserver a;
  OnExistListenTogetherCallback jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback;
  protected FloatIconLayout a;
  protected FloatParams a;
  protected FloatTextLayout a;
  Boolean jdField_a_of_type_JavaLangBoolean;
  Runnable jdField_a_of_type_JavaLangRunnable = new LyricsController.5(this);
  String jdField_a_of_type_JavaLangString;
  HashMap<String, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  protected Set<String> a;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  private Runnable jdField_b_of_type_JavaLangRunnable = new LyricsController.2(this);
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  private Runnable jdField_c_of_type_JavaLangRunnable = new LyricsController.12(this);
  String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  int d;
  public boolean d;
  int e;
  public boolean e;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = true;
  int jdField_g_of_type_Int;
  boolean jdField_g_of_type_Boolean = false;
  int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  int i;
  
  public LyricsController(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilSet = new ArraySet();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams = new FloatParams();
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver = new LyricsController.3(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
    m();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean = true;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    this.jdField_f_of_type_Int = ViewUtils.a();
    this.jdField_g_of_type_Int = ViewUtils.b();
    int j = AIOUtils.b(12.0F, paramQQAppInterface.getResources());
    this.jdField_d_of_type_Int = j;
    this.jdField_b_of_type_Int = j;
    j = AIOUtils.b(12.0F, paramQQAppInterface.getResources());
    this.jdField_e_of_type_Int = j;
    this.jdField_c_of_type_Int = j;
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
    paramQQAppInterface.jdField_a_of_type_Int = -1000;
    paramQQAppInterface.jdField_b_of_type_Int = -1000;
    f();
    ThreadManagerV2.excute(new LyricsController.1(this), 32, null, true);
  }
  
  private ILyricView a()
  {
    FloatTextLayout localFloatTextLayout = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
    if (localFloatTextLayout != null) {
      return localFloatTextLayout.a();
    }
    return null;
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("onPlaySongChange [pre,next]=[%s,%s]", new Object[] { this.jdField_b_of_type_JavaLangString, paramString }));
    }
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString))
    {
      this.jdField_b_of_type_JavaLangString = paramString;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_a_of_type_JavaLangBoolean = null;
    }
    ILyricView localILyricView = a();
    if ((localILyricView != null) && (!Utils.a(localILyricView.a(), paramString)))
    {
      localILyricView.setSongId(paramString);
      localILyricView.setLyric(null, 1);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!Utils.a(paramString, this.jdField_b_of_type_JavaLangString)) {
      return;
    }
    this.i = paramInt;
    if (this.jdField_b_of_type_Boolean) {
      b(paramString, paramInt);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean) {
      c(paramString, paramInt1);
    }
  }
  
  private boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int j = 2;
    if (bool) {
      QLog.i("LyricsController", 2, String.format("updateLyricContent [%s]", new Object[] { paramString1 }));
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    ILyricView localILyricView = a();
    if (localILyricView == null) {
      return false;
    }
    if (paramString1.equals(localILyricView.a()))
    {
      if (localILyricView.a() == 2) {
        return false;
      }
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1 = paramString2.replace("&apos;", "'").replace("&quot;", "\"").replace("&nbsp;", " ").replace("&lt;", "<").replace("&gt;", ">").replace("&amp;", "&");
      }
      Lyric localLyric = LyricParseHelper.a(paramString1, true);
      paramString2 = localLyric;
      if (localLyric == null) {
        paramString2 = LyricParseHelper.a(paramString1, false);
      }
      if (QLog.isColorLevel())
      {
        if (paramString2 == null) {
          bool = true;
        } else {
          bool = false;
        }
        QLog.i("LyricsController", 2, String.format("updateLyricContent parse lyric==null [%b]", new Object[] { Boolean.valueOf(bool) }));
      }
      if (paramString2 == null) {
        if (paramBoolean) {
          j = 3;
        } else {
          j = 4;
        }
      }
      localILyricView.c();
      localILyricView.setLyric(paramString2, j);
      return true;
    }
    return false;
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("updateLyricState [%s, %s]", new Object[] { Const.a(paramInt), paramString }));
    }
    ILyricView localILyricView = a();
    if (localILyricView == null) {
      return;
    }
    localILyricView.setSongId(paramString);
    if (paramInt == 2)
    {
      boolean bool = localILyricView.a();
      if (!bool) {
        localILyricView.a();
      }
      paramString = new StringBuilder();
      paramString.append("updateLyricPosition() seek to playPosition:");
      paramString.append(0);
      paramString.append(" isPlaying:");
      paramString.append(bool);
      QLog.i("LyricsController", 1, paramString.toString());
      localILyricView.a(0);
      return;
    }
    if (3 == paramInt)
    {
      localILyricView.a(0);
      localILyricView.b();
      return;
    }
    if ((1 != paramInt) && (paramInt != 0))
    {
      localILyricView.c();
      return;
    }
    localILyricView.b();
  }
  
  private boolean b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if ((localObject != null) && (((QQAppInterface)localObject).getApp() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
      boolean bool = ((IQQFloatingPermission)QRoute.api(IQQFloatingPermission.class)).checkPermission((Context)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("hasFloatPermission, isOpEnable: ");
        ((StringBuilder)localObject).append(bool);
        QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
      }
      return bool;
    }
    return false;
  }
  
  private boolean b(int paramInt, String paramString)
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(paramInt, paramString))) {
      return true;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      FloatParams localFloatParams = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
      Set localSet2 = this.jdField_a_of_type_JavaUtilSet;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      localFloatParams.jdField_b_of_type_Boolean = localSet2.contains(localStringBuilder.toString());
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.b(paramInt, paramString) ^ true;
      if (bool1 != this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
        paramString.jdField_c_of_type_Boolean = bool1;
        paramString.jdField_d_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout = new FloatIconLayout(localBaseApplication);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.setFloatLayoutCallback(this);
        FloatViewSkin.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout);
        l();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout = new FloatTextLayout(localBaseApplication);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.setFloatLayoutCallback(this);
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.e();
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean;
      bool1 = false;
      if (!bool2)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int == -1000) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int = (this.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2 - AIOUtils.b(110.0F, BaseApplicationImpl.getContext().getResources()));
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Boolean = true;
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = (this.jdField_d_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2);
        } else {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = (this.jdField_f_of_type_Int - this.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int == -1000) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int = (AIOUtils.b(70.0F, BaseApplicationImpl.getContext().getResources()) + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2);
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Boolean = false;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("showLyricsInner mFloatParams: ");
        paramString.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
        QLog.d("LyricsController", 2, paramString.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout;
      paramString.a(paramString.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams));
      paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
      paramString.a(paramString.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams));
      bool2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_d_of_type_Boolean = false;
      if ((!bool3) || (!bool2)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private void c(String paramString, int paramInt)
  {
    ILyricView localILyricView = a();
    if (localILyricView == null) {
      return;
    }
    if (Utils.a(localILyricView.a(), paramString)) {
      localILyricView.a(paramInt);
    }
  }
  
  private void m()
  {
    try
    {
      ((IReadInJoySpEventReportUtil)QRoute.api(IReadInJoySpEventReportUtil.class)).init();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void n()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_g_of_type_Boolean = true;
    }
  }
  
  private void o()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      this.jdField_g_of_type_Boolean = false;
    }
  }
  
  private void p()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout;
    if (localObject != null) {
      ((FloatIconLayout)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
    if (localObject != null) {
      ((FloatTextLayout)localObject).b();
    }
    localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
  }
  
  private void q()
  {
    Object localObject = BaseApplicationImpl.getContext();
    int j;
    int k;
    if (localObject != null)
    {
      j = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      k = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      if (j != this.jdField_f_of_type_Int)
      {
        this.jdField_f_of_type_Int = j;
        if (this.jdField_b_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.e();
        }
      }
      if (k != this.jdField_g_of_type_Int) {
        this.jdField_g_of_type_Int = k;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLyricsFloatWindow mScreenWidth: ");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_Int);
      ((StringBuilder)localObject).append("  mScreenHeight: ");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_Int);
      ((StringBuilder)localObject).append(" mIsListenFloatShowing=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
    ((FloatParams)localObject).jdField_h_of_type_Boolean = false;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((((FloatParams)localObject).jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_g_of_type_Boolean))
      {
        j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int;
        int m = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int;
        bool1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean;
        boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean;
        bool2 = true;
        if (bool3)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a() < this.jdField_f_of_type_Int / 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          if (bool1) {
            j = this.jdField_d_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
          } else {
            j = this.jdField_f_of_type_Int - this.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Boolean = false;
        }
        else if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_d_of_type_Boolean)
        {
          if (bool1) {
            j = this.jdField_f_of_type_Int / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2;
          } else {
            j = this.jdField_f_of_type_Int / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2;
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Boolean = true;
        }
        else
        {
          k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.c();
          int n = this.jdField_d_of_type_Int;
          if (k <= n)
          {
            j = n - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2;
            bool1 = true;
          }
          else
          {
            k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
            n = this.jdField_f_of_type_Int;
            int i1 = this.jdField_b_of_type_Int;
            if (k >= n - i1)
            {
              j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + (n - i1);
              bool1 = false;
            }
          }
        }
        if (m < this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2)
        {
          k = this.jdField_e_of_type_Int + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2;
        }
        else
        {
          k = m;
          if (m > this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2) {
            k = this.jdField_g_of_type_Int - this.jdField_c_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.e() / 2;
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
        ((FloatParams)localObject).jdField_a_of_type_Boolean = bool1;
        ((FloatParams)localObject).jdField_a_of_type_Int = j;
        ((FloatParams)localObject).jdField_b_of_type_Int = k;
      }
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_f_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_g_of_type_Boolean)) {
        i();
      }
      boolean bool1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.c();
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.c();
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_d_of_type_Boolean = false;
      if ((bool1 != bool2) && (bool2) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {
        b(this.jdField_b_of_type_JavaLangString, this.i);
      }
    }
  }
  
  private void r()
  {
    ??? = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (??? == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ((QQAppInterface)???).getPreferences().edit();
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      if (!this.jdField_a_of_type_JavaUtilSet.isEmpty()) {
        localEditor.putStringSet("listen_together_lyric_user_closes", this.jdField_a_of_type_JavaUtilSet);
      } else {
        localEditor.remove("listen_together_lyric_user_closes");
      }
      localEditor.putInt("listen_together_float_loc_icon_cx", this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int);
      localEditor.putInt("listen_together_float_loc_icon_cy", this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int);
      localEditor.putBoolean("listen_together_float_align_right", this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean);
      localEditor.apply();
      return;
    }
  }
  
  public FloatParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPositionChangeEnd mFloatParams:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      localStringBuilder.append(" mScreenWidth:");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      localStringBuilder.append(" mScreenHeight:");
      localStringBuilder.append(this.jdField_g_of_type_Int);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    q();
    r();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int;
      int n = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Int;
      int m = j - paramInt1;
      int k = this.jdField_f_of_type_Int;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean))
        {
          paramInt1 = 0 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
          j = k;
          break label191;
        }
        j = k;
        if (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean)
        {
          paramInt1 = 0 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
          j = k - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d();
          break label191;
        }
      }
      else if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean))
      {
        j = k + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
      }
      else
      {
        j = k;
        if (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_Boolean)
        {
          paramInt1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() + 0;
          j = k + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
          break label191;
        }
      }
      paramInt1 = 0;
      label191:
      if (m < paramInt1) {
        j = paramInt1;
      } else if (m <= j) {
        j = m;
      }
      paramInt2 = n - paramInt2;
      if (paramInt2 < 0)
      {
        paramInt1 = 0;
      }
      else
      {
        k = this.jdField_g_of_type_Int;
        paramInt1 = paramInt2;
        if (paramInt2 > k) {
          paramInt1 = k;
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
      ((FloatParams)localObject).jdField_e_of_type_Boolean = false;
      ((FloatParams)localObject).jdField_a_of_type_Int = j;
      ((FloatParams)localObject).jdField_b_of_type_Int = paramInt1;
      FloatIconLayout localFloatIconLayout = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout;
      localFloatIconLayout.a(localFloatIconLayout.a((FloatParams)localObject), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams));
      localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
      ((FloatTextLayout)localObject).a(((FloatTextLayout)localObject).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams));
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("showLyrics, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool = b();
    int j = 0;
    if (!bool)
    {
      if (this.jdField_f_of_type_Boolean) {
        g();
      }
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_f_of_type_Boolean = false;
      return;
    }
    n();
    this.jdField_f_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    if (b(paramInt, paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(paramInt, paramString);
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramString = this.jdField_b_of_type_JavaLangString;
        localObject = Const.a(this.i);
        String str = this.jdField_c_of_type_JavaLangString;
        if (str == null) {
          paramInt = j;
        } else {
          paramInt = str.length();
        }
        QLog.i("LyricsController", 2, String.format("showLyrics[%s %s %d %s]", new Object[] { paramString, localObject, Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangBoolean }));
      }
      a(this.jdField_b_of_type_JavaLangString);
      paramString = this.jdField_a_of_type_JavaLangBoolean;
      if (paramString != null) {
        a(this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, paramString.booleanValue());
      }
      b(this.jdField_b_of_type_JavaLangString, this.i);
      paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout;
      if (paramString != null) {
        paramString.setPlayState(true);
      }
    }
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitAIO, type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isForeground: ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      localStringBuilder.append(" mFloatParams:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.b(paramInt, paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.b(0, null);
      if (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean)
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
        paramString.jdField_c_of_type_Boolean = true;
        paramString.jdField_d_of_type_Boolean = true;
        paramString.jdField_h_of_type_Boolean = false;
        if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) && (this.jdField_a_of_type_Boolean))
        {
          if (paramString.jdField_a_of_type_Boolean) {
            paramString = Paint.Align.RIGHT;
          } else {
            paramString = Paint.Align.LEFT;
          }
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a.setAlign(paramString);
          int k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.f();
          int m = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.f();
          int j;
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean)
          {
            paramInt = -this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d();
            j = -this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d();
          }
          else
          {
            paramInt = this.jdField_f_of_type_Int;
            j = paramInt;
          }
          paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
          paramString.a(paramInt, paramString.g());
          paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout;
          paramString.a(j, paramString.g());
          this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b();
          paramString = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
          paramString.jdField_h_of_type_Boolean = true;
          paramString.jdField_h_of_type_Int = k;
          paramString.i = m;
          paramString.jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        paramInt = 300;
        if (paramBoolean) {
          paramInt = 500;
        }
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, paramInt);
      }
    }
    FloatViewSkin.a().a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.jdField_b_of_type_JavaLangString;
      int j = 0;
      if (paramString2 != null) {
        j = paramString2.length();
      }
      QLog.i("LyricsController", 2, String.format("onGetLyric [pre=%s,next=%s] netErr=%b lyric=%d %s", new Object[] { str, paramString1, Boolean.valueOf(paramBoolean), Integer.valueOf(j), paramString2 }));
    }
    if ((paramString1 != null) && (paramString1.equals(this.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_c_of_type_JavaLangString = paramString2;
      this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
      if (this.jdField_b_of_type_Boolean)
      {
        a(paramString1, paramString2, paramBoolean);
        b(this.jdField_b_of_type_JavaLangString, this.i);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_c_of_type_JavaLangRunnable);
    if (paramBoolean)
    {
      ThreadManager.getUIHandlerV2().postDelayed(this.jdField_c_of_type_JavaLangRunnable, 500L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_f_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      q();
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isListenFloatShowing : ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        Set localSet = this.jdField_a_of_type_JavaUtilSet;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append("_");
        localStringBuilder.append(paramString);
        if (!localSet.contains(localStringBuilder.toString()))
        {
          bool = true;
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ((StringBuilder)???).append("isLyricsTextShowing type:");
            ((StringBuilder)???).append(paramInt);
            ((StringBuilder)???).append(" uin:");
            ((StringBuilder)???).append(paramString);
            ((StringBuilder)???).append(" show:");
            ((StringBuilder)???).append(bool);
            ((StringBuilder)???).append(" mLyricUserClosedAIOs:");
            ((StringBuilder)???).append(this.jdField_a_of_type_JavaUtilSet);
            QLog.i("LyricsController", 2, ((StringBuilder)???).toString());
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClickLyrics mIsListenFloatShowing:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a()) && (BaseActivity.sTopActivity != null))
    {
      localObject = ActionSheet.create(BaseActivity.sTopActivity);
      boolean bool = ListenTogetherUtils.a();
      if (bool) {
        ((ActionSheet)localObject).addButton(2131693671);
      }
      ((ActionSheet)localObject).addButton(2131693646);
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnDismissListener(new LyricsController.8(this));
      ((ActionSheet)localObject).setOnCancelListener(new LyricsController.9(this));
      ((ActionSheet)localObject).setOnButtonClickListener(new LyricsController.10(this, (ActionSheet)localObject, bool));
      ((ActionSheet)localObject).show();
      b(true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
      return;
    }
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("type", 1);
    ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
    ((Intent)localObject).setFlags(268435456);
    PublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), (Intent)localObject, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
      if (localObject != null)
      {
        paramInt2 = ((FloatTextLayout)localObject).d();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onLyricTextSizeChanged oldWidth:");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" newWidth:");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
        }
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.setFloatWidth(paramInt1);
        if ((this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean)) {
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Boolean) {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 - this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_a_of_type_Int = (this.jdField_f_of_type_Int / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.d() / 2 + this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.d() / 2);
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
        ((FloatTextLayout)localObject).a(((FloatTextLayout)localObject).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams), this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams));
        this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a();
      }
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideLyrics,  type:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" mFloatParams:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(paramInt, paramString)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    p();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(0, null);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_h_of_type_Int = 0;
    o();
    FloatViewSkin.a().b();
  }
  
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      if (paramBoolean) {
        this.jdField_a_of_type_JavaUtilSet.add(paramString);
      } else if (this.jdField_a_of_type_JavaUtilSet.contains(paramString)) {
        this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      }
      r();
      return;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmpGoneForSomePage yes: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_g_of_type_Boolean = paramBoolean;
      if (this.jdField_b_of_type_Boolean) {
        q();
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString)) && ((this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int == 2) || (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int == 1)))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a()) {
        return;
      }
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
      localObject = ((StringBuilder)localObject).toString();
      int j;
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 1)) {
        j = 1;
      } else {
        j = 0;
      }
      if ((j == 0) && ((!this.jdField_a_of_type_JavaUtilHashMap.containsKey(localObject)) || (!((Boolean)this.jdField_a_of_type_JavaUtilHashMap.get(localObject)).booleanValue())))
      {
        localObject = AIOUtils.a(new Intent(localBaseApplication, ChatActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("leftViewText", "");
      }
      else
      {
        localObject = new Intent(localBaseApplication, SplashActivity.class);
        if (j != 0) {
          j = 1;
        } else {
          j = 2;
        }
        localObject = AIOUtils.a((Intent)localObject, new int[] { j });
      }
      ((Intent)localObject).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int == 2)
      {
        ((Intent)localObject).putExtra("uintype", 0);
      }
      else
      {
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("troop_uin", this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
      }
      ((Intent)localObject).addFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject);
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (FloatViewSkin.a().a()) {
        j = 1;
      } else {
        j = 2;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "qq_vip", "0X800A5C0", j, 0, "", "", VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface), "");
    }
  }
  
  public void c(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEnterAIO, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" mFloatParams:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      ((StringBuilder)localObject).append(" mIsForeground:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.b(paramInt, paramString);
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.a(paramInt, paramString) ^ true;
    if (bool != this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_c_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
      ((FloatParams)localObject).jdField_c_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean) {
        ((FloatParams)localObject).jdField_d_of_type_Boolean = true;
      }
      q();
    }
    if ((BaseActivity.sTopActivity instanceof SplashActivity))
    {
      localObject = this.jdField_a_of_type_JavaUtilHashMap;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      ((HashMap)localObject).put(localStringBuilder.toString(), Boolean.TRUE);
      return;
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), Boolean.FALSE);
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("tmpGoneForSomePageDelay yes: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("LyricsController", 2, localStringBuilder.toString());
    }
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_g_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_g_of_type_Boolean = paramBoolean;
      if (this.jdField_b_of_type_Boolean)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
        ThreadManager.getUIHandlerV2().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 500L);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      int j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int;
      String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback = new LyricsController.11(this);
      ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(j, str, this.jdField_a_of_type_ComTencentMobileqqListentogetherOnExistListenTogetherCallback);
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroyAIO, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isForeground: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(" mFloatParams:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).remove(localStringBuilder.toString());
  }
  
  public void e()
  {
    b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout;
    if (localObject != null) {
      ((FloatIconLayout)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout;
    if (localObject != null) {
      ((FloatTextLayout)localObject).b();
    }
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherObserver);
    o();
  }
  
  protected void f()
  {
    FloatViewSkin.a().a(this);
  }
  
  public void g()
  {
    boolean bool = b();
    this.jdField_f_of_type_Boolean = false;
    if (!bool)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkPermissionAndShowDialog in mIsFirstJoinTipsShowing:");
        ((StringBuilder)localObject).append(this.jdField_d_of_type_Boolean);
        QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.jdField_d_of_type_Boolean)
      {
        n();
        localObject = new Intent();
        ((Intent)localObject).putExtra("type", 2);
        ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
        ((Intent)localObject).setFlags(268435456);
        PublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), (Intent)localObject, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        this.jdField_c_of_type_Boolean = true;
        this.jdField_h_of_type_Int = 0;
        this.jdField_e_of_type_Boolean = false;
      }
      else
      {
        this.jdField_e_of_type_Boolean = true;
      }
    }
    else
    {
      this.jdField_e_of_type_Boolean = false;
    }
    ThreadManager.getSubThreadHandler().post(new LyricsController.4(this, bool));
  }
  
  public void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
    ((FloatParams)localObject).jdField_b_of_type_Boolean = true;
    ((FloatParams)localObject).jdField_g_of_type_Boolean = false;
    q();
    int j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_e_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams.jdField_b_of_type_JavaLangString;
    b(j, str, true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      ((ListenTogetherHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(14, true, new Object[] { Integer.valueOf(j), str });
      ((ListenTogetherManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).a(j, str, "closeLyric", 0);
      if ((j == 2) && (!TextUtils.isEmpty(str)))
      {
        ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_close", 0, 0, str, "", "", "");
        return;
      }
      if ((j == 1) && (!TextUtils.isEmpty(str)))
      {
        localObject = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(str);
        if (localObject != null)
        {
          if (((TroopInfo)localObject).isTroopOwner(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin()))
          {
            localObject = "0";
            break label221;
          }
          if (((TroopInfo)localObject).isAdmin())
          {
            localObject = "1";
            break label221;
          }
        }
        localObject = "2";
        label221:
        ReportController.b(null, "dc00899", "Grp_AIO", "", "music_tab", "clk_close", 0, 0, str, "", (String)localObject, "");
      }
    }
  }
  
  public void i()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator = null;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
    int k = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
    int m = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
    int n = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.b(this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.f();
    int i2 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.g();
    int i3 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.f();
    int i4 = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.g();
    if ((Math.abs(i1 - j) < 10) && (Math.abs(i2 - k) < 10) && (Math.abs(i3 - m) < 10) && (Math.abs(i4 - n) < 10))
    {
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout.a(j, k);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatTextLayout.a(m, n);
      return;
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new LinearInterpolator());
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(250L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new LyricsController.13(this, i1, j, i2, k, i3, m, i4, n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addListener(new LyricsController.14(this, j, k, m, n));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  protected void j()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = ((QQAppInterface)localObject1).getPreferences();
    localObject1 = ((SharedPreferences)localObject3).getStringSet("listen_together_lyric_user_closes", null);
    FloatParams localFloatParams = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
    localFloatParams.jdField_a_of_type_Int = ((SharedPreferences)localObject3).getInt("listen_together_float_loc_icon_cx", localFloatParams.jdField_a_of_type_Int);
    localFloatParams = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
    localFloatParams.jdField_b_of_type_Int = ((SharedPreferences)localObject3).getInt("listen_together_float_loc_icon_cy", localFloatParams.jdField_b_of_type_Int);
    localFloatParams = this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatParams;
    localFloatParams.jdField_a_of_type_Boolean = ((SharedPreferences)localObject3).getBoolean("listen_together_float_align_right", localFloatParams.jdField_a_of_type_Boolean);
    localObject3 = this.jdField_a_of_type_JavaUtilSet;
    if (localObject1 != null) {}
    try
    {
      if (!((Set)localObject1).isEmpty()) {
        this.jdField_a_of_type_JavaUtilSet.addAll((Collection)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public void k() {}
  
  public void l()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherLyricsFloatIconLayout != null) {
      ThreadManager.getUIHandlerV2().post(new LyricsController.15(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController
 * JD-Core Version:    0.7.0.1
 */