package com.tencent.mobileqq.utils;

import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Config;
import com.tencent.mobileqq.config.business.qvip.QVipBigClubSVIP9Processor;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import java.io.File;
import mqq.app.AppRuntime;

public class VipUtils$VipIconUtils
{
  private static long[] a = { 0L, 0L };
  
  public static int a(VipUtils.VipIconUtils.NamePlateVipTpye paramNamePlateVipTpye)
  {
    if ((paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.b) || (paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.c)) {}
    do
    {
      return 2130847430;
      if (paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.d) {
        return 2130847429;
      }
      if (paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.e) {
        return 2130847431;
      }
    } while ((paramNamePlateVipTpye != VipUtils.VipIconUtils.NamePlateVipTpye.f) && (paramNamePlateVipTpye != VipUtils.VipIconUtils.NamePlateVipTpye.g));
    return 2130847426;
  }
  
  public static String a(int paramInt1, int paramInt2, long paramLong)
  {
    return a(paramInt1, paramInt2, paramLong, false);
  }
  
  private static String a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (String str = QVipBigClubSVIP9Processor.c().mAPngIconUrl;; str = QVipBigClubSVIP9Processor.c().mAPngIconUrlNewGray)
    {
      if (paramBoolean) {
        paramLong = 0L;
      }
      return String.format(str, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong) });
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    return paramString1 + File.separator + paramString2 + ".png";
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, EVIPSPEC paramEVIPSPEC)
  {
    Object localObject = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((FriendsManager)localObject).e(paramString);
      if (localObject != null)
      {
        int i;
        if (paramEVIPSPEC == EVIPSPEC.E_SP_BIGCLUB)
        {
          i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_BIGCLUB);
          return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), ((Friends)localObject).bigClubTemplateId, false);
        }
        if (paramEVIPSPEC == EVIPSPEC.E_SP_SUPERVIP)
        {
          i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_SUPERVIP);
          return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), ((Friends)localObject).superVipTemplateId, false);
        }
        if (paramEVIPSPEC == EVIPSPEC.E_SP_QQVIP)
        {
          i = VipUtils.a(paramAppRuntime, paramString, EVIPSPEC.E_SP_QQVIP);
          return a((i & 0xF) << 8 | i >> 8, ((Friends)localObject).getServiceLevel(paramEVIPSPEC), 0L, false);
        }
      }
    }
    return a(0, 0, 0L, false);
  }
  
  public static String a(AppRuntime paramAppRuntime, String paramString, VipUtils.VipIconUtils.NamePlateVipTpye paramNamePlateVipTpye, boolean paramBoolean)
  {
    paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.e(paramString);
      if (paramAppRuntime != null)
      {
        int i;
        if ((paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.f) || (paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.g))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_BIGCLUB);
          return a(paramNamePlateVipTpye.a, i, paramAppRuntime.bigClubTemplateId, paramBoolean);
        }
        if ((paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.d) || (paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.e))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_SUPERVIP);
          return a(paramNamePlateVipTpye.a, i, paramAppRuntime.superVipTemplateId, paramBoolean);
        }
        if ((paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.b) || (paramNamePlateVipTpye == VipUtils.VipIconUtils.NamePlateVipTpye.c))
        {
          i = paramAppRuntime.getServiceLevel(EVIPSPEC.E_SP_QQVIP);
          return a(paramNamePlateVipTpye.a, i, 0L, paramBoolean);
        }
      }
    }
    return a(0, 0, 0L, false);
  }
  
  public static void a(Context paramContext, ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if ((paramContext != null) && (paramImageView != null) && (paramInt1 > 0))
    {
      paramImageView.setVisibility(0);
      paramImageView.setTag(2131381699, Integer.valueOf(paramInt1));
      String str = a(IndividuationUrlHelper.a("extendnameplateiconurl"), String.valueOf(paramInt1));
      VipUtils.a(paramContext.getResources(), paramImageView, str, URLDrawableHelper.TRANSPARENT);
      if (paramInt2 != 1) {
        break label66;
      }
      VipUtils.a("0X800B922", paramInt1);
    }
    label66:
    while (paramInt2 != 2) {
      return;
    }
    VipUtils.a("0X800B924", paramInt1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    paramString = QVipBigClubSVIP9Processor.c().getVipIconSettingsUrl(paramString);
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("uin", paramQQAppInterface);
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramString, 256L, localIntent, false, -1);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt > 0;
  }
  
  public static int[] a(AppRuntime paramAppRuntime, String paramString)
  {
    paramAppRuntime = (FriendsManager)paramAppRuntime.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.e(paramString);
      if (paramAppRuntime != null) {
        return new int[] { paramAppRuntime.nameplateVipType, paramAppRuntime.grayNameplateFlag };
      }
    }
    return new int[] { 0, 0 };
  }
  
  private static String b(StrangerInfo paramStrangerInfo)
  {
    int i = VipUtils.a(paramStrangerInfo);
    i = (i & 0xF) << 8 | i >> 8;
    if ((i & 0xFF) == 3) {
      return a(i, paramStrangerInfo.mBigVipLevel, paramStrangerInfo.mTemplateId, false);
    }
    if ((i & 0xFF) == 2) {
      return a(i, paramStrangerInfo.mVipLevel, paramStrangerInfo.mTemplateId, false);
    }
    return null;
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 1;
  }
  
  private static void c(String paramString, int paramInt, boolean paramBoolean)
  {
    long l;
    if ("VIA_SETTINGME".equals(paramString))
    {
      l = System.currentTimeMillis();
      if (Math.abs(l - a[0]) >= 3000L) {}
    }
    do
    {
      do
      {
        return;
        a[0] = l;
        e("0X800AA99", paramInt, paramBoolean);
        return;
        if (!"VIA_PROFILECARD".equals(paramString)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (Math.abs(l - a[1]) < 3000L);
      a[1] = l;
      e("0X800AA9A", paramInt, paramBoolean);
      return;
      if ("VIA_AIO_TITLE".equals(paramString))
      {
        e("0X800AA9B", paramInt, paramBoolean);
        return;
      }
    } while (!"VIA_AIO_CHATSETTINGS".equals(paramString));
    e("0X800AA9C", paramInt, paramBoolean);
  }
  
  private static void d(String paramString, int paramInt, boolean paramBoolean)
  {
    if ("VIA_SETTINGME".equals(paramString)) {
      e("0X800AA9D", paramInt, paramBoolean);
    }
    do
    {
      return;
      if ("VIA_PROFILECARD".equals(paramString))
      {
        e("0X800AA9E", paramInt, paramBoolean);
        return;
      }
      if ("VIA_AIO_TITLE".equals(paramString))
      {
        e("0X800AA9F", paramInt, paramBoolean);
        return;
      }
    } while (!"VIA_AIO_CHATSETTINGS".equals(paramString));
    e("0X800AAA0", paramInt, paramBoolean);
  }
  
  private static void e(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 9;; i = 0)
    {
      ReportController.b(null, "dc00898", "", "", "qq_vip", paramString, i, 1, paramInt, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VipUtils.VipIconUtils
 * JD-Core Version:    0.7.0.1
 */