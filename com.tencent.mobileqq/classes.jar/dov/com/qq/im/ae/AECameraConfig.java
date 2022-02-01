package dov.com.qq.im.ae;

import com.tencent.mobileqq.activity.richmedia.Size;
import com.tencent.mobileqq.richmedia.capture.util.CameraHelper;
import com.tencent.mobileqq.richmedia.capture.util.SVParamManager;
import dov.com.qq.im.ae.mode.AECaptureMode;
import org.jetbrains.annotations.NotNull;

public class AECameraConfig
{
  private int jdField_a_of_type_Int;
  private Size jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize;
  private AECameraConfig.LogicPartsGenerator jdField_a_of_type_DovComQqImAeAECameraConfig$LogicPartsGenerator;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  private Float jdField_a_of_type_JavaLangFloat;
  private Integer jdField_a_of_type_JavaLangInteger;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  private final int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean;
  private int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int l;
  private int m;
  
  private AECameraConfig(AECameraConfig.Builder paramBuilder)
  {
    this.jdField_g_of_type_Boolean = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_e_of_type_Int = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_h_of_type_Int = AECameraConfig.Builder.b(paramBuilder);
    this.jdField_i_of_type_Int = AECameraConfig.Builder.c(paramBuilder);
    this.jdField_j_of_type_Int = AECameraConfig.Builder.d(paramBuilder);
    this.l = AECameraConfig.Builder.e(paramBuilder);
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = AECameraConfig.Builder.a(paramBuilder);
    this.m = AECameraConfig.Builder.f(paramBuilder);
    this.jdField_k_of_type_Boolean = AECameraConfig.Builder.b(paramBuilder);
    this.jdField_a_of_type_DovComQqImAeSessionWrap = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangString = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_j_of_type_Boolean = AECameraConfig.Builder.c(paramBuilder);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangFloat = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_a_of_type_JavaLangInteger = AECameraConfig.Builder.a(paramBuilder);
    this.jdField_h_of_type_Boolean = AECameraConfig.Builder.d(paramBuilder);
    this.jdField_i_of_type_Boolean = AECameraConfig.Builder.e(paramBuilder);
    this.jdField_g_of_type_Int = AECameraConfig.Builder.g(paramBuilder);
    this.jdField_k_of_type_Int = AECameraConfig.Builder.h(paramBuilder);
    this.jdField_f_of_type_Int = AECameraConfig.Builder.i(paramBuilder);
    this.jdField_d_of_type_Int = AECameraConfig.Builder.j(paramBuilder);
    this.jdField_b_of_type_Boolean = AECameraConfig.Builder.f(paramBuilder);
    this.jdField_d_of_type_Boolean = AECameraConfig.Builder.g(paramBuilder);
    this.jdField_e_of_type_Boolean = AECameraConfig.Builder.h(paramBuilder);
    this.jdField_a_of_type_Boolean = AECameraConfig.Builder.i(paramBuilder);
    this.jdField_f_of_type_Boolean = AECameraConfig.Builder.j(paramBuilder);
    this.jdField_b_of_type_Int = paramBuilder.jdField_b_of_type_Int;
    this.jdField_a_of_type_Int = paramBuilder.jdField_c_of_type_Int;
    this.jdField_c_of_type_Int = paramBuilder.jdField_a_of_type_Int;
    this.jdField_c_of_type_Boolean = paramBuilder.jdField_a_of_type_Boolean;
    if (AECameraConfig.Builder.a(paramBuilder) == null)
    {
      this.jdField_a_of_type_DovComQqImAeAECameraConfig$LogicPartsGenerator = a();
      return;
    }
    this.jdField_a_of_type_DovComQqImAeAECameraConfig$LogicPartsGenerator = AECameraConfig.Builder.a(paramBuilder);
  }
  
  @NotNull
  private AECameraConfig.LogicPartsGenerator a()
  {
    return new AECameraConfig.1(this);
  }
  
  public int a()
  {
    return this.jdField_k_of_type_Int;
  }
  
  public Size a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize == null) {
      if (this.jdField_h_of_type_Int != 0) {
        break label34;
      }
    }
    label34:
    for (int n = CameraHelper.a();; n = this.jdField_h_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize = SVParamManager.a().a(n);
      return this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize;
    }
  }
  
  public SessionWrap a()
  {
    return this.jdField_a_of_type_DovComQqImAeSessionWrap;
  }
  
  public AECaptureMode a()
  {
    return this.jdField_a_of_type_DovComQqImAeModeAECaptureMode;
  }
  
  public Float a()
  {
    if (this.jdField_a_of_type_JavaLangFloat == null) {
      if (this.jdField_h_of_type_Int != 0) {
        break label37;
      }
    }
    label37:
    for (int n = CameraHelper.a();; n = this.jdField_h_of_type_Int)
    {
      this.jdField_a_of_type_JavaLangFloat = Float.valueOf(SVParamManager.a().a(n));
      return this.jdField_a_of_type_JavaLangFloat;
    }
  }
  
  public Integer a()
  {
    int n;
    if (this.jdField_a_of_type_JavaLangInteger == null)
    {
      int i1 = CameraHelper.a();
      n = i1;
      if (this.jdField_h_of_type_Int == 0)
      {
        n = i1;
        if (i1 == 0) {
          n = 1;
        }
      }
      if (this.jdField_h_of_type_Int != 0) {
        break label58;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(SVParamManager.a().a(n) * 1000);
      return this.jdField_a_of_type_JavaLangInteger;
      label58:
      n = this.jdField_h_of_type_Int;
    }
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public AECaptureMode[] a()
  {
    return this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode;
  }
  
  public int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Integer b()
  {
    return Integer.valueOf(this.l);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int d()
  {
    return this.jdField_f_of_type_Int;
  }
  
  public boolean d()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public int e()
  {
    return this.jdField_g_of_type_Int;
  }
  
  public boolean e()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int f()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public boolean f()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int g()
  {
    return this.jdField_h_of_type_Int;
  }
  
  public boolean g()
  {
    return this.jdField_h_of_type_Boolean;
  }
  
  public int h()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public boolean h()
  {
    return this.jdField_i_of_type_Boolean;
  }
  
  public int i()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public boolean i()
  {
    return this.jdField_j_of_type_Boolean;
  }
  
  public int j()
  {
    return this.m;
  }
  
  public boolean j()
  {
    return this.jdField_k_of_type_Boolean;
  }
  
  public int k()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECameraConfig
 * JD-Core Version:    0.7.0.1
 */