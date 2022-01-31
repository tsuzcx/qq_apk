package com.tencent.mobileqq.shortvideo.dancemachine;

import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.dancemachine.utils.DanceLog;

public class GLLittleBoy
  extends GLFrameImage
{
  int jdField_a_of_type_Int;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  BoyDataReport.BoyItem jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineBoyDataReport$BoyItem = new BoyDataReport.BoyItem();
  private ResourceManager.DancePosture jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$DancePosture;
  public int b;
  boolean b;
  public int c;
  boolean c;
  int jdField_d_of_type_Int = 0;
  boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = 1;
  boolean jdField_e_of_type_Boolean;
  boolean f;
  public boolean g = false;
  private boolean o = true;
  
  public GLLittleBoy(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    this.jdField_f_of_type_Boolean = true;
    i();
    this.jdField_e_of_type_Boolean = true;
    this.o = true;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public ResourceManager.DancePosture a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$DancePosture;
  }
  
  public void a()
  {
    if ((this.j) && (this.o))
    {
      c();
      c(a());
    }
    super.a();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1) {}
    for (this.jdField_e_of_type_Int = 1;; this.jdField_e_of_type_Int = paramInt)
    {
      this.jdField_f_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void a(ResourceManager.DancePosture paramDancePosture)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineResourceManager$DancePosture = paramDancePosture;
  }
  
  public void a(String paramString)
  {
    a(paramString, false, false);
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramString = GLFrameImage.a(paramString, paramBoolean1, paramBoolean2);
    DanceLog.b("GLFrameImage", "GLLittleBoy:getImageByPath");
    this.jdField_f_of_type_Int = paramString.a();
    this.o = false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      int i = this.jdField_d_of_type_Int + 1;
      this.jdField_d_of_type_Int = i;
      if (i >= this.jdField_e_of_type_Int)
      {
        this.c = paramBoolean;
        this.jdField_d_of_type_Int = 0;
      }
    }
    do
    {
      return;
      this.c = paramBoolean;
    } while (!this.jdField_f_of_type_Boolean);
    this.jdField_d_of_type_Int = 0;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public RectF c()
  {
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public boolean c()
  {
    return this.c;
  }
  
  public void d()
  {
    super.d();
    i();
  }
  
  public void i()
  {
    this.b = true;
    this.jdField_d_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Int = -1;
  }
  
  public void j()
  {
    RectF localRectF = b();
    this.jdField_a_of_type_AndroidGraphicsRectF.set(localRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLLittleBoy
 * JD-Core Version:    0.7.0.1
 */