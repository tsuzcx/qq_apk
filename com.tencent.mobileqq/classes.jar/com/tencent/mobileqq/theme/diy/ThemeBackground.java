package com.tencent.mobileqq.theme.diy;

import afxa;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView.ScaleType;
import aopp;
import aqyi;
import aqyj;
import arni;
import bctj;
import bhbt;
import bkdi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.util.HashMap;
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
    ThreadManager.post(new ThemeBackground.2(paramAppRuntime, paramInt1, paramString, paramInt2, paramView), 8, null, true);
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
    return bhbt.a().a(paramString, true, new ThemeBackground.1(paramInt));
  }
  
  public static Drawable getDynamicDrawable(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return getDynamicDrawable(new File(new File(paramString1).getParent(), paramString2).getAbsolutePath(), paramInt);
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
      paramContext = new arni(paramContext.getResources(), paramBitmap);
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
          break label280;
        }
      }
      label280:
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
      str = afxa.a(paramContext, paramString2, 0).getString("chat_uniform_bg", "null");
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
          break label287;
        }
        localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(paramString2);
        if (localObject1 != null) {
          break label919;
        }
        localObject2 = new File(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeBackground", 2, "getThemeBackground_diy, bgType=" + paramString1 + ", path=" + paramString2 + ", exists=" + ((File)localObject2).exists() + ", isFile=" + ((File)localObject2).isFile());
        }
        if ((!((File)localObject2).exists()) || (!((File)localObject2).isFile())) {
          break label293;
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
              break label477;
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
                bctj.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramSharedPreferences, "", false);
              }
              catch (Exception paramContext) {}
            }
            break;
          }
        }
        finally
        {
          if (QLog.isColorLevel()) {
            break label715;
          }
        }
        if (localObject1 != null) {
          break label764;
        }
        localObject3 = new StringBuilder().append("getThemeBackground, sharpP decode result=");
        if (localObject1 == null) {
          break label877;
        }
        bool = true;
        QLog.d("ThemeBackground", 2, bool + ", path=" + paramString2);
        throw paramSharedPreferences;
      }
      catch (Exception paramSharedPreferences)
      {
        for (;;)
        {
          label218:
          QLog.e("ThemeBackground", 1, "getThemeBackground Err a2:" + paramSharedPreferences.getMessage());
          paramThemeBackground.img = null;
          try
          {
            paramSharedPreferences = new HashMap();
            paramSharedPreferences.put("param_FailCode", "EE");
            paramSharedPreferences.put("param_bgType", paramString1);
            paramSharedPreferences.put("param_themeid", ThemeUtil.getCurrentThemeId());
            bctj.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramSharedPreferences, "", false);
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
            break label937;
          }
        }
      }
    }
    label287:
    label293:
    label937:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ThemeBackground", 2, bool);
      return;
      localObject1 = null;
      break;
      File localFile = new File(bkdi.a((File)localObject2));
      if (localFile.exists())
      {
        bool = bkdi.a(paramContext);
        if ((QLog.isColorLevel()) || (!bool)) {
          QLog.d("ThemeBackground", 2, "getThemeBackground, sharpP exists, bgType=" + paramString1 + ", path=" + paramString2 + ", sharpPAv=" + bool);
        }
        localObject2 = localObject1;
        if (!bool) {}
      }
      label477:
      Object localObject3;
      label715:
      label764:
      paramThemeBackground.path = paramString2;
      label877:
      break label218;
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
          localEditor.putString(str1, str2.replace("custom_background/" + paramString + "/", "custom_background/" + aopp.a(paramString) + "/"));
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
    //   0: new 425	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 426	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 7
    //   9: ldc_w 428
    //   12: getstatic 433	android/os/Build:BRAND	Ljava/lang/String;
    //   15: invokevirtual 437	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   18: ifeq +460 -> 478
    //   21: aload 7
    //   23: getstatic 443	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   26: putfield 446	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   29: aload_2
    //   30: aload 7
    //   32: invokestatic 451	bggl:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbggm;
    //   35: astore 6
    //   37: aload 6
    //   39: getfield 456	bggm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   42: astore 5
    //   44: aload 5
    //   46: ifnull +11 -> 57
    //   49: aload 6
    //   51: getfield 458	bggm:jdField_a_of_type_Int	I
    //   54: ifeq +441 -> 495
    //   57: new 65	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   64: ldc_w 460
    //   67: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: ldc 227
    //   76: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_2
    //   80: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 462
    //   86: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 6
    //   91: getfield 458	bggm:jdField_a_of_type_Int	I
    //   94: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   97: ldc_w 304
    //   100: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: astore 8
    //   105: aload 5
    //   107: ifnull +382 -> 489
    //   110: iconst_1
    //   111: istore 4
    //   113: ldc 27
    //   115: iconst_2
    //   116: aload 8
    //   118: iload 4
    //   120: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   129: new 342	java/util/HashMap
    //   132: dup
    //   133: invokespecial 343	java/util/HashMap:<init>	()V
    //   136: astore 8
    //   138: aload 8
    //   140: ldc_w 345
    //   143: new 65	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 464
    //   153: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload 6
    //   158: getfield 458	bggm:jdField_a_of_type_Int	I
    //   161: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: aload 8
    //   173: ldc_w 350
    //   176: aload_1
    //   177: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: aload 8
    //   183: ldc_w 352
    //   186: invokestatic 357	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   189: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   192: pop
    //   193: aload_0
    //   194: invokestatic 362	bctj:a	(Landroid/content/Context;)Lbctj;
    //   197: astore 9
    //   199: getstatic 366	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   202: invokevirtual 370	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   205: checkcast 372	com/tencent/mobileqq/app/QQAppInterface
    //   208: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   211: astore 10
    //   213: aload 5
    //   215: ifnull +367 -> 582
    //   218: iconst_1
    //   219: istore 4
    //   221: aload 9
    //   223: aload 10
    //   225: ldc_w 377
    //   228: iload 4
    //   230: lconst_1
    //   231: lconst_0
    //   232: aload 8
    //   234: ldc_w 379
    //   237: iconst_0
    //   238: invokevirtual 382	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   241: aload 6
    //   243: getfield 458	bggm:jdField_a_of_type_Int	I
    //   246: iconst_1
    //   247: if_icmpne +369 -> 616
    //   250: iconst_2
    //   251: istore_3
    //   252: iload_3
    //   253: bipush 32
    //   255: if_icmpgt +126 -> 381
    //   258: aload 7
    //   260: iload_3
    //   261: putfield 467	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   264: aload_2
    //   265: aload 7
    //   267: invokestatic 451	bggl:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lbggm;
    //   270: astore 6
    //   272: aload 6
    //   274: getfield 456	bggm:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   277: astore 5
    //   279: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   282: ifne +8 -> 290
    //   285: aload 5
    //   287: ifnonnull +85 -> 372
    //   290: new 65	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 469
    //   300: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_1
    //   304: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc 227
    //   309: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_2
    //   313: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 471
    //   319: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: iload_3
    //   323: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   326: ldc_w 473
    //   329: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: astore 8
    //   334: aload 5
    //   336: ifnull +252 -> 588
    //   339: iconst_1
    //   340: istore 4
    //   342: ldc 27
    //   344: iconst_2
    //   345: aload 8
    //   347: iload 4
    //   349: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   352: ldc_w 475
    //   355: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 6
    //   360: getfield 458	bggm:jdField_a_of_type_Int	I
    //   363: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload 6
    //   374: getfield 458	bggm:jdField_a_of_type_Int	I
    //   377: iconst_1
    //   378: if_icmpeq +216 -> 594
    //   381: new 342	java/util/HashMap
    //   384: dup
    //   385: invokespecial 343	java/util/HashMap:<init>	()V
    //   388: astore_1
    //   389: aload_1
    //   390: ldc_w 345
    //   393: new 65	java/lang/StringBuilder
    //   396: dup
    //   397: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   400: ldc_w 477
    //   403: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 6
    //   408: getfield 458	bggm:jdField_a_of_type_Int	I
    //   411: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   420: pop
    //   421: aload_1
    //   422: ldc_w 352
    //   425: invokestatic 357	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   428: invokevirtual 348	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   431: pop
    //   432: aload_0
    //   433: invokestatic 362	bctj:a	(Landroid/content/Context;)Lbctj;
    //   436: astore_0
    //   437: getstatic 366	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   440: invokevirtual 370	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   443: checkcast 372	com/tencent/mobileqq/app/QQAppInterface
    //   446: invokevirtual 375	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   449: astore_2
    //   450: aload 5
    //   452: ifnull +149 -> 601
    //   455: iconst_1
    //   456: istore 4
    //   458: aload_0
    //   459: aload_2
    //   460: ldc_w 377
    //   463: iload 4
    //   465: lconst_1
    //   466: lconst_0
    //   467: aload_1
    //   468: ldc_w 379
    //   471: iconst_0
    //   472: invokevirtual 382	bctj:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   475: aload 5
    //   477: areturn
    //   478: aload 7
    //   480: getstatic 480	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   483: putfield 446	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   486: goto -457 -> 29
    //   489: iconst_0
    //   490: istore 4
    //   492: goto -379 -> 113
    //   495: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   498: ifeq -369 -> 129
    //   501: new 65	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 482
    //   511: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_1
    //   515: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc 227
    //   520: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: aload_2
    //   524: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 462
    //   530: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload 6
    //   535: getfield 458	bggm:jdField_a_of_type_Int	I
    //   538: invokevirtual 77	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   541: ldc_w 304
    //   544: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: astore 8
    //   549: aload 5
    //   551: ifnull +25 -> 576
    //   554: iconst_1
    //   555: istore 4
    //   557: ldc 27
    //   559: iconst_2
    //   560: aload 8
    //   562: iload 4
    //   564: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: goto -444 -> 129
    //   576: iconst_0
    //   577: istore 4
    //   579: goto -22 -> 557
    //   582: iconst_0
    //   583: istore 4
    //   585: goto -364 -> 221
    //   588: iconst_0
    //   589: istore 4
    //   591: goto -249 -> 342
    //   594: iload_3
    //   595: iconst_2
    //   596: imul
    //   597: istore_3
    //   598: goto -346 -> 252
    //   601: iconst_0
    //   602: istore 4
    //   604: goto -146 -> 458
    //   607: astore_0
    //   608: aload 5
    //   610: areturn
    //   611: astore 8
    //   613: goto -372 -> 241
    //   616: aload 5
    //   618: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	paramContext	Context
    //   0	619	1	paramString1	String
    //   0	619	2	paramString2	String
    //   251	347	3	i	int
    //   111	492	4	bool	boolean
    //   42	575	5	localBitmap	Bitmap
    //   35	499	6	localbggm	bggm
    //   7	472	7	localOptions	android.graphics.BitmapFactory.Options
    //   103	458	8	localObject	Object
    //   611	1	8	localException	Exception
    //   197	25	9	localbctj	bctj
    //   211	13	10	str	String
    // Exception table:
    //   from	to	target	type
    //   381	450	607	java/lang/Exception
    //   458	475	607	java/lang/Exception
    //   129	213	611	java/lang/Exception
    //   221	241	611	java/lang/Exception
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
      paramThemeBackground.img = paramContext.getResources().getDrawable(2130838759);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("getThemeBackground, bgType=").append(paramString1).append("path1=").append(str).append(", out.isNeedImg=").append(paramThemeBackground.isNeedImg).append(",out.path=").append(paramThemeBackground.path).append(", img=");
      if (paramThemeBackground.img != null) {
        break label422;
      }
    }
    label416:
    label422:
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
          break label416;
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
    if ((paramAppRuntime == null) || (paramContext == null))
    {
      QLog.i("ThemeBackground", 2, "getThemeBgObj app,context = null; animateName=" + paramString + ", app=" + paramAppRuntime + ", context=" + paramContext);
      return localThemeBackground;
    }
    if (ThemeUtil.isNowThemeIsDIY()) {
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      return localThemeBackground;
      getThemeBackground(paramContext, "theme_bg_setting_path_png", paramAppRuntime.getAccount(), localThemeBackground);
      if (localThemeBackground.img != null)
      {
        localThemeBackground.img = new LayerDrawable(new Drawable[] { localThemeBackground.img, paramAppRuntime.getApplication().getApplicationContext().getResources().getDrawable(2130847459) });
        continue;
        getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
        continue;
        getThemeBackground(paramContext, "theme_bg_friend_path_png", paramAppRuntime.getAccount(), localThemeBackground);
        if (localThemeBackground.img == null)
        {
          getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
          continue;
          getThemeBackground(paramContext, "theme_bg_dynamic_path_png", paramAppRuntime.getAccount(), localThemeBackground);
          if (localThemeBackground.img == null)
          {
            getThemeBackground(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), localThemeBackground);
            continue;
            if (ThemeUtil.isNowThemeIsAnimate())
            {
              localThemeBackground.isAnimateBg = true;
              switch (paramInt1)
              {
              }
            }
          }
        }
      }
    }
    localThemeBackground.path = ThemeUtil.getAnimatePathByTag(1);
    Object localObject = localThemeBackground.path;
    if (ThemeUtil.isHorizontalAnimate()) {}
    for (String str1 = "qq_skin_drawer_conversation.mp4";; str1 = "qq_skin_drawer.mp4")
    {
      localThemeBackground.img = getDynamicDrawable((String)localObject, str1, paramInt2);
      if (localThemeBackground.img != null) {
        break;
      }
      paramContext = paramContext.getResources().getDrawable(2130846048);
      localThemeBackground.img = VasApngUtil.getApngDrawable(paramAppRuntime, localThemeBackground.path, "-setting-", paramContext, new int[] { 1 }, paramString, null);
      break;
    }
    localObject = new Bundle();
    ((Bundle)localObject).putBoolean("key_use_rect", true);
    localThemeBackground.path = ThemeUtil.getAnimatePathByTag(2);
    String str2 = localThemeBackground.path;
    if (ThemeUtil.isHorizontalAnimate()) {}
    for (str1 = "qq_skin_drawer_conversation.mp4";; str1 = "qq_skin_conversation.mp4")
    {
      localThemeBackground.img = getDynamicDrawable(str2, str1, paramInt2);
      if (localThemeBackground.img != null) {
        break;
      }
      paramContext = paramContext.getResources().getDrawable(2130838759);
      localThemeBackground.img = VasApngUtil.getApngDrawable(paramAppRuntime, localThemeBackground.path, "-conversation-", paramContext, VasApngUtil.converstionTag, paramString, (Bundle)localObject);
      break;
    }
  }
  
  private static void horizontalAnimateInit(int paramInt, ThemeBackground paramThemeBackground, View paramView)
  {
    if ((ThemeUtil.isHorizontalAnimate()) && (bhbt.a(paramThemeBackground.img)))
    {
      paramView.addOnLayoutChangeListener(new ThemeBackground.3(paramInt, paramThemeBackground));
      setThemeDrawArea(paramView, paramInt, paramThemeBackground);
    }
  }
  
  public static boolean isSupportVideo()
  {
    return aqyj.c().e();
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
    //   9: invokestatic 640	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   12: astore 6
    //   14: aload 6
    //   16: ldc_w 642
    //   19: invokevirtual 644	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   22: astore 9
    //   24: aload 6
    //   26: ldc_w 646
    //   29: invokevirtual 644	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   32: astore 10
    //   34: aload 7
    //   36: astore 6
    //   38: ldc_w 648
    //   41: aload 9
    //   43: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +268 -> 314
    //   49: aload 7
    //   51: astore 6
    //   53: aload 10
    //   55: invokestatic 654	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   58: ldc_w 656
    //   61: invokestatic 654	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   64: if_icmpge +250 -> 314
    //   67: iconst_1
    //   68: istore_3
    //   69: goto +502 -> 571
    //   72: aload 7
    //   74: astore 6
    //   76: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   79: ifeq +503 -> 582
    //   82: aload 7
    //   84: astore 6
    //   86: ldc 27
    //   88: iconst_2
    //   89: new 65	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   96: ldc_w 658
    //   99: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: iload_3
    //   103: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: ldc_w 660
    //   109: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: iload 4
    //   114: invokevirtual 291	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   117: ldc_w 662
    //   120: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 9
    //   125: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc_w 664
    //   131: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 10
    //   136: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   145: goto +437 -> 582
    //   148: aload 7
    //   150: astore 6
    //   152: invokestatic 670	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   155: invokevirtual 673	com/tencent/theme/SkinEngine:getSkinRootPath	()Ljava/lang/String;
    //   158: astore 9
    //   160: aload 7
    //   162: astore 6
    //   164: new 135	java/io/File
    //   167: dup
    //   168: new 65	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   175: aload 9
    //   177: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc_w 675
    //   183: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: invokespecial 138	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: astore 9
    //   194: aload 7
    //   196: astore 6
    //   198: aload 9
    //   200: invokevirtual 141	java/io/File:exists	()Z
    //   203: ifeq +15 -> 218
    //   206: aload 7
    //   208: astore 6
    //   210: aload 9
    //   212: invokevirtual 296	java/io/File:isFile	()Z
    //   215: ifne +238 -> 453
    //   218: aload 7
    //   220: astore 6
    //   222: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +16 -> 241
    //   228: aload 7
    //   230: astore 6
    //   232: ldc 27
    //   234: iconst_2
    //   235: ldc_w 677
    //   238: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: aload 7
    //   243: astore 6
    //   245: aload_0
    //   246: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   249: invokevirtual 681	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   252: ldc_w 683
    //   255: invokevirtual 689	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   258: astore 7
    //   260: aload 7
    //   262: invokestatic 695	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   265: astore 6
    //   267: aload 6
    //   269: ifnull +96 -> 365
    //   272: aload_1
    //   273: new 198	android/graphics/drawable/BitmapDrawable
    //   276: dup
    //   277: aload_0
    //   278: invokevirtual 204	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   281: aload 6
    //   283: invokespecial 207	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   286: putfield 209	com/tencent/mobileqq/theme/diy/ThemeBackground:img	Landroid/graphics/drawable/Drawable;
    //   289: aload_1
    //   290: ldc_w 697
    //   293: putfield 194	com/tencent/mobileqq/theme/diy/ThemeBackground:path	Ljava/lang/String;
    //   296: aload 7
    //   298: invokevirtual 702	java/io/InputStream:close	()V
    //   301: iconst_0
    //   302: ifeq +11 -> 313
    //   305: new 704	java/lang/NullPointerException
    //   308: dup
    //   309: invokespecial 705	java/lang/NullPointerException:<init>	()V
    //   312: athrow
    //   313: return
    //   314: iconst_0
    //   315: istore_3
    //   316: goto +255 -> 571
    //   319: iload 5
    //   321: istore 4
    //   323: aload 7
    //   325: astore 6
    //   327: ldc_w 648
    //   330: aload 9
    //   332: invokevirtual 180	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   335: ifne -263 -> 72
    //   338: aload 7
    //   340: astore 6
    //   342: aload 9
    //   344: invokestatic 654	java/lang/Integer:parseInt	(Ljava/lang/String;)I
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
    //   368: ldc_w 707
    //   371: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: goto -78 -> 296
    //   377: astore_1
    //   378: aload 7
    //   380: astore_0
    //   381: aload_0
    //   382: astore 6
    //   384: ldc 27
    //   386: iconst_1
    //   387: new 65	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   394: ldc_w 709
    //   397: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   400: aload_1
    //   401: invokevirtual 385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   404: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aload_0
    //   414: ifnull -101 -> 313
    //   417: aload_0
    //   418: invokevirtual 702	java/io/InputStream:close	()V
    //   421: return
    //   422: astore_0
    //   423: ldc 27
    //   425: iconst_1
    //   426: new 65	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   433: ldc_w 711
    //   436: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_0
    //   440: invokevirtual 385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   443: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   452: return
    //   453: aload 7
    //   455: astore 6
    //   457: invokestatic 63	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +16 -> 476
    //   463: aload 7
    //   465: astore 6
    //   467: ldc 27
    //   469: iconst_2
    //   470: ldc_w 713
    //   473: invokestatic 230	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   476: goto -175 -> 301
    //   479: astore_0
    //   480: ldc 27
    //   482: iconst_1
    //   483: new 65	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 711
    //   493: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_0
    //   497: invokevirtual 385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   500: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: return
    //   510: astore_0
    //   511: aload 6
    //   513: ifnull +8 -> 521
    //   516: aload 6
    //   518: invokevirtual 702	java/io/InputStream:close	()V
    //   521: aload_0
    //   522: athrow
    //   523: astore_1
    //   524: ldc 27
    //   526: iconst_1
    //   527: new 65	java/lang/StringBuilder
    //   530: dup
    //   531: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   534: ldc_w 711
    //   537: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: invokevirtual 385	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   544: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: invokevirtual 81	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 85	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  private static void setThemeDrawArea(View paramView, int paramInt, ThemeBackground paramThemeBackground)
  {
    float f4 = 0.5F;
    float f3 = 0.0F;
    float f1 = paramView.getRootView().getHeight();
    float f2 = paramView.getHeight();
    float f5 = paramView.getWidth();
    if ((f1 == 0.0F) || (f2 == 0.0F) || (f1 < f2)) {
      return;
    }
    switch (paramInt)
    {
    default: 
      if (f1 / f5 == 1280.0F / 720.0F)
      {
        f2 = 1.0F;
        f1 = 0.0F;
        f3 = 0.5F;
        f4 = 1.0F;
      }
      break;
    }
    for (;;)
    {
      f5 = paramView.getHeight() * 1.0F / paramView.getRootView().getHeight();
      bhbt.a().a(paramThemeBackground.img, f3, (f2 - f1) * (1.0F - f5), f4, f2);
      return;
      if (f1 / f5 == 1280.0F / 720.0F)
      {
        f2 = 1.0F;
        f1 = 0.0F;
      }
      else if (f1 / f5 > 1280.0F / 720.0F)
      {
        f1 = f5 / f1 / (720.0F / 1280.0F);
        f2 = 1.0F;
        f3 = (1.0F - f1) * 0.5F;
        f1 = 0.0F;
      }
      else
      {
        f1 = (1.0F - f1 / f5 / (1280.0F / 720.0F)) / 2.0F;
        f2 = 1.0F - f1;
        continue;
        if (f1 / f5 > 1280.0F / 720.0F)
        {
          f4 = f5 / f1 / (720.0F / 1280.0F);
          f2 = 1.0F;
          f1 = 0.0F;
          f3 = 0.5F;
          f4 = 1.0F - (1.0F - f4) * 0.5F;
        }
        else
        {
          f1 = (1.0F - f1 / f5 / (1280.0F / 720.0F)) / 2.0F;
          f2 = 1.0F - f1;
          f3 = 0.5F;
          f4 = 1.0F;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeBackground
 * JD-Core Version:    0.7.0.1
 */