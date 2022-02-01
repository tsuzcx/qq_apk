package com.tencent.mobileqq.transfile.quic.internal;

import com.tencent.mobileqq.transfile.quic.open.ILoadSoCallback;

final class LoadSoImp$1
  implements Runnable
{
  LoadSoImp$1(ILoadSoCallback paramILoadSoCallback) {}
  
  public void run()
  {
    boolean bool = LoadSoImp.access$000();
    this.val$callback.onLoad(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.quic.internal.LoadSoImp.1
 * JD-Core Version:    0.7.0.1
 */