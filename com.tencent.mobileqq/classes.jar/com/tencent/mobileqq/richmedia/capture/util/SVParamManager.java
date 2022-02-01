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
    Object localObject2 = this.jdField_a_of_type_JavaUtilMap;
    Object localObject1 = Integer.valueOf(1);
    ((Map)localObject2).put(localObject1, new Size(960, 720));
    Map localMap = this.jdField_a_of_type_JavaUtilMap;
    localObject2 = Integer.valueOf(2);
    localMap.put(localObject2, new Size(960, 720));
    localMap = this.jdField_b_of_type_JavaUtilMap;
    Float localFloat = Float.valueOf(1.0F);
    localMap.put(localObject1, localFloat);
    this.jdField_b_of_type_JavaUtilMap.put(localObject2, localFloat);
    this.jdField_a_of_type_JavaLangString = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.SV658Cfg.name(), null);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      localObject1 = "30|6|1|640*480|450000|50000|1|35|3|1|800|1150|0|key=960*720#1500#2000;640*480#450#750|c2x=0|discussion=0|group=0|C2CNetworkConfigs=1;1;0|DiscussionNetworkConfigs=1;1;0|GroupNetworkConfigs=1;1;0|Duration=6;10|whiteList= |blackList= |useDPCResolution=0|ratio=1;1|450#6500#3#3#35;750#6500#3#5#45;1500#6500#3#9#55;2000#6500#3#9#55|1|dynamic=0";
    } else {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_JavaLangString = ((String)localObject1);
    a();
  }
  
  public static SVParamManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager == null) {
          jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager = new SVParamManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqRichmediaCaptureUtilSVParamManager;
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
    for (;;)
    {
      int k;
      try
      {
        Object localObject1 = this.jdField_a_of_type_JavaLangString.split(",");
        if ((localObject1 != null) && (localObject1.length != 0))
        {
          i = 0;
          String[] arrayOfString = localObject1[0].split("\\|");
          j = arrayOfString.length;
          localObject4 = ";";
          localObject1 = "";
          if (j < 17) {
            break label1146;
          }
          localObject3 = arrayOfString[3].split("\\*");
          boolean bool;
          if ((localObject3 != null) && (localObject3.length == 2))
          {
            j = Integer.valueOf(localObject3[0]).intValue();
            k = Integer.valueOf(localObject3[1]).intValue();
            localObject3 = a(arrayOfString[13], "");
            bool = TextUtils.isEmpty((CharSequence)localObject3);
            localObject7 = null;
            if (bool) {
              break label1093;
            }
            localObject3 = ((String)localObject3).split(";");
            if ((localObject3 == null) || (localObject3.length == 0)) {
              break label1059;
            }
            arrayOfInt = new int[localObject3.length];
            localObject7 = new int[localObject3.length];
            localObject5 = new int[localObject3.length];
            localObject6 = new int[localObject3.length];
            if (i >= localObject3.length) {
              break label1040;
            }
            localObject8 = localObject3[i].split("#");
            if ((localObject8 == null) || (localObject8.length < 3)) {
              break label1033;
            }
            localObject9 = localObject8[0].split("\\*");
            if (localObject9 == null) {
              break label1016;
            }
            if (localObject9.length == 2)
            {
              arrayOfInt[i] = Integer.valueOf(localObject9[0]).intValue();
              localObject7[i] = Integer.valueOf(localObject9[1]).intValue();
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label1019;
              }
              QLog.d("short_video.param_manager", 2, "initConfig(): res is null or length is not 2");
              break label1019;
            }
            if ((localObject8[1] == null) || (localObject8[2] == null)) {
              break label1033;
            }
            localObject5[i] = Integer.valueOf(localObject8[1]).intValue();
            localObject6[i] = Integer.valueOf(localObject8[2]).intValue();
            break label1033;
            i = Integer.valueOf(a(arrayOfString[14], "0")).intValue();
            if ((localObject7 == null) || (i >= localObject7.length)) {
              break label1135;
            }
            if (localObject7 == null) {
              break label1140;
            }
            j = localObject7.length - 1;
            if ((arrayOfInt != null) && (localObject4 != null))
            {
              this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(2), new Size(arrayOfInt[i], localObject4[i]));
              this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(1), new Size(arrayOfInt[i], localObject4[i]));
              this.e.put(Integer.valueOf(2), new Size(arrayOfInt[j], localObject4[j]));
              this.e.put(Integer.valueOf(1), new Size(arrayOfInt[j], localObject4[j]));
            }
            if (localObject6 != null)
            {
              this.c.put(Integer.valueOf(2), Integer.valueOf(localObject6[i]));
              this.c.put(Integer.valueOf(1), Integer.valueOf(localObject6[i]));
            }
            localObject4 = localObject3;
            localObject6 = localObject1;
            if (localObject5 != null)
            {
              this.f.put(Integer.valueOf(2), Integer.valueOf(localObject5[j]));
              this.f.put(Integer.valueOf(1), Integer.valueOf(localObject5[j]));
              localObject4 = localObject3;
              localObject6 = localObject1;
            }
          }
          else
          {
            if (!QLog.isColorLevel()) {
              break label1145;
            }
            QLog.d("short_video.param_manager", 2, "initConfig(): resolution is null or length is not 2");
            return;
          }
          if (arrayOfString.length > 25)
          {
            localObject1 = a(arrayOfString[24], (String)localObject6).split((String)localObject4);
            i = Integer.valueOf(localObject1[0]).intValue();
            j = Integer.valueOf(localObject1[1]).intValue();
            if ((j > 0) && (i > 0))
            {
              float f1 = i / j;
              this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(f1));
              this.jdField_b_of_type_JavaUtilMap.put(Integer.valueOf(2), Float.valueOf(f1));
            }
          }
          if (arrayOfString.length > 27)
          {
            bool = a(arrayOfString[27], "0").equals("1");
            this.d.put(Integer.valueOf(2), Boolean.valueOf(bool));
            this.d.put(Integer.valueOf(1), Boolean.valueOf(bool));
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("cameraResolution : ");
            ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilMap.toString());
            QLog.d("short_video.param_manager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("videoResolutionRatioMap : ");
            ((StringBuilder)localObject1).append(this.jdField_b_of_type_JavaUtilMap.toString());
            QLog.d("short_video.param_manager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("isDynamic : ");
            ((StringBuilder)localObject1).append(this.d);
            QLog.d("short_video.param_manager", 2, ((StringBuilder)localObject1).toString());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("bitRateMap : ");
            ((StringBuilder)localObject1).append(this.c);
            QLog.d("short_video.param_manager", 2, ((StringBuilder)localObject1).toString());
          }
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("short_video.param_manager", 2, "initConfig(): configs is null or its length is 0");
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("parse sv config error, stacktrace :  ");
          ((StringBuilder)localObject3).append(QLog.getStackTraceString(localException));
          QLog.e("short_video.param_manager", 2, ((StringBuilder)localObject3).toString());
        }
      }
      return;
      label1016:
      continue;
      label1019:
      arrayOfInt[i] = j;
      localObject7[i] = k;
      continue;
      label1033:
      i += 1;
      continue;
      label1040:
      Object localObject8 = localObject4;
      Object localObject4 = localObject7;
      Object localObject7 = localObject3;
      Object localObject3 = localObject8;
      break label1090;
      label1059:
      localObject8 = ";";
      Object localObject2 = "";
      localObject7 = localObject3;
      int[] arrayOfInt = null;
      Object localObject6 = arrayOfInt;
      Object localObject5 = localObject6;
      localObject4 = localObject5;
      localObject3 = localObject8;
      label1090:
      continue;
      label1093:
      Object localObject9 = ";";
      localObject8 = "";
      arrayOfInt = null;
      localObject3 = arrayOfInt;
      localObject2 = localObject3;
      localObject4 = localObject2;
      localObject6 = localObject3;
      localObject5 = localObject2;
      localObject3 = localObject9;
      localObject2 = localObject8;
      continue;
      label1135:
      int i = 0;
      continue;
      label1140:
      int j = 0;
      continue;
      label1145:
      return;
      label1146:
      localObject4 = ";";
      localObject6 = "";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.util.SVParamManager
 * JD-Core Version:    0.7.0.1
 */