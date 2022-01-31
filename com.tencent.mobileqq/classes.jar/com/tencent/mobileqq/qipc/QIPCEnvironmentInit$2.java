package com.tencent.mobileqq.qipc;

import eipc.EIPCModule;
import eipc.EIPCModuleFactory;

final class QIPCEnvironmentInit$2
  implements EIPCModuleFactory
{
  public EIPCModule onCreateModule(String paramString)
  {
    return QIPCServerModuleFactory.onCreateModule(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCEnvironmentInit.2
 * JD-Core Version:    0.7.0.1
 */