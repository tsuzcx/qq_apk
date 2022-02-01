package com.tencent.mobileqq.uftransfer.task;

import android.os.Bundle;
import com.tencent.mobileqq.uftransfer.UFTLogicThread;
import com.tencent.mobileqq.uftransfer.api.impl.UFTTransferKey;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import com.tencent.mobileqq.uftransfer.task.taskinfo.UFTBaseTaskInfo;
import mqq.app.AppRuntime;

public abstract class UFTBaseTask
{
  protected final UFTTransferKey a;
  private final IUFTTaskCallback a;
  protected final UFTBaseTaskInfo a;
  protected final AppRuntime a;
  protected boolean a;
  
  protected UFTBaseTask(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTBaseTaskInfo paramUFTBaseTaskInfo, IUFTTaskCallback paramIUFTTaskCallback)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqUftransferApiImplUFTTransferKey = paramUFTTransferKey;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo = paramUFTBaseTaskInfo;
    this.jdField_a_of_type_ComTencentMobileqqUftransferTaskIUFTTaskCallback = paramIUFTTaskCallback;
  }
  
  public static boolean a(AppRuntime paramAppRuntime, UFTTransferKey paramUFTTransferKey, UFTBaseTaskInfo paramUFTBaseTaskInfo, IUFTTaskCallback paramIUFTTaskCallback, String paramString)
  {
    if (paramAppRuntime == null)
    {
      UFTLog.d(paramString, 1, "task.app is null");
      return false;
    }
    if (paramUFTTransferKey == null)
    {
      UFTLog.d(paramString, 1, "task.transfer key is null");
      return false;
    }
    if (paramUFTBaseTaskInfo == null)
    {
      UFTLog.d(paramString, 1, "task.task info is null");
      return false;
    }
    if (paramIUFTTaskCallback == null)
    {
      UFTLog.d(paramString, 1, "task.task callback is null");
      return false;
    }
    return true;
  }
  
  public long a()
  {
    UFTBaseTaskInfo localUFTBaseTaskInfo = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    if (localUFTBaseTaskInfo != null) {
      return localUFTBaseTaskInfo.a();
    }
    return 0L;
  }
  
  protected UFTBaseTask a()
  {
    return this;
  }
  
  protected final void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    b(3);
    UFTLogicThread.a().b(new UFTBaseTask.1(this, paramInt));
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = true;
    b(3);
  }
  
  public abstract boolean a(UFTBaseTask paramUFTBaseTask);
  
  public void b(int paramInt)
  {
    UFTBaseTaskInfo localUFTBaseTaskInfo = this.jdField_a_of_type_ComTencentMobileqqUftransferTaskTaskinfoUFTBaseTaskInfo;
    if (localUFTBaseTaskInfo != null) {
      localUFTBaseTaskInfo.a(paramInt);
    }
  }
  
  public boolean b()
  {
    this.jdField_a_of_type_Boolean = false;
    b(2);
    return c();
  }
  
  protected abstract boolean c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.task.UFTBaseTask
 * JD-Core Version:    0.7.0.1
 */