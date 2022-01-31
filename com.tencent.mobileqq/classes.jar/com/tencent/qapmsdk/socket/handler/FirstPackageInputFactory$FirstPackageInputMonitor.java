package com.tencent.qapmsdk.socket.handler;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.qapmsdk.socket.model.SocketInfo;

class FirstPackageInputFactory$FirstPackageInputMonitor
  implements ITrafficInputStreamHandler
{
  private FirstPackageInputFactory$FirstPackageInputMonitor(FirstPackageInputFactory paramFirstPackageInputFactory) {}
  
  public void onClose() {}
  
  public void onInput(@NonNull byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, @Nullable SocketInfo paramSocketInfo)
  {
    paramSocketInfo.readStamp(SystemClock.elapsedRealtime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.handler.FirstPackageInputFactory.FirstPackageInputMonitor
 * JD-Core Version:    0.7.0.1
 */