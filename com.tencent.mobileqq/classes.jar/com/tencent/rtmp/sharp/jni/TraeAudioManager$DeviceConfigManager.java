package com.tencent.rtmp.sharp.jni;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

class TraeAudioManager$DeviceConfigManager
{
  String _bluetoothDevName = "unknow";
  String connectedDevice = "DEVICE_NONE";
  String connectingDevice = "DEVICE_NONE";
  HashMap<String, TraeAudioManager.DeviceConfigManager.DeviceConfig> deviceConfigs = new HashMap();
  ReentrantLock mLock = new ReentrantLock();
  String prevConnectedDevice = "DEVICE_NONE";
  boolean visiableUpdate = false;
  
  public TraeAudioManager$DeviceConfigManager(TraeAudioManager paramTraeAudioManager) {}
  
  boolean _addConfig(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" devName:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" priority:");
    ((StringBuilder)localObject).append(paramInt);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    localObject = new TraeAudioManager.DeviceConfigManager.DeviceConfig(this);
    if (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).init(paramString, paramInt))
    {
      if (this.deviceConfigs.containsKey(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "err dev exist!");
        }
        return false;
      }
      this.deviceConfigs.put(paramString, localObject);
      this.visiableUpdate = true;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append(" n");
        paramString.append(getDeviceNumber());
        paramString.append(" 0:");
        paramString.append(getDeviceName(0));
        QLog.w("TRAE", 2, paramString.toString());
      }
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TRAE", 2, " err dev init!");
    }
    return false;
  }
  
  ArrayList<String> _getAvailableDeviceList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.deviceConfigs.entrySet().iterator();
    while (localIterator.hasNext())
    {
      TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
        localArrayList.add(localDeviceConfig.getDeviceName());
      }
    }
    return localArrayList;
  }
  
  String _getConnectedDevice()
  {
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(this.connectedDevice);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
      return this.connectedDevice;
    }
    return "DEVICE_NONE";
  }
  
  String _getPrevConnectedDevice()
  {
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(this.prevConnectedDevice);
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
      return this.prevConnectedDevice;
    }
    return "DEVICE_NONE";
  }
  
  public void clearConfig()
  {
    this.mLock.lock();
    this.deviceConfigs.clear();
    this.prevConnectedDevice = "DEVICE_NONE";
    this.connectedDevice = "DEVICE_NONE";
    this.connectingDevice = "DEVICE_NONE";
    this.mLock.unlock();
  }
  
  public ArrayList<String> getAvailableDeviceList()
  {
    new ArrayList();
    this.mLock.lock();
    ArrayList localArrayList = _getAvailableDeviceList();
    this.mLock.unlock();
    return localArrayList;
  }
  
  public String getAvailabledHighestPriorityDevice()
  {
    this.mLock.lock();
    Iterator localIterator = this.deviceConfigs.entrySet().iterator();
    label22:
    Object localObject2;
    for (Object localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
    {
      localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      localObject2 = (TraeAudioManager.DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue();
      if ((localObject2 == null) || (!((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject2).getVisible()) || ((localObject1 != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject2).getPriority() < localObject1.getPriority()))) {
        break label22;
      }
    }
    this.mLock.unlock();
    if (localObject1 != null) {
      return localObject1.getDeviceName();
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public String getAvailabledHighestPriorityDevice(String paramString)
  {
    this.mLock.lock();
    Iterator localIterator = this.deviceConfigs.entrySet().iterator();
    label23:
    Object localObject2;
    for (Object localObject1 = null; localIterator.hasNext(); localObject1 = localObject2)
    {
      localObject2 = (Map.Entry)localIterator.next();
      ((Map.Entry)localObject2).getKey();
      ((Map.Entry)localObject2).getValue();
      localObject2 = (TraeAudioManager.DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue();
      if ((localObject2 == null) || (!((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject2).getVisible()) || (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject2).getDeviceName().equals(paramString)) || ((localObject1 != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject2).getPriority() < localObject1.getPriority()))) {
        break label23;
      }
    }
    this.mLock.unlock();
    if (localObject1 != null) {
      return localObject1.getDeviceName();
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public String getBluetoothName()
  {
    return this._bluetoothDevName;
  }
  
  public String getConnectedDevice()
  {
    this.mLock.lock();
    String str = _getConnectedDevice();
    this.mLock.unlock();
    return str;
  }
  
  public String getConnectingDevice()
  {
    this.mLock.lock();
    Object localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(this.connectingDevice);
    if ((localObject != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getVisible())) {
      localObject = this.connectingDevice;
    } else {
      localObject = null;
    }
    this.mLock.unlock();
    return localObject;
  }
  
  public String getDeviceName(int paramInt)
  {
    this.mLock.lock();
    Object localObject = this.deviceConfigs.entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (i == paramInt)
      {
        localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)localEntry.getValue();
        break label70;
      }
      i += 1;
    }
    localObject = null;
    label70:
    if (localObject != null) {
      localObject = ((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getDeviceName();
    } else {
      localObject = "DEVICE_NONE";
    }
    this.mLock.unlock();
    return localObject;
  }
  
  public int getDeviceNumber()
  {
    this.mLock.lock();
    int i = this.deviceConfigs.size();
    this.mLock.unlock();
    return i;
  }
  
  public String getPrevConnectedDevice()
  {
    this.mLock.lock();
    String str = _getPrevConnectedDevice();
    this.mLock.unlock();
    return str;
  }
  
  public int getPriority(String paramString)
  {
    this.mLock.lock();
    paramString = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    int i;
    if (paramString != null) {
      i = paramString.getPriority();
    } else {
      i = -1;
    }
    this.mLock.unlock();
    return i;
  }
  
  public HashMap<String, Object> getSnapParams()
  {
    HashMap localHashMap = new HashMap();
    this.mLock.lock();
    localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", _getAvailableDeviceList());
    localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", _getConnectedDevice());
    localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", _getPrevConnectedDevice());
    this.mLock.unlock();
    return localHashMap;
  }
  
  public boolean getVisiableUpdateFlag()
  {
    this.mLock.lock();
    boolean bool = this.visiableUpdate;
    this.mLock.unlock();
    return bool;
  }
  
  public boolean getVisible(String paramString)
  {
    this.mLock.lock();
    paramString = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    boolean bool;
    if (paramString != null) {
      bool = paramString.getVisible();
    } else {
      bool = false;
    }
    this.mLock.unlock();
    return bool;
  }
  
  public boolean init(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" strConfigs:");
    ((StringBuilder)localObject).append(paramString);
    AudioDeviceInterface.LogTraceEntry(((StringBuilder)localObject).toString());
    int i = 0;
    if (paramString != null)
    {
      if (paramString.length() <= 0) {
        return false;
      }
      localObject = paramString.replace("\n", "").replace("\r", "");
      if (localObject != null)
      {
        if (((String)localObject).length() <= 0) {
          return false;
        }
        paramString = (String)localObject;
        if (((String)localObject).indexOf(";") < 0)
        {
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(";");
          paramString = paramString.toString();
        }
        paramString = paramString.split(";");
        if (paramString != null)
        {
          if (1 > paramString.length) {
            return false;
          }
          this.mLock.lock();
          while (i < paramString.length)
          {
            _addConfig(paramString[i], i);
            i += 1;
          }
          this.mLock.unlock();
          this.this$0.printDevices();
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isConnected(String paramString)
  {
    this.mLock.lock();
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    boolean bool;
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible())) {
      bool = this.connectedDevice.equals(paramString);
    } else {
      bool = false;
    }
    this.mLock.unlock();
    return bool;
  }
  
  public void resetVisiableUpdateFlag()
  {
    this.mLock.lock();
    this.visiableUpdate = false;
    this.mLock.unlock();
  }
  
  public void setBluetoothName(String paramString)
  {
    if (paramString == null)
    {
      this._bluetoothDevName = "unknow";
      return;
    }
    if (paramString.isEmpty())
    {
      this._bluetoothDevName = "unknow";
      return;
    }
    this._bluetoothDevName = paramString;
  }
  
  public boolean setConnected(String paramString)
  {
    this.mLock.lock();
    Object localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    boolean bool;
    if ((localObject != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getVisible()))
    {
      localObject = this.connectedDevice;
      if ((localObject != null) && (!((String)localObject).equals(paramString))) {
        this.prevConnectedDevice = this.connectedDevice;
      }
      this.connectedDevice = paramString;
      this.connectingDevice = "";
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.mLock.unlock();
    return bool;
  }
  
  public boolean setConnecting(String paramString)
  {
    this.mLock.lock();
    TraeAudioManager.DeviceConfigManager.DeviceConfig localDeviceConfig = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    boolean bool;
    if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()))
    {
      this.connectingDevice = paramString;
      bool = true;
    }
    else
    {
      bool = false;
    }
    this.mLock.unlock();
    return bool;
  }
  
  public boolean setVisible(String paramString, boolean paramBoolean)
  {
    this.mLock.lock();
    Object localObject = (TraeAudioManager.DeviceConfigManager.DeviceConfig)this.deviceConfigs.get(paramString);
    boolean bool2 = true;
    boolean bool1;
    if ((localObject != null) && (((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).getVisible() != paramBoolean))
    {
      ((TraeAudioManager.DeviceConfigManager.DeviceConfig)localObject).setVisible(paramBoolean);
      this.visiableUpdate = true;
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" ++setVisible:");
        ((StringBuilder)localObject).append(paramString);
        if (paramBoolean) {
          paramString = " Y";
        } else {
          paramString = " N";
        }
        ((StringBuilder)localObject).append(paramString);
        QLog.w("TRAE", 2, ((StringBuilder)localObject).toString());
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    this.mLock.unlock();
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.DeviceConfigManager
 * JD-Core Version:    0.7.0.1
 */