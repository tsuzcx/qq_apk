package com.tencent.mobileqq.kandian.base.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.image.ImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;

public class ReadInJoyDisplayUtils
{
  private static final Rect a = new Rect();
  
  public static float a(View paramView)
  {
    try
    {
      paramView.getLocalVisibleRect(a);
      int j = paramView.getHeight();
      int i = a.top;
      float f2 = 100.0F;
      float f1;
      if ((i == 0) && (a.bottom == j))
      {
        f1 = f2;
      }
      else
      {
        if (a.top > 0) {}
        for (i = j - a.top;; i = a.bottom)
        {
          f1 = i * 100.0F / j;
          break;
          f1 = f2;
          if (a.bottom <= 0) {
            break;
          }
          f1 = f2;
          if (a.bottom >= j) {
            break;
          }
        }
      }
      return f1;
    }
    finally {}
    for (;;)
    {
      throw paramView;
    }
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    return 1;
  }
  
  public static int a(int paramInt, Resources paramResources)
  {
    return (paramInt - (AIOUtils.b(24.0F, paramResources) + AIOUtils.b(3.0F, paramResources))) / 2;
  }
  
  public static String a(int paramInt)
  {
    int k = paramInt / 3600;
    int j = paramInt / 60;
    int i = j;
    if (k > 0) {
      i = j - k * 60;
    }
    paramInt %= 60;
    String str1;
    if (i >= 10) {
      str1 = String.valueOf(i);
    } else {
      str1 = String.format("0%d", new Object[] { Integer.valueOf(i) });
    }
    String str2;
    if (paramInt >= 10) {
      str2 = String.valueOf(paramInt);
    } else {
      str2 = String.format("0%d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (k > 0)
    {
      String str3;
      if (k >= 10) {
        str3 = String.valueOf(k);
      } else {
        str3 = String.format("0%d", new Object[] { Integer.valueOf(k) });
      }
      return String.format("%s:%s:%s", new Object[] { str3, str1, str2 });
    }
    return String.format("%s:%s", new Object[] { str1, str2 });
  }
  
  public static String a(int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramInt <= 0)) {
      return "";
    }
    return a(paramInt);
  }
  
  public static String a(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (!com.tencent.mobileqq.text.TextUtils.hasSysEmotion(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int i = 0;
    while (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
    {
      String str = EmotcationConstants.SYS_EMOTICON_SYMBOL[i];
      int j = -1;
      for (;;)
      {
        int k = paramString.indexOf(str, j + 1);
        if (k == -1) {
          break;
        }
        j = k;
        if (k != 0)
        {
          j = k;
          if (paramString.codePointAt(k - 1) == 20)
          {
            char c = (char)i;
            paramString.replace(k, str.length() + k, String.valueOf(c));
            j = k;
          }
        }
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  public static String a(String paramString, int paramInt)
  {
    Object localObject = paramString;
    if (paramString.length() > paramInt)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, paramInt - 1));
      ((StringBuilder)localObject).append("…");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static void a()
  {
    try
    {
      if (BaseApplicationImpl.sProcessId == 1)
      {
        GlobalImageCache.a.evict(0);
        return;
      }
      GlobalImageCache.a.evictAll();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[clearMemoryCache] e = ");
      localStringBuilder.append(localException);
      QLog.e("ReadInJoyDisplayUtils", 1, localStringBuilder.toString());
    }
  }
  
  public static void a(ImageView paramImageView, URL paramURL, Context paramContext)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramImageView.setImageResource(2130842687);
      return;
    }
    if ((paramContext instanceof BaseActivity)) {
      localObject = (BaseActivity)paramContext;
    } else {
      localObject = null;
    }
    boolean bool = false;
    if (localObject != null) {
      bool = SettingCloneUtil.readValue((Context)localObject, ((BaseActivity)localObject).app.getCurrentAccountUin(), null, "qqsetting_kandian_download_pic_flag", false);
    }
    if ((!NetworkUtil.isWifiConnected(paramContext)) && (bool) && (!ImageManager.get().isLocalFileExist(paramURL)))
    {
      paramImageView.setImageResource(2130842687);
      return;
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = paramContext.getResources().getDrawable(2130842687);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = paramContext.getResources().getDrawable(2130842687);
    paramImageView.setImageDrawable(URLDrawable.getDrawable(paramURL, (URLDrawable.URLDrawableOptions)localObject));
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext)
  {
    a(paramKandianUrlImageView, paramURL, paramContext, false);
  }
  
  public static void a(KandianUrlImageView paramKandianUrlImageView, URL paramURL, Context paramContext, boolean paramBoolean)
  {
    if (paramURL == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.ui", 2, "configImage url is empty! use default preload image");
      }
      paramKandianUrlImageView.setImageResource(2130842687);
      return;
    }
    if (a(paramContext, paramURL))
    {
      if (!paramBoolean)
      {
        paramKandianUrlImageView.setImageResource(2130842687);
        return;
      }
      paramKandianUrlImageView.setImageDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165564)));
      return;
    }
    if (!paramBoolean)
    {
      if (paramKandianUrlImageView.isRound())
      {
        paramKandianUrlImageView.setImagePlaceHolder(paramContext.getResources().getDrawable(2130841253)).setImage(paramURL);
        return;
      }
      paramKandianUrlImageView.setImagePlaceHolder(paramContext.getResources().getDrawable(2130842687)).setImage(paramURL);
      return;
    }
    paramKandianUrlImageView.setBackgroundDrawable(new ColorDrawable(paramContext.getResources().getColor(2131165564)));
    paramKandianUrlImageView.setImagePlaceHolder(new ColorDrawable(paramContext.getResources().getColor(2131165564))).setImage(paramURL);
  }
  
