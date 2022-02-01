package dov.com.qq.im.ae.gif.preview;

import com.tencent.aekit.openrender.internal.Frame;
import dov.com.qq.im.ae.gif.filter.ComposeFilter;

public class VideoFilterProcess
{
  private int jdField_a_of_type_Int = 0;
  private Frame jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame = new Frame();
  private ComposeFilter jdField_a_of_type_DovComQqImAeGifFilterComposeFilter = new ComposeFilter();
  private VideoFilterProcess.FrameRenderCallback jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback;
  private boolean jdField_a_of_type_Boolean = true;
  private int b = 0;
  
  public Frame a(Frame paramFrame, int paramInt1, int paramInt2)
  {
    Frame localFrame = paramFrame;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_DovComQqImAeGifFilterComposeFilter.a(paramFrame, paramInt1, paramInt2, this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame);
      localFrame = this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame;
    }
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback.a(localFrame);
    }
    return localFrame;
  }
  
  public void a()
  {
    this.jdField_a_of_type_DovComQqImAeGifFilterComposeFilter.apply();
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback.a();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(VideoFilterProcess.FrameRenderCallback paramFrameRenderCallback)
  {
    this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback = paramFrameRenderCallback;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void b()
  {
    this.jdField_a_of_type_DovComQqImAeGifFilterComposeFilter.clearGLSL();
    this.jdField_a_of_type_ComTencentAekitOpenrenderInternalFrame.clear();
    if (this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback != null) {
      this.jdField_a_of_type_DovComQqImAeGifPreviewVideoFilterProcess$FrameRenderCallback.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.preview.VideoFilterProcess
 * JD-Core Version:    0.7.0.1
 */