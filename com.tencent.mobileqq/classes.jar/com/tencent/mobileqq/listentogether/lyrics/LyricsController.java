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
  ValueAnimator A;
  int B;
  String C;
  String D;
  Boolean E;
  private Runnable F = new LyricsController.2(this);
  private boolean G = false;
  private BroadcastReceiver H = new LyricsController.7(this);
  private Runnable I = new LyricsController.12(this);
  protected QQAppInterface a;
  protected Set<String> b = new ArraySet();
  boolean c = true;
  protected FloatParams d = new FloatParams();
  boolean e = false;
  boolean f = false;
  int g = -1;
  String h;
  protected FloatIconLayout i;
  protected FloatTextLayout j;
  int k = 0;
  int l = 0;
  int m = 0;
  int n = 0;
  int o;
  int p;
  HashMap<String, Boolean> q = new HashMap();
  public boolean r = false;
  public boolean s = false;
  boolean t = true;
  OnExistListenTogetherCallback u;
  protected ListenTogetherObserver v = new LyricsController.3(this);
  int w = 0;
  Runnable x = new LyricsController.5(this);
  boolean y = false;
  Application.ActivityLifecycleCallbacks z = new LyricsController.6(this);
  
  public LyricsController(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    paramQQAppInterface.addObserver(this.v);
    p();
    this.d.e = true;
    paramQQAppInterface = BaseApplicationImpl.getContext();
    this.o = ViewUtils.getScreenWidth();
    this.p = ViewUtils.getScreenHeight();
    int i1 = AIOUtils.b(12.0F, paramQQAppInterface.getResources());
    this.m = i1;
    this.k = i1;
    i1 = AIOUtils.b(12.0F, paramQQAppInterface.getResources());
    this.n = i1;
    this.l = i1;
    paramQQAppInterface = this.d;
    paramQQAppInterface.a = -1000;
    paramQQAppInterface.b = -1000;
    f();
    ThreadManagerV2.excute(new LyricsController.1(this), 32, null, true);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("onPlaySongChange [pre,next]=[%s,%s]", new Object[] { this.C, paramString }));
    }
    if (!Utils.a(paramString, this.C))
    {
      this.C = paramString;
      this.D = null;
      this.E = null;
    }
    ILyricView localILyricView = v();
    if ((localILyricView != null) && (!Utils.a(localILyricView.getSongId(), paramString)))
    {
      localILyricView.setSongId(paramString);
      localILyricView.setLyric(null, 1);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (!Utils.a(paramString, this.C)) {
      return;
    }
    this.B = paramInt;
    if (this.e) {
      b(paramString, paramInt);
    }
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.e) {
      c(paramString, paramInt1);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LyricsController", 2, String.format("updateLyricState [%s, %s]", new Object[] { Const.a(paramInt), paramString }));
    }
    ILyricView localILyricView = v();
    if (localILyricView == null) {
      return;
    }
    localILyricView.setSongId(paramString);
    if (paramInt == 2)
    {
      boolean bool = localILyricView.d();
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
  
  private boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool) {
      QLog.i("LyricsController", 2, String.format("updateLyricContent [%s]", new Object[] { paramString1 }));
    }
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    ILyricView localILyricView = v();
    if (localILyricView == null) {
      return false;
    }
    if (paramString1.equals(localILyricView.getSongId()))
    {
      if (localILyricView.getState() == 2) {
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
          i1 = 3;
        } else {
          i1 = 4;
        }
      }
      localILyricView.c();
      localILyricView.setLyric(paramString2, i1);
      return true;
    }
    return false;
  }
  
  private void c(String paramString, int paramInt)
  {
    ILyricView localILyricView = v();
    if (localILyricView == null) {
      return;
    }
    if (Utils.a(localILyricView.getSongId(), paramString)) {
      localILyricView.a(paramInt);
    }
  }
  
  private boolean f(int paramInt, String paramString)
  {
    if ((this.e) && (this.d.b(paramInt, paramString))) {
      return true;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    synchronized (this.b)
    {
      FloatParams localFloatParams = this.d;
      Set localSet2 = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      localFloatParams.f = localSet2.contains(localStringBuilder.toString());
      boolean bool1 = this.d.d(paramInt, paramString) ^ true;
      if (bool1 != this.d.h)
      {
        paramString = this.d;
        paramString.h = bool1;
        paramString.i = true;
      }
      if (this.i == null)
      {
        this.i = new FloatIconLayout(localBaseApplication);
        this.i.setFloatLayoutCallback(this);
        FloatViewSkin.a().a(this.i);
        n();
      }
      if (this.j == null)
      {
        this.j = new FloatTextLayout(localBaseApplication);
        this.j.setFloatLayoutCallback(this);
      }
      this.j.h();
      boolean bool2 = this.d.h;
      bool1 = false;
      if (!bool2)
      {
        if (this.d.e) {
          this.d.a = (this.o / 2 - this.i.getFloatWidth() / 2 - this.j.getFloatWidth() / 2);
        } else {
          this.d.a = (this.o / 2 + this.i.getFloatWidth() / 2 + this.j.getFloatWidth() / 2);
        }
        if (this.d.b == -1000) {
          this.d.b = (this.p - this.i.getFloatHeight() / 2 - AIOUtils.b(110.0F, BaseApplicationImpl.getContext().getResources()));
        }
        this.d.j = true;
      }
      else
      {
        if (this.d.e) {
          this.d.a = (this.m + this.i.getFloatWidth() / 2);
        } else {
          this.d.a = (this.o - this.k - this.i.getFloatWidth() / 2);
        }
        if (this.d.b == -1000) {
          this.d.b = (AIOUtils.b(70.0F, BaseApplicationImpl.getContext().getResources()) + this.i.getFloatHeight() / 2);
        }
        this.d.j = false;
      }
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("showLyricsInner mFloatParams: ");
        paramString.append(this.d);
        QLog.d("LyricsController", 2, paramString.toString());
      }
      this.i.a(this.d);
      this.j.a(this.d);
      paramString = this.i;
      paramString.a(paramString.c(this.d), this.i.d(this.d));
      paramString = this.j;
      paramString.a(paramString.c(this.d), this.j.d(this.d));
      bool2 = this.j.b(this.d);
      boolean bool3 = this.i.b(this.d);
      this.d.i = false;
      if ((!bool3) || (!bool2)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  private boolean o()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((QQAppInterface)localObject).getApp() != null))
    {
      localObject = this.a.getApp();
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
  
  private void p()
  {
    try
    {
      ((IReadInJoySpEventReportUtil)QRoute.api(IReadInJoySpEventReportUtil.class)).init();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.QQ_BACKGROUND");
      localIntentFilter.addAction("mqq.intent.action.QQ_FOREGROUND");
      BaseApplicationImpl.getContext().registerReceiver(this.H, localIntentFilter);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void q()
  {
    if (!this.y)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.z);
      this.y = true;
    }
  }
  
  private void r()
  {
    if (this.y)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.z);
      this.y = false;
    }
  }
  
  private void s()
  {
    Object localObject = this.i;
    if (localObject != null) {
      ((FloatIconLayout)localObject).c();
    }
    localObject = this.j;
    if (localObject != null) {
      ((FloatTextLayout)localObject).c();
    }
    localObject = this.A;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.A = null;
    }
  }
  
  private void t()
  {
    Object localObject = BaseApplicationImpl.getContext();
    int i1;
    int i2;
    if (localObject != null)
    {
      i1 = ((Context)localObject).getResources().getDisplayMetrics().widthPixels;
      i2 = ((Context)localObject).getResources().getDisplayMetrics().heightPixels;
      if (i1 != this.o)
      {
        this.o = i1;
        if (this.e) {
          this.j.h();
        }
      }
      if (i2 != this.p) {
        this.p = i2;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateLyricsFloatWindow mScreenWidth: ");
      ((StringBuilder)localObject).append(this.o);
      ((StringBuilder)localObject).append("  mScreenHeight: ");
      ((StringBuilder)localObject).append(this.p);
      ((StringBuilder)localObject).append(" mIsListenFloatShowing=");
      ((StringBuilder)localObject).append(this.e);
      QLog.d("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
    localObject = this.d;
    ((FloatParams)localObject).u = false;
    if (this.e)
    {
      if ((((FloatParams)localObject).k) && (!this.d.l))
      {
        i1 = this.d.a;
        int i3 = this.d.b;
        bool1 = this.d.e;
        boolean bool3 = this.d.h;
        bool2 = true;
        if (bool3)
        {
          if (this.i.getFloatCenterX() < this.o / 2) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          if (bool1) {
            i1 = this.m + this.i.getFloatWidth() / 2;
          } else {
            i1 = this.o - this.k - this.i.getFloatWidth() / 2;
          }
          this.d.j = false;
        }
        else if (this.d.i)
        {
          if (bool1) {
            i1 = this.o / 2 - this.i.getFloatWidth() / 2 - this.j.getFloatWidth() / 2;
          } else {
            i1 = this.o / 2 + this.i.getFloatWidth() / 2 + this.j.getFloatWidth() / 2;
          }
          this.d.j = true;
        }
        else
        {
          i2 = this.j.getFloatRight();
          int i4 = this.m;
          if (i2 <= i4)
          {
            i1 = i4 - this.i.getFloatWidth() / 2;
            bool1 = true;
          }
          else
          {
            i2 = this.j.getFloatLeft();
            i4 = this.o;
            int i5 = this.k;
            if (i2 >= i4 - i5)
            {
              i1 = this.i.getFloatWidth() / 2 + (i4 - i5);
              bool1 = false;
            }
          }
        }
        if (i3 < this.n + this.i.getFloatHeight() / 2)
        {
          i2 = this.n + this.i.getFloatHeight() / 2;
        }
        else
        {
          i2 = i3;
          if (i3 > this.p - this.l - this.i.getFloatHeight() / 2) {
            i2 = this.p - this.l - this.i.getFloatHeight() / 2;
          }
        }
        localObject = this.d;
        ((FloatParams)localObject).e = bool1;
        ((FloatParams)localObject).a = i1;
        ((FloatParams)localObject).b = i2;
      }
      this.i.a(this.d);
      this.j.a(this.d);
      if ((this.d.k) && (!this.d.l)) {
        j();
      }
      boolean bool1 = this.j.d();
      this.j.b(this.d);
      this.i.b(this.d);
      boolean bool2 = this.j.d();
      this.d.i = false;
      if ((bool1 != bool2) && (bool2) && (!TextUtils.isEmpty(this.C))) {
        b(this.C, this.B);
      }
    }
  }
  
  private void u()
  {
    ??? = this.a;
    if (??? == null) {
      return;
    }
    SharedPreferences.Editor localEditor = ((QQAppInterface)???).getPreferences().edit();
    synchronized (this.b)
    {
      if (!this.b.isEmpty()) {
        localEditor.putStringSet("listen_together_lyric_user_closes", this.b);
      } else {
        localEditor.remove("listen_together_lyric_user_closes");
      }
      localEditor.putInt("listen_together_float_loc_icon_cx", this.d.a);
      localEditor.putInt("listen_together_float_loc_icon_cy", this.d.b);
      localEditor.putBoolean("listen_together_float_align_right", this.d.e);
      localEditor.apply();
      return;
    }
  }
  
  private ILyricView v()
  {
    FloatTextLayout localFloatTextLayout = this.j;
    if (localFloatTextLayout != null) {
      return localFloatTextLayout.getLyricView();
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPositionChangeEnd mFloatParams:");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" mScreenWidth:");
      localStringBuilder.append(this.o);
      localStringBuilder.append(" mScreenHeight:");
      localStringBuilder.append(this.p);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    t();
    u();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.e)
    {
      int i1 = this.d.a;
      int i4 = this.d.b;
      int i3 = i1 - paramInt1;
      int i2 = this.o;
      if (this.d.e)
      {
        if ((this.d.h) && (!this.d.f))
        {
          paramInt1 = 0 - this.j.getFloatWidth();
          i1 = i2;
          break label191;
        }
        i1 = i2;
        if (!this.d.f)
        {
          paramInt1 = 0 - this.j.getFloatWidth();
          i1 = i2 - this.i.getFloatWidth();
          break label191;
        }
      }
      else if ((this.d.h) && (!this.d.f))
      {
        i1 = i2 + this.j.getFloatWidth();
      }
      else
      {
        i1 = i2;
        if (!this.d.f)
        {
          paramInt1 = this.i.getFloatWidth() + 0;
          i1 = i2 + this.j.getFloatWidth();
          break label191;
        }
      }
      paramInt1 = 0;
      label191:
      if (i3 < paramInt1) {
        i1 = paramInt1;
      } else if (i3 <= i1) {
        i1 = i3;
      }
      paramInt2 = i4 - paramInt2;
      if (paramInt2 < 0)
      {
        paramInt1 = 0;
      }
      else
      {
        i2 = this.p;
        paramInt1 = paramInt2;
        if (paramInt2 > i2) {
          paramInt1 = i2;
        }
      }
      Object localObject = this.d;
      ((FloatParams)localObject).j = false;
      ((FloatParams)localObject).a = i1;
      ((FloatParams)localObject).b = paramInt1;
      FloatIconLayout localFloatIconLayout = this.i;
      localFloatIconLayout.a(localFloatIconLayout.c((FloatParams)localObject), this.i.d(this.d));
      localObject = this.j;
      ((FloatTextLayout)localObject).a(((FloatTextLayout)localObject).c(this.d), this.j.d(this.d));
      this.i.b(this.d);
      this.j.b(this.d);
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
    boolean bool = o();
    int i1 = 0;
    if (!bool)
    {
      if (this.t) {
        h();
      }
      this.g = paramInt;
      this.h = paramString;
      this.t = false;
      return;
    }
    q();
    this.t = false;
    this.f = false;
    this.w = 0;
    this.g = -1;
    this.h = null;
    if (f(paramInt, paramString))
    {
      this.d.a(paramInt, paramString);
      this.e = true;
      if (QLog.isColorLevel())
      {
        paramString = this.C;
        localObject = Const.a(this.B);
        String str = this.D;
        if (str == null) {
          paramInt = i1;
        } else {
          paramInt = str.length();
        }
        QLog.i("LyricsController", 2, String.format("showLyrics[%s %s %d %s]", new Object[] { paramString, localObject, Integer.valueOf(paramInt), this.E }));
      }
      a(this.C);
      paramString = this.E;
      if (paramString != null) {
        b(this.C, this.D, paramString.booleanValue());
      }
      b(this.C, this.B);
      paramString = this.i;
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
      localStringBuilder.append(this.c);
      localStringBuilder.append(" mFloatParams:");
      localStringBuilder.append(this.d);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    if (this.d.d(paramInt, paramString))
    {
      this.d.c(0, null);
      if (!this.d.h)
      {
        paramString = this.d;
        paramString.h = true;
        paramString.i = true;
        paramString.u = false;
        if ((this.e) && (this.j != null) && (this.i != null) && (this.c))
        {
          if (paramString.e) {
            paramString = Paint.Align.RIGHT;
          } else {
            paramString = Paint.Align.LEFT;
          }
          this.j.o.setAlign(paramString);
          int i2 = this.j.getCurrentX();
          int i3 = this.i.getCurrentX();
          int i1;
          if (this.d.e)
          {
            paramInt = -this.j.getFloatWidth();
            i1 = -this.i.getFloatWidth();
          }
          else
          {
            paramInt = this.o;
            i1 = paramInt;
          }
          paramString = this.j;
          paramString.a(paramInt, paramString.getCurrentY());
          paramString = this.i;
          paramString.a(i1, paramString.getCurrentY());
          this.j.c();
          paramString = this.d;
          paramString.u = true;
          paramString.r = i2;
          paramString.s = i3;
          paramString.t = Paint.Align.CENTER;
        }
        ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
        paramInt = 300;
        if (paramBoolean) {
          paramInt = 500;
        }
        ThreadManager.getUIHandlerV2().postDelayed(this.F, paramInt);
      }
    }
    FloatViewSkin.a().a(this.i, this.d.n, this.d.m);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.C;
      int i1 = 0;
      if (paramString2 != null) {
        i1 = paramString2.length();
      }
      QLog.i("LyricsController", 2, String.format("onGetLyric [pre=%s,next=%s] netErr=%b lyric=%d %s", new Object[] { str, paramString1, Boolean.valueOf(paramBoolean), Integer.valueOf(i1), paramString2 }));
    }
    if ((paramString1 != null) && (paramString1.equals(this.C)))
    {
      this.D = paramString2;
      this.E = Boolean.valueOf(paramBoolean);
      if (this.e)
      {
        b(paramString1, paramString2, paramBoolean);
        b(this.C, this.B);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandlerV2().removeCallbacks(this.I);
    if (paramBoolean)
    {
      ThreadManager.getUIHandlerV2().postDelayed(this.I, 500L);
      return;
    }
    this.d.k = paramBoolean;
    if (this.e) {
      t();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClickLyrics mIsListenFloatShowing:");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    if (!this.e) {
      return;
    }
    if ((this.d.a()) && (BaseActivity.sTopActivity != null))
    {
      localObject = ActionSheet.create(BaseActivity.sTopActivity);
      boolean bool = ListenTogetherUtils.a();
      if (bool) {
        ((ActionSheet)localObject).addButton(2131891246);
      }
      ((ActionSheet)localObject).addButton(2131891221);
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnDismissListener(new LyricsController.8(this));
      ((ActionSheet)localObject).setOnCancelListener(new LyricsController.9(this));
      ((ActionSheet)localObject).setOnButtonClickListener(new LyricsController.10(this, (ActionSheet)localObject, bool));
      ((ActionSheet)localObject).show();
      b(true);
      ReportController.b(this.a, "dc00898", "", "", "qq_vip", "0X800A5C1", 1, 0, "", "", "", "");
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
    if (this.e)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        paramInt2 = ((FloatTextLayout)localObject).getFloatWidth();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("onLyricTextSizeChanged oldWidth:");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(" newWidth:");
          ((StringBuilder)localObject).append(paramInt1);
          QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
        }
        this.j.setFloatWidth(paramInt1);
        if ((this.d.j) && (!this.d.h)) {
          if (this.d.e) {
            this.d.a = (this.o / 2 - this.i.getFloatWidth() / 2 - this.j.getFloatWidth() / 2);
          } else {
            this.d.a = (this.o / 2 + this.i.getFloatWidth() / 2 + this.j.getFloatWidth() / 2);
          }
        }
        localObject = this.j;
        ((FloatTextLayout)localObject).a(((FloatTextLayout)localObject).c(this.d), this.j.d(this.d));
        this.j.b();
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
      localStringBuilder.append(this.d);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    if (!this.d.b(paramInt, paramString)) {
      return;
    }
    ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
    ThreadManager.getUIHandlerV2().removeCallbacks(this.x);
    s();
    this.e = false;
    this.d.a(0, null);
    this.g = -1;
    this.h = null;
    this.f = false;
    this.w = 0;
    r();
    FloatViewSkin.a().d();
  }
  
  protected void b(int paramInt, String paramString, boolean paramBoolean)
  {
    synchronized (this.b)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      paramString = localStringBuilder.toString();
      if (paramBoolean) {
        this.b.add(paramString);
      } else if (this.b.contains(paramString)) {
        this.b.remove(paramString);
      }
      u();
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
    if (this.d.l != paramBoolean)
    {
      this.d.l = paramBoolean;
      if (this.e) {
        t();
      }
    }
  }
  
  public void c()
  {
    if ((this.e) && (!TextUtils.isEmpty(this.d.n)) && ((this.d.m == 2) || (this.d.m == 1)))
    {
      if (this.d.a()) {
        return;
      }
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d.m);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(this.d.n);
      localObject = ((StringBuilder)localObject).toString();
      int i1;
      if (((BaseActivity.sTopActivity instanceof SplashActivity)) && (SplashActivity.currentFragment == 1)) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((i1 == 0) && ((!this.q.containsKey(localObject)) || (!((Boolean)this.q.get(localObject)).booleanValue())))
      {
        localObject = AIOUtils.a(new Intent(localBaseApplication, ChatActivity.class), new int[] { 2 });
        ((Intent)localObject).putExtra("leftViewText", "");
      }
      else
      {
        localObject = new Intent(localBaseApplication, SplashActivity.class);
        if (i1 != 0) {
          i1 = 1;
        } else {
          i1 = 2;
        }
        localObject = AIOUtils.a((Intent)localObject, new int[] { i1 });
      }
      ((Intent)localObject).putExtra("uin", this.d.n);
      if (this.d.m == 2)
      {
        ((Intent)localObject).putExtra("uintype", 0);
      }
      else
      {
        ((Intent)localObject).putExtra("uintype", 1);
        ((Intent)localObject).putExtra("troop_uin", this.d.n);
      }
      ((Intent)localObject).addFlags(268435456);
      localBaseApplication.startActivity((Intent)localObject);
      localObject = this.a;
      if (FloatViewSkin.a().b()) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      ReportController.b((AppRuntime)localObject, "dc00898", "", "", "qq_vip", "0X800A5C0", i1, 0, "", "", VipUtils.a(this.a), "");
    }
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
    if (this.d.l != paramBoolean)
    {
      this.d.l = paramBoolean;
      if (this.e)
      {
        ThreadManager.getUIHandlerV2().removeCallbacks(this.F);
        ThreadManager.getUIHandlerV2().postDelayed(this.F, 500L);
      }
    }
  }
  
  public boolean c(int paramInt, String paramString)
  {
    for (;;)
    {
      synchronized (this.b)
      {
        Set localSet = this.b;
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
            ((StringBuilder)???).append(this.b);
            QLog.i("LyricsController", 2, ((StringBuilder)???).toString());
          }
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void d()
  {
    if (this.a != null)
    {
      int i1 = this.d.m;
      String str = this.d.n;
      this.u = new LyricsController.11(this);
      ListenTogetherManager.a(this.a).a(i1, str, this.u);
    }
  }
  
  public void d(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onEnterAIO, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" mFloatParams:");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(" mIsForeground:");
      ((StringBuilder)localObject).append(this.c);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    this.d.c(paramInt, paramString);
    boolean bool = this.d.b(paramInt, paramString) ^ true;
    if (bool != this.d.h)
    {
      localObject = this.d;
      ((FloatParams)localObject).h = bool;
      if (this.c) {
        ((FloatParams)localObject).i = true;
      }
      t();
    }
    if ((BaseActivity.sTopActivity instanceof SplashActivity))
    {
      localObject = this.q;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("_");
      localStringBuilder.append(paramString);
      ((HashMap)localObject).put(localStringBuilder.toString(), Boolean.TRUE);
      return;
    }
    Object localObject = this.q;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).put(localStringBuilder.toString(), Boolean.FALSE);
  }
  
  public void e()
  {
    b(this.d.m, this.d.n);
    Object localObject = this.i;
    if (localObject != null) {
      ((FloatIconLayout)localObject).e();
    }
    localObject = this.j;
    if (localObject != null) {
      ((FloatTextLayout)localObject).e();
    }
    BaseApplicationImpl.getContext().unregisterReceiver(this.H);
    this.a.removeObserver(this.v);
    r();
  }
  
  public void e(int paramInt, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestroyAIO, type:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uin:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", isForeground: ");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(" mFloatParams:");
      ((StringBuilder)localObject).append(this.d);
      QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.q;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    ((HashMap)localObject).remove(localStringBuilder.toString());
  }
  
  protected void f()
  {
    FloatViewSkin.a().a(this);
  }
  
  public boolean g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isListenFloatShowing : ");
      localStringBuilder.append(this.e);
      QLog.i("LyricsController", 2, localStringBuilder.toString());
    }
    return this.e;
  }
  
  public void h()
  {
    boolean bool = o();
    this.t = false;
    if (!bool)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("checkPermissionAndShowDialog in mIsFirstJoinTipsShowing:");
        ((StringBuilder)localObject).append(this.r);
        QLog.i("LyricsController", 2, ((StringBuilder)localObject).toString());
      }
      if (!this.r)
      {
        q();
        localObject = new Intent();
        ((Intent)localObject).putExtra("type", 2);
        ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
        ((Intent)localObject).setFlags(268435456);
        PublicFragmentActivity.Launcher.a(BaseApplicationImpl.getContext(), (Intent)localObject, PublicTransFragmentActivity.class, ListenTogetherOverlayFragment.class);
        this.f = true;
        this.w = 0;
        this.s = false;
      }
      else
      {
        this.s = true;
      }
    }
    else
    {
      this.s = false;
    }
    ThreadManager.getSubThreadHandler().post(new LyricsController.4(this, bool));
  }
  
  public void i()
  {
    Object localObject = this.d;
    ((FloatParams)localObject).f = true;
    ((FloatParams)localObject).l = false;
    t();
    int i1 = this.d.m;
    String str = this.d.n;
    b(i1, str, true);
    localObject = this.a;
    if (localObject != null)
    {
      ((ListenTogetherHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER)).notifyUI(14, true, new Object[] { Integer.valueOf(i1), str });
      ((ListenTogetherManager)this.a.getManager(QQManagerFactory.LISTEN_TOGETHER_MANAGER)).a(i1, str, "closeLyric", 0);
      if ((i1 == 2) && (!TextUtils.isEmpty(str)))
      {
        ReportController.b(null, "dc00899", "c2c_AIO", "", "music_tab", "clk_close", 0, 0, str, "", "", "");
        return;
      }
      if ((i1 == 1) && (!TextUtils.isEmpty(str)))
      {
        localObject = ((TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER)).f(str);
        if (localObject != null)
        {
          if (((TroopInfo)localObject).isTroopOwner(this.a.getCurrentUin()))
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
  
  public void j()
  {
    ValueAnimator localValueAnimator = this.A;
    if (localValueAnimator != null)
    {
      localValueAnimator.cancel();
      this.A = null;
    }
    int i1 = this.i.c(this.d);
    int i2 = this.i.d(this.d);
    int i3 = this.j.c(this.d);
    int i4 = this.j.d(this.d);
    int i5 = this.i.getCurrentX();
    int i6 = this.i.getCurrentY();
    int i7 = this.j.getCurrentX();
    int i8 = this.j.getCurrentY();
    if ((Math.abs(i5 - i1) < 10) && (Math.abs(i6 - i2) < 10) && (Math.abs(i7 - i3) < 10) && (Math.abs(i8 - i4) < 10))
    {
      this.i.a(i1, i2);
      this.j.a(i3, i4);
      return;
    }
    this.A = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.A.setInterpolator(new LinearInterpolator());
    this.A.setDuration(250L);
    this.A.addUpdateListener(new LyricsController.13(this, i5, i1, i6, i2, i7, i3, i8, i4));
    this.A.addListener(new LyricsController.14(this, i1, i2, i3, i4));
    this.A.start();
  }
  
  protected void k()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    Object localObject3 = ((QQAppInterface)localObject1).getPreferences();
    localObject1 = ((SharedPreferences)localObject3).getStringSet("listen_together_lyric_user_closes", null);
    FloatParams localFloatParams = this.d;
    localFloatParams.a = ((SharedPreferences)localObject3).getInt("listen_together_float_loc_icon_cx", localFloatParams.a);
    localFloatParams = this.d;
    localFloatParams.b = ((SharedPreferences)localObject3).getInt("listen_together_float_loc_icon_cy", localFloatParams.b);
    localFloatParams = this.d;
    localFloatParams.e = ((SharedPreferences)localObject3).getBoolean("listen_together_float_align_right", localFloatParams.e);
    localObject3 = this.b;
    if (localObject1 != null) {}
    try
    {
      if (!((Set)localObject1).isEmpty()) {
        this.b.addAll((Collection)localObject1);
      }
      return;
    }
    finally {}
  }
  
  public FloatParams l()
  {
    return this.d;
  }
  
  public void m() {}
  
  public void n()
  {
    if (this.i != null) {
      ThreadManager.getUIHandlerV2().post(new LyricsController.15(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.lyrics.LyricsController
 * JD-Core Version:    0.7.0.1
 */