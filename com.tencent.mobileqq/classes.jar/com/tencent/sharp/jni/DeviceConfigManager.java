package com.tencent.sharp.jni;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DeviceConfigManager
{
  private static final String a = "DeviceConfigManager";
  private static volatile DeviceConfigManager b;
  private ConcurrentHashMap<String, DeviceConfigManager.DeviceConfig> c = new ConcurrentHashMap();
  private String d = "DEVICE_NONE";
  private String e = "DEVICE_NONE";
  private String f = "DEVICE_NONE";
  private String g = "unknown";
  private volatile boolean h = false;
  
  public static DeviceConfigManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new DeviceConfigManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (!a(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addConfig, invalid deviceName[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    if (this.c.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addConfig, already exist deviceName[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    Object localObject = new DeviceConfigManager.DeviceConfig(null);
    ((DeviceConfigManager.DeviceConfig)localObject).a = paramString;
    ((DeviceConfigManager.DeviceConfig)localObject).c = paramInt;
    this.c.put(paramString, localObject);
    this.h = true;
  }
  
  public static boolean a(String paramString)
  {
    return ("DEVICE_SPEAKERPHONE".equals(paramString)) || ("DEVICE_EARPHONE".equals(paramString)) || ("DEVICE_WIRED_HEADSET".equals(paramString)) || ("DEVICE_BLUETOOTH_HEADSET".equals(paramString));
  }
  
  private void l()
  {
    if (QLog.isColorLevel())
    {
      Object localObject1 = a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logDevices, mConnectedDevice[");
      ((StringBuilder)localObject2).append(h());
      ((StringBuilder)localObject2).append("] mConnectingDevice[");
      ((StringBuilder)localObject2).append(g());
      ((StringBuilder)localObject2).append("] mPrevConnectedDevice[");
      ((StringBuilder)localObject2).append(i());
      ((StringBuilder)localObject2).append("] AHPDevice[");
      ((StringBuilder)localObject2).append(e(null));
      ((StringBuilder)localObject2).append("] deviceNumber[");
      ((StringBuilder)localObject2).append(f());
      ((StringBuilder)localObject2).append("] availableNumber[");
      ((StringBuilder)localObject2).append(j().size());
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject1 = this.c.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("logDevices, devName[");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localStringBuilder.append("] visible[");
        boolean bool;
        if ((((Map.Entry)localObject2).getValue() != null) && (((DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue()).b)) {
          bool = true;
        } else {
          bool = false;
        }
        localStringBuilder.append(bool);
        localStringBuilder.append("] priority[");
        int i;
        if (((Map.Entry)localObject2).getValue() != null) {
          i = ((DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue()).c;
        } else {
          i = -1;
        }
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public String a(int paramInt)
  {
    Object localObject = this.c.entrySet().iterator();
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if (i == paramInt)
      {
        localObject = (DeviceConfigManager.DeviceConfig)localEntry.getValue();
        break label63;
      }
      i += 1;
    }
    localObject = null;
    label63:
    if (localObject != null) {
      return ((DeviceConfigManager.DeviceConfig)localObject).a;
    }
    return "DEVICE_NONE";
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = (DeviceConfigManager.DeviceConfig)this.c.get(paramString);
    if ((localObject != null) && (((DeviceConfigManager.DeviceConfig)localObject).b != paramBoolean))
    {
      ((DeviceConfigManager.DeviceConfig)localObject).b = paramBoolean;
      this.h = true;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setVisible, deviceName[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("] visible[");
        localStringBuilder.append(paramBoolean);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 2, localStringBuilder.toString());
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.w(a, 2, "clearConfig");
    }
    this.c.clear();
    this.d = "DEVICE_NONE";
    this.e = "DEVICE_NONE";
    this.f = "DEVICE_NONE";
    this.g = "unknown";
    this.h = false;
  }
  
  public boolean b(String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init, configs[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (!bool)
    {
      str = paramString.replace("\n", "").replace("\r", "");
      if (TextUtils.isEmpty(str)) {
        return false;
      }
      paramString = str;
      if (!str.contains(";"))
      {
        paramString = new StringBuilder();
        paramString.append(str);
        paramString.append(";");
        paramString = paramString.toString();
      }
      paramString = paramString.split(";");
      if (paramString.length == 0) {
        return false;
      }
      while (i < paramString.length)
      {
        a(paramString[i], i);
        i += 1;
      }
      l();
      return true;
    }
    return false;
  }
  
  public void c(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "unknown";
    }
    this.g = str;
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public void d()
  {
    this.h = false;
  }
  
  public boolean d(String paramString)
  {
    paramString = (DeviceConfigManager.DeviceConfig)this.c.get(paramString);
    return (paramString != null) && (paramString.b);
  }
  
  public String e()
  {
    return this.g;
  }
  
  public String e(String paramString)
  {
    Iterator localIterator = this.c.entrySet().iterator();
    label16:
    DeviceConfigManager.DeviceConfig localDeviceConfig;
    for (Object localObject = null; localIterator.hasNext(); localObject = localDeviceConfig)
    {
      localDeviceConfig = (DeviceConfigManager.DeviceConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localDeviceConfig == null) || (!localDeviceConfig.b) || (localDeviceConfig.a.equalsIgnoreCase(paramString)) || ((localObject != null) && (localDeviceConfig.c < localObject.c))) {
        break label16;
      }
    }
    if (localObject != null) {
      return localObject.a;
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public int f()
  {
    return this.c.size();
  }
  
  public void f(String paramString)
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.c.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.b)) {
      this.f = paramString;
    }
  }
  
  public String g()
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.c.get(this.f);
    if ((localDeviceConfig != null) && (localDeviceConfig.b)) {
      return this.f;
    }
    return "DEVICE_NONE";
  }
  
  public void g(String paramString)
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.c.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.b))
    {
      if (!this.e.equalsIgnoreCase(paramString)) {
        this.d = this.e;
      }
      this.e = paramString;
      this.f = "DEVICE_NONE";
    }
  }
  
  public String h()
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.c.get(this.e);
    if ((localDeviceConfig != null) && (localDeviceConfig.b)) {
      return this.e;
    }
    return "DEVICE_NONE";
  }
  
  public String i()
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.c.get(this.d);
    if ((localDeviceConfig != null) && (localDeviceConfig.b)) {
      return this.d;
    }
    return "DEVICE_NONE";
  }
  
  public ArrayList<String> j()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localDeviceConfig != null) && (localDeviceConfig.b)) {
        localArrayList.add(localDeviceConfig.a);
      }
    }
    return localArrayList;
  }
  
  public boolean k()
  {
    String str = g();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceConfigManager
 * JD-Core Version:    0.7.0.1
 */