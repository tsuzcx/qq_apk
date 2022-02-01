package dov.com.tencent.mobileqq.shortvideo.util;

import android.opengl.EGLContext;

public class OffScreenGLSurface$GLSharedData
{
  private EGLContext jdField_a_of_type_AndroidOpenglEGLContext;
  public TexturePileQueue a;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  
  public void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_AndroidOpenglEGLContext = null;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.util.OffScreenGLSurface.GLSharedData
 * JD-Core Version:    0.7.0.1
 */