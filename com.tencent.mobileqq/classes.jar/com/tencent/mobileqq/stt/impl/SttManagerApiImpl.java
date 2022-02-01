package com.tencent.mobileqq.stt.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.PttConstants;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.PttAutoChangeBean;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.vas.api.IVasSingedApi;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipAutoPttProcessor;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vip.IVipStatusManager;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class SttManagerApiImpl
  implements ISttManagerApi
{
  public static final int ABILITY_ENABLE = 1;
  private static final String KEY_ABILITY = "k_ability_";
  private static final String KEY_ABILITY_101 = "k_ability_101";
  private static final String KEY_CONFIG_VERSION = "k_c_v";
  private static final String PREF_STT = "rich_status";
  public static final String PTT_TAG = "vip_ptt.";
  public static final String TAG = "SttManagerApiImpl.";
  private static int sAbility = -1;
  private int mAbilityV2 = -1;
  
  private boolean getSttAbilityV2(AppRuntime paramAppRuntime)
  {
    int i = this.mAbilityV2;
    boolean bool = false;
    if (i == -1)
    {
      SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("rich_status", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("k_ability_101");
      localStringBuilder.append(paramAppRuntime.getAccount());
      this.mAbilityV2 = localSharedPreferences.getInt(localStringBuilder.toString(), 1);
    }
    if (this.mAbilityV2 == 1) {
      bool = true;
    }
    return bool;
  }
  
  public int getConfigVersion(AppRuntime paramAppRuntime)
  {
    MobileQQ localMobileQQ = paramAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rich_status");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    return localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).getInt("k_c_v", 0);
  }
  
  public boolean getSttAbility(AppRuntime paramAppRuntime)
  {
    if (sAbility < 0)
    {
      SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("rich_status", 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("k_ability_");
      localStringBuilder.append(paramAppRuntime.getAccount());
      sAbility = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
    }
    if (sAbility == 1) {
      return true;
    }
    return getSttAbilityV2(paramAppRuntime);
  }
  
  public void initAutoToTextSwitch(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    Object localObject1 = paramAppRuntime.getCurrentUin();
    if (!TextUtils.equals(PttConstants.jdField_a_of_type_JavaLangString, (CharSequence)localObject1))
    {
      PttConstants.jdField_a_of_type_JavaLangString = (String)localObject1;
      PttConstants.g = false;
      QLog.e("vip_ptt.SttManagerApiImpl.", 1, "it have change the account so init ptt state value");
    }
    if (!PttConstants.g)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("businessinfo_ptt_auto_change_text_");
      ((StringBuilder)localObject1).append(paramAppRuntime.getCurrentAccountUin());
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("businessinfo_ptt_auto_change_time_");
      ((StringBuilder)localObject2).append(paramAppRuntime.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("businessinfo_ptt_auto_change_guide_has_show_");
      ((StringBuilder)localObject3).append(paramAppRuntime.getCurrentAccountUin());
      localObject3 = ((StringBuilder)localObject3).toString();
      SharedPreferences localSharedPreferences = paramAppRuntime.getApplication().getSharedPreferences("check_update_sp_key", 0);
      PttAutoChangeBean localPttAutoChangeBean = (PttAutoChangeBean)QConfigManager.a().a(442);
      QVipAutoPttConfig localQVipAutoPttConfig = QVipAutoPttProcessor.c();
      boolean bool2 = VasUtil.a(paramAppRuntime).getVipStatus().isSVip();
      boolean bool1;
      if (localQVipAutoPttConfig.a > 1) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("ignore initAutoToTextSwitch is svip=");
      paramAppRuntime.append(bool2);
      paramAppRuntime.append(" stage=");
      paramAppRuntime.append(localQVipAutoPttConfig.a);
      QLog.e("vip_ptt.SttManagerApiImpl.", 1, paramAppRuntime.toString());
      if (((localPttAutoChangeBean != null) && (!localPttAutoChangeBean.a())) || (bool1))
      {
        paramAppRuntime = localSharedPreferences.edit();
        paramAppRuntime.putBoolean((String)localObject1, false);
        paramAppRuntime.apply();
        PttConstants.c = false;
      }
      else
      {
        PttConstants.c = localSharedPreferences.getBoolean((String)localObject1, false);
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("initAutoToTextSwitch enable=");
        paramAppRuntime.append(PttConstants.c);
        QLog.e("vip_ptt.SttManagerApiImpl.", 1, paramAppRuntime.toString());
      }
      PttConstants.jdField_a_of_type_Long = localSharedPreferences.getLong((String)localObject2, 9223372036854775807L);
      PttConstants.d = localSharedPreferences.getBoolean((String)localObject3, false);
      PttConstants.g = true;
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("initAutoToTextSwitch switch:");
        paramAppRuntime.append(PttConstants.c);
        paramAppRuntime.append(", time:");
        paramAppRuntime.append(PttConstants.jdField_a_of_type_Long);
        paramAppRuntime.append(", hasAddTips:");
        paramAppRuntime.append(PttConstants.d);
        QLog.i("SttManagerApiImpl.", 2, paramAppRuntime.toString());
      }
    }
  }
  
  public boolean isSttSession(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 3000) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public void resetSttAbility()
  {
    sAbility = -1;
  }
  
  public void saveConfigVersion(AppRuntime paramAppRuntime, int paramInt)
  {
    MobileQQ localMobileQQ = paramAppRuntime.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("rich_status");
    localStringBuilder.append(paramAppRuntime.getCurrentUin());
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("k_c_v", paramInt).commit();
  }
  
  public void saveSttAbilityV2Config(int paramInt, AppRuntime paramAppRuntime)
  {
    this.mAbilityV2 = paramInt;
    Object localObject = paramAppRuntime.getApplication().getSharedPreferences("rich_status", 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("k_ability_101");
    localStringBuilder.append(paramAppRuntime.getAccount());
    ((SharedPreferences.Editor)localObject).putInt(localStringBuilder.toString(), paramInt).apply();
    try
    {
      paramAppRuntime = StatisticCollector.getInstance(BaseApplication.getContext());
      localObject = new HashMap();
      ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
      ((HashMap)localObject).put("param_FailCode", String.valueOf(paramInt));
      ((HashMap)localObject).put("appversion", "8.7.0");
      paramAppRuntime.collectPerformance("", "PttSttEntryChange", false, 0L, 0L, (HashMap)localObject, "");
      return;
    }
    catch (Exception paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public boolean setSttAbility(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stt.impl.SttManagerApiImpl
 * JD-Core Version:    0.7.0.1
 */