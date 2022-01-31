package com.tencent.mobileqq.magicface.view;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import asdu;
import asdw;
import asdz;
import com.tencent.qphone.base.util.QLog;

public class MagicFaceGLView
  extends GLSurfaceView
  implements SurfaceHolder.Callback, asdw
{
  private asdu jdField_a_of_type_Asdu;
  private asdz jdField_a_of_type_Asdz;
  public volatile boolean a;
  private volatile boolean b;
  
  public MagicFaceGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView begins");
    }
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    this.jdField_a_of_type_Asdu = new asdu();
    setRenderer(this.jdField_a_of_type_Asdu);
    setRenderMode(0);
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] MagicFaceGLView ends");
    }
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] frameDataGL begins, srcwidth:" + paramInt1 + ",srcheight:" + paramInt2 + ",degree:" + paramFloat);
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
    if (this.jdField_a_of_type_Asdu == null) {
      return;
    }
    this.jdField_a_of_type_Asdu.a(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, getWidth(), getHeight(), paramFloat, this.b);
    requestRender();
  }
  
  public void setIsFullScreen(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setSurfaceCreatelistener(asdz paramasdz)
  {
    this.jdField_a_of_type_Asdz = paramasdz;
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated begins");
    }
    super.surfaceCreated(paramSurfaceHolder);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Asdz != null) {
      this.jdField_a_of_type_Asdz.a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicFaceGLView", 2, "func [gl] surfaceCreated ends");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.view.MagicFaceGLView
 * JD-Core Version:    0.7.0.1
 */