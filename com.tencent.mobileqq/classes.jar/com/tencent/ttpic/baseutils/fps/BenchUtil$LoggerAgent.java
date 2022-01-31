package com.tencent.ttpic.baseutils.fps;

import com.tencent.ttpic.baseutils.log.LogUtils;

public class BenchUtil$LoggerAgent
{
  public void d(String paramString1, String paramString2)
  {
    if (BenchUtil.ENABLE_LOG) {
      LogUtils.d(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.fps.BenchUtil.LoggerAgent
 * JD-Core Version:    0.7.0.1
 */