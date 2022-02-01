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
      catch (IllegalAccessException localIllegalAccessException)
      {
        QLog.e("QQAudioUtils", 1, "initAudioFocusLossProcessor error! ", localIllegalAccessException);
      }
      catch (InstantiationException localInstantiationException)
      {
        QLog.e("QQAudioUtils", 1, "initAudioFocusLossProcessor error! ", localInstantiationException);
      }
    }
  }
  
  public static byte a(InputStream paramInputStream)
  {
    byte b1 = -1;
    byte[] arrayOfByte = new byte[10];
    paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
    if (a(arrayOfByte)) {
      b1 = arrayOfByte[0];
    }
    return b1;
  }
  
  public static int a(byte paramByte)
  {
    int j = 0;
    int i = j;
    if (paramByte >= 0)
    {
      i = j;
      if (paramByte < jdField_a_of_type_ArrayOfInt.length) {
        i = jdField_a_of_type_ArrayOfInt[paramByte];
      }
    }
    return i;
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
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioUtil", 2, "context is null.");
      }
    }
    do
    {
      return false;
      if (VersionUtils.b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QQAudioUtils", 2, "Android 2.1 and below can not stop music");
    return false;
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramBoolean)
    {
      if (paramContext.requestAudioFocus(null, 3, 2) == 1) {}
      for (bool = true;; bool = false)
      {
        MediaFocusManager.a().a(1, jdField_a_of_type_ComTencentMobileqqMediafocusMediaFocusManager$OnMediaFocusChangeListener);
        if (QLog.isColorLevel()) {
          QLog.d("QQAudioUtils", 2, "pauseMusic bMute=" + paramBoolean + " result=" + bool);
        }
        return bool;
      }
    }
    for (;;)
    {
      try
      {
        for (;;)
        {
          int i = paramContext.abandonAudioFocus(null);
          if (i != 1) {
            break label173;
          }
          bool = true;
          try
          {
            ThreadManager.getSubThreadHandler().postDelayed(new QQAudioUtils.2(), 1000L);
          }
          catch (NullPointerException paramContext) {}
        }
      }
      catch (NullPointerException paramContext)
      {
        label173:
        bool = false;
        continue;
      }
      QLog.e("QQAudioUtils", 1, "caught npe", paramContext);
      break;
      bool = false;
    }
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length != 10)) {
      bool = false;
    }
    String str;
    do
    {
      return bool;
      str = PkgTools.utf8Byte2String(paramArrayOfByte, 1, 9);
      if (QLog.isColorLevel()) {
        QLog.d("QQAudioUtils", 2, "getSilkFs " + paramArrayOfByte[0] + str);
      }
    } while (str.startsWith("#!SILK_V"));
    QLog.e("QQAudioUtils", 1, "isSilkFileHead: headString = " + str);
    return false;
  }
  
  public static byte[] a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    paramArrayOfByte[paramInt2] = ((byte)(paramInt1 & 0xFF));
    paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 8 & 0xFF));
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.QQAudioUtils
 * JD-Core Version:    0.7.0.1
 */