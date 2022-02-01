package com.tencent.mobileqq.guild.share;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.config.QQGuildGrayUserTypeConfig;
import com.tencent.mobileqq.guild.config.QQGuildShareConfigBean;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;

public class KaShareInterceptor
{
  private static DialogInterface.OnClickListener a(Context paramContext, String paramString1, String paramString2)
  {
    return new -..Lambda.KaShareInterceptor.kstx4kM7GgW6OHoHEqdalHQ-rMs(paramString1, paramString2, paramContext);
  }
  
  private static void a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    DialogUtil.a(paramContext, 230, QQUIDelegate.a(2131890619), QQUIDelegate.a(2131890618), QQUIDelegate.a(2131890616), paramContext.getString(2131890617), paramOnClickListener1, paramOnClickListener2).show();
  }
  
  public static boolean a(Context paramContext, IGProGuildInfo paramIGProGuildInfo)
  {
    QQGuildShareConfigBean localQQGuildShareConfigBean = QQGuildShareConfigBean.d();
    if (!a(localQQGuildShareConfigBean)) {
      return false;
    }
    if (!a(paramIGProGuildInfo)) {
      return true;
    }
    a(paramContext, a(paramContext, localQQGuildShareConfigBean.b(), paramIGProGuildInfo.getGuildID()), -..Lambda.KaShareInterceptor.18r5-OdTiKhWBEx7jDqNryfcrv4.INSTANCE);
    return true;
  }
  
  private static boolean a(QQGuildShareConfigBean paramQQGuildShareConfigBean)
  {
    int i;
    if (QQGuildGrayUserTypeConfig.a().b() == 2) {
      i = 1;
    } else {
      i = 0;
    }
    return (i != 0) && (paramQQGuildShareConfigBean.a());
  }
  
  private static boolean a(IGProGuildInfo paramIGProGuildInfo)
  {
    String str = ((IGPSService)QQGuildUtil.b(IGPSService.class)).getSelfTinyId();
    paramIGProGuildInfo = paramIGProGuildInfo.getCreatorId();
    if (!TextUtils.equals(str, paramIGProGuildInfo))
    {
      QLog.d("KaShareInterceptor", 1, new Object[] { "TinyId ", str, " != CreatorId ", paramIGProGuildInfo });
      QQGuildUtil.a(QQGuildUtil.h(), -202, "暂时不可分享该频道");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.share.KaShareInterceptor
 * JD-Core Version:    0.7.0.1
 */