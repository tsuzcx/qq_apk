package com.tencent.mobileqq.startup.step;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
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
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
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
  private static SetSplash.SplashAnimListener a;
  public static Runnable a;
  protected static WeakReference<View> a;
  private static boolean b;
  public boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangRunnable = new SetSplash.12();
  }
  
  public SetSplash()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
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
              paramStartupDirector.jdField_a_of_type_Long = i;
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
  
  public static View a()
  {
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      return (View)jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  private static SplashADView a(Activity paramActivity, SplashUIdata paramSplashUIdata, StartupDirector paramStartupDirector)
  {
    SplashADView localSplashADView = SplashADView.a(paramSplashUIdata, paramActivity);
    localSplashADView.setOnClickListener(new SetSplash.2(paramStartupDirector));
    if (paramSplashUIdata.a == 2)
    {
      localSplashADView.setOnErrorListener(new SetSplash.3(paramStartupDirector));
      localSplashADView.setPresenter(new SetSplash.4((ImageView)paramActivity.findViewById(2131377783), (ImageView)paramActivity.findViewById(2131377786)));
    }
    return localSplashADView;
  }
  
  public static void a()
  {
    WeakReference localWeakReference = jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      jdField_a_of_type_JavaLangRefWeakReference = null;
    }
  }
  
  public static void a(long paramLong)
  {
    View localView = a();
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
    localStringBuilder.append(jdField_a_of_type_ComTencentMobileqqStartupStepSetSplash$SplashAnimListener);
    QLog.i("SetSplash", 1, localStringBuilder.toString());
    if ((paramView != null) && (paramView.getHeight() > 0))
    {
      localObject = jdField_a_of_type_ComTencentMobileqqStartupStepSetSplash$SplashAnimListener;
      if (localObject != null)
      {
        a(paramView, (SetSplash.SplashAnimListener)localObject);
        jdField_a_of_type_ComTencentMobileqqStartupStepSetSplash$SplashAnimListener = null;
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
    ((StringBuilder)localObject).append(jdField_a_of_type_JavaLangRefWeakReference);
    QLog.i("SetSplash", 1, ((StringBuilder)localObject).toString());
    StartupTracker.a("splashCost", null);
    localObject = a();
    if (localObject == null)
    {
      QLog.w("SetSplash", 1, "splashView is null, anim End:");
      b(paramSplashAnimListener);
      return;
    }
    if ((paramView != null) && (paramView.getHeight() > 0))
    {
      Runnable localRunnable = jdField_a_of_type_JavaLangRunnable;
      if (localRunnable != null) {
        ((View)localObject).removeCallbacks(localRunnable);
      }
      localObject = new int[2];
      paramView.getLocationOnScreen((int[])localObject);
      a(paramSplashAnimListener, localObject[1], paramView.getHeight());
      return;
    }
    if (c())
    {
      if (localObject != null) {
        ((View)localObject).postDelayed(jdField_a_of_type_JavaLangRunnable, 1000L);
      }
      jdField_a_of_type_ComTencentMobileqqStartupStepSetSplash$SplashAnimListener = paramSplashAnimListener;
      return;
    }
    b(paramSplashAnimListener);
  }
  
  private static void a(SetSplash.SplashAnimListener paramSplashAnimListener, int paramInt1, int paramInt2)
  {
    View localView = a();
    if ((localView != null) && (paramInt2 != 0))
    {
      if (Build.VERSION.SDK_INT < 21)
      {
        b(paramSplashAnimListener);
        return;
      }
      a();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("adView:");
      ((StringBuilder)localObject).append(localView);
      ((StringBuilder)localObject).append(" listener:");
      ((StringBuilder)localObject).append(jdField_a_of_type_ComTencentMobileqqStartupStepSetSplash$SplashAnimListener);
      QLog.i("SetSplash", 1, ((StringBuilder)localObject).toString());
      localObject = ValueAnimator.ofFloat(new float[] { 1.0F });
      ((ValueAnimator)localObject).setDuration(800L);
      if (Build.VERSION.SDK_INT >= 21) {
        ((ValueAnimator)localObject).setInterpolator(new PathInterpolator(0.65F, 0.0F, 0.28F, 1.0F));
      }
      localView.setClipToOutline(true);
      b = false;
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
          localObject2 = VasSplashUtil.a((Context)localObject2, ((StringBuilder)localObject3).toString());
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
    SplashItem localSplashItem = VasSplashUtil.a;
    if (localSplashItem == null)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "splashItem  == null");
      return false;
    }
    if (localSplashItem.a == 1)
    {
      VasSplashUtil.a(localSplashItem.jdField_b_of_type_JavaLangString, l, false);
      return false;
    }
    BaseApplicationImpl.sLaunchTime = 0L;
    BaseApplicationImpl.sShowTime = 0L;
    QLog.i("QSplash@VasSplashUtil", 1, "ready show Splash");
    b();
    if (!SplashADUtil.a(paramAppActivity)) {
      return false;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("show Splash AD, uin = ");
    ((StringBuilder)localObject).append(l % 10000L);
    QLog.i("QSplash@VasSplashUtil", 1, ((StringBuilder)localObject).toString());
    if (localSplashItem.jdField_b_of_type_Int == 1)
    {
      QLog.i("QSplash@VasSplashUtil", 1, "preLoad web");
      ((IWebProcessPreload)QRoute.api(IWebProcessPreload.class)).preloadWebProcess(-1);
      VasSplashUtil.b = true;
    }
    if (localSplashItem.jdField_b_of_type_Int == 2)
    {
      VipHandler.a();
      ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).preloadProcess();
    }
    if (localSplashItem.jdField_b_of_type_Int == 3)
    {
      VipHandler.a();
      ((ISplashMiniGameStarterService)QRoute.api(ISplashMiniGameStarterService.class)).preloadGameProcess();
    }
    localObject = new SplashUIdata.Builder();
    ((SplashUIdata.Builder)localObject).a(localSplashItem.a).a(localSplashItem.h).c(localSplashItem.h).b(localSplashItem.e).c(1).b(localSplashItem.j).d(localSplashItem.jdField_b_of_type_Int).d(localSplashItem.f).e(localSplashItem.m).f(localSplashItem.n).g(localSplashItem.o);
    paramStartupDirector.a(new SetSplash.VasSplashCallBack(localSplashItem, b(paramAppActivity, ((SplashUIdata.Builder)localObject).a(), paramStartupDirector), paramImageView2, paramImageView1, paramAppActivity));
    return true;
  }
  
  /* Error */
  public static boolean a(AppActivity paramAppActivity, StartupDirector paramStartupDirector, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 370	android/os/Build$VERSION:SDK_INT	I
    //   3: bipush 26
    //   5: if_icmplt +100 -> 105
    //   8: ldc_w 721
    //   11: invokestatic 727	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   14: astore 18
    //   16: aload 18
    //   18: ldc_w 729
    //   21: iconst_1
    //   22: anewarray 723	java/lang/Class
    //   25: dup
    //   26: iconst_0
    //   27: ldc_w 273
    //   30: aastore
    //   31: invokevirtual 733	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   34: aload 18
    //   36: iconst_1
    //   37: anewarray 735	java/lang/Object
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: invokevirtual 741	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 743	java/lang/Boolean
    //   50: invokevirtual 746	java/lang/Boolean:booleanValue	()Z
    //   53: istore 9
    //   55: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +47 -> 105
    //   61: ldc 208
    //   63: iconst_2
    //   64: iconst_2
    //   65: anewarray 735	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: ldc_w 748
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: iload 9
    //   78: invokestatic 751	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: aastore
    //   82: invokestatic 754	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   85: goto +20 -> 105
    //   88: astore_1
    //   89: goto +2245 -> 2334
    //   92: astore 18
    //   94: ldc 208
    //   96: iconst_1
    //   97: ldc_w 756
    //   100: aload 18
    //   102: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_0
    //   106: instanceof 758
    //   109: ifeq +16 -> 125
    //   112: aload_0
    //   113: checkcast 758	com/tencent/mobileqq/app/IphoneTitleBarActivity
    //   116: ldc_w 759
    //   119: invokevirtual 762	com/tencent/mobileqq/app/IphoneTitleBarActivity:setContentViewNoTitle	(I)V
    //   122: goto +10 -> 132
    //   125: aload_0
    //   126: ldc_w 759
    //   129: invokevirtual 767	mqq/app/AppActivity:setContentView	(I)V
    //   132: aload_0
    //   133: ldc_w 271
    //   136: invokevirtual 768	mqq/app/AppActivity:findViewById	(I)Landroid/view/View;
    //   139: checkcast 279	android/widget/ImageView
    //   142: astore 21
    //   144: aload_0
    //   145: ldc_w 280
    //   148: invokevirtual 768	mqq/app/AppActivity:findViewById	(I)Landroid/view/View;
    //   151: checkcast 279	android/widget/ImageView
    //   154: astore 20
    //   156: aload 21
    //   158: ifnull +2174 -> 2332
    //   161: aload 20
    //   163: ifnonnull +6 -> 169
    //   166: goto +2166 -> 2332
    //   169: aload_0
    //   170: invokestatic 491	com/tencent/mobileqq/utils/SharedPreUtils:b	(Landroid/content/Context;)Ljava/lang/String;
    //   173: astore 19
    //   175: aload_0
    //   176: invokevirtual 769	mqq/app/AppActivity:getFilesDir	()Ljava/io/File;
    //   179: astore 22
    //   181: aload 22
    //   183: ifnull +13 -> 196
    //   186: aload 22
    //   188: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   191: astore 18
    //   193: goto +8 -> 201
    //   196: ldc_w 446
    //   199: astore 18
    //   201: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +39 -> 243
    //   207: new 39	java/lang/StringBuilder
    //   210: dup
    //   211: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   214: astore 23
    //   216: aload 23
    //   218: aload 19
    //   220: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload 23
    //   226: aload 22
    //   228: invokevirtual 309	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: pop
    //   232: ldc 208
    //   234: iconst_2
    //   235: aload 23
    //   237: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: aload 22
    //   245: ifnull +237 -> 482
    //   248: aload 19
    //   250: ldc 228
    //   252: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   255: ifne +227 -> 482
    //   258: aload 19
    //   260: invokestatic 495	com/tencent/mobileqq/startup/step/SetSplash:a	(Ljava/lang/String;)I
    //   263: ifne +219 -> 482
    //   266: new 39	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   273: astore 19
    //   275: aload 19
    //   277: aload 18
    //   279: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 19
    //   285: ldc 135
    //   287: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 19
    //   293: aload_0
    //   294: invokestatic 497	com/tencent/mobileqq/utils/SharedPreUtils:a	(Landroid/content/Context;)Ljava/lang/String;
    //   297: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 19
    //   303: ldc 135
    //   305: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 19
    //   311: ldc_w 499
    //   314: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload 19
    //   320: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: astore 19
    //   325: new 128	java/io/File
    //   328: dup
    //   329: aload 19
    //   331: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   334: astore 22
    //   336: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   339: ifeq +51 -> 390
    //   342: new 39	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   349: astore 23
    //   351: aload 23
    //   353: aload 19
    //   355: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload 23
    //   361: ldc_w 771
    //   364: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload 23
    //   370: aload 22
    //   372: invokevirtual 140	java/io/File:exists	()Z
    //   375: invokevirtual 774	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: ldc 208
    //   381: iconst_2
    //   382: aload 23
    //   384: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 776	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: aload 22
    //   392: invokevirtual 140	java/io/File:exists	()Z
    //   395: ifeq +87 -> 482
    //   398: new 180	android/graphics/drawable/BitmapDrawable
    //   401: dup
    //   402: aload_0
    //   403: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   406: aload 19
    //   408: invokestatic 780	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   411: invokespecial 189	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   414: astore 19
    //   416: aload_1
    //   417: ifnull +18 -> 435
    //   420: aload_1
    //   421: ldc2_w 781
    //   424: putfield 226	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   427: goto +8 -> 435
    //   430: astore 22
    //   432: goto +14 -> 446
    //   435: iconst_0
    //   436: istore 9
    //   438: goto +33 -> 471
    //   441: astore 22
    //   443: aconst_null
    //   444: astore 19
    //   446: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   449: ifeq +14 -> 463
    //   452: ldc 208
    //   454: iconst_2
    //   455: ldc_w 784
    //   458: aload 22
    //   460: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   463: aload 22
    //   465: invokevirtual 787	java/lang/Throwable:printStackTrace	()V
    //   468: iconst_1
    //   469: istore 9
    //   471: aload 19
    //   473: ifnull +6 -> 479
    //   476: invokestatic 620	com/tencent/mobileqq/startup/step/SetSplash:b	()V
    //   479: goto +9 -> 488
    //   482: iconst_1
    //   483: istore 9
    //   485: aconst_null
    //   486: astore 19
    //   488: aload 18
    //   490: astore 23
    //   492: ldc_w 789
    //   495: astore 22
    //   497: aload 19
    //   499: ifnonnull +97 -> 596
    //   502: aload_1
    //   503: ifnull +93 -> 596
    //   506: aload_0
    //   507: aload_1
    //   508: aload 21
    //   510: aload 20
    //   512: invokestatic 791	com/tencent/mobileqq/startup/step/SetSplash:a	(Lmqq/app/AppActivity;Lcom/tencent/mobileqq/startup/director/StartupDirector;Landroid/widget/ImageView;Landroid/widget/ImageView;)Z
    //   515: istore 10
    //   517: iload 10
    //   519: ifeq +31 -> 550
    //   522: aload_1
    //   523: ldc2_w 792
    //   526: putfield 226	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   529: iconst_1
    //   530: istore 9
    //   532: iconst_1
    //   533: istore 5
    //   535: iconst_0
    //   536: istore_2
    //   537: goto +26 -> 563
    //   540: astore 18
    //   542: iconst_1
    //   543: istore 9
    //   545: iconst_0
    //   546: istore_2
    //   547: goto +34 -> 581
    //   550: iload_2
    //   551: istore 10
    //   553: iload 9
    //   555: istore_2
    //   556: iconst_0
    //   557: istore 5
    //   559: iload 10
    //   561: istore 9
    //   563: iload_2
    //   564: istore 10
    //   566: goto +46 -> 612
    //   569: astore 18
    //   571: iload_2
    //   572: istore 10
    //   574: iload 9
    //   576: istore_2
    //   577: iload 10
    //   579: istore 9
    //   581: ldc_w 596
    //   584: iconst_1
    //   585: ldc_w 789
    //   588: aload 18
    //   590: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   593: goto +13 -> 606
    //   596: iload_2
    //   597: istore 10
    //   599: iload 9
    //   601: istore_2
    //   602: iload 10
    //   604: istore 9
    //   606: iconst_0
    //   607: istore 5
    //   609: iload_2
    //   610: istore 10
    //   612: aload 19
    //   614: astore 18
    //   616: iload 10
    //   618: istore_2
    //   619: aload 19
    //   621: ifnonnull +42 -> 663
    //   624: aload 19
    //   626: astore 18
    //   628: iload 10
    //   630: istore_2
    //   631: invokestatic 120	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   634: invokestatic 794	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;)Z
    //   637: ifeq +26 -> 663
    //   640: aload 19
    //   642: astore 18
    //   644: iload 10
    //   646: istore_2
    //   647: iload 5
    //   649: ifne +14 -> 663
    //   652: invokestatic 120	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   655: aload_1
    //   656: invokestatic 796	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/content/Context;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Landroid/graphics/drawable/AnimationDrawable;
    //   659: astore 18
    //   661: iconst_0
    //   662: istore_2
    //   663: aload 18
    //   665: ifnonnull +742 -> 1407
    //   668: iload 5
    //   670: ifne +737 -> 1407
    //   673: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   676: ifeq +13 -> 689
    //   679: ldc_w 798
    //   682: iconst_2
    //   683: ldc_w 800
    //   686: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   689: new 39	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   696: astore 19
    //   698: aload 19
    //   700: aload 23
    //   702: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload 19
    //   708: ldc_w 802
    //   711: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload 19
    //   717: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: astore 25
    //   722: new 39	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   729: astore 19
    //   731: aload 19
    //   733: aload 23
    //   735: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload 19
    //   741: ldc_w 448
    //   744: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: new 128	java/io/File
    //   751: dup
    //   752: aload 19
    //   754: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   757: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   760: astore 19
    //   762: aload 19
    //   764: invokevirtual 140	java/io/File:exists	()Z
    //   767: ifeq +423 -> 1190
    //   770: aload 19
    //   772: invokevirtual 143	java/io/File:isDirectory	()Z
    //   775: ifeq +415 -> 1190
    //   778: aload 19
    //   780: invokevirtual 147	java/io/File:listFiles	()[Ljava/io/File;
    //   783: astore 24
    //   785: aload 24
    //   787: arraylength
    //   788: istore 6
    //   790: lconst_0
    //   791: lstore 12
    //   793: lload 12
    //   795: lstore 14
    //   797: iconst_0
    //   798: istore 7
    //   800: aconst_null
    //   801: astore 19
    //   803: iload 7
    //   805: iload 6
    //   807: if_icmpge +356 -> 1163
    //   810: aload 24
    //   812: iload 7
    //   814: aaload
    //   815: astore 26
    //   817: aload 26
    //   819: ifnull +319 -> 1138
    //   822: aload 26
    //   824: invokevirtual 451	java/io/File:getName	()Ljava/lang/String;
    //   827: astore 27
    //   829: aload 27
    //   831: ldc_w 453
    //   834: invokevirtual 457	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   837: astore 23
    //   839: aload 23
    //   841: ifnull +297 -> 1138
    //   844: aload 23
    //   846: arraylength
    //   847: iconst_3
    //   848: if_icmpne +287 -> 1135
    //   851: aload 23
    //   853: iconst_0
    //   854: aaload
    //   855: astore 28
    //   857: aload 28
    //   859: ifnull +66 -> 925
    //   862: aload 28
    //   864: invokevirtual 460	java/lang/String:trim	()Ljava/lang/String;
    //   867: ldc 228
    //   869: invokevirtual 464	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   872: ifne +53 -> 925
    //   875: aload 28
    //   877: ldc_w 466
    //   880: invokevirtual 469	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   883: istore 8
    //   885: aload 28
    //   887: iconst_0
    //   888: iload 8
    //   890: invokevirtual 473	java/lang/String:substring	(II)Ljava/lang/String;
    //   893: invokestatic 479	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   896: lstore 12
    //   898: aload 28
    //   900: iload 8
    //   902: iconst_1
    //   903: iadd
    //   904: invokevirtual 481	java/lang/String:substring	(I)Ljava/lang/String;
    //   907: invokestatic 479	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   910: lstore 14
    //   912: goto +13 -> 925
    //   915: lconst_0
    //   916: lstore 14
    //   918: lload 14
    //   920: lstore 12
    //   922: goto +15 -> 937
    //   925: lload 12
    //   927: lstore 16
    //   929: lload 14
    //   931: lstore 12
    //   933: lload 16
    //   935: lstore 14
    //   937: lload 14
    //   939: lload 12
    //   941: invokestatic 486	com/tencent/mobileqq/util/CommonUtil:a	(JJ)Z
    //   944: ifeq +59 -> 1003
    //   947: aload 19
    //   949: ifnonnull +47 -> 996
    //   952: new 39	java/lang/StringBuilder
    //   955: dup
    //   956: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   959: astore 19
    //   961: aload 19
    //   963: aload 25
    //   965: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   968: pop
    //   969: aload 19
    //   971: aload 23
    //   973: iconst_1
    //   974: aaload
    //   975: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   978: pop
    //   979: new 128	java/io/File
    //   982: dup
    //   983: aload 19
    //   985: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   991: astore 23
    //   993: goto +84 -> 1077
    //   996: aload 19
    //   998: astore 23
    //   1000: goto +77 -> 1077
    //   1003: aload 19
    //   1005: astore 23
    //   1007: lload 12
    //   1009: invokestatic 439	java/lang/System:currentTimeMillis	()J
    //   1012: lcmp
    //   1013: ifge +64 -> 1077
    //   1016: new 39	java/lang/StringBuilder
    //   1019: dup
    //   1020: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1023: astore 23
    //   1025: aload 23
    //   1027: aload 25
    //   1029: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1032: pop
    //   1033: aload 23
    //   1035: aload 27
    //   1037: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1040: pop
    //   1041: new 128	java/io/File
    //   1044: dup
    //   1045: aload 23
    //   1047: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1050: invokespecial 136	java/io/File:<init>	(Ljava/lang/String;)V
    //   1053: astore 27
    //   1055: aload 19
    //   1057: astore 23
    //   1059: aload 27
    //   1061: invokevirtual 140	java/io/File:exists	()Z
    //   1064: ifeq +13 -> 1077
    //   1067: aload 27
    //   1069: invokevirtual 805	java/io/File:delete	()Z
    //   1072: pop
    //   1073: aload 19
    //   1075: astore 23
    //   1077: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1080: ifeq +44 -> 1124
    //   1083: new 39	java/lang/StringBuilder
    //   1086: dup
    //   1087: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   1090: astore 19
    //   1092: aload 19
    //   1094: ldc_w 807
    //   1097: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1100: pop
    //   1101: aload 19
    //   1103: aload 26
    //   1105: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1108: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: pop
    //   1112: ldc_w 798
    //   1115: iconst_2
    //   1116: aload 19
    //   1118: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1121: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1124: aload 23
    //   1126: astore 19
    //   1128: lload 12
    //   1130: lstore 16
    //   1132: goto +14 -> 1146
    //   1135: goto +3 -> 1138
    //   1138: lload 14
    //   1140: lstore 16
    //   1142: lload 12
    //   1144: lstore 14
    //   1146: iload 7
    //   1148: iconst_1
    //   1149: iadd
    //   1150: istore 7
    //   1152: lload 14
    //   1154: lstore 12
    //   1156: lload 16
    //   1158: lstore 14
    //   1160: goto -357 -> 803
    //   1163: aload 21
    //   1165: astore 23
    //   1167: aload 19
    //   1169: astore 26
    //   1171: aload 18
    //   1173: astore 21
    //   1175: aload 20
    //   1177: astore 18
    //   1179: aload 23
    //   1181: astore 19
    //   1183: aload 22
    //   1185: astore 20
    //   1187: goto +31 -> 1218
    //   1190: aload 21
    //   1192: astore 19
    //   1194: aload 20
    //   1196: astore 21
    //   1198: aload 18
    //   1200: astore 22
    //   1202: ldc_w 789
    //   1205: astore 20
    //   1207: aconst_null
    //   1208: astore 26
    //   1210: aload 21
    //   1212: astore 18
    //   1214: aload 22
    //   1216: astore 21
    //   1218: aload 21
    //   1220: astore 25
    //   1222: aload 18
    //   1224: astore 22
    //   1226: aload 19
    //   1228: astore 23
    //   1230: aload 20
    //   1232: astore 24
    //   1234: aload 26
    //   1236: ifnull +188 -> 1424
    //   1239: aload 21
    //   1241: astore 25
    //   1243: aload 18
    //   1245: astore 22
    //   1247: aload 19
    //   1249: astore 23
    //   1251: aload 20
    //   1253: astore 24
    //   1255: aload 26
    //   1257: invokevirtual 140	java/io/File:exists	()Z
    //   1260: ifeq +164 -> 1424
    //   1263: aload 21
    //   1265: astore 25
    //   1267: aload 18
    //   1269: astore 22
    //   1271: aload 19
    //   1273: astore 23
    //   1275: aload 20
    //   1277: astore 24
    //   1279: aload 26
    //   1281: invokevirtual 810	java/io/File:isFile	()Z
    //   1284: ifeq +140 -> 1424
    //   1287: new 180	android/graphics/drawable/BitmapDrawable
    //   1290: dup
    //   1291: aload_0
    //   1292: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1295: aload 26
    //   1297: invokevirtual 131	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   1300: invokestatic 780	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   1303: invokespecial 189	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   1306: astore 23
    //   1308: aload_1
    //   1309: ifnull +20 -> 1329
    //   1312: aload_1
    //   1313: ldc2_w 811
    //   1316: putfield 226	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   1319: goto +10 -> 1329
    //   1322: astore 21
    //   1324: iconst_0
    //   1325: istore_2
    //   1326: goto +19 -> 1345
    //   1329: iconst_0
    //   1330: istore 10
    //   1332: goto +26 -> 1358
    //   1335: astore 22
    //   1337: aload 21
    //   1339: astore 23
    //   1341: aload 22
    //   1343: astore 21
    //   1345: ldc 208
    //   1347: iconst_1
    //   1348: ldc 228
    //   1350: aload 21
    //   1352: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1355: iload_2
    //   1356: istore 10
    //   1358: aload 23
    //   1360: astore 22
    //   1362: iload 10
    //   1364: istore_2
    //   1365: aload 18
    //   1367: astore 24
    //   1369: aload 19
    //   1371: astore 21
    //   1373: aload 20
    //   1375: astore 25
    //   1377: aload 23
    //   1379: ifnull +65 -> 1444
    //   1382: invokestatic 620	com/tencent/mobileqq/startup/step/SetSplash:b	()V
    //   1385: aload 23
    //   1387: astore 22
    //   1389: iload 10
    //   1391: istore_2
    //   1392: aload 18
    //   1394: astore 24
    //   1396: aload 19
    //   1398: astore 21
    //   1400: aload 20
    //   1402: astore 25
    //   1404: goto +40 -> 1444
    //   1407: ldc_w 789
    //   1410: astore 24
    //   1412: aload 21
    //   1414: astore 23
    //   1416: aload 20
    //   1418: astore 22
    //   1420: aload 18
    //   1422: astore 25
    //   1424: aload 25
    //   1426: astore 18
    //   1428: aload 24
    //   1430: astore 25
    //   1432: aload 23
    //   1434: astore 21
    //   1436: aload 22
    //   1438: astore 24
    //   1440: aload 18
    //   1442: astore 22
    //   1444: aload 22
    //   1446: ifnonnull +241 -> 1687
    //   1449: aload_1
    //   1450: ifnull +237 -> 1687
    //   1453: iload 5
    //   1455: ifne +232 -> 1687
    //   1458: ldc_w 649
    //   1461: invokestatic 639	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   1464: checkcast 649	com/tencent/mobileqq/mini/api/ISplashMiniGameStarterService
    //   1467: astore 18
    //   1469: aload 18
    //   1471: invokeinterface 815 1 0
    //   1476: istore 10
    //   1478: iload 10
    //   1480: ifne +6 -> 1486
    //   1483: goto +174 -> 1657
    //   1486: ldc_w 817
    //   1489: iconst_1
    //   1490: ldc_w 618
    //   1493: invokestatic 327	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1496: invokestatic 620	com/tencent/mobileqq/startup/step/SetSplash:b	()V
    //   1499: aload_0
    //   1500: invokestatic 623	com/tencent/mobileqq/splashad/SplashADUtil:a	(Landroid/app/Activity;)Z
    //   1503: istore 11
    //   1505: aload 18
    //   1507: invokeinterface 821 1 0
    //   1512: astore 19
    //   1514: iload 11
    //   1516: ifeq +129 -> 1645
    //   1519: iload 10
    //   1521: ifeq +124 -> 1645
    //   1524: aload 19
    //   1526: ifnull +119 -> 1645
    //   1529: new 657	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder
    //   1532: dup
    //   1533: invokespecial 658	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:<init>	()V
    //   1536: astore 20
    //   1538: aload 20
    //   1540: iconst_2
    //   1541: invokevirtual 661	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	(I)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1544: astore 23
    //   1546: aload 23
    //   1548: aconst_null
    //   1549: invokevirtual 667	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1552: iconst_0
    //   1553: invokevirtual 673	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:b	(I)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1556: astore 23
    //   1558: aload 23
    //   1560: iconst_1
    //   1561: invokevirtual 675	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:c	(I)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1564: astore 23
    //   1566: aload 23
    //   1568: aload 19
    //   1570: getfield 826	com/tencent/mobileqq/minigame/splash/SplashMiniGameData:videoLocalPath	Ljava/lang/String;
    //   1573: invokevirtual 669	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1576: astore 23
    //   1578: aload 19
    //   1580: getfield 829	com/tencent/mobileqq/minigame/splash/SplashMiniGameData:videoMute	I
    //   1583: ifne +777 -> 2360
    //   1586: iconst_1
    //   1587: istore 10
    //   1589: goto +3 -> 1592
    //   1592: aload 23
    //   1594: iload 10
    //   1596: invokevirtual 832	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1599: iconst_0
    //   1600: invokevirtual 834	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:b	(Z)Lcom/tencent/mobileqq/vassplash/model/SplashUIdata$Builder;
    //   1603: pop
    //   1604: aload 20
    //   1606: invokevirtual 708	com/tencent/mobileqq/vassplash/model/SplashUIdata$Builder:a	()Lcom/tencent/mobileqq/vassplash/model/SplashUIdata;
    //   1609: astore 19
    //   1611: aload_1
    //   1612: new 836	com/tencent/mobileqq/startup/step/SetSplash$1
    //   1615: dup
    //   1616: aload 19
    //   1618: aload_0
    //   1619: aload 19
    //   1621: aload_1
    //   1622: invokestatic 838	com/tencent/mobileqq/startup/step/SetSplash:a	(Landroid/app/Activity;Lcom/tencent/mobileqq/vassplash/model/SplashUIdata;Lcom/tencent/mobileqq/startup/director/StartupDirector;)Lcom/tencent/mobileqq/splashad/SplashADView;
    //   1625: aload_0
    //   1626: aload 18
    //   1628: invokespecial 841	com/tencent/mobileqq/startup/step/SetSplash$1:<init>	(Ljava/lang/Object;Lcom/tencent/mobileqq/splashad/SplashADView;Lmqq/app/AppActivity;Lcom/tencent/mobileqq/mini/api/ISplashMiniGameStarterService;)V
    //   1631: invokevirtual 716	com/tencent/mobileqq/startup/director/StartupDirector:a	(Lcom/tencent/mobileqq/startup/director/StartupDirector$SplashCallBack;)V
    //   1634: goto +11 -> 1645
    //   1637: astore_1
    //   1638: goto +32 -> 1670
    //   1641: astore_1
    //   1642: goto +32 -> 1674
    //   1645: aload_1
    //   1646: ldc2_w 792
    //   1649: putfield 226	com/tencent/mobileqq/startup/director/StartupDirector:jdField_a_of_type_Long	J
    //   1652: iconst_1
    //   1653: istore 9
    //   1655: iconst_0
    //   1656: istore_2
    //   1657: goto +30 -> 1687
    //   1660: astore_1
    //   1661: iconst_1
    //   1662: istore 9
    //   1664: iconst_0
    //   1665: istore_2
    //   1666: goto +8 -> 1674
    //   1669: astore_1
    //   1670: goto +4 -> 1674
    //   1673: astore_1
    //   1674: ldc_w 817
    //   1677: iconst_1
    //   1678: aload 25
    //   1680: aload_1
    //   1681: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1684: goto +3 -> 1687
    //   1687: aconst_null
    //   1688: astore 23
    //   1690: aconst_null
    //   1691: astore 19
    //   1693: aload 23
    //   1695: astore 18
    //   1697: aload 22
    //   1699: astore_1
    //   1700: aload 22
    //   1702: ifnonnull +281 -> 1983
    //   1705: aload 23
    //   1707: astore 18
    //   1709: aload 22
    //   1711: astore_1
    //   1712: iload 9
    //   1714: ifeq +269 -> 1983
    //   1717: ldc_w 843
    //   1720: astore_1
    //   1721: aload_0
    //   1722: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1725: invokevirtual 849	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   1728: getfield 854	android/util/DisplayMetrics:widthPixels	I
    //   1731: sipush 1500
    //   1734: if_icmple +7 -> 1741
    //   1737: ldc_w 856
    //   1740: astore_1
    //   1741: aload_0
    //   1742: invokevirtual 860	mqq/app/AppActivity:getAssets	()Landroid/content/res/AssetManager;
    //   1745: aload_1
    //   1746: invokevirtual 866	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1749: astore 18
    //   1751: new 180	android/graphics/drawable/BitmapDrawable
    //   1754: dup
    //   1755: aload_0
    //   1756: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1759: aload 18
    //   1761: invokespecial 869	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   1764: astore 22
    //   1766: aload_0
    //   1767: invokevirtual 860	mqq/app/AppActivity:getAssets	()Landroid/content/res/AssetManager;
    //   1770: ldc_w 871
    //   1773: invokevirtual 866	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   1776: astore_1
    //   1777: aload_1
    //   1778: astore 20
    //   1780: aload 18
    //   1782: astore 19
    //   1784: new 180	android/graphics/drawable/BitmapDrawable
    //   1787: dup
    //   1788: aload_0
    //   1789: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   1792: aload_1
    //   1793: invokespecial 869	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Ljava/io/InputStream;)V
    //   1796: astore 25
    //   1798: aload 18
    //   1800: ifnull +11 -> 1811
    //   1803: aload 18
    //   1805: invokevirtual 876	java/io/InputStream:close	()V
    //   1808: goto +3 -> 1811
    //   1811: aload_1
    //   1812: ifnull +20 -> 1832
    //   1815: aload_1
    //   1816: invokevirtual 876	java/io/InputStream:close	()V
    //   1819: goto +13 -> 1832
    //   1822: ldc 208
    //   1824: iconst_1
    //   1825: ldc_w 878
    //   1828: aload_1
    //   1829: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1832: aload 22
    //   1834: astore_1
    //   1835: aload 25
    //   1837: astore 18
    //   1839: goto +144 -> 1983
    //   1842: astore 22
    //   1844: goto +34 -> 1878
    //   1847: astore_0
    //   1848: aload 19
    //   1850: astore_1
    //   1851: goto +96 -> 1947
    //   1854: astore 22
    //   1856: aconst_null
    //   1857: astore_1
    //   1858: goto +20 -> 1878
    //   1861: astore_0
    //   1862: aconst_null
    //   1863: astore 18
    //   1865: aload 19
    //   1867: astore_1
    //   1868: goto +79 -> 1947
    //   1871: astore 22
    //   1873: aconst_null
    //   1874: astore_1
    //   1875: aload_1
    //   1876: astore 18
    //   1878: aload_1
    //   1879: astore 20
    //   1881: aload 18
    //   1883: astore 19
    //   1885: ldc 208
    //   1887: iconst_1
    //   1888: ldc_w 880
    //   1891: aload 22
    //   1893: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1896: aload 18
    //   1898: ifnull +11 -> 1909
    //   1901: aload 18
    //   1903: invokevirtual 876	java/io/InputStream:close	()V
    //   1906: goto +3 -> 1909
    //   1909: aload_1
    //   1910: ifnull +20 -> 1930
    //   1913: aload_1
    //   1914: invokevirtual 876	java/io/InputStream:close	()V
    //   1917: goto +13 -> 1930
    //   1920: ldc 208
    //   1922: iconst_1
    //   1923: ldc_w 878
    //   1926: aload_1
    //   1927: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1930: aconst_null
    //   1931: astore_1
    //   1932: aload 23
    //   1934: astore 18
    //   1936: goto +47 -> 1983
    //   1939: astore_0
    //   1940: aload 20
    //   1942: astore_1
    //   1943: aload 19
    //   1945: astore 18
    //   1947: aload 18
    //   1949: ifnull +11 -> 1960
    //   1952: aload 18
    //   1954: invokevirtual 876	java/io/InputStream:close	()V
    //   1957: goto +3 -> 1960
    //   1960: aload_1
    //   1961: ifnull +20 -> 1981
    //   1964: aload_1
    //   1965: invokevirtual 876	java/io/InputStream:close	()V
    //   1968: goto +13 -> 1981
    //   1971: ldc 208
    //   1973: iconst_1
    //   1974: ldc_w 878
    //   1977: aload_1
    //   1978: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1981: aload_0
    //   1982: athrow
    //   1983: aload_1
    //   1984: ifnull +50 -> 2034
    //   1987: aload 21
    //   1989: aload_1
    //   1990: invokevirtual 884	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   1993: aload_1
    //   1994: instanceof 149
    //   1997: ifeq +37 -> 2034
    //   2000: aload_1
    //   2001: checkcast 149	android/graphics/drawable/AnimationDrawable
    //   2004: astore_1
    //   2005: aload_1
    //   2006: ifnull +28 -> 2034
    //   2009: aload_1
    //   2010: iconst_0
    //   2011: invokevirtual 887	android/graphics/drawable/AnimationDrawable:setOneShot	(Z)V
    //   2014: aload_1
    //   2015: invokevirtual 888	android/graphics/drawable/AnimationDrawable:start	()V
    //   2018: goto +16 -> 2034
    //   2021: astore_1
    //   2022: ldc 208
    //   2024: iconst_1
    //   2025: ldc 228
    //   2027: aload_1
    //   2028: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2031: goto +3 -> 2034
    //   2034: aload 21
    //   2036: invokevirtual 892	android/widget/ImageView:getDrawable	()Landroid/graphics/drawable/Drawable;
    //   2039: astore_1
    //   2040: aload_1
    //   2041: ifnull +127 -> 2168
    //   2044: aload_1
    //   2045: instanceof 180
    //   2048: ifne +17 -> 2065
    //   2051: aload_1
    //   2052: instanceof 894
    //   2055: ifne +10 -> 2065
    //   2058: aload_1
    //   2059: instanceof 149
    //   2062: ifeq +106 -> 2168
    //   2065: aload_0
    //   2066: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   2069: invokevirtual 849	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   2072: getfield 854	android/util/DisplayMetrics:widthPixels	I
    //   2075: istore 5
    //   2077: aload_0
    //   2078: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   2081: invokevirtual 849	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   2084: getfield 897	android/util/DisplayMetrics:heightPixels	I
    //   2087: istore 6
    //   2089: aload_1
    //   2090: invokevirtual 902	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   2093: iload 5
    //   2095: imul
    //   2096: aload_1
    //   2097: invokevirtual 905	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   2100: idiv
    //   2101: istore 7
    //   2103: aload 21
    //   2105: invokevirtual 909	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   2108: astore_1
    //   2109: aload_1
    //   2110: iload 5
    //   2112: putfield 914	android/view/ViewGroup$LayoutParams:width	I
    //   2115: aload_1
    //   2116: iload 7
    //   2118: putfield 917	android/view/ViewGroup$LayoutParams:height	I
    //   2121: aload 21
    //   2123: aload_1
    //   2124: invokevirtual 921	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2127: iload 7
    //   2129: iload 6
    //   2131: if_icmpgt +14 -> 2145
    //   2134: aload 21
    //   2136: getstatic 927	android/widget/ImageView$ScaleType:FIT_XY	Landroid/widget/ImageView$ScaleType;
    //   2139: invokevirtual 931	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   2142: goto +26 -> 2168
    //   2145: iload 7
    //   2147: iload 6
    //   2149: if_icmple +19 -> 2168
    //   2152: aload 21
    //   2154: getstatic 934	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   2157: invokevirtual 931	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   2160: goto +8 -> 2168
    //   2163: astore_1
    //   2164: aload_1
    //   2165: invokevirtual 787	java/lang/Throwable:printStackTrace	()V
    //   2168: aload 24
    //   2170: ifnull +160 -> 2330
    //   2173: aload 18
    //   2175: ifnull +155 -> 2330
    //   2178: aload 24
    //   2180: aload 18
    //   2182: invokevirtual 884	android/widget/ImageView:setImageDrawable	(Landroid/graphics/drawable/Drawable;)V
    //   2185: aload_0
    //   2186: invokevirtual 777	mqq/app/AppActivity:getResources	()Landroid/content/res/Resources;
    //   2189: invokevirtual 849	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   2192: getfield 854	android/util/DisplayMetrics:widthPixels	I
    //   2195: istore 5
    //   2197: aload 18
    //   2199: invokevirtual 905	android/graphics/drawable/Drawable:getIntrinsicWidth	()I
    //   2202: i2f
    //   2203: aload 18
    //   2205: invokevirtual 902	android/graphics/drawable/Drawable:getIntrinsicHeight	()I
    //   2208: i2f
    //   2209: fdiv
    //   2210: fstore_3
    //   2211: iload 5
    //   2213: i2f
    //   2214: ldc_w 935
    //   2217: fmul
    //   2218: f2i
    //   2219: istore 6
    //   2221: iload 6
    //   2223: i2f
    //   2224: fstore 4
    //   2226: fload 4
    //   2228: fload_3
    //   2229: fdiv
    //   2230: f2i
    //   2231: istore 7
    //   2233: aload 24
    //   2235: invokevirtual 909	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   2238: checkcast 937	android/view/ViewGroup$MarginLayoutParams
    //   2241: astore_0
    //   2242: aload_0
    //   2243: iload 6
    //   2245: putfield 938	android/view/ViewGroup$MarginLayoutParams:width	I
    //   2248: aload_0
    //   2249: iload 7
    //   2251: putfield 939	android/view/ViewGroup$MarginLayoutParams:height	I
    //   2254: aload_0
    //   2255: iload 5
    //   2257: iload 6
    //   2259: isub
    //   2260: iconst_2
    //   2261: idiv
    //   2262: putfield 942	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   2265: aload_0
    //   2266: fload 4
    //   2268: fconst_2
    //   2269: fmul
    //   2270: ldc_w 943
    //   2273: fmul
    //   2274: ldc_w 944
    //   2277: fdiv
    //   2278: f2i
    //   2279: putfield 947	android/view/ViewGroup$MarginLayoutParams:bottomMargin	I
    //   2282: aload_0
    //   2283: getfield 942	android/view/ViewGroup$MarginLayoutParams:leftMargin	I
    //   2286: ifle +17 -> 2303
    //   2289: aload 24
    //   2291: aload_0
    //   2292: invokevirtual 921	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   2295: aload 24
    //   2297: iconst_0
    //   2298: invokevirtual 950	android/widget/ImageView:setVisibility	(I)V
    //   2301: iload_2
    //   2302: ireturn
    //   2303: aload 24
    //   2305: bipush 8
    //   2307: invokevirtual 950	android/widget/ImageView:setVisibility	(I)V
    //   2310: iload_2
    //   2311: ireturn
    //   2312: astore_0
    //   2313: aload 24
    //   2315: bipush 8
    //   2317: invokevirtual 950	android/widget/ImageView:setVisibility	(I)V
    //   2320: ldc 208
    //   2322: iconst_1
    //   2323: ldc_w 952
    //   2326: aload_0
    //   2327: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2330: iload_2
    //   2331: ireturn
    //   2332: iconst_1
    //   2333: ireturn
    //   2334: ldc_w 954
    //   2337: iconst_1
    //   2338: ldc 228
    //   2340: aload_1
    //   2341: invokestatic 554	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2344: aload_0
    //   2345: invokevirtual 957	mqq/app/AppActivity:superFinish	()V
    //   2348: iconst_1
    //   2349: ireturn
    //   2350: astore 28
    //   2352: goto -1437 -> 915
    //   2355: astore 28
    //   2357: goto -1442 -> 915
    //   2360: iconst_0
    //   2361: istore 10
    //   2363: goto -771 -> 1592
    //   2366: astore_1
    //   2367: goto -545 -> 1822
    //   2370: astore_1
    //   2371: goto -451 -> 1920
    //   2374: astore_1
    //   2375: goto -404 -> 1971
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2378	0	paramAppActivity	AppActivity
    //   0	2378	1	paramStartupDirector	StartupDirector
    //   0	2378	2	paramBoolean	boolean
    //   2210	19	3	f1	float
    //   2224	43	4	f2	float
    //   533	1727	5	i	int
    //   788	1472	6	j	int
    //   798	1452	7	k	int
    //   883	21	8	m	int
    //   53	1660	9	bool1	boolean
    //   515	1847	10	bool2	boolean
    //   1503	12	11	bool3	boolean
    //   791	364	12	l1	long
    //   795	364	14	l2	long
    //   927	230	16	l3	long
    //   14	21	18	localClass	java.lang.Class
    //   92	9	18	localThrowable1	Throwable
    //   191	298	18	str	String
    //   540	1	18	localException1	Exception
    //   569	20	18	localException2	Exception
    //   614	1590	18	localObject1	Object
    //   173	1771	19	localObject2	Object
    //   154	1787	20	localObject3	Object
    //   142	1122	21	localObject4	Object
    //   1322	16	21	localThrowable2	Throwable
    //   1343	810	21	localObject5	Object
    //   179	212	22	localFile	File
    //   430	1	22	localThrowable3	Throwable
    //   441	23	22	localThrowable4	Throwable
    //   495	775	22	localObject6	Object
    //   1335	7	22	localThrowable5	Throwable
    //   1360	473	22	localObject7	Object
    //   1842	1	22	localThrowable6	Throwable
    //   1854	1	22	localThrowable7	Throwable
    //   1871	21	22	localThrowable8	Throwable
    //   214	1719	23	localObject8	Object
    //   783	1531	24	localObject9	Object
    //   720	1116	25	localObject10	Object
    //   815	481	26	localObject11	Object
    //   827	241	27	localObject12	Object
    //   855	44	28	localObject13	Object
    //   2350	1	28	localException3	Exception
    //   2355	1	28	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   0	85	88	android/content/res/Resources$NotFoundException
    //   94	105	88	android/content/res/Resources$NotFoundException
    //   105	122	88	android/content/res/Resources$NotFoundException
    //   125	132	88	android/content/res/Resources$NotFoundException
    //   0	85	92	java/lang/Throwable
    //   420	427	430	java/lang/Throwable
    //   398	416	441	java/lang/Throwable
    //   522	529	540	java/lang/Exception
    //   506	517	569	java/lang/Exception
    //   1312	1319	1322	java/lang/Throwable
    //   1287	1308	1335	java/lang/Throwable
    //   1558	1566	1637	java/lang/Throwable
    //   1546	1558	1641	java/lang/Throwable
    //   1566	1586	1641	java/lang/Throwable
    //   1592	1634	1641	java/lang/Throwable
    //   1645	1652	1660	java/lang/Throwable
    //   1486	1496	1669	java/lang/Throwable
    //   1458	1478	1673	java/lang/Throwable
    //   1496	1514	1673	java/lang/Throwable
    //   1529	1546	1673	java/lang/Throwable
    //   1784	1798	1842	java/lang/Throwable
    //   1751	1777	1847	finally
    //   1751	1777	1854	java/lang/Throwable
    //   1721	1737	1861	finally
    //   1741	1751	1861	finally
    //   1721	1737	1871	java/lang/Throwable
    //   1741	1751	1871	java/lang/Throwable
    //   1784	1798	1939	finally
    //   1885	1896	1939	finally
    //   2000	2005	2021	java/lang/Throwable
    //   2009	2018	2021	java/lang/Throwable
    //   2034	2040	2163	java/lang/Throwable
    //   2044	2065	2163	java/lang/Throwable
    //   2065	2127	2163	java/lang/Throwable
    //   2134	2142	2163	java/lang/Throwable
    //   2152	2160	2163	java/lang/Throwable
    //   2178	2211	2312	java/lang/Throwable
    //   2226	2301	2312	java/lang/Throwable
    //   2303	2310	2312	java/lang/Throwable
    //   875	885	2350	java/lang/Exception
    //   885	912	2355	java/lang/Exception
    //   1803	1808	2366	java/lang/Throwable
    //   1815	1819	2366	java/lang/Throwable
    //   1901	1906	2370	java/lang/Throwable
    //   1913	1917	2370	java/lang/Throwable
    //   1952	1957	2374	java/lang/Throwable
    //   1964	1968	2374	java/lang/Throwable
  }
  
  private static SplashADView b(Activity paramActivity, SplashUIdata paramSplashUIdata, StartupDirector paramStartupDirector)
  {
    SplashADView localSplashADView = SplashADView.a(paramSplashUIdata, paramActivity);
    SplashItem localSplashItem = VasSplashUtil.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SplashADUtil.a(BaseApplicationImpl.getApplication()));
    localStringBuilder.append("");
    localSplashADView.setOnClickListener(new SetSplash.5(localSplashItem, paramStartupDirector, localSplashADView, paramSplashUIdata, paramActivity, localStringBuilder.toString()));
    if (paramSplashUIdata.a == 2)
    {
      localSplashADView.setOnErrorListener(new SetSplash.6(paramStartupDirector));
      localSplashADView.setOnCompletionListener(new SetSplash.7(paramStartupDirector));
      localSplashADView.setPresenter(new SetSplash.8((ImageView)paramActivity.findViewById(2131377783), (ImageView)paramActivity.findViewById(2131377786)));
    }
    return localSplashADView;
  }
  
  private static void b()
  {
    ThreadManager.getFileThreadHandler().postDelayed(new SetSplash.9(), 5000L);
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
    paramSplashAnimListener = a();
    if ((paramSplashAnimListener != null) && (paramSplashAnimListener.getParent() != null) && ((paramSplashAnimListener.getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)paramSplashAnimListener.getParent()).removeView(paramSplashAnimListener);
      QLog.i("SetSplash", 1, "removeView splash view");
    }
    a();
    jdField_a_of_type_ComTencentMobileqqStartupStepSetSplash$SplashAnimListener = null;
    jdField_a_of_type_JavaLangRunnable = null;
  }
  
  private static void b(AppActivity paramAppActivity)
  {
    QLog.d("QSplash@VasSplashUtil", 1, "initSplashAnim UnionBannerSplash animation");
    if ((Build.VERSION.SDK_INT >= 21) && (b())) {
      try
      {
        View localView = paramAppActivity.findViewById(2131377782);
        if ((localView != null) && ((localView.getParent() instanceof ViewGroup)))
        {
          ViewGroup localViewGroup = (ViewGroup)localView.getParent();
          if (localViewGroup != null) {
            localViewGroup.removeView(localView);
          }
          ((ViewGroup)paramAppActivity.getWindow().getDecorView()).addView(localView);
          jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localView);
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
  
  public static boolean b()
  {
    boolean bool = BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).getBoolean("splashAnim", true);
    QLog.d("QSplash@VasSplashUtil", 1, new Object[] { "isEnableSplashAnim:", Boolean.valueOf(bool) });
    return bool;
  }
  
  public static boolean c()
  {
    return a() != null;
  }
  
  protected boolean doStep()
  {
    AppActivity localAppActivity = this.mDirector.jdField_a_of_type_MqqAppAppActivity;
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
      this.mDirector.a();
      if (!a(localAppActivity, this.mDirector, true))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.appStartTime = 0L;
        this.mDirector.b = 0L;
      }
      this.jdField_a_of_type_Boolean = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */