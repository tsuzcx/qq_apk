package com.tencent.mobileqq.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.profilecard.util.LevelUtil;
import com.tencent.mobileqq.vas.quickupdate.QQLevelIconCallback;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.mobileqq.vip.IGameCardManager.GameCardInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QQSettingUtil
{
  public static int a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setting_quit_");
    localStringBuilder.append(paramString);
    return paramContext.getInt(localStringBuilder.toString(), 0);
  }
  
  public static SpannableString a(Resources paramResources, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramResources == null) {
      return new SpannableString("");
    }
    if (!QQLevelIconCallback.isQQLevelIconExists(((AppInterface)localObject1).getApp(), paramInt1)) {
      QQLevelIconCallback.downloadQQLevelIcon(paramInt1, null, false);
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, null);
    if (paramInt2 == 0)
    {
      localObject1 = new SpannableString("*");
      paramInt2 = (int)paramResources.getDimension(2131299230);
      paramResources = paramResources.getDrawable(2130847508);
      paramResources = VasApngUtil.getOptimizedApngDrawable(LevelUtil.a(paramInt1, LevelUtil.a), paramResources, VasApngUtil.VIP_APNG_TAGS, "halfStar");
      paramResources.setBounds(0, 0, paramInt2, paramInt2);
      if (bool) {
        paramResources.setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
      } else {
        paramResources.setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
      }
      ((SpannableString)localObject1).setSpan(new ImageSpan(paramResources), 0, 1, 33);
      return localObject1;
    }
    int k = paramInt2 / 64;
    paramInt2 %= 64;
    int m = paramInt2 / 16;
    int i1 = paramInt2 % 16;
    int n = i1 / 4;
    Object localObject2 = "";
    int i = 0;
    Object localObject3;
    for (;;)
    {
      localObject1 = "%";
      localObject3 = "!";
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
              localObject1 = "";
              paramInt2 = 0;
            }
            else
            {
              paramInt2 = i1 % 4;
            }
          }
          else
          {
            localObject1 = "#";
            paramInt2 = n;
          }
        }
        else
        {
          localObject1 = "@";
          paramInt2 = m;
        }
      }
      else
      {
        localObject1 = "!";
        paramInt2 = k;
      }
      int j = 0;
      while (j < paramInt2)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject3).toString();
        j += 1;
      }
      i += 1;
    }
    if ((paramInt3 > 1) && (((String)localObject2).length() > paramInt3))
    {
      localObject1 = ((String)localObject2).substring(0, paramInt3 - 1);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("$");
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject1 = localObject2;
    }
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject1);
    i = (int)paramResources.getDimension(2131299230);
    paramInt2 = 0;
    localObject2 = localObject1;
    while (paramInt2 < ((String)localObject2).length())
    {
      paramInt3 = paramInt2 + 1;
      String str = ((String)localObject2).substring(paramInt2, paramInt3);
      if (((String)localObject3).equalsIgnoreCase(str))
      {
        localObject1 = paramResources.getDrawable(2130847506);
        localObject1 = VasApngUtil.getOptimizedApngDrawable(LevelUtil.a(paramInt1, LevelUtil.e), (Drawable)localObject1, VasApngUtil.VIP_APNG_TAGS, "crown");
      }
      else if ("@".equalsIgnoreCase(str))
      {
        localObject1 = paramResources.getDrawable(2130847510);
        localObject1 = VasApngUtil.getOptimizedApngDrawable(LevelUtil.a(paramInt1, LevelUtil.d), (Drawable)localObject1, VasApngUtil.VIP_APNG_TAGS, "sun");
      }
      else if ("#".equalsIgnoreCase(str))
      {
        localObject1 = paramResources.getDrawable(2130847507);
        localObject1 = VasApngUtil.getOptimizedApngDrawable(LevelUtil.a(paramInt1, LevelUtil.c), (Drawable)localObject1, VasApngUtil.VIP_APNG_TAGS, "moon");
      }
      else if ("%".equalsIgnoreCase(str))
      {
        localObject1 = paramResources.getDrawable(2130847509);
        localObject1 = VasApngUtil.getOptimizedApngDrawable(LevelUtil.a(paramInt1, LevelUtil.b), (Drawable)localObject1, VasApngUtil.VIP_APNG_TAGS, "star");
      }
      else if ("$".equalsIgnoreCase(str))
      {
        localObject1 = paramResources.getDrawable(2130853421);
      }
      else
      {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        if ("&".equalsIgnoreCase(str)) {
          ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
        } else {
          ((Drawable)localObject1).setBounds(0, 0, i, i);
        }
        if (bool) {
          ((Drawable)localObject1).setColorFilter(1996488704, PorterDuff.Mode.SRC_ATOP);
        } else {
          ((Drawable)localObject1).setColorFilter(0, PorterDuff.Mode.SRC_ATOP);
        }
        localSpannableString.setSpan(new ImageSpan((Drawable)localObject1), paramInt2, paramInt3, 33);
      }
      paramInt2 = paramInt3;
    }
    if (QLog.isDevelopLevel())
    {
      paramResources = new StringBuilder();
      paramResources.append("parseQQLevel, sLevel = ");
      paramResources.append((String)localObject2);
      paramResources.append(", span = ");
      paramResources.append(localSpannableString);
      QLog.i("QQSettingRedesign", 4, paramResources.toString());
    }
    return localSpannableString;
  }
  
  public static URLDrawable a(View paramView, IGameCardManager.GameCardInfo paramGameCardInfo)
  {
    IGameCardManager localIGameCardManager = VasUtil.a().getGameCardManager();
    paramGameCardInfo.b = VasUtil.e();
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    return localIGameCardManager.getGameCardDrawable(false, paramGameCardInfo, new QQSettingUtil.2(paramView, paramGameCardInfo));
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setting_quit_");
    localStringBuilder.append(paramString);
    paramContext.putInt(localStringBuilder.toString(), paramInt);
    paramContext.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.execute(new QQSettingUtil.1(paramQQAppInterface));
  }
  
  static void b(QQAppInterface paramQQAppInterface)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void c(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Vip_pay_mywallet");
      localStringBuilder.append('|');
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append('|');
      localStringBuilder.append("");
      localStringBuilder.append('|');
      localStringBuilder.append("wallet");
      localStringBuilder.append('|');
      localStringBuilder.append("index");
      localStringBuilder.append('|');
      localStringBuilder.append(0);
      localStringBuilder.append('|');
      localStringBuilder.append(1);
      localStringBuilder.append('|');
      localStringBuilder.append(0);
      localStringBuilder.append('|');
      localStringBuilder.append("");
      localStringBuilder.append('|');
      localStringBuilder.append("");
      localStringBuilder.append('|');
      localStringBuilder.append("");
      localStringBuilder.append('|');
      localStringBuilder.append("");
      localStringBuilder.append('|');
      StatisticCollector.getInstance(null).reportToPCliOper(paramQQAppInterface, localStringBuilder.toString());
    }
  }
  
  public static int d(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getApplicationContext().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("mywallet_flag", 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.QQSettingUtil
 * JD-Core Version:    0.7.0.1
 */