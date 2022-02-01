package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.aladdin.config.QQAladdinUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class ReadInJoyLogicManager
  implements IReadInJoyLogicManager, Manager
{
  private static final String TAG = "ReadInJoyLogicManager";
  private AppInterface app;
  
  public ReadInJoyLogicManager(AppInterface paramAppInterface)
  {
    QLog.i("ReadInJoyLogicManager", 1, "[ReadInJoyLogicManager] constructed.");
    this.app = paramAppInterface;
    initialize();
  }
  
  public ReadInJoyLogicEngine getReadInJoyLogicEngine()
  {
    return ReadInJoyLogicEngine.a();
  }
  
  public void initialize()
  {
    QQAladdinUtils.a();
    ReadInJoyLogicEngine.a().a(this.app);
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    unInitialize();
  }
  
  public void unInitialize()
  {
    ReadInJoyLogicEngine.a().a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager
 * JD-Core Version:    0.7.0.1
 */