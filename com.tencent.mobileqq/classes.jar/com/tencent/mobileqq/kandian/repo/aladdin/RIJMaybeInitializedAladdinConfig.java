package com.tencent.mobileqq.kandian.repo.aladdin;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.Aladdin.InitParams;
import com.tencent.aladdin.config.Aladdin.InitParams.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.config.AchillesParams;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinLogger;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinRequestHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAsyncTaskExecutor;
import com.tencent.qphone.base.util.QLog;

public class RIJMaybeInitializedAladdinConfig
{
  private static boolean a = false;
  
  public static void a()
  {
    if (!a)
    {
      Aladdin.InitParams.Builder localBuilder = Aladdin.InitParams.newBuilder().withUserId(RIJQQAppInterfaceUtil.a()).withAppVersion("8.7.0").withContext(BaseApplicationImpl.getContext()).withExecutor(QQAsyncTaskExecutor.a).withRequestHandler(new QQAladdinRequestHandler()).withLogger(new QQAladdinLogger());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppSetting.a());
      localStringBuilder.append("");
      Aladdin.initialize(localBuilder.withAppFlavorId(localStringBuilder.toString()).build());
      Aladdin.registerBeanClass("AchillesParams", AchillesParams.class);
      Aladdin.registerConfigParser(140, Aladdin.DEFAULT_SIMPLE_OBJECT_PARSER);
      a = true;
    }
  }
  
  public static void b()
  {
    Boolean localBoolean = (Boolean)RIJSPUtils.a("should_request_aladdin_config", Boolean.valueOf(true));
    QLog.i("RIJMaybeInitializedAladdinConfig", 1, "[maybeGetAllConfigs] shouldRequest=$shouldRequest");
    if (localBoolean.booleanValue()) {
      QQAladdinUtils.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig
 * JD-Core Version:    0.7.0.1
 */