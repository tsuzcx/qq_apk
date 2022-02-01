package com.tencent.turingfd.sdk.ams.ga;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class Aquila
  extends Thread
{
  public Aquila(Ara paramAra, AtomicBoolean paramAtomicBoolean, HashMap paramHashMap, ITuringDeviceInfoProvider paramITuringDeviceInfoProvider, long paramLong, Object paramObject) {}
  
  public void run()
  {
    super.run();
    if (this.Ac.get()) {
      return;
    }
    this.Oe.put("260", Ara.h(this.Pe.getImei()));
    this.Oe.put("261", Ara.h(this.Pe.getImsi()));
    this.Oe.put("262", Ara.h(this.Pe.getAndroidId()));
    this.Oe.put("263", Ara.h(this.Pe.getBrand()));
    this.Oe.put("264", Ara.h(this.Pe.getModel()));
    this.Oe.put("265", Ara.h(this.Pe.getKernelVersion()));
    synchronized (this.Cc)
    {
      this.Cc.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Aquila
 * JD-Core Version:    0.7.0.1
 */