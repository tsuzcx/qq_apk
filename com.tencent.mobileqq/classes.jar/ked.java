import com.tencent.av.ui.GLVideoView;
import com.tencent.av.ui.VideoLayerUI;

public class ked
  implements Runnable
{
  long jdField_a_of_type_Long = 0L;
  
  public ked(VideoLayerUI paramVideoLayerUI, long paramLong, GLVideoView paramGLVideoView, float paramFloat) {}
  
  public void run()
  {
    long l = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_Long = (1L + l);
    if (l < this.b)
    {
      this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(this.jdField_a_of_type_Float, VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI), VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI));
      this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(this, 10L);
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiGLVideoView.a(0, 0, true);
    VideoLayerUI.a(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1);
    VideoLayerUI.b(this.jdField_a_of_type_ComTencentAvUiVideoLayerUI, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ked
 * JD-Core Version:    0.7.0.1
 */