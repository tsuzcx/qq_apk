package com.tencent.sharp.jni;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class TraeUtils
{
  public static final String a = "TraeUtils";
  
  static int a(int paramInt)
  {
    int i;
    if (c())
    {
      if (paramInt >= 0) {
        i = paramInt;
      } else {
        i = 7;
      }
    }
    else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAudioSource] audioSourcePolicy[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], source[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class<?>[] paramArrayOfClass)
  {
    if (paramObject == null) {
      return null;
    }
    try
    {
      paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
      return paramObject;
    }
    catch (Exception paramObject)
    {
      if (QLog.isColorLevel())
      {
        paramString = a;
        paramArrayOfObject = new StringBuilder();
        paramArrayOfObject.append("invokeMethod Exception:");
        paramArrayOfObject.append(paramObject.getMessage());
        QLog.w(paramString, 2, paramArrayOfObject.toString());
      }
    }
    return null;
  }
  
  static void a(Context paramContext, int paramInt)
  {
    ((AudioManager)paramContext.getSystemService("audio")).setMode(paramInt);
    if (QLog.isColorLevel())
    {
      paramContext = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setAudioMode] mode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.w(paramContext, 2, localStringBuilder.toString());
    }
  }
  
  static void a(AudioManager paramAudioManager, int paramInt)
  {
    Object localObject1;
    if ((!Build.MANUFACTURER.equals("Google")) && (Build.VERSION.SDK_INT < 28))
    {
      localObject1 = new Object[1];
      localObject1[0] = Integer.valueOf(paramInt);
      Object localObject2 = new Class[localObject1.length];
      localObject2[0] = Integer.TYPE;
      paramAudioManager = a(paramAudioManager, "forceVolumeControlStream", (Object[])localObject1, (Class[])localObject2);
      if (QLog.isColorLevel())
      {
        localObject1 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("forceVolumeControlStream  streamType[");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append("], res[");
        ((StringBuilder)localObject2).append(paramAudioManager);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramAudioManager = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("forceVolumeControlStream, manufacturer[");
      ((StringBuilder)localObject1).append(Build.MANUFACTURER);
      ((StringBuilder)localObject1).append("], sdk version[");
      ((StringBuilder)localObject1).append(Build.VERSION.SDK_INT);
      ((StringBuilder)localObject1).append("]");
      QLog.w(paramAudioManager, 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  static boolean a()
  {
    AudioManager localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    try
    {
      boolean bool = localAudioManager.isSpeakerphoneOn();
      return bool;
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AudioManager#isSpeakerphoneOn exception[");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("]");
      QLog.e(str, 1, localStringBuilder.toString());
    }
    return false;
  }
  
  private static boolean a(String paramString)
  {
    return (paramString != null) && ((paramString.contains("x86")) || (paramString.contains("mips")) || (paramString.equalsIgnoreCase("armeabi-v7a")) || (paramString.equalsIgnoreCase("arm64-v8a")));
  }
  
  static int b(int paramInt)
  {
    int i;
    if (c())
    {
      if (paramInt >= 0) {
        i = paramInt;
      } else {
        i = 0;
      }
    }
    else {
      i = 3;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAudioStreamType] audioStreamTypePolicy[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], streamType[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  static boolean b()
  {
    boolean bool2 = Build.MANUFACTURER.equals("Xiaomi");
    boolean bool1 = false;
    if (bool2)
    {
      if ((Build.MODEL.equals("MI 2")) || (Build.MODEL.equals("MI 2A")) || (Build.MODEL.equals("MI 2S")) || (Build.MODEL.equals("MI 2SC"))) {
        bool1 = true;
      }
      return bool1;
    }
    if (Build.MANUFACTURER.equals("samsung")) {
      return Build.MODEL.equals("SCH-I959");
    }
    return false;
  }
  
  static int c(int paramInt)
  {
    int i;
    if (c())
    {
      if (paramInt >= 0) {
        i = paramInt;
      } else {
        i = 3;
      }
    }
    else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getAudioMode] modePolicy[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], mode[");
      localStringBuilder.append(i);
      localStringBuilder.append("], manufacturer[");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("], model[");
      localStringBuilder.append(Build.MODEL);
      localStringBuilder.append("]");
      QLog.w(str, 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private static boolean c()
  {
    if (a(Build.CPU_ABI)) {
      return true;
    }
    if (a(Build.CPU_ABI2)) {
      return true;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      String[] arrayOfString = Build.SUPPORTED_ABIS;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (a(arrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeUtils
 * JD-Core Version:    0.7.0.1
 */