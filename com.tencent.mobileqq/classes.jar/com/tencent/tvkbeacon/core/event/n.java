package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.tvkbeacon.core.a.b;
import com.tencent.tvkbeacon.core.c.c;
import java.util.HashMap;
import java.util.Map;

public final class n
  implements SensorEventListener, Runnable
{
  private static Map<Integer, String> f;
  private long a = 0L;
  private m b;
  private int c = 0;
  private long d = 0L;
  private Context e;
  private SensorManager g;
  
  static
  {
    HashMap localHashMap = new HashMap();
    f = localHashMap;
    localHashMap.put(Integer.valueOf(1), "A126");
    f.put(Integer.valueOf(4), "A127");
    f.put(Integer.valueOf(2), "A128");
  }
  
  public static void a()
  {
    b.d().a(111, true);
    c.a("[sensor] cancel next record", new Object[0]);
  }
  
  public final void a(Context paramContext)
  {
    if (!EventStrategyBean.getInstance().isSensorEnable()) {
      return;
    }
    this.e = paramContext;
    int i = EventStrategyBean.getInstance().getConsuming();
    c.a("[sensor] startEvent consuming : %d", new Object[] { Integer.valueOf(i) });
    this.d = EventStrategyBean.getInstance().getGatherDur();
    b.d().a(111, this, 10000L, i * 1000);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.c <= 0)
    {
      this.b = null;
      c.a("[sensor] unregisterSensorListener", new Object[0]);
      if (this.g != null) {
        this.g.unregisterListener(this);
      }
      return;
    }
    if ((System.currentTimeMillis() - this.a >= this.d) && (this.b != null))
    {
      m localm = this.b;
      b.d().a(localm);
      this.a = System.currentTimeMillis();
      this.b = null;
      this.c -= 1;
      c.a("[sensor] report sensor event and %d times left ", new Object[] { Integer.valueOf(this.c) });
    }
    if (this.b == null) {
      this.b = new m();
    }
    this.b.a((String)f.get(Integer.valueOf(paramSensorEvent.sensor.getType())), paramSensorEvent.values);
  }
  
  public final void run()
  {
    this.g = ((SensorManager)this.e.getSystemService("sensor"));
    if (this.g != null)
    {
      EventStrategyBean localEventStrategyBean = EventStrategyBean.getInstance();
      int i = 1000000 / localEventStrategyBean.getHertzCount();
      if (localEventStrategyBean.isAcceleEnable())
      {
        c.a("[sensor] AcceleEnable", new Object[0]);
        this.g.registerListener(this, this.g.getDefaultSensor(1), i);
      }
      if (localEventStrategyBean.isGyroEnable())
      {
        c.a("[sensor] GyroEnable", new Object[0]);
        this.g.registerListener(this, this.g.getDefaultSensor(4), i);
      }
      if (localEventStrategyBean.isMagneticEnable())
      {
        c.a("[sensor] MagneticEnable", new Object[0]);
        this.g.registerListener(this, this.g.getDefaultSensor(2), i);
      }
    }
    this.a = System.currentTimeMillis();
    this.c = EventStrategyBean.getInstance().getGatherCount();
    c.a("[sensor] start a record", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.n
 * JD-Core Version:    0.7.0.1
 */