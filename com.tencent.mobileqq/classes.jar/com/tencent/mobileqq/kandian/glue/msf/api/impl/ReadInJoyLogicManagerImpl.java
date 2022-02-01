package com.tencent.mobileqq.kandian.glue.msf.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/impl/ReadInJoyLogicManagerImpl;", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManager;", "()V", "manager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/ReadInJoyLogicManager;", "getReadInJoyLogicEngine", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngine;", "initialize", "", "onCreate", "appRuntime", "Lmqq/app/AppRuntime;", "onDestroy", "unInitialize", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyLogicManagerImpl
  implements IReadInJoyLogicManager
{
  private ReadInJoyLogicManager manager;
  
  @Nullable
  public IReadInJoyLogicEngine getReadInJoyLogicEngine()
  {
    Object localObject = this.manager;
    if (localObject != null) {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
    } else {
      localObject = null;
    }
    return (IReadInJoyLogicEngine)localObject;
  }
  
  public void initialize()
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = this.manager;
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.initialize();
    }
  }
  
  public void onCreate(@Nullable AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      paramAppRuntime = paramAppRuntime.getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    } else {
      paramAppRuntime = null;
    }
    AppRuntime localAppRuntime = paramAppRuntime;
    if (!(paramAppRuntime instanceof ReadInJoyLogicManager)) {
      localAppRuntime = null;
    }
    this.manager = ((ReadInJoyLogicManager)localAppRuntime);
  }
  
  public void onDestroy() {}
  
  public void unInitialize()
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = this.manager;
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.unInitialize();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.impl.ReadInJoyLogicManagerImpl
 * JD-Core Version:    0.7.0.1
 */