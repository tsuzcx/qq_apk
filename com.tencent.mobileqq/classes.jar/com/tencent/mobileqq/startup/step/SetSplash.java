package com.tencent.mobileqq.startup.step;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.splashad.SplashADUtil;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vassplash.common.VasSplashUtil;
import com.tencent.mobileqq.vassplash.model.SplashItem;
import com.tencent.mobileqq.vassplash.model.SplashUIdata;
import com.tencent.mobileqq.vassplash.model.SplashUIdata.Builder;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import cooperation.vip.common.VipHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class SetSplash
  extends Step
{
  protected static WeakReference<View> b;
  public static Runnable c = new SetSplash.12();
  private static boolean d;
  private static SetSplash.SplashAnimListener e;
  public boolean a = true;
  
  private static int a(String paramString)
  {
    int i = Calendar.getInstance().get(1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      paramString = ((SimpleDateFormat)localObject).parse(paramString);
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(paramString);
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      paramString = ((Calendar)localObject).getTime();
      localObject = Calendar.getInstance();
      ((Calendar)localObject).set(11, 0);
      ((Calendar)localObject).set(12, 0);
      ((Calendar)localObject).set(13, 0);
      ((Calendar)localObject).set(14, 0);
      localObject = ((Calendar)localObject).getTime();
      long l = (paramString.getTime() - ((Date)localObject).getTime()) / 86400000L;
      return (int)l;
    }
    catch (Exception paramString)
    {
      label174:
      break label174;
    }
    return -1;
  }
  
  private static AnimationDrawable a(Context paramContext, StartupDirector paramStartupDirector)
  {
    for (;;)
    {
      int k;
      int m;
      int n;
      try
      {
        Object localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext);
        String str = ((SharedPreferences)localObject1).getString("dynamic_splash_config_md5", null);
        k = ((SharedPreferences)localObject1).getInt("dynamic_splash_config_play_times", -1);
        m = ((SharedPreferences)localObject1).getInt("dynamic_splash_config_play_internal", -1);
        if ((!TextUtils.isEmpty(str)) && (k > 0))
        {
          if (m <= 0) {
            return null;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
          ((StringBuilder)localObject1).append("/dynamicSplash");
          localObject1 = ((StringBuilder)localObject1).toString();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("/");
          ((StringBuilder)localObject2).append(str);
          str = ((StringBuilder)localObject2).toString();
          localObject1 = new File(str);
          if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
          {
            localObject1 = ((File)localObject1).listFiles();
            if (localObject1 == null) {
              return null;
            }
            n = localObject1.length - 1;
            if (n <= 0) {
              return null;
            }
            localObject1 = new AnimationDrawable();
            localObject2 = new BitmapFactory.Options();
            ((BitmapFactory.Options)localObject2).inPreferredConfig = Bitmap.Config.RGB_565;
            i = 1;
            j = 0;
            if (i > n) {
              break label485;
            }
            Object localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append(str);
            ((StringBuilder)localObject3).append("/");
            ((StringBuilder)localObject3).append(String.valueOf(i));
            ((StringBuilder)localObject3).append(".png");
            localObject3 = new File(((StringBuilder)localObject3).toString());
            if (!((File)localObject3).exists()) {
              break label483;
            }
            if (((File)localObject3).length() <= 0L) {
              return null;
            }
            localObject3 = BitmapManager.a(((File)localObject3).getAbsolutePath(), (BitmapFactory.Options)localObject2);
            if (localObject3 == null) {
              break label476;
            }
            ((AnimationDrawable)localObject1).addFrame(new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject3), m);
            j = 1;
            break label476;
            if (QLog.isColorLevel())
            {
              paramContext = new StringBuilder();
              paramContext.append("getDynamicSplashDrawable() playTimes=");
              paramContext.append(k);
              paramContext.append(", playInterval=");
              paramContext.append(m);
              paramContext.append(", totalFilesCount=");
              paramContext.append(n);
              paramContext.append(", totalPlayTime=");
              paramContext.append(i);
              QLog.d("SetSplash", 2, paramContext.toString());
            }
            ThreadManager.post(new SetSplash.10(), 5, null, false);
            if (paramStartupDirector != null) {
              paramStartupDirector.g = i;
            }
            return localObject1;
          }
        }
        return null;
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "", paramContext);
        }
        return null;
      }
      label476:
      i += 1;
      continue;
      label483:
      return null;
      label485:
      if (j == 0) {
        return null;
      }
      int j = k * m * n;
      if (j <= 0) {
        return null;
      }
      int i = j;
      if (j > 5000) {
        i = 5000;
      }
    }
  }
  
  private static SplashADView a(Activity paramActivity, SplashUIdata paramSplashUIdata, StartupDirector paramStartupDirector)
  {
    SplashADView localSplashADView = SplashADView.a(paramSplashUIdata, paramActivity);
    localSplashADView.setOnClickListener(new SetSplash.2(paramStartupDirector));
    if (paramSplashUIdata.a == 2)
    {
      localSplashADView.setOnErrorListener(new SetSplash.3(paramStartupDirector));
      localSplashADView.setPresenter(new SetSplash.4((ImageView)paramActivity.findViewById(2131446244), (ImageView)paramActivity.findViewById(2131446247)));
    }
    return localSplashADView;
  }
  
  public static void a(long paramLong)
  {
    View localView = d();
    if (localView != null) {
      localView.postDelayed(new SetSplash.11(), paramLong);
    }
  }
  
  public static void a(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startSplashAnim:");
    localStringBuilder.append(paramView);
    localStringBuilder.append(" bannerView height:");
    Object localObject;
    if (paramView != null) {
      localObject = Integer.valueOf(paramView.getHeight());
    } else {
      localObject = "0";
    }
    localStringBuilder.append(localObject);
    localStringBuilder.append(" sSplashAnimListener:");
    localStringBuilder.append(e);
    QLog.i("SetSplash", 1, localStringBuilder.toString());
    if ((paramView != null) && (paramView.getHeight() > 0))
    {
      localObject = e;
      if (localObject != null)
      {
        a(paramView, (SetSplash.SplashAnimListener)localObject);
        e = null;
      }
    }
  }
  
  public static void a(View paramView, SetSplash.SplashAnimListener paramSplashAnimListener)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("startSplashAnim:");
    ((StringBuilder)localObject).append(paramView);
    ((StringBuilder)localObject).append(" listener:");
    ((StringBuilder)localObject).append(paramSplashAnimListener);
    ((StringBuilder)localObject).append(" sSplashView:");
    ((StringBuilder)localObject).append(b);
    QLog.i("SetSplash", 1, ((StringBuilder)localObject).toString());
    StartupTracker.a("splashCost", null);
    localObject = d();
    if (localObject == null)
    {
      QLog.w("SetSplash", 1, "splashView is null, anim End:");
      b(paramSplashAnimListener);
      return;
    }
    if ((paramView != null) && (paramView.getHeight() > 0))
    {
      Runnable localRunnable = c;
      if (localRunnable != null) {
        ((View)localObject).removeCallbacks(localRunnable);
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      a(paramSplashAnimListener, localObject[1], paramView.getHeight());
      return;
    }
    if (e())
    {
      if (localObject != null) {
        ((View)localObject).postDelayed(c, 1000L);
      }
      e = paramSplashAnimListener;
      return;
    }
    b(paramSplashAnimListener);
  }
  
  private static void a(SetSplash.SplashAnimListener paramSplashAnimListener, int paramInt1, int paramInt2)
  {
    View localView = d();
    if ((localView != null) && (paramInt2 != 0))
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        b(paramSplashAnimListener);
        return;
      }
      c();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adView:");
      ((StringBuilder)localObject).append(localView);
      ((StringBuilder)localObject).append(" listener:");
      ((StringBuilder)localObject).append(e);
      QLog.i("SetSplash", 1, ((StringBuilder)localObject).toString());
      localObject = ValueAnimator.ofFloat(new float[] { 1.0F });
      ((ValueAnimator)localObject).setDuration(800L);
      if (Build.VERSION.SDK_INT >= 21) {
        ((ValueAnimator)localObject).setInterpolator(new PathInterpolator(0.65F, 0.0F, 0.28F, 1.0F));
      }
      localView.setClipToOutline(true);
      d = false;
      ((ValueAnimator)localObject).addUpdateListener(new SetSplash.13(paramInt1, localView.getHeight(), paramInt2, localView, paramSplashAnimListener));
      ((ValueAnimator)localObject).start();
      return;
    }
    b(paramSplashAnimListener);
  }
  
  public static boolean a()
  {
    long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= l1 + 86400000L)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      Object localObject2 = BaseApplicationImpl.sApplication;
      Object localObject1 = ((Context)localObject2).getFilesDir();
      if (localObject1 != null) {
        localObject1 = ((File)localObject1).getAbsolutePath();
      } else {
        localObject1 = "/data/data/com.tencent.mobileqq/files";
      }
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("/splashpic");
      localObject3 = new File(((StringBuilder)localObject3).toString());
      Object localObject4;
      if ((((File)localObject3).exists()) && (((File)localObject3).isDirectory()))
      {
        localObject3 = ((File)localObject3).listFiles();
        if (localObject3 != null)
        {
          int j = localObject3.length;
          l1 = 0L;
          l2 = l1;
          int i = 0;
          while (i < j)
          {
            localObject4 = localObject3[i];
            long l4 = l1;
            long l3 = l2;
            if (localObject4 != null)
            {
              localObject4 = ((File)localObject4).getName().split("_");
              l4 = l1;
              l3 = l2;
              if (localObject4 != null)
              {
                l4 = l1;
                l3 = l2;
                if (localObject4.length == 3)
                {
                  localObject4 = localObject4[0];
                  if ((localObject4 == null) || (((String)localObject4).trim().equals(""))) {}
                }
              }
            }
            try
            {
              int k = ((String)localObject4).indexOf("|");
              l1 = Long.parseLong(((String)localObject4).substring(0, k));
              l2 = Long.parseLong(((String)localObject4).substring(k + 1));
            }
            catch (Exception localException)
            {
              label289:
              break label289;
            }
            l2 = 0L;
            l1 = 0L;
            if (CommonUtil.a(l1, l2)) {
              return true;
            }
            l3 = l2;
            l4 = l1;
            i += 1;
            l1 = l4;
            l2 = l3;
          }
        }
      }
      localObject3 = SharedPreUtils.b(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel())
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("bir = ");
        ((StringBuilder)localObject4).append((String)localObject3);
        QLog.i("SetSplash", 2, ((StringBuilder)localObject4).toString());
      }
      if ((!((String)localObject3).equals("")) && (a((String)localObject3) == 0))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append(SharedPreUtils.a((Context)localObject2));
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append("birthdayflashlogo.png");
        localObject1 = new File(((StringBuilder)localObject3).toString());
        if ((((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      try
      {
        l1 = SplashADUtil.a(BaseApplicationImpl.getApplication());
        localObject1 = VasSplashUtil.a(BaseApplicationImpl.getContext(), l1);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject2 = BaseApplicationImpl.getContext();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append("");
          localObject2 = VasSplashUtil.b((Context)localObject2, ((StringBuilder)localObject3).toString());
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(l1);
          ((StringBuilder)localObject3).append("");
          localObject2 = VasSplashUtil.a(((StringBuilder)localObject3).toString(), (Set)localObject2);
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (String)((Iterator)localObject1).next();
            if ((((HashMap)localObject2).containsKey(localObject3)) && (((SplashItem)((HashMap)localObject2).get(localObject3)).a()))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SetSplash", 2, "vassplash should show kill");
              }
              return true;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("SetSplash", 2, "erro", localThrowable);
      }
      return false;
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetSplash", 2, "now time less than last show time");
      }
      return false;
    }
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      localObject1 = PreferenceManager.getDefaultSharedPreferences(paramContext);
      localObject2 = ((SharedPreferences)localObject1).getString("dynamic_splash_config_effective_time", null);
      paramContext = ((SharedPreferences)localObject1).getString("dynamic_splash_config_md5", null);
      l3 = ((SharedPreferences)localObject1).getLong("dynamic_splash_config_folder_modify_time", -1L);
      if (((SharedPreferences)localObject1).getInt("dynamic_splash_config_show_times", -1) <= 0) {
        return false;
      }
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      if (bool) {}
    }
    catch (Throwable paramContext)
    {
      Object localObject1;
      Object localObject2;
      long l3;
      int i;
      long l1;
      long l2;
      label109:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("needShowDynamicSplash() ERROR msg=");
        ((StringBuilder)localObject1).append(paramContext.getMessage());
        QLog.d("SetSplash", 2, ((StringBuilder)localObject1).toString());
      }
      return false;
    }
    try
    {
      i = ((String)localObject2).indexOf("|");
      l1 = Long.parseLong(((String)localObject2).substring(0, i));
      l2 = Long.parseLong(((String)localObject2).substring(i + 1));
    }
    catch (Exception localException)
    {
      break label109;
    }
    l1 = 0L;
    l2 = l1;
    if (!CommonUtil.a(l1, l2))
    {
      if (QLog.isColorLevel())
      {
        QLog.d("SetSplash", 2, "needShowDynamicSplash() the current time is not effective");
        return false;
      }
    }
    else
    {
      if (l3 >= 0L)
      {
        if (TextUtils.isEmpty(paramContext)) {
          return false;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath());
        ((StringBuilder)localObject1).append("/dynamicSplash");
        localObject1 = ((StringBuilder)localObject1).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append(paramContext);
        paramContext = new File(((StringBuilder)localObject2).toString());
        if ((paramContext.exists()) && (paramContext.isDirectory()) && (l3 == paramContext.lastModified()) && (DeviceInfoUtil.a() >= 805306368L)) {
          return true;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "needShowDynamicSplash() the folder of splash is modified, NOT show");
        }
      }
      return false;
    }
    return false;
  }
  
  private static boolean a(AppActivity paramAppActivity, StartupDirector paramStartupDirector, ImageView paramImageView1, ImageView paramImageView2)
  {
    long l = SplashADUtil.a(BaseApplicationImpl.getApplication());
    if (SafeModeUtil.a(BaseApplicationImpl.getApplication()))
    {
      VasSplashUtil.a(BaseApplicationImpl.getApplication(), l, true);
      return false;
    }
    if (!VasSplashUtil.a(l))
    {
      QLog.i("QSplash@VasSplashUtil", 1, "don't show splash");
      return false;
    }
    SplashItem localSplashItem = VasSplashUtil.f;
    if (localSplashItem == null)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "splashItem  == null");
      return false;
    }
    if (localSplashItem.e == 1)
    {
      VasSplashUtil.a(localSplashItem.b, l, false);
      return false;
    }
    BaseApplicationImpl.sLaunchTime = 0L;
    BaseApplicationImpl.sShowTime = 0L;
    QLog.i("QSplash@VasSplashUtil", 1, "ready show Splash");
    i();
    if (!SplashADUtil.a(paramAppActivity)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show Splash AD, uin = ");
    ((StringBuilder)localObject).append(l % 10000L);
    ((StringBuilder)localObject).append("，adId:");
    ((StringBuilder)localObject).append(localSplashItem.b);
    QLog.i("splash.tag.", 1, ((StringBuilder)localObject).toString());
    if (localSplashItem.g == 1)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "preLoad web");
      ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).preloadWebProcess(-1);
      VasSplashUtil.d = true;
    }
    if (localSplashItem.g == 2)
    {
      VipHandler.a();
      ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).preloadProcess();
    }
    if (localSplashItem.g == 3)
    {
      VipHandler.a();
      ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).preloadGameProcess();
    }
    localObject = new SplashUIdata.Builder();
    ((SplashUIdata.Builder)localObject).a(localSplashItem.e).a(localSplashItem.k).c(localSplashItem.k).b(localSplashItem.p).c(1).b(localSplashItem.n).d(localSplashItem.g).d(localSplashItem.h).e(localSplashItem.t).f(localSplashItem.u).g(localSplashItem.v).e(localSplashItem.w).h(localSplashItem.x).i(localSplashItem.y);
    paramStartupDirector.a(new SetSplash.VasSplashCallBack(localSplashItem, b(paramAppActivity, ((SplashUIdata.Builder)localObject).a(), paramStartupDirector), paramImageView2, paramImageView1, paramAppActivity));
    return true;
  }
  
  /* Error */
  public static boolean a(AppActivity paramAppActivity, StartupDirector paramStartupDirector, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: ldc_w 735
    //   4: ldc 231
    //   6: ldc 231
    //   8: ldc_w 737
    //   11: ldc_w 737
    //   14: invokestatic 739	com/tencent/mobileqq/startup/step/SetSplash:h	()I
    //   17: iconst_0
    //   18: ldc 231
    //   20: ldc 231
    //   22: ldc 231
    //   24: ldc 231
    //   26: invokestatic 744	com/tencent/mobileqq/statistics/ReportController:b	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   29: getstatic 363	android/os/Build$VERSION:SDK_INT	I
    //   32: bipush 26
    //   34: if_icmplt +100 -> 134
    //   37: ldc_w 746
    //   40: invokestatic 752	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   43: astore 18
    //   45: aload 18
    //   47: ldc_w 754
    //   50: iconst_1
    //   51: anewarray 748	java/lang/Class
    //   54: dup
    //   55: iconst_0
    //   56: ldc_w 266
    //   59: aastore
    //   60: invokevirtual 758	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   63: aload 18
    //   65: iconst_1
    //   66: anewarray 760	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_0
    //   72: aastore
    //   73: invokevirtual 766	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   76: checkcast 768	java/lang/Boolean
    //   79: invokevirtual 771	java/lang/Boolean:booleanValue	()Z
    //   82: istore 9
    //   84: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +47 -> 134
    //   90: ldc 211
    //   92: iconst_2
    //   93: iconst_2
    //   94: anewarray 760	java/lang/Object
    //   97: dup
    //   98: iconst_0
    //   99: ldc_w 773
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: iload 9
    //   107: invokestatic 776	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   110: aastore
    //   111: invokestatic 779	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   114: goto +20 -> 134
    //   117: astore_1
    //   118: goto +2263 -> 2381
    //   121: astore 18
    //   123: ldc 211
    //   125: iconst_1
    //   126: ldc_w 781
    //   129: aload 18
    //   131: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: aload_0
    //   135: instanceof 783
    //   138: ifeq +16 -> 154
    //   141: aload_0
    //   142: checkcast 783	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   145: ldc_w 784
    //   148: invokevirtual 787	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   151: goto +10 -> 161
    //   154: aload_0
    //   155: ldc_w 784
    //   158: invokevirtual 792	mqq/app/AppActivity:setContentView	(I)V
    //   161: aload_0
    //   162: ldc_w 264
    //   165: invokevirtual 793	mqq/app/AppActivity:findViewById	(I)Landroid/view/View;
    //   168: checkcast 272	android/widget/ImageView
    //   171: astore 21
    //   173: aload_0
    //   174: ldc_w 273
    //   177: invokevirtual 793	mqq/app/AppActivity:findViewById	(I)Landroid/view/View;
    //   180: checkcast 272	android/widget/ImageView
    //   183: astore 20
    //   185: aload 21
    //   187: ifnull +2192 -> 2379
    //   190: aload 20
    //   192: ifnonnull +6 -> 198
    //   195: goto +2184 -> 2379
    //   198: aload_0
    //   199: invokestatic 484	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   202: astore 19
    //   204: aload_0
    //   205: invokevirtual 794	mqq/app/AppActivity:getFilesDir	()Ljava/io/File;
    //   208: astore 22
    //   210: aload 22
    //   212: ifnull +13 -> 225
    //   215: aload 22
    //   217: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   220: astore 18
    //   222: goto +8 -> 230
    //   225: ldc_w 439
    //   228: astore 18
    //   230: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +39 -> 272
    //   236: new 42	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   243: astore 23
    //   245: aload 23
    //   247: aload 19
    //   249: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 23
    //   255: aload 22
    //   257: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: ldc 211
    //   263: iconst_2
    //   264: aload 23
    //   266: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   269: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload 22
    //   274: ifnull +237 -> 511
    //   277: aload 19
    //   279: ldc 231
    //   281: invokevirtual 457	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifne +227 -> 511
    //   287: aload 19
    //   289: invokestatic 488	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/lang/String;)I
    //   292: ifne +219 -> 511
    //   295: new 42	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   302: astore 19
    //   304: aload 19
    //   306: aload 18
    //   308: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload 19
    //   314: ldc 138
    //   316: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 19
    //   322: aload_0
    //   323: invokestatic 490	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   326: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 19
    //   332: ldc 138
    //   334: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload 19
    //   340: ldc_w 492
    //   343: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   346: pop
    //   347: aload 19
    //   349: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: astore 19
    //   354: new 131	java/io/File
    //   357: dup
    //   358: aload 19
    //   360: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: astore 22
    //   365: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   368: ifeq +51 -> 419
    //   371: new 42	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   378: astore 23
    //   380: aload 23
    //   382: aload 19
    //   384: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload 23
    //   390: ldc_w 796
    //   393: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 23
    //   399: aload 22
    //   401: invokevirtual 143	java/io/File:exists	()Z
    //   404: invokevirtual 799	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: ldc 211
    //   410: iconst_2
    //   411: aload 23
    //   413: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   416: invokestatic 801	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   419: aload 22
    //   421: invokevirtual 143	java/io/File:exists	()Z
    //   424: ifeq +87 -> 511
    //   427: new 183	android/graphics/drawable/BitmapDrawable
    //   430: dup
    //   431: aload_0
    //   432: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   435: aload 19
    //   437: invokestatic 805	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   440: invokespecial 192	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   443: astore 19
    //   445: aload_1
    //   446: ifnull +18 -> 464
    //   449: aload_1
    //   450: ldc2_w 806
    //   453: putfield 229	com/tencent/mobileqq/startup/director/StartupDirector:g	J
    //   456: goto +8 -> 464
    //   459: astore 22
    //   461: goto +14 -> 475
    //   464: iconst_0
    //   465: istore 9
    //   467: goto +33 -> 500
    //   470: astore 22
    //   472: aconst_null
    //   473: astore 19
    //   475: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +14 -> 492
    //   481: ldc 211
    //   483: iconst_2
    //   484: ldc_w 809
    //   487: aload 22
    //   489: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   492: aload 22
    //   494: invokevirtual 812	java/lang/Throwable:printStackTrace	()V
    //   497: iconst_1
    //   498: istore 9
    //   500: aload 19
    //   502: ifnull +6 -> 508
    //   505: invokestatic 615	com/tencent/mobileqq/startup/step/SetSplash:i	()V
    //   508: goto +9 -> 517
    //   511: iconst_1
    //   512: istore 9
    //   514: aconst_null
    //   515: astore 19
    //   517: aload 18
    //   519: astore 23
    //   521: ldc_w 814
    //   524: astore 22
    //   526: aload 19
    //   528: ifnonnull +97 -> 625
    //   531: aload_1
    //   532: ifnull +93 -> 625
    //   535: aload_0
    //   536: aload_1
    //   537: aload 21
    //   539: aload 20
    //   541: invokestatic 816	com/tencent/mobileqq/startup/step/SetSplash:a	(Lmqq/app/AppActivity;Lcom/tencent/mobileqq/startup/director/StartupDirector;Landroid/widget/ImageView;Landroid/widget/ImageView;)Z
    //   544: istore 10
    //   546: iload 10
    //   548: ifeq +31 -> 579
    //   551: aload_1
    //   552: ldc2_w 817
    //   555: putfield 229	com/tencent/mobileqq/startup/director/StartupDirector:g	J
    //   558: iconst_1
    //   559: istore 9
    //   561: iconst_1
    //   562: istore 5
    //   564: iconst_0
    //   565: istore_2
    //   566: goto +26 -> 592
    //   569: astore 18
    //   571: iconst_1
    //   572: istore 9
    //   574: iconst_0
    //   575: istore_2
    //   576: goto +34 -> 610
    //   579: iload_2
    //   580: istore 10
    //   582: iload 9
    //   584: istore_2
    //   585: iconst_0
    //   586: istore 5
    //   588: iload 10
    //   590: istore 9
    //   592: iload_2
    //   593: istore 10
    //   595: goto +46 -> 641
    //   598: astore 18
    //   600: iload_2
    //   601: istore 10
    //   603: iload 9
    //   605: istore_2
    //   606: iload 10
    //   608: istore 9
    //   610: ldc_w 589
    //   613: iconst_1
    //   614: ldc_w 814
    //   617: aload 18
    //   619: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   622: goto +13 -> 635
    //   625: iload_2
    //   626: istore 10
    //   628: iload 9
    //   630: istore_2
    //   631: iload 10
    //   633: istore 9
    //   635: iconst_0
    //   636: istore 5
    //   638: iload_2
    //   639: istore 10
    //   641: aload 19
    //   643: astore 18
    //   645: iload 10
    //   647: istore_2
    //   648: aload 19
    //   650: ifnonnull +42 -> 692
    //   653: aload 19
    //   655: astore 18
    //   657: iload 10
    //   659: istore_2
    //   660: invokestatic 123	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   663: invokestatic 819	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;)Z
    //   666: ifeq +26 -> 692
    //   669: aload 19
    //   671: astore 18
    //   673: iload 10
    //   675: istore_2
    //   676: iload 5
    //   678: ifne +14 -> 692
    //   681: invokestatic 123	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   684: aload_1
    //   685: invokestatic 821	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Landroid/graphics/drawable/AnimationDrawable;
    //   688: astore 18
    //   690: iconst_0
    //   691: istore_2
    //   692: aload 18
    //   694: ifnonnull +742 -> 1436
    //   697: iload 5
    //   699: ifne +737 -> 1436
    //   702: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +13 -> 718
    //   708: ldc_w 823
    //   711: iconst_2
    //   712: ldc_w 825
    //   715: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   718: new 42	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   725: astore 19
    //   727: aload 19
    //   729: aload 23
    //   731: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload 19
    //   737: ldc_w 827
    //   740: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: pop
    //   744: aload 19
    //   746: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   749: astore 25
    //   751: new 42	java/lang/StringBuilder
    //   754: dup
    //   755: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   758: astore 19
    //   760: aload 19
    //   762: aload 23
    //   764: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: pop
    //   768: aload 19
    //   770: ldc_w 441
    //   773: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: pop
    //   777: new 131	java/io/File
    //   780: dup
    //   781: aload 19
    //   783: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   789: astore 19
    //   791: aload 19
    //   793: invokevirtual 143	java/io/File:exists	()Z
    //   796: ifeq +423 -> 1219
    //   799: aload 19
    //   801: invokevirtual 146	java/io/File:isDirectory	()Z
    //   804: ifeq +415 -> 1219
    //   807: aload 19
    //   809: invokevirtual 150	java/io/File:listFiles	()[Ljava/io/File;
    //   812: astore 24
    //   814: aload 24
    //   816: arraylength
    //   817: istore 6
    //   819: lconst_0
    //   820: lstore 12
    //   822: lload 12
    //   824: lstore 14
    //   826: iconst_0
    //   827: istore 7
    //   829: aconst_null
    //   830: astore 19
    //   832: iload 7
    //   834: iload 6
    //   836: if_icmpge +356 -> 1192
    //   839: aload 24
    //   841: iload 7
    //   843: aaload
    //   844: astore 26
    //   846: aload 26
    //   848: ifnull +319 -> 1167
    //   851: aload 26
    //   853: invokevirtual 444	java/io/File:getName	()Ljava/lang/String;
    //   856: astore 27
    //   858: aload 27
    //   860: ldc_w 446
    //   863: invokevirtual 450	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   866: astore 23
    //   868: aload 23
    //   870: ifnull +297 -> 1167
    //   873: aload 23
    //   875: arraylength
    //   876: iconst_3
    //   877: if_icmpne +287 -> 1164
    //   880: aload 23
    //   882: iconst_0
    //   883: aaload
    //   884: astore 28
    //   886: aload 28
    //   888: ifnull +66 -> 954
    //   891: aload 28
    //   893: invokevirtual 453	java/lang/String:trim	()Ljava/lang/String;
    //   896: ldc 231
    //   898: invokevirtual 457	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   901: ifne +53 -> 954
    //   904: aload 28
    //   906: ldc_w 459
    //   909: invokevirtual 462	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   912: istore 8
    //   914: aload 28
    //   916: iconst_0
    //   917: iload 8
    //   919: invokevirtual 466	java/lang/String:substring	(II)Ljava/lang/String;
    //   922: invokestatic 472	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   925: lstore 12
    //   927: aload 28
    //   929: iload 8
    //   931: iconst_1
    //   932: iadd
    //   933: invokevirtual 474	java/lang/String:substring	(I)Ljava/lang/String;
    //   936: invokestatic 472	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   939: lstore 14
    //   941: goto +13 -> 954
    //   944: lconst_0
    //   945: lstore 14
    //   947: lload 14
    //   949: lstore 12
    //   951: goto +15 -> 966
    //   954: lload 12
    //   956: lstore 16
    //   958: lload 14
    //   960: lstore 12
    //   962: lload 16
    //   964: lstore 14
    //   966: lload 14
    //   968: lload 12
    //   970: invokestatic 479	com/tencent/mobileqq/util/CommonUtil:a	(JJ)Z
    //   973: ifeq +59 -> 1032
    //   976: aload 19
    //   978: ifnonnull +47 -> 1025
    //   981: new 42	java/lang/StringBuilder
    //   984: dup
    //   985: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   988: astore 19
    //   990: aload 19
    //   992: aload 25
    //   994: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: pop
    //   998: aload 19
    //   1000: aload 23
    //   1002: iconst_1
    //   1003: aaload
    //   1004: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: pop
    //   1008: new 131	java/io/File
    //   1011: dup
    //   1012: aload 19
    //   1014: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1017: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   1020: astore 23
    //   1022: goto +84 -> 1106
    //   1025: aload 19
    //   1027: astore 23
    //   1029: goto +77 -> 1106
    //   1032: aload 19
    //   1034: astore 23
    //   1036: lload 12
    //   1038: invokestatic 432	java/lang/System:currentTimeMillis	()J
    //   1041: lcmp
    //   1042: ifge +64 -> 1106
    //   1045: new 42	java/lang/StringBuilder
    //   1048: dup
    //   1049: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1052: astore 23
    //   1054: aload 23
    //   1056: aload 25
    //   1058: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1061: pop
    //   1062: aload 23
    //   1064: aload 27
    //   1066: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: pop
    //   1070: new 131	java/io/File
    //   1073: dup
    //   1074: aload 23
    //   1076: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1079: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   1082: astore 27
    //   1084: aload 19
    //   1086: astore 23
    //   1088: aload 27
    //   1090: invokevirtual 143	java/io/File:exists	()Z
    //   1093: ifeq +13 -> 1106
    //   1096: aload 27
    //   1098: invokevirtual 830	java/io/File:delete	()Z
    //   1101: pop
    //   1102: aload 19
    //   1104: astore 23
    //   1106: invokestatic 201	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1109: ifeq +44 -> 1153
    //   1112: new 42	java/lang/StringBuilder
    //   1115: dup
    //   1116: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   1119: astore 19
    //   1121: aload 19
    //   1123: ldc_w 832
    //   1126: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: pop
    //   1130: aload 19
    //   1132: aload 26
    //   1134: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1137: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1140: pop
    //   1141: ldc_w 823
    //   1144: iconst_2
    //   1145: aload 19
    //   1147: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1150: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1153: aload 23
    //   1155: astore 19
    //   1157: lload 12
    //   1159: lstore 16
    //   1161: goto +14 -> 1175
    //   1164: goto +3 -> 1167
    //   1167: lload 14
    //   1169: lstore 16
    //   1171: lload 12
    //   1173: lstore 14
    //   1175: iload 7
    //   1177: iconst_1
    //   1178: iadd
    //   1179: istore 7
    //   1181: lload 14
    //   1183: lstore 12
    //   1185: lload 16
    //   1187: lstore 14
    //   1189: goto -357 -> 832
    //   1192: aload 21
    //   1194: astore 23
    //   1196: aload 19
    //   1198: astore 26
    //   1200: aload 18
    //   1202: astore 21
    //   1204: aload 20
    //   1206: astore 18
    //   1208: aload 23
    //   1210: astore 19
    //   1212: aload 22
    //   1214: astore 20
    //   1216: goto +31 -> 1247
    //   1219: aload 21
    //   1221: astore 19
    //   1223: aload 20
    //   1225: astore 21
    //   1227: aload 18
    //   1229: astore 22
    //   1231: ldc_w 814
    //   1234: astore 20
    //   1236: aconst_null
    //   1237: astore 26
    //   1239: aload 21
    //   1241: astore 18
    //   1243: aload 22
    //   1245: astore 21
    //   1247: aload 21
    //   1249: astore 25
    //   1251: aload 18
    //   1253: astore 22
    //   1255: aload 19
    //   1257: astore 23
    //   1259: aload 20
    //   1261: astore 24
    //   1263: aload 26
    //   1265: ifnull +188 -> 1453
    //   1268: aload 21
    //   1270: astore 25
    //   1272: aload 18
    //   1274: astore 22
    //   1276: aload 19
    //   1278: astore 23
    //   1280: aload 20
    //   1282: astore 24
    //   1284: aload 26
    //   1286: invokevirtual 143	java/io/File:exists	()Z
    //   1289: ifeq +164 -> 1453
    //   1292: aload 21
    //   1294: astore 25
    //   1296: aload 18
    //   1298: astore 22
    //   1300: aload 19
    //   1302: astore 23
    //   1304: aload 20
    //   1306: astore 24
    //   1308: aload 26
    //   1310: invokevirtual 835	java/io/File:isFile	()Z
    //   1313: ifeq +140 -> 1453
    //   1316: new 183	android/graphics/drawable/BitmapDrawable
    //   1319: dup
    //   1320: aload_0
    //   1321: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1324: aload 26
    //   1326: invokevirtual 134	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1329: invokestatic 805	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1332: invokespecial 192	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   1335: astore 23
    //   1337: aload_1
    //   1338: ifnull +20 -> 1358
    //   1341: aload_1
    //   1342: ldc2_w 836
    //   1345: putfield 229	com/tencent/mobileqq/startup/director/StartupDirector:g	J
    //   1348: goto +10 -> 1358
    //   1351: astore 21
    //   1353: iconst_0
    //   1354: istore_2
    //   1355: goto +19 -> 1374
    //   1358: iconst_0
    //   1359: istore 10
    //   1361: goto +26 -> 1387
    //   1364: astore 22
    //   1366: aload 21
    //   1368: astore 23
    //   1370: aload 22
    //   1372: astore 21
    //   1374: ldc 211
    //   1376: iconst_1
    //   1377: ldc 231
    //   1379: aload 21
    //   1381: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1384: iload_2
    //   1385: istore 10
    //   1387: aload 23
    //   1389: astore 22
    //   1391: iload 10
    //   1393: istore_2
    //   1394: aload 18
    //   1396: astore 24
    //   1398: aload 19
    //   1400: astore 21
    //   1402: aload 20
    //   1404: astore 25
    //   1406: aload 23
    //   1408: ifnull +65 -> 1473
    //   1411: invokestatic 615	com/tencent/mobileqq/startup/step/SetSplash:i	()V
    //   1414: aload 23
    //   1416: astore 22
    //   1418: iload 10
    //   1420: istore_2
    //   1421: aload 18
    //   1423: astore 24
    //   1425: aload 19
    //   1427: astore 21
    //   1429: aload 20
    //   1431: astore 25
    //   1433: goto +40 -> 1473
    //   1436: ldc_w 814
    //   1439: astore 24
    //   1441: aload 21
    //   1443: astore 23
    //   1445: aload 20
    //   1447: astore 22
    //   1449: aload 18
    //   1451: astore 25
    //   1453: aload 25
    //   1455: astore 18
    //   1457: aload 24
    //   1459: astore 25
    //   1461: aload 23
    //   1463: astore 21
    //   1465: aload 22
    //   1467: astore 24
    //   1469: aload 18
    //   1471: astore 22
    //   1473: aload 22
    //   1475: ifnonnull +241 -> 1716
    //   1478: aload_1
    //   1479: ifnull +237 -> 1716
    //   1482: iload 5
    //   1484: ifne +232 -> 1716
    //   1487: ldc_w 649
    //   1490: invokestatic 638	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1493: checkcast 649	com/tencent/mobileqq/mini/api/ISplashMiniGameStarterService
    //   1496: astore 18
    //   1498: aload 18
    //   1500: invokeinterface 840 1 0
    //   1505: istore 10
    //   1507: iload 10
    //   1509: ifne +6 -> 1515
    //   1512: goto +174 -> 1686
    //   1515: ldc_w 842
    //   1518: iconst_1
    //   1519: ldc_w 613
    //   1522: invokestatic 319	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1525: invokestatic 615	com/tencent/mobileqq/startup/step/SetSplash:i	()V
    //   1528: aload_0
    //   1529: invokestatic 618	com/tencent/mobileqq/splashad/SplashADUtil:a	(Landroid/app/Activity;)Z
    //   1532: istore 11
    //   1534: aload 18
    //   1536: invokeinterface 846 1 0
    //   1541: astore 19
    //   1543: iload 11
    //   1545: ifeq +129 -> 1674
    //   1548: iload 10
    //   1550: ifeq +124 -> 1674
    //   1553: aload 19
    //   1555: ifnull +119 -> 1674
    //   1558: new 657	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder
    //   1561: dup
    //   1562: invokespecial 658	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:<init>	()V
    //   1565: astore 20
    //   1567: aload 20
    //   1569: iconst_2
    //   1570: invokevirtual 661	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	(I)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1573: astore 23
    //   1575: aload 23
    //   1577: aconst_null
    //   1578: invokevirtual 667	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1581: iconst_0
    //   1582: invokevirtual 674	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:b	(I)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1585: astore 23
    //   1587: aload 23
    //   1589: iconst_1
    //   1590: invokevirtual 676	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:c	(I)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1593: astore 23
    //   1595: aload 23
    //   1597: aload 19
    //   1599: getfield 851	com/tencent/mobileqq/minigame/splash/SplashMiniGameData:videoLocalPath	Ljava/lang/String;
    //   1602: invokevirtual 669	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1605: astore 23
    //   1607: aload 19
    //   1609: getfield 854	com/tencent/mobileqq/minigame/splash/SplashMiniGameData:videoMute	I
    //   1612: ifne +795 -> 2407
    //   1615: iconst_1
    //   1616: istore 10
    //   1618: goto +3 -> 1621
    //   1621: aload 23
    //   1623: iload 10
    //   1625: invokevirtual 857	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1628: iconst_0
    //   1629: invokevirtual 859	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:b	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1632: pop
    //   1633: aload 20
    //   1635: invokevirtual 722	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	()Lcom/tencent/mobileqq/vassplash/model/SplashUIdata;
    //   1638: astore 19
    //   1640: aload_1
    //   1641: new 861	com/tencent/mobileqq/startup/step/SetSplash$1
    //   1644: dup
    //   1645: aload 19
    //   1647: aload_0
    //   1648: aload 19
    //   1650: aload_1
    //   1651: invokestatic 863	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/vassplash/model/SplashUIdata;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Lcom/tencent/mobileqq/splashad/SplashADView;
    //   1654: aload_0
    //   1655: aload 18
    //   1657: invokespecial 866	com/tencent/mobileqq/startup/step/SetSplash$1:<init>	(Ljava/lang/Object;Lcom/tencent/mobileqq/splashad/SplashADView;Lmqq/app/AppActivity;Lcom/tencent/mobileqq/mini/api/ISplashMiniGameStarterService;)V
    //   1660: invokevirtual 730	com/tencent/mobileqq/startup/director/StartupDirector:a	(Lcom/tencent/mobileqq/startup/director/StartupDirector$SplashCallBack;)V
    //   1663: goto +11 -> 1674
    //   1666: astore_1
    //   1667: goto +32 -> 1699
    //   1670: astore_1
    //   1671: goto +32 -> 1703
    //   1674: aload_1
    //   1675: ldc2_w 817
    //   1678: putfield 229	com/tencent/mobileqq/startup/director/StartupDirector:g	J
    //   1681: iconst_1
    //   1682: istore 9
    //   1684: iconst_0
    //   1685: istore_2
    //   1686: goto +30 -> 1716
    //   1689: astore_1
    //   1690: iconst_1
    //   1691: istore 9
    //   1693: iconst_0
    //   1694: istore_2
    //   1695: goto +8 -> 1703
    //   1698: astore_1
    //   1699: goto +4 -> 1703
    //   1702: astore_1
    //   1703: ldc_w 842
    //   1706: iconst_1
    //   1707: aload 25
    //   1709: aload_1
    //   1710: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1713: goto +3 -> 1716
    //   1716: aconst_null
    //   1717: astore 23
    //   1719: aconst_null
    //   1720: astore 19
    //   1722: aload 23
    //   1724: astore 18
    //   1726: aload 22
    //   1728: astore_1
    //   1729: aload 22
    //   1731: ifnonnull +299 -> 2030
    //   1734: aload 23
    //   1736: astore 18
    //   1738: aload 22
    //   1740: astore_1
    //   1741: iload 9
    //   1743: ifeq +287 -> 2030
    //   1746: invokestatic 871	com/tencent/widget/immersive/ImmersiveUtils:isSupporImmersive	()I
    //   1749: iconst_1
    //   1750: if_icmpne +33 -> 1783
    //   1753: invokestatic 876	com/tencent/mobileqq/utils/QQTheme:isNowSimpleUI	()Z
    //   1756: ifeq +27 -> 1783
    //   1759: aload_0
    //   1760: invokevirtual 880	mqq/app/AppActivity:getWindow	()Landroid/view/Window;
    //   1763: ldc_w 881
    //   1766: invokevirtual 886	android/view/Window:addFlags	(I)V
    //   1769: goto +14 -> 1783
    //   1772: astore_1
    //   1773: ldc 211
    //   1775: iconst_1
    //   1776: ldc_w 888
    //   1779: aload_1
    //   1780: invokestatic 234	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1783: aload_0
    //   1784: invokestatic 891	com/tencent/mobileqq/startup/step/SetSplash:b	(Lmqq/app/AppActivity;)Ljava/lang/String;
    //   1787: astore_1
    //   1788: aload_0
    //   1789: invokevirtual 895	mqq/app/AppActivity:getAssets	()Landroid/content/res/AssetManager;
    //   1792: aload_1
    //   1793: invokevirtual 901	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1796: astore 18
    //   1798: new 183	android/graphics/drawable/BitmapDrawable
    //   1801: dup
    //   1802: aload_0
    //   1803: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1806: aload 18
    //   1808: invokespecial 904	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   1811: astore 22
    //   1813: aload_0
    //   1814: invokevirtual 895	mqq/app/AppActivity:getAssets	()Landroid/content/res/AssetManager;
    //   1817: ldc_w 906
    //   1820: invokevirtual 901	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1823: astore_1
    //   1824: aload_1
    //   1825: astore 20
    //   1827: aload 18
    //   1829: astore 19
    //   1831: new 183	android/graphics/drawable/BitmapDrawable
    //   1834: dup
    //   1835: aload_0
    //   1836: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1839: aload_1
    //   1840: invokespecial 904	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   1843: astore 25
    //   1845: aload 18
    //   1847: ifnull +11 -> 1858
    //   1850: aload 18
    //   1852: invokevirtual 911	java/io/InputStream:close	()V
    //   1855: goto +3 -> 1858
    //   1858: aload_1
    //   1859: ifnull +20 -> 1879
    //   1862: aload_1
    //   1863: invokevirtual 911	java/io/InputStream:close	()V
    //   1866: goto +13 -> 1879
    //   1869: ldc 211
    //   1871: iconst_1
    //   1872: ldc_w 913
    //   1875: aload_1
    //   1876: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1879: aload 22
    //   1881: astore_1
    //   1882: aload 25
    //   1884: astore 18
    //   1886: goto +144 -> 2030
    //   1889: astore 22
    //   1891: goto +34 -> 1925
    //   1894: astore_0
    //   1895: aload 19
    //   1897: astore_1
    //   1898: goto +96 -> 1994
    //   1901: astore 22
    //   1903: aconst_null
    //   1904: astore_1
    //   1905: goto +20 -> 1925
    //   1908: astore_0
    //   1909: aconst_null
    //   1910: astore 18
    //   1912: aload 19
    //   1914: astore_1
    //   1915: goto +79 -> 1994
    //   1918: astore 22
    //   1920: aconst_null
    //   1921: astore_1
    //   1922: aload_1
    //   1923: astore 18
    //   1925: aload_1
    //   1926: astore 20
    //   1928: aload 18
    //   1930: astore 19
    //   1932: ldc 211
    //   1934: iconst_1
    //   1935: ldc_w 915
    //   1938: aload 22
    //   1940: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1943: aload 18
    //   1945: ifnull +11 -> 1956
    //   1948: aload 18
    //   1950: invokevirtual 911	java/io/InputStream:close	()V
    //   1953: goto +3 -> 1956
    //   1956: aload_1
    //   1957: ifnull +20 -> 1977
    //   1960: aload_1
    //   1961: invokevirtual 911	java/io/InputStream:close	()V
    //   1964: goto +13 -> 1977
    //   1967: ldc 211
    //   1969: iconst_1
    //   1970: ldc_w 913
    //   1973: aload_1
    //   1974: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1977: aconst_null
    //   1978: astore_1
    //   1979: aload 23
    //   1981: astore 18
    //   1983: goto +47 -> 2030
    //   1986: astore_0
    //   1987: aload 20
    //   1989: astore_1
    //   1990: aload 19
    //   1992: astore 18
    //   1994: aload 18
    //   1996: ifnull +11 -> 2007
    //   1999: aload 18
    //   2001: invokevirtual 911	java/io/InputStream:close	()V
    //   2004: goto +3 -> 2007
    //   2007: aload_1
    //   2008: ifnull +20 -> 2028
    //   2011: aload_1
    //   2012: invokevirtual 911	java/io/InputStream:close	()V
    //   2015: goto +13 -> 2028
    //   2018: ldc 211
    //   2020: iconst_1
    //   2021: ldc_w 913
    //   2024: aload_1
    //   2025: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2028: aload_0
    //   2029: athrow
    //   2030: aload_1
    //   2031: ifnull +50 -> 2081
    //   2034: aload 21
    //   2036: aload_1
    //   2037: invokevirtual 919	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2040: aload_1
    //   2041: instanceof 152
    //   2044: ifeq +37 -> 2081
    //   2047: aload_1
    //   2048: checkcast 152	android/graphics/drawable/AnimationDrawable
    //   2051: astore_1
    //   2052: aload_1
    //   2053: ifnull +28 -> 2081
    //   2056: aload_1
    //   2057: iconst_0
    //   2058: invokevirtual 922	android/graphics/drawable/AnimationDrawable:setOneShot	(Z)V
    //   2061: aload_1
    //   2062: invokevirtual 923	android/graphics/drawable/AnimationDrawable:start	()V
    //   2065: goto +16 -> 2081
    //   2068: astore_1
    //   2069: ldc 211
    //   2071: iconst_1
    //   2072: ldc 231
    //   2074: aload_1
    //   2075: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2078: goto +3 -> 2081
    //   2081: aload 21
    //   2083: invokevirtual 927	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   2086: astore_1
    //   2087: aload_1
    //   2088: ifnull +127 -> 2215
    //   2091: aload_1
    //   2092: instanceof 183
    //   2095: ifne +17 -> 2112
    //   2098: aload_1
    //   2099: instanceof 929
    //   2102: ifne +10 -> 2112
    //   2105: aload_1
    //   2106: instanceof 152
    //   2109: ifeq +106 -> 2215
    //   2112: aload_0
    //   2113: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   2116: invokevirtual 935	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   2119: getfield 940	android/util/DisplayMetrics:widthPixels	I
    //   2122: istore 5
    //   2124: aload_0
    //   2125: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   2128: invokevirtual 935	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   2131: getfield 943	android/util/DisplayMetrics:heightPixels	I
    //   2134: istore 6
    //   2136: aload_1
    //   2137: invokevirtual 948	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   2140: iload 5
    //   2142: imul
    //   2143: aload_1
    //   2144: invokevirtual 951	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   2147: idiv
    //   2148: istore 7
    //   2150: aload 21
    //   2152: invokevirtual 955	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   2155: astore_1
    //   2156: aload_1
    //   2157: iload 5
    //   2159: putfield 960	android/view/ViewGroup$LayoutParams:width	I
    //   2162: aload_1
    //   2163: iload 7
    //   2165: putfield 963	android/view/ViewGroup$LayoutParams:height	I
    //   2168: aload 21
    //   2170: aload_1
    //   2171: invokevirtual 967	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2174: iload 7
    //   2176: iload 6
    //   2178: if_icmpgt +14 -> 2192
    //   2181: aload 21
    //   2183: getstatic 973	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   2186: invokevirtual 977	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   2189: goto +26 -> 2215
    //   2192: iload 7
    //   2194: iload 6
    //   2196: if_icmple +19 -> 2215
    //   2199: aload 21
    //   2201: getstatic 980	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   2204: invokevirtual 977	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   2207: goto +8 -> 2215
    //   2210: astore_1
    //   2211: aload_1
    //   2212: invokevirtual 812	java/lang/Throwable:printStackTrace	()V
    //   2215: aload 24
    //   2217: ifnull +160 -> 2377
    //   2220: aload 18
    //   2222: ifnull +155 -> 2377
    //   2225: aload 24
    //   2227: aload 18
    //   2229: invokevirtual 919	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2232: aload_0
    //   2233: invokevirtual 802	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   2236: invokevirtual 935	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   2239: getfield 940	android/util/DisplayMetrics:widthPixels	I
    //   2242: istore 5
    //   2244: aload 18
    //   2246: invokevirtual 951	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   2249: i2f
    //   2250: aload 18
    //   2252: invokevirtual 948	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   2255: i2f
    //   2256: fdiv
    //   2257: fstore_3
    //   2258: iload 5
    //   2260: i2f
    //   2261: ldc_w 981
    //   2264: fmul
    //   2265: f2i
    //   2266: istore 6
    //   2268: iload 6
    //   2270: i2f
    //   2271: fstore 4
    //   2273: fload 4
    //   2275: fload_3
    //   2276: fdiv
    //   2277: f2i
    //   2278: istore 7
    //   2280: aload 24
    //   2282: invokevirtual 955	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   2285: checkcast 983	android/view/ViewGroup$MarginLayoutParams
    //   2288: astore_0
    //   2289: aload_0
    //   2290: iload 6
    //   2292: putfield 984	android/view/ViewGroup$MarginLayoutParams:width	I
    //   2295: aload_0
    //   2296: iload 7
    //   2298: putfield 985	android/view/ViewGroup$MarginLayoutParams:height	I
    //   2301: aload_0
    //   2302: iload 5
    //   2304: iload 6
    //   2306: isub
    //   2307: iconst_2
    //   2308: idiv
    //   2309: putfield 988	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   2312: aload_0
    //   2313: fload 4
    //   2315: fconst_2
    //   2316: fmul
    //   2317: ldc_w 989
    //   2320: fmul
    //   2321: ldc_w 990
    //   2324: fdiv
    //   2325: f2i
    //   2326: putfield 993	android/view/ViewGroup$MarginLayoutParams:bottomMargin	I
    //   2329: aload_0
    //   2330: getfield 988	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   2333: ifle +17 -> 2350
    //   2336: aload 24
    //   2338: aload_0
    //   2339: invokevirtual 967	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2342: aload 24
    //   2344: iconst_0
    //   2345: invokevirtual 996	android/widget/ImageView:setVisibility	(I)V
    //   2348: iload_2
    //   2349: ireturn
    //   2350: aload 24
    //   2352: bipush 8
    //   2354: invokevirtual 996	android/widget/ImageView:setVisibility	(I)V
    //   2357: iload_2
    //   2358: ireturn
    //   2359: astore_0
    //   2360: aload 24
    //   2362: bipush 8
    //   2364: invokevirtual 996	android/widget/ImageView:setVisibility	(I)V
    //   2367: ldc 211
    //   2369: iconst_1
    //   2370: ldc_w 998
    //   2373: aload_0
    //   2374: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2377: iload_2
    //   2378: ireturn
    //   2379: iconst_1
    //   2380: ireturn
    //   2381: ldc_w 1000
    //   2384: iconst_1
    //   2385: ldc 231
    //   2387: aload_1
    //   2388: invokestatic 547	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2391: aload_0
    //   2392: invokevirtual 1003	mqq/app/AppActivity:superFinish	()V
    //   2395: iconst_1
    //   2396: ireturn
    //   2397: astore 28
    //   2399: goto -1455 -> 944
    //   2402: astore 28
    //   2404: goto -1460 -> 944
    //   2407: iconst_0
    //   2408: istore 10
    //   2410: goto -789 -> 1621
    //   2413: astore_1
    //   2414: goto -545 -> 1869
    //   2417: astore_1
    //   2418: goto -451 -> 1967
    //   2421: astore_1
    //   2422: goto -404 -> 2018
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2425	0	paramAppActivity	AppActivity
    //   0	2425	1	paramStartupDirector	StartupDirector
    //   0	2425	2	paramBoolean	boolean
    //   2257	19	3	f1	float
    //   2271	43	4	f2	float
    //   562	1745	5	i	int
    //   817	1490	6	j	int
    //   827	1470	7	k	int
    //   912	21	8	m	int
    //   82	1660	9	bool1	boolean
    //   544	1865	10	bool2	boolean
    //   1532	12	11	bool3	boolean
    //   820	364	12	l1	long
    //   824	364	14	l2	long
    //   956	230	16	l3	long
    //   43	21	18	localClass	java.lang.Class
    //   121	9	18	localThrowable1	Throwable
    //   220	298	18	str	String
    //   569	1	18	localException1	Exception
    //   598	20	18	localException2	Exception
    //   643	1608	18	localObject1	Object
    //   202	1789	19	localObject2	Object
    //   183	1805	20	localObject3	Object
    //   171	1122	21	localObject4	Object
    //   1351	16	21	localThrowable2	Throwable
    //   1372	828	21	localObject5	Object
    //   208	212	22	localFile	File
    //   459	1	22	localThrowable3	Throwable
    //   470	23	22	localThrowable4	Throwable
    //   524	775	22	localObject6	Object
    //   1364	7	22	localThrowable5	Throwable
    //   1389	491	22	localObject7	Object
    //   1889	1	22	localThrowable6	Throwable
    //   1901	1	22	localThrowable7	Throwable
    //   1918	21	22	localThrowable8	Throwable
    //   243	1737	23	localObject8	Object
    //   812	1549	24	localObject9	Object
    //   749	1134	25	localObject10	Object
    //   844	481	26	localObject11	Object
    //   856	241	27	localObject12	Object
    //   884	44	28	localObject13	Object
    //   2397	1	28	localException3	Exception
    //   2402	1	28	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   29	114	117	android/content/res/Resources$NotFoundException
    //   123	134	117	android/content/res/Resources$NotFoundException
    //   134	151	117	android/content/res/Resources$NotFoundException
    //   154	161	117	android/content/res/Resources$NotFoundException
    //   29	114	121	java/lang/Throwable
    //   449	456	459	java/lang/Throwable
    //   427	445	470	java/lang/Throwable
    //   551	558	569	java/lang/Exception
    //   535	546	598	java/lang/Exception
    //   1341	1348	1351	java/lang/Throwable
    //   1316	1337	1364	java/lang/Throwable
    //   1587	1595	1666	java/lang/Throwable
    //   1575	1587	1670	java/lang/Throwable
    //   1595	1615	1670	java/lang/Throwable
    //   1621	1663	1670	java/lang/Throwable
    //   1674	1681	1689	java/lang/Throwable
    //   1515	1525	1698	java/lang/Throwable
    //   1487	1507	1702	java/lang/Throwable
    //   1525	1543	1702	java/lang/Throwable
    //   1558	1575	1702	java/lang/Throwable
    //   1759	1769	1772	java/lang/Exception
    //   1831	1845	1889	java/lang/Throwable
    //   1798	1824	1894	finally
    //   1798	1824	1901	java/lang/Throwable
    //   1783	1798	1908	finally
    //   1783	1798	1918	java/lang/Throwable
    //   1831	1845	1986	finally
    //   1932	1943	1986	finally
    //   2047	2052	2068	java/lang/Throwable
    //   2056	2065	2068	java/lang/Throwable
    //   2081	2087	2210	java/lang/Throwable
    //   2091	2112	2210	java/lang/Throwable
    //   2112	2174	2210	java/lang/Throwable
    //   2181	2189	2210	java/lang/Throwable
    //   2199	2207	2210	java/lang/Throwable
    //   2225	2258	2359	java/lang/Throwable
    //   2273	2348	2359	java/lang/Throwable
    //   2350	2357	2359	java/lang/Throwable
    //   904	914	2397	java/lang/Exception
    //   914	941	2402	java/lang/Exception
    //   1850	1855	2413	java/lang/Throwable
    //   1862	1866	2413	java/lang/Throwable
    //   1948	1953	2417	java/lang/Throwable
    //   1960	1964	2417	java/lang/Throwable
    //   1999	2004	2421	java/lang/Throwable
    //   2011	2015	2421	java/lang/Throwable
  }
  
  private static SplashADView b(Activity paramActivity, SplashUIdata paramSplashUIdata, StartupDirector paramStartupDirector)
  {
    SplashADView localSplashADView = SplashADView.a(paramSplashUIdata, paramActivity);
    SplashItem localSplashItem = VasSplashUtil.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SplashADUtil.a(BaseApplicationImpl.getApplication()));
    localStringBuilder.append("");
    localSplashADView.setOnClickListener(new SetSplash.5(localSplashItem, paramStartupDirector, localSplashADView, paramSplashUIdata, paramActivity, localStringBuilder.toString()));
    if (paramSplashUIdata.a == 2)
    {
      localSplashADView.setOnErrorListener(new SetSplash.6(paramStartupDirector));
      localSplashADView.setOnCompletionListener(new SetSplash.7(paramStartupDirector));
      localSplashADView.setPresenter(new SetSplash.8((ImageView)paramActivity.findViewById(2131446244), (ImageView)paramActivity.findViewById(2131446247)));
    }
    return localSplashADView;
  }
  
  @NonNull
  private static String b(AppActivity paramAppActivity)
  {
    int i = paramAppActivity.getResources().getDisplayMetrics().widthPixels;
    int j = 0;
    if (i > 1500) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject;
    if (QQTheme.isNowSimpleUI())
    {
      if (i != 0) {
        localObject = "splash_big_simple";
      } else {
        localObject = "splash_simple";
      }
    }
    else if (StudyModeManager.h())
    {
      if (i != 0) {
        localObject = "splash_big_study";
      } else {
        localObject = "splash_study";
      }
    }
    else {
      localObject = "";
    }
    String str;
    if (i != 0) {
      str = "splash_big.jpg";
    } else {
      str = "splash.jpg";
    }
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return str;
    }
    String[] arrayOfString = paramAppActivity.getAssets().list("splash");
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return str;
      }
      int k = arrayOfString.length;
      i = j;
      while (i < k)
      {
        paramAppActivity = arrayOfString[i];
        if ((!TextUtils.isEmpty(paramAppActivity)) && (paramAppActivity.startsWith((String)localObject)))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("splash");
          ((StringBuilder)localObject).append("/");
          ((StringBuilder)localObject).append(paramAppActivity);
          return ((StringBuilder)localObject).toString();
        }
        i += 1;
      }
    }
    return str;
  }
  
  protected static void b(View paramView, SetSplash.SplashAnimListener paramSplashAnimListener)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F });
    localValueAnimator.setDuration(300L);
    localValueAnimator.addListener(new SetSplash.14(paramSplashAnimListener));
    localValueAnimator.addUpdateListener(new SetSplash.15(paramView));
    localValueAnimator.start();
  }
  
  private static void b(SetSplash.SplashAnimListener paramSplashAnimListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("splashAnimEnd listener:");
    localStringBuilder.append(paramSplashAnimListener);
    QLog.i("SetSplash", 1, localStringBuilder.toString());
    if (paramSplashAnimListener != null) {
      paramSplashAnimListener.a();
    }
    paramSplashAnimListener = d();
    if ((paramSplashAnimListener != null) && (paramSplashAnimListener.getParent() != null) && ((paramSplashAnimListener.getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)paramSplashAnimListener.getParent()).removeView(paramSplashAnimListener);
      QLog.i("SetSplash", 1, "removeView splash view");
    }
    c();
    e = null;
    c = null;
  }
  
  public static boolean b()
  {
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).getBoolean("splashAnim", true);
    QLog.d("QSplash@VasSplashUtil", 1, new Object[] { "isEnableSplashAnim:", Boolean.valueOf(bool) });
    return bool;
  }
  
  public static void c()
  {
    WeakReference localWeakReference = b;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      b = null;
    }
  }
  
  private static void c(AppActivity paramAppActivity)
  {
    QLog.d("QSplash@VasSplashUtil", 1, "initSplashAnim UnionBannerSplash animation");
    if ((Build.VERSION.SDK_INT >= 21) && (b())) {
      try
      {
        View localView = paramAppActivity.findViewById(2131446243);
        if ((localView != null) && ((localView.getParent() instanceof ViewGroup)))
        {
          ViewGroup localViewGroup = (ViewGroup)localView.getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView(localView);
          }
          ((ViewGroup)paramAppActivity.getWindow().getDecorView()).addView(localView);
          b = new WeakReference(localView);
          StartupTracker.a(null, "splashCost");
        }
        QLog.d("QSplash@VasSplashUtil", 1, "show UnionBannerSplash animation");
        return;
      }
      catch (Exception paramAppActivity)
      {
        QLog.e("QSplash@VasSplashUtil", 1, "show Splash anim  error ", paramAppActivity);
      }
    }
  }
  
  public static View d()
  {
    WeakReference localWeakReference = b;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (View)b.get();
    }
    return null;
  }
  
  public static boolean e()
  {
    return d() != null;
  }
  
  private static int h()
  {
    if (QQTheme.isNowSimpleUI()) {
      return 1;
    }
    if (StudyModeManager.h()) {
      return 3;
    }
    return 2;
  }
  
  private static void i()
  {
    ThreadManager.getFileThreadHandler().postDelayed(new SetSplash.9(), 5000L);
  }
  
  protected boolean doStep()
  {
    AppActivity localAppActivity = this.mDirector.e;
    try
    {
      boolean bool = localAppActivity.showPreview();
      if (bool) {
        return true;
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SetSplash", 2, "", localNotFoundException);
      }
      this.mDirector.b();
      if (!a(localAppActivity, this.mDirector, true))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.appStartTime = 0L;
        this.mDirector.i = 0L;
      }
      this.a = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */