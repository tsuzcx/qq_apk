package com.tencent.mobileqq.qqaudio.audioplayer;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class AudioPlayerHelper
{
  public static int a;
  private static String jdField_a_of_type_JavaLangString = null;
  private static AudioPlayerHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
  
  static
  {
    jdField_a_of_type_Int = 1000;
    jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = null;
  }
  
  public static AudioPlayerHelper.AudioPlayerParameter a()
  {
    if (b()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, true);
    }
    return new AudioPlayerHelper.AudioPlayerParameter(3, 0, true);
  }
  
  private static AudioPlayerHelper.AudioPlayerParameter a(int paramInt)
  {
    AudioPlayerHelper.AudioPlayerParameter localAudioPlayerParameter;
    if (paramInt == 0) {
      localAudioPlayerParameter = a();
    }
    for (;;)
    {
      String str = "!@$#_" + paramInt + "_";
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MobileQQ.getContext());
      localAudioPlayerParameter.jdField_a_of_type_Int = localSharedPreferences.getInt(str + "m", localAudioPlayerParameter.jdField_a_of_type_Int);
      localAudioPlayerParameter.b = localSharedPreferences.getInt(str + "s", localAudioPlayerParameter.b);
      localAudioPlayerParameter.jdField_a_of_type_Boolean = localSharedPreferences.getBoolean(str + "so", localAudioPlayerParameter.jdField_a_of_type_Boolean);
      return a(paramInt, localAudioPlayerParameter);
      if (paramInt == 1)
      {
        localAudioPlayerParameter = b();
      }
      else if (paramInt == 2)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else if (paramInt == 3)
      {
        localAudioPlayerParameter = a();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
      else
      {
        localAudioPlayerParameter = c();
        localAudioPlayerParameter.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  private static AudioPlayerHelper.AudioPlayerParameter a(int paramInt, AudioPlayerHelper.AudioPlayerParameter paramAudioPlayerParameter)
  {
    paramAudioPlayerParameter = new AudioPlayerHelper.AudioPlayerParameter(paramAudioPlayerParameter.b, paramAudioPlayerParameter.jdField_a_of_type_Int, paramAudioPlayerParameter.jdField_a_of_type_Boolean);
    Object localObject = jdField_a_of_type_JavaLangString;
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayerHelper", 2, "getDPCFixConfig | dpcConfig = " + (String)localObject);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).length() > 1)) {
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (paramInt == 0)
        {
          if (!"-1".equals(localObject[0])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[0]);
          }
          if (!"-1".equals(localObject[1]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[1]);
            return paramAudioPlayerParameter;
          }
        }
        else if (paramInt == 1)
        {
          if (!"-1".equals(localObject[2])) {
            paramAudioPlayerParameter.jdField_a_of_type_Int = Integer.parseInt(localObject[2]);
          }
          if (!"-1".equals(localObject[3]))
          {
            paramAudioPlayerParameter.b = Integer.parseInt(localObject[3]);
            return paramAudioPlayerParameter;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayerHelper", 2, "getDPCFixConfig error.", localException);
        }
      }
    }
    return paramAudioPlayerParameter;
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    return Build.MODEL.contains("Lenovo K900");
  }
  
  public static AudioPlayerHelper.AudioPlayerParameter[] a()
  {
    try
    {
      if (jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter == null)
      {
        jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter = new AudioPlayerHelper.AudioPlayerParameter[5];
        jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[0] = a(0);
        jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[1] = a(1);
        jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[2] = a(2);
        jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[3] = a(3);
        jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter[4] = a(4);
      }
      AudioPlayerHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = jdField_a_of_type_ArrayOfComTencentMobileqqQqaudioAudioplayerAudioPlayerHelper$AudioPlayerParameter;
      return arrayOfAudioPlayerParameter;
    }
    finally {}
  }
  
  @TargetApi(11)
  public static AudioPlayerHelper.AudioPlayerParameter b()
  {
    if (l()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (c()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (d()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (e()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (f()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (h()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if ((a()) || (g())) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (i()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 2, false);
    }
    if (j()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 2, false);
    }
    if (k()) {
      return new AudioPlayerHelper.AudioPlayerParameter(3, 3, false);
    }
    if (m()) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 0, false);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new AudioPlayerHelper.AudioPlayerParameter(0, 3, false);
    }
    return new AudioPlayerHelper.AudioPlayerParameter(0, 2, false);
  }
  
  private static boolean b()
  {
    String str = Build.MODEL;
    int i;
    if (((Build.MANUFACTURER.equalsIgnoreCase("Samsung")) || (str.contains("MI 2")) || (str.contains("Nexus 4"))) && (Build.VERSION.SDK_INT >= 11))
    {
      i = 1;
      if (i == 0) {
        break label54;
      }
    }
    label54:
    while ((str.contains("SCH-I699")) && (Build.VERSION.SDK_INT == 10))
    {
      return true;
      i = 0;
      break;
    }
    return false;
  }
  
  public static AudioPlayerHelper.AudioPlayerParameter c()
  {
    return new AudioPlayerHelper.AudioPlayerParameter(0, 2, true);
  }
  
  private static boolean c()
  {
    return (Build.MODEL.contains("HUAWEI Y 200T")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean d()
  {
    return (Build.MODEL.contains("Lenovo A278t")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean e()
  {
    return (Build.MODEL.contains("ZTE-T U960s")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean f()
  {
    return Build.MODEL.contains("5910");
  }
  
  private static boolean g()
  {
    return Build.MODEL.contains("vivo X9");
  }
  
  private static boolean h()
  {
    return Build.MODEL.contains("V926");
  }
  
  private static boolean i()
  {
    return Build.MODEL.contains("ZTE N881E");
  }
  
  private static boolean j()
  {
    return Build.MODEL.contains("LNV-Lenovo S870e");
  }
  
  private static boolean k()
  {
    return Build.MODEL.contains("Coolpad 5891Q");
  }
  
  private static boolean l()
  {
    return (Build.MODEL.contains("ME860")) && (Build.VERSION.SDK_INT <= 10);
  }
  
  private static boolean m()
  {
    return Build.MODEL.contains("GT-S7500");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper
 * JD-Core Version:    0.7.0.1
 */