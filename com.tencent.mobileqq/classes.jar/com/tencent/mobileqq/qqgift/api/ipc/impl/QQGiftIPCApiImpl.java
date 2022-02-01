package com.tencent.mobileqq.qqgift.api.ipc.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqgift.api.ipc.IQQGiftIPCApi;
import com.tencent.mobileqq.qqgift.ipc.QQGiftServerIPCModule;

public class QQGiftIPCApiImpl
  implements IQQGiftIPCApi
{
  public QIPCModule getServerIPCModule()
  {
    return QQGiftServerIPCModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.api.ipc.impl.QQGiftIPCApiImpl
 * JD-Core Version:    0.7.0.1
 */