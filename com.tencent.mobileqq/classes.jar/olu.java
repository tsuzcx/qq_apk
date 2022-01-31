import android.opengl.Matrix;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

public class olu
  implements HWEncodeListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private HWVideoRecorder jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  private float[] jdField_a_of_type_ArrayOfFloat;
  private int b;
  private int c;
  
  public olu(int paramInt, long paramLong, QQFilterRenderManager paramQQFilterRenderManager, HWVideoRecorder paramHWVideoRecorder)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = paramHWVideoRecorder;
    this.jdField_a_of_type_ArrayOfFloat = new float[16];
    Matrix.setIdentityM(this.jdField_a_of_type_ArrayOfFloat, 0);
    Matrix.scaleM(this.jdField_a_of_type_ArrayOfFloat, 0, 1.0F, -1.0F, 1.0F);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "onEncodeStart");
    }
    this.b = 0;
    this.c = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(-1);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.e(this.b);
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, this.c, null, this.jdField_a_of_type_ArrayOfFloat, this.b * this.jdField_a_of_type_Long * 1000000L);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "onEncodeFinish, filePath:" + paramString);
    }
  }
  
  public void a_(int paramInt, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SlideShowPhotoListManager", 2, "onEncodeError");
    }
  }
  
  public void b()
  {
    this.b += 1;
    if (this.b >= this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.e(this.b);
    this.c = this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(-1);
    if (SlideShowPhotoListManager.a)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      return;
    }
    long l1 = this.b;
    long l2 = this.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, this.c, null, this.jdField_a_of_type_ArrayOfFloat, l1 * l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olu
 * JD-Core Version:    0.7.0.1
 */