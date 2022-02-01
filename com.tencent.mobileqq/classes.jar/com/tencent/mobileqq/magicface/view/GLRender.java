package com.tencent.mobileqq.magicface.view;

import android.opengl.GLSurfaceView.Renderer;
import com.tencent.mobileqq.magicface.model.MagicFaceGLDisplayer;
import com.tencent.qphone.base.util.QLog;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class GLRender
  implements GLSurfaceView.Renderer
{
  private MagicFaceGLDisplayer jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer;
  private GLRender.VideoData jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData = null;
  private GLRender.VideoData b = null;
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func copyFrame2Render begins, datas:");
      localStringBuilder.append(paramArrayOfByte1);
      QLog.d("GLRender", 2, localStringBuilder.toString());
    }
    if (this.b == null) {
      this.b = new GLRender.VideoData(this);
    }
    if (this.b.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramInt3, paramInt4, paramFloat, paramBoolean)) {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData = null;
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData = this.b;
      }
      finally {}
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append("func copyFrame2Render ends, mCurData:");
      paramArrayOfByte1.append(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData);
      QLog.d("GLRender", 2, paramArrayOfByte1.toString());
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("func onDrawFrame begins, gl:");
        localStringBuilder.append(paramGL10);
        QLog.d("GLRender", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData != null)
      {
        paramGL10 = this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer;
        if (paramGL10 != null)
        {
          try
          {
            this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.c, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.d, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.jdField_a_of_type_Float, this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData.jdField_a_of_type_Boolean);
          }
          catch (Throwable paramGL10)
          {
            paramGL10.printStackTrace();
          }
          if (QLog.isColorLevel()) {
            QLog.d("GLRender", 2, "func onDrawFrame ends. One FRAME is drawn.");
          }
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        paramGL10 = new StringBuilder();
        paramGL10.append("func onDrawFrame ends, NULL data, mCurData:");
        paramGL10.append(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData);
        paramGL10.append(",mBitmapDisplayer:");
        paramGL10.append(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer);
        QLog.d("GLRender", 2, paramGL10.toString());
      }
      return;
    }
    finally {}
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10.glViewport(0, 0, paramInt1, paramInt2);
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GLRender", 2, "func onSurfaceCreated begins");
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicFaceGLDisplayer = new MagicFaceGLDisplayer();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender$VideoData = null;
      paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
      if (QLog.isColorLevel()) {
        QLog.d("GLRender", 2, "func onSurfaceCreated ends");
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.GLRender
 * JD-Core Version:    0.7.0.1
 */