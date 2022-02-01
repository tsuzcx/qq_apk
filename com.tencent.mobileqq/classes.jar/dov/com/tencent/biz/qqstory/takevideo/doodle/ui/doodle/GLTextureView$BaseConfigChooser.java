package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

abstract class GLTextureView$BaseConfigChooser
  implements GLTextureView.EGLConfigChooser
{
  protected int[] a;
  
  public GLTextureView$BaseConfigChooser(GLTextureView paramGLTextureView, int[] paramArrayOfInt)
  {
    this.jdField_a_of_type_ArrayOfInt = a(paramArrayOfInt);
  }
  
  private int[] a(int[] paramArrayOfInt)
  {
    if ((GLTextureView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView) != 2) && (GLTextureView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView) != 3)) {
      return paramArrayOfInt;
    }
    int i = paramArrayOfInt.length;
    int[] arrayOfInt = new int[i + 2];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, i - 1);
    arrayOfInt[(i - 1)] = 12352;
    if (GLTextureView.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiDoodleGLTextureView) == 2) {
      arrayOfInt[i] = 4;
    }
    for (;;)
    {
      arrayOfInt[(i + 1)] = 12344;
      return arrayOfInt;
      arrayOfInt[i] = 64;
    }
  }
  
  public EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jdField_a_of_type_ArrayOfInt, null, 0, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig failed");
    }
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    if (!paramEGL10.eglChooseConfig(paramEGLDisplay, this.jdField_a_of_type_ArrayOfInt, arrayOfEGLConfig, i, arrayOfInt)) {
      throw new IllegalArgumentException("eglChooseConfig#2 failed");
    }
    paramEGL10 = a(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
    if (paramEGL10 == null) {
      throw new IllegalArgumentException("No config chosen");
    }
    return paramEGL10;
  }
  
  abstract EGLConfig a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.GLTextureView.BaseConfigChooser
 * JD-Core Version:    0.7.0.1
 */