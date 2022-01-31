package com.tencent.qapmsdk.socket.handler;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.qapmsdk.socket.model.SocketInfo;

class FirstPackageOutputFactory$FirstPackageOutputMonitor
  implements ITrafficOutputStreamHandler
{
  private FirstPackageOutputFactory$FirstPackageOutputMonitor(FirstPackageOutputFactory paramFirstPackageOutputFactory) {}
  
  public void onOutput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, SocketInfo paramSocketInfo)
  {
    paramSocketInfo.writeStamp(SystemClock.elapsedRealtime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.FirstPackageOutputFactory.FirstPackageOutputMonitor
 * JD-Core Version:    0.7.0.1
 */