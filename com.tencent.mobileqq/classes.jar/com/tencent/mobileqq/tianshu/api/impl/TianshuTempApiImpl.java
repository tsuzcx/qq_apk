package com.tencent.mobileqq.tianshu.api.impl;

import com.tencent.mobileqq.tianshu.api.ITianshuTempApi;
import cooperation.qzone.QUA;

public class TianshuTempApiImpl
  implements ITianshuTempApi
{
  public String getQua()
  {
    return QUA.getQUA3();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.api.impl.TianshuTempApiImpl
 * JD-Core Version:    0.7.0.1
 */