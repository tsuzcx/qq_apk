package dov.com.qq.im.ae;

import com.tencent.mobileqq.activity.richmedia.Size;
import dov.com.qq.im.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel.Ratio;
import dov.com.qq.im.ae.entry.AECameraEntry;
import dov.com.qq.im.ae.mode.AECaptureMode;

public class AECameraConfig$Builder
{
  public int a;
  private Size jdField_a_of_type_ComTencentMobileqqActivityRichmediaSize = null;
  private AECameraConfig.LogicPartsGenerator jdField_a_of_type_DovComQqImAeAECameraConfig$LogicPartsGenerator;
  private SessionWrap jdField_a_of_type_DovComQqImAeSessionWrap = null;
  private AECaptureMode jdField_a_of_type_DovComQqImAeModeAECaptureMode = AECaptureMode.NORMAL;
  private Float jdField_a_of_type_JavaLangFloat = null;
  private Integer jdField_a_of_type_JavaLangInteger = null;
  private String jdField_a_of_type_JavaLangString = null;
  public boolean a;
  private AECaptureMode[] jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = { AECaptureMode.NORMAL, AECaptureMode.PLAY, AECaptureMode.GIF };
  public int b;
  private boolean b;
  public int c;
  private boolean c;
  private int jdField_d_of_type_Int = 14;
  private boolean jdField_d_of_type_Boolean = true;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 2;
  private boolean jdField_g_of_type_Boolean = true;
  private int jdField_h_of_type_Int = AEVideoStoryTopBarViewModel.Ratio.R_1_1.code;
  private boolean jdField_h_of_type_Boolean = true;
  private int jdField_i_of_type_Int = AECameraEntry.a.a();
  private boolean jdField_i_of_type_Boolean = true;
  private int jdField_j_of_type_Int = 0;
  private boolean jdField_j_of_type_Boolean = true;
  private int jdField_k_of_type_Int = 200;
  private boolean jdField_k_of_type_Boolean = true;
  private int l = 120;
  private int m = -1;
  
  public AECameraConfig$Builder()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(SessionWrap paramSessionWrap)
  {
    this.jdField_a_of_type_DovComQqImAeSessionWrap = paramSessionWrap;
    return this;
  }
  
  public Builder a(AECaptureMode paramAECaptureMode)
  {
    this.jdField_a_of_type_DovComQqImAeModeAECaptureMode = paramAECaptureMode;
    return this;
  }
  
  public Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder a(AECaptureMode[] paramArrayOfAECaptureMode)
  {
    this.jdField_a_of_type_ArrayOfDovComQqImAeModeAECaptureMode = paramArrayOfAECaptureMode;
    return this;
  }
  
  public AECameraConfig a()
  {
    return new AECameraConfig(this, null);
  }
  
  public Builder b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder c(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder d(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    return this;
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder e(int paramInt)
  {
    this.jdField_j_of_type_Int = paramInt;
    return this;
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.jdField_h_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder f(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
    return this;
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder g(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    return this;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder h(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
    return this;
  }
  
  public Builder h(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder i(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
    return this;
  }
  
  public Builder i(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public Builder j(int paramInt)
  {
    this.jdField_h_of_type_Int = paramInt;
    return this;
  }
  
  public Builder k(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    return this;
  }
  
  public Builder l(int paramInt)
  {
    this.l = paramInt;
    return this;
  }
  
  public Builder m(int paramInt)
  {
    this.m = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.AECameraConfig.Builder
 * JD-Core Version:    0.7.0.1
 */