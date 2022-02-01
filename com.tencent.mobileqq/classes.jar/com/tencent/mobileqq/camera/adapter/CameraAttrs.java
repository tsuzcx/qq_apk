package com.tencent.mobileqq.camera.adapter;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.camera.utils.CameraUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class CameraAttrs
{
  private static CameraAttrs s;
  public final boolean a = false;
  public int b = -1;
  public boolean c = false;
  public String d;
  public String e;
  public boolean f = false;
  public boolean g = false;
  public boolean h = false;
  public boolean i = false;
  public int j = -1;
  public int k = -1;
  public int l = -1;
  public int m = -1;
  public int n = -1;
  public int o = -1;
  public int p = -1;
  public int q = -1;
  public boolean r = false;
  private final ArrayList<String> t = new ArrayList();
  
  public static CameraAttrs a()
  {
    if (s == null) {
      try
      {
        if (s == null) {
          s = new CameraAttrs();
        }
      }
      finally {}
    }
    return s;
  }
  
  private void a(SharedPreferences paramSharedPreferences)
  {
    QLog.i("Q.camera.adapter.CameraAttrs", 1, "[loadValueFromPref] + BEGIN");
    this.c = paramSharedPreferences.getBoolean("sysCameraOn", false);
    this.d = paramSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.e = paramSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.f = paramSharedPreferences.getBoolean("disableCameraSDK", false);
    this.g = paramSharedPreferences.getBoolean("readCamNumException", false);
    this.h = paramSharedPreferences.getBoolean("disableFrontCamera", false);
    this.i = paramSharedPreferences.getBoolean("beBlurredPreviewAfterTakePic", false);
    this.j = paramSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.k = paramSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.l = paramSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.m = paramSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.n = paramSharedPreferences.getInt("int_backCamRotate0", -1);
    this.o = paramSharedPreferences.getInt("int_backCamRotate90", -1);
    this.p = paramSharedPreferences.getInt("int_backCamRotate180", -1);
    this.q = paramSharedPreferences.getInt("int_backCamRotate270", -1);
    this.r = paramSharedPreferences.getBoolean("frontCamFlipH", false);
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 2, "[loadValueFromPref] + END");
    }
  }
  
  public void a(SharedPreferences paramSharedPreferences, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + BEGIN");
    }
    int i1 = paramSharedPreferences.getInt("qcamera_conf_version", 0);
    if ((i1 != this.b) && (paramBoolean))
    {
      this.b = i1;
      a(paramSharedPreferences);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.camera.adapter.CameraAttrs", 4, "[loadConfigAndSave] + END");
    }
  }
  
  public void b()
  {
    if (this.t.contains("sysCameraOn")) {
      return;
    }
    SharedPreferences localSharedPreferences = CameraUtils.b(BaseApplicationImpl.getContext());
    this.c = localSharedPreferences.getBoolean("sysCameraOn", false);
    this.d = localSharedPreferences.getString("str_sysMinVersion", "1.0.0");
    this.e = localSharedPreferences.getString("str_sysMaxVersion", "1000.0.0");
    this.t.add("sysCameraOn");
  }
  
  public void c()
  {
    if (this.t.contains("disableCameraSDK")) {
      return;
    }
    this.f = CameraUtils.b(BaseApplicationImpl.getContext()).getBoolean("disableCameraSDK", false);
    this.t.add("disableCameraSDK");
  }
  
  public void d()
  {
    if (this.t.contains("readCamNumException")) {
      return;
    }
    SharedPreferences localSharedPreferences = CameraUtils.b(BaseApplicationImpl.getContext());
    this.g = localSharedPreferences.getBoolean("readCamNumException", false);
    this.h = localSharedPreferences.getBoolean("disableFrontCamera", false);
    this.t.add("readCamNumException");
  }
  
  public void e()
  {
    if (this.t.contains("int_frontCamRotate0")) {
      return;
    }
    SharedPreferences localSharedPreferences = CameraUtils.b(BaseApplicationImpl.getContext());
    this.j = localSharedPreferences.getInt("int_frontCamRotate0", -1);
    this.k = localSharedPreferences.getInt("int_frontCamRotate90", -1);
    this.l = localSharedPreferences.getInt("int_frontCamRotate180", -1);
    this.m = localSharedPreferences.getInt("int_frontCamRotate270", -1);
    this.n = localSharedPreferences.getInt("int_backCamRotate0", -1);
    this.o = localSharedPreferences.getInt("int_backCamRotate90", -1);
    this.p = localSharedPreferences.getInt("int_backCamRotate180", -1);
    this.q = localSharedPreferences.getInt("int_backCamRotate270", -1);
    this.t.add("int_frontCamRotate0");
  }
  
  public void f()
  {
    if (this.t.contains("frontCamFlipH")) {
      return;
    }
    this.r = CameraUtils.b(BaseApplicationImpl.getContext()).getBoolean("frontCamFlipH", false);
    this.t.add("frontCamFlipH");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.camera.adapter.CameraAttrs
 * JD-Core Version:    0.7.0.1
 */