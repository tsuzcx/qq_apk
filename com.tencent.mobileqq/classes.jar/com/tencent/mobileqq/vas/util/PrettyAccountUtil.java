package com.tencent.mobileqq.vas.util;

import MQQ.LhLogoInfo;
import MQQ.LhLogoResources;
import MQQ.VAResourcesRsp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.data.ProfileCardInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.api.IVasDepTemp;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipPrettyAccountProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class PrettyAccountUtil
{
  public static long a;
  private static Map<Integer, LhLogoResources> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap();
  static int[] jdField_a_of_type_ArrayOfInt = { 37, 9, 35, 36, 38 };
  public static long b = 0L;
  
  static
  {
    jdField_a_of_type_Long = 1594224000L;
  }
  
  public static int a()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pretty_account_info", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lh_flag_");
    localStringBuilder.append(a());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static int a(Card paramCard)
  {
    int i = 0;
    if (paramCard == null) {
      return 0;
    }
    if ((paramCard.lUserFlag & 0x400) == 1024L) {
      i = 1;
    }
    return i;
  }
  
  public static LhLogoResources a(int paramInt)
  {
    LhLogoResources localLhLogoResources = (LhLogoResources)jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pretty_account exist:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",");
      boolean bool;
      if (localLhLogoResources != null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("PrettyAccountUtil", 2, localStringBuilder.toString());
    }
    return localLhLogoResources;
  }
  
  public static TextView a(TextView paramTextView, int paramInt1, int paramInt2)
  {
    if (a())
    {
      if (1 != paramInt1) {
        return paramTextView;
      }
      Object localObject1 = a(paramInt2);
      if (localObject1 == null) {
        return paramTextView;
      }
      paramTextView.getContext().getResources();
      paramTextView.setGravity(16);
      paramTextView.setTextSize(1, 14.0F);
      paramTextView.setTextColor(Color.parseColor(((LhLogoResources)localObject1).normalColor));
      paramTextView.setPadding(0, 0, 0, 0);
      Object localObject2 = new Rect();
      String str = paramTextView.getText().toString();
      paramTextView.getPaint().getTextBounds(str, 0, str.length(), (Rect)localObject2);
      paramInt1 = ViewUtils.a(26.0F);
      paramInt2 = ((Rect)localObject2).width();
      int i = ViewUtils.a(8.0F);
      int j = ViewUtils.a(23.0F);
      localObject2 = paramTextView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = (paramInt1 + paramInt2 + i);
      ((ViewGroup.LayoutParams)localObject2).height = j;
      paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      paramTextView.setBackgroundDrawable(VasApngUtil.getRegionUrlDrawable(((LhLogoResources)localObject1).backUrl, 320));
      localObject1 = VasApngUtil.getApngURLDrawable(((LhLogoResources)localObject1).apngUrl, jdField_a_of_type_ArrayOfInt, URLDrawableHelperConstants.a);
      paramInt1 = ViewUtils.a(22.0F);
      ((URLDrawable)localObject1).setBounds(0, 0, paramInt1 * 26 / 22, paramInt1);
      paramTextView.setCompoundDrawables((Drawable)localObject1, null, null, null);
    }
    return paramTextView;
  }
  
  public static TextView a(TextView paramTextView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramTextView.setBackgroundDrawable(null);
    paramTextView.setTextColor(paramInt3);
    paramTextView.setTextSize(1, paramInt4);
    return a(paramTextView, paramInt1, paramInt2);
  }
  
  public static CharSequence a(int paramInt1, int paramInt2, CharSequence paramCharSequence, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramCharSequence;
    }
    if (paramInt2 < 0) {
      return paramCharSequence;
    }
    if (a())
    {
      if (1 != paramInt1) {
        return paramCharSequence;
      }
      if (jdField_a_of_type_JavaUtilMap.isEmpty()) {
        return paramCharSequence;
      }
      return paramString;
    }
    return paramCharSequence;
  }
  
  private static String a()
  {
    AppRuntime localAppRuntime = VasUtil.a();
    if (localAppRuntime != null)
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getCurrentUin = ");
        localStringBuilder.append(localAppRuntime.getAccount());
        QLog.i("PrettyAccountUtil", 4, localStringBuilder.toString());
      }
      return localAppRuntime.getAccount();
    }
    return null;
  }
  
  @NotNull
  private static String a(AppRuntime paramAppRuntime, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramProfileCardInfo.allInOne.troopUin))
    {
      if (paramProfileCardInfo.allInOne.uin.equals(paramAppRuntime.getCurrentAccountUin()))
      {
        if (paramBoolean) {
          return "0X800B22E";
        }
        return "0X800B22D";
      }
      if (paramBoolean) {
        return "0X800B230";
      }
      return "0X800B22F";
    }
    if (paramProfileCardInfo.allInOne.uin.equals(paramAppRuntime.getCurrentAccountUin()))
    {
      if (paramBoolean) {
        return "0X800B234";
      }
      return "0X800B233";
    }
    if (paramBoolean) {
      return "0X800B236";
    }
    return "0X800B235";
  }
  
  public static void a()
  {
    String str1 = VasUtil.a();
    String str2 = IndividuationUrlHelper.a("vipPersonalCardMaster");
    Intent localIntent = ((IVasDepTemp)QRoute.api(IVasDepTemp.class)).getQQBrowserIntent();
    localIntent.putExtra("uin", str1);
    localIntent.putExtra("url", str2);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    MobileQQ.getContext().startActivity(localIntent);
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pretty_account update self:");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("PrettyAccountUtil", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt2 == -1) {
      return;
    }
    Object localObject = MobileQQ.getContext().getSharedPreferences("pretty_account_info", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lh_flag_");
    localStringBuilder.append(a());
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt1);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("lh_level_");
    localStringBuilder.append(a());
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt2);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(VAResourcesRsp paramVAResourcesRsp)
  {
    if (paramVAResourcesRsp.lhLogoInfo != null)
    {
      paramVAResourcesRsp = paramVAResourcesRsp.lhLogoInfo;
      int i = paramVAResourcesRsp.bUpdate;
      boolean bool = true;
      if ((i == 1) && (paramVAResourcesRsp.lhLogoResources != null))
      {
        jdField_a_of_type_JavaUtilMap.clear();
        jdField_a_of_type_JavaUtilMap.putAll(paramVAResourcesRsp.lhLogoResources);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("pretty_account update state:");
        localStringBuilder.append(paramVAResourcesRsp.bUpdate);
        localStringBuilder.append(",");
        if (paramVAResourcesRsp.lhLogoResources != null) {
          bool = false;
        }
        localStringBuilder.append(bool);
        QLog.d("PrettyAccountUtil", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(TextView paramTextView, int paramInt1, int paramInt2, CharSequence paramCharSequence, String paramString)
  {
    paramTextView.setText(a(paramInt1, paramInt2, paramCharSequence, paramString));
    a(paramTextView, paramInt1, paramInt2);
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    if (a())
    {
      if (1 != paramInt1) {
        return;
      }
      ReportController.b(VasUtil.a(), "dc00898", "", "", "", paramString, paramInt2, 0, "", "", "", "");
    }
  }
  
  public static void a(AppRuntime paramAppRuntime, ProfileCardInfo paramProfileCardInfo, boolean paramBoolean)
  {
    if ((paramAppRuntime != null) && (paramProfileCardInfo != null))
    {
      if (paramProfileCardInfo.card == null) {
        return;
      }
      if (!paramBoolean)
      {
        if (System.currentTimeMillis() - b < 1500L) {
          return;
        }
        b = System.currentTimeMillis();
      }
      a(a(paramAppRuntime, paramProfileCardInfo, paramBoolean), a(paramProfileCardInfo.card), paramProfileCardInfo.card.lhLevel);
    }
  }
  
  public static boolean a()
  {
    QVipPrettyAccountConfig localQVipPrettyAccountConfig = QVipPrettyAccountProcessor.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pretty_account manageOpen:");
      localStringBuilder.append(localQVipPrettyAccountConfig.a);
      QLog.d("PrettyAccountUtil", 2, localStringBuilder.toString());
    }
    return localQVipPrettyAccountConfig.a;
  }
  
  public static int b()
  {
    SharedPreferences localSharedPreferences = MobileQQ.getContext().getSharedPreferences("pretty_account_info", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lh_level_");
    localStringBuilder.append(a());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.util.PrettyAccountUtil
 * JD-Core Version:    0.7.0.1
 */