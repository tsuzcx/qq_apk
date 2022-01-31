package dov.com.tencent.mobileqq.richmedia.capture.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class SVParamManager
{
  private static SVParamManager a;
  public float a;
  public String a;
  public Map a;
  private String jdField_b_of_type_JavaLangString = "";
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private Map c = new HashMap();
  
  private SVParamManager()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Float = 0.5F;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static SVParamManager a()
  {
    if (jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilSVParamManager == null) {}
    try
    {
      if (jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilSVParamManager == null) {
        jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilSVParamManager = new SVParamManager();
      }
      return jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureUtilSVParamManager;
    }
    finally {}
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("short_video_gpu_config", 0).getInt("cfg_version", 0);
  }
  
  public boolean a(String paramString, int paramInt, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SVParamManager", 2, "saveGPUConfig :  " + paramString);
    }
    paramContext = paramContext.getSharedPreferences("short_video_gpu_config", 0).edit();
    paramContext.putString("cfg_content", paramString);
    paramContext.putInt("cfg_version", paramInt);
    return paramContext.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.util.SVParamManager
 * JD-Core Version:    0.7.0.1
 */