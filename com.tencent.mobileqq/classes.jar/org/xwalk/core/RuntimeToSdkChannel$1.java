package org.xwalk.core;

import android.webkit.ValueCallback;

final class RuntimeToSdkChannel$1
  implements ValueCallback
{
  public void onReceiveValue(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof Object[])) {
        return;
      }
      paramObject = (Object[])paramObject;
      if (paramObject.length < 3) {
        return;
      }
      if (!(paramObject[0] instanceof String)) {
        return;
      }
      paramObject[2] = RuntimeToSdkChannel.onRuntimeCalled((String)paramObject[0], paramObject[1]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.RuntimeToSdkChannel.1
 * JD-Core Version:    0.7.0.1
 */