package com.tencent.mobileqq.shortvideo.util;

import android.content.Context;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class PtvFilterSoLoad$SVFilterSoLoadStatus
{
  public static int a;
  public static final String a;
  public static int[] a;
  public static final String[] a;
  public static final String b;
  public static int[] b;
  public static final String[] b;
  public static final String[] c = { "ccnf_patches_1_my36n.txt", "pdm_82_aligned_my36n.txt", "ufdmtcc.bin", "ufat.bin", "pdm.txt", "pdm_82.txt", "meshBasis.bin", "rotBasis.bin" };
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "pitu_tools", "ParticleSystem", "YTCommon", "image_filter_common", "image_filter_gpu", "algo_rithm_jni", "format_convert", "YTIllumination", "YTFaceTrackPro", "algo_youtu_jni" };
    jdField_a_of_type_JavaLangString = a(jdField_a_of_type_ArrayOfJavaLangString[0]);
    jdField_b_of_type_JavaLangString = a(jdField_a_of_type_ArrayOfJavaLangString[1]);
    jdField_a_of_type_ArrayOfInt = new int[] { -4, -4, -4, -4, -4, -4, -4, -4, -4, -4 };
    jdField_a_of_type_Int = -4;
    jdField_b_of_type_ArrayOfJavaLangString = new String[] { "libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so" };
    jdField_b_of_type_ArrayOfInt = new int[] { -4, -4, -4 };
  }
  
  private static String a(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = PtvFilterSoLoad.b(paramContext);
    if (paramContext == null)
    {
      VideoEnvironment.a("PtvFilterSoLoad", "isFilterSoExist:getSVFilterSoPath soRootPath=null", null);
      return false;
    }
    if (!new File(paramContext).exists())
    {
      VideoEnvironment.a("PtvFilterSoLoad", "isFilterSoExist:getSVFilterSoPath soRootPath=" + paramContext + ",exists=false", null);
      return false;
    }
    return a(paramContext);
  }
  
  public static boolean a(String paramString)
  {
    boolean[] arrayOfBoolean = new boolean[jdField_a_of_type_ArrayOfJavaLangString.length];
    boolean bool1 = true;
    String str1 = "isFilterSoExist:";
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      arrayOfBoolean[i] = FileUtils.a(paramString + a(jdField_a_of_type_ArrayOfJavaLangString[i]));
      str1 = str1 + "SV_SO_pendant[" + jdField_a_of_type_ArrayOfJavaLangString[i] + "]=" + arrayOfBoolean[i];
      if (arrayOfBoolean[i] == 0) {
        bool1 = false;
      }
      i += 1;
    }
    if (bool1)
    {
      i = 0;
      for (;;)
      {
        bool2 = bool1;
        str2 = str1;
        if (i >= c.length) {
          break;
        }
        arrayOfBoolean[i] = FileUtils.a(paramString + c[i]);
        str1 = str1 + "SV_SO_pendant[" + c[i] + "]=" + arrayOfBoolean[i];
        if (arrayOfBoolean[i] == 0) {
          bool1 = false;
        }
        i += 1;
      }
    }
    String str2 = str1;
    boolean bool2 = bool1;
    if (QLog.isColorLevel()) {
      QLog.i("EffectEnable", 2, str2);
    }
    return bool2;
  }
  
  private static boolean b()
  {
    return SoLoader.d();
  }
  
  public static boolean b(Context arg0)
  {
    String str = PtvFilterSoLoad.c(???);
    synchronized (PtvFilterSoLoad.a())
    {
      boolean bool1 = FileUtils.a(str + "libQMCF.so");
      boolean bool2 = FileUtils.a(str + jdField_b_of_type_ArrayOfJavaLangString[2]);
      if (QLog.isColorLevel()) {
        QLog.i("SVAF_SoLoad", 2, String.format("isArtFilterSoExist, qmcfso[%s], snpeso[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad.SVFilterSoLoadStatus
 * JD-Core Version:    0.7.0.1
 */