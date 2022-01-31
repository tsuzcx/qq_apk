import com.tencent.av.opengl.effects.FilterProcessRender;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;

public class jjq
  implements Runnable
{
  public jjq(FilterProcessRender paramFilterProcessRender, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    try
    {
      FilterProcessRender.a(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender).doFaceDetect(this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.e, this.jdField_a_of_type_Int / 4, this.b / 4);
      this.jdField_a_of_type_ComTencentAvOpenglEffectsFilterProcessRender.a = System.currentTimeMillis();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("FilterProcessRender", 2, "faceDetect.run e = " + localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jjq
 * JD-Core Version:    0.7.0.1
 */