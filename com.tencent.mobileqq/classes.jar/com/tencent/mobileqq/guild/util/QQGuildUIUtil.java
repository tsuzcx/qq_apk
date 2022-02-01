package com.tencent.mobileqq.guild.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QQGuildUIUtil
{
  private static Long a = Long.valueOf(0L);
  
  public static int a(float paramFloat, int paramInt1, int paramInt2)
  {
    int m = Color.red(paramInt1);
    int j = Color.blue(paramInt1);
    int i = Color.green(paramInt1);
    paramInt1 = Color.alpha(paramInt1);
    int i1 = Color.red(paramInt2);
    int n = Color.blue(paramInt2);
    int k = Color.green(paramInt2);
    paramInt2 = Color.alpha(paramInt2);
    m = (int)(m + (i1 - m) * paramFloat);
    j = (int)(j + (n - j) * paramFloat);
    i = (int)(i + (k - i) * paramFloat);
    return Color.argb((int)(paramInt1 + paramFloat * (paramInt2 - paramInt1)), m, i, j);
  }
  
  public static Bitmap a(boolean paramBoolean)
  {
    int i;
    Object localObject;
    if (!paramBoolean)
    {
      i = 2130841061;
      localObject = "static://DefaultFace_square";
    }
    else
    {
      localObject = "static://DefaultFace";
      i = 2130841060;
    }
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get(localObject);
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.b(BaseApplication.getContext().getResources(), i);
      if ((localBitmap1 != null) && (GlobalImageCache.a != null)) {
        GlobalImageCache.a.put(localObject, localBitmap1);
      }
      localBitmap2 = localBitmap1;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getDefaultFaceBitmap, bitmap=");
        ((StringBuilder)localObject).append(localBitmap1);
        QLog.d("QQGuildUIUtil", 2, ((StringBuilder)localObject).toString());
        localBitmap2 = localBitmap1;
      }
    }
    return localBitmap2;
  }
  
  public static QQGuildUIUtil.ProgressDialog a(Context paramContext)
  {
    return new QQGuildUIUtil.ProgressDialog(paramContext, null);
  }
  
  public static String a(@StringRes int paramInt)
  {
    return QQGuildUtil.h().getString(paramInt);
  }
  
  public static String a(@StringRes int paramInt, Object... paramVarArgs)
  {
    return QQGuildUtil.h().getString(paramInt, paramVarArgs);
  }
  
  public static String a(String paramString, int paramInt)
  {
    Matcher localMatcher = Pattern.compile("\\w*[0-9]+\\?").matcher(paramString);
    String str = paramString;
    if (localMatcher.find())
    {
      if (paramInt == 40) {
        return localMatcher.replaceFirst("40?");
      }
      if (paramInt == 100) {
        return localMatcher.replaceFirst("100?");
      }
      str = paramString;
      if (paramInt == 140) {
        str = localMatcher.replaceFirst("140?");
      }
    }
    return str;
  }
  
  private static List<View> a(ViewGroup paramViewGroup, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramInt)
    {
      if (paramViewGroup.getChildAt(i).getVisibility() == 0) {
        localArrayList.add(paramViewGroup.getChildAt(i));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static void a(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, @DrawableRes int paramInt4, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    int i = paramViewGroup.getChildCount();
    if (i <= 0) {
      return;
    }
    if (a(paramInt4, paramViewGroup, i)) {
      return;
    }
    paramViewGroup = a(paramViewGroup, i);
    i = paramViewGroup.size();
    if (i <= 0) {
      return;
    }
    if (a(paramInt4, (View)paramViewGroup.get(0), i)) {
      return;
    }
    if (a(paramInt1, paramInt3, paramViewGroup)) {
      return;
    }
    a(paramInt1, paramInt2, paramInt3, paramViewGroup, i);
  }
  
  private static void a(@DrawableRes int paramInt1, @DrawableRes int paramInt2, @DrawableRes int paramInt3, List<View> paramList, int paramInt4)
  {
    int j = 0;
    while (j < paramInt4)
    {
      View localView = (View)paramList.get(j);
      int i;
      if (j == 0) {
        i = paramInt1;
      } else if (j == paramInt4 - 1) {
        i = paramInt3;
      } else {
        i = paramInt2;
      }
      localView.setBackgroundResource(i);
      j += 1;
    }
  }
  
  public static void a(Activity paramActivity, int paramInt)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity = paramActivity.getWindow();
      paramActivity.clearFlags(67108864);
      paramActivity.getDecorView().setSystemUiVisibility(1280);
      paramActivity.addFlags(-2147483648);
      paramActivity.setStatusBarColor(paramInt);
      paramActivity.setNavigationBarColor(paramInt);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      paramActivity.getWindow().addFlags(67108864);
    }
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramActivity != null) && (paramActivity.getWindow() != null)) {
      a(paramActivity.getWindow(), paramBoolean1, paramBoolean2);
    }
  }
  
  public static void a(Window paramWindow, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (!paramBoolean1) {
      i = 5380;
    } else {
      i = 5376;
    }
    int j = i;
    if (!paramBoolean2) {
      j = i | 0x2 | 0x800;
    }
    if (paramWindow != null) {
      paramWindow.getDecorView().setSystemUiVisibility(j);
    }
  }
  
  public static void a(boolean paramBoolean, int paramInt, View paramView, Resources paramResources)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (paramBoolean) {
      localMarginLayoutParams.topMargin = Utils.a(paramInt, paramResources);
    } else {
      localMarginLayoutParams.bottomMargin = Utils.a(paramInt, paramResources);
    }
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  public static boolean a()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - a.longValue();
    if ((l2 > 0L) && (l2 < 500L))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("time:");
        localStringBuilder.append(l1);
        localStringBuilder.append(", mLastClickTIme:");
        localStringBuilder.append(a);
        localStringBuilder.append(", timeDiff:");
        localStringBuilder.append(l2);
        QLog.i("QQGuildUIUtil", 2, localStringBuilder.toString());
      }
      return true;
    }
    a = Long.valueOf(l1);
    return false;
  }
  
  private static boolean a(@DrawableRes int paramInt1, @DrawableRes int paramInt2, List<View> paramList)
  {
    if (paramList.size() == 2)
    {
      ((View)paramList.get(0)).setBackgroundResource(paramInt1);
      ((View)paramList.get(1)).setBackgroundResource(paramInt2);
      return true;
    }
    return false;
  }
  
  private static boolean a(@DrawableRes int paramInt1, View paramView, int paramInt2)
  {
    if (paramInt2 == 1)
    {
      if (paramView.getVisibility() == 0) {
        paramView.setBackgroundResource(paramInt1);
      }
      return true;
    }
    return false;
  }
  
  public static void b(Activity paramActivity, int paramInt)
  {
    new Handler().postDelayed(new QQGuildUIUtil.1(paramActivity), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.util.QQGuildUIUtil
 * JD-Core Version:    0.7.0.1
 */