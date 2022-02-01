package com.tencent.rtmp.sharp.jni;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(11)
class TraeAudioManager$BluetoohHeadsetCheck
  extends TraeAudioManager.BluetoohHeadsetCheckInterface
  implements BluetoothProfile.ServiceListener
{
  BluetoothAdapter _adapter = null;
  Context _ctx = null;
  TraeAudioManager.DeviceConfigManager _devCfg = null;
  BluetoothProfile _profile = null;
  private final ReentrantLock _profileLock = new ReentrantLock();
  
  TraeAudioManager$BluetoohHeadsetCheck(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  void _addAction(IntentFilter paramIntentFilter)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" ");
      localStringBuilder.append(interfaceDesc());
      localStringBuilder.append(" _addAction");
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
    paramIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
  }
  
  void _onReceive(Context arg1, Intent paramIntent)
  {
    int i;
    if ("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 10);
      if (i == 12)
      {
        if (TraeAudioManager.access$000(this.this$0) == 6)
        {
          QLog.w("TraeAudioManager", 2, "bluetoothHeadsetSwitchThread ACTION_AUDIO_STATE_CHANGED +++ Bluetooth audio SCO is now connected, SCO_CONNECTED");
          TraeAudioManager.access$002(this.this$0, 7);
          synchronized (this.this$0._bluetooth_sco_connect)
          {
            this.this$0._bluetooth_sco_connect[0] = true;
            this.this$0._bluetooth_sco_connect.notifyAll();
            return;
          }
        }
      }
      else if (i == 10) {
        this.this$0.checkAutoDeviceListUpdate(true);
      }
    }
    else if ("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", -1);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2) {
            return;
          }
          TraeAudioManager.access$002(this.this$0, 4);
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          QLog.w("TraeAudioManager", 2, "BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_CONNECTED");
          this.this$0.checkAutoDeviceListUpdate(false);
        }
      }
      else
      {
        TraeAudioManager.access$002(this.this$0, 3);
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        QLog.w("TraeAudioManager", 2, "BluetoothHeadset ACTION_CONNECTION_STATE_CHANGED BluetoothProfile.STATE_DISCONNECTED");
      }
    }
    else if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
    {
      i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
      int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
      paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE ");
        ???.append(getBTAdapterConnectionState(i));
        QLog.w("TraeAudioManager", 2, ???.toString());
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("    EXTRA_PREVIOUS_CONNECTION_STATE ");
        ???.append(getBTAdapterConnectionState(j));
        QLog.w("TraeAudioManager", 2, ???.toString());
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("    EXTRA_DEVICE ");
        localStringBuilder.append(paramIntent);
        localStringBuilder.append(" ");
        if (paramIntent != null) {
          ??? = paramIntent.getName();
        } else {
          ??? = " ";
        }
        localStringBuilder.append(???);
        QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
      }
      if (i == 2)
      {
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("   dev:");
          ???.append(paramIntent.getName());
          ???.append(" connected");
          QLog.w("TraeAudioManager", 2, ???.toString());
        }
        if (paramIntent != null) {
          ??? = paramIntent.getName();
        } else {
          ??? = "unkown";
        }
        if (!???.contains("FreeBuds")) {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
        }
        this._devCfg.setBluetoothName(???);
        return;
      }
      if (i == 0) {
        this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
      }
    }
  }
  
  @TargetApi(11)
  public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramContext != null) && (paramDeviceConfigManager != null))
    {
      this._ctx = paramContext;
      this._devCfg = paramDeviceConfigManager;
      this._adapter = BluetoothAdapter.getDefaultAdapter();
      if (this._adapter == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " err getDefaultAdapter fail!");
        }
        return false;
      }
      this._profileLock.lock();
      try
      {
        if ((this._adapter.isEnabled()) && (this._profile == null) && (!this._adapter.getProfileProxy(this._ctx, this, 1)))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
          }
          return false;
        }
        this._profileLock.unlock();
        AudioDeviceInterface.LogTraceExit();
        return true;
      }
      finally
      {
        this._profileLock.unlock();
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("TraeAudioManager", 2, " err ctx==null||_devCfg==null");
    }
    return false;
  }
  
  public String interfaceDesc()
  {
    return "BluetoohHeadsetCheck";
  }
  
  public boolean isConnected()
  {
    this._profileLock.lock();
    try
    {
      Object localObject1 = this._profile;
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        localObject1 = this._profile.getConnectedDevices();
        if (localObject1 == null) {
          return false;
        }
        int i = ((List)localObject1).size();
        bool1 = bool2;
        if (i > 0) {
          bool1 = true;
        }
      }
      return bool1;
    }
    finally
    {
      this._profileLock.unlock();
    }
  }
  
  @TargetApi(11)
  public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("_profile:");
    localStringBuilder1.append(this._profile);
    localStringBuilder1.append(" profile:");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append(" proxy:");
    localStringBuilder1.append(paramBluetoothProfile);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder1.toString());
    if (paramInt == 1) {
      this._profileLock.lock();
    }
    for (;;)
    {
      try
      {
        Object localObject = this._profile;
        localStringBuilder1 = null;
        if ((localObject != null) && (this._profile != paramBluetoothProfile))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("BluetoohHeadsetCheck: HEADSET Connected proxy:");
            ((StringBuilder)localObject).append(paramBluetoothProfile);
            ((StringBuilder)localObject).append(" _profile:");
            ((StringBuilder)localObject).append(this._profile);
            QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
          }
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profile = paramBluetoothProfile;
        if (this._profile == null) {
          break label596;
        }
        paramBluetoothProfile = this._profile.getConnectedDevices();
        if ((paramBluetoothProfile != null) && (this._profile != null))
        {
          if (!QLog.isColorLevel()) {
            break label601;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("TRAEBluetoohProxy: HEADSET Connected devs:");
          ((StringBuilder)localObject).append(paramBluetoothProfile.size());
          ((StringBuilder)localObject).append(" _profile:");
          ((StringBuilder)localObject).append(this._profile);
          QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
          break label601;
          if (paramInt < paramBluetoothProfile.size())
          {
            localObject = (BluetoothDevice)paramBluetoothProfile.get(paramInt);
            try
            {
              if (this._profile == null) {
                break label606;
              }
              i = this._profile.getConnectionState((BluetoothDevice)localObject);
            }
            catch (Exception localException)
            {
              if (!QLog.isColorLevel()) {
                break label606;
              }
            }
            StringBuilder localStringBuilder3 = new StringBuilder();
            localStringBuilder3.append("get bluetooth connection state failed.");
            localStringBuilder3.append(localException.getMessage());
            QLog.e("TraeAudioManager", 2, localStringBuilder3.toString());
            break label606;
            if (i == 2) {
              this._devCfg.setBluetoothName(((BluetoothDevice)localObject).getName());
            }
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("   ");
              localStringBuilder2.append(paramInt);
              localStringBuilder2.append(" ");
              localStringBuilder2.append(((BluetoothDevice)localObject).getName());
              localStringBuilder2.append(" ConnectionState:");
              localStringBuilder2.append(i);
              QLog.w("TraeAudioManager", 2, localStringBuilder2.toString());
            }
            paramInt += 1;
            continue;
          }
        }
        this._profileLock.unlock();
        if (this._devCfg != null)
        {
          paramBluetoothProfile = localStringBuilder1;
          if (this.this$0._deviceConfigManager != null) {
            paramBluetoothProfile = this.this$0._deviceConfigManager.getBluetoothName();
          }
          if (TextUtils.isEmpty(paramBluetoothProfile))
          {
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          }
          else if (isConnected())
          {
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
            this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
          }
          else
          {
            this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          }
        }
      }
      finally
      {
        this._profileLock.unlock();
      }
      AudioDeviceInterface.LogTraceExit();
      return;
      label596:
      paramBluetoothProfile = null;
      continue;
      label601:
      paramInt = 0;
      continue;
      label606:
      int i = 0;
    }
  }
  
  @TargetApi(11)
  public void onServiceDisconnected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_profile:");
    localStringBuilder.append(this._profile);
    localStringBuilder.append(" profile:");
    localStringBuilder.append(paramInt);
    AudioDeviceInterface.LogTraceEntry(localStringBuilder.toString());
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
      }
      if (isConnected()) {
        this.this$0.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
      }
      this._profileLock.lock();
    }
    try
    {
      if (this._profile != null)
      {
        this._adapter.closeProfileProxy(1, this._profile);
        this._profile = null;
      }
      this._profileLock.unlock();
    }
    finally
    {
      this._profileLock.unlock();
    }
  }
  
  /* Error */
  public void release()
  {
    // Byte code:
    //   0: new 53	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 248
    //   11: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: pop
    //   15: aload_1
    //   16: aload_0
    //   17: getfield 35	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profile	Landroid/bluetooth/BluetoothProfile;
    //   20: invokevirtual 168	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload_1
    //   25: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 195	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:LogTraceEntry	(Ljava/lang/String;)V
    //   31: aload_0
    //   32: getfield 42	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profileLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   35: invokevirtual 209	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   38: aload_0
    //   39: getfield 33	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_adapter	Landroid/bluetooth/BluetoothAdapter;
    //   42: ifnull +27 -> 69
    //   45: aload_0
    //   46: getfield 35	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profile	Landroid/bluetooth/BluetoothProfile;
    //   49: ifnull +15 -> 64
    //   52: aload_0
    //   53: getfield 33	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_adapter	Landroid/bluetooth/BluetoothAdapter;
    //   56: iconst_1
    //   57: aload_0
    //   58: getfield 35	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profile	Landroid/bluetooth/BluetoothProfile;
    //   61: invokevirtual 262	android/bluetooth/BluetoothAdapter:closeProfileProxy	(ILandroid/bluetooth/BluetoothProfile;)V
    //   64: aload_0
    //   65: aconst_null
    //   66: putfield 35	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profile	Landroid/bluetooth/BluetoothProfile;
    //   69: aload_0
    //   70: getfield 42	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profileLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   73: invokevirtual 221	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   76: goto +52 -> 128
    //   79: astore_1
    //   80: goto +52 -> 132
    //   83: astore_1
    //   84: invokestatic 51	com/tencent/rtmp/sharp/jni/QLog:isColorLevel	()Z
    //   87: ifeq -18 -> 69
    //   90: new 53	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 54	java/lang/StringBuilder:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: ldc_w 305
    //   102: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: aload_1
    //   108: invokevirtual 277	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 68
    //   117: iconst_2
    //   118: aload_2
    //   119: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 75	com/tencent/rtmp/sharp/jni/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: goto -56 -> 69
    //   128: invokestatic 224	com/tencent/rtmp/sharp/jni/AudioDeviceInterface:LogTraceExit	()V
    //   131: return
    //   132: aload_0
    //   133: getfield 42	com/tencent/rtmp/sharp/jni/TraeAudioManager$BluetoohHeadsetCheck:_profileLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   136: invokevirtual 221	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   139: goto +5 -> 144
    //   142: aload_1
    //   143: athrow
    //   144: goto -2 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	BluetoohHeadsetCheck
    //   7	18	1	localStringBuilder1	StringBuilder
    //   79	1	1	localObject	Object
    //   83	60	1	localException	Exception
    //   97	22	2	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   38	64	79	finally
    //   64	69	79	finally
    //   84	125	79	finally
    //   38	64	83	java/lang/Exception
    //   64	69	83	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.BluetoohHeadsetCheck
 * JD-Core Version:    0.7.0.1
 */