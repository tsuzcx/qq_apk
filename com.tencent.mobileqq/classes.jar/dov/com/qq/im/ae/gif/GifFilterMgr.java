package dov.com.qq.im.ae.gif;

import com.tencent.aekit.openrender.internal.Frame;
import dov.com.qq.im.ae.gif.filter.OverlayFilter;

public class GifFilterMgr
{
  public static final Integer a;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private OverlayFilter jdField_a_of_type_DovComQqImAeGifFilterOverlayFilter = new OverlayFilter();
  private boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_JavaLangInteger = Integer.valueOf(480);
  }
  
  public Frame a(Frame paramFrame)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImAeGifFilterOverlayFilter.a(paramFrame, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeGifFilterOverlayFilter.apply();
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeGifFilterOverlayFilter.clearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.GifFilterMgr
 * JD-Core Version:    0.7.0.1
 */