package com.tencent.mobileqq.richmedia.capture.util;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class SVParamManager
{
  private static SVParamManager jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager;
  private String jdField_a_of_type_JavaLangString;
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private final String jdField_b_of_type_JavaLangString = "short_video.param_manager";
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private Map c = new HashMap();
  private Map d = new HashMap();
  
  private SVParamManager()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new Size(960, 720));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new Size(960, 720));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(1), Float.valueOf(1.0F));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(1.0F));
    this.jdField_a_of_type_JavaLangString = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    for (String str = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";; str = this.jdField_a_of_type_JavaLangString)
    {
      this.jdField_a_of_type_JavaLangString = str;
      a();
      return;
    }
  }
  
  public static SVParamManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager == null) {
        jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager = new SVParamManager();
      }
      return jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager;
    }
    finally {}
  }
  
  private static String a(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf("=");
    if (i == -1) {
      return paramString2;
    }
    return paramString1.substring(i + 1);
  }
  
  private void a()
  {
    String[] arrayOfString3;
    try
    {
      String[] arrayOfString1 = this.jdField_a_of_type_JavaLangString.split(",");
      if ((arrayOfString1 == null) || (arrayOfString1.length == 0))
      {
        if (!QLog.isColorLevel()) {
          break label831;
        }
        QLog.d("short_video.param_manager", 2, "initConfig(): configs is null or its length is 0");
        return;
      }
      arrayOfString3 = arrayOfString1[0].split("\\|");
      if (arrayOfString3.length < 17) {
        break label515;
      }
      arrayOfString1 = arrayOfString3[3].split("\\*");
      if ((arrayOfString1 != null) && (arrayOfString1.length == 2)) {
        break label132;
      }
      if (!QLog.isColorLevel()) {
        break label831;
      }
      QLog.d("short_video.param_manager", 2, "initConfig(): resolution is null or length is not 2");
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label831;
      }
    }
    QLog.e("short_video.param_manager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
    return;
    label132:
    int j = Integer.valueOf(localException[0]).intValue();
    int k = Integer.valueOf(localException[1]).intValue();
    Object localObject = a(arrayOfString3[13], "");
    String[] arrayOfString2;
    int[] arrayOfInt2;
    int[] arrayOfInt1;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      arrayOfString2 = ((String)localObject).split(";");
      if ((arrayOfString2 != null) && (arrayOfString2.length != 0))
      {
        arrayOfInt2 = new int[arrayOfString2.length];
        arrayOfInt1 = new int[arrayOfString2.length];
        int[] arrayOfInt3 = new int[arrayOfString2.length];
        localObject = new int[arrayOfString2.length];
        i = 0;
        if (i >= arrayOfString2.length) {
          break label853;
        }
        String[] arrayOfString4 = arrayOfString2[i].split("#");
        if ((arrayOfString4 == null) || (arrayOfString4.length < 3)) {
          break label846;
        }
        String[] arrayOfString5 = arrayOfString4[0].split("\\*");
        if ((arrayOfString5 == null) || (arrayOfString5.length != 2))
        {
          if (!QLog.isColorLevel()) {
            break label832;
          }
          QLog.d("short_video.param_manager", 2, "initConfig(): res is null or length is not 2");
          break label832;
        }
        label295:
        while ((arrayOfString4[1] != null) && (arrayOfString4[2] != null))
        {
          arrayOfInt3[i] = Integer.valueOf(arrayOfString4[1]).intValue();
          localObject[i] = Integer.valueOf(arrayOfString4[2]).intValue();
          break;
          arrayOfInt2[i] = Integer.valueOf(arrayOfString5[0]).intValue();
          arrayOfInt1[i] = Integer.valueOf(arrayOfString5[1]).intValue();
        }
      }
    }
    label515:
    label831:
    label832:
    label846:
    label853:
    for (;;)
    {
      i = Integer.valueOf(a(arrayOfString3[14], "0")).intValue();
      if ((arrayOfString2 != null) && (i < arrayOfString2.length)) {}
      for (;;)
      {
        if ((arrayOfInt2 != null) && (arrayOfInt1 != null))
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new Size(arrayOfInt2[i], arrayOfInt1[i]));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new Size(arrayOfInt2[i], arrayOfInt1[i]));
        }
        if (localObject != null)
        {
          this.c.put(Integer.valueOf(2), Integer.valueOf(localObject[i]));
          this.c.put(Integer.valueOf(1), Integer.valueOf(localObject[i]));
        }
        if (arrayOfString3.length > 25)
        {
          localObject = a(arrayOfString3[24], "").split(";");
          i = Integer.valueOf(localObject[0]).intValue();
          j = Integer.valueOf(localObject[1]).intValue();
          if ((j > 0) && (i > 0))
          {
            float f = i / j;
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(f));
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(f));
          }
        }
        if (arrayOfString3.length > 27)
        {
          boolean bool = a(arrayOfString3[27], "0").equals("1");
          this.d.put(Integer.valueOf(2), Boolean.valueOf(bool));
          this.d.put(Integer.valueOf(1), Boolean.valueOf(bool));
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("short_video.param_manager", 2, "cameraResolution : " + this.jdField_a_of_type_JavaUtilMap.toString());
        QLog.d("short_video.param_manager", 2, "videoResolutionRatioMap : " + this.jdField_b_of_type_JavaUtilMap.toString());
        QLog.d("short_video.param_manager", 2, "isDynamic : " + this.d);
        QLog.d("short_video.param_manager", 2, "bitRateMap : " + this.c);
        return;
        i = 0;
      }
      arrayOfInt2 = null;
      arrayOfInt1 = null;
      localObject = null;
      continue;
      arrayOfString2 = null;
      arrayOfInt2 = null;
      arrayOfInt1 = null;
      localObject = null;
      continue;
      return;
      arrayOfInt2[i] = j;
      arrayOfInt1[i] = k;
      break label295;
      i += 1;
      break;
    }
  }
  
  public float a(int paramInt)
  {
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Float)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramInt))).floatValue();
    }
    return 1.0F;
  }
  
  public int a(int paramInt)
  {
    if (this.c.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.c.get(Integer.valueOf(paramInt))).intValue();
    }
    return -1;
  }
  
  public Size a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramInt))) {
      return (Size)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
    }
    return new Size(960, 720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.SVParamManager
 * JD-Core Version:    0.7.0.1
 */