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
  private static volatile DeviceConfigManager jdField_a_of_type_ComTencentSharpJniDeviceConfigManager;
  private static final String jdField_a_of_type_JavaLangString = "DeviceConfigManager";
  private ConcurrentHashMap<String, DeviceConfigManager.DeviceConfig> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private volatile boolean jdField_a_of_type_Boolean = false;
  private String b = "DEVICE_NONE";
  private String c = "DEVICE_NONE";
  private String d = "DEVICE_NONE";
  private String e = "unknown";
  
  public static DeviceConfigManager a()
  {
    if (jdField_a_of_type_ComTencentSharpJniDeviceConfigManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentSharpJniDeviceConfigManager == null) {
          jdField_a_of_type_ComTencentSharpJniDeviceConfigManager = new DeviceConfigManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentSharpJniDeviceConfigManager;
  }
  
  private void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (!a(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addConfig, invalid deviceName[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.e((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramString))
    {
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("addConfig, already exist deviceName[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("]");
        QLog.w((String)localObject, 2, localStringBuilder.toString());
      }
      return;
    }
    Object localObject = new DeviceConfigManager.DeviceConfig(null);
    ((DeviceConfigManager.DeviceConfig)localObject).jdField_a_of_type_JavaLangString = paramString;
    ((DeviceConfigManager.DeviceConfig)localObject).jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static boolean a(String paramString)
  {
    return ("DEVICE_SPEAKERPHONE".equals(paramString)) || ("DEVICE_EARPHONE".equals(paramString)) || ("DEVICE_WIRED_HEADSET".equals(paramString)) || ("DEVICE_BLUETOOTH_HEADSET".equals(paramString));
  }
  
  private void c()
  {
    if (QLog.isColorLevel())
    {
      Object localObject1 = jdField_a_of_type_JavaLangString;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("logDevices, mConnectedDevice[");
      ((StringBuilder)localObject2).append(c());
      ((StringBuilder)localObject2).append("] mConnectingDevice[");
      ((StringBuilder)localObject2).append(b());
      ((StringBuilder)localObject2).append("] mPrevConnectedDevice[");
      ((StringBuilder)localObject2).append(d());
      ((StringBuilder)localObject2).append("] AHPDevice[");
      ((StringBuilder)localObject2).append(a(null));
      ((StringBuilder)localObject2).append("] deviceNumber[");
      ((StringBuilder)localObject2).append(a());
      ((StringBuilder)localObject2).append("] availableNumber[");
      ((StringBuilder)localObject2).append(a().size());
      ((StringBuilder)localObject2).append("]");
      QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        String str = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("logDevices, devName[");
        localStringBuilder.append((String)((Map.Entry)localObject2).getKey());
        localStringBuilder.append("] visible[");
        boolean bool;
        if ((((Map.Entry)localObject2).getValue() != null) && (((DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue()).jdField_a_of_type_Boolean)) {
          bool = true;
        } else {
          bool = false;
        }
        localStringBuilder.append(bool);
        localStringBuilder.append("] priority[");
        int i;
        if (((Map.Entry)localObject2).getValue() != null) {
          i = ((DeviceConfigManager.DeviceConfig)((Map.Entry)localObject2).getValue()).jdField_a_of_type_Int;
        } else {
          i = -1;
        }
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        QLog.w(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.size();
  }
  
  public String a()
  {
    return this.e;
  }
  
  public String a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
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
      return ((DeviceConfigManager.DeviceConfig)localObject).jdField_a_of_type_JavaLangString;
    }
    return "DEVICE_NONE";
  }
  
  public String a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    label16:
    DeviceConfigManager.DeviceConfig localDeviceConfig;
    for (Object localObject = null; localIterator.hasNext(); localObject = localDeviceConfig)
    {
      localDeviceConfig = (DeviceConfigManager.DeviceConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localDeviceConfig == null) || (!localDeviceConfig.jdField_a_of_type_Boolean) || (localDeviceConfig.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramString)) || ((localObject != null) && (localDeviceConfig.jdField_a_of_type_Int < localObject.jdField_a_of_type_Int))) {
        break label16;
      }
    }
    if (localObject != null) {
      return localObject.jdField_a_of_type_JavaLangString;
    }
    return "DEVICE_SPEAKERPHONE";
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)((Map.Entry)localIterator.next()).getValue();
      if ((localDeviceConfig != null) && (localDeviceConfig.jdField_a_of_type_Boolean)) {
        localArrayList.add(localDeviceConfig.jdField_a_of_type_JavaLangString);
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "clearConfig");
    }
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.b = "DEVICE_NONE";
    this.c = "DEVICE_NONE";
    this.d = "DEVICE_NONE";
    this.e = "unknown";
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "unknown";
    }
    this.e = str;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localObject != null) && (((DeviceConfigManager.DeviceConfig)localObject).jdField_a_of_type_Boolean != paramBoolean))
    {
      ((DeviceConfigManager.DeviceConfig)localObject).jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        localObject = jdField_a_of_type_JavaLangString;
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
  
  public String b()
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.d);
    if ((localDeviceConfig != null) && (localDeviceConfig.jdField_a_of_type_Boolean)) {
      return this.d;
    }
    return "DEVICE_NONE";
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(String paramString)
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.jdField_a_of_type_Boolean)) {
      this.d = paramString;
    }
  }
  
  public boolean b()
  {
    String str = b();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  public boolean b(String paramString)
  {
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
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
      c();
      return true;
    }
    return false;
  }
  
  public String c()
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.c);
    if ((localDeviceConfig != null) && (localDeviceConfig.jdField_a_of_type_Boolean)) {
      return this.c;
    }
    return "DEVICE_NONE";
  }
  
  public void c(String paramString)
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((localDeviceConfig != null) && (localDeviceConfig.jdField_a_of_type_Boolean))
    {
      if (!this.c.equalsIgnoreCase(paramString)) {
        this.b = this.c;
      }
      this.c = paramString;
      this.d = "DEVICE_NONE";
    }
  }
  
  public boolean c(String paramString)
  {
    paramString = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    return (paramString != null) && (paramString.jdField_a_of_type_Boolean);
  }
  
  public String d()
  {
    DeviceConfigManager.DeviceConfig localDeviceConfig = (DeviceConfigManager.DeviceConfig)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(this.b);
    if ((localDeviceConfig != null) && (localDeviceConfig.jdField_a_of_type_Boolean)) {
      return this.b;
    }
    return "DEVICE_NONE";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.DeviceConfigManager
 * JD-Core Version:    0.7.0.1
 */