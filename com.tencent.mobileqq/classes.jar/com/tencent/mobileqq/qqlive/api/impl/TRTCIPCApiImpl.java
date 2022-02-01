package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qqlive.api.ITRTCIPCApi;
import com.tencent.mobileqq.qqlive.trtc.ipc.TRTCServerIPCModule;

public class TRTCIPCApiImpl
  implements ITRTCIPCApi
{
  public QIPCModule getServerIPCModule()
  {
    return TRTCServerIPCModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.TRTCIPCApiImpl
 * JD-Core Version:    0.7.0.1
 */