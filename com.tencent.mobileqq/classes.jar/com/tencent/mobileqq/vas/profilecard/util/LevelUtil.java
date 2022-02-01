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
  
  public static SpannableString a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    MobileQQ.sMobileQQ.waitAppRuntime(null);
    if (!QQLevelIconCallback.isQQLevelIconExists(paramContext, paramInt2)) {
      QQLevelIconCallback.downloadQQLevelIcon(paramInt2, null, false);
    }
    if (paramInt3 == 0)
    {
      localObject1 = new SpannableString("*");
      paramInt1 = (int)paramContext.getResources().getDimension(2131297240);
      paramContext = paramContext.getResources().getDrawable(2130846038);
      paramContext = VasApngUtil.getOptimizedApngDrawable(a(paramInt2, a), paramContext, VasApngUtil.VIP_APNG_TAGS, "halfstar");
      paramContext.setBounds(0, 0, paramInt1, paramInt1);
      QQTheme.a(paramContext);
      ((SpannableString)localObject1).setSpan(new ImageSpan(paramContext), 0, 1, 33);
      return localObject1;
    }
    int k = paramInt3 / 64;
    paramInt3 %= 64;
    int m = paramInt3 / 16;
    int i1 = paramInt3 % 16;
    int n = i1 / 4;
    Object localObject1 = "";
    int i = 0;
    for (;;)
    {
      String str = "#";
      paramInt3 = 2;
      if (i >= 4) {
        break;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              str = "";
              paramInt3 = 0;
            }
            else
            {
              str = "%";
              paramInt3 = i1 % 4;
            }
          }
          else {
            paramInt3 = n;
          }
        }
        else
        {
          str = "@";
          paramInt3 = m;
        }
      }
      else
      {
        str = "!";
        paramInt3 = k;
      }
      j = 0;
      while (j < paramInt3)
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append((String)localObject1);
        ((StringBuilder)localObject5).append(str);
        localObject1 = ((StringBuilder)localObject5).toString();
        j += 1;
      }
      i += 1;
    }
    if (paramBoolean)
    {
      try
      {
        i = ((String)localObject1).length();
        if (i <= paramInt1) {
          break label330;
        }
        try
        {
          localObject5 = ((String)localObject1).substring(0, paramInt1);
        }
        catch (Exception localException1) {}
        localException2.printStackTrace();
      }
      catch (Exception localException2) {}
      localObject5 = localObject1;
      break label334;
    }
    label330:
    Object localObject5 = localObject1;
    label334:
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject5);
    int j = (int)paramContext.getResources().getDimension(2131297240);
    i = 0;
    paramInt1 = paramInt3;
    while (i < ((String)localObject5).length())
    {
      paramInt3 = i + 1;
      label688:
      label715:
      do
      {
        try
        {
          Object localObject6;
          Object localObject2;
          if ("!".equalsIgnoreCase(((String)localObject5).substring(i, paramInt3)))
          {
            localObject1 = paramContext.getResources().getDrawable(2130846036);
            localObject4 = a(paramInt2, e);
            localObject6 = VasApngUtil.VIP_APNG_TAGS;
            try
            {
              localObject1 = VasApngUtil.getOptimizedApngDrawable((String)localObject4, (Drawable)localObject1, (int[])localObject6, "crown");
            }
            catch (Error localError1)
            {
              localObject4 = null;
              break label688;
            }
          }
          else
          {
            localObject2 = null;
          }
          try
          {
            if ("@".equalsIgnoreCase(((String)localObject5).substring(i, paramInt3)))
            {
              localObject4 = paramContext.getResources().getDrawable(2130846040);
              localObject4 = VasApngUtil.getOptimizedApngDrawable(a(paramInt2, d), (Drawable)localObject4, VasApngUtil.VIP_APNG_TAGS, "sun");
            }
            else
            {
              localObject4 = localObject2;
            }
            localObject2 = localObject4;
            localObject6 = localObject4;
            Object localObject8 = localObject4;
            try
            {
              if ("#".equalsIgnoreCase(((String)localObject5).substring(i, paramInt3)))
              {
                localObject6 = localObject4;
                localObject8 = localObject4;
                localObject2 = paramContext.getResources().getDrawable(2130846037);
                localObject6 = localObject4;
                localObject8 = localObject4;
                localObject2 = VasApngUtil.getOptimizedApngDrawable(a(paramInt2, c), (Drawable)localObject2, VasApngUtil.VIP_APNG_TAGS, "moon");
              }
              localObject4 = localObject2;
              localObject6 = localObject2;
              localObject8 = localObject2;
              if ("%".equalsIgnoreCase(((String)localObject5).substring(i, paramInt3)))
              {
                localObject6 = localObject2;
                localObject8 = localObject2;
                localObject4 = paramContext.getResources().getDrawable(2130846039);
                localObject6 = localObject2;
                localObject8 = localObject2;
                localObject4 = VasApngUtil.getOptimizedApngDrawable(a(paramInt2, b), (Drawable)localObject4, VasApngUtil.VIP_APNG_TAGS, "star");
              }
              paramInt1 = 2;
              localObject2 = localObject4;
            }
            catch (Exception localException3)
            {
              localObject2 = localObject6;
              break label715;
            }
            catch (Error localError2)
            {
              localObject4 = localException3;
            }
            paramInt3 = 2;
          }
          catch (Exception localException4) {}catch (Error localError3)
          {
            localObject4 = localError2;
            localObject3 = localError3;
          }
          Object localObject7 = localObject3;
        }
        catch (Exception localException5)
        {
          localObject3 = null;
        }
        catch (Error localError4)
        {
          localObject4 = null;
          paramInt3 = paramInt1;
        }
        localObject4 = localObject3;
      } while (!QLog.isColorLevel());
      Object localObject4 = localException5.toString();
      paramInt1 = 2;
      QLog.d("Q.profilecard.FrdProfileCard", 2, (String)localObject4);
      break label774;
      Object localObject3 = localObject4;
      paramInt1 = paramInt3;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.FrdProfileCard", paramInt3, localError4.toString());
        paramInt1 = paramInt3;
        localObject3 = localObject4;
      }
      label774:
      if (localObject3 != null)
      {
        localObject3.setBounds(0, 0, j, j);
        QQTheme.a(localObject3);
        localSpannableString.setSpan(new ImageSpan(localObject3), i, i + 1, 33);
      }
      i += 1;
    }
    return localSpannableString;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.profilecard.util.LevelUtil
 * JD-Core Version:    0.7.0.1
 */