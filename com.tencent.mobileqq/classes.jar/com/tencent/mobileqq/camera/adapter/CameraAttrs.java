package com.tencent.mobileqq.camera.adapter;

import android.content.SharedPreferences;
import com.tencent.qphone.base.util.QLog;

public class CameraAttrs
{
  private static CameraAttrs a;
  public static boolean s;
  public int a;
  public String a;
  public final boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  public int g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  public boolean k;
  public int l;
  public boolean l;
  public int m;
  public boolean m;
  public int n;
  public boolean n;
  public int o;
  public boolean o;
  public int p;
  public boolean p;
  public int q;
  public boolean q;
  public boolean r;
  
  private CameraAttrs()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = -1;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_i_of_type_Int = -1;
    this.jdField_j_of_type_Int = -1;
    this.jdField_k_of_type_Int = -1;
    this.jdField_l_of_type_Int = -1;
    this.jdField_m_of_type_Int = -1;
    this.jdField_n_of_type_Int = -1;
    this.jdField_o_of_type_Int = -1;
    this.jdField_p_of_type_Int = -1;
    this.jdField_q_of_type_Int = -1;
  }
  
  public static CameraAttrs a()
  {
    if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs == null) {
        jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs = new CameraAttrs();
      }
      return jdField_a_of_type_ComTencentMobileqqCameraAdapterCameraAttrs;
    }
    finally {}
  }
  
  private void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs start-------------------------------------------------------------");
    }
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "CameraAttrs qcameraConfigVersion = " + this.jdField_a_of_type_Int);
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "CameraAttrs disableCameraSDK = " + this.jdField_c_of_type_Boolean);
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "CameraAttrs autoFocusAfterPreview = " + this.r);
    if (QLog.isColorLevel())
    {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs sysCameraOnKey = " + this.jdField_b_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs str_sysMinVersionKey = " + this.jdField_a_of_type_JavaLangString);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs str_sysMaxVersionKey = " + this.jdField_b_of_type_JavaLangString);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs readCamNumException = " + this.jdField_d_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableFrontCamera = " + this.jdField_e_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs beBlurredPreviewAfterTakePic = " + this.jdField_f_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs beBlurredPicAfterTakePic = " + this.jdField_g_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableBackFlashMode = " + this.jdField_h_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs frontFlashModeException = " + this.jdField_i_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs backFlashModeException = " + this.jdField_k_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs backFlashNoOn = " + this.jdField_l_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs backFlashNoAuto = " + this.jdField_m_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs frontFlashNoAuto = " + this.jdField_j_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableFocusMode = " + this.jdField_n_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableFocusModeContinuousPicture = " + this.jdField_p_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs disableAutoFocusDouble = " + this.jdField_o_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate0 = " + this.jdField_b_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate90 = " + this.jdField_c_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate180 = " + this.jdField_d_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontCamRotate270 = " + this.jdField_e_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate0 = " + this.jdField_f_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate90 = " + this.jdField_g_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate180 = " + this.jdField_h_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backCamRotate270 = " + this.jdField_i_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate0 = " + this.jdField_j_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate90 = " + this.jdField_k_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate180 = " + this.jdField_l_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_frontExifRotate270 = " + this.jdField_m_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate0 = " + this.jdField_n_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate90 = " + this.jdField_o_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate180 = " + this.jdField_p_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs int_backExifRotate270 = " + this.jdField_q_of_type_Int);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs frontCamFlipH = " + this.jdField_q_of_type_Boolean);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs autoFocusAfterPreview = " + this.r);
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "CameraAttrs end-------------------------------------------------------------\n");
    }
  }
  
  private void b(SharedPreferences paramSharedPreferences)
  {
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "[loadValueFromPref] + BEGIN");
    this.jdField_a_of_type_Int = paramSharedPreferences.getInt("qcamera_conf_version", 0);
    this.jdField_b_of_type_Boolean = paramSharedPreferences.getBoolean("sysCameraOn", false);
    this.jdField_a_of_type_JavaLangString = paramSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.jdField_b_of_type_JavaLangString = paramSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.jdField_c_of_type_Boolean = paramSharedPreferences.getBoolean("disableCameraSDK", true);
    this.jdField_d_of_type_Boolean = paramSharedPreferences.getBoolean("readCamNumException", false);
    this.jdField_e_of_type_Boolean = paramSharedPreferences.getBoolean("disableFrontCamera", false);
    this.jdField_f_of_type_Boolean = paramSharedPreferences.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.jdField_g_of_type_Boolean = paramSharedPreferences.getBoolean("beBlurredPicAfterTakePic", false);
    this.jdField_h_of_type_Boolean = paramSharedPreferences.getBoolean("disableBackFlashMode", false);
    this.jdField_k_of_type_Boolean = paramSharedPreferences.getBoolean("backFlashModeException", false);
    this.jdField_i_of_type_Boolean = paramSharedPreferences.getBoolean("frontFlashModeException", false);
    this.jdField_l_of_type_Boolean = paramSharedPreferences.getBoolean("backFlashNoOn", false);
    this.jdField_m_of_type_Boolean = paramSharedPreferences.getBoolean("backFlashNoAuto", false);
    this.jdField_j_of_type_Boolean = paramSharedPreferences.getBoolean("frontFlashNoAuto", false);
    this.jdField_n_of_type_Boolean = paramSharedPreferences.getBoolean("disableFocusMode", false);
    this.jdField_p_of_type_Boolean = paramSharedPreferences.getBoolean("disableFocusModeContinuousPicture", false);
    this.jdField_o_of_type_Boolean = paramSharedPreferences.getBoolean("disableAutoFocusDouble", false);
    this.jdField_b_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.jdField_c_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.jdField_d_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.jdField_e_of_type_Int = paramSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.jdField_f_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate0", -1);
    this.jdField_g_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate90", -1);
    this.jdField_h_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate180", -1);
    this.jdField_i_of_type_Int = paramSharedPreferences.getInt("int_backCamRotate270", -1);
    this.jdField_j_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate0", -1);
    this.jdField_k_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate90", -1);
    this.jdField_l_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate180", -1);
    this.jdField_m_of_type_Int = paramSharedPreferences.getInt("int_frontExifRotate270", -1);
    this.jdField_n_of_type_Int = paramSharedPreferences.getInt("int_backExifRotate0", -1);
    this.jdField_o_of_type_Int = paramSharedPreferences.getInt("int_backExifRotate90", -1);
    this.jdField_p_of_type_Int = paramSharedPreferences.getInt("int_backExifRotate180", -1);
    this.jdField_q_of_type_Int = paramSharedPreferences.getInt("int_backExifRotate270", -1);
    this.jdField_q_of_type_Boolean = paramSharedPreferences.getBoolean("frontCamFlipH", false);
    this.r = paramSharedPreferences.getBoolean("autoFocusAfterPreview", false);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "[loadValueFromPref] + END");
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + BEGIN");
    }
    if (paramSharedPreferences.getInt("qcamera_conf_version", 0) != this.jdField_a_of_type_Int) {
      b(paramSharedPreferences);
    }
    a();
    s = true;
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + END");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraAttrs
 * JD-Core Version:    0.7.0.1
 */