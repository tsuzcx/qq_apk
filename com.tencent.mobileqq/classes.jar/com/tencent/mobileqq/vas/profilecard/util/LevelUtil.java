package com.tencent.mobileqq.vas.profilecard.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class LevelUtil
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  public static int e = 4;
  
  private static Drawable a(Context paramContext, int paramInt1, String paramString, int paramInt2)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject3 = null;
    int i = paramInt2 + 1;
    Object localObject1 = localObject4;
    Object localObject2 = localObject5;
    try
    {
      if ("!".equalsIgnoreCase(paramString.substring(paramInt2, i)))
      {
        localObject1 = localObject4;
        localObject2 = localObject5;
        localObject3 = paramContext.getResources().getDrawable(2130847506);
        localObject1 = localObject4;
        localObject2 = localObject5;
        localObject3 = VasApngUtil.getOptimizedApngDrawable(a(paramInt1, e), (Drawable)localObject3, VasApngUtil.VIP_APNG_TAGS, "crown");
      }
      localObject4 = localObject3;
      localObject1 = localObject3;
      localObject2 = localObject3;
      if ("@".equalsIgnoreCase(paramString.substring(paramInt2, i)))
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = paramContext.getResources().getDrawable(2130847510);
        localObject1 = localObject3;
        localObject2 = localObject3;
        localObject4 = VasApngUtil.getOptimizedApngDrawable(a(paramInt1, d), (Drawable)localObject4, VasApngUtil.VIP_APNG_TAGS, "sun");
      }
      localObject3 = localObject4;
      localObject1 = localObject4;
      localObject2 = localObject4;
      if ("#".equalsIgnoreCase(paramString.substring(paramInt2, i)))
      {
        localObject1 = localObject4;
        localObject2 = localObject4;
        localObject3 = paramContext.getResources().getDrawable(2130847507);
        localObject1 = localObject4;
        localObject2 = localObject4;
        localObject3 = VasApngUtil.getOptimizedApngDrawable(a(paramInt1, c), (Drawable)localObject3, VasApngUtil.VIP_APNG_TAGS, "moon");
      }
      localObject1 = localObject3;
      localObject2 = localObject3;
      localObject4 = localObject3;
      if ("%".equalsIgnoreCase(paramString.substring(paramInt2, i)))
      {
        localObject1 = localObject3;
        localObject2 = localObject3;
        paramContext = paramContext.getResources().getDrawable(2130847509);
        localObject1 = localObject3;
        localObject2 = localObject3;
        paramContext = VasApngUtil.getOptimizedApngDrawable(a(paramInt1, b), paramContext, VasApngUtil.VIP_APNG_TAGS, "star");
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        return localObject1;
      }
    }
    catch (Error paramContext)
    {
      localObject4 = localObject2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", 2, paramContext.toString());
        localObject4 = localObject2;
      }
    }
    return localObject4;
  }
  
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!QQLevelIconCallback.isQQLevelIconExists(paramContext, paramInt2)) {
      QQLevelIconCallback.downloadQQLevelIcon(paramInt2, null, false);
    }
    if (paramInt3 == 0)
    {
      localObject1 = new SpannableString("*");
      paramInt1 = (int)paramContext.getResources().getDimension(2131297671);
      paramContext = paramContext.getResources().getDrawable(2130847508);
      paramContext = VasApngUtil.getOptimizedApngDrawable(a(paramInt2, a), paramContext, VasApngUtil.VIP_APNG_TAGS, "halfstar");
      paramContext.setBounds(0, 0, paramInt1, paramInt1);
      QQTheme.setNightFilter(paramContext);
      ((SpannableString)localObject1).setSpan(new ImageSpan(paramContext), 0, 1, 33);
      return localObject1;
    }
    int i = paramInt3 / 64;
    int j = paramInt3 % 64;
    paramInt3 = j / 16;
    j %= 16;
    Object localObject3 = a(i, paramInt3, j / 4, j % 4);
    Object localObject1 = localObject3;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = localObject3;
      try
      {
        if (((String)localObject3).length() > paramInt1) {
          localObject1 = ((String)localObject3).substring(0, paramInt1);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject2 = localObject3;
      }
    }
    localObject3 = new SpannableString(localObject2);
    a(paramContext, paramInt2, localObject2, (SpannableString)localObject3, (int)paramContext.getResources().getDimension(2131297671));
    return localObject3;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    QQLevelIconCallback localQQLevelIconCallback = QQLevelIconCallback.sInstance;
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 != 4)
            {
              if (paramInt2 != 5) {
                return "_";
              }
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(localQQLevelIconCallback.getDir(MobileQQ.context, localQQLevelIconCallback.getScid(paramInt1)));
              localStringBuilder.append("/more.png");
              return localStringBuilder.toString();
            }
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(localQQLevelIconCallback.getDir(MobileQQ.context, localQQLevelIconCallback.getScid(paramInt1)));
            localStringBuilder.append("/crown.png");
            return localStringBuilder.toString();
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localQQLevelIconCallback.getDir(MobileQQ.context, localQQLevelIconCallback.getScid(paramInt1)));
          localStringBuilder.append("/sun.png");
          return localStringBuilder.toString();
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(localQQLevelIconCallback.getDir(MobileQQ.context, localQQLevelIconCallback.getScid(paramInt1)));
        localStringBuilder.append("/moon.png");
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQLevelIconCallback.getDir(MobileQQ.context, localQQLevelIconCallback.getScid(paramInt1)));
      localStringBuilder.append("/star.png");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localQQLevelIconCallback.getDir(MobileQQ.context, localQQLevelIconCallback.getScid(paramInt1)));
    localStringBuilder.append("/half.png");
    return localStringBuilder.toString();
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    String str2 = "";
    int j = 0;
    while (j < 4)
    {
      String str1;
      int i;
      if (j != 0)
      {
        if (j != 1)
        {
          if (j != 2)
          {
            if (j != 3)
            {
              str1 = "";
              i = 0;
            }
            else
            {
              str1 = "%";
              i = paramInt4;
            }
          }
          else
          {
            str1 = "#";
            i = paramInt3;
          }
        }
        else
        {
          str1 = "@";
          i = paramInt2;
        }
      }
      else
      {
        str1 = "!";
        i = paramInt1;
      }
      int k = 0;
      while (k < i)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2);
        localStringBuilder.append(str1);
        str2 = localStringBuilder.toString();
        k += 1;
      }
      j += 1;
    }
    return str2;
  }
  
  private static void a(Context paramContext, int paramInt1, String paramString, SpannableString paramSpannableString, int paramInt2)
  {
    int i = 0;
    while (i < paramString.length())
    {
      Drawable localDrawable = a(paramContext, paramInt1, paramString, i);
      if (localDrawable != null)
      {
        localDrawable.setBounds(0, 0, paramInt2, paramInt2);
        QQTheme.setNightFilter(localDrawable);
        paramSpannableString.setSpan(new ImageSpan(localDrawable), i, i + 1, 33);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.profilecard.util.LevelUtil
 * JD-Core Version:    0.7.0.1
 */