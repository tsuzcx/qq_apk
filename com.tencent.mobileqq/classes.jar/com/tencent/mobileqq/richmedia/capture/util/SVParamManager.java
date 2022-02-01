package com.tencent.mobileqq.richmedia.capture.util;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class SVParamManager
{
  private static SVParamManager jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager;
  private String jdField_a_of_type_JavaLangString;
  private Map<Integer, Size> jdField_a_of_type_JavaUtilMap = new HashMap();
  private final String jdField_b_of_type_JavaLangString = "short_video.param_manager";
  private Map<Integer, Float> jdField_b_of_type_JavaUtilMap = new HashMap();
  private Map<Integer, Integer> c = new HashMap();
  private Map<Integer, Boolean> d = new HashMap();
  private Map<Integer, Size> e = new HashMap();
  private Map<Integer, Integer> f = new HashMap();
  
  private SVParamManager()
  {
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new Size(960, 720));
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new Size(960, 720));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(1), Float.valueOf(1.0F));
    this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(1.0F));
    this.jdField_a_of_type_JavaLangString = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null);
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
          break label958;
        }
        QLog.d("short_video.param_manager", 2, "initConfig(): configs is null or its length is 0");
        return;
      }
      arrayOfString3 = arrayOfString1[0].split("\\|");
      if (arrayOfString3.length < 17) {
        break label631;
      }
      arrayOfString1 = arrayOfString3[3].split("\\*");
      if ((arrayOfString1 != null) && (arrayOfString1.length == 2)) {
        break label132;
      }
      if (!QLog.isColorLevel()) {
        break label958;
      }
      QLog.d("short_video.param_manager", 2, "initConfig(): resolution is null or length is not 2");
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        break label958;
      }
    }
    QLog.e("short_video.param_manager", 2, "parse sv config error, stacktrace :  " + QLog.getStackTraceString(localException));
    return;
    label132:
    int j = Integer.valueOf(localException[0]).intValue();
    int k = Integer.valueOf(localException[1]).intValue();
    Object localObject = a(arrayOfString3[13], "");
    String[] arrayOfString2;
    int[] arrayOfInt3;
    int[] arrayOfInt2;
    int[] arrayOfInt1;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      arrayOfString2 = ((String)localObject).split(";");
      if ((arrayOfString2 != null) && (arrayOfString2.length != 0))
      {
        arrayOfInt3 = new int[arrayOfString2.length];
        arrayOfInt2 = new int[arrayOfString2.length];
        arrayOfInt1 = new int[arrayOfString2.length];
        localObject = new int[arrayOfString2.length];
        i = 0;
        if (i >= arrayOfString2.length) {
          break label980;
        }
        String[] arrayOfString4 = arrayOfString2[i].split("#");
        if ((arrayOfString4 == null) || (arrayOfString4.length < 3)) {
          break label973;
        }
        String[] arrayOfString5 = arrayOfString4[0].split("\\*");
        if ((arrayOfString5 == null) || (arrayOfString5.length != 2))
        {
          if (!QLog.isColorLevel()) {
            break label959;
          }
          QLog.d("short_video.param_manager", 2, "initConfig(): res is null or length is not 2");
          break label959;
        }
        label295:
        while ((arrayOfString4[1] != null) && (arrayOfString4[2] != null))
        {
          arrayOfInt1[i] = Integer.valueOf(arrayOfString4[1]).intValue();
          localObject[i] = Integer.valueOf(arrayOfString4[2]).intValue();
          break;
          arrayOfInt3[i] = Integer.valueOf(arrayOfString5[0]).intValue();
          arrayOfInt2[i] = Integer.valueOf(arrayOfString5[1]).intValue();
        }
      }
    }
    label920:
    label958:
    label959:
    label973:
    label980:
    for (;;)
    {
      i = Integer.valueOf(a(arrayOfString3[14], "0")).intValue();
      if ((arrayOfString2 != null) && (i < arrayOfString2.length)) {
        if (arrayOfString2 == null) {
          break label920;
        }
      }
      for (j = arrayOfString2.length - 1;; j = 0)
      {
        if ((arrayOfInt3 != null) && (arrayOfInt2 != null))
        {
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new Size(arrayOfInt3[i], arrayOfInt2[i]));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new Size(arrayOfInt3[i], arrayOfInt2[i]));
          this.e.put(Integer.valueOf(2), new Size(arrayOfInt3[j], arrayOfInt2[j]));
          this.e.put(Integer.valueOf(1), new Size(arrayOfInt3[j], arrayOfInt2[j]));
        }
        if (localObject != null)
        {
          this.c.put(Integer.valueOf(2), Integer.valueOf(localObject[i]));
          this.c.put(Integer.valueOf(1), Integer.valueOf(localObject[i]));
        }
        if (arrayOfInt1 != null)
        {
          this.f.put(Integer.valueOf(2), Integer.valueOf(arrayOfInt1[j]));
          this.f.put(Integer.valueOf(1), Integer.valueOf(arrayOfInt1[j]));
        }
        label631:
        if (arrayOfString3.length > 25)
        {
          localObject = a(arrayOfString3[24], "").split(";");
          i = Integer.valueOf(localObject[0]).intValue();
          j = Integer.valueOf(localObject[1]).intValue();
          if ((j > 0) && (i > 0))
          {
            float f1 = i / j;
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(f1));
            this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(f1));
          }
        }
        if (arrayOfString3.length > 27)
        {
          boolean bool = a(arrayOfString3[27], "0").equals("1");
          this.d.put(Integer.valueOf(2), Boolean.valueOf(bool));
          this.d.put(Integer.valueOf(1), Boolean.valueOf(bool));
        }
        if (!QLog.isColorLevel()) {
          break label958;
        }
        QLog.d("short_video.param_manager", 2, "cameraResolution : " + this.jdField_a_of_type_JavaUtilMap.toString());
        QLog.d("short_video.param_manager", 2, "videoResolutionRatioMap : " + this.jdField_b_of_type_JavaUtilMap.toString());
        QLog.d("short_video.param_manager", 2, "isDynamic : " + this.d);
        QLog.d("short_video.param_manager", 2, "bitRateMap : " + this.c);
        return;
        i = 0;
        break;
      }
      arrayOfInt3 = null;
      arrayOfInt2 = null;
      arrayOfInt1 = null;
      localObject = null;
      continue;
      arrayOfInt3 = null;
      arrayOfString2 = null;
      arrayOfInt2 = null;
      arrayOfInt1 = null;
      localObject = null;
      continue;
      return;
      arrayOfInt3[i] = j;
      arrayOfInt2[i] = k;
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
    QLog.e("short_video.param_manager", 1, "[getBitRate]:-1, which may cause error!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.SVParamManager
 * JD-Core Version:    0.7.0.1
 */