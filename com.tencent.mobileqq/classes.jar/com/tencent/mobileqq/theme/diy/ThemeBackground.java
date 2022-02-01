package com.tencent.mobileqq.theme.diy;

import afrb;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView.ScaleType;
import aozu;
import arlh;
import arli;
import asbf;
import bhrj;
import bkwb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ThemeBackground
{
  public static final int BG_TYPE_AIO = 2;
  public static final int BG_TYPE_CONVERSATION = 1;
  public static final int BG_TYPE_DYNAMIC = 4;
  public static final int BG_TYPE_FRIEND = 3;
  public static final int BG_TYPE_SETTING = 0;
  public static final String DIY_DEFAULT_BG_ID = "100";
  public static final String DIY_UPLOAD_BG_ID = "99";
  public static final int PAGE_INDEX_MSG = 100;
  static final String TAG = "ThemeBackground";
  public static boolean needUpdateThemeForBg;
  public static ThemeBackground.BusinessFlag sAIOBusinessFlag = new ThemeBackground.BusinessFlag("AIO");
  public static ThemeBackground.BusinessFlag sRecentBusinessFlag = new ThemeBackground.BusinessFlag("RECENT");
  public Drawable img;
  public boolean isAnimateBg;
  public boolean isDecodeInDiy;
  public boolean isNeedImg = true;
  public int pageIndex;
  public String path;
  public ImageView.ScaleType scaleType;
  
  public static void applyThemeBg(AppRuntime paramAppRuntime, View paramView, int paramInt1, int paramInt2, String paramString)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeBackground", 2, "applyThemeBg view is null,  animateName:" + paramString + " byType:" + paramInt1);
      }
      return;
    }
    ThreadManager.post(new ThemeBackground.4(paramAppRuntime, paramInt1, paramString, paramInt2, paramView), 8, null, true);
  }
  
  protected static float[] calThemeDrawArea(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    float f3 = 0.0F;
    float f2 = 0.5F;
    float f1;
    switch (paramInt)
    {
    default: 
      if (paramFloat2 / paramFloat1 == 1280.0F / 720.0F)
      {
        paramFloat1 = 1.0F;
        f1 = 0.5F;
        f2 = 1.0F;
      }
      break;
    }
    for (;;)
    {
      return new float[] { f1, (1.0F - paramFloat3 * 1.0F / paramFloat2) * (paramFloat1 - f3) + f3, f2, paramFloat1 };
      if (paramFloat2 / paramFloat1 == 1280.0F / 720.0F)
      {
        paramFloat1 = 1.0F;
        f1 = 0.0F;
      }
      else if (paramFloat2 / paramFloat1 > 1280.0F / 720.0F)
      {
        f1 = (1.0F - paramFloat1 / paramFloat2 / (720.0F / 1280.0F)) * 0.5F;
        paramFloat1 = 1.0F;
      }
      else
      {
        f3 = (1.0F - paramFloat2 / paramFloat1 / (1280.0F / 720.0F)) / 2.0F;
        paramFloat1 = 1.0F - f3;
        f1 = 0.0F;
        continue;
        if (paramFloat2 / paramFloat1 > 1280.0F / 720.0F)
        {
          paramFloat1 = paramFloat1 / paramFloat2 / (720.0F / 1280.0F);
          f1 = 0.5F;
          f2 = 1.0F - (1.0F - paramFloat1) * 0.5F;
          paramFloat1 = 1.0F;
        }
        else
        {
          f3 = (1.0F - paramFloat2 / paramFloat1 / (1280.0F / 720.0F)) / 2.0F;
          paramFloat1 = 1.0F - f3;
          f1 = 0.5F;
          f2 = 1.0F;
        }
      }
    }
  }
  
  public static void clear(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = getSharedPreferences(paramContext, paramString2, 4).edit();
    paramContext.putString(paramString1, "null");
    paramContext.putBoolean(paramString1 + "_from", false);
    paramContext.commit();
  }
  
  public static Drawable getDynamicDrawable(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = new File(paramString);
    } while ((!paramString.exists()) || (!isSupportVideo()));
    return bhrj.a().a(paramString, true, new ThemeBackground.3(paramInt));
  }
  
  public static Drawable getDynamicDrawable(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return getDynamicDrawable(new File(new File(paramString1).getParent(), paramString2).getAbsolutePath(), paramInt);
  }
  
  public static Drawable getGLDrawableDrawable(String paramString, Function0<Drawable> paramFunction0)
  {
    if (!arli.c().f()) {
      return (Drawable)paramFunction0.invoke();
    }
    return bhrj.a().a(new File(paramString), true, paramFunction0);
  }
  
  private static void getImgFromCache(Context paramContext, String paramString1, ThemeBackground paramThemeBackground, SharedPreferences paramSharedPreferences, String paramString2, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if ("theme_bg_message_path_png".equals(paramString1)) {
        BaseApplicationImpl.sImageCache.put(paramString2, paramBitmap);
      }
      paramThemeBackground.path = paramString2;
      if ("theme_bg_setting_path_png".equals(paramString1))
      {
        paramThemeBackground.img = new BitmapDrawable(paramContext.getResources(), paramBitmap);
        return;
      }
      paramContext = new asbf(paramContext.getResources(), paramBitmap);
      paramContext.setGravity(48);
      paramThemeBackground.img = paramContext;
      return;
    }
    paramSharedPreferences = paramSharedPreferences.getString(paramString1 + "_url", null);
    if (!TextUtils.isEmpty(paramSharedPreferences))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeBackground", 2, "getThemeBackground, downloading, bgType=" + paramString1 + ", url=" + paramSharedPreferences + ", path=" + paramString2);
      }
      paramBitmap = new ResData();
      paramBitmap.path = paramString2;
      paramBitmap.url = paramSharedPreferences;
      if (!paramThemeBackground.isDecodeInDiy)
      {
        if (("theme_bg_setting_path_png".equals(paramString1)) || ("theme_bg_setting_path".equals(paramString1))) {
          paramBitmap.loadingType = 1;
        }
      }
      else if (paramThemeBackground.pageIndex == 100) {
        if (paramThemeBackground.pageIndex != 100) {
          break label284;
        }
      }
      label284:
      for (boolean bool = true;; bool = false)
      {
        needUpdateThemeForBg = bool;
        paramThemeBackground.img = DIYThemeUtils.getDIYDrawable(paramContext, paramBitmap, 0, 0, paramThemeBackground.pageIndex, true);
        paramThemeBackground.path = paramString2;
        return;
        paramBitmap.loadingType = 2;
        break;
      }
    }
    QLog.e("ThemeBackground", 2, "getThemeBackground, use to defualt, bgType=" + paramString1 + ", path=" + paramString2);
    paramThemeBackground.path = "null";
  }
  
  public static boolean getMarkOfAioBgFromDiy(Context paramContext, String paramString1, String paramString2)
  {
    String str;
    if ((!TextUtils.isEmpty(paramString1)) && ("theme_bg_aio_path".equals(paramString1)))
    {
      str = afrb.a(paramContext, paramString2, 0).getString("chat_uniform_bg", "null");
      if (!TextUtils.isEmpty(str)) {
        break label43;
      }
    }
    label43:
    do
    {
      return false;
      paramContext = getSharedPreferences(paramContext, paramString2, 0);
      paramString2 = paramContext.getString(paramString1, null);
    } while ((TextUtils.isEmpty(paramString2)) || (!str.equals(paramString2)));
    return paramContext.getBoolean(paramString1 + "_from", false);
  }
  
  private static void getNewBackgroundImage(Context paramContext, String paramString1, ThemeBackground paramThemeBackground, SharedPreferences paramSharedPreferences, String paramString2)
  {
    if (paramThemeBackground.isNeedImg)
    {
      try
      {
        if (BaseApplicationImpl.sImageCache.get(paramString2) == null) {
          break label289;
        }
        localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(paramString2);
        if (localObject1 != null) {
          break label926;
        }
        localObject2 = new File(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeBackground", 2, "getThemeBackground_diy, bgType=" + paramString1 + ", path=" + paramString2 + ", exists=" + ((File)localObject2).exists() + ", isFile=" + ((File)localObject2).isFile());
        }
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
          break label295;
        }
        localObject1 = getStatisticParam(paramContext, paramString1, paramString2);
      }
      catch (OutOfMemoryError paramSharedPreferences)
      {
        Object localObject1;
        try
        {
          Object localObject2 = SharpPUtil.decodeSharpPByFilePath(localFile.getAbsolutePath());
          localObject1 = localObject2;
          if (!QLog.isColorLevel())
          {
            localObject2 = localObject1;
            if (localObject1 != null) {}
          }
          else
          {
            localObject2 = new StringBuilder().append("getThemeBackground, sharpP decode result=");
            if (localObject1 == null) {
              break label481;
            }
          }
          for (bool = true;; bool = false)
          {
            QLog.d("ThemeBackground", 2, bool + ", path=" + paramString2);
            localObject2 = localObject1;
            localObject1 = localObject2;
            break;
          }
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          do
          {
            QLog.e("ThemeBackground", 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + localUnsatisfiedLinkError.getMessage());
            if (QLog.isColorLevel()) {
              break;
            }
            localObject3 = localObject1;
          } while (localObject1 != null);
          localObject3 = new StringBuilder().append("getThemeBackground, sharpP decode result=");
          if (localObject1 != null) {}
          for (bool = true;; bool = false)
          {
            for (;;)
            {
              QLog.d("ThemeBackground", 2, bool + ", path=" + paramString2);
              localObject3 = localObject1;
              break;
              paramSharedPreferences = paramSharedPreferences;
              QLog.e("ThemeBackground", 1, "getThemeBackground OOM a1:" + paramSharedPreferences.getMessage());
              paramThemeBackground.img = null;
              try
              {
                paramSharedPreferences = new HashMap();
                paramSharedPreferences.put("param_FailCode", "OOM");
                paramSharedPreferences.put("param_bgType", paramString1);
                paramSharedPreferences.put("param_themeid", ThemeUtil.getCurrentThemeId());
                StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramSharedPreferences, "", false);
              }
              catch (Exception paramContext) {}
            }
            break;
          }
        }
        finally
        {
          if (QLog.isColorLevel()) {
            break label720;
          }
        }
        if (localObject1 != null) {
          break label770;
        }
        localObject3 = new StringBuilder().append("getThemeBackground, sharpP decode result=");
        if (localObject1 == null) {
          break label883;
        }
        bool = true;
        QLog.d("ThemeBackground", 2, bool + ", path=" + paramString2);
        throw paramSharedPreferences;
      }
      catch (Exception paramSharedPreferences)
      {
        for (;;)
        {
          label220:
          QLog.e("ThemeBackground", 1, "getThemeBackground Err a2:" + paramSharedPreferences.getMessage());
          paramThemeBackground.img = null;
          try
          {
            paramSharedPreferences = new HashMap();
            paramSharedPreferences.put("param_FailCode", "EE");
            paramSharedPreferences.put("param_bgType", paramString1);
            paramSharedPreferences.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramSharedPreferences, "", false);
          }
          catch (Exception paramContext) {}
          continue;
          bool = false;
          continue;
          QLog.e("ThemeBackground", 2, "getThemeBackground, file not exists, bgType=" + paramString1 + ", path=" + paramString2);
          continue;
          bool = false;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getThemeBackground, check ,bgType=").append(paramString1).append(",bg=");
        if (localObject1 != null)
        {
          bool = true;
          QLog.d("ThemeBackground", 2, bool + ", path=" + paramString2);
        }
      }
      else
      {
        getImgFromCache(paramContext, paramString1, paramThemeBackground, paramSharedPreferences, paramString2, (Bitmap)localObject1);
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder().append("getThemeBackground, bgType=").append(paramString1).append(", path2=").append(paramThemeBackground.path).append(", img=");
          if (paramThemeBackground.img != null) {
            break label944;
          }
        }
      }
    }
    label289:
    label295:
    label944:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ThemeBackground", 2, bool);
      return;
      localObject1 = null;
      break;
      File localFile = new File(bkwb.a((File)localObject2));
      if (localFile.exists())
      {
        bool = bkwb.a(paramContext);
        if ((QLog.isColorLevel()) || (!bool)) {
          QLog.d("ThemeBackground", 2, "getThemeBackground, sharpP exists, bgType=" + paramString1 + ", path=" + paramString2 + ", sharpPAv=" + bool);
        }
        localObject2 = localObject1;
        if (!bool) {}
      }
      label481:
      Object localObject3;
      label720:
      label883:
      paramThemeBackground.path = paramString2;
      break label220;
    }
  }
  
  public static SharedPreferences getSharedPreferences(Context paramContext, String paramString, int paramInt)
  {
    int i = 0;
    paramContext = paramContext.getSharedPreferences("theme_background_path_" + paramString, paramInt);
    if (paramContext.getInt("theme_background_version", 0) < 1)
    {
      SharedPreferences.Editor localEditor = paramContext.edit();
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "theme_bg_message_path";
      arrayOfString[1] = "theme_bg_message_path_png";
      arrayOfString[2] = "theme_bg_aio_path";
      arrayOfString[3] = "theme_bg_setting_path";
      arrayOfString[4] = "theme_bg_setting_path_png";
      int j = arrayOfString.length;
      paramInt = i;
      while (paramInt < j)
      {
        String str1 = arrayOfString[paramInt];
        String str2 = paramContext.getString(str1, null);
        if ((str2 != null) && (str2.contains("custom_background/" + paramString + "/"))) {
          localEditor.putString(str1, str2.replace("custom_background/" + paramString + "/", "custom_background/" + aozu.a(paramString) + "/"));
        }
        paramInt += 1;
      }
      localEditor.putInt("theme_background_version", 1).commit();
    }
    return paramContext;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  private static Bitmap getStatisticParam(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 465	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 466	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 7
    //   9: ldc_w 468
    //   12: getstatic 473	android/os/Build:BRAND	Ljava/lang/String;
    //   15: invokevirtual 477	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   18: ifeq +462 -> 480
    //   21: aload 7
    //   23: getstatic 483	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: putfield 486	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   29: aload_2
    //   30: aload 7
    //   32: invokestatic 491	bgyo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbgyp;
    //   35: astore 6
    //   37: aload 6
    //   39: getfield 496	bgyp:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +11 -> 57
    //   49: aload 6
    //   51: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   54: ifeq +443 -> 497
    //   57: new 77	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 500
    //   67: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc_w 265
    //   77: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc_w 502
    //   87: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload 6
    //   92: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   95: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   98: ldc_w 342
    //   101: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: astore 8
    //   106: aload 5
    //   108: ifnull +383 -> 491
    //   111: iconst_1
    //   112: istore 4
    //   114: ldc 27
    //   116: iconst_2
    //   117: aload 8
    //   119: iload 4
    //   121: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   124: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: new 380	java/util/HashMap
    //   133: dup
    //   134: invokespecial 381	java/util/HashMap:<init>	()V
    //   137: astore 8
    //   139: aload 8
    //   141: ldc_w 383
    //   144: new 77	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 504
    //   154: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 6
    //   159: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   162: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 386	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: aload 8
    //   174: ldc_w 388
    //   177: aload_1
    //   178: invokevirtual 386	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   181: pop
    //   182: aload 8
    //   184: ldc_w 390
    //   187: invokestatic 395	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   190: invokevirtual 386	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   193: pop
    //   194: aload_0
    //   195: invokestatic 401	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   198: astore 9
    //   200: getstatic 405	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   203: invokevirtual 409	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   206: checkcast 411	com/tencent/mobileqq/app/QQAppInterface
    //   209: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   212: astore 10
    //   214: aload 5
    //   216: ifnull +369 -> 585
    //   219: iconst_1
    //   220: istore 4
    //   222: aload 9
    //   224: aload 10
    //   226: ldc_w 416
    //   229: iload 4
    //   231: lconst_1
    //   232: lconst_0
    //   233: aload 8
    //   235: ldc_w 418
    //   238: iconst_0
    //   239: invokevirtual 422	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   242: aload 6
    //   244: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   247: iconst_1
    //   248: if_icmpne +371 -> 619
    //   251: iconst_2
    //   252: istore_3
    //   253: iload_3
    //   254: bipush 32
    //   256: if_icmpgt +127 -> 383
    //   259: aload 7
    //   261: iload_3
    //   262: putfield 507	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   265: aload_2
    //   266: aload 7
    //   268: invokestatic 491	bgyo:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbgyp;
    //   271: astore 6
    //   273: aload 6
    //   275: getfield 496	bgyp:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   278: astore 5
    //   280: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifne +8 -> 291
    //   286: aload 5
    //   288: ifnonnull +86 -> 374
    //   291: new 77	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   298: ldc_w 509
    //   301: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_1
    //   305: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: ldc_w 265
    //   311: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: aload_2
    //   315: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc_w 511
    //   321: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: iload_3
    //   325: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: ldc_w 513
    //   331: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: astore 8
    //   336: aload 5
    //   338: ifnull +253 -> 591
    //   341: iconst_1
    //   342: istore 4
    //   344: ldc 27
    //   346: iconst_2
    //   347: aload 8
    //   349: iload 4
    //   351: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   354: ldc_w 515
    //   357: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: aload 6
    //   362: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   365: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   368: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload 6
    //   376: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   379: iconst_1
    //   380: if_icmpeq +217 -> 597
    //   383: new 380	java/util/HashMap
    //   386: dup
    //   387: invokespecial 381	java/util/HashMap:<init>	()V
    //   390: astore_1
    //   391: aload_1
    //   392: ldc_w 383
    //   395: new 77	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 517
    //   405: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: aload 6
    //   410: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   413: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokevirtual 386	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   422: pop
    //   423: aload_1
    //   424: ldc_w 390
    //   427: invokestatic 395	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   430: invokevirtual 386	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   433: pop
    //   434: aload_0
    //   435: invokestatic 401	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   438: astore_0
    //   439: getstatic 405	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   442: invokevirtual 409	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   445: checkcast 411	com/tencent/mobileqq/app/QQAppInterface
    //   448: invokevirtual 414	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   451: astore_2
    //   452: aload 5
    //   454: ifnull +150 -> 604
    //   457: iconst_1
    //   458: istore 4
    //   460: aload_0
    //   461: aload_2
    //   462: ldc_w 416
    //   465: iload 4
    //   467: lconst_1
    //   468: lconst_0
    //   469: aload_1
    //   470: ldc_w 418
    //   473: iconst_0
    //   474: invokevirtual 422	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   477: aload 5
    //   479: areturn
    //   480: aload 7
    //   482: getstatic 520	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   485: putfield 486	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   488: goto -459 -> 29
    //   491: iconst_0
    //   492: istore 4
    //   494: goto -380 -> 114
    //   497: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   500: ifeq -370 -> 130
    //   503: new 77	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   510: ldc_w 522
    //   513: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_1
    //   517: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: ldc_w 265
    //   523: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: aload_2
    //   527: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: ldc_w 502
    //   533: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 6
    //   538: getfield 498	bgyp:jdField_a_of_type_Int	I
    //   541: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   544: ldc_w 342
    //   547: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: astore 8
    //   552: aload 5
    //   554: ifnull +25 -> 579
    //   557: iconst_1
    //   558: istore 4
    //   560: ldc 27
    //   562: iconst_2
    //   563: aload 8
    //   565: iload 4
    //   567: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   570: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   576: goto -446 -> 130
    //   579: iconst_0
    //   580: istore 4
    //   582: goto -22 -> 560
    //   585: iconst_0
    //   586: istore 4
    //   588: goto -366 -> 222
    //   591: iconst_0
    //   592: istore 4
    //   594: goto -250 -> 344
    //   597: iload_3
    //   598: iconst_2
    //   599: imul
    //   600: istore_3
    //   601: goto -348 -> 253
    //   604: iconst_0
    //   605: istore 4
    //   607: goto -147 -> 460
    //   610: astore_0
    //   611: aload 5
    //   613: areturn
    //   614: astore 8
    //   616: goto -374 -> 242
    //   619: aload 5
    //   621: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	622	0	paramContext	Context
    //   0	622	1	paramString1	String
    //   0	622	2	paramString2	String
    //   252	349	3	i	int
    //   112	494	4	bool	boolean
    //   42	578	5	localBitmap	Bitmap
    //   35	502	6	localbgyp	bgyp
    //   7	474	7	localOptions	android.graphics.BitmapFactory.Options
    //   104	460	8	localObject	Object
    //   614	1	8	localException	Exception
    //   198	25	9	localStatisticCollector	StatisticCollector
    //   212	13	10	str	String
    // Exception table:
    //   from	to	target	type
    //   383	452	610	java/lang/Exception
    //   460	477	610	java/lang/Exception
    //   130	214	614	java/lang/Exception
    //   222	242	614	java/lang/Exception
  }
  
  public static boolean getThemeBackground(Context paramContext, String paramString1, String paramString2, ThemeBackground paramThemeBackground)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    if ((paramThemeBackground == null) || (paramString1 == null)) {}
    try
    {
      QLog.d("ThemeBackground", 2, "getThemeBackground, bgType== null");
      bool1 = bool2;
      return bool1;
    }
    finally {}
    paramString2 = getSharedPreferences(paramContext, paramString2, 4);
    String str = paramString2.getString(paramString1, "null");
    if ((str != null) && (str.equals(""))) {
      paramThemeBackground.img = paramContext.getResources().getDrawable(2130838912);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("getThemeBackground, bgType=").append(paramString1).append("path1=").append(str).append(", out.isNeedImg=").append(paramThemeBackground.isNeedImg).append(",out.path=").append(paramThemeBackground.path).append(", img=");
      if (paramThemeBackground.img != null) {
        break label423;
      }
    }
    label417:
    label423:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("ThemeBackground", 2, bool1);
      if ((paramThemeBackground.path == null) || (!paramThemeBackground.path.equals(str)) || (paramThemeBackground.img == null)) {
        if ((TextUtils.isEmpty(str)) || ("null".equals(str)) || ("none".equals(str)))
        {
          paramThemeBackground.path = "null";
          if (QLog.isColorLevel()) {
            QLog.d("ThemeBackground", 2, "getThemeBackground_DEFUALT, bgType=" + paramString1 + ", path=" + str);
          }
        }
      }
      for (;;)
      {
        if ((!paramThemeBackground.isDecodeInDiy) && (paramThemeBackground.img == null) && ("theme_bg_setting_path_png".equals(paramString1)))
        {
          setOldDiyBackground(paramContext, paramThemeBackground);
          break label417;
          getNewBackgroundImage(paramContext, paramString1, paramThemeBackground, paramString2, str);
          continue;
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            break;
          }
          paramContext = new StringBuilder().append("getThemeBackground, bgType=").append(paramString1).append(", path5=").append(paramThemeBackground.path).append(", img=");
          if (paramThemeBackground.img == null) {}
          for (bool1 = bool3;; bool1 = false)
          {
            QLog.i("ThemeBackground", 2, bool1);
            bool1 = bool2;
            break;
          }
        }
      }
      bool1 = true;
      break;
    }
  }
  
  public static boolean getThemeBackgroundEnable()
  {
    return ThemeUtil.getIsDIYTheme(null);
  }
  
  public static String getThemeBackgroundId(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return getSharedPreferences(paramContext, paramString2, 0).getString(paramString1 + "_id", "0");
  }
  
  public static String getThemeBackgroundPathByType(Context paramContext, String paramString1, String paramString2)
  {
    return getSharedPreferences(paramContext, paramString2, 0).getString(paramString1, "null");
  }
  
  public static String getThemeBackgroundUrl(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return getSharedPreferences(paramContext, paramString2, 0).getString(paramString1 + "_url", "");
  }
  
  public static ThemeBackground getThemeBgObj(AppRuntime paramAppRuntime, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    ThemeBackground localThemeBackground = new ThemeBackground();
    if ((paramAppRuntime == null) || (paramContext == null)) {
      QLog.i("ThemeBackground", 2, "getThemeBgObj app,context = null; animateName=" + paramString + ", app=" + paramAppRuntime + ", context=" + paramContext);
    }
    label63:
    boolean bool;
    label296:
    do
    {
      do
      {
        do
        {
          return localThemeBackground;
          if (paramInt1 == 1) {}
          for (bool = true;; bool = false)
          {
            if (bool) {
              sRecentBusinessFlag.setUseStatic();
            }
            if (!ThemeUtil.isNowThemeIsDIY()) {
              break label296;
            }
            switch (paramInt1)
            {
            case 2: 
            default: 
              return localThemeBackground;
            case 0: 
              getThemeBackground(paramContext, "theme_bg_setting_path_png", paramAppRuntime.getAccount(), localThemeBackground);
              if (localThemeBackground.img == null) {
                break label63;
              }
              localThemeBackground.img = new LayerDrawable(new Drawable[] { localThemeBackground.img, paramAppRuntime.getApplication().getApplicationContext().getResources().getDrawable(2130847473) });
              return localThemeBackground;
            }
          }
          getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
          return localThemeBackground;
          getThemeBackground(paramContext, "theme_bg_friend_path_png", paramAppRuntime.getAccount(), localThemeBackground);
        } while (localThemeBackground.img != null);
        getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
        return localThemeBackground;
        getThemeBackground(paramContext, "theme_bg_dynamic_path_png", paramAppRuntime.getAccount(), localThemeBackground);
      } while (localThemeBackground.img != null);
      getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
      return localThemeBackground;
    } while (!ThemeUtil.isNowThemeIsAnimate());
    localThemeBackground.isAnimateBg = true;
    switch (paramInt1)
    {
    case 2: 
    default: 
      return localThemeBackground;
    case 0: 
      localThemeBackground.path = ThemeUtil.getAnimatePathByTag(1);
      str2 = localThemeBackground.path;
      if (ThemeUtil.isHorizontalAnimate()) {}
      for (str1 = "qq_skin_drawer_conversation.mp4";; str1 = "qq_skin_drawer.mp4")
      {
        localThemeBackground.img = getDynamicDrawable(str2, str1, paramInt2);
        if (localThemeBackground.img != null) {
          break;
        }
        localThemeBackground.img = getGLDrawableDrawable(localThemeBackground.path, new ThemeBackground.1(paramContext, paramAppRuntime, localThemeBackground, paramString));
        return localThemeBackground;
      }
    }
    if (bool) {
      sRecentBusinessFlag.setUseVideo();
    }
    localThemeBackground.path = ThemeUtil.getAnimatePathByTag(2);
    String str2 = localThemeBackground.path;
    if (ThemeUtil.isHorizontalAnimate()) {}
    for (String str1 = "qq_skin_drawer_conversation.mp4";; str1 = "qq_skin_conversation.mp4")
    {
      localThemeBackground.img = getDynamicDrawable(str2, str1, paramInt2);
      if (localThemeBackground.img != null) {
        break;
      }
      if (bool) {
        sRecentBusinessFlag.setUseAETC();
      }
      localThemeBackground.img = getGLDrawableDrawable(localThemeBackground.path, new ThemeBackground.2(bool, paramContext, paramAppRuntime, localThemeBackground, paramString));
      return localThemeBackground;
    }
  }
  
  private static void horizontalAnimateInit(int paramInt, ThemeBackground paramThemeBackground, View paramView)
  {
    if ((ThemeUtil.isHorizontalAnimate()) && (bhrj.a(paramThemeBackground.img)))
    {
      paramView.addOnLayoutChangeListener(new ThemeBackground.5(paramInt, paramThemeBackground));
      setThemeDrawArea(paramView, paramInt, paramThemeBackground);
    }
  }
  
  public static boolean isSupportVideo()
  {
    return arli.c().e();
  }
  
  /* Error */
  private static void setOldDiyBackground(Context paramContext, ThemeBackground paramThemeBackground)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: iconst_0
    //   7: istore 5
    //   9: invokestatic 672	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   12: astore 6
    //   14: aload 6
    //   16: ldc_w 674
    //   19: invokevirtual 678	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: aload 6
    //   26: ldc_w 680
    //   29: invokevirtual 678	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 10
    //   34: aload 7
    //   36: astore 6
    //   38: ldc_w 682
    //   41: aload 9
    //   43: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +268 -> 314
    //   49: aload 7
    //   51: astore 6
    //   53: aload 10
    //   55: invokestatic 688	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   58: ldc_w 690
    //   61: invokestatic 688	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   64: if_icmpge +250 -> 314
    //   67: iconst_1
    //   68: istore_3
    //   69: goto +502 -> 571
    //   72: aload 7
    //   74: astore 6
    //   76: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +503 -> 582
    //   82: aload 7
    //   84: astore 6
    //   86: ldc 27
    //   88: iconst_2
    //   89: new 77	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 692
    //   99: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_3
    //   103: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc_w 694
    //   109: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 4
    //   114: invokevirtual 329	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: ldc_w 696
    //   120: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 9
    //   125: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 698
    //   131: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 10
    //   136: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto +437 -> 582
    //   148: aload 7
    //   150: astore 6
    //   152: invokestatic 704	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   155: invokevirtual 707	com/tencent/theme/SkinEngine:getSkinRootPath	()Ljava/lang/String;
    //   158: astore 9
    //   160: aload 7
    //   162: astore 6
    //   164: new 152	java/io/File
    //   167: dup
    //   168: new 77	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   175: aload 9
    //   177: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 709
    //   183: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 153	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 9
    //   194: aload 7
    //   196: astore 6
    //   198: aload 9
    //   200: invokevirtual 156	java/io/File:exists	()Z
    //   203: ifeq +15 -> 218
    //   206: aload 7
    //   208: astore 6
    //   210: aload 9
    //   212: invokevirtual 334	java/io/File:isFile	()Z
    //   215: ifne +238 -> 453
    //   218: aload 7
    //   220: astore 6
    //   222: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +16 -> 241
    //   228: aload 7
    //   230: astore 6
    //   232: ldc 27
    //   234: iconst_2
    //   235: ldc_w 711
    //   238: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload 7
    //   243: astore 6
    //   245: aload_0
    //   246: invokevirtual 242	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   249: invokevirtual 715	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   252: ldc_w 717
    //   255: invokevirtual 723	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   258: astore 7
    //   260: aload 7
    //   262: invokestatic 729	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   265: astore 6
    //   267: aload 6
    //   269: ifnull +96 -> 365
    //   272: aload_1
    //   273: new 236	android/graphics/drawable/BitmapDrawable
    //   276: dup
    //   277: aload_0
    //   278: invokevirtual 242	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   281: aload 6
    //   283: invokespecial 245	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   286: putfield 247	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   289: aload_1
    //   290: ldc_w 731
    //   293: putfield 232	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   296: aload 7
    //   298: invokevirtual 736	java/io/InputStream:close	()V
    //   301: iconst_0
    //   302: ifeq +11 -> 313
    //   305: new 738	java/lang/NullPointerException
    //   308: dup
    //   309: invokespecial 739	java/lang/NullPointerException:<init>	()V
    //   312: athrow
    //   313: return
    //   314: iconst_0
    //   315: istore_3
    //   316: goto +255 -> 571
    //   319: iload 5
    //   321: istore 4
    //   323: aload 7
    //   325: astore 6
    //   327: ldc_w 682
    //   330: aload 9
    //   332: invokevirtual 218	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifne -263 -> 72
    //   338: aload 7
    //   340: astore 6
    //   342: aload 9
    //   344: invokestatic 688	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   347: istore_2
    //   348: iload 5
    //   350: istore 4
    //   352: iload_2
    //   353: sipush 5010
    //   356: if_icmpge -284 -> 72
    //   359: iconst_1
    //   360: istore 4
    //   362: goto -290 -> 72
    //   365: ldc 27
    //   367: iconst_1
    //   368: ldc_w 741
    //   371: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: goto -78 -> 296
    //   377: astore_1
    //   378: aload 7
    //   380: astore_0
    //   381: aload_0
    //   382: astore 6
    //   384: ldc 27
    //   386: iconst_1
    //   387: new 77	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 743
    //   397: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_1
    //   401: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aload_0
    //   414: ifnull -101 -> 313
    //   417: aload_0
    //   418: invokevirtual 736	java/io/InputStream:close	()V
    //   421: return
    //   422: astore_0
    //   423: ldc 27
    //   425: iconst_1
    //   426: new 77	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 745
    //   436: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_0
    //   440: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: return
    //   453: aload 7
    //   455: astore 6
    //   457: invokestatic 75	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +16 -> 476
    //   463: aload 7
    //   465: astore 6
    //   467: ldc 27
    //   469: iconst_2
    //   470: ldc_w 747
    //   473: invokestatic 268	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: goto -175 -> 301
    //   479: astore_0
    //   480: ldc 27
    //   482: iconst_1
    //   483: new 77	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 745
    //   493: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   500: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: return
    //   510: astore_0
    //   511: aload 6
    //   513: ifnull +8 -> 521
    //   516: aload 6
    //   518: invokevirtual 736	java/io/InputStream:close	()V
    //   521: aload_0
    //   522: athrow
    //   523: astore_1
    //   524: ldc 27
    //   526: iconst_1
    //   527: new 77	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 745
    //   537: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: invokevirtual 425	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   544: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 97	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   553: goto -32 -> 521
    //   556: astore_0
    //   557: aload 7
    //   559: astore 6
    //   561: goto -50 -> 511
    //   564: astore_1
    //   565: aload 8
    //   567: astore_0
    //   568: goto -187 -> 381
    //   571: iload_3
    //   572: ifeq -253 -> 319
    //   575: iload 5
    //   577: istore 4
    //   579: goto -507 -> 72
    //   582: iload_3
    //   583: ifne -435 -> 148
    //   586: iload 4
    //   588: ifeq -112 -> 476
    //   591: goto -443 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramContext	Context
    //   0	594	1	paramThemeBackground	ThemeBackground
    //   347	10	2	i	int
    //   68	515	3	bool1	boolean
    //   112	475	4	bool2	boolean
    //   7	569	5	bool3	boolean
    //   12	548	6	localObject1	Object
    //   1	557	7	localInputStream	java.io.InputStream
    //   4	562	8	localObject2	Object
    //   22	321	9	localObject3	Object
    //   32	103	10	str	String
    // Exception table:
    //   from	to	target	type
    //   260	267	377	java/lang/Exception
    //   272	296	377	java/lang/Exception
    //   296	301	377	java/lang/Exception
    //   365	374	377	java/lang/Exception
    //   417	421	422	java/lang/Exception
    //   305	313	479	java/lang/Exception
    //   38	49	510	finally
    //   53	67	510	finally
    //   76	82	510	finally
    //   86	145	510	finally
    //   152	160	510	finally
    //   164	194	510	finally
    //   198	206	510	finally
    //   210	218	510	finally
    //   222	228	510	finally
    //   232	241	510	finally
    //   245	260	510	finally
    //   327	338	510	finally
    //   342	348	510	finally
    //   384	413	510	finally
    //   457	463	510	finally
    //   467	476	510	finally
    //   516	521	523	java/lang/Exception
    //   260	267	556	finally
    //   272	296	556	finally
    //   296	301	556	finally
    //   365	374	556	finally
    //   38	49	564	java/lang/Exception
    //   53	67	564	java/lang/Exception
    //   76	82	564	java/lang/Exception
    //   86	145	564	java/lang/Exception
    //   152	160	564	java/lang/Exception
    //   164	194	564	java/lang/Exception
    //   198	206	564	java/lang/Exception
    //   210	218	564	java/lang/Exception
    //   222	228	564	java/lang/Exception
    //   232	241	564	java/lang/Exception
    //   245	260	564	java/lang/Exception
    //   327	338	564	java/lang/Exception
    //   342	348	564	java/lang/Exception
    //   457	463	564	java/lang/Exception
    //   467	476	564	java/lang/Exception
  }
  
  public static void setThemeBackgroundPic(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeBackground", 2, "setThemeBackgroundPic, bgType=" + paramString1 + ", url=" + paramString4 + ", path=" + paramString3 + ", id=" + paramString5 + ", name=" + paramString6 + ", feetype=" + paramInt + ", isDiy=" + paramBoolean);
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramContext = getSharedPreferences(paramContext, paramString2, 4).edit();
    paramContext.putString(paramString1, paramString3);
    paramContext.putString(paramString1 + "_url", paramString4);
    paramContext.putString(paramString1 + "_id", paramString5);
    paramContext.putBoolean(paramString1 + "_from", paramBoolean);
    if (paramString6 != null) {
      paramContext.putString(paramString1 + "_name", paramString6);
    }
    paramContext.putInt(paramString1 + "_feetype", paramInt);
    if (paramString7 != null) {
      paramContext.putString(paramString1 + "_thum", paramString7);
    }
    paramContext.commit();
  }
  
  protected static void setThemeDrawArea(View paramView, int paramInt, ThemeBackground paramThemeBackground)
  {
    float f1 = paramView.getRootView().getHeight();
    float f2 = paramView.getHeight();
    float f3 = paramView.getWidth();
    if ((f1 == 0.0F) || (f2 == 0.0F) || (f1 < f2)) {
      return;
    }
    paramView = calThemeDrawArea(f3, f1, f2, paramInt);
    bhrj.a().a(paramThemeBackground.img, paramView[0], paramView[1], paramView[2], paramView[3]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground
 * JD-Core Version:    0.7.0.1
 */