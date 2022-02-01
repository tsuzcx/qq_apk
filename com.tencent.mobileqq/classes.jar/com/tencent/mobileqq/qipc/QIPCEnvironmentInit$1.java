package com.tencent.mobileqq.qipc;

import eipc.EIPCModule;
import eipc.EIPCModuleFactory;

final class QIPCEnvironmentInit$1
  implements EIPCModuleFactory
{
  public EIPCModule onCreateModule(String paramString)
  {
    return QIPCServerModuleFactory.onCreateModule(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCEnvironmentInit.1
 * JD-Core Version:    0.7.0.1
 */