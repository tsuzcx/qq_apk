package com.tencent.mobileqq.qqlive.api.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ipc.IQQLiveSdkIPCServerApi;
import com.tencent.mobileqq.qqlive.ipc.QQLiveSdkIPCServerModule;
import com.tencent.qphone.base.util.QLog;

public class QQLiveSdkIPCServerApiImpl
  implements IQQLiveSdkIPCServerApi
{
  private static final String TAG = "QQLive_IPC_API";
  
  public QIPCModule getServerIPCModule()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLive_IPC_API", 1, "init");
    }
    return QQLiveSdkIPCServerModule.INSTANCE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.ipc.impl.QQLiveSdkIPCServerApiImpl
 * JD-Core Version:    0.7.0.1
 */