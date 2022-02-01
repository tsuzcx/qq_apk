package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceGLView
  extends GLSurfaceView
  implements SurfaceHolder.Callback, IMagicFaceView
{
  private GLRender jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender;
  private MagicfaceView.SurfaceCreateListener jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener;
  public volatile boolean a;
  private volatile boolean b = false;
  
  public MagicFaceGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView begins");
    }
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender = new GLRender();
    setRenderer(this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender);
    setRenderMode(0);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView ends");
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("func [gl] frameDataGL begins, srcwidth:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",srcheight:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",degree:");
      localStringBuilder.append(paramFloat);
      QLog.d("MagicFaceGLView", 2, localStringBuilder.toString());
    }
    b(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramFloat);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] frameDataGL ends");
    }
  }
  
  public void a(int[] paramArrayOfInt, int paramInt1, int paramInt2) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    GLRender localGLRender = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewGLRender;
    if (localGLRender == null) {
      return;
    }
    localGLRender.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, getWidth(), getHeight(), paramFloat, this.b);
    requestRender();
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setSurfaceCreatelistener(MagicfaceView.SurfaceCreateListener paramSurfaceCreateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener = paramSurfaceCreateListener;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated begins");
    }
    super.surfaceCreated(paramSurfaceHolder);
    this.jdField_a_of_type_Boolean = true;
    paramSurfaceHolder = this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceView$SurfaceCreateListener;
    if (paramSurfaceHolder != null) {
      paramSurfaceHolder.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicFaceGLView
 * JD-Core Version:    0.7.0.1
 */