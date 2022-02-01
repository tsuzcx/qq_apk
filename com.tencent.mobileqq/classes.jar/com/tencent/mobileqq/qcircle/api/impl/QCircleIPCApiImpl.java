package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import cooperation.qqcircle.ipc.QCircleIPCModule;

public class QCircleIPCApiImpl
  implements IQCircleIPCApi
{
  public QIPCModule getIPCModule()
  {
    return QCircleIPCModule.getInstance();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleIPCApiImpl
 * JD-Core Version:    0.7.0.1
 */