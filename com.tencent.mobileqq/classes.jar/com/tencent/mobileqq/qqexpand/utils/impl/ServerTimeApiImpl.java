package com.tencent.mobileqq.qqexpand.utils.impl;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qqexpand.utils.IServerTimeApi;

public class ServerTimeApiImpl
  implements IServerTimeApi
{
  public long getServerTime()
  {
    return NetConnInfoCenter.getServerTime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.impl.ServerTimeApiImpl
 * JD-Core Version:    0.7.0.1
 */