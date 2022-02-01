package com.tencent.xaction.trigger.shake;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/trigger/shake/ShakeRecognizer;", "Landroid/hardware/SensorEventListener;", "mContext", "Landroid/content/Context;", "mOnShakeListener", "Lcom/tencent/xaction/trigger/shake/ShakeRecognizer$OnShakeListener;", "(Landroid/content/Context;Lcom/tencent/xaction/trigger/shake/ShakeRecognizer$OnShakeListener;)V", "DEFAULT_SHAKE_SPEED", "", "INTERVAL_TIME", "mAccelerometer", "Landroid/hardware/Sensor;", "mLastUpdateTime", "", "mLastX", "", "mLastY", "mLastZ", "mSensorManager", "Landroid/hardware/SensorManager;", "mSpeedThreshold", "finalize", "", "onAccuracyChanged", "sensor", "accuracy", "onSensorChanged", "event", "Landroid/hardware/SensorEvent;", "register", "setOnShakeListener", "listener", "unregister", "OnShakeListener", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ShakeRecognizer
  implements SensorEventListener
{
  private SensorManager a;
  private Sensor b;
  private final int c;
  private final int d;
  private final int e;
  private float f;
  private float g;
  private float h;
  private long i;
  private ShakeRecognizer.OnShakeListener j;
  
  public ShakeRecognizer(@NotNull Context paramContext, @NotNull ShakeRecognizer.OnShakeListener paramOnShakeListener)
  {
    this.j = paramOnShakeListener;
    this.c = 100;
    this.d = 2000;
    this.e = this.d;
    paramContext = paramContext.getSystemService("sensor");
    if (paramContext != null)
    {
      this.a = ((SensorManager)paramContext);
      paramContext = this.a;
      if (paramContext == null) {
        Intrinsics.throwNpe();
      }
      this.b = paramContext.getDefaultSensor(1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.hardware.SensorManager");
  }
  
  public final void a()
  {
    SensorManager localSensorManager = this.a;
    if (localSensorManager == null) {
      Intrinsics.throwNpe();
    }
    localSensorManager.registerListener((SensorEventListener)this, this.b, 3);
  }
  
  public final void b()
  {
    SensorManager localSensorManager = this.a;
    if (localSensorManager == null) {
      Intrinsics.throwNpe();
    }
    localSensorManager.unregisterListener((SensorEventListener)this);
  }
  
  protected final void finalize()
  {
    b();
  }
  
  public void onAccuracyChanged(@Nullable Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(@Nullable SensorEvent paramSensorEvent)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.i;
    if (l2 < this.c) {
      return;
    }
    this.i = l1;
    if (paramSensorEvent == null) {
      Intrinsics.throwNpe();
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    float f4 = f1 - this.f;
    float f5 = f2 - this.g;
    float f6 = f3 - this.h;
    this.f = f1;
    this.g = f2;
    this.h = f3;
    double d1 = f4 * f4 + f5 * f5;
    double d2 = f6 * f6;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 = Math.sqrt(d1 + d2);
    d2 = l2;
    Double.isNaN(d2);
    d1 /= d2;
    d2 = 10000;
    Double.isNaN(d2);
    if (d1 * d2 >= this.e) {
      this.j.onShake();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.trigger.shake.ShakeRecognizer
 * JD-Core Version:    0.7.0.1
 */