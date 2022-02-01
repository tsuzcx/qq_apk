package com.tencent.mobileqq.guild.audio;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class AudioRouter
{
  private static final String a = "AudioRouter";
  private HandlerThread b;
  private Handler c;
  private final AudioRouter.AudioRouterChangeListener d;
  private volatile int e = -1;
  private volatile int f = -1;
  private final BroadcastReceiver g = new AudioRouter.3(this);
  
  public AudioRouter(AudioRouter.AudioRouterChangeListener paramAudioRouterChangeListener)
  {
    this.d = paramAudioRouterChangeListener;
  }
  
  public static int b(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    return i;
  }
  
  private void c(int paramInt)
  {
    QLog.d(a, 1, String.format("onDeviceConnect route=%s isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(e()), Boolean.valueOf(f()) }));
    if ((this.e != 2) && (this.e != 3)) {
      this.f = this.e;
    }
    e(paramInt);
  }
  
  private void d()
  {
    if (e())
    {
      e(3);
      return;
    }
    if (f())
    {
      e(2);
      return;
    }
    e(1);
  }
  
  private void d(int paramInt)
  {
    QLog.d(a, 1, String.format("onDeviceLoss device=%s isHeadsetPlugged=%s isBluetoothOn=%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(e()), Boolean.valueOf(f()) }));
    if (this.f != -1)
    {
      e(this.f);
      AudioRoom.b().a(this.f);
      this.f = -1;
      return;
    }
    if ((paramInt != 3) && (e()))
    {
      e(3);
      return;
    }
    if ((paramInt != 2) && (f()))
    {
      e(2);
      return;
    }
    if (paramInt != 1)
    {
      e(1);
      AudioRoom.b().a(1);
    }
  }
  
  private void e(int paramInt)
  {
    this.e = paramInt;
    f(paramInt);
  }
  
  private boolean e()
  {
    return ((AudioManager)BaseApplication.getContext().getSystemService("audio")).isWiredHeadsetOn();
  }
  
  private void f(int paramInt)
  {
    AudioRouter.AudioRouterChangeListener localAudioRouterChangeListener = this.d;
    if (localAudioRouterChangeListener != null) {
      localAudioRouterChangeListener.b(paramInt);
    }
  }
  
  private boolean f()
  {
    Object localObject = BluetoothAdapter.getDefaultAdapter();
    boolean bool2 = ((BluetoothAdapter)localObject).isEnabled();
    boolean bool1 = true;
    if (bool2)
    {
      i = ((BluetoothAdapter)localObject).getProfileConnectionState(2);
      int j = ((BluetoothAdapter)localObject).getProfileConnectionState(1);
      int k = ((BluetoothAdapter)localObject).getProfileConnectionState(3);
      if (i == 2) {
        break label71;
      }
      if (j == 2)
      {
        i = j;
        break label71;
      }
      if (k == 2)
      {
        i = k;
        break label71;
      }
    }
    int i = -1;
    label71:
    localObject = (AudioManager)BaseApplication.getContext().getSystemService("audio");
    if (i == -1)
    {
      if (((AudioManager)localObject).isBluetoothA2dpOn()) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public void a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
    localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
    BaseApplication.getContext().registerReceiver(this.g, localIntentFilter);
    this.b = new HandlerThread(a);
    this.b.start();
    this.c = new Handler(this.b.getLooper());
    this.c.post(new AudioRouter.1(this));
  }
  
  public void a(int paramInt)
  {
    this.c.post(new AudioRouter.2(this, paramInt));
  }
  
  public void b()
  {
    this.c.getLooper().quit();
    BaseApplication.getContext().unregisterReceiver(this.g);
    this.e = -1;
    this.f = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.audio.AudioRouter
 * JD-Core Version:    0.7.0.1
 */