  private static boolean a(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity)) {
      paramContext = (BaseActivity)paramContext;
    } else {
      paramContext = null;
    }
    boolean bool = false;
    if (paramContext != null)
    {
      String str;
      if (paramContext.app != null) {
        str = paramContext.app.getCurrentAccountUin();
      } else {
        str = RIJQQAppInterfaceUtil.d();
      }
      bool = SettingCloneUtil.readValue(paramContext, str, null, "qqsetting_kandian_download_pic_flag", false);
    }
    return bool;
  }
  
  public static boolean a(Context paramContext, URL paramURL)
  {
    return (a(paramContext)) && (!NetworkUtil.isWifiConnected(paramContext)) && (!ImageManager.get().isLocalFileExist(paramURL));
  }
  
  public static float b(int paramInt1, int paramInt2)
  {
    paramInt1 = a(paramInt1, paramInt2);
    if (paramInt1 == 1) {
      return 0.5625F;
    }
    if (paramInt1 == 2) {
      return 1.333F;
    }
    return 1.0F;
  }
  
  public static Drawable b(String paramString)
  {
    int i = Color.parseColor(paramString);
    paramString = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { i, i & 0x14FFFFFF });
    paramString.setShape(0);
    paramString.setGradientType(0);
    paramString.setBounds(0, 0, 400, 400);
    return paramString;
  }
  
  public static Pair<Integer, Integer> b()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    return new Pair(Integer.valueOf((localResources.getDisplayMetrics().widthPixels - AIOUtils.b(3.0F, localResources)) / 3), Integer.valueOf(localResources.getDimensionPixelSize(2131299547)));
  }
  
  public static Pair<Integer, Integer> c()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = (localResources.getDisplayMetrics().widthPixels - AIOUtils.b(3.0F, localResources)) / 2;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.33F)));
  }
  
  public static Pair<Integer, Integer> d()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.597F)));
  }
  
  public static Pair<Integer, Integer> e()
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = (localResources.getDisplayMetrics().widthPixels - AIOUtils.b(3.0F, localResources)) / 3;
    return new Pair(Integer.valueOf(i), Integer.valueOf(i));
  }
  
  public static Pair<Integer, Integer> f()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.562F)));
  }
  
  public static Pair<Integer, Integer> g()
  {
    int i = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels;
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 0.5625F)));
  }
  
  public static Pair<Integer, Integer> h()
  {
    int i = (int)(BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().widthPixels * 0.5F);
    return new Pair(Integer.valueOf(i), Integer.valueOf((int)(i * 1.3333F)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils
 * JD-Core Version:    0.7.0.1
 */