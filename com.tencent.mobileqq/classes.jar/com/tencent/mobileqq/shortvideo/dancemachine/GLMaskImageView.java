package com.tencent.mobileqq.shortvideo.dancemachine;

import aian;
import android.graphics.RectF;
import android.opengl.GLES20;
import java.nio.FloatBuffer;
import java.util.HashMap;

public class GLMaskImageView
  extends GLImageView
{
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private String jdField_a_of_type_JavaLangString = "";
  protected GLImage b = new GLImage();
  
  public GLMaskImageView(GLViewContext paramGLViewContext, String paramString)
  {
    super(paramGLViewContext, paramString);
    f(4);
  }
  
  protected void al_()
  {
    super.al_();
    int i = ((Integer)this.jdField_a_of_type_Aian.a.get("a_texCoordMask")).intValue();
    GLES20.glVertexAttribPointer(i, 2, 5126, false, 0, this.jdField_a_of_type_Aian.d() * this.i * 4);
    GLES20.glEnableVertexAttribArray(i);
    i = ((Integer)this.jdField_a_of_type_Aian.b.get("u_texture_mask")).intValue();
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, this.b.a());
    GLES20.glUniform1i(i, 1);
  }
  
  protected void am_()
  {
    super.am_();
    RectF localRectF1 = b();
    RectF localRectF2 = new RectF(this.jdField_a_of_type_ComTencentMobileqqShortvideoDancemachineGLViewContext.a());
    this.jdField_a_of_type_AndroidGraphicsRectF.setIntersect(localRectF1, localRectF2);
    float f1 = (this.jdField_a_of_type_AndroidGraphicsRectF.left - localRectF2.left) / localRectF2.width();
    float f2 = (localRectF2.right - this.jdField_a_of_type_AndroidGraphicsRectF.right) / localRectF2.width();
    float f3 = (this.jdField_a_of_type_AndroidGraphicsRectF.top - localRectF2.top) / localRectF2.height();
    float f4 = (localRectF2.bottom - this.jdField_a_of_type_AndroidGraphicsRectF.bottom) / localRectF2.height();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(f1);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(f3);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(f1);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f4);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f2);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f4);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(1.0F - f2);
    this.jdField_a_of_type_JavaNioFloatBuffer.put(f3);
  }
  
  public void b(String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      this.b.a(paramString);
      this.jdField_a_of_type_JavaLangString = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.dancemachine.GLMaskImageView
 * JD-Core Version:    0.7.0.1
 */