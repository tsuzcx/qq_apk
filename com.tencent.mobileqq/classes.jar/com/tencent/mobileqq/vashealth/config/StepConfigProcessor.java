package com.tencent.mobileqq.vashealth.config;

import android.content.Context;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.vashealth.StepCounterServlert;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vashealth/config/StepConfigProcessor;", "Lcom/tencent/mobileqq/config/IQConfigProcessor;", "Lcom/tencent/mobileqq/vashealth/config/StepConfigBean;", "()V", "clazz", "Ljava/lang/Class;", "isAccountRelated", "", "isNeedCompressed", "isNeedStoreLargeFile", "isNeedUpgradeReset", "migrateOldOrDefaultContent", "type", "", "migrateOldVersion", "onParsed", "confFiles", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/vashealth/config/StepConfigBean;", "onReqFailed", "", "failCode", "onUpdate", "newConf", "Companion", "health-impl_release"}, k=1, mv={1, 1, 16})
public final class StepConfigProcessor
  extends IQConfigProcessor<StepConfigBean>
{
  public static final StepConfigProcessor.Companion a = new StepConfigProcessor.Companion(null);
  
  @JvmStatic
  @NotNull
  public static final StepConfigBean a()
  {
    return a.a();
  }
  
  @NotNull
  public StepConfigBean a(int paramInt)
  {
    return new StepConfigBean(0, 0, 0, 0, 0, 31, null);
  }
  
  @Nullable
  public StepConfigBean a(@Nullable QConfItem[] paramArrayOfQConfItem)
  {
    if (paramArrayOfQConfItem != null)
    {
      paramArrayOfQConfItem = (QConfItem)ArraysKt.firstOrNull(paramArrayOfQConfItem);
      if (paramArrayOfQConfItem != null)
      {
        paramArrayOfQConfItem = paramArrayOfQConfItem.b;
        if (paramArrayOfQConfItem != null) {
          return StepConfigBean.a.a(paramArrayOfQConfItem);
        }
      }
    }
    return null;
  }
  
  public void a(@Nullable StepConfigBean paramStepConfigBean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdate newConf:");
      ((StringBuilder)localObject).append(paramStepConfigBean);
      QLog.d("StepConfigProcessor", 2, ((StringBuilder)localObject).toString());
    }
    paramStepConfigBean = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(paramStepConfigBean, "app");
    Object localObject = new NewIntent((Context)paramStepConfigBean.getApplication(), StepCounterServlert.class);
    ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_step_update_config");
    paramStepConfigBean.startServlet((NewIntent)localObject);
  }
  
  @NotNull
  public Class<StepConfigBean> clazz()
  {
    return StepConfigBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode:");
    localStringBuilder.append(paramInt);
    QLog.w("StepConfigProcessor", 2, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 738;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.config.StepConfigProcessor
 * JD-Core Version:    0.7.0.1
 */