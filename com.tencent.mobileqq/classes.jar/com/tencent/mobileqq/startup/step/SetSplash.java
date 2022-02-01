package com.tencent.mobileqq.startup.step;

import abev;
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
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import azvf;
import azvg;
import azvi;
import azvj;
import bcor;
import bcow;
import bcqx;
import bcqy;
import bcqz;
import bcra;
import bcrb;
import bcrc;
import bcrd;
import bcre;
import bcrf;
import bggl;
import bggo;
import bgln;
import bgsg;
import bmtq;
import bqcd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppActivity;
import mqq.os.MqqHandler;

public class SetSplash
  extends Step
{
  public boolean a = true;
  
  private static int a(String paramString)
  {
    int i = Calendar.getInstance().get(1);
    paramString = i + "-" + paramString;
    Object localObject = new SimpleDateFormat("yyyy-MM-dd");
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
    catch (Exception paramString) {}
    return -1;
  }
  
  private static AnimationDrawable a(Context paramContext, bcow parambcow)
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
        if ((!TextUtils.isEmpty(str)) && (k > 0) && (m > 0))
        {
          localObject1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
          str = (String)localObject1 + "/" + str;
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
            BitmapFactory.Options localOptions = new BitmapFactory.Options();
            localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
            j = 0;
            i = 1;
            if (i > n) {
              break label432;
            }
            Object localObject2 = new File(str + "/" + String.valueOf(i) + ".png");
            if ((!((File)localObject2).exists()) || (((File)localObject2).length() <= 0L)) {
              break label423;
            }
            localObject2 = bggl.a(((File)localObject2).getAbsolutePath(), localOptions);
            if (localObject2 == null) {
              break label425;
            }
            j = 1;
            ((AnimationDrawable)localObject1).addFrame(new BitmapDrawable(paramContext.getResources(), (Bitmap)localObject2), m);
            break label425;
            if (QLog.isColorLevel()) {
              QLog.d("SetSplash", 2, "getDynamicSplashDrawable() playTimes=" + k + ", playInterval=" + m + ", totalFilesCount=" + n + ", totalPlayTime=" + i);
            }
            ThreadManager.post(new SetSplash.11(), 5, null, false);
            if (parambcow != null) {
              parambcow.jdField_a_of_type_Long = i;
            }
            return localObject1;
          }
          return null;
        }
      }
      catch (Throwable paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, "", paramContext);
        }
        return null;
      }
      return null;
      label423:
      return null;
      label425:
      i += 1;
      continue;
      label432:
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
  
  private static SplashADView a(Activity paramActivity, azvi paramazvi, bcow parambcow)
  {
    SplashADView localSplashADView = SplashADView.a(paramazvi, paramActivity);
    localSplashADView.setOnClickListener(new bcqz(parambcow));
    if (paramazvi.a == 2)
    {
      localSplashADView.setOnErrorListener(new bcra(parambcow));
      localSplashADView.setPresenter(new bcrb((ImageView)paramActivity.findViewById(2131377762), (ImageView)paramActivity.findViewById(2131377765)));
    }
    return localSplashADView;
  }
  
  private static void a()
  {
    ThreadManager.getFileThreadHandler().postDelayed(new SetSplash.10(), 5000L);
  }
  
  public static boolean a()
  {
    long l1 = BaseApplicationImpl.getApplication().getSharedPreferences("banner_and_splash", 0).getLong("splashshowtime", 0L);
    long l2 = System.currentTimeMillis();
    if ((l2 > l1) && (l2 <= 86400000L + l1)) {
      return false;
    }
    if (l2 > l1 + 86400000L)
    {
      Object localObject2 = BaseApplicationImpl.sApplication;
      Object localObject1 = ((Context)localObject2).getFilesDir();
      long l3;
      long l4;
      int j;
      int i;
      if (localObject1 != null)
      {
        localObject1 = ((File)localObject1).getAbsolutePath();
        localObject3 = new File((String)localObject1 + "/splashpic");
        l3 = 0L;
        l4 = 0L;
        if ((localObject3 != null) && (((File)localObject3).exists()) && (((File)localObject3).isDirectory()))
        {
          localObject3 = ((File)localObject3).listFiles();
          if (localObject3 != null)
          {
            j = localObject3.length;
            i = 0;
          }
        }
      }
      else
      {
        for (;;)
        {
          long l5;
          long l6;
          for (;;)
          {
            if (i >= j) {
              break label342;
            }
            Object localObject4 = localObject3[i];
            l5 = l4;
            l6 = l3;
            if (localObject4 != null)
            {
              localObject4 = ((File)localObject4).getName().split("_");
              l5 = l4;
              l6 = l3;
              if (localObject4 != null)
              {
                l5 = l4;
                l6 = l3;
                if (localObject4.length == 3)
                {
                  localObject4 = localObject4[0];
                  l1 = l4;
                  l2 = l3;
                  if (localObject4 != null)
                  {
                    l1 = l4;
                    l2 = l3;
                    if (((String)localObject4).trim().equals("")) {}
                  }
                  try
                  {
                    int k = ((String)localObject4).indexOf("|");
                    l2 = Long.parseLong(((String)localObject4).substring(0, k));
                    l1 = Long.parseLong(((String)localObject4).substring(k + 1));
                    l5 = l1;
                    l6 = l2;
                    if (bggo.a(l2, l1))
                    {
                      return true;
                      localObject1 = "/data/data/com.tencent.mobileqq/files";
                    }
                  }
                  catch (Exception localException)
                  {
                    for (;;)
                    {
                      l2 = 0L;
                      l1 = 0L;
                    }
                  }
                }
              }
            }
          }
          i += 1;
          l4 = l5;
          l3 = l6;
        }
      }
      label342:
      Object localObject3 = bgsg.b(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, "bir = " + (String)localObject3);
      }
      if ((!((String)localObject3).equals("")) && (a((String)localObject3) == 0))
      {
        localObject1 = new File((String)localObject1 + "/" + bgsg.a((Context)localObject2) + "/" + "birthdayflashlogo.png");
        if ((localObject1 != null) && (((File)localObject1).exists()) && (((File)localObject1).length() > 1L)) {
          return true;
        }
      }
      try
      {
        l1 = bcor.a(BaseApplicationImpl.getApplication());
        localObject2 = azvf.a(BaseApplicationImpl.getContext(), l1);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject1 = azvf.a(BaseApplicationImpl.getApplication(), l1 + "");
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (String)((Iterator)localObject2).next();
            if ((((HashMap)localObject1).containsKey(localObject3)) && (((azvg)((HashMap)localObject1).get(localObject3)).a()))
            {
              if (QLog.isColorLevel()) {
                QLog.i("SetSplash", 2, "qbosssplash should show kill");
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
    if (QLog.isColorLevel()) {
      QLog.d("SetSplash", 2, "now time less than last show time");
    }
    return false;
  }
  
  private static boolean a(Context paramContext)
  {
    try
    {
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(paramContext);
      String str2 = localSharedPreferences.getString("dynamic_splash_config_effective_time", null);
      paramContext = localSharedPreferences.getString("dynamic_splash_config_md5", null);
      long l3 = localSharedPreferences.getLong("dynamic_splash_config_folder_modify_time", -1L);
      if (localSharedPreferences.getInt("dynamic_splash_config_show_times", -1) <= 0) {
        return false;
      }
      boolean bool = TextUtils.isEmpty(str2);
      if (!bool) {}
      int i;
      long l2;
      long l1;
      String str1;
      return false;
    }
    catch (Throwable paramContext)
    {
      try
      {
        i = str2.indexOf("|");
        l2 = Long.parseLong(str2.substring(0, i));
        l1 = Long.parseLong(str2.substring(i + 1));
        if (!bggo.a(l2, l1))
        {
          if (!QLog.isColorLevel()) {
            break label306;
          }
          QLog.d("SetSplash", 2, "needShowDynamicSplash() the current time is not effective");
          return false;
          paramContext = paramContext;
          if (!QLog.isColorLevel()) {
            break label306;
          }
          QLog.d("SetSplash", 2, "needShowDynamicSplash() ERROR msg=" + paramContext.getMessage());
          return false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          l1 = 0L;
          l2 = 0L;
        }
        if ((l3 >= 0L) && (!TextUtils.isEmpty(paramContext)))
        {
          str1 = BaseApplicationImpl.getContext().getFilesDir().getAbsolutePath() + "/dynamicSplash";
          paramContext = new File(str1 + "/" + paramContext);
          if ((paramContext.exists()) && (paramContext.isDirectory()) && (l3 == paramContext.lastModified()) && (bgln.d() >= 805306368L)) {
            return true;
          }
          if (QLog.isColorLevel()) {
            QLog.d("SetSplash", 2, "needShowDynamicSplash() the folder of splash is modified, NOT show");
          }
        }
      }
    }
  }
  
  public static boolean a(AppActivity paramAppActivity, bcow parambcow, boolean paramBoolean)
  {
    boolean bool1 = true;
    boolean bool2;
    ImageView localImageView2;
    ImageView localImageView1;
    for (;;)
    {
      try
      {
        bool2 = bqcd.c(paramAppActivity);
        if (QLog.isColorLevel()) {
          QLog.d("SetSplash", 2, new Object[] { "enableNotch=", Boolean.valueOf(bool2) });
        }
        if ((paramAppActivity instanceof IphoneTitleBarActivity))
        {
          ((IphoneTitleBarActivity)paramAppActivity).setContentViewNoTitle(2131562895);
          localImageView2 = (ImageView)paramAppActivity.findViewById(2131377762);
          localImageView1 = (ImageView)paramAppActivity.findViewById(2131377765);
          if ((localImageView2 != null) && (localImageView1 != null)) {
            break;
          }
          return true;
        }
      }
      catch (Throwable localThrowable1)
      {
        QLog.e("SetSplash", 1, "enableNotch exception", localThrowable1);
        continue;
      }
      catch (Resources.NotFoundException parambcow)
      {
        QLog.e("ResourcesLoad", 1, "", parambcow);
        paramAppActivity.superFinish();
        return true;
      }
      paramAppActivity.setContentView(2131562895);
    }
    Object localObject1 = bgsg.b(paramAppActivity);
    Object localObject3 = paramAppActivity.getFilesDir();
    Object localObject5;
    if (localObject3 != null)
    {
      localObject5 = ((File)localObject3).getAbsolutePath();
      if (QLog.isColorLevel()) {
        QLog.i("SetSplash", 2, (String)localObject1 + localObject3);
      }
      if ((localObject3 == null) || (((String)localObject1).equals("")) || (a((String)localObject1) != 0)) {
        break label2475;
      }
      localObject1 = (String)localObject5 + "/" + bgsg.a(paramAppActivity) + "/" + "birthdayflashlogo.png";
      localObject3 = new File((String)localObject1);
      if (QLog.isColorLevel()) {
        QLog.e("SetSplash", 2, (String)localObject1 + " ,birthday_logoPath exists? " + ((File)localObject3).exists());
      }
      if (!((File)localObject3).exists()) {
        break label2475;
      }
    }
    label2347:
    for (;;)
    {
      try
      {
        localObject1 = new BitmapDrawable(paramAppActivity.getResources(), bggl.a((String)localObject1));
        if (parambcow != null) {}
        try
        {
          parambcow.jdField_a_of_type_Long = 2200L;
          bool1 = false;
          if (localObject1 == null) {
            break label2472;
          }
          a();
        }
        catch (Throwable localThrowable5)
        {
          long l1;
          Object localObject8;
          Object localObject9;
          Object localObject7;
          int k;
          int j;
          long l4;
          long l3;
          InputStream localInputStream;
          long l5;
          long l6;
          String str;
          String[] arrayOfString;
          long l2;
          int m;
          azvg localazvg;
          Object localObject6;
          Object localObject4;
          boolean bool3;
          boolean bool4;
          float f;
          azvj localazvj;
          continue;
          parambcow = null;
          continue;
          bool2 = paramBoolean;
          paramBoolean = bool1;
          bool1 = bool2;
          continue;
          localObject2 = localThrowable5;
          bool1 = bool2;
          continue;
          continue;
          int i = 0;
          continue;
          i = 0;
          continue;
          continue;
        }
        if ((localObject1 != null) || (parambcow == null)) {}
      }
      catch (Throwable localException1)
      {
        try
        {
          l1 = bcor.a(BaseApplicationImpl.getApplication());
          if (abev.a(BaseApplicationImpl.getApplication()))
          {
            azvf.a(BaseApplicationImpl.getApplication(), l1, true);
            i = 0;
            if ((localObject1 != null) || (!a(BaseApplicationImpl.getContext())) || (i != 0)) {
              break label2457;
            }
            localObject1 = a(BaseApplicationImpl.getContext(), parambcow);
            bool1 = false;
            localObject3 = localObject1;
            bool2 = bool1;
            if (localObject1 != null) {
              break label2446;
            }
            localObject3 = localObject1;
            bool2 = bool1;
            if (i != 0) {
              break label2446;
            }
            if (QLog.isColorLevel()) {
              QLog.i("setsplash", 2, "not birthday splash");
            }
            localObject8 = (String)localObject5 + "/splashpic/";
            localObject9 = new File((String)localObject5 + "/splashpic");
            localObject7 = null;
            localObject3 = null;
            localObject5 = localObject7;
            if (localObject9 == null) {
              continue;
            }
            localObject5 = localObject7;
            if (!((File)localObject9).exists()) {
              continue;
            }
            localObject5 = localObject7;
            if (!((File)localObject9).isDirectory()) {
              continue;
            }
            localObject9 = ((File)localObject9).listFiles();
            k = localObject9.length;
            j = 0;
            l4 = 0L;
            l3 = 0L;
            localObject5 = localObject3;
            if (j >= k) {
              continue;
            }
            localInputStream = localObject9[j];
            localObject7 = localObject3;
            l5 = l4;
            l6 = l3;
            if (localInputStream != null)
            {
              str = localInputStream.getName();
              arrayOfString = str.split("_");
              localObject7 = localObject3;
              l5 = l4;
              l6 = l3;
              if (arrayOfString != null)
              {
                localObject7 = localObject3;
                l5 = l4;
                l6 = l3;
                if (arrayOfString.length == 3)
                {
                  localObject5 = arrayOfString[0];
                  l1 = l4;
                  l2 = l3;
                  if (localObject5 != null)
                  {
                    l1 = l4;
                    l2 = l3;
                    if (((String)localObject5).trim().equals("")) {}
                  }
                }
              }
            }
          }
        }
        catch (Exception localException1)
        {
          try
          {
            m = ((String)localObject5).indexOf("|");
            l2 = Long.parseLong(((String)localObject5).substring(0, m));
            l1 = Long.parseLong(((String)localObject5).substring(m + 1));
            if (bggo.a(l2, l1))
            {
              localObject5 = localObject3;
              if (localObject3 == null) {
                localObject5 = new File((String)localObject8 + arrayOfString[1]);
              }
              localObject7 = localObject5;
              l5 = l1;
              l6 = l2;
              if (QLog.isColorLevel())
              {
                QLog.i("setsplash", 2, "处理每个记录" + localInputStream.getAbsolutePath());
                l6 = l2;
                l5 = l1;
                localObject7 = localObject5;
              }
              j += 1;
              localObject3 = localObject7;
              l4 = l5;
              l3 = l6;
              continue;
              localObject5 = "/data/data/com.tencent.mobileqq/files";
              break;
              localThrowable4 = localThrowable4;
              localObject1 = null;
              if (QLog.isColorLevel()) {
                QLog.e("SetSplash", 2, "decodeFile Failed!", localThrowable4);
              }
              localThrowable4.printStackTrace();
              continue;
              if (!azvf.a(l1))
              {
                QLog.i("QSplash@QbossSplashUtil", 1, "don't show splash");
                i = 0;
                continue;
              }
              localazvg = azvf.a;
              if (localazvg == null)
              {
                QLog.i("QSplash@QbossSplashUtil", 1, "adEntry  == null");
                i = 0;
                continue;
              }
              if (localazvg.a == 1)
              {
                azvf.a(localazvg.jdField_b_of_type_JavaLangString, l1, false);
                i = 0;
                continue;
              }
              BaseApplicationImpl.sLaunchTime = 0L;
              BaseApplicationImpl.sShowTime = 0L;
              QLog.i("QSplash@QbossSplashUtil", 1, "ready show Splash");
              a();
              if (!bcor.a(paramAppActivity)) {
                break label2460;
              }
              QLog.i("QSplash@QbossSplashUtil", 1, "show Splash AD, uin = " + l1 % 10000L);
              if (localazvg.jdField_b_of_type_Int == 1)
              {
                QLog.i("QSplash@QbossSplashUtil", 1, "preLoad web");
                WebProcessManager.b(-1);
                azvf.b = true;
              }
              if (localazvg.jdField_b_of_type_Int == 2)
              {
                bmtq.a();
                SplashMiniGameStarter.preloadProcess();
              }
              if (localazvg.jdField_b_of_type_Int == 3)
              {
                bmtq.a();
                SplashMiniGameStarter.preloadGameProcess();
              }
              localObject7 = new azvj();
              ((azvj)localObject7).a(localazvg.a).a(localazvg.h).c(localazvg.h).b(localazvg.e).c(1).b(localazvg.j).d(localazvg.jdField_b_of_type_Int).d(localazvg.f);
              parambcow.a(new bcqx(localazvg, b(paramAppActivity, ((azvj)localObject7).a(), parambcow), paramAppActivity, localImageView1, localImageView2, l1));
              bool1 = false;
              paramBoolean = true;
              bool2 = true;
            }
            try
            {
              parambcow.jdField_a_of_type_Long = 1500L;
              i = 1;
              paramBoolean = bool2;
            }
            catch (Exception localException2)
            {
              bool1 = false;
              continue;
            }
            localException1 = localException1;
            QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd initView error ", localException1);
            i = 0;
          }
          catch (Exception localException3)
          {
            l2 = 0L;
            l1 = 0L;
            continue;
            localObject6 = localException1;
            if (l1 >= System.currentTimeMillis()) {
              continue;
            }
            localObject7 = new File((String)localObject8 + str);
            localObject6 = localException1;
            if (!((File)localObject7).exists()) {
              continue;
            }
            ((File)localObject7).delete();
            localObject6 = localException1;
            continue;
          }
          localObject4 = localObject1;
          bool2 = bool1;
          if (localObject6 == null) {
            break label2446;
          }
        }
        localObject4 = localObject1;
        bool2 = bool1;
        if (((File)localObject6).exists())
        {
          localObject4 = localObject1;
          bool2 = bool1;
          if (((File)localObject6).isFile())
          {
            try
            {
              localObject4 = new BitmapDrawable(paramAppActivity.getResources(), bggl.a(((File)localObject6).getAbsolutePath()));
              bool1 = false;
              if (parambcow == null) {}
            }
            catch (Throwable localThrowable6)
            {
              QLog.e("SetSplash", 1, "", localThrowable6);
              continue;
              bool2 = bool1;
              bool3 = paramBoolean;
              QLog.i("SplashMiniGameStarter", 1, "ready show Splash");
              bool2 = bool1;
              bool3 = paramBoolean;
              a();
              bool2 = bool1;
              bool3 = paramBoolean;
              if ((bcor.a(paramAppActivity)) && (bool4))
              {
                bool2 = bool1;
                bool3 = paramBoolean;
                localObject4 = new azvj();
                bool2 = bool1;
                bool3 = paramBoolean;
                localazvj = ((azvj)localObject4).a(2).a(null).b(0).c(1).c(SplashMiniGameStarter.curData.videoLocalPath);
                bool2 = bool1;
                bool3 = paramBoolean;
                if (SplashMiniGameStarter.curData.videoMute == 0)
                {
                  bool4 = true;
                  bool2 = bool1;
                  bool3 = paramBoolean;
                  localazvj.a(bool4).b(false);
                  bool2 = bool1;
                  bool3 = paramBoolean;
                  localObject4 = ((azvj)localObject4).a();
                  bool2 = bool1;
                  bool3 = paramBoolean;
                  parambcow.a(new bcqy(localObject4, a(paramAppActivity, (azvi)localObject4, parambcow), paramAppActivity));
                }
              }
              else
              {
                bool2 = false;
                bool1 = false;
                bool3 = true;
                paramBoolean = true;
                parambcow.jdField_a_of_type_Long = 1500L;
                continue;
              }
            }
            for (;;)
            {
              try
              {
                parambcow.jdField_a_of_type_Long = 2201L;
                localObject1 = localObject4;
                bool1 = false;
                localObject4 = localObject1;
                bool2 = bool1;
                if (localObject1 == null) {
                  break label2446;
                }
                a();
                if ((localObject1 != null) || (parambcow == null) || (i != 0)) {
                  break label2433;
                }
                bool2 = bool1;
                bool3 = paramBoolean;
              }
              catch (Throwable localThrowable7)
              {
                localObject2 = localObject4;
                break label1969;
              }
              try
              {
                bool4 = SplashMiniGameStarter.needShow();
                if (bool4) {
                  break label1982;
                }
                bool2 = bool1;
                bool1 = paramBoolean;
                paramBoolean = bool2;
              }
              catch (Throwable parambcow)
              {
                bool1 = bool3;
                paramBoolean = bool2;
                QLog.e("SplashMiniGameStarter", 1, "show SplashAd initView error ", parambcow);
                break;
                bool4 = false;
                break label2099;
              }
            }
            if ((localObject1 == null) && (bool1))
            {
              str = null;
              localObject8 = null;
              localInputStream = null;
              localObject9 = null;
              localObject7 = "splash.jpg";
              localObject4 = localObject9;
              localObject6 = localObject8;
              parambcow = localInputStream;
              localObject1 = str;
              for (;;)
              {
                try
                {
                  if (paramAppActivity.getResources().getDisplayMetrics().widthPixels > 1500) {
                    localObject7 = "splash_big.jpg";
                  }
                  localObject4 = localObject9;
                  localObject6 = localObject8;
                  parambcow = localInputStream;
                  localObject1 = str;
                  localObject8 = paramAppActivity.getAssets().open((String)localObject7);
                  localObject4 = localObject9;
                  localObject6 = localObject8;
                  parambcow = localInputStream;
                  localObject1 = localObject8;
                  localObject7 = new BitmapDrawable(paramAppActivity.getResources(), (InputStream)localObject8);
                  localObject4 = localObject9;
                  localObject6 = localObject8;
                  parambcow = localInputStream;
                  localObject1 = localObject8;
                  localInputStream = paramAppActivity.getAssets().open("splash_logo.png");
                  localObject4 = localInputStream;
                  localObject6 = localObject8;
                  parambcow = localInputStream;
                  localObject1 = localObject8;
                  localObject9 = new BitmapDrawable(paramAppActivity.getResources(), localInputStream);
                  if (localObject8 == null) {}
                }
                catch (Throwable localThrowable8)
                {
                  parambcow = (bcow)localObject4;
                  localObject1 = localazvj;
                  QLog.e("SetSplash", 1, "e1:", localThrowable8);
                  if (localazvj == null) {
                    continue;
                  }
                  try
                  {
                    localazvj.close();
                    if (localObject4 != null) {
                      ((InputStream)localObject4).close();
                    }
                    parambcow = null;
                    localObject1 = null;
                  }
                  catch (Throwable parambcow)
                  {
                    QLog.e("SetSplash", 1, "e2:", parambcow);
                    parambcow = null;
                    localObject1 = null;
                  }
                  continue;
                }
                finally
                {
                  if (localObject1 == null) {
                    continue;
                  }
                  try
                  {
                    ((InputStream)localObject1).close();
                    if (parambcow == null) {
                      continue;
                    }
                    parambcow.close();
                  }
                  catch (Throwable parambcow)
                  {
                    QLog.e("SetSplash", 1, "e2:", parambcow);
                    continue;
                  }
                }
                try
                {
                  ((InputStream)localObject8).close();
                  if (localInputStream != null) {
                    localInputStream.close();
                  }
                  parambcow = (bcow)localObject9;
                  localObject1 = localObject7;
                }
                catch (Throwable parambcow)
                {
                  QLog.e("SetSplash", 1, "e2:", parambcow);
                  parambcow = (bcow)localObject9;
                  localObject1 = localObject7;
                }
              }
              if (localObject1 != null)
              {
                localImageView2.setImageDrawable((Drawable)localObject1);
                if (!(localObject1 instanceof AnimationDrawable)) {}
              }
              try
              {
                localObject1 = (AnimationDrawable)localObject1;
                if (localObject1 != null)
                {
                  ((AnimationDrawable)localObject1).setOneShot(false);
                  ((AnimationDrawable)localObject1).start();
                }
              }
              catch (Throwable localThrowable2)
              {
                QLog.e("SetSplash", 1, "", localThrowable2);
                continue;
                if (k <= j) {
                  continue;
                }
                localImageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                continue;
              }
              try
              {
                localObject1 = localImageView2.getDrawable();
                if ((localObject1 != null) && (((localObject1 instanceof BitmapDrawable)) || ((localObject1 instanceof SkinnableBitmapDrawable)) || ((localObject1 instanceof AnimationDrawable))))
                {
                  i = paramAppActivity.getResources().getDisplayMetrics().widthPixels;
                  j = paramAppActivity.getResources().getDisplayMetrics().heightPixels;
                  k = ((Drawable)localObject1).getIntrinsicHeight() * i / ((Drawable)localObject1).getIntrinsicWidth();
                  localObject1 = localImageView2.getLayoutParams();
                  ((ViewGroup.LayoutParams)localObject1).width = i;
                  ((ViewGroup.LayoutParams)localObject1).height = k;
                  localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  if (k > j) {
                    break label2347;
                  }
                  localImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                }
              }
              catch (Throwable localThrowable3)
              {
                localThrowable3.printStackTrace();
                continue;
                localImageView1.setVisibility(8);
                continue;
              }
              if ((localImageView1 != null) && (parambcow != null)) {}
              try
              {
                localImageView1.setImageDrawable(parambcow);
                i = paramAppActivity.getResources().getDisplayMetrics().widthPixels;
                f = parambcow.getIntrinsicWidth() / parambcow.getIntrinsicHeight();
                j = (int)(0.3333333F * i);
                k = (int)(j / f);
                paramAppActivity = (ViewGroup.MarginLayoutParams)localImageView1.getLayoutParams();
                paramAppActivity.width = j;
                paramAppActivity.height = k;
                paramAppActivity.leftMargin = ((i - j) / 2);
                paramAppActivity.bottomMargin = ((int)(j * 2.0F * 28.0F / 256.0F));
                if (paramAppActivity.leftMargin <= 0) {
                  break label2375;
                }
                localImageView1.setLayoutParams(paramAppActivity);
                localImageView1.setVisibility(0);
              }
              catch (Throwable paramAppActivity)
              {
                localImageView1.setVisibility(8);
                QLog.e("SetSplash", 1, "splash_logo", paramAppActivity);
                continue;
              }
              return paramBoolean;
            }
          }
        }
      }
      label1969:
      label1982:
      label2375:
      Object localObject2 = null;
      label2099:
      bool1 = true;
    }
  }
  
  private static SplashADView b(Activity paramActivity, azvi paramazvi, bcow parambcow)
  {
    SplashADView localSplashADView = SplashADView.a(paramazvi, paramActivity);
    localSplashADView.setOnClickListener(new bcrc(paramazvi, parambcow, localSplashADView, paramActivity));
    if (paramazvi.a == 2)
    {
      localSplashADView.setOnErrorListener(new bcrd(parambcow));
      localSplashADView.setOnCompletionListener(new bcre(parambcow));
      localSplashADView.setPresenter(new bcrf((ImageView)paramActivity.findViewById(2131377762), (ImageView)paramActivity.findViewById(2131377765)));
    }
    return localSplashADView;
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
      if ((!this.mDirector.a()) || (!a(localAppActivity, this.mDirector, true)))
      {
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        BaseApplicationImpl.appStartTime = 0L;
        this.mDirector.b = 0L;
      }
      this.a = true;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.SetSplash
 * JD-Core Version:    0.7.0.1
 */