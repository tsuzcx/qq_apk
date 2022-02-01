package com.tencent.mobileqq.qqaudio;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager;
import com.tencent.mobileqq.mediafocus.MediaFocusManager.OnMediaFocusChangeListener;
import com.tencent.mobileqq.pttview.QQPttAudioFocusLossProcessor;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class QQAudioUtils
{
  private static MediaFocusManager.OnMediaFocusChangeListener a;
  @ConfigInject(configPath="Foundation/QQAudio/src/main/resources/Inject_QQAudioFocusLossProcessor.yml", version=1)
  public static ArrayList<Class<? extends IAudioFocusLossProcessor>> a;
  public static final int[] a;
  private static ArrayList<IAudioFocusLossProcessor> b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 8000, 12000, 16000, 24000, 36000, 44100, 48000 };
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_a_of_type_JavaUtilArrayList.add(QQPttAudioFocusLossProcessor.class);
    jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener = new QQAudioUtils.1();
    b = new ArrayList();
    Iterator localIterator = jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      try
      {
        localObject = (IAudioFocusLossProcessor)((Class)localObject).newInstance();
        b.add(localObject);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("QQAudioUtils", 1, "initAudioFocusLossProcessor error! ", localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("QQAudioUtils", 1, "initAudioFocusLossProcessor error! ", localIllegalAccessException);
      }
    }
  }
  
  public static byte a(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[10];
    paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (a(arrayOfByte)) {
      return arrayOfByte[0];
    }
    return -1;
  }
  
  public static int a(byte paramByte)
  {
    if (paramByte >= 0)
    {
      int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;
      if (paramByte < arrayOfInt.length) {
        return arrayOfInt[paramByte];
      }
    }
    return 0;
  }
  
  public static int a(byte paramByte, InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2];
    paramByte = 0;
    while (paramInputStream.read(arrayOfByte) > 0)
    {
      int i = a(arrayOfByte);
      byte b1 = paramByte + 20;
      paramByte = b1;
      if (i > 0)
      {
        paramInputStream.skip(i);
        paramByte = b1;
      }
    }
    return paramByte;
  }
  
  public static int a(int paramInt)
  {
    return paramInt * 20 * 2 / 1000;
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);
  }
  
  protected static void a()
  {
    Iterator localIterator = b.iterator();
    while (localIterator.hasNext()) {
      ((IAudioFocusLossProcessor)localIterator.next()).a();
    }
  }
  
  @TargetApi(8)
  public static boolean a(Context paramContext, boolean paramBoolean)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
      return false;
    }
    if (!VersionUtils.b())
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQAudioUtils", 2, "Android 2.1 and below can not stop music");
      }
      return false;
    }
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean)
    {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {
        bool1 = true;
      }
      MediaFocusManager.a().a(1, jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
    }
    else
    {
      bool1 = bool3;
      try
      {
        if (paramContext.abandonAudioFocus(null) == 1) {
          bool1 = true;
        }
        bool2 = bool1;
        ThreadManager.getSubThreadHandler().postDelayed(new QQAudioUtils.2(), 1000L);
      }
      catch (NullPointerException paramContext)
      {
        QLog.e("QQAudioUtils", 1, "caught npe", paramContext);
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("pauseMusic bMute=");
      paramContext.append(paramBoolean);
      paramContext.append(" result=");
      paramContext.append(bool1);
      QLog.d("QQAudioUtils", 2, paramContext.toString());
    }
    return bool1;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length != 10) {
        return false;
      }
      String str = PkgTools.utf8Byte2String(paramArrayOfByte, 1, 9);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSilkFs ");
        localStringBuilder.append(paramArrayOfByte[0]);
        localStringBuilder.append(str);
        QLog.d("QQAudioUtils", 2, localStringBuilder.toString());
      }
      if (str.startsWith("#!SILK_V")) {
        return true;
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("isSilkFileHead: headString = ");
      paramArrayOfByte.append(str);
      QLog.e("QQAudioUtils", 1, paramArrayOfByte.toString());
    }
    return false;
  }
  
  public static byte[] a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioUtils
 * JD-Core Version:    0.7.0.1
 */