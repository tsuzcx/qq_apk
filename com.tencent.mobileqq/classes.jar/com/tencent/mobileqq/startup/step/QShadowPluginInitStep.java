package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import com.tencent.shadow.dynamic.host.QShadowMultiLoaderPluginProcessService;

public class QShadowPluginInitStep
  extends Step
{
  protected boolean doStep()
  {
    BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(QShadowMultiLoaderPluginProcessService.getActivityHolder());
    DynamicRuntime.recoveryRuntime(BaseApplicationImpl.getContext());
    new InitMemoryCache().step();
    QLog.d("QShadowPluginInitStep", 2, "doStep run");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.QShadowPluginInitStep
 * JD-Core Version:    0.7.0.1
 */