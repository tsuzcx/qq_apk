package com.tencent.mobileqq.qcircle.api.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.MobileQQ;

public class QCircleHostConfig
{
  private static final String TAG = "QCircleHostConfig";
  
  public static boolean checkOpmask(long paramLong, int paramInt)
  {
    return (paramLong & 1 << paramInt) != 0L;
  }
  
  public static boolean getEnablePeriodCollect()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getBoolean("qcircle_need_period_collect", false);
    }
    return false;
  }
  
  public static long getGetFollowUserTime()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong("sp_last_getfollowuser_time", 0L);
    }
    return 0L;
  }
  
  public static long getPushFuleCountTime()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong("qcircle_fule_count_push_time", 0L);
    }
    return 0L;
  }
  
  public static SharedPreferences getQCircleSp()
  {
    String str = ((IAccountRuntime)QRoute.api(IAccountRuntime.class)).getAccount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_qqcirlce_business");
    localStringBuilder.append(str);
    str = localStringBuilder.toString();
    return MobileQQ.sMobileQQ.getSharedPreferences(str, 0);
  }
  
  public static long getRelationGroupLoadTime()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong("key_qcircle_relation_group_time", 0L);
    }
    return 0L;
  }
  
  public static long getRelationLoadTimeInterval()
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      return localSharedPreferences.getLong("key_qcircle_relation_time_interval", 0L);
    }
    return 0L;
  }
  
  public static int isNeedShowLebaQCircleEnterGuideNew()
  {
    Object localObject = getQCircleSp();
    int i = -1;
    if (localObject != null) {
      i = ((SharedPreferences)localObject).getInt("qcircle_show_leba_qcircle_enter_guide_new", -1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowMessageEntranceTips: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QCircleHostConfig", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public static int isNeedShowLebaTabGuideNew()
  {
    Object localObject = getQCircleSp();
    int i = -1;
    if (localObject != null) {
      i = ((SharedPreferences)localObject).getInt("qcircle_show_lebatab_guide_new", -1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowMessageEntranceTips: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QCircleHostConfig", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public static int isNeedShowMessageEntranceAnim()
  {
    Object localObject = getQCircleSp();
    int i = -1;
    if (localObject != null) {
      i = ((SharedPreferences)localObject).getInt("qcircle_show_message_enter_guide_anim", -1);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isNeedShowMessageEntranceTips: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("QCircleHostConfig", 1, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public static void saveEnablePeriodCollect(boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putBoolean("qcircle_need_period_collect", paramBoolean).apply();
    }
  }
  
  public static void saveGetFollowUserTime(long paramLong)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("sp_last_getfollowuser_time", paramLong).apply();
    }
  }
  
  public static void savePushFuleCountTime(long paramLong)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("qcircle_fule_count_push_time", paramLong).apply();
    }
  }
  
  public static void setNeedShowLebaQCircleEntranceGuideNew(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void setNeedShowLebaTabGuideNew(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void setNeedShowMessageEntranceAnim(boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static void setRelationGroupTime(long paramLong)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("key_qcircle_relation_group_time", paramLong).apply();
    }
  }
  
  public static void setRelationGroupTimeInterval(long paramLong)
  {
    SharedPreferences localSharedPreferences = getQCircleSp();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong("key_qcircle_relation_time_interval", paramLong).apply();
    }
  }
  
  public static void updateGuideWnsConfig(String paramString1, String paramString2)
  {
    QzoneConfig.getInstance().updateOneConfig("qqcircle", paramString1, paramString2);
    Object localObject = new HashMap();
    ((HashMap)localObject).put(paramString1, paramString2);
    HashMap localHashMap = new HashMap();
    localHashMap.put("qqcircle", localObject);
    localObject = new QCircleSetMultiCircleWnsConfigRequest(localHashMap);
    VSNetworkHelper.getInstance().sendRequest((BaseRequest)localObject, new QCircleHostConfig.1(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.utils.QCircleHostConfig
 * JD-Core Version:    0.7.0.1
 */