package com.tencent.mobileqq.security;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.security.business.ModifyPwdTopBarHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class ModifyPwdTopBarHelper
{
  private static volatile ModifyPwdTopBarHelper a;
  
  public static ModifyPwdTopBarHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ModifyPwdTopBarHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public TipsBar a(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    TipsBar localTipsBar = new TipsBar(paramContext);
    localTipsBar.setVisibility(0);
    localTipsBar.getTextView().setText(b(paramBaseQQAppInterface.getCurrentUin(), "bar_content_string", ""));
    localTipsBar.setTipsIcon(paramContext.getResources().getDrawable(2130839453));
    localTipsBar.setOriginalOnClickListener(new ModifyPwdTopBarHelper.1(this, paramContext, paramBaseQQAppInterface));
    return localTipsBar;
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, long paramLong)
  {
    if ((paramBaseQQAppInterface != null) && (!TextUtils.isEmpty(paramBaseQQAppInterface.getCurrentAccountUin())) && (paramLong > 0L))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).doClearAfterLoginSuccess(false);
      String str1 = paramBaseQQAppInterface.getCurrentAccountUin();
      if (!b(str1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ModifyPwdTopBarHelper", 2, "isModifyPwdBarHelperEnable false");
        }
        return;
      }
      boolean bool1 = b(str1, "key_verify_for_dlg_or_clk", false);
      boolean bool2 = b(str1, "key_show_status", false);
      long l1 = b(str1, "time_dlg_show_or_bar_clk", 0L);
      long l2 = b(str1, "time_fetch_next_time", 0L);
      String str2 = b(str1, "bar_url", "");
      String str3 = b(str1, "bar_content_string", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateBarDisplayInfo verifyForDlgOrClk: ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" showStatus: ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" timeDlgShowOrBarClk: ");
      localStringBuilder.append(l1);
      localStringBuilder.append(" fetchNext: ");
      localStringBuilder.append(l2);
      localStringBuilder.append(" barUrl: ");
      localStringBuilder.append(str2);
      localStringBuilder.append(" contentStr: ");
      localStringBuilder.append(str3);
      localStringBuilder.append(" currentMillis: ");
      localStringBuilder.append(paramLong);
      QLog.d("ModifyPwdTopBarHelper", 1, localStringBuilder.toString());
      if ((bool1) && (paramLong - l1 >= 86400000L) && (paramLong >= l2)) {
        a(paramBaseQQAppInterface, str1);
      }
      a(paramBaseQQAppInterface, bool2);
      return;
    }
    QLog.e("ModifyPwdTopBarHelper", 1, "updateBarDisplayStatus: params error");
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, String paramString)
  {
    if (paramBaseQQAppInterface == null)
    {
      QLog.e("ModifyPwdTopBarHelper", 1, "requestTopBarDisplayInfo error: app == null");
      return;
    }
    ModifyPwdTopBarHandler localModifyPwdTopBarHandler = (ModifyPwdTopBarHandler)paramBaseQQAppInterface.getBusinessHandler(ModifyPwdTopBarHandler.class.getName());
    if (localModifyPwdTopBarHandler == null)
    {
      QLog.e("ModifyPwdTopBarHelper", 1, "requestTopBarDisplayInfo error: handler == null");
      return;
    }
    long l = System.currentTimeMillis();
    HashMap localHashMap = new HashMap();
    paramString = new ModifyPwdTopBarHelper.2(this, l, localHashMap, paramBaseQQAppInterface, paramString);
    localHashMap.put(Long.valueOf(l), paramString);
    paramBaseQQAppInterface.addObserver(paramString);
    localModifyPwdTopBarHandler.a(l);
  }
  
  protected void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ReportController.b(paramBaseQQAppInterface, "dc00898", "", "", "0X800B186", "0X800B186", 0, 0, "", "", "", "");
      BannerManager.a().a(SecureModifyPwdNotifyBannerProcessor.a, 2, null);
      return;
    }
    BannerManager.a().a(SecureModifyPwdNotifyBannerProcessor.a, 0, null);
  }
  
  public void a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cancelVerifyRiskDialog uin: ");
    localStringBuilder.append(paramString);
    QLog.d("ModifyPwdTopBarHelper", 1, localStringBuilder.toString());
    a(paramString, false, false, 0L, 0L);
  }
  
  public void a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAfterPushRiskDialog uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" currentMillis: ");
    localStringBuilder.append(paramLong);
    QLog.d("ModifyPwdTopBarHelper", 1, localStringBuilder.toString());
    c(paramString);
    a(paramString, true, false, paramLong, 0L);
  }
  
  protected void a(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localEditor.putLong(localStringBuilder.toString(), paramLong);
    localEditor.commit();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localEditor.putString(localStringBuilder.toString(), paramString3);
    localEditor.commit();
  }
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  protected void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateConfigData uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" verifyForDlgOrClk: ");
    localStringBuilder.append(paramBoolean1);
    localStringBuilder.append(" showStatus: ");
    localStringBuilder.append(paramBoolean2);
    localStringBuilder.append(" timeDlgShowOrBarClk: ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(" fetchNext: ");
    localStringBuilder.append(paramLong2);
    QLog.d("ModifyPwdTopBarHelper", 1, localStringBuilder.toString());
    a(paramString, "key_verify_for_dlg_or_clk", paramBoolean1);
    a(paramString, "key_show_status", paramBoolean2);
    a(paramString, "time_dlg_show_or_bar_clk", paramLong1);
    a(paramString, "time_fetch_next_time", paramLong2);
  }
  
  protected long b(String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localSharedPreferences.getLong(localStringBuilder.toString(), paramLong);
  }
  
  protected String b(String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localSharedPreferences.getString(localStringBuilder.toString(), paramString3);
  }
  
  protected void b(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("doAfterClickTopBar uin: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" currentMillis: ");
    localStringBuilder.append(paramLong);
    QLog.d("ModifyPwdTopBarHelper", 1, localStringBuilder.toString());
    a(paramString, true, false, paramLong, 0L);
  }
  
  public boolean b(String paramString)
  {
    return b(paramString, "key_risk_top_bar_enable", false);
  }
  
  protected boolean b(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), paramBoolean);
  }
  
  protected void c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setModifyPwdTopBarEnable uin: ");
    localStringBuilder.append(paramString);
    QLog.d("ModifyPwdTopBarHelper", 1, localStringBuilder.toString());
    a(paramString, "key_risk_top_bar_enable", true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.security.ModifyPwdTopBarHelper
 * JD-Core Version:    0.7.0.1
 */