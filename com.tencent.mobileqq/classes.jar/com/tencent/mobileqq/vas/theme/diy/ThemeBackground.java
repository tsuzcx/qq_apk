package com.tencent.mobileqq.vas.theme.diy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.android.gldrawable.api.GLDrawableApi;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

public class ThemeBackground
{
  public static ThemeBackground.BusinessFlag a;
  public static ThemeBackground.BusinessFlag b;
  public static boolean c;
  public int a;
  public Drawable a;
  public ImageView.ScaleType a;
  public String a;
  public boolean a;
  public boolean b;
  public boolean d;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground$BusinessFlag = new ThemeBackground.BusinessFlag("AIO");
    jdField_b_of_type_ComTencentMobileqqVasThemeDiyThemeBackground$BusinessFlag = new ThemeBackground.BusinessFlag("RECENT");
  }
  
  public ThemeBackground()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("theme_background_path_");
    ((StringBuilder)localObject1).append(paramString);
    paramContext = paramContext.getSharedPreferences(((StringBuilder)localObject1).toString(), paramInt);
    paramInt = 0;
    if (paramContext.getInt("theme_background_version", 0) < 1)
    {
      localObject1 = paramContext.edit();
      String[] arrayOfString = new String[5];
      arrayOfString[0] = "theme_bg_message_path";
      arrayOfString[1] = "theme_bg_message_path_png";
      arrayOfString[2] = "theme_bg_aio_path";
      arrayOfString[3] = "theme_bg_setting_path";
      arrayOfString[4] = "theme_bg_setting_path_png";
      int i = arrayOfString.length;
      while (paramInt < i)
      {
        String str1 = arrayOfString[paramInt];
        String str2 = paramContext.getString(str1, null);
        if (str2 != null)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("custom_background/");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append("/");
          if (str2.contains(((StringBuilder)localObject2).toString()))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("custom_background/");
            ((StringBuilder)localObject2).append(paramString);
            ((StringBuilder)localObject2).append("/");
            localObject2 = ((StringBuilder)localObject2).toString();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("custom_background/");
            localStringBuilder.append(DiySecureFileHelper.a(paramString));
            localStringBuilder.append("/");
            ((SharedPreferences.Editor)localObject1).putString(str1, str2.replace((CharSequence)localObject2, localStringBuilder.toString()));
          }
        }
        paramInt += 1;
      }
      ((SharedPreferences.Editor)localObject1).putInt("theme_background_version", 1).commit();
    }
    return paramContext;
  }
  
  @Nullable
  private static Bitmap a(Context paramContext, String paramString1, String paramString2)
  {
    Bitmap localBitmap;
    if (GlobalImageCache.a.get(paramString2) != null) {
      localBitmap = (Bitmap)GlobalImageCache.a.get(paramString2);
    } else {
      localBitmap = null;
    }
    Object localObject = localBitmap;
    if (localBitmap == null)
    {
      localObject = new File(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getThemeBackground_diy, bgType=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", path=");
        localStringBuilder.append(paramString2);
        localStringBuilder.append(", exists=");
        localStringBuilder.append(((File)localObject).exists());
        localStringBuilder.append(", isFile=");
        localStringBuilder.append(((File)localObject).isFile());
        QLog.d("ThemeBackground", 2, localStringBuilder.toString());
      }
      if ((((File)localObject).exists()) && (((File)localObject).isFile())) {
        return b(paramContext, paramString1, paramString2);
      }
      localObject = a(paramContext, paramString1, paramString2, localBitmap, (File)localObject);
    }
    return localObject;
  }
  
  /* Error */
  @Nullable
  private static Bitmap a(Context paramContext, String paramString1, String paramString2, Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: new 131	java/io/File
    //   3: dup
    //   4: ldc 169
    //   6: invokestatic 175	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   9: checkcast 169	com/tencent/mobileqq/vas/api/IVasDepTemp
    //   12: aload 4
    //   14: invokeinterface 179 2 0
    //   19: invokespecial 132	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 4
    //   24: aload 4
    //   26: invokevirtual 146	java/io/File:exists	()Z
    //   29: ifeq +341 -> 370
    //   32: ldc 169
    //   34: invokestatic 175	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   37: checkcast 169	com/tencent/mobileqq/vas/api/IVasDepTemp
    //   40: aload_0
    //   41: invokeinterface 183 2 0
    //   46: istore 5
    //   48: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifne +8 -> 59
    //   54: iload 5
    //   56: ifne +61 -> 117
    //   59: new 38	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   66: astore_0
    //   67: aload_0
    //   68: ldc 185
    //   70: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_0
    //   75: aload_1
    //   76: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_0
    //   81: ldc 141
    //   83: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_0
    //   88: aload_2
    //   89: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_0
    //   94: ldc 187
    //   96: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_0
    //   101: iload 5
    //   103: invokevirtual 149	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   106: pop
    //   107: ldc 156
    //   109: iconst_2
    //   110: aload_0
    //   111: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_3
    //   118: astore_1
    //   119: iload 5
    //   121: ifeq +295 -> 416
    //   124: iconst_0
    //   125: istore 6
    //   127: iconst_0
    //   128: istore 5
    //   130: aload 4
    //   132: invokevirtual 190	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: invokestatic 196	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   138: astore_0
    //   139: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifne +9 -> 151
    //   145: aload_0
    //   146: astore_1
    //   147: aload_0
    //   148: ifnonnull +268 -> 416
    //   151: new 38	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   158: astore_3
    //   159: aload_3
    //   160: ldc 198
    //   162: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_0
    //   167: astore 4
    //   169: aload_3
    //   170: astore_1
    //   171: aload_0
    //   172: ifnull +11 -> 183
    //   175: aload_3
    //   176: astore_1
    //   177: iconst_1
    //   178: istore 5
    //   180: aload_0
    //   181: astore 4
    //   183: aload_1
    //   184: iload 5
    //   186: invokevirtual 149	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: ldc 141
    //   193: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: aload_2
    //   199: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: ldc 156
    //   205: iconst_2
    //   206: aload_1
    //   207: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload 4
    //   215: areturn
    //   216: astore_0
    //   217: goto +85 -> 302
    //   220: astore_0
    //   221: new 38	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   228: astore_1
    //   229: aload_1
    //   230: ldc 200
    //   232: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_1
    //   237: aload_0
    //   238: invokevirtual 203	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   241: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: ldc 156
    //   247: iconst_1
    //   248: aload_1
    //   249: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   255: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   258: ifne +9 -> 267
    //   261: aload_3
    //   262: astore_1
    //   263: aload_3
    //   264: ifnonnull +152 -> 416
    //   267: new 38	java/lang/StringBuilder
    //   270: dup
    //   271: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   274: astore 7
    //   276: aload 7
    //   278: ldc 198
    //   280: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_3
    //   285: astore 4
    //   287: aload 7
    //   289: astore_1
    //   290: aload_3
    //   291: ifnull -108 -> 183
    //   294: aload_3
    //   295: astore_0
    //   296: aload 7
    //   298: astore_1
    //   299: goto -122 -> 177
    //   302: invokestatic 137	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifne +7 -> 312
    //   308: aload_3
    //   309: ifnonnull +59 -> 368
    //   312: new 38	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   319: astore_1
    //   320: aload_1
    //   321: ldc 198
    //   323: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: iload 6
    //   329: istore 5
    //   331: aload_3
    //   332: ifnull +6 -> 338
    //   335: iconst_1
    //   336: istore 5
    //   338: aload_1
    //   339: iload 5
    //   341: invokevirtual 149	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_1
    //   346: ldc 141
    //   348: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_1
    //   353: aload_2
    //   354: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: ldc 156
    //   360: iconst_2
    //   361: aload_1
    //   362: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: aload_0
    //   369: athrow
    //   370: new 38	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   377: astore_0
    //   378: aload_0
    //   379: ldc 208
    //   381: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload_0
    //   386: aload_1
    //   387: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_0
    //   392: ldc 141
    //   394: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_0
    //   399: aload_2
    //   400: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: pop
    //   404: ldc 156
    //   406: iconst_2
    //   407: aload_0
    //   408: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   414: aload_3
    //   415: astore_1
    //   416: aload_1
    //   417: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	paramContext	Context
    //   0	418	1	paramString1	String
    //   0	418	2	paramString2	String
    //   0	418	3	paramBitmap	Bitmap
    //   0	418	4	paramFile	File
    //   46	294	5	bool1	boolean
    //   125	203	6	bool2	boolean
    //   274	23	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   130	139	216	finally
    //   221	255	216	finally
    //   130	139	220	java/lang/UnsatisfiedLinkError
  }
  
  public static Drawable a(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = new File(paramString);
    if (paramString.exists())
    {
      if (!b()) {
        return null;
      }
      return GLDrawableApi.asyncFactory(new ThemeBackground.3(paramInt), new ThemeBackground.4(paramString));
    }
    return null;
  }
  
  public static Drawable a(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    return a(new File(new File(paramString1).getParent(), paramString2).getAbsolutePath(), paramInt);
  }
  
  public static Drawable a(String paramString, Function0<Drawable> paramFunction0)
  {
    if (!QVipSDKProcessor.c().i()) {
      return (Drawable)paramFunction0.invoke();
    }
    return GLDrawableApi.asyncFactory(paramFunction0, new ThemeBackground.5(paramString));
  }
  
  public static ThemeBackground a(AppRuntime paramAppRuntime, Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    ThemeBackground localThemeBackground = new ThemeBackground();
    if ((paramAppRuntime != null) && (paramContext != null))
    {
      boolean bool;
      if (paramInt1 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        jdField_b_of_type_ComTencentMobileqqVasThemeDiyThemeBackground$BusinessFlag.a();
      }
      if (ThemeUtil.isNowThemeIsDIY())
      {
        a(paramAppRuntime, paramContext, paramInt1, localThemeBackground);
        return localThemeBackground;
      }
      if (ThemeUtil.isNowThemeIsAnimate()) {
        a(paramAppRuntime, paramContext, paramInt1, paramString, paramInt2, localThemeBackground, bool);
      }
      return localThemeBackground;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getThemeBgObj app,context = null; animateName=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", app=");
    localStringBuilder.append(paramAppRuntime);
    localStringBuilder.append(", context=");
    localStringBuilder.append(paramContext);
    QLog.i("ThemeBackground", 2, localStringBuilder.toString());
    return localThemeBackground;
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramContext = a(paramContext, paramString2, 0);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_id");
    return paramContext.getString(paramString2.toString(), "0");
  }
  
  private static void a(int paramInt, ThemeBackground paramThemeBackground, View paramView)
  {
    if ((ThemeUtil.isHorizontalAnimate()) && ((paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof IGLDrawable)))
    {
      paramView.addOnLayoutChangeListener(new ThemeBackground.7(paramInt, paramThemeBackground));
      a(paramView, paramInt, paramThemeBackground);
    }
  }
  
  /* Error */
  private static void a(Context paramContext, ThemeBackground paramThemeBackground)
  {
    // Byte code:
    //   0: invokestatic 330	com/tencent/mobileqq/vas/theme/api/ThemeUtil:getCurrentThemeInfo	()Landroid/os/Bundle;
    //   3: astore_2
    //   4: aload_2
    //   5: ldc_w 332
    //   8: invokevirtual 336	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore 5
    //   13: aload_2
    //   14: ldc_w 338
    //   17: invokevirtual 336	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   20: astore 6
    //   22: aconst_null
    //   23: astore_3
    //   24: aconst_null
    //   25: astore_2
    //   26: aload_0
    //   27: invokevirtual 342	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   30: invokevirtual 348	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   33: ldc_w 350
    //   36: invokevirtual 356	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   39: astore 4
    //   41: aload 4
    //   43: astore_2
    //   44: aload 4
    //   46: astore_3
    //   47: aload_0
    //   48: aload_1
    //   49: aload 5
    //   51: aload 6
    //   53: aload 4
    //   55: invokestatic 359	com/tencent/mobileqq/vas/theme/diy/ThemeBackground:a	(Landroid/content/Context;Lcom/tencent/mobileqq/vas/theme/diy/ThemeBackground;Ljava/lang/String;Ljava/lang/String;Ljava/io/InputStream;)V
    //   58: aload 4
    //   60: ifnull +115 -> 175
    //   63: aload 4
    //   65: invokevirtual 364	java/io/InputStream:close	()V
    //   68: return
    //   69: astore_0
    //   70: new 38	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   77: astore_1
    //   78: aload_1
    //   79: ldc_w 366
    //   82: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_1
    //   87: aload_0
    //   88: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 156
    //   97: iconst_1
    //   98: aload_1
    //   99: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: return
    //   106: astore_0
    //   107: goto +69 -> 176
    //   110: astore_0
    //   111: aload_3
    //   112: astore_2
    //   113: new 38	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   120: astore_1
    //   121: aload_3
    //   122: astore_2
    //   123: aload_1
    //   124: ldc_w 369
    //   127: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_3
    //   132: astore_2
    //   133: aload_1
    //   134: aload_0
    //   135: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   138: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_3
    //   143: astore_2
    //   144: ldc 156
    //   146: iconst_1
    //   147: aload_1
    //   148: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_3
    //   155: ifnull +20 -> 175
    //   158: aload_3
    //   159: invokevirtual 364	java/io/InputStream:close	()V
    //   162: return
    //   163: astore_0
    //   164: new 38	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   171: astore_1
    //   172: goto -94 -> 78
    //   175: return
    //   176: aload_2
    //   177: ifnull +46 -> 223
    //   180: aload_2
    //   181: invokevirtual 364	java/io/InputStream:close	()V
    //   184: goto +39 -> 223
    //   187: astore_1
    //   188: new 38	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   195: astore_2
    //   196: aload_2
    //   197: ldc_w 366
    //   200: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: aload_2
    //   205: aload_1
    //   206: invokevirtual 367	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   209: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: ldc 156
    //   215: iconst_1
    //   216: aload_2
    //   217: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 206	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: goto +5 -> 228
    //   226: aload_0
    //   227: athrow
    //   228: goto -2 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	paramContext	Context
    //   0	231	1	paramThemeBackground	ThemeBackground
    //   3	214	2	localObject1	Object
    //   23	136	3	localObject2	Object
    //   39	25	4	localInputStream	InputStream
    //   11	39	5	str1	String
    //   20	32	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   63	68	69	java/lang/Exception
    //   26	41	106	finally
    //   47	58	106	finally
    //   113	121	106	finally
    //   123	131	106	finally
    //   133	142	106	finally
    //   144	154	106	finally
    //   26	41	110	java/lang/Exception
    //   47	58	110	java/lang/Exception
    //   158	162	163	java/lang/Exception
    //   180	184	187	java/lang/Exception
  }
  
  private static void a(Context paramContext, ThemeBackground paramThemeBackground, String paramString1, String paramString2, InputStream paramInputStream)
  {
    boolean bool1 = "999".equals(paramString1);
    boolean bool3 = false;
    if ((bool1) && (Integer.parseInt(paramString2) < Integer.parseInt("20000000"))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (bool1)
    {
      bool2 = bool3;
    }
    else
    {
      bool2 = bool3;
      if (!"999".equals(paramString1))
      {
        bool2 = bool3;
        if (Integer.parseInt(paramString1) < 5010) {
          bool2 = true;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getThemeBackground setting old ,oldDefualtDiy=");
    localStringBuilder.append(bool1);
    localStringBuilder.append(",otherOldDiy=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(",id=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",ver=");
    localStringBuilder.append(paramString2);
    QLog.d("ThemeBackground", 2, localStringBuilder.toString());
    if ((bool1) || (bool2))
    {
      paramString1 = SkinEngine.getInstances().getSkinRootPath();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("drawable-xhdpi/qq_setting_me_bg.png");
      paramString1 = new File(paramString2.toString());
      if ((paramString1.exists()) && (paramString1.isFile()))
      {
        QLog.d("ThemeBackground", 2, "getThemeBackground setting old ,already has file");
        return;
      }
      QLog.d("ThemeBackground", 2, "getThemeBackground setting old ,have no file");
      paramString1 = BitmapFactory.decodeStream(paramInputStream);
      if (paramString1 != null)
      {
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramContext.getResources(), paramString1);
        paramThemeBackground.jdField_a_of_type_JavaLangString = "qq_setting_me_bg.png";
        return;
      }
      QLog.e("ThemeBackground", 1, "getThemeBackground setting bitmap null err");
    }
  }
  
  private static void a(Context paramContext, String paramString1, ThemeBackground paramThemeBackground, SharedPreferences paramSharedPreferences, String paramString2)
  {
    boolean bool1 = paramThemeBackground.jdField_a_of_type_Boolean;
    boolean bool2 = true;
    if (bool1) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = a(paramContext, paramString1, paramString2);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getThemeBackground, check ,bgType=");
          localStringBuilder.append(paramString1);
          localStringBuilder.append(",bg=");
          if (localBitmap == null) {
            break label533;
          }
          bool1 = true;
          localStringBuilder.append(bool1);
          localStringBuilder.append(", path=");
          localStringBuilder.append(paramString2);
          QLog.d("ThemeBackground", 2, localStringBuilder.toString());
        }
        try
        {
          a(paramContext, paramString1, paramThemeBackground, paramSharedPreferences, paramString2, localBitmap);
        }
        catch (Exception paramSharedPreferences) {}catch (OutOfMemoryError paramSharedPreferences) {}
        paramString2 = new StringBuilder();
      }
      catch (Exception paramSharedPreferences)
      {
        paramString2 = new StringBuilder();
        paramString2.append("getThemeBackground Err a2:");
        paramString2.append(paramSharedPreferences.getMessage());
        QLog.e("ThemeBackground", 1, paramString2.toString());
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        try
        {
          paramSharedPreferences = new HashMap();
          paramSharedPreferences.put("param_FailCode", "EE");
          paramSharedPreferences.put("param_bgType", paramString1);
          paramSharedPreferences.put("param_themeid", ThemeUtil.getCurrentThemeId());
          StatisticCollector.getInstance(paramContext).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramSharedPreferences, "", false);
        }
        catch (Exception paramContext)
        {
          paramSharedPreferences = new StringBuilder();
          paramSharedPreferences.append("getThemeBackground :");
          paramSharedPreferences.append(paramContext.getMessage());
          QLog.e("ThemeBackground", 1, paramSharedPreferences.toString());
        }
      }
      catch (OutOfMemoryError paramSharedPreferences) {}
      paramString2.append("getThemeBackground OOM a1:");
      paramString2.append(paramSharedPreferences.getMessage());
      QLog.e("ThemeBackground", 1, paramString2.toString());
      paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      try
      {
        paramSharedPreferences = new HashMap();
        paramSharedPreferences.put("param_FailCode", "OOM");
        paramSharedPreferences.put("param_bgType", paramString1);
        paramSharedPreferences.put("param_themeid", ThemeUtil.getCurrentThemeId());
        StatisticCollector.getInstance(paramContext).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "ThemeBackgroundDecoder", false, 1L, 0L, paramSharedPreferences, "", false);
      }
      catch (Exception paramContext)
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("getThemeBackground :");
        paramSharedPreferences.append(paramContext.getMessage());
        QLog.e("ThemeBackground", 1, paramSharedPreferences.toString());
      }
      paramThemeBackground.jdField_a_of_type_JavaLangString = paramString2;
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getThemeBackground, bgType=");
        paramContext.append(paramString1);
        paramContext.append(", path2=");
        paramContext.append(paramThemeBackground.jdField_a_of_type_JavaLangString);
        paramContext.append(", img=");
        if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        paramContext.append(bool1);
        QLog.d("ThemeBackground", 2, paramContext.toString());
      }
      return;
      label533:
      bool1 = false;
    }
  }
  
  private static void a(Context paramContext, String paramString1, ThemeBackground paramThemeBackground, SharedPreferences paramSharedPreferences, String paramString2, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if ("theme_bg_message_path_png".equals(paramString1)) {
        GlobalImageCache.a.put(paramString2, paramBitmap);
      }
      paramThemeBackground.jdField_a_of_type_JavaLangString = paramString2;
      if ("theme_bg_setting_path_png".equals(paramString1))
      {
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(paramContext.getResources(), paramBitmap);
        return;
      }
      paramContext = new ChatBackgroundDrawable(paramContext.getResources(), paramBitmap);
      paramContext.setGravity(48);
      paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
      return;
    }
    paramBitmap = new StringBuilder();
    paramBitmap.append(paramString1);
    paramBitmap.append("_url");
    paramSharedPreferences = paramSharedPreferences.getString(paramBitmap.toString(), null);
    if (!TextUtils.isEmpty(paramSharedPreferences))
    {
      if (QLog.isColorLevel())
      {
        paramBitmap = new StringBuilder();
        paramBitmap.append("getThemeBackground, downloading, bgType=");
        paramBitmap.append(paramString1);
        paramBitmap.append(", url=");
        paramBitmap.append(paramSharedPreferences);
        paramBitmap.append(", path=");
        paramBitmap.append(paramString2);
        QLog.d("ThemeBackground", 2, paramBitmap.toString());
      }
      paramBitmap = new ResData();
      paramBitmap.c = paramString2;
      paramBitmap.d = paramSharedPreferences;
      boolean bool2 = paramThemeBackground.jdField_b_of_type_Boolean;
      boolean bool1 = true;
      if (!bool2) {
        if ((!"theme_bg_setting_path_png".equals(paramString1)) && (!"theme_bg_setting_path".equals(paramString1))) {
          paramBitmap.e = 2;
        } else {
          paramBitmap.e = 1;
        }
      }
      int i = paramThemeBackground.jdField_a_of_type_Int;
      if (i == 100)
      {
        if (i != 100) {
          bool1 = false;
        }
        c = bool1;
      }
      paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DIYThemeUtils.a(paramContext, paramBitmap, 0, 0, paramThemeBackground.jdField_a_of_type_Int, true);
      paramThemeBackground.jdField_a_of_type_JavaLangString = paramString2;
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("getThemeBackground, use to defualt, bgType=");
    paramContext.append(paramString1);
    paramContext.append(", path=");
    paramContext.append(paramString2);
    QLog.e("ThemeBackground", 2, paramContext.toString());
    paramThemeBackground.jdField_a_of_type_JavaLangString = "null";
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return;
    }
    paramContext = a(paramContext, paramString2, 4).edit();
    paramContext.putString(paramString1, "null");
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_from");
    paramContext.putBoolean(paramString2.toString(), false);
    paramContext.commit();
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt, String paramString7, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setThemeBackgroundPic, bgType=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", path=");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", id=");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(", name=");
      localStringBuilder.append(paramString6);
      localStringBuilder.append(", feetype=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", isDiy=");
      localStringBuilder.append(paramBoolean);
      QLog.d("ThemeBackground", 2, localStringBuilder.toString());
    }
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    paramContext = a(paramContext, paramString2, 4).edit();
    paramContext.putString(paramString1, paramString3);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_url");
    paramContext.putString(paramString2.toString(), paramString4);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_id");
    paramContext.putString(paramString2.toString(), paramString5);
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_from");
    paramContext.putBoolean(paramString2.toString(), paramBoolean);
    if (paramString6 != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_name");
      paramContext.putString(paramString2.toString(), paramString6);
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("_feetype");
    paramContext.putInt(paramString2.toString(), paramInt);
    if (paramString7 != null)
    {
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("_thum");
      paramContext.putString(paramString2.toString(), paramString7);
    }
    paramContext.commit();
  }
  
  public static void a(View paramView, int paramInt, ThemeBackground paramThemeBackground)
  {
    float f1 = paramView.getRootView().getHeight();
    float f2 = paramView.getHeight();
    float f3 = paramView.getWidth();
    if ((f1 != 0.0F) && (f2 != 0.0F))
    {
      if (f1 < f2) {
        return;
      }
      paramView = a(f3, f1, f2, paramInt);
      paramThemeBackground = paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((paramThemeBackground instanceof IGLDrawable)) {
        ((IGLDrawable)paramThemeBackground).setDrawArea(paramView[0], paramView[1], paramView[2], paramView[3]);
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, Context paramContext, int paramInt, ThemeBackground paramThemeBackground)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            a(paramContext, "theme_bg_dynamic_path_png", paramAppRuntime.getAccount(), paramThemeBackground);
            if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
              a(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), paramThemeBackground);
            }
          }
          else
          {
            a(paramContext, "theme_bg_friend_path_png", paramAppRuntime.getAccount(), paramThemeBackground);
            if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
              a(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), paramThemeBackground);
            }
          }
        }
      }
      else {
        a(paramContext, "theme_bg_message_path_png", paramAppRuntime.getAccount(), paramThemeBackground);
      }
    }
    else
    {
      a(paramContext, "theme_bg_setting_path_png", paramAppRuntime.getAccount(), paramThemeBackground);
      paramContext = paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramContext != null) {
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new LayerDrawable(new Drawable[] { paramContext, paramAppRuntime.getApplication().getApplicationContext().getResources().getDrawable(2130847697) });
      }
    }
  }
  
  private static void a(AppRuntime paramAppRuntime, Context paramContext, int paramInt1, String paramString, int paramInt2, ThemeBackground paramThemeBackground, boolean paramBoolean)
  {
    paramThemeBackground.d = true;
    String str1 = "qq_skin_drawer_conversation.mp4";
    String str2;
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 3) && (paramInt1 != 4)) {
        return;
      }
      if (paramBoolean) {
        jdField_b_of_type_ComTencentMobileqqVasThemeDiyThemeBackground$BusinessFlag.d();
      }
      paramThemeBackground.jdField_a_of_type_JavaLangString = ThemeUtil.getAnimatePathByTag(2);
      str2 = paramThemeBackground.jdField_a_of_type_JavaLangString;
      if (!ThemeUtil.isHorizontalAnimate()) {
        str1 = "qq_skin_conversation.mp4";
      }
      paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(str2, str1, paramInt2);
      if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null)
      {
        if (paramBoolean) {
          jdField_b_of_type_ComTencentMobileqqVasThemeDiyThemeBackground$BusinessFlag.f();
        }
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramThemeBackground.jdField_a_of_type_JavaLangString, new ThemeBackground.2(paramBoolean, paramContext, paramAppRuntime, paramThemeBackground, paramString));
      }
    }
    else
    {
      paramThemeBackground.jdField_a_of_type_JavaLangString = ThemeUtil.getAnimatePathByTag(1);
      str2 = paramThemeBackground.jdField_a_of_type_JavaLangString;
      if (!ThemeUtil.isHorizontalAnimate()) {
        str1 = "qq_skin_drawer.mp4";
      }
      paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(str2, str1, paramInt2);
      if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = a(paramThemeBackground.jdField_a_of_type_JavaLangString, new ThemeBackground.1(paramContext, paramAppRuntime, paramThemeBackground, paramString));
      }
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, View paramView, int paramInt1, int paramInt2, String paramString)
  {
    if (paramView == null)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("applyThemeBg view is null,  animateName:");
        paramAppRuntime.append(paramString);
        paramAppRuntime.append(" byType:");
        paramAppRuntime.append(paramInt1);
        QLog.e("ThemeBackground", 2, paramAppRuntime.toString());
      }
      return;
    }
    ThreadManager.post(new ThemeBackground.6(paramAppRuntime, paramInt1, paramString, paramInt2, paramView), 8, null, true);
  }
  
  public static boolean a()
  {
    return ThemeUtil.getIsDIYTheme(null);
  }
  
  private static boolean a(Context paramContext, String paramString1, ThemeBackground paramThemeBackground, SharedPreferences paramSharedPreferences, String paramString2)
  {
    String str = paramThemeBackground.jdField_a_of_type_JavaLangString;
    boolean bool = true;
    if ((str != null) && (str.equals(paramString2)) && (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      paramContext = new StringBuilder();
      paramContext.append("getThemeBackground, bgType=");
      paramContext.append(paramString1);
      paramContext.append(", path5=");
      paramContext.append(paramThemeBackground.jdField_a_of_type_JavaLangString);
      paramContext.append(", img=");
      if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        bool = false;
      }
      paramContext.append(bool);
      QLog.i("ThemeBackground", 2, paramContext.toString());
      return false;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (!"null".equals(paramString2)) && (!"none".equals(paramString2)))
    {
      a(paramContext, paramString1, paramThemeBackground, paramSharedPreferences, paramString2);
    }
    else
    {
      paramThemeBackground.jdField_a_of_type_JavaLangString = "null";
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("getThemeBackground_DEFUALT, bgType=");
      paramSharedPreferences.append(paramString1);
      paramSharedPreferences.append(", path=");
      paramSharedPreferences.append(paramString2);
      QLog.d("ThemeBackground", 2, paramSharedPreferences.toString());
    }
    if ((!paramThemeBackground.jdField_b_of_type_Boolean) && (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && ("theme_bg_setting_path_png".equals(paramString1))) {
      a(paramContext, paramThemeBackground);
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && ("theme_bg_aio_path".equals(paramString1)))
    {
      String str = ChatBackgroundUtil.a(paramContext, paramString2, 0).getString("chat_uniform_bg", "null");
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      paramContext = a(paramContext, paramString2, 0);
      paramString2 = paramContext.getString(paramString1, null);
      if (!TextUtils.isEmpty(paramString2))
      {
        if (!str.equals(paramString2)) {
          return false;
        }
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("_from");
        return paramContext.getBoolean(paramString2.toString(), false);
      }
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, ThemeBackground paramThemeBackground)
  {
    boolean bool = false;
    if ((paramThemeBackground != null) && (paramString1 != null)) {}
    try
    {
      paramString2 = a(paramContext, paramString2, 4);
      String str = paramString2.getString(paramString1, "null");
      if ((str != null) && (str.equals(""))) {
        paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130838740);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getThemeBackground, bgType=");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("path1=");
        localStringBuilder.append(str);
        localStringBuilder.append(", out.isNeedImg=");
        localStringBuilder.append(paramThemeBackground.jdField_a_of_type_Boolean);
        localStringBuilder.append(",out.path=");
        localStringBuilder.append(paramThemeBackground.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(", img=");
        if (paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          bool = true;
        }
        localStringBuilder.append(bool);
        QLog.d("ThemeBackground", 2, localStringBuilder.toString());
      }
      bool = a(paramContext, paramString1, paramThemeBackground, paramString2, str);
      return bool;
    }
    finally {}
    QLog.d("ThemeBackground", 2, "getThemeBackground, bgType== null");
    return false;
  }
  
  public static float[] a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    float f4 = 0.0F;
    float f2 = 0.0F;
    float f1 = 0.0F;
    float f3 = 0.5F;
    if (paramInt != 0)
    {
      f4 = paramFloat2 / paramFloat1;
      if (f4 == 1.777778F)
      {
        paramFloat1 = 1.0F;
        f2 = f1;
      }
      for (;;)
      {
        f1 = 1.0F;
        break;
        if (f4 > 1.777778F)
        {
          f1 = 1.0F - (1.0F - paramFloat1 / paramFloat2 / 0.5625F) * 0.5F;
          paramFloat1 = 1.0F;
          break;
        }
        f2 = (1.0F - f4 / 1.777778F) / 2.0F;
        paramFloat1 = 1.0F - f2;
      }
    }
    f1 = paramFloat2 / paramFloat1;
    if (f1 == 1.777778F)
    {
      paramFloat1 = 1.0F;
      f1 = 0.5F;
      f3 = 0.0F;
    }
    else
    {
      if (f1 > 1.777778F)
      {
        f3 = (1.0F - paramFloat1 / paramFloat2 / 0.5625F) * 0.5F;
        paramFloat1 = 1.0F;
        f2 = f4;
      }
      else
      {
        paramFloat1 = (1.0F - f1 / 1.777778F) / 2.0F;
        f3 = 0.0F;
        f2 = paramFloat1;
        paramFloat1 = 1.0F - paramFloat1;
      }
      f1 = 0.5F;
    }
    return new float[] { f3, f2 + (paramFloat1 - f2) * (1.0F - paramFloat3 * 1.0F / paramFloat2), f1, paramFloat1 };
  }
  
  @Nullable
  private static Bitmap b(Context paramContext, String paramString1, String paramString2)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ("vivo".equalsIgnoreCase(Build.BRAND)) {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    } else {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    }
    Object localObject3 = BitmapManager.a(paramString2, localOptions);
    Bitmap localBitmap = ((BitmapManager.BitmapDecodeResult)localObject3).jdField_a_of_type_AndroidGraphicsBitmap;
    Object localObject1;
    boolean bool;
    if ((localBitmap != null) && (((BitmapManager.BitmapDecodeResult)localObject3).jdField_a_of_type_Int == 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getThemeBackground, decodeFileForResult ok bgType=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", path=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", result:");
      ((StringBuilder)localObject1).append(((BitmapManager.BitmapDecodeResult)localObject3).jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(",bg=");
      if (localBitmap != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ThemeBackground", 2, ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getThemeBackground, decodeFileForResult Err0 bgType=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", path=");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append(", result:");
      ((StringBuilder)localObject1).append(((BitmapManager.BitmapDecodeResult)localObject3).jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append(",bg=");
      if (localBitmap != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.e("ThemeBackground", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new HashMap();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("d_");
      ((StringBuilder)localObject4).append(((BitmapManager.BitmapDecodeResult)localObject3).jdField_a_of_type_Int);
      ((HashMap)localObject1).put("param_FailCode", ((StringBuilder)localObject4).toString());
      ((HashMap)localObject1).put("param_bgType", paramString1);
      ((HashMap)localObject1).put("param_themeid", ThemeUtil.getCurrentThemeId());
      localObject4 = StatisticCollector.getInstance(paramContext);
      String str = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
      if (localBitmap == null) {
        break label727;
      }
      bool = true;
      ((StatisticCollector)localObject4).collectPerformance(str, "ThemeBackgroundDecoder", bool, 1L, 0L, (HashMap)localObject1, "", false);
    }
    catch (Exception localException)
    {
      QLog.e("ThemeBackground", 2, localException.getMessage());
    }
    Object localObject2 = localBitmap;
    if (((BitmapManager.BitmapDecodeResult)localObject3).jdField_a_of_type_Int == 1)
    {
      int i = 2;
      localObject2 = localObject3;
      while (i <= 32)
      {
        localOptions.inSampleSize = i;
        localObject2 = BitmapManager.a(paramString2, localOptions);
        localBitmap = ((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
        if (localBitmap == null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getThemeBackground, miniDecode, bgType=");
          ((StringBuilder)localObject3).append(paramString1);
          ((StringBuilder)localObject3).append(", path=");
          ((StringBuilder)localObject3).append(paramString2);
          ((StringBuilder)localObject3).append(",simpleSize=");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(", bg=");
          if (localBitmap != null) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject3).append(bool);
          ((StringBuilder)localObject3).append(", result=");
          ((StringBuilder)localObject3).append(((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int);
          QLog.d("ThemeBackground", 2, ((StringBuilder)localObject3).toString());
        }
        if (((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int != 1) {
          break;
        }
        i *= 2;
      }
    }
    for (;;)
    {
      try
      {
        paramString1 = new HashMap();
        paramString2 = new StringBuilder();
        paramString2.append("dd_");
        paramString2.append(((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int);
        paramString1.put("param_FailCode", paramString2.toString());
        paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
        paramContext = StatisticCollector.getInstance(paramContext);
        paramString2 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        if (localBitmap == null) {
          break label733;
        }
        bool = true;
        paramContext.collectPerformance(paramString2, "ThemeBackgroundDecoder", bool, 1L, 0L, paramString1, "", false);
        return localBitmap;
      }
      catch (Exception paramContext)
      {
        QLog.e("ThemeBackground", 2, paramContext.getMessage());
        localObject2 = localBitmap;
      }
      return localObject2;
      label727:
      bool = false;
      break;
      label733:
      bool = false;
    }
  }
  
  private static void b(View paramView, ThemeBackground paramThemeBackground, int paramInt1, int paramInt2)
  {
    paramView.setTag(paramThemeBackground);
    if ((paramView instanceof ImageView))
    {
      ImageView localImageView = (ImageView)paramView;
      localImageView.setImageDrawable(paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      if ((ThemeUtil.isHorizontalAnimate()) && ((paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable instanceof IGLDrawable)))
      {
        paramThemeBackground.jdField_a_of_type_AndroidWidgetImageView$ScaleType = localImageView.getScaleType();
        localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
      }
    }
    else if (!((IVasDepTemp)QRoute.api(IVasDepTemp.class)).setContentBackground(paramView, paramInt1))
    {
      if ((paramView instanceof FPSSwipListView)) {
        ((FPSSwipListView)paramView).setContentBackground(paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      } else {
        paramView.setBackgroundDrawable(paramThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
    a(paramInt2, paramThemeBackground, paramView);
  }
  
  public static boolean b()
  {
    return QVipSDKProcessor.c().h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.diy.ThemeBackground
 * JD-Core Version:    0.7.0.1
 */