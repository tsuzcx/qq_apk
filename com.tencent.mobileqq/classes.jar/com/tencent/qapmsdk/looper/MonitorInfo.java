package com.tencent.qapmsdk.looper;

import android.support.annotation.Nullable;

class MonitorInfo
{
  volatile long cacheRealStackTime = 0L;
  IMonitorCallback callback;
  volatile long lastGetStackTimeStamp = 0L;
  volatile long lastStackRequestTime = 0L;
  @Nullable
  volatile String stack = null;
  @Nullable
  volatile GetStackRunnable stackGetter = null;
  boolean stackGetterInited = false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.looper.MonitorInfo
 * JD-Core Version:    0.7.0.1
 */